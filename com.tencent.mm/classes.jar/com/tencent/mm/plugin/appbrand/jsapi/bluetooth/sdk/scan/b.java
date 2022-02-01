package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter.Builder;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings.Builder;
import android.os.Build.VERSION;
import android.os.ParcelUuid;
import android.support.v4.e.n;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanFilterCompat;>;
import java.util.Map;

@TargetApi(18)
public final class b
{
  static final e kGb;
  
  static
  {
    AppMethodBeat.i(144618);
    int i = Build.VERSION.SDK_INT;
    if (!a.kEz)
    {
      ad.i("MicroMsg.ble.BleScannerCompat", "use 18");
      kGb = new a();
      AppMethodBeat.o(144618);
      return;
    }
    if (i >= 21)
    {
      ad.i("MicroMsg.ble.BleScannerCompat", "use 21");
      kGb = new c();
      AppMethodBeat.o(144618);
      return;
    }
    ad.i("MicroMsg.ble.BleScannerCompat", "use 18");
    kGb = new a();
    AppMethodBeat.o(144618);
  }
  
  public static boolean a(BluetoothAdapter paramBluetoothAdapter, e parame)
  {
    AppMethodBeat.i(144617);
    boolean bool = kGb.a(paramBluetoothAdapter, parame);
    AppMethodBeat.o(144617);
    return bool;
  }
  
  public static boolean a(BluetoothAdapter paramBluetoothAdapter, List<ScanFilterCompat> paramList, ScanSettingsCompat paramScanSettingsCompat, e parame)
  {
    AppMethodBeat.i(144616);
    ad.i("MicroMsg.ble.BleScannerCompat", "scanMode: " + paramScanSettingsCompat.kGV);
    boolean bool = kGb.a(paramBluetoothAdapter, paramList, paramScanSettingsCompat, parame);
    AppMethodBeat.o(144616);
    return bool;
  }
  
  @TargetApi(18)
  static final class a
    implements b.e
  {
    static final n<e, b.b> kGc;
    
    static
    {
      AppMethodBeat.i(144606);
      kGc = new n();
      AppMethodBeat.o(144606);
    }
    
    public final boolean a(BluetoothAdapter paramBluetoothAdapter, e parame)
    {
      AppMethodBeat.i(144605);
      parame = (b.b)kGc.remove(parame);
      if (parame == null)
      {
        AppMethodBeat.o(144605);
        return false;
      }
      paramBluetoothAdapter.stopLeScan(parame);
      AppMethodBeat.o(144605);
      return true;
    }
    
    public final boolean a(BluetoothAdapter paramBluetoothAdapter, List<ScanFilterCompat> paramList, ScanSettingsCompat paramScanSettingsCompat, e parame)
    {
      AppMethodBeat.i(144604);
      paramScanSettingsCompat = (b.b)kGc.get(parame);
      if (paramScanSettingsCompat != null) {
        paramList = paramScanSettingsCompat;
      }
      for (;;)
      {
        boolean bool = paramBluetoothAdapter.startLeScan(paramList);
        AppMethodBeat.o(144604);
        return bool;
        paramList = new b.b(paramList, parame);
        kGc.put(parame, paramList);
      }
    }
  }
  
