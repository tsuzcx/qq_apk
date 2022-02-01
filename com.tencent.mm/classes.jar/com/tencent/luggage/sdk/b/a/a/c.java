package com.tencent.luggage.sdk.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.FutureTask;

public class c
  implements Runnable
{
  private final FutureTask<?> cdt;
  
  public c(Runnable paramRunnable)
  {
    AppMethodBeat.i(146755);
    this.cdt = new FutureTask(paramRunnable, Integer.valueOf(0));
    AppMethodBeat.o(146755);
  }
  
  public void run()
  {
    AppMethodBeat.i(146756);
    this.cdt.run();
    AppMethodBeat.o(146756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.c
 * JD-Core Version:    0.7.0.1
 */