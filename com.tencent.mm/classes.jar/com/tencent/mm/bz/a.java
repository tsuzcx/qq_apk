package com.tencent.mm.bz;

import com.tencent.mm.api.d;
import com.tencent.mm.api.n;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.cache.g;
import com.tencent.mm.z.e;
import java.util.Iterator;
import java.util.Stack;

public final class a
  implements n
{
  private com.tencent.mm.bt.b bzV;
  
  public a(com.tencent.mm.bt.b paramb)
  {
    this.bzV = paramb;
  }
  
  public final int getTextColor()
  {
    Object localObject1 = (com.tencent.mm.cache.c)ArtistCacheManager.wL().a(com.tencent.mm.e.a.bzR);
    if (localObject1 == null) {
      return 0;
    }
    localObject1 = ((com.tencent.mm.cache.c)localObject1).dkX;
    if (localObject1 != null)
    {
      localObject1 = ((Stack)localObject1).iterator();
      int i = 0;
      label112:
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        Object localObject2 = (com.tencent.mm.z.c)((Iterator)localObject1).next();
        if ((localObject2 instanceof e))
        {
          localObject2 = (e)localObject2;
          int[] arrayOfInt = com.tencent.mm.view.footer.a.wxV;
          j = 0;
          for (;;)
          {
            if (j >= arrayOfInt.length) {
              break label112;
            }
            if (((e)localObject2).mColor == arrayOfInt[j])
            {
              i = 1 << j | i;
              break;
            }
            j += 1;
          }
        }
      }
    }
    int j = 0;
    return j;
  }
  
  public final int rY()
  {
    com.tencent.mm.cache.c localc = (com.tencent.mm.cache.c)ArtistCacheManager.wL().a(com.tencent.mm.e.a.bzR);
    if (localc == null) {
      return 0;
    }
    return localc.wT()[1];
  }
  
  public final int rZ()
  {
    com.tencent.mm.cache.c localc = (com.tencent.mm.cache.c)ArtistCacheManager.wL().a(com.tencent.mm.e.a.bzR);
    if (localc == null) {
      return 0;
    }
    return localc.wT()[0];
  }
  
  public final int sa()
  {
    g localg = (g)ArtistCacheManager.wL().a(com.tencent.mm.e.a.bzQ);
    if (localg == null) {
      return 0;
    }
    return localg.bg(false);
  }
  
  public final int sb()
  {
    com.tencent.mm.cache.b localb = (com.tencent.mm.cache.b)ArtistCacheManager.wL().a(com.tencent.mm.e.a.bzP);
    if (localb == null) {
      return 0;
    }
    return localb.bg(false);
  }
  
  public final int sc()
  {
    int i = 0;
    Object localObject = (com.tencent.mm.cache.b)ArtistCacheManager.wL().a(com.tencent.mm.e.a.bzP);
    if (localObject != null) {
      i = ((com.tencent.mm.cache.b)localObject).dkZ + 0;
    }
    localObject = (g)ArtistCacheManager.wL().a(com.tencent.mm.e.a.bzQ);
    int j = i;
    if (localObject != null) {
      j = i + ((g)localObject).dkZ;
    }
    return j;
  }
  
  public final boolean sd()
  {
    com.tencent.mm.cache.a locala = (com.tencent.mm.cache.a)ArtistCacheManager.wL().a(com.tencent.mm.e.a.bzS);
    if (locala == null) {
      return false;
    }
    return locala.bg(false) > 0;
  }
  
  public final boolean se()
  {
    boolean bool2 = false;
    com.tencent.mm.e.b localb = this.bzV.b(d.buP);
    boolean bool1 = bool2;
    if (localb != null)
    {
      bool1 = bool2;
      if (localb.tG() == com.tencent.mm.e.a.bzS) {
        if (((com.tencent.mm.e.c)localb).bAI <= 0) {
          break label47;
        }
      }
    }
    label47:
    for (bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  public final int sf()
  {
    Object localObject = (com.tencent.mm.cache.b)ArtistCacheManager.wL().a(com.tencent.mm.e.a.bzP);
    if (localObject == null) {
      return 0;
    }
    localObject = ((com.tencent.mm.cache.b)localObject).dkX;
    if (localObject != null)
    {
      localObject = ((Stack)localObject).iterator();
      int i = 0;
      label97:
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        com.tencent.mm.z.b localb = (com.tencent.mm.z.b)((Iterator)localObject).next();
        int[] arrayOfInt = com.tencent.mm.view.footer.a.wxV;
        j = 0;
        for (;;)
        {
          if (j >= arrayOfInt.length) {
            break label97;
          }
          if (localb.mColor == arrayOfInt[j])
          {
            i = 1 << j | i;
            break;
          }
          j += 1;
        }
      }
    }
    int j = 0;
    return j;
  }
  
  public final boolean sg()
  {
    com.tencent.mm.cache.b localb = (com.tencent.mm.cache.b)ArtistCacheManager.wL().a(com.tencent.mm.e.a.bzP);
    g localg = (g)ArtistCacheManager.wL().a(com.tencent.mm.e.a.bzQ);
    com.tencent.mm.cache.a locala = (com.tencent.mm.cache.a)ArtistCacheManager.wL().a(com.tencent.mm.e.a.bzS);
    com.tencent.mm.cache.c localc = (com.tencent.mm.cache.c)ArtistCacheManager.wL().a(com.tencent.mm.e.a.bzR);
    return ((localb != null) && (localb.bg(true) > 0)) || ((localg != null) && (localg.bg(true) > 0)) || ((localc != null) && (localc.bg(true) > 0)) || ((locala != null) && (locala.bg(true) > 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bz.a
 * JD-Core Version:    0.7.0.1
 */