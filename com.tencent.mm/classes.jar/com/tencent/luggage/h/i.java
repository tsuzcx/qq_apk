package com.tencent.luggage.h;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.q;
import d.g.a.a;
import d.g.b.k;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/luggage/util/UIUtilsCompat;", "Lcom/tencent/luggage/util/UIUtilsInterface;", "()V", "interfaceImpl", "getInterfaceImpl", "()Lcom/tencent/luggage/util/UIUtilsInterface;", "setInterfaceImpl", "(Lcom/tencent/luggage/util/UIUtilsInterface;)V", "getCutOutHeight", "", "context", "Landroid/content/Context;", "getDarkModeColor", "originalColor", "getStableStatusBarHeight", "hasCutOut", "", "hasHuaweiMagicWindowFeature", "huaweiSpecial", "isDarkMode", "isHuaweiFold", "luggage-commons_release"})
public final class i
  implements j
{
  private static j cgj;
  public static final i cgk;
  
  static
  {
    AppMethodBeat.i(174639);
    cgk = new i();
    AppMethodBeat.o(174639);
  }
  
  public static void a(j paramj)
  {
    cgj = paramj;
  }
  
  public final boolean DT()
  {
    AppMethodBeat.i(174636);
    j localj = cgj;
    if (localj != null)
    {
      boolean bool = localj.DT();
      AppMethodBeat.o(174636);
      return bool;
    }
    AppMethodBeat.o(174636);
    return false;
  }
  
  public final boolean DU()
  {
    AppMethodBeat.i(201068);
    j localj = cgj;
    if (localj != null)
    {
      boolean bool = localj.DU();
      AppMethodBeat.o(201068);
      return bool;
    }
    AppMethodBeat.o(201068);
    return false;
  }
  
  public final boolean DV()
  {
    AppMethodBeat.i(201069);
    j localj = cgj;
    if (localj != null)
    {
      boolean bool = localj.DV();
      AppMethodBeat.o(201069);
      return bool;
    }
    AppMethodBeat.o(201069);
    return false;
  }
  
  public final boolean DW()
  {
    AppMethodBeat.i(201070);
    j localj = cgj;
    if (localj != null)
    {
      boolean bool = localj.DW();
      AppMethodBeat.o(201070);
      return bool;
    }
    AppMethodBeat.o(201070);
    return false;
  }
  
  public final int aF(Context paramContext)
  {
    AppMethodBeat.i(174637);
    if (paramContext == null)
    {
      AppMethodBeat.o(174637);
      return 0;
    }
    j localj = cgj;
    if (localj != null)
    {
      i = localj.aF(paramContext);
      AppMethodBeat.o(174637);
      return i;
    }
    int i = ((Number)((a)new a(paramContext)).invoke()).intValue();
    AppMethodBeat.o(174637);
    return i;
  }
  
  public final boolean aG(Context paramContext)
  {
    AppMethodBeat.i(174638);
    if (paramContext == null)
    {
      AppMethodBeat.o(174638);
      return false;
    }
    j localj = cgj;
    if (localj != null)
    {
      bool = localj.aG(paramContext);
      AppMethodBeat.o(174638);
      return bool;
    }
    boolean bool = ((Boolean)((a)new b(paramContext)).invoke()).booleanValue();
    AppMethodBeat.o(174638);
    return bool;
  }
  
  public final int aH(Context paramContext)
  {
    AppMethodBeat.i(182836);
    k.h(paramContext, "context");
    j localj = cgj;
    if (localj != null)
    {
      i = localj.aH(paramContext);
      AppMethodBeat.o(182836);
      return i;
    }
    int i = q.jx(paramContext);
    AppMethodBeat.o(182836);
    return i;
  }
  
  public final int gy(int paramInt)
  {
    AppMethodBeat.i(174635);
    j localj = cgj;
    if (localj != null)
    {
      paramInt = localj.gy(paramInt);
      AppMethodBeat.o(174635);
      return paramInt;
    }
    AppMethodBeat.o(174635);
    return paramInt;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<Integer>
  {
    a(Context paramContext)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<Boolean>
  {
    b(Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.h.i
 * JD-Core Version:    0.7.0.1
 */