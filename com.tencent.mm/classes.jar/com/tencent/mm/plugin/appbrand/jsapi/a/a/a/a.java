package com.tencent.mm.plugin.appbrand.jsapi.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.c;
import d.l;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/jsapi/AppBrandWebGLPluginJsApi;", "Lcom/tencent/mm/plugin/appbrand/extendplugin/AppBrandPluginAsyncJsApi;", "()V", "getPluginType", "", "getViewId", "", "data", "Lorg/json/JSONObject;", "plugin-appbrand-integration_release"})
public class a
  extends c
{
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(189115);
    if (paramJSONObject != null)
    {
      int i = paramJSONObject.optInt("canvasId", -1);
      AppMethodBeat.o(189115);
      return i;
    }
    AppMethodBeat.o(189115);
    return -1;
  }
  
  public final String bgx()
  {
    return "webgl";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */