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
  public static final h bil;
  private static final int bks;
  private static final int bkt;
  private static final int bku;
  private Metadata bdo;
  private final com.google.android.exoplayer2.i.m bin;
  private g bir;
  private a bkA;
  private long bkB;
  private long bkC;
  private int bkD;
  private final long bkv;
  private final j bkw;
  private final i bkx;
  private com.google.android.exoplayer2.c.m bky;
  private int bkz;
  private final int flags;
  
  static
  {
    AppMethodBeat.i(92045);
    bil = new h()
    {
      public final e[] ux()
      {
        AppMethodBeat.i(92037);
        b localb = new b();
        AppMethodBeat.o(92037);
        return new e[] { localb };
      }
    };
    bks = x.bJ("Xing");
    bkt = x.bJ("Info");
    bku = x.bJ("VBRI");
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
    this.bkv = paramLong;
    this.bin = new com.google.android.exoplayer2.i.m(10);
    this.bkw = new j();
    this.bkx = new i();
    this.bkB = -9223372036854775807L;
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
      paramf.uv();
      if (paramf.getPosition() != 0L) {
        break label326;
      }
      e(paramf);
      n = (int)paramf.uw();
      if (!paramBoolean) {
        paramf.dP(n);
      }
      k = 0;
      i = 0;
      j = 0;
    }
    for (;;)
    {
      label65:
      byte[] arrayOfByte = this.bin.data;
      boolean bool;
      if (j > 0) {
        bool = true;
      }
      for (;;)
      {
        if (paramf.b(arrayOfByte, 0, 4, bool))
        {
          this.bin.setPosition(0);
          int i1 = this.bin.readInt();
          int i2;
          if ((i == 0) || (j(i1, i)))
          {
            i2 = j.dW(i1);
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
              paramf.uv();
              paramf.dQ(n + i);
              k = i;
              i = 0;
              j = 0;
              break label65;
            }
            paramf.dP(1);
            k = i;
            i = 0;
            j = 0;
            break label65;
          }
          j += 1;
          if (j == 1)
          {
            j.a(i1, this.bkw);
            i = i1;
          }
          while (j != 4)
          {
            paramf.dQ(i2 - 4);
            break;
          }
        }
      }
      if (paramBoolean) {
        paramf.dP(n + k);
      }
      for (;;)
      {
        this.bkz = i;
        AppMethodBeat.o(92042);
        return true;
        paramf.uv();
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
    paramf.b(this.bin.data, 0, 10);
    this.bin.setPosition(0);
    if (this.bin.xf() == com.google.android.exoplayer2.metadata.id3.a.bqj)
    {
      this.bin.eZ(3);
      int j = this.bin.xj();
      int k = j + 10;
      a.a locala;
      if (this.bdo == null)
      {
        byte[] arrayOfByte = new byte[k];
        System.arraycopy(this.bin.data, 0, arrayOfByte, 0, 10);
        paramf.b(arrayOfByte, 10, j);
        if ((this.flags & 0x2) != 0)
        {
          locala = i.bhW;
          label120:
          this.bdo = new com.google.android.exoplayer2.metadata.id3.a(locala).d(arrayOfByte, k);
          if (this.bdo != null) {
            this.bkx.c(this.bdo);
          }
        }
      }
      for (;;)
      {
        i += k;
        break;
        locala = null;
        break label120;
        paramf.dQ(j);
      }
    }
    paramf.uv();
    paramf.dQ(i);
    AppMethodBeat.o(92043);
  }
  
  private a f(f paramf)
  {
    AppMethodBeat.i(92044);
    paramf.b(this.bin.data, 0, 4);
    this.bin.setPosition(0);
    j.a(this.bin.readInt(), this.bkw);
    paramf = new a(paramf.getPosition(), this.bkw.bitrate, paramf.getLength());
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
    if (this.bkz == 0) {}
    label796:
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
        if (this.bkA == null)
        {
          paramk = new com.google.android.exoplayer2.i.m(this.bkw.beI);
          paramf.b(paramk.data, 0, this.bkw.beI);
          if ((this.bkw.version & 0x1) == 0) {
            break label568;
          }
          if (this.bkw.channels != 1)
          {
            i = 36;
            if (paramk.limit < i + 4) {
              break label591;
            }
            paramk.setPosition(i);
            j = paramk.readInt();
            if ((j != bks) && (j != bkt)) {
              break label591;
            }
            if ((j != bks) && (j != bkt)) {
              break label748;
            }
            localObject1 = this.bkw;
            l2 = paramf.getPosition();
            l1 = paramf.getLength();
            k = ((j)localObject1).bif;
            m = ((j)localObject1).sampleRate;
            l2 += ((j)localObject1).beI;
            n = paramk.readInt();
            if ((n & 0x1) == 1)
            {
              i1 = paramk.xk();
              if (i1 != 0) {
                break label630;
              }
            }
            paramk = null;
            if ((paramk != null) && (!this.bkx.uz()))
            {
              paramf.uv();
              paramf.dQ(i + 141);
              paramf.b(this.bin.data, 0, 3);
              this.bin.setPosition(0);
              localObject1 = this.bkx;
              k = this.bin.xf();
              i = k >> 12;
              k &= 0xFFF;
              if ((i > 0) || (k > 0))
              {
                ((i)localObject1).bdA = i;
                ((i)localObject1).bdB = k;
              }
            }
            paramf.dP(this.bkw.beI);
            localObject1 = paramk;
            if (paramk != null)
            {
              localObject1 = paramk;
              if (!paramk.uu())
              {
                localObject1 = paramk;
                if (j == bkt) {
                  localObject1 = f(paramf);
                }
              }
            }
            this.bkA = ((a)localObject1);
            if ((this.bkA == null) || ((!this.bkA.uu()) && ((this.flags & 0x1) != 0))) {
              this.bkA = f(paramf);
            }
            this.bir.a(this.bkA);
            localObject1 = this.bky;
            localObject2 = this.bkw.mimeType;
            i = this.bkw.channels;
            j = this.bkw.sampleRate;
            k = this.bkx.bdA;
            m = this.bkx.bdB;
            if ((this.flags & 0x2) == 0) {
              break label1094;
            }
            paramk = null;
            ((com.google.android.exoplayer2.c.m)localObject1).f(Format.a(null, (String)localObject2, null, -1, 4096, i, j, -1, k, m, null, null, 0, null, paramk));
          }
        }
        else
        {
          if (this.bkD != 0) {
            break label1250;
          }
          paramf.uv();
          if (paramf.b(this.bin.data, 0, 4, true)) {
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
      label568:
      if (this.bkw.channels != 1)
      {
        i = 21;
      }
      else
      {
        i = 13;
        continue;
        label591:
        if (paramk.limit >= 40)
        {
          paramk.setPosition(36);
          if (paramk.readInt() == bku)
          {
            j = bku;
            continue;
          }
        }
        j = 0;
        continue;
        label630:
        long l3 = x.b(i1, k * 1000000L, m);
        if ((n & 0x6) != 6)
        {
          paramk = new d(l2, l3, l1);
        }
        else
        {
          long l4 = paramk.xk();
          paramk.eZ(1);
          localObject2 = new long[99];
          k = 0;
          while (k < 99)
          {
            localObject2[k] = paramk.readUnsignedByte();
            k += 1;
          }
          paramk = new d(l2, l3, l1, (long[])localObject2, l4, ((j)localObject1).beI);
          continue;
          label748:
          if (j == bku)
          {
            localObject1 = this.bkw;
            l1 = paramf.getPosition();
            l3 = paramf.getLength();
            paramk.eZ(10);
            i = paramk.readInt();
            if (i <= 0) {
              localObject1 = null;
            }
            for (;;)
            {
              paramf.dP(this.bkw.beI);
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
                paramk.eZ(2);
                l1 += ((j)localObject1).beI;
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
                  break label796;
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
                i = paramk.xf();
                break label974;
                i = paramk.xk();
                break label974;
              }
              localObject1 = new c((long[])localObject1, (long[])localObject2, l4);
            }
          }
          label974:
          localObject1 = null;
          paramf.uv();
          continue;
          label1094:
          paramk = this.bdo;
        }
      }
    }
    this.bin.setPosition(0);
    int i = this.bin.readInt();
    if ((!j(i, this.bkz)) || (j.dW(i) == -1))
    {
      paramf.dP(1);
      this.bkz = 0;
      AppMethodBeat.o(92041);
      return 0;
    }
    j.a(i, this.bkw);
    if (this.bkB == -9223372036854775807L)
    {
      this.bkB = this.bkA.N(paramf.getPosition());
      if (this.bkv != -9223372036854775807L)
      {
        l1 = this.bkA.N(0L);
        l2 = this.bkB;
        this.bkB = (this.bkv - l1 + l2);
      }
    }
    this.bkD = this.bkw.beI;
    label1250:
    i = this.bky.a(paramf, this.bkD, true);
    if (i == -1)
    {
      AppMethodBeat.o(92041);
      return -1;
    }
    this.bkD -= i;
    if (this.bkD > 0)
    {
      AppMethodBeat.o(92041);
      return 0;
    }
    long l1 = this.bkB;
    long l2 = this.bkC * 1000000L / this.bkw.sampleRate;
    this.bky.a(l2 + l1, 1, this.bkw.beI, 0, null);
    this.bkC += this.bkw.bif;
    this.bkD = 0;
    AppMethodBeat.o(92041);
    return 0;
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(92040);
    this.bir = paramg;
    this.bky = this.bir.dV(0);
    this.bir.uy();
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
    this.bkz = 0;
    this.bkB = -9223372036854775807L;
    this.bkC = 0L;
    this.bkD = 0;
  }
  
  static abstract interface a
    extends l
  {
    public abstract long N(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.b
 * JD-Core Version:    0.7.0.1
 */