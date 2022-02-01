package com.tencent.mm.plugin.appbrand.config;

import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dpt;
import com.tencent.mm.protocal.protobuf.eg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public enum r
{
  public static void a(AppBrandSysConfigLU paramAppBrandSysConfigLU, String paramString)
  {
    AppMethodBeat.i(147007);
    paramAppBrandSysConfigLU.jEa = true;
    paramAppBrandSysConfigLU.jEb = true;
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.AppBrandSysConfigUtil", "operationInfo nil");
      AppMethodBeat.o(147007);
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString).getJSONObject("bgKeepAlive");
      if (localJSONObject.optInt("music", 1) == 1)
      {
        bool = true;
        paramAppBrandSysConfigLU.jEa = bool;
        if (localJSONObject.optInt("location", 1) != 1) {
          break label96;
        }
      }
      label96:
      for (boolean bool = true;; bool = false)
      {
        paramAppBrandSysConfigLU.jEb = bool;
        AppMethodBeat.o(147007);
        return;
        bool = false;
        break;
      }
      return;
    }
    catch (JSONException paramAppBrandSysConfigLU)
    {
      ac.w("MicroMsg.AppBrandSysConfigUtil", "assembleBgKeepAliveConfigByOperationInfo operationInfo:%s", new Object[] { paramString });
      ac.w("MicroMsg.AppBrandSysConfigUtil", "assembleBgKeepAliveConfigByOperationInfo exp:%s", new Object[] { paramAppBrandSysConfigLU });
      AppMethodBeat.o(147007);
    }
  }
  
  static eg x(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(147006);
    Object localObject = paramJSONObject.optJSONObject("AppConfig");
    paramJSONObject = new eg();
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).optJSONArray("VersionList");
      paramJSONObject.DQQ = new LinkedList();
      if (localObject != null)
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
          dpt localdpt = new dpt();
          localdpt.type = localJSONObject.optInt("type");
          localdpt.version = localJSONObject.optInt("version");
          paramJSONObject.DQQ.add(localdpt);
          i += 1;
        }
      }
    }
    AppMethodBeat.o(147006);
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.r
 * JD-Core Version:    0.7.0.1
 */