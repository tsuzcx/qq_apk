package com.tencent.mm.plugin.g.a.b;

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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SyncTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class g
  extends ScanCallback
{
  private static g vvM;
  private ArrayList<a> mCallbackList;
  private Context mContext;
  private MMHandler mHandler;
  private BluetoothAdapter vug;
  private BluetoothManager vvN;
  private BluetoothLeScanner vvO;
  private boolean vva;
  
  private g(Context paramContext)
  {
    AppMethodBeat.i(22560);
    if (paramContext == null)
    {
      Log.e("MicroMsg.exdevice.NewBluetoothLEScanner", "No context for scanner");
      AppMethodBeat.o(22560);
      return;
    }
    this.mContext = paramContext;
    this.mCallbackList = new ArrayList();
    this.vva = false;
    this.vug = null;
    this.vvO = null;
    this.mHandler = null;
    this.vvN = ((BluetoothManager)this.mContext.getSystemService("bluetooth"));
    this.vug = this.vvN.getAdapter();
    if (this.vug != null)
    {
      Log.d("MicroMsg.exdevice.NewBluetoothLEScanner", "Get bluetoothLeScanner");
      this.vvO = this.vug.getBluetoothLeScanner();
    }
    this.mHandler = new MMHandler("NewBluetoothLEScannerThread");
    AppMethodBeat.o(22560);
  }
  
  private boolean a(a parama)
  {
    AppMethodBeat.i(22562);
    if (parama == null)
    {
      Log.e("MicroMsg.exdevice.NewBluetoothLEScanner", "callback is null");
      AppMethodBeat.o(22562);
      return false;
    }
    int i = 0;
    label53:
    boolean bool;
    if (i < this.mCallbackList.size()) {
      if ((a)this.mCallbackList.get(i) == parama)
      {
        if (i >= 0) {
          break label100;
        }
        bool = this.mCallbackList.add(parama);
        Log.d("MicroMsg.exdevice.NewBluetoothLEScanner", "add callback ".concat(String.valueOf(bool)));
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
      Log.w("MicroMsg.exdevice.NewBluetoothLEScanner", "callback has in queue. pass");
    }
  }
  
  public static g daX()
  {
    AppMethodBeat.i(22559);
    if (vvM != null)
    {
      localg = vvM;
      AppMethodBeat.o(22559);
      return localg;
    }
    g localg = new g(MMApplicationContext.getContext());
    vvM = localg;
    AppMethodBeat.o(22559);
    return localg;
  }
  
  public final boolean a(final boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(22561);
    Log.i("MicroMsg.exdevice.NewBluetoothLEScanner", "(API21)execute scan");
    parama = (Boolean)new SyncTask() {}.exec(this.mHandler);
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
        Log.d("MicroMsg.exdevice.NewBluetoothLEScanner", "onLeScan. device addr = %s, name = %s, data = %s", new Object[] { localScanResult.getDevice().getAddress(), localScanResult.getDevice().getName(), b.bK(localScanResult.getScanRecord().getBytes()) });
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
          ((g.a)g.a(g.this).get(i)).GP(paramInt);
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
      Log.d("MicroMsg.exdevice.NewBluetoothLEScanner", "onLeScan. device addr = %s, name = %s, data = %s", new Object[] { paramScanResult.getDevice().getAddress(), paramScanResult.getDevice().getName(), b.bK(paramScanResult.getScanRecord().getBytes()) });
      Log.d("MicroMsg.exdevice.NewBluetoothLEScanner", "callback size = %d", new Object[] { Integer.valueOf(this.mCallbackList.size()) });
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
    public abstract void GP(int paramInt);
    
    public abstract void a(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.g.a.b.g
 * JD-Core Version:    0.7.0.1
 */