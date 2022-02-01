package com.tencent.mm.plugin.expansions;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expansions/expansions;", "", "()V", "isEnabled", "", "module", "", "isInstalled", "request", "", "setUpBlock", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/expansions/ExpansionsKtWrapper;", "Lkotlin/ExtensionFunctionType;", "tryGetAssets", "Landroid/content/res/AssetManager;", "tryLoadLibrary", "libName", "expansions-visitor_release"})
public final class d
{
  public static final d piG;
  
  static
  {
    AppMethodBeat.i(152987);
    piG = new d();
    AppMethodBeat.o(152987);
  }
  
  public static boolean Vi(String paramString)
  {
    AppMethodBeat.i(152986);
    k.h(paramString, "libName");
    boolean bool = a.Vi(paramString);
    AppMethodBeat.o(152986);
    return bool;
  }
  
  public static boolean Vj(String paramString)
  {
    AppMethodBeat.i(152984);
    k.h(paramString, "module");
    boolean bool = a.cbb();
    AppMethodBeat.o(152984);
    return bool;
  }
  
  public static boolean Vk(String paramString)
  {
    AppMethodBeat.i(152985);
    k.h(paramString, "module");
    boolean bool = a.cbc();
    AppMethodBeat.o(152985);
    return bool;
  }
  
  public static void u(d.g.a.b<? super b, y> paramb)
  {
    AppMethodBeat.i(152983);
    b localb = new b();
    if (paramb != null) {
      paramb.aA(localb);
    }
    if (localb.piC != null)
    {
      a.a((a.a)new b.a(localb));
      AppMethodBeat.o(152983);
      return;
    }
    a.a((a.b)new b.b(localb));
    AppMethodBeat.o(152983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.d
 * JD-Core Version:    0.7.0.1
 */