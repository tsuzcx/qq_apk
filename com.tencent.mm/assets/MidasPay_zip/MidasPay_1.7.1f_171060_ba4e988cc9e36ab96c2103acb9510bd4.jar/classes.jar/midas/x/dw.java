package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;

public class dw
  extends br
{
  private String a;
  
  public dw(String paramString)
  {
    a("https", String.format("/v1/r/%s/mobile_get_cardbill_info", new Object[] { ed.b().n().a.offerId }), "442");
    this.a = paramString;
    c();
  }
  
  public void c()
  {
    fp localfp = fp.a();
    e("offer_id", ed.b().f());
    ec localec = ed.b().n();
    int i = localec.a.saveType;
    if ((i != 3) && (i != 2))
    {
      e("openid", localec.a.openId);
      e("openkey", localec.a.openKey);
      e("session_id", localec.a.sessionId);
      e("session_type", localec.a.sessionType);
    }
    else
    {
      if (i == 3) {
        e("accounttype", "qb");
      } else if (i == 2) {
        e("accounttype", "qd");
      }
      if ((a.a().j()) && (!localec.d.e))
      {
        e("openid", localec.e.a);
        e("openkey", localec.e.b);
        e("session_id", "uin");
        e("session_type", "skey");
      }
      else if ((!d.a()) && (!d.b()))
      {
        e("openid", localec.a.openId);
        e("openkey", localec.a.openKey);
        e("session_id", localec.a.sessionId);
        e("session_type", localec.a.sessionType);
      }
      else
      {
        e("openid", localec.e.a);
        e("openkey", localec.e.b);
        e("session_id", "uin");
        e("session_type", "skey");
      }
    }
    e("pf", localec.a.pf);
    e("pfkey", localec.a.pfKey);
    e("billno", this.a);
    e("format", "json");
    e("sdkversion", fm.c());
    e("session_token", localec.e.l);
    e("type", "1");
    e("use_errmsg", "1");
    e("extend", localfp.y());
    e("xg_mid", APAppDataInterface.singleton().l());
    if (APAppDataInterface.singleton().e().equals("dev")) {
      e("offer_id", ed.b().n().a.offerId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.dw
 * JD-Core Version:    0.7.0.1
 */