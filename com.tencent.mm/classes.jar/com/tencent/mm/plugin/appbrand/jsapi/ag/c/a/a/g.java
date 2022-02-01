package com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a;

import com.tencent.luggage.xweb_ext.extendplugin.component.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class g
  extends d
{
  private static final int CTRL_INDEX = 817;
  public static final String NAME = "operateXWebLivePlayerBackground";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(215868);
    paramJSONObject = new b(paramInt, paramJSONObject, paramf, this);
    Object localObject = e.f(paramJSONObject);
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOperateXWebLivePlayerBackground", "audioOfVideoBackgroundPlayManager is null");
      paramf.i(paramInt, h("fail:audioOfVideoBackgroundPlayManager is null", null));
      AppMethodBeat.o(215868);
      return;
    }
    localObject = ((com.tencent.mm.plugin.appbrand.jsapi.ag.a)localObject).bLP();
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOperateXWebLivePlayerBackground", "videoPlayer is null");
      paramf.i(paramInt, h("fail:videoPlayer is null", null));
      AppMethodBeat.o(215868);
      return;
    }
    if (!(localObject instanceof com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a))
    {
      Log.w("MicroMsg.AppBrand.JsApiOperateXWebLivePlayerBackground", "videoPlayer is not LivePlayerPluginHandler");
      paramf.i(paramInt, h("fail:videoPlayer is not for XWebLivePlayer", null));
      AppMethodBeat.o(215868);
      return;
    }
    ((com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a)localObject).h(paramJSONObject);
    AppMethodBeat.o(215868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a.g
 * JD-Core Version:    0.7.0.1
 */