package com.tencent.midas.jsbridge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.Toast;
import com.pay.tool.APMidasCommMethod;
import com.pay.tool.APMidasTools;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.midas.api.request.APMidasBaseRequest.APMidasExtendInfo;
import com.tencent.midas.api.request.APMidasBaseRequest.APMidasMPInfo;
import com.tencent.midas.api.request.APMidasGameRequest;
import com.tencent.midas.api.request.APMidasGoodsRequest;
import com.tencent.midas.api.request.APMidasMonthRequest;
import com.tencent.midas.api.request.APMidasSubscribeRequest;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.control.APMidasPayHelper;
import com.tencent.midas.data.APPluginDataInterface;
import com.tencent.midas.data.APPluginReportManager;
import com.tencent.midas.plugin.APPluginUtils;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class APWebJSBridgeActivity
  extends HellActivity
{
  private static final String KEY_REQUEST = "key_request";
  private static final String KEY_TYPE = "key_pure_h5_pay";
  private static final String TAG = "APWebJSBridgeActivity";
  private static final String VALUE_PURE_H5 = "value_pure_h5_pay";
  private static final String WEB_URL_POST = "/index.html";
  private static final String WEB_URL_PRE = "http://youxi.vip.qq.com/m/act/";
  private byte _hellAccFlag_;
  private IAPWebPage webPage = null;
  
  private String constructUrl()
  {
    AppMethodBeat.i(192856);
    String str1;
    Object localObject;
    if (TextUtils.isEmpty(APPluginDataInterface.singleton().getDiscountUrl()))
    {
      str1 = "http://youxi.vip.qq.com/m/act/" + APPluginDataInterface.singleton().getOfferId() + "/index.html";
      str2 = APMidasTools.getUrlParamsValue(str1, APWebProtocol.URL_KEY_HEAD_CONTROL);
      localObject = APMidasTools.getUrlParamsValue(str1, APWebProtocol.URL_KEY_HEAD_TITLE);
      this.webPage.initHead(this, str2, (String)localObject);
      this.webPage.updateWebViewSize(str1);
      APLog.e("constructUrl", str1);
      localObject = new HashMap();
      ((HashMap)localObject).put("offerId", APPluginDataInterface.singleton().getOfferId());
      ((HashMap)localObject).put("openId", APPluginDataInterface.singleton().getOpenId());
      ((HashMap)localObject).put("openKey", APPluginDataInterface.singleton().getOpenKey());
      ((HashMap)localObject).put("sessionId", APPluginDataInterface.singleton().getSessionId());
      ((HashMap)localObject).put("sessionType", APPluginDataInterface.singleton().getSessionType());
      ((HashMap)localObject).put("pf", APPluginDataInterface.singleton().getPf());
      ((HashMap)localObject).put("pfKey", APPluginDataInterface.singleton().getPfKey());
      ((HashMap)localObject).put("zoneId", APPluginDataInterface.singleton().getZoneId());
      if (!str1.contains("?")) {
        break label328;
      }
      str2 = str1;
      if (str1.endsWith("?")) {}
    }
    label328:
    for (String str2 = str1 + "&";; str2 = str1 + "?")
    {
      str1 = str2 + APMidasTools.map2UrlParams((HashMap)localObject);
      APLog.i("constructUrl", str1);
      AppMethodBeat.o(192856);
      return str1;
      str1 = APPluginDataInterface.singleton().getDiscountUrl();
      str2 = APMidasTools.getUrlParamsValue(str1, APWebProtocol.URL_KEY_HEAD_CONTROL);
      localObject = APMidasTools.getUrlParamsValue(str1, APWebProtocol.URL_KEY_HEAD_TITLE);
      this.webPage.initHead(this, str2, (String)localObject);
      this.webPage.updateWebViewSize(APPluginDataInterface.singleton().getDiscountUrl());
      break;
    }
  }
  
  private String getPureH5PayURLParameters(APMidasBaseRequest paramAPMidasBaseRequest)
  {
    AppMethodBeat.i(192847);
    HashMap localHashMap = new HashMap();
    localHashMap.put("m", "buy");
    localHashMap.put("_version", "v3");
    localHashMap.put("appid", paramAPMidasBaseRequest.offerId);
    localHashMap.put("pf", paramAPMidasBaseRequest.pf);
    localHashMap.put("n", paramAPMidasBaseRequest.saveValue);
    localHashMap.put("sessionid", paramAPMidasBaseRequest.sessionId);
    localHashMap.put("sessiontype", paramAPMidasBaseRequest.sessionType);
    localHashMap.put("openid", paramAPMidasBaseRequest.openId);
    localHashMap.put("openkey", paramAPMidasBaseRequest.openKey);
    localHashMap.put("zoneid", paramAPMidasBaseRequest.zoneId);
    localHashMap.put("sdktype", "android");
    Object localObject = APPluginUtils.getMidasCoreVersionName(this);
    APLog.d("APWebJSBridgeActivity", "app_version = ".concat(String.valueOf(localObject)));
    localHashMap.put("appversion", localObject);
    localHashMap.put("request_from", "androidsdk");
    localHashMap.put("is_android_sdk_error_version", "1");
    localHashMap.put("android_sdk_reserve", paramAPMidasBaseRequest.reserv);
    localHashMap.put("android_sdk_mpinfo_discountType", paramAPMidasBaseRequest.mpInfo.discountType);
    localHashMap.put("android_sdk_mpinfo_discountUrl", paramAPMidasBaseRequest.mpInfo.discountUrl);
    localHashMap.put("android_sdk_mpinfo_discoutId", paramAPMidasBaseRequest.mpInfo.discoutId);
    localHashMap.put("android_sdk_mpinfo_drmInfo", paramAPMidasBaseRequest.mpInfo.drmInfo);
    localHashMap.put("android_sdk_mpinfo_extras", paramAPMidasBaseRequest.mpInfo.extras);
    localHashMap.put("android_sdk_mpinfo_payChannel", paramAPMidasBaseRequest.mpInfo.payChannel);
    localHashMap.put("android_sdk_extendInfo_unit", paramAPMidasBaseRequest.extendInfo.unit);
    localHashMap.put("android_sdk_extendInfo_isShowListOtherNum", String.valueOf(paramAPMidasBaseRequest.extendInfo.isShowListOtherNum));
    localHashMap.put("android_sdk_extendInfo_isShowNum", String.valueOf(paramAPMidasBaseRequest.extendInfo.isShowNum));
    if ((paramAPMidasBaseRequest instanceof APMidasGameRequest)) {
      if (("hy_gameid".equals(paramAPMidasBaseRequest.sessionId)) && ("wc_actoken".equals(paramAPMidasBaseRequest.sessionType)))
      {
        localHashMap.put("c", "wechat_game");
        if (!TextUtils.isEmpty(paramAPMidasBaseRequest.saveValue)) {
          localHashMap.put("as", "1");
        }
        label388:
        paramAPMidasBaseRequest = APMidasPayAPI.env;
        if (!"dev".equals(paramAPMidasBaseRequest)) {
          break label764;
        }
        localHashMap.put("sandbox", "2");
      }
    }
    for (;;)
    {
      paramAPMidasBaseRequest = map2UrlParams(localHashMap);
      AppMethodBeat.o(192847);
      return paramAPMidasBaseRequest;
      if ("itopid".equals(paramAPMidasBaseRequest.sessionId))
      {
        localHashMap.put("c", "itop_game");
        break;
      }
      localHashMap.put("c", "game");
      break;
      if ((paramAPMidasBaseRequest instanceof APMidasGoodsRequest))
      {
        paramAPMidasBaseRequest = (APMidasGoodsRequest)paramAPMidasBaseRequest;
        localHashMap.put("c", "goods");
        if (paramAPMidasBaseRequest.tokenType == 1)
        {
          localHashMap.put("params", paramAPMidasBaseRequest.goodsTokenUrl);
          break label388;
        }
        localHashMap.put("productid", paramAPMidasBaseRequest.prodcutId);
        break label388;
      }
      if ((paramAPMidasBaseRequest instanceof APMidasSubscribeRequest))
      {
        localObject = (APMidasSubscribeRequest)paramAPMidasBaseRequest;
        if (("uin".equals(paramAPMidasBaseRequest.sessionId)) || ("openid".equals(paramAPMidasBaseRequest.sessionId))) {
          localHashMap.put("c", "qqsubscribe");
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(((APMidasSubscribeRequest)localObject).productId))
          {
            localHashMap.put("as", "1");
            localHashMap.put("productid", ((APMidasSubscribeRequest)localObject).productId);
          }
          localHashMap.put("service", ((APMidasSubscribeRequest)localObject).serviceCode);
          localHashMap.put("aid", ((APMidasSubscribeRequest)localObject).remark);
          if (!((APMidasSubscribeRequest)localObject).autoPay) {
            break;
          }
          localHashMap.put("ap", "1");
          break;
          localHashMap.put("c", "subscribe");
        }
      }
      if (!(paramAPMidasBaseRequest instanceof APMidasMonthRequest)) {
        break label388;
      }
      localObject = (APMidasMonthRequest)paramAPMidasBaseRequest;
      localHashMap.put("da", "1");
      localHashMap.put("c", ((APMidasMonthRequest)localObject).serviceCode.toLowerCase());
      localHashMap.put("_newservice", "1");
      if (((APMidasMonthRequest)localObject).autoPay) {
        localHashMap.put("ap", "1");
      }
      if (!TextUtils.isEmpty(paramAPMidasBaseRequest.saveValue)) {
        localHashMap.put("as", "1");
      }
      localHashMap.put("aid", ((APMidasMonthRequest)localObject).remark);
      break label388;
      label764:
      if ("test".equals(paramAPMidasBaseRequest)) {
        localHashMap.put("sandbox", "1");
      }
    }
  }
  
  private void initUI()
  {
    AppMethodBeat.i(192853);
    this.webPage.initUI(this);
    this.webPage.loadUrl(constructUrl());
    AppMethodBeat.o(192853);
  }
  
  private void initWebPage()
  {
    AppMethodBeat.i(192852);
    APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), "sdk.plugin.webpage.init", "", "");
    if (APX5.isX5Enabled(this))
    {
      this.webPage = new APX5WebPage();
      APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), "sdk.plugin.webpage.x5", "", "");
      AppMethodBeat.o(192852);
      return;
    }
    this.webPage = new APSystemWebPage();
    APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), "sdk.plugin.webpage.system", "", "");
    AppMethodBeat.o(192852);
  }
  
  public static String map2UrlParams(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(192848);
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHashMap.next();
        localStringBuffer.append((String)localEntry.getKey());
        localStringBuffer.append("=");
        localStringBuffer.append((String)localEntry.getValue());
        localStringBuffer.append("&");
        continue;
        paramHashMap = localStringBuffer.toString();
      }
    }
    catch (Exception paramHashMap) {}
    for (;;)
    {
      AppMethodBeat.o(192848);
      return paramHashMap;
      if (!TextUtils.isEmpty(localStringBuffer)) {
        localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      }
    }
  }
  
  private static boolean startPureH5Pay(Context paramContext, APMidasBaseRequest paramAPMidasBaseRequest)
  {
    AppMethodBeat.i(192851);
    if (paramContext == null)
    {
      APLog.e("APWebJSBridgeActivity", "Cannot start pure h5 pay with null context!");
      AppMethodBeat.o(192851);
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, APWebJSBridgeActivity.class);
    localIntent.putExtra("key_pure_h5_pay", "value_pure_h5_pay");
    localIntent.putExtra("key_request", paramAPMidasBaseRequest);
    paramAPMidasBaseRequest = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramAPMidasBaseRequest.axQ(), "com/tencent/midas/jsbridge/APWebJSBridgeActivity", "startPureH5Pay", "(Landroid/content/Context;Lcom/tencent/midas/api/request/APMidasBaseRequest;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramAPMidasBaseRequest.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/midas/jsbridge/APWebJSBridgeActivity", "startPureH5Pay", "(Landroid/content/Context;Lcom/tencent/midas/api/request/APMidasBaseRequest;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(192851);
    return true;
  }
  
  public static boolean startPureH5Pay(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(192850);
    APLog.d("APWebJSBridgeActivity", " Calling into startPureH5Pay caller = " + java.lang.Thread.currentThread().getStackTrace()[3].toString());
    APPluginReportManager.getInstance().reportImmediatelyOneRecord("launchpay", "sdk.plugin.pureH5.error.reason", "scene=" + paramString2 + "&reason=" + paramString1);
    if (paramContext == null)
    {
      APLog.e("APWebJSBridgeActivity", "Cannot start pure h5 pay with null context!");
      AppMethodBeat.o(192850);
      return false;
    }
    paramContext = APMidasPayHelper.requestObject;
    if (paramContext == null)
    {
      APLog.e("APWebJSBridgeActivity", "Cannot start pure h5 pay with null request object!");
      AppMethodBeat.o(192850);
      return false;
    }
    paramString1 = APMidasPayHelper.staticActivityContext;
    if (paramString1 == null)
    {
      APLog.e("APWebJSBridgeActivity", "Cannot start pure h5 pay with null activity object!");
      AppMethodBeat.o(192850);
      return false;
    }
    APMidasPayHelper.staticActivityContext = null;
    boolean bool = startPureH5Pay(paramString1, paramContext);
    AppMethodBeat.o(192850);
    return bool;
  }
  
  private void toPureH5Pay(APMidasBaseRequest paramAPMidasBaseRequest)
  {
    AppMethodBeat.i(192849);
    this.webPage.toPureH5Pay(this, paramAPMidasBaseRequest);
    paramAPMidasBaseRequest = "https://pay.qq.com/h5/index.shtml?" + getPureH5PayURLParameters(paramAPMidasBaseRequest);
    APLog.d("APWebJSBridgeActivity", "To pure h5 pay full url = ".concat(String.valueOf(paramAPMidasBaseRequest)));
    this.webPage.loadUrl(paramAPMidasBaseRequest);
    AppMethodBeat.o(192849);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(192846);
    super.onCreate(paramBundle);
    try
    {
      APMidasCommMethod.pushActivity(this);
      initWebPage();
      paramBundle = getIntent();
      if ((paramBundle != null) && ("value_pure_h5_pay".equals(paramBundle.getStringExtra("key_pure_h5_pay"))))
      {
        toPureH5Pay((APMidasBaseRequest)paramBundle.getSerializableExtra("key_request"));
        AppMethodBeat.o(192846);
        return;
      }
      initUI();
      AppMethodBeat.o(192846);
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle = APPluginUtils.getFullExceptionStacktrace(paramBundle);
      if ((!TextUtils.isEmpty(paramBundle)) && ((paramBundle.contains("webview")) || (paramBundle.contains("Webview")))) {
        Toast.makeText(this, "系统组件缺失，请退出重试", 0).show();
      }
      APPluginUtils.callbackInMidasPluginWithoutCaringAboutNewProcess(this, 100, "返回");
      finish();
      AppMethodBeat.o(192846);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(192857);
    if (paramInt == 4)
    {
      APLog.d("APWebJSBridgeActivity", "onKey down = back!");
      APMidasResponse localAPMidasResponse = new APMidasResponse();
      localAPMidasResponse.resultCode = 100;
      localAPMidasResponse.resultMsg = "返回";
      APMidasPayHelper.midasCallBack(localAPMidasResponse);
      finish();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(192857);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(192854);
    super.onResume();
    AppMethodBeat.o(192854);
  }
  
  protected void onStart()
  {
    AppMethodBeat.i(192855);
    super.onStart();
    AppMethodBeat.o(192855);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.midas.jsbridge.APWebJSBridgeActivity
 * JD-Core Version:    0.7.0.1
 */