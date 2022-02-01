package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/util/UplossStatisticsCache;", "", "()V", "UplossCachePair", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "getUplossCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setUplossCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "averageUplossCachePair", "Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "getAverageUplossCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "setAverageUplossCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;)V", "levelList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLevelList", "()Ljava/util/ArrayList;", "setLevelList", "(Ljava/util/ArrayList;)V", "getCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "plugin-finder-base_release"})
public final class aa
{
  ArrayList<i> yPC;
  i yRd;
  e yRe;
  
  public aa()
  {
    AppMethodBeat.i(260854);
    this.yRd = new i("Uploss", 0, 6);
    this.yRe = new e("AverageUploss", 14);
    this.yPC = new ArrayList();
    AppMethodBeat.o(260854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.aa
 * JD-Core Version:    0.7.0.1
 */