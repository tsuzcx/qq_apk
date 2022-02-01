package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ac;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiHideHomeButton;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wxa-app-jsapi_release"})
public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.d<com.tencent.mm.plugin.appbrand.d>
{
  public static final int CTRL_INDEX = 684;
  public static final String NAME = "hideHomeButton";
  @Deprecated
  public static final a mkn;
  
  static
  {
    AppMethodBeat.i(240921);
    mkn = new a((byte)0);
    AppMethodBeat.o(240921);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiHideHomeButton$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-wxa-app-jsapi_release"})
  static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(d paramd, ac paramac, com.tencent.mm.plugin.appbrand.d paramd1, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(240919);
      if (this.mkp.bRi() == null) {
        this.mkp.bRE();
      }
      for (;;)
      {
        com.tencent.mm.plugin.appbrand.d locald = this.lBv;
        if (locald == null) {
          p.hyc();
        }
        locald.i(this.lyo, this.mko.Zf("ok"));
        AppMethodBeat.o(240919);
        return;
        this.mkp.bRF();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.d
 * JD-Core Version:    0.7.0.1
 */