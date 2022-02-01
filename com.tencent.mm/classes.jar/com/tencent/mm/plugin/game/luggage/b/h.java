package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.sdk.platformtools.ad;

public class h
  extends bq<com.tencent.luggage.d.a>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(b<com.tencent.luggage.d.a>.a paramb)
  {
    AppMethodBeat.i(211605);
    ad.i("MicroMsg.JsApiCloseJsCore", "invokeInOwn");
    if (com.tencent.mm.plugin.game.luggage.h.a.cXE() != null) {
      com.tencent.mm.plugin.game.luggage.h.a.cXE().cXF();
    }
    AppMethodBeat.o(211605);
  }
  
  public final int ccO()
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