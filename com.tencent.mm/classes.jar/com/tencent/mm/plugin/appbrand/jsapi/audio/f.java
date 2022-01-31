package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public class f
  extends a
{
  public static final int CTRL_INDEX = 293;
  public static final String NAME = "getAudioState";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState data is null");
      paramc.C(paramInt, h("fail:data is null", null));
      return;
    }
    paramJSONObject = paramJSONObject.optString("audioId");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      y.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState audioId is empty");
      paramc.C(paramInt, h("fail:audioId is empty", null));
      return;
    }
    f.a locala = new f.a(this, paramc, paramInt);
    locala.appId = paramc.getAppId();
    locala.bFM = paramJSONObject;
    locala.ahU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.f
 * JD-Core Version:    0.7.0.1
 */