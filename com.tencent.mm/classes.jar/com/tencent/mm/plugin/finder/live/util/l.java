package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/util/DownlossStatisticsCache;", "", "()V", "DownlossCachePair", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "getDownlossCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setDownlossCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "averageDownlossCachePair", "Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "getAverageDownlossCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "setAverageDownlossCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;)V", "levelList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLevelList", "()Ljava/util/ArrayList;", "setLevelList", "(Ljava/util/ArrayList;)V", "getCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "plugin-finder_release"})
public final class l
{
  ArrayList<i> uvW;
  i uwM;
  e uwN;
  
  public l()
  {
    AppMethodBeat.i(247263);
    this.uwM = new i("Downloss", 0, 6);
    this.uwN = new e("AverageDownloss", 14);
    this.uvW = new ArrayList();
    AppMethodBeat.o(247263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.l
 * JD-Core Version:    0.7.0.1
 */