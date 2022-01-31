package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

final class JsApiSetBackgroundAudioState$1
  extends g.b
{
  JsApiSetBackgroundAudioState$1(JsApiSetBackgroundAudioState paramJsApiSetBackgroundAudioState, u.b paramb, c paramc, int paramInt) {}
  
  public final void onDestroy()
  {
    String str = this.giE.getString("appId", "");
    y.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "onDestroy, appId:%s", new Object[] { str });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("operationType", "stop");
      label44:
      JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask localSetBackgroundAudioStateTask = new JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask(this.gjj, this.ggH, this.dIS);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState.1
 * JD-Core Version:    0.7.0.1
 */