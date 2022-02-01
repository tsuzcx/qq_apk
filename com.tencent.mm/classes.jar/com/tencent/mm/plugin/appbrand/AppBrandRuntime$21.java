package com.tencent.mm.plugin.appbrand;

import android.content.res.Configuration;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandRuntime$21
  implements MessageQueue.IdleHandler
{
  AppBrandRuntime$21(AppBrandRuntime paramAppBrandRuntime, Configuration paramConfiguration) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(197179);
    AppBrandRuntime.a(this.jxm, this.jxB);
    AppMethodBeat.o(197179);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime.21
 * JD-Core Version:    0.7.0.1
 */