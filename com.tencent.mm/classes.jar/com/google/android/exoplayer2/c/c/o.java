package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;

public final class o
  implements u
{
  private q aBX;
  private int aDk;
  private final h aEV;
  private final i aEW;
  private boolean aEX;
  private boolean aEY;
  private boolean aEZ;
  private int aFa;
  private int aFb;
  private boolean aFc;
  private long ayE;
  private int state;
  
  public o(h paramh)
  {
    this.aEV = paramh;
    this.aEW = new i(new byte[10]);
    this.state = 0;
  }
  
  private boolean a(j paramj, byte[] paramArrayOfByte, int paramInt)
  {
    int i = Math.min(paramj.oe(), paramInt - this.aDk);
    if (i <= 0) {
      return true;
    }
    if (paramArrayOfByte == null) {
      paramj.dB(i);
    }
    for (;;)
    {
      this.aDk = (i + this.aDk);
      if (this.aDk == paramInt) {
        break;
      }
      return false;
      paramj.readBytes(paramArrayOfByte, this.aDk, i);
    }
  }
  
  private void setState(int paramInt)
  {
    this.state = paramInt;
    this.aDk = 0;
  }
  
  public final void a(j paramj, boolean paramBoolean)
  {
    if (paramBoolean) {
      switch (this.state)
      {
      case 0: 
      case 1: 
      case 2: 
      default: 
        setState(1);
      }
    }
    for (;;)
    {
      if (paramj.oe() > 0)
      {
        int i;
        switch (this.state)
        {
        default: 
          break;
        case 0: 
          paramj.dB(paramj.oe());
          continue;
          if (this.aFb != -1) {
            new StringBuilder("Unexpected start indicator: expected ").append(this.aFb).append(" more bytes");
          }
          this.aEV.lZ();
          break;
        case 1: 
          if (a(paramj, this.aEW.data, 9))
          {
            this.aEW.setPosition(0);
            if (this.aEW.dz(24) != 1)
            {
              this.aFb = -1;
              i = 0;
              if (i == 0) {
                break label326;
              }
            }
            for (i = 2;; i = 0)
            {
              setState(i);
              break;
              this.aEW.dy(8);
              i = this.aEW.dz(16);
              this.aEW.dy(5);
              this.aFc = this.aEW.ob();
              this.aEW.dy(2);
              this.aEX = this.aEW.ob();
              this.aEY = this.aEW.ob();
              this.aEW.dy(6);
              this.aFa = this.aEW.dz(8);
              if (i == 0) {}
              for (this.aFb = -1;; this.aFb = (i + 6 - 9 - this.aFa))
              {
                i = 1;
                break;
              }
            }
          }
          break;
        case 2: 
          i = Math.min(10, this.aFa);
          if ((a(paramj, this.aEW.data, i)) && (a(paramj, null, this.aFa)))
          {
            this.aEW.setPosition(0);
            this.ayE = -9223372036854775807L;
            if (this.aEX)
            {
              this.aEW.dy(4);
              long l1 = this.aEW.dz(3);
              this.aEW.dy(1);
              long l2 = this.aEW.dz(15) << 15;
              this.aEW.dy(1);
              long l3 = this.aEW.dz(15);
              this.aEW.dy(1);
              if ((!this.aEZ) && (this.aEY))
              {
                this.aEW.dy(4);
                long l4 = this.aEW.dz(3);
                this.aEW.dy(1);
                long l5 = this.aEW.dz(15) << 15;
                this.aEW.dy(1);
                long l6 = this.aEW.dz(15);
                this.aEW.dy(1);
                this.aBX.W(l4 << 30 | l5 | l6);
                this.aEZ = true;
              }
              this.ayE = this.aBX.W(l1 << 30 | l2 | l3);
            }
            this.aEV.d(this.ayE, this.aFc);
            setState(3);
          }
          break;
        case 3: 
          label326:
          int k = paramj.oe();
          if (this.aFb == -1) {}
          for (i = 0;; i = k - this.aFb)
          {
            int j = k;
            if (i > 0)
            {
              j = k - i;
              paramj.dA(paramj.position + j);
            }
            this.aEV.b(paramj);
            if (this.aFb == -1) {
              break;
            }
            this.aFb -= j;
            if (this.aFb != 0) {
              break;
            }
            this.aEV.lZ();
            setState(1);
            break;
          }
        }
      }
    }
  }
  
  public final void a(q paramq, f paramf, u.d paramd)
  {
    this.aBX = paramq;
    this.aEV.a(paramf, paramd);
  }
  
  public final void lY()
  {
    this.state = 0;
    this.aDk = 0;
    this.aEZ = false;
    this.aEV.lY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.o
 * JD-Core Version:    0.7.0.1
 */