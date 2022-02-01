package com.tencent.mm.plugin.d.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bp;
import java.util.ArrayList;
import junit.framework.Assert;

@TargetApi(18)
public final class c
  implements BluetoothAdapter.LeScanCallback
{
  private static c nVS;
  private Context mContext;
  private aq mHandler;
  private BluetoothAdapter nUZ;
  private ArrayList<a> nVT;
  private boolean nVU;
  
  private c(Context paramContext)
  {
    AppMethodBeat.i(22493);
    if (paramContext == null)
    {
      ae.e("MicroMsg.exdevice.BluetoothLEScaner", "no context for scaner");
      AppMethodBeat.o(22493);
      return;
    }
    this.mContext = paramContext;
    this.nVT = new ArrayList();
    this.nVU = false;
    this.nUZ = null;
    this.mHandler = null;
    this.nUZ = ((BluetoothManager)this.mContext.getSystemService("bluetooth")).getAdapter();
    this.mHandler = new aq("BluetoothLEScanerThread");
    AppMethodBeat.o(22493);
  }
  
  private boolean a(a parama)
  {
    AppMethodBeat.i(22495);
    if (parama == null)
    {
      ae.e("MicroMsg.exdevice.BluetoothLEScaner", "callback is null");
      AppMethodBeat.o(22495);
      return false;
    }
    int i = 0;
    label53:
    boolean bool;
    if (i < this.nVT.size()) {
      if ((a)this.nVT.get(i) == parama)
      {
        if (i >= 0) {
          break label100;
        }
        bool = this.nVT.add(parama);
        ae.d("MicroMsg.exdevice.BluetoothLEScaner", "add callback ".concat(String.valueOf(bool)));
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
      ae.w("MicroMsg.exdevice.BluetoothLEScaner", "callback has in queue. pass");
    }
  }
  
  public static c bNG()
  {
    AppMethodBeat.i(22492);
    if (nVS != null)
    {
      localc = nVS;
      AppMethodBeat.o(22492);
      return localc;
    }
    c localc = new c(ak.getContext());
    nVS = localc;
    AppMethodBeat.o(22492);
    return localc;
  }
  
  public final boolean a(final boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(22494);
    parama = (Boolean)new bp() {}.b(this.mHandler);
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
    ae.d("MicroMsg.exdevice.BluetoothLEScaner", "onLeScan. device addr = %s, name = %s, data = %s", new Object[] { paramBluetoothDevice.getAddress(), paramBluetoothDevice.getName(), b.bf(paramArrayOfByte) });
    ae.d("MicroMsg.exdevice.BluetoothLEScaner", "callback size = %d", new Object[] { Integer.valueOf(this.nVT.size()) });
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
    
    public abstract void bNF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.c
 * JD-Core Version:    0.7.0.1
 */