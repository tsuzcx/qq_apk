package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.o;
import com.tencent.mm.plugin.appbrand.api.f.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/AppBrandPreRenderColdStartService;", "", "()V", "TAG", "", "bindRemoteService", "", "loaderId", "", "configWC", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "remoteProcessName", "callback", "Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "start", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "startInternal", "requestId", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  public static final m qrR;
  
  static
  {
    AppMethodBeat.i(316825);
    qrR = new m();
    AppMethodBeat.o(316825);
  }
  
  private static final void a(BindRemoteServiceData paramBindRemoteServiceData, com.tencent.mm.ipcinvoker.f paramf)
  {
    AppMethodBeat.i(316816);
    if (paramBindRemoteServiceData == null)
    {
      if (paramf != null) {
        paramf.onCallback(new BindRemoteServiceResult(-4));
      }
      AppMethodBeat.o(316816);
      return;
    }
    i locali = com.tencent.threadpool.h.ahAA;
    s.s(paramBindRemoteServiceData, "data");
    locali.bk((Runnable)new bb(paramBindRemoteServiceData, (com.tencent.mm.plugin.appbrand.api.f)new a(paramf)));
    AppMethodBeat.o(316816);
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.api.g paramg, final com.tencent.mm.plugin.appbrand.api.f paramf)
  {
    AppMethodBeat.i(316811);
    s.u(paramg, "bundle");
    int i = paramg.hashCode();
    long l = Util.currentTicks();
    Log.i("MicroMsg.AppBrandPreRenderColdStartService", "start with id:" + i + " username:" + paramg.username + " appId:" + paramg.appId + " versionType:" + paramg.euz + " path:" + paramg.qAF + " scene:" + paramg.scene);
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1519, 0);
    paramf = (com.tencent.mm.plugin.appbrand.api.f)new m.d(i, l, paramf);
    if (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yOT, 1) <= 0)
    {
      f.a.a(paramf, -8);
      AppMethodBeat.o(316811);
      return;
    }
    new com.tencent.mm.plugin.appbrand.launching.precondition.j(i, paramg, (q)new e(i, paramf), paramf).start();
    AppMethodBeat.o(316811);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/AppBrandPreRenderColdStartService$bindRemoteService$1$2", "Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "onError", "", "errCode", "", "errMsg", "", "onSuccess", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.plugin.appbrand.api.f
  {
    a(com.tencent.mm.ipcinvoker.f<BindRemoteServiceResult> paramf) {}
    
    public final void onError(int paramInt, String paramString)
    {
      AppMethodBeat.i(317200);
      com.tencent.mm.ipcinvoker.f localf = this.mht;
      if (localf != null) {
        localf.onCallback(new BindRemoteServiceResult(paramInt, paramString));
      }
      AppMethodBeat.o(317200);
    }
    
    public final void onSuccess()
    {
      AppMethodBeat.i(317192);
      com.tencent.mm.ipcinvoker.f localf = this.mht;
      if (localf != null) {
        localf.onCallback(new BindRemoteServiceResult(0));
      }
      AppMethodBeat.o(317192);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/AppBrandPreRenderColdStartService$bindRemoteService$2", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallbackEx;", "Lcom/tencent/mm/plugin/appbrand/BindRemoteServiceResult;", "onBridgeNotFound", "", "onCallback", "data", "onCaughtInvokeException", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.ipcinvoker.g<BindRemoteServiceResult>
  {
    b(int paramInt, com.tencent.mm.plugin.appbrand.api.f paramf, AtomicBoolean paramAtomicBoolean, String paramString, m.c paramc) {}
    
    public final void aYr()
    {
      AppMethodBeat.i(317039);
      Log.e("MicroMsg.AppBrandPreRenderColdStartService", s.X("bindRemoteService onBridgeNotFound, id:", Integer.valueOf(this.qrS)));
      com.tencent.mm.plugin.appbrand.api.f localf = this.qrT;
      if (localf != null) {
        f.a.a(localf, -4);
      }
      AppMethodBeat.o(317039);
    }
    
    public final void h(Exception paramException)
    {
      AppMethodBeat.i(317042);
      Log.e("MicroMsg.AppBrandPreRenderColdStartService", "bindRemoteService onCaughtInvokeException, id:" + this.qrS + ", exception:" + paramException);
      paramException = this.qrT;
      if (paramException != null) {
        f.a.a(paramException, -4);
      }
      AppMethodBeat.o(317042);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/AppBrandPreRenderColdStartService$bindRemoteService$onRemoteProcessDiedListener$1", "Lcom/tencent/mm/ipcinvoker/IRemoteProcDied;", "onDied", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements o
  {
    c(String paramString, int paramInt, AtomicBoolean paramAtomicBoolean, com.tencent.mm.plugin.appbrand.api.f paramf) {}
    
    public final void onDied()
    {
      AppMethodBeat.i(317013);
      Log.e("MicroMsg.AppBrandPreRenderColdStartService", "bindRemoteService onRemoteProcessDied(" + this.qrV + "), id:" + this.qrS);
      if (!this.qrU.getAndSet(true))
      {
        com.tencent.mm.plugin.appbrand.api.f localf = this.qrT;
        if (localf != null) {
          f.a.a(localf, -5);
        }
      }
      com.tencent.mm.ipcinvoker.j.a(this.qrV, (o)this);
      AppMethodBeat.o(317013);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "process", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandMiniProgramProcess;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements q<AppBrandInitConfigWC, AppBrandStatObject, d, ah>
  {
    e(int paramInt, com.tencent.mm.plugin.appbrand.api.f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m
 * JD-Core Version:    0.7.0.1
 */