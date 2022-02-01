package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APGoodsRequest;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;

public class cu
  extends bx
{
  public cu()
  {
    a("https", String.format("/v1/r/%s/activity_proc", new Object[] { em.b().n().a.offerId }), "442");
    c();
  }
  
  public void c()
  {
    Object localObject = em.b().n();
    e("offer_id", em.b().f());
    e("openid", ((el)localObject).a.openId);
    e("pf", ((el)localObject).a.pf);
    e("pfkey", ((el)localObject).a.pfKey);
    e("format", "json");
    e("sdkversion", fv.c());
    e("session_token", ((el)localObject).e.l);
    e("buy_type", ((el)localObject).b.j);
    e("xg_mid", APAppDataInterface.singleton().l());
    e("offer_id", em.b().f());
    f("openid", ((el)localObject).a.openId);
    f("openkey", ((el)localObject).a.openKey);
    f("session_id", ((el)localObject).a.sessionId);
    f("session_type", ((el)localObject).a.sessionType);
    f("zoneid", ((el)localObject).a.zoneId);
    localObject = (APGoodsRequest)em.b().n().a;
    if (2 == ((APGoodsRequest)localObject).tokenType)
    {
      f("productid", ((APGoodsRequest)localObject).prodcutId);
      f("is_forbid_vmall_order", "0");
    }
    else if (3 == ((APGoodsRequest)localObject).tokenType)
    {
      f("is_forbid_vmall_order", "1");
      f("goods_info", APTools.a(((APGoodsRequest)localObject).prodcutId, 1));
    }
    fy localfy = fy.a();
    f("itemnum", ((APGoodsRequest)localObject).saveValue);
    f("extend", localfy.y());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetDeveloperPayLoad = ");
    localStringBuilder.append(localfy.T());
    APLog.d("APGoodsTokenReq", localStringBuilder.toString());
    f("app_metadata", localfy.T());
    if (((APGoodsRequest)localObject).isCanChange)
    {
      f("appmode", "2");
      return;
    }
    f("appmode", "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.cu
 * JD-Core Version:    0.7.0.1
 */