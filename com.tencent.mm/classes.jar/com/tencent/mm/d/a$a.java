package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$a
{
  static final long cJP;
  public int cJQ = 0;
  
  static
  {
    AppMethodBeat.i(959);
    cJP = "Micromsg".hashCode();
    AppMethodBeat.o(959);
  }
  
  public a$a(int paramInt)
  {
    this.cJQ = paramInt;
  }
  
  public static a I(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(960);
    long l;
    int i;
    if (paramArrayOfByte.length == 8)
    {
      l = 0L;
      i = 0;
      if (i >= paramArrayOfByte.length) {
        if (l >> 32 != cJP) {
          break label75;
        }
      }
    }
    label75:
    for (paramArrayOfByte = new a((int)l);; paramArrayOfByte = null)
    {
      AppMethodBeat.o(960);
      return paramArrayOfByte;
      l |= (paramArrayOfByte[i] & 0xFF) << i * 8;
      i += 1;
      break;
    }
  }
  
  static byte[] bh(long paramLong)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.d.a.a
 * JD-Core Version:    0.7.0.1
 */