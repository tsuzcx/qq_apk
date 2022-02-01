package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.t;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalJsApiPool;", "", "()V", "getPagePool", "", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "getServicePool", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k tgN;
  
  static
  {
    AppMethodBeat.i(320140);
    tgN = new k();
    AppMethodBeat.o(320140);
  }
  
  public static final Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> cBu()
  {
    AppMethodBeat.i(320122);
    Object localObject = new HashMap(t.cpP());
    Iterator localIterator = ((Iterable)kotlin.a.p.listOf(new com.tencent.mm.plugin.appbrand.jsapi.p[] { (com.tencent.mm.plugin.appbrand.jsapi.p)new h(), (com.tencent.mm.plugin.appbrand.jsapi.p)new i(), (com.tencent.mm.plugin.appbrand.jsapi.p)new j(), (com.tencent.mm.plugin.appbrand.jsapi.p)new l() })).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.appbrand.jsapi.p localp = (com.tencent.mm.plugin.appbrand.jsapi.p)localIterator.next();
      ((HashMap)localObject).put(localp.getName(), localp);
    }
    localObject = (Map)localObject;
    AppMethodBeat.o(320122);
    return localObject;
  }
  
  public static final Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> cBv()
  {
    AppMethodBeat.i(320131);
    Object localObject = new HashMap(t.cpQ());
    Iterator localIterator = ((Iterable)kotlin.a.p.listOf(new com.tencent.mm.plugin.appbrand.jsapi.p[] { (com.tencent.mm.plugin.appbrand.jsapi.p)new h(), (com.tencent.mm.plugin.appbrand.jsapi.p)new i(), (com.tencent.mm.plugin.appbrand.jsapi.p)new j(), (com.tencent.mm.plugin.appbrand.jsapi.p)new l() })).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.appbrand.jsapi.p localp = (com.tencent.mm.plugin.appbrand.jsapi.p)localIterator.next();
      ((HashMap)localObject).put(localp.getName(), localp);
    }
    localObject = (Map)localObject;
    AppMethodBeat.o(320131);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.k
 * JD-Core Version:    0.7.0.1
 */