package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/util/VideoBitrateStatisticsCache;", "", "()V", "VideoBitrateCachePair", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "getVideoBitrateCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setVideoBitrateCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "averageVideoBitrateCachePair", "Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "getAverageVideoBitrateCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "setAverageVideoBitrateCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;)V", "levelList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLevelList", "()Ljava/util/ArrayList;", "setLevelList", "(Ljava/util/ArrayList;)V", "getCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ae
{
  private ArrayList<i> DIj;
  private i DJP;
  private e DJQ;
  
  public ae()
  {
    AppMethodBeat.i(351248);
    this.DJP = new i("VideoBitrate", 0, 6);
    this.DJQ = new e("AverageVideoBitrate", 14);
    this.DIj = new ArrayList();
    AppMethodBeat.o(351248);
  }
  
  public final aa euo()
  {
    AppMethodBeat.i(351253);
    this.DIj.add(new i("BadVideoBitrate", 300, 4));
    this.DIj.add(new i("NormalVideoBitrate", 1800, 4));
    this.DIj.add(new i("GoodVideoBitrate", 2147483647, 4));
    aa localaa = new aa(this.DJP, this.DJQ, this.DIj);
    AppMethodBeat.o(351253);
    return localaa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.ae
 * JD-Core Version:    0.7.0.1
 */