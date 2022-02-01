package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.c.f;
import com.tencent.mm.plugin.appbrand.page.c.g;
import com.tencent.mm.plugin.appbrand.page.c.h;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import d.a.j;
import d.g.b.p;
import d.g.b.y.f;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiSetNavigateBackConfirmDialog;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wxa-app-jsapi_release"})
public final class t
  extends a<q>
{
  public static final int CTRL_INDEX = 772;
  public static final String NAME = "setNavigateBackConfirmDialog";
  public static final a lbA;
  
  static
  {
    AppMethodBeat.i(177324);
    lbA = new a((byte)0);
    AppMethodBeat.o(177324);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiSetNavigateBackConfirmDialog$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-wxa-app-jsapi_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(t paramt, r paramr, q paramq, boolean paramBoolean, y.f paramf, int paramInt) {}
    
    public final void run()
    {
      String str = null;
      AppMethodBeat.i(177322);
      Object localObject1 = this.lbC;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((r)localObject1).getCurrentUrl();
        localObject2 = (CharSequence)localObject1;
        localObject1 = this.lbD.getRuntime();
        p.g(localObject1, "env.runtime");
        localObject1 = ((AppBrandRuntime)localObject1).aVN();
        p.g(localObject1, "env.runtime.pageContainer");
        localObject1 = ((u)localObject1).getCurrentPage();
        if (localObject1 == null) {
          break label87;
        }
      }
      label87:
      for (localObject1 = ((r)localObject1).getCurrentUrl();; localObject1 = null)
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
      if (this.gQY)
      {
        localObject1 = (List)new ArrayList();
        localObject2 = ((Iterable)j.listOf(new String[] { "scene_actionbar_back", "scene_back_key_pressed", "scene_jsapi_navigate_back" })).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          ((List)localObject1).add(new g(this.gQY, (String)localObject3));
        }
        localObject2 = this.lbD.getRuntime();
        p.g(localObject2, "env.runtime");
        localObject2 = ((AppBrandRuntime)localObject2).aVN();
        p.g(localObject2, "env.runtime.pageContainer");
        localObject2 = ((u)localObject2).getCurrentPage();
        if (localObject2 != null)
        {
          localObject3 = h.mgz;
          if (localObject1 == null) {
            break label292;
          }
          str = (String)this.lbE.MLV;
          p.g(str, "content");
        }
      }
      label292:
      for (localObject1 = new f(str, (List)localObject1);; localObject1 = str)
      {
        ((r)localObject2).a((h)localObject3, (f)localObject1);
        this.lbD.h(this.krv, this.lbB.Pg("ok"));
        AppMethodBeat.o(177322);
        return;
        localObject1 = null;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.t
 * JD-Core Version:    0.7.0.1
 */