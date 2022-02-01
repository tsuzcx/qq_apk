package com.tencent.mobileqq.msf.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.push.f;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class NetConnInfoCenter
  extends BroadcastReceiver
{
  public static byte[] GUID = new byte[0];
  public static String RDMREPORT_INTENT;
  public static final String TAG;
  public static NetConnInfoCenterImpl impl = new NetConnInfoCenterImpl();
  private static boolean sHasBooted = false;
  public static long servetTimeSecondInterv;
  public static volatile int socketConnState;
  
  static
  {
    TAG = NetConnInfoCenter.class.getSimpleName();
    servetTimeSecondInterv = 0L;
    socketConnState = 0;
    RDMREPORT_INTENT = "com.tencent.mobileqq.rdm.report";
  }
  
  public static void checkConnInfo(Context paramContext)
  {
    impl.checkConnInfo(paramContext, null);
  }
  
  public static void checkConnInfo(Context paramContext, boolean paramBoolean)
  {
    impl.checkConnInfo(paramContext, null, paramBoolean);
  }
  
  public static int getCdmaStrength()
  {
    return impl.lastCdmaStrenght;
  }
  
  public static int getGsmStrength()
  {
    return impl.lastGsmStrength;
  }
  
  public static long getServerTime()
  {
    return System.currentTimeMillis() / 1000L + servetTimeSecondInterv;
  }
  
  public static long getServerTimeMillis()
  {
    return System.currentTimeMillis() + servetTimeSecondInterv * 1000L;
  }
  
  public static String getSignalStrengthsLog()
  {
    return " SignalStrengths wifi:" + getWifiStrength() + " gsm:" + getGsmStrength() + " cdma:" + getCdmaStrength() + " net:" + NetConnInfoCenterImpl.getSystemNetworkType();
  }
  
  public static int getWifiStrength()
  {
    if ((impl.lastWifiStrength == 0) && (NetConnInfoCenterImpl.isWifiConn())) {
      impl.checkWifiSignalStrengths();
    }
    return impl.lastWifiStrength;
  }
  
  public static void handleGetServerTimeResp(long paramLong)
  {
    impl.handleGetServerTimeResp(paramLong);
  }
  
  public static void init(MsfCore paramMsfCore)
  {
    NetConnInfoCenterImpl.setMsfCore(paramMsfCore);
    impl.registerSignalStrengthsChanged(BaseApplication.getContext());
  }
  
  public static void onConnClosed(com.tencent.qphone.base.a parama)
  {
    impl.onConnClosed(parama);
  }
  
  public static void onConnOpened(String paramString1, String paramString2)
  {
    impl.onConnOpened(paramString1, paramString2);
  }
  
  public static void onOepnConnAllFailed()
  {
    impl.onOepnConnAllFailed();
  }
  
  public static void onRecvFirstResp()
  {
    impl.onRecvFirstResp();
  }
  
  public static void startOrBindService(Intent paramIntent)
  {
    try
    {
      BaseApplication.getContext().startService(paramIntent);
      return;
    }
    catch (Exception localException)
    {
      QLog.d(TAG, 1, "init msf startService exception:", localException);
      try
      {
        BaseApplication.getContext().bindService(paramIntent, new n(), 1);
        return;
      }
      catch (Exception paramIntent)
      {
        QLog.d(TAG, 1, "init msf bindService exception:", paramIntent);
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      if (QLog.isColorLevel()) {
        QLog.d(NetConnInfoCenterImpl.tag, 2, "receive broadcast intent == null return");
      }
    }
    do
    {
      do
      {
        do
        {
          boolean bool1;
          do
          {
            do
            {
              return;
              if (QLog.isColorLevel()) {
                QLog.d(NetConnInfoCenterImpl.tag, 2, "receive broadcast " + paramIntent);
              }
              if (paramIntent.getAction() != null) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d(NetConnInfoCenterImpl.tag, 2, "receive broadcast intent.getAction() == null return");
            return;
            if (paramIntent.getAction().equals("com.tencent.mobileqq.msf.receiveofflinepush"))
            {
              paramContext = impl;
              NetConnInfoCenterImpl.msfCore.pushManager.m();
              return;
            }
            if (paramIntent.getAction().equals("com.tencent.mobileqq.msf.offlinepushclearall"))
            {
              paramContext = impl;
              NetConnInfoCenterImpl.msfCore.pushManager.h();
              return;
            }
            if (paramIntent.getAction().equals("com.tencent.mobileqq.msf.receiveofflinepushav"))
            {
              paramContext = impl;
              NetConnInfoCenterImpl.msfCore.pushManager.n();
              return;
            }
            if (paramIntent.getAction().equals("com.tencent.mobileqq.msf.offlinepushclearallav"))
            {
              paramContext = impl;
              NetConnInfoCenterImpl.msfCore.pushManager.i();
              return;
            }
            if (paramIntent.getAction().equals("com.tencent.mobileqq.qqwifi.scanStateChange"))
            {
              if (QLog.isColorLevel()) {
                QLog.i(NetConnInfoCenterImpl.tag, 2, "QQWIFI ： intent.getExtras():" + paramIntent.getExtras());
              }
              p.a().a(paramIntent);
              return;
            }
            boolean bool2 = false;
            bool1 = bool2;
            if (!sHasBooted)
            {
              sHasBooted = true;
              bool1 = bool2;
              if (SystemClock.elapsedRealtime() < 300000L) {
                bool1 = true;
              }
            }
            if (!MsfService.inited)
            {
              MsfService.sIsCreatedByAutoBoot = bool1;
              startOrBindService(new Intent(paramContext, MsfService.class));
            }
            if (!paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.i(NetConnInfoCenterImpl.tag, 2, "receive CONNECTIVITY_CHANGE");
            }
            try
            {
              p.a().d();
              paramIntent = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
              impl.checkConnInfo(paramContext, paramIntent, true);
              return;
            }
            catch (Exception paramContext) {}
          } while (!QLog.isColorLevel());
          QLog.d(NetConnInfoCenterImpl.tag, 2, paramContext.toString(), paramContext);
          return;
          if ((paramIntent.getAction().equals("android.intent.action.TIME_SET")) || (paramIntent.getAction().equals("android.intent.action.TIMEZONE_CHANGED")))
          {
            if (QLog.isColorLevel()) {
              QLog.d(NetConnInfoCenterImpl.tag, 2, "recv broadcast " + paramIntent.getAction());
            }
            impl.checkServerTime();
            return;
          }
          if (!bool1) {
            break;
          }
          com.tencent.mobileqq.msf.core.a.a.a(true);
          com.tencent.mobileqq.msf.core.c.m.J = true;
        } while (!QLog.isColorLevel());
        QLog.d(NetConnInfoCenterImpl.tag, 2, "set StatReporter.needReportBooting true");
        return;
        if (!paramIntent.getAction().equals(RDMREPORT_INTENT)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(NetConnInfoCenterImpl.tag, 2, "receive reportRDM call");
      return;
    } while (!"android.net.wifi.WIFI_STATE_CHANGED".equals(paramIntent.getAction()));
    if (QLog.isColorLevel()) {
      QLog.i(NetConnInfoCenterImpl.tag, 2, "receive WIFI_STATE_CHANGED_ACTION");
    }
    p.a().b(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.NetConnInfoCenter
 * JD-Core Version:    0.7.0.1
 */