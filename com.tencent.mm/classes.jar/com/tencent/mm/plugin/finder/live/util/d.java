package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/util/AudioBitrateStatisticsCache;", "", "()V", "averageCachePair", "Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "getAverageCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "setAverageCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;)V", "levelList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "Lkotlin/collections/ArrayList;", "getLevelList", "()Ljava/util/ArrayList;", "setLevelList", "(Ljava/util/ArrayList;)V", "realtimeCachePair", "getRealtimeCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setRealtimeCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "getCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "plugin-finder-base_release"})
public final class d
{
  private i yPA;
  private e yPB;
  private ArrayList<i> yPC;
  
  public d()
  {
    AppMethodBeat.i(258976);
    this.yPA = new i("AudioBitrate", 0, 6);
    this.yPB = new e("AverageAudioBitrate", 14);
    this.yPC = new ArrayList();
    AppMethodBeat.o(258976);
  }
  
  public final x dEo()
  {
    AppMethodBeat.i(258975);
    this.yPC.add(new i("BadAudioBitrate", 10, 4));
    this.yPC.add(new i("NormalAudioBitrate", 30, 4));
    this.yPC.add(new i("GoodAudioBitrate", 2147483647, 4));
    x localx = new x(this.yPA, this.yPB, this.yPC);
    AppMethodBeat.o(258975);
    return localx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.d
 * JD-Core Version:    0.7.0.1
 */