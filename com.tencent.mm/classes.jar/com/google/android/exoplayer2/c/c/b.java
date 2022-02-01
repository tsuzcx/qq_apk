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
  public static final h aXT;
  private static final int bac;
  private static final int bad;
  private static final int bae;
  private Metadata aSW;
  private final com.google.android.exoplayer2.i.m aXV;
  private g aXZ;
  private final long baf;
  private final j bag;
  private final i bah;
  private com.google.android.exoplayer2.c.m bai;
  private int baj;
  private a bak;
  private long bal;
  private long bam;
  private int ban;
  private final int flags;
  
  static
  {
    AppMethodBeat.i(92045);
    aXT = new h()
    {
      public final e[] sT()
      {
        AppMethodBeat.i(92037);
        b localb = new b();
        AppMethodBeat.o(92037);
        return new e[] { localb };
      }
    };
    bac = x.aQ("Xing");
    bad = x.aQ("Info");
    bae = x.aQ("VBRI");
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
    this.baf = paramLong;
    this.aXV = new com.google.android.exoplayer2.i.m(10);
    this.bag = new j();
    this.bah = new i();
    this.bal = -9223372036854775807L;
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
      paramf.sR();
      if (paramf.getPosition() != 0L) {
        break label326;
      }
      e(paramf);
      n = (int)paramf.sS();
      if (!paramBoolean) {
        paramf.dQ(n);
      }
      k = 0;
      i = 0;
      j = 0;
    }
    for (;;)
    {
      label65:
      byte[] arrayOfByte = this.aXV.data;
      boolean bool;
      if (j > 0) {
        bool = true;
      }
      for (;;)
      {
        if (paramf.b(arrayOfByte, 0, 4, bool))
        {
          this.aXV.setPosition(0);
          int i1 = this.aXV.readInt();
          int i2;
          if ((i == 0) || (j(i1, i)))
          {
            i2 = j.dX(i1);
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
              paramf.sR();
              paramf.dR(n + i);
              k = i;
              i = 0;
              j = 0;
              break label65;
            }
            paramf.dQ(1);
            k = i;
            i = 0;
            j = 0;
            break label65;
          }
          j += 1;
          if (j == 1)
          {
            j.a(i1, this.bag);
            i = i1;
          }
          while (j != 4)
          {
            paramf.dR(i2 - 4);
            break;
          }
        }
      }
      if (paramBoolean) {
        paramf.dQ(n + k);
      }
      for (;;)
      {
        this.baj = i;
        AppMethodBeat.o(92042);
        return true;
        paramf.sR();
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
    paramf.b(this.aXV.data, 0, 10);
    this.aXV.setPosition(0);
    if (this.aXV.vA() == com.google.android.exoplayer2.metadata.id3.a.bfU)
    {
      this.aXV.eX(3);
      int j = this.aXV.vE();
      int k = j + 10;
      a.a locala;
      if (this.aSW == null)
      {
        byte[] arrayOfByte = new byte[k];
        System.arraycopy(this.aXV.data, 0, arrayOfByte, 0, 10);
        paramf.b(arrayOfByte, 10, j);
        if ((this.flags & 0x2) != 0)
        {
          locala = i.aXE;
          label120:
          this.aSW = new com.google.android.exoplayer2.metadata.id3.a(locala).d(arrayOfByte, k);
          if (this.aSW != null) {
            this.bah.c(this.aSW);
          }
        }
      }
      for (;;)
      {
        i += k;
        break;
        locala = null;
        break label120;
        paramf.dR(j);
      }
    }
    paramf.sR();
    paramf.dR(i);
    AppMethodBeat.o(92043);
  }
  
  private a f(f paramf)
  {
    AppMethodBeat.i(92044);
    paramf.b(this.aXV.data, 0, 4);
    this.aXV.setPosition(0);
    j.a(this.aXV.readInt(), this.bag);
    paramf = new a(paramf.getPosition(), this.bag.bitrate, paramf.getLength());
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
    if (this.baj == 0) {}
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
        if (this.bak == null)
        {
          paramk = new com.google.android.exoplayer2.i.m(this.bag.aUr);
          paramf.b(paramk.data, 0, this.bag.aUr);
          if ((this.bag.version & 0x1) == 0) {
            break label567;
          }
          if (this.bag.channels != 1)
          {
            i = 36;
            if (paramk.limit < i + 4) {
              break label590;
            }
            paramk.setPosition(i);
            j = paramk.readInt();
            if ((j != bac) && (j != bad)) {
              break label590;
            }
            if ((j != bac) && (j != bad)) {
              break label747;
            }
            localObject1 = this.bag;
            l2 = paramf.getPosition();
            l1 = paramf.getLength();
            k = ((j)localObject1).aXN;
            m = ((j)localObject1).sampleRate;
            l2 += ((j)localObject1).aUr;
            n = paramk.readInt();
            if ((n & 0x1) == 1)
            {
              i1 = paramk.vF();
              if (i1 != 0) {
                break label629;
              }
            }
            paramk = null;
            if ((paramk != null) && (!this.bah.sV()))
            {
              paramf.sR();
              paramf.dR(i + 141);
              paramf.b(this.aXV.data, 0, 3);
              this.aXV.setPosition(0);
              localObject1 = this.bah;
              k = this.aXV.vA();
              i = k >> 12;
              k &= 0xFFF;
              if ((i > 0) || (k > 0))
              {
                ((i)localObject1).aTi = i;
                ((i)localObject1).aTj = k;
              }
            }
            paramf.dQ(this.bag.aUr);
            localObject1 = paramk;
            if (paramk != null)
            {
              localObject1 = paramk;
              if (!paramk.sQ())
              {
                localObject1 = paramk;
                if (j == bad) {
                  localObject1 = f(paramf);
                }
              }
            }
            this.bak = ((a)localObject1);
            if ((this.bak == null) || ((!this.bak.sQ()) && ((this.flags & 0x1) != 0))) {
              this.bak = f(paramf);
            }
            this.aXZ.a(this.bak);
            localObject1 = this.bai;
            localObject2 = this.bag.mimeType;
            i = this.bag.channels;
            j = this.bag.sampleRate;
            k = this.bah.aTi;
            m = this.bah.aTj;
            if ((this.flags & 0x2) == 0) {
              break label1094;
            }
            paramk = null;
            ((com.google.android.exoplayer2.c.m)localObject1).f(Format.a(null, (String)localObject2, -1, 4096, i, j, -1, k, m, null, null, 0, null, paramk));
          }
        }
        else
        {
          if (this.ban != 0) {
            break label1250;
          }
          paramf.sR();
          if (paramf.b(this.aXV.data, 0, 4, true)) {
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
      if (this.bag.channels != 1)
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
          if (paramk.readInt() == bae)
          {
            j = bae;
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
          long l4 = paramk.vF();
          paramk.eX(1);
          localObject2 = new long[99];
          k = 0;
          while (k < 99)
          {
            localObject2[k] = paramk.readUnsignedByte();
            k += 1;
          }
          paramk = new d(l2, l3, l1, (long[])localObject2, l4, ((j)localObject1).aUr);
          continue;
          label747:
          if (j == bae)
          {
            localObject1 = this.bag;
            l1 = paramf.getPosition();
            l3 = paramf.getLength();
            paramk.eX(10);
            i = paramk.readInt();
            if (i <= 0) {
              localObject1 = null;
            }
            for (;;)
            {
              paramf.dQ(this.bag.aUr);
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
                paramk.eX(2);
                l1 += ((j)localObject1).aUr;
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
                i = paramk.vA();
                break label974;
                i = paramk.vF();
                break label974;
              }
              localObject1 = new c((long[])localObject1, (long[])localObject2, l4);
            }
          }
          label974:
          localObject1 = null;
          paramf.sR();
          continue;
          label1094:
          paramk = this.aSW;
        }
      }
    }
    this.aXV.setPosition(0);
    int i = this.aXV.readInt();
    if ((!j(i, this.baj)) || (j.dX(i) == -1))
    {
      paramf.dQ(1);
      this.baj = 0;
      AppMethodBeat.o(92041);
      return 0;
    }
    j.a(i, this.bag);
    if (this.bal == -9223372036854775807L)
    {
      this.bal = this.bak.N(paramf.getPosition());
      if (this.baf != -9223372036854775807L)
      {
        l1 = this.bak.N(0L);
        l2 = this.bal;
        this.bal = (this.baf - l1 + l2);
      }
    }
    this.ban = this.bag.aUr;
    label1250:
    i = this.bai.a(paramf, this.ban, true);
    if (i == -1)
    {
      AppMethodBeat.o(92041);
      return -1;
    }
    this.ban -= i;
    if (this.ban > 0)
    {
      AppMethodBeat.o(92041);
      return 0;
    }
    long l1 = this.bal;
    long l2 = this.bam * 1000000L / this.bag.sampleRate;
    this.bai.a(l2 + l1, 1, this.bag.aUr, 0, null);
    this.bam += this.bag.aXN;
    this.ban = 0;
    AppMethodBeat.o(92041);
    return 0;
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(92040);
    this.aXZ = paramg;
    this.bai = this.aXZ.dW(0);
    this.aXZ.sU();
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
    this.baj = 0;
    this.bal = -9223372036854775807L;
    this.bam = 0L;
    this.ban = 0;
  }
  
  static abstract interface a
    extends l
  {
    public abstract long N(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.b
 * JD-Core Version:    0.7.0.1
 */