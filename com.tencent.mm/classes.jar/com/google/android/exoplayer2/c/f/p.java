package com.google.android.exoplayer2.c.f;

import android.util.SparseArray;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.c.l.a;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.u;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
  implements e
{
  public static final com.google.android.exoplayer2.c.h aBP;
  private final u aGN;
  private g aIN;
  private final SparseArray<p.a> aLM;
  private final com.google.android.exoplayer2.i.m aLN;
  private boolean aLO;
  private boolean aLP;
  private boolean aLQ;
  
  static
  {
    AppMethodBeat.i(95156);
    aBP = new p.1();
    AppMethodBeat.o(95156);
  }
  
  public p()
  {
    this(new u(0L));
    AppMethodBeat.i(95150);
    AppMethodBeat.o(95150);
  }
  
  private p(u paramu)
  {
    AppMethodBeat.i(95151);
    this.aGN = paramu;
    this.aLN = new com.google.android.exoplayer2.i.m(4096);
    this.aLM = new SparseArray();
    AppMethodBeat.o(95151);
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(95155);
    if (!paramf.b(this.aLN.data, 0, 4, true))
    {
      AppMethodBeat.o(95155);
      return -1;
    }
    this.aLN.setPosition(0);
    int i = this.aLN.readInt();
    if (i == 441)
    {
      AppMethodBeat.o(95155);
      return -1;
    }
    if (i == 442)
    {
      paramf.b(this.aLN.data, 0, 10);
      this.aLN.setPosition(9);
      paramf.dg((this.aLN.readUnsignedByte() & 0x7) + 14);
      AppMethodBeat.o(95155);
      return 0;
    }
    if (i == 443)
    {
      paramf.b(this.aLN.data, 0, 2);
      this.aLN.setPosition(0);
      paramf.dg(this.aLN.readUnsignedShort() + 6);
      AppMethodBeat.o(95155);
      return 0;
    }
    if ((i & 0xFFFFFF00) >> 8 != 1)
    {
      paramf.dg(1);
      AppMethodBeat.o(95155);
      return 0;
    }
    i &= 0xFF;
    p.a locala = (p.a)this.aLM.get(i);
    paramk = locala;
    Object localObject;
    if (!this.aLO)
    {
      localObject = locala;
      if (locala == null)
      {
        localObject = null;
        if ((this.aLP) || (i != 189)) {
          break label422;
        }
        paramk = new b();
        this.aLP = true;
        localObject = locala;
        if (paramk != null)
        {
          localObject = new v.d(i, 256);
          paramk.a(this.aIN, (v.d)localObject);
          localObject = new p.a(paramk, this.aGN);
          this.aLM.put(i, localObject);
        }
      }
      if ((!this.aLP) || (!this.aLQ))
      {
        paramk = (k)localObject;
        if (paramf.getPosition() <= 1048576L) {}
      }
      else
      {
        this.aLO = true;
        this.aIN.nZ();
        paramk = (k)localObject;
      }
    }
    paramf.b(this.aLN.data, 0, 2);
    this.aLN.setPosition(0);
    i = this.aLN.readUnsignedShort() + 6;
    if (paramk == null) {
      paramf.dg(i);
    }
    for (;;)
    {
      AppMethodBeat.o(95155);
      return 0;
      label422:
      if ((!this.aLP) && ((i & 0xE0) == 192))
      {
        paramk = new m();
        this.aLP = true;
        break;
      }
      paramk = (k)localObject;
      if (this.aLQ) {
        break;
      }
      paramk = (k)localObject;
      if ((i & 0xF0) != 224) {
        break;
      }
      paramk = new i();
      this.aLQ = true;
      break;
      this.aLN.reset(i);
      paramf.readFully(this.aLN.data, 0, i);
      this.aLN.setPosition(6);
      paramf = this.aLN;
      paramf.readBytes(paramk.aLF.data, 0, 3);
      paramk.aLF.setPosition(0);
      paramk.aLF.dE(8);
      paramk.aLG = paramk.aLF.oj();
      paramk.aLH = paramk.aLF.oj();
      paramk.aLF.dE(6);
      paramk.aLJ = paramk.aLF.dD(8);
      paramf.readBytes(paramk.aLF.data, 0, paramk.aLJ);
      paramk.aLF.setPosition(0);
      paramk.aAT = 0L;
      if (paramk.aLG)
      {
        paramk.aLF.dE(4);
        long l1 = paramk.aLF.dD(3);
        paramk.aLF.dE(1);
        long l2 = paramk.aLF.dD(15) << 15;
        paramk.aLF.dE(1);
        long l3 = paramk.aLF.dD(15);
        paramk.aLF.dE(1);
        if ((!paramk.aLI) && (paramk.aLH))
        {
          paramk.aLF.dE(4);
          long l4 = paramk.aLF.dD(3);
          paramk.aLF.dE(1);
          long l5 = paramk.aLF.dD(15) << 15;
          paramk.aLF.dE(1);
          long l6 = paramk.aLF.dD(15);
          paramk.aLF.dE(1);
          paramk.aGN.ah(l4 << 30 | l5 | l6);
          paramk.aLI = true;
        }
        paramk.aAT = paramk.aGN.ah(l1 << 30 | l2 | l3);
      }
      paramk.aLR.d(paramk.aAT, true);
      paramk.aLR.t(paramf);
      paramk.aLR.om();
      this.aLN.em(this.aLN.capacity());
    }
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(95153);
    this.aIN = paramg;
    paramg.a(new l.a(-9223372036854775807L));
    AppMethodBeat.o(95153);
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(95152);
    byte[] arrayOfByte = new byte[14];
    paramf.b(arrayOfByte, 0, 14);
    if (442 != ((arrayOfByte[0] & 0xFF) << 24 | (arrayOfByte[1] & 0xFF) << 16 | (arrayOfByte[2] & 0xFF) << 8 | arrayOfByte[3] & 0xFF))
    {
      AppMethodBeat.o(95152);
      return false;
    }
    if ((arrayOfByte[4] & 0xC4) != 68)
    {
      AppMethodBeat.o(95152);
      return false;
    }
    if ((arrayOfByte[6] & 0x4) != 4)
    {
      AppMethodBeat.o(95152);
      return false;
    }
    if ((arrayOfByte[8] & 0x4) != 4)
    {
      AppMethodBeat.o(95152);
      return false;
    }
    if ((arrayOfByte[9] & 0x1) != 1)
    {
      AppMethodBeat.o(95152);
      return false;
    }
    if ((arrayOfByte[12] & 0x3) != 3)
    {
      AppMethodBeat.o(95152);
      return false;
    }
    paramf.dh(arrayOfByte[13] & 0x7);
    paramf.b(arrayOfByte, 0, 3);
    int i = arrayOfByte[0];
    int j = arrayOfByte[1];
    if (1 == (arrayOfByte[2] & 0xFF | (i & 0xFF) << 16 | (j & 0xFF) << 8))
    {
      AppMethodBeat.o(95152);
      return true;
    }
    AppMethodBeat.o(95152);
    return false;
  }
  
  public final void g(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95154);
    this.aGN.bbs = -9223372036854775807L;
    int i = 0;
    while (i < this.aLM.size())
    {
      p.a locala = (p.a)this.aLM.valueAt(i);
      locala.aLI = false;
      locala.aLR.ol();
      i += 1;
    }
    AppMethodBeat.o(95154);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.p
 * JD-Core Version:    0.7.0.1
 */