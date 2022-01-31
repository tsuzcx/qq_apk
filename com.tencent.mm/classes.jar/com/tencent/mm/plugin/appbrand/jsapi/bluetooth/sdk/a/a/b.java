package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;

@TargetApi(18)
public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  public String bwK;
  
  public b(String paramString)
  {
    this.bwK = paramString;
  }
  
  public final void aiu()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aiA();
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.ConnectAction", "action:%s, bluetoothGatt is null", new Object[] { this });
      a(j.gmW);
      done();
      return;
    }
    if ((this.bwK == null) || (!BluetoothAdapter.checkBluetoothAddress(this.bwK)))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.ConnectAction", "action:%s, unspecified deviceId", new Object[] { this });
      a(j.gnf);
      done();
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aiB())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.ConnectAction", "bluetooth is not enable.", new Object[0]);
      a(j.gmR);
      done();
      return;
    }
    if (this.gmv.gmp != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.ConnectAction", "already connect, please close", new Object[0]);
      a(j.gne);
      done();
      return;
    }
    localObject = ((BluetoothAdapter)localObject).getRemoteDevice(this.bwK);
    if (localObject != null)
    {
      localObject = ((BluetoothDevice)localObject).connectGatt(this.gmv.context, false, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(this.gmv));
      if (localObject != null)
      {
        String str = this.bwK;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
          bool1 = true;
        }
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "create a new connection deviceId=%s mainthread:%b", new Object[] { str, Boolean.valueOf(bool1) });
        this.gmv.gmp = ((BluetoothGatt)localObject);
        return;
      }
      localObject = this.bwK;
      bool1 = bool2;
      if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        bool1 = true;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.ConnectAction", "Get Gatt fail!, deviceId=%s mainthread:%b", new Object[] { localObject, Boolean.valueOf(bool1) });
    }
    for (;;)
    {
      a(j.gmP);
      done();
      return;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.ConnectAction", "Device not found, deviceId=%s", new Object[] { this.bwK });
    }
  }
  
  public final void b(j paramj)
  {
    switch (paramj.errCode)
    {
    default: 
      return;
    }
    this.gmv.da(false);
  }
  
  public final String getName()
  {
    return "ConnectAction";
  }
  
  public final void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    String str1;
    String str2;
    if (paramBluetoothGatt != null)
    {
      str1 = paramBluetoothGatt.toString();
      String str3 = f.lk(paramInt1);
      if (paramInt2 != 2) {
        break label80;
      }
      str2 = "CONNECTED";
      label25:
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "[onConnectionStateChange]gatt:%s gattStatus:%s, newState:%s", new Object[] { str1, str3, str2 });
      if (paramInt2 != 2) {
        break label87;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "Attempting to start service discovery", new Object[0]);
      paramBluetoothGatt.discoverServices();
    }
    label80:
    label87:
    while (paramInt2 != 0)
    {
      return;
      str1 = "";
      break;
      str2 = "DISCONNECTED";
      break label25;
    }
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "close", new Object[0]);
    paramBluetoothGatt.close();
    paramBluetoothGatt = new StringBuilder();
    paramBluetoothGatt.append("fail:connection fail");
    paramBluetoothGatt.append(" ");
    paramBluetoothGatt.append("status:");
    paramBluetoothGatt.append(paramInt1);
    a(new j(10003, paramBluetoothGatt.toString()));
  }
  
  public final void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "[onServicesDiscovered] status:%s", new Object[] { f.lk(paramInt) });
    if (paramInt == 0) {
      a(j.gmO);
    }
    for (;;)
    {
      done();
      return;
      a(j.gng);
    }
  }
  
  public final String toString()
  {
    return "ConnectAction{deviceId='" + this.bwK + '\'' + ", debug=" + this.apo + ", mainThread=" + this.glS + ", serial=" + this.glU + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.b
 * JD-Core Version:    0.7.0.1
 */