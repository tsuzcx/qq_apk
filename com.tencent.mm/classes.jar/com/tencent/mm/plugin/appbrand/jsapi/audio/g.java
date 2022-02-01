package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 290;
  public static final String NAME = "destroyAudioInstance";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145708);
    a(paramc, paramJSONObject, paramInt, paramc.aYB());
    AppMethodBeat.o(145708);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt, o paramo)
  {
    AppMethodBeat.i(210895);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "destroyAudioInstance fail, data is null");
      paramc.h(paramInt, e("fail:data is null", null));
      AppMethodBeat.o(210895);
      return;
    }
    ae.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "destroyAudioInstance data:%s", new Object[] { paramJSONObject.toString() });
    paramJSONObject = paramJSONObject.optString("audioId");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      ae.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "audioId is empty");
      paramc.h(paramInt, e("fail:audioId is empty", null));
      AppMethodBeat.o(210895);
      return;
    }
    paramo = new g.a(this, paramc, paramInt);
    paramo.appId = paramc.getAppId();
    paramo.ddg = paramJSONObject;
    paramo.aPa();
    c.kzo.PS(paramc.getAppId()).remove(paramJSONObject);
    AppMethodBeat.o(210895);
  }
  
  public final boolean biS()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.g
 * JD-Core Version:    0.7.0.1
 */