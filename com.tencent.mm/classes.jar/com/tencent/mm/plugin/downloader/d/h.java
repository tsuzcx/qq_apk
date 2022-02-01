package com.tencent.mm.plugin.downloader.d;

import android.util.Pair;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class h
{
  private static int A(ByteBuffer paramByteBuffer)
  {
    D(paramByteBuffer);
    int j = paramByteBuffer.capacity();
    if (j < 22) {}
    for (;;)
    {
      return -1;
      int k = Math.min(j - 22, 65535);
      int i = 0;
      while (i < k)
      {
        int m = j - 22 - i;
        if ((paramByteBuffer.getInt(m) == 101010256) && ((paramByteBuffer.getShort(m + 20) & 0xFFFF) == i)) {
          return m;
        }
        i += 1;
      }
    }
  }
  
  public static long B(ByteBuffer paramByteBuffer)
  {
    D(paramByteBuffer);
    return e(paramByteBuffer, paramByteBuffer.position() + 16);
  }
  
  public static long C(ByteBuffer paramByteBuffer)
  {
    D(paramByteBuffer);
    return e(paramByteBuffer, paramByteBuffer.position() + 12);
  }
  
  private static void D(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
      throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }
  }
  
  public static final boolean c(RandomAccessFile paramRandomAccessFile, long paramLong)
  {
    paramLong -= 20L;
    if (paramLong < 0L) {}
    do
    {
      return false;
      paramRandomAccessFile.seek(paramLong);
    } while (paramRandomAccessFile.readInt() != 1347094023);
    return true;
  }
  
  private static long e(ByteBuffer paramByteBuffer, int paramInt)
  {
    return paramByteBuffer.getInt(paramInt) & 0xFFFFFFFF;
  }
  
  private static Pair<ByteBuffer, Long> g(RandomAccessFile paramRandomAccessFile, int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 65535)) {
      throw new IllegalArgumentException("maxCommentSize: ".concat(String.valueOf(paramInt)));
    }
    long l = paramRandomAccessFile.length();
    if (l < 22L) {}
    ByteBuffer localByteBuffer;
    do
    {
      return null;
      localByteBuffer = ByteBuffer.allocate((int)Math.min(paramInt, l - 22L) + 22);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      l -= localByteBuffer.capacity();
      paramRandomAccessFile.seek(l);
      paramRandomAccessFile.readFully(localByteBuffer.array(), localByteBuffer.arrayOffset(), localByteBuffer.capacity());
      paramInt = A(localByteBuffer);
    } while (paramInt == -1);
    localByteBuffer.position(paramInt);
    paramRandomAccessFile = localByteBuffer.slice();
    paramRandomAccessFile.order(ByteOrder.LITTLE_ENDIAN);
    return Pair.create(paramRandomAccessFile, Long.valueOf(l + paramInt));
  }
  
  static Pair<ByteBuffer, Long> h(RandomAccessFile paramRandomAccessFile)
  {
    Object localObject;
    if (paramRandomAccessFile.length() < 22L) {
      localObject = null;
    }
    Pair localPair;
    do
    {
      return localObject;
      localPair = g(paramRandomAccessFile, 0);
      localObject = localPair;
    } while (localPair != null);
    return g(paramRandomAccessFile, 65535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.d.h
 * JD-Core Version:    0.7.0.1
 */