package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APGoodsRequest;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;

public class v2
  extends y1
{
  public v2()
  {
    a("https", String.format("/v1/r/%s/activity_proc", new Object[] { p4.p().e().b.offerId }), "442");
    G();
  }
  
  public void G()
  {
    Object localObject = p4.p().e();
    b("offer_id", p4.p().c());
    b("openid", ((o4)localObject).b.openId);
    b("pf", ((o4)localObject).b.pf);
    b("pfkey", ((o4)localObject).b.pfKey);
    b("format", "json");
    b("sdkversion", z5.c());
    b("session_token", ((o4)localObject).f.k);
    b("buy_type", ((o4)localObject).c.g);
    b("xg_mid", APAppDataInterface.singleton().C());
    b("offer_id", p4.p().c());
    e("openid", ((o4)localObject).b.openId);
    e("openkey", ((o4)localObject).b.openKey);
    e("session_id", ((o4)localObject).b.sessionId);
    e("session_type", ((o4)localObject).b.sessionType);
    e("zoneid", ((o4)localObject).b.zoneId);
    localObject = (APGoodsRequest)p4.p().e().b;
    int i = ((APGoodsRequest)localObject).tokenType;
    if (2 == i)
    {
      e("productid", ((APGoodsRequest)localObject).prodcutId);
      e("is_forbid_vmall_order", "0");
    }
    else if (3 == i)
    {
      e("is_forbid_vmall_order", "1");
      e("goods_info", APTools.b(((APGoodsRequest)localObject).prodcutId, 1));
    }
    c6 localc6 = c6.s0();
    e("itemnum", ((APBaseRequest)localObject).saveValue);
    e("extend", localc6.e());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetDeveloperPayLoad = ");
    localStringBuilder.append(localc6.k());
    APLog.d("APGoodsTokenReq", localStringBuilder.toString());
    e("app_metadata", localc6.k());
    if (((APBaseRequest)localObject).isCanChange)
    {
      e("appmode", "2");
      return;
    }
    e("appmode", "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.v2
 * JD-Core Version:    0.7.0.1
 */