package com.tencent.mm.loader.e;

import com.tencent.mm.loader.d.c;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public final class e
  implements c
{
  public static byte[] r(InputStream paramInputStream)
  {
    return s(paramInputStream);
  }
  
  private static byte[] s(InputStream paramInputStream)
  {
    byte[] arrayOfByte = new byte[1024];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    arrayOfByte = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    paramInputStream.close();
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.e.e
 * JD-Core Version:    0.7.0.1
 */