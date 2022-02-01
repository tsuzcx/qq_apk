package com.tencent.mm.plugin.appbrand.config;

import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dke;
import com.tencent.mm.protocal.protobuf.ee;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public enum r
{
  public static void a(AppBrandSysConfigLU paramAppBrandSysConfigLU, String paramString)
  {
    AppMethodBeat.i(147007);
    paramAppBrandSysConfigLU.jdM = true;
    paramAppBrandSysConfigLU.jdN = true;
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.AppBrandSysConfigUtil", "operationInfo nil");
      AppMethodBeat.o(147007);
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString).getJSONObject("bgKeepAlive");
      if (localJSONObject.optInt("music", 1) == 1)
      {
        bool = true;
        paramAppBrandSysConfigLU.jdM = bool;
        if (localJSONObject.optInt("location", 1) != 1) {
          break label96;
        }
      }
      label96:
      for (boolean bool = true;; bool = false)
      {
        paramAppBrandSysConfigLU.jdN = bool;
        AppMethodBeat.o(147007);
        return;
        bool = false;
        break;
      }
      return;
    }
    catch (JSONException paramAppBrandSysConfigLU)
    {
      ad.w("MicroMsg.AppBrandSysConfigUtil", "assembleBgKeepAliveConfigByOperationInfo operationInfo:%s", new Object[] { paramString });
      ad.w("MicroMsg.AppBrandSysConfigUtil", "assembleBgKeepAliveConfigByOperationInfo exp:%s", new Object[] { paramAppBrandSysConfigLU });
      AppMethodBeat.o(147007);
    }
  }
  
  static ee x(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(147006);
    Object localObject = paramJSONObject.optJSONObject("AppConfig");
    paramJSONObject = new ee();
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).optJSONArray("VersionList");
      paramJSONObject.Cyu = new LinkedList();
      if (localObject != null)
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
          dke localdke = new dke();
          localdke.type = localJSONObject.optInt("type");
          localdke.version = localJSONObject.optInt("version");
          paramJSONObject.Cyu.add(localdke);
          i += 1;
        }
      }
    }
    AppMethodBeat.o(147006);
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.r
 * JD-Core Version:    0.7.0.1
 */