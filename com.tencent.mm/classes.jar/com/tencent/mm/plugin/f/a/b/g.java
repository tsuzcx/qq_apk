package com.tencent.mm.plugin.f.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.HandlerThread;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(21)
public final class g
  extends ScanCallback
{
  private static g hUV;
  private BluetoothAdapter hTo;
  private BluetoothManager hUW;
  private BluetoothLeScanner hUX;
  private ArrayList<g.a> hUi;
  private boolean hUj;
  private Context mContext;
  ah mHandler;
  
  private g(Context paramContext)
  {
    if (paramContext == null)
    {
      y.e("MicroMsg.exdevice.NewBluetoothLEScanner", "No context for scanner");
      return;
    }
    this.mContext = paramContext;
    this.hUi = new ArrayList();
    this.hUj = false;
    this.hTo = null;
    this.hUX = null;
    this.mHandler = null;
    this.hUW = ((BluetoothManager)this.mContext.getSystemService("bluetooth"));
    this.hTo = this.hUW.getAdapter();
    if (this.hTo != null)
    {
      y.d("MicroMsg.exdevice.NewBluetoothLEScanner", "Get bluetoothLeScanner");
      this.hUX = this.hTo.getBluetoothLeScanner();
    }
    this.mHandler = new ah(new ai("NewBluetoothLEScannerThread").mnU.getLooper());
  }
  
  private boolean a(g.a parama)
  {
    if (parama == null)
    {
      y.e("MicroMsg.exdevice.NewBluetoothLEScanner", "callback is null");
      return false;
    }
    int i = 0;
    if (i < this.hUi.size()) {
      if ((g.a)this.hUi.get(i) != parama) {}
    }
    for (;;)
    {
      if (i >= 0) {
        break label89;
      }
      boolean bool = this.hUi.add(parama);
      y.d("MicroMsg.exdevice.NewBluetoothLEScanner", "add callback " + bool);
      return bool;
      i += 1;
      break;
      i = -1;
    }
    label89:
    y.w("MicroMsg.exdevice.NewBluetoothLEScanner", "callback has in queue. pass");
    return true;
  }
  
  public static g awx()
  {
    if (hUV != null) {
      return hUV;
    }
    g localg = new g(ae.getContext());
    hUV = localg;
    return localg;
  }
  
  public final void onBatchScanResults(List<ScanResult> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ScanResult localScanResult = (ScanResult)paramList.next();
        y.d("MicroMsg.exdevice.NewBluetoothLEScanner", "onLeScan. device addr = %s, name = %s, data = %s", new Object[] { localScanResult.getDevice().getAddress(), localScanResult.getDevice().getName(), b.aq(localScanResult.getScanRecord().getBytes()) });
      }
    }
  }
  
  public final void onScanFailed(int paramInt)
  {
    this.mHandler.post(new g.3(this, paramInt));
  }
  
  public final void onScanResult(int paramInt, ScanResult paramScanResult)
  {
    if ((paramScanResult != null) && (paramScanResult.getScanRecord() != null))
    {
      y.d("MicroMsg.exdevice.NewBluetoothLEScanner", "onLeScan. device addr = %s, name = %s, data = %s", new Object[] { paramScanResult.getDevice().getAddress(), paramScanResult.getDevice().getName(), b.aq(paramScanResult.getScanRecord().getBytes()) });
      y.d("MicroMsg.exdevice.NewBluetoothLEScanner", "callback size = %d", new Object[] { Integer.valueOf(this.hUi.size()) });
      BluetoothDevice localBluetoothDevice = paramScanResult.getDevice();
      paramInt = paramScanResult.getRssi();
      paramScanResult = paramScanResult.getScanRecord().getBytes();
      this.mHandler.post(new g.2(this, localBluetoothDevice, paramInt, paramScanResult));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.g
 * JD-Core Version:    0.7.0.1
 */