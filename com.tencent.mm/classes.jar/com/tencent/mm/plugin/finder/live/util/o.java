package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/util/HeightStatisticsCache;", "", "()V", "realtimeCachePair", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "getRealtimeCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setRealtimeCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "getCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "plugin-finder-base_release"})
public final class o
{
  private i yPA;
  
  public o()
  {
    AppMethodBeat.i(259294);
    this.yPA = new i("Height", 0, 6);
    AppMethodBeat.o(259294);
  }
  
  public final x dEo()
  {
    AppMethodBeat.i(259292);
    x localx = new x(this.yPA, null, null);
    AppMethodBeat.o(259292);
    return localx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.o
 * JD-Core Version:    0.7.0.1
 */