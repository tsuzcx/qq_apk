package com.tencent.mobileqq.earlydownload.xmldata;

public class JpegSoData
  extends XmlData
{
  @saveInSP(a=true, b=false)
  public String v7a_MD5;
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.pic.jpeg.so";
  }
  
  public String getStrResName()
  {
    return "qq.android.pic.jpeg.so";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.JpegSoData
 * JD-Core Version:    0.7.0.1
 */