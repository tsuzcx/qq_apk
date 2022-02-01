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
import d.g.b.p;
import d.l;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Action;", "deviceId", "", "pin", "", "timeoutMs", "", "forcePair", "", "(Ljava/lang/String;[BJZ)V", "myTag", "pairReceiver", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction$PairReceiver;", "doActionImpl", "", "getName", "onDone", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Result;", "PairReceiver", "luggage-commons-jsapi-connectivity-ext_release"})
public final class f
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  private final String cVh;
  final String kIm;
  private a kIo;
  final byte[] kIp;
  private final boolean kIq;
  
  public f(String paramString, byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(208377);
    this.cVh = paramString;
    this.kIp = paramArrayOfByte;
    this.kIq = paramBoolean;
    this.kIm = ("MicroMsg.AppBrand.PairAction#" + hashCode());
    this.kIA = paramLong;
    AppMethodBeat.o(208377);
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(208376);
    super.b(paramj);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.kIm, "onDone, result: ".concat(String.valueOf(paramj)), new Object[0]);
    paramj = this.kIo;
    if (paramj != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(paramj.kIr.kIm, "pairReceiver.unregisterSelf", new Object[0]);
      paramj.context.unregisterReceiver((BroadcastReceiver)paramj);
    }
    this.kIo = null;
    AppMethodBeat.o(208376);
  }
  
  public final void bjZ()
  {
    AppMethodBeat.i(208375);
    if (!c.bki())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.kIm, "Bluetooth is not enable.", new Object[0]);
      a(j.kIS);
      done();
      AppMethodBeat.o(208375);
      return;
    }
    if (!BluetoothAdapter.checkBluetoothAddress(this.cVh))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.kIm, "Invalid deviceId", new Object[0]);
      a(j.kJg);
      done();
      AppMethodBeat.o(208375);
      return;
    }
    Object localObject2 = c.bkg();
    if (localObject2 == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.kIm, "Bluetooth is not enable.", new Object[0]);
      a(j.kIS);
      done();
      AppMethodBeat.o(208375);
      return;
    }
    Object localObject1 = ((BluetoothAdapter)localObject2).getRemoteDevice(this.cVh);
    if (!this.kIq)
    {
      localObject2 = ((BluetoothAdapter)localObject2).getBondedDevices();
      if ((localObject2 != null) && (true == ((Set)localObject2).contains(localObject1)))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.kIm, "already paired", new Object[0]);
        a(j.kIP);
        done();
        AppMethodBeat.o(208375);
        return;
      }
    }
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.kIm, "createBond", new Object[0]);
    if (!((BluetoothDevice)localObject1).createBond())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.kIm, "startPairing is false", new Object[0]);
      a(j.kIZ);
      done();
      AppMethodBeat.o(208375);
      return;
    }
    localObject2 = this.kIw;
    p.g(localObject2, "worker");
    localObject2 = ((d)localObject2).getContext();
    if (localObject2 == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.kIm, "context is null", new Object[0]);
      a(j.kIZ);
      done();
      AppMethodBeat.o(208375);
      return;
    }
    p.g(localObject1, "device");
    this.kIo = new a((Context)localObject2, (BluetoothDevice)localObject1);
    localObject2 = this.kIo;
    if (localObject2 != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(((a)localObject2).kIr.kIm, "pairReceiver.registerSelf", new Object[0]);
      localObject1 = ((a)localObject2).context;
      localObject2 = (BroadcastReceiver)localObject2;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.bluetooth.device.action.PAIRING_REQUEST");
      localIntentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
      ((Context)localObject1).registerReceiver((BroadcastReceiver)localObject2, localIntentFilter);
      AppMethodBeat.o(208375);
      return;
    }
    AppMethodBeat.o(208375);
  }
  
  public final String getName()
  {
    return "PairAction";
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction$PairReceiver;", "Landroid/content/BroadcastReceiver;", "context", "Landroid/content/Context;", "device", "Landroid/bluetooth/BluetoothDevice;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction;Landroid/content/Context;Landroid/bluetooth/BluetoothDevice;)V", "onReceive", "", "intent", "Landroid/content/Intent;", "registerSelf", "unregisterSelf", "luggage-commons-jsapi-connectivity-ext_release"})
  final class a
    extends BroadcastReceiver
  {
    final Context context;
    private final BluetoothDevice kHc;
    
    public a(BluetoothDevice paramBluetoothDevice)
    {
      AppMethodBeat.i(208374);
      this.context = paramBluetoothDevice;
      this.kHc = localObject;
      AppMethodBeat.o(208374);
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(208373);
      BluetoothDevice localBluetoothDevice = this.kHc;
      if (paramIntent != null) {}
      for (paramContext = paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE"); (p.i(localBluetoothDevice, paramContext) ^ true); paramContext = null)
      {
        AppMethodBeat.o(208373);
        return;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.kIm, "onReceive, intent: ".concat(String.valueOf(paramIntent)), new Object[0]);
      if (p.i("android.bluetooth.device.action.PAIRING_REQUEST", paramIntent.getAction()))
      {
        if (!paramIntent.hasExtra("android.bluetooth.device.extra.PAIRING_VARIANT"))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(f.this.kIm, "Cannot find EXTRA_PAIRING_VARIANT", new Object[0]);
          AppMethodBeat.o(208373);
          return;
        }
        switch (paramIntent.getIntExtra("android.bluetooth.device.extra.PAIRING_VARIANT", -1))
        {
        case 1: 
        default: 
          AppMethodBeat.o(208373);
          return;
        case 0: 
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.kIm, "PAIRING_VARIANT_PIN", new Object[0]);
          if (f.this.kIp == null)
          {
            f.this.a(j.kJi);
            f.this.done();
            AppMethodBeat.o(208373);
            return;
          }
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.kIm, "setPin", new Object[0]);
          this.kHc.setPin(f.this.kIp);
          AppMethodBeat.o(208373);
          return;
        }
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.kIm, "PAIRING_VARIANT_PASSKEY_CONFIRMATION", new Object[0]);
        AppMethodBeat.o(208373);
        return;
      }
      if (p.i("android.bluetooth.device.action.BOND_STATE_CHANGED", paramIntent.getAction()))
      {
        if (!paramIntent.hasExtra("android.bluetooth.device.extra.BOND_STATE"))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(f.this.kIm, "Cannot find EXTRA_BOND_STATE", new Object[0]);
          AppMethodBeat.o(208373);
          return;
        }
        switch (paramIntent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1))
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(208373);
        return;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.kIm, "BOND_NONE, reason: " + paramIntent.getIntExtra("android.bluetooth.device.extra.REASON", -1), new Object[0]);
        f.this.a(j.kIQ);
        f.this.done();
        AppMethodBeat.o(208373);
        return;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.kIm, "BOND_BONDING", new Object[0]);
        AppMethodBeat.o(208373);
        return;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.kIm, "BOND_BONDED", new Object[0]);
        f.this.a(j.kIP);
        f.this.done();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.f
 * JD-Core Version:    0.7.0.1
 */