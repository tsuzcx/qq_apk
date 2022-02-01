package com.tencent.mobileqq.app;

import VIP.ReqCheckPayAuth;
import VIP.ReqGetApiList;
import VIP.ReqGetOpenId;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;

public class QWalletOpenHandler
  extends BusinessHandler
{
  public static final int a = 1;
  public static final String a = "OpenPayServer.getOpenId";
  public static final int b = 2;
  public static final String b = "OpenPayServer.getApiList";
  public static final int c = 3;
  public static final String c = "OpenPayServer.checkPayAuth";
  private static final String d = "Q.qwallet.open.OpenPayHandler";
  
  public QWalletOpenHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected Class a()
  {
    return QWalletOpenObserver.class;
  }
  
  public void a(ReqCheckPayAuth paramReqCheckPayAuth)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.a.a(), "OpenPayServer.checkPayAuth");
    localToServiceMsg.extraData.putSerializable("reqCheckPayAuth", paramReqCheckPayAuth);
    super.a(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.open.OpenPayHandler", 2, "sendCheckSignatureReq: on send--cmd=OpenPayServer.checkPayAuth");
    }
  }
  
  public void a(ReqGetApiList paramReqGetApiList)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.a.a(), "OpenPayServer.getApiList");
    localToServiceMsg.extraData.putSerializable("reqGetApiList", paramReqGetApiList);
    super.a(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.open.OpenPayHandler", 2, "sendGetOpenApisReq: on send--cmd=OpenPayServer.getApiList");
    }
  }
  
  public void a(ReqGetOpenId paramReqGetOpenId)
  {
    TicketManager localTicketManager = (TicketManager)this.a.getManager(2);
    if (localTicketManager != null)
    {
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.a.a(), "OpenPayServer.getOpenId");
      paramReqGetOpenId.uin = Long.valueOf(this.a.a()).longValue();
      paramReqGetOpenId.sessionKey = localTicketManager.getSkey(this.a.a());
      localToServiceMsg.extraData.putSerializable("reqGetOpenId", paramReqGetOpenId);
      super.a(localToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qwallet.open.OpenPayHandler", 2, "sendGetOpenIdReq: on send--cmd=OpenPayServer.getOpenId");
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    boolean bool;
    do
    {
      do
      {
        return;
        bool = paramFromServiceMsg.isSuccess();
        paramToServiceMsg = paramToServiceMsg.getServiceCmd();
      } while (TextUtils.isEmpty(paramToServiceMsg));
      if (paramToServiceMsg.compareTo("OpenPayServer.getOpenId") == 0)
      {
        super.a(1, bool, paramObject);
        return;
      }
      if (paramToServiceMsg.compareTo("OpenPayServer.getApiList") == 0)
      {
        super.a(2, bool, paramObject);
        return;
      }
    } while (paramToServiceMsg.compareTo("OpenPayServer.checkPayAuth") != 0);
    super.a(3, bool, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QWalletOpenHandler
 * JD-Core Version:    0.7.0.1
 */