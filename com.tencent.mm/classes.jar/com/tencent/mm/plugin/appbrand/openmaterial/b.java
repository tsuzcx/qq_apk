package com.tencent.mm.plugin.appbrand.openmaterial;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialService;", "Lcom/tencent/mm/plugin/appbrand/service/IAppBrandOpenMaterialService;", "()V", "TAG", "", "enhanceBottomSheet", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IEnhanceBottomSheetController;", "openMaterialScene", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;", "context", "Landroid/content/Context;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "openMaterialBottomSheet", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;", "launchAppBrandExecutor", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;", "fetchOpenMaterials", "", "materialModel", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/MaterialModel;", "fetchOpenMaterialsCallback", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IFetchOpenMaterialsCallback;", "fetchOpenMaterialsQuickly", "getOpenMaterialBottomSheetFactory", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet$IFactory;", "isEnabled", "", "isSupport", "mimeType", "restoreOpenMaterialCollection", "saveOpenMaterialCollection", "plugin-appbrand-integration_release"})
public final class b
  implements com.tencent.mm.plugin.appbrand.service.i
{
  public static final b nkM;
  
  static
  {
    AppMethodBeat.i(229097);
    nkM = new b();
    AppMethodBeat.o(229097);
  }
  
  public final h a(com.tencent.mm.plugin.appbrand.openmaterial.model.b paramb, Context paramContext, com.tencent.mm.ui.widget.a.e parame, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection, g paramg, j paramj)
  {
    AppMethodBeat.i(229094);
    p.h(paramb, "openMaterialScene");
    p.h(paramContext, "context");
    p.h(parame, "bottomSheet");
    p.h(paramAppBrandOpenMaterialCollection, "openMaterialCollection");
    Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialService", "enhanceBottomSheet, openMaterialCollection: ".concat(String.valueOf(paramAppBrandOpenMaterialCollection)));
    c.a locala = c.nkP;
    p.h(paramb, "openMaterialScene");
    p.h(paramContext, "context");
    p.h(parame, "bottomSheet");
    p.h(paramAppBrandOpenMaterialCollection, "openMaterialCollection");
    if (d.eg(paramContext)) {
      if (parame.hbo() == 0)
      {
        Log.i("MicroMsg.AppBrand.BottomSheetEnhanceLogic", "create, create GridBottomSheetEnhanceLogic");
        if (paramj != null) {
          break label221;
        }
        paramj = j.nlj;
        p.g(paramj, "ILaunchAppBrandExecutor.DEFAULT");
      }
    }
    label138:
    label221:
    for (;;)
    {
      paramb = (c)new e(paramb, paramContext, parame, paramAppBrandOpenMaterialCollection, paramg, paramj);
      paramb = (h)paramb;
      paramb.bQc();
      AppMethodBeat.o(229094);
      return paramb;
      Log.i("MicroMsg.AppBrand.BottomSheetEnhanceLogic", "create, create ListBottomSheetEnhanceLogic");
      if (paramj == null)
      {
        paramj = j.nlj;
        p.g(paramj, "ILaunchAppBrandExecutor.DEFAULT");
      }
      for (;;)
      {
        paramb = (c)new k(paramb, paramContext, parame, paramAppBrandOpenMaterialCollection, paramg, paramj);
        break;
        Log.i("MicroMsg.AppBrand.BottomSheetEnhanceLogic", "create, context is invalid, use dummy");
        paramb = h.nli;
        p.g(paramb, "IEnhanceBottomSheetController.DUMMY");
        break label138;
      }
    }
  }
  
  public final AppBrandOpenMaterialCollection a(MaterialModel paramMaterialModel)
  {
    AppMethodBeat.i(229092);
    p.h(paramMaterialModel, "materialModel");
    Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialService", "fetchOpenMaterialsQuickly, materialModel: ".concat(String.valueOf(paramMaterialModel)));
    com.tencent.mm.plugin.appbrand.openmaterial.a.b.a locala = com.tencent.mm.plugin.appbrand.openmaterial.a.b.nlq;
    paramMaterialModel = com.tencent.mm.plugin.appbrand.openmaterial.a.b.a.bQe().a(paramMaterialModel);
    AppMethodBeat.o(229092);
    return paramMaterialModel;
  }
  
  public final void a(MaterialModel paramMaterialModel, i parami)
  {
    AppMethodBeat.i(229091);
    p.h(paramMaterialModel, "materialModel");
    p.h(parami, "fetchOpenMaterialsCallback");
    Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialService", "fetchOpenMaterials, materialModel: ".concat(String.valueOf(paramMaterialModel)));
    com.tencent.mm.plugin.appbrand.openmaterial.a.b.a locala = com.tencent.mm.plugin.appbrand.openmaterial.a.b.nlq;
    com.tencent.mm.plugin.appbrand.openmaterial.a.b.a.bQe().a(paramMaterialModel, parami);
    AppMethodBeat.o(229091);
  }
  
  public final boolean a(MaterialModel paramMaterialModel, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
  {
    AppMethodBeat.i(229095);
    p.h(paramMaterialModel, "materialModel");
    p.h(paramAppBrandOpenMaterialCollection, "openMaterialCollection");
    com.tencent.mm.plugin.appbrand.openmaterial.a.e locale = com.tencent.mm.plugin.appbrand.openmaterial.a.e.nlz;
    boolean bool = com.tencent.mm.plugin.appbrand.openmaterial.a.e.b(paramMaterialModel, paramAppBrandOpenMaterialCollection);
    AppMethodBeat.o(229095);
    return bool;
  }
  
  public final boolean adl(String paramString)
  {
    AppMethodBeat.i(229090);
    p.h(paramString, "mimeType");
    Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialService", "isSupport, mimeType: ".concat(String.valueOf(paramString)));
    com.tencent.mm.plugin.appbrand.openmaterial.a.d locald = com.tencent.mm.plugin.appbrand.openmaterial.a.d.nly;
    boolean bool = com.tencent.mm.plugin.appbrand.openmaterial.a.d.contains(paramString);
    AppMethodBeat.o(229090);
    return bool;
  }
  
  public final AppBrandOpenMaterialCollection b(MaterialModel paramMaterialModel)
  {
    AppMethodBeat.i(229096);
    p.h(paramMaterialModel, "materialModel");
    com.tencent.mm.plugin.appbrand.openmaterial.a.e locale = com.tencent.mm.plugin.appbrand.openmaterial.a.e.nlz;
    paramMaterialModel = com.tencent.mm.plugin.appbrand.openmaterial.a.e.g(paramMaterialModel);
    AppMethodBeat.o(229096);
    return paramMaterialModel;
  }
  
  public final g.a bQa()
  {
    AppMethodBeat.i(229093);
    Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialService", "getOpenMaterialBottomSheetFactory");
    g.a locala = (g.a)a.nkB;
    AppMethodBeat.o(229093);
    return locala;
  }
  
  public final boolean c(com.tencent.mm.plugin.appbrand.openmaterial.model.b paramb)
  {
    AppMethodBeat.i(229089);
    p.h(paramb, "openMaterialScene");
    com.tencent.mm.plugin.expt.b.b localb = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class);
    if (localb != null) {}
    for (int i = localb.a(com.tencent.mm.plugin.expt.b.b.a.soE, 0);; i = 0)
    {
      Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialService", "isEnabled, enabledFlattenVals: ".concat(String.valueOf(i)));
      boolean bool = paramb.isEnabled(i);
      Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialService", "isEnabled(" + paramb + "): " + bool);
      AppMethodBeat.o(229089);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.b
 * JD-Core Version:    0.7.0.1
 */