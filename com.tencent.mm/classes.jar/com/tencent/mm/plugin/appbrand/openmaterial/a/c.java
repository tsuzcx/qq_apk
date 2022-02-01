package com.tencent.mm.plugin.appbrand.openmaterial.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/openmaterial/data/OpenMaterialsTempStorage;", "", "()V", "LAST_SAVE_COLLECTION_KEY", "", "LAST_SAVE_SESSION_ID_KEY", "SESSION_ID_SUFFIX", "getCollectionInner", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "materialModel", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/MaterialModel;", "remove", "", "materialModelStr", "getSessionIdInner", "readCollection", "readSessionId", "removeSessionId", "saveCollection", "openMaterialCollection", "saveSessionId", "sessionId", "getAndRemove", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "key", "defVal", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c trI;
  
  static
  {
    AppMethodBeat.i(323709);
    trI = new c();
    AppMethodBeat.o(323709);
  }
  
  public static String a(MaterialModel paramMaterialModel, boolean paramBoolean)
  {
    AppMethodBeat.i(323703);
    Log.i("MicroMsg.AppBrand.OpenMaterialsTempStorage", "getSessionIdInner, materialModel: " + paramMaterialModel + ", remove: " + paramBoolean);
    paramMaterialModel = d.f(paramMaterialModel);
    if (paramMaterialModel == null) {}
    for (paramMaterialModel = null; paramMaterialModel == null; paramMaterialModel = paramMaterialModel.toString())
    {
      AppMethodBeat.o(323703);
      return null;
    }
    Object localObject = f.qBv;
    localObject = f.aBP();
    if (localObject == null) {
      paramMaterialModel = null;
    }
    while (paramMaterialModel == null)
    {
      AppMethodBeat.o(323703);
      return null;
      if (paramBoolean)
      {
        String str = s.X(paramMaterialModel, "#sessionId");
        paramMaterialModel = ((MultiProcessMMKV)localObject).getString(str, null);
        ((MultiProcessMMKV)localObject).remove(str);
      }
      else
      {
        paramMaterialModel = ((MultiProcessMMKV)localObject).getString(s.X(paramMaterialModel, "#sessionId"), null);
      }
    }
    Log.i("MicroMsg.AppBrand.OpenMaterialsTempStorage", s.X("getReporterInner, sessionId: ", paramMaterialModel));
    AppMethodBeat.o(323703);
    return paramMaterialModel;
  }
  
  public static boolean a(MaterialModel paramMaterialModel, String paramString)
  {
    String str = null;
    AppMethodBeat.i(323687);
    s.u(paramMaterialModel, "materialModel");
    s.u(paramString, "sessionId");
    Log.i("MicroMsg.AppBrand.OpenMaterialsTempStorage", "saveSessionId, materialModel: " + paramMaterialModel + ", sessionId: " + paramString);
    paramMaterialModel = d.f(paramMaterialModel);
    if (paramMaterialModel == null) {}
    for (paramMaterialModel = null; paramMaterialModel == null; paramMaterialModel = paramMaterialModel.toString())
    {
      AppMethodBeat.o(323687);
      return false;
    }
    Object localObject = f.qBv;
    localObject = f.aBP();
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((MultiProcessMMKV)localObject).getString(paramMaterialModel, null))
    {
      Log.w("MicroMsg.AppBrand.OpenMaterialsTempStorage", "saveSessionId, openMaterialCollectionStr is null");
      AppMethodBeat.o(323687);
      return false;
    }
    localObject = f.qBv;
    localObject = f.aBP();
    if (localObject == null) {}
    for (paramMaterialModel = str; paramMaterialModel == null; paramMaterialModel = ((MultiProcessMMKV)localObject).putString("lastSaveSessionId#OpenMaterial", paramMaterialModel))
    {
      AppMethodBeat.o(323687);
      return false;
      str = ((MultiProcessMMKV)localObject).getString("lastSaveSessionId#OpenMaterial", null);
      if (str != null)
      {
        Log.i("MicroMsg.AppBrand.OpenMaterialsTempStorage", "saveSessionId, remove old sessionId");
        ((MultiProcessMMKV)localObject).remove(s.X(str, "#sessionId"));
      }
      ((MultiProcessMMKV)localObject).putString(s.X(paramMaterialModel, "#sessionId"), paramString);
    }
    AppMethodBeat.o(323687);
    return true;
  }
  
  public static AppBrandOpenMaterialCollection aeo(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(323691);
    Object localObject2 = f.qBv;
    localObject2 = f.aBP();
    if (localObject2 == null) {}
    for (paramString = null; paramString == null; paramString = ((MultiProcessMMKV)localObject2).getString(paramString, null))
    {
      AppMethodBeat.o(323691);
      return null;
    }
    try
    {
      paramString = d.aH(new JSONObject(paramString));
      AppMethodBeat.o(323691);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.OpenMaterialsTempStorage", s.X("getCollectionInner, fail since ", paramString));
        paramString = localObject1;
      }
    }
  }
  
  public static boolean b(MaterialModel paramMaterialModel, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
  {
    String str = null;
    AppMethodBeat.i(323678);
    s.u(paramMaterialModel, "materialModel");
    s.u(paramAppBrandOpenMaterialCollection, "openMaterialCollection");
    Log.i("MicroMsg.AppBrand.OpenMaterialsTempStorage", s.X("saveCollection, materialModel: ", paramMaterialModel));
    paramMaterialModel = d.f(paramMaterialModel);
    if (paramMaterialModel == null) {}
    for (paramMaterialModel = null; paramMaterialModel == null; paramMaterialModel = paramMaterialModel.toString())
    {
      AppMethodBeat.o(323678);
      return false;
    }
    paramAppBrandOpenMaterialCollection = d.c(paramAppBrandOpenMaterialCollection);
    if (paramAppBrandOpenMaterialCollection == null) {}
    for (paramAppBrandOpenMaterialCollection = null; paramAppBrandOpenMaterialCollection == null; paramAppBrandOpenMaterialCollection = paramAppBrandOpenMaterialCollection.toString())
    {
      AppMethodBeat.o(323678);
      return false;
    }
    Object localObject = f.qBv;
    localObject = f.aBP();
    if (localObject == null) {}
    for (paramMaterialModel = str; paramMaterialModel == null; paramMaterialModel = ((MultiProcessMMKV)localObject).putString("lastSaveCollection#OpenMaterial", paramMaterialModel))
    {
      AppMethodBeat.o(323678);
      return false;
      str = ((MultiProcessMMKV)localObject).getString("lastSaveCollection#OpenMaterial", null);
      if (str != null)
      {
        Log.i("MicroMsg.AppBrand.OpenMaterialsTempStorage", "saveCollection, remove old collection");
        ((MultiProcessMMKV)localObject).remove(str);
      }
      ((MultiProcessMMKV)localObject).putString(paramMaterialModel, paramAppBrandOpenMaterialCollection);
    }
    AppMethodBeat.o(323678);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.a.c
 * JD-Core Version:    0.7.0.1
 */