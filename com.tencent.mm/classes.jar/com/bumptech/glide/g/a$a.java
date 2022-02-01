package com.bumptech.glide.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

final class a$a
  extends InputStream
{
  private int aNL = -1;
  private final ByteBuffer byteBuffer;
  
  a$a(ByteBuffer paramByteBuffer)
  {
    this.byteBuffer = paramByteBuffer;
  }
  
  public final int available()
  {
    AppMethodBeat.i(77711);
    int i = this.byteBuffer.remaining();
    AppMethodBeat.o(77711);
    return i;
  }
  
  public final void mark(int paramInt)
  {
    try
    {
      AppMethodBeat.i(77713);
      this.aNL = this.byteBuffer.position();
      AppMethodBeat.o(77713);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean markSupported()
  {
    return true;
  }
  
  public final int read()
  {
    AppMethodBeat.i(77712);
    if (!this.byteBuffer.hasRemaining())
    {
      AppMethodBeat.o(77712);
      return -1;
    }
    int i = this.byteBuffer.get();
    AppMethodBeat.o(77712);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77714);
    if (!this.byteBuffer.hasRemaining())
    {
      AppMethodBeat.o(77714);
      return -1;
    }
    paramInt2 = Math.min(paramInt2, available());
    this.byteBuffer.get(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(77714);
    return paramInt2;
  }
  
  public final void reset()
  {
    try
    {
      AppMethodBeat.i(77715);
      if (this.aNL == -1)
      {
        IOException localIOException = new IOException("Cannot reset to unset mark position");
        AppMethodBeat.o(77715);
        throw localIOException;
      }
    }
    finally {}
    this.byteBuffer.position(this.aNL);
    AppMethodBeat.o(77715);
  }
  
  public final long skip(long paramLong)
  {
    AppMethodBeat.i(77716);
    if (!this.byteBuffer.hasRemaining())
    {
      AppMethodBeat.o(77716);
      return -1L;
    }
    paramLong = Math.min(paramLong, available());
    this.byteBuffer.position((int)(this.byteBuffer.position() + paramLong));
    AppMethodBeat.o(77716);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.bumptech.glide.g.a.a
 * JD-Core Version:    0.7.0.1
 */