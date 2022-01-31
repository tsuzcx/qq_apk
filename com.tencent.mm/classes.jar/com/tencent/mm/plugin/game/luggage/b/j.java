package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public class j
  extends bh<f>
{
  public final void a(Context paramContext, String paramString, bh.a parama)
  {
    AppMethodBeat.i(135875);
    ab.i("MicroMsg.JsApiGetLocalWePkgInfo", "invokeInMM");
    al.d(new j.1(this, parama));
    AppMethodBeat.o(135875);
  }
  
  public final void b(a.a parama) {}
  
  public final int bjL()
  {
    return 1;
  }
  
  public final String name()
  {
    return "getLocalWePkgInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.j
 * JD-Core Version:    0.7.0.1
 */