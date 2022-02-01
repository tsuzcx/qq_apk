package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.game.c;
import com.tencent.mm.plugin.appbrand.game.f.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/camera/JsApiInsertCameraWC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/camera/JsApiInsertCamera;", "()V", "invoke", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class m
  extends l
{
  public static final m.a oMF;
  
  static
  {
    AppMethodBeat.i(281561);
    oMF = new m.a((byte)0);
    AppMethodBeat.o(281561);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(281560);
    p.k(parame, "component");
    if (((parame instanceof d)) || ((parame instanceof c)))
    {
      Boolean localBoolean = ((com.tencent.mm.plugin.gamelive.e)h.ag(com.tencent.mm.plugin.gamelive.e.class)).isGameLiving(parame.getAppId(), ((com.tencent.mm.plugin.appbrand.config.l)parame.au(com.tencent.mm.plugin.appbrand.config.l.class)).bLq());
      p.j(localBoolean, "MMKernel.plugin(IPluginG…ass.java).appDebugType())");
      if (localBoolean.booleanValue())
      {
        Log.i("MicroMsg.JsApiInsertCameraWC", "is game living");
        parame.j(paramInt, agS("fail: " + a.ba(parame.getContext(), au.i.appbrand_game_camera_is_in_live)));
        AppMethodBeat.o(281560);
        return;
      }
    }
    super.a(parame, paramJSONObject, paramInt);
    AppMethodBeat.o(281560);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.m
 * JD-Core Version:    0.7.0.1
 */