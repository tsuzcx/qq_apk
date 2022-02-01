package com.tencent.mm.plugin.appbrand.z;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.FutureTask;

public class l
  implements Runnable
{
  private final FutureTask<?> cAN;
  
  public l(Runnable paramRunnable)
  {
    AppMethodBeat.i(187736);
    this.cAN = new FutureTask(paramRunnable, Integer.valueOf(0));
    AppMethodBeat.o(187736);
  }
  
  public void run()
  {
    AppMethodBeat.i(187737);
    this.cAN.run();
    AppMethodBeat.o(187737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.z.l
 * JD-Core Version:    0.7.0.1
 */