package com.tencent.mm.plugin.d.a.b;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

@TargetApi(21)
public final class g
  extends ScanCallback
{
  private static g jOP;
  private BluetoothAdapter jNi;
  private BluetoothManager jOQ;
  private BluetoothLeScanner jOR;
  private ArrayList<g.a> jOc;
  private boolean jOd;
  private Context mContext;
  private ak mHandler;
  
  private g(Context paramContext)
  {
    AppMethodBeat.i(18449);
    if (paramContext == null)
    {
      ab.e("MicroMsg.exdevice.NewBluetoothLEScanner", "No context for scanner");
      AppMethodBeat.o(18449);
      return;
    }
    this.mContext = paramContext;
    this.jOc = new ArrayList();
    this.jOd = false;
    this.jNi = null;
    this.jOR = null;
    this.mHandler = null;
    this.jOQ = ((BluetoothManager)this.mContext.getSystemService("bluetooth"));
    this.jNi = this.jOQ.getAdapter();
    if (this.jNi != null)
    {
      ab.d("MicroMsg.exdevice.NewBluetoothLEScanner", "Get bluetoothLeScanner");
      this.jOR = this.jNi.getBluetoothLeScanner();
    }
    this.mHandler = new ak(new al("NewBluetoothLEScannerThread").oNc.getLooper());
    AppMethodBeat.o(18449);
  }
  
  private boolean a(g.a parama)
  {
    AppMethodBeat.i(18451);
    if (parama == null)
    {
      ab.e("MicroMsg.exdevice.NewBluetoothLEScanner", "callback is null");
      AppMethodBeat.o(18451);
      return false;
    }
    int i = 0;
    label53:
    boolean bool;
    if (i < this.jOc.size()) {
      if ((g.a)this.jOc.get(i) == parama)
      {
        if (i >= 0) {
          break label100;
        }
        bool = this.jOc.add(parama);
        ab.d("MicroMsg.exdevice.NewBluetoothLEScanner", "add callback ".concat(String.valueOf(bool)));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(18451);
      return bool;
      i += 1;
      break;
      i = -1;
      break label53;
      label100:
      bool = true;
      ab.w("MicroMsg.exdevice.NewBluetoothLEScanner", "callback has in queue. pass");
    }
  }
  
  public static g aWa()
  {
    AppMethodBeat.i(18448);
    if (jOP != null)
    {
      localg = jOP;
      AppMethodBeat.o(18448);
      return localg;
    }
    g localg = new g(ah.getContext());
    jOP = localg;
    AppMethodBeat.o(18448);
    return localg;
  }
  
  public final boolean a(boolean paramBoolean, g.a parama)
  {
    AppMethodBeat.i(18450);
    ab.i("MicroMsg.exdevice.NewBluetoothLEScanner", "(API21)execute scan");
    parama = (Boolean)new g.1(this, paramBoolean, parama).b(this.mHandler);
    if (parama != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = parama.booleanValue();
      AppMethodBeat.o(18450);
      return paramBoolean;
    }
  }
  
  public final void onBatchScanResults(List<ScanResult> paramList)
  {
    AppMethodBeat.i(18454);
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ScanResult localScanResult = (ScanResult)paramList.next();
        ab.d("MicroMsg.exdevice.NewBluetoothLEScanner", "onLeScan. device addr = %s, name = %s, data = %s", new Object[] { localScanResult.getDevice().getAddress(), localScanResult.getDevice().getName(), b.aO(localScanResult.getScanRecord().getBytes()) });
      }
    }
    AppMethodBeat.o(18454);
  }
  
  public final void onScanFailed(int paramInt)
  {
    AppMethodBeat.i(18452);
    this.mHandler.post(new g.3(this, paramInt));
    AppMethodBeat.o(18452);
  }
  
  public final void onScanResult(int paramInt, ScanResult paramScanResult)
  {
    AppMethodBeat.i(18453);
    if ((paramScanResult != null) && (paramScanResult.getScanRecord() != null))
    {
      ab.d("MicroMsg.exdevice.NewBluetoothLEScanner", "onLeScan. device addr = %s, name = %s, data = %s", new Object[] { paramScanResult.getDevice().getAddress(), paramScanResult.getDevice().getName(), b.aO(paramScanResult.getScanRecord().getBytes()) });
      ab.d("MicroMsg.exdevice.NewBluetoothLEScanner", "callback size = %d", new Object[] { Integer.valueOf(this.jOc.size()) });
      BluetoothDevice localBluetoothDevice = paramScanResult.getDevice();
      paramInt = paramScanResult.getRssi();
      paramScanResult = paramScanResult.getScanRecord().getBytes();
      this.mHandler.post(new g.2(this, localBluetoothDevice, paramInt, paramScanResult));
    }
    AppMethodBeat.o(18453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.g
 * JD-Core Version:    0.7.0.1
 */