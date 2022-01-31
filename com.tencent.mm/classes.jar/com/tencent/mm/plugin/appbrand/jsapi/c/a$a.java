package com.tencent.mm.plugin.appbrand.jsapi.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class a$a
{
  volatile boolean bSr = false;
  BluetoothAdapter gqX;
  Map<String, JSONObject> gqY = new ConcurrentHashMap();
  UUID[] gqZ = null;
  a.a.a gra;
  long grb = 0L;
  Map<String, JSONObject> grc = new ConcurrentHashMap();
  BluetoothAdapter.LeScanCallback grd = new a.a.1(this);
  
  public a$a()
  {
    BluetoothManager localBluetoothManager = (BluetoothManager)ae.getContext().getSystemService("bluetooth");
    if (localBluetoothManager == null)
    {
      y.e("MicroMsg.BeaconManager", "bluetoothManager is null!");
      return;
    }
    this.gqX = localBluetoothManager.getAdapter();
    if (this.gqX == null)
    {
      y.e("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
      return;
    }
    a.glv = this.gqX.isEnabled();
  }
  
  final boolean aiS()
  {
    try
    {
      boolean bool = this.bSr;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean un()
  {
    y.i("MicroMsg.BeaconManager", "BeaconWorker:%d stop", new Object[] { Integer.valueOf(hashCode()) });
    if (!aiS())
    {
      y.i("MicroMsg.BeaconManager", "BeaconWorker:%d, already stop", new Object[] { Integer.valueOf(hashCode()) });
      return false;
    }
    this.gqY.clear();
    this.gqX.stopLeScan(this.grd);
    this.bSr = false;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c.a.a
 * JD-Core Version:    0.7.0.1
 */