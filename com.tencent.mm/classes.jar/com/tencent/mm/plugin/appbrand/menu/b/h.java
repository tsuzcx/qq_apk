package com.tencent.mm.plugin.appbrand.menu.b;

import com.tencent.luggage.sdk.b.a.c.a;
import com.tencent.luggage.sdk.b.a.c.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni;
import com.tencent.mm.plugin.appbrand.menu.a.b;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.service.c;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/menu/devtools/SecondaryMenuDelegate_GameForceGc;", "Lcom/tencent/mm/plugin/appbrand/menu/base/BaseSecondaryMenuDelegate;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "()V", "getTitle", "", "context", "Landroid/content/Context;", "pageView", "appId", "performItemClick", "", "shouldShow", "", "plugin-appbrand-integration_release"})
public final class h
  implements b<ag>
{
  public static final h nfX;
  
  static
  {
    AppMethodBeat.i(50889);
    nfX = new h();
    AppMethodBeat.o(50889);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(229051);
      Object localObject = this.mpU;
      p.g(localObject, "service");
      localObject = ((c)localObject).Ol();
      p.g(localObject, "service.delegate");
      ((f)localObject).Oz().Oh().requestV8GarbageCollectionForTest();
      AppMethodBeat.o(229051);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.b.h
 * JD-Core Version:    0.7.0.1
 */