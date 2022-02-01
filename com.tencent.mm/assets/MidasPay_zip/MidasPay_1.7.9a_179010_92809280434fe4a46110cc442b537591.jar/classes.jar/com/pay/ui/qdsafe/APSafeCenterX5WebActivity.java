package com.pay.ui.qdsafe;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.pay.data.report.APDataReportManager;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginActivity;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebView.WebViewTransport;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.File;
import java.lang.reflect.Method;
import midas.x.i6.a;

public class APSafeCenterX5WebActivity
  extends APActivity
{
  public WebView d;
  
  public final void a(WebView paramWebView)
  {
    try
    {
      Method localMethod = paramWebView.getClass().getMethod("removeJavascriptInterface", new Class[] { String.class });
      if (localMethod != null)
      {
        localMethod.invoke(paramWebView, new Object[] { "searchBoxJavaBridge_" });
        localMethod.invoke(paramWebView, new Object[] { "accessibility" });
        localMethod.invoke(paramWebView, new Object[] { "accessibilityTraversal" });
        return;
      }
    }
    catch (Exception paramWebView)
    {
      APLog.i("removeJavascriptInterface", paramWebView.toString());
    }
  }
  
  public void a(String paramString)
  {
    ((TextView)findViewById(2131099769)).setText(paramString);
  }
  
  public void b(String paramString)
  {
    APLog.i("密保cgi", paramString);
    try
    {
      this.d = ((WebView)findViewById(2131099770));
      Object localObject = this.d.getSettings();
      ((WebSettings)localObject).setJavaScriptEnabled(true);
      ((WebSettings)localObject).setSupportMultipleWindows(true);
      ((WebSettings)localObject).setDomStorageEnabled(true);
      ((WebSettings)localObject).setAppCacheMaxSize(2097152L);
      ((WebSettings)localObject).setAppCachePath(getApplicationContext().getDir("cache", 0).getPath());
      ((WebSettings)localObject).setAllowFileAccess(true);
      ((WebSettings)localObject).setAppCacheEnabled(true);
      ((WebSettings)localObject).setCacheMode(-1);
      localObject = new c();
      d locald = new d();
      this.d.setWebViewClient((WebViewClient)localObject);
      this.d.setWebChromeClient(locald);
      a(this.d);
      this.d.loadUrl(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131165227);
    paramBundle = getIntent().getExtras();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("requesturl");
      if (!TextUtils.isEmpty(paramBundle)) {
        b(paramBundle);
      }
    }
    paramBundle = (Button)findViewById(2131099725);
    paramBundle.setText("返回");
    paramBundle.setOnClickListener(new a());
    ((Button)findViewById(2131099754)).setOnClickListener(new b());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    APDataReportManager.getInstance().insertData("sdk.mb.keyback", this.a);
    if ((paramInt == 4) && (this.d.canGoBack()))
    {
      this.d.goBack();
      return true;
    }
    finish();
    APUICommonMethod.a(this);
    return true;
  }
  
  public void onResume()
  {
    super.onResume();
    APDataReportManager.getInstance().insertData("sdk.mb.show", this.a);
  }
  
  public class a
    implements View.OnClickListener
  {
    public a() {}
    
    public void onClick(View paramView)
    {
      APDataReportManager.getInstance().insertData("sdk.mb.back", APSafeCenterX5WebActivity.a(APSafeCenterX5WebActivity.this));
      APSafeCenterX5WebActivity.this.setResult(-1);
      APSafeCenterX5WebActivity.this.finish();
      APUICommonMethod.a(APSafeCenterX5WebActivity.this);
    }
  }
  
  public class b
    implements View.OnClickListener
  {
    public b() {}
    
    public void onClick(View paramView)
    {
      APDataReportManager.getInstance().insertData("sdk.mb.fresh", APSafeCenterX5WebActivity.b(APSafeCenterX5WebActivity.this));
      paramView = (WebView)APSafeCenterX5WebActivity.this.findViewById(2131099770);
      APSafeCenterX5WebActivity.a(APSafeCenterX5WebActivity.this, paramView);
      paramView.reload();
    }
  }
  
  public class c
    extends WebViewClient
  {
    public c() {}
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      APSafeCenterX5WebActivity.a(APSafeCenterX5WebActivity.this, paramWebView);
      if (paramString.startsWith("http://unipay.mibaocheck")) {}
      try
      {
        paramString = paramString.split("=")[1].split("&")[0];
        paramWebView = paramString;
      }
      catch (Exception paramString)
      {
        label45:
        break label45;
      }
      APUICommonMethod.a(APSafeCenterX5WebActivity.this, "网络错误，请稍后重试");
      paramWebView.stopLoading();
      paramWebView = "";
      paramString = new Intent();
      paramString.putExtra("channel", i6.a.b);
      paramString.putExtra("sig", paramWebView);
      APSafeCenterX5WebActivity.this.setResult(10, paramString);
      APSafeCenterX5WebActivity.this.finish();
      APUICommonMethod.a(APSafeCenterX5WebActivity.this);
    }
  }
  
  public class d
    extends WebChromeClient
  {
    public d() {}
    
    public boolean onCreateWindow(WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage)
    {
      paramWebView = new WebView(paramWebView.getContext());
      APSafeCenterX5WebActivity.a(APSafeCenterX5WebActivity.this, paramWebView);
      paramWebView.getSettings().setJavaScriptEnabled(true);
      paramWebView.setWebChromeClient(this);
      paramWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
      ((WebView.WebViewTransport)paramMessage.obj).setWebView(paramWebView);
      paramMessage.sendToTarget();
      return true;
    }
    
    public void onReceivedTitle(WebView paramWebView, String paramString)
    {
      if ((paramString != null) && (!paramString.contains("html")) && (!paramString.contains("?"))) {
        APSafeCenterX5WebActivity.this.a(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.qdsafe.APSafeCenterX5WebActivity
 * JD-Core Version:    0.7.0.1
 */