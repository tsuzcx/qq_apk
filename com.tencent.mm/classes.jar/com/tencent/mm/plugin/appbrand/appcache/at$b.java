package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vending.c.a;

final class at$b
  implements a<Void, Void>
{
  private WxaPkgWrappingInfo nFY;
  
  public at$b(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    this.nFY = paramWxaPkgWrappingInfo;
  }
  
  public final Void bFz()
  {
    AppMethodBeat.i(271498);
    boolean bool = WxaCommLibRuntimeReader.b(this.nFY);
    int i = d.bBL();
    Log.i("MicroMsg.AppBrand.WxaCommLibPreloadNotify", "IPC_resetAppBrandCommLibReader#invoke() waitForPreloaded entered, process[%s], pkgInfo[%s], globalReaderUpdated[%b], runningRuntimeCount[%d]", new Object[] { MMApplicationContext.getProcessName(), this.nFY, Boolean.valueOf(bool), Integer.valueOf(i) });
    if ((bool) && (i <= 0)) {
      h.ciY();
    }
    Void localVoid = YAb;
    AppMethodBeat.o(271498);
    return localVoid;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.at.b
 * JD-Core Version:    0.7.0.1
 */