  static final class b
    implements BluetoothAdapter.LeScanCallback
  {
    private final List<ScanFilterCompat> kGd;
    private final WeakReference<e> kGe;
    
    b(List<ScanFilterCompat> paramList, e parame)
    {
      AppMethodBeat.i(144607);
      this.kGd = paramList;
      this.kGe = new WeakReference(parame);
      AppMethodBeat.o(144607);
    }
    
    public final void onLeScan(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(144608);
      e locale = (e)this.kGe.get();
      if (locale == null)
      {
        AppMethodBeat.o(144608);
        return;
      }
      paramArrayOfByte = new ScanResultCompat(paramBluetoothDevice, f.as(paramArrayOfByte), paramInt, System.currentTimeMillis());
      if (this.kGd == null)
      {
        locale.a(1, paramArrayOfByte);
        AppMethodBeat.o(144608);
        return;
      }
      Iterator localIterator1 = this.kGd.iterator();
      while (localIterator1.hasNext())
      {
        ScanFilterCompat localScanFilterCompat = (ScanFilterCompat)localIterator1.next();
        paramBluetoothDevice = paramArrayOfByte.getDevice();
        if ((localScanFilterCompat.kGA != null) && ((paramBluetoothDevice == null) || (!localScanFilterCompat.kGA.equals(paramBluetoothDevice.getAddress())))) {
          paramInt = 0;
        }
        while (paramInt != 0)
        {
          locale.a(1, paramArrayOfByte);
          AppMethodBeat.o(144608);
          return;
          f localf = paramArrayOfByte.kGS;
          if ((localf == null) && ((localScanFilterCompat.mDeviceName != null) || (localScanFilterCompat.kGB != null) || (localScanFilterCompat.kGH != null) || (localScanFilterCompat.kGE != null) || (localScanFilterCompat.kGD != null) || (localScanFilterCompat.kGG >= 0)))
          {
            paramInt = 0;
          }
          else if ((localScanFilterCompat.mDeviceName != null) && (!localScanFilterCompat.mDeviceName.equals(localf.mDeviceName)))
          {
            paramInt = 0;
          }
          else
          {
            Object localObject1;
            Object localObject2;
            if (localScanFilterCompat.kGB != null)
            {
              localObject1 = localScanFilterCompat.kGB;
              localObject2 = localScanFilterCompat.kGC;
              paramBluetoothDevice = localf.kGM;
              if (localObject1 == null) {
                paramInt = 1;
              }
              for (;;)
              {
                if (paramInt != 0) {
                  break label363;
                }
                paramInt = 0;
                break;
                if (paramBluetoothDevice != null)
                {
                  Iterator localIterator2 = paramBluetoothDevice.iterator();
                  label356:
                  for (;;)
                  {
                    if (!localIterator2.hasNext()) {
                      break label358;
                    }
                    ParcelUuid localParcelUuid = (ParcelUuid)localIterator2.next();
                    if (localObject2 == null) {}
                    for (paramBluetoothDevice = null;; paramBluetoothDevice = ((ParcelUuid)localObject2).getUuid())
                    {
                      if (!ScanFilterCompat.a(((ParcelUuid)localObject1).getUuid(), paramBluetoothDevice, localParcelUuid.getUuid())) {
                        break label356;
                      }
                      paramInt = 1;
                      break;
                    }
                  }
                }
                label358:
                paramInt = 0;
              }
            }
            label363:
            if (localScanFilterCompat.kGD != null)
            {
              localObject1 = localScanFilterCompat.kGE;
              localObject2 = localScanFilterCompat.kGF;
              paramBluetoothDevice = localScanFilterCompat.kGD;
              if (paramBluetoothDevice == null) {}
              for (paramBluetoothDevice = null;; paramBluetoothDevice = (byte[])localf.kGO.get(paramBluetoothDevice))
              {
                if (ScanFilterCompat.a((byte[])localObject1, (byte[])localObject2, paramBluetoothDevice)) {
                  break label431;
                }
                paramInt = 0;
                break;
              }
            }
            label431:
            if ((localScanFilterCompat.kGG >= 0) && (localf != null))
            {
              paramBluetoothDevice = localScanFilterCompat.kGH;
              localObject1 = localScanFilterCompat.kGI;
              paramInt = localScanFilterCompat.kGG;
              if (!ScanFilterCompat.a(paramBluetoothDevice, (byte[])localObject1, (byte[])localf.kGN.get(paramInt)))
              {
                paramInt = 0;
                continue;
              }
            }
            paramInt = 1;
          }
        }
      }
      AppMethodBeat.o(144608);
    }
  }
  
