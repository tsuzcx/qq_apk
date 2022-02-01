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
  public static final com.google.android.exoplayer2.c.h bio;
  private final u bnm;
  private g bpm;
  private final SparseArray<a> bsl;
  private final com.google.android.exoplayer2.i.m bsm;
  private boolean bsn;
  private boolean bso;
  private boolean bsp;
  
  static
  {
    AppMethodBeat.i(92278);
    bio = new com.google.android.exoplayer2.c.h()
    {
      public final e[] us()
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
    this.bnm = paramu;
    this.bsm = new com.google.android.exoplayer2.i.m(4096);
    this.bsl = new SparseArray();
    AppMethodBeat.o(92273);
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(92277);
    if (!paramf.b(this.bsm.data, 0, 4, true))
    {
      AppMethodBeat.o(92277);
      return -1;
    }
    this.bsm.setPosition(0);
    int i = this.bsm.readInt();
    if (i == 441)
    {
      AppMethodBeat.o(92277);
      return -1;
    }
    if (i == 442)
    {
      paramf.b(this.bsm.data, 0, 10);
      this.bsm.setPosition(9);
      paramf.dU((this.bsm.readUnsignedByte() & 0x7) + 14);
      AppMethodBeat.o(92277);
      return 0;
    }
    if (i == 443)
    {
      paramf.b(this.bsm.data, 0, 2);
      this.bsm.setPosition(0);
      paramf.dU(this.bsm.readUnsignedShort() + 6);
      AppMethodBeat.o(92277);
      return 0;
    }
    if ((i & 0xFFFFFF00) >> 8 != 1)
    {
      paramf.dU(1);
      AppMethodBeat.o(92277);
      return 0;
    }
    i &= 0xFF;
    a locala = (a)this.bsl.get(i);
    paramk = locala;
    Object localObject;
    if (!this.bsn)
    {
      localObject = locala;
      if (locala == null)
      {
        localObject = null;
        if ((this.bso) || (i != 189)) {
          break label422;
        }
        paramk = new b();
        this.bso = true;
        localObject = locala;
        if (paramk != null)
        {
          localObject = new v.d(i, 256);
          paramk.a(this.bpm, (v.d)localObject);
          localObject = new a(paramk, this.bnm);
          this.bsl.put(i, localObject);
        }
      }
      if ((!this.bso) || (!this.bsp))
      {
        paramk = (k)localObject;
        if (paramf.getPosition() <= 1048576L) {}
      }
      else
      {
        this.bsn = true;
        this.bpm.ut();
        paramk = (k)localObject;
      }
    }
    paramf.b(this.bsm.data, 0, 2);
    this.bsm.setPosition(0);
    i = this.bsm.readUnsignedShort() + 6;
    if (paramk == null) {
      paramf.dU(i);
    }
    for (;;)
    {
      AppMethodBeat.o(92277);
      return 0;
      label422:
      if ((!this.bso) && ((i & 0xE0) == 192))
      {
        paramk = new m();
        this.bso = true;
        break;
      }
      paramk = (k)localObject;
      if (this.bsp) {
        break;
      }
      paramk = (k)localObject;
      if ((i & 0xF0) != 224) {
        break;
      }
      paramk = new i();
      this.bsp = true;
      break;
      this.bsm.reset(i);
      paramf.readFully(this.bsm.data, 0, i);
      this.bsm.setPosition(6);
      paramf = this.bsm;
      paramf.readBytes(paramk.bse.data, 0, 3);
      paramk.bse.setPosition(0);
      paramk.bse.et(8);
      paramk.bsf = paramk.bse.uD();
      paramk.bsg = paramk.bse.uD();
      paramk.bse.et(6);
      paramk.bsi = paramk.bse.es(8);
      paramf.readBytes(paramk.bse.data, 0, paramk.bsi);
      paramk.bse.setPosition(0);
      paramk.timeUs = 0L;
      if (paramk.bsf)
      {
        paramk.bse.et(4);
        long l1 = paramk.bse.es(3);
        paramk.bse.et(1);
        long l2 = paramk.bse.es(15) << 15;
        paramk.bse.et(1);
        long l3 = paramk.bse.es(15);
        paramk.bse.et(1);
        if ((!paramk.bsh) && (paramk.bsg))
        {
          paramk.bse.et(4);
          long l4 = paramk.bse.es(3);
          paramk.bse.et(1);
          long l5 = paramk.bse.es(15) << 15;
          paramk.bse.et(1);
          long l6 = paramk.bse.es(15);
          paramk.bse.et(1);
          paramk.bnm.ao(l4 << 30 | l5 | l6);
          paramk.bsh = true;
        }
        paramk.timeUs = paramk.bnm.ao(l1 << 30 | l2 | l3);
      }
      paramk.bsq.c(paramk.timeUs, true);
      paramk.bsq.t(paramf);
      paramk.bsq.uG();
      this.bsm.eZ(this.bsm.capacity());
    }
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(92275);
    this.bpm = paramg;
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
    paramf.dV(arrayOfByte[13] & 0x7);
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
  
  public final void f(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92276);
    this.bnm.bHp = -9223372036854775807L;
    int i = 0;
    while (i < this.bsl.size())
    {
      a locala = (a)this.bsl.valueAt(i);
      locala.bsh = false;
      locala.bsq.uF();
      i += 1;
    }
    AppMethodBeat.o(92276);
  }
  
  static final class a
  {
    final u bnm;
    final l bse;
    boolean bsf;
    boolean bsg;
    boolean bsh;
    int bsi;
    final h bsq;
    long timeUs;
    
    public a(h paramh, u paramu)
    {
      AppMethodBeat.i(92271);
      this.bsq = paramh;
      this.bnm = paramu;
      this.bse = new l(new byte[64]);
      AppMethodBeat.o(92271);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.p
 * JD-Core Version:    0.7.0.1
 */