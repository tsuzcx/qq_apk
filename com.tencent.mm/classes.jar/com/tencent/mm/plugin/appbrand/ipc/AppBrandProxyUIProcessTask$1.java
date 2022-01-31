package com.tencent.mm.plugin.appbrand.ipc;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandProxyUIProcessTask$1
  implements Runnable
{
  AppBrandProxyUIProcessTask$1(AppBrandProxyUIProcessTask paramAppBrandProxyUIProcessTask, AppBrandProxyUIProcessTask.ProcessResult paramProcessResult) {}
  
  public final void run()
  {
    AppMethodBeat.i(73151);
    if (this.hws.hwr == null)
    {
      AppMethodBeat.o(73151);
      return;
    }
    this.hws.hwr.a(this.hwh);
    AppMethodBeat.o(73151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.1
 * JD-Core Version:    0.7.0.1
 */