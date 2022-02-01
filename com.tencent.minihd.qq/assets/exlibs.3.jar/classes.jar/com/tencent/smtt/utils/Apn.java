package com.tencent.smtt.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

public class Apn
{
  public static final int APN_2G = 1;
  public static final int APN_3G = 2;
  public static final int APN_4G = 4;
  public static final int APN_UNKNOWN = 0;
  public static final int APN_WIFI = 3;
  
  public static String getApnInfo(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnectedOrConnecting())) {
        switch (paramContext.getType())
        {
        case 0: 
          paramContext = paramContext.getExtraInfo();
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
      return "unknown";
    }
    return "unknown";
    return "wifi";
  }
  
  public static int getApnType(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.isConnectedOrConnecting()))
    {
      switch (paramContext.getType())
      {
      default: 
        return 0;
      case 1: 
        return 3;
      }
      switch (paramContext.getSubtype())
      {
      default: 
        return 0;
      case 1: 
      case 2: 
      case 4: 
      case 7: 
      case 11: 
        return 1;
      case 3: 
      case 5: 
      case 6: 
      case 8: 
      case 9: 
      case 10: 
      case 12: 
      case 14: 
      case 15: 
        return 2;
      }
      return 4;
    }
    return 0;
  }
  
  public static String getWifiSSID(Context paramContext)
  {
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (paramContext != null)
      {
        paramContext = paramContext.getBSSID();
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      return "";
    }
    return null;
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (paramContext == null) {
      return false;
    }
    return (paramContext.isConnected()) || (paramContext.isAvailable());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.utils.Apn
 * JD-Core Version:    0.7.0.1
 */