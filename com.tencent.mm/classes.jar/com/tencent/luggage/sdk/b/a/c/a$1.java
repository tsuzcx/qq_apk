package com.tencent.luggage.sdk.b.a.c;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.g;
import com.tencent.mm.plugin.appbrand.i.h;
import com.tencent.mm.plugin.appbrand.jsapi.bt;
import com.tencent.mm.plugin.appbrand.t.m;

final class a$1
  implements h
{
  a$1(a parama, g paramg) {}
  
  public final void s(String paramString1, String paramString2)
  {
    AppMethodBeat.i(140721);
    d.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "hy: on exception! message: %s, stacktrace %s", new Object[] { paramString1, paramString2 });
    bt.a(this.bEz, "onError", String.format("{'message':'%s', 'stack': '%s'}", new Object[] { m.Fr(paramString1), m.Fr(paramString2) }));
    AppMethodBeat.o(140721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.a.1
 * JD-Core Version:    0.7.0.1
 */