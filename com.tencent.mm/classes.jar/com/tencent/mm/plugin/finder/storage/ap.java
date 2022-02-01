package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.plugin.teenmode.a.d;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderTeenModeConfig;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderTeenModeConfig;", "()V", "getFinderOption", "", "isTeenMode", "", "isTeenModeAndViewAll", "isTeenModeAndViewNothing", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ap
  implements bw
{
  public static final a FMy;
  
  static
  {
    AppMethodBeat.i(339036);
    FMy = new a((byte)0);
    AppMethodBeat.o(339036);
  }
  
  private static int eZD()
  {
    AppMethodBeat.i(339031);
    int i = ((d)h.ax(d.class)).eZD();
    AppMethodBeat.o(339031);
    return i;
  }
  
  public final boolean aBu()
  {
    AppMethodBeat.i(339040);
    boolean bool = ((d)h.ax(d.class)).aBu();
    AppMethodBeat.o(339040);
    return bool;
  }
  
  public final boolean eZE()
  {
    AppMethodBeat.i(339043);
    if ((aBu()) && (eZD() == 1))
    {
      AppMethodBeat.o(339043);
      return true;
    }
    AppMethodBeat.o(339043);
    return false;
  }
  
  public final boolean eZF()
  {
    AppMethodBeat.i(339046);
    if ((aBu()) && (eZD() == 2))
    {
      AppMethodBeat.o(339046);
      return true;
    }
    AppMethodBeat.o(339046);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderTeenModeConfig$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.ap
 * JD-Core Version:    0.7.0.1
 */