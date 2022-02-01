package com.bumptech.glide.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public final class d
  extends InputStream
{
  private static final Queue<d> aLp;
  private InputStream aLq;
  public IOException aLr;
  
  static
  {
    AppMethodBeat.i(77745);
    aLp = j.dy(0);
    AppMethodBeat.o(77745);
  }
  
  public static d e(InputStream paramInputStream)
  {
    AppMethodBeat.i(77734);
    synchronized (aLp)
    {
      d locald = (d)aLp.poll();
      ??? = locald;
      if (locald == null) {
        ??? = new d();
      }
      ((d)???).aLq = paramInputStream;
      AppMethodBeat.o(77734);
      return ???;
    }
  }
  
  public final int available()
  {
    AppMethodBeat.i(77735);
    int i = this.aLq.available();
    AppMethodBeat.o(77735);
    return i;
  }
  
  public final void close()
  {
    AppMethodBeat.i(77736);
    this.aLq.close();
    AppMethodBeat.o(77736);
  }
  
  public final void mark(int paramInt)
  {
    AppMethodBeat.i(77737);
    this.aLq.mark(paramInt);
    AppMethodBeat.o(77737);
  }
  
  public final boolean markSupported()
  {
    AppMethodBeat.i(77738);
    boolean bool = this.aLq.markSupported();
    AppMethodBeat.o(77738);
    return bool;
  }
  
  public final int read()
  {
    AppMethodBeat.i(77743);
    try
    {
      i = this.aLq.read();
      AppMethodBeat.o(77743);
      return i;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        this.aLr = localIOException;
        int i = -1;
      }
    }
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77739);
    try
    {
      i = this.aLq.read(paramArrayOfByte);
      AppMethodBeat.o(77739);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        this.aLr = paramArrayOfByte;
        int i = -1;
      }
    }
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77740);
    try
    {
      paramInt1 = this.aLq.read(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(77740);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        this.aLr = paramArrayOfByte;
        paramInt1 = -1;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(77744);
    this.aLr = null;
    this.aLq = null;
    synchronized (aLp)
    {
      aLp.offer(this);
      AppMethodBeat.o(77744);
      return;
    }
  }
  
  public final void reset()
  {
    try
    {
      AppMethodBeat.i(77741);
      this.aLq.reset();
      AppMethodBeat.o(77741);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long skip(long paramLong)
  {
    AppMethodBeat.i(77742);
    try
    {
      paramLong = this.aLq.skip(paramLong);
      AppMethodBeat.o(77742);
      return paramLong;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        this.aLr = localIOException;
        paramLong = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.h.d
 * JD-Core Version:    0.7.0.1
 */