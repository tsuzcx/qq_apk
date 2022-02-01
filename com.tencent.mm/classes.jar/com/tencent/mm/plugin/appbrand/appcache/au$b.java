package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vending.c.a;

final class au$b
  implements a<Void, Void>
{
  private final ICommLibReader qFR;
  
  public au$b(ICommLibReader paramICommLibReader)
  {
    this.qFR = paramICommLibReader;
  }
  
  public final Void ceW()
  {
    AppMethodBeat.i(320343);
    boolean bool = WxaCommLibRuntimeReader.f(this.qFR);
    int i = d.cbh();
    Log.i("MicroMsg.AppBrand.WxaCommLibPreloadNotify", "IPC_resetAppBrandCommLibReader#invoke() waitForPreloaded entered, process[%s], pkgInfo[%s], globalReaderUpdated[%b], runningRuntimeCount[%d]", new Object[] { MMApplicationContext.getProcessName(), this.qFR, Boolean.valueOf(bool), Integer.valueOf(i) });
    if ((bool) && (i <= 0)) {
      h.cJT();
    }
    Void localVoid = aguz;
    AppMethodBeat.o(320343);
    return localVoid;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.au.b
 * JD-Core Version:    0.7.0.1
 */