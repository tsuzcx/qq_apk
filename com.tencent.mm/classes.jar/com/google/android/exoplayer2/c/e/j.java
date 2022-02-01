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
  private a bpK;
  private int bpL;
  private boolean bpM;
  private k.d bpN;
  private k.b bpO;
  
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
  
  protected final void U(long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(92174);
    super.U(paramLong);
    if (paramLong != 0L) {}
    for (boolean bool = true;; bool = false)
    {
      this.bpM = bool;
      if (this.bpN != null) {
        i = this.bpN.bqg;
      }
      this.bpL = i;
      AppMethodBeat.o(92174);
      return;
    }
  }
  
  protected final boolean a(m paramm, long paramLong, h.a parama)
  {
    AppMethodBeat.i(92176);
    if (this.bpK != null)
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
    if (this.bpN == null)
    {
      k.a(1, paramm, false);
      paramLong = paramm.xg();
      i = paramm.readUnsignedByte();
      l = paramm.xg();
      j = paramm.xh();
      k = paramm.xh();
      m = paramm.xh();
      i1 = paramm.readUnsignedByte();
      n = (int)Math.pow(2.0D, i1 & 0xF);
      i1 = (int)Math.pow(2.0D, (i1 & 0xF0) >> 4);
      if ((paramm.readUnsignedByte() & 0x1) > 0)
      {
        bool1 = true;
        this.bpN = new k.d(paramLong, i, l, j, k, m, n, i1, bool1, Arrays.copyOf(paramm.data, paramm.limit));
        paramm = null;
      }
    }
    for (;;)
    {
      this.bpK = paramm;
      if (this.bpK != null) {
        break label959;
      }
      AppMethodBeat.o(92176);
      return true;
      bool1 = false;
      break;
      Object localObject1;
      Object localObject2;
      if (this.bpO == null)
      {
        k.a(3, paramm, false);
        localObject1 = paramm.readString((int)paramm.xg());
        i = ((String)localObject1).length();
        paramLong = paramm.xg();
        localObject2 = new String[(int)paramLong];
        j = i + 11 + 4;
        i = 0;
        while (i < paramLong)
        {
          localObject2[i] = paramm.readString((int)paramm.xg());
          j = j + 4 + localObject2[i].length();
          i += 1;
        }
        if ((paramm.readUnsignedByte() & 0x1) == 0)
        {
          paramm = new o("framing bit expected to be set");
          AppMethodBeat.o(92176);
          throw paramm;
        }
        this.bpO = new k.b((String)localObject1, (String[])localObject2, j + 1);
        paramm = null;
      }
      else
      {
        localObject1 = new byte[paramm.limit];
        System.arraycopy(paramm.data, 0, localObject1, 0, paramm.limit);
        n = this.bpN.channels;
        k.a(5, paramm, false);
        i1 = paramm.readUnsignedByte();
        localObject2 = new i(paramm.data);
        ((i)localObject2).en(paramm.position * 8);
        i = 0;
        if (i < i1 + 1)
        {
          if (((i)localObject2).em(24) != 5653314)
          {
            paramm = new o("expected code book to start with [0x56, 0x43, 0x42] at " + (((i)localObject2).bpI * 8 + ((i)localObject2).bpJ));
            AppMethodBeat.o(92176);
            throw paramm;
          }
          int i2 = ((i)localObject2).em(16);
          int i3 = ((i)localObject2).em(24);
          paramm = new long[i3];
          bool1 = ((i)localObject2).uI();
          if (!bool1)
          {
            boolean bool2 = ((i)localObject2).uI();
            j = 0;
            if (j < paramm.length)
            {
              if ((bool2) && (!((i)localObject2).uI())) {
                paramm[j] = 0L;
              }
              for (;;)
              {
                j += 1;
                break;
                paramm[j] = (((i)localObject2).em(5) + 1);
              }
            }
          }
          else
          {
            j = ((i)localObject2).em(5) + 1;
            k = 0;
            while (k < paramm.length)
            {
              int i4 = ((i)localObject2).em(k.eo(i3 - k));
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
          j = ((i)localObject2).em(4);
          if (j > 2)
          {
            paramm = new o("lookup type greater than 2 not decodable: ".concat(String.valueOf(j)));
            AppMethodBeat.o(92176);
            throw paramm;
          }
          if ((j == 1) || (j == 2))
          {
            ((i)localObject2).en(32);
            ((i)localObject2).en(32);
            k = ((i)localObject2).em(4);
            ((i)localObject2).en(1);
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
            ((i)localObject2).en((int)(paramLong * (k + 1)));
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
        j = ((i)localObject2).em(6);
        i = 0;
        while (i < j + 1)
        {
          if (((i)localObject2).em(16) != 0)
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
        if (!((i)localObject2).uI())
        {
          paramm = new o("framing bit after modes not set as expected");
          AppMethodBeat.o(92176);
          throw paramm;
        }
        i = k.eo(paramm.length - 1);
        paramm = new a(this.bpN, this.bpO, (byte[])localObject1, paramm, i);
      }
    }
    label959:
    paramm = new ArrayList();
    paramm.add(this.bpK.bpP.data);
    paramm.add(this.bpK.bpQ);
    parama.bdF = Format.a(null, "audio/vorbis", this.bpK.bpP.bqe, -1, this.bpK.bpP.channels, (int)this.bpK.bpP.sampleRate, paramm, null, null);
    AppMethodBeat.o(92176);
    return true;
  }
  
  protected final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(92173);
    super.reset(paramBoolean);
    if (paramBoolean)
    {
      this.bpK = null;
      this.bpN = null;
      this.bpO = null;
    }
    this.bpL = 0;
    this.bpM = false;
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
    a locala = this.bpK;
    int k = locala.bpS;
    if (!locala.bpR[(i >> 1 & 255 >>> 8 - k)].bpY) {}
    for (i = locala.bpP.bqg;; i = locala.bpP.bqh)
    {
      if (this.bpM) {
        j = (this.bpL + i) / 4;
      }
      long l = j;
      paramm.eY(paramm.limit + 4);
      paramm.data[(paramm.limit - 4)] = ((byte)(int)(l & 0xFF));
      paramm.data[(paramm.limit - 3)] = ((byte)(int)(l >>> 8 & 0xFF));
      paramm.data[(paramm.limit - 2)] = ((byte)(int)(l >>> 16 & 0xFF));
      paramm.data[(paramm.limit - 1)] = ((byte)(int)(l >>> 24 & 0xFF));
      this.bpM = true;
      this.bpL = i;
      l = j;
      AppMethodBeat.o(92175);
      return l;
    }
  }
  
  static final class a
  {
    public final k.b bpO;
    public final k.d bpP;
    public final byte[] bpQ;
    public final k.c[] bpR;
    public final int bpS;
    
    public a(k.d paramd, k.b paramb, byte[] paramArrayOfByte, k.c[] paramArrayOfc, int paramInt)
    {
      this.bpP = paramd;
      this.bpO = paramb;
      this.bpQ = paramArrayOfByte;
      this.bpR = paramArrayOfc;
      this.bpS = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.j
 * JD-Core Version:    0.7.0.1
 */