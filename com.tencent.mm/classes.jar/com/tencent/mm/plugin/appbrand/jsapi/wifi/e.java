package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e
  extends a
{
  public static final int CTRL_INDEX = 315;
  public static final String NAME = "stopWifi";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144693);
    ac.i("MicroMsg.JsApiStopWifi", "invoke registerHotspotHelper");
    paramJSONObject = paramc.getContext();
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.JsApiStopWifi", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.h(paramInt, k("fail:context is null", paramJSONObject));
      AppMethodBeat.o(144693);
      return;
    }
    if (!d.kZg)
    {
      ac.e("MicroMsg.JsApiStopWifi", "not invoke startWifi");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12000));
      paramc.h(paramInt, k("fail:not invoke startWifi", paramJSONObject));
      AppMethodBeat.o(144693);
      return;
    }
    if (d.kZh != null) {
      ac.i("MicroMsg.JsApiStopWifi", "unregisterReceiver");
    }
    try
    {
      paramJSONObject.unregisterReceiver(d.kZh);
      d.kZg = false;
      d.kZh = null;
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(0));
      paramc.h(paramInt, k("ok", paramJSONObject));
      AppMethodBeat.o(144693);
      return;
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        ac.e("MicroMsg.JsApiStopWifi", "unregisterReceiver:%s fail", new Object[] { paramJSONObject });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.e
 * JD-Core Version:    0.7.0.1
 */