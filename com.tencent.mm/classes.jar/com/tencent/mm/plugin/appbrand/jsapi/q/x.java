package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.b.g;
import com.tencent.mm.plugin.appbrand.page.b.h;
import com.tencent.mm.plugin.appbrand.page.b.i;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiSetNavigateBackConfirmDialog;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wxa-app-jsapi_release"})
public final class x
  extends c<v>
{
  public static final int CTRL_INDEX = 772;
  public static final String NAME = "setNavigateBackConfirmDialog";
  public static final a piO;
  
  static
  {
    AppMethodBeat.i(177324);
    piO = new a((byte)0);
    AppMethodBeat.o(177324);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiSetNavigateBackConfirmDialog$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-wxa-app-jsapi_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(x paramx, u paramu, v paramv, boolean paramBoolean, aa.f paramf, int paramInt) {}
    
    public final void run()
    {
      String str = null;
      AppMethodBeat.i(177322);
      Object localObject1 = this.piQ;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((u)localObject1).getCurrentUrl();
        localObject2 = (CharSequence)localObject1;
        localObject1 = this.oUL.getRuntime();
        p.j(localObject1, "env.runtime");
        localObject1 = ((AppBrandRuntime)localObject1).bBX();
        p.j(localObject1, "env.runtime.pageContainer");
        localObject1 = ((com.tencent.mm.plugin.appbrand.page.x)localObject1).getCurrentPage();
        if (localObject1 == null) {
          break label87;
        }
      }
      label87:
      for (localObject1 = ((u)localObject1).getCurrentUrl();; localObject1 = null)
      {
        if (TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1)) {
          break label92;
        }
        AppMethodBeat.o(177322);
        return;
        localObject1 = null;
        break;
      }
      label92:
      Object localObject3;
      if (this.kyu)
      {
        localObject1 = (List)new ArrayList();
        localObject2 = ((Iterable)j.listOf(new String[] { "scene_actionbar_back", "scene_back_key_pressed", "scene_jsapi_navigate_back" })).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          ((List)localObject1).add(new h(this.kyu, (String)localObject3));
        }
        localObject2 = this.oUL.getRuntime();
        p.j(localObject2, "env.runtime");
        localObject2 = ((AppBrandRuntime)localObject2).bBX();
        p.j(localObject2, "env.runtime.pageContainer");
        localObject2 = ((com.tencent.mm.plugin.appbrand.page.x)localObject2).getCurrentPage();
        if (localObject2 != null)
        {
          localObject3 = i.qxY;
          if (localObject1 == null) {
            break label292;
          }
          str = (String)this.piR.aaBC;
          p.j(str, "content");
        }
      }
      label292:
      for (localObject1 = new g(str, (List)localObject1);; localObject1 = str)
      {
        ((u)localObject2).a((i)localObject3, (g)localObject1);
        this.oUL.j(this.otk, this.piP.agS("ok"));
        AppMethodBeat.o(177322);
        return;
        localObject1 = null;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.x
 * JD-Core Version:    0.7.0.1
 */