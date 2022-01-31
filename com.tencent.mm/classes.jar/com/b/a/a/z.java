package com.b.a.a;

import android.os.Handler;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

final class z
{
  private static z bsE;
  private static final SparseArray<z> bsF;
  private final ExecutorService bsG;
  private final Handler handler;
  
  static
  {
    AppMethodBeat.i(55674);
    bsF = new SparseArray();
    AppMethodBeat.o(55674);
  }
  
  private z(Handler paramHandler)
  {
    AppMethodBeat.i(55675);
    if (paramHandler != null) {}
    for (this.bsG = null;; this.bsG = Executors.newSingleThreadExecutor())
    {
      this.handler = paramHandler;
      AppMethodBeat.o(55675);
      return;
    }
  }
  
  static z b(Handler paramHandler)
  {
    AppMethodBeat.i(55676);
    if (paramHandler != null)
    {
      int i = paramHandler.getLooper().hashCode();
      z localz2 = (z)bsF.get(i);
      z localz1 = localz2;
      if (localz2 == null)
      {
        localz1 = new z(paramHandler);
        bsF.put(i, localz1);
      }
      AppMethodBeat.o(55676);
      return localz1;
    }
    if (bsE == null) {
      bsE = new z(null);
    }
    paramHandler = bsE;
    AppMethodBeat.o(55676);
    return paramHandler;
  }
  
  final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(55677);
    if (this.handler != null)
    {
      this.handler.post(paramRunnable);
      AppMethodBeat.o(55677);
      return;
    }
    this.bsG.execute(paramRunnable);
    AppMethodBeat.o(55677);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.b.a.a.z
 * JD-Core Version:    0.7.0.1
 */