package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class a
  extends bc
{
  private static final int CTRL_INDEX = -2;
  private static final String NAME = "onUpdateWXConfig";
  
  public final void i(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppMethodBeat.i(325696);
    try
    {
      w("opConfig", new JSONObject(paramString)).i(paramAppBrandRuntime.ari()).cpV();
      AppMethodBeat.o(325696);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.JsEventOnUpdateWXConfig", "dispatchOpConfig(rt:%s), exception=%s", new Object[] { paramAppBrandRuntime.mAppId, paramString });
      AppMethodBeat.o(325696);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.a
 * JD-Core Version:    0.7.0.1
 */