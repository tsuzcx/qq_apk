package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;

public class i2
  extends y1
{
  public String A = "";
  public String B = "0";
  
  public i2(String paramString1, String paramString2)
  {
    this.B = paramString2;
    this.A = paramString1;
    a("https", String.format("/v1/r/%s/mobile_get_cardbill_info", new Object[] { p4.p().e().b.offerId }), "442");
    G();
  }
  
  public void G()
  {
    if (this.B.equals("0")) {
      H();
    } else if (this.B.equals("5")) {
      J();
    } else if (this.B.equals("4")) {
      K();
    } else if (this.B.equals("3")) {
      I();
    }
    b("offer_id", p4.p().c());
  }
  
  public final void H()
  {
    c6 localc6 = c6.s0();
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
    b("xg_mid", APAppDataInterface.singleton().C());
    b("extend", localc6.e());
    if (c6.s0().U()) {
      b("mcard_pay_mode", "1");
    } else {
      b("mcard_pay_mode", "0");
    }
    if (APAppDataInterface.singleton().h().equals("dev")) {
      b("offer_id", p4.p().e().b.offerId);
    }
  }
  
  public final void I()
  {
    c6 localc6 = c6.s0();
    o4 localo4 = p4.p().e();
    e("openid", localo4.b.openId);
    e("openkey", localo4.b.openKey);
    e("session_id", localo4.b.sessionId);
    e("session_type", localo4.b.sessionType);
    e("pf", localo4.b.pf);
    e("pfkey", localo4.b.pfKey);
    b("openid", localo4.b.openId);
    b("billno", this.A);
    b("format", "json");
    b("sdkversion", z5.c());
    b("session_token", localo4.f.k);
    int i = localo4.b.saveType;
    if (i == 0) {
      b("type", "save");
    } else if (i == 1) {
      b("type", "bg");
    }
    b("oper_type", "3");
    b("xg_mid", APAppDataInterface.singleton().C());
    b("extend", localc6.e());
    if (APAppDataInterface.singleton().h().equals("dev")) {
      b("offer_id", p4.p().e().b.offerId);
    }
  }
  
  public final void J()
  {
    c6 localc6 = c6.s0();
    o4 localo4 = p4.p().e();
    e("openid", localo4.b.openId);
    e("openkey", localo4.b.openKey);
    e("session_id", localo4.b.sessionId);
    e("session_type", localo4.b.sessionType);
    e("pf", localo4.b.pf);
    e("pfkey", localo4.b.pfKey);
    b("openid", localo4.b.openId);
    b("billno", this.A);
    b("format", "json");
    b("sdkversion", z5.c());
    b("session_token", localo4.f.k);
    int i = localo4.b.saveType;
    if (i == 0) {
      b("type", "save");
    } else if (i == 1) {
      b("type", "bg");
    } else if (i == 4) {
      b("type", "month");
    } else if (i == 5) {
      b("type", "month");
    }
    if ((c6.s0().e0() != null) && (c6.s0().e0().toLowerCase().equals("v2")))
    {
      e("pre_contract", "1");
      b("pre_contract", "1");
    }
    b("oper_type", "5");
    b("xg_mid", APAppDataInterface.singleton().C());
    b("extend", localc6.e());
    if (APAppDataInterface.singleton().h().equals("dev")) {
      b("offer_id", p4.p().e().b.offerId);
    }
  }
  
  public final void K()
  {
    c6 localc6 = c6.s0();
    o4 localo4 = p4.p().e();
    e("openid", localo4.b.openId);
    e("openkey", localo4.b.openKey);
    e("session_id", localo4.b.sessionId);
    e("session_type", localo4.b.sessionType);
    e("pf", localo4.b.pf);
    e("pfkey", localo4.b.pfKey);
    b("openid", localo4.b.openId);
    b("billno", this.A);
    b("format", "json");
    b("sdkversion", z5.c());
    b("session_token", localo4.f.k);
    int i = localo4.b.saveType;
    if (i == 0) {
      b("type", "save");
    } else if (i == 1) {
      b("type", "bg");
    } else if (i == 4) {
      b("type", "bg");
    } else if (i == 5) {
      b("type", "bg");
    }
    b("oper_type", "4");
    b("xg_mid", APAppDataInterface.singleton().C());
    b("extend", localc6.e());
    if (APAppDataInterface.singleton().h().equals("dev")) {
      b("offer_id", p4.p().e().b.offerId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.i2
 * JD-Core Version:    0.7.0.1
 */