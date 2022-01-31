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
  public boolean aKX = false;
  public boolean arI = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.hFM.arI;
  private final Handler bTu = new Handler(Looper.getMainLooper());
  public boolean hFR = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.hFM.hFR;
  public boolean hFT = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.hFM.hFT;
  public long hGA = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.hFM.hFX;
  public j hGB;
  protected d hGv;
  protected com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b hGw;
  public b hGx;
  private Runnable hGy = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(94277);
      if (a.this.aKX)
      {
        AppMethodBeat.o(94277);
        return;
      }
      a.this.a(j.hHc);
      a.this.done();
      AppMethodBeat.o(94277);
    }
  };
  public long hGz = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.hFM.hFO;
  
  private void aCq()
  {
    Assert.assertNotNull(this.hGv);
    Assert.assertNotNull(this.hGw);
    Assert.assertNotNull(this.hGx);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b paramb)
  {
    this.hGw = paramb;
  }
  
  public final void a(d paramd)
  {
    this.hGv = paramd;
  }
  
  public final void a(j paramj)
  {
    this.hGB = paramj;
    if (this.hFR)
    {
      this.bTu.post(new a.2(this, paramj));
      return;
    }
    this.hGx.a(paramj);
  }
  
  public abstract void aCo();
  
  public final void aCp()
  {
    aCq();
    this.bTu.postDelayed(this.hGy, this.hGz);
    aCo();
  }
  
  public void b(j paramj) {}
  
  public final void done()
  {
    this.bTu.removeCallbacks(this.hGy);
    this.aKX = true;
    b(this.hGB);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b localb = this.hGw;
    Object localObject = this.hGB;
    if (localObject != null) {}
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectDispatcher", "actionCompleteCallback action:%s result:%s", new Object[] { this, localObject });
      if (!this.hFT) {
        break;
      }
      localb.aCn();
      return;
      localObject = "";
    }
    localb.hGf.remove(this);
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
    return "Action{action='" + getName() + '\'' + ", debug=" + this.arI + ", mainThread=" + this.hFR + ", serial=" + this.hFT + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
 * JD-Core Version:    0.7.0.1
 */