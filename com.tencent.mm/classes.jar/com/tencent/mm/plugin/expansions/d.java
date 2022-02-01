package com.tencent.mm.plugin.expansions;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expansions/expansions;", "", "()V", "isEnabled", "", "module", "", "isInstalled", "request", "", "setUpBlock", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/expansions/ExpansionsKtWrapper;", "Lkotlin/ExtensionFunctionType;", "tryGetAssets", "Landroid/content/res/AssetManager;", "tryLoadLibrary", "libName", "expansions-visitor_release"})
public final class d
{
  public static final d pLO;
  
  static
  {
    AppMethodBeat.i(152987);
    pLO = new d();
    AppMethodBeat.o(152987);
  }
  
  public static boolean Zu(String paramString)
  {
    AppMethodBeat.i(152986);
    k.h(paramString, "libName");
    boolean bool = a.Zu(paramString);
    AppMethodBeat.o(152986);
    return bool;
  }
  
  public static boolean Zv(String paramString)
  {
    AppMethodBeat.i(152984);
    k.h(paramString, "module");
    boolean bool = a.cik();
    AppMethodBeat.o(152984);
    return bool;
  }
  
  public static boolean Zw(String paramString)
  {
    AppMethodBeat.i(152985);
    k.h(paramString, "module");
    boolean bool = a.cil();
    AppMethodBeat.o(152985);
    return bool;
  }
  
  public static void y(d.g.a.b<? super b, y> paramb)
  {
    AppMethodBeat.i(152983);
    b localb = new b();
    if (paramb != null) {
      paramb.ay(localb);
    }
    if (localb.pLK != null)
    {
      a.a((a.a)new b.a(localb));
      AppMethodBeat.o(152983);
      return;
    }
    a.a((a.b)new b.b(localb));
    AppMethodBeat.o(152983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.d
 * JD-Core Version:    0.7.0.1
 */