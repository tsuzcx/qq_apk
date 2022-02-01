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
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanFilterCompat;>;
import java.util.Map;

@TargetApi(18)
public final class b
{
  static final e kJq;
  
  static
  {
    AppMethodBeat.i(144618);
    int i = Build.VERSION.SDK_INT;
    if (!a.kHO)
    {
      ae.i("MicroMsg.ble.BleScannerCompat", "use 18");
      kJq = new a();
      AppMethodBeat.o(144618);
      return;
    }
    if (i >= 21)
    {
      ae.i("MicroMsg.ble.BleScannerCompat", "use 21");
      kJq = new c();
      AppMethodBeat.o(144618);
      return;
    }
    ae.i("MicroMsg.ble.BleScannerCompat", "use 18");
    kJq = new a();
    AppMethodBeat.o(144618);
  }
  
  public static boolean a(BluetoothAdapter paramBluetoothAdapter, e parame)
  {
    AppMethodBeat.i(144617);
    boolean bool = kJq.a(paramBluetoothAdapter, parame);
    AppMethodBeat.o(144617);
    return bool;
  }
  
  public static boolean a(BluetoothAdapter paramBluetoothAdapter, List<ScanFilterCompat> paramList, ScanSettingsCompat paramScanSettingsCompat, e parame)
  {
    AppMethodBeat.i(144616);
    ae.i("MicroMsg.ble.BleScannerCompat", "scanMode: " + paramScanSettingsCompat.kKk);
    boolean bool = kJq.a(paramBluetoothAdapter, paramList, paramScanSettingsCompat, parame);
    AppMethodBeat.o(144616);
    return bool;
  }
  
  @TargetApi(18)
  static final class a
    implements b.e
  {
    static final n<e, b.b> kJr;
    
    static
    {
      AppMethodBeat.i(144606);
      kJr = new n();
      AppMethodBeat.o(144606);
    }
    
    public final boolean a(BluetoothAdapter paramBluetoothAdapter, e parame)
    {
      AppMethodBeat.i(144605);
      parame = (b.b)kJr.remove(parame);
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
      paramScanSettingsCompat = (b.b)kJr.get(parame);
      if (paramScanSettingsCompat != null) {
        paramList = paramScanSettingsCompat;
      }
      for (;;)
      {
        boolean bool = paramBluetoothAdapter.startLeScan(paramList);
        AppMethodBeat.o(144604);
        return bool;
        paramList = new b.b(paramList, parame);
        kJr.put(parame, paramList);
      }
    }
  }
  
