package com.tencent.mm.plugin.appbrand.game.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.as;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class c
{
  private static final String[] koR = { "scrollWebviewTo", "showNavigationBar", "hideNavigationBar", "showNavigationBarLoading", "hideNavigationBarLoading" };
  
  public static Map<String, m> bhT()
  {
    AppMethodBeat.i(45135);
    Map localMap = q.biU();
    localMap.putAll(q.biV());
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
    ((Collection)localObject).add(new com.tencent.mm.plugin.appbrand.jsapi.appdownload.e(as.aYl()));
    ((Collection)localObject).add(new a());
    ((Collection)localObject).add(new com.tencent.mm.plugin.appbrand.jsapi.m.e(com.tencent.mm.plugin.appbrand.jsapi.m.e.laS, as.aYj()));
    ((Collection)localObject).add(new com.tencent.mm.plugin.appbrand.game.e.b.c());
    ((Collection)localObject).add(new com.tencent.mm.plugin.appbrand.jsapi.m.b.b(com.tencent.mm.plugin.appbrand.jsapi.m.b.a.laR, as.aYk()));
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      m localm = (m)((Iterator)localObject).next();
      if ((localm != null) && (!bu.isNullOrNil(localm.getName()))) {
        localMap.put(localm.getName(), localm);
      }
    }
    localObject = koR;
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