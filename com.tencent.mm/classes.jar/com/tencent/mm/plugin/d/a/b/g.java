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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

@TargetApi(21)
public final class g
  extends ScanCallback
{
  private static g nRa;
  private Context mContext;
  private ap mHandler;
  private BluetoothAdapter nPt;
  private ArrayList<a> nQn;
  private boolean nQo;
  private BluetoothManager nRb;
  private BluetoothLeScanner nRc;
  
  private g(Context paramContext)
  {
    AppMethodBeat.i(22560);
    if (paramContext == null)
    {
      ad.e("MicroMsg.exdevice.NewBluetoothLEScanner", "No context for scanner");
      AppMethodBeat.o(22560);
      return;
    }
    this.mContext = paramContext;
    this.nQn = new ArrayList();
    this.nQo = false;
    this.nPt = null;
    this.nRc = null;
    this.mHandler = null;
    this.nRb = ((BluetoothManager)this.mContext.getSystemService("bluetooth"));
    this.nPt = this.nRb.getAdapter();
    if (this.nPt != null)
    {
      ad.d("MicroMsg.exdevice.NewBluetoothLEScanner", "Get bluetoothLeScanner");
      this.nRc = this.nPt.getBluetoothLeScanner();
    }
    this.mHandler = new ap("NewBluetoothLEScannerThread");
    AppMethodBeat.o(22560);
  }
  
  private boolean a(a parama)
  {
    AppMethodBeat.i(22562);
    if (parama == null)
    {
      ad.e("MicroMsg.exdevice.NewBluetoothLEScanner", "callback is null");
      AppMethodBeat.o(22562);
      return false;
    }
    int i = 0;
    label53:
    boolean bool;
    if (i < this.nQn.size()) {
      if ((a)this.nQn.get(i) == parama)
      {
        if (i >= 0) {
          break label100;
        }
        bool = this.nQn.add(parama);
        ad.d("MicroMsg.exdevice.NewBluetoothLEScanner", "add callback ".concat(String.valueOf(bool)));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(22562);
      return bool;
      i += 1;
      break;
      i = -1;
      break label53;
      label100:
      bool = true;
      ad.w("MicroMsg.exdevice.NewBluetoothLEScanner", "callback has in queue. pass");
    }
  }
  
  public static g bMN()
  {
    AppMethodBeat.i(22559);
    if (nRa != null)
    {
      localg = nRa;
      AppMethodBeat.o(22559);
      return localg;
    }
    g localg = new g(aj.getContext());
    nRa = localg;
    AppMethodBeat.o(22559);
    return localg;
  }
  
  public final boolean a(final boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(22561);
    ad.i("MicroMsg.exdevice.NewBluetoothLEScanner", "(API21)execute scan");
    parama = (Boolean)new bo() {}.b(this.mHandler);
    if (parama != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = parama.booleanValue();
      AppMethodBeat.o(22561);
      return paramBoolean;
    }
  }
  
  public final void onBatchScanResults(List<ScanResult> paramList)
  {
    AppMethodBeat.i(22565);
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ScanResult localScanResult = (ScanResult)paramList.next();
        ad.d("MicroMsg.exdevice.NewBluetoothLEScanner", "onLeScan. device addr = %s, name = %s, data = %s", new Object[] { localScanResult.getDevice().getAddress(), localScanResult.getDevice().getName(), b.bg(localScanResult.getScanRecord().getBytes()) });
      }
    }
    AppMethodBeat.o(22565);
  }
  
  public final void onScanFailed(final int paramInt)
  {
    AppMethodBeat.i(22563);
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22558);
        int i = 0;
        while (i < g.a(g.this).size())
        {
          ((g.a)g.a(g.this).get(i)).yW(paramInt);
          i += 1;
        }
        AppMethodBeat.o(22558);
      }
    });
    AppMethodBeat.o(22563);
  }
  
  public final void onScanResult(final int paramInt, final ScanResult paramScanResult)
  {
    AppMethodBeat.i(22564);
    if ((paramScanResult != null) && (paramScanResult.getScanRecord() != null))
    {
      ad.d("MicroMsg.exdevice.NewBluetoothLEScanner", "onLeScan. device addr = %s, name = %s, data = %s", new Object[] { paramScanResult.getDevice().getAddress(), paramScanResult.getDevice().getName(), b.bg(paramScanResult.getScanRecord().getBytes()) });
      ad.d("MicroMsg.exdevice.NewBluetoothLEScanner", "callback size = %d", new Object[] { Integer.valueOf(this.nQn.size()) });
      final BluetoothDevice localBluetoothDevice = paramScanResult.getDevice();
      paramInt = paramScanResult.getRssi();
      paramScanResult = paramScanResult.getScanRecord().getBytes();
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(22557);
          int i = 0;
          while (i < g.a(g.this).size())
          {
            ((g.a)g.a(g.this).get(i)).a(localBluetoothDevice, paramInt, paramScanResult);
            i += 1;
          }
          AppMethodBeat.o(22557);
        }
      });
    }
    AppMethodBeat.o(22564);
  }
  
  public static abstract interface a
  {
    public abstract void a(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte);
    
    public abstract void yW(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.g
 * JD-Core Version:    0.7.0.1
 */