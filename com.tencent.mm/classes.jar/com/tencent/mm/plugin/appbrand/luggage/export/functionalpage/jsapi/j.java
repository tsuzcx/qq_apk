package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import d.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalJsApiPool;", "", "()V", "getPagePool", "", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "getServicePool", "plugin-appbrand-integration_release"})
public final class j
{
  public static final j lTX;
  
  static
  {
    AppMethodBeat.i(223698);
    lTX = new j();
    AppMethodBeat.o(223698);
  }
  
  public static final Map<String, m> bte()
  {
    AppMethodBeat.i(223696);
    Object localObject = new HashMap(q.biU());
    Iterator localIterator = ((Iterable)d.a.j.listOf(new m[] { (m)new h(), (m)new i(), (m)new k() })).iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      ((HashMap)localObject).put(localm.getName(), localm);
    }
    localObject = (Map)localObject;
    AppMethodBeat.o(223696);
    return localObject;
  }
  
  public static final Map<String, m> btf()
  {
    AppMethodBeat.i(223697);
    Object localObject = new HashMap(q.biV());
    Iterator localIterator = ((Iterable)d.a.j.listOf(new m[] { (m)new h(), (m)new i(), (m)new k() })).iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      ((HashMap)localObject).put(localm.getName(), localm);
    }
    localObject = (Map)localObject;
    AppMethodBeat.o(223697);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.j
 * JD-Core Version:    0.7.0.1
 */