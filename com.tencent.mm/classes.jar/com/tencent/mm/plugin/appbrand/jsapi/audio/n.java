package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.v;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class n
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 481;
  public static final String NAME = "setInnerAudioOption";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145774);
    boolean bool = paramJSONObject.optBoolean("mixWithOther", true);
    paramJSONObject = new com.tencent.mm.aj.a();
    paramJSONObject.hLD = bool;
    ad.i("MicroMsg.AudioPlayerHelper", "setAudioContextOption, mixWithOther:%b", new Object[] { Boolean.valueOf(paramJSONObject.hLD) });
    v localv = new v();
    localv.dky.action = 19;
    localv.dky.dkC = paramJSONObject;
    com.tencent.mm.plugin.music.b.a.a(localv);
    paramc.h(paramInt, e("ok", null));
    AppMethodBeat.o(145774);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.n
 * JD-Core Version:    0.7.0.1
 */