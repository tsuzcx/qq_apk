package com.tencent.luggage.sdk.customize.impl;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.e;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.f;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/customize/impl/LuggageBLEScanStatsService;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/IAppScanStats;", "()V", "isScanningTooFrequently", "", "recordScanStart", "", "recordScanStop", "", "id", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
final class c
  implements f
{
  public static final c eqy;
  
  static
  {
    AppMethodBeat.i(220381);
    eqy = new c();
    AppMethodBeat.o(220381);
  }
  
  private c()
  {
    AppMethodBeat.i(220376);
    if (Build.VERSION.SDK_INT >= 24) {}
    for (f localf = (f)a.eqt;; localf = (f)e.rOG)
    {
      this.eqz = localf;
      AppMethodBeat.o(220376);
      return;
    }
  }
  
  public final int aqV()
  {
    AppMethodBeat.i(220392);
    int i = this.eqz.aqV();
    AppMethodBeat.o(220392);
    return i;
  }
  
  public final boolean aqW()
  {
    AppMethodBeat.i(220387);
    boolean bool = this.eqz.aqW();
    AppMethodBeat.o(220387);
    return bool;
  }
  
  public final void mr(int paramInt)
  {
    AppMethodBeat.i(220397);
    this.eqz.mr(paramInt);
    AppMethodBeat.o(220397);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.customize.impl.c
 * JD-Core Version:    0.7.0.1
 */