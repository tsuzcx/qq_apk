package com.tencent.mars.comm;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import java.io.PrintWriter;
import java.io.StringWriter;

public class PlatformComm$C2Java
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
      Object localObject = ((ConnectivityManager)PlatformComm.access$000().getSystemService("connectivity")).getActiveNetworkInfo();
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
      ad.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
    }
    return null;
  }
  
  public static int getCurRadioAccessNetworkInfo()
  {
    if (PlatformComm.access$000() == null)
    {
      PlatformComm.Assert.assertTrue(false);
      return 0;
    }
    try
    {
      int i = ((TelephonyManager)PlatformComm.access$000().getSystemService("phone")).getNetworkType();
      return i;
    }
    catch (Exception localException)
    {
      ad.e("PlatformComm", exception2String(localException));
      ad.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
      PlatformComm.Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
    }
    return 0;
  }
  
  public static PlatformComm.SIMInfo getCurSIMInfo()
  {
    try
    {
      if (PlatformComm.access$000() == null) {
        return null;
      }
      int i = ay.getISPCode(PlatformComm.access$000());
      if (i != 0)
      {
        PlatformComm.SIMInfo localSIMInfo = new PlatformComm.SIMInfo();
        localSIMInfo.ispCode = String.valueOf(i);
        ad.d("PlatformComm", "getISPCode MCC_MNC=%s", new Object[] { localSIMInfo.ispCode });
        localSIMInfo.ispName = ay.getISPName(PlatformComm.access$000());
        return localSIMInfo;
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
    }
    return null;
  }
  
  public static PlatformComm.WifiInfo getCurWifiInfo()
  {
    try
    {
      if (PlatformComm.access$000() == null) {
        return null;
      }
      Object localObject = (ConnectivityManager)PlatformComm.access$000().getSystemService("connectivity");
      if (localObject == null) {
        return null;
      }
      try
      {
        localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
        if (localObject != null) {
          if (1 == ((NetworkInfo)localObject).getType()) {}
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          ad.e("PlatformComm", "getActiveNetworkInfo failed.");
          localWifiInfo = null;
        }
        PlatformComm.WifiInfo localWifiInfo = new PlatformComm.WifiInfo();
        localWifiInfo.ssid = ay.iA(aj.getContext());
        localWifiInfo.bssid = ay.iB(aj.getContext());
        return localWifiInfo;
      }
      return null;
    }
    catch (Exception localException2)
    {
      ad.printErrStackTrace("PlatformComm", localException2, "", new Object[0]);
      return null;
    }
  }
  
  public static int getNetInfo()
  {
    try
    {
      localObject1 = (ConnectivityManager)PlatformComm.access$000().getSystemService("connectivity");
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
        ad.printErrStackTrace("PlatformComm", localException2, "", new Object[0]);
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
      if (PlatformComm.access$000() == null)
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
      ad.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
    }
    return 0L;
  }
  
  public static int getStatisticsNetType()
  {
    if (PlatformComm.access$000() == null)
    {
      PlatformComm.Assert.assertTrue(false);
      return 0;
    }
    try
    {
      int i = ay.getNetType(PlatformComm.access$000());
      if (i == -1) {
        return -1;
      }
      if (ay.isWifi(i)) {
        return 1;
      }
      if (ay.is2G(PlatformComm.access$000())) {
        return 3;
      }
      if (ay.is3G(PlatformComm.access$000())) {
        return 4;
      }
      if (ay.is4G(PlatformComm.access$000())) {
        return 5;
      }
      if (ay.is5G(PlatformComm.access$000())) {
        return 7;
      }
      boolean bool = ay.isWap(i);
      if (bool) {
        return 2;
      }
      return 6;
    }
    catch (Exception localException)
    {
      ad.e("PlatformComm", exception2String(localException));
      ad.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
      PlatformComm.Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
    }
    return -1;
  }
  
  public static boolean isNetworkConnected()
  {
    if (PlatformComm.access$000() == null)
    {
      PlatformComm.Assert.assertTrue(false);
      return false;
    }
    try
    {
      boolean bool = ay.isNetworkConnected(PlatformComm.access$000());
      return bool;
    }
    catch (Exception localException)
    {
      ad.e("PlatformComm", exception2String(localException));
      ad.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
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
      PlatformComm.access$100().post(new Runnable()
      {
        public final void run()
        {
          PlatformComm.resetprocessimp.restartProcess();
        }
      });
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
    }
  }
  
  public static boolean startAlarm(int paramInt1, int paramInt2)
  {
    ad.i("PlatformComm", "start alarm no type id is %d", new Object[] { Integer.valueOf(paramInt1) });
    if (PlatformComm.access$000() == null)
    {
      PlatformComm.Assert.assertTrue(false);
      return false;
    }
    long l = paramInt1;
    try
    {
      boolean bool = Alarm.start(113, l, paramInt2, PlatformComm.access$000());
      return bool;
    }
    catch (Exception localException)
    {
      if (PlatformComm.reportCrashImp != null) {
        PlatformComm.reportCrashImp.reportIdkey();
      }
      ad.e("PlatformComm", exception2String(localException));
      ad.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
      PlatformComm.Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
    }
    return false;
  }
  
  public static boolean startAlarm(int paramInt1, int paramInt2, int paramInt3)
  {
    ad.i("PlatformComm", "start alarm type:%d id is %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (PlatformComm.access$000() == null)
    {
      PlatformComm.Assert.assertTrue(false);
      return false;
    }
    long l = paramInt2;
    try
    {
      boolean bool = Alarm.start(paramInt1, l, paramInt3, PlatformComm.access$000());
      return bool;
    }
    catch (Exception localException)
    {
      if (PlatformComm.reportCrashImp != null) {
        PlatformComm.reportCrashImp.reportIdkey();
      }
      ad.e("PlatformComm", exception2String(localException));
      ad.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
      PlatformComm.Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
    }
    return false;
  }
  
  public static boolean stopAlarm(int paramInt)
  {
    if (PlatformComm.access$000() == null)
    {
      PlatformComm.Assert.assertTrue(false);
      return false;
    }
    long l = paramInt;
    try
    {
      boolean bool = Alarm.stop(l, PlatformComm.access$000());
      return bool;
    }
    catch (Exception localException)
    {
      ad.e("PlatformComm", exception2String(localException));
      ad.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
      PlatformComm.Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
    }
    return false;
  }
  
  public static WakerLock wakeupLock_new()
  {
    if (PlatformComm.access$000() == null)
    {
      PlatformComm.Assert.assertTrue(false);
      return null;
    }
    try
    {
      WakerLock localWakerLock = new WakerLock(PlatformComm.access$000(), "PlatformComm");
      return localWakerLock;
    }
    catch (Exception localException)
    {
      ad.e("PlatformComm", exception2String(localException));
      ad.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
      PlatformComm.Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mars.comm.PlatformComm.C2Java
 * JD-Core Version:    0.7.0.1
 */