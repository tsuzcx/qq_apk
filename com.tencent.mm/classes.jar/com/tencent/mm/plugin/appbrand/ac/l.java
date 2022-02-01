package com.tencent.mm.plugin.appbrand.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.FutureTask;

public class l
  implements Runnable
{
  private final FutureTask<?> cQn;
  
  public l(Runnable paramRunnable)
  {
    AppMethodBeat.i(208764);
    this.cQn = new FutureTask(paramRunnable, Integer.valueOf(0));
    AppMethodBeat.o(208764);
  }
  
  public void run()
  {
    AppMethodBeat.i(208765);
    this.cQn.run();
    AppMethodBeat.o(208765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ac.l
 * JD-Core Version:    0.7.0.1
 */