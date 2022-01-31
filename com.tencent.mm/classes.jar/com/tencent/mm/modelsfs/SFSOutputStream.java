package com.tencent.mm.modelsfs;

import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.io.OutputStream;

public class SFSOutputStream
  extends OutputStream
{
  private StackTraceElement[] eyN;
  private long mNativePtr;
  
  public SFSOutputStream(long paramLong)
  {
    this.mNativePtr = paramLong;
    this.eyN = Thread.currentThread().getStackTrace();
  }
  
  private static native int nativeClose(long paramLong);
  
  private static native int nativeWrite(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
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
    if (this.mNativePtr != 0L)
    {
      StringBuilder localStringBuilder = new StringBuilder("SFSOutputStream leaked:\n");
      StackTraceElement[] arrayOfStackTraceElement = this.eyN;
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(arrayOfStackTraceElement[i].toString()).append('\n');
        i += 1;
      }
      y.e("MicroMsg.SFSOutputStream", localStringBuilder.toString());
      close();
    }
    super.finalize();
  }
  
  public void write(int paramInt)
  {
    if (this.mNativePtr == 0L) {
      throw new IOException("Stream already closed.");
    }
    int i = (byte)paramInt;
    if (nativeWrite(this.mNativePtr, new byte[] { i }, 0, 1) != 1) {
      throw new IOException(SFSContext.nativeErrorMessage());
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.mNativePtr == 0L) {
      throw new IOException("Stream already closed.");
    }
    if (((paramInt1 | paramInt2) < 0) || (paramInt1 > paramArrayOfByte.length) || (paramArrayOfByte.length - paramInt1 < paramInt2)) {
      throw new ArrayIndexOutOfBoundsException("length = " + paramArrayOfByte.length + "offset = " + paramInt1 + "count = " + paramInt2);
    }
    if (nativeWrite(this.mNativePtr, paramArrayOfByte, paramInt1, paramInt2) != paramInt2) {
      throw new IOException(SFSContext.nativeErrorMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsfs.SFSOutputStream
 * JD-Core Version:    0.7.0.1
 */