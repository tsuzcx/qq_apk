package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;

@TargetApi(18)
public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  public String cLR;
  public boolean jJt;
  public String jJu = "LE";
  public long jJv = 0L;
  
  public b(String paramString)
  {
    this.cLR = paramString;
  }
  
  public final void aYR()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    AppMethodBeat.i(144571);
    Object localObject = c.aZb();
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.ConnectAction", "action:%s, bluetoothGatt is null", new Object[] { this });
      a(j.jKh);
      done();
      AppMethodBeat.o(144571);
      return;
    }
    if ((this.cLR == null) || (!BluetoothAdapter.checkBluetoothAddress(this.cLR)))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.ConnectAction", "action:%s, unspecified deviceId", new Object[] { this });
      a(j.jKq);
      done();
      AppMethodBeat.o(144571);
      return;
    }
    if (!c.aZd())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.ConnectAction", "bluetooth is not enable.", new Object[0]);
      a(j.jKc);
      done();
      AppMethodBeat.o(144571);
      return;
    }
    if (this.jJH.jJp != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.ConnectAction", "already connect, please close", new Object[0]);
      a(j.jKp);
      done();
      AppMethodBeat.o(144571);
      return;
    }
    localObject = ((BluetoothAdapter)localObject).getRemoteDevice(this.cLR);
    if (localObject != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "autoConnect:%b transport:%s", new Object[] { Boolean.valueOf(this.jJt), this.jJu });
      String str;
      int i;
      if (Build.VERSION.SDK_INT >= 23)
      {
        str = this.jJu.toUpperCase();
        i = -1;
        switch (str.hashCode())
        {
        default: 
          switch (i)
          {
          default: 
            localObject = ((BluetoothDevice)localObject).connectGatt(this.jJH.context, this.jJt, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(this.jJH), 2);
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
        str = this.cLR;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
          bool1 = true;
        }
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "create a new connection deviceId=%s mainthread:%b", new Object[] { str, Boolean.valueOf(bool1) });
        this.jJH.jJp = ((BluetoothGatt)localObject);
        AppMethodBeat.o(144571);
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
        localObject = ((BluetoothDevice)localObject).connectGatt(this.jJH.context, this.jJt, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(this.jJH), 2);
        continue;
        localObject = ((BluetoothDevice)localObject).connectGatt(this.jJH.context, this.jJt, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(this.jJH), 0);
        continue;
        localObject = ((BluetoothDevice)localObject).connectGatt(this.jJH.context, this.jJt, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(this.jJH), 1);
        continue;
        localObject = ((BluetoothDevice)localObject).connectGatt(this.jJH.context, this.jJt, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(this.jJH));
      }
      label589:
      localObject = this.cLR;
      bool1 = bool2;
      if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        bool1 = true;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.ConnectAction", "Get Gatt fail!, deviceId=%s mainthread:%b", new Object[] { localObject, Boolean.valueOf(bool1) });
    }
    for (;;)
    {
      a(j.jKa);
      done();
      AppMethodBeat.o(144571);
      return;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.ConnectAction", "Device not found, deviceId=%s", new Object[] { this.cLR });
    }
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(144572);
    switch (paramj.errCode)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(144572);
      return;
      this.jJH.fS(false);
    }
  }
  
  public final String getName()
  {
    return "ConnectAction";
  }
  
  public final void onConnectionStateChange(final BluetoothGatt paramBluetoothGatt, final int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144573);
    String str1;
    String str3;
    if (paramBluetoothGatt != null)
    {
      str1 = paramBluetoothGatt.toString();
      str3 = f.rB(paramInt1);
      if (paramInt2 != 2) {
        break label97;
      }
    }
    label97:
    for (String str2 = "CONNECTED";; str2 = "DISCONNECTED")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "[onConnectionStateChange]gatt:%s gattStatus:%s, newState:%s", new Object[] { str1, str3, str2 });
      this.jJH.jJp = paramBluetoothGatt;
      if (paramInt2 != 2) {
        break label159;
      }
      if (paramBluetoothGatt != null) {
        break label104;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.ConnectAction", "[onConnectionStateChange] gatt is null", new Object[0]);
      AppMethodBeat.o(144573);
      return;
      str1 = "";
      break;
    }
    label104:
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "[onConnectionStateChange] discoverServicesDelayMills: " + this.jJv, new Object[0]);
    this.azU.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(183546);
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "Attempting to start service discovery", new Object[0]);
        paramBluetoothGatt.discoverServices();
        AppMethodBeat.o(183546);
      }
    }, this.jJv);
    AppMethodBeat.o(144573);
    return;
    label159:
    if (paramInt2 == 0) {
      this.azU.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(183547);
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "close", new Object[0]);
          b.this.jJH.fS(false);
          b localb = b.this;
          int i = paramInt1;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("fail:connection fail");
          localStringBuilder.append(" ");
          localStringBuilder.append("status:");
          localStringBuilder.append(i);
          localb.a(new j(10003, localStringBuilder.toString()));
          b.this.done();
          AppMethodBeat.o(183547);
        }
      });
    }
    AppMethodBeat.o(144573);
  }
  
  public final void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    AppMethodBeat.i(144574);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "[onServicesDiscovered] status:%s", new Object[] { f.rB(paramInt) });
    this.jJH.jJp = paramBluetoothGatt;
    if (paramInt == 0) {
      a(j.jJZ);
    }
    for (;;)
    {
      done();
      AppMethodBeat.o(144574);
      return;
      a(j.jKr);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144575);
    String str = "ConnectAction#" + this.jJO + "{deviceId='" + this.cLR + '\'' + ", debug=" + this.aMt + ", mainThread=" + this.jIS + ", serial=" + this.jIU + '}';
    AppMethodBeat.o(144575);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.b
 * JD-Core Version:    0.7.0.1
 */