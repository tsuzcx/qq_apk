package com.e.a.b;

import com.e.a.a.b.e;
import com.e.a.c.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class g
{
  com.e.a.c.k<m> ceh = new com.e.a.c.k();
  com.e.a.c.g<n> cei = new com.e.a.c.g();
  ArrayList<j> cej = new ArrayList();
  com.e.a.c.g<o> cek = new com.e.a.c.g();
  com.e.a.c.k<c> cel = new com.e.a.c.k();
  com.e.a.a.b.k<String, c> cem = e.Bc();
  final com.e.a.c.k<i> cen = new com.e.a.c.k();
  l ceo;
  final int mId;
  private final String mName;
  
  public g(int paramInt, String paramString)
  {
    this.mId = paramInt;
    this.mName = paramString;
  }
  
  public final void a(long paramLong, i parami)
  {
    this.cen.a(paramLong, parami);
  }
  
  public final void a(j paramj)
  {
    paramj.mIndex = this.cej.size();
    this.cej.add(paramj);
  }
  
  public final i aA(long paramLong)
  {
    return (i)this.cen.get(paramLong);
  }
  
  public final c aB(long paramLong)
  {
    return (c)this.cel.get(paramLong);
  }
  
  public final n bS(int paramInt1, int paramInt2)
  {
    n localn2 = (n)this.cei.get(paramInt1);
    n localn1 = localn2;
    if (localn2 != null)
    {
      localn1 = new n();
      if (localn2.cfl == null) {
        break label59;
      }
    }
    label59:
    for (localn1.cfl = localn2.cfl;; localn1.cfl = localn2)
    {
      localn2.fq += paramInt2;
      return localn1;
    }
  }
  
  public final c ct(String paramString)
  {
    paramString = this.cem.aq(paramString);
    if (paramString.size() == 1) {
      return (c)paramString.iterator().next();
    }
    return null;
  }
  
  public final n gf(int paramInt)
  {
    return (n)this.cei.get(paramInt);
  }
  
  public final o gg(int paramInt)
  {
    return (o)this.cek.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.e.a.b.g
 * JD-Core Version:    0.7.0.1
 */