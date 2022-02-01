package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.ui.u;
import com.tencent.mm.plugin.appbrand.ui.v;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiHideSplashScreenshot;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Constants", "plugin-appbrand-integration_release"})
public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  public static final int CTRL_INDEX = -1;
  public static final String NAME = "hideSplashScreenshot";
  public static final a kLR;
  
  static
  {
    AppMethodBeat.i(189124);
    kLR = new a((byte)0);
    AppMethodBeat.o(189124);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiHideSplashScreenshot$Constants;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama, o paramo, c paramc, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(189121);
      v localv = this.jwz.aWm();
      if (localv == null)
      {
        this.kLT.h(this.krv, this.kLS.Pg("fail: timeout"));
        AppMethodBeat.o(189121);
        return;
      }
      if ((localv instanceof u))
      {
        this.jwz.aVV();
        this.kLT.h(this.krv, this.kLS.Pg("ok"));
        AppMethodBeat.o(189121);
        return;
      }
      this.kLT.h(this.krv, this.kLS.Pg("fail: screenshot invalid"));
      AppMethodBeat.o(189121);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
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