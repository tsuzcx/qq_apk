package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;

public class de
  extends br
{
  private String A;
  private String a;
  private String b;
  private String c;
  private String v;
  private String w;
  private String x;
  private String y;
  private String z;
  
  public de(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    a("https", String.format("/v1/r/%s/mobile_mp_info", new Object[] { ed.b().n().a.offerId }), "442");
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.v = paramString4;
    this.w = paramString5;
    this.x = paramString6;
    this.y = paramString7;
    c();
  }
  
  public de(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
    this.z = paramString8;
    this.A = paramString9;
    c();
  }
  
  public void c()
  {
    e("offer_id", ed.b().f());
    e("openid", this.a);
    e("pf", this.x);
    e("pfkey", this.y);
    e("format", "json");
    String str = "";
    if (ed.b().n().e != null) {
      str = ed.b().n().e.l;
    }
    if (this.z != null) {
      e("drm_info", this.z);
    }
    e("session_token", str);
    e("openkey", this.b);
    e("session_id", this.c);
    e("zoneid", this.w);
    e("session_type", this.v);
    e("sdkversion", fm.c());
    e("extend", this.A);
    e("xg_mid", APAppDataInterface.singleton().l());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.de
 * JD-Core Version:    0.7.0.1
 */