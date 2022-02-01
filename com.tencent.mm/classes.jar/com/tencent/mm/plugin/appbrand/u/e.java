package com.tencent.mm.plugin.appbrand.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class e
{
  private final Map<Integer, com.tencent.mm.plugin.appbrand.u.a.e> qly;
  
  public e()
  {
    AppMethodBeat.i(147379);
    this.qly = new HashMap();
    AppMethodBeat.o(147379);
  }
  
  final com.tencent.mm.plugin.appbrand.u.a.e Cj(int paramInt)
  {
    AppMethodBeat.i(147380);
    com.tencent.mm.plugin.appbrand.u.a.e locale = (com.tencent.mm.plugin.appbrand.u.a.e)this.qly.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(147380);
    return locale;
  }
  
  final void a(com.tencent.mm.plugin.appbrand.u.a.e parame)
  {
    AppMethodBeat.i(147381);
    this.qly.put(Integer.valueOf(parame.getType()), parame);
    AppMethodBeat.o(147381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.e
 * JD-Core Version:    0.7.0.1
 */