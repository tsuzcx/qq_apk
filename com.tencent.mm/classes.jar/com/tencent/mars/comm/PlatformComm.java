package com.tencent.mars.comm;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.io.PrintWriter;
import java.io.StringWriter;

public class PlatformComm
{
  public static final int EMobile = 2;
  public static final int ENoNet = -1;
  public static final int EOtherNet = 3;
  public static final int EWifi = 1;
  private static final boolean IS_PROXY_ON = false;
  public static final int NETTYPE_2G = 3;
  public static final int NETTYPE_3G = 4;
  public static final int NETTYPE_4G = 5;
  public static final int NETTYPE_5G = 7;
  public static final int NETTYPE_NON = -1;
  public static final int NETTYPE_NOT_WIFI = 0;
  public static final int NETTYPE_UNKNOWN = 6;
  public static final int NETTYPE_WAP = 2;
  public static final int NETTYPE_WIFI = 1;
  private static final String TAG = "PlatformComm";
  private static Context context = null;
  private static MMHandler handler = null;
  public static IReportCrash reportCrashImp;
  public static IResetProcess resetprocessimp = null;
  
  static
  {
    reportCrashImp = null;
  }
  
  public static void init(Context paramContext, MMHandler paramMMHandler)
  {
    context = paramContext;
    handler = paramMMHandler;
    NetworkSignalUtil.InitNetworkSignalUtil(paramContext);
  }
  
  static class APNInfo
  {
    public String extraInfo;
    public int netType;
    public int subNetType;
  }
  
  static class Assert
  {
    static void assertTrue(String paramString, boolean paramBoolean) {}
    
    static void assertTrue(boolean paramBoolean) {}
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
        Object localObject = ((ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
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
      catch (Exception localException)
      {
        Log.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
      }
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
        Log.e("PlatformComm", exception2String(localException));
        Log.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
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
          Log.d("PlatformComm", "getISPCode MCC_MNC=%s", new Object[] { localSIMInfo.ispCode });
          localSIMInfo.ispName = NetStatusUtil.getISPName(PlatformComm.context);
          return localSIMInfo;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
      }
      return null;
    }
    
    @Deprecated
    public static PlatformComm.WifiInfo getCurWifiInfo()
    {
      PlatformComm.WifiInfo localWifiInfo = new PlatformComm.WifiInfo();
      localWifiInfo.ssid = ConnectivityCompat.Companion.getFormattedWiFiSsid();
      localWifiInfo.bssid = ConnectivityCompat.Companion.getFormattedWiFiBssid();
      return localWifiInfo;
    }
    
    public static int getNetInfo()
    {
      try
      {
        localObject1 = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
        if (localObject1 == null) {
          return -1;
        }
        localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
      }
      catch (Exception localException1)
      {
        Object localObject2;
        for (;;)
        {
          Object localObject1;
          localObject2 = null;
        }
        try
        {
          int i = localObject2.getType();
          switch (i)
          {
          default: 
            return 3;
          case 1: 
            return 1;
          }
          return 2;
        }
        catch (Exception localException2)
        {
          Log.printErrStackTrace("PlatformComm", localException2, "", new Object[0]);
        }
      }
      if (localObject1 == null) {
        return -1;
      }
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
      catch (Exception localException)
      {
        Log.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
      }
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
        if (NetStatusUtil.isWifi(i)) {
          return 1;
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
        if (NetStatusUtil.is5G(PlatformComm.context)) {
          return 7;
        }
        boolean bool = NetStatusUtil.isWap(i);
        if (bool) {
          return 2;
        }
        return 6;
      }
      catch (Exception localException)
      {
        Log.e("PlatformComm", exception2String(localException));
        Log.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
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
        Log.e("PlatformComm", exception2String(localException));
        Log.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
        PlatformComm.Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
      }
      return false;
    }
    
    public static void restartProcess()
    {
      if (PlatformComm.resetprocessimp == null) {
        return;
      }
      try
      {
        PlatformComm.handler.post(new Runnable()
        {
          public void run()
          {
            PlatformComm.resetprocessimp.restartProcess();
          }
        });
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
      }
    }
    
    public static boolean startAlarm(int paramInt1, int paramInt2)
    {
      Log.i("PlatformComm", "start alarm no type id is %d", new Object[] { Integer.valueOf(paramInt1) });
      if (PlatformComm.context == null)
      {
        PlatformComm.Assert.assertTrue(false);
        return false;
      }
      long l = paramInt1;
      try
      {
        boolean bool = Alarm.start(113, l, paramInt2, PlatformComm.context);
        return bool;
      }
      catch (Exception localException)
      {
        if (PlatformComm.reportCrashImp != null) {
          PlatformComm.reportCrashImp.reportIdkey();
        }
        Log.e("PlatformComm", exception2String(localException));
        Log.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
        PlatformComm.Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
      }
      return false;
    }
    
    public static boolean startAlarm(int paramInt1, int paramInt2, int paramInt3)
    {
      Log.i("PlatformComm", "start alarm type:%d id is %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
        if (PlatformComm.reportCrashImp != null) {
          PlatformComm.reportCrashImp.reportIdkey();
        }
        Log.e("PlatformComm", exception2String(localException));
        Log.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
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
        Log.e("PlatformComm", exception2String(localException));
        Log.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
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
        WakerLock localWakerLock = new WakerLock(PlatformComm.context, "PlatformComm");
        return localWakerLock;
      }
      catch (Exception localException)
      {
        Log.e("PlatformComm", exception2String(localException));
        Log.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
        PlatformComm.Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
      }
      return null;
    }
  }
  
  public static abstract interface IReportCrash
  {
    public abstract void reportIdkey();
  }
  
  public static abstract interface IResetProcess
  {
    public abstract void restartProcess();
  }
  
  public static class SIMInfo
  {
    public String ispCode;
    public String ispName;
  }
  
  public static class WifiInfo
  {
    public String bssid;
    public String ssid;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mars.comm.PlatformComm
 * JD-Core Version:    0.7.0.1
 */