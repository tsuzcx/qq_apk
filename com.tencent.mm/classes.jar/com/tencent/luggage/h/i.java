package com.tencent.luggage.h;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/luggage/util/UIUtilsCompat;", "Lcom/tencent/luggage/util/UIUtilsInterface;", "()V", "interfaceImpl", "getInterfaceImpl", "()Lcom/tencent/luggage/util/UIUtilsInterface;", "setInterfaceImpl", "(Lcom/tencent/luggage/util/UIUtilsInterface;)V", "getCutOutHeight", "", "context", "Landroid/content/Context;", "getDarkModeColor", "originalColor", "getStableStatusBarHeight", "hasCutOut", "", "hasHuaweiMagicWindowFeature", "huaweiSpecial", "isDarkMode", "isHuaweiFold", "luggage-commons_release"})
public final class i
  implements j
{
  public static final i cqA;
  private static j cqz;
  
  static
  {
    AppMethodBeat.i(174639);
    cqA = new i();
    AppMethodBeat.o(174639);
  }
  
  public static void a(j paramj)
  {
    cqz = paramj;
  }
  
  public final boolean Ft()
  {
    AppMethodBeat.i(187563);
    j localj = cqz;
    if (localj != null)
    {
      boolean bool = localj.Ft();
      AppMethodBeat.o(187563);
      return bool;
    }
    AppMethodBeat.o(187563);
    return false;
  }
  
  public final boolean Fu()
  {
    AppMethodBeat.i(187564);
    j localj = cqz;
    if (localj != null)
    {
      boolean bool = localj.Fu();
      AppMethodBeat.o(187564);
      return bool;
    }
    AppMethodBeat.o(187564);
    return false;
  }
  
  public final boolean Fv()
  {
    AppMethodBeat.i(187565);
    j localj = cqz;
    if (localj != null)
    {
      boolean bool = localj.Fv();
      AppMethodBeat.o(187565);
      return bool;
    }
    AppMethodBeat.o(187565);
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
    j localj = cqz;
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
    j localj = cqz;
    if (localj != null)
    {
      bool = localj.aG(paramContext);
      AppMethodBeat.o(174638);
      return bool;
    }
    boolean bool = ((Boolean)((a)new i.b(paramContext)).invoke()).booleanValue();
    AppMethodBeat.o(174638);
    return bool;
  }
  
  public final int aH(Context paramContext)
  {
    AppMethodBeat.i(182836);
    p.h(paramContext, "context");
    j localj = cqz;
    if (localj != null)
    {
      i = localj.aH(paramContext);
      AppMethodBeat.o(182836);
      return i;
    }
    int i = com.tencent.mm.ui.q.jI(paramContext);
    AppMethodBeat.o(182836);
    return i;
  }
  
  public final int gD(int paramInt)
  {
    AppMethodBeat.i(174635);
    j localj = cqz;
    if (localj != null)
    {
      paramInt = localj.gD(paramInt);
      AppMethodBeat.o(174635);
      return paramInt;
    }
    AppMethodBeat.o(174635);
    return paramInt;
  }
  
  public final boolean isDarkMode()
  {
    AppMethodBeat.i(174636);
    j localj = cqz;
    if (localj != null)
    {
      boolean bool = localj.isDarkMode();
      AppMethodBeat.o(174636);
      return bool;
    }
    AppMethodBeat.o(174636);
    return false;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.q
    implements a<Integer>
  {
    a(Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.h.i
 * JD-Core Version:    0.7.0.1
 */