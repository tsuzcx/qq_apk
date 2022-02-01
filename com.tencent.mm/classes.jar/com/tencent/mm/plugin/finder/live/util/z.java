package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/util/UplossStatisticsCache;", "", "()V", "UplossCachePair", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "getUplossCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setUplossCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "averageUplossCachePair", "Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "getAverageUplossCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "setAverageUplossCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;)V", "levelList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLevelList", "()Ljava/util/ArrayList;", "setLevelList", "(Ljava/util/ArrayList;)V", "getCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "plugin-finder_release"})
public final class z
{
  ArrayList<i> uvW;
  i uxu;
  e uxv;
  
  public z()
  {
    AppMethodBeat.i(247305);
    this.uxu = new i("Uploss", 0, 6);
    this.uxv = new e("AverageUploss", 14);
    this.uvW = new ArrayList();
    AppMethodBeat.o(247305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.z
 * JD-Core Version:    0.7.0.1
 */