package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;

public class s2
  extends y1
{
  public String A;
  
  public s2(String paramString)
  {
    this.A = paramString;
    a("https", String.format("/v1/r/%s/mobile_get_image", new Object[] { p4.p().e().b.offerId }), "442");
    G();
  }
  
  public void G()
  {
    b("offer_id", p4.p().c());
    c6 localc6 = c6.s0();
    o4 localo4 = p4.p().e();
    b("openid", localo4.b.openId);
    b("openkey", localo4.b.openKey);
    b("session_id", localo4.b.sessionId);
    b("session_type", localo4.b.sessionType);
    b("pf", localo4.b.pf);
    b("pfkey", localo4.b.pfKey);
    b("type", "bin");
    b("format", "json");
    b("sdkversion", z5.c());
    b("session_token", localo4.f.k);
    b("pay_method", this.A);
    b("xg_mid", APAppDataInterface.singleton().C());
    b("extend", localc6.e());
    if (APAppDataInterface.singleton().h().equals("dev")) {
      b("offer_id", p4.p().e().b.offerId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.s2
 * JD-Core Version:    0.7.0.1
 */