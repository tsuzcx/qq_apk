package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import org.json.JSONObject;

public final class JsApiOpenWeRunSetting
  extends d
{
  public static final int CTRL_INDEX = 228;
  public static final String NAME = "openWeRunSetting";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(45601);
    if (paramJSONObject != null) {
      bool = paramJSONObject.optBoolean("checkSupport", true);
    }
    paramf = new JsApiOpenWeRunSetting.OpenWeRunSetting(this, paramf, paramInt, bool);
    paramf.bDJ();
    AppBrandMainProcessService.a(paramf);
    AppMethodBeat.o(45601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting
 * JD-Core Version:    0.7.0.1
 */