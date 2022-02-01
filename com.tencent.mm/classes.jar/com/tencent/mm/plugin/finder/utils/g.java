package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderAdUtil;", "", "()V", "isAdTypeMatch", "", "adType", "", "matchType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g GfZ;
  
  static
  {
    AppMethodBeat.i(333794);
    GfZ = new g();
    AppMethodBeat.o(333794);
  }
  
  public static boolean io(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.g
 * JD-Core Version:    0.7.0.1
 */