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
  public boolean aXD = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.kEm.aXD;
  public boolean brw = false;
  public boolean kEr = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.kEm.kEr;
  public boolean kEt = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.kEm.kEt;
  public d kFh;
  protected com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b kFi;
  public b kFj;
  private Runnable kFk = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(144589);
      if (a.this.brw)
      {
        AppMethodBeat.o(144589);
        return;
      }
      a.this.a(j.kFP);
      a.this.done();
      AppMethodBeat.o(144589);
    }
  };
  public long kFl = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.kEm.kEo;
  public long kFm = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.kEm.kEx;
  public j kFn;
  protected int kFo = hashCode();
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b paramb)
  {
    this.kFi = paramb;
  }
  
  public final void a(final j paramj)
  {
    this.kFn = paramj;
    if (this.kEr)
    {
      this.aCF.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(144590);
          a.this.kFj.a(paramj);
          AppMethodBeat.o(144590);
        }
      });
      return;
    }
    this.kFj.a(paramj);
  }
  
  public void b(j paramj) {}
  
  public abstract void bjq();
  
  public final void doAction()
  {
    Assert.assertNotNull(this.kFh);
    Assert.assertNotNull(this.kFi);
    Assert.assertNotNull(this.kFj);
    this.aCF.postDelayed(this.kFk, this.kFl);
    bjq();
  }
  
  public final void done()
  {
    this.aCF.removeCallbacks(this.kFk);
    this.brw = true;
    b(this.kFn);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b localb = this.kFi;
    Object localObject = this.kFn;
    if (localObject != null) {}
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectDispatcher", "actionCompleteCallback action:%s result:%s", new Object[] { this, localObject });
      if (!this.kEt) {
        break;
      }
      localb.bjo();
      return;
      localObject = "";
    }
    localb.kEF.remove(this);
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
    return "Action#" + this.kFo + "{action='" + getName() + '\'' + ", debug=" + this.aXD + ", mainThread=" + this.kEr + ", serial=" + this.kEt + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
 * JD-Core Version:    0.7.0.1
 */