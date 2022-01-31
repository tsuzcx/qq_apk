package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class AppBrandMainProcessService$1
  extends Handler
{
  AppBrandMainProcessService$1(AppBrandMainProcessService paramAppBrandMainProcessService, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppBrandMainProcessService.b(paramMessage.getData(), true).Zu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.1
 * JD-Core Version:    0.7.0.1
 */