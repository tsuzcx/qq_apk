package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.u;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  implements v
{
  private u bcR;
  private int bgc;
  private final h bhJ;
  private final l bhK;
  private boolean bhL;
  private boolean bhM;
  private boolean bhN;
  private int bhO;
  private int bhP;
  private boolean bhQ;
  private int state;
  private long timeUs;
  
  public o(h paramh)
  {
    AppMethodBeat.i(92265);
    this.bhJ = paramh;
    this.bhK = new l(new byte[10]);
    this.state = 0;
    AppMethodBeat.o(92265);
  }
  
  private boolean a(m paramm, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(92269);
    int i = Math.min(paramm.vy(), paramInt - this.bgc);
    if (i <= 0)
    {
      AppMethodBeat.o(92269);
      return true;
    }
    if (paramArrayOfByte == null) {
      paramm.eX(i);
    }
    for (;;)
    {
      this.bgc = (i + this.bgc);
      if (this.bgc != paramInt) {
        break;
      }
      AppMethodBeat.o(92269);
      return true;
      paramm.readBytes(paramArrayOfByte, this.bgc, i);
    }
    AppMethodBeat.o(92269);
    return false;
  }
  
  private void setState(int paramInt)
  {
    this.state = paramInt;
    this.bgc = 0;
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
      if (paramm.vy() > 0)
      {
        int i;
        switch (this.state)
        {
        default: 
          break;
        case 0: 
          paramm.eX(paramm.vy());
          continue;
          if (this.bhP != -1) {
            new StringBuilder("Unexpected start indicator: expected ").append(this.bhP).append(" more bytes");
          }
          this.bhJ.th();
          break;
        case 1: 
          if (a(paramm, this.bhK.data, 9))
          {
            this.bhK.setPosition(0);
            if (this.bhK.eo(24) != 1)
            {
              this.bhP = -1;
              i = 0;
              if (i == 0) {
                break label330;
              }
            }
            for (i = 2;; i = 0)
            {
              setState(i);
              break;
              this.bhK.ep(8);
              i = this.bhK.eo(16);
              this.bhK.ep(5);
              this.bhQ = this.bhK.te();
              this.bhK.ep(2);
              this.bhL = this.bhK.te();
              this.bhM = this.bhK.te();
              this.bhK.ep(6);
              this.bhO = this.bhK.eo(8);
              if (i == 0) {}
              for (this.bhP = -1;; this.bhP = (i + 6 - 9 - this.bhO))
              {
                i = 1;
                break;
              }
            }
          }
          break;
        case 2: 
          i = Math.min(10, this.bhO);
          if ((a(paramm, this.bhK.data, i)) && (a(paramm, null, this.bhO)))
          {
            this.bhK.setPosition(0);
            this.timeUs = -9223372036854775807L;
            if (this.bhL)
            {
              this.bhK.ep(4);
              long l1 = this.bhK.eo(3);
              this.bhK.ep(1);
              long l2 = this.bhK.eo(15) << 15;
              this.bhK.ep(1);
              long l3 = this.bhK.eo(15);
              this.bhK.ep(1);
              if ((!this.bhN) && (this.bhM))
              {
                this.bhK.ep(4);
                long l4 = this.bhK.eo(3);
                this.bhK.ep(1);
                long l5 = this.bhK.eo(15) << 15;
                this.bhK.ep(1);
                long l6 = this.bhK.eo(15);
                this.bhK.ep(1);
                this.bcR.ao(l4 << 30 | l5 | l6);
                this.bhN = true;
              }
              this.timeUs = this.bcR.ao(l1 << 30 | l2 | l3);
            }
            this.bhJ.c(this.timeUs, this.bhQ);
            setState(3);
          }
          break;
        case 3: 
          label330:
          int k = paramm.vy();
          if (this.bhP == -1) {}
          for (i = 0;; i = k - this.bhP)
          {
            int j = k;
            if (i > 0)
            {
              j = k - i;
              paramm.eW(paramm.position + j);
            }
            this.bhJ.t(paramm);
            if (this.bhP == -1) {
              break;
            }
            this.bhP -= j;
            if (this.bhP != 0) {
              break;
            }
            this.bhJ.th();
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
    this.bcR = paramu;
    this.bhJ.a(paramg, paramd);
    AppMethodBeat.o(92266);
  }
  
  public final void tg()
  {
    AppMethodBeat.i(92267);
    this.state = 0;
    this.bgc = 0;
    this.bhN = false;
    this.bhJ.tg();
    AppMethodBeat.o(92267);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.o
 * JD-Core Version:    0.7.0.1
 */