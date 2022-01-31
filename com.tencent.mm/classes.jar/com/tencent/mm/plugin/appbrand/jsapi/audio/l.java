package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.s;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class l
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 481;
  public static final String NAME = "setInnerAudioOption";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137794);
    boolean bool = paramJSONObject.optBoolean("mixWithOther", true);
    paramJSONObject = new com.tencent.mm.ag.a();
    paramJSONObject.fqV = bool;
    ab.i("MicroMsg.AudioPlayerHelper", "setAudioContextOption, mixWithOther:%b", new Object[] { Boolean.valueOf(paramJSONObject.fqV) });
    s locals = new s();
    locals.cmS.action = 19;
    locals.cmS.cmW = paramJSONObject;
    com.tencent.mm.plugin.music.b.a.a(locals);
    paramc.h(paramInt, j("ok", null));
    AppMethodBeat.o(137794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.l
 * JD-Core Version:    0.7.0.1
 */