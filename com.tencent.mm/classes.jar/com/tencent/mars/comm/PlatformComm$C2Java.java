package com.tencent.mars.comm;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.az;
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
      ae.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
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
      ae.e("PlatformComm", exception2String(localException));
      ae.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
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
      int i = az.getISPCode(PlatformComm.access$000());
      if (i != 0)
      {
        PlatformComm.SIMInfo localSIMInfo = new PlatformComm.SIMInfo();
        localSIMInfo.ispCode = String.valueOf(i);
        ae.d("PlatformComm", "getISPCode MCC_MNC=%s", new Object[] { localSIMInfo.ispCode });
        localSIMInfo.ispName = az.getISPName(PlatformComm.access$000());
        return localSIMInfo;
      }
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
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
          ae.e("PlatformComm", "getActiveNetworkInfo failed.");
          localWifiInfo = null;
        }
        PlatformComm.WifiInfo localWifiInfo = new PlatformComm.WifiInfo();
        localWifiInfo.ssid = az.ja(ak.getContext());
        localWifiInfo.bssid = az.jb(ak.getContext());
        return localWifiInfo;
      }
      return null;
    }
    catch (Exception localException2)
    {
      ae.printErrStackTrace("PlatformComm", localException2, "", new Object[0]);
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
        ae.printErrStackTrace("PlatformComm", localException2, "", new Object[0]);
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
      ae.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
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
      int i = az.getNetType(PlatformComm.access$000());
      if (i == -1) {
        return -1;
      }
      if (az.isWifi(i)) {
        return 1;
      }
      if (az.is2G(PlatformComm.access$000())) {
        return 3;
      }
      if (az.is3G(PlatformComm.access$000())) {
        return 4;
      }
      if (az.is4G(PlatformComm.access$000())) {
        return 5;
      }
      if (az.is5G(PlatformComm.access$000())) {
        return 7;
      }
      boolean bool = az.isWap(i);
      if (bool) {
        return 2;
      }
      return 6;
    }
    catch (Exception localException)
    {
      ae.e("PlatformComm", exception2String(localException));
      ae.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
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
      boolean bool = az.isNetworkConnected(PlatformComm.access$000());
      return bool;
    }
    catch (Exception localException)
    {
      ae.e("PlatformComm", exception2String(localException));
      ae.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
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
      ae.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
    }
  }
  
  public static boolean startAlarm(int paramInt1, int paramInt2)
  {
    ae.i("PlatformComm", "start alarm no type id is %d", new Object[] { Integer.valueOf(paramInt1) });
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
      ae.e("PlatformComm", exception2String(localException));
      ae.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
      PlatformComm.Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
    }
    return false;
  }
  
  public static boolean startAlarm(int paramInt1, int paramInt2, int paramInt3)
  {
    ae.i("PlatformComm", "start alarm type:%d id is %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      ae.e("PlatformComm", exception2String(localException));
      ae.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
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
      ae.e("PlatformComm", exception2String(localException));
      ae.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
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
      ae.e("PlatformComm", exception2String(localException));
      ae.printErrStackTrace("PlatformComm", localException, "", new Object[0]);
      PlatformComm.Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mars.comm.PlatformComm.C2Java
 * JD-Core Version:    0.7.0.1
 */