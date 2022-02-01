package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;

public class n3
  extends y1
{
  public String A;
  public String B;
  
  public n3(String paramString1, String paramString2)
  {
    this.A = paramString1;
    this.B = paramString2;
    this.f = 1;
    a("https", String.format("/v1/r/%s/cancel_pay_notify", new Object[] { p4.p().e().b.offerId }), "442");
    G();
  }
  
  public void G()
  {
    c6 localc6 = c6.s0();
    o4 localo4 = p4.p().e();
    b("offer_id", p4.p().c());
    b("openid", localo4.b.openId);
    b("openkey", localo4.b.openKey);
    b("session_id", localo4.b.sessionId);
    b("session_type", localo4.b.sessionType);
    b("pf", localo4.b.pf);
    b("pfkey", localo4.b.pfKey);
    b("pay_method", this.A);
    b("channel_orderid", this.B);
    b("sdkversion", z5.c());
    e("extend", localc6.e());
    e("openid", localo4.b.openId);
    b("user_uuid", APTools.b(localc6.Y(), 1));
    b("user_imei", APTools.b(localc6.W(), 1));
    b("user_androidid", APTools.b(localc6.V(), 1));
    b("user_mac", APTools.b(localc6.X(), 1));
    b("xg_mid", APAppDataInterface.singleton().C());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.n3
 * JD-Core Version:    0.7.0.1
 */