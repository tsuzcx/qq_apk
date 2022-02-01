package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.v;
import com.tencent.mm.g.a.v.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public final class n
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 481;
  public static final String NAME = "setInnerAudioOption";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145774);
    String str = paramc.getAppId();
    ae.i("MicroMsg.Audio.JsApiSetInnerAudioOption", "data:%s, appId:%s", new Object[] { paramJSONObject, str });
    ae.i("MicroMsg.AudioPlayerHelper", "getAudioContextOption()");
    Object localObject = new v();
    ((v)localObject).dlA.action = 20;
    com.tencent.mm.plugin.music.b.a.a((v)localObject);
    com.tencent.mm.ai.a locala = ((v)localObject).dlB.dlE;
    localObject = locala;
    if (locala == null) {
      localObject = new com.tencent.mm.ai.a();
    }
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(((com.tencent.mm.ai.a)localObject).appId)) && (!str.equalsIgnoreCase(((com.tencent.mm.ai.a)localObject).appId)))
    {
      ((com.tencent.mm.ai.a)localObject).reset();
      ae.i("MicroMsg.Audio.JsApiSetInnerAudioOption", "reset AudioContextParam");
    }
    ((com.tencent.mm.ai.a)localObject).appId = str;
    if (paramJSONObject.has("mixWithOther")) {
      ((com.tencent.mm.ai.a)localObject).hOw = paramJSONObject.optBoolean("mixWithOther", true);
    }
    if (paramJSONObject.has("speakerOn")) {
      ((com.tencent.mm.ai.a)localObject).dcN = paramJSONObject.optBoolean("speakerOn", true);
    }
    if (!((com.tencent.mm.ai.a)localObject).dcN) {
      ((com.tencent.mm.ai.a)localObject).hOw = false;
    }
    ae.i("MicroMsg.AudioPlayerHelper", "setAudioContextOption, mixWithOther:%b", new Object[] { Boolean.valueOf(((com.tencent.mm.ai.a)localObject).hOw) });
    paramJSONObject = new v();
    paramJSONObject.dlA.action = 19;
    paramJSONObject.dlA.dlE = ((com.tencent.mm.ai.a)localObject);
    com.tencent.mm.plugin.music.b.a.a(paramJSONObject);
    paramc.h(paramInt, e("ok", null));
    AppMethodBeat.o(145774);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.n
 * JD-Core Version:    0.7.0.1
 */