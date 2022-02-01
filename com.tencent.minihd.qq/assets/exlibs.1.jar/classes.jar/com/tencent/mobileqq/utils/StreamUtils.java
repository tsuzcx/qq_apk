package com.tencent.mobileqq.utils;

import java.io.InputStream;
import org.apache.http.util.ByteArrayBuffer;

public class StreamUtils
{
  private static final int a = 4096;
  private static final int b = 134217728;
  
  public static byte[] a(InputStream paramInputStream, int paramInt)
  {
    if ((paramInputStream == null) || (paramInt > 134217728)) {
      return null;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = 4096;
    }
    ByteArrayBuffer localByteArrayBuffer = new ByteArrayBuffer(i);
    try
    {
      byte[] arrayOfByte = new byte[4096];
      for (;;)
      {
        paramInt = paramInputStream.read(arrayOfByte);
        if (paramInt == -1) {
          break;
        }
        localByteArrayBuffer.append(arrayOfByte, 0, paramInt);
      }
    }
    finally
    {
      paramInputStream.close();
    }
    return localObject.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.StreamUtils
 * JD-Core Version:    0.7.0.1
 */