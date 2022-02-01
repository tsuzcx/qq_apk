package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime.b;
import com.tencent.mm.plugin.appbrand.ad.g;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.utils.j;
import com.tencent.mm.plugin.appbrand.x.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.a.b;
import d.y;
import java.util.LinkedList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimePostResourcePreparedJobsBatchRun;", "", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "process", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime$PrepareProcess;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime$PrepareProcess;)V", "actions", "Ljava/util/LinkedList;", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Lcom/tencent/mm/plugin/appbrand/launching/PostPreparedAction;", "addAction", "action", "run", "plugin-appbrand-integration_release"})
public final class h
{
  public final LinkedList<b<d.g.a.a<y>, y>> lio;
  final o lip;
  public final AppBrandRuntime.b liq;
  
  public h(o paramo, AppBrandRuntime.b paramb)
  {
    AppMethodBeat.i(50755);
    this.lip = paramo;
    this.liq = paramb;
    this.lio = new LinkedList();
    if ((this.lip.CC()) && (((com.tencent.mm.plugin.appbrand.performance.a)this.lip.ar(com.tencent.mm.plugin.appbrand.performance.a.class)).lHr)) {
      v((b)1.lir);
    }
    if ((!this.lip.aTa()) || (this.lip.aUc()) || (e.K(g.class) == null) || (!((g)e.K(g.class)).N((AppBrandRuntime)this.lip)))
    {
      ac.i("AppBrandRuntimePostResourcePreparedJobsBatchRun", this.lip.getAppId() + " add start prepare orientation action");
      v((b)new h.2(this));
    }
    AppMethodBeat.o(50755);
  }
  
  private final void v(b<? super d.g.a.a<y>, y> paramb)
  {
    AppMethodBeat.i(50754);
    this.lio.add(paramb);
    AppMethodBeat.o(50754);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  public static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public a(j paramj)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(h paramh) {}
    
    public final void run()
    {
      AppMethodBeat.i(50753);
      this.lis.liq.Al();
      AppMethodBeat.o(50753);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.h
 * JD-Core Version:    0.7.0.1
 */