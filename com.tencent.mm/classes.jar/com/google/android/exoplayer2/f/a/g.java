package com.google.android.exoplayer2.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  private static int A(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(95620);
    int i = 0;
    int k;
    int j;
    do
    {
      if (paramm.qM() == 0)
      {
        AppMethodBeat.o(95620);
        return -1;
      }
      k = paramm.readUnsignedByte();
      j = i + k;
      i = j;
    } while (k == 255);
    AppMethodBeat.o(95620);
    return j;
  }
  
  public static void a(long paramLong, com.google.android.exoplayer2.i.m paramm, com.google.android.exoplayer2.c.m[] paramArrayOfm)
  {
    AppMethodBeat.i(95619);
    while (paramm.qM() > 1)
    {
      int i = A(paramm);
      int j = A(paramm);
      if ((j == -1) || (j > paramm.qM()))
      {
        paramm.setPosition(paramm.limit);
      }
      else if (a(i, j, paramm))
      {
        paramm.en(8);
        int k = paramm.readUnsignedByte() & 0x1F;
        paramm.en(1);
        int m = k * 3;
        int n = paramm.position;
        int i1 = paramArrayOfm.length;
        i = 0;
        while (i < i1)
        {
          com.google.android.exoplayer2.c.m localm = paramArrayOfm[i];
          paramm.setPosition(n);
          localm.a(paramm, m);
          localm.a(paramLong, 1, m, 0, null);
          i += 1;
        }
        paramm.en(j - (k * 3 + 10));
      }
      else
      {
        paramm.en(j);
      }
    }
    AppMethodBeat.o(95619);
  }
  
  private static boolean a(int paramInt1, int paramInt2, com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(95621);
    if ((paramInt1 != 4) || (paramInt2 < 8))
    {
      AppMethodBeat.o(95621);
      return false;
    }
    paramInt1 = paramm.position;
    paramInt2 = paramm.readUnsignedByte();
    int i = paramm.readUnsignedShort();
    int j = paramm.readInt();
    int k = paramm.readUnsignedByte();
    paramm.setPosition(paramInt1);
    if ((paramInt2 == 181) && (i == 49) && (j == 1195456820) && (k == 3))
    {
      AppMethodBeat.o(95621);
      return true;
    }
    AppMethodBeat.o(95621);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.g
 * JD-Core Version:    0.7.0.1
 */