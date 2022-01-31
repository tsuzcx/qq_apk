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
    AppMethodBeat.i(72336);
    int i = this.input.available();
    AppMethodBeat.o(72336);
    return i;
  }
  
  public final void close()
  {
    AppMethodBeat.i(72337);
    try
    {
      this.input.close();
      return;
    }
    finally
    {
      this.output.close();
      AppMethodBeat.o(72337);
    }
  }
  
  public final void mark(int paramInt)
  {
    AppMethodBeat.i(72338);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(72338);
    throw localUnsupportedOperationException;
  }
  
  public final boolean markSupported()
  {
    return false;
  }
  
  public final int read()
  {
    AppMethodBeat.i(72340);
    int i = this.input.read();
    if (i >= 0) {
      this.output.write(i);
    }
    AppMethodBeat.o(72340);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(72339);
    int i = this.input.read(paramArrayOfByte);
    if (i > 0) {
      this.output.write(paramArrayOfByte, 0, i);
    }
    AppMethodBeat.o(72339);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(72341);
    paramInt2 = this.input.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt2 > 0) {
      this.output.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    AppMethodBeat.o(72341);
    return paramInt2;
  }
  
  public final void reset()
  {
    try
    {
      AppMethodBeat.i(72342);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(72342);
      throw localUnsupportedOperationException;
    }
    finally {}
  }
  
  public final long skip(long paramLong)
  {
    AppMethodBeat.i(72343);
    byte[] arrayOfByte = new byte[1024];
    int i;
    for (long l = 0L; l < paramLong; l += i)
    {
      i = read(arrayOfByte, 0, (int)Math.min(paramLong - l, 1024L));
      if (i < 0)
      {
        AppMethodBeat.o(72343);
        return l;
      }
    }
    AppMethodBeat.o(72343);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.internal.FileLruCache.CopyingInputStream
 * JD-Core Version:    0.7.0.1
 */