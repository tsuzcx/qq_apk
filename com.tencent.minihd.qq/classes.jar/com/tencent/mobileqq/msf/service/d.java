package com.tencent.mobileqq.msf.service;

import android.os.Binder;
import android.os.RemoteException;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.f;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IBaseService.Stub;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

class d
  extends IBaseService.Stub
{
  d(MsfService paramMsfService) {}
  
  public FromServiceMsg sendSyncToServiceMsg(ToServiceMsg paramToServiceMsg)
    throws RemoteException
  {
    return null;
  }
  
  public int sendToServiceMsg(ToServiceMsg paramToServiceMsg)
    throws RemoteException
  {
    if (paramToServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("MSF.S.MsfService", 2, "sendToServiceMsg toServiceMsg null!");
      }
      return -1;
    }
    int i = MsfCore.getNextSeq();
    if (paramToServiceMsg.getRequestSsoSeq() == -1) {
      paramToServiceMsg.setRequestSsoSeq(i);
    }
    if (paramToServiceMsg.getTimeout() == -1L) {
      paramToServiceMsg.setTimeout(30000L);
    }
    if (MsfService.core.getMsfAppid() == -1) {
      MsfService.core.setMsfAppid(paramToServiceMsg.getAppId());
    }
    try
    {
      int j = Binder.getCallingUid();
      paramToServiceMsg.addAttribute("__base_tag_isAppMsg", Boolean.valueOf(true));
      if (paramToServiceMsg.getServiceCmd().startsWith("cmd_sync_syncuser"))
      {
        this.a.handleAccountSyncRequest(this.a, paramToServiceMsg, j);
      }
      else
      {
        f.a();
        if (MsfService.isSamePackage(this.a, j, paramToServiceMsg.getServiceCmd())) {
          MsfService.msfServiceReqHandler.a(this.a, paramToServiceMsg, j);
        }
      }
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.w("MSF.S.MsfService", 1, "service handle msg error " + paramToServiceMsg, paramToServiceMsg);
    }
    return -2;
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.d
 * JD-Core Version:    0.7.0.1
 */