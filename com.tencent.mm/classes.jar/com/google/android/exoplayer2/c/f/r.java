package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.u;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
  implements v
{
  private int cTO;
  private final q cVJ;
  private final m cVK;
  private int cVL;
  private boolean cVM;
  private boolean cVN;
  
  public r(q paramq)
  {
    AppMethodBeat.i(92279);
    this.cVJ = paramq;
    this.cVK = new m(32);
    AppMethodBeat.o(92279);
  }
  
  public final void Si()
  {
    this.cVN = true;
  }
  
  public final void a(m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(92281);
    if (paramBoolean) {}
    for (int i = paramm.readUnsignedByte() + paramm.position;; i = -1)
    {
      if (this.cVN)
      {
        if (!paramBoolean)
        {
          AppMethodBeat.o(92281);
          return;
        }
        this.cVN = false;
        paramm.setPosition(i);
        this.cTO = 0;
      }
      while (paramm.UF() > 0) {
        if (this.cTO < 3)
        {
          if (this.cTO == 0)
          {
            i = paramm.readUnsignedByte();
            paramm.setPosition(paramm.position - 1);
            if (i == 255)
            {
              this.cVN = true;
              AppMethodBeat.o(92281);
              return;
            }
          }
          i = Math.min(paramm.UF(), 3 - this.cTO);
          paramm.readBytes(this.cVK.data, this.cTO, i);
          this.cTO = (i + this.cTO);
          if (this.cTO == 3)
          {
            this.cVK.iF(3);
            this.cVK.iH(1);
            i = this.cVK.readUnsignedByte();
            int j = this.cVK.readUnsignedByte();
            if ((i & 0x80) != 0) {}
            for (paramBoolean = true;; paramBoolean = false)
            {
              this.cVM = paramBoolean;
              this.cVL = (((i & 0xF) << 8 | j) + 3);
              if (this.cVK.UG() >= this.cVL) {
                break;
              }
              byte[] arrayOfByte = this.cVK.data;
              this.cVK.iF(Math.min(4098, Math.max(this.cVL, arrayOfByte.length * 2)));
              System.arraycopy(arrayOfByte, 0, this.cVK.data, 0, 3);
              break;
            }
          }
        }
        else
        {
          i = Math.min(paramm.UF(), this.cVL - this.cTO);
          paramm.readBytes(this.cVK.data, this.cTO, i);
          this.cTO = (i + this.cTO);
          if (this.cTO == this.cVL)
          {
            if (this.cVM)
            {
              if (x.m(this.cVK.data, this.cVL, -1) != 0)
              {
                this.cVN = true;
                AppMethodBeat.o(92281);
                return;
              }
              this.cVK.iF(this.cVL - 4);
            }
            for (;;)
            {
              this.cVJ.t(this.cVK);
              this.cTO = 0;
              break;
              this.cVK.iF(this.cVL);
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
    this.cVJ.a(paramu, paramg, paramd);
    this.cVN = true;
    AppMethodBeat.o(92280);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.r
 * JD-Core Version:    0.7.0.1
 */