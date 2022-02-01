package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.x;
import com.tencent.mm.g.a.x.b;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class n
  extends d
{
  public static final int CTRL_INDEX = 481;
  public static final String NAME = "setInnerAudioOption";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145774);
    String str = paramf.getAppId();
    Log.i("MicroMsg.Audio.JsApiSetInnerAudioOption", "data:%s, appId:%s", new Object[] { paramJSONObject, str });
    Log.i("MicroMsg.AudioPlayerHelper", "getAudioContextOption()");
    Object localObject = new x();
    ((x)localObject).dCQ.action = 20;
    com.tencent.mm.plugin.music.b.a.a((x)localObject);
    com.tencent.mm.ai.a locala = ((x)localObject).dCR.dCU;
    localObject = locala;
    if (locala == null) {
      localObject = new com.tencent.mm.ai.a();
    }
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(((com.tencent.mm.ai.a)localObject).appId)) && (!str.equalsIgnoreCase(((com.tencent.mm.ai.a)localObject).appId)))
    {
      ((com.tencent.mm.ai.a)localObject).reset();
      Log.i("MicroMsg.Audio.JsApiSetInnerAudioOption", "reset AudioContextParam");
    }
    ((com.tencent.mm.ai.a)localObject).appId = str;
    if (paramJSONObject.has("mixWithOther")) {
      ((com.tencent.mm.ai.a)localObject).iJC = paramJSONObject.optBoolean("mixWithOther", true);
    }
    if (paramJSONObject.has("speakerOn")) {
      ((com.tencent.mm.ai.a)localObject).dtE = paramJSONObject.optBoolean("speakerOn", true);
    }
    if (!((com.tencent.mm.ai.a)localObject).dtE) {
      ((com.tencent.mm.ai.a)localObject).iJC = false;
    }
    Log.i("MicroMsg.AudioPlayerHelper", "setAudioContextOption, mixWithOther:%b", new Object[] { Boolean.valueOf(((com.tencent.mm.ai.a)localObject).iJC) });
    paramJSONObject = new x();
    paramJSONObject.dCQ.action = 19;
    paramJSONObject.dCQ.dCU = ((com.tencent.mm.ai.a)localObject);
    com.tencent.mm.plugin.music.b.a.a(paramJSONObject);
    paramf.i(paramInt, h("ok", null));
    AppMethodBeat.o(145774);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.n
 * JD-Core Version:    0.7.0.1
 */