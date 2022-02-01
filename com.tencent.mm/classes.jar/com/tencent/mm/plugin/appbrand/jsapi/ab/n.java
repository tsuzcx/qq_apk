package com.tencent.mm.plugin.appbrand.jsapi.ab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetSystemInfoWC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetSystemInfoLU;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "fillExtraInfo", "", "component", "data", "", "", "", "Companion", "plugin-appbrand-integration_release"})
public final class n
  extends l<g>
{
  public static final n.a psl;
  
  static
  {
    AppMethodBeat.i(280184);
    psl = new n.a((byte)0);
    AppMethodBeat.o(280184);
  }
  
  protected final void a(g paramg, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(280183);
    p.k(paramg, "component");
    p.k(paramMap, "data");
    super.a(paramg, paramMap);
    paramg = paramg.getRuntime();
    if (paramg != null)
    {
      paramg = paramg.Sq();
      if (paramg != null) {}
    }
    else
    {
      Log.i("JsApiGetSystemInfoWC", "initConfig is null, return");
      AppMethodBeat.o(280183);
      return;
    }
    if (((paramg instanceof AppBrandInitConfigWC)) && (((AppBrandInitConfigWC)paramg).nBE.isEnable()))
    {
      Log.i("JsApiGetSystemInfoWC", "half screen mode, force [screenTop] to 0");
      paramMap.put("screenTop", Integer.valueOf(0));
    }
    AppMethodBeat.o(280183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab.n
 * JD-Core Version:    0.7.0.1
 */