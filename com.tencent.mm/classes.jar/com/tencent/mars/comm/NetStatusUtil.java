package com.tencent.mars.comm;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.mm.hellhoundlib.b.c;
import java.lang.reflect.Method;

public class NetStatusUtil
{
  public static final int CMNET = 6;
  public static final int CMWAP = 5;
  public static final int CTNET = 8;
  public static final int CTWAP = 7;
  public static final int LTE = 10;
  public static final int MOBILE = 9;
  public static final int NETTYPE_NOT_WIFI = 0;
  public static final int NETTYPE_WIFI = 1;
  public static final int NET_3G = 4;
  public static final int NON_NETWORK = -1;
  public static final int NO_SIM_OPERATOR = 0;
  public static final int NR_5G = 11;
  public static final int POLICY_NONE = 0;
  public static final int POLICY_REJECT_METERED_BACKGROUND = 1;
  private static final String TAG = "MicroMsg.NetStatusUtil";
  public static final int TBACKGROUND_DATA_LIMITED = 2;
  public static final int TBACKGROUND_NOT_LIMITED = 0;
  public static final int TBACKGROUND_PROCESS_LIMITED = 1;
  public static final int TBACKGROUND_WIFI_LIMITED = 3;
  public static final int UNINET = 1;
  public static final int UNIWAP = 2;
  public static final int UNKNOW_TYPE = 999;
  public static final int WAP_3G = 3;
  public static final int WIFI = 0;
  private static int nowStrength = 0;
  private byte _hellAccFlag_;
  
