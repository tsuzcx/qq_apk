package com.tencent.mm.plugin.appbrand.jsapi.al.e.b;

import com.tencent.luggage.xweb_ext.extendplugin.component.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.al.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  private static final int CTRL_INDEX = 819;
  public static final String NAME = "operateXWebVideoBackground";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(327176);
    paramJSONObject = new b(paramInt, paramJSONObject, paramf, this);
    Object localObject = e.f(paramJSONObject);
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOperateXWebVideoBackground", "audioOfVideoBackgroundPlayManager is null");
      paramf.callback(paramInt, ZP("fail:audioOfVideoBackgroundPlayManager is null"));
      AppMethodBeat.o(327176);
      return;
    }
    localObject = ((a)localObject).cyw();
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOperateXWebVideoBackground", "videoPlayer is null");
      paramf.callback(paramInt, ZP("fail:videoPlayer is null"));
      AppMethodBeat.o(327176);
      return;
    }
    if (!(localObject instanceof com.tencent.luggage.xweb_ext.extendplugin.component.video.c))
    {
      Log.w("MicroMsg.AppBrand.JsApiOperateXWebVideoBackground", "videoPlayer is not VideoPluginHandler");
      paramf.callback(paramInt, ZP("fail:videoPlayer is not for XwebVideo"));
      AppMethodBeat.o(327176);
      return;
    }
    ((com.tencent.luggage.xweb_ext.extendplugin.component.video.c)localObject).h(paramJSONObject);
    AppMethodBeat.o(327176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.e.b.g
 * JD-Core Version:    0.7.0.1
 */