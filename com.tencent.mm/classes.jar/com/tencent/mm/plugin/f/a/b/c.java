package com.tencent.mm.plugin.f.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.HandlerThread;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import junit.framework.Assert;

@TargetApi(18)
public final class c
  implements BluetoothAdapter.LeScanCallback
{
  private static c hUh;
  private BluetoothAdapter hTo;
  private ArrayList<c.a> hUi;
  private boolean hUj;
  private Context mContext;
  private ah mHandler;
  
  private c(Context paramContext)
  {
    if (paramContext == null)
    {
      y.e("MicroMsg.exdevice.BluetoothLEScaner", "no context for scaner");
      return;
    }
    this.mContext = paramContext;
    this.hUi = new ArrayList();
    this.hUj = false;
    this.hTo = null;
    this.mHandler = null;
    this.hTo = ((BluetoothManager)this.mContext.getSystemService("bluetooth")).getAdapter();
    this.mHandler = new ah(new ai("BluetoothLEScanerThread").mnU.getLooper());
  }
  
  private boolean a(c.a parama)
  {
    if (parama == null)
    {
      y.e("MicroMsg.exdevice.BluetoothLEScaner", "callback is null");
      return false;
    }
    int i = 0;
    if (i < this.hUi.size()) {
      if ((c.a)this.hUi.get(i) != parama) {}
    }
    for (;;)
    {
      if (i >= 0) {
        break label89;
      }
      boolean bool = this.hUi.add(parama);
      y.d("MicroMsg.exdevice.BluetoothLEScaner", "add callback " + bool);
      return bool;
      i += 1;
      break;
      i = -1;
    }
    label89:
    y.w("MicroMsg.exdevice.BluetoothLEScaner", "callback has in queue. pass");
    return true;
  }
  
  public static c aws()
  {
    if (hUh != null) {
      return hUh;
    }
    c localc = new c(ae.getContext());
    hUh = localc;
    return localc;
  }
  
  public final boolean a(boolean paramBoolean, c.a parama)
  {
    parama = (Boolean)new c.1(this, paramBoolean, parama).b(this.mHandler);
    if (parama != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      return parama.booleanValue();
    }
  }
  
  public final void onLeScan(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.exdevice.BluetoothLEScaner", "onLeScan. device addr = %s, name = %s, data = %s", new Object[] { paramBluetoothDevice.getAddress(), paramBluetoothDevice.getName(), b.aq(paramArrayOfByte) });
    y.d("MicroMsg.exdevice.BluetoothLEScaner", "callback size = %d", new Object[] { Integer.valueOf(this.hUi.size()) });
    this.mHandler.post(new c.2(this, paramBluetoothDevice, paramInt, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.c
 * JD-Core Version:    0.7.0.1
 */