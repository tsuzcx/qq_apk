package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.v;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

public final class m
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 481;
  public static final String NAME = "setInnerAudioOption";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145774);
    boolean bool = paramJSONObject.optBoolean("mixWithOther", true);
    paramJSONObject = new com.tencent.mm.ai.a();
    paramJSONObject.htl = bool;
    ac.i("MicroMsg.AudioPlayerHelper", "setAudioContextOption, mixWithOther:%b", new Object[] { Boolean.valueOf(paramJSONObject.htl) });
    v localv = new v();
    localv.cZg.action = 19;
    localv.cZg.cZk = paramJSONObject;
    com.tencent.mm.plugin.music.b.a.a(localv);
    paramc.h(paramInt, e("ok", null));
    AppMethodBeat.o(145774);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.m
 * JD-Core Version:    0.7.0.1
 */