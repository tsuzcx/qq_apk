package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

final class JsApiOperateMusicPlayer$2
  extends g.b
{
  JsApiOperateMusicPlayer$2(JsApiOperateMusicPlayer paramJsApiOperateMusicPlayer, u.b paramb, p paramp) {}
  
  public final void a(g.c paramc)
  {
    String str = this.giE.getString("appId", "");
    this.giE.getInt("pkgType", 0);
    switch (JsApiOperateMusicPlayer.3.fGn[paramc.ordinal()])
    {
    }
    int i;
    do
    {
      return;
      i = this.gbW.getRuntime().aab().scene;
      AppBrandStickyBannerLogic.a.apw();
    } while (i == 1023);
    paramc = new JSONObject();
    try
    {
      paramc.put("operationType", "pause");
      label95:
      JsApiOperateMusicPlayer.OperateMusicPlayer localOperateMusicPlayer = new JsApiOperateMusicPlayer.OperateMusicPlayer(this.giH, this.gbW, JsApiOperateMusicPlayer.OperateMusicPlayer.a(this.giH.giG));
      localOperateMusicPlayer.bTX = paramc.toString();
      localOperateMusicPlayer.bOL = str;
      localOperateMusicPlayer.fVQ = this.giE;
      AppBrandMainProcessService.a(localOperateMusicPlayer);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label95;
    }
  }
  
  public final void onDestroy()
  {
    y.d("MicroMsg.JsApiOperateMusicPlayer", "onDestroy");
    String str = this.giE.getString("appId", "");
    this.giE.getInt("pkgType", 0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("operationType", "stop");
      label47:
      JsApiOperateMusicPlayer.OperateMusicPlayer localOperateMusicPlayer = new JsApiOperateMusicPlayer.OperateMusicPlayer(this.giH, this.gbW, JsApiOperateMusicPlayer.OperateMusicPlayer.a(this.giH.giG));
      localOperateMusicPlayer.bTX = localJSONObject.toString();
      localOperateMusicPlayer.bOL = str;
      localOperateMusicPlayer.action = -1;
      localOperateMusicPlayer.fVQ = this.giE;
      AppBrandMainProcessService.b(localOperateMusicPlayer);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label47;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.2
 * JD-Core Version:    0.7.0.1
 */