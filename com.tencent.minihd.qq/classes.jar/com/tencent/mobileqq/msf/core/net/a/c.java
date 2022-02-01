package com.tencent.mobileqq.msf.core.net.a;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl;
import com.tencent.mobileqq.msf.core.a.a;
import com.tencent.mobileqq.msf.core.c.m;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class c
{
  private static final String a = "ReqAllFailDetector";
  private static final int f = 10000;
  private static final long g = 60000L;
  private CopyOnWriteArrayList b;
  private CopyOnWriteArrayList c;
  private CopyOnWriteArrayList d = new CopyOnWriteArrayList();
  private AtomicBoolean e = new AtomicBoolean(false);
  private long h = 0L;
  private String i = "";
  private int j = 0;
  private long k = 0L;
  private String l = "";
  private MsfCore m;
  private Handler n = new d(this, Looper.getMainLooper());
  
  public c(MsfCore paramMsfCore)
  {
    this.m = paramMsfCore;
    a();
  }
  
  private CopyOnWriteArrayList c()
  {
    if (NetConnInfoCenterImpl.isWifiConn()) {
      return this.c;
    }
    if (NetConnInfoCenterImpl.isMobileConn()) {
      return this.b;
    }
    return null;
  }
  
  public void a()
  {
    try
    {
      this.b = a.ah();
      this.c = a.ag();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("ReqAllFailDetector", 1, "loadConfigEndpoint exception", localException);
    }
  }
  
  public void a(long paramLong1, String paramString1, int paramInt, String paramString2, long paramLong2)
  {
    if (!this.e.compareAndSet(false, true)) {
      QLog.d("ReqAllFailDetector", 1, "startReqFailDetect fail by detect running");
    }
    for (;;)
    {
      return;
      try
      {
        CopyOnWriteArrayList localCopyOnWriteArrayList = c();
        if ((localCopyOnWriteArrayList != null) && (localCopyOnWriteArrayList.size() > 0))
        {
          QLog.d("ReqAllFailDetector", 1, "startReqFailDetect");
          this.n.sendEmptyMessageDelayed(10000, 60000L);
          this.h = paramLong1;
          this.i = paramString1;
          this.j = paramInt;
          this.l = paramString2;
          this.k = paramLong2;
          paramInt = 0;
          while (paramInt < localCopyOnWriteArrayList.size())
          {
            paramString1 = new e(this.m, (com.tencent.mobileqq.msf.core.d)localCopyOnWriteArrayList.get(paramInt), paramInt);
            paramString1.start();
            this.d.add(paramString1);
            paramInt += 1;
          }
        }
        this.e.set(false);
        QLog.d("ReqAllFailDetector", 1, "stopReqFailDetect by sso empty");
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        QLog.d("ReqAllFailDetector", 1, "startReqFailDetect fail by except", paramString1);
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    try
    {
      if ((this.e.get()) && (this.d.size() > 0))
      {
        int i1 = 0;
        while (i1 < this.d.size())
        {
          ((e)this.d.get(i1)).a(paramToServiceMsg);
          i1 += 1;
        }
      }
      return;
    }
    catch (Throwable paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
      QLog.d("ReqAllFailDetector", 1, "onSendRequest exception", paramToServiceMsg);
    }
  }
  
  public void b()
  {
    QLog.d("ReqAllFailDetector", 1, "stopReqFailDetect");
    this.e.set(false);
    Object localObject;
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localObject = this.d.iterator();
      while (((Iterator)localObject).hasNext())
      {
        e locale = (e)((Iterator)localObject).next();
        String str = locale.b();
        locale.a();
        this.d.remove(locale);
        if (localStringBuffer.length() > 0) {
          localStringBuffer.append("#");
        }
        localStringBuffer.append(str);
      }
      localObject = new HashMap();
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      QLog.d("ReqAllFailDetector", 1, "stopReqFailDetect exception", localThrowable);
      return;
    }
    ((HashMap)localObject).put("host", this.i);
    ((HashMap)localObject).put("port", String.valueOf(this.j));
    ((HashMap)localObject).put("reason", String.valueOf(this.l));
    ((HashMap)localObject).put("sendCount", String.valueOf(this.k));
    ((HashMap)localObject).put("connTime", String.valueOf(this.h));
    ((HashMap)localObject).put("detectInfo", localThrowable.toString());
    this.m.statReporter.a("dim.Msf.ConnRequestAllFailDetect", true, 0L, 0L, (Map)localObject, false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.a.c
 * JD-Core Version:    0.7.0.1
 */