package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import org.json.JSONException;
import org.json.JSONObject;

final class JsApiOperateMusicPlayer$1
  implements f
{
  JsApiOperateMusicPlayer$1(JsApiOperateMusicPlayer paramJsApiOperateMusicPlayer, u.b paramb, p paramp) {}
  
  public final void aP(String paramString, int paramInt)
  {
    String str = this.giE.getString("appId", "");
    int i = this.giE.getInt("pkgType", 0);
    if (((!str.equals(paramString)) || (i != paramInt)) && (this.giE.ik("Music#isPlaying")) && (g.qC(str) != g.a.fxU)) {
      paramString = new JSONObject();
    }
    try
    {
      paramString.put("operationType", "pause");
      label78:
      JsApiOperateMusicPlayer.OperateMusicPlayer localOperateMusicPlayer = new JsApiOperateMusicPlayer.OperateMusicPlayer(this.giH, this.gbW, JsApiOperateMusicPlayer.OperateMusicPlayer.a(this.giH.giG));
      localOperateMusicPlayer.bTX = paramString.toString();
      localOperateMusicPlayer.bOL = str;
      localOperateMusicPlayer.fVQ = this.giE;
      AppBrandMainProcessService.a(localOperateMusicPlayer);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label78;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.1
 * JD-Core Version:    0.7.0.1
 */