package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;

public class l3
  extends y1
{
  public String A;
  public String B;
  public String C;
  public String D;
  public String E;
  public String F;
  public String G;
  public String H;
  public String I;
  
  public l3(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    a("https", String.format("/v1/r/%s/mobile_mp_info", new Object[] { p4.p().e().b.offerId }), "442");
    this.A = paramString1;
    this.B = paramString2;
    this.C = paramString3;
    this.D = paramString4;
    this.E = paramString5;
    this.F = paramString6;
    this.G = paramString7;
    G();
  }
  
  public l3(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
    this.H = paramString8;
    this.I = paramString9;
    G();
  }
  
  public void G()
  {
    b("offer_id", p4.p().c());
    b("openid", this.A);
    b("pf", this.F);
    b("pfkey", this.G);
    b("format", "json");
    String str1;
    if (p4.p().e().f != null) {
      str1 = p4.p().e().f.k;
    } else {
      str1 = "";
    }
    String str2 = this.H;
    if (str2 != null) {
      b("drm_info", str2);
    }
    b("session_token", str1);
    b("openkey", this.B);
    b("session_id", this.C);
    b("zoneid", this.E);
    b("session_type", this.D);
    b("sdkversion", z5.c());
    b("extend", this.I);
    b("xg_mid", APAppDataInterface.singleton().C());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.l3
 * JD-Core Version:    0.7.0.1
 */