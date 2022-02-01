package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.c.f;
import com.tencent.mm.plugin.appbrand.page.c.h;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.q;
import d.g.b.p;
import d.g.b.y.a;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiSetNavigateBackInterception;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "Lcom/tencent/mm/plugin/appbrand/jsapi/page/NavigateBackInterceptionConstant;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "isEmpty", "", "Lorg/json/JSONArray;", "Companion", "luggage-wxa-app-jsapi_release"})
public final class u
  extends a<q>
{
  public static final int CTRL_INDEX = 880;
  public static final String NAME = "setNavigateBackInterception";
  public static final a lbF;
  
  static
  {
    AppMethodBeat.i(198666);
    lbF = new a((byte)0);
    AppMethodBeat.o(198666);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiSetNavigateBackInterception$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "typeToScene", "type", "luggage-wxa-app-jsapi_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(u paramu, r paramr, q paramq, y.a parama, ArrayList paramArrayList, int paramInt) {}
    
    public final void run()
    {
      Object localObject2 = null;
      AppMethodBeat.i(198664);
      Object localObject1 = this.lbC;
      if (localObject1 != null)
      {
        localObject1 = ((r)localObject1).getCurrentUrl();
        localObject3 = (CharSequence)localObject1;
        localObject1 = this.lbD.getRuntime();
        p.g(localObject1, "env.runtime");
        localObject1 = ((AppBrandRuntime)localObject1).aVN();
        p.g(localObject1, "env.runtime.pageContainer");
        localObject1 = ((com.tencent.mm.plugin.appbrand.page.u)localObject1).getCurrentPage();
        if (localObject1 == null) {
          break label87;
        }
      }
      label87:
      for (localObject1 = ((r)localObject1).getCurrentUrl();; localObject1 = null)
      {
        if (TextUtils.equals((CharSequence)localObject3, (CharSequence)localObject1)) {
          break label92;
        }
        AppMethodBeat.o(198664);
        return;
        localObject1 = null;
        break;
      }
      label92:
      localObject1 = this.lbD.getRuntime();
      p.g(localObject1, "env.runtime");
      localObject1 = ((AppBrandRuntime)localObject1).aVN();
      p.g(localObject1, "env.runtime.pageContainer");
      Object localObject3 = ((com.tencent.mm.plugin.appbrand.page.u)localObject1).getCurrentPage();
      if (localObject3 != null)
      {
        h localh = h.mgy;
        localObject1 = localObject2;
        if (this.lbH.MLQ) {
          localObject1 = new f(null, (List)this.lbI, 1);
        }
        ((r)localObject3).a(localh, (f)localObject1);
      }
      this.lbD.h(this.krv, this.lbG.Pg("ok"));
      AppMethodBeat.o(198664);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.u
 * JD-Core Version:    0.7.0.1
 */