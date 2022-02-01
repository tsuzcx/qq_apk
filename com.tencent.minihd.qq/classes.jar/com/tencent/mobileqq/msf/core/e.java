package com.tencent.mobileqq.msf.core;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.a.a;
import com.tencent.mobileqq.msf.core.c.m;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class e
{
  public static final String a = "send_mode";
  public static final int b = 0;
  public static final int c = 1;
  public static final String d = "unknown";
  public static final String e = "pcactive";
  public static final String f = "quicksend";
  public static final int g = 0;
  public static final int h = -1;
  public static final int i = 1;
  public static final int j = 2;
  public static final int k = 3;
  public static final int l = 4;
  public static final int m = 5;
  public static final int n = 6;
  public static final String o = "light_sender_type";
  public static final int p = 0;
  public static final int q = 1;
  private static final String r = "LightSender";
  private MsfCore s;
  private LinkedBlockingQueue t = new LinkedBlockingQueue();
  private LinkedList u = new LinkedList();
  private long v = 0L;
  private ThreadPoolExecutor w;
  private int x = a.P();
  private int y = a.P();
  private int z = 60;
  
  public e(MsfCore paramMsfCore, Context paramContext)
  {
    this.s = paramMsfCore;
    CodecWarpper.setKsid(paramMsfCore.getAccountCenter().f());
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.w = new ThreadPoolExecutor(this.x, this.y, this.z, TimeUnit.SECONDS, this.t, new a("LightSender"));
      this.w.allowCoreThreadTimeOut(true);
      return;
    }
    this.w = new ThreadPoolExecutor(1, 1, this.z, TimeUnit.SECONDS, this.t, new a("LightSender"));
  }
  
  private FromServiceMsg a(FromServiceMsg paramFromServiceMsg)
  {
    byte[] arrayOfByte1;
    int i1;
    if ((paramFromServiceMsg.getFlag() & 0x1) != 0)
    {
      arrayOfByte1 = paramFromServiceMsg.getWupBuffer();
      if (arrayOfByte1.length > 4) {
        i1 = (arrayOfByte1[0] & 0xFF) << 24 | 0x0 | (arrayOfByte1[1] & 0xFF) << 16 | (arrayOfByte1[2] & 0xFF) << 8 | arrayOfByte1[3] & 0xFF;
      }
    }
    else
    {
      try
      {
        byte[] arrayOfByte2 = new byte[i1];
        System.arraycopy(arrayOfByte1, 4, arrayOfByte2, 0, i1 - 4);
        arrayOfByte1 = com.tencent.qphone.base.util.f.b(arrayOfByte2);
        arrayOfByte2 = new byte[arrayOfByte1.length + 4];
        arrayOfByte2[0] = ((byte)(arrayOfByte1.length + 4 >> 24 & 0xFF));
        arrayOfByte2[1] = ((byte)(arrayOfByte1.length + 4 >> 16 & 0xFF));
        arrayOfByte2[2] = ((byte)(arrayOfByte1.length + 4 >> 8 & 0xFF));
        arrayOfByte2[3] = ((byte)(arrayOfByte1.length + 4 & 0xFF));
        System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 4, arrayOfByte1.length);
        paramFromServiceMsg.putWupBuffer(arrayOfByte2);
        return paramFromServiceMsg;
      }
      catch (Throwable paramFromServiceMsg)
      {
        QLog.d("LightSender", 1, "LightSender uncompress data failed", paramFromServiceMsg);
        return null;
      }
    }
    return null;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt, String paramString, com.tencent.mobileqq.msf.core.b.f paramf)
  {
    paramf.f = paramInt;
    if (paramFromServiceMsg == null)
    {
      paramFromServiceMsg = l.a(paramToServiceMsg);
      if (paramFromServiceMsg != null)
      {
        paramFromServiceMsg.setBusinessFail(paramInt, paramString);
        this.s.getSsoRespHandler().b(paramToServiceMsg, paramFromServiceMsg);
      }
      return;
    }
    this.s.getSsoRespHandler().b(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private boolean a(com.tencent.mobileqq.msf.core.net.d paramd, String paramString, int paramInt, com.tencent.mobileqq.msf.core.b.f paramf)
  {
    Object localObject;
    if (NetConnInfoCenterImpl.isWifiConn()) {
      localObject = this.s.getSsoListManager().j();
    }
    while (localObject != null)
    {
      localObject = ((CopyOnWriteArrayList)localObject).iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          d locald = (d)((Iterator)localObject).next();
          paramd.a(locald.e());
          boolean bool = paramd.a(locald.c(), locald.d(), paramString, paramf);
          paramf.k += 1;
          if (bool)
          {
            return true;
            localObject = this.s.getSsoListManager().k();
            break;
          }
        }
      }
      QLog.d("LightSender", 1, "LightSender connect all fail ssoseq:" + paramInt);
      return false;
    }
    QLog.d("LightSender", 1, "LightSender ssolist is empty ssoseq:" + paramInt);
    return false;
  }
  
  private boolean c()
  {
    return this.t.size() + this.w.getActiveCount() >= this.y;
  }
  
  private byte d()
  {
    int i2 = 254;
    if (NetConnInfoCenterImpl.isWifiConn()) {
      return 1;
    }
    int i1;
    if (NetConnInfoCenterImpl.isMobileConn())
    {
      i1 = NetConnInfoCenterImpl.getMobileNetworkType() + 100;
      if (i1 <= 254) {
        break label144;
      }
      i1 = i2;
      if (QLog.isColorLevel())
      {
        QLog.d("LightSender", 2, "error,netWorkType is " + 254);
        i1 = i2;
      }
    }
    label144:
    for (;;)
    {
      return (byte)i1;
      long l1 = System.currentTimeMillis();
      if ((this.v == 0L) || (l1 - this.v > 60000L))
      {
        this.v = l1;
        try
        {
          NetConnInfoCenter.checkConnInfo(BaseApplication.getContext(), true);
          return 0;
        }
        catch (Throwable localThrowable)
        {
          QLog.d("LightSender", 1, "checkConnInfo " + localThrowable);
        }
      }
      return 0;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("LightSender", 2, "LightSender, addSendQueue cmd:" + paramToServiceMsg.getServiceCmd() + " ssoSeq:" + paramToServiceMsg.getRequestSsoSeq());
      }
      b localb = new b(paramToServiceMsg);
      this.w.submit(localb);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("LightSender", 1, "submit task failed, cmd:" + paramToServiceMsg.getServiceCmd() + " ssoSeq:" + paramToServiceMsg.getRequestSsoSeq(), localException);
    }
  }
  
  private String e(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg != null) && (paramToServiceMsg.getServiceCmd().equals("MessageSvc.QueryPullUp"))) {
      return "pcactive";
    }
    if ((paramToServiceMsg != null) && (this.s.quicksender != null) && (this.s.quicksender.a.containsKey(paramToServiceMsg.getServiceCmd()))) {
      return "quicksend";
    }
    return "unknown";
  }
  
  private byte[] f(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return null;
    }
    try
    {
      String str = paramToServiceMsg.getServiceCmd();
      if (paramToServiceMsg.getWupBuffer() != null)
      {
        byte b1 = d();
        int i1 = 0;
        if (paramToServiceMsg.getAttributes().containsKey("send_mode")) {
          i1 = ((Integer)paramToServiceMsg.getAttributes().get("send_mode")).intValue();
        }
        if (i1 == 1) {
          return CodecWarpper.encodeRequest(paramToServiceMsg.getRequestSsoSeq(), l.d(), l.f(), l.g(), "", str, null, paramToServiceMsg.getAppId(), this.s.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, paramToServiceMsg.getWupBuffer(), true);
        }
        return CodecWarpper.encodeRequest(paramToServiceMsg.getRequestSsoSeq(), l.d(), l.f(), l.g(), "", str, null, paramToServiceMsg.getAppId(), this.s.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, paramToServiceMsg.getWupBuffer(), true);
      }
      return new byte[0];
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      QLog.d("LightSender", 1, "LightSender get packet fail ssoseq: " + paramToServiceMsg.getRequestSsoSeq(), localThrowable);
    }
    return null;
  }
  
  public void a()
  {
    if (!this.t.isEmpty())
    {
      Iterator localIterator = this.t.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if ((localb != null) && (localb.a != null) && (localb.a.getServiceName().equals("MessageSvc.QueryPullUp"))) {
          localIterator.remove();
        }
      }
    }
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {}
    label123:
    for (boolean bool = false;; bool = false)
    {
      return bool;
      for (;;)
      {
        try
        {
          if (paramToServiceMsg.getAttributes().containsKey("light_sender_type"))
          {
            i1 = ((Integer)paramToServiceMsg.getAttributes().get("light_sender_type")).intValue();
            if ((i1 == 1) && (c()))
            {
              if (!QLog.isColorLevel()) {
                break label123;
              }
              QLog.d("LightSender", 2, "LightSender busy returns, cmd:" + paramToServiceMsg.getServiceCmd() + " ssoSeq:" + paramToServiceMsg.getRequestSsoSeq());
              break label123;
            }
            d(paramToServiceMsg);
            bool = true;
            break;
          }
        }
        finally {}
        int i1 = 0;
      }
    }
  }
  
  public void b()
  {
    if (!this.u.isEmpty())
    {
      Iterator localIterator = this.u.iterator();
      while (localIterator.hasNext())
      {
        ToServiceMsg localToServiceMsg = (ToServiceMsg)localIterator.next();
        if (localToServiceMsg.getServiceCmd().equals("MessageSvc.QueryPullUp")) {
          localToServiceMsg.getAttributes().put("RequestEcho", Boolean.valueOf(false));
        }
      }
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg)
  {
    Iterator localIterator = this.u.iterator();
    while (localIterator.hasNext())
    {
      ToServiceMsg localToServiceMsg = (ToServiceMsg)localIterator.next();
      if (paramToServiceMsg.getRequestSsoSeq() == localToServiceMsg.getRequestSsoSeq()) {
        localIterator.remove();
      }
    }
  }
  
  public boolean c(ToServiceMsg paramToServiceMsg)
  {
    int i2;
    int i1;
    int i4;
    int i3;
    if (paramToServiceMsg != null)
    {
      i2 = paramToServiceMsg.getRequestSsoSeq();
      if (paramToServiceMsg.getAttributes().containsKey("attr_quick_send_resend_time"))
      {
        i1 = ((Integer)paramToServiceMsg.getAttributes().get("attr_quick_send_resend_time")).intValue();
        if (paramToServiceMsg.getAttributes().containsKey("retryIndex"))
        {
          i4 = ((Integer)paramToServiceMsg.getAttributes().get("retryIndex")).intValue();
          i3 = i1;
          i1 = i4;
        }
      }
    }
    for (;;)
    {
      com.tencent.mobileqq.msf.core.b.f localf = new com.tencent.mobileqq.msf.core.b.f();
      localf.b = SystemClock.elapsedRealtime();
      localf.a = false;
      com.tencent.mobileqq.msf.core.net.d locald = new com.tencent.mobileqq.msf.core.net.d(i2);
      if ((QLog.isColorLevel()) || (QLog.isDevelopLevel())) {
        QLog.d("LightSender", 1, "trySendMsg cmd:" + paramToServiceMsg.getServiceCmd() + " ssoSeq:" + paramToServiceMsg.getRequestSsoSeq() + " resendIndex: " + i3);
      }
      try
      {
        Object localObject1 = f(paramToServiceMsg);
        if (localObject1 == null)
        {
          a(paramToServiceMsg, null, 1, "sendData ssoseq:" + i2 + ", send buffer is empty", localf);
          return false;
          localObject3 = new StringBuilder().append("trySendMsg cmd:");
          if (paramToServiceMsg.getServiceCmd() != null) {}
          for (localObject1 = Integer.valueOf(paramToServiceMsg.getServiceCmd().hashCode());; localObject1 = "null")
          {
            QLog.d("LightSender", 1, localObject1 + " ssoSeq:" + paramToServiceMsg.getRequestSsoSeq() + " resendIndex: " + i3);
            break;
          }
        }
        Object localObject3 = e(paramToServiceMsg);
        localf.c = paramToServiceMsg.getUin();
        localf.d = paramToServiceMsg.getServiceCmd();
        localf.e = localObject1.length;
        localf.g = SystemClock.elapsedRealtime();
        localf.j = localf.g;
        boolean bool = a(locald, (String)localObject3, i2, localf);
        localf.j = (SystemClock.elapsedRealtime() - localf.j);
        localf.i = bool;
        if (!bool)
        {
          localf.g = (SystemClock.elapsedRealtime() - localf.g);
          a(paramToServiceMsg, null, 2, "sendData ssoseq:" + i2 + ", connect failed", localf);
          return false;
        }
        localObject1 = locald.a((byte[])localObject1, localf);
        localf.g = (SystemClock.elapsedRealtime() - localf.g);
        if (localObject1 == null)
        {
          a(paramToServiceMsg, null, 3, "sendData ssoseq:" + i2 + ", recv data failed", localf);
          return false;
        }
        localObject1 = this.s.sender.p.parseData((byte[])localObject1);
        if (localObject1 != null)
        {
          localObject1 = a((FromServiceMsg)localObject1);
          if (localObject1 == null)
          {
            a(paramToServiceMsg, null, 5, "sendData ssoseq:" + i2 + ", recv data failed", localf);
            return false;
          }
          ((FromServiceMsg)localObject1).setRequestSsoSeq(((FromServiceMsg)localObject1).getAppSeq());
          if (paramToServiceMsg != null)
          {
            ((FromServiceMsg)localObject1).setAppSeq(paramToServiceMsg.getAppSeq());
            ((FromServiceMsg)localObject1).setMsfCommand(paramToServiceMsg.getMsfCommand());
            ((FromServiceMsg)localObject1).setAppId(paramToServiceMsg.getAppId());
            ((FromServiceMsg)localObject1).setRequestSsoSeq(paramToServiceMsg.getRequestSsoSeq());
          }
          if (!this.s.getSsoRespHandler().a(paramToServiceMsg, (FromServiceMsg)localObject1)) {
            a(paramToServiceMsg, null, 6, "sendData ssoseq:" + i2 + ", recv new ssolist", localf);
          }
          localf.a = true;
          return true;
        }
        a(paramToServiceMsg, null, 4, "sendData ssoseq:" + i2 + ", parse data failed", localf);
        return false;
      }
      catch (Throwable localThrowable)
      {
        a(paramToServiceMsg, null, -1, "sendData ssoseq:" + i2 + ", exception", localf);
        localThrowable.printStackTrace();
        QLog.d("LightSender", 1, "LightSender doSendData ssoseq:" + i2 + " exception, ", localThrowable);
        return false;
      }
      finally
      {
        locald.a();
        locald.b();
        localf.b = (SystemClock.elapsedRealtime() - localf.b);
        if ((this.s.statReporter != null) && (this.s.quicksender != null) && (paramToServiceMsg != null) && (this.s.quicksender.b(paramToServiceMsg)))
        {
          paramToServiceMsg = new HashMap();
          paramToServiceMsg.put("isSucc", Boolean.toString(localf.a));
          paramToServiceMsg.put("costtime", Long.toString(localf.b));
          paramToServiceMsg.put("account", localf.c);
          paramToServiceMsg.put("cmd", localf.d);
          paramToServiceMsg.put("datalen", Integer.toString(localf.e));
          paramToServiceMsg.put("sendFailReason", Integer.toString(localf.f));
          paramToServiceMsg.put("sendCosttime", Long.toString(localf.g));
          paramToServiceMsg.put("isConnSucc", Boolean.toString(localf.i));
          paramToServiceMsg.put("connCosttime", Long.toString(localf.j));
          paramToServiceMsg.put("connCount", Integer.toString(localf.k));
          paramToServiceMsg.put("connFailReason", localf.l);
          paramToServiceMsg.put("sendExcpt", localf.h);
          paramToServiceMsg.put("reIndex", "" + i3);
          paramToServiceMsg.put("msgReIndex", "" + i1);
          this.s.statReporter.a("dim.Msf.QuickSend", localf.a, localf.g + localf.j, 0L, paramToServiceMsg, false, false);
        }
      }
      i4 = -1;
      i3 = i1;
      i1 = i4;
      continue;
      i1 = 0;
      break;
      i1 = -1;
      i3 = 0;
      i2 = 0;
    }
  }
  
  static class a
    implements ThreadFactory
  {
    private static final AtomicInteger a = new AtomicInteger(1);
    private final ThreadGroup b;
    private final AtomicInteger c = new AtomicInteger(1);
    private final String d;
    
    a(String paramString)
    {
      Object localObject = System.getSecurityManager();
      if (localObject != null) {}
      for (localObject = ((SecurityManager)localObject).getThreadGroup();; localObject = Thread.currentThread().getThreadGroup())
      {
        this.b = ((ThreadGroup)localObject);
        this.d = (paramString + "-pool-" + a.getAndIncrement() + "-thread-");
        return;
      }
    }
    
    public Thread newThread(Runnable paramRunnable)
    {
      paramRunnable = new Thread(this.b, paramRunnable, this.d + this.c.getAndIncrement(), 0L);
      if (paramRunnable.isDaemon()) {
        paramRunnable.setDaemon(false);
      }
      if (paramRunnable.getPriority() != 5) {
        paramRunnable.setPriority(5);
      }
      return paramRunnable;
    }
  }
  
  class b
    implements Runnable
  {
    public ToServiceMsg a;
    
    b(ToServiceMsg paramToServiceMsg)
    {
      this.a = paramToServiceMsg;
    }
    
    public void run()
    {
      try
      {
        String str = Thread.currentThread().getName();
        int i = e.a(e.this).getActiveCount();
        if (QLog.isColorLevel()) {
          QLog.d("LightSender", 2, "threadName: " + str + " threadPoolAccount: " + i);
        }
        if (this.a == null) {
          return;
        }
        e.b(e.this).add(this.a);
        e.this.c(this.a);
        e.this.b(this.a);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.d("LightSender", 1, "LightSender sendTask exception,", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.e
 * JD-Core Version:    0.7.0.1
 */