package com.tencent.mobileqq.troop.data;

public class TroopCreateUtils
{
  public static final String a = "troopUin";
  public static final String b = "troopLocation";
  
  public static String a(int paramInt)
  {
    long l1 = 0x7FFFFFFF & paramInt;
    long l2 = paramInt >> 31 & 0x1;
    return (l1 | l2 << 31) + "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopCreateUtils
 * JD-Core Version:    0.7.0.1
 */