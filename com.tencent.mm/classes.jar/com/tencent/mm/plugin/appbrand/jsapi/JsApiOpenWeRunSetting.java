package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import org.json.JSONObject;

public final class JsApiOpenWeRunSetting
  extends a
{
  public static final int CTRL_INDEX = 228;
  public static final String NAME = "openWeRunSetting";
  private JsApiOpenWeRunSetting.OpenWeRunSetting hzo;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(130540);
    if (paramJSONObject != null) {
      bool = paramJSONObject.optBoolean("checkSupport", true);
    }
    this.hzo = new JsApiOpenWeRunSetting.OpenWeRunSetting(this, paramc, paramInt, bool);
    this.hzo.aBj();
    AppBrandMainProcessService.a(this.hzo);
    AppMethodBeat.o(130540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting
 * JD-Core Version:    0.7.0.1
 */