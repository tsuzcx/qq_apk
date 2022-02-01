package com.tencent.mm.plugin.expansions;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expansions/ExpansionsKt;", "", "()V", "isEnabled", "", "module", "", "isInstalled", "request", "", "setUpBlock", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/expansions/ExpansionsKtWrapper;", "Lkotlin/ExtensionFunctionType;", "tryGetAssets", "Landroid/content/res/AssetManager;", "tryLoadLibrary", "libName", "expansions-visitor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b yFu;
  
  static
  {
    AppMethodBeat.i(273685);
    yFu = new b();
    AppMethodBeat.o(273685);
  }
  
  public static void ag(kotlin.g.a.b<? super c, ah> paramb)
  {
    AppMethodBeat.i(273671);
    c localc = new c();
    if (paramb != null) {
      paramb.invoke(localc);
    }
    if (localc.yFx != null)
    {
      e.getAssets((e.a)new c.a(localc));
      AppMethodBeat.o(273671);
      return;
    }
    e.install((e.b)new c.b(localc));
    AppMethodBeat.o(273671);
  }
  
  public static boolean apZ(String paramString)
  {
    AppMethodBeat.i(273673);
    s.u(paramString, "module");
    boolean bool = e.dHF();
    AppMethodBeat.o(273673);
    return bool;
  }
  
  public static boolean isInstalled(String paramString)
  {
    AppMethodBeat.i(273678);
    s.u(paramString, "module");
    boolean bool = e.aQh();
    AppMethodBeat.o(273678);
    return bool;
  }
  
  public static boolean tryLoadLibrary(String paramString)
  {
    AppMethodBeat.i(273683);
    s.u(paramString, "libName");
    boolean bool = e.tryLoadLibrary(paramString);
    AppMethodBeat.o(273683);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.b
 * JD-Core Version:    0.7.0.1
 */