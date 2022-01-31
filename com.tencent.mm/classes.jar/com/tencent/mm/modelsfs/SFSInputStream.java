package com.tencent.mm.modelsfs;

import java.io.IOException;
import java.io.InputStream;

public class SFSInputStream
  extends InputStream
{
  private long asE = 0L;
  private long mNativePtr;
  
  public SFSInputStream(long paramLong)
  {
    this.mNativePtr = paramLong;
  }
  
  private static native int nativeClose(long paramLong);
  
  private static native int nativeRead(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private static native long nativeSeek(long paramLong1, long paramLong2, int paramInt);
  
  private static native long nativeSize(long paramLong);
  
  public int available()
  {
    if (this.mNativePtr == 0L) {
      throw new IOException("Stream already closed.");
    }
    long l1 = nativeSize(this.mNativePtr);
    if (l1 < 0L) {
      throw new IOException(SFSContext.nativeErrorMessage());
    }
    long l2 = nativeSeek(this.mNativePtr, 0L, 1);
    if (l2 < 0L) {
      throw new IOException(SFSContext.nativeErrorMessage());
    }
    return (int)(l1 - l2);
  }
  
  public void close()
  {
    if (this.mNativePtr == 0L) {
      return;
    }
    if (nativeClose(this.mNativePtr) == -1) {
      throw new IOException(SFSContext.nativeErrorMessage());
    }
    this.mNativePtr = 0L;
  }
  
  protected void finalize()
  {
    if (this.mNativePtr != 0L) {
      close();
    }
    super.finalize();
  }
  
  public void mark(int paramInt)
  {
    if (this.mNativePtr == 0L) {
      return;
    }
    this.asE = nativeSeek(this.mNativePtr, 0L, 1);
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public int read()
  {
    if (this.mNativePtr == 0L) {
      throw new IOException("Stream already closed.");
    }
    byte[] arrayOfByte = new byte[1];
    int i;
    do
    {
      i = nativeRead(this.mNativePtr, arrayOfByte, 0, 1);
    } while (i == 0);
    if (i == -1) {
      return -1;
    }
    return arrayOfByte[0];
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.mNativePtr == 0L) {
      throw new IOException("Stream already closed.");
    }
    if (((paramInt1 | paramInt2) < 0) || (paramInt1 > paramArrayOfByte.length) || (paramArrayOfByte.length - paramInt1 < paramInt2)) {
      throw new ArrayIndexOutOfBoundsException("length = " + paramArrayOfByte.length + ", offset = " + paramInt1 + ", count = " + paramInt2);
    }
    paramInt1 = nativeRead(this.mNativePtr, paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 == 0) {
      return -1;
    }
    if (paramInt1 == -1) {
      throw new IOException(SFSContext.nativeErrorMessage());
    }
    return paramInt1;
  }
  
  public void reset()
  {
    if (this.mNativePtr == 0L) {
      throw new IOException("Stream already closed.");
    }
    if (this.asE < 0L) {
      throw new IOException("Previous call to mark() failed.");
    }
    if (nativeSeek(this.mNativePtr, this.asE, 0) != this.asE) {
      throw new IOException("Seeking to previous position failed.");
    }
  }
  
  public long skip(long paramLong)
  {
    if (this.mNativePtr == 0L) {
      throw new IOException("Stream already closed.");
    }
    if (paramLong < 0L) {
      throw new IOException("byteCount < 0: " + paramLong);
    }
    long l = nativeSeek(this.mNativePtr, 0L, 1);
    paramLong = nativeSeek(this.mNativePtr, paramLong, 1);
    if ((l == -1L) || (paramLong == -1L)) {
      throw new IOException(SFSContext.nativeErrorMessage());
    }
    return paramLong - l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsfs.SFSInputStream
 * JD-Core Version:    0.7.0.1
 */