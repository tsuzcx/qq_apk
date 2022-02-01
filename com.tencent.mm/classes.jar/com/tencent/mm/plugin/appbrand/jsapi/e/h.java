package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
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
    this.jSl = ((q)paramq.as(q.class));
    if ((this.jSl instanceof r))
    {
      localObject = (r)this.jSl;
      if ((((q)localObject).iXN) && (((q)localObject).jSy))
      {
        ad.i("MicroMsg.JsApiEnableLocationUpdateBackgroundWxImp", "already in location background mode");
        paramq.h(paramInt, e("ok", null));
        AppMethodBeat.o(46378);
        return;
      }
    }
    Object localObject = (IPCInteger)XIPCInvoker.a("com.tencent.mm", new IPCVoid(), a.class);
    AppBrandGlobalSystemConfig localAppBrandGlobalSystemConfig = AppBrandGlobalSystemConfig.aTv();
    if ((localObject != null) && (((IPCInteger)localObject).value >= localAppBrandGlobalSystemConfig.jcj))
    {
      ad.w("MicroMsg.JsApiEnableLocationUpdateBackgroundWxImp", "enableLocationBackground: fail reach max concurrent background count");
      paramq.h(paramInt, e("fail reach max concurrent background count", null));
      AppMethodBeat.o(46378);
      return;
    }
    super.b(paramq, paramJSONObject, paramInt);
    if (!(this.jSl instanceof r))
    {
      ad.w("MicroMsg.JsApiEnableLocationUpdateBackgroundWxImp", "state manager not RuntimeLocationUpdateStateManagerWxa");
      paramq.h(paramInt, e("fail:system error", null));
      AppMethodBeat.o(46378);
      return;
    }
    if ((this.jSl != null) && (this.jSl.jSy)) {
      AppBrandBackgroundRunningMonitor.a(paramq, 1, d.iXP.aTC);
    }
    AppMethodBeat.o(46378);
  }
  
  static class a
    implements k<IPCVoid, IPCInteger>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.h
 * JD-Core Version:    0.7.0.1
 */