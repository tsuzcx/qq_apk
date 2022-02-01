package com.tencent.mm.plugin.appbrand.ipc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.utils.j;
import d.g.a.a;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandRuntimeLaunchConditionForMainProcessIPC;", "", "()V", "connect", "", "waitFor", "block", "Lkotlin/Function0;", "IPCInvokerConnector", "plugin-appbrand-integration_release"})
public final class b
{
  public static final b jVn;
  
  static
  {
    AppMethodBeat.i(187148);
    jVn = new b();
    AppMethodBeat.o(187148);
  }
  
  public static final void connect()
  {
    AppMethodBeat.i(187146);
    s((a)b.jVo);
    AppMethodBeat.o(187146);
  }
  
  public static final void s(a<y> parama)
  {
    AppMethodBeat.i(187147);
    k.h(parama, "block");
    parama = new j((Runnable)new e(parama), 2);
    AppBrandMainProcessService.W((Runnable)new c(parama));
    XIPCInvoker.a("com.tencent.mm", IPCVoid.gey, b.a.class, (d)new d(parama));
    AppMethodBeat.o(187147);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<y>
  {
    public static final b jVo;
    
    static
    {
      AppMethodBeat.i(187142);
      jVo = new b();
      AppMethodBeat.o(187142);
    }
    
    b()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(j paramj) {}
    
    public final void run()
    {
      AppMethodBeat.i(187143);
      this.jVp.countDown();
      AppMethodBeat.o(187143);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class d<T>
    implements d<ResultType>
  {
    d(j paramj) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(187145);
      this.gmj.invoke();
      AppMethodBeat.o(187145);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.b
 * JD-Core Version:    0.7.0.1
 */