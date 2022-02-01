package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.utils.am;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiSetVisualEffectOnCapture;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wxa-app-jsapi_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ah
  extends c<g>
{
  private static final int CTRL_INDEX = 1066;
  private static final String NAME = "setVisualEffectOnCapture";
  public static final ah.a soE;
  
  static
  {
    AppMethodBeat.i(327756);
    soE = new ah.a((byte)0);
    AppMethodBeat.o(327756);
  }
  
  private static final void a(am paramam)
  {
    AppMethodBeat.i(327753);
    s.u(paramam, "$switcher");
    if (paramam.cNG()) {
      paramam.urL = true;
    }
    AppMethodBeat.o(327753);
  }
  
  private static final void b(am paramam)
  {
    AppMethodBeat.i(327755);
    s.u(paramam, "$switcher");
    if (paramam.cNH()) {
      paramam.urL = false;
    }
    AppMethodBeat.o(327755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.ah
 * JD-Core Version:    0.7.0.1
 */