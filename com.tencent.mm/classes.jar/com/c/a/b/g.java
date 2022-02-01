package com.c.a.b;

import com.c.a.a.b.e;
import com.c.a.c.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class g
{
  com.c.a.c.k<m> coL = new com.c.a.c.k();
  com.c.a.c.g<n> coM = new com.c.a.c.g();
  ArrayList<j> coN = new ArrayList();
  com.c.a.c.g<o> coO = new com.c.a.c.g();
  com.c.a.c.k<c> coP = new com.c.a.c.k();
  com.c.a.a.b.k<String, c> coQ = e.JV();
  final com.c.a.c.k<i> coR = new com.c.a.c.k();
  l coS;
  final int mId;
  private final String mName;
  
  public g(int paramInt, String paramString)
  {
    this.mId = paramInt;
    this.mName = paramString;
  }
  
  public final void a(long paramLong, i parami)
  {
    this.coR.a(paramLong, parami);
  }
  
  public final void a(j paramj)
  {
    paramj.mIndex = this.coN.size();
    this.coN.add(paramj);
  }
  
  public final i aN(long paramLong)
  {
    return (i)this.coR.get(paramLong);
  }
  
  public final c aO(long paramLong)
  {
    return (c)this.coP.get(paramLong);
  }
  
  public final n bS(int paramInt1, int paramInt2)
  {
    n localn2 = (n)this.coM.get(paramInt1);
    n localn1 = localn2;
    if (localn2 != null)
    {
      localn1 = new n();
      if (localn2.cpN == null) {
        break label59;
      }
    }
    label59:
    for (localn1.cpN = localn2.cpN;; localn1.cpN = localn2)
    {
      localn2.fs += paramInt2;
      return localn1;
    }
  }
  
  public final c cI(String paramString)
  {
    paramString = this.coQ.az(paramString);
    if (paramString.size() == 1) {
      return (c)paramString.iterator().next();
    }
    return null;
  }
  
  public final n hq(int paramInt)
  {
    return (n)this.coM.get(paramInt);
  }
  
  public final o hr(int paramInt)
  {
    return (o)this.coO.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.c.a.b.g
 * JD-Core Version:    0.7.0.1
 */