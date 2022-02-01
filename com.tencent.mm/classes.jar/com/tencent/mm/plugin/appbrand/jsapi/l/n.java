package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.t;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiRewriteRoute;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wxa-app_release"})
public final class n
  extends a<d>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "rewriteRoute";
  @Deprecated
  public static final a kes;
  
  static
  {
    AppMethodBeat.i(194370);
    kes = new a((byte)0);
    AppMethodBeat.o(194370);
  }
  
  public final boolean aXA()
  {
    return true;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiRewriteRoute$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-wxa-app_release"})
  static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(n paramn, d paramd, String paramString, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(194368);
      Object localObject = this.jyZ.getRuntime();
      k.g(localObject, "env.runtime");
      boolean bool = ((AppBrandRuntime)localObject).aLK().Lx(this.keu);
      d locald = this.jyZ;
      int i = this.jxb;
      n localn = this.ket;
      if (bool) {}
      for (localObject = "ok";; localObject = "fail")
      {
        locald.h(i, localn.HI((String)localObject));
        AppMethodBeat.o(194368);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.n
 * JD-Core Version:    0.7.0.1
 */