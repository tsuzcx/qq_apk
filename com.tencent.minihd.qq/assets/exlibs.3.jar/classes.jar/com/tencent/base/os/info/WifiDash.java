package com.tencent.base.os.info;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.base.Global;

public class WifiDash
{
  static volatile String currBSSID = null;
  
  public static String getBSSID()
  {
    if (currBSSID == null) {}
    try
    {
      if (currBSSID == null) {
        updateBSSID();
      }
      if (("N/A".equals(currBSSID)) || ("00:00:00:00:00:00".equals(currBSSID)) || ("FF:FF:FF:FF:FF:FF".equalsIgnoreCase(currBSSID))) {
        return null;
      }
    }
    finally {}
    return currBSSID;
  }
  
  public static String getWifiInfo()
  {
    Object localObject = (WifiManager)Global.getSystemService("wifi");
    if (localObject == null) {
      return "[-]";
    }
    try
    {
      localObject = ((WifiManager)localObject).getConnectionInfo();
      if (localObject == null) {
        return "[-]";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        str1 = null;
      }
      String str2 = str1.getSSID();
      int i = WifiManager.calculateSignalLevel(str1.getRssi(), 5);
      String str1 = String.valueOf(str1.getLinkSpeed()) + " " + "Mbps";
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append('[').append(String.valueOf(i)).append(", ").append(str2).append(", ").append(str1).append(']');
      return localStringBuffer.toString();
    }
  }
  
  private static Object queryWifiInfo(Object paramObject)
  {
    Object localObject1 = (WifiManager)Global.getSystemService("wifi");
    if (localObject1 == null) {}
    for (;;)
    {
      return paramObject;
      try
      {
        localObject1 = ((WifiManager)localObject1).getConnectionInfo();
        if (localObject1 == null) {
          continue;
        }
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2 = null;
        }
      }
    }
  }
  
  public static String updateBSSID()
  {
    try
    {
      Object localObject3 = queryWifiInfo("N/A");
      Object localObject1 = null;
      if (localObject3 != "N/A")
      {
        localObject3 = ((WifiInfo)localObject3).getBSSID();
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "N/A";
        }
      }
      currBSSID = (String)localObject1;
      return localObject1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.base.os.info.WifiDash
 * JD-Core Version:    0.7.0.1
 */