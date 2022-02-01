package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.luggage.sdk.b.a.c.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.c;
import java.util.Map;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/debugger/RemoteDebugServiceLogicWC;", "Lcom/tencent/luggage/sdk/jsapi/component/service/MPRemoteDebugServiceLogic;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "service", "(Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;)V", "getService", "()Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "onCreateJsApiPool", "", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "plugin-appbrand-integration_release"})
public final class t
  extends j<c>
{
  private final c liR;
  
  public t(c paramc)
  {
    super((d)paramc);
    AppMethodBeat.i(50353);
    this.liR = paramc;
    AppMethodBeat.o(50353);
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> Nf()
  {
    AppMethodBeat.i(50352);
    Map localMap = com.tencent.mm.plugin.appbrand.jsapi.t.bEk();
    kotlin.g.b.p.g(localMap, "AppBrandJsApiPool.getServiceApiPool()");
    AppMethodBeat.o(50352);
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.t
 * JD-Core Version:    0.7.0.1
 */