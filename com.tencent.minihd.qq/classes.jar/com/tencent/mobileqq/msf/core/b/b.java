package com.tencent.mobileqq.msf.core.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.m;
import com.tencent.mobileqq.msf.core.e;
import com.tencent.mobileqq.msf.core.net.h;
import com.tencent.mobileqq.msf.core.s;
import com.tencent.mobileqq.msf.core.x;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class b
{
  public static final String b = "attr_quick_send";
  public static final String c = "attr_quick_send_resend_time";
  public HashMap a = new HashMap();
  public d d = new d();
  Handler e = new c(this);
  private String f = "QuickSendManager";
  private MsfCore g;
  private final int h = 1;
  private ConcurrentHashMap i = new ConcurrentHashMap();
  private AtomicBoolean j = new AtomicBoolean();
  private long k = 0L;
  private volatile Handler l;
  
  public b(MsfCore paramMsfCore)
  {
    this.g = paramMsfCore;
    this.i.clear();
    paramMsfCore = new HandlerThread("MsfCoreHttpTimeoutChecker", 5);
    paramMsfCore.start();
    this.l = new Handler(paramMsfCore.getLooper());
    a();
  }
  
  private void e(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {}
    while ((this.g.lightSender.a(paramToServiceMsg)) || (f(paramToServiceMsg))) {
      return;
    }
    g(paramToServiceMsg);
  }
  
  private boolean f(ToServiceMsg paramToServiceMsg)
  {
    if (TextUtils.isEmpty(paramToServiceMsg.getServiceCmd()))
    {
      QLog.d(this.f, 1, "tryResendMsg fail, cmd is null ");
      return false;
    }
    if (!paramToServiceMsg.isNeedCallback())
    {
      QLog.d(this.f, 1, "tryResendMsg fail, request don't need callback ");
      return false;
    }
    if (!this.a.containsKey(paramToServiceMsg.getServiceCmd()))
    {
      QLog.d(this.f, 1, "tryResendMsg fail, refuse quick send cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq());
      return false;
    }
    if (!this.i.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq())))
    {
      QLog.d(this.f, 1, "tryResendMsg fail, sendQueue don't contain msg, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq());
      return false;
    }
    if (paramToServiceMsg.getAttributes().containsKey("attr_quick_send_resend_time")) {}
    for (int m = ((Integer)paramToServiceMsg.getAttributes().get("attr_quick_send_resend_time")).intValue();; m = 0)
    {
      a locala = (a)this.a.get(paramToServiceMsg.getServiceCmd());
      if ((m < 1) || (m > locala.c))
      {
        QLog.d(this.f, 1, "tryResendMsg fail, msg has resend " + m + " times, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq());
        return false;
      }
      paramToServiceMsg.getAttributes().put("attr_quick_send_resend_time", Integer.valueOf(m + 1));
      Message localMessage = this.e.obtainMessage();
      localMessage.what = 1;
      localMessage.arg1 = paramToServiceMsg.getRequestSsoSeq();
      this.e.sendMessageDelayed(localMessage, locala.b);
      if (QLog.isColorLevel()) {
        QLog.d(this.f, 2, "tryResendMsg cmd:" + paramToServiceMsg.getServiceCmd() + " ssoSeq:" + paramToServiceMsg.getRequestSsoSeq() + " resendIndex: " + (m + 1) + " delayed: " + locala.b);
      }
      return true;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null) {}
    try
    {
      d(paramToServiceMsg);
      if (this.i.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))) {
        this.i.remove(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
      }
      return;
    }
    finally
    {
      paramToServiceMsg = finally;
      throw paramToServiceMsg;
    }
  }
  
  public a a(String paramString)
  {
    return (a)this.a.get(paramString);
  }
  
  void a()
  {
    this.a.put("MessageSvc.PbSendMsg", new a(15000L, 60000L, 8, true, false));
    this.a.put("ImgStore.GroupPicUp", new a(15000L, 60000L, 8, true, false));
    this.a.put("ImgStore.GroupPicDown", new a(15000L, 60000L, 8, true, false));
    this.a.put("LongConn.OffPicUp", new a(15000L, 60000L, 8, true, false));
    this.a.put("LongConn.OffPicDown", new a(15000L, 60000L, 8, true, false));
    b();
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    if (TextUtils.isEmpty(paramToServiceMsg.getServiceCmd()))
    {
      QLog.d(this.f, 1, "addQuickSendQueue fail, cmd is null ");
      return;
    }
    if (!paramToServiceMsg.isNeedCallback())
    {
      QLog.d(this.f, 1, "addQuickSendQueue fail, request don't need callback ");
      return;
    }
    if (!this.a.containsKey(paramToServiceMsg.getServiceCmd()))
    {
      QLog.d(this.f, 1, "addQuickSendQueue fail, refuse quick send cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq());
      return;
    }
    if (this.i.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq())))
    {
      QLog.d(this.f, 1, "addQuickSendQueue fail, msg has quick send, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq());
      return;
    }
    paramToServiceMsg.getAttributes().put("attr_quick_send", Boolean.valueOf(true));
    paramToServiceMsg.getAttributes().put("light_sender_type", Integer.valueOf(1));
    paramToServiceMsg.getAttributes().put("attr_quick_send_resend_time", Integer.valueOf(1));
    this.i.put(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), paramToServiceMsg);
    e(paramToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg == null) {
      QLog.d(this.f, 1, "onRecvResp toMsg is null");
    }
    do
    {
      do
      {
        return;
        if (paramFromServiceMsg != null) {
          break;
        }
        QLog.d(this.f, 1, "onRecvResp quicksend fail, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq() + " fromMsg is null");
      } while (f(paramToServiceMsg));
      g(paramToServiceMsg);
      return;
      if (paramFromServiceMsg.isSuccess()) {
        break;
      }
      QLog.d(this.f, 1, "onRecvResp quicksend fail, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq() + " code: " + paramFromServiceMsg.getBusinessFailCode() + " failmsg: " + paramFromServiceMsg.getBusinessFailMsg());
      if (paramFromServiceMsg.getBusinessFailCode() == 2901)
      {
        g(paramToServiceMsg);
        return;
      }
    } while (f(paramToServiceMsg));
    g(paramToServiceMsg);
    return;
    if (this.i.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq())))
    {
      QLog.d(this.f, 1, "onRecvResp quicksend succ, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq());
      try
      {
        x.a(paramToServiceMsg, paramFromServiceMsg, true);
        if ((this.g.quicksender != null) && (this.g.quicksender.b(paramToServiceMsg))) {
          this.g.quicksender.d.b(paramToServiceMsg, paramFromServiceMsg);
        }
        g(paramToServiceMsg);
        paramFromServiceMsg.getAttributes().put("_attr_send_by_quickHttp", Boolean.valueOf(true));
        paramFromServiceMsg.setAppId(paramToServiceMsg.getAppId());
        paramFromServiceMsg.setAppSeq(paramToServiceMsg.getAppSeq());
        paramFromServiceMsg.setMsfCommand(paramToServiceMsg.getMsfCommand());
        this.g.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
    QLog.d(this.f, 1, "onRecvResp quicksend result not notice, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq());
  }
  
  public boolean a(int paramInt)
  {
    return this.i.contains(Integer.valueOf(paramInt));
  }
  
  public void b()
  {
    for (;;)
    {
      int m;
      try
      {
        String[] arrayOfString = com.tencent.mobileqq.msf.core.a.a.R();
        if (arrayOfString == null) {
          return;
        }
        int n = arrayOfString.length;
        m = 0;
        if (m < n)
        {
          Object localObject2 = arrayOfString[m].split(":");
          if (localObject2 == null) {
            break label199;
          }
          Object localObject1 = localObject2[0];
          localObject2 = localObject2[1].split(";");
          if (localObject2 == null) {
            break label199;
          }
          long l1 = Integer.valueOf(localObject2[0]).intValue();
          long l2 = Integer.valueOf(localObject2[1]).intValue();
          int i1 = Integer.valueOf(localObject2[2]).intValue();
          if (!localObject2[3].equals("1")) {
            break label206;
          }
          bool1 = true;
          if (!localObject2[4].equals("1")) {
            break label212;
          }
          bool2 = true;
          localObject2 = new a(l1, l2, i1, bool1, bool2);
          if (((a)localObject2).e) {
            this.a.remove(localObject1);
          } else {
            this.a.put(localObject1, localObject2);
          }
        }
      }
      catch (Exception localException)
      {
        QLog.d(this.f, 1, "get send args error");
      }
      return;
      label199:
      m += 1;
      continue;
      label206:
      boolean bool1 = false;
      continue;
      label212:
      boolean bool2 = false;
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (this.a.containsKey(paramToServiceMsg.getServiceCmd()))
    {
      QLog.d(this.f, 1, "onRecvNormalResp, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq());
      g(paramToServiceMsg);
    }
  }
  
  public boolean b(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return false;
    }
    if (this.a.containsKey(paramToServiceMsg.getServiceCmd()))
    {
      a locala = (a)this.a.get(paramToServiceMsg.getServiceCmd());
      if (locala != null)
      {
        if (locala.a < paramToServiceMsg.getTimeout()) {
          return (!"MessageSvc.PbSendMsg".equals(paramToServiceMsg.getServiceCmd())) || (paramToServiceMsg.getAttributes().containsKey("normal_msg"));
        }
        QLog.d(this.f, 1, "no try quicksend request ssoseq: " + paramToServiceMsg.getRequestSsoSeq() + " by timeout error");
      }
    }
    return false;
  }
  
  public void c()
  {
    if (this.j.get())
    {
      QLog.d(this.f, 1, "quick heart beat has sending, return.");
      return;
    }
    if (this.g.sender.a.b())
    {
      this.j.set(true);
      ToServiceMsg localToServiceMsg = new ToServiceMsg("", "0", "Heartbeat.Ping");
      localToServiceMsg.setMsfCommand(MsfCommand._msf_QuickHeartBeat);
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localToServiceMsg.setAppId(this.g.getMsfAppid());
      localToServiceMsg.putWupBuffer(new byte[] { 0, 0, 0, 4 });
      localToServiceMsg.setTimeout(com.tencent.mobileqq.msf.core.a.a.v());
      localToServiceMsg.getAttributes().put("quickSendDetectTime", Long.valueOf(SystemClock.elapsedRealtime()));
      this.g.sender.a(localToServiceMsg);
      return;
    }
    this.j.set(false);
  }
  
  public void c(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      a locala = a(paramToServiceMsg.getServiceCmd());
      if ((locala != null) && (locala.a >= 5000L))
      {
        a locala1 = new a(paramToServiceMsg);
        this.l.postDelayed(locala1, locala.a);
        paramToServiceMsg.getAttributes().put("to_msgtimeoutCallbacker", locala1);
      }
    }
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l2 = 0L;
    boolean bool = false;
    long l1 = l2;
    if (paramToServiceMsg != null)
    {
      l1 = l2;
      if (paramToServiceMsg.getAttributes().containsKey("quickSendDetectTime"))
      {
        long l3 = ((Long)paramToServiceMsg.getAttributes().get("quickSendDetectTime")).longValue();
        l1 = l2;
        if (l3 > 0L) {
          l1 = SystemClock.elapsedRealtime() - l3;
        }
      }
    }
    int m;
    if (paramFromServiceMsg.getBusinessFailCode() == 1002)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.f, 2, "handleQuickHeartbeat wait " + paramToServiceMsg + " timeout.");
      }
      if (!this.g.sender.a.b())
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.f, 2, "conn is also closed, stop quick detecting");
        }
        this.j.set(false);
        m = 1;
        if (this.g.statReporter != null)
        {
          paramToServiceMsg = new HashMap();
          if (this.g.getAccountCenter() == null) {
            break label440;
          }
          paramToServiceMsg.put("account", this.g.getAccountCenter().i());
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        paramToServiceMsg.put("closeType", "" + m);
        this.g.statReporter.a("dim.Msf.QuickSendDetect", bool, l1, 0L, paramToServiceMsg, false, false);
        return;
        l2 = SystemClock.elapsedRealtime();
        if (l2 > this.k + com.tencent.mobileqq.msf.core.a.a.w())
        {
          this.k = l2;
          try
          {
            QLog.d(this.f, 1, "handleQuickHeartbeat disconn: " + System.currentTimeMillis() + " mLastDetectDisconnTime:" + l2);
            this.g.sender.a.a(com.tencent.qphone.base.a.A);
            m = 2;
            this.j.set(false);
            break;
          }
          catch (Exception paramToServiceMsg)
          {
            QLog.d(this.f, 1, "handleQuickHeartbeat disconn error", paramToServiceMsg);
            this.j.set(false);
            m = 0;
            break;
          }
          finally
          {
            this.j.set(false);
          }
        }
      }
      this.j.set(false);
      QLog.d(this.f, 1, "handleQuickHeartbeat stop disconn by too frequency.");
      m = 0;
      break;
      QLog.d(this.f, 1, "recv Quick heart resp.now conn is alive.");
      this.j.set(false);
      bool = true;
      m = 0;
      break;
      label440:
      paramToServiceMsg.put("account", this.g.sender.h());
    }
  }
  
  public void d(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg != null) && (paramToServiceMsg.getAttributes().containsKey("to_msgtimeoutCallbacker")))
    {
      QLog.d(this.f, 1, "remove timoutchecker for msg");
      Runnable localRunnable = (Runnable)paramToServiceMsg.getAttributes().get("to_msgtimeoutCallbacker");
      this.l.removeCallbacks(localRunnable);
      paramToServiceMsg.getAttributes().remove("to_msgtimeoutCallbacker");
    }
  }
  
  class a
    implements Runnable
  {
    private ToServiceMsg b;
    
    public a(ToServiceMsg paramToServiceMsg)
    {
      this.b = paramToServiceMsg;
    }
    
    public void run()
    {
      if (this.b == null) {
        QLog.d(b.b(b.this), 1, "req null, return.");
      }
      for (;;)
      {
        return;
        try
        {
          if ((b.c(b.this).quicksender != null) && (b.c(b.this).quicksender.b(this.b))) {
            b.c(b.this).quicksender.d.b(this.b);
          }
          b.this.a(this.b);
          a locala = b.this.a(this.b.getServiceCmd());
          if ((locala == null) || (!locala.d)) {
            continue;
          }
          b.this.c();
          return;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            localThrowable.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.b.b
 * JD-Core Version:    0.7.0.1
 */