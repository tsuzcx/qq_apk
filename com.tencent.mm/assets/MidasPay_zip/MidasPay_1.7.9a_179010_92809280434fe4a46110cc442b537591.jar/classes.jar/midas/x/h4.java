package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;

public class h4
  extends y1
{
  public String A;
  
  public h4(String paramString)
  {
    a("https", String.format("/v1/r/%s/mobile_get_cardbill_info", new Object[] { p4.p().e().b.offerId }), "442");
    this.A = paramString;
    G();
  }
  
  public void G()
  {
    c6 localc6 = c6.s0();
    b("offer_id", p4.p().c());
    o4 localo4 = p4.p().e();
    APBaseRequest localAPBaseRequest = localo4.b;
    int i = localAPBaseRequest.saveType;
    if ((i != 3) && (i != 2))
    {
      b("openid", localAPBaseRequest.openId);
      b("openkey", localo4.b.openKey);
      b("session_id", localo4.b.sessionId);
      b("session_type", localo4.b.sessionType);
    }
    else
    {
      if (i == 3) {
        b("accounttype", "qb");
      } else if (i == 2) {
        b("accounttype", "qd");
      }
      if ((a.r().e()) && (!localo4.e.e))
      {
        b("openid", localo4.f.a);
        b("openkey", localo4.f.b);
        b("session_id", "uin");
        b("session_type", "skey");
      }
      else if ((!d.a()) && (!d.b()))
      {
        b("openid", localo4.b.openId);
        b("openkey", localo4.b.openKey);
        b("session_id", localo4.b.sessionId);
        b("session_type", localo4.b.sessionType);
      }
      else
      {
        b("openid", localo4.f.a);
        b("openkey", localo4.f.b);
        b("session_id", "uin");
        b("session_type", "skey");
      }
    }
    b("pf", localo4.b.pf);
    b("pfkey", localo4.b.pfKey);
    b("billno", this.A);
    b("format", "json");
    b("sdkversion", z5.c());
    b("session_token", localo4.f.k);
    b("type", "1");
    b("use_errmsg", "1");
    b("extend", localc6.e());
    b("xg_mid", APAppDataInterface.singleton().C());
    if (APAppDataInterface.singleton().h().equals("dev")) {
      b("offer_id", p4.p().e().b.offerId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.h4
 * JD-Core Version:    0.7.0.1
 */