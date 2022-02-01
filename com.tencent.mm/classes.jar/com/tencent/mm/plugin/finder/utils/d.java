package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderAdUtil;", "", "()V", "isAdTypeMatch", "", "adType", "", "matchType", "plugin-finder_release"})
public final class d
{
  public static final d ACS;
  
  static
  {
    AppMethodBeat.i(292169);
    ACS = new d();
    AppMethodBeat.o(292169);
  }
  
  public static boolean gX(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.d
 * JD-Core Version:    0.7.0.1
 */