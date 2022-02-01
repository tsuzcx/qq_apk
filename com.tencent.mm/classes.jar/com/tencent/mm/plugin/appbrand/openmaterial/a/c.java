package com.tencent.mm.plugin.appbrand.openmaterial.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/openmaterial/data/OpenMaterialsTempStorage;", "", "()V", "LAST_SAVE_COLLECTION_KEY", "", "LAST_SAVE_SESSION_ID_KEY", "SESSION_ID_SUFFIX", "getCollectionInner", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "materialModel", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/MaterialModel;", "remove", "", "materialModelStr", "getSessionIdInner", "readCollection", "readSessionId", "removeSessionId", "saveCollection", "openMaterialCollection", "saveSessionId", "sessionId", "getAndRemove", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "key", "defVal", "plugin-appbrand-integration_release"})
public final class c
{
  public static final c qnc;
  
  static
  {
    AppMethodBeat.i(266928);
    qnc = new c();
    AppMethodBeat.o(266928);
  }
  
  public static boolean a(MaterialModel paramMaterialModel, String paramString)
  {
    AppMethodBeat.i(266925);
    p.k(paramMaterialModel, "materialModel");
    p.k(paramString, "sessionId");
    Log.i("MicroMsg.AppBrand.OpenMaterialsTempStorage", "saveSessionId, materialModel: " + paramMaterialModel + ", sessionId: " + paramString);
    paramMaterialModel = d.h(paramMaterialModel);
    String str1;
    if (paramMaterialModel != null)
    {
      str1 = paramMaterialModel.toString();
      if (str1 != null) {}
    }
    else
    {
      AppMethodBeat.o(266925);
      return false;
    }
    p.j(str1, "materialModel.serialize(…oString() ?: return false");
    paramMaterialModel = f.nCi.aal();
    if (paramMaterialModel != null) {}
    for (paramMaterialModel = paramMaterialModel.getString(str1, null); paramMaterialModel == null; paramMaterialModel = null)
    {
      Log.w("MicroMsg.AppBrand.OpenMaterialsTempStorage", "saveSessionId, openMaterialCollectionStr is null");
      AppMethodBeat.o(266925);
      return false;
    }
    paramMaterialModel = f.nCi.aal();
    if (paramMaterialModel != null)
    {
      String str2 = paramMaterialModel.getString("lastSaveSessionId#OpenMaterial", null);
      if (str2 != null)
      {
        Log.i("MicroMsg.AppBrand.OpenMaterialsTempStorage", "saveSessionId, remove old sessionId");
        paramMaterialModel.remove(str2 + "#sessionId");
      }
      paramMaterialModel.putString(str1 + "#sessionId", paramString);
      if (paramMaterialModel.putString("lastSaveSessionId#OpenMaterial", str1) != null) {}
    }
    else
    {
      AppMethodBeat.o(266925);
      return false;
    }
    AppMethodBeat.o(266925);
    return true;
  }
  
  public static AppBrandOpenMaterialCollection alh(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(266926);
    MultiProcessMMKV localMultiProcessMMKV = f.nCi.aal();
    if (localMultiProcessMMKV != null)
    {
      paramString = localMultiProcessMMKV.getString(paramString, null);
      if (paramString != null) {}
    }
    else
    {
      AppMethodBeat.o(266926);
      return null;
    }
    try
    {
      paramString = d.ax(new JSONObject(paramString));
      AppMethodBeat.o(266926);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.OpenMaterialsTempStorage", "getCollectionInner, fail since ".concat(String.valueOf(paramString)));
        paramString = localObject;
      }
    }
  }
  
  public static boolean b(MaterialModel paramMaterialModel, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
  {
    AppMethodBeat.i(266924);
    p.k(paramMaterialModel, "materialModel");
    p.k(paramAppBrandOpenMaterialCollection, "openMaterialCollection");
    Log.i("MicroMsg.AppBrand.OpenMaterialsTempStorage", "saveCollection, materialModel: ".concat(String.valueOf(paramMaterialModel)));
    paramMaterialModel = d.h(paramMaterialModel);
    if (paramMaterialModel != null)
    {
      paramMaterialModel = paramMaterialModel.toString();
      if (paramMaterialModel != null) {}
    }
    else
    {
      AppMethodBeat.o(266924);
      return false;
    }
    p.j(paramMaterialModel, "materialModel.serialize(…oString() ?: return false");
    paramAppBrandOpenMaterialCollection = d.c(paramAppBrandOpenMaterialCollection);
    if (paramAppBrandOpenMaterialCollection != null)
    {
      paramAppBrandOpenMaterialCollection = paramAppBrandOpenMaterialCollection.toString();
      if (paramAppBrandOpenMaterialCollection != null) {}
    }
    else
    {
      AppMethodBeat.o(266924);
      return false;
    }
    p.j(paramAppBrandOpenMaterialCollection, "openMaterialCollection.s…oString() ?: return false");
    MultiProcessMMKV localMultiProcessMMKV = f.nCi.aal();
    if (localMultiProcessMMKV != null)
    {
      String str = localMultiProcessMMKV.getString("lastSaveCollection#OpenMaterial", null);
      if (str != null)
      {
        Log.i("MicroMsg.AppBrand.OpenMaterialsTempStorage", "saveCollection, remove old collection");
        localMultiProcessMMKV.remove(str);
      }
      localMultiProcessMMKV.putString(paramMaterialModel, paramAppBrandOpenMaterialCollection);
      if (localMultiProcessMMKV.putString("lastSaveCollection#OpenMaterial", paramMaterialModel) != null) {}
    }
    else
    {
      AppMethodBeat.o(266924);
      return false;
    }
    AppMethodBeat.o(266924);
    return true;
  }
  
  public static String g(MaterialModel paramMaterialModel)
  {
    AppMethodBeat.i(266927);
    Log.i("MicroMsg.AppBrand.OpenMaterialsTempStorage", "getSessionIdInner, materialModel: " + paramMaterialModel + ", remove: false");
    paramMaterialModel = d.h(paramMaterialModel);
    if (paramMaterialModel != null)
    {
      paramMaterialModel = paramMaterialModel.toString();
      if (paramMaterialModel != null) {}
    }
    else
    {
      AppMethodBeat.o(266927);
      return null;
    }
    p.j(paramMaterialModel, "materialModel.serialize(…           ?: return null");
    MultiProcessMMKV localMultiProcessMMKV = f.nCi.aal();
    if (localMultiProcessMMKV != null)
    {
      paramMaterialModel = localMultiProcessMMKV.getString(paramMaterialModel + "#sessionId", null);
      if (paramMaterialModel != null) {}
    }
    else
    {
      AppMethodBeat.o(266927);
      return null;
    }
    Log.i("MicroMsg.AppBrand.OpenMaterialsTempStorage", "getReporterInner, sessionId: ".concat(String.valueOf(paramMaterialModel)));
    AppMethodBeat.o(266927);
    return paramMaterialModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.a.c
 * JD-Core Version:    0.7.0.1
 */