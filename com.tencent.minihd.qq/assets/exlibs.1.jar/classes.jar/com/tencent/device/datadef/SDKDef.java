package com.tencent.device.datadef;

public class SDKDef
{
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    case 1000000008: 
    case 1000000009: 
    default: 
      return "智能设备";
    case 1000000004: 
    case 1000000011: 
    case 1000000012: 
    case 1000000013: 
      return "vstar摄像头";
    case 1000000005: 
      return "全志摄像头";
    case 1000000006: 
      return "大华摄像头";
    case 1000000007: 
      return "康佳电视";
    }
    return "NXP摄像头";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.device.datadef.SDKDef
 * JD-Core Version:    0.7.0.1
 */