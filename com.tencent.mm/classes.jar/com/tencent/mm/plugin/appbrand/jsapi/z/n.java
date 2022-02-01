package com.tencent.mm.plugin.appbrand.jsapi.z;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n
  extends d
{
  public static final int CTRL_INDEX = 535;
  public static final String NAME = "getVolume";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137672);
    Log.i("MicroMsg.JsApiGetVolume", "invoke JsApiGetVolume!");
    if (paramf == null)
    {
      Log.e("MicroMsg.JsApiGetVolume", "component is null");
      AppMethodBeat.o(137672);
      return;
    }
    paramJSONObject = paramf.getContext();
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiGetVolume", "fail:context is null");
      paramf.i(paramInt, h("fail:context is null", null));
      AppMethodBeat.o(137672);
      return;
    }
    if (!(paramJSONObject instanceof Activity))
    {
      Log.e("MicroMsg.JsApiGetVolume", "fail:context is not Activity");
      paramf.i(paramInt, h("fail:context is not Activity", null));
      AppMethodBeat.o(137672);
      return;
    }
    paramJSONObject = (AudioManager)paramJSONObject.getSystemService("audio");
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiGetVolume", "fail:manager is null");
      paramf.i(paramInt, h("fail:manager is null", null));
      AppMethodBeat.o(137672);
      return;
    }
    int i = paramJSONObject.getStreamVolume(3);
    int j = paramJSONObject.getStreamMaxVolume(3);
    Log.i("MicroMsg.JsApiGetVolume", "JsApiGetVolume %d/%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    paramJSONObject = new HashMap();
    paramJSONObject.put("currentVolume", Integer.valueOf(i));
    paramJSONObject.put("maxVolume", Integer.valueOf(j));
    paramf.i(paramInt, n("ok", paramJSONObject));
    AppMethodBeat.o(137672);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.n
 * JD-Core Version:    0.7.0.1
 */