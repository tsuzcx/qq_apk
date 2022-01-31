package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandMainProcessService$1
  extends Handler
{
  AppBrandMainProcessService$1(AppBrandMainProcessService paramAppBrandMainProcessService, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(90980);
    paramMessage = AppBrandMainProcessService.b(paramMessage.getData(), true);
    if (paramMessage != null) {
      paramMessage.ata();
    }
    AppMethodBeat.o(90980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.1
 * JD-Core Version:    0.7.0.1
 */