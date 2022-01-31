package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.e.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

final class JsApiOperateMusicPlayer$2
  extends e.c
{
  JsApiOperateMusicPlayer$2(JsApiOperateMusicPlayer paramJsApiOperateMusicPlayer, v.b paramb, c paramc) {}
  
  public final void a(e.d paramd)
  {
    AppMethodBeat.i(130716);
    String str = this.hBX.getString("appId", "");
    this.hBX.getInt("pkgType", 0);
    switch (JsApiOperateMusicPlayer.3.gYU[paramd.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130716);
      return;
      int i = this.hxC.getRuntime().wS().bDh.scene;
      AppBrandStickyBannerLogic.a.aMM();
      if (i == 1023) {
        continue;
      }
      paramd = new JSONObject();
      try
      {
        paramd.put("operationType", "pause");
        label111:
        JsApiOperateMusicPlayer.OperateMusicPlayer localOperateMusicPlayer = new JsApiOperateMusicPlayer.OperateMusicPlayer(this.hCa, this.hxC, JsApiOperateMusicPlayer.OperateMusicPlayer.a(this.hCa.hBZ));
        localOperateMusicPlayer.jsonString = paramd.toString();
        localOperateMusicPlayer.cwc = str;
        localOperateMusicPlayer.hCb = this.hBX;
        AppBrandMainProcessService.a(localOperateMusicPlayer);
      }
      catch (JSONException localJSONException)
      {
        break label111;
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(130717);
    ab.d("MicroMsg.JsApiOperateMusicPlayer", "onDestroy");
    String str = this.hBX.getString("appId", "");
    this.hBX.getInt("pkgType", 0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("operationType", "stop");
      label52:
      JsApiOperateMusicPlayer.OperateMusicPlayer localOperateMusicPlayer = new JsApiOperateMusicPlayer.OperateMusicPlayer(this.hCa, this.hxC, JsApiOperateMusicPlayer.OperateMusicPlayer.a(this.hCa.hBZ));
      localOperateMusicPlayer.jsonString = localJSONObject.toString();
      localOperateMusicPlayer.cwc = str;
      localOperateMusicPlayer.action = -1;
      localOperateMusicPlayer.hCb = this.hBX;
      AppBrandMainProcessService.b(localOperateMusicPlayer);
      AppMethodBeat.o(130717);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label52;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.2
 * JD-Core Version:    0.7.0.1
 */