package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.y;

final class AppBrandMainProcessService$3
  extends Handler
{
  AppBrandMainProcessService$3(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    paramMessage = AppBrandMainProcessService.b(paramMessage.getData(), false);
    MainProcessTask localMainProcessTask = AppBrandMainProcessService.tG(paramMessage.gep);
    if (localMainProcessTask == null)
    {
      y.e("MicroMsg.AppBrandMainProcessService", "receive client msg, get null task by id %s", new Object[] { paramMessage.gep });
      return;
    }
    AppBrandMainProcessService.b(paramMessage, localMainProcessTask);
    localMainProcessTask.Zv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.3
 * JD-Core Version:    0.7.0.1
 */