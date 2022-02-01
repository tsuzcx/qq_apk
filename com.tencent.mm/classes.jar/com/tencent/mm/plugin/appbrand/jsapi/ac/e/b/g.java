package com.tencent.mm.plugin.appbrand.jsapi.ac.e.b;

import com.tencent.luggage.xweb_ext.extendplugin.component.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 819;
  public static final String NAME = "operateXWebVideoBackground";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(186957);
    paramJSONObject = new b(paramInt, paramJSONObject, paramc, this);
    Object localObject = e.f(paramJSONObject);
    if (localObject == null)
    {
      ad.w("MicroMsg.AppBrand.JsApiOperateXWebVideoBackground", "audioOfVideoBackgroundPlayManager is null");
      paramc.h(paramInt, e("fail:audioOfVideoBackgroundPlayManager is null", null));
      AppMethodBeat.o(186957);
      return;
    }
    localObject = ((com.tencent.mm.plugin.appbrand.jsapi.ac.a)localObject).bpx();
    if (localObject == null)
    {
      ad.w("MicroMsg.AppBrand.JsApiOperateXWebVideoBackground", "videoPlayer is null");
      paramc.h(paramInt, e("fail:videoPlayer is null", null));
      AppMethodBeat.o(186957);
      return;
    }
    if (!(localObject instanceof com.tencent.luggage.xweb_ext.extendplugin.component.video.c))
    {
      ad.w("MicroMsg.AppBrand.JsApiOperateXWebVideoBackground", "videoPlayer is not VideoPluginHandler");
      paramc.h(paramInt, e("fail:videoPlayer is not for XwebVideo", null));
      AppMethodBeat.o(186957);
      return;
    }
    ((com.tencent.luggage.xweb_ext.extendplugin.component.video.c)localObject).h(paramJSONObject);
    AppMethodBeat.o(186957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.e.b.g
 * JD-Core Version:    0.7.0.1
 */