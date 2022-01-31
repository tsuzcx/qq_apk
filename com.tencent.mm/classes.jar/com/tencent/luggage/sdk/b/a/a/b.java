package com.tencent.luggage.sdk.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.FutureTask;

public class b
  implements Runnable
{
  private final FutureTask<?> bEf;
  
  public b(Runnable paramRunnable)
  {
    AppMethodBeat.i(140705);
    this.bEf = new FutureTask(paramRunnable, Integer.valueOf(0));
    AppMethodBeat.o(140705);
  }
  
  public void run()
  {
    AppMethodBeat.i(140706);
    this.bEf.run();
    AppMethodBeat.o(140706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */