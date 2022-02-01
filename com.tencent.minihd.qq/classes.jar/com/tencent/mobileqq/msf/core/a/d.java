package com.tencent.mobileqq.msf.core.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.l;
import com.tencent.mobileqq.msf.core.net.h;
import com.tencent.mobileqq.msf.core.s;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.k;
import com.tencent.mobileqq.msf.sdk.o;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.msf.service.protocol.serverconfig.ProxyIpChannel;
import com.tencent.msf.service.protocol.serverconfig.ProxyIpInfo;
import com.tencent.msf.service.protocol.serverconfig.ProxyIpList;
import com.tencent.msf.service.protocol.serverconfig.f;
import com.tencent.msf.service.protocol.serverconfig.g;
import com.tencent.msf.service.protocol.serverconfig.i;
import com.tencent.msf.service.protocol.serverconfig.j;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class d
{
  private static final String A = "_sso_proxy_ip_mobile_";
  private static final int B = 0;
  public static final String a = "MSF.C.SsoListManager";
  private static final String p = "__loginSdk_ssoWifilist";
  private static final String q = "__loginSdk_ssoMobilelist";
  private static final String r = "__loginSdk_ssoHttpWifilist";
  private static final String s = "__loginSdk_ssoHttpMobilelist";
  private static final String t = "__loginSdk_ssolist";
  private static final String u = "wifiused";
  private static final int v = 10;
  private static final String w = "wifiname";
  private static final String x = "wifitime";
  private static final String y = "wifiUsedCount";
  private static final String z = "_key_proxyip_";
  private k C = new k(1000);
  private Thread D = null;
  CopyOnWriteArrayList b;
  CopyOnWriteArrayList c;
  CopyOnWriteArrayList d;
  CopyOnWriteArrayList e;
  CopyOnWriteArrayList f;
  CopyOnWriteArrayList g;
  CopyOnWriteArrayList h;
  CopyOnWriteArrayList i;
  MsfCore j;
  private CopyOnWriteArrayList k = new CopyOnWriteArrayList();
  private CopyOnWriteArrayList l = new CopyOnWriteArrayList();
  private CopyOnWriteArrayList m = new CopyOnWriteArrayList();
  private CopyOnWriteArrayList n = new CopyOnWriteArrayList();
  private ConcurrentHashMap o = new ConcurrentHashMap();
  
  public d(MsfCore paramMsfCore)
  {
    this.j = paramMsfCore;
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, f paramf)
  {
    com.tencent.msf.service.protocol.serverconfig.a locala;
    if ((paramf.b != null) && (paramf.b.length > 0))
    {
      JceInputStream localJceInputStream = new JceInputStream(paramf.b);
      locala = new com.tencent.msf.service.protocol.serverconfig.a();
      locala.readFrom(localJceInputStream);
      if (locala.a != 2) {
        break label99;
      }
      MsfStore.getNativeConfigStore().setConfig("LOGLEVEL_", String.valueOf(locala.d));
      MsfStore.getNativeConfigStore().setConfig("LOGLEVELTIME", String.valueOf(System.currentTimeMillis()));
      o.b(locala.d);
      MsfCore.initAppProMsg("*", paramFromServiceMsg.getAppId());
    }
    label99:
    do
    {
      do
      {
        return;
      } while (locala.a != 1);
      locala.f = paramf.c;
      this.C.offer(locala);
    } while (this.D != null);
    this.D = new e(this, "LogUploadThread");
    this.D.start();
  }
  
  private void a(String paramString, f paramf)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("0"))) {
      QLog.d("MSF.C.SsoListManager", 2, "recv proxyList Push error, uin is error");
    }
    ProxyIpChannel localProxyIpChannel;
    do
    {
      do
      {
        return;
      } while ((paramf.b == null) || (paramf.b.length <= 0));
      localObject1 = new JceInputStream(paramf.b);
      localProxyIpChannel = new ProxyIpChannel();
      localProxyIpChannel.readFrom((JceInputStream)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.SsoListManager", 2, "recv proxyList Push for " + MsfSdkUtils.getShortUin(paramString) + ".");
      }
    } while ((localProxyIpChannel == null) || (localProxyIpChannel.vProxy_iplists == null));
    Object localObject2 = "_key_proxyip_" + paramString;
    Object localObject1 = "_sso_proxy_ip_mobile_" + paramString;
    if (localProxyIpChannel.vProxy_iplists.size() > 0)
    {
      MsfStore.getNativeConfigStore().setConfig((String)localObject2, HexUtil.bytes2HexStr(paramf.b));
      paramf = localProxyIpChannel.vProxy_iplists.iterator();
      while (paramf.hasNext())
      {
        localObject2 = (ProxyIpList)paramf.next();
        if ((localObject2 != null) && (((ProxyIpList)localObject2).uService_type == 0L))
        {
          MsfStore.getNativeConfigStore().setConfig((String)localObject1, HexUtil.bytes2HexStr(((ProxyIpList)localObject2).toByteArray()));
          b(((ProxyIpList)localObject2).vIplist);
        }
      }
    }
    for (;;)
    {
      paramf = new FromServiceMsg();
      paramf.setUin(paramString);
      paramf.setMsfCommand(MsfCommand.onProxyIpChanged);
      paramf.setAppId(this.j.getMsfAppid());
      paramf.setMsgSuccess();
      paramf.setRequestSsoSeq(MsfCore.getNextSeq());
      MsfSdkUtils.addFromMsgProcessName("*", paramf);
      this.j.addRespToQuque(null, paramf);
      if ((localProxyIpChannel == null) || (localProxyIpChannel.iReconnect != 1)) {
        break;
      }
      this.j.sender.a.a(com.tencent.qphone.base.a.z);
      return;
      QLog.d("MSF.C.SsoListManager", 1, "clear proxyList for " + MsfSdkUtils.getShortUin(paramString) + ".");
      MsfStore.getNativeConfigStore().removeConfig((String)localObject2);
      MsfStore.getNativeConfigStore().removeConfig((String)localObject1);
      o();
    }
  }
  
  private void a(String paramString, ArrayList paramArrayList)
  {
    int i1 = 0;
    Object localObject;
    if (paramString != null) {
      localObject = paramString;
    }
    for (;;)
    {
      try
      {
        if (paramString.length() == 0) {
          break label164;
        }
        paramString = ((String)localObject).split(";");
        int i2 = paramString.length;
        if (i1 >= i2) {
          break label161;
        }
        localObject = paramString[i1];
        if (((String)localObject).length() <= 0) {
          break label172;
        }
        localObject = com.tencent.mobileqq.msf.core.d.a((String)localObject);
        if ((localObject != null) && (!TextUtils.isEmpty(((com.tencent.mobileqq.msf.core.d)localObject).c())) && (!"null".equals(((com.tencent.mobileqq.msf.core.d)localObject).c())))
        {
          ((com.tencent.mobileqq.msf.core.d)localObject).a(false);
          paramArrayList.add(localObject);
        }
        else if (localObject == null)
        {
          QLog.d("MSF.C.SsoListManager", 1, "found invalid endpoint: null");
        }
      }
      finally {}
      QLog.d("MSF.C.SsoListManager", 1, "found invalid endpoint: " + ((com.tencent.mobileqq.msf.core.d)localObject).toString());
      break label172;
      label161:
      return;
      label164:
      localObject = "";
      continue;
      label172:
      i1 += 1;
    }
  }
  
  public static String b()
  {
    Object localObject = (ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity");
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if ((localObject != null) && (((NetworkInfo)localObject).getType() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.SsoListManager", 2, "connect to mobile network " + ((NetworkInfo)localObject).getSubtypeName());
        }
        localObject = ((NetworkInfo)localObject).getExtraInfo();
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.SsoListManager", 2, "current apn:" + (String)localObject);
        }
        return localObject;
      }
      return null;
    }
    return null;
  }
  
  private void b(FromServiceMsg paramFromServiceMsg, f paramf)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("", paramFromServiceMsg.getUin(), "ConfigPushSvc.PushResp");
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    localUniPacket.setServantName("QQService.ConfigPushSvc.MainServant");
    localUniPacket.setFuncName("PushResp");
    g localg = new g();
    localg.b = paramf.c;
    localg.a = paramf.a;
    if (paramf.a == 3) {
      localg.c = paramf.b;
    }
    localUniPacket.put("PushResp", localg);
    localToServiceMsg.putWupBuffer(localUniPacket.encode());
    localToServiceMsg.setAppId(this.j.getMsfAppid());
    localToServiceMsg.setNeedCallback(false);
    localToServiceMsg.setTimeout(30000L);
    localToServiceMsg.setRequestSsoSeq(paramFromServiceMsg.getRequestSsoSeq());
    try
    {
      this.j.sendSsoMsg(localToServiceMsg);
      return;
    }
    catch (Exception paramFromServiceMsg)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("MSF.C.SsoListManager", 2, "send push sso resp error " + paramFromServiceMsg, paramFromServiceMsg);
    }
  }
  
  private void b(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Object localObject;
      com.tencent.mobileqq.msf.core.d locald;
      int i1;
      if ((this.l != null) && (this.l.size() > 0))
      {
        localObject = this.l.iterator();
        while (((Iterator)localObject).hasNext())
        {
          locald = (com.tencent.mobileqq.msf.core.d)((Iterator)localObject).next();
          if (locald.h) {
            this.l.remove(locald);
          }
        }
        if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
          i1 = paramArrayList.size() - 1;
        }
      }
      else
      {
        while (i1 >= 0)
        {
          localObject = (ProxyIpInfo)paramArrayList.get(i1);
          locald = new com.tencent.mobileqq.msf.core.d();
          locald.c(StringUtils.getIpAddrFromInt(((ProxyIpInfo)localObject).uIp));
          locald.a(((ProxyIpInfo)localObject).uPort);
          locald.g = 1;
          locald.h = true;
          this.l.add(0, locald);
          i1 -= 1;
          continue;
          localObject = this.c.iterator();
          while (((Iterator)localObject).hasNext())
          {
            locald = (com.tencent.mobileqq.msf.core.d)((Iterator)localObject).next();
            if (locald.h) {
              this.c.remove(locald);
            }
          }
          if ((paramArrayList != null) && (paramArrayList.size() > 0))
          {
            i1 = paramArrayList.size() - 1;
            while (i1 >= 0)
            {
              localObject = (ProxyIpInfo)paramArrayList.get(i1);
              locald = new com.tencent.mobileqq.msf.core.d();
              locald.c(StringUtils.getIpAddrFromInt(((ProxyIpInfo)localObject).uIp));
              locald.a(((ProxyIpInfo)localObject).uPort);
              locald.g = 1;
              locald.h = true;
              this.c.add(0, locald);
              i1 -= 1;
            }
          }
        }
      }
    }
  }
  
  private boolean b(com.tencent.mobileqq.msf.core.d paramd)
  {
    if (this.k.remove(paramd))
    {
      this.k.add(paramd);
      QLog.d("MSF.C.SsoListManager", 1, " set " + paramd + " at wifiList last.");
      return true;
    }
    QLog.d("MSF.C.SsoListManager", 1, " not found " + paramd + " at wifiList.");
    return false;
  }
  
  /* Error */
  public static String c()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 389	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   6: ldc_w 543
    //   9: invokevirtual 397	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   12: checkcast 545	android/net/wifi/WifiManager
    //   15: invokevirtual 549	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   18: astore_1
    //   19: aload_1
    //   20: invokevirtual 554	android/net/wifi/WifiInfo:getSSID	()Ljava/lang/String;
    //   23: astore_2
    //   24: aload_2
    //   25: ifnonnull +10 -> 35
    //   28: aconst_null
    //   29: astore_1
    //   30: ldc 2
    //   32: monitorexit
    //   33: aload_1
    //   34: areturn
    //   35: aload_1
    //   36: invokevirtual 554	android/net/wifi/WifiInfo:getSSID	()Ljava/lang/String;
    //   39: ldc_w 556
    //   42: ldc_w 383
    //   45: invokevirtual 560	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   48: astore_1
    //   49: aload_1
    //   50: ldc_w 562
    //   53: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   56: istore_0
    //   57: iload_0
    //   58: ifeq -28 -> 30
    //   61: aconst_null
    //   62: astore_1
    //   63: goto -33 -> 30
    //   66: astore_1
    //   67: ldc 2
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   56	2	0	bool	boolean
    //   18	45	1	localObject1	Object
    //   66	5	1	localObject2	Object
    //   23	2	2	str	String
    // Exception table:
    //   from	to	target	type
    //   3	24	66	finally
    //   35	57	66	finally
  }
  
  private boolean c(com.tencent.mobileqq.msf.core.d paramd)
  {
    if (this.l.remove(paramd))
    {
      this.l.add(paramd);
      QLog.d("MSF.C.SsoListManager", 1, " set " + paramd + " at mobileList last.");
      return true;
    }
    QLog.d("MSF.C.SsoListManager", 1, " not found " + paramd + " at mobileList.");
    return false;
  }
  
  private ArrayList d(String paramString)
  {
    paramString = "_sso_proxy_ip_mobile_" + paramString;
    paramString = MsfStore.getNativeConfigStore().getConfig(paramString);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JceInputStream(HexUtil.hexStr2Bytes(paramString));
        ProxyIpList localProxyIpList = new ProxyIpList();
        localProxyIpList.readFrom(paramString);
        if ((localProxyIpList != null) && (localProxyIpList.vIplist != null) && (localProxyIpList.vIplist.size() > 0))
        {
          paramString = localProxyIpList.vIplist;
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  private void n()
  {
    Object localObject = l.e();
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.SsoListManager", 2, "getIMSI " + (String)localObject);
    }
    if (this.c.isEmpty())
    {
      if (localObject != null) {
        break label149;
      }
      this.c.addAll(this.d);
    }
    while (QLog.isColorLevel())
    {
      QLog.d("MSF.C.SsoListManager", 2, "init defaultMobileSSo list result:");
      localObject = this.c.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mobileqq.msf.core.d locald = (com.tencent.mobileqq.msf.core.d)((Iterator)localObject).next();
        QLog.d("MSF.C.SsoListManager", 2, "ip " + locald.c() + ", port " + locald.d());
      }
      label149:
      if ((((String)localObject).startsWith("460")) || (((String)localObject).startsWith("461")))
      {
        if ((((String)localObject).startsWith("46000")) || (((String)localObject).startsWith("46002"))) {
          this.c.addAll(this.e);
        } else if (((String)localObject).startsWith("46001")) {
          this.c.addAll(this.f);
        } else if (((String)localObject).startsWith("46003")) {
          this.c.addAll(this.g);
        } else {
          this.c.addAll(this.d);
        }
      }
      else {
        this.c.addAll(this.h);
      }
    }
  }
  
  private void o()
  {
    com.tencent.mobileqq.msf.core.d locald;
    try
    {
      Iterator localIterator1 = this.l.iterator();
      while (localIterator1.hasNext())
      {
        locald = (com.tencent.mobileqq.msf.core.d)localIterator1.next();
        if (locald.h) {
          this.l.remove(locald);
        }
      }
      localIterator2 = this.c.iterator();
    }
    finally {}
    Iterator localIterator2;
    while (localIterator2.hasNext())
    {
      locald = (com.tencent.mobileqq.msf.core.d)localIterator2.next();
      if (locald.h) {
        this.c.remove(locald);
      }
    }
  }
  
  public void a()
  {
    this.c = new CopyOnWriteArrayList();
    this.d = new CopyOnWriteArrayList();
    this.e = new CopyOnWriteArrayList();
    this.f = new CopyOnWriteArrayList();
    this.g = new CopyOnWriteArrayList();
    this.h = new CopyOnWriteArrayList();
    this.b = new CopyOnWriteArrayList();
    this.i = new CopyOnWriteArrayList();
    this.d.add(com.tencent.mobileqq.msf.core.d.a("socket://msfxg.3g.qq.com:8080#46000_46002_46001_46003:0:1"));
    this.d.add(com.tencent.mobileqq.msf.core.d.a("socket://120.198.203.168:14000#46000_46002:0:1"));
    this.d.add(com.tencent.mobileqq.msf.core.d.a("socket://112.90.140.220:14000#46001:0:1"));
    this.d.add(com.tencent.mobileqq.msf.core.d.a("socket://112.90.78.168:14000#46001:0:1"));
    this.d.add(com.tencent.mobileqq.msf.core.d.a("socket://183.36.108.242:14000#46003:0:1"));
    this.e.add(com.tencent.mobileqq.msf.core.d.a("socket://120.198.199.172:14000#46000_46002:0:1"));
    this.e.add(com.tencent.mobileqq.msf.core.d.a("socket://msfxg.3g.qq.com:80#46000_46002:0:1"));
    this.e.add(com.tencent.mobileqq.msf.core.d.a("socket://120.198.203.168:443#46000_46002:0:1"));
    this.e.add(com.tencent.mobileqq.msf.core.d.a("socket://120.198.201.160:8080#46000_46002:0:1"));
    this.f.add(com.tencent.mobileqq.msf.core.d.a("socket://112.90.140.220:14000#46001:0:1"));
    this.f.add(com.tencent.mobileqq.msf.core.d.a("socket://msfxg.3g.qq.com:80#46001:0:1"));
    this.f.add(com.tencent.mobileqq.msf.core.d.a("socket://112.90.78.168:443#46001:0:1"));
    this.f.add(com.tencent.mobileqq.msf.core.d.a("socket://112.90.78.169:8080#46001:0:1"));
    this.f.add(com.tencent.mobileqq.msf.core.d.a("socket://125.39.213.49:443#46001:0:1"));
    this.g.add(com.tencent.mobileqq.msf.core.d.a("socket://14.17.42.14:14000#46003:0:1"));
    this.g.add(com.tencent.mobileqq.msf.core.d.a("socket://msfxg.3g.qq.com:80#46003:0:1"));
    this.g.add(com.tencent.mobileqq.msf.core.d.a("socket://183.36.108.242:443#46003:0:1"));
    this.g.add(com.tencent.mobileqq.msf.core.d.a("socket://14.17.42.37:8080#46003:0:1"));
    this.g.add(com.tencent.mobileqq.msf.core.d.a("socket://123.151.10.190:443#46003:0:1"));
    this.h.add(com.tencent.mobileqq.msf.core.d.a("socket://msfxg.3g.qq.com:80#46000_46002_46001_46003:0:1"));
    this.h.add(com.tencent.mobileqq.msf.core.d.a("socket://183.36.108.242:8080#46000_46002_46001_46003:0:1"));
    this.h.add(com.tencent.mobileqq.msf.core.d.a("socket://112.90.78.168:443#46000_46002_46001_46003:0:1"));
    this.h.add(com.tencent.mobileqq.msf.core.d.a("socket://120.198.203.168:443#46000_46002_46001_46003:0:1"));
    this.b.add(com.tencent.mobileqq.msf.core.d.a("socket://msfwifi.3g.qq.com:8080#00000:0:1"));
    this.b.add(com.tencent.mobileqq.msf.core.d.a("socket://183.36.108.241:8080#00000:0:1"));
    this.b.add(com.tencent.mobileqq.msf.core.d.a("socket://120.198.203.168:8080#00000:0:1"));
    this.b.add(com.tencent.mobileqq.msf.core.d.a("socket://120.198.201.160:8080#00000:0:1"));
    this.i.add(com.tencent.mobileqq.msf.core.d.a("socket://msfhttp.3g.qq.com:80#00000:0:1"));
    n();
    d();
    g();
    a(c());
  }
  
  public void a(com.tencent.mobileqq.msf.core.d paramd)
  {
    for (;;)
    {
      try
      {
        if (NetConnInfoCenterImpl.isWifiConn())
        {
          if (!b(paramd)) {
            c(paramd);
          }
          return;
        }
        if (NetConnInfoCenterImpl.isMobileConn())
        {
          if (c(paramd)) {
            continue;
          }
          b(paramd);
          continue;
        }
        b(paramd);
      }
      finally {}
      c(paramd);
    }
  }
  
  public void a(f paramf)
  {
    Object localObject1;
    Object localObject2;
    Iterator localIterator;
    if ((paramf.b != null) && (paramf.b.length > 0))
    {
      localObject1 = new JceInputStream(paramf.b);
      paramf = new i();
      paramf.readFrom((JceInputStream)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.SsoListManager", 2, "recv ssoList Push.");
      }
      if (!NetConnInfoCenterImpl.isWifiConn()) {
        break label193;
      }
      localObject1 = new ArrayList();
      localObject2 = paramf.b.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add(com.tencent.mobileqq.msf.core.d.a((j)((Iterator)localObject2).next(), 0));
      }
      localObject2 = new ArrayList();
      localIterator = paramf.h.iterator();
      while (localIterator.hasNext()) {
        ((ArrayList)localObject2).add(com.tencent.mobileqq.msf.core.d.a((j)localIterator.next(), 0));
      }
      a((ArrayList)localObject1, (ArrayList)localObject2, false, true);
    }
    for (;;)
    {
      if (paramf.c == 1)
      {
        QLog.w("MSF.C.SsoListManager", 1, "set sso reconnect is true.");
        this.j.isReconnectSso.set(true);
      }
      return;
      label193:
      localObject1 = new ArrayList();
      localObject2 = paramf.a.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add(com.tencent.mobileqq.msf.core.d.a((j)((Iterator)localObject2).next(), 1));
      }
      localObject2 = new ArrayList();
      localIterator = paramf.g.iterator();
      while (localIterator.hasNext()) {
        ((ArrayList)localObject2).add(com.tencent.mobileqq.msf.core.d.a((j)localIterator.next(), 1));
      }
      b((ArrayList)localObject1, (ArrayList)localObject2, false, true);
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg)
  {
    try
    {
      localObject = new UniPacket(true);
      ((UniPacket)localObject).setEncodeName("utf-8");
      ((UniPacket)localObject).decode(paramFromServiceMsg.getWupBuffer());
      str = paramFromServiceMsg.getUin();
      localObject = (f)((UniPacket)localObject).getByClass("PushReq", new f());
      if (((f)localObject).a == 1) {
        a((f)localObject);
      }
      for (;;)
      {
        b(paramFromServiceMsg, (f)localObject);
        return;
        if (((f)localObject).a != 2) {
          break;
        }
        MsfSdkUtils.addFromMsgProcessName("*", paramFromServiceMsg);
        paramFromServiceMsg.setMsfCommand(MsfCommand.onRecvConfigPush);
        this.j.addRespToQuque(null, paramFromServiceMsg);
      }
    }
    catch (Exception paramFromServiceMsg)
    {
      Object localObject;
      String str;
      while (QLog.isColorLevel())
      {
        QLog.i("MSF.C.SsoListManager", 2, "onRecvSsoPush error " + paramFromServiceMsg, paramFromServiceMsg);
        return;
        if (((f)localObject).a == 3) {
          a(paramFromServiceMsg, (f)localObject);
        } else if (((f)localObject).a == 4) {
          a(str, (f)localObject);
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    label481:
    label484:
    label487:
    label490:
    for (;;)
    {
      try
      {
        Object localObject2 = BaseApplication.getContext().getSharedPreferences("wifiused", 0);
        long l1 = System.currentTimeMillis();
        Object localObject1;
        int i1;
        if (this.o.containsKey(paramString))
        {
          this.o.put(paramString, Long.valueOf(l1));
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.SsoListManager", 2, "find ssid: " + paramString + " update time = " + l1);
          }
          paramString = this.o.entrySet().iterator();
          localObject1 = ((SharedPreferences)localObject2).edit();
          ((SharedPreferences.Editor)localObject1).putInt("wifiUsedCount", this.o.size());
          i1 = 0;
          if (paramString.hasNext())
          {
            localObject2 = (Map.Entry)paramString.next();
            if (localObject2 == null) {
              continue;
            }
            l1 = ((Long)((Map.Entry)localObject2).getValue()).longValue();
            localObject2 = (String)((Map.Entry)localObject2).getKey();
            if (localObject2 == null) {
              break label481;
            }
            ((SharedPreferences.Editor)localObject1).putString("wifiname" + i1, (String)localObject2);
            ((SharedPreferences.Editor)localObject1).putLong("wifitime" + i1, l1);
            i1 += 1;
            break label487;
          }
        }
        else
        {
          i1 = this.o.size();
          l1 = System.currentTimeMillis();
          localObject1 = null;
          if (i1 >= 10)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.SsoListManager", 2, "too much ssid need to delete one find Least Recently Used now...");
            }
            Iterator localIterator = this.o.entrySet().iterator();
            if (localIterator.hasNext())
            {
              Map.Entry localEntry = (Map.Entry)localIterator.next();
              if (localEntry == null) {
                continue;
              }
              long l2 = ((Long)localEntry.getValue()).longValue();
              if (l2 >= l1) {
                break label484;
              }
              localObject1 = (String)localEntry.getKey();
              l1 = l2;
              break label490;
            }
            if (localObject1 != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MSF.C.SsoListManager", 2, "Least Recently Used ssid find delete now: " + (String)localObject1);
              }
              this.o.remove(localObject1);
              localObject1 = "__loginSdk_ssoWifilist_" + (String)localObject1;
              MsfStore.getNativeConfigStore().n_removeConfig((String)localObject1);
            }
          }
          this.o.put(paramString, Long.valueOf(System.currentTimeMillis()));
          continue;
        }
        ((SharedPreferences.Editor)localObject1).commit();
      }
      finally {}
      break;
      break label487;
      break label490;
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null) {}
    try
    {
      if (paramArrayList.size() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.w("MSF.C.SsoListManager", 2, "setTestSso serviceLists is null...");
        }
        throw new RuntimeException("setTestSso serviceLists is null...");
      }
    }
    finally {}
    this.k.clear();
    this.l.clear();
    this.b.clear();
    this.c.clear();
    Object localObject = paramArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mobileqq.msf.core.d locald = (com.tencent.mobileqq.msf.core.d)((Iterator)localObject).next();
      this.l.add(locald);
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      localObject = (com.tencent.mobileqq.msf.core.d)paramArrayList.next();
      this.k.add(localObject);
    }
  }
  
  public void a(ArrayList paramArrayList1, ArrayList paramArrayList2, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      Object localObject1;
      try
      {
        if ((!this.j.sender.a.o().equals("")) || (BaseConstants.isUseDebugSso))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.SsoListManager", 4, "debug mode, skip store sso ");
          }
          return;
        }
        this.k.clear();
        this.m.clear();
        localObject1 = new StringBuffer();
        paramArrayList1 = paramArrayList1.iterator();
        if (!paramArrayList1.hasNext()) {
          break label224;
        }
        localObject2 = (com.tencent.mobileqq.msf.core.d)paramArrayList1.next();
        if ((localObject2 != null) && (!TextUtils.isEmpty(((com.tencent.mobileqq.msf.core.d)localObject2).c())) && (!"null".equals(((com.tencent.mobileqq.msf.core.d)localObject2).c())))
        {
          ((StringBuffer)localObject1).append(((com.tencent.mobileqq.msf.core.d)localObject2).toString() + ";");
          this.k.add(localObject2);
          continue;
        }
        if (localObject2 != null) {
          break label191;
        }
      }
      finally {}
      QLog.d("MSF.C.SsoListManager", 1, "found invalid wifi endpoint: null");
      continue;
      label191:
      QLog.d("MSF.C.SsoListManager", 1, "found invalid wifi endpoint: " + ((com.tencent.mobileqq.msf.core.d)localObject2).toString());
      continue;
      label224:
      paramArrayList1 = new StringBuffer();
      if (paramArrayList2 != null)
      {
        paramArrayList2 = paramArrayList2.iterator();
        while (paramArrayList2.hasNext())
        {
          localObject2 = (com.tencent.mobileqq.msf.core.d)paramArrayList2.next();
          if ((localObject2 != null) && (!TextUtils.isEmpty(((com.tencent.mobileqq.msf.core.d)localObject2).c())) && (!"null".equals(((com.tencent.mobileqq.msf.core.d)localObject2).c())))
          {
            paramArrayList1.append(((com.tencent.mobileqq.msf.core.d)localObject2).toString() + ";");
            this.m.add(localObject2);
          }
          else if (localObject2 == null)
          {
            QLog.d("MSF.C.SsoListManager", 1, "found invalid wifi http endpoint: null");
          }
          else
          {
            QLog.d("MSF.C.SsoListManager", 1, "found invalid wifi http endpoint: " + ((com.tencent.mobileqq.msf.core.d)localObject2).toString());
          }
        }
      }
      paramArrayList2 = ((StringBuffer)localObject1).toString();
      paramArrayList1 = paramArrayList1.toString();
      Object localObject2 = c();
      if (localObject2 != null)
      {
        localObject1 = "__loginSdk_ssoWifilist_" + (String)localObject2;
        localObject2 = "__loginSdk_ssoHttpWifilist_" + (String)localObject2;
        MsfStore.getNativeConfigStore().n_setConfig((String)localObject1, paramArrayList2);
        MsfStore.getNativeConfigStore().n_setConfig((String)localObject2, paramArrayList1);
        if (paramBoolean2) {
          QLog.d("MSF.C.SsoListManager", 1, "save push wifisso for " + paramArrayList2);
        } else {
          QLog.d("MSF.C.SsoListManager", 1, "save http get wifisso for " + paramArrayList2);
        }
      }
    }
  }
  
  public void b(FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.SsoListManager", 2, "onRecvSsoHelloPush from:" + paramFromServiceMsg);
    }
    for (;;)
    {
      try
      {
        localToServiceMsg = new ToServiceMsg("", paramFromServiceMsg.getUin(), "SSO.HelloPush");
        localToServiceMsg.putWupBuffer(paramFromServiceMsg.getWupBuffer());
        localToServiceMsg.setAppId(this.j.getMsfAppid());
        localToServiceMsg.setNeedCallback(false);
        localToServiceMsg.setTimeout(30000L);
        localToServiceMsg.setRequestSsoSeq(paramFromServiceMsg.getRequestSsoSeq());
      }
      catch (Exception paramFromServiceMsg)
      {
        ToServiceMsg localToServiceMsg;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("MSF.C.SsoListManager", 2, "onRecvSsoHelloPush error " + paramFromServiceMsg, paramFromServiceMsg);
      }
      try
      {
        this.j.sendSsoMsg(localToServiceMsg);
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          QLog.i("MSF.C.SsoListManager", 2, "send sso hello push resp error " + paramFromServiceMsg, paramFromServiceMsg);
          return;
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        o();
        if (!paramString.equals("0")) {
          c(paramString);
        }
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void b(ArrayList paramArrayList1, ArrayList paramArrayList2, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      Object localObject1;
      try
      {
        if ((!this.j.sender.a.o().equals("")) || (BaseConstants.isUseDebugSso))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.SsoListManager", 4, "debug mode, skip store sso ");
          }
          return;
        }
        this.l.clear();
        this.n.clear();
        localObject1 = d(this.j.getAccountCenter().i());
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          int i1 = ((ArrayList)localObject1).size() - 1;
          if (i1 >= 0)
          {
            localObject2 = (ProxyIpInfo)((ArrayList)localObject1).get(i1);
            com.tencent.mobileqq.msf.core.d locald = new com.tencent.mobileqq.msf.core.d();
            locald.c(StringUtils.getIpAddrFromInt(((ProxyIpInfo)localObject2).uIp));
            locald.a(((ProxyIpInfo)localObject2).uPort);
            locald.g = 1;
            locald.h = true;
            this.l.add(0, locald);
            i1 -= 1;
            continue;
          }
        }
        localObject1 = new StringBuffer();
        paramArrayList1 = paramArrayList1.iterator();
        if (!paramArrayList1.hasNext()) {
          break label348;
        }
        localObject2 = (com.tencent.mobileqq.msf.core.d)paramArrayList1.next();
        if ((localObject2 != null) && (!TextUtils.isEmpty(((com.tencent.mobileqq.msf.core.d)localObject2).c())) && (!"null".equals(((com.tencent.mobileqq.msf.core.d)localObject2).c())))
        {
          ((com.tencent.mobileqq.msf.core.d)localObject2).a(false);
          ((StringBuffer)localObject1).append(((com.tencent.mobileqq.msf.core.d)localObject2).toString() + ";");
          this.l.add(localObject2);
          continue;
        }
        if (localObject2 != null) {
          break label315;
        }
      }
      finally {}
      QLog.d("MSF.C.SsoListManager", 1, "found invalid mobile endpoint: null");
      continue;
      label315:
      QLog.d("MSF.C.SsoListManager", 1, "found invalid mobile endpoint: " + ((com.tencent.mobileqq.msf.core.d)localObject2).toString());
      continue;
      label348:
      paramArrayList1 = new StringBuffer();
      paramArrayList2 = paramArrayList2.iterator();
      while (paramArrayList2.hasNext())
      {
        localObject2 = (com.tencent.mobileqq.msf.core.d)paramArrayList2.next();
        if ((localObject2 != null) && (!TextUtils.isEmpty(((com.tencent.mobileqq.msf.core.d)localObject2).c())) && (!"null".equals(((com.tencent.mobileqq.msf.core.d)localObject2).c())))
        {
          ((com.tencent.mobileqq.msf.core.d)localObject2).a(false);
          paramArrayList1.append(((com.tencent.mobileqq.msf.core.d)localObject2).toString() + ";");
          this.n.add(localObject2);
        }
        else if (localObject2 == null)
        {
          QLog.d("MSF.C.SsoListManager", 1, "found invalid mobile http endpoint: null");
        }
        else
        {
          QLog.d("MSF.C.SsoListManager", 1, "found invalid mobile http endpoint: " + ((com.tencent.mobileqq.msf.core.d)localObject2).toString());
        }
      }
      paramArrayList2 = ((StringBuffer)localObject1).toString();
      paramArrayList1 = paramArrayList1.toString();
      Object localObject2 = b();
      if (localObject2 != null)
      {
        localObject1 = "__loginSdk_ssoMobilelist_" + (String)localObject2;
        localObject2 = "__loginSdk_ssoHttpMobilelist_" + (String)localObject2;
        MsfStore.getNativeConfigStore().n_setConfig((String)localObject1, paramArrayList2);
        MsfStore.getNativeConfigStore().n_setConfig((String)localObject2, paramArrayList1);
        if (paramBoolean2) {
          QLog.d("MSF.C.SsoListManager", 1, "save push mobilesso for " + (String)localObject1 + " " + paramArrayList2);
        } else {
          QLog.d("MSF.C.SsoListManager", 1, "save http mobilesso for " + (String)localObject1 + " " + paramArrayList2);
        }
      }
    }
  }
  
  public void c(String paramString)
  {
    try
    {
      b(d(this.j.getAccountCenter().i()));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void d()
  {
    int i1 = 0;
    try
    {
      SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("wifiused", 0);
      int i2 = localSharedPreferences.getInt("wifiUsedCount", 0);
      while (i1 < i2)
      {
        String str = localSharedPreferences.getString("wifiname" + i1, "");
        long l1 = localSharedPreferences.getLong("wifitime" + i1, 0L);
        if ((str != null) && (l1 > 0L))
        {
          this.o.put(str, Long.valueOf(l1));
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.SsoListManager", 2, "get a ssid " + str + " time = " + l1);
          }
        }
        i1 += 1;
      }
      return;
    }
    finally {}
  }
  
  public void e()
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    int i2;
    for (;;)
    {
      try
      {
        localObject1 = new ArrayList();
        localObject2 = new ArrayList();
        localObject3 = b();
        if (localObject3 == null) {
          return;
        }
        String str1 = "__loginSdk_ssoMobilelist_" + (String)localObject3;
        localObject4 = "__loginSdk_ssoHttpMobilelist_" + (String)localObject3;
        localObject3 = MsfStore.getNativeConfigStore().getConfig(str1);
        localObject4 = MsfStore.getNativeConfigStore().getConfig((String)localObject4);
        i2 = 0;
        if ((localObject3 != null) && (((String)localObject3).length() != 0)) {
          break label439;
        }
        localObject3 = MsfStore.getNativeConfigStore().getConfig("__loginSdk_ssolist");
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.SsoListManager", 2, "loadSsoStoreForCurrentAPN get a new apn, ssoStore from __loginSdk_ssolist " + (String)localObject3);
        }
        if ((localObject3 == null) || (((String)localObject3).length() <= 0)) {
          break;
        }
        localObject4 = new ArrayList();
        a((String)localObject3, (ArrayList)localObject4);
        localObject3 = ((ArrayList)localObject4).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label566;
        }
        localObject4 = (com.tencent.mobileqq.msf.core.d)((Iterator)localObject3).next();
        if (((com.tencent.mobileqq.msf.core.d)localObject4).i.indexOf("00000") <= -1) {
          ((ArrayList)localObject1).add(localObject4);
        } else {
          ((com.tencent.mobileqq.msf.core.d)localObject4).a(true);
        }
      }
      finally {}
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.SsoListManager", 2, "loadSsoStoreForCurrentAPN a new apn get from defaultMobileSso mobile: " + str2 + " " + this.c);
    }
    ((ArrayList)localObject1).addAll(this.c);
    for (;;)
    {
      if (((ArrayList)localObject1).size() > 0)
      {
        this.l.clear();
        this.l.addAll((Collection)localObject1);
      }
      if (((ArrayList)localObject2).size() > 0)
      {
        this.n.clear();
        this.n.addAll((Collection)localObject1);
      }
      if (i1 != 0)
      {
        localObject1 = new StringBuffer();
        localObject2 = this.l.iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (com.tencent.mobileqq.msf.core.d)((Iterator)localObject2).next();
            ((StringBuffer)localObject1).append(((com.tencent.mobileqq.msf.core.d)localObject3).toString() + ";");
            continue;
            label439:
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.SsoListManager", 2, "a old apn loadSsoStoreForCurrentAPN mobile: " + str2 + " " + (String)localObject3);
            }
            if ((localObject3 != null) && (((String)localObject3).length() > 0)) {
              a((String)localObject3, (ArrayList)localObject1);
            }
            i1 = i2;
            if (localObject4 == null) {
              break;
            }
            i1 = i2;
            if (((String)localObject4).length() <= 0) {
              break;
            }
            a((String)localObject4, (ArrayList)localObject2);
            i1 = i2;
            break;
          }
        }
        localObject1 = ((StringBuffer)localObject1).toString();
        MsfStore.getNativeConfigStore().n_setConfig(str2, (String)localObject1);
      }
      c(this.j.getAccountCenter().i());
      break;
      label566:
      int i1 = 1;
    }
  }
  
  public void f()
  {
    int i2 = 0;
    Object localObject1;
    Object localObject2;
    String str3;
    Object localObject4;
    Object localObject3;
    for (;;)
    {
      try
      {
        localObject1 = new ArrayList();
        localObject2 = new ArrayList();
        String str1 = c();
        if (str1 == null) {
          return;
        }
        str3 = "__loginSdk_ssoWifilist_" + str1;
        localObject4 = "__loginSdk_ssoHttpWifilist_" + str1;
        localObject3 = MsfStore.getNativeConfigStore().getConfig(str3);
        localObject4 = MsfStore.getNativeConfigStore().getConfig((String)localObject4);
        if ((localObject3 != null) && (((String)localObject3).length() != 0)) {
          break label432;
        }
        localObject3 = MsfStore.getNativeConfigStore().getConfig("__loginSdk_ssolist");
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.SsoListManager", 2, "loadSsoStoreForCurrentSSID get a new ssid, ssoStore from __loginSdk_ssolist" + (String)localObject3);
        }
        if ((localObject3 == null) || (((String)localObject3).length() <= 0)) {
          break;
        }
        localObject4 = new ArrayList();
        a((String)localObject3, (ArrayList)localObject4);
        localObject3 = ((ArrayList)localObject4).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label546;
        }
        localObject4 = (com.tencent.mobileqq.msf.core.d)((Iterator)localObject3).next();
        if (((com.tencent.mobileqq.msf.core.d)localObject4).i.indexOf("00000") > -1) {
          ((ArrayList)localObject1).add(localObject4);
        } else {
          ((com.tencent.mobileqq.msf.core.d)localObject4).a(false);
        }
      }
      finally {}
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.SsoListManager", 2, "loadSsoStoreForCurrentSSID a new ssid get from defaultWifiSso wifi: " + str3 + this.b);
    }
    ((ArrayList)localObject1).addAll(this.b);
    for (;;)
    {
      if (((ArrayList)localObject1).size() > 0)
      {
        this.k.clear();
        this.k.addAll((Collection)localObject1);
      }
      if (((ArrayList)localObject2).size() > 0)
      {
        this.m.clear();
        this.m.addAll((Collection)localObject2);
      }
      if (i1 != 0)
      {
        localObject1 = new StringBuffer();
        localObject2 = this.k.iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (com.tencent.mobileqq.msf.core.d)((Iterator)localObject2).next();
            ((StringBuffer)localObject1).append(((com.tencent.mobileqq.msf.core.d)localObject3).toString() + ";");
            continue;
            label432:
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.SsoListManager", 2, "a old ssid loadSsoStoreForCurrentSSID wifi: " + str3 + (String)localObject3);
            }
            if ((localObject3 != null) && (((String)localObject3).length() > 0)) {
              a((String)localObject3, (ArrayList)localObject1);
            }
            i1 = i2;
            if (localObject4 == null) {
              break;
            }
            i1 = i2;
            if (((String)localObject4).length() <= 0) {
              break;
            }
            a((String)localObject4, (ArrayList)localObject2);
            i1 = i2;
            break;
          }
        }
        localObject1 = ((StringBuffer)localObject1).toString();
        MsfStore.getNativeConfigStore().n_setConfig(str3, (String)localObject1);
      }
      a(str2);
      break;
      label546:
      int i1 = 1;
    }
  }
  
  public void g()
  {
    for (;;)
    {
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      ArrayList localArrayList3;
      ArrayList localArrayList4;
      Object localObject2;
      String str4;
      String str5;
      String str3;
      String str6;
      try
      {
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        localArrayList3 = new ArrayList();
        localArrayList4 = new ArrayList();
        Object localObject1 = c();
        if (localObject1 == null) {
          break label562;
        }
        localObject2 = "__loginSdk_ssoWifilist" + "_";
        localObject1 = (String)localObject2 + (String)localObject1;
        str4 = MsfStore.getNativeConfigStore().getConfig((String)localObject1);
        str5 = MsfStore.getNativeConfigStore().getConfig("__loginSdk_ssoHttpWifilist");
        localObject2 = "__loginSdk_ssoMobilelist";
        str3 = "__loginSdk_ssoHttpMobilelist";
        str6 = b();
        if (str6 != null)
        {
          localObject2 = "__loginSdk_ssoMobilelist" + "_" + str6;
          str3 = "__loginSdk_ssoHttpMobilelist" + "_" + str6;
        }
        str6 = MsfStore.getNativeConfigStore().getConfig((String)localObject2);
        str3 = MsfStore.getNativeConfigStore().getConfig(str3);
        if (((str4 != null) && (str4.length() != 0)) || ((str6 != null) && (str6.length() != 0))) {
          break label358;
        }
        localObject1 = MsfStore.getNativeConfigStore().getConfig("__loginSdk_ssolist");
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.SsoListManager", 2, "load ssoStore " + (String)localObject1);
        }
        if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
          break label519;
        }
        localObject2 = new ArrayList();
        a((String)localObject1, (ArrayList)localObject2);
        localObject1 = ((ArrayList)localObject2).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label519;
        }
        localObject2 = (com.tencent.mobileqq.msf.core.d)((Iterator)localObject1).next();
        if (((com.tencent.mobileqq.msf.core.d)localObject2).i.indexOf("00000") > -1)
        {
          ((com.tencent.mobileqq.msf.core.d)localObject2).a(true);
          localArrayList1.add(localObject2);
          continue;
        }
        ((com.tencent.mobileqq.msf.core.d)localObject2).a(false);
      }
      finally {}
      localArrayList2.add(localObject2);
      continue;
      label358:
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.SsoListManager", 2, "load wifiStore wifi: " + str1 + ":" + str4);
        QLog.d("MSF.C.SsoListManager", 2, "load mobileStore " + (String)localObject2 + ":" + str6);
      }
      if ((str4 != null) && (str4.length() > 0)) {
        a(str4, localArrayList1);
      }
      if ((str6 != null) && (str6.length() > 0)) {
        a(str6, localArrayList2);
      }
      if ((str5 != null) && (str5.length() > 0)) {
        a(str5, localArrayList3);
      }
      if ((str3 != null) && (str3.length() > 0)) {
        a(str3, localArrayList4);
      }
      label519:
      this.k.addAll(localArrayList1);
      this.l.addAll(localArrayList2);
      this.m.addAll(localArrayList3);
      this.n.addAll(localArrayList4);
      return;
      label562:
      String str2 = "__loginSdk_ssoWifilist";
    }
  }
  
  public CopyOnWriteArrayList h()
  {
    if (this.k.size() == 0) {
      return this.b;
    }
    return this.k;
  }
  
  public CopyOnWriteArrayList i()
  {
    if (this.l.size() == 0) {
      return this.c;
    }
    return this.l;
  }
  
  public CopyOnWriteArrayList j()
  {
    if (this.m.size() == 0) {
      return this.i;
    }
    return this.m;
  }
  
  public CopyOnWriteArrayList k()
  {
    if (this.n.size() == 0) {
      return this.i;
    }
    return this.n;
  }
  
  public CopyOnWriteArrayList l()
  {
    return this.b;
  }
  
  public CopyOnWriteArrayList m()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.a.d
 * JD-Core Version:    0.7.0.1
 */