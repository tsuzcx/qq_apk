package midas.x;

import android.app.Activity;
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

public class bg
{
  public static String a = "com.tencent.pay.tv.push.request.";
  public static String b = "Midas";
  public static String c = "com.tencent.midas.control.APMidasPayHelper";
  public static String d = "midasLoginExpire";
  public static String e = "midasCallBack";
  public static String f = "APMidasResponse";
  public static String g = "com.tencent.midas.api.APMidasResponse";
  private static final String h = "bg";
  private static final int[] i = { 5, 10, 30 };
  private static volatile bg j = null;
  private String A = "TVPay_TV_Android_6.0.2";
  private boolean B = false;
  private int C = 0;
  private b D = new b(this);
  private bd.b E = new bd.b()
  {
    public void a()
    {
      bg.b(bg.this);
    }
    
    public void a(String paramAnonymousString)
    {
      try
      {
        paramAnonymousString = new JSONObject(URLDecoder.decode((String)bg.a(URLDecoder.decode(paramAnonymousString, "UTF-8")).get("pushmsg"), "UTF-8"));
        String str1 = paramAnonymousString.getString("cmd");
        if (str1.equalsIgnoreCase("sync_order_result"))
        {
          paramAnonymousString = paramAnonymousString.getString("msg");
          bg.a(bg.this, paramAnonymousString);
          return;
        }
        boolean bool = str1.equalsIgnoreCase("send_order_resp");
        if (bool) {
          try
          {
            paramAnonymousString = new JSONObject(paramAnonymousString.getString("msg"));
            int i = paramAnonymousString.getInt("retcode");
            str1 = (String)paramAnonymousString.get("confirmmsg");
            String str2 = bg.m();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("order confirm:");
            localStringBuilder.append(paramAnonymousString.toString());
            APLog.i(str2, localStringBuilder.toString());
            bg.a(bg.this, i, str1);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            paramAnonymousString.printStackTrace();
            bg.this.a(null, "订单异常，请重试");
            return;
          }
        }
        bool = str1.equalsIgnoreCase("sync_install");
        if (bool) {
          try
          {
            APLog.i(bg.m(), "install");
            bg.a(bg.this);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            paramAnonymousString.printStackTrace();
            bg.this.a(null, "支付异常");
            return;
          }
        }
        return;
      }
      catch (JSONException paramAnonymousString)
      {
        bg.this.a(null, "订单异常，请重试");
        paramAnonymousString.printStackTrace();
        return;
      }
      catch (UnsupportedEncodingException paramAnonymousString)
      {
        bg.this.a(null, "订单异常，请重试");
        paramAnonymousString.printStackTrace();
      }
    }
    
    public void b()
    {
      bg.this.i();
    }
    
    public void c()
    {
      if (!bg.this.e())
      {
        bg.this.l();
        bg.a(bg.this, 0);
        return;
      }
      bg.c(bg.this);
      String str = bg.m();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onHandleConnectError curIndex:");
      localStringBuilder.append(bg.d(bg.this));
      APLog.i(str, localStringBuilder.toString());
      if (bg.d(bg.this) == bg.n().length + 1)
      {
        bg.a(bg.this, 0);
        APLog.i(bg.m(), "onHandleConnectError stop:");
        APDataReportManager.getInstance().insertData("sdk.tv.polling.retry.failed", -1, null, null, bg.e(bg.this));
        bg.f(bg.this).removeMessages(1);
        bg.this.l();
        return;
      }
      bg.f(bg.this).sendMessageDelayed(bg.f(bg.this).obtainMessage(1), bg.n()[(bg.d(bg.this) % bg.n().length)] * 1000);
    }
  };
  private bj F = new bj()
  {
    public void a(int paramAnonymousInt, String paramAnonymousString)
    {
      if (paramAnonymousInt != 0)
      {
        switch (paramAnonymousInt)
        {
        default: 
          bi localbi = new bi();
          localbi.a = 5;
          localbi.c = 0;
          localbi.e = -1;
          localbi.f = -1;
          bg.a().a(localbi, paramAnonymousString);
          return;
        case 7: 
          bg.this.i();
          return;
        }
        bg.this.h();
        return;
      }
      APLog.i(bg.m(), "SyncOrder success");
    }
  };
  private String k = "release";
  private boolean l = false;
  private APBaseRequest m;
  private String n;
  private Activity o;
  private boolean p = false;
  private String q = null;
  private String r = null;
  private String s;
  private String t;
  private String u = "";
  private IAPPayCallBack v;
  private boolean w = true;
  private bh x;
  private bh y;
  private boolean z = false;
  
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
  
