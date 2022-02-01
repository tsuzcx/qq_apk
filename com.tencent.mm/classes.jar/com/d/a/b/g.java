package com.d.a.b;

import com.d.a.a.b.e;
import com.d.a.a.b.k;
import com.d.a.c.h;
import com.d.a.c.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class g
{
  com.d.a.c.l<m> ckl = new com.d.a.c.l();
  h<n> ckm = new h();
  ArrayList<j> ckn = new ArrayList();
  h<o> cko = new h();
  com.d.a.c.l<c> ckp = new com.d.a.c.l();
  k<String, c> ckq = e.KP();
  final com.d.a.c.l<i> ckr = new com.d.a.c.l();
  l cks;
  final int mId;
  private final String mName;
  
  public g(int paramInt, String paramString)
  {
    this.mId = paramInt;
    this.mName = paramString;
  }
  
  public final void a(long paramLong, i parami)
  {
    this.ckr.d(paramLong, parami);
  }
  
  public final void a(j paramj)
  {
    paramj.mIndex = this.ckn.size();
    this.ckn.add(paramj);
  }
  
  public final i aP(long paramLong)
  {
    return (i)this.ckr.aX(paramLong);
  }
  
  public final c aQ(long paramLong)
  {
    return (c)this.ckp.aX(paramLong);
  }
  
  public final c cV(String paramString)
  {
    paramString = this.ckq.av(paramString);
    if (paramString.size() == 1) {
      return (c)paramString.iterator().next();
    }
    return null;
  }
  
  public final n ck(int paramInt1, int paramInt2)
  {
    n localn2 = (n)this.ckm.get(paramInt1);
    n localn1 = localn2;
    if (localn2 != null)
    {
      localn1 = new n();
      if (localn2.cln == null) {
        break label59;
      }
    }
    label59:
    for (localn1.cln = localn2.cln;; localn1.cln = localn2)
    {
      localn2.zP += paramInt2;
      return localn1;
    }
  }
  
  public final n ij(int paramInt)
  {
    return (n)this.ckm.get(paramInt);
  }
  
  public final o ik(int paramInt)
  {
    return (o)this.cko.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.d.a.b.g
 * JD-Core Version:    0.7.0.1
 */