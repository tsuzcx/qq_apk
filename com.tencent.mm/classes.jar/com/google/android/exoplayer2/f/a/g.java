package com.google.android.exoplayer2.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  private static int A(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92788);
    int i = 0;
    int k;
    int j;
    do
    {
      if (paramm.xd() == 0)
      {
        AppMethodBeat.o(92788);
        return -1;
      }
      k = paramm.readUnsignedByte();
      j = i + k;
      i = j;
    } while (k == 255);
    AppMethodBeat.o(92788);
    return j;
  }
  
  public static void a(long paramLong, com.google.android.exoplayer2.i.m paramm, com.google.android.exoplayer2.c.m[] paramArrayOfm)
  {
    AppMethodBeat.i(92787);
    while (paramm.xd() > 1)
    {
      int i = A(paramm);
      int j = A(paramm);
      if ((j == -1) || (j > paramm.xd()))
      {
        paramm.setPosition(paramm.limit);
      }
      else if (a(i, j, paramm))
      {
        paramm.eZ(8);
        int k = paramm.readUnsignedByte() & 0x1F;
        paramm.eZ(1);
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
        paramm.eZ(j - (k * 3 + 10));
      }
      else
      {
        paramm.eZ(j);
      }
    }
    AppMethodBeat.o(92787);
  }
  
  private static boolean a(int paramInt1, int paramInt2, com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92789);
    if ((paramInt1 != 4) || (paramInt2 < 8))
    {
      AppMethodBeat.o(92789);
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
      AppMethodBeat.o(92789);
      return true;
    }
    AppMethodBeat.o(92789);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.g
 * JD-Core Version:    0.7.0.1
 */