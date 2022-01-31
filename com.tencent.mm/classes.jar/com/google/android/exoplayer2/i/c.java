package com.google.android.exoplayer2.i;

import android.util.Pair;

public final class c
{
  private static final byte[] aSg = { 0, 0, 0, 1 };
  private static final int[] aSh = { 96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350 };
  private static final int[] aSi = { 0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1 };
  
  private static int c(i parami)
  {
    int j = parami.dz(5);
    int i = j;
    if (j == 31) {
      i = parami.dz(6) + 32;
    }
    return i;
  }
  
  private static int d(i parami)
  {
    int i = parami.dz(4);
    if (i == 15) {
      return parami.dz(24);
    }
    if (i < 13) {}
    for (boolean bool = true;; bool = false)
    {
      a.aB(bool);
      return aSh[i];
    }
  }
  
  public static Pair<Integer, Integer> i(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new i(paramArrayOfByte);
    int m = c(paramArrayOfByte);
    int i = d(paramArrayOfByte);
    int k = paramArrayOfByte.dz(4);
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
        j = paramArrayOfByte.dz(4);
        i = m;
      }
    }
    int j = aSi[j];
    if (j != -1) {}
    for (boolean bool = true;; bool = false)
    {
      a.aB(bool);
      return Pair.create(Integer.valueOf(i), Integer.valueOf(j));
    }
  }
  
  public static byte[] i(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[aSg.length + paramInt2];
    System.arraycopy(aSg, 0, arrayOfByte, 0, aSg.length);
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, aSg.length, paramInt2);
    return arrayOfByte;
  }
  
  public static byte[] s(int paramInt1, int paramInt2, int paramInt3)
  {
    return new byte[] { (byte)(paramInt1 << 3 & 0xF8 | paramInt2 >> 1 & 0x7), (byte)(paramInt2 << 7 & 0x80 | paramInt3 << 3 & 0x78) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.i.c
 * JD-Core Version:    0.7.0.1
 */