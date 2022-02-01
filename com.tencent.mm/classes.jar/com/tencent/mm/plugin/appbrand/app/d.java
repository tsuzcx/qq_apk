package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ay;
import d.f;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/app/AppBrandProcessSharedMMKV;", "", "()V", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "SP_NAME", "", "TAG", "UIN", "", "getUIN", "()I", "UIN_BY_SP", "getUIN_BY_SP", "UIN_BY_SP$delegate", "Lkotlin/Lazy;", "plugin-appbrand-integration_release"})
public final class d
{
  private static final f jGv;
  public static final d jGw;
  
  static
  {
    AppMethodBeat.i(50163);
    jGw = new d();
    jGv = d.g.O((d.g.a.a)a.jGx);
    AppMethodBeat.o(50163);
  }
  
  public static ay LD()
  {
    AppMethodBeat.i(50164);
    Object localObject = new StringBuilder("AppBrandProcessSharedMMKV_");
    if (com.tencent.mm.kernel.g.ajM()) {
      p.g(com.tencent.mm.kernel.g.ajP(), "MMKernel.account()");
    }
    for (int i = com.tencent.mm.kernel.a.getUin();; i = ((Number)jGv.getValue()).intValue())
    {
      localObject = ay.aRW(i);
      AppMethodBeat.o(50164);
      return localObject;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<Integer>
  {
    public static final a jGx;
    
    static
    {
      AppMethodBeat.i(50162);
      jGx = new a();
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