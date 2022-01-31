package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import org.json.JSONException;
import org.json.JSONObject;

final class JsApiOperateMusicPlayer$1
  implements f
{
  JsApiOperateMusicPlayer$1(JsApiOperateMusicPlayer paramJsApiOperateMusicPlayer, v.b paramb, c paramc) {}
  
  public final void bf(String paramString, int paramInt)
  {
    AppMethodBeat.i(130715);
    String str = this.hBX.getString("appId", "");
    int i = this.hBX.getInt("pkgType", 0);
    if (((!str.equals(paramString)) || (i != paramInt)) && (this.hBX.oR("Music#isPlaying")) && (e.xY(str) != e.b.gOZ)) {
      paramString = new JSONObject();
    }
    try
    {
      paramString.put("operationType", "pause");
      label83:
      JsApiOperateMusicPlayer.OperateMusicPlayer localOperateMusicPlayer = new JsApiOperateMusicPlayer.OperateMusicPlayer(this.hCa, this.hxC, JsApiOperateMusicPlayer.OperateMusicPlayer.a(this.hCa.hBZ));
      localOperateMusicPlayer.jsonString = paramString.toString();
      localOperateMusicPlayer.cwc = str;
      localOperateMusicPlayer.hCb = this.hBX;
      AppBrandMainProcessService.a(localOperateMusicPlayer);
      AppMethodBeat.o(130715);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label83;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.1
 * JD-Core Version:    0.7.0.1
 */