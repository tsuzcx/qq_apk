package com.tencent.mm.memory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.SynchronizedPool;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.nio.ByteBuffer;

public final class h
  extends SynchronizedPool<ByteBuffer>
{
  public static h itz;
  
  static
  {
    AppMethodBeat.i(156425);
    itz = new h();
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(156424);
        int i = 0;
        while (i < 10)
        {
          h.a(h.itz, ByteBuffer.allocate(16384));
          i += 1;
        }
        AppMethodBeat.o(156424);
      }
    }, "DecodeTempStorage_preload");
    AppMethodBeat.o(156425);
  }
  
  private h()
  {
    super(20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.memory.h
 * JD-Core Version:    0.7.0.1
 */