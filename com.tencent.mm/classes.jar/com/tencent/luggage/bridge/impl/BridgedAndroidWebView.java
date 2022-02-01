package com.tencent.luggage.bridge.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.luggage.bridge.o;
import com.tencent.luggage.bridge.p;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BridgedAndroidWebView
  extends BridgedAndroidWebViewBase
{
  private o cgI;
  private WebViewClient cgX;
  private WebChromeClient cgY;
  
  public BridgedAndroidWebView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BridgedAndroidWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BridgedAndroidWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(140352);
    this.cgX = new WebViewClient()
    {
      public final void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(140350);
        BridgedAndroidWebView.a(BridgedAndroidWebView.this).cgP.onReady();
        AppMethodBeat.o(140350);
      }
      
      public final void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(140349);
        BridgedAndroidWebView.a(BridgedAndroidWebView.this);
        AppMethodBeat.o(140349);
      }
    };
    this.cgY = new WebChromeClient()
    {
      public boolean onJsPrompt(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, JsPromptResult paramAnonymousJsPromptResult)
      {
        AppMethodBeat.i(140351);
        paramAnonymousWebView = BridgedAndroidWebView.a(BridgedAndroidWebView.this).cgP.cw(paramAnonymousString2);
        if (paramAnonymousWebView != null)
        {
          paramAnonymousJsPromptResult.confirm(paramAnonymousWebView);
          AppMethodBeat.o(140351);
          return true;
        }
        AppMethodBeat.o(140351);
        return false;
      }
    };
    this.cgI = new o(this);
    setWebViewClient(this.cgX);
    setWebChromeClient(this.cgY);
    AppMethodBeat.o(140352);
  }
  
  public o getBridge()
  {
    return this.cgI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.impl.BridgedAndroidWebView
 * JD-Core Version:    0.7.0.1
 */