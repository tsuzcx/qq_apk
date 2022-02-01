package com.tencent.mobileqq.msf.core;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.c.i;
import com.tencent.mobileqq.msf.core.net.h;
import com.tencent.mobileqq.msf.core.push.f;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.msf.service.protocol.security.c;
import com.tencent.msf.service.protocol.security.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class NetConnInfoCenterImpl
{
  public static final String KEY_RECORD_SERVER_TIME = "recordSysTimeKey";
  private static int _activeNetInfoType = 0;
  static int _dayOfYear = 0;
  private static String _lastMobileApn;
  private static String _lastWifiSSID;
  private static AtomicBoolean _netSupport;
  static String currentAPN;
  private static long lastCheckTime = 0L;
  private static long lastCompareTime = 0L;
  private static AtomicBoolean lastConnSuccWithoutNet;
  private static long lastConnSuccWithoutNetTime = 0L;
  private static int mobileNetworkType = 0;
  private static final byte mobileStat = 0;
  public static MsfCore msfCore;
  static boolean needWifiAuth = false;
  static AtomicInteger netChangeCount;
  private static final String serverTimeDiffKey = "servetTimeDiff";
  static String subtypeName;
  static String tag = "MSF.C.NetConnInfoCenter";
  private static final byte wifiStat = 1;
  boolean calculateSignalLevel = true;
  private long firstGetServerTime = 0L;
  int lastCdmaStrenght;
  private long lastGetServerTimeInterval = 0L;
  int lastGsmStrength;
  int lastWifiStrength;
  private int sendGetServerTimeMsgCount = 0;
  
  static
  {
    netChangeCount = new AtomicInteger(0);
    _dayOfYear = Calendar.getInstance().get(6);
    _activeNetInfoType = 0;
    _netSupport = new AtomicBoolean(false);
    lastCheckTime = -1L;
    lastCompareTime = 0L;
    lastConnSuccWithoutNet = new AtomicBoolean();
    lastConnSuccWithoutNetTime = 0L;
    currentAPN = "";
    subtypeName = "";
  }
  
  public static void callQQProcess(String paramString)
  {
    try
    {
      if (f.n)
      {
        Object localObject = new Intent(paramString);
        paramString = f.o;
        int i = msfCore.getUinPushStatus(paramString);
        ((Intent)localObject).putExtra("uin", paramString);
        ((Intent)localObject).putExtra("istatus", i);
        ((Intent)localObject).putExtra("gatewayip", s.m());
        localObject = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, (Intent)localObject, 0);
        ((AlarmManager)BaseApplication.getContext().getSystemService("alarm")).set(0, System.currentTimeMillis() + com.tencent.mobileqq.msf.core.a.a.K(), (PendingIntent)localObject);
        QLog.d(tag, 1, "send bootAction for QQ " + MsfSdkUtils.getShortUin(paramString));
        f.n = false;
        return;
      }
      QLog.d(tag, 1, "not need send bootAction for QQ");
      return;
    }
    catch (Exception paramString)
    {
      QLog.d(tag, 1, "send bootAction for QQ error " + paramString);
    }
  }
  
  private void closeNowConn()
  {
    if ((msfCore != null) && (msfCore.sender != null)) {
      msfCore.sender.a(com.tencent.qphone.base.a.b);
    }
  }
  
  public static String getCurrentAPN()
  {
    return currentAPN;
  }
  
  public static String getLastWifiSSID()
  {
    return _lastWifiSSID;
  }
  
  public static int getMobileNetworkType()
  {
    return mobileNetworkType;
  }
  
  private static String getNetStatusMsg(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 0: 
      return "NONE";
    case 1: 
      return "MOBILE";
    case 2: 
      return "WiFi";
    }
    return "WiFi";
  }
  
  public static String getNetSubtypeName()
  {
    return subtypeName;
  }
  
  public static int getSystemNetState()
  {
    if (isWifiConn()) {
      return 2;
    }
    if (isMobileConn()) {
      return 1;
    }
    return 0;
  }
  
  public static int getSystemNetworkType()
  {
    int i = 0;
    if (isWifiConn()) {
      i = _activeNetInfoType;
    }
    while (!isMobileConn()) {
      return i;
    }
    return getMobileNetworkType() + 10000;
  }
  
  public static InetAddress intToInetAddress(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    int j = (byte)(paramInt >> 8 & 0xFF);
    int k = (byte)(paramInt >> 16 & 0xFF);
    int m = (byte)(paramInt >> 24 & 0xFF);
    try
    {
      InetAddress localInetAddress = InetAddress.getByAddress(new byte[] { i, j, k, m });
      return localInetAddress;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      throw new AssertionError();
    }
  }
  
  public static boolean isMobileConn()
  {
    return _activeNetInfoType == 1;
  }
  
  public static boolean isMobileNetworkInfo(NetworkInfo paramNetworkInfo)
  {
    return (paramNetworkInfo.getType() == 0) || (50 == paramNetworkInfo.getType());
  }
  
  public static boolean isNeedWifiAuth()
  {
    return needWifiAuth;
  }
  
  public static boolean isNetSupport()
  {
    return _netSupport.get();
  }
  
  public static boolean isWifiConn()
  {
    return (_activeNetInfoType == 2) || (_activeNetInfoType == 3);
  }
  
  public static boolean isWifiOrMobileConn()
  {
    return (isWifiConn()) || (isMobileConn());
  }
  
  private void mobileConnected(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo != null) {
      mobileNetworkType = paramNetworkInfo.getSubtype();
    }
    for (;;)
    {
      setConnInfo(_activeNetInfoType | 0x1);
      return;
      try
      {
        mobileNetworkType = ((TelephonyManager)BaseApplication.getContext().getSystemService("phone")).getNetworkType();
      }
      catch (Exception paramNetworkInfo)
      {
        paramNetworkInfo.printStackTrace();
      }
    }
  }
  
  private void mobileDisConnected()
  {
    setConnInfo(_activeNetInfoType & 0xFFFFFFFE);
  }
  
  private void onMobileConnChnaged()
  {
    if ((isMobileConn()) && (msfCore != null) && (msfCore.standbyModeManager != null)) {
      msfCore.standbyModeManager.f();
    }
  }
  
  private void onWifiConnChanged()
  {
    if (isWifiConn()) {
      if ((msfCore != null) && (msfCore.sender != null))
      {
        msfCore.sender.a.h.a(_lastWifiSSID);
        msfCore.standbyModeManager.g();
      }
    }
    while ((msfCore == null) || (msfCore.sender == null)) {
      return;
    }
    msfCore.sender.a.h.a();
  }
  
  private static void resetLastConnSuccWithoutNet()
  {
    lastConnSuccWithoutNet.set(false);
    lastConnSuccWithoutNetTime = 0L;
  }
  
  private void sendNewCheckServerTime()
  {
    if (msfCore != null)
    {
      localToServiceMsg = new ToServiceMsg("", "0", "Client.CorrectTime");
      localToServiceMsg.setMsfCommand(MsfCommand.getServerTime);
      localToServiceMsg.setAppId(msfCore.sender.i());
      localToServiceMsg.setTimeout(30000L);
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localToServiceMsg.addAttribute("__base_tag_isAppMsg", Boolean.valueOf(true));
      localToServiceMsg.putWupBuffer(MsfSdkUtils.convertInt2Bytes(4));
      msfCore.sender.b(localToServiceMsg);
    }
    while (!QLog.isDevelopLevel())
    {
      ToServiceMsg localToServiceMsg;
      return;
    }
    QLog.d(tag, 4, "msfCore not inited. can not send checkServerTimeMsg.");
  }
  
  private void sendOldCheckServerTime()
  {
    if (msfCore != null)
    {
      localToServiceMsg = new ToServiceMsg("", "0", "login.time");
      localToServiceMsg.setMsfCommand(MsfCommand.getServerTime);
      localToServiceMsg.setAppId(msfCore.sender.i());
      localToServiceMsg.setTimeout(30000L);
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localUniPacket = new UniPacket(true);
      localUniPacket.setServantName("test");
      localUniPacket.setFuncName("cmdstr");
      locald = new d(1, 15, MsfCore.getNextSeq(), 1, "0", msfCore.sender.i(), String.valueOf(msfCore.sender.i()), "123", 0);
      localc = new c();
      localc.a = ((int)(System.currentTimeMillis() / 1000L));
      localUniPacket.put("RequestHeader", locald);
      localUniPacket.put("RequestGetServerTime", localc);
      localToServiceMsg.putWupBuffer(localUniPacket.encode());
      msfCore.sender.b(localToServiceMsg);
    }
    while (!QLog.isDevelopLevel())
    {
      ToServiceMsg localToServiceMsg;
      UniPacket localUniPacket;
      d locald;
      c localc;
      return;
    }
    QLog.d(tag, 4, "msfCore not inited. can not send checkServerTimeMsg.");
  }
  
  public static void setLastConnSuccWithoutNet()
  {
    lastConnSuccWithoutNetTime = System.currentTimeMillis();
    lastConnSuccWithoutNet.set(true);
  }
  
  static void setMsfCore(MsfCore paramMsfCore)
  {
    msfCore = paramMsfCore;
    NetConnInfoCenter.servetTimeSecondInterv = BaseApplication.getContext().getSharedPreferences(tag, 0).getLong("servetTimeDiff", 0L);
  }
  
  public static void setNeedWifiAuth(boolean paramBoolean)
  {
    needWifiAuth = paramBoolean;
  }
  
  public static void setNetSupport(boolean paramBoolean)
  {
    _netSupport.set(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d(tag, 2, "setNetSupport " + _netSupport.get());
    }
  }
  
  private void wifiConnected()
  {
    WifiInfo localWifiInfo = ((WifiManager)BaseApplication.getContext().getSystemService("wifi")).getConnectionInfo();
    if (localWifiInfo != null)
    {
      int i = localWifiInfo.getIpAddress();
      if (QLog.isColorLevel()) {
        QLog.d(tag, 2, "wifiConnected localAddress " + i + "(" + intToInetAddress(i).getHostAddress() + "), " + localWifiInfo.toString());
      }
      if (msfCore != null) {
        msfCore.getStatReporter().a(localWifiInfo);
      }
    }
    setConnInfo(_activeNetInfoType | 0x2);
  }
  
  private void wifiDisConnected()
  {
    setConnInfo(_activeNetInfoType & 0xFFFFFFFD);
  }
  
  public void checkConnInfo(Context paramContext, NetworkInfo paramNetworkInfo)
  {
    checkConnInfo(paramContext, paramNetworkInfo, false);
  }
  
  public void checkConnInfo(Context paramContext, NetworkInfo paramNetworkInfo, boolean paramBoolean)
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramBoolean) {
      i.e();
    }
    checkConnInfo(localConnectivityManager.getActiveNetworkInfo(), paramNetworkInfo);
    try
    {
      paramContext = localConnectivityManager.getNetworkInfo(0);
      if (paramContext != null) {
        break label98;
      }
      paramContext = localConnectivityManager.getNetworkInfo(50);
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        QLog.d(tag, 1, "get currentAPN error " + paramContext);
      }
    }
    if (paramContext != null) {
      currentAPN = paramContext.getExtraInfo();
    }
    if (paramBoolean) {
      i.e();
    }
  }
  
  public void checkConnInfo(NetworkInfo paramNetworkInfo1, NetworkInfo paramNetworkInfo2)
  {
    String str;
    if (paramNetworkInfo1 != null) {
      str = paramNetworkInfo1.getTypeName();
    }
    do
    {
      do
      {
        try
        {
          subtypeName = paramNetworkInfo1.getSubtypeName();
          if (str.toLowerCase().contains("mobile_mms")) {
            return;
          }
        }
        catch (Exception localException)
        {
          do
          {
            do
            {
              do
              {
                for (;;)
                {
                  QLog.d(tag, 1, "get subtypeName error " + localException);
                }
                QLog.d(tag, 1, "currentAPN:" + currentAPN + ". received networkInfo: " + paramNetworkInfo1.getDetailedState() + " :" + paramNetworkInfo1 + ". extra NetworkInfo: " + paramNetworkInfo2);
                if ((!paramNetworkInfo1.isAvailable()) || (paramNetworkInfo1.getDetailedState() != NetworkInfo.DetailedState.CONNECTED)) {
                  break;
                }
                if (1 == paramNetworkInfo1.getType())
                {
                  wifiConnected();
                  return;
                }
              } while (!isMobileNetworkInfo(paramNetworkInfo1));
              wifiDisConnected();
              mobileConnected(paramNetworkInfo1);
              return;
            } while ((paramNetworkInfo1.getDetailedState() != NetworkInfo.DetailedState.DISCONNECTED) && (paramNetworkInfo1.getDetailedState() != NetworkInfo.DetailedState.FAILED) && (paramNetworkInfo1.getDetailedState() != NetworkInfo.DetailedState.IDLE) && (paramNetworkInfo1.getDetailedState() != NetworkInfo.DetailedState.SUSPENDED));
            if (1 == paramNetworkInfo1.getType())
            {
              wifiDisConnected();
              return;
            }
          } while (!isMobileNetworkInfo(paramNetworkInfo1));
          mobileDisConnected();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(tag, 2, "currentAPN:" + currentAPN + ". active NetworkInfo: " + paramNetworkInfo1 + ". extra NetworkInfo: " + paramNetworkInfo2);
        }
      } while ((paramNetworkInfo2 == null) || ((paramNetworkInfo2.getDetailedState() != NetworkInfo.DetailedState.DISCONNECTED) && (paramNetworkInfo2.getDetailedState() != NetworkInfo.DetailedState.FAILED) && (paramNetworkInfo2.getDetailedState() != NetworkInfo.DetailedState.IDLE) && (paramNetworkInfo2.getDetailedState() != NetworkInfo.DetailedState.SUSPENDED)));
      if (1 == paramNetworkInfo2.getType())
      {
        wifiDisConnected();
        return;
      }
    } while (!isMobileNetworkInfo(paramNetworkInfo2));
    mobileDisConnected();
  }
  
  public void checkRecordTime()
  {
    try
    {
      long l = SystemClock.elapsedRealtime();
      if ((0L != lastCompareTime) && (l > lastCompareTime + com.tencent.mobileqq.msf.core.a.a.C()))
      {
        lastCompareTime = l;
        String str;
        if ((-1L == lastCheckTime) && (MsfStore.getNativeConfigStore() != null))
        {
          str = MsfStore.getNativeConfigStore().getConfig("recordSysTimeKey");
          if (str == null) {}
        }
        try
        {
          lastCheckTime = Long.parseLong(str);
          l = System.currentTimeMillis();
          if (-1L != lastCheckTime)
          {
            if (l <= lastCheckTime + com.tencent.mobileqq.msf.core.a.a.A() + Math.random() * com.tencent.mobileqq.msf.core.a.a.B()) {
              return;
            }
            checkServerTime();
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d(tag, 2, "get lastCheckTime catch Exception " + localException1);
            }
          }
        }
      }
      return;
    }
    catch (Exception localException2)
    {
      if (QLog.isColorLevel())
      {
        QLog.d(tag, 2, "checkRecordTime catch Exception " + localException2);
        return;
        lastCheckTime = l;
        if (MsfStore.getNativeConfigStore() != null)
        {
          MsfStore.getNativeConfigStore().n_setConfig("recordSysTimeKey", String.valueOf(lastCheckTime));
          return;
          if (0L == lastCompareTime) {
            lastCompareTime = l;
          }
        }
      }
    }
  }
  
  public void checkServerTime()
  {
    System.currentTimeMillis();
    long l = SystemClock.elapsedRealtime();
    if ((l - this.lastGetServerTimeInterval > 0L) && (l - this.lastGetServerTimeInterval <= com.tencent.mobileqq.msf.core.a.a.z()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(tag, 2, "quit to checkTimeMsg too frequency.");
      }
      return;
    }
    if (this.sendGetServerTimeMsgCount < 10)
    {
      sendOldCheckServerTime();
      this.sendGetServerTimeMsgCount += 1;
      this.lastGetServerTimeInterval = l;
    }
    for (;;)
    {
      l = System.currentTimeMillis();
      if ((this.firstGetServerTime == 0L) || (l - this.firstGetServerTime > 600000L))
      {
        this.firstGetServerTime = l;
        this.sendGetServerTimeMsgCount = 0;
      }
      lastCheckTime = l;
      if (MsfStore.getNativeConfigStore() == null) {
        break;
      }
      MsfStore.getNativeConfigStore().n_setConfig("recordSysTimeKey", String.valueOf(l));
      return;
      if (QLog.isColorLevel()) {
        QLog.d(tag, 2, "also send checkTimeMsg " + this.sendGetServerTimeMsgCount);
      }
    }
  }
  
  void checkWifiSignalStrengths()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.calculateSignalLevel;
        if (!bool) {
          break label134;
        }
        try
        {
          Object localObject1 = (WifiManager)BaseApplication.getContext().getSystemService("wifi");
          if (localObject1 != null)
          {
            localObject1 = ((WifiManager)localObject1).getConnectionInfo();
            if (localObject1 == null) {
              continue;
            }
            i = 1;
            if (((WifiInfo)localObject1).getBSSID() == null) {
              continue;
            }
            j = 1;
            if ((j & i) != 0) {
              this.lastWifiStrength = WifiManager.calculateSignalLevel(((WifiInfo)localObject1).getRssi(), 32);
            }
          }
        }
        catch (Exception localException)
        {
          int i;
          int j;
          QLog.d(tag, 1, "check WifiState error " + localException, localException);
          this.calculateSignalLevel = false;
          continue;
        }
        return;
      }
      finally {}
      i = 0;
      continue;
      j = 0;
      continue;
      label134:
      this.lastWifiStrength = 0;
    }
  }
  
  public void handleGetServerTimeResp(long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(tag, 4, "handleGetServerTimeResp servertime is " + paramLong);
    }
    NetConnInfoCenter.servetTimeSecondInterv = paramLong - System.currentTimeMillis() / 1000L;
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(tag, 0).edit();
    localEditor.putLong("servetTimeDiff", NetConnInfoCenter.servetTimeSecondInterv);
    localEditor.commit();
    if (QLog.isColorLevel()) {
      QLog.d(tag, 2, "set serverTime is " + msfCore.timeFormatter.format(Long.valueOf(System.currentTimeMillis() + NetConnInfoCenter.servetTimeSecondInterv * 1000L)));
    }
    MsfCore.initAppProMsg("*", msfCore.sender.i());
  }
  
  public void onConnClosed(com.tencent.qphone.base.a parama)
  {
    NetConnInfoCenter.socketConnState = 1;
    msfCore.pushManager.a(parama);
    try
    {
      if ((msfCore.standbyModeManager != null) && (!msfCore.standbyModeManager.d()))
      {
        parama = new FromServiceMsg(msfCore.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_connClosed");
        parama.setMsgSuccess();
        parama.setMsfCommand(MsfCommand.onConnClosed);
        MsfSdkUtils.addFromMsgProcessName("*", parama);
        msfCore.addRespToQuque(null, parama);
        return;
      }
      QLog.d(tag, 1, "onConnClosed, stop notify by standby");
      return;
    }
    catch (Exception parama)
    {
      QLog.d(tag, 1, "", parama);
    }
  }
  
  public void onConnOpened(String paramString1, String paramString2)
  {
    NetConnInfoCenter.socketConnState = 2;
    msfCore.pushManager.d();
    if ((msfCore.standbyModeManager != null) && (!msfCore.standbyModeManager.d()))
    {
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(msfCore.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_connOpened");
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localFromServiceMsg.setMsfCommand(MsfCommand.onConnOpened);
      localFromServiceMsg.addAttribute("resp_connopen_serverAdd", paramString1);
      localFromServiceMsg.addAttribute("resp_connopen_localAdd", paramString2);
      if (msfCore.pushManager.b()) {
        localFromServiceMsg.addAttribute("resp_needBootApp", Integer.valueOf(1));
      }
      MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
      msfCore.addRespToQuque(null, localFromServiceMsg);
      return;
    }
    msfCore.standbyModeManager.i();
    QLog.d(tag, 1, "onConnOpened, stop notify by standby");
  }
  
  public void onOepnConnAllFailed()
  {
    if ((msfCore.standbyModeManager != null) && (!msfCore.standbyModeManager.d()))
    {
      NetConnInfoCenter.socketConnState = 3;
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(msfCore.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_connAllFailed");
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localFromServiceMsg.setMsfCommand(MsfCommand.onOepnConnAllFailed);
      if (msfCore.pushManager.b()) {
        localFromServiceMsg.addAttribute("resp_needBootApp", Integer.valueOf(1));
      }
      MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
      msfCore.addRespToQuque(null, localFromServiceMsg);
    }
    for (;;)
    {
      msfCore.sender.a.h.b();
      return;
      QLog.d(tag, 1, "onOepnConnAllFailed, stop notify by standby");
    }
  }
  
  public void onRecvFirstResp()
  {
    if (isWifiConn()) {
      msfCore.sender.a.h.b(_lastWifiSSID);
    }
    if ((msfCore.standbyModeManager != null) && (!msfCore.standbyModeManager.d()))
    {
      NetConnInfoCenter.socketConnState = 4;
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(msfCore.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_recvFirstResp");
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localFromServiceMsg.setMsfCommand(MsfCommand.onReceFirstResp);
      if (msfCore.pushManager.b()) {
        localFromServiceMsg.addAttribute("resp_needBootApp", Integer.valueOf(1));
      }
      MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
      msfCore.addRespToQuque(null, localFromServiceMsg);
      return;
    }
    QLog.d(tag, 1, "onRecvFirstResp, stop notify by standby");
  }
  
  public void registerSignalStrengthsChanged(Context paramContext)
  {
    Object localObject = new a(null);
    ((TelephonyManager)paramContext.getSystemService("phone")).listen((PhoneStateListener)localObject, 256);
    localObject = new b(null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.RSSI_CHANGED");
    paramContext.registerReceiver((BroadcastReceiver)localObject, localIntentFilter);
  }
  
  /* Error */
  public void setConnInfo(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 849	com/tencent/mobileqq/msf/core/a/d:c	()Ljava/lang/String;
    //   5: astore 5
    //   7: invokestatic 851	com/tencent/mobileqq/msf/core/a/d:b	()Ljava/lang/String;
    //   10: astore 6
    //   12: getstatic 81	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   15: iload_1
    //   16: if_icmpne +247 -> 263
    //   19: invokestatic 483	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +54 -> 76
    //   25: getstatic 59	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:tag	Ljava/lang/String;
    //   28: iconst_2
    //   29: new 200	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 853
    //   39: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokestatic 855	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:isNetSupport	()Z
    //   45: invokevirtual 488	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   48: ldc_w 857
    //   51: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: iload_1
    //   55: invokevirtual 507	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   58: ldc_w 859
    //   61: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: getstatic 81	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   67: invokevirtual 507	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload 5
    //   78: ifnull +90 -> 168
    //   81: getstatic 246	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   84: ifnull +14 -> 98
    //   87: getstatic 246	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   90: aload 5
    //   92: invokevirtual 863	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   95: ifne +73 -> 168
    //   98: invokestatic 483	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq +43 -> 144
    //   104: getstatic 59	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:tag	Ljava/lang/String;
    //   107: iconst_2
    //   108: new 200	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   115: ldc_w 865
    //   118: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload 5
    //   123: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: ldc_w 867
    //   129: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: getstatic 246	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   135: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: aload 5
    //   146: putstatic 246	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   149: getstatic 136	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   152: ifnull +16 -> 168
    //   155: getstatic 136	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   158: getfield 871	com/tencent/mobileqq/msf/core/MsfCore:ssoListManager	Lcom/tencent/mobileqq/msf/core/a/d;
    //   161: invokevirtual 872	com/tencent/mobileqq/msf/core/a/d:f	()V
    //   164: aload_0
    //   165: invokespecial 874	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:onWifiConnChanged	()V
    //   168: aload 6
    //   170: ifnull +90 -> 260
    //   173: getstatic 876	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   176: ifnull +14 -> 190
    //   179: getstatic 876	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   182: aload 6
    //   184: invokevirtual 863	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   187: ifne +73 -> 260
    //   190: invokestatic 483	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +43 -> 236
    //   196: ldc_w 878
    //   199: iconst_2
    //   200: new 200	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   207: ldc_w 880
    //   210: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload 6
    //   215: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: ldc_w 882
    //   221: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: getstatic 876	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   227: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload 6
    //   238: putstatic 876	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   241: getstatic 136	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   244: ifnull +12 -> 256
    //   247: getstatic 136	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   250: getfield 871	com/tencent/mobileqq/msf/core/MsfCore:ssoListManager	Lcom/tencent/mobileqq/msf/core/a/d;
    //   253: invokevirtual 883	com/tencent/mobileqq/msf/core/a/d:e	()V
    //   256: aload_0
    //   257: invokespecial 885	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:onMobileConnChnaged	()V
    //   260: aload_0
    //   261: monitorexit
    //   262: return
    //   263: iload_1
    //   264: ifle +246 -> 510
    //   267: iconst_1
    //   268: invokestatic 887	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:setNetSupport	(Z)V
    //   271: getstatic 98	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:lastConnSuccWithoutNet	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   274: invokevirtual 296	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   277: ifeq +74 -> 351
    //   280: new 889	java/util/HashMap
    //   283: dup
    //   284: invokespecial 890	java/util/HashMap:<init>	()V
    //   287: astore 7
    //   289: aload 7
    //   291: ldc_w 892
    //   294: invokestatic 189	java/lang/System:currentTimeMillis	()J
    //   297: getstatic 100	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:lastConnSuccWithoutNetTime	J
    //   300: lsub
    //   301: ldc2_w 445
    //   304: ldiv
    //   305: invokestatic 666	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   308: invokeinterface 897 3 0
    //   313: pop
    //   314: aload 7
    //   316: ldc_w 899
    //   319: iload_1
    //   320: invokestatic 436	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   323: invokeinterface 897 3 0
    //   328: pop
    //   329: getstatic 136	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   332: invokevirtual 521	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/m;
    //   335: ldc_w 901
    //   338: iconst_0
    //   339: lconst_0
    //   340: lconst_0
    //   341: aload 7
    //   343: iconst_0
    //   344: iconst_0
    //   345: invokevirtual 904	com/tencent/mobileqq/msf/core/c/m:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   348: invokestatic 906	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:resetLastConnSuccWithoutNet	()V
    //   351: getstatic 59	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:tag	Ljava/lang/String;
    //   354: iconst_1
    //   355: new 200	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   362: ldc_w 908
    //   365: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: getstatic 81	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   371: invokestatic 910	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:getNetStatusMsg	(I)Ljava/lang/String;
    //   374: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: ldc_w 912
    //   380: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: iload_1
    //   384: invokestatic 910	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:getNetStatusMsg	(I)Ljava/lang/String;
    //   387: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   396: aload_0
    //   397: invokevirtual 914	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:checkWifiSignalStrengths	()V
    //   400: iload_1
    //   401: iconst_2
    //   402: if_icmpeq +8 -> 410
    //   405: iload_1
    //   406: iconst_3
    //   407: if_icmpne +375 -> 782
    //   410: iconst_1
    //   411: istore 4
    //   413: iload 4
    //   415: invokestatic 916	com/tencent/mobileqq/msf/core/c/i:a	(Z)V
    //   418: ldc 102
    //   420: invokestatic 918	com/tencent/mobileqq/msf/core/s:c	(Ljava/lang/String;)V
    //   423: iconst_0
    //   424: invokestatic 920	com/tencent/mobileqq/msf/core/s:d	(I)V
    //   427: iconst_0
    //   428: istore_3
    //   429: iload_1
    //   430: iconst_1
    //   431: if_icmpne +362 -> 793
    //   434: iload_3
    //   435: istore_2
    //   436: getstatic 81	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   439: ifeq +13 -> 452
    //   442: getstatic 81	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   445: bipush 254
    //   447: if_icmpne +103 -> 550
    //   450: iload_3
    //   451: istore_2
    //   452: iload_1
    //   453: putstatic 81	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   456: aload_0
    //   457: invokespecial 874	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:onWifiConnChanged	()V
    //   460: aload_0
    //   461: invokespecial 885	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:onMobileConnChnaged	()V
    //   464: iload_2
    //   465: ifeq +7 -> 472
    //   468: aload_0
    //   469: invokespecial 922	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:closeNowConn	()V
    //   472: iload_1
    //   473: ifle -213 -> 260
    //   476: getstatic 136	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   479: ifnull -219 -> 260
    //   482: getstatic 136	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   485: getfield 746	com/tencent/mobileqq/msf/core/MsfCore:pushManager	Lcom/tencent/mobileqq/msf/core/push/f;
    //   488: ifnull -228 -> 260
    //   491: getstatic 136	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   494: getfield 746	com/tencent/mobileqq/msf/core/MsfCore:pushManager	Lcom/tencent/mobileqq/msf/core/push/f;
    //   497: invokevirtual 924	com/tencent/mobileqq/msf/core/push/f:c	()V
    //   500: goto -240 -> 260
    //   503: astore 5
    //   505: aload_0
    //   506: monitorexit
    //   507: aload 5
    //   509: athrow
    //   510: iconst_0
    //   511: invokestatic 887	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:setNetSupport	(Z)V
    //   514: goto -163 -> 351
    //   517: astore 7
    //   519: getstatic 59	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:tag	Ljava/lang/String;
    //   522: iconst_1
    //   523: new 200	java/lang/StringBuilder
    //   526: dup
    //   527: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   530: ldc_w 926
    //   533: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: aload 7
    //   538: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   541: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   547: goto -129 -> 418
    //   550: getstatic 81	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   553: iconst_2
    //   554: if_icmpeq +12 -> 566
    //   557: iload_3
    //   558: istore_2
    //   559: getstatic 81	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   562: iconst_3
    //   563: if_icmpne -111 -> 452
    //   566: aload 6
    //   568: ifnull +220 -> 788
    //   571: getstatic 876	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   574: ifnull +14 -> 588
    //   577: getstatic 876	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   580: aload 6
    //   582: invokevirtual 863	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   585: ifne +203 -> 788
    //   588: invokestatic 483	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   591: ifeq +43 -> 634
    //   594: ldc_w 878
    //   597: iconst_2
    //   598: new 200	java/lang/StringBuilder
    //   601: dup
    //   602: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   605: ldc_w 928
    //   608: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: aload 6
    //   613: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: ldc_w 882
    //   619: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: getstatic 876	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   625: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   631: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   634: aload 6
    //   636: putstatic 876	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   639: getstatic 136	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   642: ifnull +146 -> 788
    //   645: getstatic 136	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   648: getfield 871	com/tencent/mobileqq/msf/core/MsfCore:ssoListManager	Lcom/tencent/mobileqq/msf/core/a/d;
    //   651: invokevirtual 883	com/tencent/mobileqq/msf/core/a/d:e	()V
    //   654: goto +134 -> 788
    //   657: iload_3
    //   658: istore_2
    //   659: getstatic 81	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   662: ifeq -210 -> 452
    //   665: iload_3
    //   666: istore_2
    //   667: getstatic 81	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   670: bipush 254
    //   672: if_icmpeq -220 -> 452
    //   675: iload_3
    //   676: istore_2
    //   677: getstatic 81	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   680: iconst_1
    //   681: if_icmpne -229 -> 452
    //   684: aload 5
    //   686: ifnull +86 -> 772
    //   689: getstatic 246	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   692: ifnull +14 -> 706
    //   695: getstatic 246	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   698: aload 5
    //   700: invokevirtual 863	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   703: ifne +69 -> 772
    //   706: invokestatic 483	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   709: ifeq +43 -> 752
    //   712: getstatic 59	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:tag	Ljava/lang/String;
    //   715: iconst_2
    //   716: new 200	java/lang/StringBuilder
    //   719: dup
    //   720: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   723: ldc_w 865
    //   726: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: aload 5
    //   731: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: ldc_w 867
    //   737: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: getstatic 246	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   743: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   749: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   752: aload 5
    //   754: putstatic 246	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   757: getstatic 136	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   760: ifnull +12 -> 772
    //   763: getstatic 136	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   766: getfield 871	com/tencent/mobileqq/msf/core/MsfCore:ssoListManager	Lcom/tencent/mobileqq/msf/core/a/d;
    //   769: invokevirtual 872	com/tencent/mobileqq/msf/core/a/d:f	()V
    //   772: iconst_1
    //   773: istore_2
    //   774: goto -322 -> 452
    //   777: iconst_1
    //   778: istore_2
    //   779: goto -327 -> 452
    //   782: iconst_0
    //   783: istore 4
    //   785: goto -372 -> 413
    //   788: iconst_1
    //   789: istore_2
    //   790: goto -338 -> 452
    //   793: iload_1
    //   794: iconst_2
    //   795: if_icmpeq -138 -> 657
    //   798: iload_1
    //   799: iconst_3
    //   800: if_icmpne -23 -> 777
    //   803: goto -146 -> 657
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	806	0	this	NetConnInfoCenterImpl
    //   0	806	1	paramInt	int
    //   435	355	2	i	int
    //   428	248	3	j	int
    //   411	373	4	bool	boolean
    //   5	140	5	str1	String
    //   503	250	5	localObject	Object
    //   10	625	6	str2	String
    //   287	55	7	localHashMap	java.util.HashMap
    //   517	20	7	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   2	76	503	finally
    //   81	98	503	finally
    //   98	144	503	finally
    //   144	168	503	finally
    //   173	190	503	finally
    //   190	236	503	finally
    //   236	256	503	finally
    //   256	260	503	finally
    //   267	351	503	finally
    //   351	400	503	finally
    //   413	418	503	finally
    //   418	427	503	finally
    //   436	450	503	finally
    //   452	464	503	finally
    //   468	472	503	finally
    //   476	500	503	finally
    //   510	514	503	finally
    //   519	547	503	finally
    //   550	557	503	finally
    //   559	566	503	finally
    //   571	588	503	finally
    //   588	634	503	finally
    //   634	654	503	finally
    //   659	665	503	finally
    //   667	675	503	finally
    //   677	684	503	finally
    //   689	706	503	finally
    //   706	752	503	finally
    //   752	772	503	finally
    //   413	418	517	java/io/IOException
  }
  
  private class a
    extends PhoneStateListener
  {
    private a() {}
    
    public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
    {
      super.onSignalStrengthsChanged(paramSignalStrength);
      int i = paramSignalStrength.getCdmaDbm();
      NetConnInfoCenterImpl.this.lastCdmaStrenght = i;
      int j = paramSignalStrength.getGsmSignalStrength();
      i = j;
      if (j == 99) {
        i = -3;
      }
      NetConnInfoCenterImpl.this.lastGsmStrength = i;
      NetConnInfoCenterImpl.this.checkWifiSignalStrengths();
    }
  }
  
  private class b
    extends BroadcastReceiver
  {
    private b() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      NetConnInfoCenterImpl.this.checkWifiSignalStrengths();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl
 * JD-Core Version:    0.7.0.1
 */