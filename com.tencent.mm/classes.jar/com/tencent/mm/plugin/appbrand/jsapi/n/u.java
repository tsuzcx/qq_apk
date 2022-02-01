package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.b.g;
import com.tencent.mm.plugin.appbrand.page.b.i;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.r;
import d.g.b.p;
import d.g.b.y.a;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiSetNavigateBackInterception;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "Lcom/tencent/mm/plugin/appbrand/jsapi/page/NavigateBackInterceptionConstant;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "isEmpty", "", "Lorg/json/JSONArray;", "Companion", "luggage-wxa-app-jsapi_release"})
public final class u
  extends a<r>
{
  public static final int CTRL_INDEX = 880;
  public static final String NAME = "setNavigateBackInterception";
  public static final a lfq;
  
  static
  {
    AppMethodBeat.i(209705);
    lfq = new a((byte)0);
    AppMethodBeat.o(209705);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiSetNavigateBackInterception$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "typeToScene", "type", "luggage-wxa-app-jsapi_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(u paramu, q paramq, r paramr, y.a parama, ArrayList paramArrayList, int paramInt) {}
    
    public final void run()
    {
      Object localObject2 = null;
      AppMethodBeat.i(209703);
      Object localObject1 = this.lfn;
      if (localObject1 != null)
      {
        localObject1 = ((q)localObject1).getCurrentUrl();
        localObject3 = (CharSequence)localObject1;
        localObject1 = this.lfo.getRuntime();
        p.g(localObject1, "env.runtime");
        localObject1 = ((AppBrandRuntime)localObject1).aWm();
        p.g(localObject1, "env.runtime.pageContainer");
        localObject1 = ((t)localObject1).getCurrentPage();
        if (localObject1 == null) {
          break label87;
        }
      }
      label87:
      for (localObject1 = ((q)localObject1).getCurrentUrl();; localObject1 = null)
      {
        if (TextUtils.equals((CharSequence)localObject3, (CharSequence)localObject1)) {
          break label92;
        }
        AppMethodBeat.o(209703);
        return;
        localObject1 = null;
        break;
      }
      label92:
      localObject1 = this.lfo.getRuntime();
      p.g(localObject1, "env.runtime");
      localObject1 = ((AppBrandRuntime)localObject1).aWm();
      p.g(localObject1, "env.runtime.pageContainer");
      Object localObject3 = ((t)localObject1).getCurrentPage();
      if (localObject3 != null)
      {
        i locali = i.mlx;
        localObject1 = localObject2;
        if (this.lfs.NiT) {
          localObject1 = new g(null, (List)this.lft, 1);
        }
        ((q)localObject3).a(locali, (g)localObject1);
      }
      this.lfo.h(this.kuL, this.lfr.PO("ok"));
      AppMethodBeat.o(209703);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.u
 * JD-Core Version:    0.7.0.1
 */