package com.tencent.mm.plugin.appbrand.ab.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
  extends b
{
  public final com.tencent.mm.plugin.appbrand.ab.e.b a(com.tencent.mm.plugin.appbrand.ab.e.b paramb)
  {
    AppMethodBeat.i(156645);
    super.a(paramb);
    paramb.put("Sec-WebSocket-Version", "13");
    AppMethodBeat.o(156645);
    return paramb;
  }
  
  public a bqA()
  {
    AppMethodBeat.i(156646);
    c localc = new c();
    AppMethodBeat.o(156646);
    return localc;
  }
  
  public final a.b c(com.tencent.mm.plugin.appbrand.ab.e.a parama)
  {
    AppMethodBeat.i(156644);
    if (g(parama) == 13)
    {
      parama = a.b.lOj;
      AppMethodBeat.o(156644);
      return parama;
    }
    parama = a.b.lOk;
    AppMethodBeat.o(156644);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ab.b.c
 * JD-Core Version:    0.7.0.1
 */