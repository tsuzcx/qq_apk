package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.u;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  implements v
{
  private u aWJ;
  private int aZT;
  private final h bbA;
  private final l bbB;
  private boolean bbC;
  private boolean bbD;
  private boolean bbE;
  private int bbF;
  private int bbG;
  private boolean bbH;
  private int state;
  private long timeUs;
  
  public o(h paramh)
  {
    AppMethodBeat.i(92265);
    this.bbA = paramh;
    this.bbB = new l(new byte[10]);
    this.state = 0;
    AppMethodBeat.o(92265);
  }
  
  private boolean a(m paramm, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(92269);
    int i = Math.min(paramm.vg(), paramInt - this.aZT);
    if (i <= 0)
    {
      AppMethodBeat.o(92269);
      return true;
    }
    if (paramArrayOfByte == null) {
      paramm.fu(i);
    }
    for (;;)
    {
      this.aZT = (i + this.aZT);
      if (this.aZT != paramInt) {
        break;
      }
      AppMethodBeat.o(92269);
      return true;
      paramm.readBytes(paramArrayOfByte, this.aZT, i);
    }
    AppMethodBeat.o(92269);
    return false;
  }
  
  private void setState(int paramInt)
  {
    this.state = paramInt;
    this.aZT = 0;
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
      if (paramm.vg() > 0)
      {
        int i;
        switch (this.state)
        {
        default: 
          break;
        case 0: 
          paramm.fu(paramm.vg());
          continue;
          if (this.bbG != -1) {
            new StringBuilder("Unexpected start indicator: expected ").append(this.bbG).append(" more bytes");
          }
          this.bbA.sG();
          break;
        case 1: 
          if (a(paramm, this.bbB.data, 9))
          {
            this.bbB.setPosition(0);
            if (this.bbB.eA(24) != 1)
            {
              this.bbG = -1;
              i = 0;
              if (i == 0) {
                break label330;
              }
            }
            for (i = 2;; i = 0)
            {
              setState(i);
              break;
              this.bbB.eB(8);
              i = this.bbB.eA(16);
              this.bbB.eB(5);
              this.bbH = this.bbB.sD();
              this.bbB.eB(2);
              this.bbC = this.bbB.sD();
              this.bbD = this.bbB.sD();
              this.bbB.eB(6);
              this.bbF = this.bbB.eA(8);
              if (i == 0) {}
              for (this.bbG = -1;; this.bbG = (i + 6 - 9 - this.bbF))
              {
                i = 1;
                break;
              }
            }
          }
          break;
        case 2: 
          i = Math.min(10, this.bbF);
          if ((a(paramm, this.bbB.data, i)) && (a(paramm, null, this.bbF)))
          {
            this.bbB.setPosition(0);
            this.timeUs = -9223372036854775807L;
            if (this.bbC)
            {
              this.bbB.eB(4);
              long l1 = this.bbB.eA(3);
              this.bbB.eB(1);
              long l2 = this.bbB.eA(15) << 15;
              this.bbB.eB(1);
              long l3 = this.bbB.eA(15);
              this.bbB.eB(1);
              if ((!this.bbE) && (this.bbD))
              {
                this.bbB.eB(4);
                long l4 = this.bbB.eA(3);
                this.bbB.eB(1);
                long l5 = this.bbB.eA(15) << 15;
                this.bbB.eB(1);
                long l6 = this.bbB.eA(15);
                this.bbB.eB(1);
                this.aWJ.as(l4 << 30 | l5 | l6);
                this.bbE = true;
              }
              this.timeUs = this.aWJ.as(l1 << 30 | l2 | l3);
            }
            this.bbA.c(this.timeUs, this.bbH);
            setState(3);
          }
          break;
        case 3: 
          label330:
          int k = paramm.vg();
          if (this.bbG == -1) {}
          for (i = 0;; i = k - this.bbG)
          {
            int j = k;
            if (i > 0)
            {
              j = k - i;
              paramm.ft(paramm.position + j);
            }
            this.bbA.t(paramm);
            if (this.bbG == -1) {
              break;
            }
            this.bbG -= j;
            if (this.bbG != 0) {
              break;
            }
            this.bbA.sG();
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
    this.aWJ = paramu;
    this.bbA.a(paramg, paramd);
    AppMethodBeat.o(92266);
  }
  
  public final void sF()
  {
    AppMethodBeat.i(92267);
    this.state = 0;
    this.aZT = 0;
    this.bbE = false;
    this.bbA.sF();
    AppMethodBeat.o(92267);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.o
 * JD-Core Version:    0.7.0.1
 */