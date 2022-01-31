package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.m.k.a;
import java.util.Map;

final class bv$1
  implements k.a
{
  public final void d(c paramc, String paramString)
  {
    AppMethodBeat.i(86967);
    bv.1.1 local1 = new bv.1.1(this, paramc, paramString);
    bv.hAL.put(paramString, local1);
    ((h)paramc).getRuntime().gPL.a(local1);
    AppMethodBeat.o(86967);
  }
  
  public final void e(c paramc, String paramString)
  {
    AppMethodBeat.i(86968);
    paramString = (c.a)bv.hAL.get(paramString);
    if (paramString != null)
    {
      paramc = ((h)paramc).getRuntime();
      if (paramc != null) {
        paramc.gPL.b(paramString);
      }
    }
    AppMethodBeat.o(86968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bv.1
 * JD-Core Version:    0.7.0.1
 */