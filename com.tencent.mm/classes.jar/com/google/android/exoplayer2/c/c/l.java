package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.j;

public final class l
  implements h
{
  private k aCt;
  private boolean aDE;
  private long aDG;
  private final j aEL = new j(10);
  private int aEM;
  private int sampleSize;
  
  public final void a(f paramf, u.d paramd)
  {
    paramd.mg();
    this.aCt = paramf.cQ(paramd.mh());
    this.aCt.f(Format.j(paramd.mi(), "application/id3"));
  }
  
  public final void b(j paramj)
  {
    if (!this.aDE) {
      return;
    }
    int i = paramj.oe();
    if (this.aEM < 10)
    {
      int j = Math.min(i, 10 - this.aEM);
      System.arraycopy(paramj.data, paramj.position, this.aEL.data, this.aEM, j);
      if (j + this.aEM == 10)
      {
        this.aEL.setPosition(0);
        if ((73 != this.aEL.readUnsignedByte()) || (68 != this.aEL.readUnsignedByte()) || (51 != this.aEL.readUnsignedByte()))
        {
          this.aDE = false;
          return;
        }
        this.aEL.dB(3);
        this.sampleSize = (this.aEL.og() + 10);
      }
    }
    i = Math.min(i, this.sampleSize - this.aEM);
    this.aCt.a(paramj, i);
    this.aEM = (i + this.aEM);
  }
  
  public final void d(long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.aDE = true;
    this.aDG = paramLong;
    this.sampleSize = 0;
    this.aEM = 0;
  }
  
  public final void lY()
  {
    this.aDE = false;
  }
  
  public final void lZ()
  {
    if ((!this.aDE) || (this.sampleSize == 0) || (this.aEM != this.sampleSize)) {
      return;
    }
    this.aCt.a(this.aDG, 1, this.sampleSize, 0, null);
    this.aDE = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.l
 * JD-Core Version:    0.7.0.1
 */