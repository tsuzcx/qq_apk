package com.tencent.mm.plugin.appbrand.openmaterial;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.openmaterial.a.b.a;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.f;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialService;", "Lcom/tencent/mm/plugin/appbrand/service/IAppBrandOpenMaterialService;", "()V", "TAG", "", "enhanceBottomSheet", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IEnhanceBottomSheetController;", "openMaterialScene", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;", "context", "Landroid/content/Context;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "openMaterialBottomSheet", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;", "launchAppBrandExecutor", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;", "fetchOpenMaterials", "", "materialModel", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/MaterialModel;", "fetchOpenMaterialsCallback", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IFetchOpenMaterialsCallback;", "fetchOpenMaterialsQuickly", "getOpenMaterialBottomSheetFactory", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet$IFactory;", "isEnabled", "", "isSupport", "mimeType", "markEnhancedBottomSheetShown", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialReporter;", "needEnhance", "restoreOpenMaterialCollection", "restoreOpenMaterialReporter", "remove", "saveOpenMaterialCollection", "saveOpenMaterialReporter", "openMaterialReporter", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements com.tencent.mm.plugin.appbrand.service.j
{
  public static final b tre;
  
  static
  {
    AppMethodBeat.i(323558);
    tre = new b();
    AppMethodBeat.o(323558);
  }
  
  public final h a(com.tencent.mm.plugin.appbrand.openmaterial.model.b paramb, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
  {
    AppMethodBeat.i(323634);
    s.u(paramb, "openMaterialScene");
    s.u(paramAppBrandOpenMaterialCollection, "openMaterialCollection");
    Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialService", s.X("markEnhancedBottomSheetShown, openMaterialScene: ", paramb));
    paramb = (h)com.tencent.mm.plugin.appbrand.openmaterial.b.b.b(paramb, paramAppBrandOpenMaterialCollection);
    AppMethodBeat.o(323634);
    return paramb;
  }
  
  public final h a(com.tencent.mm.plugin.appbrand.openmaterial.model.b paramb, MaterialModel paramMaterialModel, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection, boolean paramBoolean)
  {
    AppMethodBeat.i(323663);
    s.u(paramb, "openMaterialScene");
    s.u(paramMaterialModel, "materialModel");
    s.u(paramAppBrandOpenMaterialCollection, "openMaterialCollection");
    com.tencent.mm.plugin.appbrand.openmaterial.a.c localc;
    if (paramBoolean)
    {
      localc = com.tencent.mm.plugin.appbrand.openmaterial.a.c.trI;
      s.u(paramMaterialModel, "materialModel");
    }
    for (paramMaterialModel = com.tencent.mm.plugin.appbrand.openmaterial.a.c.a(paramMaterialModel, true); paramMaterialModel == null; paramMaterialModel = com.tencent.mm.plugin.appbrand.openmaterial.a.c.a(paramMaterialModel, false))
    {
      paramb = (h)new com.tencent.mm.plugin.appbrand.openmaterial.b.a(paramb, paramAppBrandOpenMaterialCollection);
      AppMethodBeat.o(323663);
      return paramb;
      localc = com.tencent.mm.plugin.appbrand.openmaterial.a.c.trI;
      s.u(paramMaterialModel, "materialModel");
    }
    paramb = (h)new com.tencent.mm.plugin.appbrand.openmaterial.b.a(paramb, paramAppBrandOpenMaterialCollection, paramMaterialModel);
    AppMethodBeat.o(323663);
    return paramb;
  }
  
  public final i a(com.tencent.mm.plugin.appbrand.openmaterial.model.b paramb, Context paramContext, f paramf, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection, g paramg, k paramk)
  {
    AppMethodBeat.i(323623);
    s.u(paramb, "openMaterialScene");
    s.u(paramContext, "context");
    s.u(paramf, "bottomSheet");
    s.u(paramAppBrandOpenMaterialCollection, "openMaterialCollection");
    Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialService", s.X("enhanceBottomSheet, openMaterialCollection: ", paramAppBrandOpenMaterialCollection));
    Object localObject = c.trf;
    s.u(paramb, "openMaterialScene");
    s.u(paramContext, "context");
    s.u(paramf, "bottomSheet");
    s.u(paramAppBrandOpenMaterialCollection, "openMaterialCollection");
    if (d.eZ(paramContext)) {
      if (paramf.bottomSheetStyle == 0)
      {
        localObject = e.tri;
        if (e.a.b(paramAppBrandOpenMaterialCollection))
        {
          Log.i("MicroMsg.AppBrand.BottomSheetEnhanceLogic", "create, create GridBottomSheetEnhanceLogic");
          if (paramk == null)
          {
            paramk = k.trz;
            s.s(paramk, "launchAppBrandExecutor ?…hAppBrandExecutor.DEFAULT");
            paramb = (i)new e(paramb, paramContext, paramf, paramAppBrandOpenMaterialCollection, paramg, paramk);
            label143:
            s.s(paramb, "{\n                if (BO…          }\n            }");
          }
        }
      }
    }
    for (;;)
    {
      paramb.a(i.a.trv);
      AppMethodBeat.o(323623);
      return paramb;
      break;
      Log.i("MicroMsg.AppBrand.BottomSheetEnhanceLogic", "create, can not enhance, use dummy");
      paramb = i.tru;
      break label143;
      localObject = l.trA;
      if (l.a.b(paramAppBrandOpenMaterialCollection))
      {
        Log.i("MicroMsg.AppBrand.BottomSheetEnhanceLogic", "create, create ListBottomSheetEnhanceLogic");
        if (paramk == null) {
          paramk = k.trz;
        }
        for (;;)
        {
          s.s(paramk, "launchAppBrandExecutor ?…hAppBrandExecutor.DEFAULT");
          paramb = (i)new l(paramb, paramContext, paramf, paramAppBrandOpenMaterialCollection, paramg, paramk);
          break;
        }
      }
      Log.i("MicroMsg.AppBrand.BottomSheetEnhanceLogic", "create, can not enhance, use dummy");
      paramb = i.tru;
      break label143;
      Log.i("MicroMsg.AppBrand.BottomSheetEnhanceLogic", "create, context is invalid, use dummy");
      paramb = i.tru;
      s.s(paramb, "{\n                Log.i(…oller.DUMMY\n            }");
    }
  }
  
  public final AppBrandOpenMaterialCollection a(MaterialModel paramMaterialModel)
  {
    AppMethodBeat.i(323588);
    s.u(paramMaterialModel, "materialModel");
    Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialService", s.X("fetchOpenMaterialsQuickly, materialModel: ", paramMaterialModel));
    b.a locala = com.tencent.mm.plugin.appbrand.openmaterial.a.b.trG;
    paramMaterialModel = b.a.cDt().a(paramMaterialModel);
    AppMethodBeat.o(323588);
    return paramMaterialModel;
  }
  
  public final void a(MaterialModel paramMaterialModel, j paramj)
  {
    AppMethodBeat.i(323580);
    s.u(paramMaterialModel, "materialModel");
    s.u(paramj, "fetchOpenMaterialsCallback");
    Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialService", s.X("fetchOpenMaterials, materialModel: ", paramMaterialModel));
    b.a locala = com.tencent.mm.plugin.appbrand.openmaterial.a.b.trG;
    b.a.cDt().a(paramMaterialModel, paramj);
    AppMethodBeat.o(323580);
  }
  
  public final boolean a(MaterialModel paramMaterialModel, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
  {
    AppMethodBeat.i(323642);
    s.u(paramMaterialModel, "materialModel");
    s.u(paramAppBrandOpenMaterialCollection, "openMaterialCollection");
    com.tencent.mm.plugin.appbrand.openmaterial.a.c localc = com.tencent.mm.plugin.appbrand.openmaterial.a.c.trI;
    boolean bool = com.tencent.mm.plugin.appbrand.openmaterial.a.c.b(paramMaterialModel, paramAppBrandOpenMaterialCollection);
    AppMethodBeat.o(323642);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.openmaterial.model.b paramb, MaterialModel paramMaterialModel, h paramh)
  {
    AppMethodBeat.i(323655);
    s.u(paramb, "openMaterialScene");
    s.u(paramMaterialModel, "materialModel");
    s.u(paramh, "openMaterialReporter");
    paramb = com.tencent.mm.plugin.appbrand.openmaterial.a.c.trI;
    paramb = paramh.getSessionId();
    s.s(paramb, "openMaterialReporter.sessionId");
    boolean bool = com.tencent.mm.plugin.appbrand.openmaterial.a.c.a(paramMaterialModel, paramb);
    AppMethodBeat.o(323655);
    return bool;
  }
  
  public final boolean a(f paramf, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
  {
    AppMethodBeat.i(323608);
    s.u(paramf, "bottomSheet");
    s.u(paramAppBrandOpenMaterialCollection, "openMaterialCollection");
    c.a locala = c.trf;
    s.u(paramf, "bottomSheet");
    s.u(paramAppBrandOpenMaterialCollection, "openMaterialCollection");
    if (paramf.bottomSheetStyle == 0) {
      paramf = e.tri;
    }
    for (boolean bool = e.a.b(paramAppBrandOpenMaterialCollection);; bool = l.a.b(paramAppBrandOpenMaterialCollection))
    {
      Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialService", s.X("needEnhance, needEnhance: ", Boolean.valueOf(bool)));
      AppMethodBeat.o(323608);
      return bool;
      paramf = l.trA;
    }
  }
  
  public final boolean aen(String paramString)
  {
    AppMethodBeat.i(323571);
    s.u(paramString, "mimeType");
    Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialService", s.X("isSupport, mimeType: ", paramString));
    AppMethodBeat.o(323571);
    return true;
  }
  
  public final AppBrandOpenMaterialCollection b(MaterialModel paramMaterialModel)
  {
    AppMethodBeat.i(323648);
    s.u(paramMaterialModel, "materialModel");
    Object localObject = com.tencent.mm.plugin.appbrand.openmaterial.a.c.trI;
    s.u(paramMaterialModel, "materialModel");
    Log.i("MicroMsg.AppBrand.OpenMaterialsTempStorage", "getCollectionInner, materialModel: " + paramMaterialModel + ", remove: false");
    localObject = com.tencent.mm.plugin.appbrand.openmaterial.a.d.f(paramMaterialModel);
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((JSONObject)localObject).toString())
    {
      paramMaterialModel = AppBrandOpenMaterialCollection.h(paramMaterialModel);
      s.s(paramMaterialModel, "dummy(materialModel)");
      AppMethodBeat.o(323648);
      return paramMaterialModel;
    }
    localObject = com.tencent.mm.plugin.appbrand.openmaterial.a.c.aeo((String)localObject);
    if (localObject == null)
    {
      paramMaterialModel = AppBrandOpenMaterialCollection.h(paramMaterialModel);
      s.s(paramMaterialModel, "dummy(materialModel)");
      AppMethodBeat.o(323648);
      return paramMaterialModel;
    }
    AppMethodBeat.o(323648);
    return localObject;
  }
  
  public final boolean c(com.tencent.mm.plugin.appbrand.openmaterial.model.b paramb)
  {
    AppMethodBeat.i(323566);
    s.u(paramb, "openMaterialScene");
    Object localObject = com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_appbrand_open_material2", "7", false, true);
    s.s(localObject, "getInstance().getMulitEx…             false, true)");
    localObject = n.bJF((String)localObject);
    int i;
    if (localObject == null)
    {
      i = 7;
      Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialService", s.X("isEnabled, enabledFlattenVals: ", Integer.valueOf(i)));
      if ((i & paramb.tsb) == 0) {
        break label126;
      }
    }
    label126:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialService", "isEnabled(" + paramb + "): " + bool);
      AppMethodBeat.o(323566);
      return bool;
      i = ((Integer)localObject).intValue();
      break;
    }
  }
  
  public final g.a cDh()
  {
    AppMethodBeat.i(323597);
    Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialService", "getOpenMaterialBottomSheetFactory");
    g.a locala = (g.a)a.tqT;
    AppMethodBeat.o(323597);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.b
 * JD-Core Version:    0.7.0.1
 */