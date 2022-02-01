package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.u;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
  implements v
{
  private int bqr;
  private final q bsm;
  private final m bsn;
  private int bso;
  private boolean bsp;
  private boolean bsq;
  
  public r(q paramq)
  {
    AppMethodBeat.i(92279);
    this.bsm = paramq;
    this.bsn = new m(32);
    AppMethodBeat.o(92279);
  }
  
  public final void a(m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(92281);
    if (paramBoolean) {}
    for (int i = paramm.readUnsignedByte() + paramm.position;; i = -1)
    {
      if (this.bsq)
      {
        if (!paramBoolean)
        {
          AppMethodBeat.o(92281);
          return;
        }
        this.bsq = false;
        paramm.setPosition(i);
        this.bqr = 0;
      }
      while (paramm.xd() > 0) {
        if (this.bqr < 3)
        {
          if (this.bqr == 0)
          {
            i = paramm.readUnsignedByte();
            paramm.setPosition(paramm.position - 1);
            if (i == 255)
            {
              this.bsq = true;
              AppMethodBeat.o(92281);
              return;
            }
          }
          i = Math.min(paramm.xd(), 3 - this.bqr);
          paramm.readBytes(this.bsn.data, this.bqr, i);
          this.bqr = (i + this.bqr);
          if (this.bqr == 3)
          {
            this.bsn.reset(3);
            this.bsn.eZ(1);
            i = this.bsn.readUnsignedByte();
            int j = this.bsn.readUnsignedByte();
            if ((i & 0x80) != 0) {}
            for (paramBoolean = true;; paramBoolean = false)
            {
              this.bsp = paramBoolean;
              this.bso = (((i & 0xF) << 8 | j) + 3);
              if (this.bsn.capacity() >= this.bso) {
                break;
              }
              byte[] arrayOfByte = this.bsn.data;
              this.bsn.reset(Math.min(4098, Math.max(this.bso, arrayOfByte.length * 2)));
              System.arraycopy(arrayOfByte, 0, this.bsn.data, 0, 3);
              break;
            }
          }
        }
        else
        {
          i = Math.min(paramm.xd(), this.bso - this.bqr);
          paramm.readBytes(this.bsn.data, this.bqr, i);
          this.bqr = (i + this.bqr);
          if (this.bqr == this.bso)
          {
            if (this.bsp)
            {
              if (x.m(this.bsn.data, this.bso, -1) != 0)
              {
                this.bsq = true;
                AppMethodBeat.o(92281);
                return;
              }
              this.bsn.reset(this.bso - 4);
            }
            for (;;)
            {
              this.bsm.t(this.bsn);
              this.bqr = 0;
              break;
              this.bsn.reset(this.bso);
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
    this.bsm.a(paramu, paramg, paramd);
    this.bsq = true;
    AppMethodBeat.o(92280);
  }
  
  public final void uK()
  {
    this.bsq = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.r
 * JD-Core Version:    0.7.0.1
 */