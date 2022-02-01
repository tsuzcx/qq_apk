package com.tencent.mm.plugin.finder.feed.model;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/ICacheHelper;", "", "addCache", "", "cache", "Lcom/tencent/mm/plugin/finder/feed/model/IFinderCache;", "clearCache", "clearExpiredCache", "contains", "", "id", "", "getCache", "", "ids", "removeCache", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface o
{
  public abstract void a(q paramq);
  
  public abstract void clearCache();
  
  public abstract boolean contains(long paramLong);
  
  public abstract void nA(long paramLong);
  
  public abstract q nK(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.o
 * JD-Core Version:    0.7.0.1
 */