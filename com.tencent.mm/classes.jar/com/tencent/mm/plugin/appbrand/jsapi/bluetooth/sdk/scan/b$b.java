package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.os.ParcelUuid;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class b$b
  implements BluetoothAdapter.LeScanCallback
{
  private final List<ScanFilterCompat> filters;
  private final WeakReference<e> hHq;
  
  b$b(List<ScanFilterCompat> paramList, e parame)
  {
    AppMethodBeat.i(94295);
    this.filters = paramList;
    this.hHq = new WeakReference(parame);
    AppMethodBeat.o(94295);
  }
  
  public final void onLeScan(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(94296);
    e locale = (e)this.hHq.get();
    if (locale == null)
    {
      AppMethodBeat.o(94296);
      return;
    }
    paramArrayOfByte = new ScanResultCompat(paramBluetoothDevice, f.ai(paramArrayOfByte), paramInt, System.currentTimeMillis());
    if (this.filters == null)
    {
      locale.a(1, paramArrayOfByte);
      AppMethodBeat.o(94296);
      return;
    }
    Iterator localIterator1 = this.filters.iterator();
    while (localIterator1.hasNext())
    {
      ScanFilterCompat localScanFilterCompat = (ScanFilterCompat)localIterator1.next();
      paramBluetoothDevice = paramArrayOfByte.getDevice();
      if ((localScanFilterCompat.hHM != null) && ((paramBluetoothDevice == null) || (!localScanFilterCompat.hHM.equals(paramBluetoothDevice.getAddress())))) {
        paramInt = 0;
      }
      while (paramInt != 0)
      {
        locale.a(1, paramArrayOfByte);
        AppMethodBeat.o(94296);
        return;
        f localf = paramArrayOfByte.hId;
        if ((localf == null) && ((localScanFilterCompat.mDeviceName != null) || (localScanFilterCompat.hHN != null) || (localScanFilterCompat.hHT != null) || (localScanFilterCompat.hHQ != null) || (localScanFilterCompat.hHP != null) || (localScanFilterCompat.hHS >= 0)))
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
          if (localScanFilterCompat.hHN != null)
          {
            localObject1 = localScanFilterCompat.hHN;
            localObject2 = localScanFilterCompat.hHO;
            paramBluetoothDevice = localf.hHY;
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
          if (localScanFilterCompat.hHP != null)
          {
            localObject1 = localScanFilterCompat.hHQ;
            localObject2 = localScanFilterCompat.hHR;
            paramBluetoothDevice = localScanFilterCompat.hHP;
            if (paramBluetoothDevice == null) {}
            for (paramBluetoothDevice = null;; paramBluetoothDevice = (byte[])localf.hIa.get(paramBluetoothDevice))
            {
              if (ScanFilterCompat.a((byte[])localObject1, (byte[])localObject2, paramBluetoothDevice)) {
                break label431;
              }
              paramInt = 0;
              break;
            }
          }
          label431:
          if ((localScanFilterCompat.hHS >= 0) && (localf != null))
          {
            paramBluetoothDevice = localScanFilterCompat.hHT;
            localObject1 = localScanFilterCompat.hHU;
            paramInt = localScanFilterCompat.hHS;
            if (!ScanFilterCompat.a(paramBluetoothDevice, (byte[])localObject1, (byte[])localf.hHZ.get(paramInt)))
            {
              paramInt = 0;
              continue;
            }
          }
          paramInt = 1;
        }
      }
    }
    AppMethodBeat.o(94296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.b.b
 * JD-Core Version:    0.7.0.1
 */