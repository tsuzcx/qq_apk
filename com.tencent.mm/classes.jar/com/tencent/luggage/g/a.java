package com.tencent.luggage.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class a
  extends InputStream
{
  public final ByteBuffer bFu;
  private int bFv;
  
  public a(ByteBuffer paramByteBuffer)
  {
    this.bFu = paramByteBuffer;
  }
  
  public static void f(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(90872);
    if (paramByteBuffer.getClass().getName().equals("java.nio.DirectByteBuffer")) {}
    try
    {
      org.a.a.ep(paramByteBuffer).azS("free");
      System.gc();
      AppMethodBeat.o(90872);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.v("MicroMsg.ByteBufferBackedInputStream", "free() try reflect free e = %s", new Object[] { localException });
        try
        {
          org.a.a.ep(org.a.a.ep(paramByteBuffer).azS("cleaner").object).azS("clean");
        }
        catch (Exception paramByteBuffer)
        {
          ab.v("MicroMsg.ByteBufferBackedInputStream", "free() try reflect cleaner e = %s", new Object[] { paramByteBuffer });
        }
      }
    }
  }
  
  public final int available()
  {
    AppMethodBeat.i(90864);
    int i = this.bFu.remaining();
    AppMethodBeat.o(90864);
    return i;
  }
  
  public final void close()
  {
    AppMethodBeat.i(90867);
    super.close();
    f(this.bFu);
    AppMethodBeat.o(90867);
  }
  
  public final long getLength()
  {
    AppMethodBeat.i(90871);
    long l = this.bFu.limit();
    AppMethodBeat.o(90871);
    return l;
  }
  
  public final void mark(int paramInt)
  {
    try
    {
      AppMethodBeat.i(90868);
      this.bFv = this.bFu.position();
      AppMethodBeat.o(90868);
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
    AppMethodBeat.i(90865);
    if (this.bFu.hasRemaining())
    {
      int i = this.bFu.get();
      AppMethodBeat.o(90865);
      return i & 0xFF;
    }
    AppMethodBeat.o(90865);
    return -1;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90866);
    if (!this.bFu.hasRemaining())
    {
      AppMethodBeat.o(90866);
      return -1;
    }
    paramInt2 = Math.min(paramInt2, this.bFu.remaining());
    this.bFu.get(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(90866);
    return paramInt2;
  }
  
  public final void reset()
  {
    try
    {
      AppMethodBeat.i(90870);
      this.bFu.position(this.bFv);
      AppMethodBeat.o(90870);
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
      AppMethodBeat.i(90869);
      this.bFu.position(paramInt);
      AppMethodBeat.o(90869);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.g.a
 * JD-Core Version:    0.7.0.1
 */