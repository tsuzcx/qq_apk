package com.tencent.tencentmap.mapsdk.map;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

public class s
{
  public static Uri a = Uri.parse("content://telephony/carriers/preferapn");
  
  public static String a(Context paramContext)
  {
    switch (b(paramContext))
    {
    default: 
      return "";
    case 5: 
      return "wifi";
    case 3: 
      return "3gwap";
    case 2: 
      return "uniwap";
    case 1: 
      return "cmwap";
    }
    return "ctwap";
  }
  
  private static int b(Context paramContext)
  {
    int j = 6;
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    int i;
    if ((paramContext == null) || (!paramContext.isAvailable())) {
      i = 0;
    }
    do
    {
      do
      {
        do
        {
          int k;
          do
          {
            return i;
            k = paramContext.getType();
            if (k == 1) {
              return 5;
            }
            i = j;
          } while (k != 0);
          paramContext = paramContext.getExtraInfo();
          i = j;
        } while (paramContext == null);
        i = j;
      } while (paramContext.equals(""));
      if (paramContext.equalsIgnoreCase("cmwap")) {
        return 1;
      }
      if (paramContext.equalsIgnoreCase("3gwap")) {
        return 3;
      }
      if (paramContext.equalsIgnoreCase("uniwap")) {
        return 2;
      }
      i = j;
    } while (!paramContext.equalsIgnoreCase("ctwap"));
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.s
 * JD-Core Version:    0.7.0.1
 */