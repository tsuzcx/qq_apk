package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public class f
  extends a
{
  public static final int CTRL_INDEX = 293;
  public static final String NAME = "getAudioState";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137728);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState data is null");
      paramc.h(paramInt, j("fail:data is null", null));
      AppMethodBeat.o(137728);
      return;
    }
    paramJSONObject = paramJSONObject.optString("audioId");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      ab.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState audioId is empty");
      paramc.h(paramInt, j("fail:audioId is empty", null));
      AppMethodBeat.o(137728);
      return;
    }
    f.a locala = new f.a(this, paramc, paramInt);
    locala.appId = paramc.getAppId();
    locala.ceu = paramJSONObject;
    locala.aBL();
    AppMethodBeat.o(137728);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.f
 * JD-Core Version:    0.7.0.1
 */