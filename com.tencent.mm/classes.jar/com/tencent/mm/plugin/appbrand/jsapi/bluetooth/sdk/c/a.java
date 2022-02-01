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
  public volatile boolean cUO = false;
  public boolean debug = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.cqY().debug;
  protected final Handler mainHandler = new Handler(Looper.getMainLooper());
  public boolean rMf = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.cqY().rMf;
  public boolean rMh = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.cqY().rMh;
  public d rNd;
  protected com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b rNe;
  public b rNf;
  private final Runnable rNg = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(144589);
      if (a.this.cUO)
      {
        AppMethodBeat.o(144589);
        return;
      }
      a.this.onResult(k.rNN);
      a.this.done();
      AppMethodBeat.o(144589);
    }
  };
  public long rNh = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.cqY().rMc;
  public long rNi = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.cqY().rMl;
  public k rNj;
  protected int rNk = hashCode();
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b paramb)
  {
    this.rNe = paramb;
  }
  
  public void a(k paramk) {}
  
  public abstract void crh();
  
  public final void doAction()
  {
    Assert.assertNotNull(this.rNd);
    Assert.assertNotNull(this.rNe);
    Assert.assertNotNull(this.rNf);
    this.mainHandler.postDelayed(this.rNg, this.rNh);
    crh();
  }
  
  public final void done()
  {
    this.mainHandler.removeCallbacks(this.rNg);
    this.cUO = true;
    a(this.rNj);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b localb = this.rNe;
    Object localObject = this.rNj;
    if (localObject != null) {}
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectDispatcher", "actionCompleteCallback action:%s result:%s", new Object[] { this, localObject });
      if (!this.rMh) {
        break;
      }
      localb.crb();
      return;
      localObject = "";
    }
    localObject = localb.rMw;
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
  
  public final void onResult(final k paramk)
  {
    this.rNj = paramk;
    if (this.rMf)
    {
      this.mainHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(144590);
          a.this.rNf.onResult(paramk);
          AppMethodBeat.o(144590);
        }
      });
      return;
    }
    this.rNf.onResult(paramk);
  }
  
  public void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt) {}
  
  public String toString()
  {
    return "Action#" + this.rNk + "{action='" + getName() + '\'' + ", debug=" + this.debug + ", mainThread=" + this.rMf + ", serial=" + this.rMh + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
 * JD-Core Version:    0.7.0.1
 */