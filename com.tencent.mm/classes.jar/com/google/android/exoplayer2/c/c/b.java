package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.a.a;
import com.google.android.exoplayer2.a.a.a;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.j;

public final class b
  implements h
{
  private k aCt;
  private final i aDh = new i(new byte[8]);
  private final j aDi = new j(this.aDh.data);
  private String aDj;
  private int aDk;
  private boolean aDl;
  private long aDm;
  private final String auI;
  private Format auL;
  long ayE;
  private int sampleSize;
  private int state = 0;
  
  public b()
  {
    this(null);
  }
  
  public b(String paramString)
  {
    this.auI = paramString;
  }
  
  public final void a(f paramf, u.d paramd)
  {
    paramd.mg();
    this.aDj = paramd.mi();
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
        boolean bool;
        if (paramj.oe() > 0)
        {
          if (!this.aDl)
          {
            if (paramj.readUnsignedByte() == 11) {}
            for (bool = true;; bool = false)
            {
              this.aDl = bool;
              break;
            }
          }
          i = paramj.readUnsignedByte();
          if (i == 119) {
            this.aDl = false;
          }
        }
        for (i = 1; i != 0; i = 0)
        {
          this.state = 1;
          this.aDi.data[0] = 11;
          this.aDi.data[1] = 119;
          this.aDk = 2;
          break;
          if (i == 11) {}
          for (bool = true;; bool = false)
          {
            this.aDl = bool;
            break;
          }
        }
      case 1: 
        Object localObject = this.aDi.data;
        i = Math.min(paramj.oe(), 8 - this.aDk);
        paramj.readBytes((byte[])localObject, this.aDk, i);
        this.aDk += i;
        if (this.aDk == 8) {}
        for (i = 1; i != 0; i = 0)
        {
          this.aDh.setPosition(0);
          localObject = a.a(this.aDh);
          if ((this.auL == null) || (((a.a)localObject).auC != this.auL.auC) || (((a.a)localObject).sampleRate != this.auL.sampleRate) || (((a.a)localObject).mimeType != this.auL.aus))
          {
            this.auL = Format.a(this.aDj, ((a.a)localObject).mimeType, -1, -1, ((a.a)localObject).auC, ((a.a)localObject).sampleRate, null, null, this.auI);
            this.aCt.f(this.auL);
          }
          this.sampleSize = ((a.a)localObject).avQ;
          this.aDm = (1000000L * ((a.a)localObject).sampleCount / this.auL.sampleRate);
          this.aDi.setPosition(0);
          this.aCt.a(this.aDi, 8);
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
    this.aDl = false;
  }
  
  public final void lZ() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.b
 * JD-Core Version:    0.7.0.1
 */