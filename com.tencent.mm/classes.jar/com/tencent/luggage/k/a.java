package com.tencent.luggage.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class a
  extends InputStream
{
  public final ByteBuffer cDP;
  private int cDQ;
  
  public a(ByteBuffer paramByteBuffer)
  {
    this.cDP = paramByteBuffer;
  }
  
  public static void f(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(140481);
    if (paramByteBuffer.getClass().getName().equals("java.nio.DirectByteBuffer")) {
      try
      {
        org.a.a.gY(org.a.a.gY(paramByteBuffer).bIz("cleaner").object).bIz("clean");
        AppMethodBeat.o(140481);
        return;
      }
      catch (Exception paramByteBuffer) {}
    }
    AppMethodBeat.o(140481);
  }
  
  public final ByteBuffer SE()
  {
    return this.cDP;
  }
  
  public final int available()
  {
    AppMethodBeat.i(140473);
    int i = this.cDP.remaining();
    AppMethodBeat.o(140473);
    return i;
  }
  
  public final void close()
  {
    AppMethodBeat.i(140476);
    super.close();
    f(this.cDP);
    AppMethodBeat.o(140476);
  }
  
  public final void mark(int paramInt)
  {
    try
    {
      AppMethodBeat.i(140477);
      this.cDQ = this.cDP.position();
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
    if (this.cDP.hasRemaining())
    {
      int i = this.cDP.get();
      AppMethodBeat.o(140474);
      return i & 0xFF;
    }
    AppMethodBeat.o(140474);
    return -1;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140475);
    if (!this.cDP.hasRemaining())
    {
      AppMethodBeat.o(140475);
      return -1;
    }
    paramInt2 = Math.min(paramInt2, this.cDP.remaining());
    this.cDP.get(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(140475);
    return paramInt2;
  }
  
  public final void reset()
  {
    try
    {
      AppMethodBeat.i(140479);
      this.cDP.position(this.cDQ);
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
      this.cDP.position(paramInt);
      AppMethodBeat.o(140478);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long sr()
  {
    AppMethodBeat.i(140480);
    long l = this.cDP.limit();
    AppMethodBeat.o(140480);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.k.a
 * JD-Core Version:    0.7.0.1
 */