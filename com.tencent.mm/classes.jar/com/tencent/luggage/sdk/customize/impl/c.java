package com.tencent.luggage.sdk.customize.impl;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.e;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.f;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/customize/impl/LuggageBLEScanStatsService;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/IAppScanStats;", "()V", "isScanningTooFrequently", "", "recordScanStart", "", "recordScanStop", "", "id", "luggage-wechat-full-sdk_release"})
final class c
  implements f
{
  public static final c cyf;
  
  static
  {
    AppMethodBeat.i(237735);
    cyf = new c();
    AppMethodBeat.o(237735);
  }
  
  private c()
  {
    AppMethodBeat.i(237734);
    if (Build.VERSION.SDK_INT >= 24) {}
    for (f localf = (f)a.cxZ;; localf = (f)e.oKN)
    {
      this.cyg = localf;
      AppMethodBeat.o(237734);
      return;
    }
  }
  
  public final int QI()
  {
    AppMethodBeat.i(237737);
    int i = this.cyg.QI();
    AppMethodBeat.o(237737);
    return i;
  }
  
  public final boolean QJ()
  {
    AppMethodBeat.i(237736);
    boolean bool = this.cyg.QJ();
    AppMethodBeat.o(237736);
    return bool;
  }
  
  public final void iQ(int paramInt)
  {
    AppMethodBeat.i(237738);
    this.cyg.iQ(paramInt);
    AppMethodBeat.o(237738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.customize.impl.c
 * JD-Core Version:    0.7.0.1
 */