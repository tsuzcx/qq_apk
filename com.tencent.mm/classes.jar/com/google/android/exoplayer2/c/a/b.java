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
  public static final h aRP;
  private static final int aRQ;
  private final m aRR;
  private final m aRS;
  private final m aRT;
  private final m aRU;
  private g aRV;
  private int aRW;
  private int aRX;
  public int aRY;
  public int aRZ;
  public long aSa;
  private a aSb;
  private e aSc;
  private c aSd;
  
  static
  {
    AppMethodBeat.i(91983);
    aRP = new h()
    {
      public final com.google.android.exoplayer2.c.e[] ss()
      {
        AppMethodBeat.i(91978);
        b localb = new b();
        AppMethodBeat.o(91978);
        return new com.google.android.exoplayer2.c.e[] { localb };
      }
    };
    aRQ = x.bU("FLV");
    AppMethodBeat.o(91983);
  }
  
  public b()
  {
    AppMethodBeat.i(91979);
    this.aRR = new m(4);
    this.aRS = new m(9);
    this.aRT = new m(11);
    this.aRU = new m();
    this.aRW = 1;
    AppMethodBeat.o(91979);
  }
  
  private m b(f paramf)
  {
    AppMethodBeat.i(91982);
    if (this.aRZ > this.aRU.vh()) {
      this.aRU.n(new byte[Math.max(this.aRU.vh() * 2, this.aRZ)], 0);
    }
    for (;;)
    {
      this.aRU.ft(this.aRZ);
      paramf.readFully(this.aRU.data, 0, this.aRZ);
      paramf = this.aRU;
      AppMethodBeat.o(91982);
      return paramf;
      this.aRU.setPosition(0);
    }
  }
  
  public final long O(long paramLong)
  {
    return 0L;
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(91981);
    for (;;)
    {
      switch (this.aRW)
      {
      default: 
        break;
      case 1: 
        if (!paramf.a(this.aRS.data, 0, 9, true))
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
          this.aRS.setPosition(0);
          this.aRS.fu(4);
          int j = this.aRS.readUnsignedByte();
          if ((j & 0x4) != 0)
          {
            i = 1;
            if ((j & 0x1) == 0) {
              break label255;
            }
          }
          for (j = 1;; j = 0)
          {
            if ((i != 0) && (this.aSb == null)) {
              this.aSb = new a(this.aRV.ej(8));
            }
            if ((j != 0) && (this.aSc == null)) {
              this.aSc = new e(this.aRV.ej(9));
            }
            if (this.aSd == null) {
              this.aSd = new c();
            }
            this.aRV.st();
            this.aRV.a(this);
            this.aRX = (this.aRS.readInt() - 9 + 4);
            this.aRW = 2;
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
        paramf.ed(this.aRX);
        this.aRX = 0;
        this.aRW = 3;
      }
    }
    if (!paramf.a(this.aRT.data, 0, 11, true)) {}
    for (int i = 0; i == 0; i = 1)
    {
      AppMethodBeat.o(91981);
      return -1;
      this.aRT.setPosition(0);
      this.aRY = this.aRT.readUnsignedByte();
      this.aRZ = this.aRT.vj();
      this.aSa = this.aRT.vj();
      this.aSa = ((this.aRT.readUnsignedByte() << 24 | this.aSa) * 1000L);
      this.aRT.fu(3);
      this.aRW = 4;
    }
    if ((this.aRY == 8) && (this.aSb != null))
    {
      this.aSb.b(b(paramf), this.aSa);
      i = 1;
    }
    for (;;)
    {
      this.aRX = 4;
      this.aRW = 2;
      if (i == 0) {
        break;
      }
      AppMethodBeat.o(91981);
      return 0;
      if ((this.aRY == 9) && (this.aSc != null))
      {
        this.aSc.b(b(paramf), this.aSa);
        i = 1;
      }
      else if ((this.aRY == 18) && (this.aSd != null))
      {
        this.aSd.b(b(paramf), this.aSa);
        i = 1;
      }
      else
      {
        paramf.ed(this.aRZ);
        i = 0;
      }
    }
  }
  
  public final void a(g paramg)
  {
    this.aRV = paramg;
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(91980);
    paramf.b(this.aRR.data, 0, 3);
    this.aRR.setPosition(0);
    if (this.aRR.vj() != aRQ)
    {
      AppMethodBeat.o(91980);
      return false;
    }
    paramf.b(this.aRR.data, 0, 2);
    this.aRR.setPosition(0);
    if ((this.aRR.readUnsignedShort() & 0xFA) != 0)
    {
      AppMethodBeat.o(91980);
      return false;
    }
    paramf.b(this.aRR.data, 0, 4);
    this.aRR.setPosition(0);
    int i = this.aRR.readInt();
    paramf.sp();
    paramf.ee(i);
    paramf.b(this.aRR.data, 0, 4);
    this.aRR.setPosition(0);
    if (this.aRR.readInt() == 0)
    {
      AppMethodBeat.o(91980);
      return true;
    }
    AppMethodBeat.o(91980);
    return false;
  }
  
  public final void g(long paramLong1, long paramLong2)
  {
    this.aRW = 1;
    this.aRX = 0;
  }
  
  public final long getDurationUs()
  {
    return this.aSd.aNk;
  }
  
  public final boolean so()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.a.b
 * JD-Core Version:    0.7.0.1
 */