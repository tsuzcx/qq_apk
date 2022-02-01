package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;

public class cr
  extends bx
{
  private String a;
  
  public cr(String paramString)
  {
    this.a = paramString;
    a("https", String.format("/v1/r/%s/mobile_get_image", new Object[] { em.b().n().a.offerId }), "442");
    c();
  }
  
  public void c()
  {
    e("offer_id", em.b().f());
    fy localfy = fy.a();
    el localel = em.b().n();
    e("openid", localel.a.openId);
    e("openkey", localel.a.openKey);
    e("session_id", localel.a.sessionId);
    e("session_type", localel.a.sessionType);
    e("pf", localel.a.pf);
    e("pfkey", localel.a.pfKey);
    e("type", "bin");
    e("format", "json");
    e("sdkversion", fv.c());
    e("session_token", localel.e.l);
    e("pay_method", this.a);
    e("xg_mid", APAppDataInterface.singleton().l());
    e("extend", localfy.y());
    if (APAppDataInterface.singleton().e().equals("dev")) {
      e("offer_id", em.b().n().a.offerId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.cr
 * JD-Core Version:    0.7.0.1
 */