package com.tencent.mm.plugin.appbrand.config;

import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fo;
import com.tencent.mm.protocal.protobuf.fxf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public enum x
{
  static fo R(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(147006);
    Object localObject = paramJSONObject.optJSONObject("AppConfig");
    paramJSONObject = new fo();
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).optJSONArray("VersionList");
      paramJSONObject.YGZ = new LinkedList();
      if (localObject != null)
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
          fxf localfxf = new fxf();
          localfxf.type = localJSONObject.optInt("type");
          localfxf.version = localJSONObject.optInt("version");
          paramJSONObject.YGZ.add(localfxf);
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
    paramAppBrandSysConfigLU.qYR = true;
    paramAppBrandSysConfigLU.qYS = true;
    paramAppBrandSysConfigLU.qYT = true;
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
        paramAppBrandSysConfigLU.qYR = bool;
        if (localJSONObject.optInt("location", 1) != 1) {
          break label119;
        }
        bool = true;
        label85:
        paramAppBrandSysConfigLU.qYS = bool;
        if (localJSONObject.optInt("bluetooth", 1) != 1) {
          break label124;
        }
      }
      label119:
      label124:
      for (boolean bool = true;; bool = false)
      {
        paramAppBrandSysConfigLU.qYT = bool;
        AppMethodBeat.o(147007);
        return;
        bool = false;
        break;
        bool = false;
        break label85;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.x
 * JD-Core Version:    0.7.0.1
 */