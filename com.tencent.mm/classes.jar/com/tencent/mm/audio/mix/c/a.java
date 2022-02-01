package com.tencent.mm.audio.mix.c;

public final class a
{
  public static short a(byte paramByte1, byte paramByte2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (short)((short)((short)(paramByte1 & 0xFF | 0x0) << 8) | paramByte2 & 0xFF);
    }
    return (short)((short)((short)(paramByte2 & 0xFF | 0x0) << 8) | paramByte1 & 0xFF);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, double paramDouble)
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      paramArrayOfByte[i] = ((byte)(int)(paramArrayOfByte[i] * paramDouble));
      i += 1;
    }
    return paramArrayOfByte;
  }
  
  public static byte[] getBytes(short paramShort, boolean paramBoolean)
  {
    byte[] arrayOfByte = new byte[2];
    if (paramBoolean)
    {
      arrayOfByte[1] = ((byte)(paramShort & 0xFF));
      arrayOfByte[0] = ((byte)((short)(paramShort >> 8) & 0xFF));
      return arrayOfByte;
    }
    arrayOfByte[0] = ((byte)(paramShort & 0xFF));
    arrayOfByte[1] = ((byte)((short)(paramShort >> 8) & 0xFF));
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.c.a
 * JD-Core Version:    0.7.0.1
 */