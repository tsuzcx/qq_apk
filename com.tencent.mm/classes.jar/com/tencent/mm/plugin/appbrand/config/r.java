package com.tencent.mm.plugin.appbrand.config;

import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dwh;
import com.tencent.mm.protocal.protobuf.ek;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public enum r
{
  public static void a(AppBrandSysConfigLU paramAppBrandSysConfigLU, String paramString)
  {
    AppMethodBeat.i(147007);
    paramAppBrandSysConfigLU.kbq = true;
    paramAppBrandSysConfigLU.kbr = true;
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.AppBrandSysConfigUtil", "operationInfo nil");
      AppMethodBeat.o(147007);
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString).getJSONObject("bgKeepAlive");
      if (localJSONObject.optInt("music", 1) == 1)
      {
        bool = true;
        paramAppBrandSysConfigLU.kbq = bool;
        if (localJSONObject.optInt("location", 1) != 1) {
          break label96;
        }
      }
      label96:
      for (boolean bool = true;; bool = false)
      {
        paramAppBrandSysConfigLU.kbr = bool;
        AppMethodBeat.o(147007);
        return;
        bool = false;
        break;
      }
      return;
    }
    catch (JSONException paramAppBrandSysConfigLU)
    {
      ae.w("MicroMsg.AppBrandSysConfigUtil", "assembleBgKeepAliveConfigByOperationInfo operationInfo:%s", new Object[] { paramString });
      ae.w("MicroMsg.AppBrandSysConfigUtil", "assembleBgKeepAliveConfigByOperationInfo exp:%s", new Object[] { paramAppBrandSysConfigLU });
      AppMethodBeat.o(147007);
    }
  }
  
  static ek x(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(147006);
    Object localObject = paramJSONObject.optJSONObject("AppConfig");
    paramJSONObject = new ek();
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).optJSONArray("VersionList");
      paramJSONObject.FOG = new LinkedList();
      if (localObject != null)
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
          dwh localdwh = new dwh();
          localdwh.type = localJSONObject.optInt("type");
          localdwh.version = localJSONObject.optInt("version");
          paramJSONObject.FOG.add(localdwh);
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