package com.tencent.mm.a;

import com.tencent.mm.pointers.PByteArray;

public final class c
{
  public static int a(PByteArray paramPByteArray, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      return 2;
    }
    if ((paramArrayOfByte1.length < 0) || (paramArrayOfByte2.length <= 0)) {
      return 2;
    }
    int i = 8 - paramArrayOfByte1.length % 8;
    if (i == 0) {
      i = 8;
    }
    for (;;)
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte1.length + i];
      int j = 0;
      while (j < paramArrayOfByte1.length)
      {
        arrayOfByte[j] = paramArrayOfByte1[j];
        j += 1;
      }
      j = 0;
      while (j < i)
      {
        arrayOfByte[(paramArrayOfByte1.length + j)] = ((byte)i);
        j += 1;
      }
      paramPByteArray.value = new byte[paramArrayOfByte1.length + i + 32];
      if (k.a(paramPByteArray.value, arrayOfByte, arrayOfByte.length, paramArrayOfByte2.length, paramArrayOfByte2, 0) == 0) {
        return 11;
      }
      paramArrayOfByte1 = new byte[paramArrayOfByte1.length + i + 8];
      i = 0;
      while (i < paramArrayOfByte1.length)
      {
        paramArrayOfByte1[i] = paramPByteArray.value[i];
        i += 1;
      }
      paramPByteArray.value = paramArrayOfByte1;
      return 0;
    }
  }
  
  public static int b(PByteArray paramPByteArray, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      return 2;
    }
    if ((paramArrayOfByte1.length < 0) || (paramArrayOfByte2.length <= 0)) {
      return 2;
    }
    int i = paramArrayOfByte1.length;
    paramPByteArray.value = new byte[i];
    if (k.a(paramPByteArray.value, paramArrayOfByte1, i, paramArrayOfByte2.length, paramArrayOfByte2, 1) == 0) {
      return 12;
    }
    int j = paramPByteArray.value[(i - 1 - 8)];
    if ((j <= 0) || (j > 8)) {
      return 12;
    }
    paramArrayOfByte1 = new byte[i - j - 8];
    i = 0;
    while (i < paramArrayOfByte1.length)
    {
      paramArrayOfByte1[i] = paramPByteArray.value[i];
      i += 1;
    }
    paramPByteArray.value = paramArrayOfByte1;
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.a.c
 * JD-Core Version:    0.7.0.1
 */