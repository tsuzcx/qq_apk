package com.tencent.mars.zstd;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class Zstd
{
  public static int compress(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, int paramInt)
  {
    if (!paramByteBuffer2.isDirect()) {
      throw new IllegalArgumentException("srcBuf must be a direct buffer");
    }
    if (!paramByteBuffer1.isDirect()) {
      throw new IllegalArgumentException("dstBuf must be a direct buffer");
    }
    long l = compressDirectByteBuffer(paramByteBuffer1, paramByteBuffer1.position(), paramByteBuffer1.limit() - paramByteBuffer1.position(), paramByteBuffer2, paramByteBuffer2.position(), paramByteBuffer2.limit() - paramByteBuffer2.position(), paramInt);
    if (isError(l)) {
      throw new RuntimeException(getErrorName(l));
    }
    paramByteBuffer2.position(paramByteBuffer2.limit());
    paramByteBuffer1.position(paramByteBuffer1.position() + (int)l);
    return (int)l;
  }
  
  public static int compress(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, ZstdDictCompress paramZstdDictCompress)
  {
    if (!paramByteBuffer2.isDirect()) {
      throw new IllegalArgumentException("srcBuf must be a direct buffer");
    }
    if (!paramByteBuffer1.isDirect()) {
      throw new IllegalArgumentException("dstBuf must be a direct buffer");
    }
    long l = compressDirectByteBufferFastDict(paramByteBuffer1, paramByteBuffer1.position(), paramByteBuffer1.limit() - paramByteBuffer1.position(), paramByteBuffer2, paramByteBuffer2.position(), paramByteBuffer2.limit() - paramByteBuffer2.position(), paramZstdDictCompress);
    if (isError(l)) {
      throw new RuntimeException(getErrorName(l));
    }
    paramByteBuffer2.position(paramByteBuffer2.limit());
    paramByteBuffer1.limit((int)l);
    return (int)l;
  }
  
  public static int compress(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, byte[] paramArrayOfByte, int paramInt)
  {
    if (!paramByteBuffer2.isDirect()) {
      throw new IllegalArgumentException("srcBuf must be a direct buffer");
    }
    if (!paramByteBuffer1.isDirect()) {
      throw new IllegalArgumentException("dstBuf must be a direct buffer");
    }
    long l = compressDirectByteBufferUsingDict(paramByteBuffer1, paramByteBuffer1.position(), paramByteBuffer1.limit() - paramByteBuffer1.position(), paramByteBuffer2, paramByteBuffer2.position(), paramByteBuffer2.limit() - paramByteBuffer2.position(), paramArrayOfByte, paramInt);
    if (isError(l)) {
      throw new RuntimeException(getErrorName(l));
    }
    paramByteBuffer2.position(paramByteBuffer2.limit());
    paramByteBuffer1.limit((int)l);
    return (int)l;
  }
  
  public static native long compress(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt);
  
  public static long compress(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt)
  {
    return compressUsingDict(paramArrayOfByte1, 0, paramArrayOfByte2, 0, paramArrayOfByte2.length, paramArrayOfByte3, paramInt);
  }
  
  public static ByteBuffer compress(ByteBuffer paramByteBuffer, int paramInt)
  {
    if (!paramByteBuffer.isDirect()) {
      throw new IllegalArgumentException("srcBuf must be a direct buffer");
    }
    long l = compressBound(paramByteBuffer.limit() - paramByteBuffer.position());
    if (l > 2147483647L) {
      throw new RuntimeException("Max output size is greater than MAX_INT");
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect((int)l);
    l = compressDirectByteBuffer(localByteBuffer, 0, (int)l, paramByteBuffer, paramByteBuffer.position(), paramByteBuffer.limit() - paramByteBuffer.position(), paramInt);
    if (isError(l)) {
      throw new RuntimeException(getErrorName(l));
    }
    paramByteBuffer.position(paramByteBuffer.limit());
    localByteBuffer.limit((int)l);
    return localByteBuffer;
  }
  
  public static ByteBuffer compress(ByteBuffer paramByteBuffer, ZstdDictCompress paramZstdDictCompress)
  {
    if (!paramByteBuffer.isDirect()) {
      throw new IllegalArgumentException("srcBuf must be a direct buffer");
    }
    long l = compressBound(paramByteBuffer.limit() - paramByteBuffer.position());
    if (l > 2147483647L) {
      throw new RuntimeException("Max output size is greater than MAX_INT");
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect((int)l);
    l = compressDirectByteBufferFastDict(localByteBuffer, 0, (int)l, paramByteBuffer, paramByteBuffer.position(), paramByteBuffer.limit() - paramByteBuffer.position(), paramZstdDictCompress);
    if (isError(l)) {
      throw new RuntimeException(getErrorName(l));
    }
    paramByteBuffer.position(paramByteBuffer.limit());
    localByteBuffer.limit((int)l);
    return localByteBuffer;
  }
  
  public static ByteBuffer compress(ByteBuffer paramByteBuffer, byte[] paramArrayOfByte, int paramInt)
  {
    if (!paramByteBuffer.isDirect()) {
      throw new IllegalArgumentException("srcBuf must be a direct buffer");
    }
    long l = compressBound(paramByteBuffer.limit() - paramByteBuffer.position());
    if (l > 2147483647L) {
      throw new RuntimeException("Max output size is greater than MAX_INT");
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect((int)l);
    l = compressDirectByteBufferUsingDict(localByteBuffer, 0, (int)l, paramByteBuffer, paramByteBuffer.position(), paramByteBuffer.limit() - paramByteBuffer.position(), paramArrayOfByte, paramInt);
    if (isError(l)) {
      throw new RuntimeException(getErrorName(l));
    }
    paramByteBuffer.position(paramByteBuffer.limit());
    localByteBuffer.limit((int)l);
    return localByteBuffer;
  }
  
  public static byte[] compress(byte[] paramArrayOfByte)
  {
    return compress(paramArrayOfByte, 3);
  }
  
  public static byte[] compress(byte[] paramArrayOfByte, int paramInt)
  {
    long l = compressBound(paramArrayOfByte.length);
    if (l > 2147483647L) {
      throw new RuntimeException("Max output size is greater than MAX_INT");
    }
    byte[] arrayOfByte = new byte[(int)l];
    l = compress(arrayOfByte, paramArrayOfByte, paramInt);
    if (isError(l)) {
      throw new RuntimeException(getErrorName(l));
    }
    return Arrays.copyOfRange(arrayOfByte, 0, (int)l);
  }
  
  public static byte[] compress(byte[] paramArrayOfByte, ZstdDictCompress paramZstdDictCompress)
  {
    long l = compressBound(paramArrayOfByte.length);
    if (l > 2147483647L) {
      throw new RuntimeException("Max output size is greater than MAX_INT");
    }
    byte[] arrayOfByte = new byte[(int)l];
    l = compressFastDict(arrayOfByte, 0, paramArrayOfByte, 0, paramArrayOfByte.length, paramZstdDictCompress);
    if (isError(l)) {
      throw new RuntimeException(getErrorName(l));
    }
    return Arrays.copyOfRange(arrayOfByte, 0, (int)l);
  }
  
  public static native long compressBound(long paramLong);
  
  public static native long compressByteArray(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4, int paramInt5);
  
  public static native long compressDirectByteBuffer(ByteBuffer paramByteBuffer1, int paramInt1, int paramInt2, ByteBuffer paramByteBuffer2, int paramInt3, int paramInt4, int paramInt5);
  
  public static native long compressDirectByteBufferFastDict(ByteBuffer paramByteBuffer1, int paramInt1, int paramInt2, ByteBuffer paramByteBuffer2, int paramInt3, int paramInt4, ZstdDictCompress paramZstdDictCompress);
  
  public static native long compressDirectByteBufferUsingDict(ByteBuffer paramByteBuffer1, int paramInt1, int paramInt2, ByteBuffer paramByteBuffer2, int paramInt3, int paramInt4, byte[] paramArrayOfByte, int paramInt5);
  
  public static native long compressFastDict(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, ZstdDictCompress paramZstdDictCompress);
  
  public static native long compressUsingDict(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, byte[] paramArrayOfByte3, int paramInt4);
  
  @Deprecated
  public static long compressUsingDict(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt)
  {
    return compressUsingDict(paramArrayOfByte1, 0, paramArrayOfByte2, 0, paramArrayOfByte2.length, paramArrayOfByte3, paramInt);
  }
  
  public static byte[] compressUsingDict(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    long l = compressBound(paramArrayOfByte1.length);
    if (l > 2147483647L) {
      throw new RuntimeException("Max output size is greater than MAX_INT");
    }
    byte[] arrayOfByte = new byte[(int)l];
    l = compressUsingDict(arrayOfByte, 0, paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2, paramInt);
    if (isError(l)) {
      throw new RuntimeException(getErrorName(l));
    }
    return Arrays.copyOfRange(arrayOfByte, 0, (int)l);
  }
  
  public static int decompress(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
  {
    if (!paramByteBuffer2.isDirect()) {
      throw new IllegalArgumentException("srcBuf must be a direct buffer");
    }
    if (!paramByteBuffer1.isDirect()) {
      throw new IllegalArgumentException("dstBuf must be a direct buffer");
    }
    long l = decompressDirectByteBuffer(paramByteBuffer1, paramByteBuffer1.position(), paramByteBuffer1.limit() - paramByteBuffer1.position(), paramByteBuffer2, paramByteBuffer2.position(), paramByteBuffer2.limit() - paramByteBuffer2.position());
    if (isError(l)) {
      throw new RuntimeException(getErrorName(l));
    }
    paramByteBuffer2.position(paramByteBuffer2.limit());
    paramByteBuffer1.position(paramByteBuffer1.position() + (int)l);
    return (int)l;
  }
  
  public static int decompress(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, ZstdDictDecompress paramZstdDictDecompress)
  {
    if (!paramByteBuffer2.isDirect()) {
      throw new IllegalArgumentException("srcBuff must be a direct buffer");
    }
    if (!paramByteBuffer1.isDirect()) {
      throw new IllegalArgumentException("dstBuff must be a direct buffer");
    }
    long l = decompressDirectByteBufferFastDict(paramByteBuffer1, paramByteBuffer1.position(), paramByteBuffer1.limit() - paramByteBuffer1.position(), paramByteBuffer2, paramByteBuffer2.position(), paramByteBuffer2.limit() - paramByteBuffer2.position(), paramZstdDictDecompress);
    if (isError(l)) {
      throw new RuntimeException(getErrorName(l));
    }
    paramByteBuffer2.position(paramByteBuffer2.limit());
    paramByteBuffer1.position(paramByteBuffer1.position() + (int)l);
    return (int)l;
  }
  
  public static int decompress(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, byte[] paramArrayOfByte)
  {
    if (!paramByteBuffer2.isDirect()) {
      throw new IllegalArgumentException("srcBuff must be a direct buffer");
    }
    if (!paramByteBuffer1.isDirect()) {
      throw new IllegalArgumentException("dstBuff must be a direct buffer");
    }
    long l = decompressDirectByteBufferUsingDict(paramByteBuffer1, paramByteBuffer1.position(), paramByteBuffer1.limit() - paramByteBuffer1.position(), paramByteBuffer2, paramByteBuffer2.position(), paramByteBuffer2.limit() - paramByteBuffer2.position(), paramArrayOfByte);
    if (isError(l)) {
      throw new RuntimeException(getErrorName(l));
    }
    paramByteBuffer2.position(paramByteBuffer2.limit());
    paramByteBuffer1.position(paramByteBuffer1.position() + (int)l);
    return (int)l;
  }
  
  public static native long decompress(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public static long decompress(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    return decompressUsingDict(paramArrayOfByte1, 0, paramArrayOfByte2, 0, paramArrayOfByte2.length, paramArrayOfByte3);
  }
  
  public static ByteBuffer decompress(ByteBuffer paramByteBuffer, int paramInt)
  {
    if (!paramByteBuffer.isDirect()) {
      throw new IllegalArgumentException("srcBuf must be a direct buffer");
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt);
    long l = decompressDirectByteBuffer(localByteBuffer, 0, paramInt, paramByteBuffer, paramByteBuffer.position(), paramByteBuffer.limit());
    if (isError(l)) {
      throw new RuntimeException(getErrorName(l));
    }
    paramByteBuffer.position(paramByteBuffer.limit());
    return localByteBuffer;
  }
  
  public static ByteBuffer decompress(ByteBuffer paramByteBuffer, ZstdDictDecompress paramZstdDictDecompress, int paramInt)
  {
    if (!paramByteBuffer.isDirect()) {
      throw new IllegalArgumentException("srcBuff must be a direct buffer");
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt);
    long l = decompressDirectByteBufferFastDict(localByteBuffer, 0, paramInt, paramByteBuffer, paramByteBuffer.position(), paramByteBuffer.limit(), paramZstdDictDecompress);
    if (isError(l)) {
      throw new RuntimeException(getErrorName(l));
    }
    paramByteBuffer.position(paramByteBuffer.limit());
    return localByteBuffer;
  }
  
  public static ByteBuffer decompress(ByteBuffer paramByteBuffer, byte[] paramArrayOfByte, int paramInt)
  {
    if (!paramByteBuffer.isDirect()) {
      throw new IllegalArgumentException("srcBuff must be a direct buffer");
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt);
    long l = decompressDirectByteBufferUsingDict(localByteBuffer, 0, paramInt, paramByteBuffer, paramByteBuffer.position(), paramByteBuffer.limit(), paramArrayOfByte);
    if (isError(l)) {
      throw new RuntimeException(getErrorName(l));
    }
    paramByteBuffer.position(paramByteBuffer.limit());
    return localByteBuffer;
  }
  
  public static byte[] decompress(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    long l = decompress(arrayOfByte, paramArrayOfByte);
    if (isError(l)) {
      throw new RuntimeException(getErrorName(l));
    }
    paramArrayOfByte = arrayOfByte;
    if (l != paramInt) {
      paramArrayOfByte = Arrays.copyOfRange(arrayOfByte, 0, (int)l);
    }
    return paramArrayOfByte;
  }
  
  public static byte[] decompress(byte[] paramArrayOfByte, ZstdDictDecompress paramZstdDictDecompress, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    long l = decompressFastDict(arrayOfByte, 0, paramArrayOfByte, 0, paramArrayOfByte.length, paramZstdDictDecompress);
    if (isError(l)) {
      throw new RuntimeException(getErrorName(l));
    }
    paramArrayOfByte = arrayOfByte;
    if (l != paramInt) {
      paramArrayOfByte = Arrays.copyOfRange(arrayOfByte, 0, (int)l);
    }
    return paramArrayOfByte;
  }
  
  public static byte[] decompress(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    long l = decompressUsingDict(arrayOfByte, 0, paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2);
    if (isError(l)) {
      throw new RuntimeException(getErrorName(l));
    }
    paramArrayOfByte1 = arrayOfByte;
    if (l != paramInt) {
      paramArrayOfByte1 = Arrays.copyOfRange(arrayOfByte, 0, (int)l);
    }
    return paramArrayOfByte1;
  }
  
  public static native long decompressByteArray(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4);
  
  public static native long decompressDirectByteBuffer(ByteBuffer paramByteBuffer1, int paramInt1, int paramInt2, ByteBuffer paramByteBuffer2, int paramInt3, int paramInt4);
  
  public static native long decompressDirectByteBufferFastDict(ByteBuffer paramByteBuffer1, int paramInt1, int paramInt2, ByteBuffer paramByteBuffer2, int paramInt3, int paramInt4, ZstdDictDecompress paramZstdDictDecompress);
  
  public static native long decompressDirectByteBufferUsingDict(ByteBuffer paramByteBuffer1, int paramInt1, int paramInt2, ByteBuffer paramByteBuffer2, int paramInt3, int paramInt4, byte[] paramArrayOfByte);
  
  public static native long decompressFastDict(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, ZstdDictDecompress paramZstdDictDecompress);
  
  public static native long decompressUsingDict(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, byte[] paramArrayOfByte3);
  
  @Deprecated
  public static long decompressUsingDict(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    return decompressUsingDict(paramArrayOfByte1, 0, paramArrayOfByte2, 0, paramArrayOfByte2.length, paramArrayOfByte3);
  }
  
  public static native long decompressedDirectByteBufferSize(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2);
  
  public static long decompressedSize(ByteBuffer paramByteBuffer)
  {
    return decompressedDirectByteBufferSize(paramByteBuffer, paramByteBuffer.position(), paramByteBuffer.limit() - paramByteBuffer.position());
  }
  
  public static native long decompressedSize(byte[] paramArrayOfByte);
  
  public static native String getErrorName(long paramLong);
  
  public static native boolean isError(long paramLong);
  
  public static long trainFromBuffer(byte[][] paramArrayOfByte, byte[] paramArrayOfByte1)
  {
    return trainFromBuffer(paramArrayOfByte, paramArrayOfByte1, false);
  }
  
  public static native long trainFromBuffer(byte[][] paramArrayOfByte, byte[] paramArrayOfByte1, boolean paramBoolean);
  
  public static long trainFromBufferDirect(ByteBuffer paramByteBuffer1, int[] paramArrayOfInt, ByteBuffer paramByteBuffer2)
  {
    return trainFromBufferDirect(paramByteBuffer1, paramArrayOfInt, paramByteBuffer2, false);
  }
  
  public static native long trainFromBufferDirect(ByteBuffer paramByteBuffer1, int[] paramArrayOfInt, ByteBuffer paramByteBuffer2, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mars.zstd.Zstd
 * JD-Core Version:    0.7.0.1
 */