  private String a(APBaseRequest paramAPBaseRequest)
  {
    Object localObject = c();
    String str = h;
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
      this.r = ((JSONObject)localObject).getString("u");
      this.u = ((JSONObject)localObject).getString("c");
      this.t = ((JSONObject)localObject).getString("v");
      this.s = ((JSONObject)localObject).getString("k");
      this.p = false;
      if (((paramAPBaseRequest instanceof APGoodsRequest)) && (((APGoodsRequest)paramAPBaseRequest).tokenType == 1)) {
        this.p = true;
      }
      paramAPBaseRequest = a(paramAPBaseRequest, this.q, this.s);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("手机端的UUID");
      ((StringBuilder)localObject).append(this.r);
      APLog.i("APSyncOrderReq", ((StringBuilder)localObject).toString());
      return paramAPBaseRequest;
    }
    catch (JSONException paramAPBaseRequest)
    {
      paramAPBaseRequest.printStackTrace();
    }
    return "";
  }
  
  private String a(APBaseRequest paramAPBaseRequest, String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cmd", "send_order");
      paramAPBaseRequest = paramAPBaseRequest.toJson();
      paramAPBaseRequest.put("tvUUID", paramString1);
      paramAPBaseRequest.put("version", "1.7.1f");
      paramAPBaseRequest.put("mbUUID", this.r);
      localJSONObject.put("msg", paramAPBaseRequest);
      paramAPBaseRequest = localJSONObject.toString();
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append(paramAPBaseRequest);
      paramString1.append(paramString2);
      paramString1 = g.a(paramString1.toString().getBytes());
      String str = h;
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
  
  public static bg a()
  {
    if (j == null) {
      try
      {
        if (j == null) {
          j = new bg();
        }
      }
      finally {}
    }
    return j;
  }
  
  private void a(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      APDataReportManager.getInstance().insertData("sdk.tv.order.send.succ.show", -1, null, null, v());
      if ((this.x != null) && (this.x.isShowing())) {
        this.x.a("订单已推送到手机，请在手机上完成支付");
      }
      bd.a().a(0);
      bd.a().b();
      return;
    }
    if (paramInt == 1)
    {
      APDataReportManager.getInstance().insertData("sdk.tv.order.parse.error.show", -1, null, null, v());
      if (!this.z)
      {
        a(paramString, this.o, new a()
        {
          public void a()
          {
            APDataReportManager.getInstance().insertData("sdk.tv.order.parse.error.sure", -1, null, null, bg.e(bg.this));
            bg.a().a(null, "订单异常，请重试");
          }
        });
        return;
      }
      APDataReportManager.getInstance().insertData("sdk.tv.order.parse.error.sure", -1, null, null, v());
      a().a(null, "订单异常，请重试");
      return;
    }
    paramString = APDataReportManager.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(v());
    localStringBuilder.append("&");
    localStringBuilder.append(paramInt);
    paramString.insertData("sdk.tv.order.send.unknow.error.tip", -1, null, null, localStringBuilder.toString());
    a().a(null, "支付异常");
  }
  
  private void a(APPayResponse paramAPPayResponse)
  {
    try
    {
      Object localObject = bf.a(g);
      try
      {
        APBeanUtil.copyProperties(paramAPPayResponse, localObject);
        bf.a(c, e, new Object[] { localObject });
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
  
  private void a(String paramString, Context paramContext, final a parama)
  {
    paramContext = new bh.a(paramContext);
    paramContext.b("提示");
    paramContext.a(paramString);
    paramContext.a(2131034255);
    paramContext.a("确定", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.cancel();
        parama.a();
      }
    });
    paramString = paramContext.a();
    if (paramString == null) {
      return;
    }
    paramString.setCancelable(false);
    paramString.setOnKeyListener(new DialogInterface.OnKeyListener()
    {
      public boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          paramAnonymousDialogInterface.cancel();
          parama.a();
        }
        return false;
      }
    });
    try
    {
      paramString.show();
      return;
    }
    catch (Exception paramString) {}
  }
  
  private static Map<String, String> b(String paramString)
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
  
  private void b(APPayResponse paramAPPayResponse)
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
    if (this.v != null)
    {
      this.v.MidasPayCallBack(localAPPayResponse);
      this.v = null;
      this.w = true;
    }
    t();
  }
  
  private void c(final APPayResponse paramAPPayResponse)
  {
    Object localObject = new bh.a(this.o);
    ((bh.a)localObject).b("支付异常");
    ((bh.a)localObject).a("请稍候再试");
    ((bh.a)localObject).a(2131034255);
    ((bh.a)localObject).a("确定", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        APDataReportManager.getInstance().insertData("sdk.tv.error.sure", -1, null, null, bg.e(bg.this));
        paramAnonymousDialogInterface.cancel();
        bg.a(bg.this, paramAPPayResponse);
      }
    });
    localObject = ((bh.a)localObject).a();
    if (localObject != null)
    {
      ((bh)localObject).setCancelable(false);
      ((bh)localObject).setOnKeyListener(new DialogInterface.OnKeyListener()
      {
        public boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
          {
            APDataReportManager.getInstance().insertData("sdk.tv.error.sure", -1, null, null, bg.e(bg.this));
            paramAnonymousDialogInterface.cancel();
            bg.a(bg.this, paramAPPayResponse);
            return true;
          }
          return false;
        }
      });
    }
    try
    {
      ((bh)localObject).show();
      return;
    }
    catch (Exception paramAPPayResponse) {}
  }
  
  private void c(String paramString)
  {
    bi localbi = new bi();
    try
    {
      localbi.a(new JSONObject(paramString));
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    paramString = h;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("充值结果:");
    localStringBuilder.append(localbi.a);
    APLog.i(paramString, localStringBuilder.toString());
    int i1 = ed.b().n().a.saveType;
    paramString = APDataReportManager.getInstance();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(v());
    localStringBuilder.append("&");
    localStringBuilder.append(localbi.a);
    paramString.insertData("sdk.tv.result.mobile", i1, null, null, localStringBuilder.toString());
    if (this.w) {
      return;
    }
    if (localbi.a == 2)
    {
      a().a(localbi, "支付取消");
      return;
    }
    if (localbi.a == -1)
    {
      a().a(localbi, "支付异常");
      return;
    }
    if (localbi.a == 0)
    {
      APLog.i(h, "充值成功");
      a().a(localbi, "支付成功");
      return;
    }
    if (localbi.a == 3)
    {
      a().a(localbi, "支付参数错误");
      return;
    }
    a().a(localbi, "支付异常");
  }
  
  private void d(final APPayResponse paramAPPayResponse)
  {
    Object localObject = new bh.a(this.o);
    ((bh.a)localObject).b("支付成功");
    ((bh.a)localObject).a("快去继续游戏吧:)");
    ((bh.a)localObject).a(2131034252);
    ((bh.a)localObject).a("确定", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        APDataReportManager.getInstance().insertData("sdk.tv.success.sure", -1, null, null, bg.e(bg.this));
        paramAnonymousDialogInterface.cancel();
        bg.a(bg.this, paramAPPayResponse);
      }
    });
    localObject = ((bh.a)localObject).a();
    if (localObject != null)
    {
      ((bh)localObject).setCancelable(false);
      ((bh)localObject).setOnKeyListener(new DialogInterface.OnKeyListener()
      {
        public boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
          {
            APDataReportManager.getInstance().insertData("sdk.tv.success.sure", -1, null, null, bg.e(bg.this));
            bg.a(bg.this, paramAPPayResponse);
            return true;
          }
          return false;
        }
      });
    }
    try
    {
      ((bh)localObject).show();
      return;
    }
    catch (Exception paramAPPayResponse) {}
  }
  
  private void o()
  {
    APDataReportManager.getInstance().insertData("sdk.tv.install.show", -1, null, null, v());
    bd.a().c();
    bd.a().a(0);
    bd.a().b();
  }
  
  private void p()
  {
    APDataReportManager.getInstance().insertData("sdk.tv.send.timeout.show", -1, null, null, v());
    if (!this.z)
    {
      a("订单推送到手机失败，请检查手机网络，或者重新配对", this.o, new a()
      {
        public void a()
        {
          APDataReportManager.getInstance().insertData("sdk.tv.send.timeout.sure", -1, null, null, bg.e(bg.this));
          bg.g(bg.this);
          bg.a(bg.this, null);
        }
      });
      return;
    }
    APDataReportManager.getInstance().insertData("sdk.tv.send.timeout.sure", -1, null, null, v());
  }
  
  private void q()
  {
    try
    {
      bf.a(c, d, null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void r()
  {
    if (this.x != null)
    {
      APDataReportManager.getInstance().insertData("sdk.tv.paying.close", -1, null, null, v());
      this.x.dismiss();
    }
    if (this.y != null)
    {
      APDataReportManager.getInstance().insertData("sdk.tv.result.back.finish", -1, null, null, v());
      this.y.dismiss();
    }
  }
  
  private void s()
  {
    bd.a().c();
    this.D.removeMessages(1);
  }
  
  private void t()
  {
    bs.a().c();
  }
  
  private void u()
  {
    if (this.v != null)
    {
      this.v.MidasPayNeedLogin();
      this.v = null;
      this.w = true;
    }
    t();
  }
  
  private String v()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.q);
    localStringBuilder.append("&");
    localStringBuilder.append(this.r);
    return localStringBuilder.toString();
  }
  
  public int a(Activity paramActivity, APBaseRequest paramAPBaseRequest, IAPPayCallBack paramIAPPayCallBack)
  {
    this.z = false;
    this.o = paramActivity;
    this.v = paramIAPPayCallBack;
    this.w = false;
    this.q = APTools.h();
    this.m = paramAPBaseRequest;
    APDataReportManager.getInstance().insertData("sdk.tv.pay.click", 0, null, null, v());
    be.a().a(paramActivity, "1.7.1f");
    this.n = a(paramAPBaseRequest);
    if (TextUtils.isEmpty(this.n))
    {
      Toast.makeText(paramActivity, "订单信息错误", 1).show();
      APDataReportManager.getInstance().insertData("sdk.tv.order.error", -1, null, null, v());
      return 5;
    }
    APDataReportManager.getInstance().insertData("sdk.tv.paying.show", -1, null, null, v());
    k();
    paramIAPPayCallBack = APDataReportManager.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(v());
    localStringBuilder.append("&");
    localStringBuilder.append(0);
    paramIAPPayCallBack.insertData("sdk.tv.apphook.success", 0, null, null, localStringBuilder.toString());
    bd.a().a("tv", this.A, this.q, b(), this.E);
    bd.a().a(3);
    bd.a().b();
    be.a().a(paramAPBaseRequest);
    be.a().a(paramActivity, this.n, this.q, this.r, this.F);
    return 0;
  }
  
  public void a(bi parambi, String paramString)
  {
    paramString = new APPayResponse();
    if (parambi == null)
    {
      paramString.resultCode = 5;
      paramString.realSaveNum = 0;
      paramString.payState = -1;
      paramString.provideState = -1;
    }
    else
    {
      paramString.resultCode = parambi.a;
      paramString.realSaveNum = parambi.c;
      paramString.payState = parambi.e;
      paramString.provideState = parambi.f;
      paramString.payChannel = parambi.d;
      paramString.resultMsg = parambi.g;
      paramString.extendInfo = parambi.h;
      paramString.resultInerCode = parambi.b;
      paramString.payReserve1 = parambi.i;
      paramString.payReserve2 = parambi.j;
      paramString.payReserve3 = parambi.k;
    }
    s();
    if (!this.z)
    {
      r();
      int i1 = paramString.resultCode;
      if (i1 != 0)
      {
        if (i1 != 2)
        {
          APDataReportManager.getInstance().insertData("sdk.tv.error.show", -1, null, null, v());
          c(paramString);
          return;
        }
        APDataReportManager.getInstance().insertData("sdk.tv.result.cancel", -1, null, null, v());
        APUICommonMethod.a(this.o, "支付已取消");
        b(paramString);
        return;
      }
      APDataReportManager.getInstance().insertData("sdk.tv.success.show", -1, null, null, v());
      d(paramString);
      return;
    }
    APDataReportManager.getInstance().insertData("sdk.tv.error.sure", -1, null, null, v());
    b(paramString);
    a(paramString);
  }
  
  public boolean a(Activity paramActivity)
  {
    return a(paramActivity, "paymode").startsWith("tenbox_");
  }
  
  public String b()
  {
    return APAppDataInterface.singleton().e();
  }
  
  public void b(Activity paramActivity)
  {
    APDataReportManager.getInstance().insertData("sdk.tv.paired.error.show", -1, null, null, v());
    paramActivity = new bh.a(paramActivity);
    paramActivity.b("配对提示");
    paramActivity.a("配对信息错误，请重新配对");
    paramActivity.a(2131034254);
    paramActivity.a("确定", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        APDataReportManager.getInstance().insertData("sdk.tv.paired.error.sure", -1, null, null, bg.e(bg.this));
        paramAnonymousDialogInterface.dismiss();
      }
    });
    paramActivity = paramActivity.a();
    if (paramActivity != null)
    {
      paramActivity.setCancelable(false);
      paramActivity.setOnKeyListener(new DialogInterface.OnKeyListener()
      {
        public boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
          {
            APDataReportManager.getInstance().insertData("sdk.tv.paired.error.sure", -1, null, null, bg.e(bg.this));
            paramAnonymousDialogInterface.dismiss();
            return true;
          }
          return false;
        }
      });
    }
    try
    {
      paramActivity.show();
      return;
    }
    catch (Exception paramActivity) {}
  }
  
  public String c()
  {
    return a(this.o, "qqpay_UUID");
  }
  
  public boolean d()
  {
    Object localObject = c();
    APLog.i(h, (String)localObject);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return false;
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      this.r = ((JSONObject)localObject).getString("u");
      this.u = ((JSONObject)localObject).getString("c");
      this.t = ((JSONObject)localObject).getString("v");
      this.s = ((JSONObject)localObject).getString("k");
      if ((!TextUtils.isEmpty(this.r)) && (!TextUtils.isEmpty(this.u)) && (!TextUtils.isEmpty(this.t)))
      {
        if (TextUtils.isEmpty(this.s)) {
          return false;
        }
        return this.u.equalsIgnoreCase("A");
      }
      return false;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return false;
  }
  
  public boolean e()
  {
    Object localObject = (ConnectivityManager)this.o.getSystemService("connectivity");
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
  
  public boolean f()
  {
    return this.p;
  }
  
  public void g()
  {
    s();
    if (this.z) {
      return;
    }
    a(this.o, this.m, this.v);
  }
  
  public void h()
  {
    if (!this.z)
    {
      APDataReportManager.getInstance().insertData("sdk.tv.login.error.show", -1, null, null, v());
      a("用户登录状态失效，请重新登录", this.o, new a()
      {
        public void a()
        {
          APDataReportManager.getInstance().insertData("sdk.tv.login.error.sure", -1, null, null, bg.e(bg.this));
          bg.g(bg.this);
          bg.h(bg.this);
          bg.i(bg.this);
        }
      });
    }
    else
    {
      APDataReportManager.getInstance().insertData("sdk.tv.login.error.sure", -1, null, null, v());
      u();
      q();
    }
    s();
  }
  
  public void i()
  {
    APDataReportManager.getInstance().insertData("sdk.tv.offline.show", -1, null, null, v());
    s();
    if (!this.z)
    {
      a("手机不在线，请检查手机状态", this.o, new a()
      {
        public void a()
        {
          APDataReportManager.getInstance().insertData("sdk.tv.offline.sure", -1, null, null, bg.e(bg.this));
          bg.g(bg.this);
          bg.a(bg.this, null);
        }
      });
      return;
    }
    APDataReportManager.getInstance().insertData("sdk.tv.offline.sure", -1, null, null, v());
    APPayResponse localAPPayResponse = new APPayResponse();
    localAPPayResponse.resultCode = 5;
    localAPPayResponse.realSaveNum = 0;
    localAPPayResponse.payState = -1;
    localAPPayResponse.provideState = -1;
    b(localAPPayResponse);
    a(localAPPayResponse);
  }
  
  public void j()
  {
    final int i1 = ed.b().n().a.saveType;
    APDataReportManager.getInstance().insertData("sdk.tv.result.back.show", i1, null, null, v());
    s();
    Object localObject = new bh.a(this.o);
    ((bh.a)localObject).b("提示");
    ((bh.a)localObject).a("支付是否完成？");
    ((bh.a)localObject).a(2131034255);
    ((bh.a)localObject).a("支付完成", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        APDataReportManager.getInstance().insertData("sdk.tv.result.back.sure", i1, null, null, bg.e(bg.this));
        paramAnonymousDialogInterface.dismiss();
        bg.a(bg.this, null);
        bg.i(bg.this);
      }
    });
    ((bh.a)localObject).b("重新支付", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
        paramAnonymousInt = i1;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(bg.e(bg.this));
        localStringBuilder.append("&");
        localStringBuilder.append(bg.this.f());
        localAPDataReportManager.insertData("sdk.tv.result.back.retry", paramAnonymousInt, null, null, localStringBuilder.toString());
        paramAnonymousDialogInterface.dismiss();
        if (bg.j(bg.this))
        {
          paramAnonymousDialogInterface = new APPayResponse();
          paramAnonymousDialogInterface.resultCode = 5;
          paramAnonymousDialogInterface.realSaveNum = 0;
          paramAnonymousDialogInterface.payState = -1;
          paramAnonymousDialogInterface.provideState = -1;
          paramAnonymousDialogInterface.resultMsg = "道具（游戏侧下单）刷新二维码重新支付";
          bg.a(bg.this, paramAnonymousDialogInterface);
          return;
        }
        bg.this.g();
      }
    });
    localObject = ((bh.a)localObject).a();
    if (localObject != null)
    {
      ((bh)localObject).setCancelable(false);
      ((bh)localObject).setOnKeyListener(new DialogInterface.OnKeyListener()
      {
        public boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
          {
            APDataReportManager.getInstance().insertData("sdk.tv.result.back.sure", i1, null, null, bg.e(bg.this));
            paramAnonymousDialogInterface.dismiss();
            bg.a(bg.this, null);
            bg.i(bg.this);
            return true;
          }
          return false;
        }
      });
    }
    try
    {
      ((bh)localObject).show();
    }
    catch (Exception localException)
    {
      label137:
      break label137;
    }
    APDataReportManager.getInstance().insertData("sdk.tv.result.back.sure", i1, null, null, v());
    b(null);
    s();
    this.y = ((bh)localObject);
  }
  
  public void k()
  {
    Object localObject = new bh.a(this.o);
    ((bh.a)localObject).b("请耐心等待");
    ((bh.a)localObject).a("订单正向手机推送，请在手机上查看");
    ((bh.a)localObject).a(2131034254);
    localObject = ((bh.a)localObject).a();
    if (localObject != null)
    {
      ((bh)localObject).setCancelable(false);
      ((bh)localObject).setOnKeyListener(new DialogInterface.OnKeyListener()
      {
        public boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
          {
            APDataReportManager.getInstance().insertData("sdk.tv.paying.close", -1, null, null, null);
            bg.this.j();
            paramAnonymousDialogInterface.dismiss();
            return true;
          }
          return false;
        }
      });
    }
    try
    {
      ((bh)localObject).show();
    }
    catch (Exception localException)
    {
      label69:
      break label69;
    }
    j();
    this.x = ((bh)localObject);
  }
  
  public void l()
  {
    APDataReportManager.getInstance().insertData("sdk.tv.connect.error.show", -1, null, null, null);
    s();
    if (!this.z)
    {
      a("订单超时,请以手机支付状态为准", this.o, new a()
      {
        public void a()
        {
          APDataReportManager.getInstance().insertData("sdk.tv.connect.error.sure", -1, null, null, bg.e(bg.this));
          bg.g(bg.this);
          bg.a(bg.this, null);
        }
      });
      return;
    }
    APDataReportManager.getInstance().insertData("sdk.tv.connect.error.sure", -1, null, null, v());
    APPayResponse localAPPayResponse = new APPayResponse();
    localAPPayResponse.resultCode = 5;
    localAPPayResponse.realSaveNum = 0;
    localAPPayResponse.payState = -1;
    localAPPayResponse.provideState = -1;
    b(localAPPayResponse);
    a(localAPPayResponse);
  }
  
  static abstract interface a
  {
    public abstract void a();
  }
  
  static class b
    extends Handler
  {
    private final WeakReference<bg> a;
    
    public b(bg parambg)
    {
      this.a = new WeakReference(parambg);
    }
    
    public void handleMessage(Message paramMessage)
    {
      paramMessage = (bg)this.a.get();
      if (paramMessage == null) {
        return;
      }
      APDataReportManager.getInstance().insertData("sdk.tv.polling.retry", -1, null, null, bg.e(paramMessage));
      APLog.i(bg.m(), "onHandleConnectError retry");
      bd.a().b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.bg
 * JD-Core Version:    0.7.0.1
 */