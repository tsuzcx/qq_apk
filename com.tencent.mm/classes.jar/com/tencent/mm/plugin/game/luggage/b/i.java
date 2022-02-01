package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.sdk.platformtools.Log;

public class i
  extends bv<com.tencent.luggage.d.a>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(b<com.tencent.luggage.d.a>.a paramb)
  {
    AppMethodBeat.i(277131);
    Log.i("MicroMsg.JsApiCloseJsCore", "invokeInOwn");
    if (com.tencent.mm.plugin.game.luggage.h.a.fFa() != null) {
      com.tencent.mm.plugin.game.luggage.h.a.fFa().fFb();
    }
    AppMethodBeat.o(277131);
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "closeJsCore";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.i
 * JD-Core Version:    0.7.0.1
 */