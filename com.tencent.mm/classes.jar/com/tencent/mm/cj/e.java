package com.tencent.mm.cj;

public final class e
{
  public static byte[] cF(byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ 0x12));
      i += 1;
    }
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cj.e
 * JD-Core Version:    0.7.0.1
 */