package com.tencent.mm.plugin.appbrand.config;

import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dvk;
import com.tencent.mm.protocal.protobuf.ek;
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
    paramAppBrandSysConfigLU.jYb = true;
    paramAppBrandSysConfigLU.jYc = true;
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
        paramAppBrandSysConfigLU.jYb = bool;
        if (localJSONObject.optInt("location", 1) != 1) {
          break label96;
        }
      }
      label96:
      for (boolean bool = true;; bool = false)
      {
        paramAppBrandSysConfigLU.jYc = bool;
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
  
  static ek x(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(147006);
    Object localObject = paramJSONObject.optJSONObject("AppConfig");
    paramJSONObject = new ek();
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).optJSONArray("VersionList");
      paramJSONObject.Fwi = new LinkedList();
      if (localObject != null)
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
          dvk localdvk = new dvk();
          localdvk.type = localJSONObject.optInt("type");
          localdvk.version = localJSONObject.optInt("version");
          paramJSONObject.Fwi.add(localdvk);
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