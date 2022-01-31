package com.tencent.mm.plugin.appbrand.jsapi;

import android.util.SparseArray;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.sdk.platformtools.bk;
import org.json.JSONArray;
import org.json.JSONObject;

final class ba
  extends a
{
  public static final int CTRL_INDEX = 215;
  public static final String NAME = "updatePerfData";
  private static final SparseArray<Integer> ghC = new SparseArray();
  
  ba()
  {
    ghC.put("firstRenderTime".hashCode(), Integer.valueOf(301));
    ghC.put("reRenderTime".hashCode(), Integer.valueOf(302));
    ghC.put("webview2AppServiceTotalTime".hashCode(), Integer.valueOf(402));
    ghC.put("webview2AppServiceDataSize".hashCode(), Integer.valueOf(403));
    ghC.put("webview2AppServiceNativeTime".hashCode(), Integer.valueOf(404));
    ghC.put("appService2WebviewTotalTime".hashCode(), Integer.valueOf(405));
    ghC.put("appService2WebviewDataSize".hashCode(), Integer.valueOf(406));
    ghC.put("appService2WebviewNativeTime".hashCode(), Integer.valueOf(407));
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = paramJSONObject.optJSONArray("dataArray");
    if ((!AppBrandPerformanceManager.vS(paramc.getAppId())) || (paramJSONObject == null))
    {
      paramc.C(paramInt, h("fail", null));
      return;
    }
    int i = 0;
    if (i < paramJSONObject.length())
    {
      Object localObject = paramJSONObject.optJSONObject(i);
      String str;
      if (localObject != null)
      {
        str = ((JSONObject)localObject).optString("key");
        localObject = ((JSONObject)localObject).optString("value");
        if (!bk.bl(str))
        {
          Integer localInteger = (Integer)ghC.get(str.hashCode());
          if (localInteger == null) {
            break label135;
          }
          AppBrandPerformanceManager.m(paramc.getAppId(), localInteger.intValue(), (String)localObject);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label135:
        AppBrandPerformanceManager.E(paramc.getAppId(), str, (String)localObject);
      }
    }
    paramc.C(paramInt, h("ok", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ba
 * JD-Core Version:    0.7.0.1
 */