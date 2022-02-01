package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/util/RttStatisticsCache;", "", "()V", "RttCachePair", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "getRttCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setRttCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "averageRttCachePair", "Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "getAverageRttCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "setAverageRttCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;)V", "levelList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLevelList", "()Ljava/util/ArrayList;", "setLevelList", "(Ljava/util/ArrayList;)V", "getCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "plugin-finder-base_release"})
public final class v
{
  ArrayList<i> yPC;
  i yQT;
  e yQU;
  
  public v()
  {
    AppMethodBeat.i(263589);
    this.yQT = new i("Rtt", 0, 6);
    this.yQU = new e("AverageRtt", 14);
    this.yPC = new ArrayList();
    AppMethodBeat.o(263589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.v
 * JD-Core Version:    0.7.0.1
 */