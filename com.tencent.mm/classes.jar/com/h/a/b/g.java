package com.h.a.b;

import com.h.a.a.b.e;
import com.h.a.c.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class g
{
  com.h.a.c.k<m> eaG = new com.h.a.c.k();
  com.h.a.c.g<n> eaH = new com.h.a.c.g();
  ArrayList<j> eaI = new ArrayList();
  com.h.a.c.g<o> eaJ = new com.h.a.c.g();
  com.h.a.c.k<c> eaK = new com.h.a.c.k();
  com.h.a.a.b.k<String, c> eaL = e.akQ();
  final com.h.a.c.k<i> eaM = new com.h.a.c.k();
  l eaN;
  final int mId;
  private final String mName;
  
  public g(int paramInt, String paramString)
  {
    this.mId = paramInt;
    this.mName = paramString;
  }
  
  public final void a(long paramLong, i parami)
  {
    this.eaM.f(paramLong, parami);
  }
  
  public final void a(j paramj)
  {
    paramj.mIndex = this.eaI.size();
    this.eaI.add(paramj);
  }
  
  public final n cX(int paramInt1, int paramInt2)
  {
    n localn2 = (n)this.eaH.get(paramInt1);
    n localn1 = localn2;
    if (localn2 != null)
    {
      localn1 = new n();
      if (localn2.ebI == null) {
        break label59;
      }
    }
    label59:
    for (localn1.ebI = localn2.ebI;; localn1.ebI = localn2)
    {
      localn2.Sc += paramInt2;
      return localn1;
    }
  }
  
  public final i di(long paramLong)
  {
    return (i)this.eaM.A(paramLong);
  }
  
  public final c dj(long paramLong)
  {
    return (c)this.eaK.A(paramLong);
  }
  
  public final c ep(String paramString)
  {
    paramString = this.eaL.bQ(paramString);
    if (paramString.size() == 1) {
      return (c)paramString.iterator().next();
    }
    return null;
  }
  
  public final n lO(int paramInt)
  {
    return (n)this.eaH.get(paramInt);
  }
  
  public final o lP(int paramInt)
  {
    return (o)this.eaJ.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.h.a.b.g
 * JD-Core Version:    0.7.0.1
 */