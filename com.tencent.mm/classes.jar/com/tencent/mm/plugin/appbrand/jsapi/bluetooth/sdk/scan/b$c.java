package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanFilter.Builder;
import android.bluetooth.le.ScanSettings.Builder;
import android.support.v4.f.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanFilterCompat;>;

@SuppressLint({"MissingPermission"})
@TargetApi(21)
final class b$c
  implements b.e
{
  static final m<e, b.d> gnr = new m();
  
  public final boolean a(BluetoothAdapter paramBluetoothAdapter, e parame)
  {
    parame = (b.d)gnr.remove(parame);
    if (parame == null) {
      return false;
    }
    paramBluetoothAdapter.getBluetoothLeScanner().stopScan(parame);
    return true;
  }
  
  public final boolean a(BluetoothAdapter paramBluetoothAdapter, List<ScanFilterCompat> paramList, ScanSettingsCompat paramScanSettingsCompat, e parame)
  {
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
        if (paramList.gnO != null) {
          localBuilder.setDeviceName(paramList.gnO);
        }
        if (paramList.gnQ != null) {
          localBuilder.setServiceUuid(paramList.gnQ, paramList.gnR);
        }
        if (paramList.gnP != null) {
          localBuilder.setDeviceAddress(paramList.gnP);
        }
        if (paramList.gnS != null) {
          localBuilder.setServiceData(paramList.gnS, paramList.gnT, paramList.gnU);
        }
        if (paramList.gnV < 0) {
          localBuilder.setManufacturerData(paramList.gnV, paramList.gnW, paramList.gnX);
        }
        ((List)localObject).add(localBuilder.build());
      }
    }
    paramList = null;
    if (paramScanSettingsCompat == null) {
      throw new IllegalStateException("Scan settings are null");
    }
    paramScanSettingsCompat = new ScanSettings.Builder().setReportDelay(paramScanSettingsCompat.gol).setScanMode(paramScanSettingsCompat.goj).build();
    Object localObject = paramBluetoothAdapter.getBluetoothLeScanner();
    paramBluetoothAdapter = (b.d)gnr.get(parame);
    if (paramBluetoothAdapter != null) {}
    for (;;)
    {
      ((BluetoothLeScanner)localObject).startScan(paramList, paramScanSettingsCompat, paramBluetoothAdapter);
      return true;
      paramBluetoothAdapter = new b.d(parame);
      gnr.put(parame, paramBluetoothAdapter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.b.c
 * JD-Core Version:    0.7.0.1
 */