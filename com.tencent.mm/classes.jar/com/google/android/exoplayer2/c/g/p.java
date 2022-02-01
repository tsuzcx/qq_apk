package com.google.android.exoplayer2.c.g;

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
  public static final com.google.android.exoplayer2.c.h aXh;
  private final u bcf;
  private g bef;
  private final SparseArray<a> bhl;
  private final com.google.android.exoplayer2.i.m bhm;
  private boolean bhn;
  private boolean bho;
  private boolean bhp;
  
  static
  {
    AppMethodBeat.i(92278);
    aXh = new com.google.android.exoplayer2.c.h()
    {
      public final e[] sK()
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
    this.bcf = paramu;
    this.bhm = new com.google.android.exoplayer2.i.m(4096);
    this.bhl = new SparseArray();
    AppMethodBeat.o(92273);
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(92277);
    if (!paramf.b(this.bhm.data, 0, 4, true))
    {
      AppMethodBeat.o(92277);
      return -1;
    }
    this.bhm.setPosition(0);
    int i = this.bhm.readInt();
    if (i == 441)
    {
      AppMethodBeat.o(92277);
      return -1;
    }
    if (i == 442)
    {
      paramf.b(this.bhm.data, 0, 10);
      this.bhm.setPosition(9);
      paramf.dR((this.bhm.readUnsignedByte() & 0x7) + 14);
      AppMethodBeat.o(92277);
      return 0;
    }
    if (i == 443)
    {
      paramf.b(this.bhm.data, 0, 2);
      this.bhm.setPosition(0);
      paramf.dR(this.bhm.readUnsignedShort() + 6);
      AppMethodBeat.o(92277);
      return 0;
    }
    if ((i & 0xFFFFFF00) >> 8 != 1)
    {
      paramf.dR(1);
      AppMethodBeat.o(92277);
      return 0;
    }
    i &= 0xFF;
    a locala = (a)this.bhl.get(i);
    paramk = locala;
    Object localObject;
    if (!this.bhn)
    {
      localObject = locala;
      if (locala == null)
      {
        localObject = null;
        if ((this.bho) || (i != 189)) {
          break label422;
        }
        paramk = new b();
        this.bho = true;
        localObject = locala;
        if (paramk != null)
        {
          localObject = new v.d(i, 256);
          paramk.a(this.bef, (v.d)localObject);
          localObject = new a(paramk, this.bcf);
          this.bhl.put(i, localObject);
        }
      }
      if ((!this.bho) || (!this.bhp))
      {
        paramk = (k)localObject;
        if (paramf.getPosition() <= 1048576L) {}
      }
      else
      {
        this.bhn = true;
        this.bef.sL();
        paramk = (k)localObject;
      }
    }
    paramf.b(this.bhm.data, 0, 2);
    this.bhm.setPosition(0);
    i = this.bhm.readUnsignedShort() + 6;
    if (paramk == null) {
      paramf.dR(i);
    }
    for (;;)
    {
      AppMethodBeat.o(92277);
      return 0;
      label422:
      if ((!this.bho) && ((i & 0xE0) == 192))
      {
        paramk = new m();
        this.bho = true;
        break;
      }
      paramk = (k)localObject;
      if (this.bhp) {
        break;
      }
      paramk = (k)localObject;
      if ((i & 0xF0) != 224) {
        break;
      }
      paramk = new i();
      this.bhp = true;
      break;
      this.bhm.reset(i);
      paramf.readFully(this.bhm.data, 0, i);
      this.bhm.setPosition(6);
      paramf = this.bhm;
      paramf.readBytes(paramk.bhe.data, 0, 3);
      paramk.bhe.setPosition(0);
      paramk.bhe.ep(8);
      paramk.bhf = paramk.bhe.sV();
      paramk.bhg = paramk.bhe.sV();
      paramk.bhe.ep(6);
      paramk.bhi = paramk.bhe.eo(8);
      paramf.readBytes(paramk.bhe.data, 0, paramk.bhi);
      paramk.bhe.setPosition(0);
      paramk.timeUs = 0L;
      if (paramk.bhf)
      {
        paramk.bhe.ep(4);
        long l1 = paramk.bhe.eo(3);
        paramk.bhe.ep(1);
        long l2 = paramk.bhe.eo(15) << 15;
        paramk.bhe.ep(1);
        long l3 = paramk.bhe.eo(15);
        paramk.bhe.ep(1);
        if ((!paramk.bhh) && (paramk.bhg))
        {
          paramk.bhe.ep(4);
          long l4 = paramk.bhe.eo(3);
          paramk.bhe.ep(1);
          long l5 = paramk.bhe.eo(15) << 15;
          paramk.bhe.ep(1);
          long l6 = paramk.bhe.eo(15);
          paramk.bhe.ep(1);
          paramk.bcf.as(l4 << 30 | l5 | l6);
          paramk.bhh = true;
        }
        paramk.timeUs = paramk.bcf.as(l1 << 30 | l2 | l3);
      }
      paramk.bhq.c(paramk.timeUs, true);
      paramk.bhq.t(paramf);
      paramk.bhq.sY();
      this.bhm.fk(this.bhm.capacity());
    }
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(92275);
    this.bef = paramg;
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
    paramf.dS(arrayOfByte[13] & 0x7);
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
    this.bcf.bzt = -9223372036854775807L;
    int i = 0;
    while (i < this.bhl.size())
    {
      a locala = (a)this.bhl.valueAt(i);
      locala.bhh = false;
      locala.bhq.sX();
      i += 1;
    }
    AppMethodBeat.o(92276);
  }
  
  static final class a
  {
    final u bcf;
    final l bhe;
    boolean bhf;
    boolean bhg;
    boolean bhh;
    int bhi;
    final h bhq;
    long timeUs;
    
    public a(h paramh, u paramu)
    {
      AppMethodBeat.i(92271);
      this.bhq = paramh;
      this.bcf = paramu;
      this.bhe = new l(new byte[64]);
      AppMethodBeat.o(92271);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.g.p
 * JD-Core Version:    0.7.0.1
 */