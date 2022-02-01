package com.tencent.mobileqq.activity.widget.qqmusic.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.tencent.common.app.BaseApplicationImpl;
import java.net.InetSocketAddress;

public class ApnManager
{
  public static final int a = 1000;
  private static Context jdField_a_of_type_AndroidContentContext;
  private static final String jdField_a_of_type_JavaLangString = "ApnManager";
  public static final int b = 1010;
  public static final int c = 1020;
  public static final int d = 1021;
  public static final int e = 1022;
  public static final int f = 1023;
  public static final int g = 1030;
  
  public static int a()
  {
    return a(a);
  }
  
  public static int a(Context paramContext)
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo != null)
      {
        boolean bool = localNetworkInfo.isConnected();
        if (bool) {
          try
          {
            int i = localNetworkInfo.getType();
            if (i == 1) {
              return 1030;
            }
            if (i == 0)
            {
              i = b(paramContext);
              return i;
            }
            return 1010;
          }
          catch (Exception paramContext)
          {
            return 1010;
          }
        }
      }
      return 1000;
    }
    catch (Exception paramContext)
    {
      MLog.a("ApnManager", paramContext);
    }
    return 1010;
  }
  
  public static InetSocketAddress a()
  {
    return ApnProxyManager.a(a);
  }
  
  public static void a()
  {
    a = BaseApplicationImpl.getContext();
  }
  
  public static boolean a()
  {
    return a(a) != 1000;
  }
  
  private static int b(Context paramContext)
  {
    try
    {
      int i = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType();
      switch (i)
      {
      default: 
        return 1020;
      case 7: 
        return 1021;
      case 4: 
        return 1021;
      case 2: 
        return 1021;
      case 5: 
        return 1022;
      case 6: 
        return 1022;
      case 1: 
        return 1021;
      case 8: 
        return 1022;
      case 10: 
        return 1022;
      case 9: 
        return 1022;
      case 3: 
        return 1022;
      case 14: 
        return 1022;
      case 12: 
        return 1022;
      case 15: 
        return 1022;
      case 11: 
        return 1021;
      case 13: 
        return 1023;
      }
      return 1020;
    }
    catch (Exception paramContext) {}
    return 1020;
  }
  
  public static boolean b()
  {
    return a(a) == 1030;
  }
  
  public static boolean c()
  {
    int i = a(a);
    return (i == 1021) || (i == 1022) || (i == 1023);
  }
  
  public static boolean d()
  {
    return a(a) == 1021;
  }
  
  public static boolean e()
  {
    return a(a) == 1022;
  }
  
  public static boolean f()
  {
    return a(a) == 1023;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.utils.ApnManager
 * JD-Core Version:    0.7.0.1
 */