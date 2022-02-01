package com.tencent.mobileqq.app;

import Wallet.ReqApplication;
import Wallet.ReqH5Config;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class QWalletHomeHandler
  extends BusinessHandler
{
  public static final int a = 1;
  public static final String a = "WalletRecommend.getWalletRecommendAPP";
  public static final int b = 2;
  public static final String b = "WalletRecommend.getWalletRealAPP";
  public static final int c = 3;
  public static final String c = "WalletRecommend.getH5Config";
  private static final String d = "Q.qwallet.home.HomeHandler";
  
  public QWalletHomeHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected Class a()
  {
    return QWalletHomeObserver.class;
  }
  
  public void a(ReqApplication paramReqApplication)
  {
    if (paramReqApplication == null) {}
    do
    {
      return;
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.a.a(), "WalletRecommend.getWalletRecommendAPP");
      localToServiceMsg.extraData.putSerializable("ReqApplication", paramReqApplication);
      super.a(localToServiceMsg);
    } while (!QLog.isColorLevel());
    QLog.d("Q.qwallet.home.HomeHandler", 2, "sendGetOpenLoginStateReq: on send--cmd=WalletRecommend.getWalletRecommendAPP");
  }
  
  public void a(ReqH5Config paramReqH5Config)
  {
    if (paramReqH5Config == null) {}
    do
    {
      return;
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.a.a(), "WalletRecommend.getH5Config");
      localToServiceMsg.extraData.putSerializable("ReqH5Config", paramReqH5Config);
      super.a(localToServiceMsg);
    } while (!QLog.isColorLevel());
    QLog.d("Q.qwallet.home.HomeHandler", 2, "sendGetPersonalReq: on send--cmd=WalletRecommend.getH5Config");
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
      if (paramToServiceMsg.compareTo("WalletRecommend.getWalletRecommendAPP") == 0)
      {
        super.a(1, bool, paramObject);
        return;
      }
      if (paramToServiceMsg.compareTo("WalletRecommend.getWalletRealAPP") == 0)
      {
        super.a(2, bool, paramObject);
        return;
      }
    } while (paramToServiceMsg.compareTo("WalletRecommend.getH5Config") != 0);
    super.a(3, bool, paramObject);
  }
  
  public void b(ReqApplication paramReqApplication)
  {
    if (paramReqApplication == null) {}
    do
    {
      return;
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.a.a(), "WalletRecommend.getWalletRealAPP");
      localToServiceMsg.extraData.putSerializable("ReqApplication", paramReqApplication);
      super.a(localToServiceMsg);
    } while (!QLog.isColorLevel());
    QLog.d("Q.qwallet.home.HomeHandler", 2, "sendGetRealEventReq: on send--cmd=WalletRecommend.getWalletRealAPP");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QWalletHomeHandler
 * JD-Core Version:    0.7.0.1
 */