package com.tencent.mm.plugin.appbrand.game.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.bd;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.t;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class c
{
  private static final String[] lsA = { "scrollWebviewTo", "showNavigationBar", "hideNavigationBar", "showNavigationBarLoading", "hideNavigationBarLoading" };
  
  public static Map<String, p> bDi()
  {
    AppMethodBeat.i(45135);
    Map localMap = t.bEk();
    localMap.putAll(t.bEl());
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
    ((Collection)localObject).add(new com.tencent.mm.plugin.appbrand.jsapi.appdownload.e(bd.bty()));
    ((Collection)localObject).add(new a());
    ((Collection)localObject).add(new com.tencent.mm.plugin.appbrand.jsapi.o.e(com.tencent.mm.plugin.appbrand.jsapi.o.e.mgh, bd.btw()));
    ((Collection)localObject).add(new com.tencent.mm.plugin.appbrand.game.e.b.c());
    ((Collection)localObject).add(new com.tencent.mm.plugin.appbrand.jsapi.o.b.b(com.tencent.mm.plugin.appbrand.jsapi.o.b.a.mgg, bd.btx()));
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      p localp = (p)((Iterator)localObject).next();
      if ((localp != null) && (!Util.isNullOrNil(localp.getName()))) {
        localMap.put(localp.getName(), localp);
      }
    }
    localObject = lsA;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.c
 * JD-Core Version:    0.7.0.1
 */