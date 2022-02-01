package com.tencent.luggage.h;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.p;
import d.g.a.a;
import d.g.b.k;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/luggage/util/UIUtilsCompat;", "Lcom/tencent/luggage/util/UIUtilsInterface;", "()V", "interfaceImpl", "getInterfaceImpl", "()Lcom/tencent/luggage/util/UIUtilsInterface;", "setInterfaceImpl", "(Lcom/tencent/luggage/util/UIUtilsInterface;)V", "getCutOutHeight", "", "context", "Landroid/content/Context;", "getDarkModeColor", "originalColor", "getStableStatusBarHeight", "hasCutOut", "", "hasHuaweiMagicWindowFeature", "huaweiSpecial", "isDarkMode", "isHuaweiFold", "luggage-commons_release"})
public final class i
  implements j
{
  private static j cjm;
  public static final i cjn;
  
  static
  {
    AppMethodBeat.i(174639);
    cjn = new i();
    AppMethodBeat.o(174639);
  }
  
  public static void a(j paramj)
  {
    cjm = paramj;
  }
  
  public final boolean Eq()
  {
    AppMethodBeat.i(174636);
    j localj = cjm;
    if (localj != null)
    {
      boolean bool = localj.Eq();
      AppMethodBeat.o(174636);
      return bool;
    }
    AppMethodBeat.o(174636);
    return false;
  }
  
  public final boolean Er()
  {
    AppMethodBeat.i(194913);
    j localj = cjm;
    if (localj != null)
    {
      boolean bool = localj.Er();
      AppMethodBeat.o(194913);
      return bool;
    }
    AppMethodBeat.o(194913);
    return false;
  }
  
  public final boolean Es()
  {
    AppMethodBeat.i(194914);
    j localj = cjm;
    if (localj != null)
    {
      boolean bool = localj.Es();
      AppMethodBeat.o(194914);
      return bool;
    }
    AppMethodBeat.o(194914);
    return false;
  }
  
  public final boolean Et()
  {
    AppMethodBeat.i(194915);
    j localj = cjm;
    if (localj != null)
    {
      boolean bool = localj.Et();
      AppMethodBeat.o(194915);
      return bool;
    }
    AppMethodBeat.o(194915);
    return false;
  }
  
  public final int aE(Context paramContext)
  {
    AppMethodBeat.i(174637);
    if (paramContext == null)
    {
      AppMethodBeat.o(174637);
      return 0;
    }
    j localj = cjm;
    if (localj != null)
    {
      i = localj.aE(paramContext);
      AppMethodBeat.o(174637);
      return i;
    }
    int i = ((Number)((a)new a(paramContext)).invoke()).intValue();
    AppMethodBeat.o(174637);
    return i;
  }
  
  public final boolean aF(Context paramContext)
  {
    AppMethodBeat.i(174638);
    if (paramContext == null)
    {
      AppMethodBeat.o(174638);
      return false;
    }
    j localj = cjm;
    if (localj != null)
    {
      bool = localj.aF(paramContext);
      AppMethodBeat.o(174638);
      return bool;
    }
    boolean bool = ((Boolean)((a)new b(paramContext)).invoke()).booleanValue();
    AppMethodBeat.o(174638);
    return bool;
  }
  
  public final int aG(Context paramContext)
  {
    AppMethodBeat.i(182836);
    k.h(paramContext, "context");
    j localj = cjm;
    if (localj != null)
    {
      i = localj.aG(paramContext);
      AppMethodBeat.o(182836);
      return i;
    }
    int i = p.jm(paramContext);
    AppMethodBeat.o(182836);
    return i;
  }
  
  public final int gO(int paramInt)
  {
    AppMethodBeat.i(174635);
    j localj = cjm;
    if (localj != null)
    {
      paramInt = localj.gO(paramInt);
      AppMethodBeat.o(174635);
      return paramInt;
    }
    AppMethodBeat.o(174635);
    return paramInt;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<Integer>
  {
    a(Context paramContext)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.h.i
 * JD-Core Version:    0.7.0.1
 */