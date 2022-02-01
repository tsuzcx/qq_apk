package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.autogen.a.ab;
import com.tencent.mm.autogen.a.ab.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.music.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class p
  extends c
{
  public static final int CTRL_INDEX = 481;
  public static final String NAME = "setInnerAudioOption";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145774);
    String str = paramf.getAppId();
    Log.i("MicroMsg.Audio.JsApiSetInnerAudioOption", "data:%s, appId:%s", new Object[] { paramJSONObject, str });
    Log.i("MicroMsg.AudioPlayerHelper", "getAudioContextOption()");
    Object localObject = new ab();
    ((ab)localObject).hzS.action = 20;
    b.a((ab)localObject);
    a locala = ((ab)localObject).hzT.hzV;
    localObject = locala;
    if (locala == null) {
      localObject = new a();
    }
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(((a)localObject).appId)) && (!str.equalsIgnoreCase(((a)localObject).appId)))
    {
      ((a)localObject).reset();
      Log.i("MicroMsg.Audio.JsApiSetInnerAudioOption", "reset AudioContextParam");
    }
    ((a)localObject).appId = str;
    if (paramJSONObject.has("mixWithOther")) {
      ((a)localObject).orh = paramJSONObject.optBoolean("mixWithOther", true);
    }
    if (paramJSONObject.has("speakerOn")) {
      ((a)localObject).hqB = paramJSONObject.optBoolean("speakerOn", true);
    }
    if (!((a)localObject).hqB) {
      ((a)localObject).orh = false;
    }
    Log.i("MicroMsg.AudioPlayerHelper", "setAudioContextOption, mixWithOther:%b", new Object[] { Boolean.valueOf(((a)localObject).orh) });
    paramJSONObject = new ab();
    paramJSONObject.hzS.action = 19;
    paramJSONObject.hzS.hzV = ((a)localObject);
    b.a(paramJSONObject);
    paramf.callback(paramInt, ZP("ok"));
    AppMethodBeat.o(145774);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.p
 * JD-Core Version:    0.7.0.1
 */