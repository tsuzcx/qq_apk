package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;

public class cw
  extends bx
{
  private String a = "";
  private String b = "";
  
  public cw(String paramString1, String paramString2)
  {
    this.a = paramString2;
    this.b = paramString1;
    a("https", String.format("/v1/r/%s/mobile_hfpay_coupons_proc", new Object[] { em.b().n().a.offerId }), "442");
    c();
  }
  
  public void c()
  {
    e("offer_id", em.b().f());
    fy.a();
    Object localObject = em.b().n();
    e("openid", ((el)localObject).a.openId);
    e("openkey", ((el)localObject).a.openKey);
    e("session_id", ((el)localObject).a.sessionId);
    e("session_type", ((el)localObject).a.sessionType);
    e("pf", ((el)localObject).a.pf);
    e("pfkey", ((el)localObject).a.pfKey);
    e("sdkversion", fv.c());
    f("openid", ((el)localObject).a.openId);
    f("zoneid", ((el)localObject).a.zoneId);
    f("accounttype", ((el)localObject).a.acctType);
    f("action", this.a);
    if ("rollback".equals(this.a))
    {
      f("pre_uuid", APTools.a(fy.a().i(), 1));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pre_uuid:");
      ((StringBuilder)localObject).append(APTools.a(fy.a().i(), 1));
      APLog.i("APHFCouponsRollBackReq", ((StringBuilder)localObject).toString());
      f("varitem", gf.b().e());
      return;
    }
    if ("sp_rollback".equals(this.a))
    {
      APLog.i("out_trade_no:", em.b().n().b());
      APLog.i("channel_orderid:", fy.a().D());
      f("out_trade_no", em.b().n().b());
      f("channel_orderid", fy.a().D());
      f("pay_method", this.b);
      return;
    }
    if ("goldcoupons_rollback".equals(this.a))
    {
      f("varitem", o.a().n());
      f("channel_orderid", fy.a().D());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.cw
 * JD-Core Version:    0.7.0.1
 */