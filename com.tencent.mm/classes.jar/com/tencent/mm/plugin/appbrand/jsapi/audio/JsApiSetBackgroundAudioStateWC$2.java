package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

final class JsApiSetBackgroundAudioStateWC$2
  extends g.b
{
  JsApiSetBackgroundAudioStateWC$2(JsApiSetBackgroundAudioStateWC paramJsApiSetBackgroundAudioStateWC, u.b paramb) {}
  
  public final void onDestroy()
  {
    String str = this.giE.getString("appId", "");
    y.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "onDestroy, appId:%s", new Object[] { str });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("operationType", "stop");
      label44:
      JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask localSetBackgroundAudioStateTask = this.gjm.b(this.gjm, this.gjm.giA.ggu, this.gjm.giA.gfg);
      localSetBackgroundAudioStateTask.giD = localJSONObject.toString();
      localSetBackgroundAudioStateTask.appId = str;
      AppBrandMainProcessService.b(localSetBackgroundAudioStateTask);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label44;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioStateWC.2
 * JD-Core Version:    0.7.0.1
 */