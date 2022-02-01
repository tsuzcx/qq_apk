package com.tencent.mm.plugin.appbrand.y;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.FutureTask;

public class l
  implements Runnable
{
  private final FutureTask<?> cBu;
  
  public l(Runnable paramRunnable)
  {
    AppMethodBeat.i(201303);
    this.cBu = new FutureTask(paramRunnable, Integer.valueOf(0));
    AppMethodBeat.o(201303);
  }
  
  public void run()
  {
    AppMethodBeat.i(201304);
    this.cBu.run();
    AppMethodBeat.o(201304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.y.l
 * JD-Core Version:    0.7.0.1
 */