package com.tencent.mm.plugin.appbrand.ipc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.vending.e.b;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandRuntimeLaunchConditionForMainProcessIPC;", "", "()V", "connect", "", "waitFor", "block", "Lkotlin/Function0;", "lifecycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "IPCInvokerConnector", "IPCInvokerConnectorAutoReleaseCallback", "plugin-appbrand-integration_release"})
public final class c
{
  public static final c orl;
  
  static
  {
    AppMethodBeat.i(275324);
    orl = new c();
    AppMethodBeat.o(275324);
  }
  
  public static final void a(kotlin.g.a.a<x> parama, b<? super com.tencent.mm.vending.e.a> paramb)
  {
    AppMethodBeat.i(275323);
    String str = MainProcessIPCService.PROCESS_NAME;
    IPCVoid localIPCVoid = IPCVoid.jZu;
    if (parama == null) {}
    for (parama = null;; parama = new b(parama, paramb))
    {
      XIPCInvoker.a(str, localIPCVoid, c.a.class, (f)parama);
      AppMethodBeat.o(275323);
      return;
    }
  }
  
  public static final void connect()
  {
    AppMethodBeat.i(275322);
    a(null, null);
    AppMethodBeat.o(275322);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandRuntimeLaunchConditionForMainProcessIPC$IPCInvokerConnectorAutoReleaseCallback;", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "block", "Lkotlin/Function0;", "", "lifecycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "(Lkotlin/jvm/functions/Function0;Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "dead", "onCallback", "data", "plugin-appbrand-integration_release"})
  static final class b
    implements f<IPCVoid>, com.tencent.mm.vending.e.a
  {
    private kotlin.g.a.a<x> kRn;
    
    public b(kotlin.g.a.a<x> parama, b<? super com.tencent.mm.vending.e.a> paramb)
    {
      AppMethodBeat.i(280639);
      this.kRn = parama;
      if (paramb != null)
      {
        paramb.keep((com.tencent.mm.vending.e.a)this);
        AppMethodBeat.o(280639);
        return;
      }
      AppMethodBeat.o(280639);
    }
    
    public final void dead()
    {
      this.kRn = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.c
 * JD-Core Version:    0.7.0.1
 */