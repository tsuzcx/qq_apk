package com.tencent.mm.plugin.appbrand.jsapi.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.c;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/jsapi/AppBrandWebGLPluginJsApi;", "Lcom/tencent/mm/plugin/appbrand/extendplugin/AppBrandPluginAsyncJsApi;", "()V", "getPluginType", "", "getViewId", "", "data", "Lorg/json/JSONObject;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
  extends c
{
  public final int V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(327989);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(327989);
      return -1;
    }
    int i = paramJSONObject.optInt("canvasId", -1);
    AppMethodBeat.o(327989);
    return i;
  }
  
  public final String cog()
  {
    return "webgl";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c.a.a.a
 * JD-Core Version:    0.7.0.1
 */