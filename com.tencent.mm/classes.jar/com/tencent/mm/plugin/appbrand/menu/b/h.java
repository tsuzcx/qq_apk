package com.tencent.mm.plugin.appbrand.menu.b;

import com.tencent.luggage.sdk.b.a.c.a;
import com.tencent.luggage.sdk.b.a.c.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni;
import com.tencent.mm.plugin.appbrand.menu.a.b;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.service.c;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/menu/devtools/SecondaryMenuDelegate_GameForceGc;", "Lcom/tencent/mm/plugin/appbrand/menu/base/BaseSecondaryMenuDelegate;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "()V", "getTitle", "", "context", "Landroid/content/Context;", "pageView", "appId", "performItemClick", "", "shouldShow", "", "plugin-appbrand-integration_release"})
public final class h
  implements b<ah>
{
  public static final h qgH;
  
  static
  {
    AppMethodBeat.i(50889);
    qgH = new h();
    AppMethodBeat.o(50889);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(265699);
      Object localObject = this.poa;
      p.j(localObject, "service");
      localObject = ((c)localObject).Ri();
      p.j(localObject, "service.delegate");
      ((f)localObject).Rz().Rf().requestV8GarbageCollectionForTest();
      AppMethodBeat.o(265699);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.b.h
 * JD-Core Version:    0.7.0.1
 */