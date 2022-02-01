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
  public static final h cLL;
  private static final int cNQ;
  private static final int cNR;
  private static final int cNS;
  private Metadata cGL;
  private final com.google.android.exoplayer2.i.m cLN;
  private g cLR;
  private final long cNT;
  private final j cNU;
  private final i cNV;
  private com.google.android.exoplayer2.c.m cNW;
  private int cNX;
  private b.a cNY;
  private long cNZ;
  private long cOa;
  private int cOb;
  private final int flags;
  
  static
  {
    AppMethodBeat.i(92045);
    cLL = new h()
    {
      public final e[] RV()
      {
        AppMethodBeat.i(92037);
        b localb = new b();
        AppMethodBeat.o(92037);
        return new e[] { localb };
      }
    };
    cNQ = x.du("Xing");
    cNR = x.du("Info");
    cNS = x.du("VBRI");
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
    this.cNT = paramLong;
    this.cLN = new com.google.android.exoplayer2.i.m(10);
    this.cNU = new j();
    this.cNV = new i();
    this.cNZ = -9223372036854775807L;
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
      paramf.RS();
      if (paramf.getPosition() != 0L) {
        break label326;
      }
      e(paramf);
      n = (int)paramf.RT();
      if (!paramBoolean) {
        paramf.eP(n);
      }
      k = 0;
      i = 0;
      j = 0;
    }
    for (;;)
    {
      label65:
      byte[] arrayOfByte = this.cLN.data;
      boolean bool;
      if (j > 0) {
        bool = true;
      }
      for (;;)
      {
        if (paramf.b(arrayOfByte, 0, 4, bool))
        {
          this.cLN.setPosition(0);
          int i1 = this.cLN.readInt();
          int i2;
          if ((i == 0) || (j(i1, i)))
          {
            i2 = j.hA(i1);
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
              paramf.RS();
              paramf.hu(n + i);
              k = i;
              i = 0;
              j = 0;
              break label65;
            }
            paramf.eP(1);
            k = i;
            i = 0;
            j = 0;
            break label65;
          }
          j += 1;
          if (j == 1)
          {
            j.a(i1, this.cNU);
            i = i1;
          }
          while (j != 4)
          {
            paramf.hu(i2 - 4);
            break;
          }
        }
      }
      if (paramBoolean) {
        paramf.eP(n + k);
      }
      for (;;)
      {
        this.cNX = i;
        AppMethodBeat.o(92042);
        return true;
        paramf.RS();
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
    paramf.b(this.cLN.data, 0, 10);
    this.cLN.setPosition(0);
    if (this.cLN.UI() == com.google.android.exoplayer2.metadata.id3.a.cTG)
    {
      this.cLN.iH(3);
      int j = this.cLN.UM();
      int k = j + 10;
      a.a locala;
      if (this.cGL == null)
      {
        byte[] arrayOfByte = new byte[k];
        System.arraycopy(this.cLN.data, 0, arrayOfByte, 0, 10);
        paramf.b(arrayOfByte, 10, j);
        if ((this.flags & 0x2) != 0)
        {
          locala = i.cLw;
          label120:
          this.cGL = new com.google.android.exoplayer2.metadata.id3.a(locala).d(arrayOfByte, k);
          if (this.cGL != null) {
            this.cNV.c(this.cGL);
          }
        }
      }
      for (;;)
      {
        i += k;
        break;
        locala = null;
        break label120;
        paramf.hu(j);
      }
    }
    paramf.RS();
    paramf.hu(i);
    AppMethodBeat.o(92043);
  }
  
  private b.a f(f paramf)
  {
    AppMethodBeat.i(92044);
    paramf.b(this.cLN.data, 0, 4);
    this.cLN.setPosition(0);
    j.a(this.cLN.readInt(), this.cNU);
    paramf = new a(paramf.getPosition(), this.cNU.bitrate, paramf.RU());
    AppMethodBeat.o(92044);
    return paramf;
  }
  
  private static boolean j(int paramInt, long paramLong)
  {
    return (0xFFFE0C00 & paramInt) == (0xFFFE0C00 & paramLong);
  }
  
  public final void C(long paramLong1, long paramLong2)
  {
    this.cNX = 0;
    this.cNZ = -9223372036854775807L;
    this.cOa = 0L;
    this.cOb = 0;
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(92041);
    if (this.cNX == 0) {}
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
        if (this.cNY == null)
        {
          paramk = new com.google.android.exoplayer2.i.m(this.cNU.cIf);
          paramf.b(paramk.data, 0, this.cNU.cIf);
          if ((this.cNU.version & 0x1) == 0) {
            break label568;
          }
          if (this.cNU.channels != 1)
          {
            i = 36;
            if (paramk.limit < i + 4) {
              break label591;
            }
            paramk.setPosition(i);
            j = paramk.readInt();
            if ((j != cNQ) && (j != cNR)) {
              break label591;
            }
            if ((j != cNQ) && (j != cNR)) {
              break label748;
            }
            localObject1 = this.cNU;
            l2 = paramf.getPosition();
            l1 = paramf.RU();
            k = ((j)localObject1).cLF;
            m = ((j)localObject1).sampleRate;
            l2 += ((j)localObject1).cIf;
            n = paramk.readInt();
            if ((n & 0x1) == 1)
            {
              i1 = paramk.UN();
              if (i1 != 0) {
                break label630;
              }
            }
            paramk = null;
            if ((paramk != null) && (!this.cNV.RX()))
            {
              paramf.RS();
              paramf.hu(i + 141);
              paramf.b(this.cLN.data, 0, 3);
              this.cLN.setPosition(0);
              localObject1 = this.cNV;
              k = this.cLN.UI();
              i = k >> 12;
              k &= 0xFFF;
              if ((i > 0) || (k > 0))
              {
                ((i)localObject1).cGW = i;
                ((i)localObject1).cGX = k;
              }
            }
            paramf.eP(this.cNU.cIf);
            localObject1 = paramk;
            if (paramk != null)
            {
              localObject1 = paramk;
              if (!paramk.RR())
              {
                localObject1 = paramk;
                if (j == cNR) {
                  localObject1 = f(paramf);
                }
              }
            }
            this.cNY = ((b.a)localObject1);
            if ((this.cNY == null) || ((!this.cNY.RR()) && ((this.flags & 0x1) != 0))) {
              this.cNY = f(paramf);
            }
            this.cLR.a(this.cNY);
            localObject1 = this.cNW;
            localObject2 = this.cNU.mimeType;
            i = this.cNU.channels;
            j = this.cNU.sampleRate;
            k = this.cNV.cGW;
            m = this.cNV.cGX;
            if ((this.flags & 0x2) == 0) {
              break label1094;
            }
            paramk = null;
            ((com.google.android.exoplayer2.c.m)localObject1).f(Format.a(null, (String)localObject2, null, -1, 4096, i, j, -1, k, m, null, null, 0, null, paramk));
          }
        }
        else
        {
          if (this.cOb != 0) {
            break label1250;
          }
          paramf.RS();
          if (paramf.b(this.cLN.data, 0, 4, true)) {
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
      if (this.cNU.channels != 1)
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
          if (paramk.readInt() == cNS)
          {
            j = cNS;
            continue;
          }
        }
        j = 0;
        continue;
        label630:
        long l3 = x.c(i1, k * 1000000L, m);
        if ((n & 0x6) != 6)
        {
          paramk = new d(l2, l3, l1);
        }
        else
        {
          long l4 = paramk.UN();
          paramk.iH(1);
          localObject2 = new long[99];
          k = 0;
          while (k < 99)
          {
            localObject2[k] = paramk.readUnsignedByte();
            k += 1;
          }
          paramk = new d(l2, l3, l1, (long[])localObject2, l4, ((j)localObject1).cIf);
          continue;
          label748:
          if (j == cNS)
          {
            localObject1 = this.cNU;
            l1 = paramf.getPosition();
            l3 = paramf.RU();
            paramk.iH(10);
            i = paramk.readInt();
            if (i <= 0) {
              localObject1 = null;
            }
            for (;;)
            {
              paramf.eP(this.cNU.cIf);
              break;
              j = ((j)localObject1).sampleRate;
              l2 = i;
              if (j >= 32000) {}
              for (i = 1152;; i = 576)
              {
                l4 = x.c(l2, i * 1000000L, j);
                k = paramk.readUnsignedShort();
                m = paramk.readUnsignedShort();
                n = paramk.readUnsignedShort();
                paramk.iH(2);
                l1 += ((j)localObject1).cIf;
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
                i = paramk.UI();
                break label974;
                i = paramk.UN();
                break label974;
              }
              localObject1 = new c((long[])localObject1, (long[])localObject2, l4);
            }
          }
          label974:
          localObject1 = null;
          paramf.RS();
          continue;
          label1094:
          paramk = this.cGL;
        }
      }
    }
    this.cLN.setPosition(0);
    int i = this.cLN.readInt();
    if ((!j(i, this.cNX)) || (j.hA(i) == -1))
    {
      paramf.eP(1);
      this.cNX = 0;
      AppMethodBeat.o(92041);
      return 0;
    }
    j.a(i, this.cNU);
    if (this.cNZ == -9223372036854775807L)
    {
      this.cNZ = this.cNY.ce(paramf.getPosition());
      if (this.cNT != -9223372036854775807L)
      {
        l1 = this.cNY.ce(0L);
        l2 = this.cNZ;
        this.cNZ = (this.cNT - l1 + l2);
      }
    }
    this.cOb = this.cNU.cIf;
    label1250:
    i = this.cNW.a(paramf, this.cOb, true);
    if (i == -1)
    {
      AppMethodBeat.o(92041);
      return -1;
    }
    this.cOb -= i;
    if (this.cOb > 0)
    {
      AppMethodBeat.o(92041);
      return 0;
    }
    long l1 = this.cNZ;
    long l2 = this.cOa * 1000000L / this.cNU.sampleRate;
    this.cNW.a(l2 + l1, 1, this.cNU.cIf, 0, null);
    this.cOa += this.cNU.cLF;
    this.cOb = 0;
    AppMethodBeat.o(92041);
    return 0;
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(92040);
    this.cLR = paramg;
    this.cNW = this.cLR.hz(0);
    this.cLR.RW();
    AppMethodBeat.o(92040);
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(92039);
    boolean bool = a(paramf, true);
    AppMethodBeat.o(92039);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.b
 * JD-Core Version:    0.7.0.1
 */