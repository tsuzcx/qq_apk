package com.tencent.mm.plugin.appbrand.openmaterial;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ny;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialDetailModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialModel;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$buildHybridBottomSheet$1$jsBridge$1$1$launch$1"})
final class a$c$b$1
  implements Runnable
{
  a$c$b$1(a.c.b paramb, String paramString1, int paramInt, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(229072);
    Object localObject1 = a.c(this.nkF.nkD.nkC);
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.appbrand.openmaterial.ui.a)localObject1).hide();
    }
    Object localObject2 = (AppBrandOpenMaterialDetailModel)this.nkF.nkE.d(this.kPQ, Integer.valueOf(this.kQh), this.mXY);
    if (localObject2 == null) {
      Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "launch#buildHybridBottomSheet, openMaterialModel is null");
    }
    for (;;)
    {
      a.a(this.nkF.nkD.nkC, this.kPQ, this.kQh, this.mXY);
      AppMethodBeat.o(229072);
      return;
      localObject1 = a.d(this.nkF.nkD.nkC);
      localObject2 = (AppBrandOpenMaterialModel)localObject2;
      p.h(localObject2, "openMaterialModel");
      Log.i(((com.tencent.mm.plugin.appbrand.openmaterial.b.a)localObject1).bQh(), "onListPageAppBrandClick");
      Object localObject3 = ((com.tencent.mm.plugin.appbrand.openmaterial.b.a)localObject1).nkx.nlF;
      p.g(localObject3, "openMaterialCollection.a…dOpenMaterialDetailModels");
      long l = j.a((List)localObject3, localObject2) + 1;
      Log.d(((com.tencent.mm.plugin.appbrand.openmaterial.b.a)localObject1).bQh(), "onListPageAppBrandClick, index: ".concat(String.valueOf(l)));
      localObject3 = ((ny)((com.tencent.mm.plugin.appbrand.openmaterial.b.a)localObject1).nlV.getValue()).yt(((Number)((com.tencent.mm.plugin.appbrand.openmaterial.b.a)localObject1).nlY.getValue()).longValue()).yu(l).Bf(((AppBrandOpenMaterialModel)localObject2).appId);
      localObject2 = ((AppBrandOpenMaterialModel)localObject2).appName;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((ny)localObject3).Bg((String)localObject1).bfK();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.a.c.b.1
 * JD-Core Version:    0.7.0.1
 */