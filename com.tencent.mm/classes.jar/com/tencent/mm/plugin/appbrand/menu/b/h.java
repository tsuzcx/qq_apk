package com.tencent.mm.plugin.appbrand.menu.b;

import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.luggage.sdk.b.a.d.d;
import com.tencent.luggage.sdk.b.a.d.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni;
import com.tencent.mm.plugin.appbrand.menu.a.b;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.service.c;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/menu/devtools/SecondaryMenuDelegate_GameForceGc;", "Lcom/tencent/mm/plugin/appbrand/menu/base/BaseSecondaryMenuDelegate;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "()V", "getTitle", "", "context", "Landroid/content/Context;", "pageView", "appId", "performItemClick", "", "shouldShow", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements b<ah>
{
  public static final h tlt;
  
  static
  {
    AppMethodBeat.i(50889);
    tlt = new h();
    AppMethodBeat.o(50889);
  }
  
  private static final void f(c paramc)
  {
    AppMethodBeat.i(323902);
    paramc.esM.arN().esf.requestV8GarbageCollectionForTest();
    AppMethodBeat.o(323902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.b.h
 * JD-Core Version:    0.7.0.1
 */