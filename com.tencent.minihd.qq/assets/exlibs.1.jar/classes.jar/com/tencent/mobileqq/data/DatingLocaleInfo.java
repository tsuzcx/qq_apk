package com.tencent.mobileqq.data;

import java.io.Serializable;

public class DatingLocaleInfo
  implements Serializable
{
  public String city;
  public String country;
  public DatingLocaleInfo.DatingGPS gps;
  public String name;
  public String poi;
  public String province;
  public String region;
  
  public DatingLocaleInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, DatingLocaleInfo.DatingGPS paramDatingGPS)
  {
    this.name = paramString1;
    this.country = paramString2;
    this.province = paramString3;
    this.city = paramString4;
    this.region = paramString5;
    this.poi = paramString6;
    this.gps = paramDatingGPS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.DatingLocaleInfo
 * JD-Core Version:    0.7.0.1
 */