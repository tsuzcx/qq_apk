package com.tencent.mm.plugin.appbrand.af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.FutureTask;

public class n
  implements Runnable
{
  private final FutureTask<?> eLr;
  
  public n(Runnable paramRunnable)
  {
    AppMethodBeat.i(318712);
    this.eLr = new FutureTask(paramRunnable, Integer.valueOf(0));
    AppMethodBeat.o(318712);
  }
  
  public void run()
  {
    AppMethodBeat.i(318715);
    this.eLr.run();
    AppMethodBeat.o(318715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.af.n
 * JD-Core Version:    0.7.0.1
 */