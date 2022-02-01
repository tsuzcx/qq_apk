package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/util/FrameRateStatisticsCache;", "", "()V", "averageCachePair", "Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "getAverageCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "setAverageCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;)V", "levelList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "Lkotlin/collections/ArrayList;", "getLevelList", "()Ljava/util/ArrayList;", "setLevelList", "(Ljava/util/ArrayList;)V", "realtimeCachePair", "getRealtimeCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setRealtimeCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "getCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  private i DIh;
  private e DIi;
  private ArrayList<i> DIj;
  
  public o()
  {
    AppMethodBeat.i(351284);
    this.DIh = new i("FrameRate", 0, 6);
    this.DIi = new e("AverageFrameRate", 14);
    this.DIj = new ArrayList();
    AppMethodBeat.o(351284);
  }
  
  public final aa euo()
  {
    AppMethodBeat.i(351291);
    this.DIj.add(new i("BadFrameRate", 5, 4));
    this.DIj.add(new i("NormalFrameRate", 12, 4));
    this.DIj.add(new i("GoodFrameRate", 2147483647, 4));
    aa localaa = new aa(this.DIh, this.DIi, this.DIj);
    AppMethodBeat.o(351291);
    return localaa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.o
 * JD-Core Version:    0.7.0.1
 */