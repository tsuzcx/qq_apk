package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;

public class ch
  extends bx
{
  private String a = "";
  private String b = "0";
  
  public ch(String paramString1, String paramString2)
  {
    this.b = paramString2;
    this.a = paramString1;
    a("https", String.format("/v1/r/%s/mobile_get_cardbill_info", new Object[] { em.b().n().a.offerId }), "442");
    b();
  }
  
  private void I()
  {
    fy localfy = fy.a();
    el localel = em.b().n();
    int i = localel.a.saveType;
    if ((i != 3) && (i != 2))
    {
      e("openid", localel.a.openId);
      e("openkey", localel.a.openKey);
      e("session_id", localel.a.sessionId);
      e("session_type", localel.a.sessionType);
    }
    else
    {
      if (i == 3) {
        e("accounttype", "qb");
      } else if (i == 2) {
        e("accounttype", "qd");
      }
      if ((a.a().j()) && (!localel.d.e))
      {
        e("openid", localel.e.a);
        e("openkey", localel.e.b);
        e("session_id", "uin");
        e("session_type", "skey");
      }
      else if ((!d.a()) && (!d.b()))
      {
        e("openid", localel.a.openId);
        e("openkey", localel.a.openKey);
        e("session_id", localel.a.sessionId);
        e("session_type", localel.a.sessionType);
      }
      else
      {
        e("openid", localel.e.a);
        e("openkey", localel.e.b);
        e("session_id", "uin");
        e("session_type", "skey");
      }
    }
    e("pf", localel.a.pf);
    e("pfkey", localel.a.pfKey);
    e("billno", this.a);
    e("format", "json");
    e("sdkversion", fv.c());
    e("session_token", localel.e.l);
    e("xg_mid", APAppDataInterface.singleton().l());
    e("extend", localfy.y());
    if (fy.a().A()) {
      e("mcard_pay_mode", "1");
    } else {
      e("mcard_pay_mode", "0");
    }
    if (APAppDataInterface.singleton().e().equals("dev")) {
      e("offer_id", em.b().n().a.offerId);
    }
  }
  
  private void c()
  {
    fy localfy = fy.a();
    el localel = em.b().n();
    f("openid", localel.a.openId);
    f("openkey", localel.a.openKey);
    f("session_id", localel.a.sessionId);
    f("session_type", localel.a.sessionType);
    f("pf", localel.a.pf);
    f("pfkey", localel.a.pfKey);
    e("openid", localel.a.openId);
    e("billno", this.a);
    e("format", "json");
    e("sdkversion", fv.c());
    e("session_token", localel.e.l);
    int i = localel.a.saveType;
    if (i == 0) {
      e("type", "save");
    } else if (i == 1) {
      e("type", "bg");
    }
    e("oper_type", "3");
    e("xg_mid", APAppDataInterface.singleton().l());
    e("extend", localfy.y());
    if (APAppDataInterface.singleton().e().equals("dev")) {
      e("offer_id", em.b().n().a.offerId);
    }
  }
  
  private void d()
  {
    fy localfy = fy.a();
    el localel = em.b().n();
    f("openid", localel.a.openId);
    f("openkey", localel.a.openKey);
    f("session_id", localel.a.sessionId);
    f("session_type", localel.a.sessionType);
    f("pf", localel.a.pf);
    f("pfkey", localel.a.pfKey);
    e("openid", localel.a.openId);
    e("billno", this.a);
    e("format", "json");
    e("sdkversion", fv.c());
    e("session_token", localel.e.l);
    int i = localel.a.saveType;
    if (i == 0) {
      e("type", "save");
    } else if (i == 1) {
      e("type", "bg");
    } else if (i == 4) {
      e("type", "month");
    } else if (i == 5) {
      e("type", "month");
    }
    if ((fy.a().M() != null) && (fy.a().M().toLowerCase().equals("v2")))
    {
      f("pre_contract", "1");
      e("pre_contract", "1");
    }
    e("oper_type", "5");
    e("xg_mid", APAppDataInterface.singleton().l());
    e("extend", localfy.y());
    if (APAppDataInterface.singleton().e().equals("dev")) {
      e("offer_id", em.b().n().a.offerId);
    }
  }
  
  private void e()
  {
    fy localfy = fy.a();
    el localel = em.b().n();
    f("openid", localel.a.openId);
    f("openkey", localel.a.openKey);
    f("session_id", localel.a.sessionId);
    f("session_type", localel.a.sessionType);
    f("pf", localel.a.pf);
    f("pfkey", localel.a.pfKey);
    e("openid", localel.a.openId);
    e("billno", this.a);
    e("format", "json");
    e("sdkversion", fv.c());
    e("session_token", localel.e.l);
    int i = localel.a.saveType;
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
    e("extend", localfy.y());
    if (APAppDataInterface.singleton().e().equals("dev")) {
      e("offer_id", em.b().n().a.offerId);
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
    e("offer_id", em.b().f());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ch
 * JD-Core Version:    0.7.0.1
 */