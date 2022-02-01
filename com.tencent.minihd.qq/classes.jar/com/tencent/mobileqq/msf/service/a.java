package com.tencent.mobileqq.msf.service;

import android.os.DeadObjectException;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.e;
import com.tencent.mobileqq.msf.core.c.e.a;
import com.tencent.mobileqq.msf.core.c.m;
import com.tencent.mobileqq.msf.core.push.d;
import com.tencent.mobileqq.msf.core.push.f;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IMsfServiceCallbacker;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

class a
  extends Thread
{
  private static final int e = 10;
  volatile Object a = new Object();
  volatile boolean b = false;
  volatile boolean c = true;
  int d = 0;
  
  private static boolean a(String paramString, b paramb)
  {
    int i = 0;
    int j;
    MsfMessagePair localMsfMessagePair2;
    label43:
    Object localObject1;
    boolean bool2;
    label65:
    Object localObject2;
    label95:
    boolean bool1;
    label214:
    label233:
    boolean bool3;
    if (!paramb.g.isEmpty())
    {
      i += 1;
      j = i;
      if (i <= 10)
      {
        localMsfMessagePair2 = (MsfMessagePair)paramb.g.peek();
        if (localMsfMessagePair2 == null) {
          j = i;
        }
      }
      else
      {
        if (j <= 10) {
          break label1086;
        }
        return true;
      }
      localObject1 = paramb.c();
      if (localObject1 == null)
      {
        bool2 = true;
        if (!bool2) {
          break label444;
        }
        bool2 = false;
        localObject2 = localMsfMessagePair2.fromServiceMsg.getServiceCmd();
        localObject1 = BaseConstants.CMD_NeedBootPushCmdHeads;
        int k = localObject1.length;
        j = 0;
        bool1 = bool2;
        if (j < k)
        {
          Object localObject3 = localObject1[j];
          if ((localObject2 == null) || (!((String)localObject2).startsWith((String)localObject3))) {
            break label437;
          }
          paramb.a = false;
          paramb.c = false;
          if ((!"LongConn.OffPicUp".equalsIgnoreCase((String)localObject2)) && (!"ImgStore.GroupPicUp".equalsIgnoreCase((String)localObject2))) {
            break label1088;
          }
          localObject3 = new StringBuilder().append("dispatchMsg:").append((String)localObject2).append(" resp:").append(localMsfMessagePair2.fromServiceMsg.getStringForLog()).append(" req:");
          if (localMsfMessagePair2.toServiceMsg == null) {
            break label430;
          }
          localObject1 = localMsfMessagePair2.toServiceMsg.getStringForLog();
          QLog.d("MSF.S.AppProcessManager", 1, (String)localObject1);
          bool1 = true;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MSF.S.AppProcessManager", 2, paramString + "'s callBack is null; " + (String)localObject2 + " is cared: " + bool1);
        }
        bool3 = true;
        bool2 = bool1;
        bool1 = bool3;
      }
    }
    for (;;)
    {
      label290:
      if (("LongConn.OffPicUp".equalsIgnoreCase(localMsfMessagePair2.fromServiceMsg.getServiceCmd())) || ("ImgStore.GroupPicUp".equalsIgnoreCase(localMsfMessagePair2.fromServiceMsg.getServiceCmd()))) {
        QLog.d("MSF.S.AppProcessManager", 1, "dispatchMsg:" + localMsfMessagePair2.fromServiceMsg.getStringForLog() + " processDied:" + bool2 + " isSendToSink:" + bool1);
      }
      if (localMsfMessagePair2.fromServiceMsg.getAttribute("resp_needBootApp") != null)
      {
        bool1 = true;
        label390:
        if (bool2) {
          break label779;
        }
        paramb.g.poll();
        if (bool1) {
          paramb.a(3, localMsfMessagePair2.fromServiceMsg.getUin());
        }
      }
      for (;;)
      {
        for (;;)
        {
          break;
          bool2 = false;
          break label65;
          label430:
          localObject1 = "null";
          break label214;
          label437:
          j += 1;
          break label95;
          label444:
          if ((paramb.c == true) && (localMsfMessagePair2.fromServiceMsg.getMsfCommand() != MsfCommand.setMsfConnStatus))
          {
            j = i;
            if (SystemClock.elapsedRealtime() - paramb.b < 2000L) {
              break label43;
            }
            paramb.c = false;
            if (QLog.isColorLevel()) {
              QLog.d("MSF.S.AppProcessManager", 2, "half close timeout " + paramString + " isAppConnected " + paramb.a);
            }
          }
          try
          {
            if (localMsfMessagePair2.toServiceMsg == null)
            {
              ((IMsfServiceCallbacker)localObject1).onRecvPushResp(localMsfMessagePair2.fromServiceMsg);
              if (QLog.isColorLevel()) {
                QLog.d("MSF.S.AppProcessManager", 2, "send push " + paramString + " from:" + localMsfMessagePair2.fromServiceMsg);
              }
            }
            else
            {
              ((IMsfServiceCallbacker)localObject1).onResponse(localMsfMessagePair2.toServiceMsg, localMsfMessagePair2.fromServiceMsg);
              if (QLog.isColorLevel()) {
                QLog.d("MSF.S.AppProcessManager", 2, "send resp " + paramString + " to:" + localMsfMessagePair2.toServiceMsg + " from:" + localMsfMessagePair2.fromServiceMsg);
              }
            }
          }
          catch (DeadObjectException localDeadObjectException)
          {
            bool3 = true;
            boolean bool4 = false;
            paramb.d();
            bool1 = bool4;
            bool2 = bool3;
            if (!QLog.isColorLevel()) {
              break label290;
            }
            QLog.d("MSF.S.AppProcessManager", 2, "DeadObjectException");
            bool1 = bool4;
            bool2 = bool3;
            break label290;
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MSF.S.AppProcessManager", 2, localMsfMessagePair2.toString() + " " + localMsfMessagePair2.fromServiceMsg, localException);
            }
            bool1 = false;
          }
        }
        break label290;
        bool1 = false;
        break label390;
        label779:
        if (QLog.isColorLevel()) {
          QLog.d("MSF.S.AppProcessManager", 2, "need boot " + bool1 + " " + paramString + " from:" + localMsfMessagePair2.fromServiceMsg);
        }
        if (bool1)
        {
          paramb.a(0, localMsfMessagePair2.fromServiceMsg.getUin());
          paramb.d += 1L;
          if (paramb.d > 100L)
          {
            MsfMessagePair localMsfMessagePair1 = (MsfMessagePair)paramb.g.poll();
            localObject2 = new HashMap();
            c.a((HashMap)localObject2);
            ((HashMap)localObject2).put("MsgType", localMsfMessagePair1.fromServiceMsg.toString());
            ((HashMap)localObject2).put("ProcName", paramString);
            ((HashMap)localObject2).put("uin", localMsfMessagePair1.fromServiceMsg.getUin());
            ((HashMap)localObject2).put("appid", String.valueOf(localMsfMessagePair1.fromServiceMsg.getAppId()));
            ((HashMap)localObject2).put("MsgLeft", String.valueOf(paramb.g.size()));
            c.e.getStatReporter().a("dim.Msf.ForkProcFailed", false, 0L, 0L, (Map)localObject2, true, false);
            paramb.d = 0L;
            if ((localMsfMessagePair2.fromServiceMsg != null) && (localMsfMessagePair2.fromServiceMsg.getServiceCmd() != null) && (localMsfMessagePair2.fromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))) {
              e.a().a(e.a.c, localMsfMessagePair2.fromServiceMsg.getWupBuffer(), 14);
            }
          }
          return false;
        }
        paramb.g.poll();
        if (i == 1) {
          paramb.a(1, localMsfMessagePair2.fromServiceMsg.getUin());
        }
      }
      label1086:
      return false;
      label1088:
      bool1 = true;
      break label233;
      j = i;
      break label43;
      bool1 = true;
    }
  }
  
  private static boolean b(String paramString, b paramb)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (!paramb.g.isEmpty())
      {
        if (i <= 10) {
          break label31;
        }
        bool1 = true;
      }
      label31:
      MsfMessagePair localMsfMessagePair;
      do
      {
        return bool1;
        localMsfMessagePair = (MsfMessagePair)paramb.g.peek();
        bool1 = bool2;
      } while (localMsfMessagePair == null);
      if (localMsfMessagePair.fromServiceMsg.getAttribute("resp_needBootApp") != null) {}
      for (int j = 1;; j = 0)
      {
        Object localObject;
        if ((paramb.c() == null) && (j != 0))
        {
          bool1 = bool2;
          if (localMsfMessagePair.fromServiceMsg == null) {
            break;
          }
          localObject = BaseConstants.CMD_NeedBootPushCmdHeads;
          j = localObject.length;
          i = 0;
          label101:
          if (i >= j) {
            break label1091;
          }
          String str = localObject[i];
          if (!localMsfMessagePair.fromServiceMsg.getServiceCmd().startsWith(str)) {}
        }
        label1091:
        for (i = 1;; i = 0)
        {
          for (;;)
          {
            if (i != 0)
            {
              paramb.a = false;
              paramb.c = false;
              i = c.e.getUinPushStatus(localMsfMessagePair.fromServiceMsg.getUin());
              h.a(BaseApplication.getContext(), paramString, localMsfMessagePair.fromServiceMsg.getUin(), ((b)c.c.get(paramString)).b(), i);
              MsfService.getCore().pushManager.i.a();
              if (QLog.isColorLevel()) {
                QLog.d("MSF.S.AppProcessManager", 2, "need boot app " + paramString + " from:" + localMsfMessagePair.fromServiceMsg);
              }
              paramb.d += 1L;
              bool1 = bool2;
              if (paramb.d <= 100L) {
                break;
              }
              localMsfMessagePair = (MsfMessagePair)paramb.g.poll();
              localObject = new HashMap();
              c.a((HashMap)localObject);
              ((HashMap)localObject).put("MsgType", localMsfMessagePair.fromServiceMsg.toString());
              ((HashMap)localObject).put("ProcName", paramString);
              ((HashMap)localObject).put("uin", localMsfMessagePair.fromServiceMsg.getUin());
              ((HashMap)localObject).put("appid", String.valueOf(localMsfMessagePair.fromServiceMsg.getAppId()));
              ((HashMap)localObject).put("MsgLeft", String.valueOf(paramb.g.size()));
              c.e.getStatReporter().a("dim.Msf.ForkProcFailed", false, 0L, 0L, (Map)localObject, true, false);
              paramb.d = 0L;
              return false;
              i += 1;
              break label101;
            }
            paramb.g.poll();
            bool1 = bool2;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("MSF.S.AppProcessManager", 2, "need boot app but not in CMD_NeedBootPushCmdHeads " + paramString + " from:" + localMsfMessagePair.fromServiceMsg);
            return false;
            if ((paramb.c == true) && (localMsfMessagePair.fromServiceMsg.getMsfCommand() != MsfCommand.setMsfConnStatus))
            {
              bool1 = bool2;
              if (SystemClock.elapsedRealtime() - paramb.b < 2000L) {
                break;
              }
              paramb.c = false;
              if (QLog.isColorLevel()) {
                QLog.d("MSF.S.AppProcessManager", 2, "half close timeout " + paramString + " isAppConnected " + paramb.a);
              }
            }
            if (!paramb.a) {
              break label963;
            }
            try
            {
              if (localMsfMessagePair.toServiceMsg == null)
              {
                paramb.c().onRecvPushResp(localMsfMessagePair.fromServiceMsg);
                if (QLog.isColorLevel()) {
                  QLog.d("MSF.S.AppProcessManager", 2, "send push " + paramString + " from:" + localMsfMessagePair.fromServiceMsg);
                }
              }
              for (;;)
              {
                paramb.g.poll();
                break;
                paramb.c().onResponse(localMsfMessagePair.toServiceMsg, localMsfMessagePair.fromServiceMsg);
                if (QLog.isColorLevel()) {
                  QLog.d("MSF.S.AppProcessManager", 2, "send resp " + paramString + " to:" + localMsfMessagePair.toServiceMsg + " from:" + localMsfMessagePair.fromServiceMsg);
                }
              }
            }
            catch (DeadObjectException localDeadObjectException)
            {
              paramb.d();
              if (j != 0)
              {
                i = c.e.getUinPushStatus(localMsfMessagePair.fromServiceMsg.getUin());
                if (c.c.get(paramString) != null)
                {
                  h.a(BaseApplication.getContext(), paramString, localMsfMessagePair.fromServiceMsg.getUin(), ((b)c.c.get(paramString)).b(), i);
                  MsfService.getCore().pushManager.i.a();
                }
              }
              for (;;)
              {
                bool1 = bool2;
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("MSF.S.AppProcessManager", 2, "found DeadObjectException " + localDeadObjectException.toString());
                return false;
                paramb.g.poll();
                if (QLog.isColorLevel()) {
                  QLog.d("MSF.S.AppProcessManager", 2, "found not NeedBootMsg," + localMsfMessagePair.fromServiceMsg + " dropped");
                }
              }
            }
            catch (Throwable localThrowable)
            {
              paramb.g.poll();
              localThrowable.printStackTrace();
              if (!QLog.isColorLevel()) {
                break label1101;
              }
            }
          }
          QLog.d("MSF.S.AppProcessManager", 2, "handle error " + localMsfMessagePair.toString() + " " + localMsfMessagePair.fromServiceMsg + " ", localThrowable);
          break label1101;
          label963:
          if (j != 0)
          {
            i = c.e.getUinPushStatus(localMsfMessagePair.fromServiceMsg.getUin());
            h.a(BaseApplication.getContext(), paramString, localMsfMessagePair.fromServiceMsg.getUin(), ((b)c.c.get(paramString)).b(), i);
            MsfService.getCore().pushManager.i.a();
            return false;
          }
          paramb.g.poll();
          if (!QLog.isColorLevel()) {
            break label1101;
          }
          QLog.d("MSF.S.AppProcessManager", 2, "found " + paramb.e + " notNeedBootMsg," + localMsfMessagePair.fromServiceMsg + " dropped");
          break label1101;
        }
      }
      label1101:
      i += 1;
    }
  }
  
  public void a()
  {
    synchronized (this.a)
    {
      this.c = true;
      this.b = false;
      this.a.notify();
      return;
    }
  }
  
  public void run()
  {
    c.f.f = false;
    while (this.c)
    {
      this.c = false;
      this.d = 0;
      ??? = c.c.keySet().iterator();
      while (((Iterator)???).hasNext())
      {
        String str = (String)((Iterator)???).next();
        b localb = (b)c.c.get(str);
        if (localb != null)
        {
          if (a(str, localb)) {
            this.c = true;
          }
          this.d += localb.g.size();
        }
      }
    }
    c.f.a(2);
    this.b = true;
    for (;;)
    {
      synchronized (this.a)
      {
        boolean bool = this.b;
        if (bool) {}
        try
        {
          if (this.d == 0)
          {
            this.a.wait(61440L);
            this.c = true;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
          continue;
        }
      }
      this.a.wait(600L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.a
 * JD-Core Version:    0.7.0.1
 */