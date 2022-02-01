package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/util/AudioBitrateStatisticsCache;", "", "()V", "averageCachePair", "Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "getAverageCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "setAverageCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;)V", "levelList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "Lkotlin/collections/ArrayList;", "getLevelList", "()Ljava/util/ArrayList;", "setLevelList", "(Ljava/util/ArrayList;)V", "realtimeCachePair", "getRealtimeCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setRealtimeCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "getCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  private i DIh;
  private e DIi;
  private ArrayList<i> DIj;
  
  public d()
  {
    AppMethodBeat.i(351336);
    this.DIh = new i("AudioBitrate", 0, 6);
    this.DIi = new e("AverageAudioBitrate", 14);
    this.DIj = new ArrayList();
    AppMethodBeat.o(351336);
  }
  
  public final aa euo()
  {
    AppMethodBeat.i(351344);
    this.DIj.add(new i("BadAudioBitrate", 10, 4));
    this.DIj.add(new i("NormalAudioBitrate", 30, 4));
    this.DIj.add(new i("GoodAudioBitrate", 2147483647, 4));
    aa localaa = new aa(this.DIh, this.DIi, this.DIj);
    AppMethodBeat.o(351344);
    return localaa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.d
 * JD-Core Version:    0.7.0.1
 */