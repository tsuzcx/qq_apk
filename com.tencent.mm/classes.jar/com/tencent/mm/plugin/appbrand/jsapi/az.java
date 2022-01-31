package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.sdk.platformtools.bk;
import org.json.JSONArray;
import org.json.JSONObject;

final class az
  extends a
{
  public static final int CTRL_INDEX = 283;
  public static final String NAME = "traceEvent";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = paramJSONObject.optJSONArray("events");
    if ((!AppBrandPerformanceManager.vS(paramc.getAppId())) || (paramJSONObject == null))
    {
      paramc.C(paramInt, h("fail", null));
      return;
    }
    int i = 0;
    while (i < paramJSONObject.length())
    {
      Object localObject = paramJSONObject.optJSONObject(i);
      if (localObject != null)
      {
        String str1 = ((JSONObject)localObject).optString("category");
        String str2 = ((JSONObject)localObject).optString("name");
        long l1 = ((JSONObject)localObject).optLong("start");
        long l2 = ((JSONObject)localObject).optLong("end");
        String str3 = ((JSONObject)localObject).optString("phase");
        localObject = ((JSONObject)localObject).optString("args");
        if (!bk.bl(str2)) {
          com.tencent.mm.plugin.appbrand.performance.a.a(paramc.getAppId(), str1, str2, str3, l1, l2, (String)localObject);
        }
      }
      i += 1;
    }
    paramc.C(paramInt, h("ok", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.az
 * JD-Core Version:    0.7.0.1
 */