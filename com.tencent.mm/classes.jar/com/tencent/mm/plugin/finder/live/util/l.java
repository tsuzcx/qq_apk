package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/util/DownlossStatisticsCache;", "", "()V", "DownlossCachePair", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "getDownlossCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setDownlossCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "averageDownlossCachePair", "Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "getAverageDownlossCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "setAverageDownlossCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;)V", "levelList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLevelList", "()Ljava/util/ArrayList;", "setLevelList", "(Ljava/util/ArrayList;)V", "getCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "plugin-finder-base_release"})
public final class l
{
  ArrayList<i> yPC;
  i yQt;
  e yQu;
  
  public l()
  {
    AppMethodBeat.i(259402);
    this.yQt = new i("Downloss", 0, 6);
    this.yQu = new e("AverageDownloss", 14);
    this.yPC = new ArrayList();
    AppMethodBeat.o(259402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.l
 * JD-Core Version:    0.7.0.1
 */