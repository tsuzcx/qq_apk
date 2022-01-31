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

final class JsApiSetBackgroundAudioStateWC$1
  implements f
{
  JsApiSetBackgroundAudioStateWC$1(JsApiSetBackgroundAudioStateWC paramJsApiSetBackgroundAudioStateWC, v.b paramb) {}
  
  public final void bf(String paramString, int paramInt)
  {
    AppMethodBeat.i(130761);
    String str = this.hBX.getString("appId", "");
    int i = this.hBX.getInt("pkgType", 0);
    if (((!str.equals(paramString)) || (i != paramInt)) && (this.hBX.oR("setBackgroundAudioState#isPlaying")) && (e.xY(str) != e.b.gOZ))
    {
      ab.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "onStickyBannerChanged, pause the music");
      paramString = new JSONObject();
    }
    try
    {
      paramString.put("operationType", "pause");
      label90:
      JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask localSetBackgroundAudioStateTask = this.hCG.b(this.hCG, this.hCG.hBT.hyO, this.hCG.hBT.hry);
      localSetBackgroundAudioStateTask.hBW = paramString.toString();
      localSetBackgroundAudioStateTask.appId = str;
      AppBrandMainProcessService.a(localSetBackgroundAudioStateTask);
      AppMethodBeat.o(130761);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label90;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioStateWC.1
 * JD-Core Version:    0.7.0.1
 */