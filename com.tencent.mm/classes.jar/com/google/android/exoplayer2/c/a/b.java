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
  public static final h aXT;
  private static final int aXU;
  private final m aXV;
  private final m aXW;
  private final m aXX;
  private final m aXY;
  private g aXZ;
  private int aYa;
  private int aYb;
  public int aYc;
  public int aYd;
  public long aYe;
  private a aYf;
  private e aYg;
  private c aYh;
  
  static
  {
    AppMethodBeat.i(91983);
    aXT = new h()
    {
      public final com.google.android.exoplayer2.c.e[] sT()
      {
        AppMethodBeat.i(91978);
        b localb = new b();
        AppMethodBeat.o(91978);
        return new com.google.android.exoplayer2.c.e[] { localb };
      }
    };
    aXU = x.aQ("FLV");
    AppMethodBeat.o(91983);
  }
  
  public b()
  {
    AppMethodBeat.i(91979);
    this.aXV = new m(4);
    this.aXW = new m(9);
    this.aXX = new m(11);
    this.aXY = new m();
    this.aYa = 1;
    AppMethodBeat.o(91979);
  }
  
  private m b(f paramf)
  {
    AppMethodBeat.i(91982);
    if (this.aYd > this.aXY.capacity()) {
      this.aXY.n(new byte[Math.max(this.aXY.capacity() * 2, this.aYd)], 0);
    }
    for (;;)
    {
      this.aXY.eW(this.aYd);
      paramf.readFully(this.aXY.data, 0, this.aYd);
      paramf = this.aXY;
      AppMethodBeat.o(91982);
      return paramf;
      this.aXY.setPosition(0);
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
      switch (this.aYa)
      {
      default: 
        break;
      case 1: 
        if (!paramf.a(this.aXW.data, 0, 9, true))
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
          this.aXW.setPosition(0);
          this.aXW.eX(4);
          int j = this.aXW.readUnsignedByte();
          if ((j & 0x4) != 0)
          {
            i = 1;
            if ((j & 0x1) == 0) {
              break label255;
            }
          }
          for (j = 1;; j = 0)
          {
            if ((i != 0) && (this.aYf == null)) {
              this.aYf = new a(this.aXZ.dW(8));
            }
            if ((j != 0) && (this.aYg == null)) {
              this.aYg = new e(this.aXZ.dW(9));
            }
            if (this.aYh == null) {
              this.aYh = new c();
            }
            this.aXZ.sU();
            this.aXZ.a(this);
            this.aYb = (this.aXW.readInt() - 9 + 4);
            this.aYa = 2;
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
        paramf.dQ(this.aYb);
        this.aYb = 0;
        this.aYa = 3;
      }
    }
    if (!paramf.a(this.aXX.data, 0, 11, true)) {}
    for (int i = 0; i == 0; i = 1)
    {
      AppMethodBeat.o(91981);
      return -1;
      this.aXX.setPosition(0);
      this.aYc = this.aXX.readUnsignedByte();
      this.aYd = this.aXX.vA();
      this.aYe = this.aXX.vA();
      this.aYe = ((this.aXX.readUnsignedByte() << 24 | this.aYe) * 1000L);
      this.aXX.eX(3);
      this.aYa = 4;
    }
    if ((this.aYc == 8) && (this.aYf != null))
    {
      this.aYf.b(b(paramf), this.aYe);
      i = 1;
    }
    for (;;)
    {
      this.aYb = 4;
      this.aYa = 2;
      if (i == 0) {
        break;
      }
      AppMethodBeat.o(91981);
      return 0;
      if ((this.aYc == 9) && (this.aYg != null))
      {
        this.aYg.b(b(paramf), this.aYe);
        i = 1;
      }
      else if ((this.aYc == 18) && (this.aYh != null))
      {
        this.aYh.b(b(paramf), this.aYe);
        i = 1;
      }
      else
      {
        paramf.dQ(this.aYd);
        i = 0;
      }
    }
  }
  
  public final void a(g paramg)
  {
    this.aXZ = paramg;
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(91980);
    paramf.b(this.aXV.data, 0, 3);
    this.aXV.setPosition(0);
    if (this.aXV.vA() != aXU)
    {
      AppMethodBeat.o(91980);
      return false;
    }
    paramf.b(this.aXV.data, 0, 2);
    this.aXV.setPosition(0);
    if ((this.aXV.readUnsignedShort() & 0xFA) != 0)
    {
      AppMethodBeat.o(91980);
      return false;
    }
    paramf.b(this.aXV.data, 0, 4);
    this.aXV.setPosition(0);
    int i = this.aXV.readInt();
    paramf.sR();
    paramf.dR(i);
    paramf.b(this.aXV.data, 0, 4);
    this.aXV.setPosition(0);
    if (this.aXV.readInt() == 0)
    {
      AppMethodBeat.o(91980);
      return true;
    }
    AppMethodBeat.o(91980);
    return false;
  }
  
  public final void f(long paramLong1, long paramLong2)
  {
    this.aYa = 1;
    this.aYb = 0;
  }
  
  public final long getDurationUs()
  {
    return this.aYh.aTs;
  }
  
  public final boolean sQ()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.a.b
 * JD-Core Version:    0.7.0.1
 */