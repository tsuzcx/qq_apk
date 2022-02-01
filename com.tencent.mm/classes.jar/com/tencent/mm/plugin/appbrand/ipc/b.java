package com.tencent.mm.plugin.appbrand.ipc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.utils.k;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandRuntimeLaunchConditionForMainProcessIPC;", "", "()V", "connect", "", "waitFor", "block", "Lkotlin/Function0;", "IPCInvokerConnector", "plugin-appbrand-integration_release"})
public final class b
{
  public static final b lwB;
  
  static
  {
    AppMethodBeat.i(228221);
    lwB = new b();
    AppMethodBeat.o(228221);
  }
  
  public static final void connect()
  {
    AppMethodBeat.i(228219);
    w((a)b.b.lwC);
    AppMethodBeat.o(228219);
  }
  
  public static final void w(a<x> parama)
  {
    AppMethodBeat.i(228220);
    p.h(parama, "block");
    parama = new k((Runnable)new b.e(parama), 2);
    AppBrandMainProcessService.Y((Runnable)new c(parama));
    XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, b.a.class, (d)new d(parama));
    AppMethodBeat.o(228220);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(228216);
      this.lwD.countDown();
      AppMethodBeat.o(228216);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class d<T>
    implements d<ResultType>
  {
    d(k paramk) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.b
 * JD-Core Version:    0.7.0.1
 */