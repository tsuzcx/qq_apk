package com.tencent.mm.plugin.game.luggage;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.q;
import com.tencent.luggage.webview.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.g.h;
import com.tencent.mm.plugin.webview.luggage.LuggageMMLocalResourceProvider;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.xweb.WebView;
import org.json.JSONObject;

public class i
  extends h
{
  public i(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(232078);
    if (this.CCu != null) {
      this.CCu.QLj = true;
    }
    AppMethodBeat.o(232078);
  }
  
  public final void Ou()
  {
    AppMethodBeat.i(83028);
    getWebCore().crO = new q()
    {
      public final String Oz()
      {
        AppMethodBeat.i(83025);
        String str = com.tencent.mm.plugin.appbrand.ac.d.anc("preload_game_adapter.js");
        AppMethodBeat.o(83025);
        return str;
      }
      
      public final WebResourceResponse a(WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        return null;
      }
      
      public final void dv(String paramAnonymousString) {}
      
      public final void dw(String paramAnonymousString) {}
    };
    if (getWebCore().crR != null)
    {
      getWebCore().crR.a(new LuggageMMLocalResourceProvider());
      getWebCore().crR.a(new e(com.tencent.mm.plugin.appbrand.ac.d.anc("preload_game_adapter.js")));
    }
    AppMethodBeat.o(83028);
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(83030);
    super.b(paramWebView, paramString);
    AppMethodBeat.o(83030);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(83029);
    super.b(paramWebView, paramString, paramBitmap);
    AppMethodBeat.o(83029);
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(232080);
    super.loadUrl(paramString);
    g.b(getWebCore(), paramString);
    AppMethodBeat.o(232080);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(83026);
    super.onAttachedToWindow();
    getWebCore().a(new com.tencent.luggage.d.d()
    {
      public final JSONObject NU()
      {
        return null;
      }
      
      public final String name()
      {
        return "onJsApiReady";
      }
    });
    AppMethodBeat.o(83026);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(83027);
    super.onDetachedFromWindow();
    AppMethodBeat.o(83027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.i
 * JD-Core Version:    0.7.0.1
 */