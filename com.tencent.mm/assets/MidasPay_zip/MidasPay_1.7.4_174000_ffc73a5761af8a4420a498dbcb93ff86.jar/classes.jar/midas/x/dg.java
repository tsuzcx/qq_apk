package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;

public class dg
  extends bx
{
  private String a;
  private String b;
  private String c;
  private String v;
  private String w;
  private String x;
  private String y;
  private String z = em.b().n().a.offerId;
  
  public dg(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    a("https", String.format("/v1/r/%s/mobile_get_config", new Object[] { this.z }), "442");
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.v = paramString4;
    this.x = paramString5;
    this.y = paramString6;
    c();
  }
  
  public void c()
  {
    e("offer_id", em.b().f());
    fy.a();
    f("openkey", this.b);
    f("session_id", this.c);
    f("session_type", this.v);
    f("pf", this.x);
    f("pfkey", this.y);
    f("openid", this.a);
    f("offer_id", this.z);
    e("format", "json");
    String str = "";
    if (em.b().n().e != null) {
      str = em.b().n().e.l;
    }
    e("openid", this.a);
    e("session_token", str);
    e("zoneid", this.w);
    e("sdkversion", fv.c());
    e("reqtype", "cpay");
    e("extend", fy.a().y());
    e("xg_mid", APAppDataInterface.singleton().l());
    if (APAppDataInterface.singleton().e().equals("dev")) {
      e("offer_id", em.b().n().a.offerId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.dg
 * JD-Core Version:    0.7.0.1
 */