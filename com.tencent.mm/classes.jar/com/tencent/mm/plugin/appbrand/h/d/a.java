package com.tencent.mm.plugin.appbrand.h.d;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import rx.g;
import rx.schedulers.Schedulers;

public class a
  implements Executor
{
  private static a jjT;
  private final g jjU;
  private final Handler mHandler;
  
  private a()
  {
    AppMethodBeat.i(159030);
    this.mHandler = new Handler(Looper.getMainLooper());
    this.jjU = Schedulers.from(this);
    AppMethodBeat.o(159030);
  }
  
  public static g aVc()
  {
    AppMethodBeat.i(159031);
    if (jjT == null) {}
    try
    {
      if (jjT == null) {
        jjT = new a();
      }
      g localg = jjT.jjU;
      AppMethodBeat.o(159031);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(159031);
    }
  }
  
  public void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(159032);
    this.mHandler.post(paramRunnable);
    AppMethodBeat.o(159032);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.d.a
 * JD-Core Version:    0.7.0.1
 */