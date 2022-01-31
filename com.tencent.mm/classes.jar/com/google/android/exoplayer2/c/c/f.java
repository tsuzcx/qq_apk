package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.j;

public final class f
  implements h
{
  private k aCt;
  private int aDB;
  private final j aDi = new j(new byte[15]);
  private int aDk;
  private long aDm;
  private String aDt;
  private final String auI;
  private Format auL;
  private long ayE;
  private int sampleSize;
  private int state;
  
  public f(String paramString)
  {
    this.aDi.data[0] = 127;
    this.aDi.data[1] = -2;
    this.aDi.data[2] = -128;
    this.aDi.data[3] = 1;
    this.state = 0;
    this.auI = paramString;
  }
  
  public final void a(com.google.android.exoplayer2.c.f paramf, u.d paramd)
  {
    paramd.mg();
    this.aDt = paramd.mi();
    this.aCt = paramf.cQ(paramd.mh());
  }
  
  public final void b(j paramj)
  {
    while (paramj.oe() > 0)
    {
      switch (this.state)
      {
      default: 
        break;
      case 0: 
        while (paramj.oe() > 0)
        {
          this.aDB <<= 8;
          this.aDB |= paramj.readUnsignedByte();
          if (this.aDB == 2147385345) {
            this.aDB = 0;
          }
        }
        for (i = 1; i != 0; i = 0)
        {
          this.aDk = 4;
          this.state = 1;
          break;
        }
      case 1: 
        byte[] arrayOfByte = this.aDi.data;
        i = Math.min(paramj.oe(), 15 - this.aDk);
        paramj.readBytes(arrayOfByte, this.aDk, i);
        this.aDk += i;
        if (this.aDk == 15) {}
        for (i = 1; i != 0; i = 0)
        {
          arrayOfByte = this.aDi.data;
          if (this.auL == null)
          {
            this.auL = com.google.android.exoplayer2.a.h.a(arrayOfByte, this.aDt, this.auI);
            this.aCt.f(this.auL);
          }
          this.sampleSize = com.google.android.exoplayer2.a.h.h(arrayOfByte);
          this.aDm = ((int)(com.google.android.exoplayer2.a.h.g(arrayOfByte) * 1000000L / this.auL.sampleRate));
          this.aDi.setPosition(0);
          this.aCt.a(this.aDi, 15);
          this.state = 2;
          break;
        }
      }
      int i = Math.min(paramj.oe(), this.sampleSize - this.aDk);
      this.aCt.a(paramj, i);
      this.aDk = (i + this.aDk);
      if (this.aDk == this.sampleSize)
      {
        this.aCt.a(this.ayE, 1, this.sampleSize, 0, null);
        this.ayE += this.aDm;
        this.state = 0;
      }
    }
  }
  
  public final void d(long paramLong, boolean paramBoolean)
  {
    this.ayE = paramLong;
  }
  
  public final void lY()
  {
    this.state = 0;
    this.aDk = 0;
    this.aDB = 0;
  }
  
  public final void lZ() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.f
 * JD-Core Version:    0.7.0.1
 */