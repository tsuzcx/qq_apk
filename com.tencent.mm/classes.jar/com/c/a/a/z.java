package com.c.a.a;

import android.os.Handler;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

final class z
{
  private static z bUZ;
  private static final SparseArray<z> bVa;
  private final ExecutorService bVb;
  private final Handler handler;
  
  static
  {
    AppMethodBeat.i(88019);
    bVa = new SparseArray();
    AppMethodBeat.o(88019);
  }
  
  private z(Handler paramHandler)
  {
    AppMethodBeat.i(88020);
    if (paramHandler != null) {}
    for (this.bVb = null;; this.bVb = Executors.newSingleThreadExecutor())
    {
      this.handler = paramHandler;
      AppMethodBeat.o(88020);
      return;
    }
  }
  
  static z b(Handler paramHandler)
  {
    AppMethodBeat.i(88021);
    if (paramHandler != null)
    {
      int i = paramHandler.getLooper().hashCode();
      z localz2 = (z)bVa.get(i);
      z localz1 = localz2;
      if (localz2 == null)
      {
        localz1 = new z(paramHandler);
        bVa.put(i, localz1);
      }
      AppMethodBeat.o(88021);
      return localz1;
    }
    if (bUZ == null) {
      bUZ = new z(null);
    }
    paramHandler = bUZ;
    AppMethodBeat.o(88021);
    return paramHandler;
  }
  
  final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(88022);
    if (this.handler != null)
    {
      this.handler.post(paramRunnable);
      AppMethodBeat.o(88022);
      return;
    }
    this.bVb.execute(paramRunnable);
    AppMethodBeat.o(88022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.c.a.a.z
 * JD-Core Version:    0.7.0.1
 */