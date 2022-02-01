package com.tencent.mm.plugin.appbrand.ipc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.utils.j;
import d.g.a.a;
import d.g.b.k;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandRuntimeLaunchConditionForMainProcessIPC;", "", "()V", "connect", "", "waitFor", "block", "Lkotlin/Function0;", "IPCInvokerConnector", "plugin-appbrand-integration_release"})
public final class b
{
  public static final b juS;
  
  static
  {
    AppMethodBeat.i(196277);
    juS = new b();
    AppMethodBeat.o(196277);
  }
  
  public static final void connect()
  {
    AppMethodBeat.i(196275);
    o((a)b.juT);
    AppMethodBeat.o(196275);
  }
  
  public static final void o(a<y> parama)
  {
    AppMethodBeat.i(196276);
    k.h(parama, "block");
    parama = new j((Runnable)new b.e(parama), 2);
    AppBrandMainProcessService.U((Runnable)new c(parama));
    XIPCInvoker.a("com.tencent.mm", IPCVoid.fZS, b.a.class, (d)new d(parama));
    AppMethodBeat.o(196276);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<y>
  {
    public static final b juT;
    
    static
    {
      AppMethodBeat.i(196271);
      juT = new b();
      AppMethodBeat.o(196271);
    }
    
    b()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(j paramj) {}
    
    public final void run()
    {
      AppMethodBeat.i(196272);
      this.juU.countDown();
      AppMethodBeat.o(196272);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class d<T>
    implements d<ResultType>
  {
    d(j paramj) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.b
 * JD-Core Version:    0.7.0.1
 */