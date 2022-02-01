package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aw;
import d.f;
import d.g.b.u;
import d.g.b.w;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/app/AppBrandProcessSharedMMKV;", "", "()V", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "SP_NAME", "", "TAG", "UIN", "", "getUIN", "()I", "UIN_BY_SP", "getUIN_BY_SP", "UIN_BY_SP$delegate", "Lkotlin/Lazy;", "plugin-appbrand-integration_release"})
public final class d
{
  private static final f jjI;
  public static final d jjJ;
  
  static
  {
    AppMethodBeat.i(50163);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(d.class), "UIN_BY_SP", "getUIN_BY_SP()I")) };
    jjJ = new d();
    jjI = d.g.K((d.g.a.a)a.jjK);
    AppMethodBeat.o(50163);
  }
  
  public static aw JW()
  {
    AppMethodBeat.i(50164);
    Object localObject = new StringBuilder("AppBrandProcessSharedMMKV_");
    if (com.tencent.mm.kernel.g.agM()) {
      d.g.b.k.g(com.tencent.mm.kernel.g.agP(), "MMKernel.account()");
    }
    for (int i = com.tencent.mm.kernel.a.getUin();; i = ((Number)jjI.getValue()).intValue())
    {
      localObject = aw.aKT(i);
      AppMethodBeat.o(50164);
      return localObject;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<Integer>
  {
    public static final a jjK;
    
    static
    {
      AppMethodBeat.i(50162);
      jjK = new a();
      AppMethodBeat.o(50162);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.d
 * JD-Core Version:    0.7.0.1
 */