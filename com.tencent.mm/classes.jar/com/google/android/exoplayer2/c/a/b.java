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
  public static final h aXh;
  private static final int aXi;
  private final m aXj;
  private final m aXk;
  private final m aXl;
  private final m aXm;
  private g aXn;
  private int aXo;
  private int aXp;
  public int aXq;
  public int aXr;
  public long aXs;
  private a aXt;
  private e aXu;
  private c aXv;
  
  static
  {
    AppMethodBeat.i(91983);
    aXh = new h()
    {
      public final com.google.android.exoplayer2.c.e[] sK()
      {
        AppMethodBeat.i(91978);
        b localb = new b();
        AppMethodBeat.o(91978);
        return new com.google.android.exoplayer2.c.e[] { localb };
      }
    };
    aXi = x.aY("FLV");
    AppMethodBeat.o(91983);
  }
  
  public b()
  {
    AppMethodBeat.i(91979);
    this.aXj = new m(4);
    this.aXk = new m(9);
    this.aXl = new m(11);
    this.aXm = new m();
    this.aXo = 1;
    AppMethodBeat.o(91979);
  }
  
  private m b(f paramf)
  {
    AppMethodBeat.i(91982);
    if (this.aXr > this.aXm.capacity()) {
      this.aXm.q(new byte[Math.max(this.aXm.capacity() * 2, this.aXr)], 0);
    }
    for (;;)
    {
      this.aXm.fk(this.aXr);
      paramf.readFully(this.aXm.data, 0, this.aXr);
      paramf = this.aXm;
      AppMethodBeat.o(91982);
      return paramf;
      this.aXm.setPosition(0);
    }
  }
  
  public final long K(long paramLong)
  {
    return 0L;
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(91981);
    for (;;)
    {
      switch (this.aXo)
      {
      default: 
        break;
      case 1: 
        if (!paramf.a(this.aXk.data, 0, 9, true))
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
          this.aXk.setPosition(0);
          this.aXk.fl(4);
          int j = this.aXk.readUnsignedByte();
          if ((j & 0x4) != 0)
          {
            i = 1;
            if ((j & 0x1) == 0) {
              break label257;
            }
          }
          for (j = 1;; j = 0)
          {
            if ((i != 0) && (this.aXt == null)) {
              this.aXt = new a(this.aXn.bh(8, 1));
            }
            if ((j != 0) && (this.aXu == null)) {
              this.aXu = new e(this.aXn.bh(9, 2));
            }
            if (this.aXv == null) {
              this.aXv = new c();
            }
            this.aXn.sL();
            this.aXn.a(this);
            this.aXp = (this.aXk.readInt() - 9 + 4);
            this.aXo = 2;
            i = 1;
            break;
            i = 0;
            break label110;
          }
        }
        break;
      case 2: 
        label110:
        paramf.dR(this.aXp);
        label257:
        this.aXp = 0;
        this.aXo = 3;
      }
    }
    if (!paramf.a(this.aXl.data, 0, 11, true)) {}
    for (int i = 0; i == 0; i = 1)
    {
      AppMethodBeat.o(91981);
      return -1;
      this.aXl.setPosition(0);
      this.aXq = this.aXl.readUnsignedByte();
      this.aXr = this.aXl.vL();
      this.aXs = this.aXl.vL();
      this.aXs = ((this.aXl.readUnsignedByte() << 24 | this.aXs) * 1000L);
      this.aXl.fl(3);
      this.aXo = 4;
    }
    if ((this.aXq == 8) && (this.aXt != null))
    {
      this.aXt.b(b(paramf), this.aXs);
      i = 1;
    }
    for (;;)
    {
      this.aXp = 4;
      this.aXo = 2;
      if (i == 0) {
        break;
      }
      AppMethodBeat.o(91981);
      return 0;
      if ((this.aXq == 9) && (this.aXu != null))
      {
        this.aXu.b(b(paramf), this.aXs);
        i = 1;
      }
      else if ((this.aXq == 18) && (this.aXv != null))
      {
        this.aXv.b(b(paramf), this.aXs);
        i = 1;
      }
      else
      {
        paramf.dR(this.aXr);
        i = 0;
      }
    }
  }
  
  public final void a(g paramg)
  {
    this.aXn = paramg;
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(91980);
    paramf.b(this.aXj.data, 0, 3);
    this.aXj.setPosition(0);
    if (this.aXj.vL() != aXi)
    {
      AppMethodBeat.o(91980);
      return false;
    }
    paramf.b(this.aXj.data, 0, 2);
    this.aXj.setPosition(0);
    if ((this.aXj.readUnsignedShort() & 0xFA) != 0)
    {
      AppMethodBeat.o(91980);
      return false;
    }
    paramf.b(this.aXj.data, 0, 4);
    this.aXj.setPosition(0);
    int i = this.aXj.readInt();
    paramf.sI();
    paramf.dS(i);
    paramf.b(this.aXj.data, 0, 4);
    this.aXj.setPosition(0);
    if (this.aXj.readInt() == 0)
    {
      AppMethodBeat.o(91980);
      return true;
    }
    AppMethodBeat.o(91980);
    return false;
  }
  
  public final void f(long paramLong1, long paramLong2)
  {
    this.aXo = 1;
    this.aXp = 0;
  }
  
  public final long getDurationUs()
  {
    return this.aXv.aSz;
  }
  
  public final boolean sH()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.a.b
 * JD-Core Version:    0.7.0.1
 */