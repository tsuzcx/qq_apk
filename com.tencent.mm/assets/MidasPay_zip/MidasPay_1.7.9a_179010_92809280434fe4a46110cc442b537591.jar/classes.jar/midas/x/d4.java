package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;

public class d4
  extends y1
{
  public String A;
  
  public d4(String paramString)
  {
    this.A = paramString;
    a("https", String.format("/v1/r/%s/mobile_mb_smscode", new Object[] { p4.p().e().b.offerId }), "442");
    G();
  }
  
  public void G()
  {
    c6 localc6 = c6.s0();
    o4 localo4 = p4.p().e();
    b("offer_id", p4.p().c());
    b("openid", localo4.b.openId);
    b("session_id", localo4.b.sessionId);
    a(localc6);
  }
  
  public final void a(c6 paramc6)
  {
    o4 localo4 = p4.p().e();
    e("openid", localo4.b.openId);
    e("openkey", localo4.b.openKey);
    e("pay_id", localo4.f.a);
    e("auth_key", localo4.f.b);
    e("session_type", localo4.b.sessionType);
    e("sms_info", this.A);
    e("extend", paramc6.e());
    b("pay_session_id", localo4.f.c);
    b("pay_session_type", localo4.f.d);
    b("wx_pay_by_bindqq", "1");
    b("xg_mid", APAppDataInterface.singleton().C());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.d4
 * JD-Core Version:    0.7.0.1
 */