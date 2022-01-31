package com.tencent.luggage.bridge.impl;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.tencent.luggage.bridge.o;
import com.tencent.luggage.bridge.p;
import com.tencent.matrix.trace.core.AppMethodBeat;

class BridgedAndroidWebView$2
  extends WebChromeClient
{
  BridgedAndroidWebView$2(BridgedAndroidWebView paramBridgedAndroidWebView) {}
  
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    AppMethodBeat.i(90751);
    paramWebView = BridgedAndroidWebView.a(this.byx).byn.bx(paramString2);
    if (paramWebView != null)
    {
      paramJsPromptResult.confirm(paramWebView);
      AppMethodBeat.o(90751);
      return true;
    }
    AppMethodBeat.o(90751);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.bridge.impl.BridgedAndroidWebView.2
 * JD-Core Version:    0.7.0.1
 */