package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.b.g;
import com.tencent.mm.plugin.appbrand.page.b.i;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.s;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.z.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiSetNavigateBackInterception;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "Lcom/tencent/mm/plugin/appbrand/jsapi/page/NavigateBackInterceptionConstant;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "isEmpty", "", "Lorg/json/JSONArray;", "Companion", "luggage-wxa-app-jsapi_release"})
public final class y
  extends d<s>
{
  public static final int CTRL_INDEX = 880;
  public static final String NAME = "setNavigateBackInterception";
  public static final a mkN;
  
  static
  {
    AppMethodBeat.i(240924);
    mkN = new a((byte)0);
    AppMethodBeat.o(240924);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiSetNavigateBackInterception$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "typeToScene", "type", "luggage-wxa-app-jsapi_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(y paramy, t paramt, s params, z.a parama, ArrayList paramArrayList, int paramInt) {}
    
    public final void run()
    {
      Object localObject2 = null;
      AppMethodBeat.i(240922);
      Object localObject1 = this.mkL;
      if (localObject1 != null)
      {
        localObject1 = ((t)localObject1).getCurrentUrl();
        localObject3 = (CharSequence)localObject1;
        localObject1 = this.lXa.getRuntime();
        p.g(localObject1, "env.runtime");
        localObject1 = ((AppBrandRuntime)localObject1).brh();
        p.g(localObject1, "env.runtime.pageContainer");
        localObject1 = ((w)localObject1).getCurrentPage();
        if (localObject1 == null) {
          break label87;
        }
      }
      label87:
      for (localObject1 = ((t)localObject1).getCurrentUrl();; localObject1 = null)
      {
        if (TextUtils.equals((CharSequence)localObject3, (CharSequence)localObject1)) {
          break label92;
        }
        AppMethodBeat.o(240922);
        return;
        localObject1 = null;
        break;
      }
      label92:
      localObject1 = this.lXa.getRuntime();
      p.g(localObject1, "env.runtime");
      localObject1 = ((AppBrandRuntime)localObject1).brh();
      p.g(localObject1, "env.runtime.pageContainer");
      Object localObject3 = ((w)localObject1).getCurrentPage();
      if (localObject3 != null)
      {
        i locali = i.nvV;
        localObject1 = localObject2;
        if (this.mkP.SYB) {
          localObject1 = new g(null, (List)this.mkQ, 1);
        }
        ((t)localObject3).a(locali, (g)localObject1);
      }
      this.lXa.i(this.lyo, this.mkO.Zf("ok"));
      AppMethodBeat.o(240922);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.y
 * JD-Core Version:    0.7.0.1
 */