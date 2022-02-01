package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APMonthRequest;
import com.pay.tool.APAppDataInterface;

public class b4
  extends y1
{
  public b4()
  {
    a("https", String.format("/v1/r/%s/mobile_sign_contract", new Object[] { p4.p().e().b.offerId }), "442");
    H();
  }
  
  public final void G()
  {
    b("sdkversion", z5.c());
    b("format", "json");
    b("xg_mid", APAppDataInterface.singleton().C());
    b("extend", c6.s0().e());
    if (APAppDataInterface.singleton().h().equals("dev")) {
      b("offer_id", p4.p().e().b.offerId);
    }
  }
  
  public void H()
  {
    b("offer_id", p4.p().c());
    J();
    I();
    G();
  }
  
  public final void I()
  {
    o4 localo4 = p4.p().e();
    e("openid", localo4.b.openId);
    e("openkey", localo4.b.openKey);
    e("session_id", localo4.b.sessionId);
    e("session_type", localo4.b.sessionType);
    e("pay_method", "qqwallet");
    int i = localo4.b.saveType;
    if (i == 0)
    {
      e("type", "save");
      return;
    }
    if (i == 1)
    {
      e("type", "bg");
      return;
    }
    if (i == 4)
    {
      e("type", "month");
      return;
    }
    if (i == 5) {
      e("type", "unimonth");
    }
  }
  
  public final void J()
  {
    o4 localo4 = p4.p().e();
    b("openid", localo4.b.openId);
    b("openkey", localo4.b.openKey);
    b("session_id", localo4.b.sessionId);
    b("session_type", localo4.b.sessionType);
    b("pf", localo4.b.pf);
    b("pfkey", localo4.b.pfKey);
    b("zoneid", localo4.b.zoneId);
    b("biz_appid", "1");
    b("wx_publice_pay", "1");
    b("wx_direct_pay", "3");
    APBaseRequest localAPBaseRequest = localo4.b;
    if (localAPBaseRequest.saveType == 4)
    {
      b("service_code", ((APMonthRequest)localAPBaseRequest).serviceCode);
      if (localo4.b.saveType == 5) {
        b("product_id", ((z4)localo4.c).k);
      }
    }
    b("out_trade_no", "");
    b("session_token", localo4.f.k);
    b("token_id", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.b4
 * JD-Core Version:    0.7.0.1
 */