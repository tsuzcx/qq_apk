package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/app/AppBrandProcessSharedMMKV;", "", "()V", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "SP_NAME", "", "TAG", "UIN", "", "getUIN", "()I", "UIN_BY_SP", "getUIN_BY_SP", "UIN_BY_SP$delegate", "Lkotlin/Lazy;", "plugin-appbrand-integration_release"})
public final class f
{
  private static final kotlin.f kIr;
  public static final f kIs;
  
  static
  {
    AppMethodBeat.i(50163);
    kIs = new f();
    kIr = kotlin.g.ah((kotlin.g.a.a)a.kIt);
    AppMethodBeat.o(50163);
  }
  
  private static int getUIN()
  {
    AppMethodBeat.i(227973);
    if (com.tencent.mm.kernel.g.aAc())
    {
      p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
      i = com.tencent.mm.kernel.a.getUin();
      AppMethodBeat.o(227973);
      return i;
    }
    int i = ((Number)kIr.getValue()).intValue();
    AppMethodBeat.o(227973);
    return i;
  }
  
  public final MultiProcessMMKV VQ()
  {
    AppMethodBeat.i(50164);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("AppBrandProcessSharedMMKV_" + getUIN());
    AppMethodBeat.o(50164);
    return localMultiProcessMMKV;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<Integer>
  {
    public static final a kIt;
    
    static
    {
      AppMethodBeat.i(50162);
      kIt = new a();
      AppMethodBeat.o(50162);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.f
 * JD-Core Version:    0.7.0.1
 */