package com.tencent.mm.memory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

final class h$1
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(115378);
    int i = 0;
    while (i < 10)
    {
      h.a(h.fdJ, ByteBuffer.allocate(16384));
      i += 1;
    }
    AppMethodBeat.o(115378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.memory.h.1
 * JD-Core Version:    0.7.0.1
 */