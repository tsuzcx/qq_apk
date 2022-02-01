package com.tencent.mm.plugin.appbrand.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class e
{
  private final Map<Integer, com.tencent.mm.plugin.appbrand.u.a.e> nka;
  
  public e()
  {
    AppMethodBeat.i(147379);
    this.nka = new HashMap();
    AppMethodBeat.o(147379);
  }
  
  final void a(com.tencent.mm.plugin.appbrand.u.a.e parame)
  {
    AppMethodBeat.i(147381);
    this.nka.put(Integer.valueOf(parame.getType()), parame);
    AppMethodBeat.o(147381);
  }
  
  final com.tencent.mm.plugin.appbrand.u.a.e yG(int paramInt)
  {
    AppMethodBeat.i(147380);
    com.tencent.mm.plugin.appbrand.u.a.e locale = (com.tencent.mm.plugin.appbrand.u.a.e)this.nka.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(147380);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.e
 * JD-Core Version:    0.7.0.1
 */