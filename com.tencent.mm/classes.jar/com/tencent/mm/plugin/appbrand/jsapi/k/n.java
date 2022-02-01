package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.u;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiRewriteRoute;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wxa-app_release"})
public final class n
  extends a<d>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "rewriteRoute";
  @Deprecated
  public static final a kFk;
  
  static
  {
    AppMethodBeat.i(193281);
    kFk = new a((byte)0);
    AppMethodBeat.o(193281);
  }
  
  public final boolean bex()
  {
    return true;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiRewriteRoute$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-wxa-app_release"})
  static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(n paramn, d paramd, String paramString, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(193279);
      Object localObject = this.jZw.getRuntime();
      k.g(localObject, "env.runtime");
      boolean bool = ((AppBrandRuntime)localObject).aSA().PF(this.kFm);
      d locald = this.jZw;
      int i = this.jXx;
      n localn = this.kFl;
      if (bool) {}
      for (localObject = "ok";; localObject = "fail")
      {
        locald.h(i, localn.LM((String)localObject));
        AppMethodBeat.o(193279);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.n
 * JD-Core Version:    0.7.0.1
 */