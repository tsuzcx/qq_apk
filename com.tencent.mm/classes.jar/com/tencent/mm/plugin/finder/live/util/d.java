package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/util/AudioBitrateStatisticsCache;", "", "()V", "averageCachePair", "Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "getAverageCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "setAverageCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;)V", "levelList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "Lkotlin/collections/ArrayList;", "getLevelList", "()Ljava/util/ArrayList;", "setLevelList", "(Ljava/util/ArrayList;)V", "realtimeCachePair", "getRealtimeCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setRealtimeCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "getCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "plugin-finder_release"})
public final class d
{
  private i uvU;
  private e uvV;
  private ArrayList<i> uvW;
  
  public d()
  {
    AppMethodBeat.i(247228);
    this.uvU = new i("AudioBitrate", 0, 6);
    this.uvV = new e("AverageAudioBitrate", 14);
    this.uvW = new ArrayList();
    AppMethodBeat.o(247228);
  }
  
  public final w did()
  {
    AppMethodBeat.i(247227);
    this.uvW.add(new i("BadAudioBitrate", 10, 4));
    this.uvW.add(new i("NormalAudioBitrate", 30, 4));
    this.uvW.add(new i("GoodAudioBitrate", 2147483647, 4));
    w localw = new w(this.uvU, this.uvV, this.uvW);
    AppMethodBeat.o(247227);
    return localw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.d
 * JD-Core Version:    0.7.0.1
 */