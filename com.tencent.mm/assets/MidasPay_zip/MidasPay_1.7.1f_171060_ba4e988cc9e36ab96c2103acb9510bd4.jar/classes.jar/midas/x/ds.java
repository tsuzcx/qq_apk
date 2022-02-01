package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;

public class ds
  extends br
{
  private String a;
  
  public ds(String paramString)
  {
    this.a = paramString;
    a("https", String.format("/v1/r/%s/mobile_mb_smscode", new Object[] { ed.b().n().a.offerId }), "442");
    c();
  }
  
  private void a(fp paramfp)
  {
    ec localec = ed.b().n();
    f("openid", localec.a.openId);
    f("openkey", localec.a.openKey);
    f("pay_id", localec.e.a);
    f("auth_key", localec.e.b);
    f("session_type", localec.a.sessionType);
    f("sms_info", this.a);
    f("extend", paramfp.y());
    e("pay_session_id", localec.e.c);
    e("pay_session_type", localec.e.d);
    e("wx_pay_by_bindqq", "1");
    e("xg_mid", APAppDataInterface.singleton().l());
  }
  
  public void c()
  {
    fp localfp = fp.a();
    ec localec = ed.b().n();
    e("offer_id", ed.b().f());
    e("openid", localec.a.openId);
    e("session_id", localec.a.sessionId);
    a(localfp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ds
 * JD-Core Version:    0.7.0.1
 */