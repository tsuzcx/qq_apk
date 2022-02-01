package com.tencent.mm.plugin.appbrand.config;

import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eqm;
import com.tencent.mm.protocal.protobuf.ex;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public enum u
{
  static ex E(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(147006);
    Object localObject = paramJSONObject.optJSONObject("AppConfig");
    paramJSONObject = new ex();
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).optJSONArray("VersionList");
      paramJSONObject.KIo = new LinkedList();
      if (localObject != null)
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
          eqm localeqm = new eqm();
          localeqm.type = localJSONObject.optInt("type");
          localeqm.version = localJSONObject.optInt("version");
          paramJSONObject.KIo.add(localeqm);
          i += 1;
        }
      }
    }
    AppMethodBeat.o(147006);
    return paramJSONObject;
  }
  
  public static void a(AppBrandSysConfigLU paramAppBrandSysConfigLU, String paramString)
  {
    AppMethodBeat.i(147007);
    paramAppBrandSysConfigLU.ley = true;
    paramAppBrandSysConfigLU.lez = true;
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.AppBrandSysConfigUtil", "operationInfo nil");
      AppMethodBeat.o(147007);
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString).getJSONObject("bgKeepAlive");
      if (localJSONObject.optInt("music", 1) == 1)
      {
        bool = true;
        paramAppBrandSysConfigLU.ley = bool;
        if (localJSONObject.optInt("location", 1) != 1) {
          break label96;
        }
      }
      label96:
      for (boolean bool = true;; bool = false)
      {
        paramAppBrandSysConfigLU.lez = bool;
        AppMethodBeat.o(147007);
        return;
        bool = false;
        break;
      }
      return;
    }
    catch (JSONException paramAppBrandSysConfigLU)
    {
      Log.w("MicroMsg.AppBrandSysConfigUtil", "assembleBgKeepAliveConfigByOperationInfo operationInfo:%s", new Object[] { paramString });
      Log.w("MicroMsg.AppBrandSysConfigUtil", "assembleBgKeepAliveConfigByOperationInfo exp:%s", new Object[] { paramAppBrandSysConfigLU });
      AppMethodBeat.o(147007);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.u
 * JD-Core Version:    0.7.0.1
 */