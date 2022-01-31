package com.tencent.mm.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.e.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class ArtistCacheManager$a
{
  HashMap<a, e> ecp;
  
  public ArtistCacheManager$a(ArtistCacheManager paramArtistCacheManager)
  {
    AppMethodBeat.i(116208);
    this.ecp = new HashMap();
    AppMethodBeat.o(116208);
  }
  
  public final void clearAll()
  {
    AppMethodBeat.i(116209);
    Iterator localIterator = this.ecp.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((e)((Map.Entry)localIterator.next()).getValue()).onDestroy();
    }
    AppMethodBeat.o(116209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.cache.ArtistCacheManager.a
 * JD-Core Version:    0.7.0.1
 */