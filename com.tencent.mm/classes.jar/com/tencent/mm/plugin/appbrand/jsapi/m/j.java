package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor;
import com.tencent.mm.plugin.appbrand.backgroundrunning.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class j
  extends k
{
  private static final int CTRL_INDEX = 586;
  private static final String NAME = "enableLocationUpdateBackground";
  
  public final void b(y paramy, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46378);
    this.rZZ = ((u)paramy.aO(u.class));
    if ((this.rZZ instanceof v))
    {
      localObject = (v)this.rZZ;
      if ((((u)localObject).qSk) && (((u)localObject).sax))
      {
        Log.i("MicroMsg.JsApiEnableLocationUpdateBackgroundWxImp", "already in location background mode");
        paramy.callback(paramInt, ZP("ok"));
        AppMethodBeat.o(46378);
        return;
      }
    }
    Object localObject = (IPCInteger)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCVoid(), j.a.class);
    AppBrandGlobalSystemConfig localAppBrandGlobalSystemConfig = AppBrandGlobalSystemConfig.ckD();
    if ((localObject != null) && (((IPCInteger)localObject).value >= localAppBrandGlobalSystemConfig.qWJ))
    {
      Log.w("MicroMsg.JsApiEnableLocationUpdateBackgroundWxImp", "enableLocationBackground: fail reach max concurrent background count");
      paramy.callback(paramInt, ZP("fail reach max concurrent background count"));
      AppMethodBeat.o(46378);
      return;
    }
    super.b(paramy, paramJSONObject, paramInt);
    if (!(this.rZZ instanceof v))
    {
      Log.w("MicroMsg.JsApiEnableLocationUpdateBackgroundWxImp", "state manager not RuntimeLocationUpdateStateManagerWxa");
      paramy.callback(paramInt, ZP("fail:system error"));
      AppMethodBeat.o(46378);
      return;
    }
    if ((this.rZZ != null) && (this.rZZ.sax)) {
      AppBrandBackgroundRunningMonitor.a(paramy, 1, c.qSm.cIi);
    }
    AppMethodBeat.o(46378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.j
 * JD-Core Version:    0.7.0.1
 */