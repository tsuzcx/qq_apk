package com.tencent.mm.media.widget.d;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/util/CameraReportHelper;", "", "()V", "TAG", "", "futureTask", "Ljava/util/concurrent/FutureTask;", "", "checkAndReportCamera2Info", "", "CameraInfo", "plugin-mediaeditor_release"})
public final class d
{
  private static FutureTask<Integer> cCU;
  public static final d lit;
  
  static
  {
    AppMethodBeat.i(258563);
    lit = new d();
    AppMethodBeat.o(258563);
  }
  
  public static void baH()
  {
    AppMethodBeat.i(258559);
    cCU = new FutureTask((Callable)b.liw);
    h.ZvG.be((Runnable)c.lix);
    AppMethodBeat.o(258559);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "call"})
  static final class b<V>
    implements Callable<Integer>
  {
    public static final b liw;
    
    static
    {
      AppMethodBeat.i(263345);
      liw = new b();
      AppMethodBeat.o(263345);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    public static final c lix;
    
    static
    {
      AppMethodBeat.i(261386);
      lix = new c();
      AppMethodBeat.o(261386);
    }
    
    public final void run()
    {
      AppMethodBeat.i(261384);
      Object localObject = h.ZvG;
      d locald2 = d.lit;
      ((i)localObject).be((Runnable)d.baI());
      try
      {
        localObject = d.lit;
        d.baI().get(10L, TimeUnit.SECONDS);
        AppMethodBeat.o(261384);
        return;
      }
      catch (TimeoutException localTimeoutException)
      {
        Log.e("MicroMsg.CameraReportHelper", "futureTask TimeoutException cancel");
        d locald1 = d.lit;
        if (!d.baI().isCancelled())
        {
          locald1 = d.lit;
          if (!d.baI().isDone())
          {
            locald1 = d.lit;
            d.baI().cancel(true);
            AppMethodBeat.o(261384);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.CameraReportHelper", "futureTask Exception");
        AppMethodBeat.o(261384);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.d.d
 * JD-Core Version:    0.7.0.1
 */