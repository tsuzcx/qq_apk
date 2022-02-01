package com.tencent.mm.plugin.appbrand.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class e
{
  private final Map<Integer, com.tencent.mm.plugin.appbrand.v.a.e> tqw;
  
  public e()
  {
    AppMethodBeat.i(147379);
    this.tqw = new HashMap();
    AppMethodBeat.o(147379);
  }
  
  final com.tencent.mm.plugin.appbrand.v.a.e Cy(int paramInt)
  {
    AppMethodBeat.i(147380);
    com.tencent.mm.plugin.appbrand.v.a.e locale = (com.tencent.mm.plugin.appbrand.v.a.e)this.tqw.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(147380);
    return locale;
  }
  
  final void a(com.tencent.mm.plugin.appbrand.v.a.e parame)
  {
    AppMethodBeat.i(147381);
    this.tqw.put(Integer.valueOf(parame.getType()), parame);
    AppMethodBeat.o(147381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.e
 * JD-Core Version:    0.7.0.1
 */