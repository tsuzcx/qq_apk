package com.tencent.mm.plugin.appbrand.game.d;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.luggage.game.c.g;
import com.tencent.luggage.game.c.g.a;
import com.tencent.luggage.game.c.g.b;
import com.tencent.luggage.game.c.g.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.z;

public final class a
  implements g
{
  private WebView lsg;
  
  public final g.a Ma()
  {
    AppMethodBeat.i(45121);
    g.a local1 = new g.a()
    {
      public final void Mb()
      {
        AppMethodBeat.i(45114);
        this.lsh.setJavaScriptEnabled(true);
        AppMethodBeat.o(45114);
      }
    };
    AppMethodBeat.o(45121);
    return local1;
  }
  
  public final void a(final g.b paramb)
  {
    AppMethodBeat.i(45122);
    this.lsg.setWebViewClient(new ac()
    {
      private WebResourceResponse YL(String paramAnonymousString)
      {
        AppMethodBeat.i(45118);
        if (paramb.dn(paramAnonymousString))
        {
          paramAnonymousString = paramb.dr(g.b.cvx);
          paramAnonymousString = new WebResourceResponse(paramAnonymousString.mimeType, paramAnonymousString.charset, paramAnonymousString.aFm);
          AppMethodBeat.o(45118);
          return paramAnonymousString;
        }
        AppMethodBeat.o(45118);
        return null;
      }
      
      public final WebResourceResponse a(WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest)
      {
        AppMethodBeat.i(45117);
        paramAnonymousWebView = YL(paramAnonymousWebResourceRequest.getUrl().toString());
        AppMethodBeat.o(45117);
        return paramAnonymousWebView;
      }
      
      public final WebResourceResponse a(WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(45116);
        paramAnonymousWebView = YL(paramAnonymousWebResourceRequest.getUrl().toString());
        AppMethodBeat.o(45116);
        return paramAnonymousWebView;
      }
      
      public final void b(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(45119);
        paramb.LZ();
        AppMethodBeat.o(45119);
      }
      
      public final WebResourceResponse c(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(45115);
        paramAnonymousWebView = YL(paramAnonymousString);
        AppMethodBeat.o(45115);
        return paramAnonymousWebView;
      }
    });
    AppMethodBeat.o(45122);
  }
  
  public final void aF(Context paramContext)
  {
    AppMethodBeat.i(45120);
    this.lsg = new WebView(paramContext);
    AppMethodBeat.o(45120);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(45128);
    this.lsg.destroy();
    AppMethodBeat.o(45128);
  }
  
  public final void dp(String paramString)
  {
    AppMethodBeat.i(45127);
    this.lsg.evaluateJavascript(paramString, null);
    AppMethodBeat.o(45127);
  }
  
  public final View getView()
  {
    return this.lsg;
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(45123);
    this.lsg.loadUrl(paramString);
    AppMethodBeat.o(45123);
  }
  
  public final void requestLayout()
  {
    AppMethodBeat.i(45126);
    this.lsg.requestLayout();
    AppMethodBeat.o(45126);
  }
  
  public final void setTranslationY(float paramFloat)
  {
    AppMethodBeat.i(45124);
    this.lsg.setTranslationY(paramFloat);
    AppMethodBeat.o(45124);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(45125);
    this.lsg.setVisibility(paramInt);
    AppMethodBeat.o(45125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.d.a
 * JD-Core Version:    0.7.0.1
 */