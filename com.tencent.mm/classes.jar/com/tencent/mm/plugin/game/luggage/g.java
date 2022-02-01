package com.tencent.mm.plugin.game.luggage;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.d.c;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.l;
import com.tencent.luggage.webview.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d.e;
import com.tencent.mm.plugin.webview.luggage.LuggageMMLocalResourceProvider;
import com.tencent.xweb.WebView;
import org.json.JSONObject;

public class g
  extends e
{
  public g(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void Bg()
  {
    AppMethodBeat.i(83028);
    getWebCore().cau = new l()
    {
      public final String Bm()
      {
        AppMethodBeat.i(83025);
        String str = com.tencent.mm.plugin.appbrand.aa.d.Ne("preload_game_adapter.js");
        AppMethodBeat.o(83025);
        return str;
      }
      
      public final WebResourceResponse a(WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        return null;
      }
      
      public final void bU(String paramAnonymousString) {}
      
      public final void bV(String paramAnonymousString) {}
    };
    if (getWebCore().cay != null)
    {
      getWebCore().cay.a(new LuggageMMLocalResourceProvider());
      getWebCore().cay.a(new com.tencent.mm.plugin.webview.luggage.d(com.tencent.mm.plugin.appbrand.aa.d.Ne("preload_game_adapter.js")));
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
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(83026);
    super.onAttachedToWindow();
    getWebCore().a(new c()
    {
      public final JSONObject AM()
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
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.g
 * JD-Core Version:    0.7.0.1
 */