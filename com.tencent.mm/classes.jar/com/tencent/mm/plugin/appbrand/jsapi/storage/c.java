package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataParcel;
import com.tencent.mm.plugin.appbrand.backgroundfetch.k;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
    AppMethodBeat.i(46819);
    if (paramc == null)
    {
      ad.w("MicroMsg.JsApiGetBackgroundFetchData", "fail:component is null");
      AppMethodBeat.o(46819);
      return;
    }
    if (paramJSONObject == null)
    {
      ad.w("MicroMsg.JsApiGetBackgroundFetchData", "fail:data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(46819);
      return;
    }
    Object localObject = paramJSONObject.optString("fetchType");
    if (bt.isNullOrNil((String)localObject))
    {
      ad.w("MicroMsg.JsApiGetBackgroundFetchData", "fail:fetchType is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(46819);
      return;
    }
    paramJSONObject = paramc.getAppId();
    if (bt.isNullOrNil(paramJSONObject))
    {
      ad.w("MicroMsg.JsApiGetBackgroundFetchData", "fail:appid is null");
      paramc.h(paramInt, e("fail:appID is empty", null));
      AppMethodBeat.o(46819);
      return;
    }
    if (((String)localObject).equals("periodic")) {}
    for (int i = 1; g.ab(k.class) == null; i = 0)
    {
      ad.w("MicroMsg.JsApiGetBackgroundFetchData", "worker fail:IAppBrandBackgroundFetchDataStorage is null");
      paramc.h(paramInt, e("fail:internal error", null));
      AppMethodBeat.o(46819);
      return;
    }
    localObject = ((k)g.ab(k.class)).bh(paramJSONObject, i);
    if (localObject == null)
    {
      ad.w("MicroMsg.JsApiGetBackgroundFetchData", "worker fail:record is null");
      paramc.h(paramInt, e("fail:record is null", null));
      AppMethodBeat.o(46819);
      return;
    }
    if (((AppBrandBackgroundFetchDataParcel)localObject).data == null)
    {
      ad.w("MicroMsg.JsApiGetBackgroundFetchData", "worker fail:fetched data is null");
      paramc.h(paramInt, e("fail:fetched data is null", null));
      AppMethodBeat.o(46819);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("fetchedData", ((AppBrandBackgroundFetchDataParcel)localObject).data);
    localHashMap.put("path", ((AppBrandBackgroundFetchDataParcel)localObject).path);
    localHashMap.put("query", ((AppBrandBackgroundFetchDataParcel)localObject).query);
    localHashMap.put("scene", Integer.valueOf(((AppBrandBackgroundFetchDataParcel)localObject).scene));
    localHashMap.put("timeStamp", Long.valueOf(((AppBrandBackgroundFetchDataParcel)localObject).fpL));
    ad.i("MicroMsg.JsApiGetBackgroundFetchData", "JsApiGetBackgroundFetchData, app(%s_%d)", new Object[] { paramJSONObject, Integer.valueOf(i) });
    paramc.h(paramInt, k("ok", localHashMap));
    AppMethodBeat.o(46819);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.c
 * JD-Core Version:    0.7.0.1
 */