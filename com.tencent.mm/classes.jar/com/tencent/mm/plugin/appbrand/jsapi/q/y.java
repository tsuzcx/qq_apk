package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.b.g;
import com.tencent.mm.plugin.appbrand.page.b.i;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.v;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.aa.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiSetNavigateBackInterception;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "Lcom/tencent/mm/plugin/appbrand/jsapi/page/NavigateBackInterceptionConstant;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "isEmpty", "", "Lorg/json/JSONArray;", "Companion", "luggage-wxa-app-jsapi_release"})
public final class y
  extends c<v>
{
  public static final int CTRL_INDEX = 880;
  public static final String NAME = "setNavigateBackInterception";
  public static final a piS;
  
  static
  {
    AppMethodBeat.i(209189);
    piS = new a((byte)0);
    AppMethodBeat.o(209189);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiSetNavigateBackInterception$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "typeToScene", "type", "luggage-wxa-app-jsapi_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(y paramy, u paramu, v paramv, aa.a parama, ArrayList paramArrayList, int paramInt) {}
    
    public final void run()
    {
      Object localObject2 = null;
      AppMethodBeat.i(209100);
      Object localObject1 = this.piQ;
      if (localObject1 != null)
      {
        localObject1 = ((u)localObject1).getCurrentUrl();
        localObject3 = (CharSequence)localObject1;
        localObject1 = this.oUL.getRuntime();
        p.j(localObject1, "env.runtime");
        localObject1 = ((AppBrandRuntime)localObject1).bBX();
        p.j(localObject1, "env.runtime.pageContainer");
        localObject1 = ((x)localObject1).getCurrentPage();
        if (localObject1 == null) {
          break label87;
        }
      }
      label87:
      for (localObject1 = ((u)localObject1).getCurrentUrl();; localObject1 = null)
      {
        if (TextUtils.equals((CharSequence)localObject3, (CharSequence)localObject1)) {
          break label92;
        }
        AppMethodBeat.o(209100);
        return;
        localObject1 = null;
        break;
      }
      label92:
      localObject1 = this.oUL.getRuntime();
      p.j(localObject1, "env.runtime");
      localObject1 = ((AppBrandRuntime)localObject1).bBX();
      p.j(localObject1, "env.runtime.pageContainer");
      Object localObject3 = ((x)localObject1).getCurrentPage();
      if (localObject3 != null)
      {
        i locali = i.qxX;
        localObject1 = localObject2;
        if (this.piU.aaBx) {
          localObject1 = new g(null, (List)this.piV, 1);
        }
        ((u)localObject3).a(locali, (g)localObject1);
      }
      this.oUL.j(this.otk, this.piT.agS("ok"));
      AppMethodBeat.o(209100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.y
 * JD-Core Version:    0.7.0.1
 */