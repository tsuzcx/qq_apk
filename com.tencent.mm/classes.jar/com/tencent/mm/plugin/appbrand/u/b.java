package com.tencent.mm.plugin.appbrand.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.u.c.c;
import com.tencent.mm.plugin.appbrand.u.c.d;
import com.tencent.mm.plugin.appbrand.u.c.e;
import com.tencent.mm.plugin.appbrand.u.c.f;
import com.tencent.mm.plugin.appbrand.u.c.g;
import com.tencent.mm.plugin.appbrand.u.c.h;
import com.tencent.mm.plugin.appbrand.u.c.i;
import com.tencent.mm.plugin.appbrand.u.c.j;
import com.tencent.mm.plugin.appbrand.u.c.k;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static final Map<Integer, com.tencent.mm.plugin.appbrand.u.a.a> qlq;
  
  static
  {
    AppMethodBeat.i(147368);
    qlq = new HashMap();
    a(new com.tencent.mm.plugin.appbrand.u.c.b());
    a(new g());
    a(new i());
    a(new k());
    a(new j());
    a(new f());
    a(new e());
    a(new h());
    a(new com.tencent.mm.plugin.appbrand.u.c.a());
    a(new c());
    a(new d());
    AppMethodBeat.o(147368);
  }
  
  public static com.tencent.mm.plugin.appbrand.u.a.a Ci(int paramInt)
  {
    AppMethodBeat.i(147366);
    com.tencent.mm.plugin.appbrand.u.a.a locala = (com.tencent.mm.plugin.appbrand.u.a.a)qlq.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(147366);
    return locala;
  }
  
  private static void a(com.tencent.mm.plugin.appbrand.u.a.a parama)
  {
    AppMethodBeat.i(147367);
    qlq.put(Integer.valueOf(parama.ccB()), parama);
    AppMethodBeat.o(147367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.b
 * JD-Core Version:    0.7.0.1
 */