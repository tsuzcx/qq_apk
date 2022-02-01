package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.game.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/camera/JsApiInsertCameraWC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/camera/JsApiInsertCamera;", "()V", "invoke", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends l
{
  public static final m.a rQB;
  
  static
  {
    AppMethodBeat.i(325981);
    rQB = new m.a((byte)0);
    AppMethodBeat.o(325981);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(325983);
    s.u(paramf, "component");
    if (((paramf instanceof com.tencent.mm.plugin.appbrand.game.f.d)) || ((paramf instanceof c)))
    {
      Boolean localBoolean = ((com.tencent.mm.plugin.gamelive.d)h.az(com.tencent.mm.plugin.gamelive.d.class)).isGameLiving(paramf.getAppId(), ((n)paramf.aN(n.class)).qYY.qHO);
      s.s(localBoolean, "plugin(IPluginGameLive::…ass.java).appDebugType())");
      if (localBoolean.booleanValue())
      {
        Log.i("MicroMsg.JsApiInsertCameraWC", "is game living");
        paramf.callback(paramInt, ZP(s.X("fail: ", a.bt(paramf.getContext(), ba.i.appbrand_game_camera_is_in_live))));
        AppMethodBeat.o(325983);
        return;
      }
    }
    super.a(paramf, paramJSONObject, paramInt);
    AppMethodBeat.o(325983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.m
 * JD-Core Version:    0.7.0.1
 */