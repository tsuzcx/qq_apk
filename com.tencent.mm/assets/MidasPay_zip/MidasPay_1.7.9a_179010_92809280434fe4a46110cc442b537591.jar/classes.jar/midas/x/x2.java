package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;

public class x2
  extends y1
{
  public String A = "";
  public String B = "";
  
  public x2(String paramString1, String paramString2)
  {
    this.A = paramString2;
    this.B = paramString1;
    a("https", String.format("/v1/r/%s/mobile_hfpay_coupons_proc", new Object[] { p4.p().e().b.offerId }), "442");
    G();
  }
  
  public void G()
  {
    b("offer_id", p4.p().c());
    c6.s0();
    Object localObject = p4.p().e();
    b("openid", ((o4)localObject).b.openId);
    b("openkey", ((o4)localObject).b.openKey);
    b("session_id", ((o4)localObject).b.sessionId);
    b("session_type", ((o4)localObject).b.sessionType);
    b("pf", ((o4)localObject).b.pf);
    b("pfkey", ((o4)localObject).b.pfKey);
    b("sdkversion", z5.c());
    e("openid", ((o4)localObject).b.openId);
    e("zoneid", ((o4)localObject).b.zoneId);
    e("accounttype", ((o4)localObject).b.acctType);
    e("action", this.A);
    if ("rollback".equals(this.A))
    {
      e("pre_uuid", APTools.b(c6.s0().Z(), 1));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pre_uuid:");
      ((StringBuilder)localObject).append(APTools.b(c6.s0().Z(), 1));
      APLog.i("APHFCouponsRollBackReq", ((StringBuilder)localObject).toString());
      e("varitem", j6.e().b());
      return;
    }
    if ("sp_rollback".equals(this.A))
    {
      APLog.i("out_trade_no:", p4.p().e().b());
      APLog.i("channel_orderid:", c6.s0().g());
      e("out_trade_no", p4.p().e().b());
      e("channel_orderid", c6.s0().g());
      e("pay_method", this.B);
      return;
    }
    if ("goldcoupons_rollback".equals(this.A))
    {
      e("varitem", p.o().b());
      e("channel_orderid", c6.s0().g());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.x2
 * JD-Core Version:    0.7.0.1
 */