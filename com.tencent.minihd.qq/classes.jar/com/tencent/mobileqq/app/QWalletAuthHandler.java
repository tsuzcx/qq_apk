package com.tencent.mobileqq.app;

import QQWalletPay.ReqCheckChangePwdAuth;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class QWalletAuthHandler
  extends BusinessHandler
{
  public static final int a = 1;
  public static final String a = "QQWalletPayAuthServer.checkChangePwdAuth";
  private static final String b = "Q.qwallet.auth.AuthHandler";
  
  protected QWalletAuthHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected Class a()
  {
    return QWalletAuthObserver.class;
  }
  
  public void a(ReqCheckChangePwdAuth paramReqCheckChangePwdAuth)
  {
    if (paramReqCheckChangePwdAuth == null) {}
    do
    {
      return;
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.a.a(), "QQWalletPayAuthServer.checkChangePwdAuth");
      localToServiceMsg.extraData.putSerializable("ReqCheckChangePwdAuth", paramReqCheckChangePwdAuth);
      super.a(localToServiceMsg);
    } while (!QLog.isColorLevel());
    QLog.d("Q.qwallet.auth.AuthHandler", 2, "sendCheckModifyPassReq: on send--cmd=QQWalletPayAuthServer.checkChangePwdAuth");
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    boolean bool;
    do
    {
      return;
      bool = paramFromServiceMsg.isSuccess();
      paramToServiceMsg = paramToServiceMsg.getServiceCmd();
    } while ((TextUtils.isEmpty(paramToServiceMsg)) || (paramToServiceMsg.compareTo("QQWalletPayAuthServer.checkChangePwdAuth") != 0));
    super.a(1, bool, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QWalletAuthHandler
 * JD-Core Version:    0.7.0.1
 */