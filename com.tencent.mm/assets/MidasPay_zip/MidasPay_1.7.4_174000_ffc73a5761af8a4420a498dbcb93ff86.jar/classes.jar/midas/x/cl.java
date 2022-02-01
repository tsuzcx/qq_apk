package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;

public class cl
  extends bx
{
  public cl()
  {
    String str1 = String.format("/v1/r/%s/get_ip_list", new Object[] { em.b().n().a.offerId });
    String str2 = bz.c();
    this.i = 3;
    a(str2, "https", str1, "443");
    b();
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void b()
  {
    fy localfy = fy.a();
    e("offer_id", em.b().f());
    el localel = em.b().n();
    if (localel != null)
    {
      e("openid", localel.a.openId);
      e("openkey", localel.a.openKey);
      e("session_id", localel.a.sessionId);
      e("session_type", localel.a.sessionType);
      e("pf", localel.a.pf);
      e("pfkey", localel.a.pfKey);
      e("format", "json");
      e("session_token", localel.e.l);
    }
    e("extend", localfy.y());
    e("sdkversion", fv.c());
    e("xg_mid", APAppDataInterface.singleton().l());
    if (APAppDataInterface.singleton().e().equals("dev")) {
      e("offer_id", em.b().n().a.offerId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.cl
 * JD-Core Version:    0.7.0.1
 */