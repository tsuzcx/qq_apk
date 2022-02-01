package com.tencent.mm.b;

public final class i
{
  public static int ce(int paramInt1, int paramInt2)
  {
    int i = 0;
    if ((paramInt2 < 0) || (paramInt2 >= 2147483647)) {
      return 0;
    }
    byte[] arrayOfByte = new byte[4];
    while (i < 4)
    {
      arrayOfByte[i] = ((byte)(paramInt1 >> i * 8 & 0xFF));
      i += 1;
    }
    return (int)((s(arrayOfByte, 4) & 0xFFFFFFFF) % paramInt2);
  }
  
  public static int s(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt ^ 0x0;
    int k = paramInt >> 2;
    int j = 0;
    while (j < k)
    {
      int m = (j << 2) + 0;
      int n = paramArrayOfByte[(m + 3)];
      int i1 = paramArrayOfByte[(m + 2)];
      int i2 = paramArrayOfByte[(m + 1)];
      m = (paramArrayOfByte[(m + 0)] & 0xFF | ((n << 8 | i1 & 0xFF) << 8 | i2 & 0xFF) << 8) * 1540483477;
      i = i * 1540483477 ^ (m ^ m >>> 24) * 1540483477;
      j += 1;
    }
    k = paramInt - (k << 2);
    j = i;
    if (k != 0)
    {
      j = i;
      if (k >= 3) {
        j = i ^ paramArrayOfByte[(paramInt + 0 - 3)] << 16;
      }
      i = j;
      if (k >= 2) {
        i = j ^ paramArrayOfByte[(paramInt + 0 - 2)] << 8;
      }
      j = i;
      if (k > 0) {
        j = i ^ paramArrayOfByte[(paramInt + 0 - 1)];
      }
      j *= 1540483477;
    }
    paramInt = (j ^ j >>> 13) * 1540483477;
    return paramInt ^ paramInt >>> 15;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.b.i
 * JD-Core Version:    0.7.0.1
 */