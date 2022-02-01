package com.google.android.exoplayer2.i;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class d
{
  private static final byte[] byG = { 0, 0, 0, 1 };
  private static final int[] byH = { 96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350 };
  private static final int[] byI = { 0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1 };
  
  public static byte[] bo(int paramInt1, int paramInt2)
  {
    int k = 0;
    AppMethodBeat.i(93122);
    int i = 0;
    int j = -1;
    while (i < byH.length)
    {
      if (paramInt1 == byH[i]) {
        j = i;
      }
      i += 1;
    }
    int m = -1;
    i = k;
    k = m;
    while (i < byI.length)
    {
      if (paramInt2 == byI[i]) {
        k = i;
      }
      i += 1;
    }
    if ((paramInt1 == -1) || (k == -1))
    {
      localObject = new IllegalArgumentException("Invalid sample rate or number of channels: " + paramInt1 + ", " + paramInt2);
      AppMethodBeat.o(93122);
      throw ((Throwable)localObject);
    }
    Object localObject = u(2, j, k);
    AppMethodBeat.o(93122);
    return localObject;
  }
  
  private static int c(l paraml)
  {
    AppMethodBeat.i(93126);
    int j = paraml.eo(5);
    int i = j;
    if (j == 31) {
      i = paraml.eo(6) + 32;
    }
    AppMethodBeat.o(93126);
    return i;
  }
  
  private static int d(l paraml)
  {
    AppMethodBeat.i(93127);
    int i = paraml.eo(4);
    if (i == 15)
    {
      i = paraml.eo(24);
      AppMethodBeat.o(93127);
      return i;
    }
    if (i < 13) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkArgument(bool);
      i = byH[i];
      break;
    }
  }
  
  private static int j(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(93125);
    int i = paramArrayOfByte.length;
    int j = byG.length;
    while (paramInt <= i - j)
    {
      if (k(paramArrayOfByte, paramInt))
      {
        AppMethodBeat.o(93125);
        return paramInt;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(93125);
    return -1;
  }
  
  private static boolean k(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte.length - paramInt <= byG.length) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= byG.length) {
        break label43;
      }
      if (paramArrayOfByte[(paramInt + i)] != byG[i]) {
        break;
      }
      i += 1;
    }
    label43:
    return true;
  }
  
  public static byte[] k(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93123);
    byte[] arrayOfByte = new byte[byG.length + paramInt2];
    System.arraycopy(byG, 0, arrayOfByte, 0, byG.length);
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, byG.length, paramInt2);
    AppMethodBeat.o(93123);
    return arrayOfByte;
  }
  
  public static byte[] u(int paramInt1, int paramInt2, int paramInt3)
  {
    return new byte[] { (byte)(paramInt1 << 3 & 0xF8 | paramInt2 >> 1 & 0x7), (byte)(paramInt2 << 7 & 0x80 | paramInt3 << 3 & 0x78) };
  }
  
  public static Pair<Integer, Integer> v(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93121);
    paramArrayOfByte = new l(paramArrayOfByte);
    int m = c(paramArrayOfByte);
    int i = d(paramArrayOfByte);
    int k = paramArrayOfByte.eo(4);
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
        j = paramArrayOfByte.eo(4);
        i = m;
      }
    }
    int j = byI[j];
    if (j != -1) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkArgument(bool);
      paramArrayOfByte = Pair.create(Integer.valueOf(i), Integer.valueOf(j));
      AppMethodBeat.o(93121);
      return paramArrayOfByte;
    }
  }
  
  public static byte[][] w(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93124);
    if (!k(paramArrayOfByte, 0))
    {
      AppMethodBeat.o(93124);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j;
    do
    {
      localArrayList.add(Integer.valueOf(i));
      j = j(paramArrayOfByte, i + byG.length);
      i = j;
    } while (j != -1);
    byte[][] arrayOfByte = new byte[localArrayList.size()][];
    i = 0;
    if (i < localArrayList.size())
    {
      int k = ((Integer)localArrayList.get(i)).intValue();
      if (i < localArrayList.size() - 1) {}
      for (j = ((Integer)localArrayList.get(i + 1)).intValue();; j = paramArrayOfByte.length)
      {
        byte[] arrayOfByte1 = new byte[j - k];
        System.arraycopy(paramArrayOfByte, k, arrayOfByte1, 0, arrayOfByte1.length);
        arrayOfByte[i] = arrayOfByte1;
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(93124);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.i.d
 * JD-Core Version:    0.7.0.1
 */