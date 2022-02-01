package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime.b;
import com.tencent.mm.plugin.appbrand.ad.g;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.utils.j;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.a.b;
import d.y;
import java.util.LinkedList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimePostResourcePreparedJobsBatchRun;", "", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "process", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime$PrepareProcess;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime$PrepareProcess;)V", "actions", "Ljava/util/LinkedList;", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Lcom/tencent/mm/plugin/appbrand/launching/PostPreparedAction;", "addAction", "action", "run", "plugin-appbrand-integration_release"})
public final class h
{
  public final LinkedList<b<d.g.a.a<y>, y>> kGU;
  final o kGV;
  public final AppBrandRuntime.b kGW;
  
  public h(o paramo, AppBrandRuntime.b paramb)
  {
    AppMethodBeat.i(50755);
    this.kGV = paramo;
    this.kGW = paramb;
    this.kGU = new LinkedList();
    if ((this.kGV.CZ()) && (((com.tencent.mm.plugin.appbrand.performance.a)this.kGV.ar(com.tencent.mm.plugin.appbrand.performance.a.class)).lhy)) {
      r((b)1.kGX);
    }
    if ((!this.kGV.aMk()) || (this.kGV.aNm()) || (e.K(g.class) == null) || (!((g)e.K(g.class)).N((AppBrandRuntime)this.kGV)))
    {
      ad.i("AppBrandRuntimePostResourcePreparedJobsBatchRun", this.kGV.getAppId() + " add start prepare orientation action");
      r((b)new h.2(this));
    }
    AppMethodBeat.o(50755);
  }
  
  private final void r(b<? super d.g.a.a<y>, y> paramb)
  {
    AppMethodBeat.i(50754);
    this.kGU.add(paramb);
    AppMethodBeat.o(50754);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  public static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public a(j paramj)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(h paramh) {}
    
    public final void run()
    {
      AppMethodBeat.i(50753);
      this.kGY.kGW.AH();
      AppMethodBeat.o(50753);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.h
 * JD-Core Version:    0.7.0.1
 */