package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e
  extends com.tencent.mm.plugin.appbrand.jsapi.d
{
  public static final int CTRL_INDEX = 315;
  public static final String NAME = "stopWifi";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144693);
    Log.i("MicroMsg.JsApiStopWifi", "invoke registerHotspotHelper");
    paramJSONObject = paramf.getContext();
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiStopWifi", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramf.i(paramInt, n("fail:context is null", paramJSONObject));
      AppMethodBeat.o(144693);
      return;
    }
    if (!d.mHU)
    {
      Log.e("MicroMsg.JsApiStopWifi", "not invoke startWifi");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12000));
      paramf.i(paramInt, n("fail:not invoke startWifi", paramJSONObject));
      AppMethodBeat.o(144693);
      return;
    }
    if (d.mHV != null) {
      Log.i("MicroMsg.JsApiStopWifi", "unregisterReceiver");
    }
    try
    {
      paramJSONObject.unregisterReceiver(d.mHV);
      d.mHU = false;
      d.mHV = null;
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(0));
      paramf.i(paramInt, n("ok", paramJSONObject));
      AppMethodBeat.o(144693);
      return;
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        Log.e("MicroMsg.JsApiStopWifi", "unregisterReceiver:%s fail", new Object[] { paramJSONObject });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.e
 * JD-Core Version:    0.7.0.1
 */