package com.tencent.mm.plugin.g.a.b;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SyncTask;
import java.util.ArrayList;
import junit.framework.Assert;

public final class c
  implements BluetoothAdapter.LeScanCallback
{
  private static c vuZ;
  private ArrayList<a> mCallbackList;
  private Context mContext;
  private MMHandler mHandler;
  private BluetoothAdapter vug;
  private boolean vva;
  
  private c(Context paramContext)
  {
    AppMethodBeat.i(22493);
    if (paramContext == null)
    {
      Log.e("MicroMsg.exdevice.BluetoothLEScaner", "no context for scaner");
      AppMethodBeat.o(22493);
      return;
    }
    this.mContext = paramContext;
    this.mCallbackList = new ArrayList();
    this.vva = false;
    this.vug = null;
    this.mHandler = null;
    this.vug = ((BluetoothManager)this.mContext.getSystemService("bluetooth")).getAdapter();
    this.mHandler = new MMHandler("BluetoothLEScanerThread");
    AppMethodBeat.o(22493);
  }
  
  private boolean a(a parama)
  {
    AppMethodBeat.i(22495);
    if (parama == null)
    {
      Log.e("MicroMsg.exdevice.BluetoothLEScaner", "callback is null");
      AppMethodBeat.o(22495);
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
        Log.d("MicroMsg.exdevice.BluetoothLEScaner", "add callback ".concat(String.valueOf(bool)));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(22495);
      return bool;
      i += 1;
      break;
      i = -1;
      break label53;
      label100:
      bool = true;
      Log.w("MicroMsg.exdevice.BluetoothLEScaner", "callback has in queue. pass");
    }
  }
  
  public static c daS()
  {
    AppMethodBeat.i(22492);
    if (vuZ != null)
    {
      localc = vuZ;
      AppMethodBeat.o(22492);
      return localc;
    }
    c localc = new c(MMApplicationContext.getContext());
    vuZ = localc;
    AppMethodBeat.o(22492);
    return localc;
  }
  
  public final boolean a(final boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(22494);
    parama = (Boolean)new SyncTask() {}.exec(this.mHandler);
    if (parama != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = parama.booleanValue();
      AppMethodBeat.o(22494);
      return paramBoolean;
    }
  }
  
  public final void onLeScan(final BluetoothDevice paramBluetoothDevice, final int paramInt, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22496);
    Log.d("MicroMsg.exdevice.BluetoothLEScaner", "onLeScan. device addr = %s, name = %s, data = %s", new Object[] { paramBluetoothDevice.getAddress(), paramBluetoothDevice.getName(), b.bK(paramArrayOfByte) });
    Log.d("MicroMsg.exdevice.BluetoothLEScaner", "callback size = %d", new Object[] { Integer.valueOf(this.mCallbackList.size()) });
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22491);
        int i = 0;
        while (i < c.a(c.this).size())
        {
          ((c.a)c.a(c.this).get(i)).a(paramBluetoothDevice, paramInt, paramArrayOfByte);
          i += 1;
        }
        AppMethodBeat.o(22491);
      }
    });
    AppMethodBeat.o(22496);
  }
  
  public static abstract interface a
  {
    public abstract void a(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte);
    
    public abstract void daR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.g.a.b.c
 * JD-Core Version:    0.7.0.1
 */