package com.tencent.luggage.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class a
  extends InputStream
{
  public final ByteBuffer cjb;
  private int cjc;
  
  public a(ByteBuffer paramByteBuffer)
  {
    this.cjb = paramByteBuffer;
  }
  
  public static void i(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(140481);
    if (paramByteBuffer.getClass().getName().equals("java.nio.DirectByteBuffer")) {
      try
      {
        org.a.a.fU(org.a.a.fU(paramByteBuffer).aRD("cleaner").object).aRD("clean");
        AppMethodBeat.o(140481);
        return;
      }
      catch (Exception paramByteBuffer) {}
    }
    AppMethodBeat.o(140481);
  }
  
  public final int available()
  {
    AppMethodBeat.i(140473);
    int i = this.cjb.remaining();
    AppMethodBeat.o(140473);
    return i;
  }
  
  public final void close()
  {
    AppMethodBeat.i(140476);
    super.close();
    i(this.cjb);
    AppMethodBeat.o(140476);
  }
  
  public final long getLength()
  {
    AppMethodBeat.i(140480);
    long l = this.cjb.limit();
    AppMethodBeat.o(140480);
    return l;
  }
  
  public final void mark(int paramInt)
  {
    try
    {
      AppMethodBeat.i(140477);
      this.cjc = this.cjb.position();
      AppMethodBeat.o(140477);
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
    AppMethodBeat.i(140474);
    if (this.cjb.hasRemaining())
    {
      int i = this.cjb.get();
      AppMethodBeat.o(140474);
      return i & 0xFF;
    }
    AppMethodBeat.o(140474);
    return -1;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140475);
    if (!this.cjb.hasRemaining())
    {
      AppMethodBeat.o(140475);
      return -1;
    }
    paramInt2 = Math.min(paramInt2, this.cjb.remaining());
    this.cjb.get(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(140475);
    return paramInt2;
  }
  
  public final void reset()
  {
    try
    {
      AppMethodBeat.i(140479);
      this.cjb.position(this.cjc);
      AppMethodBeat.o(140479);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void seek(int paramInt)
  {
    try
    {
      AppMethodBeat.i(140478);
      this.cjb.position(paramInt);
      AppMethodBeat.o(140478);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.h.a
 * JD-Core Version:    0.7.0.1
 */