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
  public static final com.google.android.exoplayer2.c.h aRP;
  private final u aWJ;
  private g aYJ;
  private final SparseArray<a> bbI;
  private final com.google.android.exoplayer2.i.m bbJ;
  private boolean bbK;
  private boolean bbL;
  private boolean bbM;
  
  static
  {
    AppMethodBeat.i(92278);
    aRP = new com.google.android.exoplayer2.c.h()
    {
      public final e[] ss()
      {
        AppMethodBeat.i(92270);
        p localp = new p();
        AppMethodBeat.o(92270);
        return new e[] { localp };
      }
    };
    AppMethodBeat.o(92278);
  }
  
  public p()
  {
    this(new u(0L));
    AppMethodBeat.i(92272);
    AppMethodBeat.o(92272);
  }
  
  private p(u paramu)
  {
    AppMethodBeat.i(92273);
    this.aWJ = paramu;
    this.bbJ = new com.google.android.exoplayer2.i.m(4096);
    this.bbI = new SparseArray();
    AppMethodBeat.o(92273);
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(92277);
    if (!paramf.b(this.bbJ.data, 0, 4, true))
    {
      AppMethodBeat.o(92277);
      return -1;
    }
    this.bbJ.setPosition(0);
    int i = this.bbJ.readInt();
    if (i == 441)
    {
      AppMethodBeat.o(92277);
      return -1;
    }
    if (i == 442)
    {
      paramf.b(this.bbJ.data, 0, 10);
      this.bbJ.setPosition(9);
      paramf.ed((this.bbJ.readUnsignedByte() & 0x7) + 14);
      AppMethodBeat.o(92277);
      return 0;
    }
    if (i == 443)
    {
      paramf.b(this.bbJ.data, 0, 2);
      this.bbJ.setPosition(0);
      paramf.ed(this.bbJ.readUnsignedShort() + 6);
      AppMethodBeat.o(92277);
      return 0;
    }
    if ((i & 0xFFFFFF00) >> 8 != 1)
    {
      paramf.ed(1);
      AppMethodBeat.o(92277);
      return 0;
    }
    i &= 0xFF;
    a locala = (a)this.bbI.get(i);
    paramk = locala;
    Object localObject;
    if (!this.bbK)
    {
      localObject = locala;
      if (locala == null)
      {
        localObject = null;
        if ((this.bbL) || (i != 189)) {
          break label422;
        }
        paramk = new b();
        this.bbL = true;
        localObject = locala;
        if (paramk != null)
        {
          localObject = new v.d(i, 256);
          paramk.a(this.aYJ, (v.d)localObject);
          localObject = new a(paramk, this.aWJ);
          this.bbI.put(i, localObject);
        }
      }
      if ((!this.bbL) || (!this.bbM))
      {
        paramk = (k)localObject;
        if (paramf.getPosition() <= 1048576L) {}
      }
      else
      {
        this.bbK = true;
        this.aYJ.st();
        paramk = (k)localObject;
      }
    }
    paramf.b(this.bbJ.data, 0, 2);
    this.bbJ.setPosition(0);
    i = this.bbJ.readUnsignedShort() + 6;
    if (paramk == null) {
      paramf.ed(i);
    }
    for (;;)
    {
      AppMethodBeat.o(92277);
      return 0;
      label422:
      if ((!this.bbL) && ((i & 0xE0) == 192))
      {
        paramk = new m();
        this.bbL = true;
        break;
      }
      paramk = (k)localObject;
      if (this.bbM) {
        break;
      }
      paramk = (k)localObject;
      if ((i & 0xF0) != 224) {
        break;
      }
      paramk = new i();
      this.bbM = true;
      break;
      this.bbJ.fs(i);
      paramf.readFully(this.bbJ.data, 0, i);
      this.bbJ.setPosition(6);
      paramf = this.bbJ;
      paramf.readBytes(paramk.bbB.data, 0, 3);
      paramk.bbB.setPosition(0);
      paramk.bbB.eB(8);
      paramk.bbC = paramk.bbB.sD();
      paramk.bbD = paramk.bbB.sD();
      paramk.bbB.eB(6);
      paramk.bbF = paramk.bbB.eA(8);
      paramf.readBytes(paramk.bbB.data, 0, paramk.bbF);
      paramk.bbB.setPosition(0);
      paramk.timeUs = 0L;
      if (paramk.bbC)
      {
        paramk.bbB.eB(4);
        long l1 = paramk.bbB.eA(3);
        paramk.bbB.eB(1);
        long l2 = paramk.bbB.eA(15) << 15;
        paramk.bbB.eB(1);
        long l3 = paramk.bbB.eA(15);
        paramk.bbB.eB(1);
        if ((!paramk.bbE) && (paramk.bbD))
        {
          paramk.bbB.eB(4);
          long l4 = paramk.bbB.eA(3);
          paramk.bbB.eB(1);
          long l5 = paramk.bbB.eA(15) << 15;
          paramk.bbB.eB(1);
          long l6 = paramk.bbB.eA(15);
          paramk.bbB.eB(1);
          paramk.aWJ.as(l4 << 30 | l5 | l6);
          paramk.bbE = true;
        }
        paramk.timeUs = paramk.aWJ.as(l1 << 30 | l2 | l3);
      }
      paramk.bbN.c(paramk.timeUs, true);
      paramk.bbN.t(paramf);
      paramk.bbN.sG();
      this.bbJ.ft(this.bbJ.vh());
    }
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(92275);
    this.aYJ = paramg;
    paramg.a(new l.a(-9223372036854775807L));
    AppMethodBeat.o(92275);
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(92274);
    byte[] arrayOfByte = new byte[14];
    paramf.b(arrayOfByte, 0, 14);
    if (442 != ((arrayOfByte[0] & 0xFF) << 24 | (arrayOfByte[1] & 0xFF) << 16 | (arrayOfByte[2] & 0xFF) << 8 | arrayOfByte[3] & 0xFF))
    {
      AppMethodBeat.o(92274);
      return false;
    }
    if ((arrayOfByte[4] & 0xC4) != 68)
    {
      AppMethodBeat.o(92274);
      return false;
    }
    if ((arrayOfByte[6] & 0x4) != 4)
    {
      AppMethodBeat.o(92274);
      return false;
    }
    if ((arrayOfByte[8] & 0x4) != 4)
    {
      AppMethodBeat.o(92274);
      return false;
    }
    if ((arrayOfByte[9] & 0x1) != 1)
    {
      AppMethodBeat.o(92274);
      return false;
    }
    if ((arrayOfByte[12] & 0x3) != 3)
    {
      AppMethodBeat.o(92274);
      return false;
    }
    paramf.ee(arrayOfByte[13] & 0x7);
    paramf.b(arrayOfByte, 0, 3);
    int i = arrayOfByte[0];
    int j = arrayOfByte[1];
    if (1 == (arrayOfByte[2] & 0xFF | (i & 0xFF) << 16 | (j & 0xFF) << 8))
    {
      AppMethodBeat.o(92274);
      return true;
    }
    AppMethodBeat.o(92274);
    return false;
  }
  
  public final void g(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92276);
    this.aWJ.brn = -9223372036854775807L;
    int i = 0;
    while (i < this.bbI.size())
    {
      a locala = (a)this.bbI.valueAt(i);
      locala.bbE = false;
      locala.bbN.sF();
      i += 1;
    }
    AppMethodBeat.o(92276);
  }
  
  static final class a
  {
    final u aWJ;
    final l bbB;
    boolean bbC;
    boolean bbD;
    boolean bbE;
    int bbF;
    final h bbN;
    long timeUs;
    
    public a(h paramh, u paramu)
    {
      AppMethodBeat.i(92271);
      this.bbN = paramh;
      this.aWJ = paramu;
      this.bbB = new l(new byte[64]);
      AppMethodBeat.o(92271);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.p
 * JD-Core Version:    0.7.0.1
 */