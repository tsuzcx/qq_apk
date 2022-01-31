package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

final class zzr<TResult>
{
  private final Object mLock;
  @GuardedBy("mLock")
  private Queue<zzq<TResult>> zzaga;
  @GuardedBy("mLock")
  private boolean zzagb;
  
  zzr()
  {
    AppMethodBeat.i(57408);
    this.mLock = new Object();
    AppMethodBeat.o(57408);
  }
  
  public final void zza(Task<TResult> paramTask)
  {
    AppMethodBeat.i(57410);
    synchronized (this.mLock)
    {
      if ((this.zzaga == null) || (this.zzagb))
      {
        AppMethodBeat.o(57410);
        return;
      }
      this.zzagb = true;
    }
    synchronized (this.mLock)
    {
      zzq localzzq = (zzq)this.zzaga.poll();
      if (localzzq == null)
      {
        this.zzagb = false;
        AppMethodBeat.o(57410);
        return;
        paramTask = finally;
        AppMethodBeat.o(57410);
        throw paramTask;
      }
      localzzq.onComplete(paramTask);
    }
  }
  
  public final void zza(zzq<TResult> paramzzq)
  {
    AppMethodBeat.i(57409);
    synchronized (this.mLock)
    {
      if (this.zzaga == null) {
        this.zzaga = new ArrayDeque();
      }
      this.zzaga.add(paramzzq);
      AppMethodBeat.o(57409);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.tasks.zzr
 * JD-Core Version:    0.7.0.1
 */