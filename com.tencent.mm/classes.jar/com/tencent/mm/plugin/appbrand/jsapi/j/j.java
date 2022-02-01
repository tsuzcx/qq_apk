package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor;
import com.tencent.mm.plugin.appbrand.backgroundrunning.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class j
  extends k
{
  private static final int CTRL_INDEX = 586;
  private static final String NAME = "enableLocationUpdateBackground";
  
  public final void b(v paramv, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46378);
    this.oUM = ((t)paramv.av(t.class));
    if ((this.oUM instanceof u))
    {
      localObject = (u)this.oUM;
      if ((((t)localObject).nSz) && (((t)localObject).oVh))
      {
        Log.i("MicroMsg.JsApiEnableLocationUpdateBackgroundWxImp", "already in location background mode");
        paramv.j(paramInt, h("ok", null));
        AppMethodBeat.o(46378);
        return;
      }
    }
    Object localObject = (IPCInteger)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCVoid(), j.a.class);
    AppBrandGlobalSystemConfig localAppBrandGlobalSystemConfig = AppBrandGlobalSystemConfig.bLe();
    if ((localObject != null) && (((IPCInteger)localObject).value >= localAppBrandGlobalSystemConfig.nWT))
    {
      Log.w("MicroMsg.JsApiEnableLocationUpdateBackgroundWxImp", "enableLocationBackground: fail reach max concurrent background count");
      paramv.j(paramInt, h("fail reach max concurrent background count", null));
      AppMethodBeat.o(46378);
      return;
    }
    super.b(paramv, paramJSONObject, paramInt);
    if (!(this.oUM instanceof u))
    {
      Log.w("MicroMsg.JsApiEnableLocationUpdateBackgroundWxImp", "state manager not RuntimeLocationUpdateStateManagerWxa");
      paramv.j(paramInt, h("fail:system error", null));
      AppMethodBeat.o(46378);
      return;
    }
    if ((this.oUM != null) && (this.oUM.oVh)) {
      AppBrandBackgroundRunningMonitor.a(paramv, 1, c.nSB.aOm);
    }
    AppMethodBeat.o(46378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.j
 * JD-Core Version:    0.7.0.1
 */