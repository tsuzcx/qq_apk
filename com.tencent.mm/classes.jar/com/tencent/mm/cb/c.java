package com.tencent.mm.cb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.f;
import com.tencent.mm.api.y;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.cache.d;
import java.util.Iterator;
import java.util.Stack;

public final class c
  implements y
{
  private boolean fez = true;
  private com.tencent.mm.bt.b hoR;
  
  public c(com.tencent.mm.bt.b paramb)
  {
    this.hoR = paramb;
  }
  
  public final int aBA()
  {
    AppMethodBeat.i(9336);
    com.tencent.mm.cache.b localb = (com.tencent.mm.cache.b)ArtistCacheManager.aLv().a(com.tencent.mm.e.a.hoK);
    if (localb == null)
    {
      AppMethodBeat.o(9336);
      return 0;
    }
    int i = localb.aR(this.fez);
    AppMethodBeat.o(9336);
    return i;
  }
  
  public final int aBB()
  {
    AppMethodBeat.i(9337);
    int i = 0;
    Object localObject = (com.tencent.mm.cache.b)ArtistCacheManager.aLv().a(com.tencent.mm.e.a.hoK);
    if (localObject != null) {
      i = ((com.tencent.mm.cache.b)localObject).lvO + 0;
    }
    localObject = (com.tencent.mm.cache.i)ArtistCacheManager.aLv().a(com.tencent.mm.e.a.hoL);
    int j = i;
    if (localObject != null) {
      j = i + ((com.tencent.mm.cache.i)localObject).lvO;
    }
    AppMethodBeat.o(9337);
    return j;
  }
  
  public final boolean aBC()
  {
    AppMethodBeat.i(9338);
    com.tencent.mm.cache.a locala = (com.tencent.mm.cache.a)ArtistCacheManager.aLv().a(com.tencent.mm.e.a.hoN);
    if (locala == null)
    {
      AppMethodBeat.o(9338);
      return false;
    }
    if (locala.aR(this.fez) > 0)
    {
      AppMethodBeat.o(9338);
      return true;
    }
    AppMethodBeat.o(9338);
    return false;
  }
  
  public final boolean aBD()
  {
    boolean bool2 = false;
    AppMethodBeat.i(9339);
    com.tencent.mm.e.b localb = this.hoR.c(com.tencent.mm.api.i.hdS);
    boolean bool1 = bool2;
    if (localb != null)
    {
      bool1 = bool2;
      if (localb.aEy() == com.tencent.mm.e.a.hoN) {
        if (((com.tencent.mm.e.c)localb).getRotation() == 0.0F) {
          break label61;
        }
      }
    }
    label61:
    for (bool1 = true;; bool1 = false)
    {
      AppMethodBeat.o(9339);
      return bool1;
    }
  }
  
  public final int aBE()
  {
    AppMethodBeat.i(9341);
    Object localObject = (com.tencent.mm.cache.b)ArtistCacheManager.aLv().a(com.tencent.mm.e.a.hoK);
    if (localObject == null)
    {
      AppMethodBeat.o(9341);
      return 0;
    }
    int[] arrayOfInt1 = new int[com.tencent.mm.view.footer.a.agLQ.length];
    if (this.fez)
    {
      localObject = ((com.tencent.mm.cache.b)localObject).lvL;
      if (localObject != null) {
        localObject = ((Stack)localObject).iterator();
      }
    }
    else
    {
      label143:
      for (;;)
      {
        label67:
        if (!((Iterator)localObject).hasNext()) {
          break label145;
        }
        com.tencent.mm.ab.b localb = (com.tencent.mm.ab.b)((Iterator)localObject).next();
        int[] arrayOfInt2 = com.tencent.mm.view.footer.a.agLQ;
        i = 0;
        for (;;)
        {
          if (i >= arrayOfInt2.length) {
            break label143;
          }
          if (localb.mColor == arrayOfInt2[i])
          {
            arrayOfInt1[i] += 1;
            break label67;
            localObject = ((com.tencent.mm.cache.b)localObject).lvM;
            break;
          }
          i += 1;
        }
      }
    }
    label145:
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
    AppMethodBeat.o(9341);
    return j;
  }
  
  public final boolean aBF()
  {
    AppMethodBeat.i(9342);
    com.tencent.mm.cache.b localb = (com.tencent.mm.cache.b)ArtistCacheManager.aLv().a(com.tencent.mm.e.a.hoK);
    com.tencent.mm.cache.i locali = (com.tencent.mm.cache.i)ArtistCacheManager.aLv().a(com.tencent.mm.e.a.hoL);
    com.tencent.mm.cache.a locala = (com.tencent.mm.cache.a)ArtistCacheManager.aLv().a(com.tencent.mm.e.a.hoN);
    d locald = (d)ArtistCacheManager.aLv().a(com.tencent.mm.e.a.hoM);
    if (((localb != null) && (localb.aR(true) > 0)) || ((locali != null) && (locali.aR(true) > 0)) || ((locald != null) && (locald.aR(true) > 0)) || ((locala != null) && (locala.aR(true) > 0)))
    {
      AppMethodBeat.o(9342);
      return true;
    }
    AppMethodBeat.o(9342);
    return false;
  }
  
  public final String aBG()
  {
    AppMethodBeat.i(9343);
    String str = ((d)ArtistCacheManager.aLv().a(com.tencent.mm.e.a.hoM)).CN(",")[0];
    AppMethodBeat.o(9343);
    return str;
  }
  
  public final String aBH()
  {
    AppMethodBeat.i(9344);
    String str = ((d)ArtistCacheManager.aLv().a(com.tencent.mm.e.a.hoM)).CN("||")[1];
    AppMethodBeat.o(9344);
    return str;
  }
  
  public final int aBx()
  {
    AppMethodBeat.i(9333);
    d locald = (d)ArtistCacheManager.aLv().a(com.tencent.mm.e.a.hoM);
    if (locald == null)
    {
      AppMethodBeat.o(9333);
      return 0;
    }
    int i = locald.ey(this.fez)[1];
    AppMethodBeat.o(9333);
    return i;
  }
  
  public final int aBy()
  {
    AppMethodBeat.i(9334);
    d locald = (d)ArtistCacheManager.aLv().a(com.tencent.mm.e.a.hoM);
    if (locald == null)
    {
      AppMethodBeat.o(9334);
      return 0;
    }
    int i = locald.ey(this.fez)[0];
    AppMethodBeat.o(9334);
    return i;
  }
  
  public final int aBz()
  {
    AppMethodBeat.i(9335);
    com.tencent.mm.cache.i locali = (com.tencent.mm.cache.i)ArtistCacheManager.aLv().a(com.tencent.mm.e.a.hoL);
    if (locali == null)
    {
      AppMethodBeat.o(9335);
      return 0;
    }
    int i = locali.aR(this.fez);
    AppMethodBeat.o(9335);
    return i;
  }
  
  public final int getTextColor()
  {
    AppMethodBeat.i(9340);
    Object localObject1 = (d)ArtistCacheManager.aLv().a(com.tencent.mm.e.a.hoM);
    if (localObject1 == null)
    {
      AppMethodBeat.o(9340);
      return 0;
    }
    int i;
    if (this.fez)
    {
      localObject1 = ((d)localObject1).lvL;
      if (localObject1 != null)
      {
        localObject1 = ((Stack)localObject1).iterator();
        i = 0;
      }
    }
    else
    {
      label139:
      for (;;)
      {
        label54:
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break label143;
        }
        Object localObject2 = (com.tencent.mm.ab.c)((Iterator)localObject1).next();
        if ((localObject2 instanceof f))
        {
          localObject2 = (f)localObject2;
          int[] arrayOfInt = com.tencent.mm.view.footer.a.agLQ;
          j = 0;
          for (;;)
          {
            if (j >= arrayOfInt.length) {
              break label139;
            }
            if (((f)localObject2).mColor == arrayOfInt[j])
            {
              i = 1 << j | i;
              break label54;
              localObject1 = ((d)localObject1).lvM;
              break;
            }
            j += 1;
          }
        }
      }
    }
    int j = 0;
    label143:
    AppMethodBeat.o(9340);
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.cb.c
 * JD-Core Version:    0.7.0.1
 */