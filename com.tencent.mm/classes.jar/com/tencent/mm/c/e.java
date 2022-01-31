package com.tencent.mm.c;

import java.io.InputStream;

public final class e
{
  public static final boolean a(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1;
      if (i >= paramInt) {
        bool1 = true;
      }
      int j;
      do
      {
        return bool1;
        j = paramInputStream.read(paramArrayOfByte, i + 0, paramInt - i);
        bool1 = bool2;
      } while (j < 0);
      i += j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.c.e
 * JD-Core Version:    0.7.0.1
 */