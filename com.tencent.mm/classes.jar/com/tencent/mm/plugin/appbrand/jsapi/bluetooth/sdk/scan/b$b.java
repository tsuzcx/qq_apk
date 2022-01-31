package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.os.ParcelUuid;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class b$b
  implements BluetoothAdapter.LeScanCallback
{
  private final List<ScanFilterCompat> filters;
  private final WeakReference<e> gns;
  
  b$b(List<ScanFilterCompat> paramList, e parame)
  {
    this.filters = paramList;
    this.gns = new WeakReference(parame);
  }
  
  public final void onLeScan(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    e locale = (e)this.gns.get();
    if (locale == null) {
      return;
    }
    paramArrayOfByte = new ScanResultCompat(paramBluetoothDevice, f.O(paramArrayOfByte), paramInt, System.currentTimeMillis());
    if (this.filters == null)
    {
      locale.a(1, paramArrayOfByte);
      return;
    }
    Iterator localIterator1 = this.filters.iterator();
    while (localIterator1.hasNext())
    {
      ScanFilterCompat localScanFilterCompat = (ScanFilterCompat)localIterator1.next();
      paramBluetoothDevice = paramArrayOfByte.getDevice();
      if ((localScanFilterCompat.gnP != null) && ((paramBluetoothDevice == null) || (!localScanFilterCompat.gnP.equals(paramBluetoothDevice.getAddress())))) {
        paramInt = 0;
      }
      while (paramInt != 0)
      {
        locale.a(1, paramArrayOfByte);
        return;
        f localf = paramArrayOfByte.gog;
        if ((localf == null) && ((localScanFilterCompat.gnO != null) || (localScanFilterCompat.gnQ != null) || (localScanFilterCompat.gnW != null) || (localScanFilterCompat.gnT != null) || (localScanFilterCompat.gnS != null) || (localScanFilterCompat.gnV >= 0)))
        {
          paramInt = 0;
        }
        else if ((localScanFilterCompat.gnO != null) && (!localScanFilterCompat.gnO.equals(localf.gnO)))
        {
          paramInt = 0;
        }
        else
        {
          Object localObject1;
          Object localObject2;
          if (localScanFilterCompat.gnQ != null)
          {
            localObject1 = localScanFilterCompat.gnQ;
            localObject2 = localScanFilterCompat.gnR;
            paramBluetoothDevice = localf.gob;
            if (localObject1 == null) {
              paramInt = 1;
            }
            for (;;)
            {
              if (paramInt != 0) {
                break label343;
              }
              paramInt = 0;
              break;
              if (paramBluetoothDevice != null)
              {
                Iterator localIterator2 = paramBluetoothDevice.iterator();
                label336:
                for (;;)
                {
                  if (!localIterator2.hasNext()) {
                    break label338;
                  }
                  ParcelUuid localParcelUuid = (ParcelUuid)localIterator2.next();
                  if (localObject2 == null) {}
                  for (paramBluetoothDevice = null;; paramBluetoothDevice = ((ParcelUuid)localObject2).getUuid())
                  {
                    if (!ScanFilterCompat.a(((ParcelUuid)localObject1).getUuid(), paramBluetoothDevice, localParcelUuid.getUuid())) {
                      break label336;
                    }
                    paramInt = 1;
                    break;
                  }
                }
              }
              label338:
              paramInt = 0;
            }
          }
          label343:
          if (localScanFilterCompat.gnS != null)
          {
            localObject1 = localScanFilterCompat.gnT;
            localObject2 = localScanFilterCompat.gnU;
            paramBluetoothDevice = localScanFilterCompat.gnS;
            if (paramBluetoothDevice == null) {}
            for (paramBluetoothDevice = null;; paramBluetoothDevice = (byte[])localf.god.get(paramBluetoothDevice))
            {
              if (ScanFilterCompat.a((byte[])localObject1, (byte[])localObject2, paramBluetoothDevice)) {
                break label411;
              }
              paramInt = 0;
              break;
            }
          }
          label411:
          if ((localScanFilterCompat.gnV >= 0) && (localf != null))
          {
            paramBluetoothDevice = localScanFilterCompat.gnW;
            localObject1 = localScanFilterCompat.gnX;
            paramInt = localScanFilterCompat.gnV;
            if (!ScanFilterCompat.a(paramBluetoothDevice, (byte[])localObject1, (byte[])localf.goc.get(paramInt)))
            {
              paramInt = 0;
              continue;
            }
          }
          paramInt = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.b.b
 * JD-Core Version:    0.7.0.1
 */