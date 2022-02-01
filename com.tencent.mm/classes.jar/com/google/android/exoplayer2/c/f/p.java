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
  public static final com.google.android.exoplayer2.c.h aXT;
  private final u bcR;
  private g beR;
  private final SparseArray<a> bhR;
  private final com.google.android.exoplayer2.i.m bhS;
  private boolean bhT;
  private boolean bhU;
  private boolean bhV;
  
  static
  {
    AppMethodBeat.i(92278);
    aXT = new com.google.android.exoplayer2.c.h()
    {
      public final e[] sT()
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
    this.bcR = paramu;
    this.bhS = new com.google.android.exoplayer2.i.m(4096);
    this.bhR = new SparseArray();
    AppMethodBeat.o(92273);
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(92277);
    if (!paramf.b(this.bhS.data, 0, 4, true))
    {
      AppMethodBeat.o(92277);
      return -1;
    }
    this.bhS.setPosition(0);
    int i = this.bhS.readInt();
    if (i == 441)
    {
      AppMethodBeat.o(92277);
      return -1;
    }
    if (i == 442)
    {
      paramf.b(this.bhS.data, 0, 10);
      this.bhS.setPosition(9);
      paramf.dQ((this.bhS.readUnsignedByte() & 0x7) + 14);
      AppMethodBeat.o(92277);
      return 0;
    }
    if (i == 443)
    {
      paramf.b(this.bhS.data, 0, 2);
      this.bhS.setPosition(0);
      paramf.dQ(this.bhS.readUnsignedShort() + 6);
      AppMethodBeat.o(92277);
      return 0;
    }
    if ((i & 0xFFFFFF00) >> 8 != 1)
    {
      paramf.dQ(1);
      AppMethodBeat.o(92277);
      return 0;
    }
    i &= 0xFF;
    a locala = (a)this.bhR.get(i);
    paramk = locala;
    Object localObject;
    if (!this.bhT)
    {
      localObject = locala;
      if (locala == null)
      {
        localObject = null;
        if ((this.bhU) || (i != 189)) {
          break label422;
        }
        paramk = new b();
        this.bhU = true;
        localObject = locala;
        if (paramk != null)
        {
          localObject = new v.d(i, 256);
          paramk.a(this.beR, (v.d)localObject);
          localObject = new a(paramk, this.bcR);
          this.bhR.put(i, localObject);
        }
      }
      if ((!this.bhU) || (!this.bhV))
      {
        paramk = (k)localObject;
        if (paramf.getPosition() <= 1048576L) {}
      }
      else
      {
        this.bhT = true;
        this.beR.sU();
        paramk = (k)localObject;
      }
    }
    paramf.b(this.bhS.data, 0, 2);
    this.bhS.setPosition(0);
    i = this.bhS.readUnsignedShort() + 6;
    if (paramk == null) {
      paramf.dQ(i);
    }
    for (;;)
    {
      AppMethodBeat.o(92277);
      return 0;
      label422:
      if ((!this.bhU) && ((i & 0xE0) == 192))
      {
        paramk = new m();
        this.bhU = true;
        break;
      }
      paramk = (k)localObject;
      if (this.bhV) {
        break;
      }
      paramk = (k)localObject;
      if ((i & 0xF0) != 224) {
        break;
      }
      paramk = new i();
      this.bhV = true;
      break;
      this.bhS.reset(i);
      paramf.readFully(this.bhS.data, 0, i);
      this.bhS.setPosition(6);
      paramf = this.bhS;
      paramf.readBytes(paramk.bhK.data, 0, 3);
      paramk.bhK.setPosition(0);
      paramk.bhK.ep(8);
      paramk.bhL = paramk.bhK.te();
      paramk.bhM = paramk.bhK.te();
      paramk.bhK.ep(6);
      paramk.bhO = paramk.bhK.eo(8);
      paramf.readBytes(paramk.bhK.data, 0, paramk.bhO);
      paramk.bhK.setPosition(0);
      paramk.timeUs = 0L;
      if (paramk.bhL)
      {
        paramk.bhK.ep(4);
        long l1 = paramk.bhK.eo(3);
        paramk.bhK.ep(1);
        long l2 = paramk.bhK.eo(15) << 15;
        paramk.bhK.ep(1);
        long l3 = paramk.bhK.eo(15);
        paramk.bhK.ep(1);
        if ((!paramk.bhN) && (paramk.bhM))
        {
          paramk.bhK.ep(4);
          long l4 = paramk.bhK.eo(3);
          paramk.bhK.ep(1);
          long l5 = paramk.bhK.eo(15) << 15;
          paramk.bhK.ep(1);
          long l6 = paramk.bhK.eo(15);
          paramk.bhK.ep(1);
          paramk.bcR.ao(l4 << 30 | l5 | l6);
          paramk.bhN = true;
        }
        paramk.timeUs = paramk.bcR.ao(l1 << 30 | l2 | l3);
      }
      paramk.bhW.c(paramk.timeUs, true);
      paramk.bhW.t(paramf);
      paramk.bhW.th();
      this.bhS.eW(this.bhS.capacity());
    }
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(92275);
    this.beR = paramg;
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
    paramf.dR(arrayOfByte[13] & 0x7);
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
    this.bcR.bxb = -9223372036854775807L;
    int i = 0;
    while (i < this.bhR.size())
    {
      a locala = (a)this.bhR.valueAt(i);
      locala.bhN = false;
      locala.bhW.tg();
      i += 1;
    }
    AppMethodBeat.o(92276);
  }
  
  static final class a
  {
    final u bcR;
    final l bhK;
    boolean bhL;
    boolean bhM;
    boolean bhN;
    int bhO;
    final h bhW;
    long timeUs;
    
    public a(h paramh, u paramu)
    {
      AppMethodBeat.i(92271);
      this.bhW = paramh;
      this.bcR = paramu;
      this.bhK = new l(new byte[64]);
      AppMethodBeat.o(92271);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.p
 * JD-Core Version:    0.7.0.1
 */