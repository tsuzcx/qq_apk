package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/util/NetJitStatisticsCache;", "", "()V", "averageCachePair", "Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "getAverageCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "setAverageCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;)V", "levelList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "Lkotlin/collections/ArrayList;", "getLevelList", "()Ljava/util/ArrayList;", "setLevelList", "(Ljava/util/ArrayList;)V", "realtimeCachePair", "getRealtimeCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setRealtimeCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "getCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "plugin-finder_release"})
public final class r
{
  i uvU;
  e uvV;
  ArrayList<i> uvW;
  
  public r()
  {
    AppMethodBeat.i(247296);
    this.uvU = new i("NetJit", 0, 6);
    this.uvV = new e("AverageNetJit", 14);
    this.uvW = new ArrayList();
    AppMethodBeat.o(247296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.r
 * JD-Core Version:    0.7.0.1
 */