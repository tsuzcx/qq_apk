package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class b
{
  public final List<byte[]> bdv;
  public final int biG;
  
  private b(List<byte[]> paramList, int paramInt)
  {
    this.bdv = paramList;
    this.biG = paramInt;
  }
  
  public static b M(m paramm)
  {
    AppMethodBeat.i(93266);
    for (;;)
    {
      int j;
      int i;
      try
      {
        paramm.fa(21);
        int n = paramm.readUnsignedByte();
        int i1 = paramm.readUnsignedByte();
        int m = paramm.position;
        j = 0;
        i = 0;
        if (j < i1)
        {
          paramm.fa(1);
          i2 = paramm.readUnsignedShort();
          k = 0;
          if (k >= i2) {
            break label242;
          }
          i3 = paramm.readUnsignedShort();
          i += i3 + 4;
          paramm.fa(i3);
          k += 1;
          continue;
        }
        paramm.setPosition(m);
        arrayOfByte = new byte[i];
        j = 0;
        m = 0;
        if (j >= i1) {
          break label256;
        }
        paramm.fa(1);
        int i2 = paramm.readUnsignedShort();
        int k = 0;
        if (k >= i2) {
          break label249;
        }
        int i3 = paramm.readUnsignedShort();
        System.arraycopy(k.bGC, 0, arrayOfByte, m, k.bGC.length);
        m += k.bGC.length;
        System.arraycopy(paramm.data, paramm.position, arrayOfByte, m, i3);
        m += i3;
        paramm.fa(i3);
        k += 1;
        continue;
        paramm = new b(paramm, (n & 0x3) + 1);
        AppMethodBeat.o(93266);
        return paramm;
      }
      catch (ArrayIndexOutOfBoundsException paramm)
      {
        byte[] arrayOfByte;
        paramm = new o("Error parsing HEVC config", paramm);
        AppMethodBeat.o(93266);
        throw paramm;
      }
      paramm = Collections.singletonList(arrayOfByte);
      continue;
      label242:
      j += 1;
      continue;
      label249:
      j += 1;
      continue;
      label256:
      if (i == 0) {
        paramm = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.video.b
 * JD-Core Version:    0.7.0.1
 */