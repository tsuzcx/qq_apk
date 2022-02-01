package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.u;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
  implements v
{
  private int bgc;
  private final q bhX;
  private final m bhY;
  private int bhZ;
  private boolean bia;
  private boolean bib;
  
  public r(q paramq)
  {
    AppMethodBeat.i(92279);
    this.bhX = paramq;
    this.bhY = new m(32);
    AppMethodBeat.o(92279);
  }
  
  public final void a(m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(92281);
    if (paramBoolean) {}
    for (int i = paramm.readUnsignedByte() + paramm.position;; i = -1)
    {
      if (this.bib)
      {
        if (!paramBoolean)
        {
          AppMethodBeat.o(92281);
          return;
        }
        this.bib = false;
        paramm.setPosition(i);
        this.bgc = 0;
      }
      while (paramm.vy() > 0) {
        if (this.bgc < 3)
        {
          if (this.bgc == 0)
          {
            i = paramm.readUnsignedByte();
            paramm.setPosition(paramm.position - 1);
            if (i == 255)
            {
              this.bib = true;
              AppMethodBeat.o(92281);
              return;
            }
          }
          i = Math.min(paramm.vy(), 3 - this.bgc);
          paramm.readBytes(this.bhY.data, this.bgc, i);
          this.bgc = (i + this.bgc);
          if (this.bgc == 3)
          {
            this.bhY.reset(3);
            this.bhY.eX(1);
            i = this.bhY.readUnsignedByte();
            int j = this.bhY.readUnsignedByte();
            if ((i & 0x80) != 0) {}
            for (paramBoolean = true;; paramBoolean = false)
            {
              this.bia = paramBoolean;
              this.bhZ = (((i & 0xF) << 8 | j) + 3);
              if (this.bhY.capacity() >= this.bhZ) {
                break;
              }
              byte[] arrayOfByte = this.bhY.data;
              this.bhY.reset(Math.min(4098, Math.max(this.bhZ, arrayOfByte.length * 2)));
              System.arraycopy(arrayOfByte, 0, this.bhY.data, 0, 3);
              break;
            }
          }
        }
        else
        {
          i = Math.min(paramm.vy(), this.bhZ - this.bgc);
          paramm.readBytes(this.bhY.data, this.bgc, i);
          this.bgc = (i + this.bgc);
          if (this.bgc == this.bhZ)
          {
            if (this.bia)
            {
              if (x.m(this.bhY.data, this.bhZ, -1) != 0)
              {
                this.bib = true;
                AppMethodBeat.o(92281);
                return;
              }
              this.bhY.reset(this.bhZ - 4);
            }
            for (;;)
            {
              this.bhX.t(this.bhY);
              this.bgc = 0;
              break;
              this.bhY.reset(this.bhZ);
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
    this.bhX.a(paramu, paramg, paramd);
    this.bib = true;
    AppMethodBeat.o(92280);
  }
  
  public final void tg()
  {
    this.bib = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.r
 * JD-Core Version:    0.7.0.1
 */