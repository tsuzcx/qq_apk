package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.page.ae;
import d.g.b.p;
import d.l;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiRemoveHTMLCanvasElement;", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/BaseRemoveViewJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "()V", "getViewId", "", "data", "Lorg/json/JSONObject;", "onRemoveView", "", "component", "viewId", "view", "Landroid/view/View;", "Companion", "plugin-appbrand-integration_release"})
public final class k
  extends c<ae>
{
  public static final int CTRL_INDEX = 596;
  public static final String NAME = "removeWebGLCanvas";
  public static final k.a kJf;
  
  static
  {
    AppMethodBeat.i(50504);
    kJf = new k.a((byte)0);
    AppMethodBeat.o(50504);
  }
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(50502);
    p.h(paramJSONObject, "data");
    int i = paramJSONObject.getInt("canvasId");
    AppMethodBeat.o(50502);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.k
 * JD-Core Version:    0.7.0.1
 */