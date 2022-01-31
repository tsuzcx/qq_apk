package com.tencent.mm.c;

public final class a$a
{
  static final long bvh = "Micromsg".hashCode();
  public int bvi = 0;
  
  public a$a(int paramInt)
  {
    this.bvi = paramInt;
  }
  
  static byte[] ak(long paramLong)
  {
    byte[] arrayOfByte = new byte[8];
    int i = 0;
    for (;;)
    {
      if (i >= 8) {
        return arrayOfByte;
      }
      arrayOfByte[i] = ((byte)(int)(paramLong >> i * 8 & 0xFF));
      i += 1;
    }
  }
  
  public static a s(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 8)
    {
      long l = 0L;
      int i = 0;
      for (;;)
      {
        if (i >= paramArrayOfByte.length)
        {
          if (l >> 32 != bvh) {
            break;
          }
          return new a((int)l);
        }
        l |= (paramArrayOfByte[i] & 0xFF) << i * 8;
        i += 1;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.c.a.a
 * JD-Core Version:    0.7.0.1
 */