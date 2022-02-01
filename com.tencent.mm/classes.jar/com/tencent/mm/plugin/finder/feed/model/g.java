package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderCacheManager;", "", "()V", "adCacheManger", "Lcom/tencent/mm/plugin/finder/feed/model/FinderAdCacheManager;", "adH5CacheManger", "clear", "", "getAdCacheManager", "getH5CacheManager", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g BeY;
  private static final e BeZ;
  private static final e Bfa;
  
  static
  {
    AppMethodBeat.i(365981);
    BeY = new g();
    BeZ = new e();
    Bfa = new e();
    AppMethodBeat.o(365981);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(365971);
    BeZ.clear();
    Bfa.clear();
    AppMethodBeat.o(365971);
  }
  
  public static e edK()
  {
    return BeZ;
  }
  
  public static e edL()
  {
    return Bfa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.g
 * JD-Core Version:    0.7.0.1
 */