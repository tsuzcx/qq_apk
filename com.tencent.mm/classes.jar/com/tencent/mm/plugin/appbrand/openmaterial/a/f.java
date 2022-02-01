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
import kotlin.a.ab;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"MATERIAL_MODEL_KEY_MATERIAL_PATH", "", "MATERIAL_MODEL_KEY_MIME_TYPE", "OPEN_MATERIAL_MODEL_KEY_APP_ID", "OPEN_MATERIAL_MODEL_KEY_APP_NAME", "OPEN_MATERIAL_MODEL_KEY_CATEGORIES", "OPEN_MATERIAL_MODEL_KEY_ENTER_PATH", "OPEN_MATERIAL_MODEL_KEY_FUNCTION_DESC", "OPEN_MATERIAL_MODEL_KEY_FUNCTION_NAME", "OPEN_MATERIAL_MODEL_KEY_ICON_URL", "OPEN_MATERIAL_MODEL_KEY_MATERIAL_MODEL", "OPEN_MATERIAL_MODEL_KEY_OPEN_MATERIAL_DETAIL_MODELS", "OPEN_MATERIAL_MODEL_KEY_OPEN_MATERIAL_MODELS", "OPEN_MATERIAL_MODEL_KEY_SCORE", "OPEN_MATERIAL_MODEL_KEY_VERSION_TYPE", "TAG", "deserializeMaterialModel", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/MaterialModel;", "jsonObj", "Lorg/json/JSONObject;", "deserializeOpenMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "deserializeOpenMaterialDetailModel", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialDetailModel;", "deserializeOpenMaterialModel", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialModel;", "serializeOpenMaterialDetailModel", "openMaterialDetailModel", "serializeOpenMaterialModel", "openMaterialModel", "serialize", "plugin-appbrand-integration_release"})
public final class f
{
  static final JSONObject a(AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
  {
    AppMethodBeat.i(229163);
    JSONObject localJSONObject;
    Object localObject1;
    Object localObject2;
    try
    {
      localJSONObject = new JSONObject();
      localObject1 = paramAppBrandOpenMaterialCollection.nlD;
      p.g(localObject1, "materialModel");
      localJSONObject.put("materialModel", h((MaterialModel)localObject1));
      localObject1 = new JSONArray();
      localObject2 = paramAppBrandOpenMaterialCollection.nlE;
      p.g(localObject2, "appBrandOpenMaterialModels");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        AppBrandOpenMaterialModel localAppBrandOpenMaterialModel = (AppBrandOpenMaterialModel)((Iterator)localObject2).next();
        p.g(localAppBrandOpenMaterialModel, "openMaterialModel");
        ((JSONArray)localObject1).put(a(localAppBrandOpenMaterialModel));
        continue;
        AppMethodBeat.o(229163);
      }
    }
    catch (Exception paramAppBrandOpenMaterialCollection)
    {
      Log.w("MicroMsg.AppBrand.OpenMaterialsStorage", "serialize#AppBrandOpenMaterialCollection, fail since ".concat(String.valueOf(paramAppBrandOpenMaterialCollection)));
      paramAppBrandOpenMaterialCollection = null;
    }
    for (;;)
    {
      return paramAppBrandOpenMaterialCollection;
      localJSONObject.put("appBrandOpenMaterialModels", localObject1);
      localObject1 = new JSONArray();
      paramAppBrandOpenMaterialCollection = paramAppBrandOpenMaterialCollection.nlF;
      p.g(paramAppBrandOpenMaterialCollection, "appBrandOpenMaterialDetailModels");
      paramAppBrandOpenMaterialCollection = ((Iterable)paramAppBrandOpenMaterialCollection).iterator();
      while (paramAppBrandOpenMaterialCollection.hasNext())
      {
        localObject2 = (AppBrandOpenMaterialDetailModel)paramAppBrandOpenMaterialCollection.next();
        p.g(localObject2, "openMaterialDetailModel");
        ((JSONArray)localObject1).put(a((AppBrandOpenMaterialDetailModel)localObject2));
      }
      localJSONObject.put("appBrandOpenMaterialDetailModels", localObject1);
      paramAppBrandOpenMaterialCollection = localJSONObject;
    }
  }
  
