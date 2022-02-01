package com.google.android.exoplayer2.c.g;

import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.u;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  implements v
{
  private u bcf;
  private int bfv;
  private final h bhd;
  private final l bhe;
  private boolean bhf;
  private boolean bhg;
  private boolean bhh;
  private int bhi;
  private int bhj;
  private boolean bhk;
  private int state;
  private long timeUs;
  
  public o(h paramh)
  {
    AppMethodBeat.i(92265);
    this.bhd = paramh;
    this.bhe = new l(new byte[10]);
    this.state = 0;
    AppMethodBeat.o(92265);
  }
  
  private boolean a(m paramm, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(92269);
    int i = Math.min(paramm.vJ(), paramInt - this.bfv);
    if (i <= 0)
    {
      AppMethodBeat.o(92269);
      return true;
    }
    if (paramArrayOfByte == null) {
      paramm.fl(i);
    }
    for (;;)
    {
      this.bfv = (i + this.bfv);
      if (this.bfv != paramInt) {
        break;
      }
      AppMethodBeat.o(92269);
      return true;
      paramm.readBytes(paramArrayOfByte, this.bfv, i);
    }
    AppMethodBeat.o(92269);
    return false;
  }
  
  private void setState(int paramInt)
  {
    this.state = paramInt;
    this.bfv = 0;
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
      if (paramm.vJ() > 0)
      {
        int i;
        switch (this.state)
        {
        default: 
          break;
        case 0: 
          paramm.fl(paramm.vJ());
          continue;
          if (this.bhj != -1) {
            new StringBuilder("Unexpected start indicator: expected ").append(this.bhj).append(" more bytes");
          }
          this.bhd.sY();
          break;
        case 1: 
          if (a(paramm, this.bhe.data, 9))
          {
            this.bhe.setPosition(0);
            if (this.bhe.eo(24) != 1)
            {
              this.bhj = -1;
              i = 0;
              if (i == 0) {
                break label330;
              }
            }
            for (i = 2;; i = 0)
            {
              setState(i);
              break;
              this.bhe.ep(8);
              i = this.bhe.eo(16);
              this.bhe.ep(5);
              this.bhk = this.bhe.sV();
              this.bhe.ep(2);
              this.bhf = this.bhe.sV();
              this.bhg = this.bhe.sV();
              this.bhe.ep(6);
              this.bhi = this.bhe.eo(8);
              if (i == 0) {}
              for (this.bhj = -1;; this.bhj = (i + 6 - 9 - this.bhi))
              {
                i = 1;
                break;
              }
            }
          }
          break;
        case 2: 
          i = Math.min(10, this.bhi);
          if ((a(paramm, this.bhe.data, i)) && (a(paramm, null, this.bhi)))
          {
            this.bhe.setPosition(0);
            this.timeUs = -9223372036854775807L;
            if (this.bhf)
            {
              this.bhe.ep(4);
              long l1 = this.bhe.eo(3);
              this.bhe.ep(1);
              long l2 = this.bhe.eo(15) << 15;
              this.bhe.ep(1);
              long l3 = this.bhe.eo(15);
              this.bhe.ep(1);
              if ((!this.bhh) && (this.bhg))
              {
                this.bhe.ep(4);
                long l4 = this.bhe.eo(3);
                this.bhe.ep(1);
                long l5 = this.bhe.eo(15) << 15;
                this.bhe.ep(1);
                long l6 = this.bhe.eo(15);
                this.bhe.ep(1);
                this.bcf.as(l4 << 30 | l5 | l6);
                this.bhh = true;
              }
              this.timeUs = this.bcf.as(l1 << 30 | l2 | l3);
            }
            this.bhd.c(this.timeUs, this.bhk);
            setState(3);
          }
          break;
        case 3: 
          label330:
          int k = paramm.vJ();
          if (this.bhj == -1) {}
          for (i = 0;; i = k - this.bhj)
          {
            int j = k;
            if (i > 0)
            {
              j = k - i;
              paramm.fk(paramm.position + j);
            }
            this.bhd.t(paramm);
            if (this.bhj == -1) {
              break;
            }
            this.bhj -= j;
            if (this.bhj != 0) {
              break;
            }
            this.bhd.sY();
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
    this.bcf = paramu;
    this.bhd.a(paramg, paramd);
    AppMethodBeat.o(92266);
  }
  
  public final void sX()
  {
    AppMethodBeat.i(92267);
    this.state = 0;
    this.bfv = 0;
    this.bhh = false;
    this.bhd.sX();
    AppMethodBeat.o(92267);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.g.o
 * JD-Core Version:    0.7.0.1
 */