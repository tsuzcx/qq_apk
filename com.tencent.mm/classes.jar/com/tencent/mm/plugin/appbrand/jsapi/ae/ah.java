package com.tencent.mm.plugin.appbrand.jsapi.ae;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/PartOfGetSystemInfo_WindowInfoWC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/PartOfGetSystemInfo_WindowInfo;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "overrideWindowInfo", "", "component", "outRes", "", "", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class ah
  extends ag<g>
{
  protected final void a(g paramg, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(326082);
    s.u(paramg, "component");
    s.u(paramMap, "outRes");
    r.a locala = r.swZ;
    r.a.c(paramg, paramMap);
    AppMethodBeat.o(326082);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ae.ah
 * JD-Core Version:    0.7.0.1
 */