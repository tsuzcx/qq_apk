package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.luggage.sdk.b.a.c.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import d.g.b.k;
import d.l;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/debugger/RemoteDebugServiceLogicWC;", "Lcom/tencent/luggage/sdk/jsapi/component/service/MPRemoteDebugServiceLogic;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "service", "(Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;)V", "getService", "()Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "onCreateJsApiPool", "", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "plugin-appbrand-integration_release"})
public final class s
  extends h<com.tencent.mm.plugin.appbrand.service.c>
{
  private final com.tencent.mm.plugin.appbrand.service.c jhq;
  
  public s(com.tencent.mm.plugin.appbrand.service.c paramc)
  {
    super((com.tencent.luggage.sdk.b.a.c.c)paramc);
    AppMethodBeat.i(50353);
    this.jhq = paramc;
    AppMethodBeat.o(50353);
  }
  
  public final Map<String, m> CD()
  {
    AppMethodBeat.i(50352);
    Map localMap = q.aXK();
    k.g(localMap, "AppBrandJsApiPool.getServiceApiPool()");
    AppMethodBeat.o(50352);
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.s
 * JD-Core Version:    0.7.0.1
 */