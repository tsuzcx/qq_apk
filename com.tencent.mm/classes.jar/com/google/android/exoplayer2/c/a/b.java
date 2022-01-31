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
  public static final h aBP;
  private static final int aBQ;
  private final m aBR;
  private final m aBS;
  private final m aBT;
  private final m aBU;
  private g aBV;
  private int aBW;
  private int aBX;
  public int aBY;
  public int aBZ;
  public long aCa;
  private a aCb;
  private e aCc;
  private c aCd;
  
  static
  {
    AppMethodBeat.i(94868);
    aBP = new b.1();
    aBQ = x.aS("FLV");
    AppMethodBeat.o(94868);
  }
  
  public b()
  {
    AppMethodBeat.i(94864);
    this.aBR = new m(4);
    this.aBS = new m(9);
    this.aBT = new m(11);
    this.aBU = new m();
    this.aBW = 1;
    AppMethodBeat.o(94864);
  }
  
  private m b(f paramf)
  {
    AppMethodBeat.i(94867);
    if (this.aBZ > this.aBU.capacity()) {
      this.aBU.l(new byte[Math.max(this.aBU.capacity() * 2, this.aBZ)], 0);
    }
    for (;;)
    {
      this.aBU.em(this.aBZ);
      paramf.readFully(this.aBU.data, 0, this.aBZ);
      paramf = this.aBU;
      AppMethodBeat.o(94867);
      return paramf;
      this.aBU.setPosition(0);
    }
  }
  
  public final long E(long paramLong)
  {
    return 0L;
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(94866);
    for (;;)
    {
      switch (this.aBW)
      {
      default: 
        break;
      case 1: 
        if (!paramf.a(this.aBS.data, 0, 9, true))
        {
          i = 0;
          if (i == 0)
          {
            AppMethodBeat.o(94866);
            return -1;
          }
        }
        else
        {
          this.aBS.setPosition(0);
          this.aBS.en(4);
          int j = this.aBS.readUnsignedByte();
          if ((j & 0x4) != 0)
          {
            i = 1;
            if ((j & 0x1) == 0) {
              break label255;
            }
          }
          for (j = 1;; j = 0)
          {
            if ((i != 0) && (this.aCb == null)) {
              this.aCb = new a(this.aBV.dm(8));
            }
            if ((j != 0) && (this.aCc == null)) {
              this.aCc = new e(this.aBV.dm(9));
            }
            if (this.aCd == null) {
              this.aCd = new c();
            }
            this.aBV.nZ();
            this.aBV.a(this);
            this.aBX = (this.aBS.readInt() - 9 + 4);
            this.aBW = 2;
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
        paramf.dg(this.aBX);
        this.aBX = 0;
        this.aBW = 3;
      }
    }
    if (!paramf.a(this.aBT.data, 0, 11, true)) {}
    for (int i = 0; i == 0; i = 1)
    {
      AppMethodBeat.o(94866);
      return -1;
      this.aBT.setPosition(0);
      this.aBY = this.aBT.readUnsignedByte();
      this.aBZ = this.aBT.qO();
      this.aCa = this.aBT.qO();
      this.aCa = ((this.aBT.readUnsignedByte() << 24 | this.aCa) * 1000L);
      this.aBT.en(3);
      this.aBW = 4;
    }
    if ((this.aBY == 8) && (this.aCb != null))
    {
      this.aCb.b(b(paramf), this.aCa);
      i = 1;
    }
    for (;;)
    {
      this.aBX = 4;
      this.aBW = 2;
      if (i == 0) {
        break;
      }
      AppMethodBeat.o(94866);
      return 0;
      if ((this.aBY == 9) && (this.aCc != null))
      {
        this.aCc.b(b(paramf), this.aCa);
        i = 1;
      }
      else if ((this.aBY == 18) && (this.aCd != null))
      {
        this.aCd.b(b(paramf), this.aCa);
        i = 1;
      }
      else
      {
        paramf.dg(this.aBZ);
        i = 0;
      }
    }
  }
  
  public final void a(g paramg)
  {
    this.aBV = paramg;
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(94865);
    paramf.b(this.aBR.data, 0, 3);
    this.aBR.setPosition(0);
    if (this.aBR.qO() != aBQ)
    {
      AppMethodBeat.o(94865);
      return false;
    }
    paramf.b(this.aBR.data, 0, 2);
    this.aBR.setPosition(0);
    if ((this.aBR.readUnsignedShort() & 0xFA) != 0)
    {
      AppMethodBeat.o(94865);
      return false;
    }
    paramf.b(this.aBR.data, 0, 4);
    this.aBR.setPosition(0);
    int i = this.aBR.readInt();
    paramf.nW();
    paramf.dh(i);
    paramf.b(this.aBR.data, 0, 4);
    this.aBR.setPosition(0);
    if (this.aBR.readInt() == 0)
    {
      AppMethodBeat.o(94865);
      return true;
    }
    AppMethodBeat.o(94865);
    return false;
  }
  
  public final void g(long paramLong1, long paramLong2)
  {
    this.aBW = 1;
    this.aBX = 0;
  }
  
  public final long getDurationUs()
  {
    return this.aCd.axh;
  }
  
  public final boolean nV()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.c.a.b
 * JD-Core Version:    0.7.0.1
 */