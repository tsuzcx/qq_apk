package com.tencent.mm.plugin.downloader.c;

import android.util.Pair;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class k
{
  private static int A(ByteBuffer paramByteBuffer)
  {
    B(paramByteBuffer);
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
        if ((paramByteBuffer.getInt(m) == 101010256) && (e(paramByteBuffer, m + 20) == i)) {
          return m;
        }
        i += 1;
      }
    }
  }
  
  public static void B(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
      throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }
  }
  
  public static void c(ByteBuffer paramByteBuffer, long paramLong)
  {
    B(paramByteBuffer);
    int i = paramByteBuffer.position();
    if ((paramLong < 0L) || (paramLong > 4294967295L)) {
      throw new IllegalArgumentException("uint32 value of out range: " + paramLong);
    }
    paramByteBuffer.putInt(i + 16 + paramByteBuffer.position(), (int)paramLong);
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
  
  public static int e(ByteBuffer paramByteBuffer, int paramInt)
  {
    return paramByteBuffer.getShort(paramInt) & 0xFFFF;
  }
  
  public static long f(ByteBuffer paramByteBuffer, int paramInt)
  {
    return paramByteBuffer.getInt(paramInt) & 0xFFFFFFFF;
  }
  
  static Pair<ByteBuffer, Long> f(RandomAccessFile paramRandomAccessFile, int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 65535)) {
      throw new IllegalArgumentException("maxCommentSize: " + paramInt);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.k
 * JD-Core Version:    0.7.0.1
 */