package com.tencent.mm.plugin.appbrand.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q.c.c;
import com.tencent.mm.plugin.appbrand.q.c.d;
import com.tencent.mm.plugin.appbrand.q.c.e;
import com.tencent.mm.plugin.appbrand.q.c.f;
import com.tencent.mm.plugin.appbrand.q.c.g;
import com.tencent.mm.plugin.appbrand.q.c.h;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static final Map<Integer, com.tencent.mm.plugin.appbrand.q.a.a> lXA;
  
  static
  {
    AppMethodBeat.i(147368);
    lXA = new HashMap();
    a(new com.tencent.mm.plugin.appbrand.q.c.a());
    a(new d());
    a(new f());
    a(new h());
    a(new g());
    a(new c());
    a(new com.tencent.mm.plugin.appbrand.q.c.b());
    a(new e());
    AppMethodBeat.o(147368);
  }
  
  private static void a(com.tencent.mm.plugin.appbrand.q.a.a parama)
  {
    AppMethodBeat.i(147367);
    lXA.put(Integer.valueOf(parama.btB()), parama);
    AppMethodBeat.o(147367);
  }
  
  public static com.tencent.mm.plugin.appbrand.q.a.a uI(int paramInt)
  {
    AppMethodBeat.i(147366);
    com.tencent.mm.plugin.appbrand.q.a.a locala = (com.tencent.mm.plugin.appbrand.q.a.a)lXA.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(147366);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.b
 * JD-Core Version:    0.7.0.1
 */