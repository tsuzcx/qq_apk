package com.tencent.biz.pubaccount;

import android.graphics.Bitmap;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.webviewplugin.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class CustomWebViewClient
  extends WebViewClient
{
  public static final String a = "WEBVIEWCHECK";
  protected WebViewPluginEngine a;
  
  public CustomWebViewClient(WebViewPluginEngine paramWebViewPluginEngine)
  {
    this.a = paramWebViewPluginEngine;
  }
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WEBVIEWCHECK", 2, "CustomWebView loadUrl url:" + paramString);
    }
    super.onLoadResource(paramWebView, paramString);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if (this.a != null) {
      this.a.a(paramString, 1, null);
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    if (this.a != null) {
      this.a.a(paramString, 0, null);
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WEBVIEWCHECK", 2, "CustomWebViewClient onReceivedError errorCode:" + paramInt + ", description:" + paramString1 + ", failingUrl:" + paramString2);
    }
    if (this.a != null) {
      this.a.a(paramString2, 2, paramInt);
    }
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    if (this.a == null) {
      return null;
    }
    try
    {
      paramWebView = (WebResourceResponse)this.a.a(paramString, 11);
      return paramWebView;
    }
    catch (Exception paramWebView)
    {
      for (;;)
      {
        paramWebView = null;
      }
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    boolean bool2 = true;
    if (this.a == null) {}
    do
    {
      if ((paramString != null) && ((paramString.startsWith("http")) || (paramString.startsWith("data:"))) && (!paramString.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
        CustomWebView.b(Util.b(paramString, new String[0]));
      }
      boolean bool1 = false;
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this.a.b(paramString));
        bool1 = bool2;
      } while (this.a.a(paramString));
    } while (!this.a.c(paramString));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.pubaccount.CustomWebViewClient
 * JD-Core Version:    0.7.0.1
 */