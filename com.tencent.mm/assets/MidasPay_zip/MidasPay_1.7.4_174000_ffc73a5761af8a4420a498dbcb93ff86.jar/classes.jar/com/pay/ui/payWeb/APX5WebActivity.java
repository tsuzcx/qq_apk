package com.pay.ui.payWeb;

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
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APExtendInfo;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APTools;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APActivity;
import com.tencent.midas.comm.APLog;
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
import midas.x.ac;
import midas.x.el;
import midas.x.em;
import midas.x.et;
import midas.x.ez;
import midas.x.fa;
import midas.x.fy;
import midas.x.gf;
import midas.x.gn;
import midas.x.gu;
import midas.x.hn;
import midas.x.hu;
import midas.x.hv;
import midas.x.hy;
import midas.x.hz;
import midas.x.j;
import midas.x.w;

public class APX5WebActivity
  extends APActivity
{
  public static boolean b = true;
  private boolean a = false;
  final int c = 1;
  protected WebView d = null;
  protected AP3PointsLoading e = null;
  protected hv q = null;
  ValueCallback<Uri> r = null;
  WebChromeClient s = new WebChromeClient()
  {
    public void onCloseWindow(WebView paramAnonymousWebView)
    {
      APLog.d("APX5WebActivity", "onCloseWindow");
      if (APX5WebActivity.this.q.o != null) {
        APX5WebActivity.this.q.o.a(paramAnonymousWebView);
      }
    }
    
    public boolean onCreateWindow(WebView paramAnonymousWebView, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, Message paramAnonymousMessage)
    {
      APLog.d("APX5WebActivity", "onCreateWindow");
      if (APX5WebActivity.this.q.o != null) {
        APX5WebActivity.this.q.o.a(paramAnonymousWebView, paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousMessage);
      }
      return super.onCreateWindow(paramAnonymousWebView, paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousMessage);
    }
    
    public boolean onJsAlert(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
    {
      APLog.d("APX5WebActivity", "onJsAlert");
      if (APX5WebActivity.this.q.o != null) {
        APX5WebActivity.this.q.o.a(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousJsResult);
      }
      return true;
    }
    
    public void openFileChooser(ValueCallback<Uri> paramAnonymousValueCallback, String paramAnonymousString1, String paramAnonymousString2)
    {
      APX5WebActivity.this.r = paramAnonymousValueCallback;
      paramAnonymousValueCallback = new Intent("android.intent.action.GET_CONTENT");
      paramAnonymousValueCallback.addCategory("android.intent.category.OPENABLE");
      paramAnonymousValueCallback.setType("image/*");
      APX5WebActivity.this.startActivityForResult(Intent.createChooser(paramAnonymousValueCallback, "选择文件"), 1);
    }
  };
  WebViewClient t = new WebViewClient()
  {
    public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
      APLog.i("APX5WebActivity", "onPageFinished");
      if (APX5WebActivity.this.e != null)
      {
        APX5WebActivity.this.e.a();
        APX5WebActivity.this.e.setVisibility(8);
      }
      APX5WebActivity.this.d.setVisibility(0);
      WebView localWebView = APX5WebActivity.this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("javascript:");
      localStringBuilder.append(j.a);
      localWebView.loadUrl(localStringBuilder.toString());
      APX5WebActivity.a(APX5WebActivity.this, false);
      if (APX5WebActivity.this.q.n != null) {
        APX5WebActivity.this.q.n.b(paramAnonymousWebView, paramAnonymousString);
      }
    }
    
    public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
    {
      super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
      APLog.i("APX5WebActivity", "onPageStarted");
      if ((!APX5WebActivity.a(APX5WebActivity.this)) && (APX5WebActivity.this.q.n != null)) {
        APX5WebActivity.this.q.n.a(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
      }
    }
    
    public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
    {
      super.onReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceivedError errorCode,description ==");
      localStringBuilder.append(paramAnonymousInt);
      localStringBuilder.append(",");
      localStringBuilder.append(paramAnonymousString1);
      APLog.i("APX5WebActivity", localStringBuilder.toString());
      if (APX5WebActivity.b(APX5WebActivity.this) != null) {
        APX5WebActivity.c(APX5WebActivity.this).dismiss();
      }
      APX5WebActivity.a(APX5WebActivity.this, false);
      if (APX5WebActivity.this.q.n != null) {
        APX5WebActivity.this.q.n.a(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
      }
      APX5WebActivity.d(APX5WebActivity.this);
    }
    
    public void onReceivedHttpAuthRequest(WebView paramAnonymousWebView, HttpAuthHandler paramAnonymousHttpAuthHandler, String paramAnonymousString1, String paramAnonymousString2)
    {
      super.onReceivedHttpAuthRequest(paramAnonymousWebView, paramAnonymousHttpAuthHandler, paramAnonymousString1, paramAnonymousString2);
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      APLog.i("APX5WebActivity", "shouldOverrideUrlLoading");
      paramAnonymousWebView.stopLoading();
      if (APX5WebActivity.this.q.n != null) {
        APX5WebActivity.this.q.n.a(paramAnonymousWebView, paramAnonymousString);
      }
      APX5WebActivity.a(APX5WebActivity.this, true);
      return super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousString);
    }
  };
  
  private void l()
  {
    APDataReportManager.getInstance().insertData(this.q.k, this.f);
    View localView = LayoutInflater.from(this).inflate(2131165266, null);
    setContentView(localView);
    ((Button)localView.findViewById(2131099861)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APDataReportManager.getInstance().insertData(APX5WebActivity.this.q.l, APX5WebActivity.e(APX5WebActivity.this));
        APX5WebActivity.this.j();
      }
    });
  }
  
  protected void a() {}
  
  protected void a(WebView paramWebView)
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
  
  protected void b()
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
  
  public void c() {}
  
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
    this.q.p.put("saveType", String.valueOf(em.b().n().a.saveType));
    this.q.p.put("gameCoinName", APTools.a(em.b().n().b.b, 1));
    this.q.p.put("gameCoinRate", em.b().n().b.e);
    this.q.p.put("recommendList", APTools.a(hn.a().b(), ","));
    this.q.p.put("minNumber", String.valueOf(em.b().n().b.h));
    this.q.p.put("sdkVersion", "1.7.4");
    this.q.p.put("sessionToken", em.b().n().e.l);
    this.q.p.put("mpJson", APTools.a(ac.a().f(), 1));
    this.q.p.put("gameCoinUnit", APTools.a(em.b().n().a.extendInfo.unit, 1));
    HashMap localHashMap = this.q.p;
    if (em.b().n().a.extendInfo.isShowNum) {
      str = "1";
    } else {
      str = "0";
    }
    localHashMap.put("showNum", str);
    this.q.p.put("uuid", APTools.a(fy.a().i(), 1));
    this.q.p.put("drm_resource", gf.b().e());
    this.q.p.put("payChannel", String.valueOf(gn.a(em.b().n().e.f)));
    this.q.p.put("payChannelName", em.b().n().e.f);
    String str = fy.a().g();
    if ("AndroidPay".equals(str)) {
      this.q.p.put("entry", "game");
    } else if ("APPayGameListNumActivity".equals(str)) {
      this.q.p.put("entry", "sdk");
    }
    this.q.p.put("hasMpTuan", w.a().d());
    if (em.b().n().d.b)
    {
      this.q.p.put("firstCharge", "1");
      return;
    }
    this.q.p.put("firstCharge", "0");
  }
  
  protected void h() {}
  
  protected String i()
  {
    return null;
  }
  
  protected void j()
  {
    c();
    d();
    k();
    h();
    a();
    a(this.d);
    b();
    this.d.setScrollBarStyle(0);
    this.d.setWebChromeClient(this.s);
    this.d.setWebViewClient(this.t);
    APLog.i("apWebData.webUrl == ", i());
    this.d.loadUrl(i());
  }
  
  protected void k() {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if (this.r == null) {
        return;
      }
      if ((paramIntent != null) && (paramInt2 == -1)) {
        paramIntent = paramIntent.getData();
      } else {
        paramIntent = null;
      }
      this.r.onReceiveValue(paramIntent);
      this.r = null;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.ui.payWeb.APX5WebActivity
 * JD-Core Version:    0.7.0.1
 */