package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APTools;

public class do
  extends br
{
  private String a = "get_qrcode";
  
  public do(String paramString1, String paramString2)
  {
    this.l = "GET";
    this.a = paramString2;
    a("https", String.format("/v1/r/%s/qrcode", new Object[] { ed.b().n().a.offerId }), "442");
    a(paramString1);
  }
  
  public void a(String paramString)
  {
    ed.b().g();
    ec localec = ed.b().n();
    fp.a();
    e("openid", localec.a.openId);
    e("openkey", localec.a.openKey);
    e("session_id", localec.a.sessionId);
    e("session_type", localec.a.sessionType);
    e("a", this.a);
    e("url", APTools.a(paramString, 1));
    if (this.a.equals("l")) {
      e("t", paramString);
    }
    e("size", "600");
    e("sdkversion", "1.7.1f");
    e("uuid", fp.a().i());
    e("pushtype", "NodeJS");
  }
  
  protected void a_()
  {
    super.a_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.do
 * JD-Core Version:    0.7.0.1
 */