  static final class b
    implements BluetoothAdapter.LeScanCallback
  {
    private final List<ScanFilterCompat> kJs;
    private final WeakReference<e> kJt;
    
    b(List<ScanFilterCompat> paramList, e parame)
    {
      AppMethodBeat.i(144607);
      this.kJs = paramList;
      this.kJt = new WeakReference(parame);
      AppMethodBeat.o(144607);
    }
    
    public final void onLeScan(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(144608);
      e locale = (e)this.kJt.get();
      if (locale == null)
      {
        AppMethodBeat.o(144608);
        return;
      }
      paramArrayOfByte = new ScanResultCompat(paramBluetoothDevice, f.as(paramArrayOfByte), paramInt, System.currentTimeMillis());
      if (this.kJs == null)
      {
        locale.a(1, paramArrayOfByte);
        AppMethodBeat.o(144608);
        return;
      }
      Iterator localIterator1 = this.kJs.iterator();
      while (localIterator1.hasNext())
      {
        ScanFilterCompat localScanFilterCompat = (ScanFilterCompat)localIterator1.next();
        paramBluetoothDevice = paramArrayOfByte.getDevice();
        if ((localScanFilterCompat.kJP != null) && ((paramBluetoothDevice == null) || (!localScanFilterCompat.kJP.equals(paramBluetoothDevice.getAddress())))) {
          paramInt = 0;
        }
        while (paramInt != 0)
        {
          locale.a(1, paramArrayOfByte);
          AppMethodBeat.o(144608);
          return;
          f localf = paramArrayOfByte.kKh;
          if ((localf == null) && ((localScanFilterCompat.mDeviceName != null) || (localScanFilterCompat.kJQ != null) || (localScanFilterCompat.kJW != null) || (localScanFilterCompat.kJT != null) || (localScanFilterCompat.kJS != null) || (localScanFilterCompat.kJV >= 0)))
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
            if (localScanFilterCompat.kJQ != null)
            {
              localObject1 = localScanFilterCompat.kJQ;
              localObject2 = localScanFilterCompat.kJR;
              paramBluetoothDevice = localf.kKb;
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
            if (localScanFilterCompat.kJS != null)
            {
              localObject1 = localScanFilterCompat.kJT;
              localObject2 = localScanFilterCompat.kJU;
              paramBluetoothDevice = localScanFilterCompat.kJS;
              if (paramBluetoothDevice == null) {}
              for (paramBluetoothDevice = null;; paramBluetoothDevice = (byte[])localf.kKd.get(paramBluetoothDevice))
              {
                if (ScanFilterCompat.a((byte[])localObject1, (byte[])localObject2, paramBluetoothDevice)) {
                  break label431;
                }
                paramInt = 0;
                break;
              }
            }
            label431:
            if ((localScanFilterCompat.kJV >= 0) && (localf != null))
            {
              paramBluetoothDevice = localScanFilterCompat.kJW;
              localObject1 = localScanFilterCompat.kJX;
              paramInt = localScanFilterCompat.kJV;
              if (!ScanFilterCompat.a(paramBluetoothDevice, (byte[])localObject1, (byte[])localf.kKc.get(paramInt)))
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
    static final n<e, b.d> kJr;
    
    static
    {
      AppMethodBeat.i(144611);
      kJr = new n();
      AppMethodBeat.o(144611);
    }
    
    public final boolean a(BluetoothAdapter paramBluetoothAdapter, e parame)
    {
      AppMethodBeat.i(144610);
      parame = (b.d)kJr.remove(parame);
      if (parame == null)
      {
        AppMethodBeat.o(144610);
        return false;
      }
      if (paramBluetoothAdapter.getBluetoothLeScanner() == null)
      {
        ae.e("MicroMsg.ble.BleScannerCompat", "bluetoothscanner is null, return");
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
          if (paramList.kJQ != null) {
            localBuilder.setServiceUuid(paramList.kJQ, paramList.kJR);
          }
          if (paramList.kJP != null) {
            localBuilder.setDeviceAddress(paramList.kJP);
          }
          if (paramList.kJS != null) {
            localBuilder.setServiceData(paramList.kJS, paramList.kJT, paramList.kJU);
          }
          if (paramList.kJV < 0) {
            localBuilder.setManufacturerData(paramList.kJV, paramList.kJW, paramList.kJX);
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
      paramScanSettingsCompat = new ScanSettings.Builder().setReportDelay(paramScanSettingsCompat.kKm).setScanMode(paramScanSettingsCompat.kKk).build();
      if (paramBluetoothAdapter.getBluetoothLeScanner() == null)
      {
        ae.e("MicroMsg.ble.BleScannerCompat", "bluetoothscanner is null, return");
        AppMethodBeat.o(144609);
        return false;
      }
      Object localObject = paramBluetoothAdapter.getBluetoothLeScanner();
      paramBluetoothAdapter = (b.d)kJr.get(parame);
      if (paramBluetoothAdapter != null) {}
      for (;;)
      {
        ((BluetoothLeScanner)localObject).startScan(paramList, paramScanSettingsCompat, paramBluetoothAdapter);
        AppMethodBeat.o(144609);
        return true;
        paramBluetoothAdapter = new b.d(parame);
        kJr.put(parame, paramBluetoothAdapter);
      }
    }
  }
  
  @TargetApi(21)
  static final class d
    extends ScanCallback
  {
    private final WeakReference<e> kJt;
    
    d(e parame)
    {
      AppMethodBeat.i(144612);
      this.kJt = new WeakReference(parame);
      AppMethodBeat.o(144612);
    }
    
    public final void onBatchScanResults(List<ScanResult> paramList)
    {
      AppMethodBeat.i(144614);
      if ((e)this.kJt.get() == null)
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
      e locale = (e)this.kJt.get();
      if (locale != null) {
        locale.onScanFailed(paramInt);
      }
      AppMethodBeat.o(144615);
    }
    
    public final void onScanResult(int paramInt, ScanResult paramScanResult)
    {
      AppMethodBeat.i(144613);
      e locale = (e)this.kJt.get();
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