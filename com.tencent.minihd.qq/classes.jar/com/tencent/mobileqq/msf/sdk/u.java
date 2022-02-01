package com.tencent.mobileqq.msf.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.RemoteException;
import com.tencent.mobileqq.msf.core.l;
import com.tencent.mobileqq.msf.core.m;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IBaseActionListener;
import com.tencent.qphone.base.remote.IBaseService;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class u
{
  private static final String a = "MSF.D.RemoteServiceProxy";
  private static int b = 0;
  private static long c = -1L;
  protected static ConcurrentLinkedQueue f = new ConcurrentLinkedQueue();
  protected static ConcurrentHashMap g = new ConcurrentHashMap();
  static final String m = "appTimeoutReq";
  protected volatile IBaseService d;
  protected Object e = new Object();
  protected volatile Handler h;
  protected volatile long i = -1L;
  protected volatile long j = -1L;
  protected volatile int k = -1;
  AtomicInteger l = new AtomicInteger();
  String n;
  protected ServiceConnection o = new v(this);
  
  public u(String paramString)
  {
    this.n = paramString;
  }
  
  protected int a(ToServiceMsg paramToServiceMsg)
    throws RemoteException
  {
    return this.d.sendToServiceMsg(paramToServiceMsg);
  }
  
  protected FromServiceMsg a(ToServiceMsg paramToServiceMsg, String paramString)
  {
    paramToServiceMsg = l.a(paramToServiceMsg);
    paramToServiceMsg.setBusinessFail(1013, paramString);
    return paramToServiceMsg;
  }
  
  void a()
  {
    if (!m.a()) {
      QLog.d("MSF.D.RemoteServiceProxy", 1, "startBaseServiceConn no allow");
    }
    for (;;)
    {
      return;
      try
      {
        ComponentName localComponentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.n);
        Intent localIntent = new Intent();
        localIntent.setComponent(localComponentName);
        BaseApplication.getContext().startService(localIntent);
        if (QLog.isColorLevel())
        {
          QLog.d("MSF.D.RemoteServiceProxy", 2, " start service finish");
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    c(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public int b(ToServiceMsg paramToServiceMsg)
  {
    int i1 = 1;
    if (paramToServiceMsg == null) {}
    for (;;)
    {
      return -1;
      if (paramToServiceMsg.getAppSeq() < 0) {
        paramToServiceMsg.setAppSeq(MsfSdkUtils.getNextAppSeq());
      }
      try
      {
        synchronized (this.e)
        {
          if (this.h == null)
          {
            HandlerThread localHandlerThread = new HandlerThread("Timeout-Checker", 5);
            localHandlerThread.start();
            this.h = new Handler(localHandlerThread.getLooper());
          }
          if (h())
          {
            if (paramToServiceMsg.getTimeout() == -1L) {
              paramToServiceMsg.setTimeout(30000L);
            }
            if (paramToServiceMsg.isNeedCallback())
            {
              paramToServiceMsg.addAttribute("appTimeoutReq", Integer.valueOf(this.l.incrementAndGet()));
              g.put(Integer.valueOf(paramToServiceMsg.getAppSeq()), paramToServiceMsg);
              ??? = new a(paramToServiceMsg);
              if (("LongConn.OffPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) || ("ImgStore.GroupPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())))
              {
                this.h.postDelayed((Runnable)???, paramToServiceMsg.getTimeout() + 20000L);
                QLog.d("MSF.D.RemoteServiceProxy", 1, "PicUpMsg timer start, appSeq: " + paramToServiceMsg.getAppSeq() + ", delayMillis: " + String.valueOf(paramToServiceMsg.getTimeout() + 20000L));
              }
            }
            else
            {
              if (i1 == 0) {
                break label425;
              }
              if (Build.VERSION.SDK_INT >= 21)
              {
                if (b > 0)
                {
                  long l1 = System.currentTimeMillis();
                  if ((-1L != c) && (l1 < c + 300000L))
                  {
                    ??? = BaseApplication.getContext().getSharedPreferences("pull_msf_succ", 0).edit();
                    ((SharedPreferences.Editor)???).putString("uin", paramToServiceMsg.getUin());
                    ((SharedPreferences.Editor)???).putString("time", new Date().toString());
                    ((SharedPreferences.Editor)???).commit();
                    QLog.d("MSF.D.RemoteServiceProxy", 1, "succ to pull msf service.");
                  }
                }
                b = 0;
              }
              i1 = a(paramToServiceMsg);
              return i1;
            }
          }
          else
          {
            i1 = 0;
          }
        }
      }
      catch (DeadObjectException localDeadObjectException)
      {
        for (;;)
        {
          c(paramToServiceMsg);
          return -1;
          this.h.postDelayed(localDeadObjectException, paramToServiceMsg.getTimeout() + 2000L);
        }
      }
      catch (Exception localException)
      {
        if (this.d == null)
        {
          c(paramToServiceMsg);
          return -1;
          label425:
          c(paramToServiceMsg);
          synchronized (this.e)
          {
            i();
            if ((Build.VERSION.SDK_INT < 21) || (b <= 10) || (System.currentTimeMillis() <= c + 60000L)) {
              continue;
            }
            ??? = BaseApplication.getContext().getSharedPreferences("pull_msf", 0).edit();
            ((SharedPreferences.Editor)???).putString("uin", paramToServiceMsg.getUin());
            ((SharedPreferences.Editor)???).putString("time", new Date().toString());
            ((SharedPreferences.Editor)???).commit();
            QLog.d("MSF.D.RemoteServiceProxy", 1, "cannot pull msf service.");
            return -1;
          }
        }
        ((Exception)???).printStackTrace();
      }
    }
    return -1;
  }
  
  boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (!m.a())
    {
      QLog.d("MSF.D.RemoteServiceProxy", 1, "startBaseServiceConn no allow");
      bool2 = bool1;
    }
    for (;;)
    {
      return bool2;
      bool1 = bool2;
      try
      {
        ComponentName localComponentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.n);
        bool1 = bool2;
        Intent localIntent = new Intent();
        bool1 = bool2;
        localIntent.setComponent(localComponentName);
        bool1 = bool2;
        boolean bool3 = BaseApplication.getContext().bindService(localIntent, this.o, 1);
        bool2 = bool3;
        bool1 = bool3;
        if (QLog.isColorLevel())
        {
          bool1 = bool3;
          QLog.d("MSF.D.RemoteServiceProxy", 2, " bind " + this.n + " service finished " + bool3);
          return bool3;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return bool1;
  }
  
  protected void c(ToServiceMsg paramToServiceMsg)
  {
    f.add(paramToServiceMsg);
  }
  
  protected void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    try
    {
      paramToServiceMsg.getActionListener().onRecvFromMsg(paramFromServiceMsg);
      return;
    }
    catch (RemoteException paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
    }
  }
  
  public boolean c()
  {
    try
    {
      ComponentName localComponentName = new ComponentName(BaseApplication.getContext(), this.n);
      Intent localIntent = new Intent();
      localIntent.setComponent(localComponentName);
      boolean bool = BaseApplication.getContext().stopService(localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.RemoteServiceProxy", 2, " stopService " + this.n + " service finished " + bool);
      }
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  protected void d()
  {
    w localw = new w(this);
    localw.setName("handleWaitSendProxyMsgThread");
    localw.start();
  }
  
  public void g()
  {
    try
    {
      BaseApplication.getContext().unbindService(this.o);
      this.d = null;
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.RemoteServiceProxy", 2, " unbindService service finished");
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected boolean h()
  {
    return this.d != null;
  }
  
  public void i()
  {
    if (!m.a()) {
      QLog.d("MSF.D.RemoteServiceProxy", 1, "startBaseServiceConn no allow");
    }
    for (;;)
    {
      return;
      long l1 = System.currentTimeMillis();
      if ((this.i == -1L) || (l1 - this.i > 10000L))
      {
        this.i = l1;
        a();
        b();
        return;
      }
      QLog.d("MSF.D.RemoteServiceProxy", 1, "wait start " + this.n + " service result, skiped...");
      try
      {
        int i1 = Build.VERSION.SDK_INT;
        if (i1 >= 21)
        {
          QLog.d("MSF.D.RemoteServiceProxy", 1, "sdk version:" + i1);
          long l2 = l1 - this.j;
          if ((this.j == -1L) || (l2 > 10000L))
          {
            if (b == 0) {
              c = l1;
            }
            b += 1;
            this.j = l1;
            Process localProcess = Runtime.getRuntime().exec("am stopservice --user 0 -n com.tencent.mobileqq/com.tencent.mobileqq.msf.service.MsfService");
            BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localProcess.getInputStream()));
            String str2;
            for (String str1 = "";; str1 = str1 + str2)
            {
              str2 = localBufferedReader.readLine();
              if (str2 == null) {
                break;
              }
            }
            localProcess.destroy();
            localBufferedReader.close();
            BaseApplication.getContext().sendBroadcast(new Intent("com.tencent.mobileqq.msf.startmsf"));
            this.k = 1;
            QLog.d("MSF.D.RemoteServiceProxy", 1, "start MsfService through Broadcast" + str1);
          }
          if ((this.j != -1L) && (l2 > this.k * 2000))
          {
            b();
            this.k += 1;
            QLog.d("MSF.D.RemoteServiceProxy", 1, "delay binding MSF Service");
            return;
          }
        }
      }
      catch (Exception localException)
      {
        QLog.d("MSF.D.RemoteServiceProxy", 1, "start MsfService exception " + localException.toString());
      }
    }
  }
  
  protected class a
    implements Runnable
  {
    private ToServiceMsg b;
    
    public a(ToServiceMsg paramToServiceMsg)
    {
      this.b = paramToServiceMsg;
    }
    
    public void run()
    {
      if (("LongConn.OffPicUp".equalsIgnoreCase(this.b.getServiceCmd())) || ("ImgStore.GroupPicUp".equalsIgnoreCase(this.b.getServiceCmd()))) {
        QLog.d("MSF.D.RemoteServiceProxy", 1, "enter MonitorTaskWrapper.run(), appseq is " + this.b.getAppSeq());
      }
      Object localObject = (ToServiceMsg)u.g.get(Integer.valueOf(this.b.getAppSeq()));
      if ((localObject != null) && (((ToServiceMsg)localObject).getAttribute("appTimeoutReq", Integer.valueOf(-1)) == this.b.getAttribute("appTimeoutReq", Integer.valueOf(-2))) && ((ToServiceMsg)u.g.remove(Integer.valueOf(this.b.getAppSeq())) != null))
      {
        QLog.d("MSF.D.RemoteServiceProxy", 1, "found timeout req, appseq is " + this.b.getAppSeq());
        localObject = u.this.a(this.b, this.b.getServiceName() + " timeout");
        u.this.a(this.b, (FromServiceMsg)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.u
 * JD-Core Version:    0.7.0.1
 */