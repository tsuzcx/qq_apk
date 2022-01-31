package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e;
import java.util.List;
import junit.framework.Assert;

public abstract class a
  implements e
{
  public boolean aEm = false;
  public boolean apo = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.glN.apo;
  public boolean glS = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.glN.glS;
  public boolean glU = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.glN.glU;
  public long gmA = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.glN.glY;
  public j gmB;
  private final Handler gmh = new Handler(Looper.getMainLooper());
  public d gmv;
  protected com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b gmw;
  public b gmx;
  private Runnable gmy = new a.1(this);
  public long gmz = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.glN.glP;
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b paramb)
  {
    this.gmw = paramb;
  }
  
  public final void a(j paramj)
  {
    this.gmB = paramj;
    if (this.glS)
    {
      this.gmh.post(new a.2(this, paramj));
      return;
    }
    this.gmx.a(paramj);
  }
  
  public abstract void aiu();
  
  public final void aiv()
  {
    Assert.assertNotNull(this.gmv);
    Assert.assertNotNull(this.gmw);
    Assert.assertNotNull(this.gmx);
    this.gmh.postDelayed(this.gmy, this.gmz);
    aiu();
  }
  
  public void b(j paramj) {}
  
  public final void done()
  {
    this.gmh.removeCallbacks(this.gmy);
    this.aEm = true;
    b(this.gmB);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b localb = this.gmw;
    Object localObject = this.gmB;
    if (localObject != null) {}
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectDispatcher", "actionCompleteCallback action:%s result:%s", new Object[] { this, localObject });
      if (this != null)
      {
        if (!this.glU) {
          break;
        }
        localb.ait();
      }
      return;
      localObject = "";
    }
    localb.gmg.remove(this);
  }
  
  public abstract String getName();
  
  public final void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic) {}
  
  public void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt) {}
  
  public void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt) {}
  
  public void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2) {}
  
  public final void onDescriptorRead(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt) {}
  
  public void onDescriptorWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt) {}
  
  public final void onMtuChanged(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2) {}
  
  public final void onReadRemoteRssi(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2) {}
  
  public final void onReliableWriteCompleted(BluetoothGatt paramBluetoothGatt, int paramInt) {}
  
  public void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt) {}
  
  public String toString()
  {
    return "Action{action='" + getName() + '\'' + ", debug=" + this.apo + ", mainThread=" + this.glS + ", serial=" + this.glU + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
 * JD-Core Version:    0.7.0.1
 */