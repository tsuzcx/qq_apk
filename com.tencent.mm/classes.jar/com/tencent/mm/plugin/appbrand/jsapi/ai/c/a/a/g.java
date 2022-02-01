package com.tencent.mm.plugin.appbrand.jsapi.ai.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class g
  extends c
{
  private static final int CTRL_INDEX = 817;
  public static final String NAME = "operateXWebLivePlayerBackground";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(223400);
    paramJSONObject = new com.tencent.mm.plugin.appbrand.h.b(paramInt, paramJSONObject, parame, this);
    Object localObject = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(paramJSONObject);
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOperateXWebLivePlayerBackground", "audioOfVideoBackgroundPlayManager is null");
      parame.j(paramInt, h("fail:audioOfVideoBackgroundPlayManager is null", null));
      AppMethodBeat.o(223400);
      return;
    }
    localObject = ((a)localObject).bYg();
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOperateXWebLivePlayerBackground", "videoPlayer is null");
      parame.j(paramInt, h("fail:videoPlayer is null", null));
      AppMethodBeat.o(223400);
      return;
    }
    if (!(localObject instanceof com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b))
    {
      Log.w("MicroMsg.AppBrand.JsApiOperateXWebLivePlayerBackground", "videoPlayer is not LivePlayerPluginHandler");
      parame.j(paramInt, h("fail:videoPlayer is not for XWebLivePlayer", null));
      AppMethodBeat.o(223400);
      return;
    }
    ((com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b)localObject).h(paramJSONObject);
    AppMethodBeat.o(223400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.c.a.a.g
 * JD-Core Version:    0.7.0.1
 */