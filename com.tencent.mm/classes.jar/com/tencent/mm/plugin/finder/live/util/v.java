package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/util/SendBytesStatisticsCache;", "", "()V", "averageCachePair", "Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "getAverageCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "setAverageCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;)V", "levelList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "Lkotlin/collections/ArrayList;", "getLevelList", "()Ljava/util/ArrayList;", "setLevelList", "(Ljava/util/ArrayList;)V", "realtimeCachePair", "getRealtimeCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setRealtimeCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "getCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "plugin-finder_release"})
public final class v
{
  i uvU;
  e uvV;
  ArrayList<i> uvW;
  
  public v()
  {
    AppMethodBeat.i(247300);
    this.uvU = new i("SendBytes", 0, 6);
    this.uvV = new e("AverageSendBytes", 14);
    this.uvW = new ArrayList();
    AppMethodBeat.o(247300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.v
 * JD-Core Version:    0.7.0.1
 */