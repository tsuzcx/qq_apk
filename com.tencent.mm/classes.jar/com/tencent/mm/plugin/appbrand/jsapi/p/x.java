package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.b.g;
import com.tencent.mm.plugin.appbrand.page.b.h;
import com.tencent.mm.plugin.appbrand.page.b.i;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiSetNavigateBackConfirmDialog;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wxa-app-jsapi_release"})
public final class x
  extends d<s>
{
  public static final int CTRL_INDEX = 772;
  public static final String NAME = "setNavigateBackConfirmDialog";
  public static final a mkJ;
  
  static
  {
    AppMethodBeat.i(177324);
    mkJ = new a((byte)0);
    AppMethodBeat.o(177324);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiSetNavigateBackConfirmDialog$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-wxa-app-jsapi_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(x paramx, t paramt, s params, boolean paramBoolean, z.f paramf, int paramInt) {}
    
    public final void run()
    {
      String str = null;
      AppMethodBeat.i(177322);
      Object localObject1 = this.mkL;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((t)localObject1).getCurrentUrl();
        localObject2 = (CharSequence)localObject1;
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
      if (this.hLa)
      {
        localObject1 = (List)new ArrayList();
        localObject2 = ((Iterable)j.listOf(new String[] { "scene_actionbar_back", "scene_back_key_pressed", "scene_jsapi_navigate_back" })).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          ((List)localObject1).add(new h(this.hLa, (String)localObject3));
        }
        localObject2 = this.lXa.getRuntime();
        p.g(localObject2, "env.runtime");
        localObject2 = ((AppBrandRuntime)localObject2).brh();
        p.g(localObject2, "env.runtime.pageContainer");
        localObject2 = ((w)localObject2).getCurrentPage();
        if (localObject2 != null)
        {
          localObject3 = i.nvW;
          if (localObject1 == null) {
            break label292;
          }
          str = (String)this.mkM.SYG;
          p.g(str, "content");
        }
      }
      label292:
      for (localObject1 = new g(str, (List)localObject1);; localObject1 = str)
      {
        ((t)localObject2).a((i)localObject3, (g)localObject1);
        this.lXa.i(this.lyo, this.mkK.Zf("ok"));
        AppMethodBeat.o(177322);
        return;
        localObject1 = null;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.x
 * JD-Core Version:    0.7.0.1
 */