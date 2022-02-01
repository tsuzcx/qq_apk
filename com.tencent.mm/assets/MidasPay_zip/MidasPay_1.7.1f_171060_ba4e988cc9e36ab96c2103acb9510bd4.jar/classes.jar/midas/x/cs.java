package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APMonthRequest;
import com.pay.api.request.APSubscribeRequest;
import com.pay.tool.APTools;

public class cs
  extends br
{
  private String a;
  private String b;
  private String c;
  
  public cs(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.c = paramString3;
    this.b = paramString2;
    a("https", String.format("/v1/r/%s/mobile_wireless_proc", new Object[] { ed.b().n().a.offerId }), "442");
    c();
  }
  
  private void a(ec paramec)
  {
    int i = paramec.a.saveType;
    f("pf", paramec.a.pf);
    f("pfkey", paramec.a.pfKey);
    f("zoneid", paramec.a.zoneId);
    f("accounttype", paramec.a.acctType);
    f("sdkversion", fm.c());
    f("action", this.a);
    Object localObject = new String[] { "save", "bg", "qd", "qb", "month", "unimonth" }[i];
    if (this.a.equals("hfpay_send_sms"))
    {
      f("type", (String)localObject);
      f("buy_quantity", paramec.e.g);
      f("mobile", this.b);
      f("hf_billno", paramec.e.n);
      f("portal_serial_no", paramec.e.p);
      if (i == 1) {
        f("amt", String.valueOf(APTools.g(((em)paramec.b).a())));
      }
      if (i == 4) {
        f("service_code", ((APMonthRequest)paramec.a).serviceCode);
      }
      if (i == 5)
      {
        localObject = (APSubscribeRequest)paramec.a;
        f("service_code", ((APSubscribeRequest)localObject).serviceCode);
        f("product_id", ((APSubscribeRequest)localObject).productId);
      }
      if ((i == 4) && (((en)paramec.b).l == 4)) {
        if (paramec.a.isCanChange)
        {
          localObject = fs.a().h();
          if ((localObject != null) && (((String)localObject).length() > 0)) {
            f("provide_uin", fs.a().h());
          }
        }
        else
        {
          localObject = (en)paramec.b;
          localObject = hb.a((en)localObject, ((en)localObject).m);
          if ((localObject != null) && (((String)localObject).length() > 0)) {
            f("provide_uin", (String)localObject);
          }
        }
      }
      e("extend", paramec.a.reserv);
      return;
    }
    if (this.a.equals("hfpay_direct_pay"))
    {
      f("type", (String)localObject);
      f("hf_billno", paramec.e.n);
      f("sms_authcode", this.c);
    }
  }
  
  public void c()
  {
    e("offer_id", ed.b().f());
    ec localec = ed.b().n();
    int i = localec.a.saveType;
    if ((i != 3) && (i != 2))
    {
      e("openid", localec.a.openId);
      e("session_id", localec.a.sessionId);
      e("session_type", localec.a.sessionType);
      f("openid", localec.a.openId);
      f("openkey", localec.a.openKey);
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
        e("session_id", "uin");
        e("session_type", "skey");
        f("openid", localec.e.a);
        f("openkey", localec.e.b);
      }
      else if ((!d.a()) && (!d.b()))
      {
        e("openid", localec.a.openId);
        e("session_id", localec.a.sessionId);
        e("session_type", localec.a.sessionType);
        f("openid", localec.a.openId);
        f("openkey", localec.a.openKey);
      }
      else
      {
        e("openid", localec.e.a);
        e("session_id", "uin");
        e("session_type", "skey");
        f("openid", localec.e.a);
        f("openkey", localec.e.b);
      }
    }
    a(localec);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.cs
 * JD-Core Version:    0.7.0.1
 */