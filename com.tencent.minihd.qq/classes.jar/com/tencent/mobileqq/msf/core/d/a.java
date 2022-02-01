package com.tencent.mobileqq.msf.core.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl;
import com.tencent.mobileqq.msf.core.c.m;
import com.tencent.mobileqq.msf.core.net.h;
import com.tencent.mobileqq.msf.core.s;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.InetSocketAddress;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class a
  extends BroadcastReceiver
{
  public static final String a = "storeflow";
  public static final String b = "key_storeflow";
  private static final String c = "StandbyModeManager";
  private static final int h = 10001;
  private static final String n = "standbyMode";
  private static final String o = "enterTime";
  private static final String p = "enterTimeSys";
  private static final String q = "contiousTime";
  private static final String r = "disconnCount";
  private static final String x = "testStartTime";
  private static final String y = "testFinished";
  private static final String z = "testSeqNo";
  private Handler A = new b(this);
  private AtomicBoolean d = new AtomicBoolean(false);
  private AtomicBoolean e = new AtomicBoolean(false);
  private AtomicInteger f = new AtomicInteger(0);
  private HashSet g = new HashSet();
  private MsfCore i;
  private c j;
  private long k = 0L;
  private long l = 0L;
  private String m = "0";
  private long s = 0L;
  private long t = 0L;
  private long u = 0L;
  private boolean v = true;
  private boolean w = false;
  
  public a(MsfCore paramMsfCore)
  {
    this.i = paramMsfCore;
    l();
    this.j = new c(paramMsfCore);
    m();
    if (!q()) {
      o();
    }
    k();
    a();
  }
  
  private void c(String paramString)
  {
    if (this.d.get())
    {
      QLog.d("StandbyModeManager", 1, "exitStandbyMode");
      long l1 = SystemClock.elapsedRealtime();
      long l2 = System.currentTimeMillis();
      if ((this.i.sender.a.b()) && (this.e.get()))
      {
        QLog.d("StandbyModeManager", 1, "notifyConnOpened when exitStandbyMode");
        NetConnInfoCenter.onConnOpened(this.i.sender.a.r().toString(), this.i.nowSocketConnAdd);
        if (this.i.sender.a.s())
        {
          QLog.d("StandbyModeManager", 1, "notifyFirestMsgRecved when exitStandbyMode");
          NetConnInfoCenter.onRecvFirstResp();
        }
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("account", j());
      localHashMap.put("contious", String.valueOf(l1 - this.k));
      localHashMap.put("disconnCount", String.valueOf(this.f.get()));
      localHashMap.put("notifyReconnect", String.valueOf(this.e.get()));
      localHashMap.put("exitReason", paramString);
      localHashMap.put("start", String.valueOf(this.l));
      localHashMap.put("end", String.valueOf(l2));
      this.i.getStatReporter().a("dim.Msf.StandbyModeExit", true, 0L, 0L, localHashMap, false, false);
      this.j.a();
      BaseApplication.getContext().getSharedPreferences("standbyMode", 0).edit().putLong("enterTime", 0L).putLong("enterTimeSys", 0L).putLong("enterTimeSys", 0L).putInt("disconnCount", 0).commit();
      this.k = 0L;
      this.m = "0";
      this.f.set(0);
      this.e.set(false);
      this.d.set(false);
    }
  }
  
  private void k()
  {
    try
    {
      if (com.tencent.mobileqq.msf.core.a.a.ai())
      {
        SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("standbyMode", 0);
        long l1 = localSharedPreferences.getLong("testStartTime", 0L);
        this.v = localSharedPreferences.getBoolean("testFinished", false);
        if (!this.v)
        {
          if (l1 > 0L) {
            this.s = l1;
          }
          for (;;)
          {
            this.t = (this.s + 259200000L);
            this.u = (this.t + 172800000L);
            return;
            Calendar localCalendar = Calendar.getInstance();
            localCalendar.set(6, localCalendar.get(6) + 1);
            localCalendar.set(11, 0);
            localCalendar.set(12, 0);
            localCalendar.set(13, 0);
            localCalendar.set(14, 0);
            this.s = localCalendar.getTimeInMillis();
            localSharedPreferences.edit().putLong("testStartTime", this.s).commit();
            localSharedPreferences.edit().putInt("testSeqNo", 0).commit();
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("StandbyModeManager", 1, "initStandbyTest exception " + localException.toString());
    }
  }
  
  private void l()
  {
    this.g.add("GrayUinPro.Check");
    this.g.add("cmd_openConn");
    this.g.add("StatSvc.register");
    this.g.add("StatSvc.SimpleGet");
    this.g.add("wtlogin.");
    this.g.add("login.");
    this.g.add("Heartbeat.Alive");
    this.g.add("ConfigPushSvc.PushResp");
    this.g.add("SSO.HelloPush");
    this.g.add("MessageSvc.");
    this.g.add("OnlinePush.");
    this.g.add("PbMessageSvc.");
    this.g.add("ImgStore.GroupPicUp");
    this.g.add("ImgStore.GroupPicDown");
    this.g.add("PttStore.GroupPttUp");
    this.g.add("PttStore.GroupPttDown");
    this.g.add("LongConn.OffPicUp");
    this.g.add("LongConn.OffPicDown");
    this.g.add("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500");
    this.g.add("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_DOWNLOAD-1200");
    this.g.add("OfflineFilleHandleSvr.pb_ftnPtt_CMD_REQ_APPLY_DOWNLOAD-1200");
    this.g.add("MultiMsg.ApplyUp");
    this.g.add("MultiMsg.ApplyDown");
    this.g.add("PttCenterSvr.ShortVideoUpReq");
    this.g.add("PttCenterSvr.ShortVideoDownReq");
    this.g.add("PttCenterSvr.GroupShortVideoUpReq");
    this.g.add("PttCenterSvr.GroupShortVideoDownReq");
    this.g.add("EqqAccountSvc.get_eqq_detail");
    this.g.add("hrtxformqq.getUsrSimpleInfo");
    this.g.add("PubAccountSvc.get_detail_info");
    this.g.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600");
    this.g.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700");
    this.g.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800");
    this.g.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200");
    this.g.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_FILE_QUERY-1400");
    this.g.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100");
    this.g.add("VideoCCSvc.PutInfo");
    this.g.add("SharpSvr.s2cack");
    this.g.add("SharpSvr.c2s");
    this.g.add("MultiVideo.s2cack");
    this.g.add("SharpSvr.s2cackMSF");
    this.g.add("VideoSvc.Ack");
    this.g.add("QQWifiSvc.AvailQQWiFi");
    this.g.add("QQWifiSvc.QQWiFiJarInfo");
    this.g.add("QQWifiSvc.wifiReport");
    this.g.add("QQWifiSvc.getAccount");
    this.g.add("QQWifiSvc.ReportWiFiStatus");
    this.g.add("QQWifiSvc.getNearWiFi");
    this.g.add("QQWifiSvc.getNearbyAvailWiFiInfo");
    a(com.tencent.mobileqq.msf.core.a.a.ae());
  }
  
  private void m()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("standbyMode", 0);
    long l1 = localSharedPreferences.getLong("enterTime", 0L);
    long l2 = localSharedPreferences.getLong("enterTimeSys", 0L);
    long l3 = localSharedPreferences.getLong("contiousTime", 0L);
    int i1 = localSharedPreferences.getInt("disconnCount", 0);
    if ((l1 > 0L) && (l2 > 0L))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("account", j());
      localHashMap.put("contious", String.valueOf(l3));
      localHashMap.put("disconnCount", String.valueOf(i1));
      localHashMap.put("notifyReconnect", String.valueOf(false));
      localHashMap.put("exitReason", "crashed");
      localHashMap.put("start", String.valueOf(this.l));
      localHashMap.put("end", String.valueOf(l2 + l3));
      this.i.getStatReporter().a("dim.Msf.StandbyModeExit", true, 0L, 0L, localHashMap, false, false);
    }
    localSharedPreferences.edit().putLong("enterTime", 0L).putLong("enterTimeSys", 0L).putLong("enterTimeSys", 0L).putInt("disconnCount", 0).commit();
  }
  
  private void n()
  {
    this.A.removeMessages(10001);
    c("screeOn");
  }
  
  private void o()
  {
    if (!this.d.get())
    {
      if (r())
      {
        this.A.removeMessages(10001);
        if (!s())
        {
          this.A.sendEmptyMessageDelayed(10001, com.tencent.mobileqq.msf.core.a.a.n());
          return;
        }
        QLog.d("StandbyModeManager", 1, "stop try start standby by lockScreenMsg ON when screenoff");
        return;
      }
      QLog.d("StandbyModeManager", 1, "stop try start standby by mobileOff ON when screenoff");
      return;
    }
    QLog.d("StandbyModeManager", 1, "stop try start standby by alreadyActive ON when screenoff");
  }
  
  private void p()
  {
    if (this.d.compareAndSet(false, true))
    {
      QLog.d("StandbyModeManager", 1, "enterStandbyMode");
      this.m = j();
      this.k = SystemClock.elapsedRealtime();
      this.l = System.currentTimeMillis();
      HashMap localHashMap = new HashMap();
      localHashMap.put("account", this.m);
      this.i.getStatReporter().a("dim.Msf.StandbyModeEnter", true, 0L, 0L, localHashMap, false, false);
      BaseApplication.getContext().getSharedPreferences("standbyMode", 0).edit().putLong("enterTime", this.k).putLong("enterTimeSys", this.l).putLong("enterTimeSys", 0L).putInt("disconnCount", 0).commit();
    }
  }
  
  private boolean q()
  {
    return ((PowerManager)BaseApplication.getContext().getSystemService("power")).isScreenOn();
  }
  
  private boolean r()
  {
    return NetConnInfoCenterImpl.isMobileConn();
  }
  
  private boolean s()
  {
    String str = this.i.getAccountCenter().i();
    if ((TextUtils.isEmpty(str)) || ("0".equals(str)))
    {
      QLog.d("StandbyModeManager", 1, "can't know current main account");
      return true;
    }
    SettingCloneUtil.clearAllSetting();
    return SettingCloneUtil.readValue(BaseApplication.getContext(), str, "锁屏显示消息弹框", "qqsetting_lock_screen_whenexit_key", true);
  }
  
  public void a()
  {
    long l1;
    Object localObject;
    try
    {
      if ((!com.tencent.mobileqq.msf.core.a.a.ai()) || (this.v)) {
        break label248;
      }
      l1 = System.currentTimeMillis();
      if ((l1 <= 0L) || (this.s <= 0L)) {
        return;
      }
      if (this.t <= 0L) {
        return;
      }
      if (l1 >= this.u)
      {
        this.w = false;
        this.v = true;
        BaseApplication.getContext().getSharedPreferences("standbyMode", 0).edit().putBoolean("testFinished", true).commit();
        String str = BaseApplication.getContext().getSharedPreferences("storeflow", 0).getString("key_storeflow", null);
        localObject = new HashMap();
        ((HashMap)localObject).put("report_account", this.i.getAccountCenter().i());
        if (str == null) {
          return;
        }
        ((HashMap)localObject).put("flow", str);
        QLog.d("StandbyModeManager", 1, "standby get flow:" + str);
        this.i.getStatReporter().a("ReportStandbyAllFlow", true, 0L, 0L, (Map)localObject, false, false);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.d("StandbyModeManager", 1, "onStandbyTestCheck exception " + localException.toString());
      return;
    }
    if (l1 >= this.t)
    {
      this.w = true;
      return;
      label248:
      if ((com.tencent.mobileqq.msf.core.a.a.ai()) && (this.v))
      {
        int i1 = com.tencent.mobileqq.msf.core.a.a.aj();
        SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("standbyMode", 0);
        if (i1 > localSharedPreferences.getInt("testSeqNo", 0))
        {
          localObject = Calendar.getInstance();
          ((Calendar)localObject).set(6, ((Calendar)localObject).get(6) + 1);
          ((Calendar)localObject).set(11, 0);
          ((Calendar)localObject).set(12, 0);
          ((Calendar)localObject).set(13, 0);
          ((Calendar)localObject).set(14, 0);
          this.s = ((Calendar)localObject).getTimeInMillis();
          localSharedPreferences.edit().putLong("testStartTime", this.s).commit();
          localSharedPreferences.edit().putInt("testSeqNo", i1).commit();
          this.t = (this.s + 259200000L);
          this.u = (this.t + 172800000L);
          this.v = false;
          localSharedPreferences.edit().putBoolean("testFinished", false).commit();
        }
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    this.j.a(paramToServiceMsg);
  }
  
  public void a(String[] paramArrayOfString)
  {
    if ((this.g != null) && (paramArrayOfString != null))
    {
      int i2 = paramArrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str = paramArrayOfString[i1];
        this.g.add(str);
        i1 += 1;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      int i1;
      do
      {
        return false;
        if (this.g.contains(paramString)) {
          return true;
        }
        i1 = paramString.indexOf(".");
      } while (i1 <= 0);
      paramString = paramString.substring(0, i1) + ".";
    } while (!this.g.contains(paramString));
    return true;
  }
  
  public long b()
  {
    return this.s;
  }
  
  public void b(ToServiceMsg paramToServiceMsg)
  {
    this.j.b(paramToServiceMsg);
  }
  
  public boolean b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || ("0".equals(paramString)))
    {
      QLog.d("StandbyModeManager", 1, "can't know current main account");
      return true;
    }
    SettingCloneUtil.clearAllSetting();
    return SettingCloneUtil.readValue(BaseApplication.getContext(), paramString, "锁屏显示消息弹框", "qqsetting_lock_screen_whenexit_key", true);
  }
  
  public void c()
  {
    if (this.d.get()) {
      BaseApplication.getContext().getSharedPreferences("standbyMode", 0).edit().putLong("contiousTime", this.k - SystemClock.elapsedRealtime()).putInt("disconnCount", this.f.get()).commit();
    }
  }
  
  public boolean d()
  {
    return (com.tencent.mobileqq.msf.core.a.a.af()) && (this.d.get()) && (!this.w);
  }
  
  public HashSet e()
  {
    return this.g;
  }
  
  public void f()
  {
    QLog.d("StandbyModeManager", 1, "onMobileOn");
    a();
    if (!this.d.get())
    {
      if (!q())
      {
        this.A.removeMessages(10001);
        if (!s())
        {
          this.A.obtainMessage().obj = this.i.getAccountCenter().i();
          this.A.sendEmptyMessageDelayed(10001, com.tencent.mobileqq.msf.core.a.a.n());
          return;
        }
        QLog.d("StandbyModeManager", 1, "stop try start standby by lockScreenMsg ON when mobileOn");
        return;
      }
      QLog.d("StandbyModeManager", 1, "stop try start standby by screenOn ON when mobileOn");
      return;
    }
    QLog.d("StandbyModeManager", 1, "stop try start standby by alreadyActive ON when mobileOn");
  }
  
  public void g()
  {
    a();
    QLog.d("StandbyModeManager", 1, "onWifiOn");
    this.A.removeMessages(10001);
    c("wifiOn");
  }
  
  public void h()
  {
    if (this.d.get())
    {
      QLog.d("StandbyModeManager", 1, "onConnClosed");
      this.f.incrementAndGet();
    }
  }
  
  public void i()
  {
    if (this.d.get())
    {
      QLog.d("StandbyModeManager", 1, "onConnOpened");
      this.e.compareAndSet(false, true);
    }
  }
  
  public String j()
  {
    if ((this.i.getAccountCenter() != null) && (this.i.getAccountCenter().i() != null) && (this.i.getAccountCenter().i().length() >= 4)) {
      return this.i.getAccountCenter().i();
    }
    return "0";
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      QLog.d("StandbyModeManager", 1, "onReceive intent==null");
    }
    do
    {
      return;
      paramContext = paramIntent.getAction();
      if ("android.intent.action.SCREEN_ON".equals(paramContext))
      {
        a();
        n();
        return;
      }
    } while (!"android.intent.action.SCREEN_OFF".equals(paramContext));
    a();
    o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.d.a
 * JD-Core Version:    0.7.0.1
 */