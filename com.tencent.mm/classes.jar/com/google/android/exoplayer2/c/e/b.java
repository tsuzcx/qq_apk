package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collections;

final class b
  extends h
{
  g bdZ;
  private a bea;
  
  public static boolean r(m paramm)
  {
    AppMethodBeat.i(92145);
    if ((paramm.vJ() >= 5) && (paramm.readUnsignedByte() == 127) && (paramm.df() == 1179402563L))
    {
      AppMethodBeat.o(92145);
      return true;
    }
    AppMethodBeat.o(92145);
    return false;
  }
  
  private static boolean t(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    if (paramArrayOfByte[0] == -1) {
      bool = true;
    }
    return bool;
  }
  
  protected final boolean a(m paramm, long paramLong, h.a parama)
  {
    int i = 0;
    AppMethodBeat.i(92148);
    Object localObject = paramm.data;
    if (this.bdZ == null)
    {
      this.bdZ = new g((byte[])localObject);
      paramm = Arrays.copyOfRange((byte[])localObject, 9, paramm.limit);
      paramm[4] = -128;
      paramm = Collections.singletonList(paramm);
      localObject = this.bdZ;
      i = ((g)localObject).bia;
      parama.aSv = Format.a(null, "audio/flac", -1, ((g)localObject).sampleRate * i, this.bdZ.channels, this.bdZ.sampleRate, paramm, null, null);
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(92148);
        return true;
        if ((localObject[0] & 0x7F) != 3) {
          break;
        }
        this.bea = new a();
        parama = this.bea;
        paramm.fl(1);
        int j = paramm.vL() / 18;
        parama.beb = new long[j];
        parama.bec = new long[j];
        while (i < j)
        {
          parama.beb[i] = paramm.readLong();
          parama.bec[i] = paramm.readLong();
          paramm.fl(2);
          i += 1;
        }
      }
    } while (!t((byte[])localObject));
    if (this.bea != null)
    {
      this.bea.firstFrameOffset = paramLong;
      parama.bey = this.bea;
    }
    AppMethodBeat.o(92148);
    return false;
  }
  
  protected final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(92146);
    super.reset(paramBoolean);
    if (paramBoolean)
    {
      this.bdZ = null;
      this.bea = null;
    }
    AppMethodBeat.o(92146);
  }
  
  protected final long s(m paramm)
  {
    int j = 1;
    AppMethodBeat.i(92147);
    if (!t(paramm.data))
    {
      AppMethodBeat.o(92147);
      return -1L;
    }
    int k = (paramm.data[2] & 0xFF) >> 4;
    int i;
    long l1;
    switch (k)
    {
    default: 
      i = -1;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      for (;;)
      {
        l1 = i;
        AppMethodBeat.o(92147);
        return l1;
        i = 192;
        continue;
        i = 576 << k - 2;
      }
    case 6: 
    case 7: 
      paramm.fl(4);
      l1 = paramm.data[paramm.position];
      i = 7;
      label169:
      if (i >= 0) {
        if ((1 << i & l1) == 0L) {
          if (i < 6)
          {
            l1 &= (1 << i) - 1;
            i = 7 - i;
          }
        }
      }
      break;
    }
    for (;;)
    {
      long l2 = l1;
      if (i == 0)
      {
        paramm = new NumberFormatException("Invalid UTF-8 sequence first byte: ".concat(String.valueOf(l1)));
        AppMethodBeat.o(92147);
        throw paramm;
        if (i != 7) {
          break label386;
        }
        i = 1;
        continue;
        i -= 1;
        break label169;
      }
      int m;
      do
      {
        l2 = l2 << 6 | m & 0x3F;
        j += 1;
        if (j >= i) {
          break;
        }
        m = paramm.data[(paramm.position + j)];
      } while ((m & 0xC0) == 128);
      paramm = new NumberFormatException("Invalid UTF-8 sequence continuation byte: ".concat(String.valueOf(l2)));
      AppMethodBeat.o(92147);
      throw paramm;
      paramm.position += i;
      if (k == 6) {}
      for (i = paramm.readUnsignedByte();; i = paramm.readUnsignedShort())
      {
        paramm.setPosition(0);
        i += 1;
        break;
      }
      i = 256 << k - 8;
      break;
      label386:
      i = 0;
    }
  }
  
  final class a
    implements f, l
  {
    long[] beb;
    long[] bec;
    private long bed = -1L;
    long firstFrameOffset = -1L;
    
    public a() {}
    
    public final long K(long paramLong)
    {
      AppMethodBeat.i(92144);
      paramLong = b.this.S(paramLong);
      int i = x.a(this.beb, paramLong, true);
      paramLong = this.firstFrameOffset;
      long l = this.bec[i];
      AppMethodBeat.o(92144);
      return l + paramLong;
    }
    
    public final long Q(long paramLong)
    {
      AppMethodBeat.i(92143);
      paramLong = b.this.S(paramLong);
      int i = x.a(this.beb, paramLong, true);
      this.bed = this.beb[i];
      AppMethodBeat.o(92143);
      return paramLong;
    }
    
    public final long getDurationUs()
    {
      g localg = b.this.bdZ;
      return localg.byR * 1000000L / localg.sampleRate;
    }
    
    public final long i(com.google.android.exoplayer2.c.f paramf)
    {
      if (this.bed >= 0L)
      {
        long l = -(this.bed + 2L);
        this.bed = -1L;
        return l;
      }
      return -1L;
    }
    
    public final boolean sH()
    {
      return true;
    }
    
    public final l sU()
    {
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.b
 * JD-Core Version:    0.7.0.1
 */