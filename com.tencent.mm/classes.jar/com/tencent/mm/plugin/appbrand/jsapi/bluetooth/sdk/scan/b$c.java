package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanFilter.Builder;
import android.bluetooth.le.ScanSettings.Builder;
import android.support.v4.e.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanFilterCompat;>;

@SuppressLint({"MissingPermission"})
@TargetApi(21)
final class b$c
  implements b.e
{
  static final m<e, b.d> hHp;
  
  static
  {
    AppMethodBeat.i(94299);
    hHp = new m();
    AppMethodBeat.o(94299);
  }
  
  public final boolean a(BluetoothAdapter paramBluetoothAdapter, e parame)
  {
    AppMethodBeat.i(94298);
    parame = (b.d)hHp.remove(parame);
    if (parame == null)
    {
      AppMethodBeat.o(94298);
      return false;
    }
    if (paramBluetoothAdapter.getBluetoothLeScanner() == null)
    {
      ab.e("MicroMsg.ble.BleScannerCompat", "bluetoothscanner is null, return");
      AppMethodBeat.o(94298);
      return false;
    }
    paramBluetoothAdapter.getBluetoothLeScanner().stopScan(parame);
    AppMethodBeat.o(94298);
    return true;
  }
  
  public final boolean a(BluetoothAdapter paramBluetoothAdapter, List<ScanFilterCompat> paramList, ScanSettingsCompat paramScanSettingsCompat, e parame)
  {
    AppMethodBeat.i(94297);
    if (paramList != null)
    {
      localObject = new ArrayList(paramList.size());
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        paramList = (List<ScanFilterCompat>)localObject;
        if (!localIterator.hasNext()) {
          break;
        }
        paramList = (ScanFilterCompat)localIterator.next();
        ScanFilter.Builder localBuilder = new ScanFilter.Builder();
        if (paramList.mDeviceName != null) {
          localBuilder.setDeviceName(paramList.mDeviceName);
        }
        if (paramList.hHN != null) {
          localBuilder.setServiceUuid(paramList.hHN, paramList.hHO);
        }
        if (paramList.hHM != null) {
          localBuilder.setDeviceAddress(paramList.hHM);
        }
        if (paramList.hHP != null) {
          localBuilder.setServiceData(paramList.hHP, paramList.hHQ, paramList.hHR);
        }
        if (paramList.hHS < 0) {
          localBuilder.setManufacturerData(paramList.hHS, paramList.hHT, paramList.hHU);
        }
        ((List)localObject).add(localBuilder.build());
      }
    }
    paramList = null;
    if (paramScanSettingsCompat == null)
    {
      paramBluetoothAdapter = new IllegalStateException("Scan settings are null");
      AppMethodBeat.o(94297);
      throw paramBluetoothAdapter;
    }
    paramScanSettingsCompat = new ScanSettings.Builder().setReportDelay(paramScanSettingsCompat.hIi).setScanMode(paramScanSettingsCompat.hIg).build();
    if (paramBluetoothAdapter.getBluetoothLeScanner() == null)
    {
      ab.e("MicroMsg.ble.BleScannerCompat", "bluetoothscanner is null, return");
      AppMethodBeat.o(94297);
      return false;
    }
    Object localObject = paramBluetoothAdapter.getBluetoothLeScanner();
    paramBluetoothAdapter = (b.d)hHp.get(parame);
    if (paramBluetoothAdapter != null) {}
    for (;;)
    {
      ((BluetoothLeScanner)localObject).startScan(paramList, paramScanSettingsCompat, paramBluetoothAdapter);
      AppMethodBeat.o(94297);
      return true;
      paramBluetoothAdapter = new b.d(parame);
      hHp.put(parame, paramBluetoothAdapter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.b.c
 * JD-Core Version:    0.7.0.1
 */