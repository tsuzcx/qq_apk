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
  protected final Handler aCF = new Handler(Looper.getMainLooper());
  public boolean aXD = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.kHB.aXD;
  public boolean brw = false;
  public boolean kHG = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.kHB.kHG;
  public boolean kHI = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.kHB.kHI;
  public long kIA = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.kHB.kHD;
  public long kIB = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.kHB.kHM;
  public j kIC;
  protected int kID = hashCode();
  public d kIw;
  protected com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b kIx;
  public b kIy;
  private Runnable kIz = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(144589);
      if (a.this.brw)
      {
        AppMethodBeat.o(144589);
        return;
      }
      a.this.a(j.kJe);
      a.this.done();
      AppMethodBeat.o(144589);
    }
  };
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b paramb)
  {
    this.kIx = paramb;
  }
  
  public final void a(final j paramj)
  {
    this.kIC = paramj;
    if (this.kHG)
    {
      this.aCF.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(144590);
          a.this.kIy.a(paramj);
          AppMethodBeat.o(144590);
        }
      });
      return;
    }
    this.kIy.a(paramj);
  }
  
  public void b(j paramj) {}
  
  public abstract void bjZ();
  
  public final void doAction()
  {
    Assert.assertNotNull(this.kIw);
    Assert.assertNotNull(this.kIx);
    Assert.assertNotNull(this.kIy);
    this.aCF.postDelayed(this.kIz, this.kIA);
    bjZ();
  }
  
  public final void done()
  {
    this.aCF.removeCallbacks(this.kIz);
    this.brw = true;
    b(this.kIC);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b localb = this.kIx;
    Object localObject = this.kIC;
    if (localObject != null) {}
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectDispatcher", "actionCompleteCallback action:%s result:%s", new Object[] { this, localObject });
      if (!this.kHI) {
        break;
      }
      localb.bjX();
      return;
      localObject = "";
    }
    localb.kHU.remove(this);
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
    return "Action#" + this.kID + "{action='" + getName() + '\'' + ", debug=" + this.aXD + ", mainThread=" + this.kHG + ", serial=" + this.kHI + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
 * JD-Core Version:    0.7.0.1
 */