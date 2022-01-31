package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.menu.MenuDelegate_EnableDebug;
import org.json.JSONObject;

public final class ax
  extends a
{
  public static final int CTRL_INDEX = 249;
  public static final String NAME = "setEnableDebug";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    boolean bool = paramJSONObject.optBoolean("enableDebug", false);
    if (((com.tencent.mm.plugin.appbrand.config.i)paramc.D(com.tencent.mm.plugin.appbrand.config.i.class)).fPN == bool)
    {
      paramc.C(paramInt, h("ok", null));
      return;
    }
    MenuDelegate_EnableDebug.e(paramc.getContext(), paramc.getAppId(), bool);
    paramc.C(paramInt, h("ok", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ax
 * JD-Core Version:    0.7.0.1
 */