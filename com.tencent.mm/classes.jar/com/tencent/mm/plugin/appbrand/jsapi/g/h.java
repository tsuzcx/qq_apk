package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor;
import com.tencent.mm.plugin.appbrand.backgroundrunning.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class h
  extends i
{
  private static final int CTRL_INDEX = 586;
  private static final String NAME = "enableLocationUpdateBackground";
  
  public final void b(com.tencent.mm.plugin.appbrand.q paramq, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46378);
    this.kOt = ((q)paramq.as(q.class));
    if ((this.kOt instanceof r))
    {
      localObject = (r)this.kOt;
      if ((((q)localObject).jSa) && (((q)localObject).kOG))
      {
        ad.i("MicroMsg.JsApiEnableLocationUpdateBackgroundWxImp", "already in location background mode");
        paramq.h(paramInt, e("ok", null));
        AppMethodBeat.o(46378);
        return;
      }
    }
    Object localObject = (IPCInteger)XIPCInvoker.a("com.tencent.mm", new IPCVoid(), h.a.class);
    AppBrandGlobalSystemConfig localAppBrandGlobalSystemConfig = AppBrandGlobalSystemConfig.bdT();
    if ((localObject != null) && (((IPCInteger)localObject).value >= localAppBrandGlobalSystemConfig.jWs))
    {
      ad.w("MicroMsg.JsApiEnableLocationUpdateBackgroundWxImp", "enableLocationBackground: fail reach max concurrent background count");
      paramq.h(paramInt, e("fail reach max concurrent background count", null));
      AppMethodBeat.o(46378);
      return;
    }
    super.b(paramq, paramJSONObject, paramInt);
    if (!(this.kOt instanceof r))
    {
      ad.w("MicroMsg.JsApiEnableLocationUpdateBackgroundWxImp", "state manager not RuntimeLocationUpdateStateManagerWxa");
      paramq.h(paramInt, e("fail:system error", null));
      AppMethodBeat.o(46378);
      return;
    }
    if ((this.kOt != null) && (this.kOt.kOG)) {
      AppBrandBackgroundRunningMonitor.a(paramq, 1, d.jSc.beO);
    }
    AppMethodBeat.o(46378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.h
 * JD-Core Version:    0.7.0.1
 */