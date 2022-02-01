package com.tencent.mm.plugin.expansions;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expansions/expansions;", "", "()V", "isEnabled", "", "module", "", "isInstalled", "request", "", "setUpBlock", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/expansions/ExpansionsKtWrapper;", "Lkotlin/ExtensionFunctionType;", "tryGetAssets", "Landroid/content/res/AssetManager;", "tryLoadLibrary", "libName", "expansions-visitor_release"})
public final class d
{
  public static final d vtq;
  
  static
  {
    AppMethodBeat.i(152987);
    vtq = new d();
    AppMethodBeat.o(152987);
  }
  
  public static void D(kotlin.g.a.b<? super b, x> paramb)
  {
    AppMethodBeat.i(152983);
    b localb = new b();
    if (paramb != null) {
      paramb.invoke(localb);
    }
    if (localb.vtm != null)
    {
      a.a((a.a)new b.a(localb));
      AppMethodBeat.o(152983);
      return;
    }
    a.a((a.b)new b.b(localb));
    AppMethodBeat.o(152983);
  }
  
  public static boolean avY(String paramString)
  {
    AppMethodBeat.i(152986);
    p.k(paramString, "libName");
    boolean bool = a.avY(paramString);
    AppMethodBeat.o(152986);
    return bool;
  }
  
  public static boolean avZ(String paramString)
  {
    AppMethodBeat.i(152984);
    p.k(paramString, "module");
    boolean bool = a.dbe();
    AppMethodBeat.o(152984);
    return bool;
  }
  
  public static boolean awa(String paramString)
  {
    AppMethodBeat.i(152985);
    p.k(paramString, "module");
    boolean bool = a.dbf();
    AppMethodBeat.o(152985);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.d
 * JD-Core Version:    0.7.0.1
 */