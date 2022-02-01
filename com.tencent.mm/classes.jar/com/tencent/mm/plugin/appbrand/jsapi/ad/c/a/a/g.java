package com.tencent.mm.plugin.appbrand.jsapi.ad.c.a.a;

import com.tencent.luggage.xweb_ext.extendplugin.component.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 817;
  public static final String NAME = "operateXWebLivePlayerBackground";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(220624);
    paramJSONObject = new b(paramInt, paramJSONObject, paramc, this);
    Object localObject = e.f(paramJSONObject);
    if (localObject == null)
    {
      ae.w("MicroMsg.AppBrand.JsApiOperateXWebLivePlayerBackground", "audioOfVideoBackgroundPlayManager is null");
      paramc.h(paramInt, e("fail:audioOfVideoBackgroundPlayManager is null", null));
      AppMethodBeat.o(220624);
      return;
    }
    localObject = ((com.tencent.mm.plugin.appbrand.jsapi.ad.a)localObject).bqh();
    if (localObject == null)
    {
      ae.w("MicroMsg.AppBrand.JsApiOperateXWebLivePlayerBackground", "videoPlayer is null");
      paramc.h(paramInt, e("fail:videoPlayer is null", null));
      AppMethodBeat.o(220624);
      return;
    }
    if (!(localObject instanceof com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a))
    {
      ae.w("MicroMsg.AppBrand.JsApiOperateXWebLivePlayerBackground", "videoPlayer is not LivePlayerPluginHandler");
      paramc.h(paramInt, e("fail:videoPlayer is not for XWebLivePlayer", null));
      AppMethodBeat.o(220624);
      return;
    }
    ((com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a)localObject).h(paramJSONObject);
    AppMethodBeat.o(220624);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.c.a.a.g
 * JD-Core Version:    0.7.0.1
 */