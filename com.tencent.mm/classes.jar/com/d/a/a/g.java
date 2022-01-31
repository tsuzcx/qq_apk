package com.d.a.a;

import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;

final class g
{
  protected static byte[] l(byte[] paramArrayOfByte)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    Object localObject2 = localObject4;
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length);
      localObject1 = localObject3;
      localObject2 = localObject4;
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localObject1 = localObject3;
      localObject2 = localObject4;
      localGZIPOutputStream.write(paramArrayOfByte);
      localObject1 = localObject3;
      localObject2 = localObject4;
      localGZIPOutputStream.close();
      localObject1 = localObject3;
      localObject2 = localObject4;
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localObject1 = paramArrayOfByte;
      localObject2 = paramArrayOfByte;
      localByteArrayOutputStream.close();
      return paramArrayOfByte;
    }
    catch (Error paramArrayOfByte)
    {
      return localObject1;
    }
    catch (Exception paramArrayOfByte) {}
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.d.a.a.g
 * JD-Core Version:    0.7.0.1
 */