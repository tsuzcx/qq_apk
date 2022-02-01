package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;

public class cb
  extends br
{
  private String a = "";
  private String b = "0";
  
  public cb(String paramString1, String paramString2)
  {
    this.b = paramString2;
    this.a = paramString1;
    a("https", String.format("/v1/r/%s/mobile_get_cardbill_info", new Object[] { ed.b().n().a.offerId }), "442");
    b();
  }
  
  private void I()
  {
    fp localfp = fp.a();
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
    e("xg_mid", APAppDataInterface.singleton().l());
    e("extend", localfp.y());
    if (fp.a().A()) {
      e("mcard_pay_mode", "1");
    } else {
      e("mcard_pay_mode", "0");
    }
    if (APAppDataInterface.singleton().e().equals("dev")) {
      e("offer_id", ed.b().n().a.offerId);
    }
  }
  
  private void c()
  {
    fp localfp = fp.a();
    ec localec = ed.b().n();
    f("openid", localec.a.openId);
    f("openkey", localec.a.openKey);
    f("session_id", localec.a.sessionId);
    f("session_type", localec.a.sessionType);
    f("pf", localec.a.pf);
    f("pfkey", localec.a.pfKey);
    e("openid", localec.a.openId);
    e("billno", this.a);
    e("format", "json");
    e("sdkversion", fm.c());
    e("session_token", localec.e.l);
    int i = localec.a.saveType;
    if (i == 0) {
      e("type", "save");
    } else if (i == 1) {
      e("type", "bg");
    }
    e("oper_type", "3");
    e("xg_mid", APAppDataInterface.singleton().l());
    e("extend", localfp.y());
    if (APAppDataInterface.singleton().e().equals("dev")) {
      e("offer_id", ed.b().n().a.offerId);
    }
  }
  
  private void d()
  {
    fp localfp = fp.a();
    ec localec = ed.b().n();
    f("openid", localec.a.openId);
    f("openkey", localec.a.openKey);
    f("session_id", localec.a.sessionId);
    f("session_type", localec.a.sessionType);
    f("pf", localec.a.pf);
    f("pfkey", localec.a.pfKey);
    e("openid", localec.a.openId);
    e("billno", this.a);
    e("format", "json");
    e("sdkversion", fm.c());
    e("session_token", localec.e.l);
    int i = localec.a.saveType;
    if (i == 0) {
      e("type", "save");
    } else if (i == 1) {
      e("type", "bg");
    } else if (i == 4) {
      e("type", "month");
    } else if (i == 5) {
      e("type", "month");
    }
    if ((fp.a().M() != null) && (fp.a().M().toLowerCase().equals("v2")))
    {
      f("pre_contract", "1");
      e("pre_contract", "1");
    }
    e("oper_type", "5");
    e("xg_mid", APAppDataInterface.singleton().l());
    e("extend", localfp.y());
    if (APAppDataInterface.singleton().e().equals("dev")) {
      e("offer_id", ed.b().n().a.offerId);
    }
  }
  
  private void e()
  {
    fp localfp = fp.a();
    ec localec = ed.b().n();
    f("openid", localec.a.openId);
    f("openkey", localec.a.openKey);
    f("session_id", localec.a.sessionId);
    f("session_type", localec.a.sessionType);
    f("pf", localec.a.pf);
    f("pfkey", localec.a.pfKey);
    e("openid", localec.a.openId);
    e("billno", this.a);
    e("format", "json");
    e("sdkversion", fm.c());
    e("session_token", localec.e.l);
    int i = localec.a.saveType;
    if (i == 0) {
      e("type", "save");
    } else if (i == 1) {
      e("type", "bg");
    } else if (i == 4) {
      e("type", "bg");
    } else if (i == 5) {
      e("type", "bg");
    }
    e("oper_type", "4");
    e("xg_mid", APAppDataInterface.singleton().l());
    e("extend", localfp.y());
    if (APAppDataInterface.singleton().e().equals("dev")) {
      e("offer_id", ed.b().n().a.offerId);
    }
  }
  
  public void b()
  {
    if (this.b.equals("0")) {
      I();
    } else if (this.b.equals("5")) {
      d();
    } else if (this.b.equals("4")) {
      e();
    } else if (this.b.equals("3")) {
      c();
    }
    e("offer_id", ed.b().f());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.cb
 * JD-Core Version:    0.7.0.1
 */