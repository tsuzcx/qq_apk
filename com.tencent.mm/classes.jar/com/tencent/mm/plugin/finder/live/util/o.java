package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/util/HeightStatisticsCache;", "", "()V", "realtimeCachePair", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "getRealtimeCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setRealtimeCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "getCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "plugin-finder_release"})
public final class o
{
  private i uvU;
  
  public o()
  {
    AppMethodBeat.i(247282);
    this.uvU = new i("Height", 0, 6);
    AppMethodBeat.o(247282);
  }
  
  public final w did()
  {
    AppMethodBeat.i(247281);
    w localw = new w(this.uvU, null, null);
    AppMethodBeat.o(247281);
    return localw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.o
 * JD-Core Version:    0.7.0.1
 */