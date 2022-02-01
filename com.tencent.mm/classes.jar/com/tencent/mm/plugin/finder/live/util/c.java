package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/util/AppCpuStatisticsCache;", "", "()V", "averageCpuCachePair", "Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "getAverageCpuCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "setAverageCpuCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;)V", "cpuCachePair", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "getCpuCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setCpuCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "levelList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLevelList", "()Ljava/util/ArrayList;", "setLevelList", "(Ljava/util/ArrayList;)V", "getCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private ArrayList<i> DIj;
  private i DIk;
  private e DIl;
  
  public c()
  {
    AppMethodBeat.i(351308);
    this.DIk = new i("AppCpu", 0, 6);
    this.DIl = new e("AverageAppCpu", 14);
    this.DIj = new ArrayList();
    AppMethodBeat.o(351308);
  }
  
  public final aa euo()
  {
    AppMethodBeat.i(351324);
    this.DIj.add(new i("GoodCpu", 20, 4));
    this.DIj.add(new i("NormalCpu", 60, 4));
    this.DIj.add(new i("BadCpu", 100, 4));
    aa localaa = new aa(this.DIk, this.DIl, this.DIj);
    AppMethodBeat.o(351324);
    return localaa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.c
 * JD-Core Version:    0.7.0.1
 */