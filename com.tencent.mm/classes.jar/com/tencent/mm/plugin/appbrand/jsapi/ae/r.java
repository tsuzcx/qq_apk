package com.tencent.mm.plugin.appbrand.jsapi.ae;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetSystemInfoWC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetSystemInfoLU;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "fillExtraInfo", "", "component", "data", "", "", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  extends p<g>
{
  public static final a swZ;
  
  static
  {
    AppMethodBeat.i(326033);
    swZ = new a((byte)0);
    AppMethodBeat.o(326033);
  }
  
  public r()
  {
    super((d)new e());
    AppMethodBeat.i(326030);
    AppMethodBeat.o(326030);
  }
  
  protected final void b(g paramg, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(326035);
    s.u(paramg, "component");
    s.u(paramMap, "data");
    super.b(paramg, paramMap);
    a.c(paramg, paramMap);
    AppMethodBeat.o(326035);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetSystemInfoWC$Companion;", "", "()V", "TAG", "", "overrideScreenTop", "", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void c(g paramg, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(326032);
      s.u(paramg, "component");
      s.u(paramMap, "data");
      paramg = paramg.getRuntime();
      if (paramg == null) {}
      for (paramg = null; paramg == null; paramg = paramg.asH())
      {
        Log.i("JsApiGetSystemInfoWC", "initConfig is null, return");
        AppMethodBeat.o(326032);
        return;
      }
      if (((paramg instanceof AppBrandInitConfigWC)) && (((AppBrandInitConfigWC)paramg).qAT.isEnable()))
      {
        Log.i("JsApiGetSystemInfoWC", "half screen mode, force [screenTop] to 0");
        paramMap.put("screenTop", Integer.valueOf(0));
      }
      AppMethodBeat.o(326032);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ae.r
 * JD-Core Version:    0.7.0.1
 */