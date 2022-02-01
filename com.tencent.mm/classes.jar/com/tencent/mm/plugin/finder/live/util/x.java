package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "", "cache", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "averageCache", "Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "levelList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;Ljava/util/ArrayList;)V", "average", "getAverage", "()Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "setAverage", "(Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;)V", "continueFlag", "", "getContinueFlag", "()Z", "setContinueFlag", "(Z)V", "level", "getLevel", "()Ljava/util/ArrayList;", "setLevel", "(Ljava/util/ArrayList;)V", "realtime", "getRealtime", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setRealtime", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "plugin-finder-base_release"})
public final class x
{
  boolean xcp;
  i yQV;
  e yQW;
  ArrayList<i> yQX;
  
  public x(i parami, e parame, ArrayList<i> paramArrayList)
  {
    AppMethodBeat.i(258627);
    this.xcp = true;
    this.yQV = parami;
    this.yQW = parame;
    this.yQX = paramArrayList;
    AppMethodBeat.o(258627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.x
 * JD-Core Version:    0.7.0.1
 */