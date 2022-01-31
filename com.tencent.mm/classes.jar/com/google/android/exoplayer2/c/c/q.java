package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.t;

public final class q
  implements u
{
  private int aDk;
  private final p aFd;
  private final j aFe;
  private int aFf;
  private boolean aFg;
  private boolean aFh;
  
  public q(p paramp)
  {
    this.aFd = paramp;
    this.aFe = new j(32);
  }
  
  public final void a(j paramj, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = paramj.readUnsignedByte() + paramj.position;; i = -1)
    {
      if (this.aFh)
      {
        if (!paramBoolean) {
          return;
        }
        this.aFh = false;
        paramj.setPosition(i);
        this.aDk = 0;
      }
      label41:
      while (paramj.oe() > 0) {
        if (this.aDk < 3)
        {
          if (this.aDk == 0)
          {
            i = paramj.readUnsignedByte();
            paramj.setPosition(paramj.position - 1);
            if (i == 255)
            {
              this.aFh = true;
              return;
            }
          }
          i = Math.min(paramj.oe(), 3 - this.aDk);
          paramj.readBytes(this.aFe.data, this.aDk, i);
          this.aDk = (i + this.aDk);
          if (this.aDk == 3)
          {
            this.aFe.reset(3);
            this.aFe.dB(1);
            i = this.aFe.readUnsignedByte();
            int j = this.aFe.readUnsignedByte();
            if ((i & 0x80) != 0) {}
            for (paramBoolean = true;; paramBoolean = false)
            {
              this.aFg = paramBoolean;
              this.aFf = (((i & 0xF) << 8 | j) + 3);
              if (this.aFe.capacity() >= this.aFf) {
                break;
              }
              byte[] arrayOfByte = this.aFe.data;
              this.aFe.reset(Math.min(4098, Math.max(this.aFf, arrayOfByte.length * 2)));
              System.arraycopy(arrayOfByte, 0, this.aFe.data, 0, 3);
              break;
            }
          }
        }
        else
        {
          i = Math.min(paramj.oe(), this.aFf - this.aDk);
          paramj.readBytes(this.aFe.data, this.aDk, i);
          this.aDk = (i + this.aDk);
          if (this.aDk == this.aFf)
          {
            if (!this.aFg) {
              break label393;
            }
            if (t.l(this.aFe.data, this.aFf, -1) != 0)
            {
              this.aFh = true;
              return;
            }
            this.aFe.reset(this.aFf - 4);
          }
        }
      }
      for (;;)
      {
        this.aFd.b(this.aFe);
        this.aDk = 0;
        break label41;
        break;
        label393:
        this.aFe.reset(this.aFf);
      }
    }
  }
  
  public final void a(com.google.android.exoplayer2.i.q paramq, f paramf, u.d paramd)
  {
    this.aFd.a(paramq, paramf, paramd);
    this.aFh = true;
  }
  
  public final void lY()
  {
    this.aFh = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.q
 * JD-Core Version:    0.7.0.1
 */