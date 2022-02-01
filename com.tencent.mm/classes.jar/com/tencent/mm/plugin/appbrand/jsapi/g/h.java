package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor;
import com.tencent.mm.plugin.appbrand.backgroundrunning.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public final class h
  extends i
{
  private static final int CTRL_INDEX = 586;
  private static final String NAME = "enableLocationUpdateBackground";
  
  public final void b(com.tencent.mm.plugin.appbrand.r paramr, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46378);
    this.kRV = ((r)paramr.as(r.class));
    if ((this.kRV instanceof s))
    {
      localObject = (s)this.kRV;
      if ((((r)localObject).jVr) && (((r)localObject).kSo))
      {
        ae.i("MicroMsg.JsApiEnableLocationUpdateBackgroundWxImp", "already in location background mode");
        paramr.h(paramInt, e("ok", null));
        AppMethodBeat.o(46378);
        return;
      }
    }
    Object localObject = (IPCInteger)XIPCInvoker.a("com.tencent.mm", new IPCVoid(), a.class);
    AppBrandGlobalSystemConfig localAppBrandGlobalSystemConfig = AppBrandGlobalSystemConfig.bez();
    if ((localObject != null) && (((IPCInteger)localObject).value >= localAppBrandGlobalSystemConfig.jZH))
    {
      ae.w("MicroMsg.JsApiEnableLocationUpdateBackgroundWxImp", "enableLocationBackground: fail reach max concurrent background count");
      paramr.h(paramInt, e("fail reach max concurrent background count", null));
      AppMethodBeat.o(46378);
      return;
    }
    super.b(paramr, paramJSONObject, paramInt);
    if (!(this.kRV instanceof s))
    {
      ae.w("MicroMsg.JsApiEnableLocationUpdateBackgroundWxImp", "state manager not RuntimeLocationUpdateStateManagerWxa");
      paramr.h(paramInt, e("fail:system error", null));
      AppMethodBeat.o(46378);
      return;
    }
    if ((this.kRV != null) && (this.kRV.kSo)) {
      AppBrandBackgroundRunningMonitor.a(paramr, 1, c.jVt.beO);
    }
    AppMethodBeat.o(46378);
  }
  
  static class a
    implements k<IPCVoid, IPCInteger>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.h
 * JD-Core Version:    0.7.0.1
 */