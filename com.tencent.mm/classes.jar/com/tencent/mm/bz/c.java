package com.tencent.mm.bz;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.api.x;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.cache.d;
import com.tencent.mm.cache.i;
import com.tencent.mm.z.f;
import java.util.Iterator;
import java.util.Stack;

public final class c
  implements x
{
  private boolean dbi = true;
  private com.tencent.mm.bt.b drS;
  
  public c(com.tencent.mm.bt.b paramb)
  {
    this.drS = paramb;
  }
  
  public final int VA()
  {
    AppMethodBeat.i(9336);
    com.tencent.mm.cache.b localb = (com.tencent.mm.cache.b)ArtistCacheManager.alA().a(com.tencent.mm.e.a.drL);
    if (localb == null)
    {
      AppMethodBeat.o(9336);
      return 0;
    }
    int i = localb.ai(this.dbi);
    AppMethodBeat.o(9336);
    return i;
  }
  
  public final int VB()
  {
    AppMethodBeat.i(9337);
    int i = 0;
    Object localObject = (com.tencent.mm.cache.b)ArtistCacheManager.alA().a(com.tencent.mm.e.a.drL);
    if (localObject != null) {
      i = ((com.tencent.mm.cache.b)localObject).gpA + 0;
    }
    localObject = (i)ArtistCacheManager.alA().a(com.tencent.mm.e.a.drM);
    int j = i;
    if (localObject != null) {
      j = i + ((i)localObject).gpA;
    }
    AppMethodBeat.o(9337);
    return j;
  }
  
  public final boolean VC()
  {
    boolean bool2 = false;
    AppMethodBeat.i(9339);
    com.tencent.mm.e.b localb = this.drS.c(h.diL);
    boolean bool1 = bool2;
    if (localb != null)
    {
      bool1 = bool2;
      if (localb.XS() == com.tencent.mm.e.a.drO) {
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
  
  public final int VD()
  {
    AppMethodBeat.i(9341);
    Object localObject = (com.tencent.mm.cache.b)ArtistCacheManager.alA().a(com.tencent.mm.e.a.drL);
    if (localObject == null)
    {
      AppMethodBeat.o(9341);
      return 0;
    }
    int[] arrayOfInt1 = new int[com.tencent.mm.view.footer.a.RoQ.length];
    if (this.dbi)
    {
      localObject = ((com.tencent.mm.cache.b)localObject).gpx;
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
        com.tencent.mm.z.b localb = (com.tencent.mm.z.b)((Iterator)localObject).next();
        int[] arrayOfInt2 = com.tencent.mm.view.footer.a.RoQ;
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
            localObject = ((com.tencent.mm.cache.b)localObject).gpy;
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
  
  public final boolean VE()
  {
    AppMethodBeat.i(9342);
    com.tencent.mm.cache.b localb = (com.tencent.mm.cache.b)ArtistCacheManager.alA().a(com.tencent.mm.e.a.drL);
    i locali = (i)ArtistCacheManager.alA().a(com.tencent.mm.e.a.drM);
    com.tencent.mm.cache.a locala = (com.tencent.mm.cache.a)ArtistCacheManager.alA().a(com.tencent.mm.e.a.drO);
    d locald = (d)ArtistCacheManager.alA().a(com.tencent.mm.e.a.drN);
    if (((localb != null) && (localb.ai(true) > 0)) || ((locali != null) && (locali.ai(true) > 0)) || ((locald != null) && (locald.ai(true) > 0)) || ((locala != null) && (locala.ai(true) > 0)))
    {
      AppMethodBeat.o(9342);
      return true;
    }
    AppMethodBeat.o(9342);
    return false;
  }
  
  public final String VF()
  {
    AppMethodBeat.i(9343);
    String str = ((d)ArtistCacheManager.alA().a(com.tencent.mm.e.a.drN)).Dq(",")[0];
    AppMethodBeat.o(9343);
    return str;
  }
  
  public final String VG()
  {
    AppMethodBeat.i(9344);
    String str = ((d)ArtistCacheManager.alA().a(com.tencent.mm.e.a.drN)).Dq("||")[1];
    AppMethodBeat.o(9344);
    return str;
  }
  
  public final int Vx()
  {
    AppMethodBeat.i(9333);
    d locald = (d)ArtistCacheManager.alA().a(com.tencent.mm.e.a.drN);
    if (locald == null)
    {
      AppMethodBeat.o(9333);
      return 0;
    }
    int i = locald.dm(this.dbi)[1];
    AppMethodBeat.o(9333);
    return i;
  }
  
  public final int Vy()
  {
    AppMethodBeat.i(9334);
    d locald = (d)ArtistCacheManager.alA().a(com.tencent.mm.e.a.drN);
    if (locald == null)
    {
      AppMethodBeat.o(9334);
      return 0;
    }
    int i = locald.dm(this.dbi)[0];
    AppMethodBeat.o(9334);
    return i;
  }
  
  public final int Vz()
  {
    AppMethodBeat.i(9335);
    i locali = (i)ArtistCacheManager.alA().a(com.tencent.mm.e.a.drM);
    if (locali == null)
    {
      AppMethodBeat.o(9335);
      return 0;
    }
    int i = locali.ai(this.dbi);
    AppMethodBeat.o(9335);
    return i;
  }
  
  public final int getTextColor()
  {
    AppMethodBeat.i(9340);
    Object localObject1 = (d)ArtistCacheManager.alA().a(com.tencent.mm.e.a.drN);
    if (localObject1 == null)
    {
      AppMethodBeat.o(9340);
      return 0;
    }
    int i;
    if (this.dbi)
    {
      localObject1 = ((d)localObject1).gpx;
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
        Object localObject2 = (com.tencent.mm.z.c)((Iterator)localObject1).next();
        if ((localObject2 instanceof f))
        {
          localObject2 = (f)localObject2;
          int[] arrayOfInt = com.tencent.mm.view.footer.a.RoQ;
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
              localObject1 = ((d)localObject1).gpy;
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
  
  public final boolean isCropped()
  {
    AppMethodBeat.i(9338);
    com.tencent.mm.cache.a locala = (com.tencent.mm.cache.a)ArtistCacheManager.alA().a(com.tencent.mm.e.a.drO);
    if (locala == null)
    {
      AppMethodBeat.o(9338);
      return false;
    }
    if (locala.ai(this.dbi) > 0)
    {
      AppMethodBeat.o(9338);
      return true;
    }
    AppMethodBeat.o(9338);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bz.c
 * JD-Core Version:    0.7.0.1
 */