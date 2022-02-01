package com.tencent.mm.plugin.appbrand.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.FutureTask;

public class l
  implements Runnable
{
  private final FutureTask<?> cPv;
  
  public l(Runnable paramRunnable)
  {
    AppMethodBeat.i(221348);
    this.cPv = new FutureTask(paramRunnable, Integer.valueOf(0));
    AppMethodBeat.o(221348);
  }
  
  public void run()
  {
    AppMethodBeat.i(221349);
    this.cPv.run();
    AppMethodBeat.o(221349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ac.l
 * JD-Core Version:    0.7.0.1
 */