package com.tencent.mm.loader.e;

import com.tencent.mm.loader.d.c;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public final class d
  implements c
{
  public static byte[] p(InputStream paramInputStream)
  {
    return q(paramInputStream);
  }
  
  private static byte[] q(InputStream paramInputStream)
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
 * Qualified Name:     com.tencent.mm.loader.e.d
 * JD-Core Version:    0.7.0.1
 */