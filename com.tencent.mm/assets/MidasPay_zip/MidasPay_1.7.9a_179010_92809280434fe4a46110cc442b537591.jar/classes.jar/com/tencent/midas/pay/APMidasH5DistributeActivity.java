package com.tencent.midas.pay;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.pay.api.APAndroidPayAPI;
import com.pay.api.APPayResponse;
import com.pay.api.IAPNetCallBack;
import com.pay.api.IAPPayCallBack;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APExtendInfo;
import com.pay.api.request.APBaseRequest.APMPInfo;
import com.pay.api.request.APGameRequest;
import com.pay.api.request.APGoodsRequest;
import com.pay.api.request.APMonthRequest;
import com.pay.api.request.APNetRequest;
import com.pay.api.request.APSubscribeRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.data.report.APPluginReportParams;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APBase64;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginActivity;
import java.lang.reflect.Field;
import midas.x.d5;
import midas.x.g0;
import midas.x.o4;
import midas.x.p4;
import midas.x.s5;
import midas.x.vd;
import midas.x.z5;
import org.json.JSONException;
import org.json.JSONObject;

public class APMidasH5DistributeActivity
  extends APPluginActivity
  implements IAPPayCallBack
{
  public static String I = "com.pay.tool.APMidasCommMethod";
  public static String J = "popActivity";
  public static String K = "com.tencent.midas.control.APMidasPayHelper";
  public static String L = "midasH5CallBack";
  public static String M = "getVersion";
  public static String N = "payGame";
  public static String O = "payGoods";
  public static String P = "payMonth";
  public static String Q = "paySubscribe";
  public static String R = "payNet";
  public static String S = "midas_js_bridge_";
  public static String T = "WSJPay_js_bridge_";
  public static String U = "launchPaySign";
  public static String V = "launchUnionPay";
  public static String W = "checkUnionPayInstalled";
  public static String X = "launchPayScoreSign";
  public String A = "";
  public String B = "";
  public String C = "-1001";
  public String D = "-1002";
  public String E = "1018";
  public String F = "2";
  public Handler G = new Handler(new a());
  public boolean H = false;
  public ResultReceiver a = null;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  public String j = "";
  public String k = "";
  public boolean l = true;
  public int m = 0;
  public byte[] n = null;
  public String o = "";
  public String p = "";
  public String q = "";
  public int r = 0;
  public String s = "";
  public String t = "";
  public boolean u = true;
  public boolean v = true;
  public String w = "";
  public String x = "";
  public String y = "";
  public String z = "";
  
  /* Error */
  public void MidasPayCallBack(APPayResponse paramAPPayResponse)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield 187	com/tencent/midas/pay/APMidasH5DistributeActivity:H	Z
    //   5: new 198	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   12: astore_2
    //   13: aload_2
    //   14: ldc 201
    //   16: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: pop
    //   20: aload_2
    //   21: aload_1
    //   22: getfield 210	com/pay/api/APPayResponse:resultCode	I
    //   25: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: ldc 215
    //   31: aload_2
    //   32: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 224	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: new 226	org/json/JSONObject
    //   41: dup
    //   42: invokespecial 227	org/json/JSONObject:<init>	()V
    //   45: astore_2
    //   46: aload_2
    //   47: ldc 228
    //   49: aload_1
    //   50: getfield 210	com/pay/api/APPayResponse:resultCode	I
    //   53: invokevirtual 232	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   56: pop
    //   57: aload_2
    //   58: ldc 234
    //   60: aload_1
    //   61: getfield 236	com/pay/api/APPayResponse:resultMsg	Ljava/lang/String;
    //   64: invokevirtual 239	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   67: pop
    //   68: aload_2
    //   69: ldc 241
    //   71: aload_1
    //   72: getfield 243	com/pay/api/APPayResponse:resultInerCode	I
    //   75: invokevirtual 232	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   78: pop
    //   79: aload_2
    //   80: ldc 245
    //   82: aload_1
    //   83: getfield 247	com/pay/api/APPayResponse:realSaveNum	I
    //   86: invokevirtual 232	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   89: pop
    //   90: aload_2
    //   91: ldc 249
    //   93: aload_1
    //   94: getfield 251	com/pay/api/APPayResponse:payChannel	I
    //   97: invokevirtual 232	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   100: pop
    //   101: aload_2
    //   102: ldc 253
    //   104: aload_1
    //   105: getfield 255	com/pay/api/APPayResponse:payState	I
    //   108: invokevirtual 232	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   111: pop
    //   112: aload_2
    //   113: ldc_w 257
    //   116: aload_1
    //   117: getfield 259	com/pay/api/APPayResponse:provideState	I
    //   120: invokevirtual 232	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   123: pop
    //   124: aload_2
    //   125: ldc_w 261
    //   128: aload_1
    //   129: getfield 263	com/pay/api/APPayResponse:extendInfo	Ljava/lang/String;
    //   132: invokevirtual 239	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   135: pop
    //   136: aload_2
    //   137: ldc_w 265
    //   140: aload_1
    //   141: getfield 267	com/pay/api/APPayResponse:payReserve1	Ljava/lang/String;
    //   144: invokevirtual 239	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   147: pop
    //   148: aload_2
    //   149: ldc_w 269
    //   152: aload_1
    //   153: getfield 271	com/pay/api/APPayResponse:payReserve2	Ljava/lang/String;
    //   156: invokevirtual 239	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   159: pop
    //   160: aload_2
    //   161: ldc_w 273
    //   164: aload_1
    //   165: getfield 275	com/pay/api/APPayResponse:payReserve3	Ljava/lang/String;
    //   168: invokevirtual 239	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   171: pop
    //   172: new 198	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   179: astore_1
    //   180: aload_1
    //   181: ldc_w 277
    //   184: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload_1
    //   189: aload_2
    //   190: invokevirtual 278	org/json/JSONObject:toString	()Ljava/lang/String;
    //   193: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: ldc 215
    //   199: aload_1
    //   200: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 224	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   206: aload_2
    //   207: invokevirtual 278	org/json/JSONObject:toString	()Ljava/lang/String;
    //   210: astore_1
    //   211: goto +11 -> 222
    //   214: astore_1
    //   215: aload_1
    //   216: invokevirtual 283	java/lang/Throwable:printStackTrace	()V
    //   219: ldc 105
    //   221: astore_1
    //   222: aload_0
    //   223: invokevirtual 285	com/tencent/midas/pay/APMidasH5DistributeActivity:e	()V
    //   226: aload_0
    //   227: aload_1
    //   228: invokevirtual 193	com/tencent/midas/pay/APMidasH5DistributeActivity:a	(Ljava/lang/String;)V
    //   231: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	APMidasH5DistributeActivity
    //   0	232	1	paramAPPayResponse	APPayResponse
    //   12	195	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	211	214	finally
  }
  
  /* Error */
  public void MidasPayNeedLogin()
  {
    // Byte code:
    //   0: ldc_w 290
    //   3: aload_0
    //   4: invokevirtual 293	com/tencent/midas/pay/APMidasH5DistributeActivity:c	()Z
    //   7: invokestatic 299	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   10: invokestatic 224	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: aload_0
    //   14: invokevirtual 293	com/tencent/midas/pay/APMidasH5DistributeActivity:c	()Z
    //   17: ifeq +44 -> 61
    //   20: getstatic 301	com/tencent/midas/pay/APMidasH5DistributeActivity:I	Ljava/lang/String;
    //   23: getstatic 303	com/tencent/midas/pay/APMidasH5DistributeActivity:J	Ljava/lang/String;
    //   26: aconst_null
    //   27: invokestatic 308	midas/x/vd:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   30: pop
    //   31: getstatic 310	com/tencent/midas/pay/APMidasH5DistributeActivity:K	Ljava/lang/String;
    //   34: getstatic 313	com/tencent/midas/pay/APMidasDistributeActivity:c	Ljava/lang/String;
    //   37: aconst_null
    //   38: invokestatic 308	midas/x/vd:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   41: pop
    //   42: goto +14 -> 56
    //   45: astore_1
    //   46: ldc_w 315
    //   49: aload_1
    //   50: invokevirtual 316	java/lang/Throwable:toString	()Ljava/lang/String;
    //   53: invokestatic 224	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload_0
    //   57: invokevirtual 319	com/tencent/midas/plugin/APPluginActivity:finish	()V
    //   60: return
    //   61: new 226	org/json/JSONObject
    //   64: dup
    //   65: invokespecial 227	org/json/JSONObject:<init>	()V
    //   68: astore_1
    //   69: aload_1
    //   70: ldc 228
    //   72: aload_0
    //   73: getfield 171	com/tencent/midas/pay/APMidasH5DistributeActivity:E	Ljava/lang/String;
    //   76: invokevirtual 239	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   79: pop
    //   80: aload_1
    //   81: ldc 234
    //   83: ldc_w 321
    //   86: invokevirtual 239	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   89: pop
    //   90: goto +8 -> 98
    //   93: astore_2
    //   94: aload_2
    //   95: invokevirtual 322	org/json/JSONException:printStackTrace	()V
    //   98: aload_0
    //   99: aload_1
    //   100: invokevirtual 278	org/json/JSONObject:toString	()Ljava/lang/String;
    //   103: invokevirtual 193	com/tencent/midas/pay/APMidasH5DistributeActivity:a	(Ljava/lang/String;)V
    //   106: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	APMidasH5DistributeActivity
    //   45	5	1	localObject	Object
    //   68	32	1	localJSONObject	JSONObject
    //   93	2	2	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   20	42	45	finally
    //   69	90	93	org/json/JSONException
  }
  
  public final void a()
  {
    boolean bool = s5.a(getApplicationContext());
    String str = s5.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{'resultCode':'0','installed':'");
    localStringBuilder.append(bool);
    localStringBuilder.append("','version':'");
    localStringBuilder.append(str);
    localStringBuilder.append("','resultMsg':''}");
    a(localStringBuilder.toString());
  }
  
  public final void a(String paramString)
  {
    a(this.b, paramString);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    APLog.e("h5 callBack", paramString1);
    try
    {
      paramString1 = APMidasDistribute.buildCallBackInfo(paramString1, paramString2);
      if (this.a != null)
      {
        paramString2 = new Bundle();
        paramString2.putString("type", "h5callback");
        paramString2.putString("callbackinfo", paramString1);
        this.a.send(0, paramString2);
      }
      else
      {
        vd.a(K, L, new Object[] { paramString1 });
      }
    }
    finally
    {
      paramString2 = new StringBuilder();
      paramString2.append("getCallBackInfo error:");
      paramString2.append(paramString1.toString());
      APLog.w("APMidasH5DistributeActivity", paramString2.toString());
      paramString1.printStackTrace();
    }
    finish();
  }
  
  public final void a(String paramString, JSONObject paramJSONObject)
  {
    if (M.equals(paramString))
    {
      b();
      return;
    }
    if (N.equals(paramString))
    {
      e(paramJSONObject);
      return;
    }
    if (O.equals(paramString))
    {
      f(paramJSONObject);
      return;
    }
    if (Q.equals(paramString))
    {
      i(paramJSONObject);
      return;
    }
    if (P.equals(paramString))
    {
      g(paramJSONObject);
      return;
    }
    if (R.equals(paramString))
    {
      h(paramJSONObject);
      return;
    }
    if (U.equals(paramString))
    {
      paramString = new StringBuilder();
      paramString.append("");
      paramString.append(paramJSONObject.toString());
      APLog.d("FUNC_WECHAT_SIGNED", paramString.toString());
      c(paramJSONObject);
      return;
    }
    if (V.equals(paramString))
    {
      paramString = new StringBuilder();
      paramString.append("");
      paramString.append(paramJSONObject.toString());
      APLog.d("FUNC_UNION_PAY", paramString.toString());
      b(paramJSONObject);
      return;
    }
    if (W.equals(paramString))
    {
      a();
      return;
    }
    if (X.equals(paramString))
    {
      a(paramJSONObject);
      return;
    }
    paramString = new JSONObject();
    try
    {
      paramString.put("resultCode", this.C);
      paramString.put("resultMsg", "version not support");
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    a(paramString.toString());
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    this.H = true;
    APAndroidPayAPI.launchPayScoreSign(this, paramJSONObject, this);
  }
  
  public final void b()
  {
    a("{'resultCode':'0','version':'1.7.9a','resultMsg':''}");
  }
  
  public final void b(JSONObject paramJSONObject)
  {
    APAndroidPayAPI.launchUnionPay(this, paramJSONObject, this);
  }
  
  public final void c(JSONObject paramJSONObject)
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
  
  public boolean c()
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
  
  public void d()
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
      this.a = ((ResultReceiver)getIntent().getExtras().get("remoteReceiver"));
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
    ((StringBuilder)localObject2).append(this.a);
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
        APPluginReportParams.getInstance().a(APTools.j());
      } else {
        APPluginReportParams.getInstance().a((String)localObject2);
      }
      if (((Long)localObject3).longValue() != 0L)
      {
        APPluginReportParams.getInstance().a(((Long)localObject3).longValue());
        int i3 = (int)(System.currentTimeMillis() - ((Long)localObject3).longValue());
        APPluginReportParams.getInstance().c(i3);
      }
      if (i1 != 0) {
        g0.a(i1);
      }
      APPluginReportParams.getInstance().a(i2);
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
        this.b = str.substring(T.length(), str.length());
      } else {
        this.b = str.substring(S.length(), str.length());
      }
      APLog.i("dataJson", this.b);
      localObject3 = new JSONObject(this.b);
      str = ((JSONObject)localObject3).getString("func");
      localObject3 = new JSONObject(((JSONObject)localObject3).getString("params"));
      d((JSONObject)localObject3);
      a(str, (JSONObject)localObject3);
      return;
    }
    catch (Exception localException3)
    {
      localException3.printStackTrace();
      finish();
    }
  }
  
  public final void d(JSONObject paramJSONObject)
  {
    this.c = "";
    this.d = "";
    this.e = "";
    this.f = "";
    this.g = "";
    this.h = "";
    this.i = "";
    this.j = "";
    this.k = "";
    this.l = true;
    this.m = 0;
    this.n = null;
    this.o = "";
    this.p = "";
    this.q = "";
    this.r = 0;
    this.s = "";
    this.t = "";
    this.u = true;
    this.v = true;
    this.w = "";
    this.x = "";
    this.y = "";
    this.z = "";
    this.A = "";
    this.B = "";
    try
    {
      if (paramJSONObject.has("offerId")) {
        this.c = paramJSONObject.getString("offerId");
      }
      if (paramJSONObject.has("openId")) {
        this.d = paramJSONObject.getString("openId");
      }
      if (paramJSONObject.has("openKey")) {
        this.e = paramJSONObject.getString("openKey");
      }
      if (paramJSONObject.has("sessionId")) {
        this.f = paramJSONObject.getString("sessionId");
      }
      if (paramJSONObject.has("sessionType")) {
        this.g = paramJSONObject.getString("sessionType");
      }
      if (paramJSONObject.has("zoneId")) {
        this.h = paramJSONObject.getString("zoneId");
      }
      if (paramJSONObject.has("pf")) {
        this.i = paramJSONObject.getString("pf");
      }
      if (paramJSONObject.has("pfKey")) {
        this.j = paramJSONObject.getString("pfKey");
      }
      if (paramJSONObject.has("saveValue")) {
        this.k = paramJSONObject.getString("saveValue");
      }
      if (paramJSONObject.has("isCanChange")) {
        this.l = paramJSONObject.getBoolean("isCanChange");
      }
      if (paramJSONObject.has("remark")) {
        this.p = paramJSONObject.optString("remark");
      }
      if (paramJSONObject.has("resId")) {
        this.m = paramJSONObject.getInt("resId");
      }
      if (paramJSONObject.has("resData"))
      {
        String str = paramJSONObject.getString("resData");
        if (!TextUtils.isEmpty(str)) {
          this.n = APBase64.decode(str);
        }
      }
      if (paramJSONObject.has("acctType")) {
        this.o = paramJSONObject.getString("acctType");
      }
      if (paramJSONObject.has("reserv")) {
        this.q = paramJSONObject.getString("reserv");
      }
      if (paramJSONObject.has("mallType")) {
        this.r = paramJSONObject.getInt("mallType");
      }
      if (paramJSONObject.has("h5Url")) {
        this.s = paramJSONObject.getString("h5Url");
      }
      if (paramJSONObject.has("unit")) {
        this.t = paramJSONObject.getString("unit");
      }
      if (paramJSONObject.has("isShowNum")) {
        this.u = paramJSONObject.getBoolean("isShowNum");
      }
      if (paramJSONObject.has("isShowListOtherNum")) {
        this.v = paramJSONObject.getBoolean("isShowListOtherNum");
      }
      if (paramJSONObject.has("payChannel")) {
        this.w = paramJSONObject.getString("payChannel");
      }
      if (paramJSONObject.has("discountType")) {
        this.x = paramJSONObject.getString("discountType");
      }
      if (paramJSONObject.has("discountUrl")) {
        this.y = paramJSONObject.getString("discountUrl");
      }
      if (paramJSONObject.has("drmInfo")) {
        this.z = paramJSONObject.getString("drmInfo");
      }
      if (paramJSONObject.has("discoutId")) {
        this.A = paramJSONObject.getString("discoutId");
      }
      if (paramJSONObject.has("extras"))
      {
        this.B = paramJSONObject.getString("extras");
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      APLog.w("APMidasH5Distribute", paramJSONObject.toString());
      paramJSONObject.printStackTrace();
    }
  }
  
  public void e()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("APMidasDistributeActivity updateRemotReceiver =");
    ((StringBuilder)localObject).append(this.a);
    APLog.e("Midas", ((StringBuilder)localObject).toString());
    if (this.a != null)
    {
      localObject = new Bundle();
      this.a.send(0, (Bundle)localObject);
    }
  }
  
  public final void e(JSONObject paramJSONObject)
  {
    paramJSONObject = new APGameRequest();
    paramJSONObject.offerId = this.c;
    paramJSONObject.openId = this.d;
    paramJSONObject.openKey = this.e;
    paramJSONObject.sessionId = this.f;
    paramJSONObject.sessionType = this.g;
    paramJSONObject.zoneId = this.h;
    paramJSONObject.pf = this.i;
    paramJSONObject.pfKey = this.j;
    paramJSONObject.acctType = this.o;
    paramJSONObject.saveValue = this.k;
    paramJSONObject.isCanChange = this.l;
    paramJSONObject.resId = this.m;
    paramJSONObject.resData = this.n;
    paramJSONObject.reserv = this.q;
    paramJSONObject.remark = this.p;
    paramJSONObject.mallType = this.r;
    paramJSONObject.h5Url = this.s;
    Object localObject = paramJSONObject.extendInfo;
    ((APBaseRequest.APExtendInfo)localObject).unit = this.t;
    ((APBaseRequest.APExtendInfo)localObject).isShowNum = this.u;
    ((APBaseRequest.APExtendInfo)localObject).isShowListOtherNum = this.v;
    localObject = paramJSONObject.mpInfo;
    ((APBaseRequest.APMPInfo)localObject).payChannel = this.w;
    ((APBaseRequest.APMPInfo)localObject).discountType = this.x;
    ((APBaseRequest.APMPInfo)localObject).discountUrl = this.y;
    ((APBaseRequest.APMPInfo)localObject).discoutId = this.A;
    ((APBaseRequest.APMPInfo)localObject).drmInfo = this.z;
    ((APBaseRequest.APMPInfo)localObject).extras = this.B;
    APAndroidPayAPI.launchPay(this, paramJSONObject, this);
  }
  
  public final void f(JSONObject paramJSONObject)
  {
    APGoodsRequest localAPGoodsRequest = new APGoodsRequest();
    localAPGoodsRequest.offerId = this.c;
    localAPGoodsRequest.openId = this.d;
    localAPGoodsRequest.openKey = this.e;
    localAPGoodsRequest.sessionId = this.f;
    localAPGoodsRequest.sessionType = this.g;
    localAPGoodsRequest.zoneId = this.h;
    localAPGoodsRequest.pf = this.i;
    localAPGoodsRequest.pfKey = this.j;
    localAPGoodsRequest.acctType = this.o;
    localAPGoodsRequest.saveValue = this.k;
    localAPGoodsRequest.isCanChange = this.l;
    localAPGoodsRequest.resId = this.m;
    localAPGoodsRequest.resData = this.n;
    localAPGoodsRequest.remark = this.p;
    localAPGoodsRequest.reserv = this.q;
    localAPGoodsRequest.mallType = this.r;
    localAPGoodsRequest.h5Url = this.s;
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
    paramJSONObject = localAPGoodsRequest.extendInfo;
    paramJSONObject.unit = this.t;
    paramJSONObject.isShowNum = this.u;
    paramJSONObject.isShowListOtherNum = this.v;
    paramJSONObject = localAPGoodsRequest.mpInfo;
    paramJSONObject.payChannel = this.w;
    paramJSONObject.discountType = this.x;
    paramJSONObject.discountUrl = this.y;
    paramJSONObject.discoutId = this.A;
    paramJSONObject.drmInfo = this.z;
    paramJSONObject.extras = this.B;
    APAndroidPayAPI.launchPay(this, localAPGoodsRequest, this);
  }
  
  public final void g(JSONObject paramJSONObject)
  {
    APMonthRequest localAPMonthRequest = new APMonthRequest();
    localAPMonthRequest.offerId = this.c;
    localAPMonthRequest.openId = this.d;
    localAPMonthRequest.openKey = this.e;
    localAPMonthRequest.sessionId = this.f;
    localAPMonthRequest.sessionType = this.g;
    localAPMonthRequest.zoneId = this.h;
    localAPMonthRequest.pf = this.i;
    localAPMonthRequest.pfKey = this.j;
    localAPMonthRequest.acctType = this.o;
    localAPMonthRequest.saveValue = this.k;
    localAPMonthRequest.isCanChange = this.l;
    localAPMonthRequest.resId = this.m;
    localAPMonthRequest.resData = this.n;
    localAPMonthRequest.remark = this.p;
    localAPMonthRequest.reserv = this.q;
    localAPMonthRequest.mallType = this.r;
    localAPMonthRequest.h5Url = this.s;
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
    paramJSONObject = localAPMonthRequest.extendInfo;
    paramJSONObject.unit = this.t;
    paramJSONObject.isShowNum = this.u;
    paramJSONObject.isShowListOtherNum = this.v;
    paramJSONObject = localAPMonthRequest.mpInfo;
    paramJSONObject.payChannel = this.w;
    paramJSONObject.discountType = this.x;
    paramJSONObject.discountUrl = this.y;
    paramJSONObject.discoutId = this.A;
    paramJSONObject.drmInfo = this.z;
    paramJSONObject.extras = this.B;
    APAndroidPayAPI.launchPay(this, localAPMonthRequest, this);
  }
  
  public final void h(JSONObject paramJSONObject)
  {
    APNetRequest localAPNetRequest = new APNetRequest();
    localAPNetRequest.offerId = this.c;
    localAPNetRequest.openId = this.d;
    localAPNetRequest.openKey = this.e;
    localAPNetRequest.sessionId = this.f;
    localAPNetRequest.sessionType = this.g;
    localAPNetRequest.zoneId = this.h;
    localAPNetRequest.pf = this.i;
    localAPNetRequest.pfKey = this.j;
    localAPNetRequest.acctType = this.o;
    localAPNetRequest.saveValue = this.k;
    localAPNetRequest.isCanChange = this.l;
    localAPNetRequest.resId = this.m;
    localAPNetRequest.resData = this.n;
    localAPNetRequest.remark = this.p;
    localAPNetRequest.reserv = this.q;
    localAPNetRequest.mallType = this.r;
    localAPNetRequest.h5Url = this.s;
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
    paramJSONObject = localAPNetRequest.extendInfo;
    paramJSONObject.unit = this.t;
    paramJSONObject.isShowNum = this.u;
    paramJSONObject.isShowListOtherNum = this.v;
    paramJSONObject = localAPNetRequest.mpInfo;
    paramJSONObject.payChannel = this.w;
    paramJSONObject.discountType = this.x;
    paramJSONObject.discountUrl = this.y;
    paramJSONObject.discoutId = this.A;
    paramJSONObject.drmInfo = this.z;
    paramJSONObject.extras = this.B;
    APAndroidPayAPI.launchNet(this, localAPNetRequest, new b());
  }
  
  public final void i(JSONObject paramJSONObject)
  {
    APSubscribeRequest localAPSubscribeRequest = new APSubscribeRequest();
    localAPSubscribeRequest.offerId = this.c;
    localAPSubscribeRequest.openId = this.d;
    localAPSubscribeRequest.openKey = this.e;
    localAPSubscribeRequest.sessionId = this.f;
    localAPSubscribeRequest.sessionType = this.g;
    localAPSubscribeRequest.zoneId = this.h;
    localAPSubscribeRequest.pf = this.i;
    localAPSubscribeRequest.pfKey = this.j;
    localAPSubscribeRequest.acctType = this.o;
    localAPSubscribeRequest.saveValue = this.k;
    localAPSubscribeRequest.isCanChange = this.l;
    localAPSubscribeRequest.resId = this.m;
    localAPSubscribeRequest.resData = this.n;
    localAPSubscribeRequest.remark = this.p;
    localAPSubscribeRequest.reserv = this.q;
    localAPSubscribeRequest.mallType = this.r;
    localAPSubscribeRequest.h5Url = this.s;
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
    paramJSONObject = localAPSubscribeRequest.extendInfo;
    paramJSONObject.unit = this.t;
    paramJSONObject.isShowNum = this.u;
    paramJSONObject.isShowListOtherNum = this.v;
    paramJSONObject = localAPSubscribeRequest.mpInfo;
    paramJSONObject.payChannel = this.w;
    paramJSONObject.discountType = this.x;
    paramJSONObject.discountUrl = this.y;
    paramJSONObject.discoutId = this.A;
    paramJSONObject.drmInfo = this.z;
    paramJSONObject.extras = this.B;
    APAndroidPayAPI.launchPay(this, localAPSubscribeRequest, this);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str = "支付失败！";
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {
      return;
    }
    APPayResponse localAPPayResponse = new APPayResponse();
    try
    {
      paramIntent = paramIntent.getExtras().getString("pay_result");
      if (paramIntent.equalsIgnoreCase("success"))
      {
        localAPPayResponse.resultCode = 0;
        paramIntent = "支付成功！";
      }
      else if (paramIntent.equalsIgnoreCase("fail"))
      {
        localAPPayResponse.resultCode = -1;
        paramIntent = str;
      }
      else if (paramIntent.equalsIgnoreCase("cancel"))
      {
        localAPPayResponse.resultCode = 2;
        paramIntent = "用户取消了支付";
      }
      else
      {
        paramIntent = "";
      }
    }
    catch (Exception paramIntent)
    {
      label153:
      break label153;
    }
    try
    {
      APDataReportManager.getInstance().insertData("sdk.unionpaycallback", p4.p().e().b.saveType, p4.p().e().f.l, String.valueOf(localAPPayResponse.resultCode), null);
    }
    catch (Exception localException)
    {
      break label162;
    }
    localAPPayResponse.resultCode = -1;
    paramIntent = str;
    label162:
    localAPPayResponse.resultMsg = paramIntent;
    localAPPayResponse.payChannel = 20;
    localAPPayResponse.extendInfo = "launchUnionPay";
    MidasPayCallBack(localAPPayResponse);
  }
  
  public void onCreate(Bundle paramBundle)
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
    d();
  }
  
  public void onPause()
  {
    super.onPause();
    this.G.removeMessages(1001);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.H) {
      this.G.sendEmptyMessageDelayed(1001, 1000L);
    }
  }
  
  public class a
    implements Handler.Callback
  {
    public a() {}
    
    public boolean handleMessage(Message paramMessage)
    {
      APMidasH5DistributeActivity.a(APMidasH5DistributeActivity.this, false);
      if (paramMessage.what == 1001) {
        z5.a(-1, "签约状态未知！");
      }
      return false;
    }
  }
  
  public class b
    implements IAPNetCallBack
  {
    public b() {}
    
    public void MidasNetError(String paramString1, int paramInt, String paramString2)
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramInt);
      paramString1.append(":");
      paramString1.append(paramString2);
      APLog.d("APMidash5Distribute", paramString1.toString());
      paramString1 = new JSONObject();
      try
      {
        paramString1.put("resultCode", APMidasH5DistributeActivity.b(APMidasH5DistributeActivity.this));
        paramString1.put("resultMsg", "network error");
      }
      catch (JSONException paramString2)
      {
        paramString2.printStackTrace();
      }
      APMidasH5DistributeActivity.a(APMidasH5DistributeActivity.this, paramString1.toString());
    }
    
    public void MidasNetFinish(String paramString1, String paramString2)
    {
      if (APMidasH5DistributeActivity.this.c()) {}
      try
      {
        paramString1 = new JSONObject(paramString2);
        if (paramString1.has("ret"))
        {
          int i = paramString1.getInt("ret");
          if (i == 1018)
          {
            try
            {
              vd.a(APMidasH5DistributeActivity.I, APMidasH5DistributeActivity.J, null);
              vd.a(APMidasH5DistributeActivity.K, APMidasDistributeActivity.c, null);
            }
            catch (Exception paramString1)
            {
              APLog.i("h5distribut MidasPayNeedLogin err", paramString1.toString());
            }
            APMidasH5DistributeActivity.this.finish();
            return;
          }
        }
      }
      catch (Exception paramString1)
      {
        label85:
        break label85;
      }
      APLog.d("APMidash5Distribute MidasNetFinish", paramString2);
      APMidasH5DistributeActivity.a(APMidasH5DistributeActivity.this, paramString2);
    }
    
    public void MidasNetStop(String paramString)
    {
      APLog.d("APMidash5Distribute", "MidasMPStop");
      paramString = new JSONObject();
      try
      {
        paramString.put("resultCode", APMidasH5DistributeActivity.a(APMidasH5DistributeActivity.this));
        paramString.put("resultMsg", "user cancel");
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      APMidasH5DistributeActivity.a(APMidasH5DistributeActivity.this, paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.tencent.midas.pay.APMidasH5DistributeActivity
 * JD-Core Version:    0.7.0.1
 */