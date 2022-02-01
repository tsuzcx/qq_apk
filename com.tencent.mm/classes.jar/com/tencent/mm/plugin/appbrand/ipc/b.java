package com.tencent.mm.plugin.appbrand.ipc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.utils.k;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandRuntimeLaunchConditionForMainProcessIPC;", "", "()V", "connect", "", "waitFor", "block", "Lkotlin/Function0;", "IPCInvokerConnector", "plugin-appbrand-integration_release"})
public final class b
{
  public static final b ksR;
  
  static
  {
    AppMethodBeat.i(223312);
    ksR = new b();
    AppMethodBeat.o(223312);
  }
  
  public static final void connect()
  {
    AppMethodBeat.i(223310);
    u((a)b.ksS);
    AppMethodBeat.o(223310);
  }
  
  public static final void u(a<z> parama)
  {
    AppMethodBeat.i(223311);
    p.h(parama, "block");
    parama = new k((Runnable)new e(parama), 2);
    AppBrandMainProcessService.T((Runnable)new c(parama));
    XIPCInvoker.a("com.tencent.mm", IPCVoid.gAP, b.a.class, (d)new d(parama));
    AppMethodBeat.o(223311);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<z>
  {
    public static final b ksS;
    
    static
    {
      AppMethodBeat.i(223306);
      ksS = new b();
      AppMethodBeat.o(223306);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(223307);
      this.ksT.countDown();
      AppMethodBeat.o(223307);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class d<T>
    implements d<ResultType>
  {
    d(k paramk) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(223309);
      this.gIz.invoke();
      AppMethodBeat.o(223309);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.b
 * JD-Core Version:    0.7.0.1
 */