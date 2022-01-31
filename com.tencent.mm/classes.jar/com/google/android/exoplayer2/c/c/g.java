package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.j;
import java.util.Collections;
import java.util.List;

public final class g
  implements h
{
  private int aCl;
  private final List<u.a> aDC;
  private final k[] aDD;
  private boolean aDE;
  private int aDF;
  private long aDG;
  
  public g(List<u.a> paramList)
  {
    this.aDC = paramList;
    this.aDD = new k[paramList.size()];
  }
  
  private boolean c(j paramj, int paramInt)
  {
    if (paramj.oe() == 0) {
      return false;
    }
    if (paramj.readUnsignedByte() != paramInt) {
      this.aDE = false;
    }
    this.aDF -= 1;
    return this.aDE;
  }
  
  public final void a(f paramf, u.d paramd)
  {
    int i = 0;
    while (i < this.aDD.length)
    {
      u.a locala = (u.a)this.aDC.get(i);
      paramd.mg();
      k localk = paramf.cQ(paramd.mh());
      localk.f(Format.a(paramd.mi(), "application/dvbsubs", Collections.singletonList(locala.aFB), locala.auI));
      this.aDD[i] = localk;
      i += 1;
    }
  }
  
  public final void b(j paramj)
  {
    int i = 0;
    if ((!this.aDE) || ((this.aDF == 2) && (!c(paramj, 32)))) {}
    while ((this.aDF == 1) && (!c(paramj, 0))) {
      return;
    }
    int j = paramj.position;
    int k = paramj.oe();
    k[] arrayOfk = this.aDD;
    int m = arrayOfk.length;
    while (i < m)
    {
      k localk = arrayOfk[i];
      paramj.setPosition(j);
      localk.a(paramj, k);
      i += 1;
    }
    this.aCl += k;
  }
  
  public final void d(long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.aDE = true;
    this.aDG = paramLong;
    this.aCl = 0;
    this.aDF = 2;
  }
  
  public final void lY()
  {
    this.aDE = false;
  }
  
  public final void lZ()
  {
    if (this.aDE)
    {
      k[] arrayOfk = this.aDD;
      int j = arrayOfk.length;
      int i = 0;
      while (i < j)
      {
        arrayOfk[i].a(this.aDG, 1, this.aCl, 0, null);
        i += 1;
      }
      this.aDE = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.g
 * JD-Core Version:    0.7.0.1
 */