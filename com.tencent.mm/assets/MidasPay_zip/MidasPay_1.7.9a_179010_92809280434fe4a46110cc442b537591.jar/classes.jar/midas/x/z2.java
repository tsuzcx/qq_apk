package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APMonthRequest;
import com.pay.api.request.APSubscribeRequest;
import com.pay.tool.APTools;

public class z2
  extends y1
{
  public String A;
  public String B;
  public String C;
  
  public z2(String paramString1, String paramString2, String paramString3)
  {
    this.A = paramString1;
    this.C = paramString3;
    this.B = paramString2;
    a("https", String.format("/v1/r/%s/mobile_wireless_proc", new Object[] { p4.p().e().b.offerId }), "442");
    G();
  }
  
  public void G()
  {
    b("offer_id", p4.p().c());
    o4 localo4 = p4.p().e();
    APBaseRequest localAPBaseRequest = localo4.b;
    int i = localAPBaseRequest.saveType;
    if ((i != 3) && (i != 2))
    {
      b("openid", localAPBaseRequest.openId);
      b("session_id", localo4.b.sessionId);
      b("session_type", localo4.b.sessionType);
      e("openid", localo4.b.openId);
      e("openkey", localo4.b.openKey);
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
        b("session_id", "uin");
        b("session_type", "skey");
        e("openid", localo4.f.a);
        e("openkey", localo4.f.b);
      }
      else if ((!d.a()) && (!d.b()))
      {
        b("openid", localo4.b.openId);
        b("session_id", localo4.b.sessionId);
        b("session_type", localo4.b.sessionType);
        e("openid", localo4.b.openId);
        e("openkey", localo4.b.openKey);
      }
      else
      {
        b("openid", localo4.f.a);
        b("session_id", "uin");
        b("session_type", "skey");
        e("openid", localo4.f.a);
        e("openkey", localo4.f.b);
      }
    }
    a(localo4);
  }
  
  public final void a(o4 paramo4)
  {
    Object localObject = paramo4.b;
    int i = ((APBaseRequest)localObject).saveType;
    e("pf", ((APBaseRequest)localObject).pf);
    e("pfkey", paramo4.b.pfKey);
    e("zoneid", paramo4.b.zoneId);
    e("accounttype", paramo4.b.acctType);
    e("sdkversion", z5.c());
    e("action", this.A);
    localObject = new String[] { "save", "bg", "qd", "qb", "month", "unimonth" }[i];
    if (this.A.equals("hfpay_send_sms"))
    {
      e("type", (String)localObject);
      e("buy_quantity", paramo4.f.f);
      e("mobile", this.B);
      e("hf_billno", paramo4.f.m);
      e("portal_serial_no", paramo4.f.n);
      e("channel", c6.s0().t());
      e("hf_extend", c6.s0().s());
      e("pay_scene", "sdk");
      if (i == 1) {
        e("amt", String.valueOf(APTools.p(((y4)paramo4.c).a())));
      }
      if (i == 4) {
        e("service_code", ((APMonthRequest)paramo4.b).serviceCode);
      }
      if (i == 5)
      {
        e("service_code", ((APSubscribeRequest)paramo4.b).serviceCode);
        e("product_id", ((z4)paramo4.c).k);
      }
      if (i == 4)
      {
        localObject = paramo4.c;
        if (((z4)localObject).l == 4) {
          if (paramo4.b.isCanChange)
          {
            localObject = g6.k().d();
            if ((localObject != null) && (((String)localObject).length() > 0)) {
              e("provide_uin", g6.k().d());
            }
          }
          else
          {
            localObject = (z4)localObject;
            localObject = q7.a((z4)localObject, ((z4)localObject).m);
            if ((localObject != null) && (((String)localObject).length() > 0)) {
              e("provide_uin", (String)localObject);
            }
          }
        }
      }
      b("extend", paramo4.b.reserv);
      return;
    }
    if (this.A.equals("hfpay_direct_pay"))
    {
      e("type", (String)localObject);
      e("hf_billno", paramo4.f.m);
      e("sms_authcode", this.C);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.z2
 * JD-Core Version:    0.7.0.1
 */