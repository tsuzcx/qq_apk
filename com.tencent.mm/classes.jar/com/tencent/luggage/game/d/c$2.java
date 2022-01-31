package com.tencent.luggage.game.d;

import android.annotation.TargetApi;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$2
  extends WebViewClient
{
  c$2(c paramc, f.b paramb) {}
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(140382);
    this.bAw.uG();
    AppMethodBeat.o(140382);
  }
  
  @TargetApi(21)
  public final WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(140381);
    if (this.bAw.bO(paramWebResourceRequest.getUrl().toString()))
    {
      paramWebView = this.bAw.bR(f.b.bAN);
      paramWebView = new WebResourceResponse(paramWebView.mimeType, paramWebView.charset, paramWebView.bAO);
      AppMethodBeat.o(140381);
      return paramWebView;
    }
    AppMethodBeat.o(140381);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.d.c.2
 * JD-Core Version:    0.7.0.1
 */