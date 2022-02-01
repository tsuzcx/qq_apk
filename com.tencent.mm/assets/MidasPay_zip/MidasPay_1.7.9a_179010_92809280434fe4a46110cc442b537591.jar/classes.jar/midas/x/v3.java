package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import java.net.URLEncoder;

public class v3
  extends y1
{
  public String A;
  public String B;
  public String C;
  public String D;
  public String E;
  
  public v3(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.A = paramString1;
    this.B = paramString2;
    this.C = paramString3;
    this.D = paramString4;
    this.E = paramString5;
    a("https", String.format("/v1/r/%s/mobile_security_proc", new Object[] { p4.p().e().b.offerId }), "442");
    G();
  }
  
  public void G()
  {
    b("offer_id", p4.p().c());
    c6 localc6 = c6.s0();
    o4 localo4 = p4.p().e();
    b("openid", localo4.b.openId);
    e("openid", localo4.b.openId);
    e("openkey", localo4.b.openKey);
    e("session_id", localo4.b.sessionId);
    e("session_type", localo4.b.sessionType);
    e("extend", localc6.e());
    e("zoneid", localo4.b.zoneId);
    e("action", "register");
    try
    {
      e("name", URLEncoder.encode(this.A, "utf-8"));
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    try
    {
      e("province", URLEncoder.encode(this.D, "utf-8"));
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    e("id_type", this.B);
    e("id_card", this.C);
    e("country", "");
    e("city", this.E);
    e("device_type", "android");
    e("device_mac", c6.s0().X());
    e("device_imei", c6.s0().W());
    e("device_androidid", c6.s0().V());
    e("device_guid", c6.s0().Y());
    e("uuid", localo4.f.k);
    e("mobile", "");
    e("operator", APTools.o(a.r().d));
    e("mccmnc", APTools.n(a.r().a()));
    e("address", "");
    e("test_invalid_user", "1");
    if (APAppDataInterface.singleton().h().equals("dev")) {
      e("offer_id", p4.p().e().b.offerId);
    }
    b("openid", localo4.b.openId);
    b("pf", localo4.b.pf);
    b("pfkey", localo4.b.pfKey);
    b("format", "json");
    b("sdkversion", z5.c());
    b("session_token", localo4.f.k);
    b("user_uuid", APTools.b(localc6.Y(), 1));
    b("user_imei", APTools.b(localc6.W(), 1));
    b("user_androidid", APTools.b(localc6.V(), 1));
    b("user_mac", APTools.b(localc6.X(), 1));
    b("xg_mid", APAppDataInterface.singleton().C());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.v3
 * JD-Core Version:    0.7.0.1
 */