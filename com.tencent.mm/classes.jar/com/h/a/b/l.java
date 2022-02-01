package com.h.a.b;

import com.h.a.b.a.a;
import com.h.a.c.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class l
{
  public static final i ebx;
  g ebA;
  private e<c> ebB = new e();
  private int[] ebC;
  long ebD = 4294967295L;
  final a eby;
  ArrayList<g> ebz = new ArrayList();
  
  static
  {
    if (!l.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      ebx = new j(k.ebi);
      return;
    }
  }
  
  public l(a parama)
  {
    this.eby = parama;
    i(0, "default");
  }
  
  private g lQ(int paramInt)
  {
    int i = 0;
    while (i < this.ebz.size())
    {
      if (((g)this.ebz.get(i)).mId == paramInt) {
        return (g)this.ebz.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public final void a(long paramLong, i parami)
  {
    this.ebA.a(paramLong, parami);
    parami.eaW = this.ebA;
  }
  
  public final void a(j paramj)
  {
    this.ebA.a(paramj);
    paramj.eaW = this.ebA;
  }
  
  public final Collection<j> ali()
  {
    return ((g)this.ebz.get(0)).eaI;
  }
  
  public final void alj()
  {
    Object localObject1 = eq("java.lang.Class");
    int i;
    Iterator localIterator;
    if (localObject1 != null)
    {
      i = ((c)localObject1).eaz;
      localIterator = this.ebz.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      g localg = (g)localIterator.next();
      localObject1 = localg.eaL.values().iterator();
      Object localObject2;
      int j;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label171;
        }
        localObject2 = (c)((Iterator)localObject1).next();
        localObject3 = ((c)localObject2).akX();
        if (localObject3 != null) {
          ((c)localObject3).eaC.add(localObject2);
        }
        localObject3 = ((c)localObject2).eay;
        int m = localObject3.length;
        j = 0;
        int k = i;
        for (;;)
        {
          if (j < m)
          {
            k += b(localObject3[j].ear);
            j += 1;
            continue;
            i = 0;
            break;
          }
        }
        ((i)localObject2).mSize = k;
      }
      label171:
      localObject1 = new ArrayList(localg.eaM.size());
      localg.eaM.a(new g.1(localg, (ArrayList)localObject1));
      Object localObject3 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        i locali = (i)((Iterator)localObject3).next();
        c localc = locali.akV();
        if (localc != null)
        {
          j = localg.mId;
          if ((locali instanceof b)) {
            locali.mSize = localc.eaz;
          }
          localObject2 = (c.a)localc.eaB.get(j);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new c.a();
            localc.eaB.z(j, localObject1);
          }
          ((c.a)localObject1).eaE.add(locali);
          j = ((c.a)localObject1).eaD;
          ((c.a)localObject1).eaD = (locali.getSize() + j);
        }
      }
    }
  }
  
  public final void alk()
  {
    Object localObject2 = c.akZ();
    Object localObject1 = new ArrayList();
    int i = 0;
    while (i < this.ebz.size())
    {
      ((ArrayList)localObject1).addAll(((g)this.ebz.get(i)).eaL.bQ(localObject2));
      i += 1;
    }
    localObject2 = new ArrayList();
    localObject1 = ((Collection)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((List)localObject2).addAll(((c)((Iterator)localObject1).next()).ala());
    }
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (c)((Iterator)localObject1).next();
      ((c)localObject2).eaA = true;
      this.ebB.add(localObject2);
    }
  }
  
  public final int b(p paramp)
  {
    return this.ebC[paramp.mId];
  }
  
  public final n cX(int paramInt1, int paramInt2)
  {
    return this.ebA.cX(paramInt1, paramInt2);
  }
  
  public final i dm(long paramLong)
  {
    int i = 0;
    while (i < this.ebz.size())
    {
      i locali = ((g)this.ebz.get(i)).di(paramLong);
      if (locali != null) {
        return locali;
      }
      i += 1;
    }
    return dn(paramLong);
  }
  
  public final c dn(long paramLong)
  {
    int i = 0;
    while (i < this.ebz.size())
    {
      c localc = ((g)this.ebz.get(i)).dj(paramLong);
      if (localc != null) {
        return localc;
      }
      i += 1;
    }
    return null;
  }
  
  public final c eq(String paramString)
  {
    int i = 0;
    while (i < this.ebz.size())
    {
      c localc = ((g)this.ebz.get(i)).ep(paramString);
      if (localc != null) {
        return localc;
      }
      i += 1;
    }
    return null;
  }
  
  public final g i(int paramInt, String paramString)
  {
    g localg2 = lQ(paramInt);
    g localg1 = localg2;
    if (localg2 == null)
    {
      localg1 = new g(paramInt, paramString);
      localg1.eaN = this;
      this.ebz.add(localg1);
    }
    this.ebA = localg1;
    return this.ebA;
  }
  
  public final n lO(int paramInt)
  {
    return this.ebA.lO(paramInt);
  }
  
  public final o lP(int paramInt)
  {
    return this.ebA.lP(paramInt);
  }
  
  public final void lR(int paramInt)
  {
    int k = 0;
    int i = 0;
    int j = -1;
    while (i < p.values().length)
    {
      j = Math.max(p.values()[i].mId, j);
      i += 1;
    }
    assert ((j > 0) && (j <= p.ebS.mId));
    this.ebC = new int[j + 1];
    Arrays.fill(this.ebC, -1);
    i = k;
    while (i < p.values().length)
    {
      this.ebC[p.values()[i].mId] = p.values()[i].mSize;
      i += 1;
    }
    this.ebC[p.ebK.mId] = paramInt;
    this.ebD = (-1L >>> (8 - paramInt << 3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.h.a.b.l
 * JD-Core Version:    0.7.0.1
 */