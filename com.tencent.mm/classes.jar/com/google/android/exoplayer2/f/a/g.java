package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.j;

public final class g
{
  public static void a(long paramLong, j paramj, k[] paramArrayOfk)
  {
    while (paramj.oe() > 1)
    {
      int i = e(paramj);
      int j = e(paramj);
      if ((j == -1) || (j > paramj.oe()))
      {
        paramj.setPosition(paramj.limit);
      }
      else
      {
        if ((i != 4) || (j < 8)) {
          i = 0;
        }
        for (;;)
        {
          if (i != 0)
          {
            paramj.dB(8);
            int k = paramj.readUnsignedByte() & 0x1F;
            paramj.dB(1);
            int m = k * 3;
            int n = paramj.position;
            int i1 = paramArrayOfk.length;
            i = 0;
            for (;;)
            {
              if (i < i1)
              {
                k localk = paramArrayOfk[i];
                paramj.setPosition(n);
                localk.a(paramj, m);
                localk.a(paramLong, 1, m, 0, null);
                i += 1;
                continue;
                i = paramj.position;
                k = paramj.readUnsignedByte();
                m = paramj.readUnsignedShort();
                n = paramj.readInt();
                i1 = paramj.readUnsignedByte();
                paramj.setPosition(i);
                if ((k == 181) && (m == 49) && (n == 1195456820) && (i1 == 3))
                {
                  i = 1;
                  break;
                }
                i = 0;
                break;
              }
            }
            paramj.dB(j - (k * 3 + 10));
            break;
          }
        }
        paramj.dB(j);
      }
    }
  }
  
  private static int e(j paramj)
  {
    int i = 0;
    int k;
    int j;
    do
    {
      if (paramj.oe() == 0) {
        return -1;
      }
      k = paramj.readUnsignedByte();
      j = i + k;
      i = j;
    } while (k == 255);
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.g
 * JD-Core Version:    0.7.0.1
 */