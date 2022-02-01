package com.tencent.mobileqq.msf.core.auth;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.msf.service.protocol.security.CustomSigContent;
import com.tencent.msf.service.protocol.security.RequestCustomSig;
import com.tencent.msf.service.protocol.security.RespondCustomSig;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class d
{
  public static final int a = 604800000;
  public static final int b = 21600000;
  public static final int c = 1800000;
  public static final int d = 1000;
  public static ConcurrentHashMap f = new ConcurrentHashMap();
  public static final String g = "_new_version_never_change_token";
  public static boolean h = true;
  private static final String i = "MSF.C.TokenChecker";
  private static final String j = "_lastchecktokentime";
  private static final int k = 1800000;
  private static long l = -1L;
  b e;
  
  public d(b paramb)
  {
    this.e = paramb;
    if (TextUtils.isEmpty(MsfStore.getNativeConfigStore().getConfig("_new_version_never_change_token"))) {}
    for (h = false;; h = true)
    {
      if (!h) {
        MsfStore.getNativeConfigStore().n_setConfig("_lastchecktokentime", String.valueOf(0));
      }
      return;
    }
  }
  
  private long a(String paramString)
  {
    long l1 = this.e.a.getWtLoginCenter().a(paramString, 64);
    long l2 = this.e.a.getWtLoginCenter().a(paramString, 262144);
    if (l1 > l2) {
      return l2;
    }
    return l1;
  }
  
  private long b(String paramString)
  {
    long l1 = this.e.a.getWtLoginCenter().a(paramString, 4096);
    long l4 = this.e.a.getWtLoginCenter().a(paramString, 524288);
    long l3 = this.e.a.getWtLoginCenter().a(paramString, 131072);
    long l2 = this.e.a.getWtLoginCenter().a(paramString, 32);
    long l5 = this.e.a.getWtLoginCenter().a(paramString, 1048576);
    if (l1 > l4)
    {
      l1 = l4;
      if (l1 <= l3) {
        break label133;
      }
      l1 = l3;
      label110:
      if (l1 <= l2) {
        break label136;
      }
      l1 = l2;
    }
    label133:
    label136:
    for (;;)
    {
      if (l1 <= l5) {
        return l1;
      }
      return l5;
      break;
      break label110;
    }
    return l1;
  }
  
  private long d()
  {
    long l1 = 0L;
    try
    {
      int m = new Random(SystemClock.elapsedRealtime()).nextInt(1800000);
      l1 = m - 900000;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.TokenChecker", 4, "RandomRevise: " + l1);
    }
    return l1;
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    if (l == -1L)
    {
      str = MsfStore.getNativeConfigStore().getConfig("_lastchecktokentime");
      if (str != null) {}
    }
    while ((l1 < l) || (l1 - l >= com.tencent.mobileqq.msf.core.a.a.t()))
    {
      do
      {
        String str;
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.TokenChecker", 2, "doCheck, lastCheckTime=" + l + ", now=" + l1);
        }
        l = l1;
        MsfStore.getNativeConfigStore().n_setConfig("_lastchecktokentime", String.valueOf(l1));
        b();
        if ((this.e != null) && (this.e.a.getStandyModeManager() != null)) {
          this.e.a.getStandyModeManager().a();
        }
        return;
        l = Long.parseLong(str);
      } while (l1 - l >= com.tencent.mobileqq.msf.core.a.a.t());
      return;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = null;
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    String str;
    do
    {
      long l1;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              str = paramFromServiceMsg.getUin();
              paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
              if (paramFromServiceMsg.isSuccess()) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.w("MSF.C.TokenChecker", 2, "onChangeTokenResult fail, uin=" + str + ", errorcode=" + paramFromServiceMsg.getBusinessFailCode());
            return;
            if (!paramToServiceMsg.equals("login.chgTok_A2D2")) {
              break;
            }
            paramToServiceMsg = (RespondCustomSig)paramFromServiceMsg.getAttribute(paramFromServiceMsg.getServiceCmd());
          } while (paramToServiceMsg == null);
          Iterator localIterator = paramToServiceMsg.SigList.iterator();
          paramFromServiceMsg = null;
          CustomSigContent localCustomSigContent = null;
          paramToServiceMsg = (ToServiceMsg)localObject;
          localObject = localCustomSigContent;
          while (localIterator.hasNext())
          {
            localCustomSigContent = (CustomSigContent)localIterator.next();
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.TokenChecker", 2, "onChangeTokenResult, content.ulSigType=" + localCustomSigContent.ulSigType + ", uin=" + str);
            }
            QLog.d("MSF.C.TokenChecker", 1, "iSimplified for " + MsfSdkUtils.getShortUin(str));
            if (localCustomSigContent.ulSigType == 0L) {
              localObject = localCustomSigContent.SigContent;
            } else if (localCustomSigContent.ulSigType == 18L) {
              paramFromServiceMsg = localCustomSigContent.SigContent;
            } else if (localCustomSigContent.ulSigType == 20L) {
              paramToServiceMsg = localCustomSigContent.SigContent;
            }
          }
        } while ((localObject == null) || (paramFromServiceMsg == null) || (paramToServiceMsg == null));
        l1 = System.currentTimeMillis();
      } while (l1 - this.e.n(str).A() <= 1800000L);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.TokenChecker", 2, "renew A2 D2 succ, uin=" + str);
      }
      this.e.a(str, (byte[])localObject, paramFromServiceMsg, paramToServiceMsg, l1);
      if (com.tencent.mobileqq.msf.core.a.a.k())
      {
        QLog.d("MSF.C.TokenChecker", 1, "reloadkey add uin:" + MsfSdkUtils.getShortUin(str));
        f.put(str, Boolean.valueOf(true));
        return;
      }
      QLog.d("MSF.C.TokenChecker", 1, "give up reloading key for uin:" + MsfSdkUtils.getShortUin(str));
      return;
    } while ((!paramToServiceMsg.equals("login.chgTok_WEBVIEW_KEY")) || (!QLog.isColorLevel()));
    QLog.d("MSF.C.TokenChecker", 2, "renew webview key succ for " + str);
  }
  
  public void b()
  {
    new e(this, "threadCheckToken").start();
  }
  
  void c()
  {
    long l3 = System.currentTimeMillis();
    Iterator localIterator = this.e.d().iterator();
    if (localIterator.hasNext())
    {
      String str = ((SimpleAccount)localIterator.next()).getUin();
      int m = 0;
      int n = 0;
      long l4;
      long l1;
      Object localObject;
      if (this.e.i(str))
      {
        l4 = a(str);
        long l2 = com.tencent.mobileqq.msf.core.a.a.T();
        l1 = l2;
        if (l2 <= 0L) {
          l1 = 604800000L;
        }
        m = n;
        if (l3 - l4 > l1 + d())
        {
          localObject = new ToServiceMsg("", str, "login.chgTok_A2D2");
          ((ToServiceMsg)localObject).setMsfCommand(MsfCommand._msf_refreToken);
          ((ToServiceMsg)localObject).getAttributes().put("to_login_token_cmdhead", Integer.valueOf(9));
          ((ToServiceMsg)localObject).getAttributes().put("refresh_token_src", "AccountTokenChecker");
          ((ToServiceMsg)localObject).setRequestSsoSeq(MsfCore.getNextSeq());
          ((ToServiceMsg)localObject).setAppId(this.e.a.getMsfAppid());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          HashMap localHashMap = new HashMap();
          RequestCustomSig localRequestCustomSig = new RequestCustomSig();
          localRequestCustomSig.ulCustumFlag = 1970272L;
          localRequestCustomSig.reserved = new byte[0];
          localHashMap.put("RequestCustomSig", localRequestCustomSig);
          ((ToServiceMsg)localObject).getAttributes().put("to_login_token_map", localHashMap);
          this.e.a.changeTokenAfterLogin((ToServiceMsg)localObject, true);
          n = 1;
          m = n;
          if (QLog.isColorLevel())
          {
            QLog.d("MSF.C.TokenChecker", 2, "renew A2 D2 for " + str);
            m = n;
          }
        }
        l4 = b(str);
        l2 = com.tencent.mobileqq.msf.core.a.a.U();
        l1 = l2;
        if (l2 <= 0L) {
          l1 = 21600000L;
        }
        l1 = d() + l1;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("MainService onTicketChanged, now: ").append(l3).append(" lastCheckWebviewKeyTime: ").append(l4).append(" interval: ").append(l3 - l4).append(" needChangeToken: ");
          if (l3 - l4 <= l1) {
            break label584;
          }
        }
      }
      label584:
      for (boolean bool = true;; bool = false)
      {
        for (;;)
        {
          QLog.d("MSF.C.TokenChecker", 2, bool);
          if ((!h) || (l3 - l4 > l1))
          {
            localObject = new ToServiceMsg("", str, "login.chgTok_WEBVIEW_KEY");
            ((ToServiceMsg)localObject).setMsfCommand(MsfCommand._msf_refreToken);
            ((ToServiceMsg)localObject).setRequestSsoSeq(MsfCore.getNextSeq());
            ((ToServiceMsg)localObject).setAppId(this.e.a.getMsfAppid());
            ((ToServiceMsg)localObject).setTimeout(30000L);
            ((ToServiceMsg)localObject).getAttributes().put("refresh_token_src", "AccountTokenChecker");
            this.e.a.changeTokenAfterLogin((ToServiceMsg)localObject, true);
            n = 1;
            m = n;
            if (QLog.isColorLevel())
            {
              QLog.d("MSF.C.TokenChecker", 2, "renew webview key for " + str);
              m = n;
            }
          }
          if (m == 0) {
            break;
          }
          try
          {
            Thread.sleep(com.tencent.mobileqq.msf.core.a.a.u());
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
          }
        }
        break;
      }
    }
    h = true;
    MsfStore.getNativeConfigStore().n_setConfig("_new_version_never_change_token", String.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.d
 * JD-Core Version:    0.7.0.1
 */