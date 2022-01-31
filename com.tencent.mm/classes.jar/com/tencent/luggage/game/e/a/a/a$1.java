package com.tencent.luggage.game.e.a.a;

import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.h;
import com.tencent.mm.plugin.appbrand.jsapi.bs;
import com.tencent.mm.plugin.appbrand.t.m;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1
  implements h
{
  a$1(a parama) {}
  
  public final void s(String paramString1, String paramString2)
  {
    AppMethodBeat.i(140421);
    ab.e("Luggage.AppBrandGameServiceLogicImp", "[WAGameJsException] hy: wxa main context exception %s %s", new Object[] { paramString1, paramString2 });
    bs.a(((c)a.a(this.bBl)).aAO(), "onError", String.format("{'message':'%s', 'stack': '%s'}", new Object[] { m.Fr(paramString1), m.Fr(paramString2) }), 0);
    AppMethodBeat.o(140421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.game.e.a.a.a.1
 * JD-Core Version:    0.7.0.1
 */