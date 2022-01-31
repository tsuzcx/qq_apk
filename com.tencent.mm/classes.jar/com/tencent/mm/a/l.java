package com.tencent.mm.a;

public final class l
{
  public static byte[] c(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      return null;
    }
    return e(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static byte[] d(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      return null;
    }
    return e(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  private static byte[] e(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte2 = y(paramArrayOfByte2);
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length];
    int j = 0;
    int k = 0;
    int m = 0;
    while (j < paramArrayOfByte1.length)
    {
      m = m + 1 & 0xFF;
      k = (paramArrayOfByte2[m] & 0xFF) + k & 0xFF;
      int i = paramArrayOfByte2[m];
      paramArrayOfByte2[m] = paramArrayOfByte2[k];
      paramArrayOfByte2[k] = i;
      int n = paramArrayOfByte2[m];
      int i1 = paramArrayOfByte2[k];
      int i2 = paramArrayOfByte1[j];
      arrayOfByte[j] = ((byte)(paramArrayOfByte2[((n & 0xFF) + (i1 & 0xFF) & 0xFF)] ^ i2));
      j += 1;
    }
    return arrayOfByte;
  }
  
  private static byte[] y(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte2 = new byte[256];
    int j = 0;
    while (j < 256)
    {
      arrayOfByte2[j] = ((byte)j);
      j += 1;
    }
    byte[] arrayOfByte1;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      arrayOfByte1 = null;
      return arrayOfByte1;
    }
    j = 0;
    int m = 0;
    int k = 0;
    for (;;)
    {
      arrayOfByte1 = arrayOfByte2;
      if (j >= 256) {
        break;
      }
      m = (paramArrayOfByte[k] & 0xFF) + (arrayOfByte2[j] & 0xFF) + m & 0xFF;
      int i = arrayOfByte2[j];
      arrayOfByte2[j] = arrayOfByte2[m];
      arrayOfByte2[m] = i;
      k = (k + 1) % paramArrayOfByte.length;
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.a.l
 * JD-Core Version:    0.7.0.1
 */