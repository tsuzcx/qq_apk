package com.tencent.mm.plugin.appbrand.af.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
  extends b
{
  public final com.tencent.mm.plugin.appbrand.af.e.b a(com.tencent.mm.plugin.appbrand.af.e.b paramb)
  {
    AppMethodBeat.i(156645);
    super.a(paramb);
    paramb.put("Sec-WebSocket-Version", "13");
    AppMethodBeat.o(156645);
    return paramb;
  }
  
  public final a.b c(com.tencent.mm.plugin.appbrand.af.e.a parama)
  {
    AppMethodBeat.i(156644);
    if (g(parama) == 13)
    {
      parama = a.b.rll;
      AppMethodBeat.o(156644);
      return parama;
    }
    parama = a.b.rlm;
    AppMethodBeat.o(156644);
    return parama;
  }
  
  public a cmy()
  {
    AppMethodBeat.i(156646);
    c localc = new c();
    AppMethodBeat.o(156646);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.af.b.c
 * JD-Core Version:    0.7.0.1
 */