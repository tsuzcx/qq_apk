package com.tencent.mm.plugin.game.luggage;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.luggage.d.k;
import com.tencent.luggage.g.i;
import com.tencent.luggage.webview.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.LuggageMMLocalResourceProvider;
import com.tencent.mm.plugin.webview.luggage.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.xweb.WebView;

public class e
  extends com.tencent.mm.plugin.game.luggage.d.e
{
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(135845);
    super.b(paramWebView, paramString);
    AppMethodBeat.o(135845);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(135844);
    super.b(paramWebView, paramString, paramBitmap);
    AppMethodBeat.o(135844);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(135841);
    super.onAttachedToWindow();
    getWebCore().a(new e.1(this));
    AppMethodBeat.o(135841);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(135842);
    super.onDetachedFromWindow();
    AppMethodBeat.o(135842);
  }
  
  public final void us()
  {
    AppMethodBeat.i(135843);
    getWebCore().bze = new e.2(this);
    if (getWebCore().bzi != null)
    {
      getWebCore().bzi.a(new LuggageMMLocalResourceProvider());
      getWebCore().bzi.a(new c(i.p(ah.getContext(), "preload_game_adapter.js")));
    }
    AppMethodBeat.o(135843);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.e
 * JD-Core Version:    0.7.0.1
 */