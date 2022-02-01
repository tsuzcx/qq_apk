package com.tencent.midas.pay;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.pay.api.APAndroidPayAPI;
import com.pay.api.APPayResponse;
import com.pay.api.IAPNetCallBack;
import com.pay.api.IAPPayCallBack;
import com.pay.api.request.APGameRequest;
import com.pay.api.request.APGoodsRequest;
import com.pay.api.request.APMonthRequest;
import com.pay.api.request.APNetRequest;
import com.pay.api.request.APSubscribeRequest;
import com.pay.data.report.APPluginReportParams;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APBase64;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginActivity;
import java.lang.reflect.Field;
import midas.x.af;
import midas.x.ne;
import org.json.JSONException;
import org.json.JSONObject;

public class APMidasH5DistributeActivity
  extends APPluginActivity
  implements IAPPayCallBack
{
  public static String a = "com.pay.tool.APMidasCommMethod";
  public static String b = "popActivity";
  public static String c = "com.tencent.midas.control.APMidasPayHelper";
  public static String d = "midasH5CallBack";
  public static String e = "midas_js_bridge_";
  public static String f = "WSJPay_js_bridge_";
  private static String h = "getVersion";
  private static String i = "payGame";
  private static String j = "payGoods";
  private static String k = "payMonth";
  private static String l = "paySubscribe";
  private static String m = "payNet";
  private static String n = "launchPaySign";
  private byte[] A = null;
  private String B = "";
  private String C = "";
  private String D = "";
  private int E = 0;
  private String F = "";
  private String G = "";
  private boolean H = true;
  private boolean I = true;
  private String J = "";
  private String K = "";
  private String L = "";
  private String M = "";
  private String N = "";
  private String O = "";
  private String P = "-1001";
  private String Q = "-1002";
  private String R = "1018";
  private String S = "2";
  public ResultReceiver g = null;
  private String o = "";
  private String p = "";
  private String q = "";
  private String r = "";
  private String s = "";
  private String t = "";
  private String u = "";
  private String v = "";
  private String w = "";
  private String x = "";
  private boolean y = true;
  private int z = 0;
  
  private void a(String paramString)
  {
    a(this.o, paramString);
  }
  
  private void a(String paramString1, String paramString2)
  {
    APLog.e("h5 callBack", paramString1);
    try
    {
      paramString1 = APMidasDistribute.buildCallBackInfo(paramString1, paramString2);
      if (this.g != null)
      {
        paramString2 = new Bundle();
        paramString2.putString("type", "h5callback");
        paramString2.putString("callbackinfo", paramString1);
        this.g.send(0, paramString2);
      }
      else
      {
        ne.a(c, d, new Object[] { paramString1 });
      }
    }
    catch (Throwable paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("getCallBackInfo error:");
      paramString2.append(paramString1.toString());
      APLog.w("APMidasH5DistributeActivity", paramString2.toString());
      paramString1.printStackTrace();
    }
    finish();
  }
  
  private void a(String paramString, JSONObject paramJSONObject)
  {
    if (h.equals(paramString))
    {
      d();
      return;
    }
    if (i.equals(paramString))
    {
      c(paramJSONObject);
      return;
    }
    if (j.equals(paramString))
    {
      d(paramJSONObject);
      return;
    }
    if (l.equals(paramString))
    {
      f(paramJSONObject);
      return;
    }
    if (k.equals(paramString))
    {
      e(paramJSONObject);
      return;
    }
    if (m.equals(paramString))
    {
      g(paramJSONObject);
      return;
    }
    if (n.equals(paramString))
    {
      paramString = new StringBuilder();
      paramString.append("");
      paramString.append(paramJSONObject.toString());
      APLog.d("FUNC_WECHAT_SIGNED", paramString.toString());
      b(paramJSONObject);
      return;
    }
    paramString = new JSONObject();
    try
    {
      paramString.put("resultCode", this.P);
      paramString.put("resultMsg", "version not support");
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    a(paramString.toString());
  }
  
  private void a(JSONObject paramJSONObject)
  {
    this.p = "";
    this.q = "";
    this.r = "";
    this.s = "";
    this.t = "";
    this.u = "";
    this.v = "";
    this.w = "";
    this.x = "";
    this.y = true;
    this.z = 0;
    this.A = null;
    this.B = "";
    this.C = "";
    this.D = "";
    this.E = 0;
    this.F = "";
    this.G = "";
    this.H = true;
    this.I = true;
    this.J = "";
    this.K = "";
    this.L = "";
    this.M = "";
    this.N = "";
    this.O = "";
    try
    {
      if (paramJSONObject.has("offerId")) {
        this.p = paramJSONObject.getString("offerId");
      }
      if (paramJSONObject.has("openId")) {
        this.q = paramJSONObject.getString("openId");
      }
      if (paramJSONObject.has("openKey")) {
        this.r = paramJSONObject.getString("openKey");
      }
      if (paramJSONObject.has("sessionId")) {
        this.s = paramJSONObject.getString("sessionId");
      }
      if (paramJSONObject.has("sessionType")) {
        this.t = paramJSONObject.getString("sessionType");
      }
      if (paramJSONObject.has("zoneId")) {
        this.u = paramJSONObject.getString("zoneId");
      }
      if (paramJSONObject.has("pf")) {
        this.v = paramJSONObject.getString("pf");
      }
      if (paramJSONObject.has("pfKey")) {
        this.w = paramJSONObject.getString("pfKey");
      }
      if (paramJSONObject.has("saveValue")) {
        this.x = paramJSONObject.getString("saveValue");
      }
      if (paramJSONObject.has("isCanChange")) {
        this.y = paramJSONObject.getBoolean("isCanChange");
      }
      if (paramJSONObject.has("remark")) {
        this.C = paramJSONObject.optString("remark");
      }
      if (paramJSONObject.has("resId")) {
        this.z = paramJSONObject.getInt("resId");
      }
      if (paramJSONObject.has("resData"))
      {
        String str = paramJSONObject.getString("resData");
        if (!TextUtils.isEmpty(str)) {
          this.A = APBase64.decode(str);
        }
      }
      if (paramJSONObject.has("acctType")) {
        this.B = paramJSONObject.getString("acctType");
      }
      if (paramJSONObject.has("reserv")) {
        this.D = paramJSONObject.getString("reserv");
      }
      if (paramJSONObject.has("mallType")) {
        this.E = paramJSONObject.getInt("mallType");
      }
      if (paramJSONObject.has("h5Url")) {
        this.F = paramJSONObject.getString("h5Url");
      }
      if (paramJSONObject.has("unit")) {
        this.G = paramJSONObject.getString("unit");
      }
      if (paramJSONObject.has("isShowNum")) {
        this.H = paramJSONObject.getBoolean("isShowNum");
      }
      if (paramJSONObject.has("isShowListOtherNum")) {
        this.I = paramJSONObject.getBoolean("isShowListOtherNum");
      }
      if (paramJSONObject.has("payChannel")) {
        this.J = paramJSONObject.getString("payChannel");
      }
      if (paramJSONObject.has("discountType")) {
        this.K = paramJSONObject.getString("discountType");
      }
      if (paramJSONObject.has("discountUrl")) {
        this.L = paramJSONObject.getString("discountUrl");
      }
      if (paramJSONObject.has("drmInfo")) {
        this.M = paramJSONObject.getString("drmInfo");
      }
      if (paramJSONObject.has("discoutId")) {
        this.N = paramJSONObject.getString("discoutId");
      }
      if (paramJSONObject.has("extras"))
      {
        this.O = paramJSONObject.getString("extras");
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      APLog.w("APMidasH5Distribute", paramJSONObject.toString());
      paramJSONObject.printStackTrace();
    }
  }
  
  private void b(JSONObject paramJSONObject)
  {
    try
    {
      if (1 == paramJSONObject.getInt("payType")) {
        finish();
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    APAndroidPayAPI.launchWeChatPay(this, paramJSONObject, this);
  }
  
  private void c(JSONObject paramJSONObject)
  {
    paramJSONObject = new APGameRequest();
    paramJSONObject.offerId = this.p;
    paramJSONObject.openId = this.q;
    paramJSONObject.openKey = this.r;
    paramJSONObject.sessionId = this.s;
    paramJSONObject.sessionType = this.t;
    paramJSONObject.zoneId = this.u;
    paramJSONObject.pf = this.v;
    paramJSONObject.pfKey = this.w;
    paramJSONObject.acctType = this.B;
    paramJSONObject.saveValue = this.x;
    paramJSONObject.isCanChange = this.y;
    paramJSONObject.resId = this.z;
    paramJSONObject.resData = this.A;
    paramJSONObject.reserv = this.D;
    paramJSONObject.remark = this.C;
    paramJSONObject.mallType = this.E;
    paramJSONObject.h5Url = this.F;
    paramJSONObject.extendInfo.unit = this.G;
    paramJSONObject.extendInfo.isShowNum = this.H;
    paramJSONObject.extendInfo.isShowListOtherNum = this.I;
    paramJSONObject.mpInfo.payChannel = this.J;
    paramJSONObject.mpInfo.discountType = this.K;
    paramJSONObject.mpInfo.discountUrl = this.L;
    paramJSONObject.mpInfo.discoutId = this.N;
    paramJSONObject.mpInfo.drmInfo = this.M;
    paramJSONObject.mpInfo.extras = this.O;
    APAndroidPayAPI.launchPay(this, paramJSONObject, this);
  }
  
  private void d()
  {
    a("{'resultCode':'0','version':'1.7.4','resultMsg':''}");
  }
  
  private void d(JSONObject paramJSONObject)
  {
    APGoodsRequest localAPGoodsRequest = new APGoodsRequest();
    localAPGoodsRequest.offerId = this.p;
    localAPGoodsRequest.openId = this.q;
    localAPGoodsRequest.openKey = this.r;
    localAPGoodsRequest.sessionId = this.s;
    localAPGoodsRequest.sessionType = this.t;
    localAPGoodsRequest.zoneId = this.u;
    localAPGoodsRequest.pf = this.v;
    localAPGoodsRequest.pfKey = this.w;
    localAPGoodsRequest.acctType = this.B;
    localAPGoodsRequest.saveValue = this.x;
    localAPGoodsRequest.isCanChange = this.y;
    localAPGoodsRequest.resId = this.z;
    localAPGoodsRequest.resData = this.A;
    localAPGoodsRequest.remark = this.C;
    localAPGoodsRequest.reserv = this.D;
    localAPGoodsRequest.mallType = this.E;
    localAPGoodsRequest.h5Url = this.F;
    try
    {
      if (paramJSONObject.has("goodsTokenUrl")) {
        localAPGoodsRequest.goodsTokenUrl = paramJSONObject.getString("goodsTokenUrl");
      }
      if (paramJSONObject.has("prodcutId")) {
        localAPGoodsRequest.prodcutId = paramJSONObject.getString("prodcutId");
      }
      if (paramJSONObject.has("tokenType")) {
        localAPGoodsRequest.tokenType = paramJSONObject.getInt("tokenType");
      }
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    localAPGoodsRequest.extendInfo.unit = this.G;
    localAPGoodsRequest.extendInfo.isShowNum = this.H;
    localAPGoodsRequest.extendInfo.isShowListOtherNum = this.I;
    localAPGoodsRequest.mpInfo.payChannel = this.J;
    localAPGoodsRequest.mpInfo.discountType = this.K;
    localAPGoodsRequest.mpInfo.discountUrl = this.L;
    localAPGoodsRequest.mpInfo.discoutId = this.N;
    localAPGoodsRequest.mpInfo.drmInfo = this.M;
    localAPGoodsRequest.mpInfo.extras = this.O;
    APAndroidPayAPI.launchPay(this, localAPGoodsRequest, this);
  }
  
  private void e(JSONObject paramJSONObject)
  {
    APMonthRequest localAPMonthRequest = new APMonthRequest();
    localAPMonthRequest.offerId = this.p;
    localAPMonthRequest.openId = this.q;
    localAPMonthRequest.openKey = this.r;
    localAPMonthRequest.sessionId = this.s;
    localAPMonthRequest.sessionType = this.t;
    localAPMonthRequest.zoneId = this.u;
    localAPMonthRequest.pf = this.v;
    localAPMonthRequest.pfKey = this.w;
    localAPMonthRequest.acctType = this.B;
    localAPMonthRequest.saveValue = this.x;
    localAPMonthRequest.isCanChange = this.y;
    localAPMonthRequest.resId = this.z;
    localAPMonthRequest.resData = this.A;
    localAPMonthRequest.remark = this.C;
    localAPMonthRequest.reserv = this.D;
    localAPMonthRequest.mallType = this.E;
    localAPMonthRequest.h5Url = this.F;
    try
    {
      if (paramJSONObject.has("autoPay")) {
        localAPMonthRequest.autoPay = paramJSONObject.getBoolean("autoPay");
      }
      if (paramJSONObject.has("serviceCode")) {
        localAPMonthRequest.serviceCode = paramJSONObject.getString("serviceCode");
      }
      if (paramJSONObject.has("serviceName")) {
        localAPMonthRequest.serviceName = paramJSONObject.getString("serviceName");
      }
      if (paramJSONObject.has("serviceType")) {
        localAPMonthRequest.serviceType = paramJSONObject.getInt("serviceType");
      }
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    localAPMonthRequest.extendInfo.unit = this.G;
    localAPMonthRequest.extendInfo.isShowNum = this.H;
    localAPMonthRequest.extendInfo.isShowListOtherNum = this.I;
    localAPMonthRequest.mpInfo.payChannel = this.J;
    localAPMonthRequest.mpInfo.discountType = this.K;
    localAPMonthRequest.mpInfo.discountUrl = this.L;
    localAPMonthRequest.mpInfo.discoutId = this.N;
    localAPMonthRequest.mpInfo.drmInfo = this.M;
    localAPMonthRequest.mpInfo.extras = this.O;
    APAndroidPayAPI.launchPay(this, localAPMonthRequest, this);
  }
  
  private void f(JSONObject paramJSONObject)
  {
    APSubscribeRequest localAPSubscribeRequest = new APSubscribeRequest();
    localAPSubscribeRequest.offerId = this.p;
    localAPSubscribeRequest.openId = this.q;
    localAPSubscribeRequest.openKey = this.r;
    localAPSubscribeRequest.sessionId = this.s;
    localAPSubscribeRequest.sessionType = this.t;
    localAPSubscribeRequest.zoneId = this.u;
    localAPSubscribeRequest.pf = this.v;
    localAPSubscribeRequest.pfKey = this.w;
    localAPSubscribeRequest.acctType = this.B;
    localAPSubscribeRequest.saveValue = this.x;
    localAPSubscribeRequest.isCanChange = this.y;
    localAPSubscribeRequest.resId = this.z;
    localAPSubscribeRequest.resData = this.A;
    localAPSubscribeRequest.remark = this.C;
    localAPSubscribeRequest.reserv = this.D;
    localAPSubscribeRequest.mallType = this.E;
    localAPSubscribeRequest.h5Url = this.F;
    try
    {
      if (paramJSONObject.has("autoPay")) {
        localAPSubscribeRequest.autoPay = paramJSONObject.getBoolean("autoPay");
      }
      if (paramJSONObject.has("serviceCode")) {
        localAPSubscribeRequest.serviceCode = paramJSONObject.getString("serviceCode");
      }
      if (paramJSONObject.has("serviceName")) {
        localAPSubscribeRequest.serviceName = paramJSONObject.getString("serviceName");
      }
      if (paramJSONObject.has("serviceType")) {
        localAPSubscribeRequest.serviceType = paramJSONObject.getInt("serviceType");
      }
      if (paramJSONObject.has("productId")) {
        localAPSubscribeRequest.productId = paramJSONObject.getString("productId");
      }
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    localAPSubscribeRequest.extendInfo.unit = this.G;
    localAPSubscribeRequest.extendInfo.isShowNum = this.H;
    localAPSubscribeRequest.extendInfo.isShowListOtherNum = this.I;
    localAPSubscribeRequest.mpInfo.payChannel = this.J;
    localAPSubscribeRequest.mpInfo.discountType = this.K;
    localAPSubscribeRequest.mpInfo.discountUrl = this.L;
    localAPSubscribeRequest.mpInfo.discoutId = this.N;
    localAPSubscribeRequest.mpInfo.drmInfo = this.M;
    localAPSubscribeRequest.mpInfo.extras = this.O;
    APAndroidPayAPI.launchPay(this, localAPSubscribeRequest, this);
  }
  
  private void g(JSONObject paramJSONObject)
  {
    APNetRequest localAPNetRequest = new APNetRequest();
    localAPNetRequest.offerId = this.p;
    localAPNetRequest.openId = this.q;
    localAPNetRequest.openKey = this.r;
    localAPNetRequest.sessionId = this.s;
    localAPNetRequest.sessionType = this.t;
    localAPNetRequest.zoneId = this.u;
    localAPNetRequest.pf = this.v;
    localAPNetRequest.pfKey = this.w;
    localAPNetRequest.acctType = this.B;
    localAPNetRequest.saveValue = this.x;
    localAPNetRequest.isCanChange = this.y;
    localAPNetRequest.resId = this.z;
    localAPNetRequest.resData = this.A;
    localAPNetRequest.remark = this.C;
    localAPNetRequest.reserv = this.D;
    localAPNetRequest.mallType = this.E;
    localAPNetRequest.h5Url = this.F;
    try
    {
      if (paramJSONObject.has("reqType")) {
        localAPNetRequest.reqType = paramJSONObject.getString("reqType");
      }
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    localAPNetRequest.extendInfo.unit = this.G;
    localAPNetRequest.extendInfo.isShowNum = this.H;
    localAPNetRequest.extendInfo.isShowListOtherNum = this.I;
    localAPNetRequest.mpInfo.payChannel = this.J;
    localAPNetRequest.mpInfo.discountType = this.K;
    localAPNetRequest.mpInfo.discountUrl = this.L;
    localAPNetRequest.mpInfo.discoutId = this.N;
    localAPNetRequest.mpInfo.drmInfo = this.M;
    localAPNetRequest.mpInfo.extras = this.O;
    APAndroidPayAPI.launchNet(this, localAPNetRequest, new IAPNetCallBack()
    {
      public void MidasNetError(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2)
      {
        paramAnonymousString1 = new StringBuilder();
        paramAnonymousString1.append(paramAnonymousInt);
        paramAnonymousString1.append(":");
        paramAnonymousString1.append(paramAnonymousString2);
        APLog.d("APMidash5Distribute", paramAnonymousString1.toString());
        paramAnonymousString1 = new JSONObject();
        try
        {
          paramAnonymousString1.put("resultCode", APMidasH5DistributeActivity.b(APMidasH5DistributeActivity.this));
          paramAnonymousString1.put("resultMsg", "network error");
        }
        catch (JSONException paramAnonymousString2)
        {
          paramAnonymousString2.printStackTrace();
        }
        APMidasH5DistributeActivity.a(APMidasH5DistributeActivity.this, paramAnonymousString1.toString());
      }
      
      public void MidasNetFinish(String paramAnonymousString1, String paramAnonymousString2)
      {
        if (APMidasH5DistributeActivity.this.a()) {}
        try
        {
          paramAnonymousString1 = new JSONObject(paramAnonymousString2);
          if (paramAnonymousString1.has("ret"))
          {
            int i = paramAnonymousString1.getInt("ret");
            if (i == 1018)
            {
              try
              {
                ne.a(APMidasH5DistributeActivity.a, APMidasH5DistributeActivity.b, null);
                ne.a(APMidasH5DistributeActivity.c, APMidasDistributeActivity.b, null);
              }
              catch (Exception paramAnonymousString1)
              {
                APLog.i("h5distribut MidasPayNeedLogin err", paramAnonymousString1.toString());
              }
              APMidasH5DistributeActivity.this.finish();
              return;
            }
          }
        }
        catch (Exception paramAnonymousString1)
        {
          label85:
          break label85;
        }
        APLog.d("APMidash5Distribute MidasNetFinish", paramAnonymousString2);
        APMidasH5DistributeActivity.a(APMidasH5DistributeActivity.this, paramAnonymousString2);
      }
      
      public void MidasNetStop(String paramAnonymousString)
      {
        APLog.d("APMidash5Distribute", "MidasMPStop");
        paramAnonymousString = new JSONObject();
        try
        {
          paramAnonymousString.put("resultCode", APMidasH5DistributeActivity.a(APMidasH5DistributeActivity.this));
          paramAnonymousString.put("resultMsg", "user cancel");
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        APMidasH5DistributeActivity.a(APMidasH5DistributeActivity.this, paramAnonymousString.toString());
      }
    });
  }
  
  public void MidasPayCallBack(APPayResponse paramAPPayResponse)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("response.resultCod:");
      ((StringBuilder)localObject).append(paramAPPayResponse.resultCode);
      APLog.i("APMidasH5DistributeActivity", ((StringBuilder)localObject).toString());
      localObject = new JSONObject();
      ((JSONObject)localObject).put("resultCode", paramAPPayResponse.resultCode);
      ((JSONObject)localObject).put("resultMsg", paramAPPayResponse.resultMsg);
      ((JSONObject)localObject).put("resultInerCode", paramAPPayResponse.resultInerCode);
      ((JSONObject)localObject).put("realSaveNum", paramAPPayResponse.realSaveNum);
      ((JSONObject)localObject).put("payChannel", paramAPPayResponse.payChannel);
      ((JSONObject)localObject).put("payState", paramAPPayResponse.payState);
      ((JSONObject)localObject).put("provideState", paramAPPayResponse.provideState);
      ((JSONObject)localObject).put("extendInfo", paramAPPayResponse.extendInfo);
      ((JSONObject)localObject).put("payReserve1", paramAPPayResponse.payReserve1);
      ((JSONObject)localObject).put("payReserve2", paramAPPayResponse.payReserve2);
      ((JSONObject)localObject).put("payReserve3", paramAPPayResponse.payReserve3);
      paramAPPayResponse = new StringBuilder();
      paramAPPayResponse.append("MidasPayCallBack:");
      paramAPPayResponse.append(((JSONObject)localObject).toString());
      APLog.i("APMidasH5DistributeActivity", paramAPPayResponse.toString());
      paramAPPayResponse = ((JSONObject)localObject).toString();
    }
    catch (Throwable paramAPPayResponse)
    {
      paramAPPayResponse.printStackTrace();
      paramAPPayResponse = "";
    }
    c();
    a(paramAPPayResponse);
  }
  
  public void MidasPayNeedLogin()
  {
    APLog.i("h5distribut MidasPayNeedLogin", String.valueOf(a()));
    if (a())
    {
      try
      {
        ne.a(a, b, null);
        ne.a(c, APMidasDistributeActivity.b, null);
      }
      catch (Throwable localThrowable)
      {
        APLog.i("h5distribut MidasPayNeedLogin err", localThrowable.toString());
      }
      finish();
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("resultCode", this.R);
      localJSONObject.put("resultMsg", "login out");
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    a(localJSONObject.toString());
  }
  
  public boolean a()
  {
    try
    {
      Class localClass = Class.forName("com.tencent.midas.control.APMidasPayHelper");
      int i1 = ((Integer)localClass.getField("MIDAS_WEBVIEW").get(localClass)).intValue();
      return i1 == 0;
    }
    catch (Exception localException)
    {
      APLog.i("isInnerWebview", localException.toString());
    }
    return false;
  }
  
  public void b()
  {
    Object localObject3 = getIntent().getStringExtra("env");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("env = ");
    ((StringBuilder)localObject1).append((String)localObject3);
    APLog.i("APMidasH5DistributeActivity", ((StringBuilder)localObject1).toString());
    localObject1 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      localObject1 = "release";
    }
    localObject3 = getIntent().getStringExtra("version");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("midasplugin sdk version = ");
    localStringBuilder.append((String)localObject3);
    APLog.i("APMidasH5DistributeActivity", localStringBuilder.toString());
    APAndroidPayAPI.setEnv((String)localObject1);
    APAndroidPayAPI.setMidasPluginVersion((String)localObject3);
    try
    {
      this.g = ((ResultReceiver)getIntent().getExtras().get("remoteReceiver"));
    }
    catch (Exception localException1)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("get remoteReceiver err:");
      ((StringBuilder)localObject3).append(localException1.toString());
      APLog.i("APMidasH5DistributeActivity", ((StringBuilder)localObject3).toString());
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("get remoteReceiver :");
    ((StringBuilder)localObject2).append(this.g);
    APLog.i("APMidasH5DistributeActivity", ((StringBuilder)localObject2).toString());
    try
    {
      localObject2 = getIntent().getStringExtra("launchPayGUID");
      localObject3 = Long.valueOf(getIntent().getLongExtra("launchPayTime", 0L));
      int i1 = getIntent().getIntExtra("launchPayDataid", 0);
      int i2 = getIntent().getIntExtra("launchIntervalTime", 0);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("launchPayGUID");
      localStringBuilder.append((String)localObject2);
      APLog.i("paramsDistribute showFirstPageInsertDB=======", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("launchPayTime");
      localStringBuilder.append(localObject3);
      APLog.i("paramsDistribute showFirstPageInsertDB=======", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("launchPayDataid");
      localStringBuilder.append(i1);
      APLog.i("paramsDistribute showFirstPageInsertDB=======", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("launchIntervalTime");
      localStringBuilder.append((String)localObject2);
      APLog.i("paramsDistribute showFirstPageInsertDB=======", localStringBuilder.toString());
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        APPluginReportParams.getInstance().a(APTools.h());
      } else {
        APPluginReportParams.getInstance().a((String)localObject2);
      }
      if (((Long)localObject3).longValue() != 0L)
      {
        APPluginReportParams.getInstance().a(((Long)localObject3).longValue());
        int i3 = (int)(System.currentTimeMillis() - ((Long)localObject3).longValue());
        APPluginReportParams.getInstance().a(i3);
      }
      if (i1 != 0) {
        af.a(i1);
      }
      APPluginReportParams.getInstance().c(i2);
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    try
    {
      String str = getIntent().getStringExtra("message");
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("message:");
      ((StringBuilder)localObject3).append(str);
      APLog.i("APMidasH5DistributeActivity", ((StringBuilder)localObject3).toString());
      boolean bool = APMidasDistribute.isWSJ();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(bool);
      APLog.i("isWSJSDK", ((StringBuilder)localObject3).toString());
      if (bool) {
        this.o = str.substring(f.length(), str.length());
      } else {
        this.o = str.substring(e.length(), str.length());
      }
      APLog.i("dataJson", this.o);
      localObject3 = new JSONObject(this.o);
      str = ((JSONObject)localObject3).getString("func");
      localObject3 = new JSONObject(((JSONObject)localObject3).getString("params"));
      a((JSONObject)localObject3);
      a(str, (JSONObject)localObject3);
      return;
    }
    catch (Exception localException3)
    {
      localException3.printStackTrace();
      finish();
    }
  }
  
  public void c()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("APMidasDistributeActivity updateRemotReceiver =");
    ((StringBuilder)localObject).append(this.g);
    APLog.e("Midas", ((StringBuilder)localObject).toString());
    if (this.g != null)
    {
      localObject = new Bundle();
      this.g.send(0, (Bundle)localObject);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate savedInstanceState=");
    localStringBuilder.append(paramBundle);
    APLog.i("APMidasH5DistributeActivity", localStringBuilder.toString());
    super.onCreate(paramBundle);
    setRequestedOrientation(getResources().getConfiguration().orientation);
    if (paramBundle != null)
    {
      finish();
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.tencent.midas.pay.APMidasH5DistributeActivity
 * JD-Core Version:    0.7.0.1
 */