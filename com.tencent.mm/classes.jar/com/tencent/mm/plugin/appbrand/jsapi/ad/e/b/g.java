package com.tencent.mm.plugin.appbrand.jsapi.ad.e.b;

import com.tencent.luggage.xweb_ext.extendplugin.component.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 819;
  public static final String NAME = "operateXWebVideoBackground";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(220655);
    paramJSONObject = new b(paramInt, paramJSONObject, paramc, this);
    Object localObject = e.f(paramJSONObject);
    if (localObject == null)
    {
      ae.w("MicroMsg.AppBrand.JsApiOperateXWebVideoBackground", "audioOfVideoBackgroundPlayManager is null");
      paramc.h(paramInt, e("fail:audioOfVideoBackgroundPlayManager is null", null));
      AppMethodBeat.o(220655);
      return;
    }
    localObject = ((com.tencent.mm.plugin.appbrand.jsapi.ad.a)localObject).bqh();
    if (localObject == null)
    {
      ae.w("MicroMsg.AppBrand.JsApiOperateXWebVideoBackground", "videoPlayer is null");
      paramc.h(paramInt, e("fail:videoPlayer is null", null));
      AppMethodBeat.o(220655);
      return;
    }
    if (!(localObject instanceof com.tencent.luggage.xweb_ext.extendplugin.component.video.c))
    {
      ae.w("MicroMsg.AppBrand.JsApiOperateXWebVideoBackground", "videoPlayer is not VideoPluginHandler");
      paramc.h(paramInt, e("fail:videoPlayer is not for XwebVideo", null));
      AppMethodBeat.o(220655);
      return;
    }
    ((com.tencent.luggage.xweb_ext.extendplugin.component.video.c)localObject).h(paramJSONObject);
    AppMethodBeat.o(220655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.e.b.g
 * JD-Core Version:    0.7.0.1
 */