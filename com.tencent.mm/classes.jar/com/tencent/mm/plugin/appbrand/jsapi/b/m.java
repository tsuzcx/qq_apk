package com.tencent.mm.plugin.appbrand.jsapi.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.page.ag;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiUpdateHTMLCanvasElement;", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/BaseUpdateViewJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "()V", "enableGesture", "", "getViewId", "", "data", "Lorg/json/JSONObject;", "onUpdateView", "component", "viewId", "view", "Landroid/view/View;", "Companion", "plugin-appbrand-integration_release"})
public final class m
  extends d<ag>
{
  public static final int CTRL_INDEX = 595;
  public static final String NAME = "updateWebGLCanvas";
  public static final a lRh;
  
  static
  {
    AppMethodBeat.i(50507);
    lRh = new a((byte)0);
    AppMethodBeat.o(50507);
  }
  
  public final int H(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(50505);
    p.h(paramJSONObject, "data");
    int i = paramJSONObject.getInt("canvasId");
    AppMethodBeat.o(50505);
    return i;
  }
  
  public final boolean bEW()
  {
    return true;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiUpdateHTMLCanvasElement$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.m
 * JD-Core Version:    0.7.0.1
 */