package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;

public class dm
  extends bx
{
  private String a;
  private String b;
  
  public dm(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.i = 1;
    a("https", String.format("/v1/r/%s/cancel_pay_notify", new Object[] { em.b().n().a.offerId }), "442");
    c();
  }
  
  public void c()
  {
    fy localfy = fy.a();
    el localel = em.b().n();
    e("offer_id", em.b().f());
    e("openid", localel.a.openId);
    e("openkey", localel.a.openKey);
    e("session_id", localel.a.sessionId);
    e("session_type", localel.a.sessionType);
    e("pf", localel.a.pf);
    e("pfkey", localel.a.pfKey);
    e("pay_method", this.a);
    e("channel_orderid", this.b);
    e("sdkversion", fv.c());
    f("extend", localfy.y());
    f("openid", localel.a.openId);
    e("user_uuid", APTools.a(localfy.q(), 1));
    e("user_imei", APTools.a(localfy.r(), 1));
    e("user_androidid", APTools.a(localfy.s(), 1));
    e("user_mac", APTools.a(localfy.t(), 1));
    e("xg_mid", APAppDataInterface.singleton().l());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.dm
 * JD-Core Version:    0.7.0.1
 */