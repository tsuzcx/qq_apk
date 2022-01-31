package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

final class i$1
  implements f
{
  i$1(i parami, u.b paramb) {}
  
  public final void aP(String paramString, int paramInt)
  {
    String str = this.giE.getString("appId", "");
    int i = this.giE.getInt("pkgType", 0);
    if (((!str.equals(paramString)) || (i != paramInt)) && (this.giE.ik("operateBackgroundAudio#isPlaying")) && (g.qC(str) != g.a.fxU))
    {
      y.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "onStickyBannerChanged, pause the music");
      paramString = new JSONObject();
    }
    try
    {
      paramString.put("operationType", "pause");
      label85:
      JsApiOperateBackgroundAudio.OperateBackgroundAudioTask localOperateBackgroundAudioTask = new JsApiOperateBackgroundAudio.OperateBackgroundAudioTask(this.giF, this.giF.giA.ggu, this.giF.giA.gfg);
      localOperateBackgroundAudioTask.giD = paramString.toString();
      localOperateBackgroundAudioTask.appId = str;
      AppBrandMainProcessService.a(localOperateBackgroundAudioTask);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label85;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.i.1
 * JD-Core Version:    0.7.0.1
 */