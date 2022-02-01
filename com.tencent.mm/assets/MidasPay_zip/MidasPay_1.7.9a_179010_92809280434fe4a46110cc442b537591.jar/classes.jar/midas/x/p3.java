package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;

public class p3
  extends y1
{
  public p3()
  {
    a("https", String.format("/v1/r/%s/wechat_payscore_contract", new Object[] { p4.p().e().b.offerId }), "442");
    H();
  }
  
  public final void G()
  {
    b("sdkversion", z5.c());
    b("format", "json");
    b("xg_mid", APAppDataInterface.singleton().C());
    b("extend", c6.s0().e());
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
    e("pf", localo4.b.pf);
    e("pfkey", localo4.b.pfKey);
  }
  
  public final void J()
  {
    b("openid", p4.p().e().b.openId);
    b("action", "contract");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.p3
 * JD-Core Version:    0.7.0.1
 */