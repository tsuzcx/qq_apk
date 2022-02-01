package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;

final class j
  extends h
{
  private a cTh;
  private int cTi;
  private boolean cTj;
  private k.d cTk;
  private k.b cTl;
  
  public static boolean r(m paramm)
  {
    AppMethodBeat.i(92172);
    try
    {
      boolean bool = k.a(1, paramm, true);
      AppMethodBeat.o(92172);
      return bool;
    }
    catch (o paramm)
    {
      AppMethodBeat.o(92172);
    }
    return false;
  }
  
  protected final boolean a(m paramm, long paramLong, h.a parama)
  {
    AppMethodBeat.i(92176);
    if (this.cTh != null)
    {
      AppMethodBeat.o(92176);
      return false;
    }
    int i;
    long l;
    int j;
    int k;
    int m;
    int i1;
    int n;
    boolean bool1;
    if (this.cTk == null)
    {
      k.a(1, paramm, false);
      paramLong = paramm.UJ();
      i = paramm.readUnsignedByte();
      l = paramm.UJ();
      j = paramm.UK();
      k = paramm.UK();
      m = paramm.UK();
      i1 = paramm.readUnsignedByte();
      n = (int)Math.pow(2.0D, i1 & 0xF);
      i1 = (int)Math.pow(2.0D, (i1 & 0xF0) >> 4);
      if ((paramm.readUnsignedByte() & 0x1) > 0)
      {
        bool1 = true;
        this.cTk = new k.d(paramLong, i, l, j, k, m, n, i1, bool1, Arrays.copyOf(paramm.data, paramm.limit));
        paramm = null;
      }
    }
    for (;;)
    {
      this.cTh = paramm;
      if (this.cTh != null) {
        break label963;
      }
      AppMethodBeat.o(92176);
      return true;
      bool1 = false;
      break;
      Object localObject1;
      Object localObject2;
      if (this.cTl == null)
      {
        k.a(3, paramm, false);
        localObject1 = paramm.readString((int)paramm.UJ());
        i = ((String)localObject1).length();
        paramLong = paramm.UJ();
        localObject2 = new String[(int)paramLong];
        j = i + 11 + 4;
        i = 0;
        while (i < paramLong)
        {
          localObject2[i] = paramm.readString((int)paramm.UJ());
          j = j + 4 + localObject2[i].length();
          i += 1;
        }
        if ((paramm.readUnsignedByte() & 0x1) == 0)
        {
          paramm = new o("framing bit expected to be set");
          AppMethodBeat.o(92176);
          throw paramm;
        }
        this.cTl = new k.b((String)localObject1, (String[])localObject2, j + 1);
        paramm = null;
      }
      else
      {
        localObject1 = new byte[paramm.limit];
        System.arraycopy(paramm.data, 0, localObject1, 0, paramm.limit);
        n = this.cTk.channels;
        k.a(5, paramm, false);
        i1 = paramm.readUnsignedByte();
        localObject2 = new i(paramm.data);
        ((i)localObject2).hR(paramm.position * 8);
        i = 0;
        if (i < i1 + 1)
        {
          if (((i)localObject2).hQ(24) != 5653314)
          {
            paramm = new o("expected code book to start with [0x56, 0x43, 0x42] at " + (((i)localObject2).cTf * 8 + ((i)localObject2).cTg));
            AppMethodBeat.o(92176);
            throw paramm;
          }
          int i2 = ((i)localObject2).hQ(16);
          int i3 = ((i)localObject2).hQ(24);
          paramm = new long[i3];
          bool1 = ((i)localObject2).Sg();
          if (!bool1)
          {
            boolean bool2 = ((i)localObject2).Sg();
            j = 0;
            if (j < i3)
            {
              if ((bool2) && (!((i)localObject2).Sg())) {
                paramm[j] = 0L;
              }
              for (;;)
              {
                j += 1;
                break;
                paramm[j] = (((i)localObject2).hQ(5) + 1);
              }
            }
          }
          else
          {
            j = ((i)localObject2).hQ(5);
            k = 0;
            j += 1;
            while (k < i3)
            {
              int i4 = ((i)localObject2).hQ(k.hS(i3 - k));
              m = 0;
              while ((m < i4) && (k < i3))
              {
                paramm[k] = j;
                k += 1;
                m += 1;
              }
              j += 1;
            }
          }
          j = ((i)localObject2).hQ(4);
          if (j > 2)
          {
            paramm = new o("lookup type greater than 2 not decodable: ".concat(String.valueOf(j)));
            AppMethodBeat.o(92176);
            throw paramm;
          }
          if ((j == 1) || (j == 2))
          {
            ((i)localObject2).hR(32);
            ((i)localObject2).hR(32);
            k = ((i)localObject2).hQ(4);
            ((i)localObject2).hR(1);
            if (j != 1) {
              break label815;
            }
            if (i2 == 0) {
              break label810;
            }
            paramLong = i3;
            l = i2;
            paramLong = Math.floor(Math.pow(paramLong, 1.0D / l));
          }
          for (;;)
          {
            ((i)localObject2).hR((int)(paramLong * (k + 1)));
            new k.a(i2, i3, paramm, j, bool1);
            i += 1;
            break;
            label810:
            paramLong = 0L;
            continue;
            label815:
            paramLong = i3 * i2;
          }
        }
        j = ((i)localObject2).hQ(6);
        i = 0;
        while (i < j + 1)
        {
          if (((i)localObject2).hQ(16) != 0)
          {
            paramm = new o("placeholder of time domain transforms not zeroed out");
            AppMethodBeat.o(92176);
            throw paramm;
          }
          i += 1;
        }
        k.c((i)localObject2);
        k.b((i)localObject2);
        k.a(n, (i)localObject2);
        paramm = k.a((i)localObject2);
        if (!((i)localObject2).Sg())
        {
          paramm = new o("framing bit after modes not set as expected");
          AppMethodBeat.o(92176);
          throw paramm;
        }
        i = k.hS(paramm.length - 1);
        paramm = new a(this.cTk, this.cTl, (byte[])localObject1, paramm, i);
      }
    }
    label963:
    paramm = new ArrayList();
    paramm.add(this.cTh.cTm.data);
    paramm.add(this.cTh.cTn);
    parama.cHc = Format.a(null, "audio/vorbis", this.cTh.cTm.cTB, -1, this.cTh.cTm.channels, (int)this.cTh.cTm.sampleRate, paramm, null, null);
    AppMethodBeat.o(92176);
    return true;
  }
  
  protected final void cl(long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(92174);
    super.cl(paramLong);
    if (paramLong != 0L) {}
    for (boolean bool = true;; bool = false)
    {
      this.cTj = bool;
      if (this.cTk != null) {
        i = this.cTk.cTD;
      }
      this.cTi = i;
      AppMethodBeat.o(92174);
      return;
    }
  }
  
  protected final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(92173);
    super.reset(paramBoolean);
    if (paramBoolean)
    {
      this.cTh = null;
      this.cTk = null;
      this.cTl = null;
    }
    this.cTi = 0;
    this.cTj = false;
    AppMethodBeat.o(92173);
  }
  
  protected final long s(m paramm)
  {
    int j = 0;
    AppMethodBeat.i(92175);
    if ((paramm.data[0] & 0x1) == 1)
    {
      AppMethodBeat.o(92175);
      return -1L;
    }
    int i = paramm.data[0];
    a locala = this.cTh;
    int k = locala.cTp;
    if (!locala.cTo[(i >> 1 & 255 >>> 8 - k)].cTv) {}
    for (i = locala.cTm.cTD;; i = locala.cTm.cTE)
    {
      if (this.cTj) {
        j = (this.cTi + i) / 4;
      }
      long l = j;
      paramm.iG(paramm.limit + 4);
      paramm.data[(paramm.limit - 4)] = ((byte)(int)(l & 0xFF));
      paramm.data[(paramm.limit - 3)] = ((byte)(int)(l >>> 8 & 0xFF));
      paramm.data[(paramm.limit - 2)] = ((byte)(int)(l >>> 16 & 0xFF));
      paramm.data[(paramm.limit - 1)] = ((byte)(int)(l >>> 24 & 0xFF));
      this.cTj = true;
      this.cTi = i;
      l = j;
      AppMethodBeat.o(92175);
      return l;
    }
  }
  
  static final class a
  {
    public final k.b cTl;
    public final k.d cTm;
    public final byte[] cTn;
    public final k.c[] cTo;
    public final int cTp;
    
    public a(k.d paramd, k.b paramb, byte[] paramArrayOfByte, k.c[] paramArrayOfc, int paramInt)
    {
      this.cTm = paramd;
      this.cTl = paramb;
      this.cTn = paramArrayOfByte;
      this.cTo = paramArrayOfc;
      this.cTp = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.j
 * JD-Core Version:    0.7.0.1
 */