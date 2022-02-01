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
  public static final i bUL;
  final a bUM;
  ArrayList<g> bUN = new ArrayList();
  g bUO;
  private e<c> bUP = new e();
  private int[] bUQ;
  long bUR = 4294967295L;
  
  static
  {
    if (!l.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      bUL = new j(k.bUw);
      return;
    }
  }
  
  public l(a parama)
  {
    this.bUM = parama;
    f(0, "default");
  }
  
  private g ge(int paramInt)
  {
    int i = 0;
    while (i < this.bUN.size())
    {
      if (((g)this.bUN.get(i)).mId == paramInt) {
        return (g)this.bUN.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public final void a(long paramLong, i parami)
  {
    this.bUO.a(paramLong, parami);
    parami.bUk = this.bUO;
  }
  
  public final void a(j paramj)
  {
    this.bUO.a(paramj);
    paramj.bUk = this.bUO;
  }
  
  public final i aE(long paramLong)
  {
    int i = 0;
    while (i < this.bUN.size())
    {
      i locali = ((g)this.bUN.get(i)).aA(paramLong);
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
    while (i < this.bUN.size())
    {
      c localc = ((g)this.bUN.get(i)).aB(paramLong);
      if (localc != null) {
        return localc;
      }
      i += 1;
    }
    return null;
  }
  
  public final int b(p paramp)
  {
    return this.bUQ[paramp.mId];
  }
  
  public final c bA(String paramString)
  {
    int i = 0;
    while (i < this.bUN.size())
    {
      c localc = ((g)this.bUN.get(i)).bz(paramString);
      if (localc != null) {
        return localc;
      }
      i += 1;
    }
    return null;
  }
  
  public final n bQ(int paramInt1, int paramInt2)
  {
    return this.bUO.bQ(paramInt1, paramInt2);
  }
  
  public final g f(int paramInt, String paramString)
  {
    g localg2 = ge(paramInt);
    g localg1 = localg2;
    if (localg2 == null)
    {
      localg1 = new g(paramInt, paramString);
      localg1.bUb = this;
      this.bUN.add(localg1);
    }
    this.bUO = localg1;
    return this.bUO;
  }
  
  public final n gc(int paramInt)
  {
    return this.bUO.gc(paramInt);
  }
  
  public final o gd(int paramInt)
  {
    return this.bUO.gd(paramInt);
  }
  
  public final void gf(int paramInt)
  {
    int k = 0;
    int i = 0;
    int j = -1;
    while (i < p.values().length)
    {
      j = Math.max(p.values()[i].mId, j);
      i += 1;
    }
    assert ((j > 0) && (j <= p.bVh.mId));
    this.bUQ = new int[j + 1];
    Arrays.fill(this.bUQ, -1);
    i = k;
    while (i < p.values().length)
    {
      this.bUQ[p.values()[i].mId] = p.values()[i].mSize;
      i += 1;
    }
    this.bUQ[p.bUZ.mId] = paramInt;
    this.bUR = (-1L >>> (8 - paramInt << 3));
  }
  
  public final Collection<j> zX()
  {
    return ((g)this.bUN.get(0)).bTW;
  }
  
  public final void zY()
  {
    Object localObject1 = bA("java.lang.Class");
    int i;
    Iterator localIterator;
    if (localObject1 != null)
    {
      i = ((c)localObject1).bTN;
      localIterator = this.bUN.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      g localg = (g)localIterator.next();
      localObject1 = localg.bTZ.values().iterator();
      Object localObject2;
      int j;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label171;
        }
        localObject2 = (c)((Iterator)localObject1).next();
        localObject3 = ((c)localObject2).zM();
        if (localObject3 != null) {
          ((c)localObject3).bTQ.add(localObject2);
        }
        localObject3 = ((c)localObject2).bTM;
        int m = localObject3.length;
        j = 0;
        int k = i;
        for (;;)
        {
          if (j < m)
          {
            k += b(localObject3[j].bTF);
            j += 1;
            continue;
            i = 0;
            break;
          }
        }
        ((i)localObject2).mSize = k;
      }
      label171:
      localObject1 = new ArrayList(localg.bUa.size());
      localg.bUa.a(new g.1(localg, (ArrayList)localObject1));
      Object localObject3 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        i locali = (i)((Iterator)localObject3).next();
        c localc = locali.zJ();
        if (localc != null)
        {
          j = localg.mId;
          if ((locali instanceof b)) {
            locali.mSize = localc.bTN;
          }
          localObject2 = (c.a)localc.bTP.get(j);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new c.a();
            localc.bTP.d(j, localObject1);
          }
          ((c.a)localObject1).bTS.add(locali);
          j = ((c.a)localObject1).bTR;
          ((c.a)localObject1).bTR = (locali.getSize() + j);
        }
      }
    }
  }
  
  public final void zZ()
  {
    Object localObject2 = c.zO();
    Object localObject1 = new ArrayList();
    int i = 0;
    while (i < this.bUN.size())
    {
      ((ArrayList)localObject1).addAll(((g)this.bUN.get(i)).bTZ.an(localObject2));
      i += 1;
    }
    localObject2 = new ArrayList();
    localObject1 = ((Collection)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((List)localObject2).addAll(((c)((Iterator)localObject1).next()).zP());
    }
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (c)((Iterator)localObject1).next();
      ((c)localObject2).bTO = true;
      this.bUP.add(localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.b.l
 * JD-Core Version:    0.7.0.1
 */