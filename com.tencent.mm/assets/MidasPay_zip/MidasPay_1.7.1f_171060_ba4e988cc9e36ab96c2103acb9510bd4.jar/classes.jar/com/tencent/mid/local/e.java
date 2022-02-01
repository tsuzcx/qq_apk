package com.tencent.mid.local;

import android.util.Base64;

class e
{
  static byte[] a()
  {
    return Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0);
  }
  
  static byte[] a(byte[] paramArrayOfByte)
  {
    return b(paramArrayOfByte, a());
  }
  
  static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int[] arrayOfInt1 = new int[256];
    int[] arrayOfInt2 = new int[256];
    int j = paramArrayOfByte2.length;
    if ((j >= 1) && (j <= 256))
    {
      int k = 0;
      int i = 0;
      while (i < 256)
      {
        arrayOfInt1[i] = i;
        arrayOfInt2[i] = paramArrayOfByte2[(i % j)];
        i += 1;
      }
      i = 0;
      j = 0;
      while (i < 256)
      {
        j = j + arrayOfInt1[i] + arrayOfInt2[i] & 0xFF;
        m = arrayOfInt1[i];
        arrayOfInt1[i] = arrayOfInt1[j];
        arrayOfInt1[j] = m;
        i += 1;
      }
      paramArrayOfByte2 = new byte[paramArrayOfByte1.length];
      int m = 0;
      j = 0;
      i = k;
      k = m;
      while (i < paramArrayOfByte1.length)
      {
        k = k + 1 & 0xFF;
        j = j + arrayOfInt1[k] & 0xFF;
        m = arrayOfInt1[k];
        arrayOfInt1[k] = arrayOfInt1[j];
        arrayOfInt1[j] = m;
        paramArrayOfByte2[i] = ((byte)(arrayOfInt1[(arrayOfInt1[k] + arrayOfInt1[j] & 0xFF)] ^ paramArrayOfByte1[i]));
        i += 1;
      }
      return paramArrayOfByte2;
    }
    throw new IllegalArgumentException("key must be between 1 and 256 bytes");
  }
  
  static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return a(paramArrayOfByte1, paramArrayOfByte2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.tencent.mid.local.e
 * JD-Core Version:    0.7.0.1
 */