package com.tencent.mm.plugin.appbrand.debugger;

import a.f.b.j;
import a.l;
import com.tencent.luggage.sdk.b.a.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/debugger/RemoteDebugServiceLogicWC;", "Lcom/tencent/luggage/sdk/jsapi/component/service/MPRemoteDebugServiceLogic;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "service", "(Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;)V", "getService", "()Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "getCustomJsApiPool", "", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "plugin-appbrand-integration_release"})
public final class r
  extends g<com.tencent.mm.plugin.appbrand.service.c>
{
  private final com.tencent.mm.plugin.appbrand.service.c hmn;
  
  public r(com.tencent.mm.plugin.appbrand.service.c paramc)
  {
    super((com.tencent.luggage.sdk.b.a.c.c)paramc);
    AppMethodBeat.i(143735);
    this.hmn = paramc;
    AppMethodBeat.o(143735);
  }
  
  public final Map<String, m> wM()
  {
    AppMethodBeat.i(143734);
    Map localMap = q.aBx();
    j.p(localMap, "AppBrandJsApiPool.getServiceApiPool()");
    AppMethodBeat.o(143734);
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.r
 * JD-Core Version:    0.7.0.1
 */