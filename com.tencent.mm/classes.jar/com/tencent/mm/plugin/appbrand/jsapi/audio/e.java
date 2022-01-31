package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class e
  extends a
{
  public static final int CTRL_INDEX = 290;
  public static final String NAME = "destroyAudioInstance";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "destroyAudioInstance fail, data is null");
      paramc.C(paramInt, h("fail:data is null", null));
      return;
    }
    y.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "destroyAudioInstance data:%s", new Object[] { paramJSONObject.toString() });
    paramJSONObject = paramJSONObject.optString("audioId");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      y.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "audioId is empty");
      paramc.C(paramInt, h("fail:audioId is empty", null));
      return;
    }
    e.a locala = new e.a(this, paramc, paramInt);
    locala.appId = paramc.getAppId();
    locala.bFM = paramJSONObject;
    locala.ahU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.e
 * JD-Core Version:    0.7.0.1
 */