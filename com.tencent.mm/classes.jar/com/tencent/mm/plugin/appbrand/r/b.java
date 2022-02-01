package com.tencent.mm.plugin.appbrand.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.c.c;
import com.tencent.mm.plugin.appbrand.r.c.d;
import com.tencent.mm.plugin.appbrand.r.c.e;
import com.tencent.mm.plugin.appbrand.r.c.f;
import com.tencent.mm.plugin.appbrand.r.c.g;
import com.tencent.mm.plugin.appbrand.r.c.h;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static final Map<Integer, com.tencent.mm.plugin.appbrand.r.a.a> kWs;
  
  static
  {
    AppMethodBeat.i(147368);
    kWs = new HashMap();
    a(new com.tencent.mm.plugin.appbrand.r.c.a());
    a(new d());
    a(new f());
    a(new h());
    a(new g());
    a(new c());
    a(new com.tencent.mm.plugin.appbrand.r.c.b());
    a(new e());
    AppMethodBeat.o(147368);
  }
  
  private static void a(com.tencent.mm.plugin.appbrand.r.a.a parama)
  {
    AppMethodBeat.i(147367);
    kWs.put(Integer.valueOf(parama.biH()), parama);
    AppMethodBeat.o(147367);
  }
  
  public static com.tencent.mm.plugin.appbrand.r.a.a tn(int paramInt)
  {
    AppMethodBeat.i(147366);
    com.tencent.mm.plugin.appbrand.r.a.a locala = (com.tencent.mm.plugin.appbrand.r.a.a)kWs.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(147366);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.b
 * JD-Core Version:    0.7.0.1
 */