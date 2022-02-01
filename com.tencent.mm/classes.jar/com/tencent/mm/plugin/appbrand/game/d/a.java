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
  private WebView klh;
  
  public final g.a CB()
  {
    AppMethodBeat.i(45121);
    g.a local1 = new g.a()
    {
      public final void CC()
      {
        AppMethodBeat.i(45114);
        this.kli.setJavaScriptEnabled(true);
        AppMethodBeat.o(45114);
      }
    };
    AppMethodBeat.o(45121);
    return local1;
  }
  
  public final void a(final g.b paramb)
  {
    AppMethodBeat.i(45122);
    this.klh.setWebViewClient(new ac()
    {
      private WebResourceResponse OS(String paramAnonymousString)
      {
        AppMethodBeat.i(45118);
        if (paramb.cM(paramAnonymousString))
        {
          paramAnonymousString = paramb.cQ(g.b.cjz);
          paramAnonymousString = new WebResourceResponse(paramAnonymousString.mimeType, paramAnonymousString.charset, paramAnonymousString.aFw);
          AppMethodBeat.o(45118);
          return paramAnonymousString;
        }
        AppMethodBeat.o(45118);
        return null;
      }
      
      public final WebResourceResponse a(WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest)
      {
        AppMethodBeat.i(45117);
        paramAnonymousWebView = OS(paramAnonymousWebResourceRequest.getUrl().toString());
        AppMethodBeat.o(45117);
        return paramAnonymousWebView;
      }
      
      public final WebResourceResponse a(WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(45116);
        paramAnonymousWebView = OS(paramAnonymousWebResourceRequest.getUrl().toString());
        AppMethodBeat.o(45116);
        return paramAnonymousWebView;
      }
      
      public final void b(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(45119);
        paramb.CA();
        AppMethodBeat.o(45119);
      }
      
      public final WebResourceResponse c(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(45115);
        paramAnonymousWebView = OS(paramAnonymousString);
        AppMethodBeat.o(45115);
        return paramAnonymousWebView;
      }
    });
    AppMethodBeat.o(45122);
  }
  
  public final void av(Context paramContext)
  {
    AppMethodBeat.i(45120);
    this.klh = new WebView(paramContext);
    AppMethodBeat.o(45120);
  }
  
  public final void cO(String paramString)
  {
    AppMethodBeat.i(45127);
    this.klh.evaluateJavascript(paramString, null);
    AppMethodBeat.o(45127);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(45128);
    this.klh.destroy();
    AppMethodBeat.o(45128);
  }
  
  public final View getView()
  {
    return this.klh;
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(45123);
    this.klh.loadUrl(paramString);
    AppMethodBeat.o(45123);
  }
  
  public final void requestLayout()
  {
    AppMethodBeat.i(45126);
    this.klh.requestLayout();
    AppMethodBeat.o(45126);
  }
  
  public final void setTranslationY(float paramFloat)
  {
    AppMethodBeat.i(45124);
    this.klh.setTranslationY(paramFloat);
    AppMethodBeat.o(45124);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(45125);
    this.klh.setVisibility(paramInt);
    AppMethodBeat.o(45125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.d.a
 * JD-Core Version:    0.7.0.1
 */