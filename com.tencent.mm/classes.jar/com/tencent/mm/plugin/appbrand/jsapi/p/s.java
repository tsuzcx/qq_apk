package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.w;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiRewriteRoute;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wxa-app_release"})
public final class s
  extends com.tencent.mm.plugin.appbrand.jsapi.d<com.tencent.mm.plugin.appbrand.d>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "rewriteRoute";
  @Deprecated
  public static final a mkE;
  
  static
  {
    AppMethodBeat.i(219681);
    mkE = new a((byte)0);
    AppMethodBeat.o(219681);
  }
  
  public final boolean bEa()
  {
    return true;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiRewriteRoute$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-wxa-app_release"})
  static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(s params, com.tencent.mm.plugin.appbrand.d paramd, int paramInt1, String paramString, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(219679);
      Object localObject = this.lBv.getRuntime();
      p.g(localObject, "env.runtime");
      boolean bool = ((AppBrandRuntime)localObject).brh().ar(this.mkG, this.mkH);
      com.tencent.mm.plugin.appbrand.d locald = this.lBv;
      int i = this.lyo;
      s locals = this.mkF;
      if (bool) {}
      for (localObject = "ok";; localObject = "fail")
      {
        locald.i(i, locals.Zf((String)localObject));
        AppMethodBeat.o(219679);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.s
 * JD-Core Version:    0.7.0.1
 */