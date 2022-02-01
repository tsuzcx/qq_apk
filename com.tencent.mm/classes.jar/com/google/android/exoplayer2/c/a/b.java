package com.google.android.exoplayer2.c.a;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  implements com.google.android.exoplayer2.c.e, l
{
  public static final h bio;
  private static final int bip;
  private a biA;
  private e biB;
  private c biC;
  private final m biq;
  private final m bir;
  private final m bis;
  private final m bit;
  private g biu;
  private int biv;
  private int biw;
  public int bix;
  public int biy;
  public long biz;
  
  static
  {
    AppMethodBeat.i(91983);
    bio = new h()
    {
      public final com.google.android.exoplayer2.c.e[] us()
      {
        AppMethodBeat.i(91978);
        b localb = new b();
        AppMethodBeat.o(91978);
        return new com.google.android.exoplayer2.c.e[] { localb };
      }
    };
    bip = x.bJ("FLV");
    AppMethodBeat.o(91983);
  }
  
  public b()
  {
    AppMethodBeat.i(91979);
    this.biq = new m(4);
    this.bir = new m(9);
    this.bis = new m(11);
    this.bit = new m();
    this.biv = 1;
    AppMethodBeat.o(91979);
  }
  
  private m b(f paramf)
  {
    AppMethodBeat.i(91982);
    if (this.biy > this.bit.capacity()) {
      this.bit.n(new byte[Math.max(this.bit.capacity() * 2, this.biy)], 0);
    }
    for (;;)
    {
      this.bit.eZ(this.biy);
      paramf.readFully(this.bit.data, 0, this.biy);
      paramf = this.bit;
      AppMethodBeat.o(91982);
      return paramf;
      this.bit.setPosition(0);
    }
  }
  
  public final long L(long paramLong)
  {
    return 0L;
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(91981);
    for (;;)
    {
      switch (this.biv)
      {
      default: 
        break;
      case 1: 
        if (!paramf.a(this.bir.data, 0, 9, true))
        {
          i = 0;
          if (i == 0)
          {
            AppMethodBeat.o(91981);
            return -1;
          }
        }
        else
        {
          this.bir.setPosition(0);
          this.bir.fa(4);
          int j = this.bir.readUnsignedByte();
          if ((j & 0x4) != 0)
          {
            i = 1;
            if ((j & 0x1) == 0) {
              break label255;
            }
          }
          for (j = 1;; j = 0)
          {
            if ((i != 0) && (this.biA == null)) {
              this.biA = new a(this.biu.eb(8));
            }
            if ((j != 0) && (this.biB == null)) {
              this.biB = new e(this.biu.eb(9));
            }
            if (this.biC == null) {
              this.biC = new c();
            }
            this.biu.ut();
            this.biu.a(this);
            this.biw = (this.bir.readInt() - 9 + 4);
            this.biv = 2;
            i = 1;
            break;
            i = 0;
            break label110;
          }
        }
        break;
      case 2: 
        label110:
        label255:
        paramf.dU(this.biw);
        this.biw = 0;
        this.biv = 3;
      }
    }
    if (!paramf.a(this.bis.data, 0, 11, true)) {}
    for (int i = 0; i == 0; i = 1)
    {
      AppMethodBeat.o(91981);
      return -1;
      this.bis.setPosition(0);
      this.bix = this.bis.readUnsignedByte();
      this.biy = this.bis.wX();
      this.biz = this.bis.wX();
      this.biz = ((this.bis.readUnsignedByte() << 24 | this.biz) * 1000L);
      this.bis.fa(3);
      this.biv = 4;
    }
    if ((this.bix == 8) && (this.biA != null))
    {
      this.biA.b(b(paramf), this.biz);
      i = 1;
    }
    for (;;)
    {
      this.biw = 4;
      this.biv = 2;
      if (i == 0) {
        break;
      }
      AppMethodBeat.o(91981);
      return 0;
      if ((this.bix == 9) && (this.biB != null))
      {
        this.biB.b(b(paramf), this.biz);
        i = 1;
      }
      else if ((this.bix == 18) && (this.biC != null))
      {
        this.biC.b(b(paramf), this.biz);
        i = 1;
      }
      else
      {
        paramf.dU(this.biy);
        i = 0;
      }
    }
  }
  
  public final void a(g paramg)
  {
    this.biu = paramg;
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(91980);
    paramf.b(this.biq.data, 0, 3);
    this.biq.setPosition(0);
    if (this.biq.wX() != bip)
    {
      AppMethodBeat.o(91980);
      return false;
    }
    paramf.b(this.biq.data, 0, 2);
    this.biq.setPosition(0);
    if ((this.biq.readUnsignedShort() & 0xFA) != 0)
    {
      AppMethodBeat.o(91980);
      return false;
    }
    paramf.b(this.biq.data, 0, 4);
    this.biq.setPosition(0);
    int i = this.biq.readInt();
    paramf.uq();
    paramf.dV(i);
    paramf.b(this.biq.data, 0, 4);
    this.biq.setPosition(0);
    if (this.biq.readInt() == 0)
    {
      AppMethodBeat.o(91980);
      return true;
    }
    AppMethodBeat.o(91980);
    return false;
  }
  
  public final void f(long paramLong1, long paramLong2)
  {
    this.biv = 1;
    this.biw = 0;
  }
  
  public final long getDurationUs()
  {
    return this.biC.bdM;
  }
  
  public final boolean up()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.a.b
 * JD-Core Version:    0.7.0.1
 */