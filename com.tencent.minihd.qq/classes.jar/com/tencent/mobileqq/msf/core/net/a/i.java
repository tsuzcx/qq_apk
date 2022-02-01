package com.tencent.mobileqq.msf.core.net.a;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl;
import com.tencent.mobileqq.msf.core.net.h;
import com.tencent.mobileqq.msf.core.s;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class i
  extends m
{
  public static final int a = 0;
  public static final int b = -1;
  public static final int c = -2;
  public static final int d = -3;
  public static final int e = -4;
  private static final String g = "WifiDetector";
  private static final String h = "_wifi_detect_history";
  private static final long i = 7200000L;
  private static final long j = 60000L;
  private static final long k = 86400000L;
  private static final long l = 5L;
  private static final int t = 1000;
  private MsfCore m;
  private AtomicBoolean n = new AtomicBoolean(false);
  private volatile int o = 0;
  private int p = -1;
  private String q;
  private String r;
  private HashMap s = new HashMap();
  private Handler u = new j(this);
  private a.a v = new k(this);
  
  public i(MsfCore paramMsfCore)
  {
    this.m = paramMsfCore;
    g();
    e();
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    case -2: 
    case -1: 
    default: 
      return -1;
    case 0: 
      return 0;
    }
    return -2;
  }
  
  private void a(int paramInt, String paramString)
  {
    if ((this.p != -2) || (paramInt == 0)) {
      this.p = paramInt;
    }
    if (this.p == -2) {
      this.q = paramString;
    }
  }
  
  private void a(String paramString, long paramLong, boolean paramBoolean)
  {
    l locall = new l(paramString, paramLong, paramBoolean);
    Iterator localIterator = this.s.entrySet().iterator();
    StringBuffer localStringBuffer;
    int i1;
    String str;
    try
    {
      localStringBuffer = new StringBuffer();
      i1 = 0;
      Object localObject;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label163;
        }
        localObject = (Map.Entry)localIterator.next();
        str = (String)((Map.Entry)localObject).getKey();
        localObject = (l)((Map.Entry)localObject).getValue();
        if ((((l)localObject).a.equals(paramString)) || (System.currentTimeMillis() - ((l)localObject).b <= 86400000L)) {
          break;
        }
        this.s.remove(str);
      }
      str = ((l)localObject).a();
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return;
    }
    if (str != null) {
      if (localStringBuffer.length() <= 0) {
        localStringBuffer.append(str);
      }
    }
    for (;;)
    {
      label163:
      this.s.put(paramString, locall);
      MsfStore.getNativeConfigStore().setConfig("_wifi_detect_history", localStringBuffer.toString());
      return;
      localStringBuffer.append("#&#").append(str);
      do
      {
        break;
        i1 += 1;
      } while (i1 <= 5L);
    }
  }
  
  private void b(String paramString, long paramLong)
  {
    this.u.removeMessages(1000);
    Message localMessage = this.u.obtainMessage();
    localMessage.obj = paramString;
    this.u.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void c(String paramString)
  {
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (!NetConnInfoCenterImpl.isWifiConn())
        {
          QLog.d("WifiDetector", 1, "WIFI detect start failed, wifi is not connected!");
          return;
        }
        if (!d(paramString))
        {
          QLog.d("WifiDetector", 1, "WIFI detect start failed, ssid is invalid!");
          continue;
        }
        if (this.n.compareAndSet(false, true)) {
          break label76;
        }
      }
      finally {}
      QLog.d("WifiDetector", 1, "WIFI detect start failed, there is detect running!");
      b(paramString, 60000L);
      continue;
      label76:
      QLog.d("WifiDetector", 1, "WIFI detect started!");
      this.r = paramString;
      a(this.r, System.currentTimeMillis());
      b(paramString, 7200000L);
      while (i1 < this.f.length)
      {
        this.o |= 1 << i1;
        paramString = a(this.f[i1], i1, this.v);
        if (paramString != null)
        {
          paramString = new Thread(paramString);
          paramString.setName("WifiDetectEchoThread");
          paramString.start();
        }
        i1 += 1;
      }
    }
  }
  
  private boolean d(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals(NetConnInfoCenterImpl.getLastWifiSSID()));
  }
  
  private void e()
  {
    if ((NetConnInfoCenterImpl.isWifiConn()) && (d(NetConnInfoCenterImpl.getLastWifiSSID()))) {
      a(NetConnInfoCenterImpl.getLastWifiSSID());
    }
  }
  
  private void f()
  {
    this.n.set(false);
    this.o = 0;
    this.p = -1;
    this.q = null;
    this.r = "";
  }
  
  private void g()
  {
    Object localObject = MsfStore.getNativeConfigStore().getConfig("_wifi_detect_history");
    try
    {
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      localObject = ((String)localObject).split("#&#");
      int i1 = 0;
      while (i1 < localObject.length)
      {
        l locall = l.a(localObject[i1]);
        if (locall != null) {
          this.s.put(locall.a, locall);
        }
        i1 += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a()
  {
    QLog.d("WifiDetector", 1, "WIFI detect onWifiDisconnected!");
    this.u.removeMessages(1000);
  }
  
  public void a(String paramString)
  {
    QLog.d("WifiDetector", 1, "WIFI detect onWifiConnected!");
    l locall = (l)this.s.get(paramString);
    long l1 = System.currentTimeMillis();
    if (locall == null)
    {
      a(paramString, false);
      c(paramString);
      return;
    }
    if (!locall.c)
    {
      c(paramString);
      return;
    }
    if (l1 - locall.b >= 7200000L)
    {
      c(paramString);
      return;
    }
    b(paramString, 7200000L - (l1 - locall.b));
  }
  
  public void a(String paramString, long paramLong)
  {
    l locall = (l)this.s.get(paramString);
    if (locall != null)
    {
      a(paramString, paramLong, locall.c);
      return;
    }
    a(paramString, paramLong, false);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    l locall = (l)this.s.get(paramString);
    if (locall != null) {
      a(paramString, locall.b, paramBoolean);
    }
  }
  
  public void b()
  {
    QLog.d("WifiDetector", 1, "WIFI detect onWifiAllConnFailed!");
    c(NetConnInfoCenterImpl.getLastWifiSSID());
  }
  
  public void b(String paramString)
  {
    QLog.d("WifiDetector", 1, "WIFI detect onWifiConnSucc!");
    a(paramString, true);
  }
  
  public void c()
  {
    QLog.d("WifiDetector", 1, "WIFI detect onWifiConnFake!");
    c(NetConnInfoCenterImpl.getLastWifiSSID());
  }
  
  public void d()
  {
    int i1 = this.p;
    String str = this.q;
    if (NetConnInfoCenterImpl.isWifiConn()) {
      if (i1 == 0) {
        QLog.d("WifiDetector", 1, "WIFI detect result, WIFI_OK");
      }
    }
    for (;;)
    {
      f();
      return;
      if (i1 == -1)
      {
        QLog.d("WifiDetector", 1, "WIFI detect result, WIFI_EXCEPTION");
      }
      else if ((i1 == -2) && (!this.m.sender.a.b()) && (d(this.r)))
      {
        QLog.d("WifiDetector", 1, "WIFI detect result, WIFI_NEED_AUTH");
        FromServiceMsg localFromServiceMsg = new FromServiceMsg(NetConnInfoCenterImpl.msfCore.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_netNeedSignon");
        localFromServiceMsg.setMsgSuccess();
        localFromServiceMsg.setMsfCommand(MsfCommand.onNetNeedSignon);
        localFromServiceMsg.addAttribute("signonurl", str);
        MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
        NetConnInfoCenterImpl.msfCore.addRespToQuque(null, localFromServiceMsg);
      }
      else
      {
        QLog.d("WifiDetector", 1, "WIFI detect result, WIFI_OTHER");
        continue;
        QLog.d("WifiDetector", 1, "WIFI detect result, WIFI_NONE");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.a.i
 * JD-Core Version:    0.7.0.1
 */