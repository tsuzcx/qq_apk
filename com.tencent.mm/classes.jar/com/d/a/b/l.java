package com.d.a.b;

import com.d.a.b.a.a;
import com.d.a.c.f;
import com.d.a.c.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class l
{
  public static final i clc;
  final a cld;
  ArrayList<g> cle = new ArrayList();
  g clf;
  private f<c> clg = new f();
  private int[] clh;
  long cli = 4294967295L;
  
  static
  {
    if (!l.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      clc = new j(k.ckN);
      return;
    }
  }
  
  public l(a parama)
  {
    this.cld = parama;
    h(0, "default");
  }
  
  private g il(int paramInt)
  {
    int i = 0;
    while (i < this.cle.size())
    {
      if (((g)this.cle.get(i)).mId == paramInt) {
        return (g)this.cle.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public final Collection<j> Lh()
  {
    return ((g)this.cle.get(0)).ckn;
  }
  
  public final void Li()
  {
    Object localObject1 = cW("java.lang.Class");
    int i;
    Iterator localIterator;
    if (localObject1 != null)
    {
      i = ((c)localObject1).cke;
      localIterator = this.cle.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      g localg = (g)localIterator.next();
      localObject1 = localg.ckq.values().iterator();
      Object localObject2;
      int j;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label171;
        }
        localObject2 = (c)((Iterator)localObject1).next();
        localObject3 = ((c)localObject2).KW();
        if (localObject3 != null) {
          ((c)localObject3).ckh.add(localObject2);
        }
        localObject3 = ((c)localObject2).ckd;
        int m = localObject3.length;
        j = 0;
        int k = i;
        for (;;)
        {
          if (j < m)
          {
            k += b(localObject3[j].cjW);
            j += 1;
            continue;
            i = 0;
            break;
          }
        }
        ((i)localObject2).mSize = k;
      }
      label171:
      localObject1 = new ArrayList(localg.ckr.size());
      localg.ckr.a(new g.1(localg, (ArrayList)localObject1));
      Object localObject3 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        i locali = (i)((Iterator)localObject3).next();
        c localc = locali.KU();
        if (localc != null)
        {
          j = localg.mId;
          if ((locali instanceof b)) {
            locali.mSize = localc.cke;
          }
          localObject2 = (c.a)localc.ckg.get(j);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new c.a();
            localc.ckg.h(j, localObject1);
          }
          ((c.a)localObject1).ckj.add(locali);
          j = ((c.a)localObject1).cki;
          ((c.a)localObject1).cki = (locali.getSize() + j);
        }
      }
    }
  }
  
  public final void Lj()
  {
    Object localObject2 = c.KY();
    Object localObject1 = new ArrayList();
    int i = 0;
    while (i < this.cle.size())
    {
      ((ArrayList)localObject1).addAll(((g)this.cle.get(i)).ckq.av(localObject2));
      i += 1;
    }
    localObject2 = new ArrayList();
    localObject1 = ((Collection)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((List)localObject2).addAll(((c)((Iterator)localObject1).next()).KZ());
    }
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (c)((Iterator)localObject1).next();
      ((c)localObject2).ckf = true;
      this.clg.add(localObject2);
    }
  }
  
  public final void a(long paramLong, i parami)
  {
    this.clf.a(paramLong, parami);
    parami.ckB = this.clf;
  }
  
  public final void a(j paramj)
  {
    this.clf.a(paramj);
    paramj.ckB = this.clf;
  }
  
  public final i aT(long paramLong)
  {
    int i = 0;
    while (i < this.cle.size())
    {
      i locali = ((g)this.cle.get(i)).aP(paramLong);
      if (locali != null) {
        return locali;
      }
      i += 1;
    }
    return aU(paramLong);
  }
  
  public final c aU(long paramLong)
  {
    int i = 0;
    while (i < this.cle.size())
    {
      c localc = ((g)this.cle.get(i)).aQ(paramLong);
      if (localc != null) {
        return localc;
      }
      i += 1;
    }
    return null;
  }
  
  public final int b(p paramp)
  {
    return this.clh[paramp.mId];
  }
  
  public final c cW(String paramString)
  {
    int i = 0;
    while (i < this.cle.size())
    {
      c localc = ((g)this.cle.get(i)).cV(paramString);
      if (localc != null) {
        return localc;
      }
      i += 1;
    }
    return null;
  }
  
  public final n ck(int paramInt1, int paramInt2)
  {
    return this.clf.ck(paramInt1, paramInt2);
  }
  
  public final g h(int paramInt, String paramString)
  {
    g localg2 = il(paramInt);
    g localg1 = localg2;
    if (localg2 == null)
    {
      localg1 = new g(paramInt, paramString);
      localg1.cks = this;
      this.cle.add(localg1);
    }
    this.clf = localg1;
    return this.clf;
  }
  
  public final n ij(int paramInt)
  {
    return this.clf.ij(paramInt);
  }
  
  public final o ik(int paramInt)
  {
    return this.clf.ik(paramInt);
  }
  
  public final void im(int paramInt)
  {
    int k = 0;
    int i = 0;
    int j = -1;
    while (i < p.values().length)
    {
      j = Math.max(p.values()[i].mId, j);
      i += 1;
    }
    assert ((j > 0) && (j <= p.clx.mId));
    this.clh = new int[j + 1];
    Arrays.fill(this.clh, -1);
    i = k;
    while (i < p.values().length)
    {
      this.clh[p.values()[i].mId] = p.values()[i].mSize;
      i += 1;
    }
    this.clh[p.clp.mId] = paramInt;
    this.cli = (-1L >>> (8 - paramInt << 3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.d.a.b.l
 * JD-Core Version:    0.7.0.1
 */