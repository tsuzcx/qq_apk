package midas.x;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.Toast;
import com.pay.api.APPayResponse;
import com.pay.api.IAPPayCallBack;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APGoodsRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APBeanUtil;
import com.tencent.midas.comm.APLog;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class h1
{
  public static final String t = "h1";
  public static final int[] u = { 5, 10, 30 };
  public static String v = "com.tencent.midas.control.APMidasPayHelper";
  public static String w = "midasLoginExpire";
  public static String x = "midasCallBack";
  public static String y = "com.tencent.midas.api.APMidasResponse";
  public static volatile h1 z = null;
  public APBaseRequest a;
  public String b;
  public Activity c;
  public boolean d = false;
  public String e = null;
  public String f = null;
  public String g;
  public String h;
  public String i = "";
  public IAPPayCallBack j;
  public boolean k = true;
  public i1 l;
  public i1 m;
  public boolean n = false;
  public String o = "TVPay_TV_Android_6.0.2";
  public int p = 0;
  public u q = new u(this);
  public e1.b r = new k();
  public k1 s = new l();
  
  public static String a(Context paramContext, String paramString)
    throws IllegalArgumentException
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.os.SystemProperties");
      paramContext = (String)paramContext.getMethod("get", new Class[] { String.class }).invoke(paramContext, new Object[] { new String(paramString) });
      return paramContext;
    }
    catch (IllegalArgumentException paramContext)
    {
      throw paramContext;
    }
    catch (Exception paramContext)
    {
      label50:
      break label50;
    }
    return "";
  }
  
  public static Map<String, String> c(String paramString)
  {
    HashMap localHashMap = new HashMap();
    paramString = paramString.split("[&]");
    int i2 = paramString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      String[] arrayOfString = paramString[i1].split("[=]");
      if (arrayOfString.length > 1) {
        localHashMap.put(arrayOfString[0], arrayOfString[1]);
      } else if (TextUtils.isEmpty(arrayOfString[0])) {
        localHashMap.put(arrayOfString[0], "");
      }
      i1 += 1;
    }
    return localHashMap;
  }
  
  public static h1 v()
  {
    if (z == null) {
      try
      {
        if (z == null) {
          z = new h1();
        }
      }
      finally {}
    }
    return z;
  }
  
  public int a(Activity paramActivity, APBaseRequest paramAPBaseRequest, IAPPayCallBack paramIAPPayCallBack)
  {
    this.n = false;
    this.c = paramActivity;
    this.j = paramIAPPayCallBack;
    this.k = false;
    this.e = APTools.j();
    this.a = paramAPBaseRequest;
    APDataReportManager.getInstance().insertData("sdk.tv.pay.click", 0, null, null, i());
    f1.d().a(paramActivity, "1.7.9a");
    this.b = a(paramAPBaseRequest);
    if (TextUtils.isEmpty(this.b))
    {
      Toast.makeText(paramActivity, "订单信息错误", 1).show();
      APDataReportManager.getInstance().insertData("sdk.tv.order.error", -1, null, null, i());
      return 5;
    }
    APDataReportManager.getInstance().insertData("sdk.tv.paying.show", -1, null, null, i());
    r();
    paramIAPPayCallBack = APDataReportManager.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i());
    localStringBuilder.append("&");
    localStringBuilder.append(0);
    paramIAPPayCallBack.insertData("sdk.tv.apphook.success", 0, null, null, localStringBuilder.toString());
    e1.e().a("tv", this.o, this.e, g(), this.r);
    e1.e().a(3);
    e1.e().c();
    f1.d().a(paramAPBaseRequest);
    f1.d().b(paramActivity, this.b, this.e, this.f, this.s);
    return 0;
  }
  
  public final String a(APBaseRequest paramAPBaseRequest)
  {
    Object localObject = h();
    String str = t;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("info:");
    localStringBuilder.append((String)localObject);
    APLog.i(str, localStringBuilder.toString());
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return "";
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      this.f = ((JSONObject)localObject).getString("u");
      this.i = ((JSONObject)localObject).getString("c");
      this.h = ((JSONObject)localObject).getString("v");
      this.g = ((JSONObject)localObject).getString("k");
      this.d = false;
      if (((paramAPBaseRequest instanceof APGoodsRequest)) && (((APGoodsRequest)paramAPBaseRequest).tokenType == 1)) {
        this.d = true;
      }
      paramAPBaseRequest = a(paramAPBaseRequest, this.e, this.g);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("手机端的UUID");
      ((StringBuilder)localObject).append(this.f);
      APLog.i("APSyncOrderReq", ((StringBuilder)localObject).toString());
      return paramAPBaseRequest;
    }
    catch (JSONException paramAPBaseRequest)
    {
      paramAPBaseRequest.printStackTrace();
    }
    return "";
  }
  
  public final String a(APBaseRequest paramAPBaseRequest, String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cmd", "send_order");
      paramAPBaseRequest = paramAPBaseRequest.toJson();
      paramAPBaseRequest.put("tvUUID", paramString1);
      paramAPBaseRequest.put("version", "1.7.9a");
      paramAPBaseRequest.put("mbUUID", this.f);
      localJSONObject.put("msg", paramAPBaseRequest);
      paramAPBaseRequest = localJSONObject.toString();
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append(paramAPBaseRequest);
      paramString1.append(paramString2);
      paramString1 = g.b(paramString1.toString().getBytes());
      String str = t;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("msg:");
      localStringBuilder.append(paramAPBaseRequest);
      localStringBuilder.append(",key:");
      localStringBuilder.append(paramString2);
      APLog.i(str, localStringBuilder.toString());
      paramAPBaseRequest = new StringBuilder();
      paramAPBaseRequest.append(localJSONObject.toString());
      paramAPBaseRequest.append(paramString1);
      paramAPBaseRequest = paramAPBaseRequest.toString();
      return paramAPBaseRequest;
    }
    catch (JSONException paramAPBaseRequest)
    {
      paramAPBaseRequest.printStackTrace();
    }
    return "";
  }
  
  public final void a(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      APDataReportManager.getInstance().insertData("sdk.tv.order.send.succ.show", -1, null, null, i());
      paramString = this.l;
      if ((paramString != null) && (paramString.isShowing())) {
        this.l.a("订单已推送到手机，请在手机上完成支付");
      }
      e1.e().a(0);
      e1.e().c();
      return;
    }
    if (paramInt == 1)
    {
      APDataReportManager.getInstance().insertData("sdk.tv.order.parse.error.show", -1, null, null, i());
      if (!this.n)
      {
        a(paramString, this.c, new m());
        return;
      }
      APDataReportManager.getInstance().insertData("sdk.tv.order.parse.error.sure", -1, null, null, i());
      v().a(null, "订单异常，请重试");
      return;
    }
    paramString = APDataReportManager.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i());
    localStringBuilder.append("&");
    localStringBuilder.append(paramInt);
    paramString.insertData("sdk.tv.order.send.unknow.error.tip", -1, null, null, localStringBuilder.toString());
    v().a(null, "支付异常");
  }
  
  public final void a(APPayResponse paramAPPayResponse)
  {
    try
    {
      Object localObject = g1.a(y);
      try
      {
        APBeanUtil.copyProperties(paramAPPayResponse, localObject);
        g1.a(v, x, new Object[] { localObject });
        return;
      }
      catch (Exception paramAPPayResponse)
      {
        paramAPPayResponse.printStackTrace();
        return;
      }
      return;
    }
    catch (Exception paramAPPayResponse)
    {
      paramAPPayResponse.printStackTrace();
    }
  }
  
  public final void a(String paramString)
  {
    j1 localj1 = new j1();
    try
    {
      localj1.a(new JSONObject(paramString));
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    paramString = t;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("充值结果:");
    localStringBuilder.append(localj1.a);
    APLog.i(paramString, localStringBuilder.toString());
    int i1 = p4.p().e().b.saveType;
    paramString = APDataReportManager.getInstance();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(i());
    localStringBuilder.append("&");
    localStringBuilder.append(localj1.a);
    paramString.insertData("sdk.tv.result.mobile", i1, null, null, localStringBuilder.toString());
    if (this.k) {
      return;
    }
    i1 = localj1.a;
    if (i1 == 2)
    {
      v().a(localj1, "支付取消");
      return;
    }
    if (i1 == -1)
    {
      v().a(localj1, "支付异常");
      return;
    }
    if (i1 == 0)
    {
      APLog.i(t, "充值成功");
      v().a(localj1, "支付成功");
      return;
    }
    if (i1 == 3)
    {
      v().a(localj1, "支付参数错误");
      return;
    }
    v().a(localj1, "支付异常");
  }
  
  public final void a(String paramString, Context paramContext, final t paramt)
  {
    paramContext = new i1.a(paramContext);
    paramContext.b("提示");
    paramContext.a(paramString);
    paramContext.a(2131034256);
    paramContext.b("确定", new e(paramt));
    paramString = paramContext.a();
    if (paramString == null) {
      return;
    }
    paramString.setCancelable(false);
    paramString.setOnKeyListener(new f(paramt));
    try
    {
      paramString.show();
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void a(j1 paramj1, String paramString)
  {
    paramString = new APPayResponse();
    if (paramj1 == null)
    {
      paramString.resultCode = 5;
      paramString.realSaveNum = 0;
      paramString.payState = -1;
      paramString.provideState = -1;
    }
    else
    {
      paramString.resultCode = paramj1.a;
      paramString.realSaveNum = paramj1.c;
      paramString.payState = paramj1.e;
      paramString.provideState = paramj1.f;
      paramString.payChannel = paramj1.d;
      paramString.resultMsg = paramj1.g;
      paramString.extendInfo = paramj1.h;
      paramString.resultInerCode = paramj1.b;
      paramString.payReserve1 = paramj1.i;
      paramString.payReserve2 = paramj1.j;
      paramString.payReserve3 = paramj1.k;
    }
    d();
    if (!this.n)
    {
      e();
      int i1 = paramString.resultCode;
      if (i1 != 0)
      {
        if (i1 != 2)
        {
          APDataReportManager.getInstance().insertData("sdk.tv.error.show", -1, null, null, i());
          c(paramString);
          return;
        }
        APDataReportManager.getInstance().insertData("sdk.tv.result.cancel", -1, null, null, i());
        APUICommonMethod.a(this.c, "支付已取消");
        b(paramString);
        return;
      }
      APDataReportManager.getInstance().insertData("sdk.tv.success.show", -1, null, null, i());
      d(paramString);
      return;
    }
    APDataReportManager.getInstance().insertData("sdk.tv.error.sure", -1, null, null, i());
    b(paramString);
    a(paramString);
  }
  
  public boolean a()
  {
    Object localObject = (ConnectivityManager)this.c.getSystemService("connectivity");
    if (localObject == null) {
      return false;
    }
    localObject = ((ConnectivityManager)localObject).getAllNetworkInfo();
    if (localObject != null)
    {
      int i1 = 0;
      while (i1 < localObject.length)
      {
        if (localObject[i1].getState() == NetworkInfo.State.CONNECTED) {
          return true;
        }
        i1 += 1;
      }
    }
    return false;
  }
  
  public boolean a(Activity paramActivity)
  {
    return a(paramActivity, "paymode").startsWith("tenbox_");
  }
  
  public final void b()
  {
    try
    {
      g1.a(v, w, null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(Activity paramActivity)
  {
    APDataReportManager.getInstance().insertData("sdk.tv.paired.error.show", -1, null, null, i());
    paramActivity = new i1.a(paramActivity);
    paramActivity.b("配对提示");
    paramActivity.a("配对信息错误，请重新配对");
    paramActivity.a(2131034255);
    paramActivity.b("确定", new c());
    paramActivity = paramActivity.a();
    if (paramActivity != null)
    {
      paramActivity.setCancelable(false);
      paramActivity.setOnKeyListener(new d());
    }
    try
    {
      paramActivity.show();
      return;
    }
    catch (Exception paramActivity) {}
  }
  
  public final void b(APPayResponse paramAPPayResponse)
  {
    APPayResponse localAPPayResponse = paramAPPayResponse;
    if (paramAPPayResponse == null)
    {
      localAPPayResponse = new APPayResponse();
      localAPPayResponse.resultCode = 5;
      localAPPayResponse.realSaveNum = 0;
      localAPPayResponse.payState = -1;
      localAPPayResponse.provideState = -1;
    }
    paramAPPayResponse = this.j;
    if (paramAPPayResponse != null)
    {
      paramAPPayResponse.MidasPayCallBack(localAPPayResponse);
      this.j = null;
      this.k = true;
    }
    f();
  }
  
  public final void c(final APPayResponse paramAPPayResponse)
  {
    Object localObject = new i1.a(this.c);
    ((i1.a)localObject).b("支付异常");
    ((i1.a)localObject).a("请稍候再试");
    ((i1.a)localObject).a(2131034256);
    ((i1.a)localObject).b("确定", new g(paramAPPayResponse));
    localObject = ((i1.a)localObject).a();
    if (localObject != null)
    {
      ((Dialog)localObject).setCancelable(false);
      ((Dialog)localObject).setOnKeyListener(new h(paramAPPayResponse));
    }
    try
    {
      ((Dialog)localObject).show();
      return;
    }
    catch (Exception paramAPPayResponse) {}
  }
  
  public boolean c()
  {
    Object localObject = h();
    APLog.i(t, (String)localObject);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return false;
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      this.f = ((JSONObject)localObject).getString("u");
      this.i = ((JSONObject)localObject).getString("c");
      this.h = ((JSONObject)localObject).getString("v");
      this.g = ((JSONObject)localObject).getString("k");
      if ((!TextUtils.isEmpty(this.f)) && (!TextUtils.isEmpty(this.i)) && (!TextUtils.isEmpty(this.h)))
      {
        if (TextUtils.isEmpty(this.g)) {
          return false;
        }
        return this.i.equalsIgnoreCase("A");
      }
      return false;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return false;
  }
  
  public final void d()
  {
    e1.e().d();
    this.q.removeMessages(1);
  }
  
  public final void d(final APPayResponse paramAPPayResponse)
  {
    Object localObject = new i1.a(this.c);
    ((i1.a)localObject).b("支付成功");
    ((i1.a)localObject).a("快去继续游戏吧:)");
    ((i1.a)localObject).a(2131034253);
    ((i1.a)localObject).b("确定", new i(paramAPPayResponse));
    localObject = ((i1.a)localObject).a();
    if (localObject != null)
    {
      ((Dialog)localObject).setCancelable(false);
      ((Dialog)localObject).setOnKeyListener(new j(paramAPPayResponse));
    }
    try
    {
      ((Dialog)localObject).show();
      return;
    }
    catch (Exception paramAPPayResponse) {}
  }
  
  public final void e()
  {
    if (this.l != null)
    {
      APDataReportManager.getInstance().insertData("sdk.tv.paying.close", -1, null, null, i());
      this.l.dismiss();
    }
    if (this.m != null)
    {
      APDataReportManager.getInstance().insertData("sdk.tv.result.back.finish", -1, null, null, i());
      this.m.dismiss();
    }
  }
  
  public final void f()
  {
    z1.d().b();
  }
  
  public String g()
  {
    return APAppDataInterface.singleton().h();
  }
  
  public String h()
  {
    return a(this.c, "qqpay_UUID");
  }
  
  public final String i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.e);
    localStringBuilder.append("&");
    localStringBuilder.append(this.f);
    return localStringBuilder.toString();
  }
  
  public final void j()
  {
    APDataReportManager.getInstance().insertData("sdk.tv.install.show", -1, null, null, i());
    e1.e().d();
    e1.e().a(0);
    e1.e().c();
  }
  
  public boolean k()
  {
    return this.d;
  }
  
  public void l()
  {
    if (!this.n)
    {
      APDataReportManager.getInstance().insertData("sdk.tv.login.error.show", -1, null, null, i());
      a("用户登录状态失效，请重新登录", this.c, new o());
    }
    else
    {
      APDataReportManager.getInstance().insertData("sdk.tv.login.error.sure", -1, null, null, i());
      m();
      b();
    }
    d();
  }
  
  public final void m()
  {
    IAPPayCallBack localIAPPayCallBack = this.j;
    if (localIAPPayCallBack != null)
    {
      localIAPPayCallBack.MidasPayNeedLogin();
      this.j = null;
      this.k = true;
    }
    f();
  }
  
  public void n()
  {
    final int i1 = p4.p().e().b.saveType;
    APDataReportManager.getInstance().insertData("sdk.tv.result.back.show", i1, null, null, i());
    d();
    Object localObject = new i1.a(this.c);
    ((i1.a)localObject).b("提示");
    ((i1.a)localObject).a("支付是否完成？");
    ((i1.a)localObject).a(2131034256);
    ((i1.a)localObject).b("支付完成", new q(i1));
    ((i1.a)localObject).a("重新支付", new r(i1));
    localObject = ((i1.a)localObject).a();
    if (localObject != null)
    {
      ((Dialog)localObject).setCancelable(false);
      ((Dialog)localObject).setOnKeyListener(new s(i1));
    }
    try
    {
      ((Dialog)localObject).show();
    }
    catch (Exception localException)
    {
      label137:
      break label137;
    }
    APDataReportManager.getInstance().insertData("sdk.tv.result.back.sure", i1, null, null, i());
    b(null);
    d();
    this.m = ((i1)localObject);
  }
  
  public void o()
  {
    d();
    if (this.n) {
      return;
    }
    a(this.c, this.a, this.j);
  }
  
  public void p()
  {
    APDataReportManager.getInstance().insertData("sdk.tv.offline.show", -1, null, null, i());
    d();
    if (!this.n)
    {
      a("手机不在线，请检查手机状态", this.c, new p());
      return;
    }
    APDataReportManager.getInstance().insertData("sdk.tv.offline.sure", -1, null, null, i());
    APPayResponse localAPPayResponse = new APPayResponse();
    localAPPayResponse.resultCode = 5;
    localAPPayResponse.realSaveNum = 0;
    localAPPayResponse.payState = -1;
    localAPPayResponse.provideState = -1;
    b(localAPPayResponse);
    a(localAPPayResponse);
  }
  
  public void q()
  {
    APDataReportManager.getInstance().insertData("sdk.tv.connect.error.show", -1, null, null, null);
    d();
    if (!this.n)
    {
      a("订单超时,请以手机支付状态为准", this.c, new b());
      return;
    }
    APDataReportManager.getInstance().insertData("sdk.tv.connect.error.sure", -1, null, null, i());
    APPayResponse localAPPayResponse = new APPayResponse();
    localAPPayResponse.resultCode = 5;
    localAPPayResponse.realSaveNum = 0;
    localAPPayResponse.payState = -1;
    localAPPayResponse.provideState = -1;
    b(localAPPayResponse);
    a(localAPPayResponse);
  }
  
  public void r()
  {
    Object localObject = new i1.a(this.c);
    ((i1.a)localObject).b("请耐心等待");
    ((i1.a)localObject).a("订单正向手机推送，请在手机上查看");
    ((i1.a)localObject).a(2131034255);
    localObject = ((i1.a)localObject).a();
    if (localObject != null)
    {
      ((Dialog)localObject).setCancelable(false);
      ((Dialog)localObject).setOnKeyListener(new a());
    }
    try
    {
      ((Dialog)localObject).show();
    }
    catch (Exception localException)
    {
      label69:
      break label69;
    }
    n();
    this.l = ((i1)localObject);
  }
  
  public final void s()
  {
    APDataReportManager.getInstance().insertData("sdk.tv.send.timeout.show", -1, null, null, i());
    if (!this.n)
    {
      a("订单推送到手机失败，请检查手机网络，或者重新配对", this.c, new n());
      return;
    }
    APDataReportManager.getInstance().insertData("sdk.tv.send.timeout.sure", -1, null, null, i());
  }
  
  public class a
    implements DialogInterface.OnKeyListener
  {
    public a() {}
    
    public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
      {
        APDataReportManager.getInstance().insertData("sdk.tv.paying.close", -1, null, null, null);
        h1.this.n();
        paramDialogInterface.dismiss();
        return true;
      }
      return false;
    }
  }
  
  public class b
    implements h1.t
  {
    public b() {}
    
    public void a()
    {
      APDataReportManager.getInstance().insertData("sdk.tv.connect.error.sure", -1, null, null, h1.i(h1.this));
      h1.a(h1.this);
      h1.a(h1.this, null);
    }
  }
  
  public class c
    implements DialogInterface.OnClickListener
  {
    public c() {}
    
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      APDataReportManager.getInstance().insertData("sdk.tv.paired.error.sure", -1, null, null, h1.i(h1.this));
      paramDialogInterface.dismiss();
    }
  }
  
  public class d
    implements DialogInterface.OnKeyListener
  {
    public d() {}
    
    public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
      {
        APDataReportManager.getInstance().insertData("sdk.tv.paired.error.sure", -1, null, null, h1.i(h1.this));
        paramDialogInterface.dismiss();
        return true;
      }
      return false;
    }
  }
  
  public class e
    implements DialogInterface.OnClickListener
  {
    public e(h1.t paramt) {}
    
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      paramDialogInterface.cancel();
      paramt.a();
    }
  }
  
  public class f
    implements DialogInterface.OnKeyListener
  {
    public f(h1.t paramt) {}
    
    public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
      {
        paramDialogInterface.cancel();
        paramt.a();
      }
      return false;
    }
  }
  
  public class g
    implements DialogInterface.OnClickListener
  {
    public g(APPayResponse paramAPPayResponse) {}
    
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      APDataReportManager.getInstance().insertData("sdk.tv.error.sure", -1, null, null, h1.i(h1.this));
      paramDialogInterface.cancel();
      h1.a(h1.this, paramAPPayResponse);
    }
  }
  
  public class h
    implements DialogInterface.OnKeyListener
  {
    public h(APPayResponse paramAPPayResponse) {}
    
    public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
      {
        APDataReportManager.getInstance().insertData("sdk.tv.error.sure", -1, null, null, h1.i(h1.this));
        paramDialogInterface.cancel();
        h1.a(h1.this, paramAPPayResponse);
        return true;
      }
      return false;
    }
  }
  
  public class i
    implements DialogInterface.OnClickListener
  {
    public i(APPayResponse paramAPPayResponse) {}
    
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      APDataReportManager.getInstance().insertData("sdk.tv.success.sure", -1, null, null, h1.i(h1.this));
      paramDialogInterface.cancel();
      h1.a(h1.this, paramAPPayResponse);
    }
  }
  
  public class j
    implements DialogInterface.OnKeyListener
  {
    public j(APPayResponse paramAPPayResponse) {}
    
    public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
      {
        APDataReportManager.getInstance().insertData("sdk.tv.success.sure", -1, null, null, h1.i(h1.this));
        h1.a(h1.this, paramAPPayResponse);
        return true;
      }
      return false;
    }
  }
  
  public class k
    implements e1.b
  {
    public k() {}
    
    public void a()
    {
      if (!h1.this.a())
      {
        h1.this.q();
        h1.a(h1.this, 0);
        return;
      }
      h1.h(h1.this);
      String str = h1.t();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onHandleConnectError curIndex:");
      localStringBuilder.append(h1.g(h1.this));
      APLog.i(str, localStringBuilder.toString());
      if (h1.g(h1.this) == h1.u().length + 1)
      {
        h1.a(h1.this, 0);
        APLog.i(h1.t(), "onHandleConnectError stop:");
        APDataReportManager.getInstance().insertData("sdk.tv.polling.retry.failed", -1, null, null, h1.i(h1.this));
        h1.j(h1.this).removeMessages(1);
        h1.this.q();
        return;
      }
      h1.j(h1.this).sendMessageDelayed(h1.j(h1.this).obtainMessage(1), h1.u()[(h1.g(h1.this) % h1.u().length)] * 1000);
    }
    
    public void a(String paramString)
    {
      try
      {
        paramString = new JSONObject(URLDecoder.decode((String)h1.b(URLDecoder.decode(paramString, "UTF-8")).get("pushmsg"), "UTF-8"));
        String str1 = paramString.getString("cmd");
        boolean bool = str1.equalsIgnoreCase("sync_order_result");
        if (bool)
        {
          paramString = paramString.getString("msg");
          h1.a(h1.this, paramString);
          return;
        }
        bool = str1.equalsIgnoreCase("send_order_resp");
        if (bool) {
          try
          {
            paramString = new JSONObject(paramString.getString("msg"));
            int i = paramString.getInt("retcode");
            str1 = (String)paramString.get("confirmmsg");
            String str2 = h1.t();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("order confirm:");
            localStringBuilder.append(paramString.toString());
            APLog.i(str2, localStringBuilder.toString());
            h1.a(h1.this, i, str1);
            return;
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
            h1.this.a(null, "订单异常，请重试");
            return;
          }
        }
        bool = str1.equalsIgnoreCase("sync_install");
        if (!bool) {
          return;
        }
        try
        {
          APLog.i(h1.t(), "install");
          h1.e(h1.this);
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          h1.this.a(null, "支付异常");
          return;
        }
        h1.this.a(null, "订单异常，请重试");
      }
      catch (JSONException paramString) {}catch (UnsupportedEncodingException paramString)
      {
        break label248;
      }
      paramString.printStackTrace();
      return;
      label248:
      h1.this.a(null, "订单异常，请重试");
      paramString.printStackTrace();
    }
    
    public void b()
    {
      h1.f(h1.this);
    }
    
    public void c()
    {
      h1.this.p();
    }
  }
  
  public class l
    implements k1
  {
    public l() {}
    
    public void a(int paramInt, String paramString)
    {
      if (paramInt != 0)
      {
        if (paramInt != 6)
        {
          if (paramInt != 7)
          {
            j1 localj1 = new j1();
            localj1.a = 5;
            localj1.c = 0;
            localj1.e = -1;
            localj1.f = -1;
            h1.v().a(localj1, paramString);
            return;
          }
          h1.this.p();
          return;
        }
        h1.this.l();
        return;
      }
      APLog.i(h1.t(), "SyncOrder success");
    }
  }
  
  public class m
    implements h1.t
  {
    public m() {}
    
    public void a()
    {
      APDataReportManager.getInstance().insertData("sdk.tv.order.parse.error.sure", -1, null, null, h1.i(h1.this));
      h1.v().a(null, "订单异常，请重试");
    }
  }
  
  public class n
    implements h1.t
  {
    public n() {}
    
    public void a()
    {
      APDataReportManager.getInstance().insertData("sdk.tv.send.timeout.sure", -1, null, null, h1.i(h1.this));
      h1.a(h1.this);
      h1.a(h1.this, null);
    }
  }
  
  public class o
    implements h1.t
  {
    public o() {}
    
    public void a()
    {
      APDataReportManager.getInstance().insertData("sdk.tv.login.error.sure", -1, null, null, h1.i(h1.this));
      h1.a(h1.this);
      h1.b(h1.this);
      h1.c(h1.this);
    }
  }
  
  public class p
    implements h1.t
  {
    public p() {}
    
    public void a()
    {
      APDataReportManager.getInstance().insertData("sdk.tv.offline.sure", -1, null, null, h1.i(h1.this));
      h1.a(h1.this);
      h1.a(h1.this, null);
    }
  }
  
  public class q
    implements DialogInterface.OnClickListener
  {
    public q(int paramInt) {}
    
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      APDataReportManager.getInstance().insertData("sdk.tv.result.back.sure", i1, null, null, h1.i(h1.this));
      paramDialogInterface.dismiss();
      h1.a(h1.this, null);
      h1.c(h1.this);
    }
  }
  
  public class r
    implements DialogInterface.OnClickListener
  {
    public r(int paramInt) {}
    
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
      paramInt = i1;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(h1.i(h1.this));
      localStringBuilder.append("&");
      localStringBuilder.append(h1.this.k());
      localAPDataReportManager.insertData("sdk.tv.result.back.retry", paramInt, null, null, localStringBuilder.toString());
      paramDialogInterface.dismiss();
      if (h1.d(h1.this))
      {
        paramDialogInterface = new APPayResponse();
        paramDialogInterface.resultCode = 5;
        paramDialogInterface.realSaveNum = 0;
        paramDialogInterface.payState = -1;
        paramDialogInterface.provideState = -1;
        paramDialogInterface.resultMsg = "道具（游戏侧下单）刷新二维码重新支付";
        h1.a(h1.this, paramDialogInterface);
        return;
      }
      h1.this.o();
    }
  }
  
  public class s
    implements DialogInterface.OnKeyListener
  {
    public s(int paramInt) {}
    
    public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
      {
        APDataReportManager.getInstance().insertData("sdk.tv.result.back.sure", i1, null, null, h1.i(h1.this));
        paramDialogInterface.dismiss();
        h1.a(h1.this, null);
        h1.c(h1.this);
        return true;
      }
      return false;
    }
  }
  
  public static abstract interface t
  {
    public abstract void a();
  }
  
  public static class u
    extends Handler
  {
    public final WeakReference<h1> a;
    
    public u(h1 paramh1)
    {
      this.a = new WeakReference(paramh1);
    }
    
    public void handleMessage(Message paramMessage)
    {
      paramMessage = (h1)this.a.get();
      if (paramMessage == null) {
        return;
      }
      APDataReportManager.getInstance().insertData("sdk.tv.polling.retry", -1, null, null, h1.i(paramMessage));
      APLog.i(h1.t(), "onHandleConnectError retry");
      e1.e().c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.h1
 * JD-Core Version:    0.7.0.1
 */