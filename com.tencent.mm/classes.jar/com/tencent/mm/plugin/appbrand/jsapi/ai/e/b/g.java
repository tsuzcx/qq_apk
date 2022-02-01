package com.tencent.mm.plugin.appbrand.jsapi.ai.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.ai.a;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  private static final int CTRL_INDEX = 819;
  public static final String NAME = "operateXWebVideoBackground";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(224737);
    paramJSONObject = new b(paramInt, paramJSONObject, parame, this);
    Object localObject = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(paramJSONObject);
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOperateXWebVideoBackground", "audioOfVideoBackgroundPlayManager is null");
      parame.j(paramInt, h("fail:audioOfVideoBackgroundPlayManager is null", null));
      AppMethodBeat.o(224737);
      return;
    }
    localObject = ((a)localObject).bYg();
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOperateXWebVideoBackground", "videoPlayer is null");
      parame.j(paramInt, h("fail:videoPlayer is null", null));
      AppMethodBeat.o(224737);
      return;
    }
    if (!(localObject instanceof com.tencent.luggage.xweb_ext.extendplugin.component.video.c))
    {
      Log.w("MicroMsg.AppBrand.JsApiOperateXWebVideoBackground", "videoPlayer is not VideoPluginHandler");
      parame.j(paramInt, h("fail:videoPlayer is not for XwebVideo", null));
      AppMethodBeat.o(224737);
      return;
    }
    ((com.tencent.luggage.xweb_ext.extendplugin.component.video.c)localObject).h(paramJSONObject);
    AppMethodBeat.o(224737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.e.b.g
 * JD-Core Version:    0.7.0.1
 */