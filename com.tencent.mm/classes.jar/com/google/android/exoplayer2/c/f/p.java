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
  public static final com.google.android.exoplayer2.c.h cLL;
  private final u cQF;
  private g cSE;
  private final SparseArray<a> cVD;
  private final com.google.android.exoplayer2.i.m cVE;
  private boolean cVF;
  private boolean cVG;
  private boolean cVH;
  
  static
  {
    AppMethodBeat.i(92278);
    cLL = new com.google.android.exoplayer2.c.h()
    {
      public final e[] RV()
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
    this.cQF = paramu;
    this.cVE = new com.google.android.exoplayer2.i.m(4096);
    this.cVD = new SparseArray();
    AppMethodBeat.o(92273);
  }
  
  public final void C(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92276);
    this.cQF.dkR = -9223372036854775807L;
    int i = 0;
    while (i < this.cVD.size())
    {
      a locala = (a)this.cVD.valueAt(i);
      locala.cVz = false;
      locala.cVI.Si();
      i += 1;
    }
    AppMethodBeat.o(92276);
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(92277);
    if (!paramf.b(this.cVE.data, 0, 4, true))
    {
      AppMethodBeat.o(92277);
      return -1;
    }
    this.cVE.setPosition(0);
    int i = this.cVE.readInt();
    if (i == 441)
    {
      AppMethodBeat.o(92277);
      return -1;
    }
    if (i == 442)
    {
      paramf.b(this.cVE.data, 0, 10);
      this.cVE.setPosition(9);
      paramf.eP((this.cVE.readUnsignedByte() & 0x7) + 14);
      AppMethodBeat.o(92277);
      return 0;
    }
    if (i == 443)
    {
      paramf.b(this.cVE.data, 0, 2);
      this.cVE.setPosition(0);
      paramf.eP(this.cVE.readUnsignedShort() + 6);
      AppMethodBeat.o(92277);
      return 0;
    }
    if ((i & 0xFFFFFF00) >> 8 != 1)
    {
      paramf.eP(1);
      AppMethodBeat.o(92277);
      return 0;
    }
    i &= 0xFF;
    a locala = (a)this.cVD.get(i);
    paramk = locala;
    Object localObject;
    if (!this.cVF)
    {
      localObject = locala;
      if (locala == null)
      {
        localObject = null;
        if ((this.cVG) || (i != 189)) {
          break label422;
        }
        paramk = new b();
        this.cVG = true;
        localObject = locala;
        if (paramk != null)
        {
          localObject = new v.d(i, 256);
          paramk.a(this.cSE, (v.d)localObject);
          localObject = new a(paramk, this.cQF);
          this.cVD.put(i, localObject);
        }
      }
      if ((!this.cVG) || (!this.cVH))
      {
        paramk = (k)localObject;
        if (paramf.getPosition() <= 1048576L) {}
      }
      else
      {
        this.cVF = true;
        this.cSE.RW();
        paramk = (k)localObject;
      }
    }
    paramf.b(this.cVE.data, 0, 2);
    this.cVE.setPosition(0);
    i = this.cVE.readUnsignedShort() + 6;
    if (paramk == null) {
      paramf.eP(i);
    }
    for (;;)
    {
      AppMethodBeat.o(92277);
      return 0;
      label422:
      if ((!this.cVG) && ((i & 0xE0) == 192))
      {
        paramk = new m();
        this.cVG = true;
        break;
      }
      paramk = (k)localObject;
      if (this.cVH) {
        break;
      }
      paramk = (k)localObject;
      if ((i & 0xF0) != 224) {
        break;
      }
      paramk = new i();
      this.cVH = true;
      break;
      this.cVE.iF(i);
      paramf.readFully(this.cVE.data, 0, i);
      this.cVE.setPosition(6);
      paramf = this.cVE;
      paramf.readBytes(paramk.cVw.data, 0, 3);
      paramk.cVw.setPosition(0);
      paramk.cVw.hR(8);
      paramk.cVx = paramk.cVw.Sg();
      paramk.cVy = paramk.cVw.Sg();
      paramk.cVw.hR(6);
      paramk.cVA = paramk.cVw.hQ(8);
      paramf.readBytes(paramk.cVw.data, 0, paramk.cVA);
      paramk.cVw.setPosition(0);
      paramk.timeUs = 0L;
      if (paramk.cVx)
      {
        paramk.cVw.hR(4);
        long l1 = paramk.cVw.hQ(3);
        paramk.cVw.hR(1);
        long l2 = paramk.cVw.hQ(15) << 15;
        paramk.cVw.hR(1);
        long l3 = paramk.cVw.hQ(15);
        paramk.cVw.hR(1);
        if ((!paramk.cVz) && (paramk.cVy))
        {
          paramk.cVw.hR(4);
          long l4 = paramk.cVw.hQ(3);
          paramk.cVw.hR(1);
          long l5 = paramk.cVw.hQ(15) << 15;
          paramk.cVw.hR(1);
          long l6 = paramk.cVw.hQ(15);
          paramk.cVw.hR(1);
          paramk.cQF.cG(l4 << 30 | l5 | l6);
          paramk.cVz = true;
        }
        paramk.timeUs = paramk.cQF.cG(l1 << 30 | l2 | l3);
      }
      paramk.cVI.h(paramk.timeUs, true);
      paramk.cVI.t(paramf);
      paramk.cVI.Sj();
      this.cVE.iG(this.cVE.UG());
    }
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(92275);
    this.cSE = paramg;
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
    paramf.hu(arrayOfByte[13] & 0x7);
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
  
  static final class a
  {
    final u cQF;
    int cVA;
    final h cVI;
    final l cVw;
    boolean cVx;
    boolean cVy;
    boolean cVz;
    long timeUs;
    
    public a(h paramh, u paramu)
    {
      AppMethodBeat.i(92271);
      this.cVI = paramh;
      this.cQF = paramu;
      this.cVw = new l(new byte[64]);
      AppMethodBeat.o(92271);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.p
 * JD-Core Version:    0.7.0.1
 */