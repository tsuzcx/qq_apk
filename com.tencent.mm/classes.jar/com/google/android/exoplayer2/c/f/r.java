package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.u;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
  implements v
{
  private int bqw;
  private final q bsr;
  private final m bss;
  private int bst;
  private boolean bsu;
  private boolean bsv;
  
  public r(q paramq)
  {
    AppMethodBeat.i(92279);
    this.bsr = paramq;
    this.bss = new m(32);
    AppMethodBeat.o(92279);
  }
  
  public final void a(m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(92281);
    if (paramBoolean) {}
    for (int i = paramm.readUnsignedByte() + paramm.position;; i = -1)
    {
      if (this.bsv)
      {
        if (!paramBoolean)
        {
          AppMethodBeat.o(92281);
          return;
        }
        this.bsv = false;
        paramm.setPosition(i);
        this.bqw = 0;
      }
      while (paramm.wV() > 0) {
        if (this.bqw < 3)
        {
          if (this.bqw == 0)
          {
            i = paramm.readUnsignedByte();
            paramm.setPosition(paramm.position - 1);
            if (i == 255)
            {
              this.bsv = true;
              AppMethodBeat.o(92281);
              return;
            }
          }
          i = Math.min(paramm.wV(), 3 - this.bqw);
          paramm.readBytes(this.bss.data, this.bqw, i);
          this.bqw = (i + this.bqw);
          if (this.bqw == 3)
          {
            this.bss.reset(3);
            this.bss.fa(1);
            i = this.bss.readUnsignedByte();
            int j = this.bss.readUnsignedByte();
            if ((i & 0x80) != 0) {}
            for (paramBoolean = true;; paramBoolean = false)
            {
              this.bsu = paramBoolean;
              this.bst = (((i & 0xF) << 8 | j) + 3);
              if (this.bss.capacity() >= this.bst) {
                break;
              }
              byte[] arrayOfByte = this.bss.data;
              this.bss.reset(Math.min(4098, Math.max(this.bst, arrayOfByte.length * 2)));
              System.arraycopy(arrayOfByte, 0, this.bss.data, 0, 3);
              break;
            }
          }
        }
        else
        {
          i = Math.min(paramm.wV(), this.bst - this.bqw);
          paramm.readBytes(this.bss.data, this.bqw, i);
          this.bqw = (i + this.bqw);
          if (this.bqw == this.bst)
          {
            if (this.bsu)
            {
              if (x.m(this.bss.data, this.bst, -1) != 0)
              {
                this.bsv = true;
                AppMethodBeat.o(92281);
                return;
              }
              this.bss.reset(this.bst - 4);
            }
            for (;;)
            {
              this.bsr.t(this.bss);
              this.bqw = 0;
              break;
              this.bss.reset(this.bst);
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
    this.bsr.a(paramu, paramg, paramd);
    this.bsv = true;
    AppMethodBeat.o(92280);
  }
  
  public final void uF()
  {
    this.bsv = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.r
 * JD-Core Version:    0.7.0.1
 */