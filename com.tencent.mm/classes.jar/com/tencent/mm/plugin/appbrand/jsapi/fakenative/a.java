package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.ui.aa;
import com.tencent.mm.plugin.appbrand.ui.z;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiHideSplashScreenshot;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Constants", "plugin-appbrand-integration_release"})
public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.service.c>
{
  public static final int CTRL_INDEX = -1;
  public static final String NAME = "hideSplashScreenshot";
  public static final a.a oQZ;
  
  static
  {
    AppMethodBeat.i(282617);
    oQZ = new a.a((byte)0);
    AppMethodBeat.o(282617);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama, t paramt, com.tencent.mm.plugin.appbrand.service.c paramc, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(269679);
      aa localaa = this.oRb.bCz();
      if (localaa == null)
      {
        this.oxi.j(this.otk, this.oRa.agS("fail: timeout"));
        AppMethodBeat.o(269679);
        return;
      }
      if ((localaa instanceof z))
      {
        this.oRb.bCh();
        this.oxi.j(this.otk, this.oRa.agS("ok"));
        AppMethodBeat.o(269679);
        return;
      }
      this.oxi.j(this.otk, this.oRa.agS("fail: screenshot invalid"));
      AppMethodBeat.o(269679);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(a parama, com.tencent.mm.plugin.appbrand.service.c paramc, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.a
 * JD-Core Version:    0.7.0.1
 */