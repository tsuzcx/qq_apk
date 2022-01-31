package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.u;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
  implements v
{
  private int aJW;
  private final q aLS;
  private final m aLT;
  private int aLU;
  private boolean aLV;
  private boolean aLW;
  
  public r(q paramq)
  {
    AppMethodBeat.i(95157);
    this.aLS = paramq;
    this.aLT = new m(32);
    AppMethodBeat.o(95157);
  }
  
  public final void a(m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(95159);
    if (paramBoolean) {}
    for (int i = paramm.readUnsignedByte() + paramm.position;; i = -1)
    {
      if (this.aLW)
      {
        if (!paramBoolean)
        {
          AppMethodBeat.o(95159);
          return;
        }
        this.aLW = false;
        paramm.setPosition(i);
        this.aJW = 0;
      }
      while (paramm.qM() > 0) {
        if (this.aJW < 3)
        {
          if (this.aJW == 0)
          {
            i = paramm.readUnsignedByte();
            paramm.setPosition(paramm.position - 1);
            if (i == 255)
            {
              this.aLW = true;
              AppMethodBeat.o(95159);
              return;
            }
          }
          i = Math.min(paramm.qM(), 3 - this.aJW);
          paramm.readBytes(this.aLT.data, this.aJW, i);
          this.aJW = (i + this.aJW);
          if (this.aJW == 3)
          {
            this.aLT.reset(3);
            this.aLT.en(1);
            i = this.aLT.readUnsignedByte();
            int j = this.aLT.readUnsignedByte();
            if ((i & 0x80) != 0) {}
            for (paramBoolean = true;; paramBoolean = false)
            {
              this.aLV = paramBoolean;
              this.aLU = (((i & 0xF) << 8 | j) + 3);
              if (this.aLT.capacity() >= this.aLU) {
                break;
              }
              byte[] arrayOfByte = this.aLT.data;
              this.aLT.reset(Math.min(4098, Math.max(this.aLU, arrayOfByte.length * 2)));
              System.arraycopy(arrayOfByte, 0, this.aLT.data, 0, 3);
              break;
            }
          }
        }
        else
        {
          i = Math.min(paramm.qM(), this.aLU - this.aJW);
          paramm.readBytes(this.aLT.data, this.aJW, i);
          this.aJW = (i + this.aJW);
          if (this.aJW == this.aLU)
          {
            if (this.aLV)
            {
              if (x.m(this.aLT.data, this.aLU, -1) != 0)
              {
                this.aLW = true;
                AppMethodBeat.o(95159);
                return;
              }
              this.aLT.reset(this.aLU - 4);
            }
            for (;;)
            {
              this.aLS.t(this.aLT);
              this.aJW = 0;
              break;
              this.aLT.reset(this.aLU);
            }
          }
        }
      }
      AppMethodBeat.o(95159);
      return;
    }
  }
  
  public final void a(u paramu, g paramg, v.d paramd)
  {
    AppMethodBeat.i(95158);
    this.aLS.a(paramu, paramg, paramd);
    this.aLW = true;
    AppMethodBeat.o(95158);
  }
  
  public final void ol()
  {
    this.aLW = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.r
 * JD-Core Version:    0.7.0.1
 */