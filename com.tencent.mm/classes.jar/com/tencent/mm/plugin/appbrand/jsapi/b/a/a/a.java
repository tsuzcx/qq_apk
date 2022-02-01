package com.tencent.mm.plugin.appbrand.jsapi.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.c;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/jsapi/AppBrandWebGLPluginJsApi;", "Lcom/tencent/mm/plugin/appbrand/extendplugin/AppBrandPluginAsyncJsApi;", "()V", "getPluginType", "", "getViewId", "", "data", "Lorg/json/JSONObject;", "plugin-appbrand-integration_release"})
public class a
  extends c
{
  public final int H(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(228367);
    if (paramJSONObject != null)
    {
      int i = paramJSONObject.optInt("canvasId", -1);
      AppMethodBeat.o(228367);
      return i;
    }
    AppMethodBeat.o(228367);
    return -1;
  }
  
  public final String bCy()
  {
    return "webgl";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */