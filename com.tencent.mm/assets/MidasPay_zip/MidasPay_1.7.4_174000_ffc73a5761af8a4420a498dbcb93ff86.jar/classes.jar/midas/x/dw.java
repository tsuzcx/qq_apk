package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APTools;

public class dw
  extends bx
{
  private String a = "get_qrcode";
  
  public dw(String paramString1, String paramString2)
  {
    this.l = "GET";
    this.a = paramString2;
    a("https", String.format("/v1/r/%s/qrcode", new Object[] { em.b().n().a.offerId }), "442");
    a(paramString1);
  }
  
  public void a(String paramString)
  {
    em.b().g();
    el localel = em.b().n();
    fy.a();
    e("openid", localel.a.openId);
    e("openkey", localel.a.openKey);
    e("session_id", localel.a.sessionId);
    e("session_type", localel.a.sessionType);
    e("a", this.a);
    e("url", APTools.a(paramString, 1));
    if (this.a.equals("l")) {
      e("t", paramString);
    }
    e("size", "600");
    e("sdkversion", "1.7.4");
    e("uuid", fy.a().i());
    e("pushtype", "NodeJS");
  }
  
  protected void a_()
  {
    super.a_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.dw
 * JD-Core Version:    0.7.0.1
 */