package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Action;", "deviceId", "", "pin", "", "timeoutMs", "", "forcePair", "", "useOldImpl", "(Ljava/lang/String;[BJZZ)V", "myTag", "pairReceiver", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction$PairReceiver;", "doActionImpl", "", "getName", "onDone", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Result;", "PairReceiver", "luggage-commons-jsapi-connectivity-ext_release"})
public final class f
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  private final String dGL;
  final String lMQ;
  private a lMS;
  final byte[] lMT;
  private final boolean lMU;
  final boolean lMV;
  
  public f(String paramString, byte[] paramArrayOfByte, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(215132);
    this.dGL = paramString;
    this.lMT = paramArrayOfByte;
    this.lMU = paramBoolean1;
    this.lMV = paramBoolean2;
    this.lMQ = ("MicroMsg.AppBrand.PairAction#" + hashCode());
    this.lNf = paramLong;
    AppMethodBeat.o(215132);
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(215131);
    super.b(paramj);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.lMQ, "onDone, result: ".concat(String.valueOf(paramj)), new Object[0]);
    paramj = this.lMS;
    if (paramj != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(paramj.lMW.lMQ, "pairReceiver.unregisterSelf", new Object[0]);
      paramj.context.unregisterReceiver((BroadcastReceiver)paramj);
    }
    this.lMS = null;
    AppMethodBeat.o(215131);
  }
  
  public final void bFt()
  {
    AppMethodBeat.i(215130);
    if (!c.bFE())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.lMQ, "Bluetooth is not enable.", new Object[0]);
      a(j.lNx);
      done();
      AppMethodBeat.o(215130);
      return;
    }
    if (!BluetoothAdapter.checkBluetoothAddress(this.dGL))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.lMQ, "Invalid deviceId", new Object[0]);
      a(j.lNL);
      done();
      AppMethodBeat.o(215130);
      return;
    }
    Object localObject2 = c.bFC();
    if (localObject2 == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.lMQ, "Bluetooth is not enable.", new Object[0]);
      a(j.lNx);
      done();
      AppMethodBeat.o(215130);
      return;
    }
    Object localObject1 = ((BluetoothAdapter)localObject2).getRemoteDevice(this.dGL);
    if (!this.lMU)
    {
      localObject2 = ((BluetoothAdapter)localObject2).getBondedDevices();
      if ((localObject2 != null) && (true == ((Set)localObject2).contains(localObject1)))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.lMQ, "already paired", new Object[0]);
        a(j.lNu);
        done();
        AppMethodBeat.o(215130);
        return;
      }
    }
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.lMQ, "createBond", new Object[0]);
    if (!((BluetoothDevice)localObject1).createBond())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.lMQ, "startPairing is false", new Object[0]);
      a(j.lNE);
      done();
      AppMethodBeat.o(215130);
      return;
    }
    localObject2 = this.lNb;
    p.g(localObject2, "worker");
    localObject2 = ((d)localObject2).getContext();
    if (localObject2 == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.lMQ, "context is null", new Object[0]);
      a(j.lNE);
      done();
      AppMethodBeat.o(215130);
      return;
    }
    p.g(localObject1, "device");
    this.lMS = new a((Context)localObject2, (BluetoothDevice)localObject1);
    localObject2 = this.lMS;
    if (localObject2 != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(((a)localObject2).lMW.lMQ, "pairReceiver.registerSelf", new Object[0]);
      localObject1 = ((a)localObject2).context;
      localObject2 = (BroadcastReceiver)localObject2;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.bluetooth.device.action.PAIRING_REQUEST");
      localIntentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
      ((Context)localObject1).registerReceiver((BroadcastReceiver)localObject2, localIntentFilter);
      AppMethodBeat.o(215130);
      return;
    }
    AppMethodBeat.o(215130);
  }
  
  public final String getName()
  {
    return "PairAction";
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction$PairReceiver;", "Landroid/content/BroadcastReceiver;", "context", "Landroid/content/Context;", "device", "Landroid/bluetooth/BluetoothDevice;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction;Landroid/content/Context;Landroid/bluetooth/BluetoothDevice;)V", "onReceive", "", "intent", "Landroid/content/Intent;", "registerSelf", "unregisterSelf", "luggage-commons-jsapi-connectivity-ext_release"})
  final class a
    extends BroadcastReceiver
  {
    final Context context;
    private final BluetoothDevice lLD;
    
    public a(BluetoothDevice paramBluetoothDevice)
    {
      AppMethodBeat.i(215129);
      this.context = paramBluetoothDevice;
      this.lLD = localObject;
      AppMethodBeat.o(215129);
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(215128);
      BluetoothDevice localBluetoothDevice = this.lLD;
      if (paramIntent != null) {}
      for (paramContext = paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE"); (p.j(localBluetoothDevice, paramContext) ^ true); paramContext = null)
      {
        AppMethodBeat.o(215128);
        return;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.lMQ, "onReceive, intent: ".concat(String.valueOf(paramIntent)), new Object[0]);
      if (p.j("android.bluetooth.device.action.PAIRING_REQUEST", paramIntent.getAction()))
      {
        if (!paramIntent.hasExtra("android.bluetooth.device.extra.PAIRING_VARIANT"))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(f.this.lMQ, "Cannot find EXTRA_PAIRING_VARIANT", new Object[0]);
          AppMethodBeat.o(215128);
          return;
        }
        switch (paramIntent.getIntExtra("android.bluetooth.device.extra.PAIRING_VARIANT", -1))
        {
        case 1: 
        default: 
          AppMethodBeat.o(215128);
          return;
        case 0: 
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.lMQ, "PAIRING_VARIANT_PIN", new Object[0]);
          if (f.this.lMT == null)
          {
            f.this.a(j.lNN);
            f.this.done();
            AppMethodBeat.o(215128);
            return;
          }
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.lMQ, "setPin", new Object[0]);
          if ((!this.lLD.setPin(f.this.lMT)) || (f.this.lMV)) {
            break;
          }
          f.this.a(j.lNu);
          f.this.done();
          AppMethodBeat.o(215128);
          return;
        case 2: 
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.lMQ, "PAIRING_VARIANT_PASSKEY_CONFIRMATION", new Object[0]);
          AppMethodBeat.o(215128);
          return;
        }
      }
      else if (p.j("android.bluetooth.device.action.BOND_STATE_CHANGED", paramIntent.getAction()))
      {
        if (!paramIntent.hasExtra("android.bluetooth.device.extra.BOND_STATE"))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(f.this.lMQ, "Cannot find EXTRA_BOND_STATE", new Object[0]);
          AppMethodBeat.o(215128);
          return;
        }
        switch (paramIntent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1))
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(215128);
        return;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.lMQ, "BOND_NONE, reason: " + paramIntent.getIntExtra("android.bluetooth.device.extra.REASON", -1), new Object[0]);
        f.this.a(j.lNv);
        f.this.done();
        AppMethodBeat.o(215128);
        return;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.lMQ, "BOND_BONDING", new Object[0]);
        AppMethodBeat.o(215128);
        return;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.lMQ, "BOND_BONDED", new Object[0]);
        f.this.a(j.lNu);
        f.this.done();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.f
 * JD-Core Version:    0.7.0.1
 */