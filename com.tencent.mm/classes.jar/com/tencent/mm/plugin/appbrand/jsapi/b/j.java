package com.tencent.mm.plugin.appbrand.jsapi.b;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.page.z;
import org.json.JSONObject;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiRemoveHTMLCanvasElement;", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/BaseRemoveViewJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "()V", "getViewId", "", "data", "Lorg/json/JSONObject;", "onRemoveView", "", "component", "viewId", "view", "Landroid/view/View;", "Companion", "plugin-appbrand-integration_release"})
public final class j
  extends b<z>
{
  public static final int CTRL_INDEX = 596;
  public static final String NAME = "removeWebGLCanvas";
  public static final a hJP;
  
  static
  {
    AppMethodBeat.i(134678);
    hJP = new a((byte)0);
    AppMethodBeat.o(134678);
  }
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(134676);
    a.f.b.j.q(paramJSONObject, "data");
    int i = paramJSONObject.getInt("canvasId");
    AppMethodBeat.o(134676);
    return i;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiRemoveHTMLCanvasElement$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.j
 * JD-Core Version:    0.7.0.1
 */