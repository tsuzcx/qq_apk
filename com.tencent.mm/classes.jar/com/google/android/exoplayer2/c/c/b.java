package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.c.i;
import com.google.android.exoplayer2.c.j;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.a.a;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;

public final class b
  implements e
{
  public static final h bio;
  private static final int bkx;
  private static final int bky;
  private static final int bkz;
  private Metadata bdr;
  private final com.google.android.exoplayer2.i.m biq;
  private g biu;
  private final long bkA;
  private final j bkB;
  private final i bkC;
  private com.google.android.exoplayer2.c.m bkD;
  private int bkE;
  private a bkF;
  private long bkG;
  private long bkH;
  private int bkI;
  private final int flags;
  
  static
  {
    AppMethodBeat.i(92045);
    bio = new h()
    {
      public final e[] us()
      {
        AppMethodBeat.i(92037);
        b localb = new b();
        AppMethodBeat.o(92037);
        return new e[] { localb };
      }
    };
    bkx = x.bJ("Xing");
    bky = x.bJ("Info");
    bkz = x.bJ("VBRI");
    AppMethodBeat.o(92045);
  }
  
  public b()
  {
    this(0);
  }
  
  public b(int paramInt)
  {
    this(paramInt, -9223372036854775807L);
  }
  
  public b(int paramInt, long paramLong)
  {
    AppMethodBeat.i(92038);
    this.flags = paramInt;
    this.bkA = paramLong;
    this.biq = new com.google.android.exoplayer2.i.m(10);
    this.bkB = new j();
    this.bkC = new i();
    this.bkG = -9223372036854775807L;
    AppMethodBeat.o(92038);
  }
  
  private boolean a(f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(92042);
    int m;
    int n;
    int k;
    int i;
    int j;
    if (paramBoolean)
    {
      m = 16384;
      paramf.uq();
      if (paramf.getPosition() != 0L) {
        break label326;
      }
      e(paramf);
      n = (int)paramf.ur();
      if (!paramBoolean) {
        paramf.dU(n);
      }
      k = 0;
      i = 0;
      j = 0;
    }
    for (;;)
    {
      label65:
      byte[] arrayOfByte = this.biq.data;
      boolean bool;
      if (j > 0) {
        bool = true;
      }
      for (;;)
      {
        if (paramf.b(arrayOfByte, 0, 4, bool))
        {
          this.biq.setPosition(0);
          int i1 = this.biq.readInt();
          int i2;
          if ((i == 0) || (j(i1, i)))
          {
            i2 = j.ec(i1);
            if (i2 != -1) {}
          }
          else
          {
            i = k + 1;
            if (k == m)
            {
              if (!paramBoolean)
              {
                paramf = new o("Searched too many bytes.");
                AppMethodBeat.o(92042);
                throw paramf;
                m = 131072;
                break;
                bool = false;
                continue;
              }
              AppMethodBeat.o(92042);
              return false;
            }
            if (paramBoolean)
            {
              paramf.uq();
              paramf.dV(n + i);
              k = i;
              i = 0;
              j = 0;
              break label65;
            }
            paramf.dU(1);
            k = i;
            i = 0;
            j = 0;
            break label65;
          }
          j += 1;
          if (j == 1)
          {
            j.a(i1, this.bkB);
            i = i1;
          }
          while (j != 4)
          {
            paramf.dV(i2 - 4);
            break;
          }
        }
      }
      if (paramBoolean) {
        paramf.dU(n + k);
      }
      for (;;)
      {
        this.bkE = i;
        AppMethodBeat.o(92042);
        return true;
        paramf.uq();
      }
      label326:
      k = 0;
      n = 0;
      i = 0;
      j = 0;
    }
  }
  
  private void e(f paramf)
  {
    AppMethodBeat.i(92043);
    int i = 0;
    paramf.b(this.biq.data, 0, 10);
    this.biq.setPosition(0);
    if (this.biq.wX() == com.google.android.exoplayer2.metadata.id3.a.bqo)
    {
      this.biq.fa(3);
      int j = this.biq.xb();
      int k = j + 10;
      a.a locala;
      if (this.bdr == null)
      {
        byte[] arrayOfByte = new byte[k];
        System.arraycopy(this.biq.data, 0, arrayOfByte, 0, 10);
        paramf.b(arrayOfByte, 10, j);
        if ((this.flags & 0x2) != 0)
        {
          locala = i.bhZ;
          label120:
          this.bdr = new com.google.android.exoplayer2.metadata.id3.a(locala).d(arrayOfByte, k);
          if (this.bdr != null) {
            this.bkC.c(this.bdr);
          }
        }
      }
      for (;;)
      {
        i += k;
        break;
        locala = null;
        break label120;
        paramf.dV(j);
      }
    }
    paramf.uq();
    paramf.dV(i);
    AppMethodBeat.o(92043);
  }
  
  private a f(f paramf)
  {
    AppMethodBeat.i(92044);
    paramf.b(this.biq.data, 0, 4);
    this.biq.setPosition(0);
    j.a(this.biq.readInt(), this.bkB);
    paramf = new a(paramf.getPosition(), this.bkB.bitrate, paramf.getLength());
    AppMethodBeat.o(92044);
    return paramf;
  }
  
  private static boolean j(int paramInt, long paramLong)
  {
    return (0xFFFE0C00 & paramInt) == (0xFFFE0C00 & paramLong);
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(92041);
    if (this.bkE == 0) {}
    label795:
    label1064:
    for (;;)
    {
      int j;
      Object localObject1;
      int k;
      int m;
      int n;
      int i1;
      Object localObject2;
      try
      {
        a(paramf, false);
        if (this.bkF == null)
        {
          paramk = new com.google.android.exoplayer2.i.m(this.bkB.beL);
          paramf.b(paramk.data, 0, this.bkB.beL);
          if ((this.bkB.version & 0x1) == 0) {
            break label567;
          }
          if (this.bkB.channels != 1)
          {
            i = 36;
            if (paramk.limit < i + 4) {
              break label590;
            }
            paramk.setPosition(i);
            j = paramk.readInt();
            if ((j != bkx) && (j != bky)) {
              break label590;
            }
            if ((j != bkx) && (j != bky)) {
              break label747;
            }
            localObject1 = this.bkB;
            l2 = paramf.getPosition();
            l1 = paramf.getLength();
            k = ((j)localObject1).bii;
            m = ((j)localObject1).sampleRate;
            l2 += ((j)localObject1).beL;
            n = paramk.readInt();
            if ((n & 0x1) == 1)
            {
              i1 = paramk.xc();
              if (i1 != 0) {
                break label629;
              }
            }
            paramk = null;
            if ((paramk != null) && (!this.bkC.uu()))
            {
              paramf.uq();
              paramf.dV(i + 141);
              paramf.b(this.biq.data, 0, 3);
              this.biq.setPosition(0);
              localObject1 = this.bkC;
              k = this.biq.wX();
              i = k >> 12;
              k &= 0xFFF;
              if ((i > 0) || (k > 0))
              {
                ((i)localObject1).bdD = i;
                ((i)localObject1).bdE = k;
              }
            }
            paramf.dU(this.bkB.beL);
            localObject1 = paramk;
            if (paramk != null)
            {
              localObject1 = paramk;
              if (!paramk.up())
              {
                localObject1 = paramk;
                if (j == bky) {
                  localObject1 = f(paramf);
                }
              }
            }
            this.bkF = ((a)localObject1);
            if ((this.bkF == null) || ((!this.bkF.up()) && ((this.flags & 0x1) != 0))) {
              this.bkF = f(paramf);
            }
            this.biu.a(this.bkF);
            localObject1 = this.bkD;
            localObject2 = this.bkB.mimeType;
            i = this.bkB.channels;
            j = this.bkB.sampleRate;
            k = this.bkC.bdD;
            m = this.bkC.bdE;
            if ((this.flags & 0x2) == 0) {
              break label1094;
            }
            paramk = null;
            ((com.google.android.exoplayer2.c.m)localObject1).f(Format.a(null, (String)localObject2, -1, 4096, i, j, -1, k, m, null, null, 0, null, paramk));
          }
        }
        else
        {
          if (this.bkI != 0) {
            break label1250;
          }
          paramf.uq();
          if (paramf.b(this.biq.data, 0, 4, true)) {
            break;
          }
          AppMethodBeat.o(92041);
          return -1;
        }
      }
      catch (EOFException paramf)
      {
        AppMethodBeat.o(92041);
        return -1;
      }
      i = 21;
      continue;
      label567:
      if (this.bkB.channels != 1)
      {
        i = 21;
      }
      else
      {
        i = 13;
        continue;
        label590:
        if (paramk.limit >= 40)
        {
          paramk.setPosition(36);
          if (paramk.readInt() == bkz)
          {
            j = bkz;
            continue;
          }
        }
        j = 0;
        continue;
        label629:
        long l3 = x.b(i1, k * 1000000L, m);
        if ((n & 0x6) != 6)
        {
          paramk = new d(l2, l3, l1);
        }
        else
        {
          long l4 = paramk.xc();
          paramk.fa(1);
          localObject2 = new long[99];
          k = 0;
          while (k < 99)
          {
            localObject2[k] = paramk.readUnsignedByte();
            k += 1;
          }
          paramk = new d(l2, l3, l1, (long[])localObject2, l4, ((j)localObject1).beL);
          continue;
          label747:
          if (j == bkz)
          {
            localObject1 = this.bkB;
            l1 = paramf.getPosition();
            l3 = paramf.getLength();
            paramk.fa(10);
            i = paramk.readInt();
            if (i <= 0) {
              localObject1 = null;
            }
            for (;;)
            {
              paramf.dU(this.bkB.beL);
              break;
              j = ((j)localObject1).sampleRate;
              l2 = i;
              if (j >= 32000) {}
              for (i = 1152;; i = 576)
              {
                l4 = x.b(l2, i * 1000000L, j);
                k = paramk.readUnsignedShort();
                m = paramk.readUnsignedShort();
                n = paramk.readUnsignedShort();
                paramk.fa(2);
                l1 += ((j)localObject1).beL;
                localObject1 = new long[k + 1];
                localObject2 = new long[k + 1];
                localObject1[0] = 0L;
                localObject2[0] = l1;
                j = 1;
                if (j >= localObject1.length) {
                  break label1064;
                }
                switch (n)
                {
                default: 
                  localObject1 = null;
                  break label795;
                }
              }
              i = paramk.readUnsignedByte();
              l1 += i * m;
              localObject1[j] = (j * l4 / k);
              if (l3 == -1L) {}
              for (l2 = l1;; l2 = Math.min(l3, l1))
              {
                localObject2[j] = l2;
                j += 1;
                break;
                i = paramk.readUnsignedShort();
                break label974;
                i = paramk.wX();
                break label974;
                i = paramk.xc();
                break label974;
              }
              localObject1 = new c((long[])localObject1, (long[])localObject2, l4);
            }
          }
          label974:
          localObject1 = null;
          paramf.uq();
          continue;
          label1094:
          paramk = this.bdr;
        }
      }
    }
    this.biq.setPosition(0);
    int i = this.biq.readInt();
    if ((!j(i, this.bkE)) || (j.ec(i) == -1))
    {
      paramf.dU(1);
      this.bkE = 0;
      AppMethodBeat.o(92041);
      return 0;
    }
    j.a(i, this.bkB);
    if (this.bkG == -9223372036854775807L)
    {
      this.bkG = this.bkF.N(paramf.getPosition());
      if (this.bkA != -9223372036854775807L)
      {
        l1 = this.bkF.N(0L);
        l2 = this.bkG;
        this.bkG = (this.bkA - l1 + l2);
      }
    }
    this.bkI = this.bkB.beL;
    label1250:
    i = this.bkD.a(paramf, this.bkI, true);
    if (i == -1)
    {
      AppMethodBeat.o(92041);
      return -1;
    }
    this.bkI -= i;
    if (this.bkI > 0)
    {
      AppMethodBeat.o(92041);
      return 0;
    }
    long l1 = this.bkG;
    long l2 = this.bkH * 1000000L / this.bkB.sampleRate;
    this.bkD.a(l2 + l1, 1, this.bkB.beL, 0, null);
    this.bkH += this.bkB.bii;
    this.bkI = 0;
    AppMethodBeat.o(92041);
    return 0;
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(92040);
    this.biu = paramg;
    this.bkD = this.biu.eb(0);
    this.biu.ut();
    AppMethodBeat.o(92040);
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(92039);
    boolean bool = a(paramf, true);
    AppMethodBeat.o(92039);
    return bool;
  }
  
  public final void f(long paramLong1, long paramLong2)
  {
    this.bkE = 0;
    this.bkG = -9223372036854775807L;
    this.bkH = 0L;
    this.bkI = 0;
  }
  
  static abstract interface a
    extends l
  {
    public abstract long N(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.b
 * JD-Core Version:    0.7.0.1
 */