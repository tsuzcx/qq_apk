package com.d.a.b;

import com.d.a.a.b.e;
import com.d.a.c.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class g
{
  com.d.a.c.k<m> bWm = new com.d.a.c.k();
  com.d.a.c.g<n> bWn = new com.d.a.c.g();
  ArrayList<j> bWo = new ArrayList();
  com.d.a.c.g<o> bWp = new com.d.a.c.g();
  com.d.a.c.k<c> bWq = new com.d.a.c.k();
  com.d.a.a.b.k<String, c> bWr = e.zR();
  final com.d.a.c.k<i> bWs = new com.d.a.c.k();
  l bWt;
  final int mId;
  private final String mName;
  
  public g(int paramInt, String paramString)
  {
    this.mId = paramInt;
    this.mName = paramString;
  }
  
  public final void a(long paramLong, i parami)
  {
    this.bWs.a(paramLong, parami);
  }
  
  public final void a(j paramj)
  {
    paramj.mIndex = this.bWo.size();
    this.bWo.add(paramj);
  }
  
  public final i aE(long paramLong)
  {
    return (i)this.bWs.get(paramLong);
  }
  
  public final c aF(long paramLong)
  {
    return (c)this.bWq.get(paramLong);
  }
  
  public final c bI(String paramString)
  {
    paramString = this.bWr.an(paramString);
    if (paramString.size() == 1) {
      return (c)paramString.iterator().next();
    }
    return null;
  }
  
  public final n bT(int paramInt1, int paramInt2)
  {
    n localn2 = (n)this.bWn.get(paramInt1);
    n localn1 = localn2;
    if (localn2 != null)
    {
      localn1 = new n();
      if (localn2.bXp == null) {
        break label59;
      }
    }
    label59:
    for (localn1.bXp = localn2.bXp;; localn1.bXp = localn2)
    {
      localn2.LZ += paramInt2;
      return localn1;
    }
  }
  
  public final n gr(int paramInt)
  {
    return (n)this.bWn.get(paramInt);
  }
  
  public final o gs(int paramInt)
  {
    return (o)this.bWp.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.b.g
 * JD-Core Version:    0.7.0.1
 */