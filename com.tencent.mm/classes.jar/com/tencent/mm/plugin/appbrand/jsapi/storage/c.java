package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataParcel;
import com.tencent.mm.plugin.appbrand.backgroundfetch.h;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends a
{
  public static final int CTRL_INDEX = 522;
  public static final String NAME = "getBackgroundFetchData";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (paramc == null)
    {
      y.w("MicroMsg.JsApiGetBackgroundFetchData.javayhu", "fail:component is null");
      return;
    }
    if (paramJSONObject == null)
    {
      y.w("MicroMsg.JsApiGetBackgroundFetchData.javayhu", "fail:data is null");
      paramc.C(paramInt, h("fail:data is null", null));
      return;
    }
    Object localObject = paramJSONObject.optString("fetchType");
    if (bk.bl((String)localObject))
    {
      y.w("MicroMsg.JsApiGetBackgroundFetchData.javayhu", "fail:fetchType is null");
      paramc.C(paramInt, h("fail:fetchType is null", null));
      return;
    }
    paramJSONObject = paramc.getAppId();
    if (bk.bl(paramJSONObject))
    {
      y.w("MicroMsg.JsApiGetBackgroundFetchData.javayhu", "fail:appid is null");
      paramc.C(paramInt, h("fail:appid is null", null));
      return;
    }
    if (((String)localObject).equals("periodic")) {}
    for (int i = 1;; i = 0)
    {
      localObject = ((h)g.r(h.class)).aB(paramJSONObject, i);
      if (localObject != null) {
        break;
      }
      y.w("MicroMsg.JsApiGetBackgroundFetchData.javayhu", "worker fail:record is null");
      paramc.C(paramInt, h("fail:record is null", null));
      return;
    }
    if (((AppBrandBackgroundFetchDataParcel)localObject).data == null)
    {
      y.w("MicroMsg.JsApiGetBackgroundFetchData.javayhu", "worker fail:fetched data is null");
      paramc.C(paramInt, h("fail:fetched data is null", null));
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("fetchedData", ((AppBrandBackgroundFetchDataParcel)localObject).data);
    localHashMap.put("path", ((AppBrandBackgroundFetchDataParcel)localObject).path);
    localHashMap.put("query", ((AppBrandBackgroundFetchDataParcel)localObject).bVk);
    localHashMap.put("scene", Integer.valueOf(((AppBrandBackgroundFetchDataParcel)localObject).scene));
    localHashMap.put("timeStamp", Long.valueOf(((AppBrandBackgroundFetchDataParcel)localObject).updateTime));
    y.i("MicroMsg.JsApiGetBackgroundFetchData.javayhu", "JsApiGetBackgroundFetchData, app(%s_%d)", new Object[] { paramJSONObject, Integer.valueOf(i) });
    paramc.C(paramInt, h("ok", localHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.c
 * JD-Core Version:    0.7.0.1
 */