package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collections;

final class b
  extends h
{
  g aIH;
  private b.a aII;
  
  private static boolean o(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    if (paramArrayOfByte[0] == -1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean r(m paramm)
  {
    AppMethodBeat.i(95029);
    if ((paramm.qM() >= 5) && (paramm.readUnsignedByte() == 127) && (paramm.cc() == 1179402563L))
    {
      AppMethodBeat.o(95029);
      return true;
    }
    AppMethodBeat.o(95029);
    return false;
  }
  
  protected final boolean a(m paramm, long paramLong, h.a parama)
  {
    int i = 0;
    AppMethodBeat.i(95032);
    Object localObject = paramm.data;
    if (this.aIH == null)
    {
      this.aIH = new g((byte[])localObject);
      paramm = Arrays.copyOfRange((byte[])localObject, 9, paramm.limit);
      paramm[4] = -128;
      paramm = Collections.singletonList(paramm);
      localObject = this.aIH;
      i = ((g)localObject).aMB;
      parama.axd = Format.a(null, "audio/flac", -1, ((g)localObject).sampleRate * i, this.aIH.channels, this.aIH.sampleRate, paramm, null, null);
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(95032);
        return true;
        if ((localObject[0] & 0x7F) != 3) {
          break;
        }
        this.aII = new b.a(this);
        parama = this.aII;
        paramm.en(1);
        int j = paramm.qO() / 18;
        parama.aIJ = new long[j];
        parama.aIK = new long[j];
        while (i < j)
        {
          parama.aIJ[i] = paramm.readLong();
          parama.aIK[i] = paramm.readLong();
          paramm.en(2);
          i += 1;
        }
      }
    } while (!o((byte[])localObject));
    if (this.aII != null)
    {
      this.aII.firstFrameOffset = paramLong;
      parama.aJf = this.aII;
    }
    AppMethodBeat.o(95032);
    return false;
  }
  
  protected final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(95030);
    super.reset(paramBoolean);
    if (paramBoolean)
    {
      this.aIH = null;
      this.aII = null;
    }
    AppMethodBeat.o(95030);
  }
  
  protected final long s(m paramm)
  {
    int j = 1;
    AppMethodBeat.i(95031);
    if (!o(paramm.data))
    {
      AppMethodBeat.o(95031);
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
        AppMethodBeat.o(95031);
        return l1;
        i = 192;
        continue;
        i = 576 << k - 2;
      }
    case 6: 
    case 7: 
      paramm.en(4);
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
        AppMethodBeat.o(95031);
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
      AppMethodBeat.o(95031);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.b
 * JD-Core Version:    0.7.0.1
 */