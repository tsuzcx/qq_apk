package com.tencent.mm.plugin.d.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import junit.framework.Assert;

@TargetApi(18)
public final class c
  implements BluetoothAdapter.LeScanCallback
{
  private static c mNe;
  private Context mContext;
  private ap mHandler;
  private BluetoothAdapter mMl;
  private ArrayList<a> mNf;
  private boolean mNg;
  
  private c(Context paramContext)
  {
    AppMethodBeat.i(22493);
    if (paramContext == null)
    {
      ad.e("MicroMsg.exdevice.BluetoothLEScaner", "no context for scaner");
      AppMethodBeat.o(22493);
      return;
    }
    this.mContext = paramContext;
    this.mNf = new ArrayList();
    this.mNg = false;
    this.mMl = null;
    this.mHandler = null;
    this.mMl = ((BluetoothManager)this.mContext.getSystemService("bluetooth")).getAdapter();
    this.mHandler = new ap("BluetoothLEScanerThread");
    AppMethodBeat.o(22493);
  }
  
  private boolean a(a parama)
  {
    AppMethodBeat.i(22495);
    if (parama == null)
    {
      ad.e("MicroMsg.exdevice.BluetoothLEScaner", "callback is null");
      AppMethodBeat.o(22495);
      return false;
    }
    int i = 0;
    label53:
    boolean bool;
    if (i < this.mNf.size()) {
      if ((a)this.mNf.get(i) == parama)
      {
        if (i >= 0) {
          break label100;
        }
        bool = this.mNf.add(parama);
        ad.d("MicroMsg.exdevice.BluetoothLEScaner", "add callback ".concat(String.valueOf(bool)));
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
      ad.w("MicroMsg.exdevice.BluetoothLEScaner", "callback has in queue. pass");
    }
  }
  
  public static c bBx()
  {
    AppMethodBeat.i(22492);
    if (mNe != null)
    {
      localc = mNe;
      AppMethodBeat.o(22492);
      return localc;
    }
    c localc = new c(aj.getContext());
    mNe = localc;
    AppMethodBeat.o(22492);
    return localc;
  }
  
  public final boolean a(final boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(22494);
    parama = (Boolean)new bo() {}.b(this.mHandler);
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
    ad.d("MicroMsg.exdevice.BluetoothLEScaner", "onLeScan. device addr = %s, name = %s, data = %s", new Object[] { paramBluetoothDevice.getAddress(), paramBluetoothDevice.getName(), b.be(paramArrayOfByte) });
    ad.d("MicroMsg.exdevice.BluetoothLEScaner", "callback size = %d", new Object[] { Integer.valueOf(this.mNf.size()) });
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
    
    public abstract void bBw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.c
 * JD-Core Version:    0.7.0.1
 */