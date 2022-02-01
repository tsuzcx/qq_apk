package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

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
import android.util.SparseArray;
import androidx.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanFilterCompat;>;
import java.util.Map;

public final class c
{
  static final e rOh;
  
  static
  {
    AppMethodBeat.i(144618);
    int i = Build.VERSION.SDK_INT;
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.rMn)
    {
      Log.i("MicroMsg.ble.BleScannerCompat", "use 18");
      rOh = new a();
      AppMethodBeat.o(144618);
      return;
    }
    if (i >= 21)
    {
      Log.i("MicroMsg.ble.BleScannerCompat", "use 21");
      rOh = new c();
      AppMethodBeat.o(144618);
      return;
    }
    Log.i("MicroMsg.ble.BleScannerCompat", "use 18");
    rOh = new a();
    AppMethodBeat.o(144618);
  }
  
  public static boolean a(BluetoothAdapter paramBluetoothAdapter, h paramh)
  {
    AppMethodBeat.i(144617);
    boolean bool = rOh.a(paramBluetoothAdapter, paramh);
    AppMethodBeat.o(144617);
    return bool;
  }
  
  public static boolean a(BluetoothAdapter paramBluetoothAdapter, List<ScanFilterCompat> paramList, ScanSettingsCompat paramScanSettingsCompat, h paramh)
  {
    AppMethodBeat.i(144616);
    Log.i("MicroMsg.ble.BleScannerCompat", "scanMode: " + paramScanSettingsCompat.rPd);
    boolean bool = rOh.a(paramBluetoothAdapter, paramList, paramScanSettingsCompat, paramh);
    AppMethodBeat.o(144616);
    return bool;
  }
  
  @Deprecated
  static final class a
    implements c.e
  {
    static final g<h, c.b> rOi;
    
    static
    {
      AppMethodBeat.i(144606);
      rOi = new g();
      AppMethodBeat.o(144606);
    }
    
    public final boolean a(BluetoothAdapter paramBluetoothAdapter, h paramh)
    {
      AppMethodBeat.i(144605);
      paramh = (c.b)rOi.remove(paramh);
      if (paramh == null)
      {
        AppMethodBeat.o(144605);
        return false;
      }
      paramBluetoothAdapter.stopLeScan(paramh);
      AppMethodBeat.o(144605);
      return true;
    }
    
    public final boolean a(BluetoothAdapter paramBluetoothAdapter, List<ScanFilterCompat> paramList, ScanSettingsCompat paramScanSettingsCompat, h paramh)
    {
      AppMethodBeat.i(144604);
      Log.i("MicroMsg.ble.BleScannerCompat", "[BluetoothTrace] start scan");
      Log.printErrStackTrace("MicroMsg.ble.BleScannerCompat", new Throwable(), "[BluetoothTrace] ble scan stacktrace", new Object[0]);
      paramScanSettingsCompat = (c.b)rOi.get(paramh);
      if (paramScanSettingsCompat != null) {
        paramList = paramScanSettingsCompat;
      }
      for (;;)
      {
        boolean bool = ((Boolean)com.tencent.mm.hellhoundlib.a.a.a(paramBluetoothAdapter, new com.tencent.mm.hellhoundlib.b.a().cG(paramList).aYi(), "com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/BleScanerCompat$API18BluetoothLeScannerCompatImpl", "startScan", "(Landroid/bluetooth/BluetoothAdapter;Ljava/util/List;Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/ScanSettingsCompat;Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/ScanCallbackCompat;)Z", "android/bluetooth/BluetoothAdapter", "startLeScan", "(Landroid/bluetooth/BluetoothAdapter$LeScanCallback;)Z")).booleanValue();
        AppMethodBeat.o(144604);
        return bool;
        paramList = new c.b(paramList, paramh);
        rOi.put(paramh, paramList);
      }
    }
  }
  
  @Deprecated
  static final class b
    implements BluetoothAdapter.LeScanCallback
  {
    private final List<ScanFilterCompat> rOj;
    private final WeakReference<h> rOk;
    
    b(List<ScanFilterCompat> paramList, h paramh)
    {
      AppMethodBeat.i(144607);
      this.rOj = paramList;
      this.rOk = new WeakReference(paramh);
      AppMethodBeat.o(144607);
    }
    
    public final void onLeScan(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(144608);
      h localh = (h)this.rOk.get();
      if (localh == null)
      {
        AppMethodBeat.o(144608);
        return;
      }
      paramArrayOfByte = new ScanResultCompat(paramBluetoothDevice, i.aV(paramArrayOfByte), paramInt, System.currentTimeMillis());
      if (this.rOj == null)
      {
        localh.a(1, paramArrayOfByte);
        AppMethodBeat.o(144608);
        return;
      }
      Iterator localIterator1 = this.rOj.iterator();
      while (localIterator1.hasNext())
      {
        ScanFilterCompat localScanFilterCompat = (ScanFilterCompat)localIterator1.next();
        paramBluetoothDevice = paramArrayOfByte.crn();
        if ((localScanFilterCompat.rOH != null) && ((paramBluetoothDevice == null) || (!localScanFilterCompat.rOH.equals(paramBluetoothDevice.getAddress())))) {
          paramInt = 0;
        }
        while (paramInt != 0)
        {
          localh.a(1, paramArrayOfByte);
          AppMethodBeat.o(144608);
          return;
          i locali = paramArrayOfByte.rPa;
          if ((locali == null) && ((localScanFilterCompat.mDeviceName != null) || (localScanFilterCompat.rOI != null) || (localScanFilterCompat.rOO != null) || (localScanFilterCompat.rOL != null) || (localScanFilterCompat.rOK != null) || (localScanFilterCompat.rON >= 0)))
          {
            paramInt = 0;
          }
          else if ((localScanFilterCompat.mDeviceName != null) && (!localScanFilterCompat.mDeviceName.equals(locali.mDeviceName)))
          {
            paramInt = 0;
          }
          else
          {
            Object localObject1;
            Object localObject2;
            if (localScanFilterCompat.rOI != null)
            {
              localObject1 = localScanFilterCompat.rOI;
              localObject2 = localScanFilterCompat.rOJ;
              paramBluetoothDevice = locali.rOT;
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
            if (localScanFilterCompat.rOK != null)
            {
              localObject1 = localScanFilterCompat.rOL;
              localObject2 = localScanFilterCompat.rOM;
              paramBluetoothDevice = localScanFilterCompat.rOK;
              if (paramBluetoothDevice == null) {}
              for (paramBluetoothDevice = null;; paramBluetoothDevice = (byte[])locali.rOV.get(paramBluetoothDevice))
              {
                if (ScanFilterCompat.a((byte[])localObject1, (byte[])localObject2, paramBluetoothDevice)) {
                  break label431;
                }
                paramInt = 0;
                break;
              }
            }
            label431:
            if ((localScanFilterCompat.rON >= 0) && (locali != null))
            {
              if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.cqY().rMo) {
                paramInt = localScanFilterCompat.rON;
              }
              for (paramBluetoothDevice = (byte[])locali.rOY.get(paramInt);; paramBluetoothDevice = (byte[])locali.rOU.get(paramInt))
              {
                if (ScanFilterCompat.a(localScanFilterCompat.rOO, localScanFilterCompat.rOP, paramBluetoothDevice)) {
                  break label516;
                }
                paramInt = 0;
                break;
                paramInt = localScanFilterCompat.rON;
              }
            }
            label516:
            paramInt = 1;
          }
        }
      }
      AppMethodBeat.o(144608);
    }
  }
  
  static final class c
    implements c.e
  {
    static final g<h, c.d> rOi;
    
    static
    {
      AppMethodBeat.i(144611);
      rOi = new g();
      AppMethodBeat.o(144611);
    }
    
    public final boolean a(BluetoothAdapter paramBluetoothAdapter, h paramh)
    {
      AppMethodBeat.i(144610);
      paramh = (c.d)rOi.remove(paramh);
      if (paramh == null)
      {
        AppMethodBeat.o(144610);
        return false;
      }
      if (paramBluetoothAdapter.getBluetoothLeScanner() == null)
      {
        Log.e("MicroMsg.ble.BleScannerCompat", "bluetoothscanner is null, return");
        AppMethodBeat.o(144610);
        return false;
      }
      paramBluetoothAdapter.getBluetoothLeScanner().stopScan(paramh);
      AppMethodBeat.o(144610);
      return true;
    }
    
    public final boolean a(BluetoothAdapter paramBluetoothAdapter, List<ScanFilterCompat> paramList, ScanSettingsCompat paramScanSettingsCompat, h paramh)
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
          if (paramList.rOI != null) {
            localBuilder.setServiceUuid(paramList.rOI, paramList.rOJ);
          }
          if (paramList.rOH != null) {
            localBuilder.setDeviceAddress(paramList.rOH);
          }
          if (paramList.rOK != null) {
            localBuilder.setServiceData(paramList.rOK, paramList.rOL, paramList.rOM);
          }
          if (paramList.rON < 0) {
            localBuilder.setManufacturerData(paramList.rON, paramList.rOO, paramList.rOP);
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
      paramScanSettingsCompat = new ScanSettings.Builder().setReportDelay(paramScanSettingsCompat.rPf).setScanMode(paramScanSettingsCompat.rPd).build();
      if (paramBluetoothAdapter.getBluetoothLeScanner() == null)
      {
        Log.e("MicroMsg.ble.BleScannerCompat", "bluetoothscanner is null, return");
        AppMethodBeat.o(144609);
        return false;
      }
      Log.i("MicroMsg.ble.BleScannerCompat", "[BluetoothTrace] start scan");
      Log.printErrStackTrace("MicroMsg.ble.BleScannerCompat", new Throwable(), "[BluetoothTrace] ble scan stacktrace", new Object[0]);
      Object localObject = paramBluetoothAdapter.getBluetoothLeScanner();
      paramBluetoothAdapter = (c.d)rOi.get(paramh);
      if (paramBluetoothAdapter != null) {}
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(localObject, new com.tencent.mm.hellhoundlib.b.a().cG(paramBluetoothAdapter).cG(paramScanSettingsCompat).cG(paramList).aYi(), "com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/BleScanerCompat$API21BluetoothLeScannerCompatImpl", "startScan", "(Landroid/bluetooth/BluetoothAdapter;Ljava/util/List;Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/ScanSettingsCompat;Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/ScanCallbackCompat;)Z", "android/bluetooth/le/BluetoothLeScanner", "startScan", "(Ljava/util/List;Landroid/bluetooth/le/ScanSettings;Landroid/bluetooth/le/ScanCallback;)V");
        AppMethodBeat.o(144609);
        return true;
        paramBluetoothAdapter = new c.d(paramh);
        rOi.put(paramh, paramBluetoothAdapter);
      }
    }
  }
  
  static final class d
    extends ScanCallback
  {
    private final WeakReference<h> rOk;
    
    d(h paramh)
    {
      AppMethodBeat.i(144612);
      this.rOk = new WeakReference(paramh);
      AppMethodBeat.o(144612);
    }
    
    public final void onBatchScanResults(List<ScanResult> paramList)
    {
      AppMethodBeat.i(144614);
      if ((h)this.rOk.get() == null)
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
      h localh = (h)this.rOk.get();
      if (localh != null) {
        localh.onScanFailed(paramInt);
      }
      AppMethodBeat.o(144615);
    }
    
    public final void onScanResult(int paramInt, ScanResult paramScanResult)
    {
      AppMethodBeat.i(144613);
      h localh = (h)this.rOk.get();
      if (localh != null) {
        localh.a(paramInt, new ScanResultCompat(paramScanResult));
      }
      AppMethodBeat.o(144613);
    }
  }
  
  static abstract interface e
  {
    public abstract boolean a(BluetoothAdapter paramBluetoothAdapter, h paramh);
    
    public abstract boolean a(BluetoothAdapter paramBluetoothAdapter, List<ScanFilterCompat> paramList, ScanSettingsCompat paramScanSettingsCompat, h paramh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.c
 * JD-Core Version:    0.7.0.1
 */