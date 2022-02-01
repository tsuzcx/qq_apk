package com.pay.ui.payWeb;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APExtendInfo;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APTools;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APActivity;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginActivity;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import midas.x.c5;
import midas.x.c6;
import midas.x.c8;
import midas.x.d0;
import midas.x.d5;
import midas.x.d8;
import midas.x.j;
import midas.x.j6;
import midas.x.o4;
import midas.x.p4;
import midas.x.r6;
import midas.x.r7;
import midas.x.w4;
import midas.x.x;
import midas.x.y7;
import midas.x.z7;

public class APX5WebActivity
  extends APActivity
{
  public WebView d = null;
  public AP3PointsLoading e = null;
  public z7 f = null;
  public ValueCallback<Uri> g = null;
  public WebChromeClient h = new a();
  public boolean i = false;
  public WebViewClient j = new b();
  
  public void a(WebView paramWebView)
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
  
  public void f() {}
  
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
    this.f.n.put("saveType", String.valueOf(p4.p().e().b.saveType));
    this.f.n.put("gameCoinName", APTools.b(p4.p().e().c.b, 1));
    this.f.n.put("gameCoinRate", p4.p().e().c.c);
    this.f.n.put("recommendList", APTools.a(r7.e().c(), ","));
    this.f.n.put("minNumber", String.valueOf(p4.p().e().c.e));
    this.f.n.put("sdkVersion", "1.7.9a");
    this.f.n.put("sessionToken", p4.p().e().f.k);
    this.f.n.put("mpJson", APTools.b(d0.i().d(), 1));
    this.f.n.put("gameCoinUnit", APTools.b(p4.p().e().b.extendInfo.unit, 1));
    HashMap localHashMap = this.f.n;
    if (p4.p().e().b.extendInfo.isShowNum) {
      str = "1";
    } else {
      str = "0";
    }
    localHashMap.put("showNum", str);
    this.f.n.put("uuid", APTools.b(c6.s0().Z(), 1));
    this.f.n.put("drm_resource", j6.e().b());
    this.f.n.put("payChannel", String.valueOf(r6.e(p4.p().e().f.e)));
    this.f.n.put("payChannelName", p4.p().e().f.e);
    String str = c6.s0().Q();
    if ("AndroidPay".equals(str)) {
      this.f.n.put("entry", "game");
    } else if ("APPayGameListNumActivity".equals(str)) {
      this.f.n.put("entry", "sdk");
    }
    this.f.n.put("hasMpTuan", x.f().e());
    if (p4.p().e().e.b)
    {
      this.f.n.put("firstCharge", "1");
      return;
    }
    this.f.n.put("firstCharge", "0");
  }
  
  public String h()
  {
    return null;
  }
  
  public void i() {}
  
  public void j() {}
  
  public void k() {}
  
  public void l()
  {
    WebSettings localWebSettings = this.d.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setSupportMultipleWindows(true);
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setAppCacheMaxSize(2097152L);
    localWebSettings.setAppCachePath(getApplicationContext().getDir("cache", 0).getPath());
    localWebSettings.setAllowFileAccess(true);
    localWebSettings.setAppCacheEnabled(true);
    localWebSettings.setCacheMode(-1);
  }
  
  public final void m()
  {
    APDataReportManager.getInstance().insertData(this.f.j, this.a);
    View localView = LayoutInflater.from(this).inflate(2131165266, null);
    setContentView(localView);
    ((Button)localView.findViewById(2131099861)).setOnClickListener(new c());
  }
  
  public void n()
  {
    j();
    g();
    f();
    i();
    k();
    a(this.d);
    l();
    this.d.setScrollBarStyle(0);
    this.d.setWebChromeClient(this.h);
    this.d.setWebViewClient(this.j);
    APLog.i("apWebData.webUrl == ", h());
    this.d.loadUrl(h());
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if (this.g == null) {
        return;
      }
      if ((paramIntent != null) && (paramInt2 == -1)) {
        paramIntent = paramIntent.getData();
      } else {
        paramIntent = null;
      }
      this.g.onReceiveValue(paramIntent);
      this.g = null;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public class a
    extends WebChromeClient
  {
    public a() {}
    
    public void onCloseWindow(WebView paramWebView)
    {
      APLog.d("APX5WebActivity", "onCloseWindow");
      c8 localc8 = APX5WebActivity.this.f.m;
      if (localc8 != null) {
        localc8.a(paramWebView);
      }
    }
    
    public boolean onCreateWindow(WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage)
    {
      APLog.d("APX5WebActivity", "onCreateWindow");
      c8 localc8 = APX5WebActivity.this.f.m;
      if (localc8 != null) {
        localc8.a(paramWebView, paramBoolean1, paramBoolean2, paramMessage);
      }
      return super.onCreateWindow(paramWebView, paramBoolean1, paramBoolean2, paramMessage);
    }
    
    public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      APLog.d("APX5WebActivity", "onJsAlert");
      c8 localc8 = APX5WebActivity.this.f.m;
      if (localc8 != null) {
        localc8.a(paramWebView, paramString1, paramString2, paramJsResult);
      }
      return true;
    }
    
    public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
    {
      APX5WebActivity.this.g = paramValueCallback;
      paramValueCallback = new Intent("android.intent.action.GET_CONTENT");
      paramValueCallback.addCategory("android.intent.category.OPENABLE");
      paramValueCallback.setType("image/*");
      APX5WebActivity.this.startActivityForResult(Intent.createChooser(paramValueCallback, "选择文件"), 1);
    }
  }
  
  public class b
    extends WebViewClient
  {
    public b() {}
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      APLog.i("APX5WebActivity", "onPageFinished");
      Object localObject = APX5WebActivity.this.e;
      if (localObject != null)
      {
        ((AP3PointsLoading)localObject).d();
        APX5WebActivity.this.e.setVisibility(8);
      }
      APX5WebActivity.this.d.setVisibility(0);
      localObject = APX5WebActivity.this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("javascript:");
      localStringBuilder.append(j.a);
      ((WebView)localObject).loadUrl(localStringBuilder.toString());
      APX5WebActivity.a(APX5WebActivity.this, false);
      localObject = APX5WebActivity.this.f.l;
      if (localObject != null) {
        ((d8)localObject).b(paramWebView, paramString);
      }
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      APLog.i("APX5WebActivity", "onPageStarted");
      if (!APX5WebActivity.a(APX5WebActivity.this))
      {
        d8 locald8 = APX5WebActivity.this.f.l;
        if (locald8 != null) {
          locald8.a(paramWebView, paramString, paramBitmap);
        }
      }
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceivedError errorCode,description ==");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramString1);
      APLog.i("APX5WebActivity", ((StringBuilder)localObject).toString());
      if (APX5WebActivity.b(APX5WebActivity.this) != null) {
        APX5WebActivity.c(APX5WebActivity.this).dismiss();
      }
      APX5WebActivity.a(APX5WebActivity.this, false);
      localObject = APX5WebActivity.this.f.l;
      if (localObject != null) {
        ((d8)localObject).a(paramWebView, paramInt, paramString1, paramString2);
      }
      APX5WebActivity.d(APX5WebActivity.this);
    }
    
    public void onReceivedHttpAuthRequest(WebView paramWebView, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
    {
      super.onReceivedHttpAuthRequest(paramWebView, paramHttpAuthHandler, paramString1, paramString2);
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      APLog.i("APX5WebActivity", "shouldOverrideUrlLoading");
      paramWebView.stopLoading();
      d8 locald8 = APX5WebActivity.this.f.l;
      if (locald8 != null) {
        locald8.a(paramWebView, paramString);
      }
      APX5WebActivity.a(APX5WebActivity.this, true);
      return super.shouldOverrideUrlLoading(paramWebView, paramString);
    }
  }
  
  public class c
    implements View.OnClickListener
  {
    public c() {}
    
    public void onClick(View paramView)
    {
      paramView = APDataReportManager.getInstance();
      APX5WebActivity localAPX5WebActivity = APX5WebActivity.this;
      paramView.insertData(localAPX5WebActivity.f.k, APX5WebActivity.e(localAPX5WebActivity));
      APX5WebActivity.this.n();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.payWeb.APX5WebActivity
 * JD-Core Version:    0.7.0.1
 */