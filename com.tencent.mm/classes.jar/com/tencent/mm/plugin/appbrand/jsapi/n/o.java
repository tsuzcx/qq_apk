package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.u;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiRewriteRoute;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wxa-app_release"})
public final class o
  extends a<d>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "rewriteRoute";
  @Deprecated
  public static final a lbw;
  
  static
  {
    AppMethodBeat.i(197500);
    lbw = new a((byte)0);
    AppMethodBeat.o(197500);
  }
  
  public final boolean bib()
  {
    return true;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiRewriteRoute$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-wxa-app_release"})
  static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(o paramo, d paramd, String paramString, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(197498);
      Object localObject = this.ktS.getRuntime();
      p.g(localObject, "env.runtime");
      boolean bool = ((AppBrandRuntime)localObject).aVN().Ti(this.lby);
      d locald = this.ktS;
      int i = this.krv;
      o localo = this.lbx;
      if (bool) {}
      for (localObject = "ok";; localObject = "fail")
      {
        locald.h(i, localo.Pg((String)localObject));
        AppMethodBeat.o(197498);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.o
 * JD-Core Version:    0.7.0.1
 */