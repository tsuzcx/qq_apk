package com.tencent.mm.plugin.appbrand.jsapi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import org.json.JSONObject;

public final class c
  extends a
{
  private static final int CTRL_INDEX = 241;
  private static final String NAME = "setTopBarText";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(131485);
    paramJSONObject = paramJSONObject.optString("text");
    AppBrandStickyBannerLogic.a.cV(paramc.getAppId(), paramJSONObject);
    paramc.h(paramInt, j("ok", null));
    e.a(paramc.getAppId(), new c.1(this, paramc));
    AppMethodBeat.o(131485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ui.c
 * JD-Core Version:    0.7.0.1
 */