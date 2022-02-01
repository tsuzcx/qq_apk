package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APMonthRequest;
import com.pay.tool.APAppDataInterface;

public class dy
  extends bx
{
  public dy()
  {
    a("https", String.format("/v1/r/%s/mobile_sign_contract", new Object[] { em.b().n().a.offerId }), "442");
    c();
  }
  
  private void I()
  {
    e("sdkversion", fv.c());
    e("format", "json");
    e("xg_mid", APAppDataInterface.singleton().l());
    e("extend", fy.a().y());
    if (APAppDataInterface.singleton().e().equals("dev")) {
      e("offer_id", em.b().n().a.offerId);
    }
  }
  
  private void d()
  {
    el localel = em.b().n();
    e("openid", localel.a.openId);
    e("openkey", localel.a.openKey);
    e("session_id", localel.a.sessionId);
    e("session_type", localel.a.sessionType);
    e("pf", localel.a.pf);
    e("pfkey", localel.a.pfKey);
    e("zoneid", localel.a.zoneId);
    e("biz_appid", "1");
    e("wx_publice_pay", "1");
    e("wx_direct_pay", "3");
    if (localel.a.saveType == 4)
    {
      e("service_code", ((APMonthRequest)localel.a).serviceCode);
      if (localel.a.saveType == 5) {
        e("product_id", ((ew)localel.b).k);
      }
    }
    e("out_trade_no", "");
    e("session_token", localel.e.l);
    e("token_id", "");
  }
  
  private void e()
  {
    el localel = em.b().n();
    f("openid", localel.a.openId);
    f("openkey", localel.a.openKey);
    f("session_id", localel.a.sessionId);
    f("session_type", localel.a.sessionType);
    f("pay_method", "qqwallet");
    int i = localel.a.saveType;
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
    e("offer_id", em.b().f());
    d();
    e();
    I();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.dy
 * JD-Core Version:    0.7.0.1
 */