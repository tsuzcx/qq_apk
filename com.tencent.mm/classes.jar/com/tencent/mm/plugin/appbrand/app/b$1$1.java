package com.tencent.mm.plugin.appbrand.app;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.sdk.platformtools.y;

final class b$1$1
  implements MessageQueue.IdleHandler
{
  b$1$1(b.1 param1) {}
  
  public final boolean queueIdle()
  {
    Looper.myQueue().removeIdleHandler(this);
    if (!b.access$000()) {}
    try
    {
      y.i("MicroMsg.AppBrandProcessProfileInit[applaunch]", "start misc preload [%s]", new Object[] { this.fAM.fAK });
      AppBrandMainProcessService.aht();
      d.a(this.fAM.fAK, false, this.fAM.fAL);
      return false;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.AppBrandProcessProfileInit[applaunch]", localException, "Preload [%s] in IdleHandler encountered Exception", new Object[] { this.fAM.fAK.name() });
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.b.1.1
 * JD-Core Version:    0.7.0.1
 */