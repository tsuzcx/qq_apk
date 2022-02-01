package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;

public class m2
  extends y1
{
  public m2()
  {
    String str1 = String.format("/v1/r/%s/get_ip_list", new Object[] { p4.p().e().b.offerId });
    String str2 = a2.c();
    this.f = 3;
    b(str2, "https", str1, "443");
    G();
  }
  
  public boolean F()
  {
    return false;
  }
  
  public void G()
  {
    c6 localc6 = c6.s0();
    b("offer_id", p4.p().c());
    o4 localo4 = p4.p().e();
    if (localo4 != null)
    {
      b("openid", localo4.b.openId);
      b("openkey", localo4.b.openKey);
      b("session_id", localo4.b.sessionId);
      b("session_type", localo4.b.sessionType);
      b("pf", localo4.b.pf);
      b("pfkey", localo4.b.pfKey);
      b("format", "json");
      b("session_token", localo4.f.k);
    }
    b("extend", localc6.e());
    b("sdkversion", z5.c());
    b("xg_mid", APAppDataInterface.singleton().C());
    if (APAppDataInterface.singleton().h().equals("dev")) {
      b("offer_id", p4.p().e().b.offerId);
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.m2
 * JD-Core Version:    0.7.0.1
 */