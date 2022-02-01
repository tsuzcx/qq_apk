package com.tencent.mm.plugin.appbrand;

import com.tencent.e.i.h;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.o;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.api.f.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.d.a;
import com.tencent.mm.plugin.appbrand.launching.e;
import com.tencent.mm.plugin.appbrand.launching.e.a;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/Loader;", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "loaderId", "", "parcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "instanceId", "", "callback", "Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "(ILcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;)V", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;)V", "bindRemoteService", "", "configWC", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "getKey", "run", "Companion", "plugin-appbrand-integration_release"})
final class an
  implements h
{
  @Deprecated
  public static final a nyG;
  private final String cBH;
  private final LaunchParcel nyE;
  f nyF;
  private final int nyi;
  
  static
  {
    AppMethodBeat.i(284197);
    nyG = new a((byte)0);
    AppMethodBeat.o(284197);
  }
  
  public an(int paramInt, LaunchParcel paramLaunchParcel, String paramString, f paramf)
  {
    AppMethodBeat.i(284195);
    this.nyi = paramInt;
    this.nyE = paramLaunchParcel;
    this.cBH = paramString;
    this.nyF = paramf;
    AppMethodBeat.o(284195);
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(284193);
    String str = "AppBrandPreRenderColdStartService.Loader-" + this.nyi;
    AppMethodBeat.o(284193);
    return str;
  }
  
  public final void run()
  {
    AppMethodBeat.i(284194);
    Log.i("MicroMsg.AppBrandPreRenderColdStartService.Loader", "run()-start, id:" + this.nyi + ", username:" + this.nyE.username + ", appId:" + this.nyE.appId + ", versionType:" + this.nyE.cBU + ", instanceId:" + this.cBH + ", path:" + this.nyE.nBq);
    e locale = new e(this.nyE, this.cBH, (d.a)new e(this), (e.a)new f(this));
    locale.a(b.cBf);
    locale.run();
    AppMethodBeat.o(284194);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/Loader$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/Loader$bindRemoteService$1", "Lcom/tencent/mm/ipcinvoker/IRemoteProcDied;", "onDied", "", "plugin-appbrand-integration_release"})
  public static final class b
    implements o
  {
    b(AtomicBoolean paramAtomicBoolean, String paramString) {}
    
    public final void RQ()
    {
      AppMethodBeat.i(275249);
      an.bEk();
      Log.e("MicroMsg.AppBrandPreRenderColdStartService.Loader", "bindRemoteService onRemoteProcess died, id:" + an.b(this.nyH));
      if (!this.nyI.getAndSet(true))
      {
        f localf = this.nyH.nyF;
        if (localf != null) {
          f.a.a(localf, -5);
        }
      }
      j.a(this.nyJ, (o)this);
      AppMethodBeat.o(275249);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/Loader$bindRemoteService$3", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallbackEx;", "Lcom/tencent/mm/plugin/appbrand/BindRemoteServiceResult;", "onBridgeNotFound", "", "onCallback", "data", "onCaughtInvokeException", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "plugin-appbrand-integration_release"})
  public static final class d
    implements g<BindRemoteServiceResult>
  {
    d(AtomicBoolean paramAtomicBoolean) {}
    
    public final void aFq()
    {
      AppMethodBeat.i(282360);
      an.bEk();
      Log.e("MicroMsg.AppBrandPreRenderColdStartService.Loader", "bindRemoteService onBridgeNotFound, id:" + an.b(this.nyH));
      f localf = this.nyH.nyF;
      if (localf != null)
      {
        f.a.a(localf, -4);
        AppMethodBeat.o(282360);
        return;
      }
      AppMethodBeat.o(282360);
    }
    
    public final void g(Exception paramException)
    {
      AppMethodBeat.i(282361);
      an.bEk();
      Log.e("MicroMsg.AppBrandPreRenderColdStartService.Loader", "bindRemoteService onCaughtInvokeException, id:" + an.b(this.nyH) + ", exception:" + paramException);
      paramException = this.nyH.nyF;
      if (paramException != null)
      {
        f.a.a(paramException, -4);
        AppMethodBeat.o(282361);
        return;
      }
      AppMethodBeat.o(282361);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "kotlin.jvm.PlatformType", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "result", "", "onResult"})
  static final class e<T extends AppBrandInitConfigLU>
    implements d.a<AppBrandInitConfigWC>
  {
    e(an paraman) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "showPrompt"})
  static final class f
    implements e.a
  {
    f(an paraman) {}
    
    public final void bEl()
    {
      AppMethodBeat.i(279718);
      an.bEk();
      Log.i("MicroMsg.AppBrandPreRenderColdStartService.Loader", "run()-showPrompt, id:" + an.b(this.nyH));
      AppMethodBeat.o(279718);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.an
 * JD-Core Version:    0.7.0.1
 */