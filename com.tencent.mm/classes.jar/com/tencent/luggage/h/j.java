package com.tencent.luggage.h;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.r;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/util/UIUtilsCompat;", "Lcom/tencent/luggage/util/UIUtilsInterface;", "()V", "interfaceImpl", "getInterfaceImpl", "()Lcom/tencent/luggage/util/UIUtilsInterface;", "setInterfaceImpl", "(Lcom/tencent/luggage/util/UIUtilsInterface;)V", "getCutOutHeight", "", "context", "Landroid/content/Context;", "getDarkModeColor", "originalColor", "getStableStatusBarHeight", "hasCutOut", "", "hasHuaweiMagicWindowFeature", "huaweiSpecial", "isDarkMode", "isHuaweiFold", "luggage-commons_release"})
public final class j
  implements k
{
  private static k cDu;
  public static final j cDv;
  
  static
  {
    AppMethodBeat.i(174639);
    cDv = new j();
    AppMethodBeat.o(174639);
  }
  
  public static void a(k paramk)
  {
    cDu = paramk;
  }
  
  public final boolean Pi()
  {
    AppMethodBeat.i(221360);
    k localk = cDu;
    if (localk != null)
    {
      boolean bool = localk.Pi();
      AppMethodBeat.o(221360);
      return bool;
    }
    AppMethodBeat.o(221360);
    return false;
  }
  
  public final boolean Pj()
  {
    AppMethodBeat.i(221361);
    k localk = cDu;
    if (localk != null)
    {
      boolean bool = localk.Pj();
      AppMethodBeat.o(221361);
      return bool;
    }
    AppMethodBeat.o(221361);
    return false;
  }
  
  public final boolean Pk()
  {
    AppMethodBeat.i(221362);
    k localk = cDu;
    if (localk != null)
    {
      boolean bool = localk.Pk();
      AppMethodBeat.o(221362);
      return bool;
    }
    AppMethodBeat.o(221362);
    return false;
  }
  
  public final int aP(Context paramContext)
  {
    AppMethodBeat.i(174637);
    if (paramContext == null)
    {
      AppMethodBeat.o(174637);
      return 0;
    }
    k localk = cDu;
    if (localk != null)
    {
      i = localk.aP(paramContext);
      AppMethodBeat.o(174637);
      return i;
    }
    int i = ((Number)((a)new a(paramContext)).invoke()).intValue();
    AppMethodBeat.o(174637);
    return i;
  }
  
  public final boolean aQ(Context paramContext)
  {
    AppMethodBeat.i(174638);
    if (paramContext == null)
    {
      AppMethodBeat.o(174638);
      return false;
    }
    k localk = cDu;
    if (localk != null)
    {
      bool = localk.aQ(paramContext);
      AppMethodBeat.o(174638);
      return bool;
    }
    boolean bool = ((Boolean)((a)new b(paramContext)).invoke()).booleanValue();
    AppMethodBeat.o(174638);
    return bool;
  }
  
  public final int aR(Context paramContext)
  {
    AppMethodBeat.i(182836);
    p.h(paramContext, "context");
    k localk = cDu;
    if (localk != null)
    {
      i = localk.aR(paramContext);
      AppMethodBeat.o(182836);
      return i;
    }
    int i = r.jK(paramContext);
    AppMethodBeat.o(182836);
    return i;
  }
  
  public final int hT(int paramInt)
  {
    AppMethodBeat.i(174635);
    k localk = cDu;
    if (localk != null)
    {
      paramInt = localk.hT(paramInt);
      AppMethodBeat.o(174635);
      return paramInt;
    }
    AppMethodBeat.o(174635);
    return paramInt;
  }
  
  public final boolean isDarkMode()
  {
    AppMethodBeat.i(174636);
    k localk = cDu;
    if (localk != null)
    {
      boolean bool = localk.isDarkMode();
      AppMethodBeat.o(174636);
      return bool;
    }
    AppMethodBeat.o(174636);
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Integer>
  {
    a(Context paramContext)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<Boolean>
  {
    b(Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.h.j
 * JD-Core Version:    0.7.0.1
 */