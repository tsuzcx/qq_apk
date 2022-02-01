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
  public static final com.google.android.exoplayer2.c.h bil;
  private final u bnh;
  private g bph;
  private final SparseArray<a> bsg;
  private final com.google.android.exoplayer2.i.m bsh;
  private boolean bsi;
  private boolean bsj;
  private boolean bsk;
  
  static
  {
    AppMethodBeat.i(92278);
    bil = new com.google.android.exoplayer2.c.h()
    {
      public final e[] ux()
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
    this.bnh = paramu;
    this.bsh = new com.google.android.exoplayer2.i.m(4096);
    this.bsg = new SparseArray();
    AppMethodBeat.o(92273);
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(92277);
    if (!paramf.b(this.bsh.data, 0, 4, true))
    {
      AppMethodBeat.o(92277);
      return -1;
    }
    this.bsh.setPosition(0);
    int i = this.bsh.readInt();
    if (i == 441)
    {
      AppMethodBeat.o(92277);
      return -1;
    }
    if (i == 442)
    {
      paramf.b(this.bsh.data, 0, 10);
      this.bsh.setPosition(9);
      paramf.dP((this.bsh.readUnsignedByte() & 0x7) + 14);
      AppMethodBeat.o(92277);
      return 0;
    }
    if (i == 443)
    {
      paramf.b(this.bsh.data, 0, 2);
      this.bsh.setPosition(0);
      paramf.dP(this.bsh.readUnsignedShort() + 6);
      AppMethodBeat.o(92277);
      return 0;
    }
    if ((i & 0xFFFFFF00) >> 8 != 1)
    {
      paramf.dP(1);
      AppMethodBeat.o(92277);
      return 0;
    }
    i &= 0xFF;
    a locala = (a)this.bsg.get(i);
    paramk = locala;
    Object localObject;
    if (!this.bsi)
    {
      localObject = locala;
      if (locala == null)
      {
        localObject = null;
        if ((this.bsj) || (i != 189)) {
          break label422;
        }
        paramk = new b();
        this.bsj = true;
        localObject = locala;
        if (paramk != null)
        {
          localObject = new v.d(i, 256);
          paramk.a(this.bph, (v.d)localObject);
          localObject = new a(paramk, this.bnh);
          this.bsg.put(i, localObject);
        }
      }
      if ((!this.bsj) || (!this.bsk))
      {
        paramk = (k)localObject;
        if (paramf.getPosition() <= 1048576L) {}
      }
      else
      {
        this.bsi = true;
        this.bph.uy();
        paramk = (k)localObject;
      }
    }
    paramf.b(this.bsh.data, 0, 2);
    this.bsh.setPosition(0);
    i = this.bsh.readUnsignedShort() + 6;
    if (paramk == null) {
      paramf.dP(i);
    }
    for (;;)
    {
      AppMethodBeat.o(92277);
      return 0;
      label422:
      if ((!this.bsj) && ((i & 0xE0) == 192))
      {
        paramk = new m();
        this.bsj = true;
        break;
      }
      paramk = (k)localObject;
      if (this.bsk) {
        break;
      }
      paramk = (k)localObject;
      if ((i & 0xF0) != 224) {
        break;
      }
      paramk = new i();
      this.bsk = true;
      break;
      this.bsh.reset(i);
      paramf.readFully(this.bsh.data, 0, i);
      this.bsh.setPosition(6);
      paramf = this.bsh;
      paramf.readBytes(paramk.brZ.data, 0, 3);
      paramk.brZ.setPosition(0);
      paramk.brZ.en(8);
      paramk.bsa = paramk.brZ.uI();
      paramk.bsb = paramk.brZ.uI();
      paramk.brZ.en(6);
      paramk.bsd = paramk.brZ.em(8);
      paramf.readBytes(paramk.brZ.data, 0, paramk.bsd);
      paramk.brZ.setPosition(0);
      paramk.timeUs = 0L;
      if (paramk.bsa)
      {
        paramk.brZ.en(4);
        long l1 = paramk.brZ.em(3);
        paramk.brZ.en(1);
        long l2 = paramk.brZ.em(15) << 15;
        paramk.brZ.en(1);
        long l3 = paramk.brZ.em(15);
        paramk.brZ.en(1);
        if ((!paramk.bsc) && (paramk.bsb))
        {
          paramk.brZ.en(4);
          long l4 = paramk.brZ.em(3);
          paramk.brZ.en(1);
          long l5 = paramk.brZ.em(15) << 15;
          paramk.brZ.en(1);
          long l6 = paramk.brZ.em(15);
          paramk.brZ.en(1);
          paramk.bnh.ao(l4 << 30 | l5 | l6);
          paramk.bsc = true;
        }
        paramk.timeUs = paramk.bnh.ao(l1 << 30 | l2 | l3);
      }
      paramk.bsl.c(paramk.timeUs, true);
      paramk.bsl.t(paramf);
      paramk.bsl.uL();
      this.bsh.eY(this.bsh.capacity());
    }
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(92275);
    this.bph = paramg;
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
    paramf.dQ(arrayOfByte[13] & 0x7);
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
    this.bnh.bHG = -9223372036854775807L;
    int i = 0;
    while (i < this.bsg.size())
    {
      a locala = (a)this.bsg.valueAt(i);
      locala.bsc = false;
      locala.bsl.uK();
      i += 1;
    }
    AppMethodBeat.o(92276);
  }
  
  static final class a
  {
    final u bnh;
    final l brZ;
    boolean bsa;
    boolean bsb;
    boolean bsc;
    int bsd;
    final h bsl;
    long timeUs;
    
    public a(h paramh, u paramu)
    {
      AppMethodBeat.i(92271);
      this.bsl = paramh;
      this.bnh = paramu;
      this.brZ = new l(new byte[64]);
      AppMethodBeat.o(92271);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.p
 * JD-Core Version:    0.7.0.1
 */