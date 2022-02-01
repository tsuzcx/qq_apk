package com.tencent.luggage.k;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.t;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/util/UIUtilsCompat;", "Lcom/tencent/luggage/util/UIUtilsInterface;", "()V", "interfaceImpl", "getInterfaceImpl", "()Lcom/tencent/luggage/util/UIUtilsInterface;", "setInterfaceImpl", "(Lcom/tencent/luggage/util/UIUtilsInterface;)V", "getCutOutHeight", "", "context", "Landroid/content/Context;", "getDarkModeColor", "originalColor", "getStableStatusBarHeight", "hasCutOut", "", "huaweiSpecial", "isDarkMode", "isDarkModeForWeApp", "appId", "", "isHuaweiFold", "luggage-commons_release"})
public final class j
  implements k
{
  private static k cEb;
  public static final j cEc;
  
  static
  {
    AppMethodBeat.i(174639);
    cEc = new j();
    AppMethodBeat.o(174639);
  }
  
  public static void a(k paramk)
  {
    cEb = paramk;
  }
  
  public final boolean SI()
  {
    AppMethodBeat.i(208328);
    k localk = cEb;
    if (localk != null)
    {
      boolean bool = localk.SI();
      AppMethodBeat.o(208328);
      return bool;
    }
    AppMethodBeat.o(208328);
    return false;
  }
  
  public final boolean SJ()
  {
    AppMethodBeat.i(208329);
    k localk = cEb;
    if (localk != null)
    {
      boolean bool = localk.SJ();
      AppMethodBeat.o(208329);
      return bool;
    }
    AppMethodBeat.o(208329);
    return false;
  }
  
  public final int aM(Context paramContext)
  {
    AppMethodBeat.i(174637);
    if (paramContext == null)
    {
      AppMethodBeat.o(174637);
      return 0;
    }
    k localk = cEb;
    if (localk != null)
    {
      i = localk.aM(paramContext);
      AppMethodBeat.o(174637);
      return i;
    }
    int i = ((Number)((a)new j.a(paramContext)).invoke()).intValue();
    AppMethodBeat.o(174637);
    return i;
  }
  
  public final boolean aN(Context paramContext)
  {
    AppMethodBeat.i(174638);
    if (paramContext == null)
    {
      AppMethodBeat.o(174638);
      return false;
    }
    k localk = cEb;
    if (localk != null)
    {
      bool = localk.aN(paramContext);
      AppMethodBeat.o(174638);
      return bool;
    }
    boolean bool = ((Boolean)((a)new b(paramContext)).invoke()).booleanValue();
    AppMethodBeat.o(174638);
    return bool;
  }
  
  public final int aO(Context paramContext)
  {
    AppMethodBeat.i(182836);
    p.k(paramContext, "context");
    k localk = cEb;
    if (localk != null)
    {
      i = localk.aO(paramContext);
      AppMethodBeat.o(182836);
      return i;
    }
    int i = t.kJ(paramContext);
    AppMethodBeat.o(182836);
    return i;
  }
  
  public final boolean em(String paramString)
  {
    AppMethodBeat.i(208323);
    k localk = cEb;
    if (localk != null)
    {
      boolean bool = localk.em(paramString);
      AppMethodBeat.o(208323);
      return bool;
    }
    AppMethodBeat.o(208323);
    return false;
  }
  
  public final int iV(int paramInt)
  {
    AppMethodBeat.i(174635);
    k localk = cEb;
    if (localk != null)
    {
      paramInt = localk.iV(paramInt);
      AppMethodBeat.o(174635);
      return paramInt;
    }
    AppMethodBeat.o(174635);
    return paramInt;
  }
  
  public final boolean isDarkMode()
  {
    AppMethodBeat.i(174636);
    k localk = cEb;
    if (localk != null)
    {
      boolean bool = localk.isDarkMode();
      AppMethodBeat.o(174636);
      return bool;
    }
    AppMethodBeat.o(174636);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.k.j
 * JD-Core Version:    0.7.0.1
 */