  public static void dumpNetStatus(Context paramContext)
  {
    try
    {
      ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static int getBackgroundLimitType(Context paramContext)
  {
    int i;
    if (Build.VERSION.SDK_INT >= 14) {
      try
      {
        Object localObject = Class.forName("android.app.ActivityManagerNative");
        localObject = ((Class)localObject).getMethod("getDefault", new Class[0]).invoke(localObject, new Object[0]);
        i = ((Integer)localObject.getClass().getMethod("getProcessLimit", new Class[0]).invoke(localObject, new Object[0])).intValue();
        if (i == 0) {
          return 1;
        }
      }
      catch (Exception localException) {}
    }
    try
    {
      i = getWifiSleeepPolicy(paramContext);
      if (i != 2)
      {
        int j = getNetType(paramContext);
        if (j == 0) {}
      }
      else
      {
        return 0;
      }
      if ((i == 1) || (i == 0)) {
        return 3;
      }
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static int getISPCode(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null) {
      return 0;
    }
    paramContext = paramContext.getSimOperator();
    if ((paramContext == null) || (paramContext.length() < 5)) {
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      int j = paramContext.length();
      int i = j;
      if (j > 6) {
        i = 6;
      }
      for (;;)
      {
        if (j < i) {
          if (!Character.isDigit(paramContext.charAt(j)))
          {
            if (localStringBuilder.length() <= 0) {
              break label119;
            }
          }
          else
          {
            localStringBuilder.append(paramContext.charAt(j));
            break label119;
          }
        }
        i = Integer.valueOf(localStringBuilder.toString()).intValue();
        return i;
        j = 0;
        continue;
        label119:
        j += 1;
      }
      return 0;
    }
    catch (Exception paramContext) {}
  }
  
  public static String getISPName(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null) {
      return "";
    }
    if (paramContext.getSimOperatorName().length() <= 100) {
      return paramContext.getSimOperatorName();
    }
    return paramContext.getSimOperatorName().substring(0, 100);
  }
  
  public static int getNetType(Context paramContext)
  {
    if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
      return -1;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return -1;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null) {
      return -1;
    }
    if (paramContext.getType() == 1) {
      return 0;
    }
    if (paramContext.getExtraInfo() != null)
    {
      if (paramContext.getExtraInfo().equalsIgnoreCase("uninet")) {
        return 1;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("uniwap")) {
        return 2;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("3gwap")) {
        return 3;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("3gnet")) {
        return 4;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("cmwap")) {
        return 5;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("cmnet")) {
        return 6;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("ctwap")) {
        return 7;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("ctnet")) {
        return 8;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("LTE")) {
        return 10;
      }
    }
    return 9;
  }
  
  public static int getNetTypeForStat(Context paramContext)
  {
    if (paramContext == null) {
      return 999;
    }
    try
    {
      if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
        return 999;
      }
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return 999;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext == null) {
        return 999;
      }
      if (paramContext.getType() == 1) {
        return 1;
      }
      int i = paramContext.getSubtype();
      if (i == 0) {
        return 999;
      }
      return i * 1000;
    }
    catch (Exception paramContext) {}
    return 999;
  }
  
  public static String getNetTypeString(Context paramContext)
  {
    if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
      return "NON_NETWORK";
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return "NON_NETWORK";
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null) {
      return "NON_NETWORK";
    }
    if (paramContext.getType() == 1) {
      return "WIFI";
    }
    if (paramContext.getExtraInfo() != null) {
      return paramContext.getExtraInfo();
    }
    return "MOBILE";
  }
  
  public static int getNetWorkType(Context paramContext)
  {
    try
    {
      if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
        return -1;
      }
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext != null)
      {
        int i = paramContext.getType();
        return i;
      }
    }
    catch (Exception paramContext) {}
    return -1;
  }
  
  public static int getProxyInfo(Context paramContext, StringBuffer paramStringBuffer)
  {
    try
    {
      paramContext = Proxy.getDefaultHost();
      int i = Proxy.getDefaultPort();
      if ((paramContext != null) && (paramContext.length() > 0) && (i > 0))
      {
        paramStringBuffer.append(paramContext);
        return i;
      }
      paramContext = System.getProperty("http.proxyHost");
      String str = System.getProperty("http.proxyPort");
      int j = 80;
      i = j;
      if (str != null)
      {
        i = j;
        if (str.length() > 0) {
          i = Integer.parseInt(str);
        }
      }
      if ((paramContext != null) && (paramContext.length() > 0))
      {
        paramStringBuffer.append(paramContext);
        return i;
      }
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static int getStrength(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    try
    {
      if (getNetTypeForStat(paramContext) == 1) {
        return Math.abs(((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getRssi());
      }
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      Object localObject = new StrengthListener();
      localObject = c.a(256, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mars/comm/NetStatusUtil", "getStrength", "(Landroid/content/Context;)I", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      paramContext.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mars/comm/NetStatusUtil", "getStrength", "(Landroid/content/Context;)I", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      int i = Math.abs(nowStrength);
      return i;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static WifiInfo getWifiInfo(Context paramContext)
  {
    try
    {
      if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
        return null;
      }
      Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localObject == null) {
        return null;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if ((localObject != null) && (1 == ((NetworkInfo)localObject).getType()))
      {
        paramContext = (WifiManager)paramContext.getSystemService("wifi");
        if (paramContext == null) {
          return null;
        }
        paramContext = paramContext.getConnectionInfo();
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      return null;
    }
    return null;
  }
  
  public static int getWifiSleeepPolicy(Context paramContext)
  {
    return Settings.System.getInt(paramContext.getContentResolver(), "wifi_sleep_policy", 2);
  }
  
  public static int guessNetSpeed(Context paramContext)
  {
    try
    {
      if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
        return 102400;
      }
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext.getType() == 1) {
        return 102400;
      }
      int i = paramContext.getSubtype();
      switch (i)
      {
      }
    }
    catch (Exception paramContext)
    {
      label120:
      break label120;
    }
    return 102400;
    return 4096;
    return 8192;
    return 102400;
  }
  
  public static boolean is2G(Context paramContext)
  {
    try
    {
      if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
        return false;
      }
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext.getType() == 1) {
        return false;
      }
      if ((paramContext.getSubtype() != 2) && (paramContext.getSubtype() != 1) && (paramContext.getSubtype() != 4) && (paramContext.getSubtype() != 16) && (paramContext.getSubtype() != 7))
      {
        int i = paramContext.getSubtype();
        if (i != 11) {}
      }
      else
      {
        return true;
      }
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean is3G(Context paramContext)
  {
    try
    {
      if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
        return false;
      }
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext.getType() == 1) {
        return false;
      }
      if (paramContext.getSubtype() >= 3)
      {
        int i = paramContext.getSubtype();
        if (i < 13) {
          return true;
        }
      }
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean is4G(Context paramContext)
  {
    try
    {
      if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
        return false;
      }
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext.getType() == 1) {
        return false;
      }
      if (paramContext.getSubtype() != 13)
      {
        int i = paramContext.getSubtype();
        if (i != 18) {}
      }
      else
      {
        return true;
      }
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean is5G(Context paramContext)
  {
    try
    {
      if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
        return false;
      }
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext.getType() == 1) {
        return false;
      }
      int i = paramContext.getSubtype();
      if (i >= 20) {
        return true;
      }
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean isConnected(Context paramContext)
  {
    if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
      return false;
    }
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    try
    {
      bool = paramContext.isConnected();
      return bool;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
  }
  
  public static boolean isImmediatelyDestroyActivities(Context paramContext)
  {
    boolean bool = false;
    if (Settings.System.getInt(paramContext.getContentResolver(), "always_finish_activities", 0) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isKnownDirectNet(Context paramContext)
  {
    int i = getNetType(paramContext);
    return (6 == i) || (1 == i) || (4 == i) || (8 == i) || (10 == i) || (i == 0);
  }
  
  public static boolean isLimited(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 1) || (paramInt == 3);
  }
  
  public static boolean isMobile(Context paramContext)
  {
    try
    {
      if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
        return false;
      }
      int i = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo().getType();
      return i != 1;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean isNetworkConnected(Context paramContext)
  {
    if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
      return false;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null) {
      return false;
    }
    return paramContext.getState() == NetworkInfo.State.CONNECTED;
  }
  
  public static boolean isWap(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 5) || (paramInt == 7) || (paramInt == 3);
  }
  
  public static boolean isWap(Context paramContext)
  {
    return isWap(getNetType(paramContext));
  }
  
  public static boolean isWifi(int paramInt)
  {
    return paramInt == 0;
  }
  
  public static boolean isWifi(Context paramContext)
  {
    return isWifi(getNetType(paramContext));
  }
  
  public static class StrengthListener
    extends PhoneStateListener
  {
    public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
    {
      super.onSignalStrengthsChanged(paramSignalStrength);
      if (!paramSignalStrength.isGsm())
      {
        NetStatusUtil.access$002(paramSignalStrength.getCdmaDbm());
        return;
      }
      NetStatusUtil.access$002(paramSignalStrength.getGsmSignalStrength());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mars.comm.NetStatusUtil
 * JD-Core Version:    0.7.0.1
 */