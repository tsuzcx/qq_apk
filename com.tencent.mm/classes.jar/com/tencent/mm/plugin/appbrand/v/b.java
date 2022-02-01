package com.tencent.mm.plugin.appbrand.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.v.c.c;
import com.tencent.mm.plugin.appbrand.v.c.d;
import com.tencent.mm.plugin.appbrand.v.c.e;
import com.tencent.mm.plugin.appbrand.v.c.f;
import com.tencent.mm.plugin.appbrand.v.c.g;
import com.tencent.mm.plugin.appbrand.v.c.h;
import com.tencent.mm.plugin.appbrand.v.c.i;
import com.tencent.mm.plugin.appbrand.v.c.j;
import com.tencent.mm.plugin.appbrand.v.c.k;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static final Map<Integer, com.tencent.mm.plugin.appbrand.v.a.a> tqo;
  
  static
  {
    AppMethodBeat.i(147368);
    tqo = new HashMap();
    a(new com.tencent.mm.plugin.appbrand.v.c.b());
    a(new g());
    a(new i());
    a(new k());
    a(new j());
    a(new f());
    a(new e());
    a(new h());
    a(new com.tencent.mm.plugin.appbrand.v.c.a());
    a(new c());
    a(new d());
    AppMethodBeat.o(147368);
  }
  
  public static com.tencent.mm.plugin.appbrand.v.a.a Cx(int paramInt)
  {
    AppMethodBeat.i(147366);
    com.tencent.mm.plugin.appbrand.v.a.a locala = (com.tencent.mm.plugin.appbrand.v.a.a)tqo.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(147366);
    return locala;
  }
  
  private static void a(com.tencent.mm.plugin.appbrand.v.a.a parama)
  {
    AppMethodBeat.i(147367);
    tqo.put(Integer.valueOf(parama.cCX()), parama);
    AppMethodBeat.o(147367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.b
 * JD-Core Version:    0.7.0.1
 */