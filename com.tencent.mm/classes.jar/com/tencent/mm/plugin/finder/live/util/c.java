package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/util/AppCpuStatisticsCache;", "", "()V", "averageCpuCachePair", "Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "getAverageCpuCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "setAverageCpuCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;)V", "cpuCachePair", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "getCpuCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setCpuCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "levelList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLevelList", "()Ljava/util/ArrayList;", "setLevelList", "(Ljava/util/ArrayList;)V", "getCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "plugin-finder_release"})
public final class c
{
  private ArrayList<i> uvW;
  private i uvX;
  private e uvY;
  
  public c()
  {
    AppMethodBeat.i(247226);
    this.uvX = new i("AppCpu", 0, 6);
    this.uvY = new e("AverageAppCpu", 14);
    this.uvW = new ArrayList();
    AppMethodBeat.o(247226);
  }
  
  public final w did()
  {
    AppMethodBeat.i(247225);
    this.uvW.add(new i("GoodCpu", 20, 4));
    this.uvW.add(new i("NormalCpu", 60, 4));
    this.uvW.add(new i("BadCpu", 100, 4));
    w localw = new w(this.uvX, this.uvY, this.uvW);
    AppMethodBeat.o(247225);
    return localw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.c
 * JD-Core Version:    0.7.0.1
 */