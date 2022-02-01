package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.t;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiRewriteRoute;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wxa-app_release"})
public final class o
  extends a<d>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "rewriteRoute";
  @Deprecated
  public static final a lfh;
  
  static
  {
    AppMethodBeat.i(208071);
    lfh = new a((byte)0);
    AppMethodBeat.o(208071);
  }
  
  public final boolean biK()
  {
    return true;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiRewriteRoute$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-wxa-app_release"})
  static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(o paramo, d paramd, String paramString, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(208069);
      Object localObject = this.kxi.getRuntime();
      p.g(localObject, "env.runtime");
      boolean bool = ((AppBrandRuntime)localObject).aWm().TR(this.lfj);
      d locald = this.kxi;
      int i = this.kuL;
      o localo = this.lfi;
      if (bool) {}
      for (localObject = "ok";; localObject = "fail")
      {
        locald.h(i, localo.PO((String)localObject));
        AppMethodBeat.o(208069);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.o
 * JD-Core Version:    0.7.0.1
 */