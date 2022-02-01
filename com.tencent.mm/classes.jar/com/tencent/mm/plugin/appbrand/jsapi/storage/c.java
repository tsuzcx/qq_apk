package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataParcel;
import com.tencent.mm.plugin.appbrand.backgroundfetch.k;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends d
{
  public static final int CTRL_INDEX = 522;
  public static final String NAME = "getBackgroundFetchData";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46819);
    if (paramf == null)
    {
      Log.w("MicroMsg.JsApiGetBackgroundFetchData", "fail:component is null");
      AppMethodBeat.o(46819);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.JsApiGetBackgroundFetchData", "fail:data is null");
      paramf.i(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(46819);
      return;
    }
    Object localObject = paramJSONObject.optString("fetchType");
    if (Util.isNullOrNil((String)localObject))
    {
      Log.w("MicroMsg.JsApiGetBackgroundFetchData", "fail:fetchType is null");
      paramf.i(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(46819);
      return;
    }
    paramJSONObject = paramf.getAppId();
    if (Util.isNullOrNil(paramJSONObject))
    {
      Log.w("MicroMsg.JsApiGetBackgroundFetchData", "fail:appid is null");
      paramf.i(paramInt, h("fail:appID is empty", null));
      AppMethodBeat.o(46819);
      return;
    }
    if (((String)localObject).equals("periodic")) {}
    for (int i = 1; g.af(k.class) == null; i = 0)
    {
      Log.w("MicroMsg.JsApiGetBackgroundFetchData", "worker fail:IAppBrandBackgroundFetchDataStorage is null");
      paramf.i(paramInt, h("fail:internal error", null));
      AppMethodBeat.o(46819);
      return;
    }
    localObject = ((k)g.af(k.class)).bv(paramJSONObject, i);
    if (localObject == null)
    {
      Log.w("MicroMsg.JsApiGetBackgroundFetchData", "worker fail:record is null");
      paramf.i(paramInt, h("fail:record is null", null));
      AppMethodBeat.o(46819);
      return;
    }
    if (((AppBrandBackgroundFetchDataParcel)localObject).data == null)
    {
      Log.w("MicroMsg.JsApiGetBackgroundFetchData", "worker fail:fetched data is null");
      paramf.i(paramInt, h("fail:fetched data is null", null));
      AppMethodBeat.o(46819);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("fetchedData", ((AppBrandBackgroundFetchDataParcel)localObject).data);
    localHashMap.put("path", ((AppBrandBackgroundFetchDataParcel)localObject).path);
    localHashMap.put("query", ((AppBrandBackgroundFetchDataParcel)localObject).query);
    localHashMap.put("scene", Integer.valueOf(((AppBrandBackgroundFetchDataParcel)localObject).scene));
    localHashMap.put("timeStamp", Long.valueOf(((AppBrandBackgroundFetchDataParcel)localObject).crj));
    Log.i("MicroMsg.JsApiGetBackgroundFetchData", "JsApiGetBackgroundFetchData, app(%s_%d)", new Object[] { paramJSONObject, Integer.valueOf(i) });
    paramf.i(paramInt, n("ok", localHashMap));
    AppMethodBeat.o(46819);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.c
 * JD-Core Version:    0.7.0.1
 */