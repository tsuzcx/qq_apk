package com.facebook.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;

final class FileLruCache$CopyingInputStream
  extends InputStream
{
  final InputStream input;
  final OutputStream output;
  
  FileLruCache$CopyingInputStream(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    this.input = paramInputStream;
    this.output = paramOutputStream;
  }
  
  public final int available()
  {
    AppMethodBeat.i(17772);
    int i = this.input.available();
    AppMethodBeat.o(17772);
    return i;
  }
  
  public final void close()
  {
    AppMethodBeat.i(17773);
    try
    {
      this.input.close();
      return;
    }
    finally
    {
      this.output.close();
      AppMethodBeat.o(17773);
    }
  }
  
  public final void mark(int paramInt)
  {
    AppMethodBeat.i(17774);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(17774);
    throw localUnsupportedOperationException;
  }
  
  public final boolean markSupported()
  {
    return false;
  }
  
  public final int read()
  {
    AppMethodBeat.i(17776);
    int i = this.input.read();
    if (i >= 0) {
      this.output.write(i);
    }
    AppMethodBeat.o(17776);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(17775);
    int i = this.input.read(paramArrayOfByte);
    if (i > 0) {
      this.output.write(paramArrayOfByte, 0, i);
    }
    AppMethodBeat.o(17775);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(17777);
    paramInt2 = this.input.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt2 > 0) {
      this.output.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    AppMethodBeat.o(17777);
    return paramInt2;
  }
  
  public final void reset()
  {
    try
    {
      AppMethodBeat.i(17778);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(17778);
      throw localUnsupportedOperationException;
    }
    finally {}
  }
  
  public final long skip(long paramLong)
  {
    AppMethodBeat.i(17779);
    byte[] arrayOfByte = new byte[1024];
    int i;
    for (long l = 0L; l < paramLong; l += i)
    {
      i = read(arrayOfByte, 0, (int)Math.min(paramLong - l, 1024L));
      if (i < 0)
      {
        AppMethodBeat.o(17779);
        return l;
      }
    }
    AppMethodBeat.o(17779);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.internal.FileLruCache.CopyingInputStream
 * JD-Core Version:    0.7.0.1
 */