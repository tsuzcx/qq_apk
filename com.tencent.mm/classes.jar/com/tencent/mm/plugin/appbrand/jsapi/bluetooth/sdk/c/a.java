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
  public boolean aGM = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bQQ().aGM;
  public volatile boolean baT = false;
  protected final Handler die = new Handler(Looper.getMainLooper());
  public boolean oIw = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bQQ().oIw;
  public boolean oIy = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bQQ().oIy;
  public d oJp;
  protected com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b oJq;
  public b oJr;
  private final Runnable oJs = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(144589);
      if (a.this.baT)
      {
        AppMethodBeat.o(144589);
        return;
      }
      a.this.a(j.oJX);
      a.this.done();
      AppMethodBeat.o(144589);
    }
  };
  public long oJt = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bQQ().oIt;
  public long oJu = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bQQ().oIC;
  public j oJv;
  protected int oJw = hashCode();
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b paramb)
  {
    this.oJq = paramb;
  }
  
  public final void a(final j paramj)
  {
    this.oJv = paramj;
    if (this.oIw)
    {
      this.die.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(144590);
          a.this.oJr.a(paramj);
          AppMethodBeat.o(144590);
        }
      });
      return;
    }
    this.oJr.a(paramj);
  }
  
  public void b(j paramj) {}
  
  public abstract void bQZ();
  
  public final void doAction()
  {
    Assert.assertNotNull(this.oJp);
    Assert.assertNotNull(this.oJq);
    Assert.assertNotNull(this.oJr);
    this.die.postDelayed(this.oJs, this.oJt);
    bQZ();
  }
  
  public final void done()
  {
    this.die.removeCallbacks(this.oJs);
    this.baT = true;
    b(this.oJv);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b localb = this.oJq;
    Object localObject = this.oJv;
    if (localObject != null) {}
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectDispatcher", "actionCompleteCallback action:%s result:%s", new Object[] { this, localObject });
      if (!this.oIy) {
        break;
      }
      localb.bQS();
      return;
      localObject = "";
    }
    localObject = localb.oIM;
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
    return "Action#" + this.oJw + "{action='" + getName() + '\'' + ", debug=" + this.aGM + ", mainThread=" + this.oIw + ", serial=" + this.oIy + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
 * JD-Core Version:    0.7.0.1
 */