package com.bumptech.glide.g;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

public final class e
{
  private static final Executor aNQ;
  private static final Executor aNR;
  
  static
  {
    AppMethodBeat.i(204496);
    aNQ = new Executor()
    {
      private final Handler handler;
      
      public final void execute(Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(204494);
        this.handler.post(paramAnonymousRunnable);
        AppMethodBeat.o(204494);
      }
    };
    aNR = new Executor()
    {
      public final void execute(Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(204495);
        paramAnonymousRunnable.run();
        AppMethodBeat.o(204495);
      }
    };
    AppMethodBeat.o(204496);
  }
  
  public static Executor qr()
  {
    return aNQ;
  }
  
  public static Executor qs()
  {
    return aNR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.bumptech.glide.g.e
 * JD-Core Version:    0.7.0.1
 */