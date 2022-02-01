package com.tencent.mm.plugin.appbrand.jsapi.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.page.ae;
import d.g.b.k;
import d.l;
import org.json.JSONObject;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiUpdateHTMLCanvasElement;", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/BaseUpdateViewJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "()V", "enableGesture", "", "getViewId", "", "data", "Lorg/json/JSONObject;", "onUpdateView", "component", "viewId", "view", "Landroid/view/View;", "Companion", "plugin-appbrand-integration_release"})
public final class m
  extends c<ae>
{
  public static final int CTRL_INDEX = 595;
  public static final String NAME = "updateWebGLCanvas";
  public static final a jNF;
  
  static
  {
    AppMethodBeat.i(50507);
    jNF = new a((byte)0);
    AppMethodBeat.o(50507);
  }
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(50505);
    k.h(paramJSONObject, "data");
    int i = paramJSONObject.getInt("canvasId");
    AppMethodBeat.o(50505);
    return i;
  }
  
  public final boolean aYx()
  {
    return true;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiUpdateHTMLCanvasElement$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.m
 * JD-Core Version:    0.7.0.1
 */