package com.tencent.mm.memory;

import java.nio.ByteBuffer;

final class h$1
  implements Runnable
{
  public final void run()
  {
    int i = 0;
    while (i < 10)
    {
      h.a(h.dPc, ByteBuffer.allocate(16384));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.memory.h.1
 * JD-Core Version:    0.7.0.1
 */