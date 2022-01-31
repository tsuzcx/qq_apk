package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.c.i;
import com.google.android.exoplayer2.c.j;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.a.a;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;

public final class b
  implements e
{
  public static final h aBP;
  private static final int aDY;
  private static final int aDZ;
  private static final int aEa;
  private final com.google.android.exoplayer2.i.m aBR;
  private g aBV;
  private final long aEb;
  private final j aEc;
  private final i aEd;
  private com.google.android.exoplayer2.c.m aEe;
  private int aEf;
  private b.a aEg;
  private long aEh;
  private long aEi;
  private int aEj;
  private Metadata awI;
  private final int flags;
  
  static
  {
    AppMethodBeat.i(94930);
    aBP = new b.1();
    aDY = x.aS("Xing");
    aDZ = x.aS("Info");
    aEa = x.aS("VBRI");
    AppMethodBeat.o(94930);
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
    AppMethodBeat.i(94923);
    this.flags = paramInt;
    this.aEb = paramLong;
    this.aBR = new com.google.android.exoplayer2.i.m(10);
    this.aEc = new j();
    this.aEd = new i();
    this.aEh = -9223372036854775807L;
    AppMethodBeat.o(94923);
  }
  
  private boolean a(f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(94927);
    int m;
    int n;
    int k;
    int i;
    int j;
    if (paramBoolean)
    {
      m = 16384;
      paramf.nW();
      if (paramf.getPosition() != 0L) {
        break label326;
      }
      e(paramf);
      n = (int)paramf.nX();
      if (!paramBoolean) {
        paramf.dg(n);
      }
      k = 0;
      i = 0;
      j = 0;
    }
    for (;;)
    {
      label65:
      byte[] arrayOfByte = this.aBR.data;
      boolean bool;
      if (j > 0) {
        bool = true;
      }
      for (;;)
      {
        if (paramf.b(arrayOfByte, 0, 4, bool))
        {
          this.aBR.setPosition(0);
          int i1 = this.aBR.readInt();
          int i2;
          if ((i == 0) || (j(i1, i)))
          {
            i2 = j.dn(i1);
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
                AppMethodBeat.o(94927);
                throw paramf;
                m = 131072;
                break;
                bool = false;
                continue;
              }
              AppMethodBeat.o(94927);
              return false;
            }
            if (paramBoolean)
            {
              paramf.nW();
              paramf.dh(n + i);
              k = i;
              i = 0;
              j = 0;
              break label65;
            }
            paramf.dg(1);
            k = i;
            i = 0;
            j = 0;
            break label65;
          }
          j += 1;
          if (j == 1)
          {
            j.a(i1, this.aEc);
            i = i1;
          }
          while (j != 4)
          {
            paramf.dh(i2 - 4);
            break;
          }
        }
      }
      if (paramBoolean) {
        paramf.dg(n + k);
      }
      for (;;)
      {
        this.aEf = i;
        AppMethodBeat.o(94927);
        return true;
        paramf.nW();
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
    AppMethodBeat.i(94928);
    int i = 0;
    paramf.b(this.aBR.data, 0, 10);
    this.aBR.setPosition(0);
    if (this.aBR.qO() == com.google.android.exoplayer2.metadata.id3.a.aJO)
    {
      this.aBR.en(3);
      int j = this.aBR.qS();
      int k = j + 10;
      a.a locala;
      if (this.awI == null)
      {
        byte[] arrayOfByte = new byte[k];
        System.arraycopy(this.aBR.data, 0, arrayOfByte, 0, 10);
        paramf.b(arrayOfByte, 10, j);
        if ((this.flags & 0x2) != 0)
        {
          locala = i.aBA;
          label120:
          this.awI = new com.google.android.exoplayer2.metadata.id3.a(locala).b(arrayOfByte, k);
          if (this.awI != null) {
            this.aEd.c(this.awI);
          }
        }
      }
      for (;;)
      {
        i += k;
        break;
        locala = null;
        break label120;
        paramf.dh(j);
      }
    }
    paramf.nW();
    paramf.dh(i);
    AppMethodBeat.o(94928);
  }
  
  private b.a f(f paramf)
  {
    AppMethodBeat.i(94929);
    paramf.b(this.aBR.data, 0, 4);
    this.aBR.setPosition(0);
    j.a(this.aBR.readInt(), this.aEc);
    paramf = new a(paramf.getPosition(), this.aEc.bitrate, paramf.getLength());
    AppMethodBeat.o(94929);
    return paramf;
  }
  
  private static boolean j(int paramInt, long paramLong)
  {
    return (0xFFFE0C00 & paramInt) == (0xFFFE0C00 & paramLong);
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(94926);
    if (this.aEf == 0) {}
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
        if (this.aEg == null)
        {
          paramk = new com.google.android.exoplayer2.i.m(this.aEc.ayg);
          paramf.b(paramk.data, 0, this.aEc.ayg);
          if ((this.aEc.version & 0x1) == 0) {
            break label567;
          }
          if (this.aEc.channels != 1)
          {
            i = 36;
            if (paramk.limit < i + 4) {
              break label590;
            }
            paramk.setPosition(i);
            j = paramk.readInt();
            if ((j != aDY) && (j != aDZ)) {
              break label590;
            }
            if ((j != aDY) && (j != aDZ)) {
              break label747;
            }
            localObject1 = this.aEc;
            l2 = paramf.getPosition();
            l1 = paramf.getLength();
            k = ((j)localObject1).aBJ;
            m = ((j)localObject1).sampleRate;
            l2 += ((j)localObject1).ayg;
            n = paramk.readInt();
            if ((n & 0x1) == 1)
            {
              i1 = paramk.qT();
              if (i1 != 0) {
                break label629;
              }
            }
            paramk = null;
            if ((paramk != null) && (!this.aEd.oa()))
            {
              paramf.nW();
              paramf.dh(i + 141);
              paramf.b(this.aBR.data, 0, 3);
              this.aBR.setPosition(0);
              localObject1 = this.aEd;
              k = this.aBR.qO();
              i = k >> 12;
              k &= 0xFFF;
              if ((i > 0) || (k > 0))
              {
                ((i)localObject1).awW = i;
                ((i)localObject1).awX = k;
              }
            }
            paramf.dg(this.aEc.ayg);
            localObject1 = paramk;
            if (paramk != null)
            {
              localObject1 = paramk;
              if (!paramk.nV())
              {
                localObject1 = paramk;
                if (j == aDZ) {
                  localObject1 = f(paramf);
                }
              }
            }
            this.aEg = ((b.a)localObject1);
            if ((this.aEg == null) || ((!this.aEg.nV()) && ((this.flags & 0x1) != 0))) {
              this.aEg = f(paramf);
            }
            this.aBV.a(this.aEg);
            localObject1 = this.aEe;
            localObject2 = this.aEc.mimeType;
            i = this.aEc.channels;
            j = this.aEc.sampleRate;
            k = this.aEd.awW;
            m = this.aEd.awX;
            if ((this.flags & 0x2) == 0) {
              break label1094;
            }
            paramk = null;
            ((com.google.android.exoplayer2.c.m)localObject1).f(Format.a(null, (String)localObject2, -1, 4096, i, j, -1, k, m, null, null, 0, null, paramk));
          }
        }
        else
        {
          if (this.aEj != 0) {
            break label1250;
          }
          paramf.nW();
          if (paramf.b(this.aBR.data, 0, 4, true)) {
            break;
          }
          AppMethodBeat.o(94926);
          return -1;
        }
      }
      catch (EOFException paramf)
      {
        AppMethodBeat.o(94926);
        return -1;
      }
      i = 21;
      continue;
      label567:
      if (this.aEc.channels != 1)
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
          if (paramk.readInt() == aEa)
          {
            j = aEa;
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
          long l4 = paramk.qT();
          paramk.en(1);
          localObject2 = new long[99];
          k = 0;
          while (k < 99)
          {
            localObject2[k] = paramk.readUnsignedByte();
            k += 1;
          }
          paramk = new d(l2, l3, l1, (long[])localObject2, l4, ((j)localObject1).ayg);
          continue;
          label747:
          if (j == aEa)
          {
            localObject1 = this.aEc;
            l1 = paramf.getPosition();
            l3 = paramf.getLength();
            paramk.en(10);
            i = paramk.readInt();
            if (i <= 0) {
              localObject1 = null;
            }
            for (;;)
            {
              paramf.dg(this.aEc.ayg);
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
                paramk.en(2);
                l1 += ((j)localObject1).ayg;
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
                i = paramk.qO();
                break label974;
                i = paramk.qT();
                break label974;
              }
              localObject1 = new c((long[])localObject1, (long[])localObject2, l4);
            }
          }
          label974:
          localObject1 = null;
          paramf.nW();
          continue;
          label1094:
          paramk = this.awI;
        }
      }
    }
    this.aBR.setPosition(0);
    int i = this.aBR.readInt();
    if ((!j(i, this.aEf)) || (j.dn(i) == -1))
    {
      paramf.dg(1);
      this.aEf = 0;
      AppMethodBeat.o(94926);
      return 0;
    }
    j.a(i, this.aEc);
    if (this.aEh == -9223372036854775807L)
    {
      this.aEh = this.aEg.G(paramf.getPosition());
      if (this.aEb != -9223372036854775807L)
      {
        l1 = this.aEg.G(0L);
        l2 = this.aEh;
        this.aEh = (this.aEb - l1 + l2);
      }
    }
    this.aEj = this.aEc.ayg;
    label1250:
    i = this.aEe.a(paramf, this.aEj, true);
    if (i == -1)
    {
      AppMethodBeat.o(94926);
      return -1;
    }
    this.aEj -= i;
    if (this.aEj > 0)
    {
      AppMethodBeat.o(94926);
      return 0;
    }
    long l1 = this.aEh;
    long l2 = this.aEi * 1000000L / this.aEc.sampleRate;
    this.aEe.a(l2 + l1, 1, this.aEc.ayg, 0, null);
    this.aEi += this.aEc.aBJ;
    this.aEj = 0;
    AppMethodBeat.o(94926);
    return 0;
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(94925);
    this.aBV = paramg;
    this.aEe = this.aBV.dm(0);
    this.aBV.nZ();
    AppMethodBeat.o(94925);
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(94924);
    boolean bool = a(paramf, true);
    AppMethodBeat.o(94924);
    return bool;
  }
  
  public final void g(long paramLong1, long paramLong2)
  {
    this.aEf = 0;
    this.aEh = -9223372036854775807L;
    this.aEi = 0L;
    this.aEj = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.b
 * JD-Core Version:    0.7.0.1
 */