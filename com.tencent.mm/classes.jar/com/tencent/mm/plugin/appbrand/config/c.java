package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfigTrimHelper;", "", "()V", "TAG", "", "trimOffInjectConfigFields", "", "appId", "injectConfig", "Lorg/json/JSONObject;", "pruneWxConfigByPage", "", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c qWD;
  
  static
  {
    AppMethodBeat.i(135557);
    qWD = new c();
    AppMethodBeat.o(135557);
  }
  
  public static final void c(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(135556);
    s.u(paramString, "appId");
    s.u(paramJSONObject, "injectConfig");
    long l1 = Util.nowMilliSecond();
    Object localObject = paramJSONObject.optJSONObject("tabBar");
    int m;
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).optJSONArray("list");
      if (localObject != null)
      {
        m = ((JSONArray)localObject).length();
        if (m <= 0) {}
      }
    }
    int k;
    for (int i = 0;; i = k)
    {
      k = i + 1;
      ((JSONArray)localObject).getJSONObject(i).remove("iconData");
      ((JSONArray)localObject).getJSONObject(i).remove("selectedIconData");
      if (k >= m)
      {
        localObject = paramJSONObject.optJSONArray("subPackages");
        if (localObject != null)
        {
          m = ((JSONArray)localObject).length();
          if (m <= 0) {}
        }
        for (i = 0;; i = k)
        {
          k = i + 1;
          ((JSONArray)localObject).getJSONObject(i).remove("pages");
          if (k >= m)
          {
            localObject = paramJSONObject.optJSONArray("subpackages");
            if (localObject != null)
            {
              k = ((JSONArray)localObject).length();
              if (k <= 0) {}
            }
            for (i = j;; i = j)
            {
              j = i + 1;
              ((JSONArray)localObject).getJSONObject(i).remove("pages");
              if (j >= k)
              {
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
                return;
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.c
 * JD-Core Version:    0.7.0.1
 */