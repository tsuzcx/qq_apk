package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataParcel;
import com.tencent.mm.plugin.appbrand.backgroundfetch.k;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.c
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
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(46819);
      return;
    }
    Object localObject = paramJSONObject.optString("fetchType");
    if (Util.isNullOrNil((String)localObject))
    {
      Log.w("MicroMsg.JsApiGetBackgroundFetchData", "fail:fetchType is null");
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(46819);
      return;
    }
    paramJSONObject = paramf.getAppId();
    if (Util.isNullOrNil(paramJSONObject))
    {
      Log.w("MicroMsg.JsApiGetBackgroundFetchData", "fail:appid is null");
      paramf.callback(paramInt, ZP("fail:appID is empty"));
      AppMethodBeat.o(46819);
      return;
    }
    if (((String)localObject).equals("periodic")) {}
    for (int i = 1; h.ax(k.class) == null; i = 0)
    {
      Log.w("MicroMsg.JsApiGetBackgroundFetchData", "worker fail:IAppBrandBackgroundFetchDataStorage is null");
      paramf.callback(paramInt, ZP("fail:internal error"));
      AppMethodBeat.o(46819);
      return;
    }
    localObject = ((k)h.ax(k.class)).cg(paramJSONObject, i);
    if (localObject == null)
    {
      Log.w("MicroMsg.JsApiGetBackgroundFetchData", "worker fail:record is null");
      paramf.callback(paramInt, ZP("fail:record is null"));
      AppMethodBeat.o(46819);
      return;
    }
    if (((AppBrandBackgroundFetchDataParcel)localObject).data == null)
    {
      Log.w("MicroMsg.JsApiGetBackgroundFetchData", "worker fail:fetched data is null");
      paramf.callback(paramInt, ZP("fail:fetched data is null"));
      AppMethodBeat.o(46819);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("fetchedData", ((AppBrandBackgroundFetchDataParcel)localObject).data);
    localHashMap.put("path", ((AppBrandBackgroundFetchDataParcel)localObject).path);
    localHashMap.put("query", ((AppBrandBackgroundFetchDataParcel)localObject).query);
    localHashMap.put("scene", Integer.valueOf(((AppBrandBackgroundFetchDataParcel)localObject).scene));
    localHashMap.put("timeStamp", Long.valueOf(((AppBrandBackgroundFetchDataParcel)localObject).egK));
    Log.i("MicroMsg.JsApiGetBackgroundFetchData", "JsApiGetBackgroundFetchData, app(%s_%d)", new Object[] { paramJSONObject, Integer.valueOf(i) });
    paramf.callback(paramInt, m("ok", localHashMap));
    AppMethodBeat.o(46819);
  }
  
  public final boolean cpE()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.c
 * JD-Core Version:    0.7.0.1
 */