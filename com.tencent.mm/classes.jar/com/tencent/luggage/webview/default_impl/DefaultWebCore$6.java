package com.tencent.luggage.webview.default_impl;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.tencent.luggage.webview.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

class DefaultWebCore$6
  extends WebChromeClient
{
  DefaultWebCore$6(a parama, a.a parama1) {}
  
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    AppMethodBeat.i(90929);
    paramWebView = this.bFH.bH(paramString2);
    if (paramWebView == null)
    {
      AppMethodBeat.o(90929);
      return false;
    }
    paramJsPromptResult.confirm(paramWebView);
    AppMethodBeat.o(90929);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.luggage.webview.default_impl.DefaultWebCore.6
 * JD-Core Version:    0.7.0.1
 */