package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandMainProcessService$3
  extends Handler
{
  AppBrandMainProcessService$3(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(90985);
    paramMessage = AppBrandMainProcessService.b(paramMessage.getData(), false);
    if (paramMessage == null)
    {
      AppMethodBeat.o(90985);
      return;
    }
    MainProcessTask localMainProcessTask = AppBrandMainProcessService.BF(paramMessage.hwp);
    if (localMainProcessTask == null)
    {
      ab.e("MicroMsg.AppBrandMainProcessService", "receive client msg, get null task by id %s", new Object[] { paramMessage.hwp });
      AppMethodBeat.o(90985);
      return;
    }
    AppBrandMainProcessService.b(paramMessage, localMainProcessTask);
    localMainProcessTask.atb();
    AppMethodBeat.o(90985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.3
 * JD-Core Version:    0.7.0.1
 */