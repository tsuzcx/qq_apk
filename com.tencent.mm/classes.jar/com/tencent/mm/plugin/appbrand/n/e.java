package com.tencent.mm.plugin.appbrand.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.a.e.a;
import com.tencent.mm.plugin.appbrand.n.d.a;
import com.tencent.mm.plugin.appbrand.n.d.b;
import com.tencent.mm.plugin.appbrand.n.d.c;
import com.tencent.mm.plugin.appbrand.r;
import java.util.HashMap;
import java.util.Map;

public final class e
{
  private static final Map<Integer, com.tencent.mm.plugin.appbrand.n.a.e> iuf;
  
  static
  {
    AppMethodBeat.i(102184);
    iuf = new HashMap();
    AppMethodBeat.o(102184);
  }
  
  protected static void a(e.a parama, r paramr)
  {
    AppMethodBeat.i(102181);
    a(new a(parama, paramr));
    a(new c(parama, paramr));
    a(new b(parama, paramr));
    AppMethodBeat.o(102181);
  }
  
  private static final void a(com.tencent.mm.plugin.appbrand.n.a.e parame)
  {
    AppMethodBeat.i(102183);
    iuf.put(Integer.valueOf(parame.getType()), parame);
    AppMethodBeat.o(102183);
  }
  
  public static com.tencent.mm.plugin.appbrand.n.a.e oZ(int paramInt)
  {
    AppMethodBeat.i(102182);
    com.tencent.mm.plugin.appbrand.n.a.e locale = (com.tencent.mm.plugin.appbrand.n.a.e)iuf.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(102182);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.e
 * JD-Core Version:    0.7.0.1
 */