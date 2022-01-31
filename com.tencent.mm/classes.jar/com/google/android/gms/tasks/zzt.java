package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

final class zzt
  implements Executor
{
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(57412);
    paramRunnable.run();
    AppMethodBeat.o(57412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.tasks.zzt
 * JD-Core Version:    0.7.0.1
 */