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
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebView.WebViewTransport;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.File;
import java.lang.reflect.Method;
import midas.x.fu.a;

public class APSafeCenterX5WebActivity
  extends APActivity
{
  WebView a;
  
  private void a(WebView paramWebView)
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
    APLog.i("密保cgi", paramString);
    try
    {
      this.a = ((WebView)findViewById(2131099770));
      Object localObject = this.a.getSettings();
      ((WebSettings)localObject).setJavaScriptEnabled(true);
      ((WebSettings)localObject).setSupportMultipleWindows(true);
      ((WebSettings)localObject).setDomStorageEnabled(true);
      ((WebSettings)localObject).setAppCacheMaxSize(2097152L);
      ((WebSettings)localObject).setAppCachePath(getApplicationContext().getDir("cache", 0).getPath());
      ((WebSettings)localObject).setAllowFileAccess(true);
      ((WebSettings)localObject).setAppCacheEnabled(true);
      ((WebSettings)localObject).setCacheMode(-1);
      localObject = new WebViewClient()
      {
        public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
        }
        
        public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
        {
          super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
          APSafeCenterX5WebActivity.a(APSafeCenterX5WebActivity.this, paramAnonymousWebView);
          if (paramAnonymousString.startsWith("http://unipay.mibaocheck")) {}
          try
          {
            paramAnonymousString = paramAnonymousString.split("=")[1].split("&")[0];
            paramAnonymousWebView = paramAnonymousString;
          }
          catch (Exception paramAnonymousString)
          {
            label45:
            break label45;
          }
          paramAnonymousString = "";
          APUICommonMethod.a(APSafeCenterX5WebActivity.this, "网络错误，请稍后重试");
          paramAnonymousWebView.stopLoading();
          paramAnonymousWebView = paramAnonymousString;
          paramAnonymousString = new Intent();
          paramAnonymousString.putExtra("channel", fu.a.b);
          paramAnonymousString.putExtra("sig", paramAnonymousWebView);
          APSafeCenterX5WebActivity.this.setResult(10, paramAnonymousString);
          APSafeCenterX5WebActivity.this.finish();
          APUICommonMethod.b(APSafeCenterX5WebActivity.this);
        }
      };
      WebChromeClient local4 = new WebChromeClient()
      {
        public boolean onCreateWindow(WebView paramAnonymousWebView, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, Message paramAnonymousMessage)
        {
          paramAnonymousWebView = new WebView(paramAnonymousWebView.getContext());
          APSafeCenterX5WebActivity.a(APSafeCenterX5WebActivity.this, paramAnonymousWebView);
          paramAnonymousWebView.getSettings().setJavaScriptEnabled(true);
          paramAnonymousWebView.setWebChromeClient(this);
          paramAnonymousWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
          ((WebView.WebViewTransport)paramAnonymousMessage.obj).setWebView(paramAnonymousWebView);
          paramAnonymousMessage.sendToTarget();
          return true;
        }
        
        public void onReceivedTitle(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          if ((paramAnonymousString != null) && (!paramAnonymousString.contains("html")) && (!paramAnonymousString.contains("?"))) {
            APSafeCenterX5WebActivity.this.b(paramAnonymousString);
          }
        }
      };
      this.a.setWebViewClient((WebViewClient)localObject);
      this.a.setWebChromeClient(local4);
      a(this.a);
      this.a.loadUrl(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void b(String paramString)
  {
    ((TextView)findViewById(2131099769)).setText(paramString);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131165226);
    paramBundle = getIntent().getExtras();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("requesturl");
      if (!TextUtils.isEmpty(paramBundle)) {
        a(paramBundle);
      }
    }
    paramBundle = (Button)findViewById(2131099725);
    paramBundle.setText("返回");
    paramBundle.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APDataReportManager.getInstance().insertData("sdk.mb.back", APSafeCenterX5WebActivity.a(APSafeCenterX5WebActivity.this));
        APSafeCenterX5WebActivity.this.setResult(-1);
        APSafeCenterX5WebActivity.this.finish();
        APUICommonMethod.b(APSafeCenterX5WebActivity.this);
      }
    });
    ((Button)findViewById(2131099754)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APDataReportManager.getInstance().insertData("sdk.mb.fresh", APSafeCenterX5WebActivity.b(APSafeCenterX5WebActivity.this));
        paramAnonymousView = (WebView)APSafeCenterX5WebActivity.this.findViewById(2131099770);
        APSafeCenterX5WebActivity.a(APSafeCenterX5WebActivity.this, paramAnonymousView);
        paramAnonymousView.reload();
      }
    });
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    APDataReportManager.getInstance().insertData("sdk.mb.keyback", this.f);
    if ((paramInt == 4) && (this.a.canGoBack()))
    {
      this.a.goBack();
      return true;
    }
    finish();
    APUICommonMethod.b(this);
    return true;
  }
  
  public void onResume()
  {
    super.onResume();
    APDataReportManager.getInstance().insertData("sdk.mb.show", this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.ui.qdsafe.APSafeCenterX5WebActivity
 * JD-Core Version:    0.7.0.1
 */