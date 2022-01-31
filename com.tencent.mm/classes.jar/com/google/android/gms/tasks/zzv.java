package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;

final class zzv
  implements Runnable
{
  zzv(zzu paramzzu, Callable paramCallable) {}
  
  public final void run()
  {
    AppMethodBeat.i(57447);
    try
    {
      this.zzagj.setResult(this.val$callable.call());
      AppMethodBeat.o(57447);
      return;
    }
    catch (Exception localException)
    {
      this.zzagj.setException(localException);
      AppMethodBeat.o(57447);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.tasks.zzv
 * JD-Core Version:    0.7.0.1
 */