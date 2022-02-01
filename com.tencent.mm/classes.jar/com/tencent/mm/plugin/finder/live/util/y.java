package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/util/RttStatisticsCache;", "", "()V", "RttCachePair", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "getRttCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setRttCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "averageRttCachePair", "Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "getAverageRttCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "setAverageRttCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;)V", "levelList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLevelList", "()Ljava/util/ArrayList;", "setLevelList", "(Ljava/util/ArrayList;)V", "getCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class y
{
  ArrayList<i> DIj;
  i DJD;
  e DJE;
  
  public y()
  {
    AppMethodBeat.i(351265);
    this.DJD = new i("Rtt", 0, 6);
    this.DJE = new e("AverageRtt", 14);
    this.DIj = new ArrayList();
    AppMethodBeat.o(351265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.y
 * JD-Core Version:    0.7.0.1
 */