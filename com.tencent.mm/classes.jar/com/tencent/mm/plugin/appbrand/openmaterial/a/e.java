package com.tencent.mm.plugin.appbrand.openmaterial.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/openmaterial/data/OpenMaterialsStorage;", "", "()V", "remove", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "materialModel", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/MaterialModel;", "save", "", "openMaterialCollection", "plugin-appbrand-integration_release"})
public final class e
{
  public static final e nlz;
  
  static
  {
    AppMethodBeat.i(229156);
    nlz = new e();
    AppMethodBeat.o(229156);
  }
  
  public static boolean b(MaterialModel paramMaterialModel, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
  {
    AppMethodBeat.i(229154);
    p.h(paramMaterialModel, "materialModel");
    p.h(paramAppBrandOpenMaterialCollection, "openMaterialCollection");
    Log.i("MicroMsg.AppBrand.OpenMaterialsStorage", "save, materialModel: ".concat(String.valueOf(paramMaterialModel)));
    paramMaterialModel = f.h(paramMaterialModel);
    if (paramMaterialModel != null)
    {
      paramMaterialModel = paramMaterialModel.toString();
      if (paramMaterialModel != null) {}
    }
    else
    {
      AppMethodBeat.o(229154);
      return false;
    }
    p.g(paramMaterialModel, "materialModel.serialize(…oString() ?: return false");
    paramAppBrandOpenMaterialCollection = f.a(paramAppBrandOpenMaterialCollection);
    if (paramAppBrandOpenMaterialCollection != null)
    {
      paramAppBrandOpenMaterialCollection = paramAppBrandOpenMaterialCollection.toString();
      if (paramAppBrandOpenMaterialCollection != null) {}
    }
    else
    {
      AppMethodBeat.o(229154);
      return false;
    }
    p.g(paramAppBrandOpenMaterialCollection, "openMaterialCollection.s…oString() ?: return false");
    MultiProcessMMKV localMultiProcessMMKV = com.tencent.mm.plugin.appbrand.app.f.kIs.VQ();
    if ((localMultiProcessMMKV == null) || (localMultiProcessMMKV.putString(paramMaterialModel, paramAppBrandOpenMaterialCollection) == null))
    {
      AppMethodBeat.o(229154);
      return false;
    }
    AppMethodBeat.o(229154);
    return true;
  }
  
  public static AppBrandOpenMaterialCollection g(MaterialModel paramMaterialModel)
  {
    AppMethodBeat.i(229155);
    p.h(paramMaterialModel, "materialModel");
    Log.i("MicroMsg.AppBrand.OpenMaterialsStorage", "remove, materialModel: ".concat(String.valueOf(paramMaterialModel)));
    Object localObject1 = f.h(paramMaterialModel);
    if (localObject1 != null)
    {
      localObject1 = ((JSONObject)localObject1).toString();
      if (localObject1 != null) {}
    }
    else
    {
      paramMaterialModel = AppBrandOpenMaterialCollection.j(paramMaterialModel);
      p.g(paramMaterialModel, "AppBrandOpenMaterialColl…tion.dummy(materialModel)");
      AppMethodBeat.o(229155);
      return paramMaterialModel;
    }
    p.g(localObject1, "materialModel.serialize(…tion.dummy(materialModel)");
    Object localObject2 = com.tencent.mm.plugin.appbrand.app.f.kIs.VQ();
    if (localObject2 != null)
    {
      localObject1 = ((MultiProcessMMKV)localObject2).getString((String)localObject1, null);
      if (localObject1 != null) {}
    }
    else
    {
      paramMaterialModel = AppBrandOpenMaterialCollection.j(paramMaterialModel);
      p.g(paramMaterialModel, "AppBrandOpenMaterialColl…tion.dummy(materialModel)");
      AppMethodBeat.o(229155);
      return paramMaterialModel;
    }
    p.g(localObject1, "AppBrandProcessSharedMMK…tion.dummy(materialModel)");
    try
    {
      localObject2 = f.at(new JSONObject((String)localObject1));
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = AppBrandOpenMaterialCollection.j(paramMaterialModel);
        p.g(localObject1, "AppBrandOpenMaterialColl…tion.dummy(materialModel)");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.OpenMaterialsStorage", "remove#OpenMaterialsStorage, fail since ".concat(String.valueOf(localException)));
        AppBrandOpenMaterialCollection localAppBrandOpenMaterialCollection = AppBrandOpenMaterialCollection.j(paramMaterialModel);
        p.g(localAppBrandOpenMaterialCollection, "AppBrandOpenMaterialColl…tion.dummy(materialModel)");
      }
    }
    AppMethodBeat.o(229155);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.a.e
 * JD-Core Version:    0.7.0.1
 */