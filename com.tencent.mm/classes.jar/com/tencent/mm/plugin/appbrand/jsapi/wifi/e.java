package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(94378);
    ab.i("MicroMsg.JsApiStopWifi", "invoke registerHotspotHelper");
    paramJSONObject = paramc.getContext();
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiStopWifi", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.h(paramInt, j("fail:context is null", paramJSONObject));
      AppMethodBeat.o(94378);
      return;
    }
    if (!d.ihz)
    {
      ab.e("MicroMsg.JsApiStopWifi", "not invoke startWifi");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12000));
      paramc.h(paramInt, j("fail:not invoke startWifi", paramJSONObject));
      AppMethodBeat.o(94378);
      return;
    }
    if (d.ihA != null)
    {
      ab.i("MicroMsg.JsApiStopWifi", "unregisterReceiver");
      paramJSONObject.unregisterReceiver(d.ihA);
      d.ihz = false;
      d.ihA = null;
    }
    paramJSONObject = new HashMap();
    paramJSONObject.put("errCode", Integer.valueOf(0));
    paramc.h(paramInt, j("ok", paramJSONObject));
    AppMethodBeat.o(94378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.e
 * JD-Core Version:    0.7.0.1
 */