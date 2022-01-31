package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.o;
import java.util.Collections;
import java.util.List;

public final class b
{
  public final int aBL;
  public final List<byte[]> auu;
  
  private b(List<byte[]> paramList, int paramInt)
  {
    this.auu = paramList;
    this.aBL = paramInt;
  }
  
  public static b o(j paramj)
  {
    for (;;)
    {
      int j;
      int i;
      try
      {
        paramj.dB(21);
        int n = paramj.readUnsignedByte();
        int i1 = paramj.readUnsignedByte();
        int m = paramj.position;
        j = 0;
        i = 0;
        if (j < i1)
        {
          paramj.dB(1);
          i2 = paramj.readUnsignedShort();
          k = 0;
          if (k >= i2) {
            break label223;
          }
          i3 = paramj.readUnsignedShort();
          i += i3 + 4;
          paramj.dB(i3);
          k += 1;
          continue;
        }
        paramj.setPosition(m);
        arrayOfByte = new byte[i];
        j = 0;
        m = 0;
        if (j >= i1) {
          break label237;
        }
        paramj.dB(1);
        int i2 = paramj.readUnsignedShort();
        int k = 0;
        if (k >= i2) {
          break label230;
        }
        int i3 = paramj.readUnsignedShort();
        System.arraycopy(h.aSg, 0, arrayOfByte, m, h.aSg.length);
        m += h.aSg.length;
        System.arraycopy(paramj.data, paramj.position, arrayOfByte, m, i3);
        m += i3;
        paramj.dB(i3);
        k += 1;
        continue;
        return new b(paramj, (n & 0x3) + 1);
      }
      catch (ArrayIndexOutOfBoundsException paramj)
      {
        byte[] arrayOfByte;
        throw new o("Error parsing HEVC config", paramj);
      }
      paramj = Collections.singletonList(arrayOfByte);
      continue;
      label223:
      j += 1;
      continue;
      label230:
      j += 1;
      continue;
      label237:
      if (i == 0) {
        paramj = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.video.b
 * JD-Core Version:    0.7.0.1
 */