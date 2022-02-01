package com.tencent.map.tools.net;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SuppressLint({"MissingPermission"})
public class NetUtil
{
  private static final String CMWAP = "cmwap";
  private static final String CTWAP = "ctwap";
  public static final int DEFAULT_TIME_OUT = 10000;
  public static final String MAP_USER_AGENT = "QQ Map Mobile";
  private static final String NET_3G = "3gnet";
  public static final String STR_UserAgent = "androidsdk";
  public static final int TYPE_3GWAP = 3;
  public static final int TYPE_CMWAP = 1;
  public static final int TYPE_CTWAP = 4;
  public static final int TYPE_NET_WORK_DISABLED = 0;
  public static final int TYPE_OTHER_NET = 6;
  public static final int TYPE_UNIWAP = 2;
  public static final int TYPE_WIFI = 5;
  private static final String UNIWAP = "uniwap";
  private static final String WAP_3G = "3gwap";
  private static final String WIFI = "wifi";
  
  public static int getNetType(Context paramContext)
  {
    AppMethodBeat.i(172931);
    int i = getNetType(getNetworkInfo(paramContext));
    AppMethodBeat.o(172931);
    return i;
  }
  
  private static int getNetType(NetworkInfo paramNetworkInfo)
  {
    AppMethodBeat.i(180923);
    if ((paramNetworkInfo == null) || (!paramNetworkInfo.isAvailable()))
    {
      AppMethodBeat.o(180923);
      return 0;
    }
    int i = paramNetworkInfo.getType();
    if (i == 1)
    {
      AppMethodBeat.o(180923);
      return 5;
    }
    if (i != 0)
    {
      AppMethodBeat.o(180923);
      return 6;
    }
    paramNetworkInfo = paramNetworkInfo.getExtraInfo();
    if (TextUtils.isEmpty(paramNetworkInfo))
    {
      AppMethodBeat.o(180923);
      return 6;
    }
    if (paramNetworkInfo.equalsIgnoreCase("cmwap"))
    {
      AppMethodBeat.o(180923);
      return 1;
    }
    if (paramNetworkInfo.equalsIgnoreCase("3gwap"))
    {
      AppMethodBeat.o(180923);
      return 3;
    }
    if (paramNetworkInfo.equalsIgnoreCase("uniwap"))
    {
      AppMethodBeat.o(180923);
      return 2;
    }
    if (paramNetworkInfo.equalsIgnoreCase("ctwap"))
    {
      AppMethodBeat.o(180923);
      return 4;
    }
    AppMethodBeat.o(180923);
    return 3;
  }
  
  public static String getNetTypeStr(Context paramContext)
  {
    AppMethodBeat.i(172932);
    int i = getNetType(paramContext);
    paramContext = "";
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(172932);
      return paramContext;
      paramContext = "wifi";
      continue;
      paramContext = "3gwap";
      continue;
      paramContext = "uniwap";
      continue;
      paramContext = "cmwap";
      continue;
      paramContext = "ctwap";
    }
  }
  
  public static NetworkInfo getNetworkInfo(Context paramContext)
  {
    AppMethodBeat.i(172930);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      AppMethodBeat.o(172930);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(172930);
    }
    return null;
  }
  
  public static String getNetworkType(Context paramContext)
  {
    AppMethodBeat.i(172933);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext != null)
      {
        int i = paramContext.getType();
        if (i == 1)
        {
          AppMethodBeat.o(172933);
          return "wifi";
        }
        if (i == 0)
        {
          i = paramContext.getSubtype();
          switch (i)
          {
          case 7: 
          default: 
            AppMethodBeat.o(172933);
            return "other";
          case 4: 
            AppMethodBeat.o(172933);
            return "2g";
          case 2: 
            AppMethodBeat.o(172933);
            return "2g";
          case 5: 
            AppMethodBeat.o(172933);
            return "3g";
          case 6: 
            AppMethodBeat.o(172933);
            return "3g";
          case 1: 
            AppMethodBeat.o(172933);
            return "2g";
          case 8: 
            AppMethodBeat.o(172933);
            return "3g";
          }
          AppMethodBeat.o(172933);
          return "3g";
        }
        AppMethodBeat.o(172933);
        return "other";
      }
      AppMethodBeat.o(172933);
      return "unknown";
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(172933);
    }
    return "unknown";
  }
  
  public static boolean isMobile(Context paramContext)
  {
    AppMethodBeat.i(172936);
    int i = getNetType(paramContext);
    if ((i != 0) && (i != 5))
    {
      AppMethodBeat.o(172936);
      return true;
    }
    AppMethodBeat.o(172936);
    return false;
  }
  
  public static boolean isNetAvailable(Context paramContext)
  {
    AppMethodBeat.i(172934);
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      paramContext = getNetworkInfo(paramContext);
      boolean bool;
      if (paramContext != null)
      {
        bool = paramContext.isAvailable();
        AppMethodBeat.o(172934);
        return bool;
      }
      paramContext = localConnectivityManager.getAllNetworkInfo();
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        localConnectivityManager = paramContext[i];
        if (localConnectivityManager.isAvailable())
        {
          bool = localConnectivityManager.isConnectedOrConnecting();
          if (bool)
          {
            AppMethodBeat.o(172934);
            return true;
          }
        }
        i += 1;
      }
      return false;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(172934);
    }
  }
  
  public static boolean isWifi(Context paramContext)
  {
    AppMethodBeat.i(172935);
    if (getNetType(paramContext) == 5)
    {
      AppMethodBeat.o(172935);
      return true;
    }
    AppMethodBeat.o(172935);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.map.tools.net.NetUtil
 * JD-Core Version:    0.7.0.1
 */