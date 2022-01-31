package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedOutputStream;
import java.io.OutputStream;

public final class q
  extends BufferedOutputStream
{
  private boolean closed;
  
  public q(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  public q(OutputStream paramOutputStream, int paramInt)
  {
    super(paramOutputStream, paramInt);
  }
  
  public final void a(OutputStream paramOutputStream)
  {
    AppMethodBeat.i(152029);
    a.checkState(this.closed);
    this.out = paramOutputStream;
    this.count = 0;
    this.closed = false;
    AppMethodBeat.o(152029);
  }
  
  public final void close()
  {
    AppMethodBeat.i(152028);
    this.closed = true;
    Object localObject1 = null;
    try
    {
      flush();
      try
      {
        label16:
        this.out.close();
        localObject2 = localObject1;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          Object localObject2;
          if (localObject1 != null) {
            Object localObject3 = localObject1;
          }
        }
      }
      if (localObject2 != null) {
        x.d(localObject2);
      }
      AppMethodBeat.o(152028);
      return;
    }
    catch (Throwable localThrowable1)
    {
      break label16;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.i.q
 * JD-Core Version:    0.7.0.1
 */