  private static final JSONObject a(AppBrandOpenMaterialDetailModel paramAppBrandOpenMaterialDetailModel)
  {
    AppMethodBeat.i(229161);
    JSONObject localJSONObject;
    JSONArray localJSONArray;
    try
    {
      localJSONObject = a((AppBrandOpenMaterialModel)paramAppBrandOpenMaterialDetailModel);
      if (localJSONObject != null)
      {
        localJSONArray = new JSONArray();
        Object localObject = paramAppBrandOpenMaterialDetailModel.lgE;
        p.g(localObject, "openMaterialDetailModel.categories");
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localJSONArray.put((String)((Iterator)localObject).next());
          continue;
          AppMethodBeat.o(229161);
        }
      }
    }
    catch (Exception paramAppBrandOpenMaterialDetailModel)
    {
      Log.w("MicroMsg.AppBrand.OpenMaterialsStorage", "serializeOpenMaterialDetailModel, fail since ".concat(String.valueOf(paramAppBrandOpenMaterialDetailModel)));
      paramAppBrandOpenMaterialDetailModel = null;
    }
    for (;;)
    {
      return paramAppBrandOpenMaterialDetailModel;
      localJSONObject.put("categories", localJSONArray);
      localJSONObject.put("score", Float.valueOf(paramAppBrandOpenMaterialDetailModel.score));
      localJSONObject.put("functionDesc", paramAppBrandOpenMaterialDetailModel.nlG);
      paramAppBrandOpenMaterialDetailModel = localJSONObject;
      continue;
      paramAppBrandOpenMaterialDetailModel = null;
    }
  }
  
  private static final JSONObject a(AppBrandOpenMaterialModel paramAppBrandOpenMaterialModel)
  {
    AppMethodBeat.i(229159);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("appId", paramAppBrandOpenMaterialModel.appId);
      localJSONObject.put("versionType", paramAppBrandOpenMaterialModel.iOo);
      localJSONObject.put("enterPath", paramAppBrandOpenMaterialModel.kHw);
      localJSONObject.put("iconUrl", paramAppBrandOpenMaterialModel.iconUrl);
      localJSONObject.put("functionName", paramAppBrandOpenMaterialModel.nlH);
      localJSONObject.put("appName", paramAppBrandOpenMaterialModel.appName);
      paramAppBrandOpenMaterialModel = localJSONObject;
    }
    catch (Exception paramAppBrandOpenMaterialModel)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.OpenMaterialsStorage", "serializeOpenMaterialModel, fail since ".concat(String.valueOf(paramAppBrandOpenMaterialModel)));
        paramAppBrandOpenMaterialModel = null;
      }
    }
    AppMethodBeat.o(229159);
    return paramAppBrandOpenMaterialModel;
  }
  
  private static final MaterialModel aq(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(229158);
    try
    {
      paramJSONObject = MaterialModel.eB(paramJSONObject.getString("mimeType"), paramJSONObject.getString("materialPath"));
      AppMethodBeat.o(229158);
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.OpenMaterialsStorage", "deserializeMaterialModel, fail since ".concat(String.valueOf(paramJSONObject)));
        paramJSONObject = null;
      }
    }
  }
  
  private static final AppBrandOpenMaterialModel ar(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(229160);
    int i;
    try
    {
      str1 = paramJSONObject.getString("appId");
      j = paramJSONObject.getInt("versionType");
      str2 = paramJSONObject.getString("enterPath");
      localObject = paramJSONObject.optString("iconUrl");
      p.g(localObject, "it");
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
        Log.w("MicroMsg.AppBrand.OpenMaterialsStorage", "deserializeOpenMaterialModel, fail since ".concat(String.valueOf(paramJSONObject)));
        paramJSONObject = null;
        continue;
        if (i != 0) {
          localObject = null;
        }
      }
    }
    str3 = paramJSONObject.getString("functionName");
    paramJSONObject = paramJSONObject.optString("appName");
    p.g(paramJSONObject, "it");
    if (((CharSequence)paramJSONObject).length() == 0) {
      i = 1;
    }
    for (;;)
    {
      localObject = new AppBrandOpenMaterialModel(str1, j, str2, (String)localObject, str3);
      ((AppBrandOpenMaterialModel)localObject).appName = paramJSONObject;
      paramJSONObject = (JSONObject)localObject;
      AppMethodBeat.o(229160);
      return paramJSONObject;
      label126:
      i = 0;
      break label156;
      i = 0;
      label156:
      if (i != 0) {
        paramJSONObject = null;
      }
    }
  }
  
  private static final AppBrandOpenMaterialDetailModel as(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(229162);
    AppBrandOpenMaterialModel localAppBrandOpenMaterialModel;
    Object localObject1;
    Collection localCollection;
    Object localObject3;
    try
    {
      localAppBrandOpenMaterialModel = ar(paramJSONObject);
      if (localAppBrandOpenMaterialModel != null)
      {
        localObject1 = paramJSONObject.getJSONArray("categories");
        Object localObject2 = (Iterable)kotlin.k.j.mY(0, ((JSONArray)localObject1).length());
        localCollection = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((JSONArray)localObject1).get(((ab)localObject2).nextInt());
          if (localObject3 == null)
          {
            paramJSONObject = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(229162);
            throw paramJSONObject;
          }
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      Log.w("MicroMsg.AppBrand.OpenMaterialsStorage", "deserializeOpenMaterialDetailModel, fail since ".concat(String.valueOf(paramJSONObject)));
      paramJSONObject = null;
    }
    for (;;)
    {
      AppMethodBeat.o(229162);
      return paramJSONObject;
      localCollection.add((String)localObject3);
      break;
      localObject1 = (List)localCollection;
      double d = paramJSONObject.getDouble("score");
      paramJSONObject = paramJSONObject.getString("functionDesc");
      paramJSONObject = new AppBrandOpenMaterialDetailModel(localAppBrandOpenMaterialModel.appId, localAppBrandOpenMaterialModel.iOo, localAppBrandOpenMaterialModel.kHw, localAppBrandOpenMaterialModel.iconUrl, localAppBrandOpenMaterialModel.nlH, (List)localObject1, (float)d, paramJSONObject);
      paramJSONObject.appName = localAppBrandOpenMaterialModel.appName;
      continue;
      paramJSONObject = null;
    }
  }
  
  static final AppBrandOpenMaterialCollection at(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(229164);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Collection localCollection;
    Object localObject4;
    try
    {
      localObject1 = paramJSONObject.getJSONObject("materialModel");
      p.g(localObject1, "jsonObj.getJSONObject(OP…MODEL_KEY_MATERIAL_MODEL)");
      localObject1 = aq((JSONObject)localObject1);
      if (localObject1 == null) {
        p.hyc();
      }
      localObject2 = paramJSONObject.getJSONArray("appBrandOpenMaterialModels");
      localObject3 = (Iterable)kotlin.k.j.mY(0, ((JSONArray)localObject2).length());
      localCollection = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((JSONArray)localObject2).get(((ab)localObject3).nextInt());
        if (localObject4 == null)
        {
          paramJSONObject = new t("null cannot be cast to non-null type org.json.JSONObject");
          AppMethodBeat.o(229164);
          throw paramJSONObject;
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      Log.w("MicroMsg.AppBrand.OpenMaterialsStorage", "deserializeOpenMaterialCollection, fail since ".concat(String.valueOf(paramJSONObject)));
      paramJSONObject = null;
    }
    for (;;)
    {
      AppMethodBeat.o(229164);
      return paramJSONObject;
      localCollection.add(ar((JSONObject)localObject4));
      break;
      localObject2 = (List)localCollection;
      paramJSONObject = paramJSONObject.getJSONArray("appBrandOpenMaterialDetailModels");
      localObject3 = (Iterable)kotlin.k.j.mY(0, paramJSONObject.length());
      localCollection = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = paramJSONObject.get(((ab)localObject3).nextInt());
        if (localObject4 == null)
        {
          paramJSONObject = new t("null cannot be cast to non-null type org.json.JSONObject");
          AppMethodBeat.o(229164);
          throw paramJSONObject;
        }
        localCollection.add(as((JSONObject)localObject4));
      }
      paramJSONObject = new AppBrandOpenMaterialCollection((MaterialModel)localObject1, (List)localObject2, (List)localCollection);
    }
  }
  
  static final JSONObject h(MaterialModel paramMaterialModel)
  {
    AppMethodBeat.i(229157);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("mimeType", paramMaterialModel.mimeType);
      localJSONObject.put("materialPath", paramMaterialModel.nlI);
      paramMaterialModel = localJSONObject;
    }
    catch (Exception paramMaterialModel)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.OpenMaterialsStorage", "serialize#MaterialModel, fail since ".concat(String.valueOf(paramMaterialModel)));
        paramMaterialModel = null;
      }
    }
    AppMethodBeat.o(229157);
    return paramMaterialModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.a.f
 * JD-Core Version:    0.7.0.1
 */