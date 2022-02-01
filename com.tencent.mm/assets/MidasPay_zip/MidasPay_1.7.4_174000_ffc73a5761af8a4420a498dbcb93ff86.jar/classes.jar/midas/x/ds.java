package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import java.net.URLEncoder;

public class ds
  extends bx
{
  private String a;
  private String b;
  private String c;
  private String v;
  private String w;
  
  public ds(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.v = paramString4;
    this.w = paramString5;
    a("https", String.format("/v1/r/%s/mobile_security_proc", new Object[] { em.b().n().a.offerId }), "442");
    c();
  }
  
  public void c()
  {
    e("offer_id", em.b().f());
    fy localfy = fy.a();
    el localel = em.b().n();
    e("openid", localel.a.openId);
    f("openid", localel.a.openId);
    f("openkey", localel.a.openKey);
    f("session_id", localel.a.sessionId);
    f("session_type", localel.a.sessionType);
    f("extend", localfy.y());
    f("zoneid", localel.a.zoneId);
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
    f("device_mac", fy.a().t());
    f("device_imei", fy.a().r());
    f("device_androidid", fy.a().s());
    f("device_guid", fy.a().q());
    f("uuid", localel.e.l);
    f("mobile", "");
    f("operator", APTools.g(a.a().d));
    f("mccmnc", APTools.f(a.a().b()));
    f("address", "");
    f("test_invalid_user", "1");
    if (APAppDataInterface.singleton().e().equals("dev")) {
      f("offer_id", em.b().n().a.offerId);
    }
    e("openid", localel.a.openId);
    e("pf", localel.a.pf);
    e("pfkey", localel.a.pfKey);
    e("format", "json");
    e("sdkversion", fv.c());
    e("session_token", localel.e.l);
    e("user_uuid", APTools.a(localfy.q(), 1));
    e("user_imei", APTools.a(localfy.r(), 1));
    e("user_androidid", APTools.a(localfy.s(), 1));
    e("user_mac", APTools.a(localfy.t(), 1));
    e("xg_mid", APAppDataInterface.singleton().l());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ds
 * JD-Core Version:    0.7.0.1
 */