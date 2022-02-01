package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/util/FrameRateStatisticsCache;", "", "()V", "averageCachePair", "Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "getAverageCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "setAverageCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;)V", "levelList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "Lkotlin/collections/ArrayList;", "getLevelList", "()Ljava/util/ArrayList;", "setLevelList", "(Ljava/util/ArrayList;)V", "realtimeCachePair", "getRealtimeCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setRealtimeCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "getCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "plugin-finder-base_release"})
public final class m
{
  private i yPA;
  private e yPB;
  private ArrayList<i> yPC;
  
  public m()
  {
    AppMethodBeat.i(263635);
    this.yPA = new i("FrameRate", 0, 6);
    this.yPB = new e("AverageFrameRate", 14);
    this.yPC = new ArrayList();
    AppMethodBeat.o(263635);
  }
  
  public final x dEo()
  {
    AppMethodBeat.i(263634);
    this.yPC.add(new i("BadFrameRate", 5, 4));
    this.yPC.add(new i("NormalFrameRate", 12, 4));
    this.yPC.add(new i("GoodFrameRate", 2147483647, 4));
    x localx = new x(this.yPA, this.yPB, this.yPC);
    AppMethodBeat.o(263634);
    return localx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.m
 * JD-Core Version:    0.7.0.1
 */