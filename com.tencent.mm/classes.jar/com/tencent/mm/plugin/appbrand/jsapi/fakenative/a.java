package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.ui.aa;
import com.tencent.mm.plugin.appbrand.ui.ab;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiHideSplashScreenshot;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Constants", "plugin-appbrand-integration_release"})
public final class a
  extends d<c>
{
  public static final int CTRL_INDEX = -1;
  public static final String NAME = "hideSplashScreenshot";
  public static final a lUf;
  
  static
  {
    AppMethodBeat.i(228398);
    lUf = new a((byte)0);
    AppMethodBeat.o(228398);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiHideSplashScreenshot$Constants;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama, com.tencent.mm.plugin.appbrand.q paramq, c paramc, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(228395);
      ab localab = this.kAi.brK();
      if (localab == null)
      {
        this.lUh.i(this.lyo, this.lUg.Zf("fail: timeout"));
        AppMethodBeat.o(228395);
        return;
      }
      if ((localab instanceof aa))
      {
        this.kAi.brr();
        this.lUh.i(this.lyo, this.lUg.Zf("ok"));
        AppMethodBeat.o(228395);
        return;
      }
      this.lUh.i(this.lyo, this.lUg.Zf("fail: screenshot invalid"));
      AppMethodBeat.o(228395);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(a parama, c paramc, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.a
 * JD-Core Version:    0.7.0.1
 */