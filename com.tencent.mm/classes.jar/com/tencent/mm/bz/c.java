package com.tencent.mm.bz;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.p;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.cache.d;
import com.tencent.mm.cache.h;
import java.util.Iterator;
import java.util.Stack;

public final class c
  implements p
{
  private boolean bRn = true;
  private com.tencent.mm.bs.b ccS;
  
  public c(com.tencent.mm.bs.b paramb)
  {
    this.ccS = paramb;
  }
  
  public final int Am()
  {
    AppMethodBeat.i(116356);
    d locald = (d)ArtistCacheManager.Jb().a(com.tencent.mm.e.a.ccO);
    if (locald == null)
    {
      AppMethodBeat.o(116356);
      return 0;
    }
    int i = locald.bI(this.bRn)[1];
    AppMethodBeat.o(116356);
    return i;
  }
  
  public final int An()
  {
    AppMethodBeat.i(116357);
    d locald = (d)ArtistCacheManager.Jb().a(com.tencent.mm.e.a.ccO);
    if (locald == null)
    {
      AppMethodBeat.o(116357);
      return 0;
    }
    int i = locald.bI(this.bRn)[0];
    AppMethodBeat.o(116357);
    return i;
  }
  
  public final int Ao()
  {
    AppMethodBeat.i(116358);
    h localh = (h)ArtistCacheManager.Jb().a(com.tencent.mm.e.a.ccN);
    if (localh == null)
    {
      AppMethodBeat.o(116358);
      return 0;
    }
    int i = localh.ad(this.bRn);
    AppMethodBeat.o(116358);
    return i;
  }
  
  public final int Ap()
  {
    AppMethodBeat.i(116359);
    com.tencent.mm.cache.b localb = (com.tencent.mm.cache.b)ArtistCacheManager.Jb().a(com.tencent.mm.e.a.ccM);
    if (localb == null)
    {
      AppMethodBeat.o(116359);
      return 0;
    }
    int i = localb.ad(this.bRn);
    AppMethodBeat.o(116359);
    return i;
  }
  
  public final int Aq()
  {
    AppMethodBeat.i(116360);
    int i = 0;
    Object localObject = (com.tencent.mm.cache.b)ArtistCacheManager.Jb().a(com.tencent.mm.e.a.ccM);
    if (localObject != null) {
      i = ((com.tencent.mm.cache.b)localObject).ect + 0;
    }
    localObject = (h)ArtistCacheManager.Jb().a(com.tencent.mm.e.a.ccN);
    int j = i;
    if (localObject != null) {
      j = i + ((h)localObject).ect;
    }
    AppMethodBeat.o(116360);
    return j;
  }
  
  public final boolean Ar()
  {
    boolean bool2 = false;
    AppMethodBeat.i(116362);
    com.tencent.mm.e.b localb = this.ccS.c(com.tencent.mm.api.e.bWa);
    boolean bool1 = bool2;
    if (localb != null)
    {
      bool1 = bool2;
      if (localb.Cz() == com.tencent.mm.e.a.ccP) {
        if (((com.tencent.mm.e.c)localb).getRotation() == 0.0F) {
          break label59;
        }
      }
    }
    label59:
    for (bool1 = true;; bool1 = false)
    {
      AppMethodBeat.o(116362);
      return bool1;
    }
  }
  
  public final int As()
  {
    AppMethodBeat.i(116364);
    Object localObject = (com.tencent.mm.cache.b)ArtistCacheManager.Jb().a(com.tencent.mm.e.a.ccM);
    if (localObject == null)
    {
      AppMethodBeat.o(116364);
      return 0;
    }
    int[] arrayOfInt1 = new int[com.tencent.mm.view.footer.a.ATm.length];
    if (this.bRn)
    {
      localObject = ((com.tencent.mm.cache.b)localObject).ecq;
      if (localObject != null) {
        localObject = ((Stack)localObject).iterator();
      }
    }
    else
    {
      label141:
      for (;;)
      {
        label65:
        if (!((Iterator)localObject).hasNext()) {
          break label143;
        }
        com.tencent.mm.y.b localb = (com.tencent.mm.y.b)((Iterator)localObject).next();
        int[] arrayOfInt2 = com.tencent.mm.view.footer.a.ATm;
        i = 0;
        for (;;)
        {
          if (i >= arrayOfInt2.length) {
            break label141;
          }
          if (localb.mColor == arrayOfInt2[i])
          {
            arrayOfInt1[i] += 1;
            break label65;
            localObject = ((com.tencent.mm.cache.b)localObject).ecr;
            break;
          }
          i += 1;
        }
      }
    }
    label143:
    int m = arrayOfInt1.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (arrayOfInt1[i] > 0) {
        k = j + 1;
      }
      i += 1;
    }
    AppMethodBeat.o(116364);
    return j;
  }
  
  public final boolean At()
  {
    AppMethodBeat.i(116365);
    com.tencent.mm.cache.b localb = (com.tencent.mm.cache.b)ArtistCacheManager.Jb().a(com.tencent.mm.e.a.ccM);
    h localh = (h)ArtistCacheManager.Jb().a(com.tencent.mm.e.a.ccN);
    com.tencent.mm.cache.a locala = (com.tencent.mm.cache.a)ArtistCacheManager.Jb().a(com.tencent.mm.e.a.ccP);
    d locald = (d)ArtistCacheManager.Jb().a(com.tencent.mm.e.a.ccO);
    if (((localb != null) && (localb.ad(true) > 0)) || ((localh != null) && (localh.ad(true) > 0)) || ((locald != null) && (locald.ad(true) > 0)) || ((locala != null) && (locala.ad(true) > 0)))
    {
      AppMethodBeat.o(116365);
      return true;
    }
    AppMethodBeat.o(116365);
    return false;
  }
  
  public final String Au()
  {
    AppMethodBeat.i(116366);
    String str = ((d)ArtistCacheManager.Jb().a(com.tencent.mm.e.a.ccO)).kR(",")[0];
    AppMethodBeat.o(116366);
    return str;
  }
  
  public final String Av()
  {
    AppMethodBeat.i(116367);
    String str = ((d)ArtistCacheManager.Jb().a(com.tencent.mm.e.a.ccO)).kR("||")[1];
    AppMethodBeat.o(116367);
    return str;
  }
  
  public final int getTextColor()
  {
    AppMethodBeat.i(116363);
    Object localObject1 = (d)ArtistCacheManager.Jb().a(com.tencent.mm.e.a.ccO);
    if (localObject1 == null)
    {
      AppMethodBeat.o(116363);
      return 0;
    }
    int i;
    if (this.bRn)
    {
      localObject1 = ((d)localObject1).ecq;
      if (localObject1 != null)
      {
        localObject1 = ((Stack)localObject1).iterator();
        i = 0;
      }
    }
    else
    {
      label137:
      for (;;)
      {
        label52:
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break label141;
        }
        Object localObject2 = (com.tencent.mm.y.c)((Iterator)localObject1).next();
        if ((localObject2 instanceof com.tencent.mm.y.e))
        {
          localObject2 = (com.tencent.mm.y.e)localObject2;
          int[] arrayOfInt = com.tencent.mm.view.footer.a.ATm;
          j = 0;
          for (;;)
          {
            if (j >= arrayOfInt.length) {
              break label137;
            }
            if (((com.tencent.mm.y.e)localObject2).mColor == arrayOfInt[j])
            {
              i = 1 << j | i;
              break label52;
              localObject1 = ((d)localObject1).ecr;
              break;
            }
            j += 1;
          }
        }
      }
    }
    int j = 0;
    label141:
    AppMethodBeat.o(116363);
    return j;
  }
  
  public final boolean isCropped()
  {
    AppMethodBeat.i(116361);
    com.tencent.mm.cache.a locala = (com.tencent.mm.cache.a)ArtistCacheManager.Jb().a(com.tencent.mm.e.a.ccP);
    if (locala == null)
    {
      AppMethodBeat.o(116361);
      return false;
    }
    if (locala.ad(this.bRn) > 0)
    {
      AppMethodBeat.o(116361);
      return true;
    }
    AppMethodBeat.o(116361);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bz.c
 * JD-Core Version:    0.7.0.1
 */