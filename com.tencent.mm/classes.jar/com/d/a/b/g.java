package com.d.a.b;

import com.d.a.a.b.e;
import com.d.a.c.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class g
{
  com.d.a.c.k<m> bTU = new com.d.a.c.k();
  com.d.a.c.g<n> bTV = new com.d.a.c.g();
  ArrayList<j> bTW = new ArrayList();
  com.d.a.c.g<o> bTX = new com.d.a.c.g();
  com.d.a.c.k<c> bTY = new com.d.a.c.k();
  com.d.a.a.b.k<String, c> bTZ = e.zE();
  final com.d.a.c.k<i> bUa = new com.d.a.c.k();
  l bUb;
  final int mId;
  private final String mName;
  
  public g(int paramInt, String paramString)
  {
    this.mId = paramInt;
    this.mName = paramString;
  }
  
  public final void a(long paramLong, i parami)
  {
    this.bUa.a(paramLong, parami);
  }
  
  public final void a(j paramj)
  {
    paramj.mIndex = this.bTW.size();
    this.bTW.add(paramj);
  }
  
  public final i aA(long paramLong)
  {
    return (i)this.bUa.get(paramLong);
  }
  
  public final c aB(long paramLong)
  {
    return (c)this.bTY.get(paramLong);
  }
  
  public final n bQ(int paramInt1, int paramInt2)
  {
    n localn2 = (n)this.bTV.get(paramInt1);
    n localn1 = localn2;
    if (localn2 != null)
    {
      localn1 = new n();
      if (localn2.bUX == null) {
        break label59;
      }
    }
    label59:
    for (localn1.bUX = localn2.bUX;; localn1.bUX = localn2)
    {
      localn2.MW += paramInt2;
      return localn1;
    }
  }
  
  public final c bz(String paramString)
  {
    paramString = this.bTZ.an(paramString);
    if (paramString.size() == 1) {
      return (c)paramString.iterator().next();
    }
    return null;
  }
  
  public final n gc(int paramInt)
  {
    return (n)this.bTV.get(paramInt);
  }
  
  public final o gd(int paramInt)
  {
    return (o)this.bTX.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.b.g
 * JD-Core Version:    0.7.0.1
 */