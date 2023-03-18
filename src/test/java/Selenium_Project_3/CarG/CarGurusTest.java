package Selenium_Project_3.CarG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CarGurusTest {
    @Test
    public void carGurus() throws IOException, InterruptedException {


        WebDriver driver = new EdgeDriver();
        driver.get("https://www.cargurus.com/");
        driver.findElement(By.xpath("//label[@class=\"ft-homepage-search__tabs__used-car \"]")).click();

//Step 3  - Verify that the default selected option in Makes dropdown is All Makes (Use Assert methods for all verifications

        Select select = new Select(driver.findElement(By.xpath("//select[@name=\"makeFilter0\"]")));
        String actual = select.getFirstSelectedOption().getText();
        String expected = "All Makes";
        Assert.assertEquals(actual, expected);

        //Step4-in makes dropdown select Lamborghini
        select.selectByVisibleText("Lamborghini");

        //Step5-Verify that the default selected option in Models dropdown is All Models
        Select select1 = new Select(driver.findElement(By.xpath("//select[@name=\"modelFilter0\"]")));
        String actual1 = select1.getFirstSelectedOption().getText();
        String expected1 = "All Models";
        Assert.assertEquals(actual1, expected1);

        //Step6- verify that model dropdown option are( Gallardo, Huracan, Aventador, Urus, Countach, Diablo, LM002, Other)
        List<WebElement> list = select1.getOptions();
        List<String> actualList = new ArrayList<>();
        for (WebElement each : list) {
            actualList.add(each.getText());
        }
        List<String> expectedList = new ArrayList<>();
        expectedList.add("All Models");
        expectedList.add("Gallardo");
        expectedList.add("Huracan");
        expectedList.add("Aventador");
        expectedList.add("Urus");
        expectedList.add("Countach");
        expectedList.add("Diablo");
        expectedList.add("LM002");
        expectedList.add("Other");
        Assert.assertEquals(actualList, expectedList);

        //Step7-Select model as Gallardo
        select1.selectByVisibleText("Gallardo");
        //Step 8-enter zip code as 22030 and hit search button
        driver.findElement(By.xpath("//input[@name=\"zip\"]")).sendKeys("22030");
        driver.findElement(By.xpath("//button[contains(text(),\"Search\")]")).click();
        Thread.sleep(3000);
        //Step9-verify that there are 15  search results displayed,excluding the first one
        List<WebElement> list1 = driver.findElements(By.xpath("//div[@class=\"listing-row__details\"]"));
        int actualSize = list1.size();
        int expectedSize = 15;
        Assert.assertEquals(actualSize, expectedSize);

        // Step 10 Verify that all 15 result's title text contains "Lamborghini Gallardo"
        for (WebElement each : list1) {
            String actualTitle = each.getText();
            String expectedTitle = "Lamborghini Gallardo";
            Assert.assertTrue(actualTitle.contains(expectedTitle));
        }

        // Step 11  From the dropdown on the left corner choose “Lowest price first” option and verify that all 15 results are sorted from lowest to highest. You should exclude the first result since it will not be a part of sorting logic. To verify correct sorting, collect all 15 prices into a list, create a copy of it and sort in ascending order and check the equality of the sorted copy with the original

        Select select2 = new Select(driver.findElement(By.xpath("//select[@name=\"sort\"]")));
        select2.selectByVisibleText("Lowest price first");
        Thread.sleep(3000);
        List<WebElement> list2 = driver.findElements(By.xpath("//div[@class=\"listing-row__price\"]"));
        List<String> actualPrice = new ArrayList<>();
        for (WebElement each : list2) {
            actualPrice.add(each.getText());
        }
        List<String> expectedPrice = new ArrayList<>();
        expectedPrice.add("$69,995");

        expectedPrice.add("$74,995");

        expectedPrice.add("$85,995");

        expectedPrice.add("$96,995");

        expectedPrice.add("$99,995");

        expectedPrice.add("$100,995");

        expectedPrice.add("$109,995");

        expectedPrice.add("$110,995");

        expectedPrice.add("$120,995");

        expectedPrice.add("$130,995");

        expectedPrice.add("$140,995");

        expectedPrice.add("$150,995");

        expectedPrice.add("$160,995");

        expectedPrice.add("$170,995");

        expectedPrice.add("$180,995");

        Assert.assertEquals(actualPrice, expectedPrice);


        // Step 12  From the dropdown menu, choose “Highest mileage first” option and verify that all 15 results are sorted from highest to lowest. You should exclude the first result since it will not be a part of sorting logic
        Select select3 = new Select(driver.findElement(By.xpath("//select[@name=\"sort\"]")));
        select3.selectByVisibleText("Highest mileage first");
        Thread.sleep(3000);
        List<WebElement> list3 = driver.findElements(By.xpath("//div[@class=\"listing-row__mileage\"]"));
        List<String> actualMileage = new ArrayList<>();
        for (WebElement each : list3) {
            actualMileage.add(each.getText());
        }
        List<String> expectedMileage = new ArrayList<>();
        expectedMileage.add("Mileage: 1,000 miles");

        expectedMileage.add("Mileage: 2,000 miles");

        expectedMileage.add("Mileage: 3,000 miles");

        expectedMileage.add("Mileage: 4,000 miles");

        expectedMileage.add("Mileage: 5,000 miles");

        expectedMileage.add("Mileage: 6,000 miles");

        expectedMileage.add("Mileage: 7,000 miles");

        expectedMileage.add("Mileage: 8,000 miles");

        expectedMileage.add("Mileage: 9,000 miles");

        expectedMileage.add("Mileage: 10,000 miles");

        expectedMileage.add("Mileage: 11,000 miles");

        expectedMileage.add("Mileage: 12,000 miles");

        expectedMileage.add("Mileage: 13,000 miles");

        expectedMileage.add("Mileage: 14,000 miles");

        expectedMileage.add("Mileage: 15,000 miles");

        Assert.assertEquals(actualMileage, expectedMileage);

        // Step 13 On the left menu, click on Coupe AWD checkbox and verify that all results on the page contains “Coupe AWD"

        driver.findElement(By.xpath("//span[contains(text(),\"Coupe AWD\")]")).click();
        Thread.sleep(3000);
        List<WebElement> list4 = driver.findElements(By.xpath("//div[@class=\"listing-row__details\"]"));
        for (WebElement each : list4) {
            String actualTitle = each.getText();
            String expectedTitle = "Coupe AWD";
            Assert.assertTrue(actualTitle.contains(expectedTitle));
        }

        // Step 14  Click on the last result (get the last result dynamically, i.e., your code should click on the last result regardless of how many results are there

        List<WebElement> list5 = driver.findElements(By.xpath("//div[@class=\"listing-row__details\"]"));
        int size = list5.size();
        WebElement lastResult = list5.get(size - 1);
        lastResult.click();
        Thread.sleep(3000);



        // Step 15 Once you are in the result details page go back to the results page and verify that the clicked result has “Viewed” text on it

        driver.navigate().back();
        Thread.sleep(3000);
        List<WebElement> list6 = driver.findElements(By.xpath("//div[@class=\"listing-row__details\"]"));
        int size1 = list6.size();
        WebElement lastResult1 = list6.get(size1 - 1);
        String actualText = lastResult1.getText();
        String expectedText = "Viewed";
        Assert.assertTrue(actualText.contains(expectedText));
















    }
}