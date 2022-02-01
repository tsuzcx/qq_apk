package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APMonthRequest;
import com.pay.api.request.APSubscribeRequest;
import com.pay.tool.APAppDataInterface;

public class dq
  extends br
{
  public dq()
  {
    a("https", String.format("/v1/r/%s/mobile_sign_contract", new Object[] { ed.b().n().a.offerId }), "442");
    c();
  }
  
  private void I()
  {
    e("sdkversion", fm.c());
    e("format", "json");
    e("xg_mid", APAppDataInterface.singleton().l());
    e("extend", fp.a().y());
    if (APAppDataInterface.singleton().e().equals("dev")) {
      e("offer_id", ed.b().n().a.offerId);
    }
  }
  
  private void d()
  {
    ec localec = ed.b().n();
    e("openid", localec.a.openId);
    e("openkey", localec.a.openKey);
    e("session_id", localec.a.sessionId);
    e("session_type", localec.a.sessionType);
    e("pf", localec.a.pf);
    e("pfkey", localec.a.pfKey);
    e("zoneid", localec.a.zoneId);
    e("biz_appid", "1");
    e("wx_publice_pay", "1");
    e("wx_direct_pay", "3");
    if (localec.a.saveType == 4)
    {
      e("service_code", ((APMonthRequest)localec.a).serviceCode);
      if (localec.a.saveType == 5) {
        e("product_id", ((APSubscribeRequest)localec.a).productId);
      }
    }
    e("out_trade_no", "");
    e("session_token", localec.e.l);
    e("token_id", "");
  }
  
  private void e()
  {
    ec localec = ed.b().n();
    f("openid", localec.a.openId);
    f("openkey", localec.a.openKey);
    f("session_id", localec.a.sessionId);
    f("session_type", localec.a.sessionType);
    f("pay_method", "qqwallet");
    int i = localec.a.saveType;
    if (i == 0)
    {
      f("type", "save");
      return;
    }
    if (i == 1)
    {
      f("type", "bg");
      return;
    }
    if (i == 4)
    {
      f("type", "month");
      return;
    }
    if (i == 5) {
      f("type", "unimonth");
    }
  }
  
  public void c()
  {
    e("offer_id", ed.b().f());
    d();
    e();
    I();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.dq
 * JD-Core Version:    0.7.0.1
 */