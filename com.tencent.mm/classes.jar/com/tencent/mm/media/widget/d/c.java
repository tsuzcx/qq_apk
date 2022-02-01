package com.tencent.mm.media.widget.d;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/util/CameraReportHelper;", "", "()V", "TAG", "", "futureTask", "Ljava/util/concurrent/FutureTask;", "", "checkAndReportCamera2Info", "", "CameraInfo", "plugin-mediaeditor_release"})
public final class c
{
  private static FutureTask<Integer> cCr;
  public static final c itl;
  
  static
  {
    AppMethodBeat.i(218950);
    itl = new c();
    AppMethodBeat.o(218950);
  }
  
  public static void aRN()
  {
    AppMethodBeat.i(218949);
    cCr = new FutureTask((Callable)b.ito);
    h.RTc.aX((Runnable)c.itp);
    AppMethodBeat.o(218949);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "call"})
  static final class b<V>
    implements Callable<Integer>
  {
    public static final b ito;
    
    static
    {
      AppMethodBeat.i(218946);
      ito = new b();
      AppMethodBeat.o(218946);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    public static final c itp;
    
    static
    {
      AppMethodBeat.i(218948);
      itp = new c();
      AppMethodBeat.o(218948);
    }
    
    public final void run()
    {
      AppMethodBeat.i(218947);
      Object localObject = h.RTc;
      c localc2 = c.itl;
      ((i)localObject).aX((Runnable)c.aRO());
      try
      {
        localObject = c.itl;
        c.aRO().get(10L, TimeUnit.SECONDS);
        AppMethodBeat.o(218947);
        return;
      }
      catch (TimeoutException localTimeoutException)
      {
        Log.e("MicroMsg.CameraReportHelper", "futureTask TimeoutException cancel");
        c localc1 = c.itl;
        if (!c.aRO().isCancelled())
        {
          localc1 = c.itl;
          if (!c.aRO().isDone())
          {
            localc1 = c.itl;
            c.aRO().cancel(true);
            AppMethodBeat.o(218947);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.CameraReportHelper", "futureTask Exception");
        AppMethodBeat.o(218947);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.d.c
 * JD-Core Version:    0.7.0.1
 */