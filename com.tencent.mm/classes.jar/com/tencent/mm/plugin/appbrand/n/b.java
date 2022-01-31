package com.tencent.mm.plugin.appbrand.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.c.c;
import com.tencent.mm.plugin.appbrand.n.c.d;
import com.tencent.mm.plugin.appbrand.n.c.e;
import com.tencent.mm.plugin.appbrand.n.c.f;
import com.tencent.mm.plugin.appbrand.n.c.g;
import com.tencent.mm.plugin.appbrand.n.c.h;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static final Map<Integer, com.tencent.mm.plugin.appbrand.n.a.a> itY;
  
  static
  {
    AppMethodBeat.i(102170);
    itY = new HashMap();
    a(new com.tencent.mm.plugin.appbrand.n.c.a());
    a(new d());
    a(new f());
    a(new h());
    a(new g());
    a(new c());
    a(new com.tencent.mm.plugin.appbrand.n.c.b());
    a(new e());
    AppMethodBeat.o(102170);
  }
  
  private static void a(com.tencent.mm.plugin.appbrand.n.a.a parama)
  {
    AppMethodBeat.i(102169);
    itY.put(Integer.valueOf(parama.aIA()), parama);
    AppMethodBeat.o(102169);
  }
  
  public static com.tencent.mm.plugin.appbrand.n.a.a oY(int paramInt)
  {
    AppMethodBeat.i(102168);
    com.tencent.mm.plugin.appbrand.n.a.a locala = (com.tencent.mm.plugin.appbrand.n.a.a)itY.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(102168);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.b
 * JD-Core Version:    0.7.0.1
 */