package com.d.a.b;

import com.d.a.b.a.a;
import com.d.a.c.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class l
{
  public static final i bXd;
  final a bXe;
  ArrayList<g> bXf = new ArrayList();
  g bXg;
  private e<c> bXh = new e();
  private int[] bXi;
  long bXj = 4294967295L;
  
  static
  {
    if (!l.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      bXd = new j(k.bWO);
      return;
    }
  }
  
  public l(a parama)
  {
    this.bXe = parama;
    f(0, "default");
  }
  
  private g gt(int paramInt)
  {
    int i = 0;
    while (i < this.bXf.size())
    {
      if (((g)this.bXf.get(i)).mId == paramInt) {
        return (g)this.bXf.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public final Collection<j> Ak()
  {
    return ((g)this.bXf.get(0)).bWo;
  }
  
  public final void Al()
  {
    Object localObject1 = bJ("java.lang.Class");
    int i;
    Iterator localIterator;
    if (localObject1 != null)
    {
      i = ((c)localObject1).bWf;
      localIterator = this.bXf.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      g localg = (g)localIterator.next();
      localObject1 = localg.bWr.values().iterator();
      Object localObject2;
      int j;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label171;
        }
        localObject2 = (c)((Iterator)localObject1).next();
        localObject3 = ((c)localObject2).zZ();
        if (localObject3 != null) {
          ((c)localObject3).bWi.add(localObject2);
        }
        localObject3 = ((c)localObject2).bWe;
        int m = localObject3.length;
        j = 0;
        int k = i;
        for (;;)
        {
          if (j < m)
          {
            k += b(localObject3[j].bVX);
            j += 1;
            continue;
            i = 0;
            break;
          }
        }
        ((i)localObject2).mSize = k;
      }
      label171:
      localObject1 = new ArrayList(localg.bWs.size());
      localg.bWs.a(new g.1(localg, (ArrayList)localObject1));
      Object localObject3 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        i locali = (i)((Iterator)localObject3).next();
        c localc = locali.zW();
        if (localc != null)
        {
          j = localg.mId;
          if ((locali instanceof b)) {
            locali.mSize = localc.bWf;
          }
          localObject2 = (c.a)localc.bWh.get(j);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new c.a();
            localc.bWh.d(j, localObject1);
          }
          ((c.a)localObject1).bWk.add(locali);
          j = ((c.a)localObject1).bWj;
          ((c.a)localObject1).bWj = (locali.getSize() + j);
        }
      }
    }
  }
  
  public final void Am()
  {
    Object localObject2 = c.Ab();
    Object localObject1 = new ArrayList();
    int i = 0;
    while (i < this.bXf.size())
    {
      ((ArrayList)localObject1).addAll(((g)this.bXf.get(i)).bWr.an(localObject2));
      i += 1;
    }
    localObject2 = new ArrayList();
    localObject1 = ((Collection)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((List)localObject2).addAll(((c)((Iterator)localObject1).next()).Ac());
    }
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (c)((Iterator)localObject1).next();
      ((c)localObject2).bWg = true;
      this.bXh.add(localObject2);
    }
  }
  
  public final void a(long paramLong, i parami)
  {
    this.bXg.a(paramLong, parami);
    parami.bWC = this.bXg;
  }
  
  public final void a(j paramj)
  {
    this.bXg.a(paramj);
    paramj.bWC = this.bXg;
  }
  
  public final i aI(long paramLong)
  {
    int i = 0;
    while (i < this.bXf.size())
    {
      i locali = ((g)this.bXf.get(i)).aE(paramLong);
      if (locali != null) {
        return locali;
      }
      i += 1;
    }
    return aJ(paramLong);
  }
  
  public final c aJ(long paramLong)
  {
    int i = 0;
    while (i < this.bXf.size())
    {
      c localc = ((g)this.bXf.get(i)).aF(paramLong);
      if (localc != null) {
        return localc;
      }
      i += 1;
    }
    return null;
  }
  
  public final int b(p paramp)
  {
    return this.bXi[paramp.mId];
  }
  
  public final c bJ(String paramString)
  {
    int i = 0;
    while (i < this.bXf.size())
    {
      c localc = ((g)this.bXf.get(i)).bI(paramString);
      if (localc != null) {
        return localc;
      }
      i += 1;
    }
    return null;
  }
  
  public final n bT(int paramInt1, int paramInt2)
  {
    return this.bXg.bT(paramInt1, paramInt2);
  }
  
  public final g f(int paramInt, String paramString)
  {
    g localg2 = gt(paramInt);
    g localg1 = localg2;
    if (localg2 == null)
    {
      localg1 = new g(paramInt, paramString);
      localg1.bWt = this;
      this.bXf.add(localg1);
    }
    this.bXg = localg1;
    return this.bXg;
  }
  
  public final n gr(int paramInt)
  {
    return this.bXg.gr(paramInt);
  }
  
  public final o gs(int paramInt)
  {
    return this.bXg.gs(paramInt);
  }
  
  public final void gu(int paramInt)
  {
    int k = 0;
    int i = 0;
    int j = -1;
    while (i < p.values().length)
    {
      j = Math.max(p.values()[i].mId, j);
      i += 1;
    }
    assert ((j > 0) && (j <= p.bXz.mId));
    this.bXi = new int[j + 1];
    Arrays.fill(this.bXi, -1);
    i = k;
    while (i < p.values().length)
    {
      this.bXi[p.values()[i].mId] = p.values()[i].mSize;
      i += 1;
    }
    this.bXi[p.bXr.mId] = paramInt;
    this.bXj = (-1L >>> (8 - paramInt << 3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.b.l
 * JD-Core Version:    0.7.0.1
 */