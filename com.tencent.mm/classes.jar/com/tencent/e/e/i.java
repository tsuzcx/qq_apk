package com.tencent.e.e;

import android.os.Handler;
import android.os.Looper;
import com.tencent.e.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  implements g
{
  private Handler handler;
  
  public i()
  {
    AppMethodBeat.i(183314);
    this.handler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(183314);
  }
  
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(183315);
    if (Thread.currentThread().getId() == this.handler.getLooper().getThread().getId())
    {
      paramRunnable.run();
      AppMethodBeat.o(183315);
      return;
    }
    this.handler.post(paramRunnable);
    AppMethodBeat.o(183315);
  }
  
  public final String getTag()
  {
    AppMethodBeat.i(183316);
    String str = a.fol().tag;
    AppMethodBeat.o(183316);
    return str;
  }
  
  public final void onShutdown()
  {
    AppMethodBeat.i(183317);
    this.handler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(183317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.e.i
 * JD-Core Version:    0.7.0.1
 */