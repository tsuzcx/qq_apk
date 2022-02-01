package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;

public class CouponH5Data
  extends Entity
{
  public String mData;
  public String mHost;
  public String mKey;
  public String mPath;
  
  public CouponH5Data() {}
  
  public CouponH5Data(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mHost = paramString1;
    this.mPath = paramString2;
    this.mKey = paramString3;
    this.mData = paramString4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.CouponH5Data
 * JD-Core Version:    0.7.0.1
 */