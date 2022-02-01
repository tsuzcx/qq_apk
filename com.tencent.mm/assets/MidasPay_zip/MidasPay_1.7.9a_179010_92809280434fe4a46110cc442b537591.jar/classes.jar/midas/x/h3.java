package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;

public class h3
  extends y1
{
  public String A;
  public String B;
  public String C;
  public String D;
  public String E;
  public String F;
  public String G;
  public String H = p4.p().e().b.offerId;
  
  public h3(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    a("https", String.format("/v1/r/%s/mobile_get_config", new Object[] { this.H }), "442");
    this.A = paramString1;
    this.B = paramString2;
    this.C = paramString3;
    this.D = paramString4;
    this.F = paramString5;
    this.G = paramString6;
    G();
  }
  
  public void G()
  {
    b("offer_id", p4.p().c());
    c6.s0();
    e("openkey", this.B);
    e("session_id", this.C);
    e("session_type", this.D);
    e("pf", this.F);
    e("pfkey", this.G);
    e("openid", this.A);
    e("offer_id", this.H);
    b("format", "json");
    String str;
    if (p4.p().e().f != null) {
      str = p4.p().e().f.k;
    } else {
      str = "";
    }
    b("openid", this.A);
    b("session_token", str);
    b("zoneid", this.E);
    b("sdkversion", z5.c());
    b("reqtype", "cpay");
    b("extend", c6.s0().e());
    b("xg_mid", APAppDataInterface.singleton().C());
    if (APAppDataInterface.singleton().h().equals("dev")) {
      b("offer_id", p4.p().e().b.offerId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.h3
 * JD-Core Version:    0.7.0.1
 */