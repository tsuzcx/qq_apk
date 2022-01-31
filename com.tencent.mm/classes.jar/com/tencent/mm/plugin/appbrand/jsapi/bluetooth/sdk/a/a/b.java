package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;

@TargetApi(18)
public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  public String bYu;
  public boolean hGq;
  public String hGr = "LE";
  
  public b(String paramString)
  {
    this.bYu = paramString;
  }
  
  public final void aCo()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    AppMethodBeat.i(94259);
    Object localObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aCv();
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.ConnectAction", "action:%s, bluetoothGatt is null", new Object[] { this });
      a(j.hGV);
      done();
      AppMethodBeat.o(94259);
      return;
    }
    if ((this.bYu == null) || (!BluetoothAdapter.checkBluetoothAddress(this.bYu)))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.ConnectAction", "action:%s, unspecified deviceId", new Object[] { this });
      a(j.hHe);
      done();
      AppMethodBeat.o(94259);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aCw())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.ConnectAction", "bluetooth is not enable.", new Object[0]);
      a(j.hGQ);
      done();
      AppMethodBeat.o(94259);
      return;
    }
    if (this.hGv.hGn != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.ConnectAction", "already connect, please close", new Object[0]);
      a(j.hHd);
      done();
      AppMethodBeat.o(94259);
      return;
    }
    localObject = ((BluetoothAdapter)localObject).getRemoteDevice(this.bYu);
    if (localObject != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "autoConnect:%b transport:%s", new Object[] { Boolean.valueOf(this.hGq), this.hGr });
      String str;
      int i;
      if (Build.VERSION.SDK_INT >= 23)
      {
        str = this.hGr.toUpperCase();
        i = -1;
        switch (str.hashCode())
        {
        default: 
          switch (i)
          {
          default: 
            localObject = ((BluetoothDevice)localObject).connectGatt(this.hGv.context, this.hGq, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(this.hGv), 2);
          }
          break;
        }
      }
      for (;;)
      {
        if (localObject == null) {
          break label589;
        }
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "mBluetoothGatt:%s", new Object[] { localObject });
        str = this.bYu;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
          bool1 = true;
        }
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "create a new connection deviceId=%s mainthread:%b", new Object[] { str, Boolean.valueOf(bool1) });
        this.hGv.hGn = ((BluetoothGatt)localObject);
        AppMethodBeat.o(94259);
        return;
        if (!str.equals("LE")) {
          break;
        }
        i = 0;
        break;
        if (!str.equals("AUTO")) {
          break;
        }
        i = 1;
        break;
        if (!str.equals("BREDR")) {
          break;
        }
        i = 2;
        break;
        localObject = ((BluetoothDevice)localObject).connectGatt(this.hGv.context, this.hGq, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(this.hGv), 2);
        continue;
        localObject = ((BluetoothDevice)localObject).connectGatt(this.hGv.context, this.hGq, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(this.hGv), 0);
        continue;
        localObject = ((BluetoothDevice)localObject).connectGatt(this.hGv.context, this.hGq, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(this.hGv), 1);
        continue;
        localObject = ((BluetoothDevice)localObject).connectGatt(this.hGv.context, this.hGq, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(this.hGv));
      }
      label589:
      localObject = this.bYu;
      bool1 = bool2;
      if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        bool1 = true;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.ConnectAction", "Get Gatt fail!, deviceId=%s mainthread:%b", new Object[] { localObject, Boolean.valueOf(bool1) });
    }
    for (;;)
    {
      a(j.hGO);
      done();
      AppMethodBeat.o(94259);
      return;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.ConnectAction", "Device not found, deviceId=%s", new Object[] { this.bYu });
    }
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(94260);
    switch (paramj.errCode)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(94260);
      return;
      this.hGv.ee(false);
    }
  }
  
  public final String getName()
  {
    return "ConnectAction";
  }
  
  public final void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94261);
    String str1;
    String str3;
    if (paramBluetoothGatt != null)
    {
      str1 = paramBluetoothGatt.toString();
      str3 = f.nT(paramInt1);
      if (paramInt2 != 2) {
        break label98;
      }
    }
    label98:
    for (String str2 = "CONNECTED";; str2 = "DISCONNECTED")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "[onConnectionStateChange]gatt:%s gattStatus:%s, newState:%s", new Object[] { str1, str3, str2 });
      this.hGv.hGn = paramBluetoothGatt;
      if (paramInt2 != 2) {
        break label105;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "Attempting to start service discovery", new Object[0]);
      paramBluetoothGatt.discoverServices();
      AppMethodBeat.o(94261);
      return;
      str1 = "";
      break;
    }
    label105:
    if (paramInt2 == 0)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "close", new Object[0]);
      this.hGv.ee(false);
      paramBluetoothGatt = new StringBuilder();
      paramBluetoothGatt.append("fail:connection fail");
      paramBluetoothGatt.append(" ");
      paramBluetoothGatt.append("status:");
      paramBluetoothGatt.append(paramInt1);
      a(new j(10003, paramBluetoothGatt.toString()));
    }
    AppMethodBeat.o(94261);
  }
  
  public final void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    AppMethodBeat.i(94262);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "[onServicesDiscovered] status:%s", new Object[] { f.nT(paramInt) });
    this.hGv.hGn = paramBluetoothGatt;
    if (paramInt == 0) {
      a(j.hGN);
    }
    for (;;)
    {
      done();
      AppMethodBeat.o(94262);
      return;
      a(j.hHf);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(94263);
    String str = "ConnectAction{deviceId='" + this.bYu + '\'' + ", debug=" + this.arI + ", mainThread=" + this.hFR + ", serial=" + this.hFT + '}';
    AppMethodBeat.o(94263);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.b
 * JD-Core Version:    0.7.0.1
 */