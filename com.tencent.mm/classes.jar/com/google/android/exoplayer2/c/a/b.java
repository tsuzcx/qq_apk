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
  public static final h cLL;
  private static final int cLM;
  private final m cLN;
  private final m cLO;
  private final m cLP;
  private final m cLQ;
  private g cLR;
  private int cLS;
  private int cLT;
  public int cLU;
  public int cLV;
  public long cLW;
  private a cLX;
  private e cLY;
  private c cLZ;
  
  static
  {
    AppMethodBeat.i(91983);
    cLL = new h()
    {
      public final com.google.android.exoplayer2.c.e[] RV()
      {
        AppMethodBeat.i(91978);
        b localb = new b();
        AppMethodBeat.o(91978);
        return new com.google.android.exoplayer2.c.e[] { localb };
      }
    };
    cLM = x.du("FLV");
    AppMethodBeat.o(91983);
  }
  
  public b()
  {
    AppMethodBeat.i(91979);
    this.cLN = new m(4);
    this.cLO = new m(9);
    this.cLP = new m(11);
    this.cLQ = new m();
    this.cLS = 1;
    AppMethodBeat.o(91979);
  }
  
  private m b(f paramf)
  {
    AppMethodBeat.i(91982);
    if (this.cLV > this.cLQ.UG()) {
      this.cLQ.n(new byte[Math.max(this.cLQ.UG() * 2, this.cLV)], 0);
    }
    for (;;)
    {
      this.cLQ.iG(this.cLV);
      paramf.readFully(this.cLQ.data, 0, this.cLV);
      paramf = this.cLQ;
      AppMethodBeat.o(91982);
      return paramf;
      this.cLQ.setPosition(0);
    }
  }
  
  public final void C(long paramLong1, long paramLong2)
  {
    this.cLS = 1;
    this.cLT = 0;
  }
  
  public final boolean RR()
  {
    return false;
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(91981);
    for (;;)
    {
      switch (this.cLS)
      {
      default: 
        break;
      case 1: 
        if (!paramf.a(this.cLO.data, 0, 9, true))
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
          this.cLO.setPosition(0);
          this.cLO.iH(4);
          int j = this.cLO.readUnsignedByte();
          if ((j & 0x4) != 0)
          {
            i = 1;
            if ((j & 0x1) == 0) {
              break label255;
            }
          }
          for (j = 1;; j = 0)
          {
            if ((i != 0) && (this.cLX == null)) {
              this.cLX = new a(this.cLR.hz(8));
            }
            if ((j != 0) && (this.cLY == null)) {
              this.cLY = new e(this.cLR.hz(9));
            }
            if (this.cLZ == null) {
              this.cLZ = new c();
            }
            this.cLR.RW();
            this.cLR.a(this);
            this.cLT = (this.cLO.readInt() - 9 + 4);
            this.cLS = 2;
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
        paramf.eP(this.cLT);
        this.cLT = 0;
        this.cLS = 3;
      }
    }
    if (!paramf.a(this.cLP.data, 0, 11, true)) {}
    for (int i = 0; i == 0; i = 1)
    {
      AppMethodBeat.o(91981);
      return -1;
      this.cLP.setPosition(0);
      this.cLU = this.cLP.readUnsignedByte();
      this.cLV = this.cLP.UI();
      this.cLW = this.cLP.UI();
      this.cLW = ((this.cLP.readUnsignedByte() << 24 | this.cLW) * 1000L);
      this.cLP.iH(3);
      this.cLS = 4;
    }
    if ((this.cLU == 8) && (this.cLX != null))
    {
      this.cLX.b(b(paramf), this.cLW);
      i = 1;
    }
    for (;;)
    {
      this.cLT = 4;
      this.cLS = 2;
      if (i == 0) {
        break;
      }
      AppMethodBeat.o(91981);
      return 0;
      if ((this.cLU == 9) && (this.cLY != null))
      {
        this.cLY.b(b(paramf), this.cLW);
        i = 1;
      }
      else if ((this.cLU == 18) && (this.cLZ != null))
      {
        this.cLZ.b(b(paramf), this.cLW);
        i = 1;
      }
      else
      {
        paramf.eP(this.cLV);
        i = 0;
      }
    }
  }
  
  public final void a(g paramg)
  {
    this.cLR = paramg;
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(91980);
    paramf.b(this.cLN.data, 0, 3);
    this.cLN.setPosition(0);
    if (this.cLN.UI() != cLM)
    {
      AppMethodBeat.o(91980);
      return false;
    }
    paramf.b(this.cLN.data, 0, 2);
    this.cLN.setPosition(0);
    if ((this.cLN.readUnsignedShort() & 0xFA) != 0)
    {
      AppMethodBeat.o(91980);
      return false;
    }
    paramf.b(this.cLN.data, 0, 4);
    this.cLN.setPosition(0);
    int i = this.cLN.readInt();
    paramf.RS();
    paramf.hu(i);
    paramf.b(this.cLN.data, 0, 4);
    this.cLN.setPosition(0);
    if (this.cLN.readInt() == 0)
    {
      AppMethodBeat.o(91980);
      return true;
    }
    AppMethodBeat.o(91980);
    return false;
  }
  
  public final long cc(long paramLong)
  {
    return 0L;
  }
  
  public final long getDurationUs()
  {
    return this.cLZ.cHg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.a.b
 * JD-Core Version:    0.7.0.1
 */