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
import com.tencent.mm.plugin.game.luggage.f.f;
import com.tencent.mm.plugin.webview.luggage.LuggageMMLocalResourceProvider;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.xweb.WebView;
import org.json.JSONObject;

public class i
  extends f
{
  public i(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(211597);
    if (this.tVd != null) {
      this.tVd.EDB = true;
    }
    AppMethodBeat.o(211597);
  }
  
  public final void Ck()
  {
    AppMethodBeat.i(83028);
    getWebCore().chO = new q()
    {
      public final String Cp()
      {
        AppMethodBeat.i(83025);
        String str = com.tencent.mm.plugin.appbrand.z.d.UT("preload_game_adapter.js");
        AppMethodBeat.o(83025);
        return str;
      }
      
      public final WebResourceResponse a(WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        return null;
      }
      
      public final void cD(String paramAnonymousString) {}
      
      public final void cE(String paramAnonymousString) {}
    };
    if (getWebCore().chR != null)
    {
      getWebCore().chR.a(new LuggageMMLocalResourceProvider());
      getWebCore().chR.a(new e(com.tencent.mm.plugin.appbrand.z.d.UT("preload_game_adapter.js")));
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
    getWebCore().a(new com.tencent.luggage.d.d()
    {
      public final JSONObject BO()
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