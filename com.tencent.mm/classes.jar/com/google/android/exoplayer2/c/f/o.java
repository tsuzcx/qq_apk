package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.u;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  implements v
{
  private long aAT;
  private u aGN;
  private int aJW;
  private final h aLE;
  private final l aLF;
  private boolean aLG;
  private boolean aLH;
  private boolean aLI;
  private int aLJ;
  private int aLK;
  private boolean aLL;
  private int state;
  
  public o(h paramh)
  {
    AppMethodBeat.i(95143);
    this.aLE = paramh;
    this.aLF = new l(new byte[10]);
    this.state = 0;
    AppMethodBeat.o(95143);
  }
  
  private boolean a(m paramm, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(95147);
    int i = Math.min(paramm.qM(), paramInt - this.aJW);
    if (i <= 0)
    {
      AppMethodBeat.o(95147);
      return true;
    }
    if (paramArrayOfByte == null) {
      paramm.en(i);
    }
    for (;;)
    {
      this.aJW = (i + this.aJW);
      if (this.aJW != paramInt) {
        break;
      }
      AppMethodBeat.o(95147);
      return true;
      paramm.readBytes(paramArrayOfByte, this.aJW, i);
    }
    AppMethodBeat.o(95147);
    return false;
  }
  
  private void setState(int paramInt)
  {
    this.state = paramInt;
    this.aJW = 0;
  }
  
  public final void a(m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(95146);
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
      if (paramm.qM() > 0)
      {
        int i;
        switch (this.state)
        {
        default: 
          break;
        case 0: 
          paramm.en(paramm.qM());
          continue;
          if (this.aLK != -1) {
            new StringBuilder("Unexpected start indicator: expected ").append(this.aLK).append(" more bytes");
          }
          this.aLE.om();
          break;
        case 1: 
          if (a(paramm, this.aLF.data, 9))
          {
            this.aLF.setPosition(0);
            if (this.aLF.dD(24) != 1)
            {
              this.aLK = -1;
              i = 0;
              if (i == 0) {
                break label330;
              }
            }
            for (i = 2;; i = 0)
            {
              setState(i);
              break;
              this.aLF.dE(8);
              i = this.aLF.dD(16);
              this.aLF.dE(5);
              this.aLL = this.aLF.oj();
              this.aLF.dE(2);
              this.aLG = this.aLF.oj();
              this.aLH = this.aLF.oj();
              this.aLF.dE(6);
              this.aLJ = this.aLF.dD(8);
              if (i == 0) {}
              for (this.aLK = -1;; this.aLK = (i + 6 - 9 - this.aLJ))
              {
                i = 1;
                break;
              }
            }
          }
          break;
        case 2: 
          i = Math.min(10, this.aLJ);
          if ((a(paramm, this.aLF.data, i)) && (a(paramm, null, this.aLJ)))
          {
            this.aLF.setPosition(0);
            this.aAT = -9223372036854775807L;
            if (this.aLG)
            {
              this.aLF.dE(4);
              long l1 = this.aLF.dD(3);
              this.aLF.dE(1);
              long l2 = this.aLF.dD(15) << 15;
              this.aLF.dE(1);
              long l3 = this.aLF.dD(15);
              this.aLF.dE(1);
              if ((!this.aLI) && (this.aLH))
              {
                this.aLF.dE(4);
                long l4 = this.aLF.dD(3);
                this.aLF.dE(1);
                long l5 = this.aLF.dD(15) << 15;
                this.aLF.dE(1);
                long l6 = this.aLF.dD(15);
                this.aLF.dE(1);
                this.aGN.ah(l4 << 30 | l5 | l6);
                this.aLI = true;
              }
              this.aAT = this.aGN.ah(l1 << 30 | l2 | l3);
            }
            this.aLE.d(this.aAT, this.aLL);
            setState(3);
          }
          break;
        case 3: 
          label330:
          int k = paramm.qM();
          if (this.aLK == -1) {}
          for (i = 0;; i = k - this.aLK)
          {
            int j = k;
            if (i > 0)
            {
              j = k - i;
              paramm.em(paramm.position + j);
            }
            this.aLE.t(paramm);
            if (this.aLK == -1) {
              break;
            }
            this.aLK -= j;
            if (this.aLK != 0) {
              break;
            }
            this.aLE.om();
            setState(1);
            break;
          }
        }
      }
    }
    AppMethodBeat.o(95146);
  }
  
  public final void a(u paramu, g paramg, v.d paramd)
  {
    AppMethodBeat.i(95144);
    this.aGN = paramu;
    this.aLE.a(paramg, paramd);
    AppMethodBeat.o(95144);
  }
  
  public final void ol()
  {
    AppMethodBeat.i(95145);
    this.state = 0;
    this.aJW = 0;
    this.aLI = false;
    this.aLE.ol();
    AppMethodBeat.o(95145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.o
 * JD-Core Version:    0.7.0.1
 */