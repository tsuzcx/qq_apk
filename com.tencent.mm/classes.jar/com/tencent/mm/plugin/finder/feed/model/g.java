package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderCacheManager;", "", "()V", "adCacheManger", "Lcom/tencent/mm/plugin/finder/feed/model/FinderAdCacheManager;", "adH5CacheManger", "clear", "", "getAdCacheManager", "getH5CacheManager", "plugin-finder_release"})
public final class g
{
  private static final e xGg;
  private static final e xGh;
  public static final g xGi;
  
  static
  {
    AppMethodBeat.i(285887);
    xGi = new g();
    xGg = new e();
    xGh = new e();
    AppMethodBeat.o(285887);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(285886);
    xGg.clear();
    xGh.clear();
    AppMethodBeat.o(285886);
  }
  
  public static e dul()
  {
    return xGg;
  }
  
  public static e dum()
  {
    return xGh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.g
 * JD-Core Version:    0.7.0.1
 */