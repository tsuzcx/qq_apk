package com.tencent.mm.plugin.appbrand.jsapi.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class a$a
{
  BluetoothAdapter hMm;
  Map<String, JSONObject> hMn;
  UUID[] hMo;
  a.a.a hMp;
  long hMq;
  Map<String, JSONObject> hMr;
  BluetoothAdapter.LeScanCallback hMs;
  volatile boolean isStart;
  
  public a$a()
  {
    AppMethodBeat.i(94353);
    this.hMn = new ConcurrentHashMap();
    this.hMo = null;
    this.isStart = false;
    this.hMq = 0L;
    this.hMr = new ConcurrentHashMap();
    this.hMs = new a.a.1(this);
    BluetoothManager localBluetoothManager = (BluetoothManager)ah.getContext().getSystemService("bluetooth");
    if (localBluetoothManager == null)
    {
      ab.e("MicroMsg.BeaconManager", "bluetoothManager is null!");
      AppMethodBeat.o(94353);
      return;
    }
    this.hMm = localBluetoothManager.getAdapter();
    if (this.hMm == null)
    {
      ab.e("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
      AppMethodBeat.o(94353);
      return;
    }
    a.hFu = this.hMm.isEnabled();
    AppMethodBeat.o(94353);
  }
  
  public final boolean Ez()
  {
    AppMethodBeat.i(94354);
    ab.i("MicroMsg.BeaconManager", "BeaconWorker:%d stop", new Object[] { Integer.valueOf(hashCode()) });
    if (!isStart())
    {
      ab.i("MicroMsg.BeaconManager", "BeaconWorker:%d, already stop", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(94354);
      return false;
    }
    this.hMn.clear();
    this.hMm.stopLeScan(this.hMs);
    this.isStart = false;
    AppMethodBeat.o(94354);
    return true;
  }
  
  final boolean isStart()
  {
    try
    {
      boolean bool = this.isStart;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c.a.a
 * JD-Core Version:    0.7.0.1
 */