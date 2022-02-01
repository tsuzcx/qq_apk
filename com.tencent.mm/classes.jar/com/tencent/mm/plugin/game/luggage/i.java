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
    AppMethodBeat.i(186846);
    if (this.xyl != null) {
      this.xyl.JLQ = true;
    }
    AppMethodBeat.o(186846);
  }
  
  public final void LE()
  {
    AppMethodBeat.i(83028);
    getWebCore().ctJ = new q()
    {
      public final String LJ()
      {
        AppMethodBeat.i(83025);
        String str = com.tencent.mm.plugin.appbrand.ac.d.afA("preload_game_adapter.js");
        AppMethodBeat.o(83025);
        return str;
      }
      
      public final WebResourceResponse a(WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        return null;
      }
      
      public final void cV(String paramAnonymousString) {}
      
      public final void cW(String paramAnonymousString) {}
    };
    if (getWebCore().ctM != null)
    {
      getWebCore().ctM.a(new LuggageMMLocalResourceProvider());
      getWebCore().ctM.a(new e(com.tencent.mm.plugin.appbrand.ac.d.afA("preload_game_adapter.js")));
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
    AppMethodBeat.i(186847);
    super.loadUrl(paramString);
    g.a(getWebCore(), paramString);
    AppMethodBeat.o(186847);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(83026);
    super.onAttachedToWindow();
    getWebCore().a(new com.tencent.luggage.d.d()
    {
      public final JSONObject Ld()
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