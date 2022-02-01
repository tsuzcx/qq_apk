package com.tencent.mm.plugin.appbrand.openmaterial;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialDetailModel;
import com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.OpenMaterialWebView;
import com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.c;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/OpenMaterialWebView;", "invoke"})
final class a$c
  extends kotlin.g.b.q
  implements b<OpenMaterialWebView, x>
{
  a$c(a parama)
  {
    super(1);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialDetailModel;", "appId", "", "versionType", "", "enterPath", "invoke", "com/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$buildHybridBottomSheet$1$jsBridge$1$findOpenMaterialModel$1"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.q<String, Integer, String, AppBrandOpenMaterialDetailModel>
  {
    a(a.c paramc)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$buildHybridBottomSheet$1$jsBridge$1$1", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/ILaunchWeAppDelegate;", "launch", "", "appId", "", "versionType", "", "enterPath", "plugin-appbrand-integration_release"})
  public static final class b
    implements c
  {
    b(kotlin.g.a.q paramq, a.c paramc) {}
    
    public final void B(String paramString1, int paramInt, String paramString2)
    {
      AppMethodBeat.i(229073);
      p.h(paramString1, "appId");
      p.h(paramString2, "enterPath");
      h.RTc.aV((Runnable)new a.c.b.1(this, paramString1, paramInt, paramString2));
      AppMethodBeat.o(229073);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.a.c
 * JD-Core Version:    0.7.0.1
 */