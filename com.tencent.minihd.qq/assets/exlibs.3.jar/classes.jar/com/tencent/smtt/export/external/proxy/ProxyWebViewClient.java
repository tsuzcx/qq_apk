package com.tencent.smtt.export.external.proxy;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;

public abstract class ProxyWebViewClient
  implements IX5WebViewClient
{
  private boolean mCompatibleOnPageStartedOrFinishedMethod = false;
  protected IX5WebViewClient mWebViewClient;
  
  public void countPVContentCacheCallBack(String paramString) {}
  
  public void doUpdateVisitedHistory(IX5WebViewBase paramIX5WebViewBase, String paramString, boolean paramBoolean)
  {
    if (this.mWebViewClient != null) {
      this.mWebViewClient.doUpdateVisitedHistory(paramIX5WebViewBase, paramString, paramBoolean);
    }
  }
  
  public void onContentSizeChanged(IX5WebViewBase paramIX5WebViewBase, int paramInt1, int paramInt2)
  {
    if (this.mWebViewClient != null) {
      this.mWebViewClient.onContentSizeChanged(paramIX5WebViewBase, paramInt1, paramInt2);
    }
  }
  
  public void onDetectedBlankScreen(IX5WebViewBase paramIX5WebViewBase, String paramString, int paramInt) {}
  
  public void onFormResubmission(IX5WebViewBase paramIX5WebViewBase, Message paramMessage1, Message paramMessage2)
  {
    if (this.mWebViewClient != null) {
      this.mWebViewClient.onFormResubmission(paramIX5WebViewBase, paramMessage1, paramMessage2);
    }
  }
  
  public void onLoadResource(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    if (this.mWebViewClient != null) {
      this.mWebViewClient.onLoadResource(paramIX5WebViewBase, paramString);
    }
  }
  
  public void onPageCommitVisible(IX5WebViewBase paramIX5WebViewBase, String paramString) {}
  
  public void onPageFinished(IX5WebViewBase paramIX5WebViewBase, int paramInt1, int paramInt2, String paramString) {}
  
  public void onPageFinished(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    if (this.mWebViewClient != null) {
      this.mWebViewClient.onPageFinished(paramIX5WebViewBase, paramString);
    }
  }
  
  public void onPageStarted(IX5WebViewBase paramIX5WebViewBase, int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap) {}
  
  public void onPageStarted(IX5WebViewBase paramIX5WebViewBase, String paramString, Bitmap paramBitmap)
  {
    if (this.mWebViewClient != null) {
      this.mWebViewClient.onPageStarted(paramIX5WebViewBase, paramString, paramBitmap);
    }
  }
  
  public void onReceivedClientCertRequest(IX5WebViewBase paramIX5WebViewBase, ClientCertRequest paramClientCertRequest)
  {
    if (this.mWebViewClient != null) {
      this.mWebViewClient.onReceivedClientCertRequest(paramIX5WebViewBase, paramClientCertRequest);
    }
  }
  
  public void onReceivedError(IX5WebViewBase paramIX5WebViewBase, int paramInt, String paramString1, String paramString2)
  {
    if (this.mWebViewClient != null) {
      this.mWebViewClient.onReceivedError(paramIX5WebViewBase, paramInt, paramString1, paramString2);
    }
  }
  
  public void onReceivedError(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
  {
    if (this.mWebViewClient != null) {
      this.mWebViewClient.onReceivedError(paramIX5WebViewBase, paramWebResourceRequest, paramWebResourceError);
    }
  }
  
  public void onReceivedHttpAuthRequest(IX5WebViewBase paramIX5WebViewBase, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    if (this.mWebViewClient != null) {
      this.mWebViewClient.onReceivedHttpAuthRequest(paramIX5WebViewBase, paramHttpAuthHandler, paramString1, paramString2);
    }
  }
  
  public void onReceivedHttpError(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    if (this.mWebViewClient != null) {
      this.mWebViewClient.onReceivedHttpError(paramIX5WebViewBase, paramWebResourceRequest, paramWebResourceResponse);
    }
  }
  
  public void onReceivedLoginRequest(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, String paramString3)
  {
    if (this.mWebViewClient != null) {
      this.mWebViewClient.onReceivedLoginRequest(paramIX5WebViewBase, paramString1, paramString2, paramString3);
    }
  }
  
  public void onReceivedSslError(IX5WebViewBase paramIX5WebViewBase, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    if (this.mWebViewClient != null) {
      this.mWebViewClient.onReceivedSslError(paramIX5WebViewBase, paramSslErrorHandler, paramSslError);
    }
  }
  
  public void onScaleChanged(IX5WebViewBase paramIX5WebViewBase, float paramFloat1, float paramFloat2)
  {
    if (this.mWebViewClient != null) {
      this.mWebViewClient.onScaleChanged(paramIX5WebViewBase, paramFloat1, paramFloat2);
    }
  }
  
  public void onTooManyRedirects(IX5WebViewBase paramIX5WebViewBase, Message paramMessage1, Message paramMessage2)
  {
    if (this.mWebViewClient != null) {
      this.mWebViewClient.onTooManyRedirects(paramIX5WebViewBase, paramMessage1, paramMessage2);
    }
  }
  
  public void onUnhandledKeyEvent(IX5WebViewBase paramIX5WebViewBase, KeyEvent paramKeyEvent)
  {
    if (this.mWebViewClient != null) {
      this.mWebViewClient.onUnhandledKeyEvent(paramIX5WebViewBase, paramKeyEvent);
    }
  }
  
  public void setWebViewClient(IX5WebViewClient paramIX5WebViewClient)
  {
    this.mWebViewClient = paramIX5WebViewClient;
  }
  
  public WebResourceResponse shouldInterceptRequest(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest)
  {
    if (this.mWebViewClient != null) {
      return this.mWebViewClient.shouldInterceptRequest(paramIX5WebViewBase, paramWebResourceRequest);
    }
    return null;
  }
  
  public WebResourceResponse shouldInterceptRequest(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    if (this.mWebViewClient != null) {
      return this.mWebViewClient.shouldInterceptRequest(paramIX5WebViewBase, paramWebResourceRequest, paramBundle);
    }
    return null;
  }
  
  public WebResourceResponse shouldInterceptRequest(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    if (this.mWebViewClient != null) {
      return this.mWebViewClient.shouldInterceptRequest(paramIX5WebViewBase, paramString);
    }
    return null;
  }
  
  public boolean shouldOverrideKeyEvent(IX5WebViewBase paramIX5WebViewBase, KeyEvent paramKeyEvent)
  {
    return (this.mWebViewClient != null) && (this.mWebViewClient.shouldOverrideKeyEvent(paramIX5WebViewBase, paramKeyEvent));
  }
  
  public boolean shouldOverrideUrlLoading(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest)
  {
    return (this.mWebViewClient != null) && (this.mWebViewClient.shouldOverrideUrlLoading(paramIX5WebViewBase, paramWebResourceRequest));
  }
  
  public boolean shouldOverrideUrlLoading(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    return (this.mWebViewClient != null) && (this.mWebViewClient.shouldOverrideUrlLoading(paramIX5WebViewBase, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.export.external.proxy.ProxyWebViewClient
 * JD-Core Version:    0.7.0.1
 */