package com.tencent.luggage.sdk.b.a.c;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.h;
import com.tencent.mm.plugin.appbrand.i.i;
import com.tencent.mm.plugin.appbrand.jsapi.bs;
import com.tencent.mm.plugin.appbrand.t.m;

final class b$1
  implements h
{
  b$1(b paramb, i parami) {}
  
  public final void s(String paramString1, String paramString2)
  {
    AppMethodBeat.i(140723);
    d.e("Luggage.AppBrandMiniProgramServiceLogicImp", "hy: wxa main context exception %s %s", new Object[] { paramString1, paramString2 });
    String str = String.format("{'message':'%s', 'stack': '%s'}", new Object[] { m.Fr(paramString1), m.Fr(paramString2) });
    bs.a(this.bEG, "onError", str, 0);
    this.bEH.u(paramString1, paramString2);
    d.e("MicroMsg.AppBrand.JsRuntimeException", str);
    AppMethodBeat.o(140723);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.b.1
 * JD-Core Version:    0.7.0.1
 */