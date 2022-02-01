package com.tencent.mm.plugin.appbrand.openmaterial;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.nz;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialDetailModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$buildHybridBottomSheet$1$jsBridge$1$2", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/IWeAppExposureDelegate;", "onWeAppExposure", "", "appId", "", "versionType", "", "enterPath", "plugin-appbrand-integration_release"})
public final class a$c$c
  implements d
{
  a$c$c(q paramq, a.c paramc) {}
  
  public final void C(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(229074);
    p.h(paramString1, "appId");
    p.h(paramString2, "enterPath");
    paramString1 = (AppBrandOpenMaterialDetailModel)this.nkE.d(paramString1, Integer.valueOf(paramInt), paramString2);
    if (paramString1 == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "onWeAppExposure#buildHybridBottomSheet, openMaterialModel is null");
      AppMethodBeat.o(229074);
      return;
    }
    com.tencent.mm.plugin.appbrand.openmaterial.b.a locala = a.d(this.nkD.nkC);
    AppBrandOpenMaterialModel localAppBrandOpenMaterialModel = (AppBrandOpenMaterialModel)paramString1;
    p.h(localAppBrandOpenMaterialModel, "openMaterialModel");
    Log.i(locala.bQh(), "onListPageAppBrandExposure");
    if (!locala.nma.contains(localAppBrandOpenMaterialModel))
    {
      nz localnz = locala.bQj().yv(2L).Bi(localAppBrandOpenMaterialModel.appId);
      paramString2 = localAppBrandOpenMaterialModel.appName;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      localnz.Bj(paramString1).bfK();
      locala.nma.add(localAppBrandOpenMaterialModel);
    }
    AppMethodBeat.o(229074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.a.c.c
 * JD-Core Version:    0.7.0.1
 */