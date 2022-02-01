package com.tencent.mm.plugin.appbrand.ipc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.utils.j;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandRuntimeLaunchConditionForMainProcessIPC;", "", "()V", "connect", "", "waitFor", "block", "Lkotlin/Function0;", "IPCInvokerConnector", "plugin-appbrand-integration_release"})
public final class b
{
  public static final b kpB;
  
  static
  {
    AppMethodBeat.i(189053);
    kpB = new b();
    AppMethodBeat.o(189053);
  }
  
  public static final void connect()
  {
    AppMethodBeat.i(189051);
    t((a)b.kpC);
    AppMethodBeat.o(189051);
  }
  
  public static final void t(a<z> parama)
  {
    AppMethodBeat.i(189052);
    p.h(parama, "block");
    parama = new j((Runnable)new e(parama), 2);
    AppBrandMainProcessService.V((Runnable)new c(parama));
    XIPCInvoker.a("com.tencent.mm", IPCVoid.gyi, b.a.class, (d)new d(parama));
    AppMethodBeat.o(189052);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<z>
  {
    public static final b kpC;
    
    static
    {
      AppMethodBeat.i(189047);
      kpC = new b();
      AppMethodBeat.o(189047);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(j paramj) {}
    
    public final void run()
    {
      AppMethodBeat.i(189048);
      this.kpD.countDown();
      AppMethodBeat.o(189048);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class d<T>
    implements d<ResultType>
  {
    d(j paramj) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(189050);
      this.gFS.invoke();
      AppMethodBeat.o(189050);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.b
 * JD-Core Version:    0.7.0.1
 */