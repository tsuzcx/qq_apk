package com.tencent.luggage.h;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.q;
import d.g.a.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/luggage/util/UIUtilsCompat;", "Lcom/tencent/luggage/util/UIUtilsInterface;", "()V", "interfaceImpl", "getInterfaceImpl", "()Lcom/tencent/luggage/util/UIUtilsInterface;", "setInterfaceImpl", "(Lcom/tencent/luggage/util/UIUtilsInterface;)V", "getCutOutHeight", "", "context", "Landroid/content/Context;", "getDarkModeColor", "originalColor", "getStableStatusBarHeight", "hasCutOut", "", "hasHuaweiMagicWindowFeature", "huaweiSpecial", "isDarkMode", "isHuaweiFold", "luggage-commons_release"})
public final class i
  implements j
{
  private static j crd;
  public static final i cre;
  
  static
  {
    AppMethodBeat.i(174639);
    cre = new i();
    AppMethodBeat.o(174639);
  }
  
  public static void a(j paramj)
  {
    crd = paramj;
  }
  
  public final boolean FA()
  {
    AppMethodBeat.i(201131);
    j localj = crd;
    if (localj != null)
    {
      boolean bool = localj.FA();
      AppMethodBeat.o(201131);
      return bool;
    }
    AppMethodBeat.o(201131);
    return false;
  }
  
  public final boolean FB()
  {
    AppMethodBeat.i(201132);
    j localj = crd;
    if (localj != null)
    {
      boolean bool = localj.FB();
      AppMethodBeat.o(201132);
      return bool;
    }
    AppMethodBeat.o(201132);
    return false;
  }
  
  public final boolean Fz()
  {
    AppMethodBeat.i(201130);
    j localj = crd;
    if (localj != null)
    {
      boolean bool = localj.Fz();
      AppMethodBeat.o(201130);
      return bool;
    }
    AppMethodBeat.o(201130);
    return false;
  }
  
  public final int aG(Context paramContext)
  {
    AppMethodBeat.i(174637);
    if (paramContext == null)
    {
      AppMethodBeat.o(174637);
      return 0;
    }
    j localj = crd;
    if (localj != null)
    {
      i = localj.aG(paramContext);
      AppMethodBeat.o(174637);
      return i;
    }
    int i = ((Number)((a)new i.a(paramContext)).invoke()).intValue();
    AppMethodBeat.o(174637);
    return i;
  }
  
  public final boolean aH(Context paramContext)
  {
    AppMethodBeat.i(174638);
    if (paramContext == null)
    {
      AppMethodBeat.o(174638);
      return false;
    }
    j localj = crd;
    if (localj != null)
    {
      bool = localj.aH(paramContext);
      AppMethodBeat.o(174638);
      return bool;
    }
    boolean bool = ((Boolean)((a)new i.b(paramContext)).invoke()).booleanValue();
    AppMethodBeat.o(174638);
    return bool;
  }
  
  public final int aI(Context paramContext)
  {
    AppMethodBeat.i(182836);
    p.h(paramContext, "context");
    j localj = crd;
    if (localj != null)
    {
      i = localj.aI(paramContext);
      AppMethodBeat.o(182836);
      return i;
    }
    int i = q.jP(paramContext);
    AppMethodBeat.o(182836);
    return i;
  }
  
  public final int gE(int paramInt)
  {
    AppMethodBeat.i(174635);
    j localj = crd;
    if (localj != null)
    {
      paramInt = localj.gE(paramInt);
      AppMethodBeat.o(174635);
      return paramInt;
    }
    AppMethodBeat.o(174635);
    return paramInt;
  }
  
  public final boolean isDarkMode()
  {
    AppMethodBeat.i(174636);
    j localj = crd;
    if (localj != null)
    {
      boolean bool = localj.isDarkMode();
      AppMethodBeat.o(174636);
      return bool;
    }
    AppMethodBeat.o(174636);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.h.i
 * JD-Core Version:    0.7.0.1
 */