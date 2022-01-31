package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class e
  extends a
{
  public static final int CTRL_INDEX = 290;
  public static final String NAME = "destroyAudioInstance";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137725);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "destroyAudioInstance fail, data is null");
      paramc.h(paramInt, j("fail:data is null", null));
      AppMethodBeat.o(137725);
      return;
    }
    ab.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "destroyAudioInstance data:%s", new Object[] { paramJSONObject.toString() });
    paramJSONObject = paramJSONObject.optString("audioId");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      ab.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "audioId is empty");
      paramc.h(paramInt, j("fail:audioId is empty", null));
      AppMethodBeat.o(137725);
      return;
    }
    e.a locala = new e.a(this, paramc, paramInt);
    locala.appId = paramc.getAppId();
    locala.ceu = paramJSONObject;
    locala.aBL();
    AppMethodBeat.o(137725);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.e
 * JD-Core Version:    0.7.0.1
 */