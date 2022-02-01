package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/util/DownlossStatisticsCache;", "", "()V", "DownlossCachePair", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "getDownlossCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setDownlossCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "averageDownlossCachePair", "Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "getAverageDownlossCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "setAverageDownlossCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;)V", "levelList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLevelList", "()Ljava/util/ArrayList;", "setLevelList", "(Ljava/util/ArrayList;)V", "getCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  i DIY;
  e DIZ;
  ArrayList<i> DIj;
  
  public k()
  {
    AppMethodBeat.i(351277);
    this.DIY = new i("Downloss", 0, 6);
    this.DIZ = new e("AverageDownloss", 14);
    this.DIj = new ArrayList();
    AppMethodBeat.o(351277);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.k
 * JD-Core Version:    0.7.0.1
 */