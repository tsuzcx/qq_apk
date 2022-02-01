package com.tencent.mm.plugin.appbrand.jsapi.z.e.b;

import com.tencent.luggage.k.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 819;
  public static final String NAME = "operateXWebVideoBackground";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(206769);
    paramJSONObject = new com.tencent.mm.plugin.appbrand.i.b(paramInt, paramJSONObject, paramc, this);
    Object localObject = e.f(paramJSONObject);
    if (localObject == null)
    {
      ac.w("MicroMsg.AppBrand.JsApiOperateXWebVideoBackground", "audioOfVideoBackgroundPlayManager is null");
      paramc.h(paramInt, e("fail:audioOfVideoBackgroundPlayManager is null", null));
      AppMethodBeat.o(206769);
      return;
    }
    localObject = ((com.tencent.mm.plugin.appbrand.jsapi.z.a)localObject).aXY();
    if (localObject == null)
    {
      ac.w("MicroMsg.AppBrand.JsApiOperateXWebVideoBackground", "videoPlayer is null");
      paramc.h(paramInt, e("fail:videoPlayer is null", null));
      AppMethodBeat.o(206769);
      return;
    }
    if (!(localObject instanceof com.tencent.luggage.k.a.a.b.b))
    {
      ac.w("MicroMsg.AppBrand.JsApiOperateXWebVideoBackground", "videoPlayer is not VideoPluginHandler");
      paramc.h(paramInt, e("fail:videoPlayer is not for XwebVideo", null));
      AppMethodBeat.o(206769);
      return;
    }
    ((com.tencent.luggage.k.a.a.b.b)localObject).h(paramJSONObject);
    AppMethodBeat.o(206769);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.e.b.g
 * JD-Core Version:    0.7.0.1
 */