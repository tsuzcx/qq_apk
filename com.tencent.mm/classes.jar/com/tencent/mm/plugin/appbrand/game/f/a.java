package com.tencent.mm.plugin.appbrand.game.f;

import com.tencent.magicbrush.handler.image.MBCanvasContentHolder;
import com.tencent.mm.plugin.appbrand.game.h;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public enum a
{
  private a() {}
  
  private MBCanvasContentHolder a(Callable<MBCanvasContentHolder> paramCallable)
  {
    int i = 0;
    if (ahm()) {
      y.e("MicroMsg.WAGameCanvasSnapshotHandler", "Current thread is [%s], dismiss this task", new Object[] { Thread.currentThread() });
    }
    while (i == 0)
    {
      return null;
      i = 1;
    }
    FutureTask localFutureTask = new FutureTask(paramCallable);
    paramCallable = new a.1(this, localFutureTask);
    Object localObject2 = h.fZZ;
    if (!((h)localObject2).gaa.contains(paramCallable)) {
      ((h)localObject2).gaa.add(paramCallable);
    }
    try
    {
      localObject2 = (MBCanvasContentHolder)localFutureTask.get(2500L, TimeUnit.MILLISECONDS);
      if (localObject2 != null) {
        return localObject2;
      }
      localFutureTask.cancel(true);
      y.w("MicroMsg.WAGameCanvasSnapshotHandler", "postGetCanvasShotSyncOnRenderThread bitmap is null");
      return null;
    }
    catch (InterruptedException localInterruptedException)
    {
      y.printErrStackTrace("MicroMsg.WAGameCanvasSnapshotHandler", localInterruptedException, "hy: AppBrandGame getScreenShotsBitmap InterruptedException", new Object[0]);
      localFutureTask.cancel(true);
      return null;
    }
    catch (ExecutionException localExecutionException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.WAGameCanvasSnapshotHandler", localExecutionException, "hy: AppBrandGame getScreenShotsBitmap ExecutionException", new Object[0]);
        localFutureTask.cancel(true);
        h.fZZ.a(paramCallable);
      }
    }
    catch (TimeoutException localTimeoutException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.WAGameCanvasSnapshotHandler", localTimeoutException, "hy: AppBrandGame getScreenShotsBitmap TimeoutException", new Object[0]);
        localFutureTask.cancel(true);
        h.fZZ.a(paramCallable);
      }
    }
    finally
    {
      h.fZZ.a(paramCallable);
    }
  }
  
  private static boolean ahm()
  {
    String str = Thread.currentThread().getName();
    return (str != null) && (str.startsWith("MicroMsg.GLThread"));
  }
  
  public static MBCanvasContentHolder lb(int paramInt)
  {
    if (!ahm())
    {
      y.e("MicroMsg.WAGameCanvasSnapshotHandler", "CurrentThread is not glThread, please post to GLThread. [%s]", new Object[] { Thread.currentThread() });
      return null;
    }
    try
    {
      MBCanvasContentHolder localMBCanvasContentHolder = new a.a(paramInt, (byte)0).ahn();
      return localMBCanvasContentHolder;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.WAGameCanvasSnapshotHandler", "getScreenCanvas Direct [%s]", new Object[] { localException });
    }
    return null;
  }
  
  public final MBCanvasContentHolder ahl()
  {
    return a(new a.b((byte)0));
  }
  
  public final MBCanvasContentHolder la(int paramInt)
  {
    return a(new a.a(paramInt, (byte)0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.a
 * JD-Core Version:    0.7.0.1
 */