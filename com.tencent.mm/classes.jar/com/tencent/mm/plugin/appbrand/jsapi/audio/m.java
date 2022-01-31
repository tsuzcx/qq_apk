package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.h.a.s;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class m
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 481;
  public static final String NAME = "setInnerAudioOption";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    boolean bool = paramJSONObject.optBoolean("mixWithOther", true);
    paramc = new com.tencent.mm.af.a();
    paramc.eaM = bool;
    y.i("MicroMsg.AudioPlayerHelper", "setAudioContextOption, mixWithOther:%b", new Object[] { Boolean.valueOf(paramc.eaM) });
    paramJSONObject = new s();
    paramJSONObject.bFK.action = 19;
    paramJSONObject.bFK.bFP = paramc;
    com.tencent.mm.plugin.music.b.a.a(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.m
 * JD-Core Version:    0.7.0.1
 */