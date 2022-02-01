package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.sdk.platformtools.Log;

public class h
  extends br<com.tencent.luggage.d.a>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(b<com.tencent.luggage.d.a>.a paramb)
  {
    AppMethodBeat.i(231941);
    Log.i("MicroMsg.JsApiCloseJsCore", "invokeInOwn");
    if (com.tencent.mm.plugin.game.luggage.i.a.exd() != null) {
      com.tencent.mm.plugin.game.luggage.i.a.exd().exe();
    }
    AppMethodBeat.o(231941);
  }
  
  public final int cDj()
  {
    return 0;
  }
  
  public final String name()
  {
    return "closeJsCore";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.h
 * JD-Core Version:    0.7.0.1
 */