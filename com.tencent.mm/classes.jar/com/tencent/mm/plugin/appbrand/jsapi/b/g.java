package com.tencent.mm.plugin.appbrand.jsapi.b;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.page.z;
import java.util.HashMap;
import org.json.JSONObject;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement;", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/BaseInsertViewJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "()V", "requestMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Request;", "Lkotlin/collections/HashMap;", "scrollSupportedTouchEvent", "", "enableGesture", "enableLongClick", "getViewId", "data", "Lorg/json/JSONObject;", "inflateView", "Landroid/view/View;", "component", "viewId", "isAsyncCallback", "onInsertViewWithAsyncCallback", "", "view", "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;", "Companion", "Request", "SurfaceAvailableListener", "plugin-appbrand-integration_release"})
public final class g
  extends a<z>
{
  public static final int CTRL_INDEX = 594;
  public static final String NAME = "insertWebGLCanvas";
  public static final g.a hJI;
  private final HashMap<Integer, g.b> hJG;
  private boolean hJH;
  
  static
  {
    AppMethodBeat.i(134675);
    hJI = new g.a((byte)0);
    AppMethodBeat.o(134675);
  }
  
  public g()
  {
    AppMethodBeat.i(134674);
    this.hJG = new HashMap();
    AppMethodBeat.o(134674);
  }
  
  public final boolean aCb()
  {
    return true;
  }
  
  public final boolean aCc()
  {
    return this.hJH;
  }
  
  public final boolean aCd()
  {
    return this.hJH;
  }
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(134672);
    j.q(paramJSONObject, "data");
    int i = paramJSONObject.getInt("canvasId");
    AppMethodBeat.o(134672);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.g
 * JD-Core Version:    0.7.0.1
 */