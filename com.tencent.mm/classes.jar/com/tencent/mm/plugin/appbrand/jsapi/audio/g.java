package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class g
  extends d
{
  public static final int CTRL_INDEX = 290;
  public static final String NAME = "destroyAudioInstance";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145708);
    a(paramf, paramJSONObject, paramInt, paramf.getJsRuntime());
    AppMethodBeat.o(145708);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt, o paramo)
  {
    AppMethodBeat.i(256424);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "destroyAudioInstance fail, data is null");
      paramf.i(paramInt, h("fail:data is null", null));
      AppMethodBeat.o(256424);
      return;
    }
    Log.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "destroyAudioInstance data:%s", new Object[] { paramJSONObject.toString() });
    paramJSONObject = paramJSONObject.optString("audioId");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      Log.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "audioId is empty");
      paramf.i(paramInt, h("fail:audioId is empty", null));
      AppMethodBeat.o(256424);
      return;
    }
    paramo = new g.a(this, paramf, paramInt);
    paramo.appId = paramf.getAppId();
    paramo.dtX = paramJSONObject;
    paramo.bjm();
    c.lDH.Zm(paramf.getAppId()).remove(paramJSONObject);
    AppMethodBeat.o(256424);
  }
  
  public final boolean bEi()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.g
 * JD-Core Version:    0.7.0.1
 */