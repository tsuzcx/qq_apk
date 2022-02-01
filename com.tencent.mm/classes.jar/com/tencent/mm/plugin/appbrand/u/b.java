package com.tencent.mm.plugin.appbrand.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.u.c.c;
import com.tencent.mm.plugin.appbrand.u.c.d;
import com.tencent.mm.plugin.appbrand.u.c.e;
import com.tencent.mm.plugin.appbrand.u.c.f;
import com.tencent.mm.plugin.appbrand.u.c.g;
import com.tencent.mm.plugin.appbrand.u.c.h;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static final Map<Integer, com.tencent.mm.plugin.appbrand.u.a.a> njS;
  
  static
  {
    AppMethodBeat.i(147368);
    njS = new HashMap();
    a(new com.tencent.mm.plugin.appbrand.u.c.a());
    a(new d());
    a(new f());
    a(new h());
    a(new g());
    a(new c());
    a(new com.tencent.mm.plugin.appbrand.u.c.b());
    a(new e());
    AppMethodBeat.o(147368);
  }
  
  private static void a(com.tencent.mm.plugin.appbrand.u.a.a parama)
  {
    AppMethodBeat.i(147367);
    njS.put(Integer.valueOf(parama.bPT()), parama);
    AppMethodBeat.o(147367);
  }
  
  public static com.tencent.mm.plugin.appbrand.u.a.a yF(int paramInt)
  {
    AppMethodBeat.i(147366);
    com.tencent.mm.plugin.appbrand.u.a.a locala = (com.tencent.mm.plugin.appbrand.u.a.a)njS.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(147366);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.b
 * JD-Core Version:    0.7.0.1
 */