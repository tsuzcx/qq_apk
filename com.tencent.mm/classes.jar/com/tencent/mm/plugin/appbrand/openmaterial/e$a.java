package com.tencent.mm.plugin.appbrand.openmaterial;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/openmaterial/GridBottomSheetEnhanceLogic$Companion;", "", "()V", "canEnhance", "", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "plugin-appbrand-integration_release"})
public final class e$a
{
  public static boolean b(AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
  {
    AppMethodBeat.i(283813);
    p.k(paramAppBrandOpenMaterialCollection, "openMaterialCollection");
    List localList = paramAppBrandOpenMaterialCollection.qnh;
    p.j(localList, "openMaterialCollection.appBrandOpenMaterialModels");
    if (!((Collection)localList).isEmpty())
    {
      i = 1;
      if (i == 0)
      {
        paramAppBrandOpenMaterialCollection = paramAppBrandOpenMaterialCollection.qni;
        p.j(paramAppBrandOpenMaterialCollection, "openMaterialCollection.a…dOpenMaterialDetailModels");
        if (((Collection)paramAppBrandOpenMaterialCollection).isEmpty()) {
          break label81;
        }
      }
    }
    label81:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label86;
      }
      AppMethodBeat.o(283813);
      return true;
      i = 0;
      break;
    }
    label86:
    AppMethodBeat.o(283813);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.e.a
 * JD-Core Version:    0.7.0.1
 */