  @SuppressLint({"MissingPermission"})
  @TargetApi(21)
  static final class c
    implements b.e
  {
    static final n<e, b.d> kGc;
    
    static
    {
      AppMethodBeat.i(144611);
      kGc = new n();
      AppMethodBeat.o(144611);
    }
    
    public final boolean a(BluetoothAdapter paramBluetoothAdapter, e parame)
    {
      AppMethodBeat.i(144610);
      parame = (b.d)kGc.remove(parame);
      if (parame == null)
      {
        AppMethodBeat.o(144610);
        return false;
      }
      if (paramBluetoothAdapter.getBluetoothLeScanner() == null)
      {
        ad.e("MicroMsg.ble.BleScannerCompat", "bluetoothscanner is null, return");
        AppMethodBeat.o(144610);
        return false;
      }
      paramBluetoothAdapter.getBluetoothLeScanner().stopScan(parame);
      AppMethodBeat.o(144610);
      return true;
    }
    
    public final boolean a(BluetoothAdapter paramBluetoothAdapter, List<ScanFilterCompat> paramList, ScanSettingsCompat paramScanSettingsCompat, e parame)
    {
      AppMethodBeat.i(144609);
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
          if (paramList.kGB != null) {
            localBuilder.setServiceUuid(paramList.kGB, paramList.kGC);
          }
          if (paramList.kGA != null) {
            localBuilder.setDeviceAddress(paramList.kGA);
          }
          if (paramList.kGD != null) {
            localBuilder.setServiceData(paramList.kGD, paramList.kGE, paramList.kGF);
          }
          if (paramList.kGG < 0) {
            localBuilder.setManufacturerData(paramList.kGG, paramList.kGH, paramList.kGI);
          }
          ((List)localObject).add(localBuilder.build());
        }
      }
      paramList = null;
      if (paramScanSettingsCompat == null)
      {
        paramBluetoothAdapter = new IllegalStateException("Scan settings are null");
        AppMethodBeat.o(144609);
        throw paramBluetoothAdapter;
      }
      paramScanSettingsCompat = new ScanSettings.Builder().setReportDelay(paramScanSettingsCompat.kGX).setScanMode(paramScanSettingsCompat.kGV).build();
      if (paramBluetoothAdapter.getBluetoothLeScanner() == null)
      {
        ad.e("MicroMsg.ble.BleScannerCompat", "bluetoothscanner is null, return");
        AppMethodBeat.o(144609);
        return false;
      }
      Object localObject = paramBluetoothAdapter.getBluetoothLeScanner();
      paramBluetoothAdapter = (b.d)kGc.get(parame);
      if (paramBluetoothAdapter != null) {}
      for (;;)
      {
        ((BluetoothLeScanner)localObject).startScan(paramList, paramScanSettingsCompat, paramBluetoothAdapter);
        AppMethodBeat.o(144609);
        return true;
        paramBluetoothAdapter = new b.d(parame);
        kGc.put(parame, paramBluetoothAdapter);
      }
    }
  }
  
  @TargetApi(21)
  static final class d
    extends ScanCallback
  {
    private final WeakReference<e> kGe;
    
    d(e parame)
    {
      AppMethodBeat.i(144612);
      this.kGe = new WeakReference(parame);
      AppMethodBeat.o(144612);
    }
    
    public final void onBatchScanResults(List<ScanResult> paramList)
    {
      AppMethodBeat.i(144614);
      if ((e)this.kGe.get() == null)
      {
        AppMethodBeat.o(144614);
        return;
      }
      ArrayList localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(new ScanResultCompat((ScanResult)paramList.next()));
      }
      AppMethodBeat.o(144614);
    }
    
    public final void onScanFailed(int paramInt)
    {
      AppMethodBeat.i(144615);
      e locale = (e)this.kGe.get();
      if (locale != null) {
        locale.onScanFailed(paramInt);
      }
      AppMethodBeat.o(144615);
    }
    
    public final void onScanResult(int paramInt, ScanResult paramScanResult)
    {
      AppMethodBeat.i(144613);
      e locale = (e)this.kGe.get();
      if (locale != null) {
        locale.a(paramInt, new ScanResultCompat(paramScanResult));
      }
      AppMethodBeat.o(144613);
    }
  }
  
  static abstract interface e
  {
    public abstract boolean a(BluetoothAdapter paramBluetoothAdapter, e parame);
    
    public abstract boolean a(BluetoothAdapter paramBluetoothAdapter, List<ScanFilterCompat> paramList, ScanSettingsCompat paramScanSettingsCompat, e parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.b
 * JD-Core Version:    0.7.0.1
 */