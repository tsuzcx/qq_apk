package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.t;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalJsApiPool;", "", "()V", "getPagePool", "", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "getServicePool", "plugin-appbrand-integration_release"})
public final class k
{
  public static final k nbF;
  
  static
  {
    AppMethodBeat.i(228921);
    nbF = new k();
    AppMethodBeat.o(228921);
  }
  
  public static final Map<String, p> bOL()
  {
    AppMethodBeat.i(228919);
    Object localObject = new HashMap(t.bEk());
    Iterator localIterator = ((Iterable)kotlin.a.j.listOf(new p[] { (p)new h(), (p)new i(), (p)new j(), (p)new l() })).iterator();
    while (localIterator.hasNext())
    {
      p localp = (p)localIterator.next();
      ((HashMap)localObject).put(localp.getName(), localp);
    }
    localObject = (Map)localObject;
    AppMethodBeat.o(228919);
    return localObject;
  }
  
  public static final Map<String, p> bOM()
  {
    AppMethodBeat.i(228920);
    Object localObject = new HashMap(t.bEl());
    Iterator localIterator = ((Iterable)kotlin.a.j.listOf(new p[] { (p)new h(), (p)new i(), (p)new j(), (p)new l() })).iterator();
    while (localIterator.hasNext())
    {
      p localp = (p)localIterator.next();
      ((HashMap)localObject).put(localp.getName(), localp);
    }
    localObject = (Map)localObject;
    AppMethodBeat.o(228920);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.k
 * JD-Core Version:    0.7.0.1
 */