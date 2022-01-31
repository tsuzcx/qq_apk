package com.google.android.exoplayer2.i;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  private static final byte[] baF = { 0, 0, 0, 1 };
  private static final int[] baG = { 96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350 };
  private static final int[] baH = { 0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1 };
  
  private static int c(l paraml)
  {
    AppMethodBeat.i(95866);
    int j = paraml.dD(5);
    int i = j;
    if (j == 31) {
      i = paraml.dD(6) + 32;
    }
    AppMethodBeat.o(95866);
    return i;
  }
  
  private static int d(l paraml)
  {
    AppMethodBeat.i(95867);
    int i = paraml.dD(4);
    if (i == 15)
    {
      i = paraml.dD(24);
      AppMethodBeat.o(95867);
      return i;
    }
    if (i < 13) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkArgument(bool);
      i = baG[i];
      break;
    }
  }
  
  public static byte[] j(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95865);
    byte[] arrayOfByte = new byte[baF.length + paramInt2];
    System.arraycopy(baF, 0, arrayOfByte, 0, baF.length);
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, baF.length, paramInt2);
    AppMethodBeat.o(95865);
    return arrayOfByte;
  }
  
  public static Pair<Integer, Integer> p(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95864);
    paramArrayOfByte = new l(paramArrayOfByte);
    int m = c(paramArrayOfByte);
    int i = d(paramArrayOfByte);
    int k = paramArrayOfByte.dD(4);
    if (m != 5)
    {
      j = k;
      if (m != 29) {}
    }
    else
    {
      m = d(paramArrayOfByte);
      j = k;
      i = m;
      if (c(paramArrayOfByte) == 22)
      {
        j = paramArrayOfByte.dD(4);
        i = m;
      }
    }
    int j = baH[j];
    if (j != -1) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkArgument(bool);
      paramArrayOfByte = Pair.create(Integer.valueOf(i), Integer.valueOf(j));
      AppMethodBeat.o(95864);
      return paramArrayOfByte;
    }
  }
  
  public static byte[] s(int paramInt1, int paramInt2, int paramInt3)
  {
    return new byte[] { (byte)(paramInt1 << 3 & 0xF8 | paramInt2 >> 1 & 0x7), (byte)(paramInt2 << 7 & 0x80 | paramInt3 << 3 & 0x78) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.i.d
 * JD-Core Version:    0.7.0.1
 */