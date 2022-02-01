package com.facebook.share.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

class LikeActionController$MRUCacheWorkItem
  implements Runnable
{
  private static ArrayList<String> mruCachedItems;
  private String cacheItem;
  private boolean shouldTrim;
  
  static
  {
    AppMethodBeat.i(8038);
    mruCachedItems = new ArrayList();
    AppMethodBeat.o(8038);
  }
  
  LikeActionController$MRUCacheWorkItem(String paramString, boolean paramBoolean)
  {
    this.cacheItem = paramString;
    this.shouldTrim = paramBoolean;
  }
  
  public void run()
  {
    AppMethodBeat.i(8037);
    if (this.cacheItem != null)
    {
      mruCachedItems.remove(this.cacheItem);
      mruCachedItems.add(0, this.cacheItem);
    }
    if ((this.shouldTrim) && (mruCachedItems.size() >= 128)) {
      while (64 < mruCachedItems.size())
      {
        Object localObject = mruCachedItems;
        localObject = (String)((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1);
        LikeActionController.access$400().remove(localObject);
      }
    }
    AppMethodBeat.o(8037);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.internal.LikeActionController.MRUCacheWorkItem
 * JD-Core Version:    0.7.0.1
 */