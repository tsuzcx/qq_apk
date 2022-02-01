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
  protected final Handler aDv = new Handler(Looper.getMainLooper());
  public boolean aXs = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bFm().aXs;
  public volatile boolean brr = false;
  public boolean lMh = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bFm().lMh;
  public boolean lMj = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bFm().lMj;
  public d lNb;
  protected com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b lNc;
  public b lNd;
  private final Runnable lNe = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(144589);
      if (a.this.brr)
      {
        AppMethodBeat.o(144589);
        return;
      }
      a.this.a(j.lNJ);
      a.this.done();
      AppMethodBeat.o(144589);
    }
  };
  public long lNf = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bFm().lMe;
  public long lNg = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bFm().lMn;
  public j lNh;
  protected int lNi = hashCode();
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b paramb)
  {
    this.lNc = paramb;
  }
  
  public final void a(final j paramj)
  {
    this.lNh = paramj;
    if (this.lMh)
    {
      this.aDv.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(144590);
          a.this.lNd.a(paramj);
          AppMethodBeat.o(144590);
        }
      });
      return;
    }
    this.lNd.a(paramj);
  }
  
  public void b(j paramj) {}
  
  public abstract void bFt();
  
  public final void doAction()
  {
    Assert.assertNotNull(this.lNb);
    Assert.assertNotNull(this.lNc);
    Assert.assertNotNull(this.lNd);
    this.aDv.postDelayed(this.lNe, this.lNf);
    bFt();
  }
  
  public final void done()
  {
    this.aDv.removeCallbacks(this.lNe);
    this.brr = true;
    b(this.lNh);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b localb = this.lNc;
    Object localObject = this.lNh;
    if (localObject != null) {}
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectDispatcher", "actionCompleteCallback action:%s result:%s", new Object[] { this, localObject });
      if (!this.lMj) {
        break;
      }
      localb.bFo();
      return;
      localObject = "";
    }
    localObject = localb.lMw;
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
    return "Action#" + this.lNi + "{action='" + getName() + '\'' + ", debug=" + this.aXs + ", mainThread=" + this.lMh + ", serial=" + this.lMj + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
 * JD-Core Version:    0.7.0.1
 */