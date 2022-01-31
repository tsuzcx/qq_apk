package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataParcel;
import com.tencent.mm.plugin.appbrand.backgroundfetch.k;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
    AppMethodBeat.i(131483);
    if (paramc == null)
    {
      ab.w("MicroMsg.JsApiGetBackgroundFetchData", "fail:component is null");
      AppMethodBeat.o(131483);
      return;
    }
    if (paramJSONObject == null)
    {
      ab.w("MicroMsg.JsApiGetBackgroundFetchData", "fail:data is null");
      paramc.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(131483);
      return;
    }
    Object localObject = paramJSONObject.optString("fetchType");
    if (bo.isNullOrNil((String)localObject))
    {
      ab.w("MicroMsg.JsApiGetBackgroundFetchData", "fail:fetchType is null");
      paramc.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(131483);
      return;
    }
    paramJSONObject = paramc.getAppId();
    if (bo.isNullOrNil(paramJSONObject))
    {
      ab.w("MicroMsg.JsApiGetBackgroundFetchData", "fail:appid is null");
      paramc.h(paramInt, j("fail:appID is empty", null));
      AppMethodBeat.o(131483);
      return;
    }
    if (((String)localObject).equals("periodic")) {}
    for (int i = 1; g.E(k.class) == null; i = 0)
    {
      ab.w("MicroMsg.JsApiGetBackgroundFetchData", "worker fail:IAppBrandBackgroundFetchDataStorage is null");
      paramc.h(paramInt, j("fail:internal error", null));
      AppMethodBeat.o(131483);
      return;
    }
    localObject = ((k)g.E(k.class)).aR(paramJSONObject, i);
    if (localObject == null)
    {
      ab.w("MicroMsg.JsApiGetBackgroundFetchData", "worker fail:record is null");
      paramc.h(paramInt, j("fail:record is null", null));
      AppMethodBeat.o(131483);
      return;
    }
    if (((AppBrandBackgroundFetchDataParcel)localObject).data == null)
    {
      ab.w("MicroMsg.JsApiGetBackgroundFetchData", "worker fail:fetched data is null");
      paramc.h(paramInt, j("fail:fetched data is null", null));
      AppMethodBeat.o(131483);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("fetchedData", ((AppBrandBackgroundFetchDataParcel)localObject).data);
    localHashMap.put("path", ((AppBrandBackgroundFetchDataParcel)localObject).path);
    localHashMap.put("query", ((AppBrandBackgroundFetchDataParcel)localObject).query);
    localHashMap.put("scene", Integer.valueOf(((AppBrandBackgroundFetchDataParcel)localObject).scene));
    localHashMap.put("timeStamp", Long.valueOf(((AppBrandBackgroundFetchDataParcel)localObject).updateTime));
    ab.i("MicroMsg.JsApiGetBackgroundFetchData", "JsApiGetBackgroundFetchData, app(%s_%d)", new Object[] { paramJSONObject, Integer.valueOf(i) });
    paramc.h(paramInt, j("ok", localHashMap));
    AppMethodBeat.o(131483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.c
 * JD-Core Version:    0.7.0.1
 */