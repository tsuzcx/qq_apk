package com.tencent.luggage.bridge.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import com.tencent.luggage.bridge.o;

public class BridgedAndroidWebView
  extends BridgedAndroidWebViewBase
{
  private o bhF = new o(this);
  private WebViewClient bhV = new BridgedAndroidWebView.1(this);
  private WebChromeClient bhW = new BridgedAndroidWebView.2(this);
  
  public BridgedAndroidWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BridgedAndroidWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setWebViewClient(this.bhV);
    setWebChromeClient(this.bhW);
  }
  
  public o getBridge()
  {
    return this.bhF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.bridge.impl.BridgedAndroidWebView
 * JD-Core Version:    0.7.0.1
 */