package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ao.c;
import com.tencent.mm.sdk.platformtools.bo;

final class PluginAppBrand$6
  implements ao.c
{
  PluginAppBrand$6(PluginAppBrand paramPluginAppBrand) {}
  
  public final void b(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(154850);
    if (bo.nullAsNil(paramString).contains(".plugin.appbrand"))
    {
      h.qsU.idkeyStat(365L, 3L, 1L, false);
      KVCommCrossProcessReceiver.chN();
    }
    AppMethodBeat.o(154850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.PluginAppBrand.6
 * JD-Core Version:    0.7.0.1
 */