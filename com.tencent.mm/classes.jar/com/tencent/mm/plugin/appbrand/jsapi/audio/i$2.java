package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

final class i$2
  extends g.b
{
  i$2(i parami, u.b paramb) {}
  
  public final void onDestroy()
  {
    String str = this.giE.getString("appId", "");
    y.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "onDestroy, appId:%s", new Object[] { str });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("operationType", "stop");
      label44:
      JsApiOperateBackgroundAudio.OperateBackgroundAudioTask localOperateBackgroundAudioTask = new JsApiOperateBackgroundAudio.OperateBackgroundAudioTask(this.giF, this.giF.giA.ggu, this.giF.giA.gfg);
      localOperateBackgroundAudioTask.giD = localJSONObject.toString();
      localOperateBackgroundAudioTask.appId = str;
      AppBrandMainProcessService.b(localOperateBackgroundAudioTask);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label44;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.i.2
 * JD-Core Version:    0.7.0.1
 */