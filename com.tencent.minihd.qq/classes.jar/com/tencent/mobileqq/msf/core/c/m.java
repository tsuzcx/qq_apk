package com.tencent.mobileqq.msf.core.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import com.tencent.beacon.event.UserAction;
import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.feedback.eup.CrashStrategyBean;
import com.tencent.feedback.upload.UploadHandleListener;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl;
import com.tencent.mobileqq.msf.core.d;
import com.tencent.mobileqq.msf.core.l;
import com.tencent.mobileqq.msf.core.net.g;
import com.tencent.mobileqq.msf.core.net.h;
import com.tencent.mobileqq.msf.core.net.h.a;
import com.tencent.mobileqq.msf.core.net.q;
import com.tencent.mobileqq.msf.core.s;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class m
{
  static final String A = "param_NowLocalIp";
  static final String B = "param_sendLocalIp";
  static final String C = "param_Detail";
  static final String D = "param_tokenType";
  public static final String E = "param_reportTime";
  static final String F = "param_LoginConnect";
  static final String G = "param_connectContinuanceTime";
  static HashSet I = null;
  public static volatile boolean J = false;
  static long K = 0L;
  static long L = 0L;
  static AtomicBoolean M = new AtomicBoolean(false);
  static Thread N = new n("MsfCheckDeepSleepThread");
  private static LinkedBlockingQueue O = new LinkedBlockingQueue(100);
  private static ConcurrentHashMap P = new ConcurrentHashMap();
  private static long Q = 3600000L;
  static final String a = "MSF.C.StatReport";
  public static final String b = "param_Reason";
  public static final String c = "param_connecttrycount";
  static final String d = "param_sendTime";
  static final String e = "param_connResult";
  static final String f = "param_connFailReason";
  static final String g = "param_connNetType";
  static final String h = "param_connOpenNetType";
  static final String i = "param_connElapseTime";
  static final String j = "param_localIp";
  static final String k = "param_NetworkStatus";
  static final String l = "param_ssoInfo";
  static final String m = "param_liveTime";
  static final String n = "param_sendBytes";
  static final String o = "param_recvBytes";
  static final String p = "param_runStatus";
  static final String q = "param_deepSleep";
  static final String r = "param_runStatus_new";
  static final String s = "param_isDefaultList";
  static final String t = "param_isConnected";
  static final String u = "param_uin";
  static final String v = "param_src";
  static final String w = "param_imei";
  static final String x = "param_FailCode";
  static final String y = "param_SsoServerIp";
  static final String z = "param_GatewayIp";
  MsfCore H;
  
  public m(MsfCore paramMsfCore)
  {
    this.H = paramMsfCore;
    i.a(this, paramMsfCore);
    Q = com.tencent.mobileqq.msf.core.a.a.l();
  }
  
  public static byte a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    int i2 = 0;
    int i3;
    label26:
    int i4;
    if (g())
    {
      i1 = 1;
      i3 = (byte)i1;
      if (!f()) {
        break label246;
      }
      i1 = 2;
      i4 = (byte)i1;
      boolean bool = paramBoolean;
      if (!paramBoolean)
      {
        bool = paramBoolean;
        if (paramLong1 <= paramLong2)
        {
          Iterator localIterator = P.entrySet().iterator();
          Map.Entry localEntry;
          do
          {
            bool = paramBoolean;
            if (!localIterator.hasNext()) {
              break;
            }
            localEntry = (Map.Entry)localIterator.next();
          } while ((paramLong1 >= ((Long)localEntry.getValue()).longValue()) || (paramLong2 <= ((Long)localEntry.getKey()).longValue()));
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.StatReport", 2, "find deep sleep. report time:[" + paramLong1 + ", " + paramLong2 + "], sleep time:[" + localEntry.getKey() + ", " + localEntry.getValue() + "]");
          }
          bool = true;
        }
      }
      if (!bool) {
        break label252;
      }
    }
    label246:
    label252:
    for (int i1 = 4;; i1 = 0)
    {
      int i5 = (byte)i1;
      i1 = i2;
      if (h()) {
        i1 = 8;
      }
      return (byte)(i5 | i3 | i4 | (byte)i1);
      i1 = 0;
      break;
      i1 = 0;
      break label26;
    }
  }
  
  public static long a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramToServiceMsg != null)
    {
      l1 = l2;
      if (paramToServiceMsg.getWupBuffer() != null) {
        l1 = 0L + paramToServiceMsg.getWupBuffer().length;
      }
    }
    l2 = l1;
    if (paramFromServiceMsg != null)
    {
      l2 = l1;
      if (paramFromServiceMsg.getWupBuffer() != null) {
        l2 = l1 + paramFromServiceMsg.getWupBuffer().length;
      }
    }
    return l2;
  }
  
  private String a(d paramd)
  {
    if (paramd == null) {
      return "null EndpointKey";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramd.b()).append("://");
    localStringBuilder.append(paramd.c()).append(":").append(paramd.d());
    return localStringBuilder.toString();
  }
  
  public static long b(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (!paramBoolean) {}
    while (paramLong1 >= paramLong2) {
      return 0L;
    }
    Iterator localIterator = P.entrySet().iterator();
    long l1 = 0L;
    Map.Entry localEntry;
    if (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      if ((paramLong1 >= ((Long)localEntry.getKey()).longValue()) && (paramLong1 <= ((Long)localEntry.getValue()).longValue()))
      {
        if (paramLong2 <= ((Long)localEntry.getValue()).longValue()) {
          return paramLong2 - paramLong1;
        }
        l1 = ((Long)localEntry.getValue()).longValue() + l1 - paramLong1;
      }
    }
    for (;;)
    {
      break;
      if (paramLong1 < ((Long)localEntry.getKey()).longValue()) {
        if ((paramLong2 >= ((Long)localEntry.getKey()).longValue()) && (paramLong2 <= ((Long)localEntry.getValue()).longValue()))
        {
          l1 = l1 + paramLong2 - ((Long)localEntry.getKey()).longValue();
        }
        else if (paramLong2 > ((Long)localEntry.getValue()).longValue())
        {
          l1 = l1 + ((Long)localEntry.getValue()).longValue() - ((Long)localEntry.getKey()).longValue();
          continue;
          return l1;
        }
      }
    }
  }
  
  static void b(boolean paramBoolean)
  {
    if (!O.isEmpty())
    {
      StringBuilder localStringBuilder;
      Map localMap;
      for (;;)
      {
        try
        {
          RdmReq localRdmReq = (RdmReq)O.take();
          if (localRdmReq == null) {
            break;
          }
          localStringBuilder = new StringBuilder();
          localMap = localRdmReq.params;
          if (localMap == null) {
            break label262;
          }
          long l1 = Long.parseLong((String)localMap.get("param_reportTime"));
          long l2 = l1 - localRdmReq.elapse;
          int i1 = a(paramBoolean, l2, l1);
          localMap.put("param_runStatus", String.valueOf(i1));
          if ((i1 & 0x4) != 0) {
            break label257;
          }
          bool = false;
          localMap.put("param_deepSleep", String.valueOf(b(bool, l2, l1)));
          localMap.remove("param_reportTime");
          Iterator localIterator = localMap.entrySet().iterator();
          if (!localIterator.hasNext()) {
            break label262;
          }
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          localStringBuilder.append("k=").append((String)localEntry.getKey()).append(", v=").append((String)localEntry.getValue()).append("; ");
          continue;
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        catch (Exception localException) {}
        QLog.w("MSF.C.StatReport", 2, "report RQD error " + localException, localException);
        break;
        label257:
        boolean bool = true;
      }
      label262:
      if (localException.isMerge) {
        UserAction.onMergeUserAction(localException.eventName, localException.isSucceed, localException.elapse, localException.size, localException.isRealTime, new com.tencent.beacon.event.c[0]);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("MSF.C.StatReport", 2, "report RQD IMEI:" + l.d() + " eventName=" + localException.eventName + " isSucceed:" + localException.isSucceed + " elapse:" + localException.elapse + " size:" + localException.size + " isRealTime:" + localException.isRealTime + " isMerge:" + localException.isMerge + " params:" + localStringBuilder.toString());
        break;
        UserAction.onUserAction(localException.eventName, localException.isSucceed, localException.elapse, localException.size, localMap, localException.isRealTime);
      }
    }
  }
  
  private static boolean f()
  {
    return !MsfSdkUtils.isTopActivity(BaseApplication.getContext());
  }
  
  private static boolean g()
  {
    return !MsfSdkUtils.isScreenOn(BaseApplication.getContext());
  }
  
  private static boolean h()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      if (Settings.System.getInt(BaseApplication.getContext().getContentResolver(), "airplane_mode_on", 0) == 0) {}
    }
    while (Settings.System.getInt(BaseApplication.getContext().getContentResolver(), "airplane_mode_on", 0) != 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void a()
  {
    boolean bool = false;
    if (!M.get()) {}
    try
    {
      if ((com.tencent.mobileqq.msf.core.m.a()) && (BaseApplication.getContext().checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
        UserAction.initUserAction(BaseApplication.getContext(), true);
      }
      Object localObject = new o(this);
      if ((com.tencent.mobileqq.msf.core.m.a()) && (BaseApplication.getContext().checkSelfPermission("android.permission.READ_PHONE_STATE") == 0))
      {
        CrashStrategyBean localCrashStrategyBean = new CrashStrategyBean();
        localCrashStrategyBean.setMaxStackFrame(6);
        CrashReport.initCrashReport(BaseApplication.getContext(), (CrashHandleListener)localObject, new a(), true, localCrashStrategyBean);
        UserAction.closeUseInfoEvent();
        UserAction.setAutoLaunchEventUsable(true);
        localObject = BaseApplication.getContext().getDir("tombs", 0).getAbsolutePath();
        CrashReport.initNativeCrashReport(BaseApplication.getContext(), (String)localObject, true);
        N.start();
        M.set(true);
        if (l.g != 0) {
          break label174;
        }
      }
      for (;;)
      {
        a("dim.Msf.IMEIReading", bool, l.g, 0L, null, false, false);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.StatReport", 2, "init RQD finished");
        }
        return;
        label174:
        bool = true;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.w("MSF.C.StatReport", 1, "init RQD error " + localThrowable, localThrowable);
    }
  }
  
  public void a(long paramLong1, int paramInt, long paramLong2)
  {
    if (NetConnInfoCenterImpl.isWifiOrMobileConn())
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      a("dim.Msf.TokenExpired", false, paramLong1, paramLong2, localHashMap, false, false);
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    String str = "" + paramLong;
    str = str + "|";
    paramString1 = str + paramString1;
    paramString1 = paramString1 + "|";
    paramString1 = paramString1 + paramString2;
    paramString2 = new HashMap();
    paramString2.put("param_connectContinuanceTime", paramString1);
    a("msf_connectContinuanceTime", false, paramLong, 0L, paramString2, false, false);
  }
  
  public void a(WifiInfo paramWifiInfo)
  {
    int i2;
    label45:
    int i3;
    if ((paramWifiInfo.getBSSID() == null) || (paramWifiInfo.getIpAddress() == 0) || (paramWifiInfo.getSupplicantState() != SupplicantState.COMPLETED))
    {
      if (paramWifiInfo.getBSSID() != null) {
        break label106;
      }
      i1 = 1;
      i2 = (byte)i1;
      if (paramWifiInfo.getIpAddress() != 0) {
        break label111;
      }
      i1 = 2;
      i3 = (byte)i1;
      if (paramWifiInfo.getSupplicantState() == SupplicantState.COMPLETED) {
        break label116;
      }
    }
    label106:
    label111:
    label116:
    for (int i1 = 4;; i1 = 0)
    {
      i1 = (byte)i1;
      paramWifiInfo = new HashMap();
      paramWifiInfo.put("param_FailCode", String.valueOf((i1 | i2 | i3) + 5000));
      a("dim.Msf.WifiNoConnection", false, 0L, 0L, paramWifiInfo, true, false);
      return;
      i1 = 0;
      break;
      i1 = 0;
      break label45;
    }
  }
  
  public void a(String paramString)
  {
    UserAction.setUserID(paramString);
    CrashReport.setUserId(BaseApplication.getContext(), paramString);
  }
  
  public void a(String paramString, boolean paramBoolean, long paramLong1, int paramInt, long paramLong2)
  {
    if (NetConnInfoCenterImpl.isWifiOrMobileConn())
    {
      if (I == null) {
        I = new HashSet();
      }
      if (!I.contains(paramString)) {}
    }
    else
    {
      return;
    }
    I.add(paramString);
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_uin", paramString);
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    a("dim.Msf.UserGrayfail", paramBoolean, paramLong1, paramLong2, localHashMap, false, false);
  }
  
  public void a(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (J)
    {
      J = false;
      c();
    }
    if (com.tencent.mobileqq.msf.core.a.a.r.contains(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.StatReport", 2, paramString + " is not need report.");
      }
      return;
    }
    if ((paramMap == null) || (!paramBoolean1)) {}
    for (;;)
    {
      int i1;
      try
      {
        if ((this.H != null) && (this.H.sender != null) && (this.H.sender.a != null)) {
          paramMap.put("param_isConnected", String.valueOf(this.H.sender.a.n().b()));
        }
        paramMap.put("param_NetworkOperator", l.l());
        i1 = NetConnInfoCenterImpl.getSystemNetworkType();
        paramMap.put("param_NetworkInfo", String.valueOf(i1));
        if (!paramMap.containsKey(BaseConstants.RDM_NoChangeFailCode)) {
          break label356;
        }
        paramMap.remove(BaseConstants.RDM_NoChangeFailCode);
        paramMap.put("param_SsoServerIp", s.r);
        paramMap.put("param_GatewayrIp", s.m());
        if (!paramMap.containsKey("param_reportTime")) {
          paramMap.put("param_reportTime", String.valueOf(SystemClock.elapsedRealtime()));
        }
        RdmReq localRdmReq = new RdmReq();
        localRdmReq.eventName = paramString;
        localRdmReq.elapse = paramLong1;
        localRdmReq.size = paramLong2;
        localRdmReq.isSucceed = paramBoolean1;
        localRdmReq.isRealTime = paramBoolean2;
        localRdmReq.isMerge = paramBoolean3;
        localRdmReq.params = paramMap;
        if ((O.offer(localRdmReq)) || (!QLog.isColorLevel())) {
          break;
        }
        QLog.e("MSF.C.StatReport", 2, "wait queue is full!");
        return;
      }
      catch (Exception paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("MSF.C.StatReport", 2, "report RQD error " + paramString, paramString);
      return;
      label356:
      if (i1 == 0) {
        paramMap.put("param_FailCode", "900");
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(4015));
    localHashMap.put("param_Reason", String.valueOf(paramBoolean));
    a("Msf.LoginRespTimeout", false, 0L, 0L, localHashMap, false, false);
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("timeConnectTestServerDiff", String.valueOf(paramLong));
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      localHashMap.put("SSOIP" + i1, ((h.a)paramArrayList.get(i1)).a);
      localHashMap.put("ConnTestSsoResult" + i1, String.valueOf(((h.a)paramArrayList.get(i1)).b));
      localHashMap.put("errorDetail" + i1, ((h.a)paramArrayList.get(i1)).c);
      i1 += 1;
    }
    localHashMap.put("respcode", String.valueOf(paramInt));
    a("msf_netStateWhileSSOListCannotConnBDOK5", paramBoolean, 0L, 0L, localHashMap, true, false);
  }
  
  public void a(boolean paramBoolean, long paramLong1, int paramInt, long paramLong2)
  {
    HashMap localHashMap;
    if (NetConnInfoCenterImpl.isWifiOrMobileConn())
    {
      localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt + 3300));
      if (g()) {
        a("dim.Msf.BG.PushQueryResult", paramBoolean, paramLong1, paramLong2, localHashMap, false, false);
      }
    }
    else
    {
      return;
    }
    a("dim.Msf.PushQueryResult", paramBoolean, paramLong1, paramLong2, localHashMap, false, false);
  }
  
  public void a(boolean paramBoolean1, long paramLong1, int paramInt, long paramLong2, String paramString1, String paramString2, boolean paramBoolean2, long paramLong3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt + 3000));
    localHashMap.put("param_SsoServerIp", paramString1);
    localHashMap.put("param_sendLocalIp", paramString2);
    localHashMap.put("param_NowLocalIp", s.s);
    localHashMap.put("param_Reason", String.valueOf(paramBoolean2));
    localHashMap.put("param_sendTime", String.valueOf(paramLong3));
    a("Msf.CommonLogin", paramBoolean1, paramLong1, paramLong2, localHashMap, false, false);
  }
  
  public void a(boolean paramBoolean1, long paramLong1, int paramInt, long paramLong2, boolean paramBoolean2, String paramString)
  {
    HashMap localHashMap;
    if (NetConnInfoCenterImpl.isWifiOrMobileConn())
    {
      localHashMap = new HashMap();
      localHashMap.put("param_Reason", paramString);
      if (paramBoolean2) {
        break label85;
      }
      localHashMap.put("param_FailCode", String.valueOf(paramInt + 3100));
      if (g()) {
        a("dim.Msf.BG.RigisterPushResult", paramBoolean1, paramLong1, paramLong2, localHashMap, false, false);
      }
    }
    else
    {
      return;
    }
    a("dim.Msf.RigisterPushResult", paramBoolean1, paramLong1, paramLong2, localHashMap, false, false);
    return;
    label85:
    localHashMap.put("param_FailCode", String.valueOf(paramInt + 3200));
    if (g())
    {
      a("dim.Msf.BG.UnRigisterPushResult", paramBoolean1, paramLong1, paramLong2, localHashMap, false, false);
      return;
    }
    a("dim.Msf.UnRigisterPushResult", paramBoolean1, paramLong1, paramLong2, localHashMap, false, false);
  }
  
  public void a(boolean paramBoolean1, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean2, ArrayList paramArrayList, int paramInt)
  {
    if (!NetConnInfoCenterImpl.isWifiOrMobileConn()) {}
    while (paramArrayList.size() <= 0) {
      return;
    }
    Object localObject1 = "" + this.H.getMsfAppid();
    localObject1 = (String)localObject1 + "|1";
    Object localObject2 = com.tencent.mobileqq.msf.core.c.f(BaseApplication.getContext()) + "." + com.tencent.mobileqq.msf.core.c.e(BaseApplication.getContext());
    localObject1 = (String)localObject1 + "|" + (String)localObject2;
    localObject2 = (com.tencent.mobileqq.msf.core.net.a)paramArrayList.get(paramArrayList.size() - 1);
    localObject2 = (String)localObject1 + "|" + ((com.tencent.mobileqq.msf.core.net.a)localObject2).g;
    localObject1 = l.e();
    if ((localObject1 != null) && (((String)localObject1).length() >= 5))
    {
      localObject2 = (String)localObject2 + "|" + ((String)localObject1).substring(0, 3);
      localObject1 = (String)localObject2 + ":" + ((String)localObject1).substring(3, 5);
      localObject2 = l.i();
      if (localObject2 == null) {
        break label582;
      }
      localObject1 = (String)localObject1 + ":" + (String)localObject2;
      label301:
      localObject1 = (String)localObject1 + ":" + false;
      localObject1 = (String)localObject1 + "|" + paramLong1;
      localObject1 = (String)localObject1 + "|" + paramLong2;
      localObject1 = (String)localObject1 + "|" + paramLong3;
      localObject1 = (String)localObject1 + "|" + paramBoolean2;
      if (!paramBoolean1) {
        break label608;
      }
    }
    label582:
    label608:
    for (localObject1 = (String)localObject1 + "|1";; localObject1 = (String)localObject1 + "|" + paramInt)
    {
      localObject2 = paramArrayList.iterator();
      for (paramArrayList = (ArrayList)localObject1; ((Iterator)localObject2).hasNext(); paramArrayList = paramArrayList + "|" + ((com.tencent.mobileqq.msf.core.net.a)localObject1).a()) {
        localObject1 = (com.tencent.mobileqq.msf.core.net.a)((Iterator)localObject2).next();
      }
      localObject1 = (String)localObject2 + "|000";
      localObject1 = (String)localObject1 + ":00";
      break;
      localObject1 = (String)localObject1 + ":000";
      break label301;
    }
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("param_LoginConnect", paramArrayList);
    try
    {
      ((HashMap)localObject1).put("param_totalmemory", MsfSdkUtils.getTotalMemory());
    }
    catch (Exception paramArrayList)
    {
      try
      {
        ((HashMap)localObject1).put("param_Resolution", MsfSdkUtils.getResolutionString(BaseApplication.getContext()));
      }
      catch (Exception paramArrayList)
      {
        try
        {
          for (;;)
          {
            ((HashMap)localObject1).put("param_runStatus_new", String.valueOf(h.r));
            if (QLog.isColorLevel())
            {
              QLog.d("MSF.C.StatReport", 2, "get report status " + (String)((HashMap)localObject1).get("param_runStatus"));
              QLog.d("MSF.C.StatReport", 2, "get report new status " + String.valueOf(h.r));
            }
            if (paramLong3 == -1L) {
              break;
            }
            a("msf_connAndRecv", paramBoolean1, paramLong1 + paramLong3, 0L, (Map)localObject1, false, false);
            return;
            paramArrayList = paramArrayList;
            QLog.d("MSF.C.StatReport", 1, "getTotalMemoey error " + paramArrayList);
            continue;
            paramArrayList = paramArrayList;
            QLog.d("MSF.C.StatReport", 1, "getResilution error " + paramArrayList);
          }
        }
        catch (Exception paramArrayList)
        {
          for (;;)
          {
            QLog.d("MSF.C.StatReport", 1, "get new status error " + paramArrayList.toString());
          }
          a("msf_connAndRecv", paramBoolean1, paramLong1, 0L, (Map)localObject1, false, false);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, long paramLong1, d paramd, com.tencent.qphone.base.a parama, int paramInt, long paramLong2, long paramLong3, long paramLong4, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_connOpenNetType", String.valueOf(paramInt));
    localHashMap.put("param_ssoInfo", a(paramd));
    localHashMap.put("param_liveTime", String.valueOf(paramLong2));
    localHashMap.put("param_sendBytes", String.valueOf(paramLong3));
    localHashMap.put("param_recvBytes", String.valueOf(paramLong4));
    localHashMap.put("param_FailCode", String.valueOf(parama.ordinal() + 4900));
    localHashMap.put("param_Reason", parama.toString());
    paramd = "" + paramLong1;
    paramd = paramd + "|";
    paramd = paramd + paramString1;
    paramd = paramd + "|";
    localHashMap.put("param_connectContinuanceTime", paramd + paramString2);
    if (g())
    {
      a("dim.Msf.BG.ConnClose", paramBoolean, paramLong1, 0, localHashMap, false, false);
      return;
    }
    a("dim.Msf.ConnClose", paramBoolean, paramLong1, 0, localHashMap, false, false);
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ssolist", paramString);
    localHashMap.put("SSOListToConnectEndTime", "" + paramLong);
    a("msf_justGetSSOListButCannotConn", paramBoolean, paramLong, 0L, localHashMap, true, false);
  }
  
  public void a(boolean paramBoolean, String paramString1, long paramLong1, int paramInt, long paramLong2, String paramString2, String paramString3)
  {
    if (NetConnInfoCenterImpl.isWifiOrMobileConn())
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      localHashMap.put("param_tokenType", String.valueOf(paramString2));
      localHashMap.put("param_uin", paramString1);
      localHashMap.put("param_src", paramString3);
      localHashMap.put("param_imei", l.d());
      a("dim.Msf.RenewToken_3", paramBoolean, paramLong1, paramLong2, localHashMap, false, false);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong, ArrayList paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    int i3 = 0;
    int i4 = 0;
    int i1 = i4;
    int i2 = i3;
    if (!paramBoolean3)
    {
      i1 = i4;
      i2 = i3;
      if (paramArrayList.size() > 0)
      {
        localHashMap.put("param_Reason", String.valueOf(((com.tencent.mobileqq.msf.core.net.a)paramArrayList.get(paramArrayList.size() - 1)).e));
        if (((com.tencent.mobileqq.msf.core.net.a)paramArrayList.get(paramArrayList.size() - 1)).e != q.m) {
          break label201;
        }
        i2 = 1;
        i1 = i4;
      }
    }
    for (;;)
    {
      localHashMap.put("param_GatewayIp", s.m());
      localHashMap.put("param_FailCode", String.valueOf(paramArrayList.size()));
      localObject = new StringBuilder();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        com.tencent.mobileqq.msf.core.net.a locala = (com.tencent.mobileqq.msf.core.net.a)paramArrayList.next();
        ((StringBuilder)localObject).append(locala.toString() + "|");
      }
      label201:
      i1 = i4;
      i2 = i3;
      if (((com.tencent.mobileqq.msf.core.net.a)paramArrayList.get(paramArrayList.size() - 1)).e == q.i)
      {
        i1 = 1;
        i2 = i3;
      }
    }
    Object localObject = ((StringBuilder)localObject).toString();
    paramArrayList = (ArrayList)localObject;
    if (((String)localObject).endsWith("|")) {
      paramArrayList = ((String)localObject).substring(0, ((String)localObject).length() - 1);
    }
    localHashMap.put("param_connResult", paramArrayList);
    if (!paramBoolean3)
    {
      localHashMap.put("param_localIp", l.n());
      localHashMap.put("param_NetworkStatus", b());
    }
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        a("dim.Msf.MutilConnDefaultElapsedTime", paramBoolean3, paramLong, 0, localHashMap, true, false);
        return;
      }
      a("dim.Msf.MutilConnElapsedTime", paramBoolean3, paramLong, 0, localHashMap, false, false);
      return;
    }
    if (paramBoolean2)
    {
      if (g())
      {
        a("dim.Msf.BG.ConnDefaultElapsedTime", paramBoolean3, paramLong, 0, localHashMap, false, false);
        return;
      }
      a("dim.Msf.ConnDefaultElapsedTime", paramBoolean3, paramLong, 0, localHashMap, false, false);
      return;
    }
    if (g())
    {
      if (i2 != 0)
      {
        a("dim.Msf.BG.ConnFailByUnreachable", paramBoolean3, paramLong, 0, localHashMap, false, false);
        return;
      }
      if (i1 != 0)
      {
        a("dim.Msf.BG.ConnFailByPermission", paramBoolean3, paramLong, 0, localHashMap, false, false);
        return;
      }
      a("dim.Msf.BG.ConnElapsedTime", paramBoolean3, paramLong, 0, localHashMap, false, false);
      return;
    }
    if (i2 != 0)
    {
      a("dim.Msf.ConnFailByUnreachable", paramBoolean3, paramLong, 0, localHashMap, false, false);
      return;
    }
    if (i1 != 0)
    {
      a("dim.Msf.ConnFailByPermission", paramBoolean3, paramLong, 0, localHashMap, false, false);
      return;
    }
    a("dim.Msf.ConnElapsedTime", paramBoolean3, paramLong, 0, localHashMap, false, false);
  }
  
  String b()
  {
    int i3 = 0;
    int i2 = 0;
    NetworkInfo localNetworkInfo = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
    if (localNetworkInfo != null)
    {
      int i4;
      if (localNetworkInfo.isAvailable())
      {
        i1 = 1;
        i4 = (byte)i1;
        if (!localNetworkInfo.isConnected()) {
          break label107;
        }
      }
      label107:
      for (int i1 = 2;; i1 = 0)
      {
        int i5 = (byte)i1;
        i1 = i3;
        if (NetConnInfoCenterImpl.isMobileNetworkInfo(localNetworkInfo))
        {
          i1 = i2;
          if (((TelephonyManager)BaseApplication.getContext().getSystemService("phone")).getDataState() == 2) {
            i1 = 4;
          }
          i1 = (byte)i1;
        }
        return String.valueOf((byte)(i5 | i4 | i1));
        i1 = 0;
        break;
      }
    }
    return "-1";
  }
  
  public void c()
  {
    a("dim.Msf.AUTOBOTTING", true, 0L, 0L, new HashMap(), false, false);
  }
  
  class a
    implements UploadHandleListener
  {
    a() {}
    
    public void onUploadEnd(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, String paramString)
    {
      if (NetConnInfoCenterImpl.isMobileConn()) {
        i.a(m.this.H.sender.h(), new String[] { "param_XGRdmFlow", "param_XGFlow", "param_Flow" }, paramLong1 + paramLong2);
      }
      while (!NetConnInfoCenterImpl.isWifiConn()) {
        return;
      }
      i.a(m.this.H.sender.h(), new String[] { "param_WIFIRdmFlow", "param_WIFIFlow", "param_Flow" }, paramLong1 + paramLong2);
    }
    
    public void onUploadStart(int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.m
 * JD-Core Version:    0.7.0.1
 */