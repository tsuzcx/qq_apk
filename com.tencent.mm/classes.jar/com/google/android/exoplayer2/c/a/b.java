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
  public static final h bil;
  private static final int bim;
  private final m bin;
  private final m bio;
  private final m bip;
  private final m biq;
  private g bir;
  private int bis;
  private int bit;
  public int biu;
  public int biv;
  public long biw;
  private a bix;
  private e biy;
  private c biz;
  
  static
  {
    AppMethodBeat.i(91983);
    bil = new h()
    {
      public final com.google.android.exoplayer2.c.e[] ux()
      {
        AppMethodBeat.i(91978);
        b localb = new b();
        AppMethodBeat.o(91978);
        return new com.google.android.exoplayer2.c.e[] { localb };
      }
    };
    bim = x.bJ("FLV");
    AppMethodBeat.o(91983);
  }
  
  public b()
  {
    AppMethodBeat.i(91979);
    this.bin = new m(4);
    this.bio = new m(9);
    this.bip = new m(11);
    this.biq = new m();
    this.bis = 1;
    AppMethodBeat.o(91979);
  }
  
  private m b(f paramf)
  {
    AppMethodBeat.i(91982);
    if (this.biv > this.biq.capacity()) {
      this.biq.n(new byte[Math.max(this.biq.capacity() * 2, this.biv)], 0);
    }
    for (;;)
    {
      this.biq.eY(this.biv);
      paramf.readFully(this.biq.data, 0, this.biv);
      paramf = this.biq;
      AppMethodBeat.o(91982);
      return paramf;
      this.biq.setPosition(0);
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
      switch (this.bis)
      {
      default: 
        break;
      case 1: 
        if (!paramf.a(this.bio.data, 0, 9, true))
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
          this.bio.setPosition(0);
          this.bio.eZ(4);
          int j = this.bio.readUnsignedByte();
          if ((j & 0x4) != 0)
          {
            i = 1;
            if ((j & 0x1) == 0) {
              break label255;
            }
          }
          for (j = 1;; j = 0)
          {
            if ((i != 0) && (this.bix == null)) {
              this.bix = new a(this.bir.dV(8));
            }
            if ((j != 0) && (this.biy == null)) {
              this.biy = new e(this.bir.dV(9));
            }
            if (this.biz == null) {
              this.biz = new c();
            }
            this.bir.uy();
            this.bir.a(this);
            this.bit = (this.bio.readInt() - 9 + 4);
            this.bis = 2;
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
        paramf.dP(this.bit);
        this.bit = 0;
        this.bis = 3;
      }
    }
    if (!paramf.a(this.bip.data, 0, 11, true)) {}
    for (int i = 0; i == 0; i = 1)
    {
      AppMethodBeat.o(91981);
      return -1;
      this.bip.setPosition(0);
      this.biu = this.bip.readUnsignedByte();
      this.biv = this.bip.xf();
      this.biw = this.bip.xf();
      this.biw = ((this.bip.readUnsignedByte() << 24 | this.biw) * 1000L);
      this.bip.eZ(3);
      this.bis = 4;
    }
    if ((this.biu == 8) && (this.bix != null))
    {
      this.bix.b(b(paramf), this.biw);
      i = 1;
    }
    for (;;)
    {
      this.bit = 4;
      this.bis = 2;
      if (i == 0) {
        break;
      }
      AppMethodBeat.o(91981);
      return 0;
      if ((this.biu == 9) && (this.biy != null))
      {
        this.biy.b(b(paramf), this.biw);
        i = 1;
      }
      else if ((this.biu == 18) && (this.biz != null))
      {
        this.biz.b(b(paramf), this.biw);
        i = 1;
      }
      else
      {
        paramf.dP(this.biv);
        i = 0;
      }
    }
  }
  
  public final void a(g paramg)
  {
    this.bir = paramg;
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(91980);
    paramf.b(this.bin.data, 0, 3);
    this.bin.setPosition(0);
    if (this.bin.xf() != bim)
    {
      AppMethodBeat.o(91980);
      return false;
    }
    paramf.b(this.bin.data, 0, 2);
    this.bin.setPosition(0);
    if ((this.bin.readUnsignedShort() & 0xFA) != 0)
    {
      AppMethodBeat.o(91980);
      return false;
    }
    paramf.b(this.bin.data, 0, 4);
    this.bin.setPosition(0);
    int i = this.bin.readInt();
    paramf.uv();
    paramf.dQ(i);
    paramf.b(this.bin.data, 0, 4);
    this.bin.setPosition(0);
    if (this.bin.readInt() == 0)
    {
      AppMethodBeat.o(91980);
      return true;
    }
    AppMethodBeat.o(91980);
    return false;
  }
  
  public final void f(long paramLong1, long paramLong2)
  {
    this.bis = 1;
    this.bit = 0;
  }
  
  public final long getDurationUs()
  {
    return this.biz.bdJ;
  }
  
  public final boolean uu()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.a.b
 * JD-Core Version:    0.7.0.1
 */