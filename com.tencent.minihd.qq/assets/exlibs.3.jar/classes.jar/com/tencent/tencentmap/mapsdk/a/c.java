package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;

public class c
{
  private static c b;
  private Context a;
  
  public static c a()
  {
    if (b == null) {
      b = new c();
    }
    return b;
  }
  
  public static boolean a(String paramString)
  {
    return (paramString != null) && (paramString.contains("vnd.wap.wml"));
  }
  
  public static boolean a(boolean paramBoolean)
  {
    if (d()) {}
    while (((d.c()) && (!paramBoolean)) || (k.a(Proxy.getDefaultHost()))) {
      return false;
    }
    return true;
  }
  
  public static boolean b()
  {
    return c() != null;
  }
  
  public static Context c()
  {
    return a().a;
  }
  
  public static boolean d()
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)c().getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo != null)
      {
        int i = localNetworkInfo.getType();
        if (i == 1) {
          return true;
        }
      }
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean e()
  {
    try
    {
      Object localObject = (ConnectivityManager)c().getSystemService("connectivity");
      NetworkInfo localNetworkInfo = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localNetworkInfo != null) {
        return localNetworkInfo.isAvailable();
      }
      localObject = ((ConnectivityManager)localObject).getAllNetworkInfo();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        boolean bool = localObject[i].isAvailable();
        if (bool) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception localException) {}
  }
  
  public void a(Context paramContext)
  {
    if (this.a == null) {
      this.a = paramContext.getApplicationContext();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.c
 * JD-Core Version:    0.7.0.1
 */