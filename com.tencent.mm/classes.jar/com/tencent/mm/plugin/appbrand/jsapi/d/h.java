package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor;
import com.tencent.mm.plugin.appbrand.backgroundrunning.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

public final class h
  extends i
{
  private static final int CTRL_INDEX = 586;
  private static final String NAME = "enableLocationUpdateBackground";
  
  public final void b(com.tencent.mm.plugin.appbrand.q paramq, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46378);
    this.ksX = ((q)paramq.as(q.class));
    if ((this.ksX instanceof r))
    {
      localObject = (r)this.ksX;
      if ((((q)localObject).jyd) && (((q)localObject).ktk))
      {
        ac.i("MicroMsg.JsApiEnableLocationUpdateBackgroundWxImp", "already in location background mode");
        paramq.h(paramInt, e("ok", null));
        AppMethodBeat.o(46378);
        return;
      }
    }
    Object localObject = (IPCInteger)XIPCInvoker.a("com.tencent.mm", new IPCVoid(), a.class);
    AppBrandGlobalSystemConfig localAppBrandGlobalSystemConfig = AppBrandGlobalSystemConfig.bat();
    if ((localObject != null) && (((IPCInteger)localObject).value >= localAppBrandGlobalSystemConfig.jCw))
    {
      ac.w("MicroMsg.JsApiEnableLocationUpdateBackgroundWxImp", "enableLocationBackground: fail reach max concurrent background count");
      paramq.h(paramInt, e("fail reach max concurrent background count", null));
      AppMethodBeat.o(46378);
      return;
    }
    super.b(paramq, paramJSONObject, paramInt);
    if (!(this.ksX instanceof r))
    {
      ac.w("MicroMsg.JsApiEnableLocationUpdateBackgroundWxImp", "state manager not RuntimeLocationUpdateStateManagerWxa");
      paramq.h(paramInt, e("fail:system error", null));
      AppMethodBeat.o(46378);
      return;
    }
    if ((this.ksX != null) && (this.ksX.ktk)) {
      AppBrandBackgroundRunningMonitor.a(paramq, 1, d.jyf.aUu);
    }
    AppMethodBeat.o(46378);
  }
  
  static class a
    implements k<IPCVoid, IPCInteger>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.h
 * JD-Core Version:    0.7.0.1
 */