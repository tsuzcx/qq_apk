package com.tencent.mars.ilink.comm;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.telephony.TelephonyManager;
import java.io.PrintWriter;
import java.io.StringWriter;

public class PlatformComm
{
  static final int EMobile = 2;
  static final int ENoNet = -1;
  static final int EOtherNet = 3;
  static final int EWifi = 1;
  private static final boolean IS_PROXY_ON = false;
  static final int NETTYPE_2G = 3;
  static final int NETTYPE_3G = 4;
  static final int NETTYPE_4G = 5;
  static final int NETTYPE_NON = -1;
  static final int NETTYPE_NOT_WIFI = 0;
  static final int NETTYPE_UNKNOWN = 6;
  static final int NETTYPE_WAP = 2;
  static final int NETTYPE_WIFI = 1;
  private static final String TAG = "PlatformComm";
  public static Context context = null;
  public static Handler handler = null;
  
  public static void init(Context paramContext, Handler paramHandler)
  {
    context = paramContext;
    handler = paramHandler;
    NetworkSignalUtil.InitNetworkSignalUtil(paramContext);
  }
  
  static class APNInfo
  {
    public String extraInfo;
    public int netType;
    public int subNetType;
  }
  
  public static class Assert
  {
    public static void assertTrue(String paramString, boolean paramBoolean) {}
    
    public static void assertTrue(boolean paramBoolean) {}
  }
  
  public static class C2Java
  {
    private static String exception2String(Exception paramException)
    {
      StringWriter localStringWriter = new StringWriter();
      paramException.printStackTrace(new PrintWriter(localStringWriter));
      return localStringWriter.toString();
    }
    
    public static PlatformComm.APNInfo getAPNInfo()
    {
      try
      {
        Object localObject = ((ConnectivityManager)PlatformComm.context.getSystemService("connectivity")).getActiveNetworkInfo();
        PlatformComm.APNInfo localAPNInfo = new PlatformComm.APNInfo();
        if (localObject != null)
        {
          localAPNInfo.netType = ((NetworkInfo)localObject).getType();
          localAPNInfo.subNetType = ((NetworkInfo)localObject).getSubtype();
          if (1 != ((NetworkInfo)localObject).getType())
          {
            if (((NetworkInfo)localObject).getExtraInfo() == null) {}
            for (localObject = "";; localObject = ((NetworkInfo)localObject).getExtraInfo())
            {
              localAPNInfo.extraInfo = ((String)localObject);
              return localAPNInfo;
            }
          }
          localAPNInfo.extraInfo = getCurWifiInfo().ssid;
          return localAPNInfo;
        }
      }
      catch (Exception localException) {}
      return null;
    }
    
    public static int getCurRadioAccessNetworkInfo()
    {
      if (PlatformComm.context == null)
      {
        PlatformComm.Assert.assertTrue(false);
        return 0;
      }
      try
      {
        int i = ((TelephonyManager)PlatformComm.context.getSystemService("phone")).getNetworkType();
        return i;
      }
      catch (Exception localException)
      {
        PlatformComm.Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
      }
      return 0;
    }
    
    public static PlatformComm.SIMInfo getCurSIMInfo()
    {
      try
      {
        if (PlatformComm.context == null) {
          return null;
        }
        int i = NetStatusUtil.getISPCode(PlatformComm.context);
        if (i != 0)
        {
          PlatformComm.SIMInfo localSIMInfo = new PlatformComm.SIMInfo();
          localSIMInfo.ispCode = String.valueOf(i);
          localSIMInfo.ispName = NetStatusUtil.getISPName(PlatformComm.context);
          return localSIMInfo;
        }
      }
      catch (Exception localException) {}
      return null;
    }
    
    public static PlatformComm.WifiInfo getCurWifiInfo()
    {
      PlatformComm.WifiInfo localWifiInfo = new PlatformComm.WifiInfo();
      localWifiInfo.ssid = NetworkSignalUtil.getSSID();
      localWifiInfo.bssid = NetworkSignalUtil.getBSSID();
      return localWifiInfo;
    }
    
