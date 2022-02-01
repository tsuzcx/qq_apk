package com.tencent.mobileqq.data;

import appoint.define.appoint_define.LocaleInfo;

public class PublishDatingOption
{
  public appoint_define.LocaleInfo depLocal = null;
  public int depLocalState = -1;
  public appoint_define.LocaleInfo desLocal = null;
  public int destType = -1;
  public int genderId = -1;
  public boolean hasIntro = false;
  public int introId = -1001;
  public String introKey = "";
  public String introduce = "";
  public String maxTimeReqErr = "";
  public int maxTimeRequest = -1;
  public int partCountId = -1;
  public int payTypeId = -1;
  public PublishDatingOption.ShopInfo shopInfo = new PublishDatingOption.ShopInfo(this);
  public int themeId = -1;
  public String themeName = "";
  public long time = -1L;
  public int vehicleId = -1;
  
  public String getPartCountKey()
  {
    switch (this.partCountId)
    {
    default: 
      return "";
    case 0: 
      return "1412150901";
    case 1: 
      return "1412150902";
    case 2: 
      return "1412150903";
    case 3: 
      return "1412150904";
    }
    return "1412150905";
  }
  
  public String getVehicleKey()
  {
    switch (this.vehicleId)
    {
    default: 
      return "";
    case 0: 
      return "1412150802";
    case 1: 
      return "1412150803";
    case 2: 
      return "1412150804";
    case 3: 
      return "1412150807";
    case 4: 
    case 5: 
      return "1412150806";
    case 6: 
      return "1412150800";
    }
    return "1412150801";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("themeId:" + this.themeId);
    localStringBuilder.append(",time:" + this.time);
    localStringBuilder.append(",genderId:" + this.genderId);
    localStringBuilder.append(",introduce:" + this.introduce);
    localStringBuilder.append(",introId:" + this.introId);
    localStringBuilder.append(",introKey:" + this.introKey);
    localStringBuilder.append(",payTypeId:" + this.payTypeId);
    localStringBuilder.append(",vehicleId:" + this.vehicleId);
    localStringBuilder.append(",partCountId:" + this.partCountId);
    if (this.shopInfo != null) {
      localStringBuilder.append(",shopInfo:" + this.shopInfo.toString());
    }
    if (this.depLocal != null) {
      localStringBuilder.append(",depLocal:" + this.depLocal.str_name);
    }
    if (this.desLocal != null) {
      localStringBuilder.append(",desLocal:" + this.desLocal.str_name);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.PublishDatingOption
 * JD-Core Version:    0.7.0.1
 */