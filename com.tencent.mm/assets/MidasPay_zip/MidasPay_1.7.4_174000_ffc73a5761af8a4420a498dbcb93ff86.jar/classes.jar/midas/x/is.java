package midas.x;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APGoodsRequest;
import com.pay.api.request.APMonthRequest;
import com.pay.api.request.APSubscribeRequest;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.common.APUICommonMethod;
import java.util.HashMap;

public class is
  extends ir
{
  private static final long serialVersionUID = 1L;
  private Activity f = null;
  private ib g = null;
  private ProgressDialog h = null;
  
  public is()
  {
    c();
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(Activity paramActivity, ib paramib, Bundle paramBundle)
  {
    super.a(paramActivity, paramib, paramBundle);
    this.f = paramActivity;
    this.g = paramib;
  }
  
  public void a(ProgressDialog paramProgressDialog)
  {
    super.a(paramProgressDialog);
    if (this.h != null) {
      this.h.show();
    }
    if (this.g != null) {
      this.g.b(b());
    }
  }
  
  public void a(String paramString) {}
  
  public boolean a()
  {
    APUICommonMethod.b();
    fv.a(5, "跳转h5支付，结果未知");
    return true;
  }
  
  public String b()
  {
    Object localObject1 = "";
    try
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("&random=");
      ((StringBuilder)localObject2).append(String.valueOf(Math.random() * 100.0D));
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label40:
      break label40;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("http://pay.qq.com/h5/index.shtml?");
    ((StringBuilder)localObject2).append(g());
    ((StringBuilder)localObject2).append((String)localObject1);
    return ((StringBuilder)localObject2).toString();
  }
  
  public String g()
  {
    HashMap localHashMap = new HashMap();
    Object localObject = em.b().n().a;
    localHashMap.put("m", "buy");
    localHashMap.put("_version", "v3");
    localHashMap.put("appid", ((APBaseRequest)localObject).offerId);
    localHashMap.put("pf", ((APBaseRequest)localObject).pf);
    localHashMap.put("n", ((APBaseRequest)localObject).saveValue);
    localHashMap.put("sessionid", ((APBaseRequest)localObject).sessionId);
    localHashMap.put("sessiontype", ((APBaseRequest)localObject).sessionType);
    localHashMap.put("openid", ((APBaseRequest)localObject).openId);
    localHashMap.put("openkey", ((APBaseRequest)localObject).openKey);
    localHashMap.put("zoneid", ((APBaseRequest)localObject).zoneId);
    localHashMap.put("sdk_version", fv.c());
    localHashMap.put("request_from", "androidsdk");
    int i = ((APBaseRequest)localObject).saveType;
    if (i == 0)
    {
      if (("hy_gameid".equals(em.b().n().a.sessionId)) && ("wc_actoken".equals(em.b().n().a.sessionType))) {
        localHashMap.put("c", "wechat_game");
      } else if (a.a().h()) {
        localHashMap.put("c", "itop_game");
      } else {
        localHashMap.put("c", "game");
      }
      if (TextUtils.isEmpty(((APBaseRequest)localObject).saveValue))
      {
        APUICommonMethod.b();
        fv.a(14, "跳转h5支付，结果未知");
      }
      else
      {
        localHashMap.put("as", "1");
      }
    }
    else if (i == 1)
    {
      localObject = (APGoodsRequest)em.b().n().a;
      if (((APGoodsRequest)localObject).tokenType == 1)
      {
        localHashMap.put("c", "goods");
        localHashMap.put("params", ((APGoodsRequest)localObject).goodsTokenUrl);
      }
      else
      {
        APUICommonMethod.b();
        fv.a(14, "跳转h5支付，结果未知");
      }
    }
    else if (i == 4)
    {
      APMonthRequest localAPMonthRequest = (APMonthRequest)em.b().n().a;
      localHashMap.put("da", "1");
      localHashMap.put("c", localAPMonthRequest.serviceCode.toLowerCase());
      localHashMap.put("_newservice", "1");
      if (TextUtils.isEmpty(((APBaseRequest)localObject).saveValue))
      {
        APUICommonMethod.b();
        fv.a(14, "跳转h5支付，结果未知");
      }
      else
      {
        localHashMap.put("as", "1");
      }
    }
    else if (i == 5)
    {
      localObject = (APSubscribeRequest)em.b().n().a;
      if ((!"uin".equals(em.b().n().a.sessionId)) && (!"openid".equals(em.b().n().a.sessionId))) {
        localHashMap.put("c", "subscribe");
      } else {
        localHashMap.put("c", "qqsubscribe");
      }
      localHashMap.put("as", "1");
      if (!TextUtils.isEmpty(((APSubscribeRequest)localObject).serviceCode)) {
        localHashMap.put("service", ((APSubscribeRequest)localObject).serviceCode);
      }
      localObject = (ew)em.b().n().b;
      if (!TextUtils.isEmpty(((ew)localObject).k)) {
        localHashMap.put("productid", ((ew)localObject).k);
      }
    }
    if ("test".equals(APAppDataInterface.singleton().e())) {
      localHashMap.put("sandbox", "1");
    }
    return APTools.a(localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.is
 * JD-Core Version:    0.7.0.1
 */