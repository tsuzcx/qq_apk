package com.tencent.mm.plugin.appbrand.jsapi.u;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k
  extends a
{
  public static final int CTRL_INDEX = 535;
  public static final String NAME = "getVolume";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137672);
    ac.i("MicroMsg.JsApiGetVolume", "invoke JsApiGetVolume!");
    if (paramc == null)
    {
      ac.e("MicroMsg.JsApiGetVolume", "component is null");
      AppMethodBeat.o(137672);
      return;
    }
    paramJSONObject = paramc.getContext();
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.JsApiGetVolume", "fail:context is null");
      paramc.h(paramInt, e("fail:context is null", null));
      AppMethodBeat.o(137672);
      return;
    }
    if (!(paramJSONObject instanceof Activity))
    {
      ac.e("MicroMsg.JsApiGetVolume", "fail:context is not Activity");
      paramc.h(paramInt, e("fail:context is not Activity", null));
      AppMethodBeat.o(137672);
      return;
    }
    paramJSONObject = (AudioManager)paramJSONObject.getSystemService("audio");
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.JsApiGetVolume", "fail:manager is null");
      paramc.h(paramInt, e("fail:manager is null", null));
      AppMethodBeat.o(137672);
      return;
    }
    int i = paramJSONObject.getStreamVolume(3);
    int j = paramJSONObject.getStreamMaxVolume(3);
    ac.i("MicroMsg.JsApiGetVolume", "JsApiGetVolume %d/%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    paramJSONObject = new HashMap();
    paramJSONObject.put("currentVolume", Integer.valueOf(i));
    paramJSONObject.put("maxVolume", Integer.valueOf(j));
    paramc.h(paramInt, k("ok", paramJSONObject));
    AppMethodBeat.o(137672);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.k
 * JD-Core Version:    0.7.0.1
 */