    public static int getNetInfo()
    {
      Object localObject = (ConnectivityManager)PlatformComm.context.getSystemService("connectivity");
      if (localObject == null) {
        return -1;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject == null) {
        return -1;
      }
      try
      {
        int i = ((NetworkInfo)localObject).getType();
        switch (i)
        {
        default: 
          return 3;
        case 1: 
          return 1;
        }
        return 2;
      }
      catch (Exception localException) {}
      return 3;
    }
    
    public static int getProxyInfo(StringBuffer paramStringBuffer)
    {
      return -1;
    }
    
    public static long getSignal(boolean paramBoolean)
    {
      try
      {
        if (PlatformComm.context == null)
        {
          PlatformComm.Assert.assertTrue(false);
          return 0L;
        }
        if (paramBoolean) {
          return NetworkSignalUtil.getWifiSignalStrength();
        }
        long l = NetworkSignalUtil.getGSMSignalStrength();
        return l;
      }
      catch (Exception localException) {}
      return 0L;
    }
    
    public static int getStatisticsNetType()
    {
      if (PlatformComm.context == null)
      {
        PlatformComm.Assert.assertTrue(false);
        return 0;
      }
      try
      {
        int i = NetStatusUtil.getNetType(PlatformComm.context);
        if (i == -1) {
          return -1;
        }
        if (NetStatusUtil.is2G(PlatformComm.context)) {
          return 3;
        }
        if (NetStatusUtil.is3G(PlatformComm.context)) {
          return 4;
        }
        if (NetStatusUtil.is4G(PlatformComm.context)) {
          return 5;
        }
        if (NetStatusUtil.isWifi(i)) {
          return 1;
        }
        boolean bool = NetStatusUtil.isWap(i);
        if (bool) {
          return 2;
        }
        return 6;
      }
      catch (Exception localException)
      {
        exception2String(localException);
        PlatformComm.Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
      }
      return -1;
    }
    
    public static boolean isNetworkConnected()
    {
      if (PlatformComm.context == null)
      {
        PlatformComm.Assert.assertTrue(false);
        return false;
      }
      try
      {
        boolean bool = NetStatusUtil.isNetworkConnected(PlatformComm.context);
        return bool;
      }
      catch (Exception localException)
      {
        exception2String(localException);
        PlatformComm.Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
      }
      return false;
    }
    
    public static boolean startAlarm(int paramInt1, int paramInt2, int paramInt3)
    {
      if (PlatformComm.context == null)
      {
        PlatformComm.Assert.assertTrue(false);
        return false;
      }
      long l = paramInt2;
      try
      {
        boolean bool = Alarm.start(paramInt1, l, paramInt3, PlatformComm.context);
        return bool;
      }
      catch (Exception localException)
      {
        exception2String(localException);
        PlatformComm.Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
      }
      return false;
    }
    
    public static boolean stopAlarm(int paramInt)
    {
      if (PlatformComm.context == null)
      {
        PlatformComm.Assert.assertTrue(false);
        return false;
      }
      long l = paramInt;
      try
      {
        boolean bool = Alarm.stop(l, PlatformComm.context);
        return bool;
      }
      catch (Exception localException)
      {
        exception2String(localException);
        PlatformComm.Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
      }
      return false;
    }
    
    public static WakerLock wakeupLock_new()
    {
      if (PlatformComm.context == null)
      {
        PlatformComm.Assert.assertTrue(false);
        return null;
      }
      try
      {
        WakerLock localWakerLock = new WakerLock(PlatformComm.context);
        return localWakerLock;
      }
      catch (Exception localException)
      {
        exception2String(localException);
        PlatformComm.Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
      }
      return null;
    }
  }
  
  static class SIMInfo
  {
    public String ispCode;
    public String ispName;
  }
  
  static class WifiInfo
  {
    public String bssid;
    public String ssid;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mars.ilink.comm.PlatformComm
 * JD-Core Version:    0.7.0.1
 */