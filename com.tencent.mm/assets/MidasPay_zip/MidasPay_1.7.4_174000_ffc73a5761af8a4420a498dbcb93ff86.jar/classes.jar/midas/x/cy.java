package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APMonthRequest;
import com.pay.api.request.APSubscribeRequest;
import com.pay.tool.APTools;

public class cy
  extends bx
{
  private String a;
  private String b;
  private String c;
  
  public cy(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.c = paramString3;
    this.b = paramString2;
    a("https", String.format("/v1/r/%s/mobile_wireless_proc", new Object[] { em.b().n().a.offerId }), "442");
    c();
  }
  
  private void a(el paramel)
  {
    int i = paramel.a.saveType;
    f("pf", paramel.a.pf);
    f("pfkey", paramel.a.pfKey);
    f("zoneid", paramel.a.zoneId);
    f("accounttype", paramel.a.acctType);
    f("sdkversion", fv.c());
    f("action", this.a);
    Object localObject = new String[] { "save", "bg", "qd", "qb", "month", "unimonth" }[i];
    if (this.a.equals("hfpay_send_sms"))
    {
      f("type", (String)localObject);
      f("buy_quantity", paramel.e.g);
      f("mobile", this.b);
      f("hf_billno", paramel.e.n);
      f("portal_serial_no", paramel.e.p);
      f("channel", fy.a().am());
      f("hf_extend", fy.a().an());
      f("pay_scene", "sdk");
      if (i == 1) {
        f("amt", String.valueOf(APTools.g(((ev)paramel.b).a())));
      }
      if (i == 4) {
        f("service_code", ((APMonthRequest)paramel.a).serviceCode);
      }
      if (i == 5)
      {
        f("service_code", ((APSubscribeRequest)paramel.a).serviceCode);
        f("product_id", ((ew)paramel.b).k);
      }
      if ((i == 4) && (((ew)paramel.b).l == 4)) {
        if (paramel.a.isCanChange)
        {
          localObject = gc.a().h();
          if ((localObject != null) && (((String)localObject).length() > 0)) {
            f("provide_uin", gc.a().h());
          }
        }
        else
        {
          localObject = (ew)paramel.b;
          localObject = hm.a((ew)localObject, ((ew)localObject).m);
          if ((localObject != null) && (((String)localObject).length() > 0)) {
            f("provide_uin", (String)localObject);
          }
        }
      }
      e("extend", paramel.a.reserv);
      return;
    }
    if (this.a.equals("hfpay_direct_pay"))
    {
      f("type", (String)localObject);
      f("hf_billno", paramel.e.n);
      f("sms_authcode", this.c);
    }
  }
  
  public void c()
  {
    e("offer_id", em.b().f());
    el localel = em.b().n();
    int i = localel.a.saveType;
    if ((i != 3) && (i != 2))
    {
      e("openid", localel.a.openId);
      e("session_id", localel.a.sessionId);
      e("session_type", localel.a.sessionType);
      f("openid", localel.a.openId);
      f("openkey", localel.a.openKey);
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
        e("session_id", "uin");
        e("session_type", "skey");
        f("openid", localel.e.a);
        f("openkey", localel.e.b);
      }
      else if ((!d.a()) && (!d.b()))
      {
        e("openid", localel.a.openId);
        e("session_id", localel.a.sessionId);
        e("session_type", localel.a.sessionType);
        f("openid", localel.a.openId);
        f("openkey", localel.a.openKey);
      }
      else
      {
        e("openid", localel.e.a);
        e("session_id", "uin");
        e("session_type", "skey");
        f("openid", localel.e.a);
        f("openkey", localel.e.b);
      }
    }
    a(localel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.cy
 * JD-Core Version:    0.7.0.1
 */