package com.tencent.mm.plugin.appbrand.jsapi.al.c.a.a;

import com.tencent.luggage.xweb_ext.extendplugin.component.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.al.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class g
  extends c
{
  private static final int CTRL_INDEX = 817;
  public static final String NAME = "operateXWebLivePlayerBackground";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(327141);
    paramJSONObject = new com.tencent.mm.plugin.appbrand.h.b(paramInt, paramJSONObject, paramf, this);
    Object localObject = e.f(paramJSONObject);
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOperateXWebLivePlayerBackground", "audioOfVideoBackgroundPlayManager is null");
      paramf.callback(paramInt, ZP("fail:audioOfVideoBackgroundPlayManager is null"));
      AppMethodBeat.o(327141);
      return;
    }
    localObject = ((a)localObject).cyw();
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOperateXWebLivePlayerBackground", "videoPlayer is null");
      paramf.callback(paramInt, ZP("fail:videoPlayer is null"));
      AppMethodBeat.o(327141);
      return;
    }
    if (!(localObject instanceof com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b))
    {
      Log.w("MicroMsg.AppBrand.JsApiOperateXWebLivePlayerBackground", "videoPlayer is not LivePlayerPluginHandler");
      paramf.callback(paramInt, ZP("fail:videoPlayer is not for XWebLivePlayer"));
      AppMethodBeat.o(327141);
      return;
    }
    ((com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b)localObject).h(paramJSONObject);
    AppMethodBeat.o(327141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.c.a.a.g
 * JD-Core Version:    0.7.0.1
 */