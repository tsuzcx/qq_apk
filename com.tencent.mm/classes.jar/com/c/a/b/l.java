package com.c.a.b;

import com.c.a.b.a.a;
import com.c.a.c.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class l
{
  public static final i cpC;
  final a cpD;
  ArrayList<g> cpE = new ArrayList();
  g cpF;
  private e<c> cpG = new e();
  private int[] cpH;
  long cpI = 4294967295L;
  
  static
  {
    if (!l.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      cpC = new j(k.cpn);
      return;
    }
  }
  
  public l(a parama)
  {
    this.cpD = parama;
    g(0, "default");
  }
  
  private g hs(int paramInt)
  {
    int i = 0;
    while (i < this.cpE.size())
    {
      if (((g)this.cpE.get(i)).mId == paramInt) {
        return (g)this.cpE.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public final Collection<j> Kn()
  {
    return ((g)this.cpE.get(0)).coN;
  }
  
  public final void Ko()
  {
    Object localObject1 = cJ("java.lang.Class");
    int i;
    Iterator localIterator;
    if (localObject1 != null)
    {
      i = ((c)localObject1).coE;
      localIterator = this.cpE.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      g localg = (g)localIterator.next();
      localObject1 = localg.coQ.values().iterator();
      Object localObject2;
      int j;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label171;
        }
        localObject2 = (c)((Iterator)localObject1).next();
        localObject3 = ((c)localObject2).Kd();
        if (localObject3 != null) {
          ((c)localObject3).coH.add(localObject2);
        }
        localObject3 = ((c)localObject2).coD;
        int m = localObject3.length;
        j = 0;
        int k = i;
        for (;;)
        {
          if (j < m)
          {
            k += b(localObject3[j].cow);
            j += 1;
            continue;
            i = 0;
            break;
          }
        }
        ((i)localObject2).mSize = k;
      }
      label171:
      localObject1 = new ArrayList(localg.coR.size());
      localg.coR.a(new g.1(localg, (ArrayList)localObject1));
      Object localObject3 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        i locali = (i)((Iterator)localObject3).next();
        c localc = locali.Ka();
        if (localc != null)
        {
          j = localg.mId;
          if ((locali instanceof b)) {
            locali.mSize = localc.coE;
          }
          localObject2 = (c.a)localc.coG.get(j);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new c.a();
            localc.coG.e(j, localObject1);
          }
          ((c.a)localObject1).coJ.add(locali);
          j = ((c.a)localObject1).coI;
          ((c.a)localObject1).coI = (locali.getSize() + j);
        }
      }
    }
  }
  
  public final void Kp()
  {
    Object localObject2 = c.Kf();
    Object localObject1 = new ArrayList();
    int i = 0;
    while (i < this.cpE.size())
    {
      ((ArrayList)localObject1).addAll(((g)this.cpE.get(i)).coQ.az(localObject2));
      i += 1;
    }
    localObject2 = new ArrayList();
    localObject1 = ((Collection)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((List)localObject2).addAll(((c)((Iterator)localObject1).next()).Kg());
    }
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (c)((Iterator)localObject1).next();
      ((c)localObject2).coF = true;
      this.cpG.add(localObject2);
    }
  }
  
  public final void a(long paramLong, i parami)
  {
    this.cpF.a(paramLong, parami);
    parami.cpb = this.cpF;
  }
  
  public final void a(j paramj)
  {
    this.cpF.a(paramj);
    paramj.cpb = this.cpF;
  }
  
  public final i aR(long paramLong)
  {
    int i = 0;
    while (i < this.cpE.size())
    {
      i locali = ((g)this.cpE.get(i)).aN(paramLong);
      if (locali != null) {
        return locali;
      }
      i += 1;
    }
    return aS(paramLong);
  }
  
  public final c aS(long paramLong)
  {
    int i = 0;
    while (i < this.cpE.size())
    {
      c localc = ((g)this.cpE.get(i)).aO(paramLong);
      if (localc != null) {
        return localc;
      }
      i += 1;
    }
    return null;
  }
  
  public final int b(p paramp)
  {
    return this.cpH[paramp.mId];
  }
  
  public final n bS(int paramInt1, int paramInt2)
  {
    return this.cpF.bS(paramInt1, paramInt2);
  }
  
  public final c cJ(String paramString)
  {
    int i = 0;
    while (i < this.cpE.size())
    {
      c localc = ((g)this.cpE.get(i)).cI(paramString);
      if (localc != null) {
        return localc;
      }
      i += 1;
    }
    return null;
  }
  
  public final g g(int paramInt, String paramString)
  {
    g localg2 = hs(paramInt);
    g localg1 = localg2;
    if (localg2 == null)
    {
      localg1 = new g(paramInt, paramString);
      localg1.coS = this;
      this.cpE.add(localg1);
    }
    this.cpF = localg1;
    return this.cpF;
  }
  
  public final n hq(int paramInt)
  {
    return this.cpF.hq(paramInt);
  }
  
  public final o hr(int paramInt)
  {
    return this.cpF.hr(paramInt);
  }
  
  public final void ht(int paramInt)
  {
    int k = 0;
    int i = 0;
    int j = -1;
    while (i < p.values().length)
    {
      j = Math.max(p.values()[i].mId, j);
      i += 1;
    }
    assert ((j > 0) && (j <= p.cpX.mId));
    this.cpH = new int[j + 1];
    Arrays.fill(this.cpH, -1);
    i = k;
    while (i < p.values().length)
    {
      this.cpH[p.values()[i].mId] = p.values()[i].mSize;
      i += 1;
    }
    this.cpH[p.cpP.mId] = paramInt;
    this.cpI = (-1L >>> (8 - paramInt << 3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.c.a.b.l
 * JD-Core Version:    0.7.0.1
 */