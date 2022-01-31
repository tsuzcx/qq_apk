package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

final class h$1
  implements f
{
  h$1(h paramh, v.b paramb) {}
  
  public final void bf(String paramString, int paramInt)
  {
    AppMethodBeat.i(130711);
    String str = this.hBX.getString("appId", "");
    int i = this.hBX.getInt("pkgType", 0);
    if (((!str.equals(paramString)) || (i != paramInt)) && (this.hBX.oR("operateBackgroundAudio#isPlaying")) && (e.xY(str) != e.b.gOZ))
    {
      ab.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "onStickyBannerChanged, pause the music");
      paramString = new JSONObject();
    }
    try
    {
      paramString.put("operationType", "pause");
      label90:
      JsApiOperateBackgroundAudio.OperateBackgroundAudioTask localOperateBackgroundAudioTask = new JsApiOperateBackgroundAudio.OperateBackgroundAudioTask(this.hBY, this.hBY.hBT.hyO, this.hBY.hBT.hry);
      localOperateBackgroundAudioTask.hBW = paramString.toString();
      localOperateBackgroundAudioTask.appId = str;
      AppBrandMainProcessService.a(localOperateBackgroundAudioTask);
      AppMethodBeat.o(130711);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label90;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.h.1
 * JD-Core Version:    0.7.0.1
 */