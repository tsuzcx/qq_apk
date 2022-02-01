package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.ui.t;
import com.tencent.mm.plugin.appbrand.ui.u;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiHideSplashScreenshot;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Constants", "plugin-appbrand-integration_release"})
public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  public static final int CTRL_INDEX = -1;
  public static final String NAME = "hideSplashScreenshot";
  public static final a kqv;
  
  static
  {
    AppMethodBeat.i(187191);
    kqv = new a((byte)0);
    AppMethodBeat.o(187191);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiHideSplashScreenshot$Constants;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama, o paramo, c paramc, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(187188);
      u localu = this.jdq.aSY();
      if (localu == null)
      {
        this.kqx.h(this.jXx, this.kqw.LM("fail: timeout"));
        AppMethodBeat.o(187188);
        return;
      }
      if ((localu instanceof t))
      {
        this.jdq.aSH();
        this.kqx.h(this.jXx, this.kqw.LM("ok"));
        AppMethodBeat.o(187188);
        return;
      }
      this.kqx.h(this.jXx, this.kqw.LM("fail: screenshot invalid"));
      AppMethodBeat.o(187188);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(a parama, c paramc, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.a
 * JD-Core Version:    0.7.0.1
 */