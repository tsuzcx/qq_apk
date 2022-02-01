package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.u;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  implements v
{
  private u bnh;
  private int bqr;
  private final h brY;
  private final l brZ;
  private boolean bsa;
  private boolean bsb;
  private boolean bsc;
  private int bsd;
  private int bse;
  private boolean bsf;
  private int state;
  private long timeUs;
  
  public o(h paramh)
  {
    AppMethodBeat.i(92265);
    this.brY = paramh;
    this.brZ = new l(new byte[10]);
    this.state = 0;
    AppMethodBeat.o(92265);
  }
  
  private boolean a(m paramm, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(92269);
    int i = Math.min(paramm.xd(), paramInt - this.bqr);
    if (i <= 0)
    {
      AppMethodBeat.o(92269);
      return true;
    }
    if (paramArrayOfByte == null) {
      paramm.eZ(i);
    }
    for (;;)
    {
      this.bqr = (i + this.bqr);
      if (this.bqr != paramInt) {
        break;
      }
      AppMethodBeat.o(92269);
      return true;
      paramm.readBytes(paramArrayOfByte, this.bqr, i);
    }
    AppMethodBeat.o(92269);
    return false;
  }
  
  private void setState(int paramInt)
  {
    this.state = paramInt;
    this.bqr = 0;
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
      if (paramm.xd() > 0)
      {
        int i;
        switch (this.state)
        {
        default: 
          break;
        case 0: 
          paramm.eZ(paramm.xd());
          continue;
          if (this.bse != -1) {
            new StringBuilder("Unexpected start indicator: expected ").append(this.bse).append(" more bytes");
          }
          this.brY.uL();
          break;
        case 1: 
          if (a(paramm, this.brZ.data, 9))
          {
            this.brZ.setPosition(0);
            if (this.brZ.em(24) != 1)
            {
              this.bse = -1;
              i = 0;
              if (i == 0) {
                break label330;
              }
            }
            for (i = 2;; i = 0)
            {
              setState(i);
              break;
              this.brZ.en(8);
              i = this.brZ.em(16);
              this.brZ.en(5);
              this.bsf = this.brZ.uI();
              this.brZ.en(2);
              this.bsa = this.brZ.uI();
              this.bsb = this.brZ.uI();
              this.brZ.en(6);
              this.bsd = this.brZ.em(8);
              if (i == 0) {}
              for (this.bse = -1;; this.bse = (i + 6 - 9 - this.bsd))
              {
                i = 1;
                break;
              }
            }
          }
          break;
        case 2: 
          i = Math.min(10, this.bsd);
          if ((a(paramm, this.brZ.data, i)) && (a(paramm, null, this.bsd)))
          {
            this.brZ.setPosition(0);
            this.timeUs = -9223372036854775807L;
            if (this.bsa)
            {
              this.brZ.en(4);
              long l1 = this.brZ.em(3);
              this.brZ.en(1);
              long l2 = this.brZ.em(15) << 15;
              this.brZ.en(1);
              long l3 = this.brZ.em(15);
              this.brZ.en(1);
              if ((!this.bsc) && (this.bsb))
              {
                this.brZ.en(4);
                long l4 = this.brZ.em(3);
                this.brZ.en(1);
                long l5 = this.brZ.em(15) << 15;
                this.brZ.en(1);
                long l6 = this.brZ.em(15);
                this.brZ.en(1);
                this.bnh.ao(l4 << 30 | l5 | l6);
                this.bsc = true;
              }
              this.timeUs = this.bnh.ao(l1 << 30 | l2 | l3);
            }
            this.brY.c(this.timeUs, this.bsf);
            setState(3);
          }
          break;
        case 3: 
          label330:
          int k = paramm.xd();
          if (this.bse == -1) {}
          for (i = 0;; i = k - this.bse)
          {
            int j = k;
            if (i > 0)
            {
              j = k - i;
              paramm.eY(paramm.position + j);
            }
            this.brY.t(paramm);
            if (this.bse == -1) {
              break;
            }
            this.bse -= j;
            if (this.bse != 0) {
              break;
            }
            this.brY.uL();
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
    this.bnh = paramu;
    this.brY.a(paramg, paramd);
    AppMethodBeat.o(92266);
  }
  
  public final void uK()
  {
    AppMethodBeat.i(92267);
    this.state = 0;
    this.bqr = 0;
    this.bsc = false;
    this.brY.uK();
    AppMethodBeat.o(92267);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.o
 * JD-Core Version:    0.7.0.1
 */