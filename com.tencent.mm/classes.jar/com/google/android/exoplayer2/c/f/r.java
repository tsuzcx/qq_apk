package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.u;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
  implements v
{
  private int aZT;
  private final q bbO;
  private final m bbP;
  private int bbQ;
  private boolean bbR;
  private boolean bbS;
  
  public r(q paramq)
  {
    AppMethodBeat.i(92279);
    this.bbO = paramq;
    this.bbP = new m(32);
    AppMethodBeat.o(92279);
  }
  
  public final void a(m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(92281);
    if (paramBoolean) {}
    for (int i = paramm.readUnsignedByte() + paramm.position;; i = -1)
    {
      if (this.bbS)
      {
        if (!paramBoolean)
        {
          AppMethodBeat.o(92281);
          return;
        }
        this.bbS = false;
        paramm.setPosition(i);
        this.aZT = 0;
      }
      while (paramm.vg() > 0) {
        if (this.aZT < 3)
        {
          if (this.aZT == 0)
          {
            i = paramm.readUnsignedByte();
            paramm.setPosition(paramm.position - 1);
            if (i == 255)
            {
              this.bbS = true;
              AppMethodBeat.o(92281);
              return;
            }
          }
          i = Math.min(paramm.vg(), 3 - this.aZT);
          paramm.readBytes(this.bbP.data, this.aZT, i);
          this.aZT = (i + this.aZT);
          if (this.aZT == 3)
          {
            this.bbP.fs(3);
            this.bbP.fu(1);
            i = this.bbP.readUnsignedByte();
            int j = this.bbP.readUnsignedByte();
            if ((i & 0x80) != 0) {}
            for (paramBoolean = true;; paramBoolean = false)
            {
              this.bbR = paramBoolean;
              this.bbQ = (((i & 0xF) << 8 | j) + 3);
              if (this.bbP.vh() >= this.bbQ) {
                break;
              }
              byte[] arrayOfByte = this.bbP.data;
              this.bbP.fs(Math.min(4098, Math.max(this.bbQ, arrayOfByte.length * 2)));
              System.arraycopy(arrayOfByte, 0, this.bbP.data, 0, 3);
              break;
            }
          }
        }
        else
        {
          i = Math.min(paramm.vg(), this.bbQ - this.aZT);
          paramm.readBytes(this.bbP.data, this.aZT, i);
          this.aZT = (i + this.aZT);
          if (this.aZT == this.bbQ)
          {
            if (this.bbR)
            {
              if (x.m(this.bbP.data, this.bbQ, -1) != 0)
              {
                this.bbS = true;
                AppMethodBeat.o(92281);
                return;
              }
              this.bbP.fs(this.bbQ - 4);
            }
            for (;;)
            {
              this.bbO.t(this.bbP);
              this.aZT = 0;
              break;
              this.bbP.fs(this.bbQ);
            }
          }
        }
      }
      AppMethodBeat.o(92281);
      return;
    }
  }
  
  public final void a(u paramu, g paramg, v.d paramd)
  {
    AppMethodBeat.i(92280);
    this.bbO.a(paramu, paramg, paramd);
    this.bbS = true;
    AppMethodBeat.o(92280);
  }
  
  public final void sF()
  {
    this.bbS = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.r
 * JD-Core Version:    0.7.0.1
 */