package com.tencent.mm.plugin.appbrand.headless;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.o;
import com.tencent.mm.plugin.appbrand.api.f.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/headless/AppBrandHeadlessStartService;", "", "()V", "TAG", "", "bindRemoteService", "", "requestId", "", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "remoteProcessName", "callback", "Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "taskOnStartSuccess", "Lcom/tencent/mm/plugin/appbrand/headless/ITaskOnHeadlessStartSuccess;", "start", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "startInternal", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a ruk;
  
  static
  {
    AppMethodBeat.i(317589);
    ruk = new a();
    AppMethodBeat.o(317589);
  }
  
  public static void a(int paramInt, com.tencent.mm.plugin.appbrand.api.g paramg, final com.tencent.mm.plugin.appbrand.api.f paramf, final e parame)
  {
    AppMethodBeat.i(317561);
    new com.tencent.mm.plugin.appbrand.launching.precondition.j(paramInt, paramg, (q)new e(paramInt, paramf, parame), paramf).start();
    AppMethodBeat.o(317561);
  }
  
  private static final void a(BindRemoteServiceData paramBindRemoteServiceData, com.tencent.mm.ipcinvoker.f paramf)
  {
    AppMethodBeat.i(317569);
    if (paramBindRemoteServiceData == null)
    {
      if (paramf != null) {
        paramf.onCallback(new BindRemoteServiceResult(-4));
      }
      AppMethodBeat.o(317569);
      return;
    }
    i locali = h.ahAA;
    s.s(paramBindRemoteServiceData, "data");
    locali.bk((Runnable)new f(paramBindRemoteServiceData, (com.tencent.mm.plugin.appbrand.api.f)new a(paramf)));
    AppMethodBeat.o(317569);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/headless/AppBrandHeadlessStartService$bindRemoteService$1$2", "Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "onError", "", "errCode", "", "errMsg", "", "onSuccess", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.plugin.appbrand.api.f
  {
    a(com.tencent.mm.ipcinvoker.f<BindRemoteServiceResult> paramf) {}
    
    public final void onError(int paramInt, String paramString)
    {
      AppMethodBeat.i(317591);
      com.tencent.mm.ipcinvoker.f localf = this.mht;
      if (localf != null) {
        localf.onCallback(new BindRemoteServiceResult(paramInt, paramString));
      }
      AppMethodBeat.o(317591);
    }
    
    public final void onSuccess()
    {
      AppMethodBeat.i(317579);
      com.tencent.mm.ipcinvoker.f localf = this.mht;
      if (localf != null) {
        localf.onCallback(new BindRemoteServiceResult(0));
      }
      AppMethodBeat.o(317579);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/headless/AppBrandHeadlessStartService$bindRemoteService$2", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallbackEx;", "Lcom/tencent/mm/plugin/appbrand/headless/BindRemoteServiceResult;", "onBridgeNotFound", "", "onCallback", "data", "onCaughtInvokeException", "e", "Ljava/lang/Exception;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.ipcinvoker.g<BindRemoteServiceResult>
  {
    b(AtomicBoolean paramAtomicBoolean, com.tencent.mm.plugin.appbrand.api.f paramf, String paramString, a.c paramc, int paramInt) {}
    
    public final void aYr()
    {
      AppMethodBeat.i(317590);
      Log.e("MicroMsg.AppBrandHeadlessStartService", s.X("bindRemoteService onBridgeNotFound, id:", Integer.valueOf(this.qrX)));
      com.tencent.mm.plugin.appbrand.api.f localf = this.qrT;
      if (localf != null) {
        f.a.a(localf, -4);
      }
      AppMethodBeat.o(317590);
    }
    
    public final void h(Exception paramException)
    {
      AppMethodBeat.i(317598);
      Log.e("MicroMsg.AppBrandHeadlessStartService", "bindRemoteService onCaughtInvokeException, id:" + this.qrX + ", exception:" + paramException);
      paramException = this.qrT;
      if (paramException != null) {
        f.a.a(paramException, -4);
      }
      AppMethodBeat.o(317598);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/headless/AppBrandHeadlessStartService$bindRemoteService$onRemoteProcessDiedListener$1", "Lcom/tencent/mm/ipcinvoker/IRemoteProcDied;", "onDied", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements o
  {
    c(String paramString, int paramInt, AtomicBoolean paramAtomicBoolean, com.tencent.mm.plugin.appbrand.api.f paramf) {}
    
    public final void onDied()
    {
      AppMethodBeat.i(317565);
      Log.e("MicroMsg.AppBrandHeadlessStartService", "bindRemoteService onRemoteProcessDied(" + this.qrV + "), id:" + this.qrX);
      if (!this.qrU.getAndSet(true))
      {
        com.tencent.mm.plugin.appbrand.api.f localf = this.qrT;
        if (localf != null) {
          f.a.a(localf, -5);
        }
      }
      com.tencent.mm.ipcinvoker.j.a(this.qrV, (o)this);
      AppMethodBeat.o(317565);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "process", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandMiniProgramProcess;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements q<AppBrandInitConfigWC, AppBrandStatObject, d, ah>
  {
    e(int paramInt, com.tencent.mm.plugin.appbrand.api.f paramf, e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.headless.a
 * JD-Core Version:    0.7.0.1
 */