package com.e.a.b;

import com.e.a.b.a.a;
import com.e.a.c.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class l
{
  public static final i ceY;
  final a ceZ;
  ArrayList<g> cfa = new ArrayList();
  g cfb;
  private e<c> cfc = new e();
  private int[] cfd;
  long cfe = 4294967295L;
  
  static
  {
    if (!l.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      ceY = new j(k.ceJ);
      return;
    }
  }
  
  public l(a parama)
  {
    this.ceZ = parama;
    f(0, "default");
  }
  
  private g gh(int paramInt)
  {
    int i = 0;
    while (i < this.cfa.size())
    {
      if (((g)this.cfa.get(i)).mId == paramInt) {
        return (g)this.cfa.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public final Collection<j> Bv()
  {
    return ((g)this.cfa.get(0)).cej;
  }
  
  public final void Bw()
  {
    Object localObject1 = cu("java.lang.Class");
    int i;
    Iterator localIterator;
    if (localObject1 != null)
    {
      i = ((c)localObject1).cea;
      localIterator = this.cfa.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      g localg = (g)localIterator.next();
      localObject1 = localg.cem.values().iterator();
      Object localObject2;
      int j;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label171;
        }
        localObject2 = (c)((Iterator)localObject1).next();
        localObject3 = ((c)localObject2).Bk();
        if (localObject3 != null) {
          ((c)localObject3).ced.add(localObject2);
        }
        localObject3 = ((c)localObject2).cdZ;
        int m = localObject3.length;
        j = 0;
        int k = i;
        for (;;)
        {
          if (j < m)
          {
            k += b(localObject3[j].cdS);
            j += 1;
            continue;
            i = 0;
            break;
          }
        }
        ((i)localObject2).mSize = k;
      }
      label171:
      localObject1 = new ArrayList(localg.cen.size());
      localg.cen.a(new g.1(localg, (ArrayList)localObject1));
      Object localObject3 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        i locali = (i)((Iterator)localObject3).next();
        c localc = locali.Bh();
        if (localc != null)
        {
          j = localg.mId;
          if ((locali instanceof b)) {
            locali.mSize = localc.cea;
          }
          localObject2 = (c.a)localc.cec.get(j);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new c.a();
            localc.cec.d(j, localObject1);
          }
          ((c.a)localObject1).cef.add(locali);
          j = ((c.a)localObject1).cee;
          ((c.a)localObject1).cee = (locali.getSize() + j);
        }
      }
    }
  }
  
  public final void Bx()
  {
    Object localObject2 = c.Bm();
    Object localObject1 = new ArrayList();
    int i = 0;
    while (i < this.cfa.size())
    {
      ((ArrayList)localObject1).addAll(((g)this.cfa.get(i)).cem.aq(localObject2));
      i += 1;
    }
    localObject2 = new ArrayList();
    localObject1 = ((Collection)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((List)localObject2).addAll(((c)((Iterator)localObject1).next()).Bn());
    }
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (c)((Iterator)localObject1).next();
      ((c)localObject2).ceb = true;
      this.cfc.add(localObject2);
    }
  }
  
  public final void a(long paramLong, i parami)
  {
    this.cfb.a(paramLong, parami);
    parami.cex = this.cfb;
  }
  
  public final void a(j paramj)
  {
    this.cfb.a(paramj);
    paramj.cex = this.cfb;
  }
  
  public final i aE(long paramLong)
  {
    int i = 0;
    while (i < this.cfa.size())
    {
      i locali = ((g)this.cfa.get(i)).aA(paramLong);
      if (locali != null) {
        return locali;
      }
      i += 1;
    }
    return aF(paramLong);
  }
  
  public final c aF(long paramLong)
  {
    int i = 0;
    while (i < this.cfa.size())
    {
      c localc = ((g)this.cfa.get(i)).aB(paramLong);
      if (localc != null) {
        return localc;
      }
      i += 1;
    }
    return null;
  }
  
  public final int b(p paramp)
  {
    return this.cfd[paramp.mId];
  }
  
  public final n bS(int paramInt1, int paramInt2)
  {
    return this.cfb.bS(paramInt1, paramInt2);
  }
  
  public final c cu(String paramString)
  {
    int i = 0;
    while (i < this.cfa.size())
    {
      c localc = ((g)this.cfa.get(i)).ct(paramString);
      if (localc != null) {
        return localc;
      }
      i += 1;
    }
    return null;
  }
  
  public final g f(int paramInt, String paramString)
  {
    g localg2 = gh(paramInt);
    g localg1 = localg2;
    if (localg2 == null)
    {
      localg1 = new g(paramInt, paramString);
      localg1.ceo = this;
      this.cfa.add(localg1);
    }
    this.cfb = localg1;
    return this.cfb;
  }
  
  public final n gf(int paramInt)
  {
    return this.cfb.gf(paramInt);
  }
  
  public final o gg(int paramInt)
  {
    return this.cfb.gg(paramInt);
  }
  
  public final void gi(int paramInt)
  {
    int k = 0;
    int i = 0;
    int j = -1;
    while (i < p.values().length)
    {
      j = Math.max(p.values()[i].mId, j);
      i += 1;
    }
    assert ((j > 0) && (j <= p.cfv.mId));
    this.cfd = new int[j + 1];
    Arrays.fill(this.cfd, -1);
    i = k;
    while (i < p.values().length)
    {
      this.cfd[p.values()[i].mId] = p.values()[i].mSize;
      i += 1;
    }
    this.cfd[p.cfn.mId] = paramInt;
    this.cfe = (-1L >>> (8 - paramInt << 3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.e.a.b.l
 * JD-Core Version:    0.7.0.1
 */