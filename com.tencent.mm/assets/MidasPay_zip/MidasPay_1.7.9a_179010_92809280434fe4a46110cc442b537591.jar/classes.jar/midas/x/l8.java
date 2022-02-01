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

public class l8
  extends k8
{
  public static final long serialVersionUID = 1L;
  public e8 e = null;
  public ProgressDialog f = null;
  
  public l8()
  {
    c();
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(Activity paramActivity, e8 parame8, Bundle paramBundle)
  {
    super.a(paramActivity, parame8, paramBundle);
    this.e = parame8;
  }
  
  public void a(ProgressDialog paramProgressDialog)
  {
    super.a(paramProgressDialog);
    paramProgressDialog = this.f;
    if (paramProgressDialog != null) {
      paramProgressDialog.show();
    }
    paramProgressDialog = this.e;
    if (paramProgressDialog != null) {
      paramProgressDialog.b(f());
    }
  }
  
  public void a(String paramString) {}
  
  public boolean e()
  {
    APUICommonMethod.f();
    z5.a(5, "跳转h5支付，结果未知");
    return true;
  }
  
  public String f()
  {
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("&random=");
      ((StringBuilder)localObject).append(String.valueOf(Math.random() * 100.0D));
      localObject = ((StringBuilder)localObject).toString();
    }
    catch (Exception localException)
    {
      Object localObject;
      label38:
      StringBuilder localStringBuilder;
      break label38;
    }
    localObject = "";
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://pay.qq.com/h5/index.shtml?");
    localStringBuilder.append(g());
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  public String g()
  {
    HashMap localHashMap = new HashMap();
    Object localObject = p4.p().e().b;
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
    localHashMap.put("sdk_version", z5.c());
    localHashMap.put("request_from", "androidsdk");
    int i = ((APBaseRequest)localObject).saveType;
    if (i == 0)
    {
      if (("hy_gameid".equals(p4.p().e().b.sessionId)) && ("wc_actoken".equals(p4.p().e().b.sessionType))) {
        localHashMap.put("c", "wechat_game");
      } else if (a.r().c()) {
        localHashMap.put("c", "itop_game");
      } else {
        localHashMap.put("c", "game");
      }
      if (TextUtils.isEmpty(((APBaseRequest)localObject).saveValue))
      {
        APUICommonMethod.f();
        z5.a(14, "跳转h5支付，结果未知");
      }
      else
      {
        localHashMap.put("as", "1");
      }
    }
    else if (i == 1)
    {
      localObject = (APGoodsRequest)p4.p().e().b;
      if (((APGoodsRequest)localObject).tokenType == 1)
      {
        localHashMap.put("c", "goods");
        localHashMap.put("params", ((APGoodsRequest)localObject).goodsTokenUrl);
      }
      else
      {
        APUICommonMethod.f();
        z5.a(14, "跳转h5支付，结果未知");
      }
    }
    else if (i == 4)
    {
      APMonthRequest localAPMonthRequest = (APMonthRequest)p4.p().e().b;
      localHashMap.put("da", "1");
      localHashMap.put("c", localAPMonthRequest.serviceCode.toLowerCase());
      localHashMap.put("_newservice", "1");
      if (TextUtils.isEmpty(((APBaseRequest)localObject).saveValue))
      {
        APUICommonMethod.f();
        z5.a(14, "跳转h5支付，结果未知");
      }
      else
      {
        localHashMap.put("as", "1");
      }
    }
    else if (i == 5)
    {
      localObject = (APSubscribeRequest)p4.p().e().b;
      if ((!"uin".equals(p4.p().e().b.sessionId)) && (!"openid".equals(p4.p().e().b.sessionId))) {
        localHashMap.put("c", "subscribe");
      } else {
        localHashMap.put("c", "qqsubscribe");
      }
      localHashMap.put("as", "1");
      if (!TextUtils.isEmpty(((APMonthRequest)localObject).serviceCode)) {
        localHashMap.put("service", ((APMonthRequest)localObject).serviceCode);
      }
      localObject = (z4)p4.p().e().c;
      if (!TextUtils.isEmpty(((z4)localObject).k)) {
        localHashMap.put("productid", ((z4)localObject).k);
      }
    }
    if ("test".equals(APAppDataInterface.singleton().h())) {
      localHashMap.put("sandbox", "1");
    }
    return APTools.a(localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.l8
 * JD-Core Version:    0.7.0.1
 */