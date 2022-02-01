package com.google.android.exoplayer2.c.g;

import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.u;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
  implements v
{
  private int bfv;
  private final q bhr;
  private final m bhs;
  private int bht;
  private boolean bhu;
  private boolean bhv;
  
  public r(q paramq)
  {
    AppMethodBeat.i(92279);
    this.bhr = paramq;
    this.bhs = new m(32);
    AppMethodBeat.o(92279);
  }
  
  public final void a(m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(92281);
    if (paramBoolean) {}
    for (int i = paramm.readUnsignedByte() + paramm.position;; i = -1)
    {
      if (this.bhv)
      {
        if (!paramBoolean)
        {
          AppMethodBeat.o(92281);
          return;
        }
        this.bhv = false;
        paramm.setPosition(i);
        this.bfv = 0;
      }
      while (paramm.vJ() > 0) {
        if (this.bfv < 3)
        {
          if (this.bfv == 0)
          {
            i = paramm.readUnsignedByte();
            paramm.setPosition(paramm.position - 1);
            if (i == 255)
            {
              this.bhv = true;
              AppMethodBeat.o(92281);
              return;
            }
          }
          i = Math.min(paramm.vJ(), 3 - this.bfv);
          paramm.readBytes(this.bhs.data, this.bfv, i);
          this.bfv = (i + this.bfv);
          if (this.bfv == 3)
          {
            this.bhs.reset(3);
            this.bhs.fl(1);
            i = this.bhs.readUnsignedByte();
            int j = this.bhs.readUnsignedByte();
            if ((i & 0x80) != 0) {}
            for (paramBoolean = true;; paramBoolean = false)
            {
              this.bhu = paramBoolean;
              this.bht = (((i & 0xF) << 8 | j) + 3);
              if (this.bhs.capacity() >= this.bht) {
                break;
              }
              byte[] arrayOfByte = this.bhs.data;
              this.bhs.reset(Math.min(4098, Math.max(this.bht, arrayOfByte.length * 2)));
              System.arraycopy(arrayOfByte, 0, this.bhs.data, 0, 3);
              break;
            }
          }
        }
        else
        {
          i = Math.min(paramm.vJ(), this.bht - this.bfv);
          paramm.readBytes(this.bhs.data, this.bfv, i);
          this.bfv = (i + this.bfv);
          if (this.bfv == this.bht)
          {
            if (this.bhu)
            {
              if (x.n(this.bhs.data, this.bht, -1) != 0)
              {
                this.bhv = true;
                AppMethodBeat.o(92281);
                return;
              }
              this.bhs.reset(this.bht - 4);
            }
            for (;;)
            {
              this.bhr.t(this.bhs);
              this.bfv = 0;
              break;
              this.bhs.reset(this.bht);
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
    this.bhr.a(paramu, paramg, paramd);
    this.bhv = true;
    AppMethodBeat.o(92280);
  }
  
  public final void sX()
  {
    this.bhv = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.g.r
 * JD-Core Version:    0.7.0.1
 */