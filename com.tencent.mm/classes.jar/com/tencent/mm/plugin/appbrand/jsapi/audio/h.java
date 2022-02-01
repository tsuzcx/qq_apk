package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class h
  extends d
{
  public static final int CTRL_INDEX = 293;
  public static final String NAME = "getAudioState";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145711);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState data is null");
      paramf.i(paramInt, h("fail:data is null", null));
      AppMethodBeat.o(145711);
      return;
    }
    paramJSONObject = paramJSONObject.optString("audioId");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      Log.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState audioId is empty");
      paramf.i(paramInt, h("fail:audioId is empty", null));
      AppMethodBeat.o(145711);
      return;
    }
    h.a locala = new h.a(this, paramf, paramInt);
    locala.appId = paramf.getAppId();
    locala.dtX = paramJSONObject;
    locala.bjm();
    AppMethodBeat.o(145711);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.h
 * JD-Core Version:    0.7.0.1
 */