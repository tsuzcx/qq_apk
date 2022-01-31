package com.tencent.mm.plugin.appbrand.jsapi.r;

import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import org.json.JSONObject;

public final class c
  extends a
{
  private static final int CTRL_INDEX = 241;
  private static final String NAME = "setTopBarText";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = paramJSONObject.optString("text");
    AppBrandStickyBannerLogic.a.cg(paramc.getAppId(), paramJSONObject);
    paramc.C(paramInt, h("ok", null));
    g.a(paramc.getAppId(), new g.b()
    {
      public final void onDestroy()
      {
        AppBrandStickyBannerLogic.a.cg(paramc.getAppId(), "");
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.c
 * JD-Core Version:    0.7.0.1
 */