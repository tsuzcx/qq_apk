package com.tencent.mm.plugin.appbrand.jsapi.r;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import org.json.JSONObject;

public final class k
  extends a
{
  public static final int CTRL_INDEX = 229;
  public static final String NAME = "setScreenBrightness";
  float iaV = (0.0F / 0.0F);
  float iaW;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(126432);
    ab.d("MicroMsg.JsApiSetScreenBrightness", "JsApiSetScreenBrightness!");
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, j("fail:data is null", null));
      ab.e("MicroMsg.JsApiSetScreenBrightness", "data is null");
      AppMethodBeat.o(126432);
      return;
    }
    if (!(paramc.getContext() instanceof Activity))
    {
      ab.e("MicroMsg.JsApiSetScreenBrightness", "setScreenBrightness, server context is not activity, don't do invoke");
      paramc.h(paramInt, j("fail:context is not activity", null));
      AppMethodBeat.o(126432);
      return;
    }
    al.d(new k.1(this, paramJSONObject, paramc, paramInt));
    AppMethodBeat.o(126432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.k
 * JD-Core Version:    0.7.0.1
 */