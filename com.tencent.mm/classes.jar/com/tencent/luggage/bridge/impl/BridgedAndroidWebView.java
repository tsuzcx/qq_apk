package com.tencent.luggage.bridge.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import com.tencent.luggage.bridge.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BridgedAndroidWebView
  extends BridgedAndroidWebViewBase
{
  private o byf;
  private WebViewClient byv;
  private WebChromeClient byw;
  
  public BridgedAndroidWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BridgedAndroidWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(90752);
    this.byv = new BridgedAndroidWebView.1(this);
    this.byw = new BridgedAndroidWebView.2(this);
    this.byf = new o(this);
    setWebViewClient(this.byv);
    setWebChromeClient(this.byw);
    AppMethodBeat.o(90752);
  }
  
  public o getBridge()
  {
    return this.byf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.bridge.impl.BridgedAndroidWebView
 * JD-Core Version:    0.7.0.1
 */