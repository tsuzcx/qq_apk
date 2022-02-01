package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.io.OutputStream;

public class SFSOutputStream
  extends OutputStream
{
  private StackTraceElement[] lYS;
  private long mNativePtr;
  
  public SFSOutputStream(long paramLong)
  {
    AppMethodBeat.i(156032);
    this.mNativePtr = paramLong;
    this.lYS = Thread.currentThread().getStackTrace();
    AppMethodBeat.o(156032);
  }
  
  private static native int nativeClose(long paramLong);
  
  private static native int nativeWrite(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public void close()
  {
    AppMethodBeat.i(156033);
    if (this.mNativePtr == 0L)
    {
      AppMethodBeat.o(156033);
      return;
    }
    if (nativeClose(this.mNativePtr) == -1)
    {
      IOException localIOException = new IOException(SFSContext.nativeErrorMessage());
      AppMethodBeat.o(156033);
      throw localIOException;
    }
    this.mNativePtr = 0L;
    AppMethodBeat.o(156033);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(156036);
    if (this.mNativePtr != 0L)
    {
      StringBuilder localStringBuilder = new StringBuilder("SFSOutputStream leaked:\n");
      StackTraceElement[] arrayOfStackTraceElement = this.lYS;
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(arrayOfStackTraceElement[i].toString()).append('\n');
        i += 1;
      }
      Log.e("MicroMsg.SFSOutputStream", localStringBuilder.toString());
      close();
    }
    super.finalize();
    AppMethodBeat.o(156036);
  }
  
  public void write(int paramInt)
  {
    AppMethodBeat.i(156034);
    IOException localIOException;
    if (this.mNativePtr == 0L)
    {
      localIOException = new IOException("Stream already closed.");
      AppMethodBeat.o(156034);
      throw localIOException;
    }
    int i = (byte)paramInt;
    if (nativeWrite(this.mNativePtr, new byte[] { i }, 0, 1) != 1)
    {
      localIOException = new IOException(SFSContext.nativeErrorMessage());
      AppMethodBeat.o(156034);
      throw localIOException;
    }
    AppMethodBeat.o(156034);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(156035);
    if (this.mNativePtr == 0L)
    {
      paramArrayOfByte = new IOException("Stream already closed.");
      AppMethodBeat.o(156035);
      throw paramArrayOfByte;
    }
    if (((paramInt1 | paramInt2) < 0) || (paramInt1 > paramArrayOfByte.length) || (paramArrayOfByte.length - paramInt1 < paramInt2))
    {
      paramArrayOfByte = new ArrayIndexOutOfBoundsException("length = " + paramArrayOfByte.length + "offset = " + paramInt1 + "count = " + paramInt2);
      AppMethodBeat.o(156035);
      throw paramArrayOfByte;
    }
    if (nativeWrite(this.mNativePtr, paramArrayOfByte, paramInt1, paramInt2) != paramInt2)
    {
      paramArrayOfByte = new IOException(SFSContext.nativeErrorMessage());
      AppMethodBeat.o(156035);
      throw paramArrayOfByte;
    }
    AppMethodBeat.o(156035);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelsfs.SFSOutputStream
 * JD-Core Version:    0.7.0.1
 */