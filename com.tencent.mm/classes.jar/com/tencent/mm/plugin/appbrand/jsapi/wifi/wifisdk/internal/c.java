package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import java.util.List;

public final class c
{
  public static WifiManager aVR;
  
  public static int addNetwork(WifiConfiguration paramWifiConfiguration)
  {
    try
    {
      int i = aVR.addNetwork(paramWifiConfiguration);
      return i;
    }
    catch (Throwable paramWifiConfiguration)
    {
      paramWifiConfiguration.toString();
    }
    return d.gHp;
  }
  
  public static boolean disableNetwork(int paramInt)
  {
    try
    {
      boolean bool = aVR.disableNetwork(paramInt);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.toString();
    }
    return false;
  }
  
  public static List<WifiConfiguration> getConfiguredNetworks()
  {
    try
    {
      List localList = aVR.getConfiguredNetworks();
      return localList;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.toString();
    }
    return null;
  }
  
  public static WifiInfo getConnectionInfo()
  {
    try
    {
      WifiInfo localWifiInfo = aVR.getConnectionInfo();
      return localWifiInfo;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.toString();
    }
    return null;
  }
  
  public static List<ScanResult> getScanResults()
  {
    try
    {
      List localList = aVR.getScanResults();
      return localList;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.toString();
    }
    return null;
  }
  
  public static boolean isWifiEnabled()
  {
    try
    {
      boolean bool = aVR.isWifiEnabled();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.toString();
    }
    return false;
  }
  
  public static boolean lK(int paramInt)
  {
    try
    {
      boolean bool = aVR.enableNetwork(paramInt, true);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.toString();
    }
    return false;
  }
  
  public static boolean removeNetwork(int paramInt)
  {
    try
    {
      boolean bool = aVR.removeNetwork(paramInt);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.toString();
    }
    return false;
  }
  
  public static boolean saveConfiguration()
  {
    try
    {
      boolean bool = aVR.saveConfiguration();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.toString();
    }
    return false;
  }
  
  public static boolean startScan()
  {
    try
    {
      boolean bool = aVR.startScan();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.toString();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c
 * JD-Core Version:    0.7.0.1
 */