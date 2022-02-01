package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/util/VideoBitrateStatisticsCache;", "", "()V", "VideoBitrateCachePair", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "getVideoBitrateCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setVideoBitrateCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "averageVideoBitrateCachePair", "Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "getAverageVideoBitrateCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "setAverageVideoBitrateCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;)V", "levelList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLevelList", "()Ljava/util/ArrayList;", "setLevelList", "(Ljava/util/ArrayList;)V", "getCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "plugin-finder-base_release"})
public final class ab
{
  private ArrayList<i> yPC;
  private i yRf;
  private e yRg;
  
  public ab()
  {
    AppMethodBeat.i(258501);
    this.yRf = new i("VideoBitrate", 0, 6);
    this.yRg = new e("AverageVideoBitrate", 14);
    this.yPC = new ArrayList();
    AppMethodBeat.o(258501);
  }
  
  public final x dEo()
  {
    AppMethodBeat.i(258499);
    this.yPC.add(new i("BadVideoBitrate", 300, 4));
    this.yPC.add(new i("NormalVideoBitrate", 1800, 4));
    this.yPC.add(new i("GoodVideoBitrate", 2147483647, 4));
    x localx = new x(this.yRf, this.yRg, this.yPC);
    AppMethodBeat.o(258499);
    return localx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.ab
 * JD-Core Version:    0.7.0.1
 */