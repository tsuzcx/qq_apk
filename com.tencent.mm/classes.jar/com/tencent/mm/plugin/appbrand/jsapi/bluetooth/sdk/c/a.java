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
  protected final Handler aAO = new Handler(Looper.getMainLooper());
  public boolean aNj = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.kjo.aNj;
  public boolean bhc = false;
  public boolean kjt = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.kjo.kjt;
  public boolean kjv = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.kjo.kjv;
  public d kkh;
  protected com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b kki;
  public b kkj;
  private Runnable kkk = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(144589);
      if (a.this.bhc)
      {
        AppMethodBeat.o(144589);
        return;
      }
      a.this.a(j.kkP);
      a.this.done();
      AppMethodBeat.o(144589);
    }
  };
  public long kkl = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.kjo.kjq;
  public long kkm = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.kjo.kjz;
  public j kkn;
  protected int kko = hashCode();
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b paramb)
  {
    this.kki = paramb;
  }
  
  public final void a(final j paramj)
  {
    this.kkn = paramj;
    if (this.kjt)
    {
      this.aAO.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(144590);
          a.this.kkj.a(paramj);
          AppMethodBeat.o(144590);
        }
      });
      return;
    }
    this.kkj.a(paramj);
  }
  
  public void b(j paramj) {}
  
  public abstract void bfM();
  
  public final void doAction()
  {
    Assert.assertNotNull(this.kkh);
    Assert.assertNotNull(this.kki);
    Assert.assertNotNull(this.kkj);
    this.aAO.postDelayed(this.kkk, this.kkl);
    bfM();
  }
  
  public final void done()
  {
    this.aAO.removeCallbacks(this.kkk);
    this.bhc = true;
    b(this.kkn);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b localb = this.kki;
    Object localObject = this.kkn;
    if (localObject != null) {}
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectDispatcher", "actionCompleteCallback action:%s result:%s", new Object[] { this, localObject });
      if (!this.kjv) {
        break;
      }
      localb.bfK();
      return;
      localObject = "";
    }
    localb.kjH.remove(this);
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
    return "Action#" + this.kko + "{action='" + getName() + '\'' + ", debug=" + this.aNj + ", mainThread=" + this.kjt + ", serial=" + this.kjv + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
 * JD-Core Version:    0.7.0.1
 */