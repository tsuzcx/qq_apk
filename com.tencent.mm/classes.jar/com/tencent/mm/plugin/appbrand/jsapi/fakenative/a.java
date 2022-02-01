package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.ui.v;
import com.tencent.mm.plugin.appbrand.ui.w;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiHideSplashScreenshot;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Constants", "plugin-appbrand-integration_release"})
public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  public static final int CTRL_INDEX = -1;
  public static final String NAME = "hideSplashScreenshot";
  public static final a kPh;
  
  static
  {
    AppMethodBeat.i(223383);
    kPh = new a((byte)0);
    AppMethodBeat.o(223383);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiHideSplashScreenshot$Constants;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama, p paramp, c paramc, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(223380);
      w localw = this.jzv.aWN();
      if (localw == null)
      {
        this.kPj.h(this.kuL, this.kPi.PO("fail: timeout"));
        AppMethodBeat.o(223380);
        return;
      }
      if ((localw instanceof v))
      {
        this.jzv.aWw();
        this.kPj.h(this.kuL, this.kPi.PO("ok"));
        AppMethodBeat.o(223380);
        return;
      }
      this.kPj.h(this.kuL, this.kPi.PO("fail: screenshot invalid"));
      AppMethodBeat.o(223380);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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