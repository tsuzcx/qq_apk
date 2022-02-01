package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.sdk.platformtools.ae;

public class h
  extends bq<com.tencent.luggage.d.a>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(b<com.tencent.luggage.d.a>.a paramb)
  {
    AppMethodBeat.i(192994);
    ae.i("MicroMsg.JsApiCloseJsCore", "invokeInOwn");
    if (com.tencent.mm.plugin.game.luggage.h.a.dao() != null) {
      com.tencent.mm.plugin.game.luggage.h.a.dao().dap();
    }
    AppMethodBeat.o(192994);
  }
  
  public final int ced()
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