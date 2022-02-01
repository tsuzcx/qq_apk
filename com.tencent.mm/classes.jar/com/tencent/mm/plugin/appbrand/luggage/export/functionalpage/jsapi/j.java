package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import d.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalJsApiPool;", "", "()V", "getPagePool", "", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "getServicePool", "plugin-appbrand-integration_release"})
public final class j
{
  public static final j lPw;
  
  static
  {
    AppMethodBeat.i(189438);
    lPw = new j();
    AppMethodBeat.o(189438);
  }
  
  public static final Map<String, m> bst()
  {
    AppMethodBeat.i(189436);
    Object localObject = new HashMap(q.bil());
    Iterator localIterator = ((Iterable)d.a.j.listOf(new m[] { (m)new h(), (m)new i(), (m)new k() })).iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      ((HashMap)localObject).put(localm.getName(), localm);
    }
    localObject = (Map)localObject;
    AppMethodBeat.o(189436);
    return localObject;
  }
  
  public static final Map<String, m> bsu()
  {
    AppMethodBeat.i(189437);
    Object localObject = new HashMap(q.bim());
    Iterator localIterator = ((Iterable)d.a.j.listOf(new m[] { (m)new h(), (m)new i(), (m)new k() })).iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      ((HashMap)localObject).put(localm.getName(), localm);
    }
    localObject = (Map)localObject;
    AppMethodBeat.o(189437);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.j
 * JD-Core Version:    0.7.0.1
 */