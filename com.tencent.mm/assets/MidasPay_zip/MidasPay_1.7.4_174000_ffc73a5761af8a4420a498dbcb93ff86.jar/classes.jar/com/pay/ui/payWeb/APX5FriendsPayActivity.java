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
import android.widget.RelativeLayout.LayoutParams;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import midas.x.a;
import midas.x.c.a;
import midas.x.el;
import midas.x.em;
import midas.x.fa;
import midas.x.fv;
import midas.x.hu;
import midas.x.hv;
import midas.x.hy;

public class APX5FriendsPayActivity
  extends APX5WebActivity
{
  hy a = new hy()
  {
    public void a(WebView paramAnonymousWebView)
    {
      APUICommonMethod.b();
      fv.a(-1, "支付关闭");
    }
    
    public void a(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
    {
      paramAnonymousWebView = paramAnonymousString2.toString();
      if (paramAnonymousWebView.startsWith("http://unipay.sdk.android/?")) {
        APX5FriendsPayActivity.this.a(paramAnonymousWebView);
      }
      paramAnonymousJsResult.cancel();
    }
    
    public void a(WebView paramAnonymousWebView, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, Message paramAnonymousMessage) {}
  };
  private String u;
  private boolean v;
  
  private boolean a(WebView paramWebView, String paramString)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramWebView.getLayoutParams();
    APLog.i("webviewclient == ", "updateWebViewSize ");
    String str = APTools.a(paramString, "webviewwidth");
    int i;
    if (!TextUtils.isEmpty(str)) {
      i = Integer.valueOf(str).intValue();
    } else {
      i = 0;
    }
    paramString = APTools.a(paramString, "webvieheight");
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
  
  private String l()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(hu.a);
    ((StringBuilder)localObject1).append(this.q.b);
    ((StringBuilder)localObject1).append(this.q.a);
    ((StringBuilder)localObject1).append(m());
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
    localObject2 = "";
    try
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("&random=");
      ((StringBuilder)localObject3).append(String.valueOf(Math.random() * 100.0D));
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject2 = localObject3;
    }
    catch (Exception localException)
    {
      Object localObject3;
      label169:
      break label169;
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(APTools.a(this.q.p));
    ((StringBuilder)localObject3).append((String)localObject2);
    localObject2 = ((StringBuilder)localObject3).toString();
    localObject3 = APAppDataInterface.singleton().e();
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
  
  private String m()
  {
    return "";
  }
  
  public void a()
  {
    Object localObject = i();
    setContentView(2131165269);
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
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: new 231	java/util/HashMap
    //   11: dup
    //   12: invokespecial 232	java/util/HashMap:<init>	()V
    //   15: pop
    //   16: aload_1
    //   17: invokestatic 235	com/pay/tool/APTools:b	(Ljava/lang/String;)Ljava/util/HashMap;
    //   20: astore 5
    //   22: aload 5
    //   24: ifnonnull +14 -> 38
    //   27: aload_0
    //   28: ldc 237
    //   30: iconst_0
    //   31: invokestatic 243	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   34: invokevirtual 246	android/widget/Toast:show	()V
    //   37: return
    //   38: aload 5
    //   40: ldc 248
    //   42: invokevirtual 252	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: checkcast 123	java/lang/String
    //   48: astore_3
    //   49: aload 5
    //   51: ldc 254
    //   53: invokevirtual 252	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   56: checkcast 123	java/lang/String
    //   59: astore 4
    //   61: aload_0
    //   62: aload 5
    //   64: ldc_w 256
    //   67: invokevirtual 252	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   70: checkcast 123	java/lang/String
    //   73: putfield 258	com/pay/ui/payWeb/APX5FriendsPayActivity:u	Ljava/lang/String;
    //   76: ldc_w 260
    //   79: aload_3
    //   80: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   83: ifeq +323 -> 406
    //   86: ldc_w 262
    //   89: aload 4
    //   91: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   94: ifeq +274 -> 368
    //   97: invokestatic 268	com/pay/data/report/APDataReportManager:getInstance	()Lcom/pay/data/report/APDataReportManager;
    //   100: aload_0
    //   101: getfield 108	com/pay/ui/payWeb/APX5FriendsPayActivity:q	Lmidas/x/hv;
    //   104: getfield 271	midas/x/hv:g	Ljava/lang/String;
    //   107: aload_0
    //   108: getfield 29	com/pay/ui/payWeb/APX5FriendsPayActivity:f	I
    //   111: invokevirtual 275	com/pay/data/report/APDataReportManager:insertData	(Ljava/lang/String;I)V
    //   114: aload 5
    //   116: ldc_w 277
    //   119: invokevirtual 252	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   122: checkcast 123	java/lang/String
    //   125: astore 8
    //   127: aload 5
    //   129: ldc_w 279
    //   132: invokevirtual 252	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   135: checkcast 123	java/lang/String
    //   138: ldc_w 281
    //   141: invokestatic 286	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   144: astore_3
    //   145: aload 5
    //   147: ldc_w 288
    //   150: invokevirtual 252	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   153: checkcast 123	java/lang/String
    //   156: ldc_w 281
    //   159: invokestatic 286	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   162: astore 4
    //   164: aload 5
    //   166: ldc_w 290
    //   169: invokevirtual 252	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   172: checkcast 123	java/lang/String
    //   175: ldc_w 281
    //   178: invokestatic 286	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   181: astore 6
    //   183: aload 5
    //   185: ldc_w 292
    //   188: invokevirtual 252	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   191: checkcast 123	java/lang/String
    //   194: ldc_w 281
    //   197: invokestatic 286	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   200: astore 5
    //   202: aload 4
    //   204: astore 7
    //   206: aload 6
    //   208: astore 4
    //   210: aload 7
    //   212: astore 6
    //   214: goto +52 -> 266
    //   217: astore 5
    //   219: goto +26 -> 245
    //   222: astore 5
    //   224: goto +17 -> 241
    //   227: astore 5
    //   229: goto +8 -> 237
    //   232: astore 5
    //   234: ldc 134
    //   236: astore_3
    //   237: ldc 134
    //   239: astore 4
    //   241: ldc 134
    //   243: astore 6
    //   245: aload 5
    //   247: invokevirtual 295	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   250: aload 6
    //   252: astore 7
    //   254: ldc 134
    //   256: astore 5
    //   258: aload 4
    //   260: astore 6
    //   262: aload 7
    //   264: astore 4
    //   266: new 95	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   273: astore 7
    //   275: aload 7
    //   277: ldc_w 297
    //   280: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload 7
    //   286: aload_1
    //   287: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: ldc_w 299
    //   294: aload 7
    //   296: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokestatic 48	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   302: aload 4
    //   304: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   307: ifeq +15 -> 322
    //   310: aload_0
    //   311: ldc_w 301
    //   314: iconst_0
    //   315: invokestatic 243	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   318: invokevirtual 246	android/widget/Toast:show	()V
    //   321: return
    //   322: aload 8
    //   324: invokestatic 305	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   327: istore_2
    //   328: new 307	midas/x/fg
    //   331: dup
    //   332: aload_0
    //   333: invokespecial 310	midas/x/fg:<init>	(Landroid/app/Activity;)V
    //   336: iload_2
    //   337: aload_3
    //   338: aload 4
    //   340: aload 6
    //   342: aload 5
    //   344: new 8	com/pay/ui/payWeb/APX5FriendsPayActivity$2
    //   347: dup
    //   348: aload_0
    //   349: invokespecial 311	com/pay/ui/payWeb/APX5FriendsPayActivity$2:<init>	(Lcom/pay/ui/payWeb/APX5FriendsPayActivity;)V
    //   352: invokevirtual 314	midas/x/fg:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lmidas/x/c$a;)V
    //   355: return
    //   356: aload_0
    //   357: ldc_w 316
    //   360: iconst_0
    //   361: invokestatic 243	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   364: invokevirtual 246	android/widget/Toast:show	()V
    //   367: return
    //   368: ldc_w 318
    //   371: aload 4
    //   373: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   376: ifeq +48 -> 424
    //   379: invokestatic 268	com/pay/data/report/APDataReportManager:getInstance	()Lcom/pay/data/report/APDataReportManager;
    //   382: aload_0
    //   383: getfield 108	com/pay/ui/payWeb/APX5FriendsPayActivity:q	Lmidas/x/hv;
    //   386: getfield 320	midas/x/hv:d	Ljava/lang/String;
    //   389: aload_0
    //   390: getfield 29	com/pay/ui/payWeb/APX5FriendsPayActivity:f	I
    //   393: invokevirtual 275	com/pay/data/report/APDataReportManager:insertData	(Ljava/lang/String;I)V
    //   396: invokestatic 322	com/pay/ui/common/APUICommonMethod:b	()V
    //   399: iconst_2
    //   400: ldc 134
    //   402: invokestatic 327	midas/x/fv:a	(ILjava/lang/String;)V
    //   405: return
    //   406: ldc_w 329
    //   409: aload_1
    //   410: invokestatic 331	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   413: aload_0
    //   414: ldc_w 301
    //   417: iconst_0
    //   418: invokestatic 243	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   421: invokevirtual 246	android/widget/Toast:show	()V
    //   424: return
    //   425: astore_1
    //   426: goto -70 -> 356
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	429	0	this	APX5FriendsPayActivity
    //   0	429	1	paramString	String
    //   327	10	2	i	int
    //   48	290	3	str1	String
    //   59	313	4	localObject1	Object
    //   20	181	5	localObject2	Object
    //   217	1	5	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   222	1	5	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   227	1	5	localUnsupportedEncodingException3	java.io.UnsupportedEncodingException
    //   232	14	5	localUnsupportedEncodingException4	java.io.UnsupportedEncodingException
    //   256	87	5	str2	String
    //   181	160	6	localObject3	Object
    //   204	91	7	localObject4	Object
    //   125	198	8	str3	String
    // Exception table:
    //   from	to	target	type
    //   183	202	217	java/io/UnsupportedEncodingException
    //   164	183	222	java/io/UnsupportedEncodingException
    //   145	164	227	java/io/UnsupportedEncodingException
    //   127	145	232	java/io/UnsupportedEncodingException
    //   322	328	425	java/lang/Exception
  }
  
  protected void b()
  {
    super.b();
    this.d.getSettings().setUseWideViewPort(true);
    this.d.getSettings().setLoadWithOverviewMode(true);
    Object localObject = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int i = ((DisplayMetrics)localObject).densityDpi;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("densityDpi = ");
    ((StringBuilder)localObject).append(i);
    Log.d("APX5FriendsPayActivity", ((StringBuilder)localObject).toString());
  }
  
  public void c()
  {
    hv localhv = new hv();
    localhv.o = this.a;
    if (getResources().getConfiguration().orientation == 1) {
      localhv.a = hu.l;
    } else if (getResources().getConfiguration().orientation == 2) {
      localhv.a = hu.m;
    }
    localhv.c = "sdk.friendspay.show";
    localhv.g = "sdk.friendspay.sure";
    localhv.d = "sdk.friendspay.close";
    localhv.j = "sdk.friendspay.keyback";
    this.q = localhv;
  }
  
  protected void d()
  {
    this.q.p.put("reqFrom", hu.q);
    this.q.p.put("openId", em.b().n().a.openId);
    this.q.p.put("openKey", em.b().n().a.openKey);
    this.q.p.put("sessionId", em.b().n().a.sessionId);
    this.q.p.put("sessionType", em.b().n().a.sessionType);
    this.q.p.put("pf", em.b().n().a.pf);
    this.q.p.put("pfKey", em.b().n().a.pfKey);
    this.q.p.put("zoneId", em.b().n().a.zoneId);
    this.q.p.put("offerId", em.b().n().a.offerId);
  }
  
  protected void h()
  {
    String str = APAppDataInterface.singleton().e();
    if (str.equals("release"))
    {
      this.q.b = hu.d;
      return;
    }
    if ((!str.equals("test")) && (!str.equals("dev")))
    {
      if ((str.equals("custom")) && ("dev".equals(APAppDataInterface.singleton().k())))
      {
        this.q.b = hu.c;
        return;
      }
      if (str.equals("testing"))
      {
        this.q.b = hu.c;
        return;
      }
      this.q.b = hu.d;
      return;
    }
    this.q.b = hu.c;
  }
  
  protected String i()
  {
    if (!TextUtils.isEmpty(a.a().j)) {
      return a.a().j;
    }
    return l();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a.a().f = true;
    j();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.d.canGoBack())
      {
        APDataReportManager.getInstance().insertData(this.q.j, this.f);
        this.d.goBack();
        return true;
      }
      APDataReportManager.getInstance().insertData(this.q.d, this.f);
      if (this.v)
      {
        APUICommonMethod.b();
        fv.a(em.b().n().e.a(), 0, -1);
      }
      else
      {
        APUICommonMethod.b();
        fv.a(2, "支付取消");
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    APDataReportManager.getInstance().insertData(this.q.c, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.ui.payWeb.APX5FriendsPayActivity
 * JD-Core Version:    0.7.0.1
 */