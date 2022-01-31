package com.tencent.mm.plugin.appbrand.config;

import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cqs;
import com.tencent.mm.protocal.protobuf.dr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public enum n
{
  public static void a(AppBrandSysConfigLU paramAppBrandSysConfigLU, String paramString)
  {
    AppMethodBeat.i(101821);
    paramAppBrandSysConfigLU.hiS = true;
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.AppBrandSysConfigUtil", "operationInfo nil");
      AppMethodBeat.o(101821);
      return;
    }
    try
    {
      if (new JSONObject(paramString).getJSONObject("bgKeepAlive").getInt("music") == 1) {}
      for (boolean bool = true;; bool = false)
      {
        paramAppBrandSysConfigLU.hiS = bool;
        AppMethodBeat.o(101821);
        return;
      }
      return;
    }
    catch (JSONException paramAppBrandSysConfigLU)
    {
      ab.w("MicroMsg.AppBrandSysConfigUtil", "assembleBgKeepAliveConfigByOperationInfo operationInfo:%s", new Object[] { paramString });
      ab.w("MicroMsg.AppBrandSysConfigUtil", "assembleBgKeepAliveConfigByOperationInfo exp:%s", new Object[] { paramAppBrandSysConfigLU });
      AppMethodBeat.o(101821);
    }
  }
  
  static dr s(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(101819);
    Object localObject = paramJSONObject.optJSONObject("AppConfig");
    paramJSONObject = new dr();
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).optJSONArray("VersionList");
      paramJSONObject.wpH = new LinkedList();
      if (localObject != null)
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
          cqs localcqs = new cqs();
          localcqs.type = localJSONObject.optInt("type");
          localcqs.version = localJSONObject.optInt("version");
          paramJSONObject.wpH.add(localcqs);
          i += 1;
        }
      }
    }
    AppMethodBeat.o(101819);
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.n
 * JD-Core Version:    0.7.0.1
 */