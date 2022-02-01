package com.tencent.mm.plugin.game.chatroom.k;

public final class d
{
  public static long bW(byte[] paramArrayOfByte)
  {
    long l = 0L;
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      l |= (paramArrayOfByte[i] & 0xFF) << i * 8;
      i += 1;
    }
    return l;
  }
  
  public static byte[] rC(long paramLong)
  {
    byte[] arrayOfByte = new byte[8];
    int i = 0;
    while (i < 8)
    {
      arrayOfByte[i] = ((byte)(int)(paramLong >> i * 8 & 0xFF));
      i += 1;
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.k.d
 * JD-Core Version:    0.7.0.1
 */