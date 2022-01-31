package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.bluetooth.BluetoothDevice;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.i;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a$2
  extends e
{
  public a$2(a parama) {}
  
  public final void a(int paramInt, ScanResultCompat paramScanResultCompat)
  {
    int i = 0;
    AppMethodBeat.i(94286);
    if (paramScanResultCompat.getDevice() == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleScanWorker", "[onScanResult]result is null, err", new Object[0]);
      AppMethodBeat.o(94286);
      return;
    }
    if (!this.hHn.chl.get())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleScanWorker", "[onScanResult]not init, err", new Object[0]);
      AppMethodBeat.o(94286);
      return;
    }
    if (this.hHn.hHi == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleScanWorker", "[onScanResult]may be close, err", new Object[0]);
      AppMethodBeat.o(94286);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.d("MicroMsg.Ble.BleScanWorker", "callbackType:%d, result:%s", new Object[] { Integer.valueOf(paramInt), paramScanResultCompat });
    String str = paramScanResultCompat.getDevice().getAddress();
    if (this.hHn.hHi.containsKey(str))
    {
      paramInt = i;
      if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.hFM.hFN) {}
    }
    else
    {
      paramInt = 1;
    }
    paramScanResultCompat = new d(paramScanResultCompat);
    if (paramInt != 0)
    {
      if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.hFM.eAS <= 0) {
        break label217;
      }
      if (this.hHn.hHk != null) {
        this.hHn.hHk.add(paramScanResultCompat);
      }
    }
    for (;;)
    {
      this.hHn.hHi.put(str, paramScanResultCompat);
      AppMethodBeat.o(94286);
      return;
      label217:
      if (this.hHn.hHm != null) {
        this.hHn.hHm.a(paramScanResultCompat);
      }
    }
  }
  
  public final void onScanFailed(int paramInt)
  {
    AppMethodBeat.i(94287);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleScanWorker", "[onScanResult]onScanFailed, errorCode:%d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(94287);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a.2
 * JD-Core Version:    0.7.0.1
 */