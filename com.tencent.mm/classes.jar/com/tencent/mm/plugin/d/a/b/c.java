package com.tencent.mm.plugin.d.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
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
import junit.framework.Assert;

@TargetApi(18)
public final class c
  implements BluetoothAdapter.LeScanCallback
{
  private static c jOb;
  private BluetoothAdapter jNi;
  private ArrayList<c.a> jOc;
  private boolean jOd;
  private Context mContext;
  private ak mHandler;
  
  private c(Context paramContext)
  {
    AppMethodBeat.i(18382);
    if (paramContext == null)
    {
      ab.e("MicroMsg.exdevice.BluetoothLEScaner", "no context for scaner");
      AppMethodBeat.o(18382);
      return;
    }
    this.mContext = paramContext;
    this.jOc = new ArrayList();
    this.jOd = false;
    this.jNi = null;
    this.mHandler = null;
    this.jNi = ((BluetoothManager)this.mContext.getSystemService("bluetooth")).getAdapter();
    this.mHandler = new ak(new al("BluetoothLEScanerThread").oNc.getLooper());
    AppMethodBeat.o(18382);
  }
  
  private boolean a(c.a parama)
  {
    AppMethodBeat.i(18384);
    if (parama == null)
    {
      ab.e("MicroMsg.exdevice.BluetoothLEScaner", "callback is null");
      AppMethodBeat.o(18384);
      return false;
    }
    int i = 0;
    label53:
    boolean bool;
    if (i < this.jOc.size()) {
      if ((c.a)this.jOc.get(i) == parama)
      {
        if (i >= 0) {
          break label100;
        }
        bool = this.jOc.add(parama);
        ab.d("MicroMsg.exdevice.BluetoothLEScaner", "add callback ".concat(String.valueOf(bool)));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(18384);
      return bool;
      i += 1;
      break;
      i = -1;
      break label53;
      label100:
      bool = true;
      ab.w("MicroMsg.exdevice.BluetoothLEScaner", "callback has in queue. pass");
    }
  }
  
  public static c aVV()
  {
    AppMethodBeat.i(18381);
    if (jOb != null)
    {
      localc = jOb;
      AppMethodBeat.o(18381);
      return localc;
    }
    c localc = new c(ah.getContext());
    jOb = localc;
    AppMethodBeat.o(18381);
    return localc;
  }
  
  public final boolean a(boolean paramBoolean, c.a parama)
  {
    AppMethodBeat.i(18383);
    parama = (Boolean)new c.1(this, paramBoolean, parama).b(this.mHandler);
    if (parama != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = parama.booleanValue();
      AppMethodBeat.o(18383);
      return paramBoolean;
    }
  }
  
  public final void onLeScan(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(18385);
    ab.d("MicroMsg.exdevice.BluetoothLEScaner", "onLeScan. device addr = %s, name = %s, data = %s", new Object[] { paramBluetoothDevice.getAddress(), paramBluetoothDevice.getName(), b.aO(paramArrayOfByte) });
    ab.d("MicroMsg.exdevice.BluetoothLEScaner", "callback size = %d", new Object[] { Integer.valueOf(this.jOc.size()) });
    this.mHandler.post(new c.2(this, paramBluetoothDevice, paramInt, paramArrayOfByte));
    AppMethodBeat.o(18385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.c
 * JD-Core Version:    0.7.0.1
 */