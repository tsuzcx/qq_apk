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
  private j.a aJp;
  private int aJq;
  private boolean aJr;
  private k.d aJs;
  private k.b aJt;
  
  public static boolean r(m paramm)
  {
    AppMethodBeat.i(95056);
    try
    {
      boolean bool = k.a(1, paramm, true);
      AppMethodBeat.o(95056);
      return bool;
    }
    catch (o paramm)
    {
      AppMethodBeat.o(95056);
    }
    return false;
  }
  
  protected final void N(long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(95058);
    super.N(paramLong);
    if (paramLong != 0L) {}
    for (boolean bool = true;; bool = false)
    {
      this.aJr = bool;
      if (this.aJs != null) {
        i = this.aJs.aJL;
      }
      this.aJq = i;
      AppMethodBeat.o(95058);
      return;
    }
  }
  
  protected final boolean a(m paramm, long paramLong, h.a parama)
  {
    AppMethodBeat.i(95060);
    if (this.aJp != null)
    {
      AppMethodBeat.o(95060);
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
    if (this.aJs == null)
    {
      k.a(1, paramm, false);
      paramLong = paramm.qP();
      i = paramm.readUnsignedByte();
      l = paramm.qP();
      j = paramm.qQ();
      k = paramm.qQ();
      m = paramm.qQ();
      i1 = paramm.readUnsignedByte();
      n = (int)Math.pow(2.0D, i1 & 0xF);
      i1 = (int)Math.pow(2.0D, (i1 & 0xF0) >> 4);
      if ((paramm.readUnsignedByte() & 0x1) > 0)
      {
        bool1 = true;
        this.aJs = new k.d(paramLong, i, l, j, k, m, n, i1, bool1, Arrays.copyOf(paramm.data, paramm.limit));
        paramm = null;
      }
    }
    for (;;)
    {
      this.aJp = paramm;
      if (this.aJp != null) {
        break label959;
      }
      AppMethodBeat.o(95060);
      return true;
      bool1 = false;
      break;
      Object localObject1;
      Object localObject2;
      if (this.aJt == null)
      {
        k.a(3, paramm, false);
        localObject1 = paramm.readString((int)paramm.qP());
        i = ((String)localObject1).length();
        paramLong = paramm.qP();
        localObject2 = new String[(int)paramLong];
        j = i + 11 + 4;
        i = 0;
        while (i < paramLong)
        {
          localObject2[i] = paramm.readString((int)paramm.qP());
          j = j + 4 + localObject2[i].length();
          i += 1;
        }
        if ((paramm.readUnsignedByte() & 0x1) == 0)
        {
          paramm = new o("framing bit expected to be set");
          AppMethodBeat.o(95060);
          throw paramm;
        }
        this.aJt = new k.b((String)localObject1, (String[])localObject2, j + 1);
        paramm = null;
      }
      else
      {
        localObject1 = new byte[paramm.limit];
        System.arraycopy(paramm.data, 0, localObject1, 0, paramm.limit);
        n = this.aJs.channels;
        k.a(5, paramm, false);
        i1 = paramm.readUnsignedByte();
        localObject2 = new i(paramm.data);
        ((i)localObject2).dE(paramm.position * 8);
        i = 0;
        if (i < i1 + 1)
        {
          if (((i)localObject2).dD(24) != 5653314)
          {
            paramm = new o("expected code book to start with [0x56, 0x43, 0x42] at " + (((i)localObject2).aJn * 8 + ((i)localObject2).aJo));
            AppMethodBeat.o(95060);
            throw paramm;
          }
          int i2 = ((i)localObject2).dD(16);
          int i3 = ((i)localObject2).dD(24);
          paramm = new long[i3];
          bool1 = ((i)localObject2).oj();
          if (!bool1)
          {
            boolean bool2 = ((i)localObject2).oj();
            j = 0;
            if (j < paramm.length)
            {
              if ((bool2) && (!((i)localObject2).oj())) {
                paramm[j] = 0L;
              }
              for (;;)
              {
                j += 1;
                break;
                paramm[j] = (((i)localObject2).dD(5) + 1);
              }
            }
          }
          else
          {
            j = ((i)localObject2).dD(5) + 1;
            k = 0;
            while (k < paramm.length)
            {
              int i4 = ((i)localObject2).dD(k.dF(i3 - k));
              m = 0;
              while ((m < i4) && (k < paramm.length))
              {
                paramm[k] = j;
                k += 1;
                m += 1;
              }
              j += 1;
            }
          }
          j = ((i)localObject2).dD(4);
          if (j > 2)
          {
            paramm = new o("lookup type greater than 2 not decodable: ".concat(String.valueOf(j)));
            AppMethodBeat.o(95060);
            throw paramm;
          }
          if ((j == 1) || (j == 2))
          {
            ((i)localObject2).dE(32);
            ((i)localObject2).dE(32);
            k = ((i)localObject2).dD(4);
            ((i)localObject2).dE(1);
            if (j != 1) {
              break label811;
            }
            if (i2 == 0) {
              break label806;
            }
            paramLong = i3;
            l = i2;
            paramLong = Math.floor(Math.pow(paramLong, 1.0D / l));
          }
          for (;;)
          {
            ((i)localObject2).dE((int)(paramLong * (k + 1)));
            new k.a(i2, i3, paramm, j, bool1);
            i += 1;
            break;
            label806:
            paramLong = 0L;
            continue;
            label811:
            paramLong = i3 * i2;
          }
        }
        j = ((i)localObject2).dD(6);
        i = 0;
        while (i < j + 1)
        {
          if (((i)localObject2).dD(16) != 0)
          {
            paramm = new o("placeholder of time domain transforms not zeroed out");
            AppMethodBeat.o(95060);
            throw paramm;
          }
          i += 1;
        }
        k.c((i)localObject2);
        k.b((i)localObject2);
        k.a(n, (i)localObject2);
        paramm = k.a((i)localObject2);
        if (!((i)localObject2).oj())
        {
          paramm = new o("framing bit after modes not set as expected");
          AppMethodBeat.o(95060);
          throw paramm;
        }
        i = k.dF(paramm.length - 1);
        paramm = new j.a(this.aJs, this.aJt, (byte[])localObject1, paramm, i);
      }
    }
    label959:
    paramm = new ArrayList();
    paramm.add(this.aJp.aJu.data);
    paramm.add(this.aJp.aJv);
    parama.axd = Format.a(null, "audio/vorbis", this.aJp.aJu.aJJ, -1, this.aJp.aJu.channels, (int)this.aJp.aJu.sampleRate, paramm, null, null);
    AppMethodBeat.o(95060);
    return true;
  }
  
  protected final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(95057);
    super.reset(paramBoolean);
    if (paramBoolean)
    {
      this.aJp = null;
      this.aJs = null;
      this.aJt = null;
    }
    this.aJq = 0;
    this.aJr = false;
    AppMethodBeat.o(95057);
  }
  
  protected final long s(m paramm)
  {
    int j = 0;
    AppMethodBeat.i(95059);
    if ((paramm.data[0] & 0x1) == 1)
    {
      AppMethodBeat.o(95059);
      return -1L;
    }
    int i = paramm.data[0];
    j.a locala = this.aJp;
    int k = locala.aJx;
    if (!locala.aJw[(i >> 1 & 255 >>> 8 - k)].aJE) {}
    for (i = locala.aJu.aJL;; i = locala.aJu.aJM)
    {
      if (this.aJr) {
        j = (this.aJq + i) / 4;
      }
      long l = j;
      paramm.em(paramm.limit + 4);
      paramm.data[(paramm.limit - 4)] = ((byte)(int)(l & 0xFF));
      paramm.data[(paramm.limit - 3)] = ((byte)(int)(l >>> 8 & 0xFF));
      paramm.data[(paramm.limit - 2)] = ((byte)(int)(l >>> 16 & 0xFF));
      paramm.data[(paramm.limit - 1)] = ((byte)(int)(l >>> 24 & 0xFF));
      this.aJr = true;
      this.aJq = i;
      l = j;
      AppMethodBeat.o(95059);
      return l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.j
 * JD-Core Version:    0.7.0.1
 */