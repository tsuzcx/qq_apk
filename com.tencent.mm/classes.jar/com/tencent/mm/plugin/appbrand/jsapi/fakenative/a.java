package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.ui.u;
import com.tencent.mm.plugin.appbrand.ui.v;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiHideSplashScreenshot;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Constants", "plugin-appbrand-integration_release"})
public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  public static final int CTRL_INDEX = -1;
  public static final String NAME = "hideSplashScreenshot";
  public static final a jPJ;
  
  static
  {
    AppMethodBeat.i(196311);
    jPJ = new a((byte)0);
    AppMethodBeat.o(196311);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiHideSplashScreenshot$Constants;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama, o paramo, c paramc, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(196308);
      v localv = this.iDq.aMi();
      if (localv == null)
      {
        this.jPL.h(this.jxb, this.jPK.HI("fail: timeout"));
        AppMethodBeat.o(196308);
        return;
      }
      if ((localv instanceof u))
      {
        this.iDq.aLR();
        this.jPL.h(this.jxb, this.jPK.HI("ok"));
        AppMethodBeat.o(196308);
        return;
      }
      this.jPL.h(this.jxb, this.jPK.HI("fail: screenshot invalid"));
      AppMethodBeat.o(196308);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.a
 * JD-Core Version:    0.7.0.1
 */