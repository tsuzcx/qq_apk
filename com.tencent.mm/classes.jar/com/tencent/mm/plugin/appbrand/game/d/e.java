package com.tencent.mm.plugin.appbrand.game.d;

import com.tencent.mm.plugin.appbrand.game.d.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.aj;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.video.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.h;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class e
{
  private static final String[] gcb = { "scrollWebviewTo" };
  
  public static Map<String, com.tencent.mm.plugin.appbrand.jsapi.i> agz()
  {
    Map localMap = m.ahO();
    localMap.putAll(m.ahP());
    Object localObject = new HashSet();
    ((Collection)localObject).add(new com.tencent.mm.plugin.appbrand.game.d.a.e());
    ((Collection)localObject).add(new f());
    ((Collection)localObject).add(new com.tencent.mm.plugin.appbrand.game.d.a.d());
    ((Collection)localObject).add(new aj());
    ((Collection)localObject).add(new b());
    ((Collection)localObject).add(new com.tencent.mm.plugin.appbrand.jsapi.o.c());
    ((Collection)localObject).add(new com.tencent.mm.plugin.appbrand.jsapi.o.b());
    ((Collection)localObject).add(new com.tencent.mm.plugin.appbrand.jsapi.o.d());
    ((Collection)localObject).add(new com.tencent.mm.plugin.appbrand.jsapi.video.e());
    ((Collection)localObject).add(new com.tencent.mm.plugin.appbrand.jsapi.video.i());
    ((Collection)localObject).add(new h());
    ((Collection)localObject).add(new g());
    ((Collection)localObject).add(new a());
    ((Collection)localObject).add(new com.tencent.mm.plugin.appbrand.jsapi.h.a());
    ((Collection)localObject).add(new c());
    ((Collection)localObject).add(new d());
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.appbrand.jsapi.i locali = (com.tencent.mm.plugin.appbrand.jsapi.i)((Iterator)localObject).next();
      if ((locali != null) && (!bk.bl(locali.getName()))) {
        localMap.put(locali.getName(), locali);
      }
    }
    localObject = gcb;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localMap.remove(localObject[i]);
      i += 1;
    }
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.d.e
 * JD-Core Version:    0.7.0.1
 */