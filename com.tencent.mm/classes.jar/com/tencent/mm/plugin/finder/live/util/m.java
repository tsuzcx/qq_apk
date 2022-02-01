package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/util/FrameRateStatisticsCache;", "", "()V", "averageCachePair", "Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "getAverageCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "setAverageCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;)V", "levelList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "Lkotlin/collections/ArrayList;", "getLevelList", "()Ljava/util/ArrayList;", "setLevelList", "(Ljava/util/ArrayList;)V", "realtimeCachePair", "getRealtimeCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setRealtimeCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "getCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "plugin-finder_release"})
public final class m
{
  private i uvU;
  private e uvV;
  private ArrayList<i> uvW;
  
  public m()
  {
    AppMethodBeat.i(247265);
    this.uvU = new i("FrameRate", 0, 6);
    this.uvV = new e("AverageFrameRate", 14);
    this.uvW = new ArrayList();
    AppMethodBeat.o(247265);
  }
  
  public final w did()
  {
    AppMethodBeat.i(247264);
    this.uvW.add(new i("BadFrameRate", 5, 4));
    this.uvW.add(new i("NormalFrameRate", 12, 4));
    this.uvW.add(new i("GoodFrameRate", 2147483647, 4));
    w localw = new w(this.uvU, this.uvV, this.uvW);
    AppMethodBeat.o(247264);
    return localw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.m
 * JD-Core Version:    0.7.0.1
 */