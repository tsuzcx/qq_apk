package com.tencent.mm.plugin.appbrand.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class e
{
  private final Map<Integer, com.tencent.mm.plugin.appbrand.q.a.e> lXI;
  
  public e()
  {
    AppMethodBeat.i(147379);
    this.lXI = new HashMap();
    AppMethodBeat.o(147379);
  }
  
  final void a(com.tencent.mm.plugin.appbrand.q.a.e parame)
  {
    AppMethodBeat.i(147381);
    this.lXI.put(Integer.valueOf(parame.getType()), parame);
    AppMethodBeat.o(147381);
  }
  
  final com.tencent.mm.plugin.appbrand.q.a.e uJ(int paramInt)
  {
    AppMethodBeat.i(147380);
    com.tencent.mm.plugin.appbrand.q.a.e locale = (com.tencent.mm.plugin.appbrand.q.a.e)this.lXI.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(147380);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.e
 * JD-Core Version:    0.7.0.1
 */