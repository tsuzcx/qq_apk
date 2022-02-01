package midas.x;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.Toast;
import com.pay.api.APAndroidPayAPI;
import com.pay.api.APPayResponse;
import com.pay.api.IAPNetCallBack;
import com.pay.api.IAPPayCallBack;
import com.pay.api.MidasAbilityResponse;
import com.pay.api.ability.MidasActivityAbility;
import com.pay.api.ability.MidasActivityAbility.AbsQQShare;
import com.pay.api.ability.MidasActivityAbility.AbsWXShare;
import com.pay.api.ability.MidasBaseAbility;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APExtendInfo;
import com.pay.api.request.APBaseRequest.APMPInfo;
import com.pay.api.request.APGameRequest;
import com.pay.api.request.APGoodsRequest;
import com.pay.api.request.APNetRequest;
import com.pay.api.request.APSubscribeRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.paychannel.qqwallet.APQQShareActivity;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.common.APAlertDialog;
import com.pay.ui.common.APAlertDialog.f;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.marketing.APWebMarketActivity;
import com.pay.ui.marketing.APX5WebMarketActivity;
import com.pay.ui.payWeb.jsbridge.APWebJSBridgeActivity;
import com.pay.ui.payWeb.jsbridge.APX5WebJSBridgeActivity;
import com.tencent.midas.api.request.APIabResult;
import com.tencent.midas.api.request.APInventory;
import com.tencent.midas.api.request.APPurchase;
import com.tencent.midas.api.request.APQueryInventoryFinishedListener;
import com.tencent.midas.api.request.OnAPConsumeFinishedListener;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  public static final String r = "a";
  public static volatile a s;
  public IAPPayCallBack a;
  public IAPNetCallBack b;
  public WeakReference<Activity> c;
  public Context d = null;
  public APPayResponse e = null;
  public boolean f = false;
  public o4 g = null;
  public boolean h = false;
  public int i = 0;
  public boolean j = true;
  public boolean k = false;
  public String l;
  public String m = "0";
  public String n = "";
  public ResultReceiver o;
  public String p;
  public String q;
  
  public static void a(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 0))
    {
      APAppDataInterface.singleton().c(-1);
      return;
    }
    APAppDataInterface.singleton().c(paramInt);
  }
  
  public static void a(String paramString, Context paramContext)
  {
    paramContext = new APAlertDialog.f(paramContext);
    paramContext.b("提示");
    paramContext.a(paramString);
    paramContext.b("确定", new b());
    paramContext.b(new c());
    try
    {
      paramContext.b();
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static void a(boolean paramBoolean) {}
  
  public static void c(Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    if (paramContext == null)
    {
      APLog.e(r, "Cannot load key from disk with null context!");
      return;
    }
    if (paramAPBaseRequest == null)
    {
      APLog.e(r, "Cannot load key from disk with null request!");
      return;
    }
    if (TextUtils.isEmpty(paramAPBaseRequest.openId))
    {
      APLog.e(r, "Cannot load key from disk without open id!");
      return;
    }
    paramAPBaseRequest = paramAPBaseRequest.openId;
    paramContext = paramContext.getApplicationContext();
    String str = p4.p().c();
    z1.d().a(paramContext, paramAPBaseRequest, str, "1.7.9a");
  }
  
  public static void c(String paramString)
  {
    APAppDataInterface.singleton().b(paramString);
  }
  
  public static void d(String paramString)
  {
    APAppDataInterface.singleton().setEnv(paramString);
    a2.a(paramString);
  }
  
  public static void e(String paramString)
  {
    APAppDataInterface.singleton().k(paramString);
  }
  
  public static boolean q()
  {
    Object localObject = p4.p().e();
    if (localObject != null)
    {
      localObject = ((o4)localObject).b;
      if ((localObject instanceof APGoodsRequest))
      {
        localObject = ((APGoodsRequest)localObject).goodsTokenUrl;
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("midastype=present"))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static a r()
  {
    if (s == null) {
      try
      {
        if (s == null)
        {
          s = new a();
          s.i = 0;
          s.j = true;
        }
      }
      finally {}
    }
    return s;
  }
  
  public Context a()
  {
    return this.d;
  }
  
  public final String a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getPackageInfo(paramString, 64);
      if (paramContext == null) {
        return null;
      }
      paramContext = paramContext.signatures;
      if (paramContext != null)
      {
        if (paramContext.length == 0) {
          return null;
        }
        if (paramContext.length > 0) {
          return g.b(paramContext[0].toByteArray());
        }
      }
      return null;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  public final String a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      paramBundle = "";
    } else {
      paramBundle = paramBundle.getString("wxMiniProgramPath");
    }
    if (TextUtils.isEmpty(paramBundle)) {
      return "__midas_none_loopback";
    }
    paramBundle = APTools.n(paramBundle);
    if (paramBundle != null)
    {
      if (!paramBundle.containsKey("__midasLoopback")) {
        return "__midas_none_loopback";
      }
      String str = (String)paramBundle.get("__midasLoopback");
      paramBundle = str;
      if (TextUtils.isEmpty(str)) {
        paramBundle = "__midas_empty_loopback";
      }
      return paramBundle;
    }
    return "__midas_none_loopback";
  }
  
  public final String a(String paramString)
  {
    paramString = APTools.i(paramString);
    if ((paramString != null) && (paramString.containsKey("__midasLoopback")))
    {
      String str = (String)paramString.get("__midasLoopback");
      paramString = str;
      if (TextUtils.isEmpty(str)) {
        paramString = "__midas_empty_loopback";
      }
      return paramString;
    }
    return "__midas_none_loopback";
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("launchWXMiniProgram_OnResponse() resultCode = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", resultData=");
    ((StringBuilder)localObject).append(paramBundle);
    APLog.d("APAndroidPay", ((StringBuilder)localObject).toString());
    if (paramBundle == null) {
      localObject = "";
    } else {
      localObject = paramBundle.getString("extMsg");
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.q = a((String)localObject);
    } else {
      this.q = "__midas_none_loopback";
    }
    if (this.o == null)
    {
      APLog.w("APAndroidPay", "launchWXMiniProgram_OnResponse miniProgramResultReceiver == Null");
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("launchWXMiniProgram_OnResponse reqLoopback=");
    ((StringBuilder)localObject).append(this.p);
    ((StringBuilder)localObject).append(", respLoopback=");
    ((StringBuilder)localObject).append(this.q);
    APLog.w("APAndroidPay", ((StringBuilder)localObject).toString());
    if ((!TextUtils.isEmpty(this.p)) && (!TextUtils.isEmpty(this.q)) && (this.p.equals(this.q)))
    {
      this.o.send(paramInt, paramBundle);
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("launchWXMiniProgram_OnResponse failure: reqLoopback=");
    paramBundle.append(this.p);
    paramBundle.append(", respLoopback=");
    paramBundle.append(this.q);
    APLog.w("APAndroidPay", paramBundle.toString());
  }
  
  public final void a(Activity paramActivity)
  {
    if (!t5.a(paramActivity))
    {
      z5.a(2, "抱歉，你未安装微信客户端");
      return;
    }
    try
    {
      t5.a(paramActivity, new g(new Handler()));
      return;
    }
    catch (Exception localException)
    {
      label35:
      break label35;
    }
    APUICommonMethod.f();
    Toast.makeText(paramActivity, "未知错误", 0).show();
  }
  
  public void a(Activity paramActivity, APBaseRequest paramAPBaseRequest)
  {
    a(paramActivity, paramAPBaseRequest, null);
  }
  
  public void a(Activity paramActivity, APBaseRequest paramAPBaseRequest, ResultReceiver paramResultReceiver)
  {
    a(paramActivity, paramAPBaseRequest, null);
    r1.d().a(paramAPBaseRequest);
    if (r1.g())
    {
      t1.b().a(paramActivity, paramAPBaseRequest, paramResultReceiver);
      return;
    }
    if (paramResultReceiver != null)
    {
      paramActivity = new Bundle();
      paramActivity.putInt("code", 0);
      paramActivity.putString("msg", "");
      paramResultReceiver.send(0, paramActivity);
    }
  }
  
  public void a(Activity paramActivity, APBaseRequest paramAPBaseRequest, IAPPayCallBack paramIAPPayCallBack)
  {
    if (paramIAPPayCallBack != null) {
      this.a = paramIAPPayCallBack;
    }
    APUICommonMethod.h();
    c6.r0();
    com.pay.ui.recoChannel.APRecoChannelActivity.h = false;
    o4 localo4 = new o4(paramAPBaseRequest);
    p4.p().a(localo4);
    this.g = localo4;
    r().d = paramActivity.getApplicationContext();
    if (v0.g()) {
      c6.s0().e(true);
    } else {
      c6.s0().e(false);
    }
    a(paramActivity, paramAPBaseRequest);
    c(paramActivity, paramAPBaseRequest);
    k();
    APDataReportManager.getInstance().insertData("sdk.launchpay.enter", paramAPBaseRequest.saveType, paramAPBaseRequest.openId, APAppDataInterface.singleton().C(), paramAPBaseRequest.getReportInfo());
    if (!a(paramAPBaseRequest))
    {
      z5.a(3, paramActivity.getString(2131230774));
      return;
    }
    b(paramAPBaseRequest);
    c6.s0().I(APTools.j());
    s.f = false;
    if ((TextUtils.isEmpty(paramAPBaseRequest.mpInfo.payChannel)) && (!TextUtils.isEmpty(paramAPBaseRequest.mpInfo.discountType)) && (!TextUtils.isEmpty(paramAPBaseRequest.mpInfo.discountUrl))) {
      if (("hy_gameid".equals(paramAPBaseRequest.sessionId)) && ("wc_actoken".equals(paramAPBaseRequest.sessionType))) {
        paramAPBaseRequest.mpInfo.payChannel = "wechat";
      } else if (("openid".equals(paramAPBaseRequest.sessionId)) && ("kp_actoken".equals(paramAPBaseRequest.sessionType))) {
        paramAPBaseRequest.mpInfo.payChannel = "bank";
      }
    }
    f(paramAPBaseRequest);
    if (h1.v().a(paramActivity))
    {
      if (!h1.v().c())
      {
        h1.v().b(paramActivity);
        return;
      }
      h1.v().a(paramActivity, paramAPBaseRequest, paramIAPPayCallBack);
      return;
    }
    APLog.i("APAndroidPayAPI pay request = ", paramAPBaseRequest.toString());
    APLog.i("APAndroidPayAPI pay request reserv = ", paramAPBaseRequest.reserv);
    c6.s0().m(false);
    c6.s0().h("");
    if ((paramAPBaseRequest instanceof APGoodsRequest))
    {
      paramIAPPayCallBack = (APGoodsRequest)paramAPBaseRequest;
      if (paramIAPPayCallBack.mIsReceiptMode)
      {
        c6.s0().m(true);
        c6.s0().h(paramIAPPayCallBack.developerPayload);
      }
      else
      {
        c6.s0().m(false);
        c6.s0().h("");
      }
    }
    c6.s0().d(paramAPBaseRequest.reserv);
    u1.c().a(paramActivity, paramAPBaseRequest);
    if (e(paramAPBaseRequest))
    {
      c6.s0().c(true);
      n();
      return;
    }
    if (z5.c(paramAPBaseRequest))
    {
      d(paramAPBaseRequest);
      return;
    }
    if (z5.b(paramAPBaseRequest))
    {
      a(paramActivity);
      return;
    }
    if (z5.a(paramAPBaseRequest))
    {
      c6.s0().c(true);
      paramAPBaseRequest = new Intent();
      paramIAPPayCallBack = new Bundle();
      paramIAPPayCallBack.putString("pageName", y7.w);
      paramAPBaseRequest.putExtras(paramIAPPayCallBack);
      if (h8.d(paramActivity.getApplicationContext())) {
        paramAPBaseRequest.setClass(paramActivity, APX5WebJSBridgeActivity.class);
      } else {
        paramAPBaseRequest.setClass(paramActivity, APWebJSBridgeActivity.class);
      }
      paramActivity.startActivity(paramAPBaseRequest);
      return;
    }
    e5.h().a(paramActivity, paramAPBaseRequest);
  }
  
  public void a(Activity paramActivity, APNetRequest paramAPNetRequest, final IAPNetCallBack paramIAPNetCallBack)
  {
    o4 localo4 = new o4(paramAPNetRequest);
    p4.p().a(localo4);
    this.g = localo4;
    c6.r0();
    c6.s0().d(paramAPNetRequest.reserv);
    a(paramActivity, paramAPNetRequest);
    c(paramActivity, paramAPNetRequest);
    k();
    if (paramAPNetRequest.reqType.equals(APNetRequest.NET_REQ_MP))
    {
      a(paramAPNetRequest.openId, paramAPNetRequest.openKey, paramAPNetRequest.sessionId, paramAPNetRequest.sessionType, paramAPNetRequest.zoneId, paramAPNetRequest.pf, paramAPNetRequest.pfKey, paramAPNetRequest.reqType, paramAPNetRequest.mpInfo.drmInfo, paramAPNetRequest.reserv, new m(paramIAPNetCallBack));
      return;
    }
    if (paramAPNetRequest.reqType.equals(APNetRequest.NET_REQ_QQ))
    {
      try
      {
        f(paramAPNetRequest);
        a(paramAPNetRequest.offerId, paramAPNetRequest.openId);
      }
      catch (Exception paramActivity)
      {
        APLog.e("APAndroidPay net NET_REQ_QQ", paramActivity.toString());
      }
      new b().a(paramAPNetRequest, paramIAPNetCallBack);
      return;
    }
    paramIAPNetCallBack.MidasNetError(APNetRequest.NET_REQ_MP, -1, "APMidasNetRequest param<reqType> error");
  }
  
  public void a(Activity paramActivity, String paramString, APBaseRequest paramAPBaseRequest, final IAPNetCallBack paramIAPNetCallBack)
  {
    this.b = paramIAPNetCallBack;
    this.l = paramString;
    o4 localo4 = new o4(paramAPBaseRequest);
    p4.p().a(localo4);
    this.g = localo4;
    c6.r0();
    c6.s0().d(paramAPBaseRequest.reserv);
    a(paramActivity, paramAPBaseRequest);
    c(paramActivity, paramAPBaseRequest);
    APLog.i("APAndroidPay info reqType", paramString);
    if (paramString.equals(APNetRequest.NET_REQ_MP))
    {
      a(paramAPBaseRequest.openId, paramAPBaseRequest.openKey, paramAPBaseRequest.sessionId, paramAPBaseRequest.sessionType, paramAPBaseRequest.zoneId, paramAPBaseRequest.pf, paramAPBaseRequest.pfKey, paramString, paramAPBaseRequest.mpInfo.drmInfo, paramAPBaseRequest.reserv, new a(paramIAPNetCallBack));
      return;
    }
    if (paramString.equals(APNetRequest.NET_REQ_FRIENDSPAY))
    {
      try
      {
        f(paramAPBaseRequest);
        a(paramAPBaseRequest.offerId, paramAPBaseRequest.openId);
      }
      catch (Exception paramActivity)
      {
        APLog.e("APAndroidPay net NET_REQ_QQ", paramActivity.toString());
      }
      c(paramAPBaseRequest);
      b(paramAPBaseRequest);
      new b().a(this.b);
      return;
    }
    paramIAPNetCallBack.MidasNetError(APNetRequest.NET_REQ_MP, -1, "APMidasNetRequest param<reqType> error");
  }
  
  public void a(Activity paramActivity, JSONObject paramJSONObject)
  {
    r().d = paramActivity.getApplicationContext();
    s.f = false;
    c6.s0().c(true);
    a(paramActivity, null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("jsonObj:");
    localStringBuilder.append(paramJSONObject.toString());
    APLog.i("launchSign", localStringBuilder.toString());
    try
    {
      boolean bool = paramJSONObject.optString("wxSignVersion", "").toLowerCase().equals("v2");
      if ((bool) && (!TextUtils.isEmpty(paramJSONObject.optString("wxPreEntrustWebId"))))
      {
        APDataReportManager.getInstance().insertData("sdk.h5.wechat.sign", -1, "", "sign", "");
        new t5(paramActivity, paramJSONObject.optString("appId")).a(paramJSONObject.optString("appId"), paramJSONObject.optString("wxSignVersion"), paramJSONObject.optString("wxPreEntrustWebId"), "");
        return;
      }
      if ((paramJSONObject.has("wxSignUrl")) && (!TextUtils.isEmpty(paramJSONObject.optString("wxSignUrl"))))
      {
        APDataReportManager.getInstance().insertData("sdk.h5.wechat.sign", -1, "", "sign", "");
        new t5(paramActivity, paramJSONObject.optString("appId")).a(paramJSONObject.optString("appId"), paramJSONObject.optString("wxSignVersion"), "", APTools.a(paramJSONObject.optString("wxSignUrl"), 1));
        return;
      }
      if ((paramJSONObject.has("qqwalletSignUrl")) && (!TextUtils.isEmpty(paramJSONObject.optString("qqwalletSignUrl"))))
      {
        q5.a(paramActivity, paramJSONObject.optString("qqwalletSignUrl"));
        return;
      }
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public void a(Activity paramActivity, JSONObject paramJSONObject, final IAPPayCallBack paramIAPPayCallBack)
  {
    if (paramIAPPayCallBack != null) {
      this.a = paramIAPPayCallBack;
    }
    if (!t5.a(paramActivity))
    {
      z5.a(-2, "抱歉，你未安装微信客户端");
      return;
    }
    r().d = paramActivity.getApplicationContext();
    s.f = false;
    c6.s0().c(true);
    a(paramActivity, null);
    try
    {
      new t5(paramActivity, paramJSONObject.optString("appId")).a(paramJSONObject.optString("businessType"), paramJSONObject.optString("query"), paramJSONObject.optString("extInfo"), new i(new Handler(), paramIAPPayCallBack));
      return;
    }
    catch (Exception paramJSONObject)
    {
      label112:
      break label112;
    }
    APUICommonMethod.f();
    Toast.makeText(paramActivity, "未知错误", 0).show();
  }
  
  public void a(Context paramContext)
  {
    Object localObject = paramContext.getApplicationContext();
    int i1 = 0;
    localObject = ((Context)localObject).getDir("midasplugins", 0).listFiles();
    if (localObject != null)
    {
      int i2 = localObject.length;
      for (;;)
      {
        if ((i2 > 0) && (i1 < i2)) {
          try
          {
            if (localObject[i1].getName().startsWith("MidasCore"))
            {
              String str = new v0(paramContext).b(localObject[i1]);
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("resultData=版本号");
              localStringBuilder.append(str);
              APLog.i("APbuypage", localStringBuilder.toString());
              c6.s0().g(str);
            }
            i1 += 1;
          }
          catch (Exception paramContext)
          {
            paramContext.printStackTrace();
          }
        }
      }
    }
  }
  
  public void a(Context paramContext, Bundle paramBundle, final ResultReceiver paramResultReceiver)
  {
    this.p = a(paramBundle);
    this.o = paramResultReceiver;
    String str1 = paramBundle.getString("wxAppId");
    String str2 = paramBundle.getString("wxMiniProgramId");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      new t5(paramContext, str1).a(paramBundle, new j(new Handler(), paramResultReceiver));
      return;
    }
    APLog.e("APAndroidPay", "wx_appId or wx_userName is empty");
    paramContext = new Bundle();
    paramContext.putString("resultMsg", "wx_appId or wx_userName is empty");
    paramResultReceiver.send(-1, paramContext);
  }
  
  public final void a(final Context paramContext, final MidasActivityAbility paramMidasActivityAbility)
  {
    z1.d().a(paramMidasActivityAbility, new k(paramContext, paramMidasActivityAbility));
  }
  
  public final void a(Context paramContext, final MidasActivityAbility paramMidasActivityAbility, b2 paramb2, Bundle paramBundle)
  {
    Object localObject1;
    if ("present".equals(paramMidasActivityAbility.action))
    {
      localObject1 = new APGoodsRequest();
      ((APBaseRequest)localObject1).offerId = paramMidasActivityAbility.offerId;
      ((APBaseRequest)localObject1).openId = paramMidasActivityAbility.openId;
      ((APBaseRequest)localObject1).openKey = paramMidasActivityAbility.openKey;
      ((APBaseRequest)localObject1).sessionId = paramMidasActivityAbility.sessionId;
      ((APBaseRequest)localObject1).sessionType = paramMidasActivityAbility.sessionType;
      ((APBaseRequest)localObject1).zoneId = paramMidasActivityAbility.zoneId;
      ((APBaseRequest)localObject1).pf = paramMidasActivityAbility.pf;
      ((APBaseRequest)localObject1).pfKey = paramMidasActivityAbility.pfKey;
      ((APBaseRequest)localObject1).saveValue = "1";
      ((APBaseRequest)localObject1).isCanChange = false;
      ((APBaseRequest)localObject1).acctType = paramMidasActivityAbility.acctType;
      ((APGoodsRequest)localObject1).tokenType = 1;
      if (TextUtils.isEmpty(paramMidasActivityAbility.reserv))
      {
        paramBundle = paramMidasActivityAbility.others;
      }
      else
      {
        paramBundle = new StringBuilder();
        paramBundle.append(paramMidasActivityAbility.others);
        paramBundle.append("&req_reserv=");
        paramBundle.append(APTools.b(paramMidasActivityAbility.reserv, 1));
        paramBundle = paramBundle.toString();
      }
      ((APBaseRequest)localObject1).reserv = paramBundle;
      ((APBaseRequest)localObject1).mpInfo.payChannel = paramMidasActivityAbility.mpInfo.payChannel;
      paramBundle = ((APBaseRequest)localObject1).extendInfo;
      Object localObject2 = paramMidasActivityAbility.extendInfo;
      paramBundle.isShowNum = ((APBaseRequest.APExtendInfo)localObject2).isShowNum;
      paramBundle.isShowListOtherNum = ((APBaseRequest.APExtendInfo)localObject2).isShowListOtherNum;
      ((APBaseRequest)localObject1).remark = paramMidasActivityAbility.remark;
      paramBundle = String.format("/v1/r/%s/mobile_goods_info", new Object[] { ((APBaseRequest)localObject1).offerId });
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramBundle);
      ((StringBuilder)localObject2).append("?midastype=present&token_id=");
      ((StringBuilder)localObject2).append(paramb2.h());
      ((APGoodsRequest)localObject1).goodsTokenUrl = ((StringBuilder)localObject2).toString();
      paramb2 = new StringBuilder();
      paramb2.append("goodsRequest = ");
      paramb2.append(((APGoodsRequest)localObject1).toString());
      APLog.d("APAndroidPay", paramb2.toString());
      if ((paramContext instanceof Activity)) {
        APAndroidPayAPI.launchPay((Activity)paramContext, (APBaseRequest)localObject1, new l(paramMidasActivityAbility));
      }
    }
    else
    {
      if (!"ask".equals(paramMidasActivityAbility.action)) {
        break label522;
      }
      localObject1 = paramMidasActivityAbility.shareInfo;
      if ((localObject1 instanceof MidasActivityAbility.AbsQQShare))
      {
        paramBundle.putString("qqMiniUrl", paramb2.l());
        paramBundle.putString("qqMiniPath", paramb2.k());
        paramBundle.putString("qqMiniId", paramb2.j());
        APQQShareActivity.a(paramContext, paramb2.i(), paramMidasActivityAbility, paramBundle);
        return;
      }
      if ((localObject1 instanceof MidasActivityAbility.AbsWXShare))
      {
        paramBundle.putString("wxMiniUrl", paramb2.p());
        paramBundle.putString("wxMiniPath", paramb2.o());
        paramBundle.putString("wxMiniOriId", paramb2.n());
        new t5(paramContext, paramb2.m()).a(paramContext, paramMidasActivityAbility, paramBundle);
      }
    }
    return;
    label522:
    paramContext = new StringBuilder();
    paramContext.append("Unsupported request.action : ");
    paramContext.append(paramMidasActivityAbility.action);
    MidasAbilityResponse.onFailureSDK(paramMidasActivityAbility, -4, paramContext.toString(), new Bundle());
  }
  
  public final void a(Context paramContext, MidasBaseAbility paramMidasBaseAbility)
  {
    Object localObject = new APGameRequest();
    ((APBaseRequest)localObject).offerId = paramMidasBaseAbility.offerId;
    ((APBaseRequest)localObject).openId = paramMidasBaseAbility.openId;
    ((APBaseRequest)localObject).openKey = paramMidasBaseAbility.openKey;
    ((APBaseRequest)localObject).sessionId = paramMidasBaseAbility.sessionId;
    ((APBaseRequest)localObject).sessionType = paramMidasBaseAbility.sessionType;
    ((APBaseRequest)localObject).pf = paramMidasBaseAbility.pf;
    ((APBaseRequest)localObject).pfKey = paramMidasBaseAbility.pfKey;
    ((APBaseRequest)localObject).zoneId = "1";
    a(paramContext, (APBaseRequest)localObject, null);
    k();
    b(paramContext, paramMidasBaseAbility);
    localObject = new o4((APBaseRequest)localObject);
    p4.p().a((o4)localObject);
    this.g = ((o4)localObject);
    localObject = c6.s0();
    ((c6)localObject).I(APTools.j());
    ((c6)localObject).d(paramMidasBaseAbility.others);
    s.f = false;
    r().d = paramContext.getApplicationContext();
  }
  
  public void a(Context paramContext, MidasBaseAbility paramMidasBaseAbility, ResultReceiver paramResultReceiver)
  {
    a(paramContext, paramMidasBaseAbility);
    MidasAbilityResponse.push(paramResultReceiver);
    APDataReportManager.getInstance().insertData("sdk.launchability.enter", 0, paramMidasBaseAbility.openId, APAppDataInterface.singleton().C(), paramMidasBaseAbility.toString());
    if ((paramMidasBaseAbility instanceof MidasActivityAbility))
    {
      a(paramContext, (MidasActivityAbility)paramMidasBaseAbility);
      return;
    }
    MidasAbilityResponse.onFailureSDK(paramMidasBaseAbility, -1, "不识别的Req", new Bundle());
  }
  
  public final void a(Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    if (this.i > 0) {
      return;
    }
    b6.a();
    APTools.w(paramContext);
    APTools.setKey(APTools.d);
    APTools.c(paramContext);
    if (s.c != null)
    {
      paramAPBaseRequest = APTools.a((Activity)s.c.get());
      APAppDataInterface.singleton().c(paramAPBaseRequest);
      APDataReportManager.getInstance().insertData("sdk.deviceinfo", -1, null, null, paramAPBaseRequest);
    }
    paramAPBaseRequest = APPluginUtils.getMidasCoreVersionName(paramContext);
    APAppDataInterface.singleton().j(paramAPBaseRequest);
    a(paramContext);
    paramAPBaseRequest = ((Activity)this.c.get()).getApplicationContext().getPackageName();
    if (!"com.tencent.unipay".equals(paramAPBaseRequest))
    {
      localObject = a(((Activity)this.c.get()).getApplicationContext(), paramAPBaseRequest);
      c6.s0().b(paramAPBaseRequest);
      c6.s0().c((String)localObject);
    }
    int i2 = "1.3.9e".compareToIgnoreCase(APAppDataInterface.singleton().r());
    int i1 = 0;
    boolean bool;
    if (i2 > 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramAPBaseRequest = new StringBuilder();
    paramAPBaseRequest.append("isNeedExtra:");
    paramAPBaseRequest.append(bool);
    paramAPBaseRequest.append(" initso:");
    paramAPBaseRequest.append(this.h);
    APLog.i("initOnce", paramAPBaseRequest.toString());
    if ((!this.h) && (bool))
    {
      paramAPBaseRequest = APPluginUtils.getInstallPathString(paramContext, "MidasPay");
      localObject = APPluginUtils.getLibPath(paramContext);
      if ((localObject != null) && (!TextUtils.isEmpty(paramAPBaseRequest))) {
        APTools.a(paramAPBaseRequest, ((File)localObject).getAbsolutePath());
      }
      this.h = true;
      APLog.i("initOnce", "init so done");
    }
    if (APTools.c(paramContext, "com.eg.android.AlipayGphone")) {
      APDataReportManager.getInstance().insertData("sdk.wsj.isInstall", -1, null, "1", null);
    } else {
      APDataReportManager.getInstance().insertData("sdk.wsj.isInstall", -1, null, "0", null);
    }
    paramAPBaseRequest = APTools.a(paramContext, "com.tencent.mobileqq");
    if (!TextUtils.isEmpty(paramAPBaseRequest))
    {
      APAppDataInterface.singleton().m(APTools.b(paramAPBaseRequest, 1));
      APAppDataInterface.singleton().e("1");
    }
    else
    {
      APAppDataInterface.singleton().m("");
      APAppDataInterface.singleton().e("0");
    }
    paramAPBaseRequest = APTools.a(paramContext, "com.tencent.mm");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("wechatversion：");
    ((StringBuilder)localObject).append(paramAPBaseRequest);
    APLog.i("APAndroidPay", ((StringBuilder)localObject).toString());
    if (!TextUtils.isEmpty(paramAPBaseRequest))
    {
      APAppDataInterface.singleton().p(paramAPBaseRequest);
      APAppDataInterface.singleton().f("1");
    }
    else
    {
      APAppDataInterface.singleton().p("");
      APAppDataInterface.singleton().f("0");
    }
    if (s5.a(paramContext)) {
      APAppDataInterface.singleton().g("1");
    } else {
      APAppDataInterface.singleton().g("0");
    }
    try
    {
      paramAPBaseRequest = paramContext.getApplicationContext().getPackageManager();
      paramAPBaseRequest = paramAPBaseRequest.getPackageInfo(paramAPBaseRequest.getPackageInfo(paramContext.getApplicationContext().getPackageName(), 0).packageName, 1).activities;
      while (i1 < paramAPBaseRequest.length)
      {
        if (paramAPBaseRequest[i1].name.equals("com.tencent.midas.qq.APMidasQQWalletActivity")) {
          q5.a(true);
        }
        i1 += 1;
      }
    }
    catch (Exception paramAPBaseRequest)
    {
      label563:
      break label563;
    }
    System.loadLibrary("unipayutils");
    APTools.a();
    if (this.i == 0) {
      this.i = i.b(new d6().a(paramContext, "TencentUnipay", "intCt"));
    }
    this.i += 1;
    new d6().a(paramContext.getApplicationContext(), "TencentUnipay", "intCt", String.valueOf(this.i));
  }
  
  public final void a(Context paramContext, APBaseRequest paramAPBaseRequest, ResultReceiver paramResultReceiver)
  {
    r().d = paramContext.getApplicationContext();
    APAppDataInterface.singleton().a(APTools.h(paramContext));
    if ((paramAPBaseRequest != null) && (p4.p().e() == null))
    {
      paramResultReceiver = new o4(paramAPBaseRequest);
      p4.p().a(paramResultReceiver);
      this.k = true;
    }
    if ((paramContext instanceof Activity)) {
      s.c = new WeakReference((Activity)paramContext);
    }
    APAppDataInterface.singleton().a(paramContext.getResources().getConfiguration().orientation);
    paramResultReceiver = k.d(paramContext.getApplicationContext()).a();
    APAppDataInterface.singleton().h(paramResultReceiver);
    b(paramContext, paramAPBaseRequest);
    int i1 = m6.a(r().d);
    APAppDataInterface.singleton().b(i1);
    a(paramContext.getApplicationContext(), paramAPBaseRequest);
    APAppDataInterface.singleton().n("");
    a2.b(paramContext.getApplicationContext());
    c(paramContext, paramAPBaseRequest);
    try
    {
      c6.s0().F(APTools.l(paramContext.getApplicationContext()));
      c6.s0().E(APTools.f(paramContext.getApplicationContext()));
      c6.s0().G(APTools.g());
      c6.s0().q(APTools.h());
      c6.s0().C(APTools.i());
    }
    catch (Exception paramResultReceiver)
    {
      paramResultReceiver.printStackTrace();
    }
    paramResultReceiver = new StringBuilder();
    paramResultReceiver.append(" plugin version");
    paramResultReceiver.append(APAppDataInterface.singleton().r());
    APLog.i("GlobalInitialize", paramResultReceiver.toString());
    if (paramAPBaseRequest != null) {
      try
      {
        a(paramAPBaseRequest.offerId, paramAPBaseRequest.openId);
      }
      catch (Exception paramResultReceiver)
      {
        paramResultReceiver.printStackTrace();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Init platform got exception = ");
        localStringBuilder.append(paramResultReceiver);
        APLog.e("initPlatform", localStringBuilder.toString());
      }
    }
    g();
    h8.b(paramContext.getApplicationContext());
    if ((paramAPBaseRequest != null) && (this.j)) {
      try
      {
        new b().d();
        this.j = false;
        return;
      }
      catch (Exception paramContext)
      {
        APLog.i("GlobalInitialize APGetNetInfo", paramContext.toString());
      }
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      v1.e().d();
      return;
    }
    v1.e().a();
  }
  
  public void a(APPayResponse paramAPPayResponse)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("payCallBack resultCode:");
    ((StringBuilder)localObject).append(paramAPPayResponse.resultCode);
    APLog.i("APAndroidPay", ((StringBuilder)localObject).toString());
    z1.d().a();
    APUICommonMethod.b();
    j9.b();
    try
    {
      APLog.i("getDeviceInfo:", APAppDataInterface.singleton().g());
      APDataReportManager.getInstance().insertData("sdk.deviceinfo", -1, null, null, APAppDataInterface.singleton().g());
      localObject = APDataReportManager.getInstance();
      String str1 = p4.p().e().b.openId;
      String str2 = APAppDataInterface.singleton().C();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(paramAPPayResponse.resultCode));
      localStringBuilder.append("-");
      localStringBuilder.append(String.valueOf(paramAPPayResponse.resultInerCode));
      ((APDataReportManager)localObject).insertData("sdk.callback.exit", 0, str1, str2, localStringBuilder.toString());
      paramAPPayResponse.extendInfo = String.valueOf(p4.p().e().b.saveType);
      paramAPPayResponse.payReserve1 = String.valueOf(p4.p().e().b.reserv);
      paramAPPayResponse.payReserve2 = String.valueOf(p4.p().e().b.pf);
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    try
    {
      new Handler().postDelayed(new q(null), 200L);
    }
    catch (Exception localException2)
    {
      APLog.i("paycallback report", localException2.toString());
    }
    IAPPayCallBack localIAPPayCallBack = this.a;
    if (localIAPPayCallBack != null)
    {
      localIAPPayCallBack.MidasPayCallBack(paramAPPayResponse);
      this.a = null;
    }
    try
    {
      r6.i();
    }
    catch (Exception paramAPPayResponse)
    {
      paramAPPayResponse.printStackTrace();
    }
    try
    {
      if ((r1.i()) && (!r1.h())) {
        u1.c().a();
      }
    }
    catch (Exception paramAPPayResponse)
    {
      paramAPPayResponse.printStackTrace();
    }
    com.pay.ui.recoChannel.APRecoChannelActivity.h = false;
    try
    {
      APUICommonMethod.h();
      APUICommonMethod.i();
      g6.j();
      this.g = null;
      k5.o();
      e5.g();
      p4.p().e().g();
      r6.i();
      com.pay.ui.recoChannel.APRecoChannelActivity.g = null;
      APTools.b = 0L;
      k6.b().a();
    }
    catch (Exception paramAPPayResponse)
    {
      paramAPPayResponse.printStackTrace();
    }
    try
    {
      new d6().a(this.d, "TencentUnipay", "launchpaycalling", "0");
      w0.b(this.d);
      return;
    }
    catch (Exception paramAPPayResponse)
    {
      paramAPPayResponse.printStackTrace();
    }
  }
  
  public final void a(APBaseRequest paramAPBaseRequest, HashMap<String, String> paramHashMap)
  {
    paramHashMap = (String)paramHashMap.get("midas_friendspayurl");
    if (TextUtils.isEmpty(paramHashMap)) {
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("midas_friendspayurl=");
    ((StringBuilder)localObject1).append(paramHashMap);
    paramHashMap = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramHashMap);
    ((StringBuilder)localObject1).append("&");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("&");
    ((StringBuilder)localObject2).append(paramHashMap);
    localObject2 = ((StringBuilder)localObject2).toString();
    if (paramAPBaseRequest.reserv.contains((CharSequence)localObject1))
    {
      paramAPBaseRequest.reserv = paramAPBaseRequest.reserv.replace((CharSequence)localObject1, "");
      return;
    }
    if (paramAPBaseRequest.reserv.contains((CharSequence)localObject2))
    {
      paramAPBaseRequest.reserv = paramAPBaseRequest.reserv.replace((CharSequence)localObject2, "");
      return;
    }
    paramAPBaseRequest.reserv = paramAPBaseRequest.reserv.replace(paramHashMap, "");
  }
  
  public final void a(String paramString1, String paramString2)
  {
    h();
    c6.s0().F(APTools.l((Context)s.c.get()));
    c6.s0().E(APTools.f((Context)s.c.get()));
    c6.s0().G(APTools.g());
    c6.s0().a(0);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, fc paramfc)
  {
    paramString1 = new l3(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString9, paramString10);
    paramString2 = new k3(paramString8, paramfc);
    z1.d().a(paramString1, paramString2);
  }
  
  public void a(List<APPurchase> paramList, final OnAPConsumeFinishedListener paramOnAPConsumeFinishedListener)
  {
    if (p4.p().e().b == null)
    {
      APDataReportManager.getInstance().insertData("sdk.result.receipt.consumreq", -1, null, "requestisnull", p4.p().e().b.toString());
      APLog.e("APAndroidPay", "consumeAsync enter request is null");
      return;
    }
    APDataReportManager.getInstance().insertData("sdk.result.receipt.consumreq", -1, null, "requestisnotnull", p4.p().e().b.toString());
    Object localObject1 = r;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("consumeAsync:");
    ((StringBuilder)localObject2).append(paramList.size());
    APLog.i((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = new JSONArray();
    int i1 = 0;
    while (i1 < paramList.size())
    {
      localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("data", ((APPurchase)paramList.get(i1)).getOriginalJson());
        ((JSONObject)localObject2).put("sign", ((APPurchase)paramList.get(i1)).getSignature());
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      ((JSONArray)localObject1).put(localObject2);
      i1 += 1;
    }
    z1.d().a(new f(paramOnAPConsumeFinishedListener), ((JSONArray)localObject1).toString());
  }
  
  public void a(fc paramfc)
  {
    z1.d().e(paramfc);
  }
  
  public void a(boolean paramBoolean, List<?> paramList, final APQueryInventoryFinishedListener paramAPQueryInventoryFinishedListener)
  {
    APLog.i(r, "queryInventoryAsync enter ");
    if (p4.p().e().b == null)
    {
      APDataReportManager.getInstance().insertData("sdk.result.receipt.queryreq", -1, null, "requestisnull", p4.p().e().b.toString());
      APLog.e("APAndroidPay", "queryInventoryAsync enter mAPBaseRequest is null");
      return;
    }
    APDataReportManager.getInstance().insertData("sdk.result.receipt.queryreq", -1, null, "requestisnotnull", p4.p().e().b.toString());
    z1.d().d(new e(paramAPQueryInventoryFinishedListener), "");
  }
  
  public final boolean a(APBaseRequest paramAPBaseRequest)
  {
    if (TextUtils.isEmpty(paramAPBaseRequest.offerId))
    {
      APUICommonMethod.a((Context)this.c.get(), ((Activity)this.c.get()).getString(2131230770));
      return false;
    }
    if (TextUtils.isEmpty(paramAPBaseRequest.openId))
    {
      APUICommonMethod.a((Context)this.c.get(), ((Activity)this.c.get()).getString(2131230771));
      return false;
    }
    if (TextUtils.isEmpty(paramAPBaseRequest.openKey))
    {
      APUICommonMethod.a((Context)this.c.get(), ((Activity)this.c.get()).getString(2131230772));
      return false;
    }
    if (TextUtils.isEmpty(paramAPBaseRequest.sessionId))
    {
      APUICommonMethod.a((Context)this.c.get(), ((Activity)this.c.get()).getString(2131230780));
      return false;
    }
    if (TextUtils.isEmpty(paramAPBaseRequest.sessionType))
    {
      APUICommonMethod.a((Context)this.c.get(), ((Activity)this.c.get()).getString(2131230781));
      return false;
    }
    if (TextUtils.isEmpty(paramAPBaseRequest.pf))
    {
      APUICommonMethod.a((Context)this.c.get(), ((Activity)this.c.get()).getString(2131230776));
      return false;
    }
    if (TextUtils.isEmpty(paramAPBaseRequest.pfKey))
    {
      APUICommonMethod.a((Context)this.c.get(), ((Activity)this.c.get()).getString(2131230777));
      return false;
    }
    return true;
  }
  
  public int b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("话费券回滚hfCouponsRollBack，strJson=");
    localStringBuilder.append(paramString);
    APLog.i("话费券回滚3", localStringBuilder.toString());
    APUICommonMethod.f();
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("card_list");
      if ((paramString != null) && (paramString.length() > 0) && (!"1".equals(paramString.getJSONObject(0).optString("is_succ")))) {
        z1.d().g(new d());
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    z5.a(p4.p().e().f.a(), 0, 0);
    return 1;
  }
  
  public void b(Activity paramActivity, APBaseRequest paramAPBaseRequest, IAPPayCallBack paramIAPPayCallBack)
  {
    if (paramIAPPayCallBack != null) {
      this.a = paramIAPPayCallBack;
    }
    paramIAPPayCallBack = new o4(paramAPBaseRequest);
    if (this.k) {
      p4.p().a(paramIAPPayCallBack);
    }
    r().d = paramActivity.getApplicationContext();
    a(paramActivity, paramAPBaseRequest);
    k();
    if (!a(paramAPBaseRequest))
    {
      z5.a(3, paramActivity.getString(2131230774));
      return;
    }
    s.f = false;
    c6.s0().c(true);
    paramAPBaseRequest = new Intent();
    if (h8.d(paramActivity)) {
      paramAPBaseRequest.setClass(paramActivity, APX5WebJSBridgeActivity.class);
    } else {
      paramAPBaseRequest.setClass(paramActivity, APWebJSBridgeActivity.class);
    }
    paramActivity.startActivity(paramAPBaseRequest);
  }
  
  public void b(Activity paramActivity, JSONObject paramJSONObject, IAPPayCallBack paramIAPPayCallBack)
  {
    if (paramIAPPayCallBack != null) {
      this.a = paramIAPPayCallBack;
    }
    if (!s5.a(paramActivity))
    {
      paramJSONObject = new APPayResponse();
      paramJSONObject.resultCode = -1;
      paramJSONObject.resultMsg = "抱歉，你未安装银联云闪付客户端";
      paramJSONObject.payChannel = 20;
      paramJSONObject.resultInerCode = -1;
      paramJSONObject.extendInfo = "launchUnionPay";
      paramIAPPayCallBack.MidasPayCallBack(paramJSONObject);
      APUICommonMethod.a(paramActivity, "抱歉，你未安装银联云闪付客户端");
      return;
    }
    r().d = paramActivity.getApplicationContext();
    s.f = false;
    c6.s0().c(true);
    String str2 = null;
    a(paramActivity, null);
    for (;;)
    {
      try
      {
        localObject = new APSubscribeRequest();
        if (paramJSONObject.has("offerId")) {
          ((APBaseRequest)localObject).offerId = paramJSONObject.optString("offerId");
        }
        if (paramJSONObject.has("openId")) {
          ((APBaseRequest)localObject).openId = paramJSONObject.optString("openId");
        }
        if (paramJSONObject.has("openKey")) {
          ((APBaseRequest)localObject).openKey = paramJSONObject.optString("openKey");
        }
        if (paramJSONObject.has("sessionId")) {
          ((APBaseRequest)localObject).sessionId = paramJSONObject.optString("sessionId");
        }
        if (paramJSONObject.has("sessiontType")) {
          ((APBaseRequest)localObject).sessionType = paramJSONObject.optString("sessiontType");
        }
        if (paramJSONObject.has("pf")) {
          ((APBaseRequest)localObject).pf = paramJSONObject.optString("pf");
        }
        if (paramJSONObject.has("pfKey")) {
          ((APBaseRequest)localObject).pfKey = paramJSONObject.optString("pfKey");
        }
        a(paramActivity, (APBaseRequest)localObject);
        if (p4.p().e() == null)
        {
          localObject = new o4((APBaseRequest)localObject);
          p4.p().a((o4)localObject);
        }
        if (paramJSONObject.has("spId"))
        {
          localObject = paramJSONObject.optString("spId");
          if (!paramJSONObject.has("sysProvider")) {
            break label486;
          }
          str1 = paramJSONObject.optString("sysProvider");
          if (paramJSONObject.has("orderInfo")) {
            str2 = paramJSONObject.optString("orderInfo");
          }
          String str3 = "00";
          if (!"release".equals(APAppDataInterface.singleton().h())) {
            str3 = "01";
          }
          if (s5.a(paramActivity, (String)localObject, str1, str2, str3) == -1)
          {
            paramActivity = new APPayResponse();
            paramActivity.resultCode = -1;
            paramActivity.resultMsg = "抱歉，启动银联云闪付客户端失败";
            paramActivity.payChannel = 20;
            paramActivity.resultInerCode = -2;
            paramActivity.extendInfo = "launchUnionPay";
            paramIAPPayCallBack.MidasPayCallBack(paramActivity);
            return;
          }
          APDataReportManager.getInstance().insertData("sdk.h5.union.pay", -1, "", "pay", paramJSONObject.optString("tokenId"));
          return;
        }
      }
      catch (Exception paramActivity)
      {
        paramActivity.printStackTrace();
        return;
      }
      Object localObject = null;
      continue;
      label486:
      String str1 = null;
    }
  }
  
  public final void b(Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    m();
    if (paramAPBaseRequest == null) {
      return;
    }
    String str = paramAPBaseRequest.reserv;
    if ((paramAPBaseRequest instanceof MidasBaseAbility)) {
      str = ((MidasBaseAbility)paramAPBaseRequest).configs;
    }
    try
    {
      c6.s0().M("");
      if ((paramAPBaseRequest != null) && (!TextUtils.isEmpty(str)))
      {
        Object localObject1 = APTools.n(str);
        if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)((HashMap)localObject1).get("wechatSignVersion"))))
        {
          localObject1 = (String)((HashMap)localObject1).get("wechatSignVersion");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("wechat sign version: ");
          localStringBuilder.append((String)localObject1);
          APLog.i("APAndroidPay", localStringBuilder.toString());
          c6.s0().M((String)localObject1);
        }
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    try
    {
      APAppDataInterface.singleton().c(false);
      if ((paramAPBaseRequest != null) && (!TextUtils.isEmpty(str)))
      {
        HashMap localHashMap = APTools.n(str);
        if ((localHashMap != null) && (!TextUtils.isEmpty((CharSequence)localHashMap.get("midas_http_type"))) && ("1".equals((String)localHashMap.get("midas_http_type")))) {
          APAppDataInterface.singleton().c(true);
        }
      }
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    try
    {
      APAppDataInterface.singleton().g(true);
      if ((paramAPBaseRequest != null) && (!TextUtils.isEmpty(str)))
      {
        Object localObject2 = APTools.n(str);
        if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)((HashMap)localObject2).get("midas_encrypt_type"))))
        {
          localObject2 = (String)((HashMap)localObject2).get("midas_encrypt_type");
          APAppDataInterface.singleton().g("1".equals(localObject2));
        }
      }
    }
    catch (Exception localException3)
    {
      localException3.printStackTrace();
    }
    if (paramAPBaseRequest != null) {
      try
      {
        if (!TextUtils.isEmpty(str))
        {
          paramAPBaseRequest = APTools.n(str);
          if (paramAPBaseRequest != null)
          {
            str = (String)paramAPBaseRequest.get("enableX5");
            if (!TextUtils.isEmpty(str))
            {
              boolean bool = new d6().a(paramContext.getApplicationContext(), "TencentUnipay", "enableX5").equals("2");
              if (bool)
              {
                APLog.e("AndroidPay", "current operation is invalid, cause midas set force X5");
                return;
              }
              if (str.equals("0"))
              {
                h8.a(paramContext, "0");
              }
              else if (str.equals("1"))
              {
                h8.a(paramContext, "1");
              }
              else
              {
                paramContext = new StringBuilder();
                paramContext.append("invalid command in reserve param: ");
                paramContext.append(str);
                paramContext.append(", pass \"0\" or \"1\"");
                APLog.e("AndroidPay", paramContext.toString());
              }
            }
            paramContext = (String)paramAPBaseRequest.get("privacyPolicyType");
            if (!TextUtils.isEmpty(paramContext))
            {
              int i1 = Integer.parseInt(paramContext);
              c6.s0().d(i1);
              return;
            }
          }
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public final void b(APBaseRequest paramAPBaseRequest)
  {
    this.m = "0";
    this.n = "";
    if (!TextUtils.isEmpty(paramAPBaseRequest.reserv))
    {
      HashMap localHashMap = APTools.n(paramAPBaseRequest.reserv);
      if (localHashMap != null)
      {
        if (!TextUtils.isEmpty((CharSequence)localHashMap.get("midas_friendspay")))
        {
          String str = (String)localHashMap.get("midas_friendspay");
          if (str.equals("1"))
          {
            this.m = "1";
            if (!TextUtils.isEmpty((CharSequence)localHashMap.get("midas_friendspayurl"))) {
              try
              {
                this.n = URLDecoder.decode((String)localHashMap.get("midas_friendspayurl"), "UTF-8");
              }
              catch (UnsupportedEncodingException localUnsupportedEncodingException)
              {
                localUnsupportedEncodingException.printStackTrace();
              }
            }
          }
          else if ((localUnsupportedEncodingException.equals("2")) && (!TextUtils.isEmpty(paramAPBaseRequest.saveValue)))
          {
            this.m = "2";
          }
        }
        a(paramAPBaseRequest, localHashMap);
      }
    }
  }
  
  public boolean b()
  {
    boolean bool1 = c();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    String str1 = c6.s0().K();
    String str2 = c6.s0().L();
    bool1 = bool2;
    if ("openid".equals(str1))
    {
      bool1 = bool2;
      if ("kp_actoken".equals(str2)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void c(Activity paramActivity, JSONObject paramJSONObject, IAPPayCallBack paramIAPPayCallBack)
  {
    if (paramIAPPayCallBack != null) {
      this.a = paramIAPPayCallBack;
    }
    r().d = paramActivity.getApplicationContext();
    s.f = false;
    c6.s0().c(true);
    a(paramActivity, null);
    for (;;)
    {
      try
      {
        t5 localt5 = new t5(paramActivity, paramJSONObject.optString("appId"));
        if (!paramJSONObject.has("payType"))
        {
          Toast.makeText(paramActivity, "PayType 不能为空", 1).show();
          return;
        }
        paramIAPPayCallBack = paramJSONObject.optString("payType");
        boolean bool = "1".equals(paramIAPPayCallBack);
        if (bool) {}
        try
        {
          localt5.a(paramJSONObject.optString("appId"), paramJSONObject.optString("wxSignVersion"), APTools.a(paramJSONObject.optString("wxPreEntrustWebId"), 1), APTools.a(paramJSONObject.optString("wxSignUrl"), 1));
          APUICommonMethod.f();
          return;
        }
        catch (Exception paramActivity) {}
        if ("2".equals(paramIAPPayCallBack))
        {
          bool = paramJSONObject.has("extends");
          if (!bool) {
            break label624;
          }
          paramIAPPayCallBack = paramJSONObject.optString("extends");
          if (paramJSONObject.has("wxSignUrl")) {
            c6.s0().L(paramJSONObject.optString("wxSignUrl"));
          }
          Object localObject = new APSubscribeRequest();
          if (paramJSONObject.has("offerId")) {
            ((APBaseRequest)localObject).offerId = paramJSONObject.optString("offerId");
          }
          if (paramJSONObject.has("openId")) {
            ((APBaseRequest)localObject).openId = paramJSONObject.optString("openId");
          }
          if (paramJSONObject.has("openKey")) {
            ((APBaseRequest)localObject).openKey = paramJSONObject.optString("openKey");
          }
          if (paramJSONObject.has("sessionId")) {
            ((APBaseRequest)localObject).sessionId = paramJSONObject.optString("sessionId");
          }
          if (paramJSONObject.has("sessiontType")) {
            ((APBaseRequest)localObject).sessionType = paramJSONObject.optString("sessiontType");
          }
          if (paramJSONObject.has("pf")) {
            ((APBaseRequest)localObject).pf = paramJSONObject.optString("pf");
          }
          if (paramJSONObject.has("pfKey")) {
            ((APBaseRequest)localObject).pfKey = paramJSONObject.optString("pfKey");
          }
          a(paramActivity, (APBaseRequest)localObject);
          if (p4.p().e() == null)
          {
            paramActivity = new o4((APBaseRequest)localObject);
            p4.p().a(paramActivity);
          }
          paramActivity = paramJSONObject.optString("appId");
          localObject = paramJSONObject.optString("bargainorId");
          String str1 = paramJSONObject.optString("tokenId");
          String str2 = paramJSONObject.optString("nonceStr");
          String str3 = paramJSONObject.optString("timeStamp");
          String str4 = paramJSONObject.optString("packageValue");
          String str5 = paramJSONObject.optString("sign");
          String str6 = paramJSONObject.optString("wxSignVersion");
          String str7 = paramJSONObject.optString("wxSignUrl");
          String str8 = paramJSONObject.optString("wxPreEntrustWebId");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(paramJSONObject.optInt("payType"));
          localt5.a(paramActivity, (String)localObject, str1, str2, str3, str4, str5, str6, str7, str8, localStringBuilder.toString(), paramIAPPayCallBack);
          APDataReportManager.getInstance().insertData("sdk.h5.wechat.paysign", -1, "", "pay", paramJSONObject.optString("tokenId"));
          return;
        }
        APUICommonMethod.f();
        paramActivity = new StringBuilder();
        paramActivity.append("payType=");
        paramActivity.append(paramIAPPayCallBack);
        paramActivity.append("  不支持");
        z5.a(3, paramActivity.toString());
        return;
      }
      catch (Exception paramActivity) {}
      paramActivity.printStackTrace();
      return;
      label624:
      paramIAPPayCallBack = "";
    }
  }
  
  public final void c(APBaseRequest paramAPBaseRequest)
  {
    f(paramAPBaseRequest);
    c6 localc6 = c6.s0();
    localc6.I(APTools.j());
    localc6.d(paramAPBaseRequest.reserv);
  }
  
  public boolean c()
  {
    Object localObject = p4.p().e();
    if (localObject == null) {
      return false;
    }
    localObject = ((o4)localObject).b;
    if (localObject == null) {
      return false;
    }
    return "itopid".equals(((APBaseRequest)localObject).sessionId);
  }
  
  public final void d(APBaseRequest paramAPBaseRequest)
  {
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty(paramAPBaseRequest.reserv))
    {
      paramAPBaseRequest = APTools.n(paramAPBaseRequest.reserv);
      if (paramAPBaseRequest != null) {
        if (!TextUtils.isEmpty((CharSequence)paramAPBaseRequest.get("wechattype")))
        {
          paramAPBaseRequest = (String)paramAPBaseRequest.get("wechattype");
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("wechattype=");
          localStringBuilder.append(paramAPBaseRequest);
          APLog.d("APAndroidPay", localStringBuilder.toString());
          if ("sign".equals(paramAPBaseRequest))
          {
            new t5(this.d).b();
            return;
          }
          if (!"unsign".equals(paramAPBaseRequest)) {
            break label265;
          }
          paramAPBaseRequest = new APAlertDialog.f((Context)this.c.get());
          paramAPBaseRequest.b("解除微信小额免密支付");
          paramAPBaseRequest.a("确认解除微信小额免密支付服务吗？\n1.仅限小额支付，大额仍然需要密码验证\n2.此操作仅在本应用有效。");
          paramAPBaseRequest.b("确定", new n());
          paramAPBaseRequest.b(new o());
        }
      }
    }
    label265:
    try
    {
      paramAPBaseRequest.b();
      return;
    }
    catch (Exception paramAPBaseRequest) {}
    if (!TextUtils.isEmpty((CharSequence)paramAPBaseRequest.get("qqtype")))
    {
      paramAPBaseRequest = (String)paramAPBaseRequest.get("qqtype");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("wechattype=");
      localStringBuilder.append(paramAPBaseRequest);
      APLog.d("APAndroidPay", localStringBuilder.toString());
      if ("sign".equals(paramAPBaseRequest))
      {
        o();
        return;
      }
      "unsign".equals(paramAPBaseRequest);
    }
    return;
  }
  
  public boolean d()
  {
    boolean bool1 = c();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    String str1 = c6.s0().K();
    String str2 = c6.s0().L();
    bool1 = bool2;
    if ("hy_gameid".equals(str1))
    {
      bool1 = bool2;
      if ("wc_actoken".equals(str2)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean e()
  {
    return (f()) || (d());
  }
  
  public boolean e(APBaseRequest paramAPBaseRequest)
  {
    Object localObject = paramAPBaseRequest.mpInfo;
    paramAPBaseRequest = ((APBaseRequest.APMPInfo)localObject).payChannel;
    String str = ((APBaseRequest.APMPInfo)localObject).discountType;
    localObject = ((APBaseRequest.APMPInfo)localObject).discountUrl;
    if ((!paramAPBaseRequest.equals("wechat")) && (!paramAPBaseRequest.equals("bank"))) {
      return false;
    }
    return (!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject));
  }
  
  public final void f(APBaseRequest paramAPBaseRequest)
  {
    o4 localo4 = p4.p().e();
    try
    {
      localo4.f.a = n6.a(r().d).b(localo4.b.openId);
      localo4.f.b = n6.a(r().d).a(localo4.b.openId);
    }
    catch (Exception localException)
    {
      APLog.e("paramsInit", localException.toString());
    }
    localo4.e.f = false;
    APAppDataInterface.singleton().f(paramAPBaseRequest.extendInfo.isShowNum);
    APAppDataInterface.singleton().b(paramAPBaseRequest.extendInfo.isShowListOtherNum);
    if (TextUtils.isEmpty(paramAPBaseRequest.saveValue)) {
      paramAPBaseRequest.isCanChange = true;
    }
  }
  
  public boolean f()
  {
    Object localObject1 = p4.p().e();
    boolean bool2 = false;
    if (localObject1 == null) {
      return false;
    }
    Object localObject2 = ((o4)localObject1).b;
    if (localObject2 == null) {
      return false;
    }
    localObject1 = ((APBaseRequest)localObject2).sessionId;
    localObject2 = ((APBaseRequest)localObject2).sessionType;
    boolean bool1 = bool2;
    if ("hy_gameid".equals(localObject1))
    {
      bool1 = bool2;
      if ("wc_actoken".equals(localObject2)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final void g()
  {
    try
    {
      try
      {
        Class.forName("com.tencent.bugly.crashreport.CrashReport").getMethod("initCrashReport", new Class[] { Context.class, String.class, Boolean.TYPE }).invoke(null, new Object[] { this.d, "900045921", Boolean.valueOf(false) });
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        localInvocationTargetException.printStackTrace();
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        localNoSuchMethodException.printStackTrace();
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label104:
      break label104;
    }
    APLog.w("GlobalInitialize", "not has bugly sdk.");
    new Thread(new h()).start();
  }
  
  public final void h()
  {
    String str2 = APTools.k("MidasDeviceId");
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = APTools.j();
      APTools.d("MidasDeviceId", str1);
    }
    APLog.i("MidasDeviceId", str1);
    c6.s0().H(str1);
  }
  
  public boolean i()
  {
    Object localObject = new d6().a(this.d, "TencentUnipay", "launchpaycalling");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isCallIng launchpaycalling ");
    localStringBuilder.append((String)localObject);
    APLog.i("APAndroidPay", localStringBuilder.toString());
    if (this.a == null)
    {
      if ("1".equals(localObject)) {
        return true;
      }
      localObject = this.d;
      if (localObject != null)
      {
        localObject = ((ActivityManager.RunningTaskInfo)((ActivityManager)((Context)localObject).getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("isCallIng topActivity = ");
        localStringBuilder.append(((ComponentName)localObject).getClassName());
        APLog.d("APAndroidPay", localStringBuilder.toString());
        if (((ComponentName)localObject).getClassName().contains("com.tencent.midas.proxyactivity")) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  public boolean j()
  {
    String str = p4.p().e().b.mpInfo.payChannel;
    return (str.equals("wechat")) || (str.equals("bank"));
  }
  
  public final void k()
  {
    String str;
    APAppDataInterface localAPAppDataInterface;
    StringBuilder localStringBuilder;
    if (r().f())
    {
      if ("1".equals(APAppDataInterface.singleton().j()))
      {
        str = APAppDataInterface.singleton().B();
        localAPAppDataInterface = APAppDataInterface.singleton();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("wx");
        localStringBuilder.append(str);
        localAPAppDataInterface.i(localStringBuilder.toString());
        return;
      }
      APAppDataInterface.singleton().i("wxUninstall");
      return;
    }
    if (r().c())
    {
      if (r().d())
      {
        if ("1".equals(APAppDataInterface.singleton().j()))
        {
          str = APAppDataInterface.singleton().B();
          localAPAppDataInterface = APAppDataInterface.singleton();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("itopWx");
          localStringBuilder.append(str);
          localAPAppDataInterface.i(localStringBuilder.toString());
          return;
        }
        APAppDataInterface.singleton().i("itopWxUninstall");
        return;
      }
      if (r().b())
      {
        if ("1".equals(APAppDataInterface.singleton().i()))
        {
          str = APAppDataInterface.singleton().t();
          localAPAppDataInterface = APAppDataInterface.singleton();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("itopQQ");
          localStringBuilder.append(str);
          localAPAppDataInterface.i(localStringBuilder.toString());
          return;
        }
        APAppDataInterface.singleton().i("itopQQUninstall");
      }
    }
    else
    {
      if (d.a())
      {
        APAppDataInterface.singleton().i("other");
        return;
      }
      if (d.b())
      {
        APAppDataInterface.singleton().i("none");
        return;
      }
      if ("1".equals(APAppDataInterface.singleton().i()))
      {
        str = APAppDataInterface.singleton().t();
        localAPAppDataInterface = APAppDataInterface.singleton();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("qq");
        localStringBuilder.append(str);
        localAPAppDataInterface.i(localStringBuilder.toString());
        return;
      }
      APAppDataInterface.singleton().i("qqUninstall");
    }
  }
  
  public void l()
  {
    if (this.a != null)
    {
      j9.b();
      e5.g();
      r6.i();
      this.g = null;
      this.a.MidasPayNeedLogin();
      this.a = null;
    }
    try
    {
      APDataReportManager.getInstance().insertData("sdk.deviceinfo", -1, null, null, APAppDataInterface.singleton().g());
      APDataReportManager.getInstance().insertData("sdk.callback.exit", 0, p4.p().e().b.openId, APAppDataInterface.singleton().C(), String.valueOf(1018));
      new Handler().postDelayed(new q(null), 200L);
      return;
    }
    catch (Exception localException)
    {
      APLog.i("paycallback report", localException.toString());
    }
  }
  
  public final void m()
  {
    try
    {
      String str = new d6().a(r().d, "TencentUnipay", "privacyPolicyType");
      if (!TextUtils.isEmpty(str))
      {
        int i1 = Integer.parseInt(str);
        c6.s0().d(i1);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void n()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    if (h8.d((Context)this.c.get()))
    {
      localBundle.putString("loadUI", "showStartActivity");
      localIntent.putExtras(localBundle);
      localIntent.setClass((Context)this.c.get(), APX5WebMarketActivity.class);
    }
    else
    {
      localBundle.putString("loadUI", "showStartActivity");
      localIntent.putExtras(localBundle);
      localIntent.setClass((Context)this.c.get(), APWebMarketActivity.class);
    }
    ((Activity)this.c.get()).startActivity(localIntent);
  }
  
  public final void o()
  {
    z1.d().k(new p());
  }
  
  public class a
    implements fc
  {
    public a(IAPNetCallBack paramIAPNetCallBack) {}
    
    public void a(ob paramob)
    {
      paramob = (k3)paramob;
      paramIAPNetCallBack.MidasNetFinish(paramob.l, paramob.g());
    }
    
    public void b(ob paramob)
    {
      k3 localk3 = (k3)paramob;
      paramIAPNetCallBack.MidasNetError(localk3.l, paramob.d(), paramob.c());
    }
    
    public void c(ob paramob)
    {
      paramob = (k3)paramob;
      paramIAPNetCallBack.MidasNetStop(paramob.l);
    }
  }
  
  public static final class b
    implements c7
  {
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      z5.f();
      paramAPAlertDialog.f();
    }
  }
  
  public static final class c
    implements c7
  {
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
      {
        z5.f();
        paramAPAlertDialog.f();
      }
    }
  }
  
  public class d
    implements fc
  {
    public d() {}
    
    public void a(ob paramob)
    {
      APLog.i("APAndroidPay", "插话费卡券onFinish");
    }
    
    public void b(ob paramob)
    {
      APLog.i("APAndroidPay", "插话费卡券onError");
    }
    
    public void c(ob paramob)
    {
      APLog.i("APAndroidPay", "插话费卡券onStop");
    }
  }
  
  public class e
    implements fc
  {
    public e(APQueryInventoryFinishedListener paramAPQueryInventoryFinishedListener) {}
    
    public void a(ob paramob)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("queryInventoryAsync Ans onFinish ret:");
      ((StringBuilder)localObject1).append(paramob.d());
      APLog.i("APAndroidPay", ((StringBuilder)localObject1).toString());
      if (paramob.d() == 0)
      {
        Object localObject2 = new APIabResult(paramob.d(), paramob.c());
        localObject1 = new APInventory(((s3)paramob).g);
        paramAPQueryInventoryFinishedListener.onQueryInventoryFinished((APIabResult)localObject2, (APInventory)localObject1);
        localObject2 = APDataReportManager.getInstance();
        int i = paramob.d();
        paramob = new StringBuilder();
        paramob.append("size=");
        paramob.append(String.valueOf(((APInventory)localObject1).mPurchaseMap.size()));
        ((APDataReportManager)localObject2).insertData("sdk.result.receipt.queryans", -1, null, String.valueOf(i), paramob.toString());
        return;
      }
      localObject1 = new APIabResult(paramob.d(), paramob.c());
      paramAPQueryInventoryFinishedListener.onQueryInventoryFinished((APIabResult)localObject1, null);
      APDataReportManager.getInstance().insertData("sdk.result.receipt.queryans", -1, null, String.valueOf(paramob.d()), null);
    }
    
    public void b(ob paramob)
    {
      APDataReportManager.getInstance().insertData("sdk.result.receipt.queryans", -1, null, String.valueOf(paramob.d()), "onError");
      APLog.i("APAndroidPay", "queryInventoryAsync Ans onError");
      paramob = new APIabResult(paramob.d(), paramob.c());
      paramAPQueryInventoryFinishedListener.onQueryInventoryFinished(paramob, null);
    }
    
    public void c(ob paramob)
    {
      APLog.i("APAndroidPay", "queryInventoryAsync Ans onStop");
      paramob = new APIabResult(paramob.d(), paramob.c());
      paramAPQueryInventoryFinishedListener.onQueryInventoryFinished(paramob, null);
    }
  }
  
  public class f
    implements fc
  {
    public f(OnAPConsumeFinishedListener paramOnAPConsumeFinishedListener) {}
    
    public void a(ob paramob)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("consumeAsync onFinish ret :");
      ((StringBuilder)localObject).append(paramob.d());
      APLog.i("APAndroidPay", ((StringBuilder)localObject).toString());
      if (paramob.d() == 0)
      {
        localObject = new APInventory(((s3)paramob).g);
        paramOnAPConsumeFinishedListener.onConsumeFinished(((APInventory)localObject).getPurchaseList());
        APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
        int i = paramob.d();
        paramob = new StringBuilder();
        paramob.append("size=");
        paramob.append(String.valueOf(((APInventory)localObject).mPurchaseMap.size()));
        localAPDataReportManager.insertData("sdk.result.receipt.comsumans", -1, null, String.valueOf(i), paramob.toString());
        return;
      }
      paramOnAPConsumeFinishedListener.onConsumeFinished(null);
      APDataReportManager.getInstance().insertData("sdk.result.receipt.comsumans", -1, null, String.valueOf(paramob.d()), null);
    }
    
    public void b(ob paramob)
    {
      APLog.i("APAndroidPay", "consumeAsync onError");
      paramOnAPConsumeFinishedListener.onConsumeFinished(null);
      APDataReportManager.getInstance().insertData("sdk.result.receipt.comsumans", -1, null, "onError", null);
    }
    
    public void c(ob paramob)
    {
      APLog.i("APAndroidPay", "consumeAsync onStop");
      paramOnAPConsumeFinishedListener.onConsumeFinished(null);
    }
  }
  
  public class g
    extends ResultReceiver
  {
    public g(Handler paramHandler)
    {
      super();
    }
    
    public void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      if (paramBundle.getInt("type") == 26)
      {
        c6.s0().v(false);
        APUICommonMethod.f();
        paramBundle = new APPayResponse();
        if (paramInt == 0)
        {
          paramBundle.resultMsg = "签约成功！";
          paramBundle.resultCode = 0;
          z5.a(8, -1, -1, paramBundle.resultMsg);
          return;
        }
        if (paramInt == -1)
        {
          paramBundle.resultMsg = "签约失败！";
          paramBundle.resultCode = -1;
        }
        else if (paramInt == -2)
        {
          paramBundle.resultCode = 2;
          paramBundle.resultMsg = "用户取消了签约";
        }
        else
        {
          paramBundle.resultCode = 5;
          paramBundle.resultMsg = "签约状态未知！";
        }
        z5.a(paramBundle.resultCode, paramBundle.resultMsg, null);
        return;
      }
      z5.a(2, "签约状态未知！");
    }
  }
  
  public class h
    implements Runnable
  {
    public h() {}
    
    public void run()
    {
      SharedPreferences.Editor localEditor = a.this.d.getSharedPreferences("BuglySdkInfos", 0).edit();
      localEditor.putString("900045921", "1.7.9a");
      localEditor.commit();
    }
  }
  
  public class i
    extends ResultReceiver
  {
    public i(Handler paramHandler, IAPPayCallBack paramIAPPayCallBack)
    {
      super();
    }
    
    public void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      if (paramBundle.getInt("type") == 26)
      {
        paramBundle = new APPayResponse();
        if (paramInt == 0)
        {
          paramBundle.resultMsg = "签约成功！";
          paramBundle.resultCode = 0;
        }
        else if (paramInt == -1)
        {
          paramBundle.resultMsg = "签约失败！";
          paramBundle.resultCode = -1;
        }
        else if (paramInt == -2)
        {
          paramBundle.resultCode = 2;
          paramBundle.resultMsg = "用户取消了支付";
        }
        else
        {
          paramBundle.resultCode = 5;
          paramBundle.resultMsg = "签约状态未知！";
        }
        APUICommonMethod.f();
        paramIAPPayCallBack.MidasPayCallBack(paramBundle);
      }
    }
  }
  
  public class j
    extends ResultReceiver
  {
    public j(Handler paramHandler, ResultReceiver paramResultReceiver)
    {
      super();
    }
    
    public void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("wechatAPI.onReceiveResult resultCode = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", resultData = ");
      localStringBuilder.append(paramBundle);
      APLog.d("APAndroidPay", localStringBuilder.toString());
      if (paramBundle.getInt("type") == 19) {
        paramResultReceiver.send(0, paramBundle);
      }
    }
  }
  
  public class k
    implements fc
  {
    public k(Context paramContext, MidasActivityAbility paramMidasActivityAbility) {}
    
    public void a(ob paramob)
    {
      paramob = (b2)paramob;
      int i = paramob.d();
      if (i == 0)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("orderId", paramob.h());
        localBundle.putString("shareUrl", paramob.g());
        a.a(a.this, paramContext, paramMidasActivityAbility, paramob, localBundle);
        return;
      }
      MidasAbilityResponse.onFailureCGI(paramMidasActivityAbility, i, paramob.c(), new Bundle());
    }
    
    public void b(ob paramob)
    {
      paramob = (b2)paramob;
      MidasAbilityResponse.onFailureSDK(paramMidasActivityAbility, -3, paramob.c(), new Bundle());
    }
    
    public void c(ob paramob)
    {
      APLog.d("APAndroidPay", "toPreEnjoySign() network.onStop");
    }
  }
  
  public class l
    implements IAPPayCallBack
  {
    public l(MidasActivityAbility paramMidasActivityAbility) {}
    
    public void MidasPayCallBack(APPayResponse paramAPPayResponse)
    {
      Bundle localBundle = new Bundle();
      if (paramAPPayResponse != null)
      {
        localBundle.putInt("resultCode", paramAPPayResponse.resultCode);
        localBundle.putInt("resultInerCode", paramAPPayResponse.resultInerCode);
        localBundle.putInt("realSaveNum", paramAPPayResponse.realSaveNum);
        localBundle.putInt("payChannel", paramAPPayResponse.payChannel);
        localBundle.putInt("payState", paramAPPayResponse.payState);
        localBundle.putInt("provideState", paramAPPayResponse.provideState);
        localBundle.putString("extendInfo", paramAPPayResponse.extendInfo);
        localBundle.putString("resultMsg", paramAPPayResponse.resultMsg);
        localBundle.putString("payReserve1", paramAPPayResponse.payReserve1);
        localBundle.putString("payReserve2", paramAPPayResponse.payReserve2);
        localBundle.putString("payReserve3", paramAPPayResponse.payReserve3);
        APPurchase localAPPurchase = paramAPPayResponse.mAPPurchase;
        if (localAPPurchase != null)
        {
          localBundle.putString("purchaseJson", localAPPurchase.mOriginalJson);
          localBundle.putString("purchaseSign", paramAPPayResponse.mAPPurchase.mSignature);
        }
      }
      else
      {
        localBundle.putString("msg", "midas sdk responseInfo is Null");
      }
      int i = paramAPPayResponse.resultCode;
      if (i == 0)
      {
        MidasAbilityResponse.onSuccess(paramMidasActivityAbility, 0, localBundle);
        return;
      }
      if (i == 2)
      {
        MidasAbilityResponse.onCancel(paramMidasActivityAbility, 1, localBundle);
        return;
      }
      MidasAbilityResponse.onFailureSDK(paramMidasActivityAbility, i, "Payment callback failure", localBundle);
    }
    
    public void MidasPayNeedLogin()
    {
      MidasAbilityResponse.onFailureSDK(paramMidasActivityAbility, -5, "Login invalid, need reLogin", new Bundle());
    }
  }
  
  public class m
    implements fc
  {
    public m(IAPNetCallBack paramIAPNetCallBack) {}
    
    public void a(ob paramob)
    {
      paramob = (k3)paramob;
      paramIAPNetCallBack.MidasNetFinish(paramob.l, paramob.g());
    }
    
    public void b(ob paramob)
    {
      paramIAPNetCallBack.MidasNetError(((k3)paramob).l, paramob.d(), paramob.c());
    }
    
    public void c(ob paramob)
    {
      paramIAPNetCallBack.MidasNetStop(((k3)paramob).l);
    }
  }
  
  public class n
    implements c7
  {
    public n() {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      paramAPAlertDialog.f();
      new t5(a.this.d).c();
    }
  }
  
  public class o
    implements c7
  {
    public o() {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
      {
        paramAPAlertDialog.f();
        APUICommonMethod.f();
        z5.a(3, "unsign getcardbillinfo stop");
      }
    }
  }
  
  public class p
    implements fc
  {
    public p() {}
    
    public void a(ob paramob)
    {
      if (paramob.d() == 0)
      {
        localObject = ((a4)paramob).g();
        Activity localActivity = (Activity)a.p().c.get();
        if (localActivity != null)
        {
          q5.a(localActivity, (String)localObject);
          APUICommonMethod.f();
          z5.a(2, -1, -1);
          return;
        }
        APUICommonMethod.f();
        z5.a(3, "sign onFinish err: fromActivity==Null", paramob.e());
        return;
      }
      APUICommonMethod.f();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sign onFinish err: ");
      ((StringBuilder)localObject).append(paramob.f());
      z5.a(3, ((StringBuilder)localObject).toString(), paramob.e());
    }
    
    public void b(ob paramob)
    {
      APUICommonMethod.f();
      z5.a(3, "sign mobile_sign_contract onError");
    }
    
    public void c(ob paramob)
    {
      APUICommonMethod.f();
      z5.a(3, "sign mobile_sign_contract stop");
    }
  }
  
  public class q
    implements Runnable
  {
    public q() {}
    
    public void run()
    {
      z1.d().b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.a
 * JD-Core Version:    0.7.0.1
 */