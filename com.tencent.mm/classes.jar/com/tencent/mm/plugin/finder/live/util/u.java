package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/util/RttStatisticsCache;", "", "()V", "RttCachePair", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "getRttCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setRttCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "averageRttCachePair", "Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "getAverageRttCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "setAverageRttCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;)V", "levelList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLevelList", "()Ljava/util/ArrayList;", "setLevelList", "(Ljava/util/ArrayList;)V", "getCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "plugin-finder_release"})
public final class u
{
  ArrayList<i> uvW;
  i uxk;
  e uxl;
  
  public u()
  {
    AppMethodBeat.i(247299);
    this.uxk = new i("Rtt", 0, 6);
    this.uxl = new e("AverageRtt", 14);
    this.uvW = new ArrayList();
    AppMethodBeat.o(247299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.u
 * JD-Core Version:    0.7.0.1
 */