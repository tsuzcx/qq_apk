package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "", "cache", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "averageCache", "Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "levelList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;Ljava/util/ArrayList;)V", "average", "getAverage", "()Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "setAverage", "(Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;)V", "continueFlag", "", "getContinueFlag", "()Z", "setContinueFlag", "(Z)V", "level", "getLevel", "()Ljava/util/ArrayList;", "setLevel", "(Ljava/util/ArrayList;)V", "realtime", "getRealtime", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setRealtime", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "plugin-finder_release"})
public final class w
{
  boolean tuG;
  public i uxm;
  public e uxn;
  ArrayList<i> uxo;
  
  public w(i parami, e parame, ArrayList<i> paramArrayList)
  {
    AppMethodBeat.i(247301);
    this.tuG = true;
    this.uxm = parami;
    this.uxn = parame;
    this.uxo = paramArrayList;
    AppMethodBeat.o(247301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.w
 * JD-Core Version:    0.7.0.1
 */