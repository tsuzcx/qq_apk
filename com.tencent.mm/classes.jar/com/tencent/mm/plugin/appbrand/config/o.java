package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.protocal.c.cdl;
import com.tencent.mm.protocal.c.df;
import com.tencent.mm.protocal.c.dv;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public enum o
{
  static String a(dv paramdv)
  {
    if (paramdv == null) {
      return "AppRunningFlagInfo{null}";
    }
    return "AppRunningFlagInfo{RunningFlag=" + paramdv.sxr + ", StopServiceTime" + paramdv.sxs + ", AppForbiddenReason" + paramdv.sxt + ", SessionOpenForbiddenReason" + paramdv.sxu + ", TimelineOpenForbiddenReason" + paramdv.sxv + "}";
  }
  
  public static void a(AppBrandSysConfigWC paramAppBrandSysConfigWC, String paramString)
  {
    paramAppBrandSysConfigWC.fPP = true;
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.AppBrandSysConfigUtil", "operationInfo nil");
      return;
    }
    for (;;)
    {
      try
      {
        if (new JSONObject(paramString).getJSONObject("bgKeepAlive").getInt("music") == 1)
        {
          bool = true;
          paramAppBrandSysConfigWC.fPP = bool;
          return;
        }
      }
      catch (JSONException paramAppBrandSysConfigWC)
      {
        y.w("MicroMsg.AppBrandSysConfigUtil", "assembleBgKeepAliveConfigByOperationInfo operationInfo:%s", new Object[] { paramString });
        y.w("MicroMsg.AppBrandSysConfigUtil", "assembleBgKeepAliveConfigByOperationInfo exp:%s", new Object[] { paramAppBrandSysConfigWC });
        return;
      }
      boolean bool = false;
    }
  }
  
  static df m(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optJSONObject("AppConfig");
    paramJSONObject = new df();
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).optJSONArray("VersionList");
      paramJSONObject.swv = new LinkedList();
      if (localObject != null)
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
          cdl localcdl = new cdl();
          localcdl.type = localJSONObject.optInt("type");
          localcdl.version = localJSONObject.optInt("version");
          paramJSONObject.swv.add(localcdl);
          i += 1;
        }
      }
    }
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.o
 * JD-Core Version:    0.7.0.1
 */