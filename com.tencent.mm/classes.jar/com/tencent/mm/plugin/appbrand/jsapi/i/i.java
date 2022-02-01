package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor;
import com.tencent.mm.plugin.appbrand.backgroundrunning.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class i
  extends j
{
  private static final int CTRL_INDEX = 586;
  private static final String NAME = "enableLocationUpdateBackground";
  
  public final void b(com.tencent.mm.plugin.appbrand.s params, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46378);
    this.lXb = ((s)params.aw(s.class));
    if ((this.lXb instanceof t))
    {
      localObject = (t)this.lXb;
      if ((((s)localObject).kYn) && (((s)localObject).lXu))
      {
        Log.i("MicroMsg.JsApiEnableLocationUpdateBackgroundWxImp", "already in location background mode");
        params.i(paramInt, h("ok", null));
        AppMethodBeat.o(46378);
        return;
      }
    }
    Object localObject = (IPCInteger)XIPCInvoker.a(MainProcessIPCService.dkO, new IPCVoid(), a.class);
    AppBrandGlobalSystemConfig localAppBrandGlobalSystemConfig = AppBrandGlobalSystemConfig.bzP();
    if ((localObject != null) && (((IPCInteger)localObject).value >= localAppBrandGlobalSystemConfig.lcK))
    {
      Log.w("MicroMsg.JsApiEnableLocationUpdateBackgroundWxImp", "enableLocationBackground: fail reach max concurrent background count");
      params.i(paramInt, h("fail reach max concurrent background count", null));
      AppMethodBeat.o(46378);
      return;
    }
    super.b(params, paramJSONObject, paramInt);
    if (!(this.lXb instanceof t))
    {
      Log.w("MicroMsg.JsApiEnableLocationUpdateBackgroundWxImp", "state manager not RuntimeLocationUpdateStateManagerWxa");
      params.i(paramInt, h("fail:system error", null));
      AppMethodBeat.o(46378);
      return;
    }
    if ((this.lXb != null) && (this.lXb.lXu)) {
      AppBrandBackgroundRunningMonitor.a(params, 1, c.kYp.beL);
    }
    AppMethodBeat.o(46378);
  }
  
  static class a
    implements k<IPCVoid, IPCInteger>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.i
 * JD-Core Version:    0.7.0.1
 */