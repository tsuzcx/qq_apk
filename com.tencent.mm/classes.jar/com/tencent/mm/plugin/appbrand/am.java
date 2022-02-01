package com.tencent.mm.plugin.appbrand;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.e.a;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/Loader;", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "loaderId", "", "parcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "instanceId", "", "callback", "Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "(ILcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;)V", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;)V", "bindRemoteService", "", "configWC", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "getKey", "run", "Companion", "plugin-appbrand-integration_release"})
final class am
  implements com.tencent.f.i.h
{
  @Deprecated
  public static final a kFa;
  private final int kEI;
  private final LaunchParcel kEX;
  private final String kEY;
  com.tencent.mm.plugin.appbrand.api.f kEZ;
  
  static
  {
    AppMethodBeat.i(227928);
    kFa = new a((byte)0);
    AppMethodBeat.o(227928);
  }
  
  public am(int paramInt, LaunchParcel paramLaunchParcel, String paramString, com.tencent.mm.plugin.appbrand.api.f paramf)
  {
    AppMethodBeat.i(227927);
    this.kEI = paramInt;
    this.kEX = paramLaunchParcel;
    this.kEY = paramString;
    this.kEZ = paramf;
    AppMethodBeat.o(227927);
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(227925);
    String str = "AppBrandPreRenderColdStartService.Loader-" + this.kEI;
    AppMethodBeat.o(227925);
    return str;
  }
  
  public final void run()
  {
    AppMethodBeat.i(227926);
    Log.i("MicroMsg.AppBrandPreRenderColdStartService.Loader", "run()-start, id:" + this.kEI + ", username:" + this.kEX.username + ", appId:" + this.kEX.appId + ", versionType:" + this.kEX.iOo + ", instanceId:" + this.kEY + ", path:" + this.kEX.kHw);
    com.tencent.mm.plugin.appbrand.launching.f localf = new com.tencent.mm.plugin.appbrand.launching.f(this.kEX, this.kEY, (e.a)new e(this), (com.tencent.mm.plugin.appbrand.launching.f.a)new f(this));
    localf.a(com.tencent.luggage.sdk.launching.b.cBC);
    localf.run();
    AppMethodBeat.o(227926);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/Loader$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/Loader$bindRemoteService$1", "Lcom/tencent/mm/ipcinvoker/IRemoteProcDied;", "onDied", "", "plugin-appbrand-integration_release"})
  public static final class b
    implements m
  {
    b(AtomicBoolean paramAtomicBoolean, String paramString) {}
    
    public final void aye()
    {
      AppMethodBeat.i(227915);
      am.btn();
      Log.e("MicroMsg.AppBrandPreRenderColdStartService.Loader", "bindRemoteService onRemoteProcess died, id:" + am.b(this.kFb));
      if (!this.kFc.getAndSet(true))
      {
        com.tencent.mm.plugin.appbrand.api.f localf = this.kFb.kEZ;
        if (localf != null) {
          com.tencent.mm.plugin.appbrand.api.f.a.a(localf, -5);
        }
      }
      com.tencent.mm.ipcinvoker.h.a(this.kFd, (m)this);
      AppMethodBeat.o(227915);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "data", "Lcom/tencent/mm/plugin/appbrand/BindRemoteServiceData;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/plugin/appbrand/BindRemoteServiceResult;", "invoke"})
  static final class c<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<BindRemoteServiceData, BindRemoteServiceResult>
  {
    public static final c kFe;
    
    static
    {
      AppMethodBeat.i(227919);
      kFe = new c();
      AppMethodBeat.o(227919);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/Loader$bindRemoteService$3", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallbackEx;", "Lcom/tencent/mm/plugin/appbrand/BindRemoteServiceResult;", "onBridgeNotFound", "", "onCallback", "data", "onCaughtInvokeException", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "plugin-appbrand-integration_release"})
  public static final class d
    implements e<BindRemoteServiceResult>
  {
    d(AtomicBoolean paramAtomicBoolean) {}
    
    public final void axY()
    {
      AppMethodBeat.i(227921);
      am.btn();
      Log.e("MicroMsg.AppBrandPreRenderColdStartService.Loader", "bindRemoteService onBridgeNotFound, id:" + am.b(this.kFb));
      com.tencent.mm.plugin.appbrand.api.f localf = this.kFb.kEZ;
      if (localf != null)
      {
        com.tencent.mm.plugin.appbrand.api.f.a.a(localf, -4);
        AppMethodBeat.o(227921);
        return;
      }
      AppMethodBeat.o(227921);
    }
    
    public final void i(Exception paramException)
    {
      AppMethodBeat.i(227922);
      am.btn();
      Log.e("MicroMsg.AppBrandPreRenderColdStartService.Loader", "bindRemoteService onCaughtInvokeException, id:" + am.b(this.kFb) + ", exception:" + paramException);
      paramException = this.kFb.kEZ;
      if (paramException != null)
      {
        com.tencent.mm.plugin.appbrand.api.f.a.a(paramException, -4);
        AppMethodBeat.o(227922);
        return;
      }
      AppMethodBeat.o(227922);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "kotlin.jvm.PlatformType", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "result", "", "onResult"})
  static final class e<T extends AppBrandInitConfigLU>
    implements e.a<AppBrandInitConfigWC>
  {
    e(am paramam) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "showPrompt"})
  static final class f
    implements com.tencent.mm.plugin.appbrand.launching.f.a
  {
    f(am paramam) {}
    
    public final void bto()
    {
      AppMethodBeat.i(227924);
      am.btn();
      Log.i("MicroMsg.AppBrandPreRenderColdStartService.Loader", "run()-showPrompt, id:" + am.b(this.kFb));
      AppMethodBeat.o(227924);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.am
 * JD-Core Version:    0.7.0.1
 */