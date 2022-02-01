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
import com.tencent.xweb.ab;
import com.tencent.xweb.y;

public final class a
  implements g
{
  private WebView jqA;
  
  public final g.a By()
  {
    AppMethodBeat.i(45121);
    g.a local1 = new g.a()
    {
      public final void Bz()
      {
        AppMethodBeat.i(45114);
        this.jqB.setJavaScriptEnabled(true);
        AppMethodBeat.o(45114);
      }
    };
    AppMethodBeat.o(45121);
    return local1;
  }
  
  public final void a(final g.b paramb)
  {
    AppMethodBeat.i(45122);
    this.jqA.setWebViewClient(new ab()
    {
      private WebResourceResponse Hu(String paramAnonymousString)
      {
        AppMethodBeat.i(45118);
        if (paramb.cd(paramAnonymousString))
        {
          paramAnonymousString = paramb.cg(g.b.cck);
          paramAnonymousString = new WebResourceResponse(paramAnonymousString.mimeType, paramAnonymousString.charset, paramAnonymousString.aCO);
          AppMethodBeat.o(45118);
          return paramAnonymousString;
        }
        AppMethodBeat.o(45118);
        return null;
      }
      
      public final WebResourceResponse a(WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest)
      {
        AppMethodBeat.i(45117);
        paramAnonymousWebView = Hu(paramAnonymousWebResourceRequest.getUrl().toString());
        AppMethodBeat.o(45117);
        return paramAnonymousWebView;
      }
      
      public final WebResourceResponse a(WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(45116);
        paramAnonymousWebView = Hu(paramAnonymousWebResourceRequest.getUrl().toString());
        AppMethodBeat.o(45116);
        return paramAnonymousWebView;
      }
      
      public final void b(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(45119);
        paramb.Bx();
        AppMethodBeat.o(45119);
      }
      
      public final WebResourceResponse c(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(45115);
        paramAnonymousWebView = Hu(paramAnonymousString);
        AppMethodBeat.o(45115);
        return paramAnonymousWebView;
      }
    });
    AppMethodBeat.o(45122);
  }
  
  public final void au(Context paramContext)
  {
    AppMethodBeat.i(45120);
    this.jqA = new WebView(paramContext);
    AppMethodBeat.o(45120);
  }
  
  public final void bO(String paramString)
  {
    AppMethodBeat.i(45127);
    this.jqA.evaluateJavascript(paramString, null);
    AppMethodBeat.o(45127);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(45128);
    this.jqA.destroy();
    AppMethodBeat.o(45128);
  }
  
  public final View getView()
  {
    return this.jqA;
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(45123);
    this.jqA.loadUrl(paramString);
    AppMethodBeat.o(45123);
  }
  
  public final void requestLayout()
  {
    AppMethodBeat.i(45126);
    this.jqA.requestLayout();
    AppMethodBeat.o(45126);
  }
  
  public final void setTranslationY(float paramFloat)
  {
    AppMethodBeat.i(45124);
    this.jqA.setTranslationY(paramFloat);
    AppMethodBeat.o(45124);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(45125);
    this.jqA.setVisibility(paramInt);
    AppMethodBeat.o(45125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.d.a
 * JD-Core Version:    0.7.0.1
 */