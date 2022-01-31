package com.tencent.mm.plugin.appbrand.jsapi.r;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h
  extends a
{
  public static final int CTRL_INDEX = 535;
  public static final String NAME = "getVolume";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(126417);
    ab.i("MicroMsg.JsApiGetVolume", "invoke JsApiGetVolume!");
    if (paramc == null)
    {
      ab.e("MicroMsg.JsApiGetVolume", "component is null");
      AppMethodBeat.o(126417);
      return;
    }
    paramJSONObject = paramc.getContext();
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiGetVolume", "fail:context is null");
      paramc.h(paramInt, j("fail:context is null", null));
      AppMethodBeat.o(126417);
      return;
    }
    if (!(paramJSONObject instanceof Activity))
    {
      ab.e("MicroMsg.JsApiGetVolume", "fail:context is not Activity");
      paramc.h(paramInt, j("fail:context is not Activity", null));
      AppMethodBeat.o(126417);
      return;
    }
    paramJSONObject = (AudioManager)paramJSONObject.getSystemService("audio");
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiGetVolume", "fail:manager is null");
      paramc.h(paramInt, j("fail:manager is null", null));
      AppMethodBeat.o(126417);
      return;
    }
    int i = paramJSONObject.getStreamVolume(3);
    int j = paramJSONObject.getStreamMaxVolume(3);
    ab.i("MicroMsg.JsApiGetVolume", "JsApiGetVolume %d/%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    paramJSONObject = new HashMap();
    paramJSONObject.put("currentVolume", Integer.valueOf(i));
    paramJSONObject.put("maxVolume", Integer.valueOf(j));
    paramc.h(paramInt, j("ok", paramJSONObject));
    AppMethodBeat.o(126417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.h
 * JD-Core Version:    0.7.0.1
 */