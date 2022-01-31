package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.bluetooth.BluetoothDevice;
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
    if (paramScanResultCompat.getDevice() == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleScanWorker", "[onScanResult]result is null, err", new Object[0]);
      return;
    }
    if (!this.gnp.gnl.get())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleScanWorker", "[onScanResult]not init, err", new Object[0]);
      return;
    }
    if (this.gnp.gnj == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleScanWorker", "[onScanResult]may be close, err", new Object[0]);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.d("MicroMsg.Ble.BleScanWorker", "callbackType:%d, result:%s", new Object[] { Integer.valueOf(paramInt), paramScanResultCompat });
    String str = paramScanResultCompat.getDevice().getAddress();
    if (this.gnp.gnj.containsKey(str))
    {
      paramInt = i;
      if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.glN.glO) {}
    }
    else
    {
      paramInt = 1;
    }
    paramScanResultCompat = new d(paramScanResultCompat);
    if (paramInt != 0)
    {
      if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.glN.dDr <= 0) {
        break label192;
      }
      if (this.gnp.gnm != null) {
        this.gnp.gnm.add(paramScanResultCompat);
      }
    }
    for (;;)
    {
      this.gnp.gnj.put(str, paramScanResultCompat);
      return;
      label192:
      if (this.gnp.gno != null) {
        this.gnp.gno.a(paramScanResultCompat);
      }
    }
  }
  
  public final void onScanFailed(int paramInt)
  {
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleScanWorker", "[onScanResult]onScanFailed, errorCode:%d", new Object[] { Integer.valueOf(paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a.2
 * JD-Core Version:    0.7.0.1
 */