package com.tencent.mm.memory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.SynchronizedPool;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.nio.ByteBuffer;

public final class g
  extends SynchronizedPool<ByteBuffer>
{
  public static g nNt;
  
  static
  {
    AppMethodBeat.i(156425);
    nNt = new g();
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(156424);
        int i = 0;
        while (i < 10)
        {
          g.a(g.nNt, ByteBuffer.allocate(16384));
          i += 1;
        }
        AppMethodBeat.o(156424);
      }
    }, "DecodeTempStorage_preload");
    AppMethodBeat.o(156425);
  }
  
  private g()
  {
    super(20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.memory.g
 * JD-Core Version:    0.7.0.1
 */