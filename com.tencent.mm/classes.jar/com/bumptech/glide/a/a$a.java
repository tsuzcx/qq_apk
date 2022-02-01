package com.bumptech.glide.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;

final class a$a
  implements ThreadFactory
{
  public final Thread newThread(Runnable paramRunnable)
  {
    try
    {
      AppMethodBeat.i(100647);
      paramRunnable = new Thread(paramRunnable, "glide-disk-lru-cache-thread");
      paramRunnable.setPriority(1);
      AppMethodBeat.o(100647);
      return paramRunnable;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.bumptech.glide.a.a.a
 * JD-Core Version:    0.7.0.1
 */