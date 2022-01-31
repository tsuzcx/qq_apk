package com.tencent.c.a.a;

final class l
{
  static byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int[] arrayOfInt1 = new int[256];
    int[] arrayOfInt2 = new int[256];
    int j = paramArrayOfByte2.length;
    if ((j <= 0) || (j > 256)) {
      throw new IllegalArgumentException("key must be between 1 and 256 bytes");
    }
    int i = 0;
    label51:
    int k;
    if (i >= 256)
    {
      j = 0;
      i = 0;
      if (i < 256) {
        break label99;
      }
      paramArrayOfByte2 = new byte[paramArrayOfByte1.length];
      i = 0;
      k = 0;
      j = 0;
    }
    for (;;)
    {
      if (i >= paramArrayOfByte1.length)
      {
        return paramArrayOfByte2;
        arrayOfInt1[i] = i;
        arrayOfInt2[i] = paramArrayOfByte2[(i % j)];
        i += 1;
        break;
        label99:
        j = j + arrayOfInt1[i] + arrayOfInt2[i] & 0xFF;
        k = arrayOfInt1[i];
        arrayOfInt1[i] = arrayOfInt1[j];
        arrayOfInt1[j] = k;
        i += 1;
        break label51;
      }
      k = k + 1 & 0xFF;
      j = arrayOfInt1[k] + j & 0xFF;
      int m = arrayOfInt1[k];
      arrayOfInt1[k] = arrayOfInt1[j];
      arrayOfInt1[j] = m;
      paramArrayOfByte2[i] = ((byte)(arrayOfInt1[(arrayOfInt1[k] + arrayOfInt1[j] & 0xFF)] ^ paramArrayOfByte1[i]));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.c.a.a.l
 * JD-Core Version:    0.7.0.1
 */