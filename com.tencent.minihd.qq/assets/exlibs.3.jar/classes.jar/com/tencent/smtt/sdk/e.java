package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;

class e
  extends SystemWebChromeClient
{
  e(WebView paramWebView, WebChromeClient paramWebChromeClient)
  {
    super(paramWebView, paramWebChromeClient);
  }
  
  @TargetApi(7)
  public void onHideCustomView()
  {
    this.a.onHideCustomView();
  }
  
  @Deprecated
  @TargetApi(14)
  public void onShowCustomView(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.a.onShowCustomView(paramView, paramInt, new SystemWebChromeClient.b(this, paramCustomViewCallback));
  }
  
  @TargetApi(7)
  public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.a.onShowCustomView(paramView, new SystemWebChromeClient.b(this, paramCustomViewCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.e
 * JD-Core Version:    0.7.0.1
 */