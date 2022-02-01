package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APGoodsRequest;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;

public class co
  extends br
{
  public co()
  {
    a("https", String.format("/v1/r/%s/activity_proc", new Object[] { ed.b().n().a.offerId }), "442");
    c();
  }
  
  public void c()
  {
    Object localObject = ed.b().n();
    e("offer_id", ed.b().f());
    e("openid", ((ec)localObject).a.openId);
    e("pf", ((ec)localObject).a.pf);
    e("pfkey", ((ec)localObject).a.pfKey);
    e("format", "json");
    e("sdkversion", fm.c());
    e("session_token", ((ec)localObject).e.l);
    e("buy_type", ((ec)localObject).b.j);
    e("xg_mid", APAppDataInterface.singleton().l());
    e("offer_id", ed.b().f());
    f("openid", ((ec)localObject).a.openId);
    f("openkey", ((ec)localObject).a.openKey);
    f("session_id", ((ec)localObject).a.sessionId);
    f("session_type", ((ec)localObject).a.sessionType);
    f("zoneid", ((ec)localObject).a.zoneId);
    localObject = (APGoodsRequest)ed.b().n().a;
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
    fp localfp = fp.a();
    f("itemnum", ((APGoodsRequest)localObject).saveValue);
    f("extend", localfp.y());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetDeveloperPayLoad = ");
    localStringBuilder.append(localfp.T());
    APLog.d("APGoodsTokenReq", localStringBuilder.toString());
    f("app_metadata", localfp.T());
    if (((APGoodsRequest)localObject).isCanChange)
    {
      f("appmode", "2");
      return;
    }
    f("appmode", "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.co
 * JD-Core Version:    0.7.0.1
 */