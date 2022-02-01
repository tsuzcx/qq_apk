package com.google.android.gms.common.util.concurrent;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

public class HandlerExecutor
  implements Executor
{
  private final Handler handler;
  
  public HandlerExecutor(Handler paramHandler)
  {
    this(paramHandler.getLooper());
    AppMethodBeat.i(5319);
    AppMethodBeat.o(5319);
  }
  
  public HandlerExecutor(Looper paramLooper)
  {
    AppMethodBeat.i(5320);
    this.handler = new Handler(paramLooper);
    AppMethodBeat.o(5320);
  }
  
  public void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(5321);
    this.handler.post(paramRunnable);
    AppMethodBeat.o(5321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.util.concurrent.HandlerExecutor
 * JD-Core Version:    0.7.0.1
 */