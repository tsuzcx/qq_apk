package com.pay.ui.payWeb;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.webkit.JsResult;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RelativeLayout.LayoutParams;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginActivity;
import java.util.HashMap;
import midas.x.a;
import midas.x.a8;
import midas.x.c.b;
import midas.x.d5;
import midas.x.o4;
import midas.x.p4;
import midas.x.x7;
import midas.x.y7;
import midas.x.z5;

public class APFriendsPayActivity
  extends APWebActivity
{
  public a8 k = new a();
  public boolean l;
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: new 43	java/util/HashMap
    //   11: dup
    //   12: invokespecial 44	java/util/HashMap:<init>	()V
    //   15: pop
    //   16: aload_1
    //   17: invokestatic 50	com/pay/tool/APTools:n	(Ljava/lang/String;)Ljava/util/HashMap;
    //   20: astore 5
    //   22: aload 5
    //   24: ifnonnull +14 -> 38
    //   27: aload_0
    //   28: ldc 52
    //   30: iconst_0
    //   31: invokestatic 58	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   34: invokevirtual 61	android/widget/Toast:show	()V
    //   37: return
    //   38: aload 5
    //   40: ldc 63
    //   42: invokevirtual 67	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: checkcast 69	java/lang/String
    //   48: astore 6
    //   50: aload 5
    //   52: ldc 71
    //   54: invokevirtual 67	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   57: checkcast 69	java/lang/String
    //   60: astore 4
    //   62: aload 5
    //   64: ldc 73
    //   66: invokevirtual 67	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   69: checkcast 69	java/lang/String
    //   72: astore 7
    //   74: ldc 75
    //   76: aload 6
    //   78: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   81: ifeq +325 -> 406
    //   84: ldc 81
    //   86: aload 4
    //   88: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   91: istore_3
    //   92: ldc 83
    //   94: astore 9
    //   96: iload_3
    //   97: ifeq +272 -> 369
    //   100: invokestatic 89	com/pay/data/report/APDataReportManager:getInstance	()Lcom/pay/data/report/APDataReportManager;
    //   103: aload_0
    //   104: getfield 93	com/pay/ui/payWeb/APWebActivity:f	Lmidas/x/x7;
    //   107: getfield 98	midas/x/x7:f	Ljava/lang/String;
    //   110: aload_0
    //   111: getfield 29	com/pay/ui/common/APActivity:a	I
    //   114: invokevirtual 102	com/pay/data/report/APDataReportManager:insertData	(Ljava/lang/String;I)V
    //   117: aload 5
    //   119: ldc 104
    //   121: invokevirtual 67	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   124: checkcast 69	java/lang/String
    //   127: astore 10
    //   129: aload 5
    //   131: ldc 106
    //   133: invokevirtual 67	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   136: checkcast 69	java/lang/String
    //   139: ldc 108
    //   141: invokestatic 114	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   144: astore 4
    //   146: aload 5
    //   148: ldc 116
    //   150: invokevirtual 67	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   153: checkcast 69	java/lang/String
    //   156: ldc 108
    //   158: invokestatic 114	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   161: astore 6
    //   163: aload 5
    //   165: ldc 118
    //   167: invokevirtual 67	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   170: checkcast 69	java/lang/String
    //   173: ldc 108
    //   175: invokestatic 114	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   178: astore 8
    //   180: aload 5
    //   182: ldc 120
    //   184: invokevirtual 67	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   187: checkcast 69	java/lang/String
    //   190: ldc 108
    //   192: invokestatic 114	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   195: astore 7
    //   197: goto +73 -> 270
    //   200: astore 7
    //   202: aload 4
    //   204: astore 5
    //   206: aload 8
    //   208: astore 4
    //   210: goto +43 -> 253
    //   213: astore 7
    //   215: ldc 83
    //   217: astore 8
    //   219: aload 4
    //   221: astore 5
    //   223: aload 8
    //   225: astore 4
    //   227: goto +26 -> 253
    //   230: astore 7
    //   232: aload 4
    //   234: astore 5
    //   236: goto +9 -> 245
    //   239: astore 7
    //   241: ldc 83
    //   243: astore 5
    //   245: ldc 83
    //   247: astore 6
    //   249: ldc 83
    //   251: astore 4
    //   253: aload 7
    //   255: invokevirtual 123	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   258: aload 4
    //   260: astore 8
    //   262: aload 9
    //   264: astore 7
    //   266: aload 5
    //   268: astore 4
    //   270: new 125	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   277: astore 5
    //   279: aload 5
    //   281: ldc 128
    //   283: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload 5
    //   289: aload_1
    //   290: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: ldc 134
    //   296: aload 5
    //   298: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 144	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: aload 8
    //   306: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   309: ifeq +14 -> 323
    //   312: aload_0
    //   313: ldc 146
    //   315: iconst_0
    //   316: invokestatic 58	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   319: invokevirtual 61	android/widget/Toast:show	()V
    //   322: return
    //   323: aload 10
    //   325: invokestatic 152	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   328: istore_2
    //   329: new 154	midas/x/j5
    //   332: dup
    //   333: aload_0
    //   334: invokespecial 157	midas/x/j5:<init>	(Landroid/app/Activity;)V
    //   337: iload_2
    //   338: aload 4
    //   340: aload 8
    //   342: aload 6
    //   344: aload 7
    //   346: new 8	com/pay/ui/payWeb/APFriendsPayActivity$b
    //   349: dup
    //   350: aload_0
    //   351: invokespecial 158	com/pay/ui/payWeb/APFriendsPayActivity$b:<init>	(Lcom/pay/ui/payWeb/APFriendsPayActivity;)V
    //   354: invokevirtual 161	midas/x/j5:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lmidas/x/c$b;)V
    //   357: return
    //   358: aload_0
    //   359: ldc 163
    //   361: iconst_0
    //   362: invokestatic 58	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   365: invokevirtual 61	android/widget/Toast:show	()V
    //   368: return
    //   369: ldc 165
    //   371: aload 4
    //   373: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   376: ifeq +46 -> 422
    //   379: invokestatic 89	com/pay/data/report/APDataReportManager:getInstance	()Lcom/pay/data/report/APDataReportManager;
    //   382: aload_0
    //   383: getfield 93	com/pay/ui/payWeb/APWebActivity:f	Lmidas/x/x7;
    //   386: getfield 168	midas/x/x7:d	Ljava/lang/String;
    //   389: aload_0
    //   390: getfield 29	com/pay/ui/common/APActivity:a	I
    //   393: invokevirtual 102	com/pay/data/report/APDataReportManager:insertData	(Ljava/lang/String;I)V
    //   396: invokestatic 172	com/pay/ui/common/APUICommonMethod:f	()V
    //   399: iconst_2
    //   400: ldc 83
    //   402: invokestatic 177	midas/x/z5:a	(ILjava/lang/String;)V
    //   405: return
    //   406: ldc 179
    //   408: aload_1
    //   409: invokestatic 182	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   412: aload_0
    //   413: ldc 146
    //   415: iconst_0
    //   416: invokestatic 58	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   419: invokevirtual 61	android/widget/Toast:show	()V
    //   422: return
    //   423: astore_1
    //   424: goto -66 -> 358
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	427	0	this	APFriendsPayActivity
    //   0	427	1	paramString	String
    //   328	10	2	i	int
    //   91	6	3	bool	boolean
    //   60	312	4	localObject1	Object
    //   20	277	5	localObject2	Object
    //   48	295	6	str1	String
    //   72	124	7	str2	String
    //   200	1	7	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   213	1	7	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   230	1	7	localUnsupportedEncodingException3	java.io.UnsupportedEncodingException
    //   239	15	7	localUnsupportedEncodingException4	java.io.UnsupportedEncodingException
    //   264	81	7	localObject3	Object
    //   178	163	8	localObject4	Object
    //   94	169	9	str3	String
    //   127	197	10	str4	String
    // Exception table:
    //   from	to	target	type
    //   180	197	200	java/io/UnsupportedEncodingException
    //   163	180	213	java/io/UnsupportedEncodingException
    //   146	163	230	java/io/UnsupportedEncodingException
    //   129	146	239	java/io/UnsupportedEncodingException
    //   323	329	423	java/lang/Exception
  }
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramWebView.getLayoutParams();
    APLog.i("webviewclient == ", "updateWebViewSize ");
    String str = APTools.b(paramString, "webviewwidth");
    int i;
    if (!TextUtils.isEmpty(str)) {
      i = Integer.valueOf(str).intValue();
    } else {
      i = 0;
    }
    paramString = APTools.b(paramString, "webvieheight");
    int j;
    if (!TextUtils.isEmpty(paramString)) {
      j = Integer.valueOf(paramString).intValue();
    } else {
      j = 0;
    }
    if ((j != 0) && (i != 0))
    {
      localLayoutParams.width = APUICommonMethod.a(this, i);
      localLayoutParams.height = APUICommonMethod.a(this, j);
      paramWebView.setLayoutParams(localLayoutParams);
      return true;
    }
    return false;
  }
  
  public void g()
  {
    this.f.n.put("reqFrom", y7.p);
    this.f.n.put("openId", p4.p().e().b.openId);
    this.f.n.put("openKey", p4.p().e().b.openKey);
    this.f.n.put("sessionId", p4.p().e().b.sessionId);
    this.f.n.put("sessionType", p4.p().e().b.sessionType);
    this.f.n.put("pf", p4.p().e().b.pf);
    this.f.n.put("pfKey", p4.p().e().b.pfKey);
    this.f.n.put("zoneId", p4.p().e().b.zoneId);
    this.f.n.put("offerId", p4.p().e().b.offerId);
  }
  
  public String h()
  {
    if (!TextUtils.isEmpty(a.r().n)) {
      return a.r().n;
    }
    return o();
  }
  
  public void i()
  {
    String str = APAppDataInterface.singleton().h();
    if (str.equals("release"))
    {
      this.f.b = y7.d;
      return;
    }
    if ((!str.equals("test")) && (!str.equals("dev")))
    {
      if ((str.equals("custom")) && ("dev".equals(APAppDataInterface.singleton().f())))
      {
        this.f.b = y7.c;
        return;
      }
      if (str.equals("testing"))
      {
        this.f.b = y7.c;
        return;
      }
      this.f.b = y7.d;
      return;
    }
    this.f.b = y7.c;
  }
  
  public void j()
  {
    x7 localx7 = new x7();
    localx7.m = this.k;
    if (getResources().getConfiguration().orientation == 1) {
      localx7.a = y7.l;
    } else if (getResources().getConfiguration().orientation == 2) {
      localx7.a = y7.m;
    }
    localx7.c = "sdk.friendspay.show";
    localx7.f = "sdk.friendspay.sure";
    localx7.d = "sdk.friendspay.close";
    localx7.i = "sdk.friendspay.keyback";
    this.f = localx7;
  }
  
  public void k()
  {
    Object localObject = h();
    setContentView(2131165265);
    this.d = ((WebView)findViewById(2131099770));
    this.e = ((AP3PointsLoading)findViewById(2131099699));
    this.d.setVisibility(8);
    if (!a(this.d, (String)localObject))
    {
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject).setMargins(20, 20, 20, 20);
      this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void l()
  {
    super.l();
    this.d.getSettings().setUseWideViewPort(true);
    this.d.getSettings().setLoadWithOverviewMode(true);
    Object localObject = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int i = ((DisplayMetrics)localObject).densityDpi;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("densityDpi = ");
    ((StringBuilder)localObject).append(i);
    Log.d("APFriendsPayActivity", ((StringBuilder)localObject).toString());
  }
  
  public final String o()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(y7.a);
    ((StringBuilder)localObject1).append(this.f.b);
    ((StringBuilder)localObject1).append(this.f.a);
    ((StringBuilder)localObject1).append(p());
    Object localObject2 = ((StringBuilder)localObject1).toString();
    if (((String)localObject2).contains("?"))
    {
      localObject1 = localObject2;
      if (!((String)localObject2).endsWith("?"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("&");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("?");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    try
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("&random=");
      ((StringBuilder)localObject2).append(String.valueOf(Math.random() * 100.0D));
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    catch (Exception localException)
    {
      label172:
      Object localObject3;
      break label172;
    }
    localObject2 = "";
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(APTools.a(this.f.n));
    ((StringBuilder)localObject3).append((String)localObject2);
    localObject2 = ((StringBuilder)localObject3).toString();
    localObject3 = APAppDataInterface.singleton().h();
    if (!((String)localObject3).equals("test"))
    {
      localObject1 = localObject2;
      if (!((String)localObject3).equals("dev")) {}
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("&sandbox=1");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    if (getResources().getConfiguration().orientation == 1)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("&webviewwidth=320&webvieheight=276");
      return ((StringBuilder)localObject2).toString();
    }
    localObject2 = localObject1;
    if (getResources().getConfiguration().orientation == 2)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("&webviewwidth=418&webvieheight=270");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    return localObject2;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a.r().f = true;
    n();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.d.canGoBack())
      {
        APDataReportManager.getInstance().insertData(this.f.i, this.a);
        this.d.goBack();
        return true;
      }
      APDataReportManager.getInstance().insertData(this.f.d, this.a);
      if (this.l)
      {
        APUICommonMethod.f();
        z5.a(p4.p().e().f.a(), 0, -1);
      }
      else
      {
        APUICommonMethod.f();
        z5.a(2, "支付取消");
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    APDataReportManager.getInstance().insertData(this.f.c, this.a);
  }
  
  public final String p()
  {
    return "";
  }
  
  public class a
    implements a8
  {
    public a() {}
    
    public void a(WebView paramWebView)
    {
      APUICommonMethod.f();
      z5.a(-1, "支付关闭");
    }
    
    public void a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      paramWebView = paramString2.toString();
      if (paramWebView.startsWith("http://unipay.sdk.android/?")) {
        APFriendsPayActivity.this.a(paramWebView);
      }
      paramJsResult.cancel();
    }
    
    public void a(WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage) {}
  }
  
  public class b
    implements c.b
  {
    public b() {}
    
    public void a(int paramInt, String paramString)
    {
      if (paramInt == 0)
      {
        paramString = APDataReportManager.getInstance();
        localObject1 = APFriendsPayActivity.this;
        paramString.insertData(((APWebActivity)localObject1).f.d, APFriendsPayActivity.a((APFriendsPayActivity)localObject1), null, null, "0");
        APUICommonMethod.f();
        z5.a(9, "");
        return;
      }
      paramString = APDataReportManager.getInstance();
      Object localObject2 = APFriendsPayActivity.this;
      Object localObject1 = ((APWebActivity)localObject2).f.d;
      int i = APFriendsPayActivity.b((APFriendsPayActivity)localObject2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("");
      paramString.insertData((String)localObject1, i, null, null, ((StringBuilder)localObject2).toString());
      APUICommonMethod.f();
      z5.a(10, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.payWeb.APFriendsPayActivity
 * JD-Core Version:    0.7.0.1
 */