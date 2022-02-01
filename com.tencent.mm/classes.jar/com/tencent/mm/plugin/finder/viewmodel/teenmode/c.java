package com.tencent.mm.plugin.finder.viewmodel.teenmode;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/teenmode/FinderTeenModeLimitConfig;", "", "()V", "FINDER_TEEN_MODE_CHECK_TIMER_INTERVAL_MS", "", "getFinderAntiAddictDarkEndTime", "", "getFinderAntiAddictDarkStartTime", "getFinderAntiAddictInterval", "isEnableAntiAddictDebugMode", "", "isOpenCheckAntiAddictSwitch", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c GWG;
  
  static
  {
    AppMethodBeat.i(337374);
    GWG = new c();
    AppMethodBeat.o(337374);
  }
  
  public static int fpA()
  {
    AppMethodBeat.i(337348);
    if (fpD())
    {
      AppMethodBeat.o(337348);
      return 10;
    }
    int i = i.aRC().getInt("FinderAntiAddictInterval", 2400);
    AppMethodBeat.o(337348);
    return i;
  }
  
  public static int fpB()
  {
    AppMethodBeat.i(337357);
    if (fpD())
    {
      AppMethodBeat.o(337357);
      return 0;
    }
    int i = i.aRC().getInt("FinderAntiAddictDarkStartTime", 22);
    AppMethodBeat.o(337357);
    return i;
  }
  
  public static int fpC()
  {
    AppMethodBeat.i(337363);
    int i = i.aRC().getInt("FinderAntiAddictDarkEndTime", 6);
    AppMethodBeat.o(337363);
    return i;
  }
  
  private static boolean fpD()
  {
    AppMethodBeat.i(337369);
    d locald = d.FAy;
    if (((Number)d.eXC().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(337369);
      return true;
    }
    AppMethodBeat.o(337369);
    return false;
  }
  
  public static boolean fpz()
  {
    AppMethodBeat.i(337340);
    if ((i.aRC().getInt("FinderOpenCheckAntiAddictSwitch", 1) == 1) || (fpD()))
    {
      AppMethodBeat.o(337340);
      return true;
    }
    AppMethodBeat.o(337340);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.teenmode.c
 * JD-Core Version:    0.7.0.1
 */