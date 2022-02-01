package com.tencent.mm.plugin.appbrand.jsapi.ag.e.b;

import com.tencent.luggage.xweb_ext.extendplugin.component.e;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.ag.a;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class g
  extends d
{
  private static final int CTRL_INDEX = 819;
  public static final String NAME = "operateXWebVideoBackground";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(215905);
    paramJSONObject = new b(paramInt, paramJSONObject, paramf, this);
    Object localObject = e.f(paramJSONObject);
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOperateXWebVideoBackground", "audioOfVideoBackgroundPlayManager is null");
      paramf.i(paramInt, h("fail:audioOfVideoBackgroundPlayManager is null", null));
      AppMethodBeat.o(215905);
      return;
    }
    localObject = ((a)localObject).bLP();
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOperateXWebVideoBackground", "videoPlayer is null");
      paramf.i(paramInt, h("fail:videoPlayer is null", null));
      AppMethodBeat.o(215905);
      return;
    }
    if (!(localObject instanceof c))
    {
      Log.w("MicroMsg.AppBrand.JsApiOperateXWebVideoBackground", "videoPlayer is not VideoPluginHandler");
      paramf.i(paramInt, h("fail:videoPlayer is not for XwebVideo", null));
      AppMethodBeat.o(215905);
      return;
    }
    ((c)localObject).h(paramJSONObject);
    AppMethodBeat.o(215905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.g
 * JD-Core Version:    0.7.0.1
 */