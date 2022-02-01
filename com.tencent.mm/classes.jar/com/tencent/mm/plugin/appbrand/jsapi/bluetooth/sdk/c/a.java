package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e;
import java.util.List;
import junit.framework.Assert;

public abstract class a
  implements e
{
  public boolean aMt = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.jIN.aMt;
  protected final Handler azU = new Handler(Looper.getMainLooper());
  public volatile boolean bgw = false;
  public boolean jIS = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.jIN.jIS;
  public boolean jIU = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.jIN.jIU;
  public d jJH;
  protected com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b jJI;
  public b jJJ;
  private final Runnable jJK = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(144589);
      if (a.this.bgw)
      {
        AppMethodBeat.o(144589);
        return;
      }
      a.this.a(j.jKo);
      a.this.done();
      AppMethodBeat.o(144589);
    }
  };
  public long jJL = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.jIN.jIP;
  public long jJM = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.jIN.jIY;
  public j jJN;
  protected int jJO = hashCode();
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b paramb)
  {
    this.jJI = paramb;
  }
  
  public final void a(final j paramj)
  {
    this.jJN = paramj;
    if (this.jIS)
    {
      this.azU.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(144590);
          a.this.jJJ.a(paramj);
          AppMethodBeat.o(144590);
        }
      });
      return;
    }
    this.jJJ.a(paramj);
  }
  
  public abstract void aYR();
  
  public void b(j paramj) {}
  
  public final void doAction()
  {
    Assert.assertNotNull(this.jJH);
    Assert.assertNotNull(this.jJI);
    Assert.assertNotNull(this.jJJ);
    this.azU.postDelayed(this.jJK, this.jJL);
    aYR();
  }
  
  public final void done()
  {
    this.azU.removeCallbacks(this.jJK);
    this.bgw = true;
    b(this.jJN);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b localb = this.jJI;
    Object localObject = this.jJN;
    if (localObject != null) {}
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectDispatcher", "actionCompleteCallback action:%s result:%s", new Object[] { this, localObject });
      if (!this.jIU) {
        break;
      }
      localb.aYO();
      return;
      localObject = "";
    }
    localObject = localb.jJg;
    if (localObject != null)
    {
      ((List)localObject).remove(this);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectDispatcher", "actionCompleteCallback, runActions is null", new Object[0]);
  }
  
  public abstract String getName();
  
  public final void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic) {}
  
  public void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt) {}
  
  public void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt) {}
  
  public void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2) {}
  
  public final void onDescriptorRead(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt) {}
  
  public void onDescriptorWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt) {}
  
  public void onMtuChanged(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2) {}
  
  public void onReadRemoteRssi(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2) {}
  
  public final void onReliableWriteCompleted(BluetoothGatt paramBluetoothGatt, int paramInt) {}
  
  public void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt) {}
  
  public String toString()
  {
    return "Action#" + this.jJO + "{action='" + getName() + '\'' + ", debug=" + this.aMt + ", mainThread=" + this.jIS + ", serial=" + this.jIU + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
 * JD-Core Version:    0.7.0.1
 */