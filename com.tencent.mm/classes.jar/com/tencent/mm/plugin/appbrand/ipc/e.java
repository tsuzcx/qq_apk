package com.tencent.mm.plugin.appbrand.ipc;

import com.tencent.mm.ui.MMActivity;

abstract interface e
{
  public abstract void finishProcess(AppBrandProxyUIProcessTask.ProcessResult paramProcessResult);
  
  public abstract MMActivity getActivityContext();
  
  public abstract boolean isProcessTerminated();
  
  public abstract void runOnUiThread(Runnable paramRunnable);
  
  public abstract void sendResult(AppBrandProxyUIProcessTask.ProcessResult paramProcessResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.e
 * JD-Core Version:    0.7.0.1
 */