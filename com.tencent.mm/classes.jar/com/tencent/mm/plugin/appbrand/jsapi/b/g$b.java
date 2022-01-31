package com.tencent.mm.plugin.appbrand.jsapi.b;

import a.f.b.j;
import a.l;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Request;", "", "id", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement;I)V", "value", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;", "callback", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;)V", "getId", "()I", "", "isViewReady", "()Z", "setViewReady", "(Z)V", "invoke", "", "plugin-appbrand-integration_release"})
final class g$b
{
  boolean hJJ;
  com.tencent.mm.plugin.appbrand.jsapi.base.g hJK;
  private final int id;
  
  public g$b(int paramInt)
  {
    int i;
    this.id = i;
  }
  
  final void ate()
  {
    AppMethodBeat.i(134664);
    if (!this.hJJ)
    {
      localObject = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(134664);
      throw ((Throwable)localObject);
    }
    Object localObject = this.hJK;
    if (localObject == null) {
      j.ebi();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.base.g)localObject).BS(this.hJL.BL("ok"));
    g.a(this.hJL).remove(Integer.valueOf(this.id));
    d.i("JsApiInsertHTMLCanvasElement", "callback ok for canvasId [" + this.id + ']');
    AppMethodBeat.o(134664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.g.b
 * JD-Core Version:    0.7.0.1
 */