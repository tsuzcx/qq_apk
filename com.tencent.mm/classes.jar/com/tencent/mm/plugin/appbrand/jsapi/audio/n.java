package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.f.a.y;
import com.tencent.mm.f.a.y.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.music.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class n
  extends c
{
  public static final int CTRL_INDEX = 481;
  public static final String NAME = "setInnerAudioOption";
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145774);
    String str = parame.getAppId();
    Log.i("MicroMsg.Audio.JsApiSetInnerAudioOption", "data:%s, appId:%s", new Object[] { paramJSONObject, str });
    Log.i("MicroMsg.AudioPlayerHelper", "getAudioContextOption()");
    Object localObject = new y();
    ((y)localObject).fvx.action = 20;
    b.a((y)localObject);
    a locala = ((y)localObject).fvy.fvA;
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
      ((a)localObject).lzG = paramJSONObject.optBoolean("mixWithOther", true);
    }
    if (paramJSONObject.has("speakerOn")) {
      ((a)localObject).fmm = paramJSONObject.optBoolean("speakerOn", true);
    }
    if (!((a)localObject).fmm) {
      ((a)localObject).lzG = false;
    }
    Log.i("MicroMsg.AudioPlayerHelper", "setAudioContextOption, mixWithOther:%b", new Object[] { Boolean.valueOf(((a)localObject).lzG) });
    paramJSONObject = new y();
    paramJSONObject.fvx.action = 19;
    paramJSONObject.fvx.fvA = ((a)localObject);
    b.a(paramJSONObject);
    parame.j(paramInt, h("ok", null));
    AppMethodBeat.o(145774);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.n
 * JD-Core Version:    0.7.0.1
 */