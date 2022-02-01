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
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;
import kotlin.t;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"MATERIAL_MODEL_KEY_MATERIAL_PATH", "", "MATERIAL_MODEL_KEY_MIME_TYPE", "OPEN_MATERIAL_MODEL_KEY_APP_ID", "OPEN_MATERIAL_MODEL_KEY_APP_NAME", "OPEN_MATERIAL_MODEL_KEY_CATEGORIES", "OPEN_MATERIAL_MODEL_KEY_ENTER_PATH", "OPEN_MATERIAL_MODEL_KEY_FUNCTION_DESC", "OPEN_MATERIAL_MODEL_KEY_FUNCTION_NAME", "OPEN_MATERIAL_MODEL_KEY_ICON_URL", "OPEN_MATERIAL_MODEL_KEY_MATERIAL_MODEL", "OPEN_MATERIAL_MODEL_KEY_OPEN_MATERIAL_DETAIL_MODELS", "OPEN_MATERIAL_MODEL_KEY_OPEN_MATERIAL_MODELS", "OPEN_MATERIAL_MODEL_KEY_SCORE", "OPEN_MATERIAL_MODEL_KEY_VERSION_TYPE", "TAG", "deserializeMaterialModel", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/MaterialModel;", "jsonObj", "Lorg/json/JSONObject;", "deserializeOpenMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "deserializeOpenMaterialDetailModel", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialDetailModel;", "deserializeOpenMaterialModel", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialModel;", "serializeOpenMaterialDetailModel", "openMaterialDetailModel", "serializeOpenMaterialModel", "openMaterialModel", "serialize", "plugin-appbrand-integration_release"})
public final class d
{
  private static final JSONObject a(AppBrandOpenMaterialDetailModel paramAppBrandOpenMaterialDetailModel)
  {
    AppMethodBeat.i(272713);
    JSONObject localJSONObject;
    JSONArray localJSONArray;
    try
    {
      localJSONObject = c((AppBrandOpenMaterialModel)paramAppBrandOpenMaterialDetailModel);
      if (localJSONObject != null)
      {
        localJSONArray = new JSONArray();
        Object localObject = paramAppBrandOpenMaterialDetailModel.obg;
        p.j(localObject, "openMaterialDetailModel.categories");
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localJSONArray.put((String)((Iterator)localObject).next());
          continue;
          AppMethodBeat.o(272713);
        }
      }
    }
    catch (Exception paramAppBrandOpenMaterialDetailModel)
    {
      Log.w("MicroMsg.AppBrand.OpenMaterialsTempStorage", "serializeOpenMaterialDetailModel, fail since ".concat(String.valueOf(paramAppBrandOpenMaterialDetailModel)));
      paramAppBrandOpenMaterialDetailModel = null;
    }
    for (;;)
    {
      return paramAppBrandOpenMaterialDetailModel;
      localJSONObject.put("categories", localJSONArray);
      localJSONObject.put("score", Float.valueOf(paramAppBrandOpenMaterialDetailModel.score));
      localJSONObject.put("functionDesc", paramAppBrandOpenMaterialDetailModel.qnj);
      paramAppBrandOpenMaterialDetailModel = localJSONObject;
      continue;
      paramAppBrandOpenMaterialDetailModel = null;
    }
  }
  
  private static final MaterialModel au(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(272709);
    try
    {
      paramJSONObject = MaterialModel.eP(paramJSONObject.getString("mimeType"), paramJSONObject.getString("materialPath"));
      AppMethodBeat.o(272709);
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.OpenMaterialsTempStorage", "deserializeMaterialModel, fail since ".concat(String.valueOf(paramJSONObject)));
        paramJSONObject = null;
      }
    }
  }
  
  private static final AppBrandOpenMaterialModel av(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(272712);
    int i;
    try
    {
      str1 = paramJSONObject.getString("appId");
      j = paramJSONObject.getInt("versionType");
      str2 = paramJSONObject.getString("enterPath");
      localObject = paramJSONObject.optString("iconUrl");
      p.j(localObject, "it");
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
        Log.w("MicroMsg.AppBrand.OpenMaterialsTempStorage", "deserializeOpenMaterialModel, fail since ".concat(String.valueOf(paramJSONObject)));
        paramJSONObject = null;
        continue;
        if (i != 0) {
          localObject = null;
        }
      }
    }
    str3 = paramJSONObject.getString("functionName");
    paramJSONObject = paramJSONObject.optString("appName");
    p.j(paramJSONObject, "it");
    if (((CharSequence)paramJSONObject).length() == 0) {
      i = 1;
    }
    for (;;)
    {
      localObject = new AppBrandOpenMaterialModel(str1, j, str2, (String)localObject, str3);
      ((AppBrandOpenMaterialModel)localObject).appName = paramJSONObject;
      paramJSONObject = (JSONObject)localObject;
      AppMethodBeat.o(272712);
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
  
  private static final AppBrandOpenMaterialDetailModel aw(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(272714);
    AppBrandOpenMaterialModel localAppBrandOpenMaterialModel;
    Object localObject1;
    Collection localCollection;
    Object localObject3;
    try
    {
      localAppBrandOpenMaterialModel = av(paramJSONObject);
      if (localAppBrandOpenMaterialModel != null)
      {
        localObject1 = paramJSONObject.getJSONArray("categories");
        Object localObject2 = (Iterable)i.ou(0, ((JSONArray)localObject1).length());
        localCollection = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((JSONArray)localObject1).get(((ab)localObject2).zD());
          if (localObject3 == null)
          {
            paramJSONObject = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(272714);
            throw paramJSONObject;
          }
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      Log.w("MicroMsg.AppBrand.OpenMaterialsTempStorage", "deserializeOpenMaterialDetailModel, fail since ".concat(String.valueOf(paramJSONObject)));
      paramJSONObject = null;
    }
    for (;;)
    {
      AppMethodBeat.o(272714);
      return paramJSONObject;
      localCollection.add((String)localObject3);
      break;
      localObject1 = (List)localCollection;
      double d = paramJSONObject.getDouble("score");
      paramJSONObject = paramJSONObject.getString("functionDesc");
      paramJSONObject = new AppBrandOpenMaterialDetailModel(localAppBrandOpenMaterialModel.appId, localAppBrandOpenMaterialModel.cBU, localAppBrandOpenMaterialModel.nBq, localAppBrandOpenMaterialModel.iconUrl, localAppBrandOpenMaterialModel.qnk, (List)localObject1, (float)d, paramJSONObject);
      paramJSONObject.appName = localAppBrandOpenMaterialModel.appName;
      continue;
      paramJSONObject = null;
    }
  }
  
  static final AppBrandOpenMaterialCollection ax(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(272716);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Collection localCollection;
    Object localObject4;
    try
    {
      localObject1 = paramJSONObject.getJSONObject("materialModel");
      p.j(localObject1, "jsonObj.getJSONObject(OP…MODEL_KEY_MATERIAL_MODEL)");
      localObject1 = au((JSONObject)localObject1);
      if (localObject1 == null) {
        p.iCn();
      }
      localObject2 = paramJSONObject.getJSONArray("appBrandOpenMaterialModels");
      localObject3 = (Iterable)i.ou(0, ((JSONArray)localObject2).length());
      localCollection = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((JSONArray)localObject2).get(((ab)localObject3).zD());
        if (localObject4 == null)
        {
          paramJSONObject = new t("null cannot be cast to non-null type org.json.JSONObject");
          AppMethodBeat.o(272716);
          throw paramJSONObject;
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      Log.w("MicroMsg.AppBrand.OpenMaterialsTempStorage", "deserializeOpenMaterialCollection, fail since ".concat(String.valueOf(paramJSONObject)));
      paramJSONObject = null;
    }
    for (;;)
    {
      AppMethodBeat.o(272716);
      return paramJSONObject;
      localCollection.add(av((JSONObject)localObject4));
      break;
      localObject2 = (List)localCollection;
      paramJSONObject = paramJSONObject.getJSONArray("appBrandOpenMaterialDetailModels");
      localObject3 = (Iterable)i.ou(0, paramJSONObject.length());
      localCollection = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = paramJSONObject.get(((ab)localObject3).zD());
        if (localObject4 == null)
        {
          paramJSONObject = new t("null cannot be cast to non-null type org.json.JSONObject");
          AppMethodBeat.o(272716);
          throw paramJSONObject;
        }
        localCollection.add(aw((JSONObject)localObject4));
      }
      paramJSONObject = new AppBrandOpenMaterialCollection((MaterialModel)localObject1, (List)localObject2, (List)localCollection);
    }
  }
  
  static final JSONObject c(AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
  {
    AppMethodBeat.i(272715);
    JSONObject localJSONObject;
    Object localObject1;
    Object localObject2;
    try
    {
      localJSONObject = new JSONObject();
      localObject1 = paramAppBrandOpenMaterialCollection.qng;
      p.j(localObject1, "materialModel");
      localJSONObject.put("materialModel", h((MaterialModel)localObject1));
      localObject1 = new JSONArray();
      localObject2 = paramAppBrandOpenMaterialCollection.qnh;
      p.j(localObject2, "appBrandOpenMaterialModels");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        AppBrandOpenMaterialModel localAppBrandOpenMaterialModel = (AppBrandOpenMaterialModel)((Iterator)localObject2).next();
        p.j(localAppBrandOpenMaterialModel, "openMaterialModel");
        ((JSONArray)localObject1).put(c(localAppBrandOpenMaterialModel));
        continue;
        AppMethodBeat.o(272715);
      }
    }
    catch (Exception paramAppBrandOpenMaterialCollection)
    {
      Log.w("MicroMsg.AppBrand.OpenMaterialsTempStorage", "serialize#AppBrandOpenMaterialCollection, fail since ".concat(String.valueOf(paramAppBrandOpenMaterialCollection)));
      paramAppBrandOpenMaterialCollection = null;
    }
    for (;;)
    {
      return paramAppBrandOpenMaterialCollection;
      localJSONObject.put("appBrandOpenMaterialModels", localObject1);
      localObject1 = new JSONArray();
      paramAppBrandOpenMaterialCollection = paramAppBrandOpenMaterialCollection.qni;
      p.j(paramAppBrandOpenMaterialCollection, "appBrandOpenMaterialDetailModels");
      paramAppBrandOpenMaterialCollection = ((Iterable)paramAppBrandOpenMaterialCollection).iterator();
      while (paramAppBrandOpenMaterialCollection.hasNext())
      {
        localObject2 = (AppBrandOpenMaterialDetailModel)paramAppBrandOpenMaterialCollection.next();
        p.j(localObject2, "openMaterialDetailModel");
        ((JSONArray)localObject1).put(a((AppBrandOpenMaterialDetailModel)localObject2));
      }
      localJSONObject.put("appBrandOpenMaterialDetailModels", localObject1);
      paramAppBrandOpenMaterialCollection = localJSONObject;
    }
  }
  
  private static final JSONObject c(AppBrandOpenMaterialModel paramAppBrandOpenMaterialModel)
  {
    AppMethodBeat.i(272710);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("appId", paramAppBrandOpenMaterialModel.appId);
      localJSONObject.put("versionType", paramAppBrandOpenMaterialModel.cBU);
      localJSONObject.put("enterPath", paramAppBrandOpenMaterialModel.nBq);
      localJSONObject.put("iconUrl", paramAppBrandOpenMaterialModel.iconUrl);
      localJSONObject.put("functionName", paramAppBrandOpenMaterialModel.qnk);
      localJSONObject.put("appName", paramAppBrandOpenMaterialModel.appName);
      paramAppBrandOpenMaterialModel = localJSONObject;
    }
    catch (Exception paramAppBrandOpenMaterialModel)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.OpenMaterialsTempStorage", "serializeOpenMaterialModel, fail since ".concat(String.valueOf(paramAppBrandOpenMaterialModel)));
        paramAppBrandOpenMaterialModel = null;
      }
    }
    AppMethodBeat.o(272710);
    return paramAppBrandOpenMaterialModel;
  }
  
  public static final JSONObject h(MaterialModel paramMaterialModel)
  {
    AppMethodBeat.i(272708);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("mimeType", paramMaterialModel.mimeType);
      localJSONObject.put("materialPath", paramMaterialModel.qnl);
      paramMaterialModel = localJSONObject;
    }
    catch (Exception paramMaterialModel)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.OpenMaterialsTempStorage", "serialize#MaterialModel, fail since ".concat(String.valueOf(paramMaterialModel)));
        paramMaterialModel = null;
      }
    }
    AppMethodBeat.o(272708);
    return paramMaterialModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.a.d
 * JD-Core Version:    0.7.0.1
 */