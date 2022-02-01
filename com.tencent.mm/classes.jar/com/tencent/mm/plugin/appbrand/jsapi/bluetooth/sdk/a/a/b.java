package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.k;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  public String hEl;
  public boolean rMM;
  public String rMN = "LE";
  public long rMO = 0L;
  public String rMP = null;
  public boolean rMQ = true;
  
  public b(String paramString)
  {
    this.hEl = paramString;
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(144572);
    switch (paramk.errCode)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(144572);
      return;
      this.rNd.jh(false);
    }
  }
  
  public final void crh()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    AppMethodBeat.i(144571);
    Object localObject = c.crs();
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.ConnectAction", "action:%s, bluetoothAdapter is null", new Object[] { this });
      onResult(k.rND);
      done();
      AppMethodBeat.o(144571);
      return;
    }
    if ((this.hEl == null) || (!BluetoothAdapter.checkBluetoothAddress(this.hEl)))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.ConnectAction", "action:%s, unspecified deviceId", new Object[] { this });
      onResult(k.rNP);
      done();
      AppMethodBeat.o(144571);
      return;
    }
    if (!c.cru())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.ConnectAction", "bluetooth is not enable.", new Object[0]);
      onResult(k.rND);
      done();
      AppMethodBeat.o(144571);
      return;
    }
    if (this.rNd.rMH != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.ConnectAction", "already connect, please close", new Object[0]);
      onResult(k.rNO);
      done();
      AppMethodBeat.o(144571);
      return;
    }
    localObject = ((BluetoothAdapter)localObject).getRemoteDevice(this.hEl);
    if (localObject != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "autoConnect:%b transport:%s", new Object[] { Boolean.valueOf(this.rMM), this.rMN });
      String str;
      int i;
      if (Build.VERSION.SDK_INT >= 23)
      {
        str = this.rMN.toUpperCase();
        i = -1;
        switch (str.hashCode())
        {
        default: 
          switch (i)
          {
          default: 
            localObject = ((BluetoothDevice)localObject).connectGatt(this.rNd.context, this.rMM, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(this.rNd), 2);
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
        str = this.hEl;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
          bool1 = true;
        }
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "create a new connection deviceId=%s mainthread:%b", new Object[] { str, Boolean.valueOf(bool1) });
        this.rNd.rMH = ((BluetoothGatt)localObject);
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
        localObject = ((BluetoothDevice)localObject).connectGatt(this.rNd.context, this.rMM, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(this.rNd), 2);
        continue;
        localObject = ((BluetoothDevice)localObject).connectGatt(this.rNd.context, this.rMM, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(this.rNd), 0);
        continue;
        localObject = ((BluetoothDevice)localObject).connectGatt(this.rNd.context, this.rMM, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(this.rNd), 1);
        continue;
        localObject = ((BluetoothDevice)localObject).connectGatt(this.rNd.context, this.rMM, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(this.rNd));
      }
      label589:
      localObject = this.hEl;
      bool1 = bool2;
      if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        bool1 = true;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.ConnectAction", "Get Gatt fail!, deviceId=%s mainthread:%b", new Object[] { localObject, Boolean.valueOf(bool1) });
    }
    for (;;)
    {
      onResult(k.rNB);
      done();
      AppMethodBeat.o(144571);
      return;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.ConnectAction", "Device not found, deviceId=%s", new Object[] { this.hEl });
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
      str3 = f.Ay(paramInt1);
      if (paramInt2 != 2) {
        break label98;
      }
    }
    label98:
    for (String str2 = "CONNECTED";; str2 = "DISCONNECTED")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "[onConnectionStateChange]gatt:%s gattStatus:%s, newState:%s", new Object[] { str1, str3, str2 });
      this.rNd.rMH = paramBluetoothGatt;
      if (paramInt2 != 2) {
        break label163;
      }
      if (paramBluetoothGatt != null) {
        break label106;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.ConnectAction", "[onConnectionStateChange] gatt is null", new Object[0]);
      AppMethodBeat.o(144573);
      return;
      str1 = "";
      break;
    }
    label106:
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "[onConnectionStateChange] discoverServicesDelayMills: " + this.rMO, new Object[0]);
    this.mainHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(183546);
        Object localObject = b.this;
        int i;
        if (((b)localObject).rMP != null)
        {
          localObject = ((b)localObject).rMP;
          i = -1;
        }
        switch (((String)localObject).hashCode())
        {
        default: 
          switch (i)
          {
          default: 
            localObject = null;
          }
          break;
        }
        for (;;)
        {
          if (localObject != null)
          {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "Attempting to requestConnectionPriority, ".concat(String.valueOf(localObject)), new Object[0]);
            if (!paramBluetoothGatt.requestConnectionPriority(((Integer)localObject).intValue())) {
              com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.ConnectAction", "requestConnectionPriority fail", new Object[0]);
            }
          }
          if (!b.this.rMQ) {
            break label242;
          }
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "Attempting to start service discovery", new Object[0]);
          paramBluetoothGatt.discoverServices();
          AppMethodBeat.o(183546);
          return;
          if (!((String)localObject).equals("balanced")) {
            break;
          }
          i = 0;
          break;
          if (!((String)localObject).equals("high")) {
            break;
          }
          i = 1;
          break;
          if (!((String)localObject).equals("lowPower")) {
            break;
          }
          i = 2;
          break;
          localObject = Integer.valueOf(0);
          continue;
          localObject = Integer.valueOf(1);
          continue;
          localObject = Integer.valueOf(2);
        }
        label242:
        if (paramInt1 == 0) {
          b.this.onResult(k.rNz);
        }
        for (;;)
        {
          b.this.done();
          b.this.rNd.a(paramBluetoothGatt, paramInt1);
          AppMethodBeat.o(183546);
          return;
          b.this.onResult(b.Ax(paramInt1));
        }
      }
    }, this.rMO);
    AppMethodBeat.o(144573);
    return;
    label163:
    if (paramInt2 == 0) {
      this.mainHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(183547);
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "close", new Object[0]);
          b.this.rNd.jh(false);
          b.this.onResult(b.Ax(paramInt1));
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
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "[onServicesDiscovered] status:%s", new Object[] { f.Ay(paramInt) });
    this.rNd.rMH = paramBluetoothGatt;
    if (paramInt == 0) {
      onResult(k.rNz);
    }
    for (;;)
    {
      done();
      this.rNd.a(paramBluetoothGatt, paramInt);
      AppMethodBeat.o(144574);
      return;
      onResult(k.rNQ);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144575);
    String str = "ConnectAction#" + this.rNk + "{deviceId='" + this.hEl + '\'' + ", debug=" + this.debug + ", mainThread=" + this.rMf + ", serial=" + this.rMh + '}';
    AppMethodBeat.o(144575);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.b
 * JD-Core Version:    0.7.0.1
 */