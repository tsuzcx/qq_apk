package com.tencent.mm.plugin.appbrand.ipc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.vending.e.b;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandRuntimeLaunchConditionForMainProcessIPC;", "", "()V", "connect", "", "waitFor", "block", "Lkotlin/Function0;", "lifecycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "IPCInvokerConnector", "IPCInvokerConnectorAutoReleaseCallback", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d rve;
  
  static
  {
    AppMethodBeat.i(319399);
    rve = new d();
    AppMethodBeat.o(319399);
  }
  
  public static final void a(kotlin.g.a.a<ah> parama, b<? super com.tencent.mm.vending.e.a> paramb)
  {
    AppMethodBeat.i(319396);
    String str = MainProcessIPCService.PROCESS_NAME;
    IPCVoid localIPCVoid = IPCVoid.mzv;
    if (parama == null) {}
    for (parama = null;; parama = new d.b(parama, paramb))
    {
      XIPCInvoker.a(str, localIPCVoid, d.a.class, (f)parama);
      AppMethodBeat.o(319396);
      return;
    }
  }
  
  public static final void connect()
  {
    AppMethodBeat.i(319392);
    a(null, null);
    AppMethodBeat.o(319392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.d
 * JD-Core Version:    0.7.0.1
 */