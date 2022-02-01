package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.u;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  implements v
{
  private u cQF;
  private int cTO;
  private int cVA;
  private int cVB;
  private boolean cVC;
  private final h cVv;
  private final l cVw;
  private boolean cVx;
  private boolean cVy;
  private boolean cVz;
  private int state;
  private long timeUs;
  
  public o(h paramh)
  {
    AppMethodBeat.i(92265);
    this.cVv = paramh;
    this.cVw = new l(new byte[10]);
    this.state = 0;
    AppMethodBeat.o(92265);
  }
  
  private boolean a(m paramm, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(92269);
    int i = Math.min(paramm.UF(), paramInt - this.cTO);
    if (i <= 0)
    {
      AppMethodBeat.o(92269);
      return true;
    }
    if (paramArrayOfByte == null) {
      paramm.iH(i);
    }
    for (;;)
    {
      this.cTO = (i + this.cTO);
      if (this.cTO != paramInt) {
        break;
      }
      AppMethodBeat.o(92269);
      return true;
      paramm.readBytes(paramArrayOfByte, this.cTO, i);
    }
    AppMethodBeat.o(92269);
    return false;
  }
  
  private void setState(int paramInt)
  {
    this.state = paramInt;
    this.cTO = 0;
  }
  
  public final void Si()
  {
    AppMethodBeat.i(92267);
    this.state = 0;
    this.cTO = 0;
    this.cVz = false;
    this.cVv.Si();
    AppMethodBeat.o(92267);
  }
  
  public final void a(m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(92268);
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
      if (paramm.UF() > 0)
      {
        int i;
        switch (this.state)
        {
        default: 
          break;
        case 0: 
          paramm.iH(paramm.UF());
          continue;
          if (this.cVB != -1) {
            new StringBuilder("Unexpected start indicator: expected ").append(this.cVB).append(" more bytes");
          }
          this.cVv.Sj();
          break;
        case 1: 
          if (a(paramm, this.cVw.data, 9))
          {
            this.cVw.setPosition(0);
            if (this.cVw.hQ(24) != 1)
            {
              this.cVB = -1;
              i = 0;
              if (i == 0) {
                break label330;
              }
            }
            for (i = 2;; i = 0)
            {
              setState(i);
              break;
              this.cVw.hR(8);
              i = this.cVw.hQ(16);
              this.cVw.hR(5);
              this.cVC = this.cVw.Sg();
              this.cVw.hR(2);
              this.cVx = this.cVw.Sg();
              this.cVy = this.cVw.Sg();
              this.cVw.hR(6);
              this.cVA = this.cVw.hQ(8);
              if (i == 0) {}
              for (this.cVB = -1;; this.cVB = (i + 6 - 9 - this.cVA))
              {
                i = 1;
                break;
              }
            }
          }
          break;
        case 2: 
          i = Math.min(10, this.cVA);
          if ((a(paramm, this.cVw.data, i)) && (a(paramm, null, this.cVA)))
          {
            this.cVw.setPosition(0);
            this.timeUs = -9223372036854775807L;
            if (this.cVx)
            {
              this.cVw.hR(4);
              long l1 = this.cVw.hQ(3);
              this.cVw.hR(1);
              long l2 = this.cVw.hQ(15) << 15;
              this.cVw.hR(1);
              long l3 = this.cVw.hQ(15);
              this.cVw.hR(1);
              if ((!this.cVz) && (this.cVy))
              {
                this.cVw.hR(4);
                long l4 = this.cVw.hQ(3);
                this.cVw.hR(1);
                long l5 = this.cVw.hQ(15) << 15;
                this.cVw.hR(1);
                long l6 = this.cVw.hQ(15);
                this.cVw.hR(1);
                this.cQF.cG(l4 << 30 | l5 | l6);
                this.cVz = true;
              }
              this.timeUs = this.cQF.cG(l1 << 30 | l2 | l3);
            }
            this.cVv.h(this.timeUs, this.cVC);
            setState(3);
          }
          break;
        case 3: 
          label330:
          int k = paramm.UF();
          if (this.cVB == -1) {}
          for (i = 0;; i = k - this.cVB)
          {
            int j = k;
            if (i > 0)
            {
              j = k - i;
              paramm.iG(paramm.position + j);
            }
            this.cVv.t(paramm);
            if (this.cVB == -1) {
              break;
            }
            this.cVB -= j;
            if (this.cVB != 0) {
              break;
            }
            this.cVv.Sj();
            setState(1);
            break;
          }
        }
      }
    }
    AppMethodBeat.o(92268);
  }
  
  public final void a(u paramu, g paramg, v.d paramd)
  {
    AppMethodBeat.i(92266);
    this.cQF = paramu;
    this.cVv.a(paramg, paramd);
    AppMethodBeat.o(92266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.o
 * JD-Core Version:    0.7.0.1
 */