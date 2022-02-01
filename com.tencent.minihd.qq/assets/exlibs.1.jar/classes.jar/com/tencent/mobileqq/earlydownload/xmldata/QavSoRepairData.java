package com.tencent.mobileqq.earlydownload.xmldata;

public class QavSoRepairData
  extends XmlData
{
  @saveInSP(a=false, b=true)
  public boolean autoDownload = false;
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.qav.sorepair";
  }
  
  public String getStrResName()
  {
    return "qq.android.qav.sorepair";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.QavSoRepairData
 * JD-Core Version:    0.7.0.1
 */