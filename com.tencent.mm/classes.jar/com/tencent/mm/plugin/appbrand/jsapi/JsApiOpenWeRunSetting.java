package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import org.json.JSONObject;

public final class JsApiOpenWeRunSetting
  extends a
{
  public static final int CTRL_INDEX = 228;
  public static final String NAME = "openWeRunSetting";
  private JsApiOpenWeRunSetting.OpenWeRunSetting ggO;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    boolean bool = true;
    if (paramJSONObject != null) {
      bool = paramJSONObject.optBoolean("checkSupport", true);
    }
    this.ggO = new JsApiOpenWeRunSetting.OpenWeRunSetting(this, paramc, paramInt, bool);
    this.ggO.ahC();
    AppBrandMainProcessService.a(this.ggO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting
 * JD-Core Version:    0.7.0.1
 */