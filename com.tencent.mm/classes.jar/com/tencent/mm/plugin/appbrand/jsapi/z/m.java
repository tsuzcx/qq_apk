package com.tencent.mm.plugin.appbrand.jsapi.z;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetSystemInfoWC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetSystemInfoLU;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "fillExtraInfo", "", "component", "data", "", "", "", "Companion", "plugin-appbrand-integration_release"})
public final class m
  extends k<d>
{
  public static final a mua;
  
  static
  {
    AppMethodBeat.i(228576);
    mua = new a((byte)0);
    AppMethodBeat.o(228576);
  }
  
  protected final void a(d paramd, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(228575);
    p.h(paramd, "component");
    p.h(paramMap, "data");
    super.a(paramd, paramMap);
    paramd = paramd.getRuntime();
    if (paramd != null)
    {
      paramd = paramd.OU();
      if (paramd != null) {}
    }
    else
    {
      Log.i("JsApiGetSystemInfoWC", "initConfig is null, return");
      AppMethodBeat.o(228575);
      return;
    }
    if (((paramd instanceof AppBrandInitConfigWC)) && (((AppBrandInitConfigWC)paramd).kHL.isEnable()))
    {
      Log.i("JsApiGetSystemInfoWC", "half screen mode, force [screenTop] to 0");
      paramMap.put("screenTop", Integer.valueOf(0));
    }
    AppMethodBeat.o(228575);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetSystemInfoWC$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.m
 * JD-Core Version:    0.7.0.1
 */