package com.google.android.exoplayer2.i;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  private static final byte[] dkg = { 0, 0, 0, 1 };
  private static final int[] dkh = { 96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350 };
  private static final int[] dki = { 0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1 };
  
  public static byte[] F(int paramInt1, int paramInt2, int paramInt3)
  {
    return new byte[] { (byte)(paramInt1 << 3 & 0xF8 | paramInt2 >> 1 & 0x7), (byte)(paramInt2 << 7 & 0x80 | paramInt3 << 3 & 0x78) };
  }
  
  private static int c(l paraml)
  {
    AppMethodBeat.i(93126);
    int j = paraml.hQ(5);
    int i = j;
    if (j == 31) {
      i = paraml.hQ(6) + 32;
    }
    AppMethodBeat.o(93126);
    return i;
  }
  
  private static int d(l paraml)
  {
    AppMethodBeat.i(93127);
    int i = paraml.hQ(4);
    if (i == 15)
    {
      i = paraml.hQ(24);
      AppMethodBeat.o(93127);
      return i;
    }
    if (i < 13) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkArgument(bool);
      i = dkh[i];
      break;
    }
  }
  
  public static byte[] j(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93123);
    byte[] arrayOfByte = new byte[dkg.length + paramInt2];
    System.arraycopy(dkg, 0, arrayOfByte, 0, dkg.length);
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, dkg.length, paramInt2);
    AppMethodBeat.o(93123);
    return arrayOfByte;
  }
  
  public static Pair<Integer, Integer> y(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93121);
    paramArrayOfByte = new l(paramArrayOfByte);
    int m = c(paramArrayOfByte);
    int i = d(paramArrayOfByte);
    int k = paramArrayOfByte.hQ(4);
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
        j = paramArrayOfByte.hQ(4);
        i = m;
      }
    }
    int j = dki[j];
    if (j != -1) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkArgument(bool);
      paramArrayOfByte = Pair.create(Integer.valueOf(i), Integer.valueOf(j));
      AppMethodBeat.o(93121);
      return paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.i.d
 * JD-Core Version:    0.7.0.1
 */