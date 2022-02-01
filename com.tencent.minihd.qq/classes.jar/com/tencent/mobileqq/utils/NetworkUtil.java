package com.tencent.mobileqq.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;

public class NetworkUtil
{
  public static int a(Context paramContext)
  {
    int j = HttpUtil.a();
    int i = j;
    if (j == -1) {
      i = 2;
    }
    return i;
  }
  
  public static NetworkInfo a(Context paramContext)
  {
    return ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
  }
  
  public static String a(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramInt & 0xFF).append(".").append(paramInt >> 8 & 0xFF).append(".").append(paramInt >> 16 & 0xFF).append(".").append(paramInt >> 24 & 0xFF);
    return localStringBuffer.toString();
  }
  
  public static String a(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.getType() == 0)) {
        return paramContext.getExtraInfo();
      }
      return null;
    }
    return null;
  }
  
  public static boolean a(Context paramContext)
  {
    return HwNetworkUtil.isAirplaneModeOn(paramContext);
  }
  
  public static boolean a(NetworkInfo paramNetworkInfo)
  {
    return HwNetworkUtil.isMobileNetworkInfo(paramNetworkInfo);
  }
  
  public static int b(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext != null) {
        return paramContext.getType();
      }
    }
    return -1;
  }
  
  public static boolean b(Context paramContext)
  {
    return HwNetworkUtil.isWifiEnabled(paramContext);
  }
  
  public static boolean c(Context paramContext)
  {
    return HwNetworkUtil.isMobileNetWork(paramContext);
  }
  
  public static boolean d(Context paramContext)
  {
    return HwNetworkUtil.is3Gor4G(paramContext);
  }
  
  public static boolean e(Context paramContext)
  {
    return HwNetworkUtil.isNetSupport(paramContext);
  }
  
  public static boolean f(Context paramContext)
  {
    return HwNetworkUtil.isNetworkAvailable(paramContext);
  }
  
  public static boolean g(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext != null)
      {
        int i = paramContext.getType();
        if (i != 1) {}
      }
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      return false;
    }
    catch (Exception paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.NetworkUtil
 * JD-Core Version:    0.7.0.1
 */