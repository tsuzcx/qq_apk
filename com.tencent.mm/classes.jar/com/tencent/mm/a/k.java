package com.tencent.mm.a;

public final class k
{
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      return null;
    }
    return c(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      return null;
    }
    return c(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  private static byte[] c(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte2 = new byte[256];
    int j = 0;
    while (j < 256)
    {
      arrayOfByte2[j] = ((byte)j);
      j += 1;
    }
    byte[] arrayOfByte1;
    int k;
    int m;
    if ((paramArrayOfByte2 == null) || (paramArrayOfByte2.length == 0))
    {
      arrayOfByte1 = null;
      paramArrayOfByte2 = new byte[paramArrayOfByte1.length];
      j = 0;
      k = 0;
      m = 0;
    }
    while (j < paramArrayOfByte1.length)
    {
      m = m + 1 & 0xFF;
      k = (arrayOfByte1[m] & 0xFF) + k & 0xFF;
      int i = arrayOfByte1[m];
      arrayOfByte1[m] = arrayOfByte1[k];
      arrayOfByte1[k] = i;
      int n = arrayOfByte1[m];
      int i1 = arrayOfByte1[k];
      int i2 = paramArrayOfByte1[j];
      paramArrayOfByte2[j] = ((byte)(arrayOfByte1[((n & 0xFF) + (i1 & 0xFF) & 0xFF)] ^ i2));
      j += 1;
      continue;
      k = 0;
      m = 0;
      j = 0;
      for (;;)
      {
        arrayOfByte1 = arrayOfByte2;
        if (k >= 256) {
          break;
        }
        m = m + ((paramArrayOfByte2[j] & 0xFF) + (arrayOfByte2[k] & 0xFF)) & 0xFF;
        i = arrayOfByte2[k];
        arrayOfByte2[k] = arrayOfByte2[m];
        arrayOfByte2[m] = i;
        j = (j + 1) % paramArrayOfByte2.length;
        k += 1;
      }
    }
    return paramArrayOfByte2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.a.k
 * JD-Core Version:    0.7.0.1
 */