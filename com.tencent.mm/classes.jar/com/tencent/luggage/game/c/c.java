package com.tencent.luggage.game.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  implements g
{
  private WebView cbL;
  
  public final g.a By()
  {
    AppMethodBeat.i(130504);
    g.a local1 = new g.a()
    {
      public final void Bz()
      {
        AppMethodBeat.i(130500);
        this.cbM.setJavaScriptEnabled(true);
        AppMethodBeat.o(130500);
      }
    };
    AppMethodBeat.o(130504);
    return local1;
  }
  
  public final void a(final g.b paramb)
  {
    AppMethodBeat.i(130505);
    this.cbL.setWebViewClient(new WebViewClient()
    {
      public final void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(130502);
        paramb.Bx();
        AppMethodBeat.o(130502);
      }
      
      @TargetApi(21)
      public final WebResourceResponse shouldInterceptRequest(WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest)
      {
        AppMethodBeat.i(130501);
        if (paramb.cd(paramAnonymousWebResourceRequest.getUrl().toString()))
        {
          paramAnonymousWebView = paramb.cg(g.b.cck);
          paramAnonymousWebView = new WebResourceResponse(paramAnonymousWebView.mimeType, paramAnonymousWebView.charset, paramAnonymousWebView.aCO);
          AppMethodBeat.o(130501);
          return paramAnonymousWebView;
        }
        AppMethodBeat.o(130501);
        return null;
      }
    });
    AppMethodBeat.o(130505);
  }
  
  public final void au(Context paramContext)
  {
    AppMethodBeat.i(130503);
    this.cbL = new WebView(paramContext);
    AppMethodBeat.o(130503);
  }
  
  public final void bO(String paramString)
  {
    AppMethodBeat.i(130510);
    this.cbL.evaluateJavascript(paramString, null);
    AppMethodBeat.o(130510);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(130511);
    this.cbL.destroy();
    AppMethodBeat.o(130511);
  }
  
  public final View getView()
  {
    return this.cbL;
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(130506);
    this.cbL.loadUrl(paramString);
    AppMethodBeat.o(130506);
  }
  
  public final void requestLayout()
  {
    AppMethodBeat.i(130509);
    this.cbL.requestLayout();
    AppMethodBeat.o(130509);
  }
  
  public final void setTranslationY(float paramFloat)
  {
    AppMethodBeat.i(130507);
    this.cbL.setTranslationY(paramFloat);
    AppMethodBeat.o(130507);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(130508);
    this.cbL.setVisibility(paramInt);
    AppMethodBeat.o(130508);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.c.c
 * JD-Core Version:    0.7.0.1
 */