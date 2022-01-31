package com.tencent.mm.cache;

import com.tencent.mm.e.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class ArtistCacheManager$a
{
  public HashMap<a, d> dkV = new HashMap();
  
  public ArtistCacheManager$a(ArtistCacheManager paramArtistCacheManager) {}
  
  public final void clearAll()
  {
    Iterator localIterator = this.dkV.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((d)((Map.Entry)localIterator.next()).getValue()).onDestroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.cache.ArtistCacheManager.a
 * JD-Core Version:    0.7.0.1
 */