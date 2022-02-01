package com.tencent.map.geolocation;

import android.os.Parcelable;

public abstract interface TencentAddress
  extends Parcelable
{
  public abstract String getDirection();
  
  public abstract double getDistance();
  
  public abstract String getDtype();
  
  public abstract double getLatitude();
  
  public abstract double getLongitude();
  
  public abstract String getName();
  
  public abstract String getTag();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.map.geolocation.TencentAddress
 * JD-Core Version:    0.7.0.1
 */