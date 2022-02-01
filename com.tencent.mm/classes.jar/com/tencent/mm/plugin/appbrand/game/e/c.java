package com.tencent.mm.plugin.appbrand.game.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aq;
import com.tencent.mm.plugin.appbrand.jsapi.j.g;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class c
{
  private static final String[] jRn = { "scrollWebviewTo", "showNavigationBar", "hideNavigationBar", "showNavigationBarLoading", "hideNavigationBarLoading" };
  
  public static Map<String, m> bdH()
  {
    AppMethodBeat.i(45135);
    Map localMap = q.beH();
    localMap.putAll(q.beI());
    Object localObject = new HashSet();
    ((Collection)localObject).add(new com.tencent.luggage.game.d.b.e());
    ((Collection)localObject).add(new com.tencent.luggage.game.d.b.f());
    ((Collection)localObject).add(new com.tencent.luggage.game.d.b.d());
    ((Collection)localObject).add(new com.tencent.luggage.game.d.b());
    ((Collection)localObject).add(new b());
    ((Collection)localObject).add(new com.tencent.luggage.game.d.c());
    ((Collection)localObject).add(new com.tencent.luggage.game.d.d());
    ((Collection)localObject).add(new com.tencent.luggage.game.d.e());
    ((Collection)localObject).add(new com.tencent.luggage.game.d.c.a());
    ((Collection)localObject).add(new com.tencent.mm.plugin.appbrand.game.e.a.e());
    ((Collection)localObject).add(new com.tencent.mm.plugin.appbrand.game.e.a.d());
    ((Collection)localObject).add(new com.tencent.mm.plugin.appbrand.game.e.a.f());
    ((Collection)localObject).add(new com.tencent.mm.plugin.appbrand.jsapi.appdownload.e(aq.aUG()));
    ((Collection)localObject).add(new a());
    ((Collection)localObject).add(new g(g.kBc, aq.aUE()));
    ((Collection)localObject).add(new com.tencent.mm.plugin.appbrand.game.e.b.c());
    ((Collection)localObject).add(new com.tencent.mm.plugin.appbrand.jsapi.j.b.b(com.tencent.mm.plugin.appbrand.jsapi.j.b.a.kBb, aq.aUF()));
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      m localm = (m)((Iterator)localObject).next();
      if ((localm != null) && (!bs.isNullOrNil(localm.getName()))) {
        localMap.put(localm.getName(), localm);
      }
    }
    localObject = jRn;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localMap.remove(localObject[i]);
      i += 1;
    }
    AppMethodBeat.o(45135);
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.c
 * JD-Core Version:    0.7.0.1
 */