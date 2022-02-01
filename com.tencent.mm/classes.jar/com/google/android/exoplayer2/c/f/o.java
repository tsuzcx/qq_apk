package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.u;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  implements v
{
  private u bnm;
  private int bqw;
  private final h bsd;
  private final l bse;
  private boolean bsf;
  private boolean bsg;
  private boolean bsh;
  private int bsi;
  private int bsj;
  private boolean bsk;
  private int state;
  private long timeUs;
  
  public o(h paramh)
  {
    AppMethodBeat.i(92265);
    this.bsd = paramh;
    this.bse = new l(new byte[10]);
    this.state = 0;
    AppMethodBeat.o(92265);
  }
  
  private boolean a(m paramm, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(92269);
    int i = Math.min(paramm.wV(), paramInt - this.bqw);
    if (i <= 0)
    {
      AppMethodBeat.o(92269);
      return true;
    }
    if (paramArrayOfByte == null) {
      paramm.fa(i);
    }
    for (;;)
    {
      this.bqw = (i + this.bqw);
      if (this.bqw != paramInt) {
        break;
      }
      AppMethodBeat.o(92269);
      return true;
      paramm.readBytes(paramArrayOfByte, this.bqw, i);
    }
    AppMethodBeat.o(92269);
    return false;
  }
  
  private void setState(int paramInt)
  {
    this.state = paramInt;
    this.bqw = 0;
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
      if (paramm.wV() > 0)
      {
        int i;
        switch (this.state)
        {
        default: 
          break;
        case 0: 
          paramm.fa(paramm.wV());
          continue;
          if (this.bsj != -1) {
            new StringBuilder("Unexpected start indicator: expected ").append(this.bsj).append(" more bytes");
          }
          this.bsd.uG();
          break;
        case 1: 
          if (a(paramm, this.bse.data, 9))
          {
            this.bse.setPosition(0);
            if (this.bse.es(24) != 1)
            {
              this.bsj = -1;
              i = 0;
              if (i == 0) {
                break label330;
              }
            }
            for (i = 2;; i = 0)
            {
              setState(i);
              break;
              this.bse.et(8);
              i = this.bse.es(16);
              this.bse.et(5);
              this.bsk = this.bse.uD();
              this.bse.et(2);
              this.bsf = this.bse.uD();
              this.bsg = this.bse.uD();
              this.bse.et(6);
              this.bsi = this.bse.es(8);
              if (i == 0) {}
              for (this.bsj = -1;; this.bsj = (i + 6 - 9 - this.bsi))
              {
                i = 1;
                break;
              }
            }
          }
          break;
        case 2: 
          i = Math.min(10, this.bsi);
          if ((a(paramm, this.bse.data, i)) && (a(paramm, null, this.bsi)))
          {
            this.bse.setPosition(0);
            this.timeUs = -9223372036854775807L;
            if (this.bsf)
            {
              this.bse.et(4);
              long l1 = this.bse.es(3);
              this.bse.et(1);
              long l2 = this.bse.es(15) << 15;
              this.bse.et(1);
              long l3 = this.bse.es(15);
              this.bse.et(1);
              if ((!this.bsh) && (this.bsg))
              {
                this.bse.et(4);
                long l4 = this.bse.es(3);
                this.bse.et(1);
                long l5 = this.bse.es(15) << 15;
                this.bse.et(1);
                long l6 = this.bse.es(15);
                this.bse.et(1);
                this.bnm.ao(l4 << 30 | l5 | l6);
                this.bsh = true;
              }
              this.timeUs = this.bnm.ao(l1 << 30 | l2 | l3);
            }
            this.bsd.c(this.timeUs, this.bsk);
            setState(3);
          }
          break;
        case 3: 
          label330:
          int k = paramm.wV();
          if (this.bsj == -1) {}
          for (i = 0;; i = k - this.bsj)
          {
            int j = k;
            if (i > 0)
            {
              j = k - i;
              paramm.eZ(paramm.position + j);
            }
            this.bsd.t(paramm);
            if (this.bsj == -1) {
              break;
            }
            this.bsj -= j;
            if (this.bsj != 0) {
              break;
            }
            this.bsd.uG();
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
    this.bnm = paramu;
    this.bsd.a(paramg, paramd);
    AppMethodBeat.o(92266);
  }
  
  public final void uF()
  {
    AppMethodBeat.i(92267);
    this.state = 0;
    this.bqw = 0;
    this.bsh = false;
    this.bsd.uF();
    AppMethodBeat.o(92267);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.o
 * JD-Core Version:    0.7.0.1
 */