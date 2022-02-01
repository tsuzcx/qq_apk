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
  public static final h aXh;
  private static final int aZq;
  private static final int aZr;
  private static final int aZs;
  private Metadata aSb;
  private final com.google.android.exoplayer2.i.m aXj;
  private g aXn;
  private long aZA;
  private int aZB;
  private final long aZt;
  private final j aZu;
  private final i aZv;
  private com.google.android.exoplayer2.c.m aZw;
  private int aZx;
  private a aZy;
  private long aZz;
  private final int flags;
  
  static
  {
    AppMethodBeat.i(92045);
    aXh = new h()
    {
      public final e[] sK()
      {
        AppMethodBeat.i(92037);
        b localb = new b();
        AppMethodBeat.o(92037);
        return new e[] { localb };
      }
    };
    aZq = x.aY("Xing");
    aZr = x.aY("Info");
    aZs = x.aY("VBRI");
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
    this.aZt = paramLong;
    this.aXj = new com.google.android.exoplayer2.i.m(10);
    this.aZu = new j();
    this.aZv = new i();
    this.aZz = -9223372036854775807L;
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
      paramf.sI();
      if (paramf.getPosition() != 0L) {
        break label326;
      }
      e(paramf);
      n = (int)paramf.sJ();
      if (!paramBoolean) {
        paramf.dR(n);
      }
      k = 0;
      i = 0;
      j = 0;
    }
    for (;;)
    {
      label65:
      byte[] arrayOfByte = this.aXj.data;
      boolean bool;
      if (j > 0) {
        bool = true;
      }
      for (;;)
      {
        if (paramf.b(arrayOfByte, 0, 4, bool))
        {
          this.aXj.setPosition(0);
          int i1 = this.aXj.readInt();
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
              paramf.sI();
              paramf.dS(n + i);
              k = i;
              i = 0;
              j = 0;
              break label65;
            }
            paramf.dR(1);
            k = i;
            i = 0;
            j = 0;
            break label65;
          }
          j += 1;
          if (j == 1)
          {
            j.a(i1, this.aZu);
            i = i1;
          }
          while (j != 4)
          {
            paramf.dS(i2 - 4);
            break;
          }
        }
      }
      if (paramBoolean) {
        paramf.dR(n + k);
      }
      for (;;)
      {
        this.aZx = i;
        AppMethodBeat.o(92042);
        return true;
        paramf.sI();
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
    paramf.b(this.aXj.data, 0, 10);
    this.aXj.setPosition(0);
    if (this.aXj.vL() == com.google.android.exoplayer2.metadata.id3.a.bfm)
    {
      this.aXj.fl(3);
      int j = this.aXj.vP();
      int k = j + 10;
      a.a locala;
      if (this.aSb == null)
      {
        byte[] arrayOfByte = new byte[k];
        System.arraycopy(this.aXj.data, 0, arrayOfByte, 0, 10);
        paramf.b(arrayOfByte, 10, j);
        if ((this.flags & 0x2) != 0)
        {
          locala = i.aWS;
          label120:
          this.aSb = new com.google.android.exoplayer2.metadata.id3.a(locala).d(arrayOfByte, k);
          if (this.aSb != null) {
            this.aZv.c(this.aSb);
          }
        }
      }
      for (;;)
      {
        i += k;
        break;
        locala = null;
        break label120;
        paramf.dS(j);
      }
    }
    paramf.sI();
    paramf.dS(i);
    AppMethodBeat.o(92043);
  }
  
  private a f(f paramf)
  {
    AppMethodBeat.i(92044);
    paramf.b(this.aXj.data, 0, 4);
    this.aXj.setPosition(0);
    j.a(this.aXj.readInt(), this.aZu);
    paramf = new a(paramf.getPosition(), this.aZu.bitrate, paramf.getLength());
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
    if (this.aZx == 0) {}
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
        if (this.aZy == null)
        {
          paramk = new com.google.android.exoplayer2.i.m(this.aZu.aTz);
          paramf.b(paramk.data, 0, this.aZu.aTz);
          if ((this.aZu.version & 0x1) == 0) {
            break label567;
          }
          if (this.aZu.channels != 1)
          {
            i = 36;
            if (paramk.limit < i + 4) {
              break label590;
            }
            paramk.setPosition(i);
            j = paramk.readInt();
            if ((j != aZq) && (j != aZr)) {
              break label590;
            }
            if ((j != aZq) && (j != aZr)) {
              break label747;
            }
            localObject1 = this.aZu;
            l2 = paramf.getPosition();
            l1 = paramf.getLength();
            k = ((j)localObject1).aXb;
            m = ((j)localObject1).sampleRate;
            l2 += ((j)localObject1).aTz;
            n = paramk.readInt();
            if ((n & 0x1) == 1)
            {
              i1 = paramk.vQ();
              if (i1 != 0) {
                break label629;
              }
            }
            paramk = null;
            if ((paramk != null) && (!this.aZv.sM()))
            {
              paramf.sI();
              paramf.dS(i + 141);
              paramf.b(this.aXj.data, 0, 3);
              this.aXj.setPosition(0);
              localObject1 = this.aZv;
              k = this.aXj.vL();
              i = k >> 12;
              k &= 0xFFF;
              if ((i > 0) || (k > 0))
              {
                ((i)localObject1).aSp = i;
                ((i)localObject1).aSq = k;
              }
            }
            paramf.dR(this.aZu.aTz);
            localObject1 = paramk;
            if (paramk != null)
            {
              localObject1 = paramk;
              if (!paramk.sH())
              {
                localObject1 = paramk;
                if (j == aZr) {
                  localObject1 = f(paramf);
                }
              }
            }
            this.aZy = ((a)localObject1);
            if ((this.aZy == null) || ((!this.aZy.sH()) && ((this.flags & 0x1) != 0))) {
              this.aZy = f(paramf);
            }
            this.aXn.a(this.aZy);
            localObject1 = this.aZw;
            localObject2 = this.aZu.mimeType;
            i = this.aZu.channels;
            j = this.aZu.sampleRate;
            k = this.aZv.aSp;
            m = this.aZv.aSq;
            if ((this.flags & 0x2) == 0) {
              break label1094;
            }
            paramk = null;
            ((com.google.android.exoplayer2.c.m)localObject1).f(Format.a(null, (String)localObject2, -1, 4096, i, j, -1, k, m, null, null, 0, null, paramk));
          }
        }
        else
        {
          if (this.aZB != 0) {
            break label1250;
          }
          paramf.sI();
          if (paramf.b(this.aXj.data, 0, 4, true)) {
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
      if (this.aZu.channels != 1)
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
          if (paramk.readInt() == aZs)
          {
            j = aZs;
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
          long l4 = paramk.vQ();
          paramk.fl(1);
          localObject2 = new long[99];
          k = 0;
          while (k < 99)
          {
            localObject2[k] = paramk.readUnsignedByte();
            k += 1;
          }
          paramk = new d(l2, l3, l1, (long[])localObject2, l4, ((j)localObject1).aTz);
          continue;
          label747:
          if (j == aZs)
          {
            localObject1 = this.aZu;
            l1 = paramf.getPosition();
            l3 = paramf.getLength();
            paramk.fl(10);
            i = paramk.readInt();
            if (i <= 0) {
              localObject1 = null;
            }
            for (;;)
            {
              paramf.dR(this.aZu.aTz);
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
                paramk.fl(2);
                l1 += ((j)localObject1).aTz;
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
                i = paramk.vL();
                break label974;
                i = paramk.vQ();
                break label974;
              }
              localObject1 = new c((long[])localObject1, (long[])localObject2, l4);
            }
          }
          label974:
          localObject1 = null;
          paramf.sI();
          continue;
          label1094:
          paramk = this.aSb;
        }
      }
    }
    this.aXj.setPosition(0);
    int i = this.aXj.readInt();
    if ((!j(i, this.aZx)) || (j.dX(i) == -1))
    {
      paramf.dR(1);
      this.aZx = 0;
      AppMethodBeat.o(92041);
      return 0;
    }
    j.a(i, this.aZu);
    if (this.aZz == -9223372036854775807L)
    {
      this.aZz = this.aZy.M(paramf.getPosition());
      if (this.aZt != -9223372036854775807L)
      {
        l1 = this.aZy.M(0L);
        l2 = this.aZz;
        this.aZz = (this.aZt - l1 + l2);
      }
    }
    this.aZB = this.aZu.aTz;
    label1250:
    i = this.aZw.a(paramf, this.aZB, true);
    if (i == -1)
    {
      AppMethodBeat.o(92041);
      return -1;
    }
    this.aZB -= i;
    if (this.aZB > 0)
    {
      AppMethodBeat.o(92041);
      return 0;
    }
    long l1 = this.aZz;
    long l2 = this.aZA * 1000000L / this.aZu.sampleRate;
    this.aZw.a(l2 + l1, 1, this.aZu.aTz, 0, null);
    this.aZA += this.aZu.aXb;
    this.aZB = 0;
    AppMethodBeat.o(92041);
    return 0;
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(92040);
    this.aXn = paramg;
    this.aZw = this.aXn.bh(0, 1);
    this.aXn.sL();
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
    this.aZx = 0;
    this.aZz = -9223372036854775807L;
    this.aZA = 0L;
    this.aZB = 0;
  }
  
  static abstract interface a
    extends l
  {
    public abstract long M(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.b
 * JD-Core Version:    0.7.0.1
 */