package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;

public class ea
  extends bx
{
  private String a;
  
  public ea(String paramString)
  {
    this.a = paramString;
    a("https", String.format("/v1/r/%s/mobile_mb_smscode", new Object[] { em.b().n().a.offerId }), "442");
    c();
  }
  
  private void a(fy paramfy)
  {
    el localel = em.b().n();
    f("openid", localel.a.openId);
    f("openkey", localel.a.openKey);
    f("pay_id", localel.e.a);
    f("auth_key", localel.e.b);
    f("session_type", localel.a.sessionType);
    f("sms_info", this.a);
    f("extend", paramfy.y());
    e("pay_session_id", localel.e.c);
    e("pay_session_type", localel.e.d);
    e("wx_pay_by_bindqq", "1");
    e("xg_mid", APAppDataInterface.singleton().l());
  }
  
  public void c()
  {
    fy localfy = fy.a();
    el localel = em.b().n();
    e("offer_id", em.b().f());
    e("openid", localel.a.openId);
    e("session_id", localel.a.sessionId);
    a(localfy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ea
 * JD-Core Version:    0.7.0.1
 */