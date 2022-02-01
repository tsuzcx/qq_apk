package com.tencent.mobileqq.msf.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mobileqq.msf.core.c.e;
import com.tencent.mobileqq.msf.core.c.e.a;
import com.tencent.mobileqq.msf.core.m;
import com.tencent.mobileqq.msf.sdk.handler.IErrorHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IBaseService;
import com.tencent.qphone.base.remote.IMsfServiceCallbacker;
import com.tencent.qphone.base.remote.MsfServiceBindInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

class g
  extends u
{
  private static final String p = "MSF.D.Proxy";
  MsfServiceSdk a;
  protected volatile boolean b = false;
  IMsfServiceCallbacker c = new h(this);
  
  public g(String paramString)
  {
    super(paramString);
  }
  
  private void a(FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.Proxy", 2, " onRecvPushResp " + paramFromServiceMsg);
    }
    if (!b(null, paramFromServiceMsg)) {
      if (paramFromServiceMsg.getMsfCommand() == MsfCommand.pushSetConfig)
      {
        o.b(((Integer)paramFromServiceMsg.getAttribute(paramFromServiceMsg.getServiceCmd())).intValue());
        com.tencent.mobileqq.msf.core.NetConnInfoCenter.socketConnState = ((Integer)paramFromServiceMsg.getAttribute("_attr_socket_connstate")).intValue();
        com.tencent.mobileqq.msf.core.NetConnInfoCenter.servetTimeSecondInterv = ((Long)paramFromServiceMsg.getAttribute("_attr_server")).longValue();
        com.tencent.mobileqq.msf.core.NetConnInfoCenter.GUID = (byte[])paramFromServiceMsg.getAttribute("_attr_deviceGUID");
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getServiceCmd() != null) && (paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))) {
          e.a().a(e.a.c, paramFromServiceMsg.getWupBuffer(), 17);
        }
      }
    }
    while ((paramFromServiceMsg == null) || (paramFromServiceMsg.getServiceCmd() == null) || (!paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c")))
    {
      do
      {
        return;
        if (this.b)
        {
          this.a.addServicePushMsg(paramFromServiceMsg);
          return;
        }
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getServiceCmd() != null) && (paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))) {
          e.a().a(e.a.c, paramFromServiceMsg.getWupBuffer(), 16);
        }
      } while (!QLog.isColorLevel());
      QLog.d("MSF.D.Proxy", 2, " close msfServiceConn. push msg is droped." + paramFromServiceMsg);
      return;
    }
    e.a().a(e.a.c, paramFromServiceMsg.getWupBuffer(), 15);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    ToServiceMsg localToServiceMsg = (ToServiceMsg)g.remove(Integer.valueOf(paramToServiceMsg.getAppSeq()));
    if (localToServiceMsg != null) {
      if (("LongConn.OffPicUp".equalsIgnoreCase(localToServiceMsg.getServiceCmd())) || ("ImgStore.GroupPicUp".equalsIgnoreCase(localToServiceMsg.getServiceCmd()))) {
        QLog.d("MSF.D.Proxy", 1, "onReceiveResp." + localToServiceMsg.getStringForLog() + " isConnectedMsf:" + this.b);
      }
    }
    label158:
    do
    {
      do
      {
        do
        {
          break label158;
          for (;;)
          {
            if (!b(paramToServiceMsg, paramFromServiceMsg))
            {
              if (!this.b) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("MSF.D.Proxy", 2, "add queue req:" + paramToServiceMsg + " from:" + paramFromServiceMsg);
              }
              this.a.addServiceRespMsg(new MsfMessagePair(paramToServiceMsg, paramFromServiceMsg));
            }
            return;
            if (QLog.isColorLevel()) {
              QLog.d("MSF.D.Proxy", 2, " onResponse " + paramToServiceMsg.getRequestSsoSeq() + " " + paramFromServiceMsg);
            }
          }
        } while (!QLog.isColorLevel());
        QLog.d("MSF.D.Proxy", 2, " close msfServiceConn. msg is droped." + paramToServiceMsg.getRequestSsoSeq() + " " + paramFromServiceMsg);
        return;
        if ((!"LongConn.OffPicUp".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"ImgStore.GroupPicUp".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))) {
          break;
        }
        QLog.d("MSF.D.Proxy", 1, "onReceiveResp." + paramFromServiceMsg.getStringForLog() + " waiteTemp is null.");
      } while (!paramFromServiceMsg.isSuccess());
      paramToServiceMsg = new HashMap();
      paramToServiceMsg.put("appSeq", String.valueOf(paramFromServiceMsg.getAppSeq()));
      paramToServiceMsg.put("ssoSeq", String.valueOf(paramFromServiceMsg.getRequestSsoSeq()));
      paramFromServiceMsg = new RdmReq();
      paramFromServiceMsg.eventName = "PicUpMsgErroCase1";
      paramFromServiceMsg.isRealTime = true;
      paramFromServiceMsg.params = paramToServiceMsg;
      try
      {
        paramToServiceMsg = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), paramFromServiceMsg);
        paramToServiceMsg.setTimeout(30000L);
        MsfServiceSdk.get().sendMsg(paramToServiceMsg);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MSF.D.Proxy", 2, " found timeout resp to:" + paramToServiceMsg + " from:" + paramFromServiceMsg);
  }
  
  protected int a(ToServiceMsg paramToServiceMsg)
    throws RemoteException
  {
    if (paramToServiceMsg == null) {
      return -1;
    }
    paramToServiceMsg.setAppId(this.a.appid);
    paramToServiceMsg.getAttributes().put("to_SendTime", Long.valueOf(System.currentTimeMillis()));
    paramToServiceMsg.getAttributes().put("to_SenderProcessName", this.a.processName);
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.Proxy", 2, " send req to msfService:" + paramToServiceMsg);
    }
    return this.d.sendToServiceMsg(paramToServiceMsg);
  }
  
  public int a(Boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(this.a.msfServiceName, "0", "cmd_UnRegisterMsfService");
    localToServiceMsg.setMsfCommand(MsfCommand.unRegisterMsfService);
    localToServiceMsg.extraData.putBoolean("to_stop_wake_process", paramBoolean.booleanValue());
    this.b = false;
    return b(localToServiceMsg);
  }
  
  void a()
  {
    if (!m.a())
    {
      QLog.d("MSF.D.Proxy", 1, "startBaseService no allow");
      return;
    }
    try
    {
      ComponentName localComponentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.a.msfServiceName);
      Intent localIntent = new Intent();
      localIntent.setComponent(localComponentName);
      localIntent.putExtra("to_SenderProcessName", this.a.processName);
      BaseApplication.getContext().startService(localIntent);
      QLog.d("MSF.D.Proxy", 1, "start service finish");
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MSF.D.Proxy", 1, " " + localException, localException);
    }
  }
  
  public void a(MsfServiceSdk paramMsfServiceSdk)
  {
    this.a = paramMsfServiceSdk;
    paramMsfServiceSdk.msfServiceName = this.n;
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    c(paramToServiceMsg, paramFromServiceMsg);
  }
  
  boolean b()
  {
    boolean bool2 = false;
    if (!m.a())
    {
      QLog.d("MSF.D.Proxy", 1, "startBaseService no allow");
      return false;
    }
    boolean bool1 = bool2;
    try
    {
      ComponentName localComponentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.a.msfServiceName);
      bool1 = bool2;
      Intent localIntent = new Intent();
      bool1 = bool2;
      localIntent.putExtra("to_SenderProcessName", this.a.processName);
      bool1 = bool2;
      localIntent.setComponent(localComponentName);
      bool1 = bool2;
      bool2 = BaseApplication.getContext().bindService(localIntent, this.o, 1);
      bool1 = bool2;
      QLog.d("MSF.D.Proxy", 1, "threadID:" + Thread.currentThread().getId() + " bind " + this.a.msfServiceName + " service finished " + bool2);
      return bool2;
    }
    catch (Exception localException)
    {
      QLog.d("MSF.D.Proxy", 1, " " + localException, localException);
    }
    return bool1;
  }
  
  public boolean b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramFromServiceMsg.getBusinessFailCode();
    if (paramFromServiceMsg.getAttributes().containsKey("_attr_sameDevice")) {}
    for (boolean bool = ((Boolean)paramFromServiceMsg.getAttribute("_attr_sameDevice")).booleanValue();; bool = false)
    {
      switch (i)
      {
      case 2002: 
      case 2003: 
      case 2004: 
      case 2005: 
      case 2006: 
      case 2007: 
      case 2010: 
      default: 
        return false;
      case 2001: 
        QLog.d("MSF.D.Proxy", 1, "BaseConstants.CODE_NO_LOGIN " + paramFromServiceMsg.hashCode());
        this.a.errorHandler.onUserTokenExpired(paramToServiceMsg, paramFromServiceMsg, bool);
        return true;
      case 2011: 
        this.a.errorHandler.onRecvServerTip(paramToServiceMsg, paramFromServiceMsg, bool);
        return true;
      case 2012: 
        this.a.errorHandler.onKickedAndClearToken(paramToServiceMsg, paramFromServiceMsg, bool);
        return true;
      case 2013: 
        this.a.errorHandler.onKicked(paramToServiceMsg, paramFromServiceMsg, bool);
        return true;
      case 2009: 
        this.a.errorHandler.onServerSuspended(paramToServiceMsg, paramFromServiceMsg, bool);
        return true;
      case 2008: 
        this.a.errorHandler.onGrayError(paramToServiceMsg, paramFromServiceMsg, bool);
        return true;
      }
      this.a.errorHandler.onInvalidSign(bool);
      return true;
    }
  }
  
  protected void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.Proxy", 2, "add fail queue req:" + paramToServiceMsg + " from:" + paramFromServiceMsg);
    }
    this.a.addServiceRespMsg(new MsfMessagePair(paramToServiceMsg, paramFromServiceMsg));
  }
  
  public boolean c()
  {
    try
    {
      ComponentName localComponentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.a.msfServiceName);
      Intent localIntent = new Intent();
      localIntent.setComponent(localComponentName);
      localIntent.putExtra("to_SenderProcessName", this.a.processName);
      boolean bool = BaseApplication.getContext().stopService(localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.Proxy", 2, " stopService service finished " + bool);
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
    int i = f();
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.Proxy", 2, " registerMsfService result:" + i);
    }
    i locali = new i(this);
    locali.setName("handleWaitSendProxyMsgThread");
    try
    {
      locali.start();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("MSF.D.Proxy", 1, "error: " + localThrowable, localThrowable);
      e();
    }
  }
  
  public void e()
  {
    while (!f.isEmpty())
    {
      ToServiceMsg localToServiceMsg = (ToServiceMsg)f.poll();
      if (localToServiceMsg != null) {
        try
        {
          a(localToServiceMsg);
        }
        catch (Exception localException)
        {
          c(localToServiceMsg, a(localToServiceMsg, localToServiceMsg.getServiceName() + "sendMsgToServiceFailed，" + localException.toString()));
        }
      }
    }
  }
  
  public int f()
  {
    if ((this.a.processName == null) || (this.a.processName.endsWith("picture"))) {
      return -1;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg(this.a.msfServiceName, "0", "cmd_RegisterMsfService");
    localToServiceMsg.setMsfCommand(MsfCommand.registerMsfService);
    MsfServiceBindInfo localMsfServiceBindInfo = new MsfServiceBindInfo(this.a.appid, this.a.processName, this.a.getBootBroadcastName(), this.c);
    localToServiceMsg.getAttributes().put("intent_bindServiceInfo", localMsfServiceBindInfo);
    localToServiceMsg.setNeedCallback(false);
    this.b = true;
    return b(localToServiceMsg);
  }
  
  public void g()
  {
    super.g();
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.g
 * JD-Core Version:    0.7.0.1
 */