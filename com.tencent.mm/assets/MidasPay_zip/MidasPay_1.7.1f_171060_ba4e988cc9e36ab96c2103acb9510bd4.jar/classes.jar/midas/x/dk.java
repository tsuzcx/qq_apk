package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import java.net.URLEncoder;

public class dk
  extends br
{
  private String a;
  private String b;
  private String c;
  private String v;
  private String w;
  
  public dk(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.v = paramString4;
    this.w = paramString5;
    a("https", String.format("/v1/r/%s/mobile_security_proc", new Object[] { ed.b().n().a.offerId }), "442");
    c();
  }
  
  public void c()
  {
    e("offer_id", ed.b().f());
    fp localfp = fp.a();
    ec localec = ed.b().n();
    e("openid", localec.a.openId);
    f("openid", localec.a.openId);
    f("openkey", localec.a.openKey);
    f("session_id", localec.a.sessionId);
    f("session_type", localec.a.sessionType);
    f("extend", localfp.y());
    f("zoneid", localec.a.zoneId);
    f("action", "register");
    try
    {
      f("name", URLEncoder.encode(this.a, "utf-8"));
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    try
    {
      f("province", URLEncoder.encode(this.v, "utf-8"));
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    f("id_type", this.b);
    f("id_card", this.c);
    f("country", "");
    f("city", this.w);
    f("device_type", "android");
    f("device_mac", fp.a().t());
    f("device_imei", fp.a().r());
    f("device_androidid", fp.a().s());
    f("device_guid", fp.a().q());
    f("uuid", localec.e.l);
    f("mobile", "");
    f("operator", APTools.g(a.a().d));
    f("mccmnc", APTools.f(a.a().b()));
    f("address", "");
    f("test_invalid_user", "1");
    if (APAppDataInterface.singleton().e().equals("dev")) {
      f("offer_id", ed.b().n().a.offerId);
    }
    e("openid", localec.a.openId);
    e("pf", localec.a.pf);
    e("pfkey", localec.a.pfKey);
    e("format", "json");
    e("sdkversion", fm.c());
    e("session_token", localec.e.l);
    e("user_uuid", APTools.a(localfp.q(), 1));
    e("user_imei", APTools.a(localfp.r(), 1));
    e("user_androidid", APTools.a(localfp.s(), 1));
    e("user_mac", APTools.a(localfp.t(), 1));
    e("xg_mid", APAppDataInterface.singleton().l());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.dk
 * JD-Core Version:    0.7.0.1
 */