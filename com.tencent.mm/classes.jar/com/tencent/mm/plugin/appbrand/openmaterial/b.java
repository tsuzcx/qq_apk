package com.tencent.mm.plugin.appbrand.openmaterial;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.openmaterial.a.b.a;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.n.n;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialService;", "Lcom/tencent/mm/plugin/appbrand/service/IAppBrandOpenMaterialService;", "()V", "TAG", "", "enhanceBottomSheet", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IEnhanceBottomSheetController;", "openMaterialScene", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;", "context", "Landroid/content/Context;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "openMaterialBottomSheet", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;", "launchAppBrandExecutor", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;", "fetchOpenMaterials", "", "materialModel", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/MaterialModel;", "fetchOpenMaterialsCallback", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IFetchOpenMaterialsCallback;", "fetchOpenMaterialsQuickly", "getOpenMaterialBottomSheetFactory", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet$IFactory;", "isEnabled", "", "isSupport", "mimeType", "markEnhancedBottomSheetShown", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialReporter;", "needEnhance", "restoreOpenMaterialCollection", "restoreOpenMaterialReporter", "remove", "saveOpenMaterialCollection", "saveOpenMaterialReporter", "openMaterialReporter", "plugin-appbrand-integration_release"})
public final class b
  implements com.tencent.mm.plugin.appbrand.service.i
{
  public static final b qmk;
  
  static
  {
    AppMethodBeat.i(278867);
    qmk = new b();
    AppMethodBeat.o(278867);
  }
  
  public final i a(com.tencent.mm.plugin.appbrand.openmaterial.model.b paramb, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
  {
    AppMethodBeat.i(278860);
    p.k(paramb, "openMaterialScene");
    p.k(paramAppBrandOpenMaterialCollection, "openMaterialCollection");
    Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialService", "markEnhancedBottomSheetShown, openMaterialScene: ".concat(String.valueOf(paramb)));
    paramb = (i)com.tencent.mm.plugin.appbrand.openmaterial.b.c.b(paramb, paramAppBrandOpenMaterialCollection);
    AppMethodBeat.o(278860);
    return paramb;
  }
  
  public final i a(com.tencent.mm.plugin.appbrand.openmaterial.model.b paramb, MaterialModel paramMaterialModel, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
  {
    AppMethodBeat.i(278865);
    p.k(paramb, "openMaterialScene");
    p.k(paramMaterialModel, "materialModel");
    p.k(paramAppBrandOpenMaterialCollection, "openMaterialCollection");
    com.tencent.mm.plugin.appbrand.openmaterial.a.c localc = com.tencent.mm.plugin.appbrand.openmaterial.a.c.qnc;
    p.k(paramMaterialModel, "materialModel");
    paramMaterialModel = com.tencent.mm.plugin.appbrand.openmaterial.a.c.g(paramMaterialModel);
    if (paramMaterialModel == null)
    {
      paramb = (i)new com.tencent.mm.plugin.appbrand.openmaterial.b.a(paramb, paramAppBrandOpenMaterialCollection);
      AppMethodBeat.o(278865);
      return paramb;
    }
    paramb = (i)new com.tencent.mm.plugin.appbrand.openmaterial.b.a(paramb, paramAppBrandOpenMaterialCollection, paramMaterialModel);
    AppMethodBeat.o(278865);
    return paramb;
  }
  
  public final j a(com.tencent.mm.plugin.appbrand.openmaterial.model.b paramb, Context paramContext, com.tencent.mm.ui.widget.a.e parame, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection, h paramh, l paraml)
  {
    AppMethodBeat.i(278858);
    p.k(paramb, "openMaterialScene");
    p.k(paramContext, "context");
    p.k(parame, "bottomSheet");
    p.k(paramAppBrandOpenMaterialCollection, "openMaterialCollection");
    Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialService", "enhanceBottomSheet, openMaterialCollection: ".concat(String.valueOf(paramAppBrandOpenMaterialCollection)));
    Object localObject = c.qmn;
    p.k(paramb, "openMaterialScene");
    p.k(paramContext, "context");
    p.k(parame, "bottomSheet");
    p.k(paramAppBrandOpenMaterialCollection, "openMaterialCollection");
    if (d.ef(paramContext)) {
      if (parame.icv() == 0)
      {
        localObject = e.qmr;
        if (e.a.b(paramAppBrandOpenMaterialCollection))
        {
          Log.i("MicroMsg.AppBrand.BottomSheetEnhanceLogic", "create, create GridBottomSheetEnhanceLogic");
          if (paraml != null) {
            break label279;
          }
          paraml = l.qmQ;
          p.j(paraml, "ILaunchAppBrandExecutor.DEFAULT");
        }
      }
    }
    label276:
    label279:
    for (;;)
    {
      for (paramb = (j)new e(paramb, paramContext, parame, paramAppBrandOpenMaterialCollection, paramh, paraml);; paramb = j.qmL)
      {
        p.j(paramb, "if (BOTTOM_SHEET_STYLE_G…      }\n                }");
        label152:
        paramb.a(j.a.qmM);
        AppMethodBeat.o(278858);
        return paramb;
        Log.i("MicroMsg.AppBrand.BottomSheetEnhanceLogic", "create, can not enhance, use dummy");
      }
      localObject = m.qmR;
      if (m.a.b(paramAppBrandOpenMaterialCollection))
      {
        Log.i("MicroMsg.AppBrand.BottomSheetEnhanceLogic", "create, create ListBottomSheetEnhanceLogic");
        if (paraml != null) {
          break label276;
        }
        paraml = l.qmQ;
        p.j(paraml, "ILaunchAppBrandExecutor.DEFAULT");
      }
      for (;;)
      {
        paramb = (j)new m(paramb, paramContext, parame, paramAppBrandOpenMaterialCollection, paramh, paraml);
        break;
        Log.i("MicroMsg.AppBrand.BottomSheetEnhanceLogic", "create, can not enhance, use dummy");
        paramb = j.qmL;
        break;
        Log.i("MicroMsg.AppBrand.BottomSheetEnhanceLogic", "create, context is invalid, use dummy");
        paramb = j.qmL;
        p.j(paramb, "IEnhanceBottomSheetController.DUMMY");
        break label152;
      }
    }
  }
  
  public final AppBrandOpenMaterialCollection a(MaterialModel paramMaterialModel)
  {
    AppMethodBeat.i(278852);
    p.k(paramMaterialModel, "materialModel");
    Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialService", "fetchOpenMaterialsQuickly, materialModel: ".concat(String.valueOf(paramMaterialModel)));
    b.a locala = com.tencent.mm.plugin.appbrand.openmaterial.a.b.qna;
    paramMaterialModel = b.a.ccV().a(paramMaterialModel);
    AppMethodBeat.o(278852);
    return paramMaterialModel;
  }
  
  public final void a(MaterialModel paramMaterialModel, k paramk)
  {
    AppMethodBeat.i(278850);
    p.k(paramMaterialModel, "materialModel");
    p.k(paramk, "fetchOpenMaterialsCallback");
    Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialService", "fetchOpenMaterials, materialModel: ".concat(String.valueOf(paramMaterialModel)));
    b.a locala = com.tencent.mm.plugin.appbrand.openmaterial.a.b.qna;
    b.a.ccV().a(paramMaterialModel, paramk);
    AppMethodBeat.o(278850);
  }
  
  public final boolean a(MaterialModel paramMaterialModel, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
  {
    AppMethodBeat.i(278861);
    p.k(paramMaterialModel, "materialModel");
    p.k(paramAppBrandOpenMaterialCollection, "openMaterialCollection");
    com.tencent.mm.plugin.appbrand.openmaterial.a.c localc = com.tencent.mm.plugin.appbrand.openmaterial.a.c.qnc;
    boolean bool = com.tencent.mm.plugin.appbrand.openmaterial.a.c.b(paramMaterialModel, paramAppBrandOpenMaterialCollection);
    AppMethodBeat.o(278861);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.openmaterial.model.b paramb, MaterialModel paramMaterialModel, i parami)
  {
    AppMethodBeat.i(278864);
    p.k(paramb, "openMaterialScene");
    p.k(paramMaterialModel, "materialModel");
    p.k(parami, "openMaterialReporter");
    paramb = com.tencent.mm.plugin.appbrand.openmaterial.a.c.qnc;
    paramb = parami.getSessionId();
    p.j(paramb, "openMaterialReporter.sessionId");
    boolean bool = com.tencent.mm.plugin.appbrand.openmaterial.a.c.a(paramMaterialModel, paramb);
    AppMethodBeat.o(278864);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.ui.widget.a.e parame, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
  {
    AppMethodBeat.i(278855);
    p.k(parame, "bottomSheet");
    p.k(paramAppBrandOpenMaterialCollection, "openMaterialCollection");
    c.a locala = c.qmn;
    p.k(parame, "bottomSheet");
    p.k(paramAppBrandOpenMaterialCollection, "openMaterialCollection");
    if (parame.icv() == 0) {
      parame = e.qmr;
    }
    for (boolean bool = e.a.b(paramAppBrandOpenMaterialCollection);; bool = m.a.b(paramAppBrandOpenMaterialCollection))
    {
      Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialService", "needEnhance, needEnhance: ".concat(String.valueOf(bool)));
      AppMethodBeat.o(278855);
      return bool;
      parame = m.qmR;
    }
  }
  
  public final boolean alg(String paramString)
  {
    AppMethodBeat.i(278847);
    p.k(paramString, "mimeType");
    Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialService", "isSupport, mimeType: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(278847);
    return true;
  }
  
  public final AppBrandOpenMaterialCollection b(MaterialModel paramMaterialModel)
  {
    AppMethodBeat.i(278863);
    p.k(paramMaterialModel, "materialModel");
    Object localObject = com.tencent.mm.plugin.appbrand.openmaterial.a.c.qnc;
    p.k(paramMaterialModel, "materialModel");
    Log.i("MicroMsg.AppBrand.OpenMaterialsTempStorage", "getCollectionInner, materialModel: " + paramMaterialModel + ", remove: false");
    localObject = com.tencent.mm.plugin.appbrand.openmaterial.a.d.h(paramMaterialModel);
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).toString();
      if (localObject != null) {}
    }
    else
    {
      paramMaterialModel = AppBrandOpenMaterialCollection.j(paramMaterialModel);
      p.j(paramMaterialModel, "AppBrandOpenMaterialColl…tion.dummy(materialModel)");
      AppMethodBeat.o(278863);
      return paramMaterialModel;
    }
    p.j(localObject, "materialModel.serialize(…tion.dummy(materialModel)");
    AppBrandOpenMaterialCollection localAppBrandOpenMaterialCollection = com.tencent.mm.plugin.appbrand.openmaterial.a.c.alh((String)localObject);
    localObject = localAppBrandOpenMaterialCollection;
    if (localAppBrandOpenMaterialCollection == null)
    {
      localObject = AppBrandOpenMaterialCollection.j(paramMaterialModel);
      p.j(localObject, "AppBrandOpenMaterialColl…tion.dummy(materialModel)");
    }
    AppMethodBeat.o(278863);
    return localObject;
  }
  
  public final boolean c(com.tencent.mm.plugin.appbrand.openmaterial.model.b paramb)
  {
    int i = 0;
    AppMethodBeat.i(278845);
    p.k(paramb, "openMaterialScene");
    Object localObject = com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_appbrand_open_material2", "0", false, true);
    p.j(localObject, "ExptManager.getInstance(…             false, true)");
    localObject = n.bHC((String)localObject);
    if (localObject != null) {
      i = ((Integer)localObject).intValue();
    }
    Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialService", "isEnabled, enabledFlattenVals: ".concat(String.valueOf(i)));
    boolean bool = paramb.isEnabled(i);
    Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialService", "isEnabled(" + paramb + "): " + bool);
    AppMethodBeat.o(278845);
    return bool;
  }
  
  public final h.a ccL()
  {
    AppMethodBeat.i(278853);
    Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialService", "getOpenMaterialBottomSheetFactory");
    h.a locala = (h.a)a.qlZ;
    AppMethodBeat.o(278853);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.b
 * JD-Core Version:    0.7.0.1
 */