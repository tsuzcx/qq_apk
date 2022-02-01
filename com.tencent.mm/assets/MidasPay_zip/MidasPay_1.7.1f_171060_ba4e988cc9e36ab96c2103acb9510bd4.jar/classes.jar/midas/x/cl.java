package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;

public class cl
  extends br
{
  private String a;
  
  public cl(String paramString)
  {
    this.a = paramString;
    a("https", String.format("/v1/r/%s/mobile_get_image", new Object[] { ed.b().n().a.offerId }), "442");
    c();
  }
  
  public void c()
  {
    e("offer_id", ed.b().f());
    fp localfp = fp.a();
    ec localec = ed.b().n();
    e("openid", localec.a.openId);
    e("openkey", localec.a.openKey);
    e("session_id", localec.a.sessionId);
    e("session_type", localec.a.sessionType);
    e("pf", localec.a.pf);
    e("pfkey", localec.a.pfKey);
    e("type", "bin");
    e("format", "json");
    e("sdkversion", fm.c());
    e("session_token", localec.e.l);
    e("pay_method", this.a);
    e("xg_mid", APAppDataInterface.singleton().l());
    e("extend", localfp.y());
    if (APAppDataInterface.singleton().e().equals("dev")) {
      e("offer_id", ed.b().n().a.offerId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.cl
 * JD-Core Version:    0.7.0.1
 */