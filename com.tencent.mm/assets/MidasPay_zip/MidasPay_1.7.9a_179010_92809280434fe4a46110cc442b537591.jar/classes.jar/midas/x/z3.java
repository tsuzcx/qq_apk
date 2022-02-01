package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APTools;

public class z3
  extends y1
{
  public String A = "get_qrcode";
  
  public z3(String paramString1, String paramString2)
  {
    this.k = "GET";
    this.A = paramString2;
    a("https", String.format("/v1/r/%s/qrcode", new Object[] { p4.p().e().b.offerId }), "442");
    e(paramString1);
  }
  
  public void D()
  {
    super.D();
  }
  
  public void e(String paramString)
  {
    p4.p().g();
    o4 localo4 = p4.p().e();
    c6.s0();
    b("openid", localo4.b.openId);
    b("openkey", localo4.b.openKey);
    b("session_id", localo4.b.sessionId);
    b("session_type", localo4.b.sessionType);
    b("a", this.A);
    b("url", APTools.b(paramString, 1));
    if (this.A.equals("l")) {
      b("t", paramString);
    }
    b("size", "600");
    b("sdkversion", "1.7.9a");
    b("uuid", c6.s0().Z());
    b("pushtype", "NodeJS");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.z3
 * JD-Core Version:    0.7.0.1
 */