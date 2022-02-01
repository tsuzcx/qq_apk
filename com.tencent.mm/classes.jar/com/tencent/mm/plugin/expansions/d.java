package com.tencent.mm.plugin.expansions;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expansions/expansions;", "", "()V", "isEnabled", "", "module", "", "isInstalled", "request", "", "setUpBlock", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/expansions/ExpansionsKtWrapper;", "Lkotlin/ExtensionFunctionType;", "tryGetAssets", "Landroid/content/res/AssetManager;", "tryLoadLibrary", "libName", "expansions-visitor_release"})
public final class d
{
  public static final d rNG;
  
  static
  {
    AppMethodBeat.i(152987);
    rNG = new d();
    AppMethodBeat.o(152987);
  }
  
  public static boolean aoa(String paramString)
  {
    AppMethodBeat.i(152986);
    p.h(paramString, "libName");
    boolean bool = a.aoa(paramString);
    AppMethodBeat.o(152986);
    return bool;
  }
  
  public static boolean aob(String paramString)
  {
    AppMethodBeat.i(152984);
    p.h(paramString, "module");
    boolean bool = a.cMq();
    AppMethodBeat.o(152984);
    return bool;
  }
  
  public static boolean aoc(String paramString)
  {
    AppMethodBeat.i(152985);
    p.h(paramString, "module");
    boolean bool = a.cMr();
    AppMethodBeat.o(152985);
    return bool;
  }
  
  public static void z(kotlin.g.a.b<? super b, x> paramb)
  {
    AppMethodBeat.i(152983);
    b localb = new b();
    if (paramb != null) {
      paramb.invoke(localb);
    }
    if (localb.rNC != null)
    {
      a.a((a.a)new b.a(localb));
      AppMethodBeat.o(152983);
      return;
    }
    a.a((a.b)new b.b(localb));
    AppMethodBeat.o(152983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.d
 * JD-Core Version:    0.7.0.1
 */