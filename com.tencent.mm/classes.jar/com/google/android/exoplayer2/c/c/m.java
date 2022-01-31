package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.i;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.j;

public final class m
  implements h
{
  private k aCt;
  private long aDI;
  private String aDt;
  private boolean aDx;
  private final j aEN = new j(4);
  private final i aEO;
  private int aEP;
  private boolean aEQ;
  private final String auI;
  private int avQ;
  private long ayE;
  private int state = 0;
  
  public m()
  {
    this(null);
  }
  
  public m(String paramString)
  {
    this.aEN.data[0] = -1;
    this.aEO = new i();
    this.auI = paramString;
  }
  
  public final void a(f paramf, u.d paramd)
  {
    paramd.mg();
    this.aDt = paramd.mi();
    this.aCt = paramf.cQ(paramd.mh());
  }
  
  public final void b(j paramj)
  {
    while (paramj.oe() > 0)
    {
      Object localObject;
      switch (this.state)
      {
      default: 
        break;
      case 0: 
        localObject = paramj.data;
        i = paramj.position;
        int k = paramj.limit;
        for (;;)
        {
          if (i >= k) {
            break label168;
          }
          boolean bool;
          if ((localObject[i] & 0xFF) == 255)
          {
            bool = true;
            if ((!this.aEQ) || ((localObject[i] & 0xE0) != 224)) {
              break label156;
            }
          }
          for (int j = 1;; j = 0)
          {
            this.aEQ = bool;
            if (j == 0) {
              break label161;
            }
            paramj.setPosition(i + 1);
            this.aEQ = false;
            this.aEN.data[1] = localObject[i];
            this.aEP = 2;
            this.state = 1;
            break;
            bool = false;
            break label79;
          }
          i += 1;
        }
        paramj.setPosition(k);
        break;
      case 1: 
        label79:
        i = Math.min(paramj.oe(), 4 - this.aEP);
        label156:
        label161:
        label168:
        paramj.readBytes(this.aEN.data, this.aEP, i);
        this.aEP = (i + this.aEP);
        if (this.aEP < 4) {
          continue;
        }
        this.aEN.setPosition(0);
        if (!i.a(this.aEN.readInt(), this.aEO))
        {
          this.aEP = 0;
          this.state = 1;
          continue;
        }
        this.avQ = this.aEO.avQ;
        if (!this.aDx)
        {
          this.aDI = (1000000L * this.aEO.azn / this.aEO.sampleRate);
          localObject = Format.a(this.aDt, this.aEO.mimeType, -1, 4096, this.aEO.channels, this.aEO.sampleRate, null, null, this.auI);
          this.aCt.f((Format)localObject);
          this.aDx = true;
        }
        this.aEN.setPosition(0);
        this.aCt.a(this.aEN, 4);
        this.state = 2;
        break;
      }
      int i = Math.min(paramj.oe(), this.avQ - this.aEP);
      this.aCt.a(paramj, i);
      this.aEP = (i + this.aEP);
      if (this.aEP >= this.avQ)
      {
        this.aCt.a(this.ayE, 1, this.avQ, 0, null);
        this.ayE += this.aDI;
        this.aEP = 0;
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
    this.aEP = 0;
    this.aEQ = false;
  }
  
  public final void lZ() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.m
 * JD-Core Version:    0.7.0.1
 */