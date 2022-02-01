package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public class g
  extends a
{
  public static final int CTRL_INDEX = 293;
  public static final String NAME = "getAudioState";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145711);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState data is null");
      paramc.h(paramInt, e("fail:data is null", null));
      AppMethodBeat.o(145711);
      return;
    }
    paramJSONObject = paramJSONObject.optString("audioId");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      ad.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState audioId is empty");
      paramc.h(paramInt, e("fail:audioId is empty", null));
      AppMethodBeat.o(145711);
      return;
    }
    g.a locala = new g.a(this, paramc, paramInt);
    locala.appId = paramc.getAppId();
    locala.cTr = paramJSONObject;
    locala.aEC();
    AppMethodBeat.o(145711);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.g
 * JD-Core Version:    0.7.0.1
 */