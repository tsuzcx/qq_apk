package com.pay.ui.marketing;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.LinearLayout.LayoutParams;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APMPInfo;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APTools;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginActivity;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import midas.x.a;
import midas.x.c6;
import midas.x.e5;
import midas.x.fc;
import midas.x.o4;
import midas.x.ob;
import midas.x.p4;
import midas.x.y6;
import midas.x.z1;
import midas.x.z5;

public class APX5WebMarketActivity
  extends APActivity
{
  public String d = "";
  public boolean e = false;
  
  public final void a(WebView paramWebView)
  {
    try
    {
      Method localMethod = paramWebView.getClass().getMethod("removeJavascriptInterface", new Class[] { String.class });
      if (localMethod != null)
      {
        localMethod.invoke(paramWebView, new Object[] { "searchBoxJavaBridge_" });
        return;
      }
    }
    catch (Exception paramWebView)
    {
      APLog.i("removeJavascriptInterface", paramWebView.toString());
    }
  }
  
  public final void a(WebView paramWebView, String paramString)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramWebView.getLayoutParams();
    APLog.i("webviewclient == ", "updateWebViewSize ");
    String str = APTools.b(paramString, "mpwidth");
    boolean bool = TextUtils.isEmpty(str);
    int j = 0;
    int i;
    if (!bool) {
      i = Integer.valueOf(str).intValue();
    } else {
      i = 0;
    }
    paramString = APTools.b(paramString, "mpheight");
    if (!TextUtils.isEmpty(paramString)) {
      j = Integer.valueOf(paramString).intValue();
    }
    if ((j != 0) && (i != 0))
    {
      localLayoutParams.width = APUICommonMethod.a(this, i);
      localLayoutParams.height = APUICommonMethod.a(this, j);
      paramWebView.setLayoutParams(localLayoutParams);
    }
  }
  
  public void a(String paramString)
  {
    APLog.i("APX5WebMarketActivity url == ", paramString);
    try
    {
      WebView localWebView = (WebView)findViewById(2131099770);
      localWebView.setScrollBarStyle(0);
      a(localWebView);
      WebSettings localWebSettings = localWebView.getSettings();
      localWebSettings.setUseWideViewPort(true);
      localWebSettings.setLoadWithOverviewMode(true);
      localWebSettings.setJavaScriptEnabled(true);
      localWebSettings.setSupportMultipleWindows(true);
      localWebSettings.setDomStorageEnabled(false);
      localWebSettings.setAppCacheMaxSize(2097152L);
      localWebSettings.setAppCachePath(getApplicationContext().getDir("cache", 0).getPath());
      localWebSettings.setAllowFileAccess(true);
      localWebSettings.setAppCacheEnabled(true);
      localWebSettings.setCacheMode(-1);
      localWebView.setWebViewClient(new a());
      a(localWebView, paramString);
      localWebView.loadUrl(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public final void f()
  {
    y6 localy6 = this.b;
    if (localy6 != null) {
      localy6.show();
    }
    z1.d().i(new b());
  }
  
  public final void g()
  {
    y6 localy6 = this.b;
    if (localy6 != null) {
      localy6.show();
    }
    z1.d().i(new c());
  }
  
  public final String h()
  {
    String str1 = "";
    int i = c6.s0().G();
    Object localObject1 = c6.s0().q();
    String str3 = c6.s0().r();
    String str2 = c6.s0().p();
    Object localObject2 = APDataReportManager.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sdk.market.send");
    localStringBuilder.append(i);
    ((APDataReportManager)localObject2).insertData(localStringBuilder.toString(), this.a, null, p4.p().e().b.mpInfo.payChannel, c6.s0().l());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("send flag == sdk.market.send");
    ((StringBuilder)localObject2).append(i);
    APLog.i("reResultURL", ((StringBuilder)localObject2).toString());
    try
    {
      localObject1 = URLEncoder.encode((String)localObject1, "UTF-8");
      localObject2 = localObject1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException1)
    {
      label168:
      break label168;
    }
    try
    {
      if (TextUtils.isEmpty(str2)) {
        break label181;
      }
      localObject2 = URLEncoder.encode(str2, "UTF-8");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException2)
    {
      break label171;
    }
    localObject1 = "";
    label171:
    APLog.i("goods_name_des == ", (String)localObject1);
    localObject2 = localObject1;
    label181:
    str2 = "";
    localObject1 = localObject2;
    localObject2 = str2;
    str2 = c6.s0().R();
    try
    {
      boolean bool = str2.contains("?");
      if (bool)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str2);
        localStringBuilder.append("&present_flag=");
        localStringBuilder.append(i);
        localStringBuilder.append("&goods_name=");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("&goods_num=");
        localStringBuilder.append(str3);
        localStringBuilder.append("&extend=");
        localStringBuilder.append((String)localObject2);
        localObject1 = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str2);
        localStringBuilder.append("?present_flag=");
        localStringBuilder.append(i);
        localStringBuilder.append("&goods_name=");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("&goods_num=");
        localStringBuilder.append(str3);
        localStringBuilder.append("&extend=");
        localStringBuilder.append((String)localObject2);
        localObject1 = localStringBuilder.toString();
      }
    }
    catch (Exception localException)
    {
      label397:
      break label397;
    }
    APUICommonMethod.f();
    if (this.d.equals("showBankResultActivity"))
    {
      z5.a(2, 0, -1);
      localObject1 = str1;
    }
    else
    {
      localObject1 = str1;
      if (this.d.equals("showWechatResultActivity"))
      {
        z5.a(8, 0, -1);
        localObject1 = str1;
      }
    }
    APLog.i("result url == ", (String)localObject1);
    return localObject1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = this.b;
    if (paramBundle != null) {
      paramBundle.show();
    }
    a.r().f = true;
    paramBundle = getIntent().getExtras();
    try
    {
      this.d = paramBundle.getString("loadUI");
    }
    catch (Exception paramBundle)
    {
      label47:
      break label47;
    }
    paramBundle = p4.p().e().b.mpInfo.discountUrl;
    if (this.d.equals("showStartActivity"))
    {
      setContentView(2131165239);
      a(p4.p().e().b.mpInfo.discountUrl);
      return;
    }
    if (this.d.equals("showBankResultActivity"))
    {
      setContentView(2131165241);
      f();
      return;
    }
    if (this.d.equals("showWechatResultActivity"))
    {
      setContentView(2131165241);
      g();
      return;
    }
    z5.a(-1, "活动url为空");
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      y6 localy6 = this.b;
      if (localy6 != null) {
        localy6.dismiss();
      }
      if (this.d.equals("showStartActivity"))
      {
        APDataReportManager.getInstance().insertData("sdk.market.keyback", this.a, null, p4.p().e().b.mpInfo.payChannel, c6.s0().l());
        APUICommonMethod.f();
        z5.a(2, "");
      }
      else if (this.d.equals("showBankResultActivity"))
      {
        APDataReportManager.getInstance().insertData("sdk.market.result.keyback", this.a, null, p4.p().e().b.mpInfo.payChannel, c6.s0().l());
        APUICommonMethod.f();
        z5.a(2, 0, -1);
      }
      else if (this.d.equals("showWechatResultActivity"))
      {
        APDataReportManager.getInstance().insertData("sdk.market.result.keyback", this.a, null, p4.p().e().b.mpInfo.payChannel, c6.s0().l());
        APUICommonMethod.f();
        z5.a(8, 0, -1);
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.d.equals("showStartActivity"))
    {
      APDataReportManager.getInstance().insertData("sdk.market.show", this.a, null, p4.p().e().b.mpInfo.payChannel, c6.s0().l());
      return;
    }
    if (this.d.equals("showBankResultActivity"))
    {
      APDataReportManager.getInstance().insertData("sdk.market.result.show", this.a, null, p4.p().e().b.mpInfo.payChannel, c6.s0().l());
      APLog.i("onResume", "结果result show");
      return;
    }
    if (this.d.equals("showWechatResultActivity")) {
      APDataReportManager.getInstance().insertData("sdk.market.result.show", this.a, null, p4.p().e().b.mpInfo.payChannel, c6.s0().l());
    }
  }
  
  public class a
    extends WebViewClient
  {
    public a() {}
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      APLog.i("webviewclient == ", "onPageFinished ");
      APX5WebMarketActivity.a(APX5WebMarketActivity.this, false);
      if (APX5WebMarketActivity.n(APX5WebMarketActivity.this) != null) {
        APX5WebMarketActivity.o(APX5WebMarketActivity.this).dismiss();
      }
      ((WebView)APX5WebMarketActivity.this.findViewById(2131099770)).setVisibility(0);
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      APX5WebMarketActivity.a(APX5WebMarketActivity.this, paramWebView, paramString);
      if (!APX5WebMarketActivity.m(APX5WebMarketActivity.this))
      {
        APLog.i("webviewclient == ", "onPageStarted ");
        paramWebView.goBack();
        if (paramString.startsWith("http://unipay.android.mp.pay")) {
          APDataReportManager.getInstance().insertData("sdk.market.sure", APX5WebMarketActivity.p(APX5WebMarketActivity.this), null, p4.p().e().b.mpInfo.payChannel, c6.s0().l());
        }
      }
      try
      {
        e5.h().a(APX5WebMarketActivity.this, p4.p().e().b);
      }
      catch (Exception localException)
      {
        label98:
        break label98;
      }
      APUICommonMethod.a(APX5WebMarketActivity.this, "网络错误，请稍后重试");
      break label278;
      if (paramString.startsWith("http://unipay.android.mp.back"))
      {
        APDataReportManager.getInstance().insertData("sdk.market.cancel", APX5WebMarketActivity.q(APX5WebMarketActivity.this), null, p4.p().e().b.mpInfo.payChannel, c6.s0().l());
        paramWebView.stopLoading();
        z5.a(2, "");
        APX5WebMarketActivity.this.finish();
        APUICommonMethod.a(APX5WebMarketActivity.this);
      }
      else if (paramString.startsWith("http://unipay.android.mp.retback"))
      {
        APDataReportManager.getInstance().insertData("sdk.market.result.cancel", APX5WebMarketActivity.b(APX5WebMarketActivity.this), null, p4.p().e().b.mpInfo.payChannel, c6.s0().l());
        APUICommonMethod.f();
        if (APX5WebMarketActivity.l(APX5WebMarketActivity.this).equals("showWechatResultActivity")) {
          z5.a(8, 0, 0);
        } else if (APX5WebMarketActivity.l(APX5WebMarketActivity.this).equals("showBankResultActivity")) {
          z5.a(2, 0, 0);
        }
      }
      label278:
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      APLog.i("webviewclient == ", "onReceivedError ");
      if (paramString2.startsWith("http://unipay.android.mp.pay")) {
        paramWebView.stopLoading();
      } else if (paramString2.startsWith("http://unipay.android.mp.back")) {
        paramWebView.stopLoading();
      }
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      APX5WebMarketActivity.a(APX5WebMarketActivity.this, paramWebView, paramString);
      paramWebView.stopLoading();
      if (paramString.startsWith("http://unipay.android.mp.pay"))
      {
        APLog.i("webviewclient == ", "shouldOverrideUrlLoading");
        APDataReportManager.getInstance().insertData("sdk.market.sure", APX5WebMarketActivity.a(APX5WebMarketActivity.this), null, p4.p().e().b.mpInfo.payChannel, c6.s0().l());
      }
      try
      {
        e5.h().a(APX5WebMarketActivity.this, p4.p().e().b);
      }
      catch (Exception localException)
      {
        label88:
        break label88;
      }
      APUICommonMethod.a(APX5WebMarketActivity.this, "网络错误，请稍后重试");
      break label268;
      if (paramString.startsWith("http://unipay.android.mp.back"))
      {
        APDataReportManager.getInstance().insertData("sdk.market.cancel", APX5WebMarketActivity.j(APX5WebMarketActivity.this), null, p4.p().e().b.mpInfo.payChannel, c6.s0().l());
        paramWebView.stopLoading();
        z5.a(2, "");
        APX5WebMarketActivity.this.finish();
        APUICommonMethod.a(APX5WebMarketActivity.this);
      }
      else if (paramString.startsWith("http://unipay.android.mp.retback"))
      {
        APDataReportManager.getInstance().insertData("sdk.market.result.cancel", APX5WebMarketActivity.k(APX5WebMarketActivity.this), null, p4.p().e().b.mpInfo.payChannel, c6.s0().l());
        APUICommonMethod.f();
        if (APX5WebMarketActivity.l(APX5WebMarketActivity.this).equals("showWechatResultActivity")) {
          z5.a(8, 0, 0);
        } else if (APX5WebMarketActivity.l(APX5WebMarketActivity.this).equals("showBankResultActivity")) {
          z5.a(2, 0, 0);
        }
      }
      label268:
      APX5WebMarketActivity.a(APX5WebMarketActivity.this, true);
      return super.shouldOverrideUrlLoading(paramWebView, paramString);
    }
  }
  
  public class b
    implements fc
  {
    public b() {}
    
    public void a(ob paramob)
    {
      if (paramob.d() == 0)
      {
        paramob = APX5WebMarketActivity.c(APX5WebMarketActivity.this);
        APX5WebMarketActivity.this.a(paramob);
        return;
      }
      APX5WebMarketActivity.d(APX5WebMarketActivity.this).dismiss();
      APUICommonMethod.f();
      z5.a(2, 0, -1);
    }
    
    public void b(ob paramob)
    {
      APX5WebMarketActivity.e(APX5WebMarketActivity.this).dismiss();
      APUICommonMethod.f();
      z5.a(2, 0, -1);
    }
    
    public void c(ob paramob)
    {
      APX5WebMarketActivity.f(APX5WebMarketActivity.this).dismiss();
      APUICommonMethod.f();
      z5.a(2, 0, -1);
    }
  }
  
  public class c
    implements fc
  {
    public c() {}
    
    public void a(ob paramob)
    {
      if (paramob.d() == 0)
      {
        paramob = APX5WebMarketActivity.c(APX5WebMarketActivity.this);
        APX5WebMarketActivity.this.a(paramob);
        return;
      }
      APX5WebMarketActivity.g(APX5WebMarketActivity.this).dismiss();
      APUICommonMethod.f();
      z5.a(8, 0, -1);
    }
    
    public void b(ob paramob)
    {
      APX5WebMarketActivity.h(APX5WebMarketActivity.this).dismiss();
      APUICommonMethod.f();
      z5.a(8, 0, -1);
    }
    
    public void c(ob paramob)
    {
      APX5WebMarketActivity.i(APX5WebMarketActivity.this).dismiss();
      APUICommonMethod.f();
      z5.a(8, 0, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.marketing.APX5WebMarketActivity
 * JD-Core Version:    0.7.0.1
 */