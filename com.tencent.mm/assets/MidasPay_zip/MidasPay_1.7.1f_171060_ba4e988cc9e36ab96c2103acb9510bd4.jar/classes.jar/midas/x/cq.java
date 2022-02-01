package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;

public class cq
  extends br
{
  private String a = "";
  private String b = "";
  
  public cq(String paramString1, String paramString2)
  {
    this.a = paramString2;
    this.b = paramString1;
    a("https", String.format("/v1/r/%s/mobile_hfpay_coupons_proc", new Object[] { ed.b().n().a.offerId }), "442");
    c();
  }
  
  public void c()
  {
    e("offer_id", ed.b().f());
    fp.a();
    Object localObject = ed.b().n();
    e("openid", ((ec)localObject).a.openId);
    e("openkey", ((ec)localObject).a.openKey);
    e("session_id", ((ec)localObject).a.sessionId);
    e("session_type", ((ec)localObject).a.sessionType);
    e("pf", ((ec)localObject).a.pf);
    e("pfkey", ((ec)localObject).a.pfKey);
    e("sdkversion", fm.c());
    f("openid", ((ec)localObject).a.openId);
    f("zoneid", ((ec)localObject).a.zoneId);
    f("accounttype", ((ec)localObject).a.acctType);
    f("action", this.a);
    if ("rollback".equals(this.a))
    {
      f("pre_uuid", APTools.a(fp.a().i(), 1));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pre_uuid:");
      ((StringBuilder)localObject).append(APTools.a(fp.a().i(), 1));
      APLog.i("APHFCouponsRollBackReq", ((StringBuilder)localObject).toString());
      f("varitem", fv.b().e());
      return;
    }
    if ("sp_rollback".equals(this.a))
    {
      APLog.i("out_trade_no:", ed.b().n().b());
      APLog.i("channel_orderid:", fp.a().D());
      f("out_trade_no", ed.b().n().b());
      f("channel_orderid", fp.a().D());
      f("pay_method", this.b);
      return;
    }
    if ("goldcoupons_rollback".equals(this.a))
    {
      f("varitem", o.a().n());
      f("channel_orderid", fp.a().D());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.cq
 * JD-Core Version:    0.7.0.1
 */