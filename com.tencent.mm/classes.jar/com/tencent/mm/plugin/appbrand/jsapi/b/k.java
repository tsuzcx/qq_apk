package com.tencent.mm.plugin.appbrand.jsapi.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.page.ag;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiRemoveHTMLCanvasElement;", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/BaseRemoveViewJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "()V", "getViewId", "", "data", "Lorg/json/JSONObject;", "onRemoveView", "", "component", "viewId", "view", "Landroid/view/View;", "Companion", "plugin-appbrand-integration_release"})
public final class k
  extends c<ag>
{
  public static final int CTRL_INDEX = 596;
  public static final String NAME = "removeWebGLCanvas";
  public static final a lRg;
  
  static
  {
    AppMethodBeat.i(50504);
    lRg = new a((byte)0);
    AppMethodBeat.o(50504);
  }
  
  public final int H(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(50502);
    p.h(paramJSONObject, "data");
    int i = paramJSONObject.getInt("canvasId");
    AppMethodBeat.o(50502);
    return i;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiRemoveHTMLCanvasElement$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.k
 * JD-Core Version:    0.7.0.1
 */