package com.tencent.mm.plugin.appbrand.game.e;

import com.tencent.luggage.game.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ah;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b
{
  private static final String[] htl = { "scrollWebviewTo", "showNavigationBar", "hideNavigationBar", "showNavigationBarLoading", "hideNavigationBarLoading" };
  
  public static Map<String, m> aAD()
  {
    AppMethodBeat.i(130200);
    Map localMap = q.aBx();
    localMap.putAll(q.aBy());
    Object localObject = new HashSet();
    ((Collection)localObject).add(new com.tencent.luggage.game.e.b.e());
    ((Collection)localObject).add(new com.tencent.luggage.game.e.b.f());
    ((Collection)localObject).add(new com.tencent.luggage.game.e.b.d());
    ((Collection)localObject).add(new as());
    ((Collection)localObject).add(new com.tencent.luggage.game.e.b());
    ((Collection)localObject).add(new c());
    ((Collection)localObject).add(new com.tencent.luggage.game.e.d());
    ((Collection)localObject).add(new com.tencent.luggage.game.e.e());
    ((Collection)localObject).add(new com.tencent.mm.plugin.appbrand.game.e.a.e());
    ((Collection)localObject).add(new com.tencent.mm.plugin.appbrand.game.e.a.d());
    ((Collection)localObject).add(new com.tencent.mm.plugin.appbrand.game.e.a.f());
    ((Collection)localObject).add(new com.tencent.mm.plugin.appbrand.jsapi.appdownload.e());
    ((Collection)localObject).add(new a());
    ((Collection)localObject).add(new com.tencent.mm.plugin.appbrand.jsapi.j.f(com.tencent.mm.plugin.appbrand.jsapi.j.f.hTU, ah.auo()));
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      m localm = (m)((Iterator)localObject).next();
      if ((localm != null) && (!bo.isNullOrNil(localm.getName()))) {
        localMap.put(localm.getName(), localm);
      }
    }
    localObject = htl;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localMap.remove(localObject[i]);
      i += 1;
    }
    AppMethodBeat.o(130200);
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.b
 * JD-Core Version:    0.7.0.1
 */