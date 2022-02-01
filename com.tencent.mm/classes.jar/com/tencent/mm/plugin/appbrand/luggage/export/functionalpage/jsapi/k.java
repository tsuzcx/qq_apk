package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalJsApiPool;", "", "()V", "getPagePool", "", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "getServicePool", "plugin-appbrand-integration_release"})
public final class k
{
  public static final k qbT;
  
  static
  {
    AppMethodBeat.i(271371);
    qbT = new k();
    AppMethodBeat.o(271371);
  }
  
  public static final Map<String, o> cbb()
  {
    AppMethodBeat.i(271368);
    Object localObject = new HashMap(s.bPI());
    Iterator localIterator = ((Iterable)kotlin.a.j.listOf(new o[] { (o)new h(), (o)new i(), (o)new j(), (o)new l() })).iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      ((HashMap)localObject).put(localo.getName(), localo);
    }
    localObject = (Map)localObject;
    AppMethodBeat.o(271368);
    return localObject;
  }
  
  public static final Map<String, o> cbc()
  {
    AppMethodBeat.i(271370);
    Object localObject = new HashMap(s.bPJ());
    Iterator localIterator = ((Iterable)kotlin.a.j.listOf(new o[] { (o)new h(), (o)new i(), (o)new j(), (o)new l() })).iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      ((HashMap)localObject).put(localo.getName(), localo);
    }
    localObject = (Map)localObject;
    AppMethodBeat.o(271370);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.k
 * JD-Core Version:    0.7.0.1
 */