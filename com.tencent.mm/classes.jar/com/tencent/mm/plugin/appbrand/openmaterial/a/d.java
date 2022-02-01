package com.tencent.mm.plugin.appbrand.openmaterial.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialDetailModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.k.k;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"MATERIAL_MODEL_KEY_MATERIAL_PATH", "", "MATERIAL_MODEL_KEY_MIME_TYPE", "OPEN_MATERIAL_MODEL_KEY_APP_ID", "OPEN_MATERIAL_MODEL_KEY_APP_NAME", "OPEN_MATERIAL_MODEL_KEY_CATEGORIES", "OPEN_MATERIAL_MODEL_KEY_ENTER_PATH", "OPEN_MATERIAL_MODEL_KEY_FUNCTION_DESC", "OPEN_MATERIAL_MODEL_KEY_FUNCTION_NAME", "OPEN_MATERIAL_MODEL_KEY_ICON_URL", "OPEN_MATERIAL_MODEL_KEY_MATERIAL_MODEL", "OPEN_MATERIAL_MODEL_KEY_OPEN_MATERIAL_DETAIL_MODELS", "OPEN_MATERIAL_MODEL_KEY_OPEN_MATERIAL_MODELS", "OPEN_MATERIAL_MODEL_KEY_SCORE", "OPEN_MATERIAL_MODEL_KEY_VERSION_TYPE", "TAG", "deserializeMaterialModel", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/MaterialModel;", "jsonObj", "Lorg/json/JSONObject;", "deserializeOpenMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "deserializeOpenMaterialDetailModel", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialDetailModel;", "deserializeOpenMaterialModel", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialModel;", "serializeOpenMaterialDetailModel", "openMaterialDetailModel", "serializeOpenMaterialModel", "openMaterialModel", "serialize", "plugin-appbrand-integration_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class d
{
  private static final JSONObject a(AppBrandOpenMaterialDetailModel paramAppBrandOpenMaterialDetailModel)
  {
    AppMethodBeat.i(323704);
    try
    {
      localJSONObject = d((AppBrandOpenMaterialModel)paramAppBrandOpenMaterialDetailModel);
      if (localJSONObject != null) {
        break label26;
      }
      paramAppBrandOpenMaterialDetailModel = null;
    }
    catch (Exception paramAppBrandOpenMaterialDetailModel)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        JSONArray localJSONArray;
        Log.w("MicroMsg.AppBrand.OpenMaterialsTempStorage", s.X("serializeOpenMaterialDetailModel, fail since ", paramAppBrandOpenMaterialDetailModel));
        paramAppBrandOpenMaterialDetailModel = null;
        continue;
        Object localObject = kotlin.ah.aiuX;
        localJSONObject.put("categories", localJSONArray);
        localJSONObject.put("score", Float.valueOf(paramAppBrandOpenMaterialDetailModel.score));
        localJSONObject.put("functionDesc", paramAppBrandOpenMaterialDetailModel.trQ);
        paramAppBrandOpenMaterialDetailModel = localJSONObject;
      }
    }
    AppMethodBeat.o(323704);
    return paramAppBrandOpenMaterialDetailModel;
    label26:
    localJSONArray = new JSONArray();
    localObject = paramAppBrandOpenMaterialDetailModel.rbS;
    s.s(localObject, "openMaterialDetailModel.categories");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localJSONArray.put((String)((Iterator)localObject).next());
    }
  }
  
  private static final MaterialModel aE(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(323681);
    try
    {
      paramJSONObject = MaterialModel.fg(paramJSONObject.getString("mimeType"), paramJSONObject.getString("materialPath"));
      AppMethodBeat.o(323681);
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.OpenMaterialsTempStorage", s.X("deserializeMaterialModel, fail since ", paramJSONObject));
        paramJSONObject = null;
      }
    }
  }
  
  private static final AppBrandOpenMaterialModel aF(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(323692);
    int i;
    try
    {
      str1 = paramJSONObject.getString("appId");
      j = paramJSONObject.getInt("versionType");
      str2 = paramJSONObject.getString("enterPath");
      localObject = paramJSONObject.optString("iconUrl");
      s.s(localObject, "it");
      if (((CharSequence)localObject).length() != 0) {
        break label126;
      }
      i = 1;
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        String str1;
        int j;
        String str2;
        Object localObject;
        String str3;
        Log.w("MicroMsg.AppBrand.OpenMaterialsTempStorage", s.X("deserializeOpenMaterialModel, fail since ", paramJSONObject));
        paramJSONObject = null;
        continue;
        if (i != 0) {
          localObject = null;
        }
      }
    }
    str3 = paramJSONObject.getString("functionName");
    paramJSONObject = paramJSONObject.optString("appName");
    s.s(paramJSONObject, "it");
    if (((CharSequence)paramJSONObject).length() == 0) {
      i = 1;
    }
    for (;;)
    {
      localObject = new AppBrandOpenMaterialModel(str1, j, str2, (String)localObject, str3);
      ((AppBrandOpenMaterialModel)localObject).appName = paramJSONObject;
      paramJSONObject = (JSONObject)localObject;
      AppMethodBeat.o(323692);
      return paramJSONObject;
      label126:
      i = 0;
      break label153;
      i = 0;
      label153:
      if (i != 0) {
        paramJSONObject = null;
      }
    }
  }
  
  private static final AppBrandOpenMaterialDetailModel aG(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(323715);
    try
    {
      localAppBrandOpenMaterialModel = aF(paramJSONObject);
      if (localAppBrandOpenMaterialModel != null) {
        break label23;
      }
      paramJSONObject = null;
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        AppBrandOpenMaterialModel localAppBrandOpenMaterialModel;
        Object localObject2;
        Collection localCollection;
        Object localObject3;
        Log.w("MicroMsg.AppBrand.OpenMaterialsTempStorage", s.X("deserializeOpenMaterialDetailModel, fail since ", paramJSONObject));
        paramJSONObject = null;
        continue;
        localCollection.add((String)localObject3);
        continue;
        Object localObject1 = (List)localCollection;
        double d = paramJSONObject.getDouble("score");
        paramJSONObject = paramJSONObject.getString("functionDesc");
        paramJSONObject = new AppBrandOpenMaterialDetailModel(localAppBrandOpenMaterialModel.appId, localAppBrandOpenMaterialModel.euz, localAppBrandOpenMaterialModel.qAF, localAppBrandOpenMaterialModel.iconUrl, localAppBrandOpenMaterialModel.trR, (List)localObject1, (float)d, paramJSONObject);
        paramJSONObject.appName = localAppBrandOpenMaterialModel.appName;
      }
    }
    AppMethodBeat.o(323715);
    return paramJSONObject;
    label23:
    localObject1 = paramJSONObject.getJSONArray("categories");
    localObject2 = (Iterable)k.qt(0, ((JSONArray)localObject1).length());
    localCollection = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((JSONArray)localObject1).get(((kotlin.a.ah)localObject2).Zo());
      if (localObject3 == null)
      {
        paramJSONObject = new NullPointerException("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(323715);
        throw paramJSONObject;
      }
    }
  }
  
  static final AppBrandOpenMaterialCollection aH(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(323739);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Collection localCollection;
    Object localObject4;
    try
    {
      localObject1 = paramJSONObject.getJSONObject("materialModel");
      s.s(localObject1, "jsonObj.getJSONObject(OP…MODEL_KEY_MATERIAL_MODEL)");
      localObject1 = aE((JSONObject)localObject1);
      s.checkNotNull(localObject1);
      localObject2 = paramJSONObject.getJSONArray("appBrandOpenMaterialModels");
      localObject3 = (Iterable)k.qt(0, ((JSONArray)localObject2).length());
      localCollection = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((JSONArray)localObject2).get(((kotlin.a.ah)localObject3).Zo());
        if (localObject4 == null)
        {
          paramJSONObject = new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
          AppMethodBeat.o(323739);
          throw paramJSONObject;
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      Log.w("MicroMsg.AppBrand.OpenMaterialsTempStorage", s.X("deserializeOpenMaterialCollection, fail since ", paramJSONObject));
      paramJSONObject = null;
    }
    for (;;)
    {
      AppMethodBeat.o(323739);
      return paramJSONObject;
      localCollection.add(aF((JSONObject)localObject4));
      break;
      localObject2 = (List)localCollection;
      paramJSONObject = paramJSONObject.getJSONArray("appBrandOpenMaterialDetailModels");
      localObject3 = (Iterable)k.qt(0, paramJSONObject.length());
      localCollection = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = paramJSONObject.get(((kotlin.a.ah)localObject3).Zo());
        if (localObject4 == null)
        {
          paramJSONObject = new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
          AppMethodBeat.o(323739);
          throw paramJSONObject;
        }
        localCollection.add(aG((JSONObject)localObject4));
      }
      paramJSONObject = new AppBrandOpenMaterialCollection((MaterialModel)localObject1, (List)localObject2, (List)localCollection);
    }
  }
  
  static final JSONObject c(AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
  {
    AppMethodBeat.i(323727);
    JSONObject localJSONObject;
    Object localObject1;
    Object localObject2;
    try
    {
      localJSONObject = new JSONObject();
      localObject1 = paramAppBrandOpenMaterialCollection.trN;
      s.s(localObject1, "materialModel");
      localJSONObject.put("materialModel", f((MaterialModel)localObject1));
      localObject1 = new JSONArray();
      localObject2 = paramAppBrandOpenMaterialCollection.trO;
      s.s(localObject2, "appBrandOpenMaterialModels");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        AppBrandOpenMaterialModel localAppBrandOpenMaterialModel = (AppBrandOpenMaterialModel)((Iterator)localObject2).next();
        s.s(localAppBrandOpenMaterialModel, "openMaterialModel");
        ((JSONArray)localObject1).put(d(localAppBrandOpenMaterialModel));
        continue;
        AppMethodBeat.o(323727);
      }
    }
    catch (Exception paramAppBrandOpenMaterialCollection)
    {
      Log.w("MicroMsg.AppBrand.OpenMaterialsTempStorage", s.X("serialize#AppBrandOpenMaterialCollection, fail since ", paramAppBrandOpenMaterialCollection));
      paramAppBrandOpenMaterialCollection = null;
    }
    for (;;)
    {
      return paramAppBrandOpenMaterialCollection;
      localObject2 = kotlin.ah.aiuX;
      localJSONObject.put("appBrandOpenMaterialModels", localObject1);
      localObject1 = new JSONArray();
      paramAppBrandOpenMaterialCollection = paramAppBrandOpenMaterialCollection.trP;
      s.s(paramAppBrandOpenMaterialCollection, "appBrandOpenMaterialDetailModels");
      paramAppBrandOpenMaterialCollection = ((Iterable)paramAppBrandOpenMaterialCollection).iterator();
      while (paramAppBrandOpenMaterialCollection.hasNext())
      {
        localObject2 = (AppBrandOpenMaterialDetailModel)paramAppBrandOpenMaterialCollection.next();
        s.s(localObject2, "openMaterialDetailModel");
        ((JSONArray)localObject1).put(a((AppBrandOpenMaterialDetailModel)localObject2));
      }
      paramAppBrandOpenMaterialCollection = kotlin.ah.aiuX;
      localJSONObject.put("appBrandOpenMaterialDetailModels", localObject1);
      paramAppBrandOpenMaterialCollection = localJSONObject;
    }
  }
  
  private static final JSONObject d(AppBrandOpenMaterialModel paramAppBrandOpenMaterialModel)
  {
    AppMethodBeat.i(323686);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("appId", paramAppBrandOpenMaterialModel.appId);
      localJSONObject.put("versionType", paramAppBrandOpenMaterialModel.euz);
      localJSONObject.put("enterPath", paramAppBrandOpenMaterialModel.qAF);
      localJSONObject.put("iconUrl", paramAppBrandOpenMaterialModel.iconUrl);
      localJSONObject.put("functionName", paramAppBrandOpenMaterialModel.trR);
      localJSONObject.put("appName", paramAppBrandOpenMaterialModel.appName);
      paramAppBrandOpenMaterialModel = localJSONObject;
    }
    catch (Exception paramAppBrandOpenMaterialModel)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.OpenMaterialsTempStorage", s.X("serializeOpenMaterialModel, fail since ", paramAppBrandOpenMaterialModel));
        paramAppBrandOpenMaterialModel = null;
      }
    }
    AppMethodBeat.o(323686);
    return paramAppBrandOpenMaterialModel;
  }
  
  public static final JSONObject f(MaterialModel paramMaterialModel)
  {
    AppMethodBeat.i(323670);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("mimeType", paramMaterialModel.mimeType);
      localJSONObject.put("materialPath", paramMaterialModel.trT);
      paramMaterialModel = localJSONObject;
    }
    catch (Exception paramMaterialModel)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.OpenMaterialsTempStorage", s.X("serialize#MaterialModel, fail since ", paramMaterialModel));
        paramMaterialModel = null;
      }
    }
    AppMethodBeat.o(323670);
    return paramMaterialModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.a.d
 * JD-Core Version:    0.7.0.1
 */