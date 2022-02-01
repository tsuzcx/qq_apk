package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener;
import com.tencent.mm.sdk.platformtools.Util;

final class PluginAppBrand$5
  implements MMUncaughtExceptionHandler.IOnUncaughtExceptionListener
{
  PluginAppBrand$5(PluginAppBrand paramPluginAppBrand) {}
  
  public final void uncaughtException(MMUncaughtExceptionHandler paramMMUncaughtExceptionHandler, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(279773);
    if (Util.nullAsNil(paramString).contains(".plugin.appbrand"))
    {
      h.IzE.idkeyStat(365L, 3L, 1L, false);
      KVCommCrossProcessReceiver.fBy();
    }
    AppMethodBeat.o(279773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.PluginAppBrand.5
 * JD-Core Version:    0.7.0.1
 */