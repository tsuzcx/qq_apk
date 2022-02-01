package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/util/AppCpuStatisticsCache;", "", "()V", "averageCpuCachePair", "Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "getAverageCpuCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "setAverageCpuCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;)V", "cpuCachePair", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "getCpuCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setCpuCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "levelList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLevelList", "()Ljava/util/ArrayList;", "setLevelList", "(Ljava/util/ArrayList;)V", "getCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "plugin-finder-base_release"})
public final class c
{
  private ArrayList<i> yPC;
  private i yPD;
  private e yPE;
  
  public c()
  {
    AppMethodBeat.i(259985);
    this.yPD = new i("AppCpu", 0, 6);
    this.yPE = new e("AverageAppCpu", 14);
    this.yPC = new ArrayList();
    AppMethodBeat.o(259985);
  }
  
  public final x dEo()
  {
    AppMethodBeat.i(259984);
    this.yPC.add(new i("GoodCpu", 20, 4));
    this.yPC.add(new i("NormalCpu", 60, 4));
    this.yPC.add(new i("BadCpu", 100, 4));
    x localx = new x(this.yPD, this.yPE, this.yPC);
    AppMethodBeat.o(259984);
    return localx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.c
 * JD-Core Version:    0.7.0.1
 */