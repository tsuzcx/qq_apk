package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfigTrimHelper;", "", "()V", "TAG", "", "trimOffInjectConfigFields", "", "appId", "injectConfig", "Lorg/json/JSONObject;", "pruneWxConfigByPage", "", "luggage-wxa-app_release"})
public final class c
{
  public static final c lcF;
  
  static
  {
    AppMethodBeat.i(135557);
    lcF = new c();
    AppMethodBeat.o(135557);
  }
  
  public static final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(135556);
    p.h(paramString, "appId");
    p.h(paramJSONObject, "injectConfig");
    long l1 = Util.nowMilliSecond();
    Object localObject = paramJSONObject.optJSONObject("tabBar");
    int k;
    int i;
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).optJSONArray("list");
      if (localObject != null)
      {
        k = ((JSONArray)localObject).length();
        i = 0;
        while (i < k)
        {
          ((JSONArray)localObject).getJSONObject(i).remove("iconData");
          ((JSONArray)localObject).getJSONObject(i).remove("selectedIconData");
          i += 1;
        }
      }
    }
    localObject = paramJSONObject.optJSONArray("subPackages");
    if (localObject != null)
    {
      k = ((JSONArray)localObject).length();
      i = 0;
      while (i < k)
      {
        ((JSONArray)localObject).getJSONObject(i).remove("pages");
        i += 1;
      }
    }
    localObject = paramJSONObject.optJSONArray("subpackages");
    if (localObject != null)
    {
      k = ((JSONArray)localObject).length();
      i = j;
      while (i < k)
      {
        ((JSONArray)localObject).getJSONObject(i).remove("pages");
        i += 1;
      }
    }
    if (paramBoolean)
    {
      paramJSONObject.remove("page");
      paramJSONObject.remove("preloadRule");
    }
    paramJSONObject.remove("preloadResources");
    paramJSONObject.remove("preloadSubpackages");
    paramJSONObject.remove("manualSplashScreen");
    paramJSONObject.remove("useCommandBuffer");
    paramJSONObject.remove("permission");
    paramJSONObject.remove("navigateToMiniProgramAppIdList");
    long l2 = Util.nowMilliSecond();
    Log.d("Luggage.WXA.AppBrandAppConfigTrimHelper", "trimOffInjectConfigFields appId[" + paramString + "] cost[" + (l2 - l1) + "ms]");
    AppMethodBeat.o(135556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.c
 * JD-Core Version:    0.7.0.1
 */