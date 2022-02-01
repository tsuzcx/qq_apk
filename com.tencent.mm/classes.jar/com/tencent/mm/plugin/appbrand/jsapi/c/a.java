package com.tencent.mm.plugin.appbrand.jsapi.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class a
  extends az
{
  private static final int CTRL_INDEX = -2;
  private static final String NAME = "onUpdateWXConfig";
  
  public final void i(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppMethodBeat.i(251359);
    try
    {
      o("opConfig", new JSONObject(paramString)).j(paramAppBrandRuntime.QW()).bPO();
      AppMethodBeat.o(251359);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.JsEventOnUpdateWXConfig", "dispatchOpConfig(rt:%s), exception=%s", new Object[] { paramAppBrandRuntime.mAppId, paramString });
      AppMethodBeat.o(251359);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c.a
 * JD-Core Version:    0.7.0.1
 */