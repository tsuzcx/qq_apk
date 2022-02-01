package com.tencent.mm.plugin.appbrand.jsapi.aa.c.a.a;

import com.tencent.luggage.k.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 817;
  public static final String NAME = "operateXWebLivePlayerBackground";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(195095);
    paramJSONObject = new b(paramInt, paramJSONObject, paramc, this);
    Object localObject = e.g(paramJSONObject);
    if (localObject == null)
    {
      ad.w("MicroMsg.AppBrand.JsApiOperateXWebLivePlayerBackground", "audioOfVideoBackgroundPlayManager is null");
      paramc.h(paramInt, e("fail:audioOfVideoBackgroundPlayManager is null", null));
      AppMethodBeat.o(195095);
      return;
    }
    localObject = ((com.tencent.mm.plugin.appbrand.jsapi.aa.a)localObject).beS();
    if (localObject == null)
    {
      ad.w("MicroMsg.AppBrand.JsApiOperateXWebLivePlayerBackground", "videoPlayer is null");
      paramc.h(paramInt, e("fail:videoPlayer is null", null));
      AppMethodBeat.o(195095);
      return;
    }
    if (!(localObject instanceof com.tencent.luggage.k.a.a.a.a.a))
    {
      ad.w("MicroMsg.AppBrand.JsApiOperateXWebLivePlayerBackground", "videoPlayer is not LivePlayerPluginHandler");
      paramc.h(paramInt, e("fail:videoPlayer is not for XWebLivePlayer", null));
      AppMethodBeat.o(195095);
      return;
    }
    ((com.tencent.luggage.k.a.a.a.a.a)localObject).i(paramJSONObject);
    AppMethodBeat.o(195095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.c.a.a.g
 * JD-Core Version:    0.7.0.1
 */