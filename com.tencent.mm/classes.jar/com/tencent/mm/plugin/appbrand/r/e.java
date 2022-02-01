package com.tencent.mm.plugin.appbrand.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class e
{
  private final Map<Integer, com.tencent.mm.plugin.appbrand.r.a.e> kWA;
  
  public e()
  {
    AppMethodBeat.i(147379);
    this.kWA = new HashMap();
    AppMethodBeat.o(147379);
  }
  
  final void a(com.tencent.mm.plugin.appbrand.r.a.e parame)
  {
    AppMethodBeat.i(147381);
    this.kWA.put(Integer.valueOf(parame.getType()), parame);
    AppMethodBeat.o(147381);
  }
  
  final com.tencent.mm.plugin.appbrand.r.a.e to(int paramInt)
  {
    AppMethodBeat.i(147380);
    com.tencent.mm.plugin.appbrand.r.a.e locale = (com.tencent.mm.plugin.appbrand.r.a.e)this.kWA.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(147380);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.e
 * JD-Core Version:    0.7.0.1
 */